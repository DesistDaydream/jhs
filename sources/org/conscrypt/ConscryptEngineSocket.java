package org.conscrypt;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.nio.ByteBuffer;
import java.security.PrivateKey;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLEngineResult;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSession;
import javax.net.ssl.X509ExtendedTrustManager;
import javax.net.ssl.X509TrustManager;

/* loaded from: classes4.dex */
public class ConscryptEngineSocket extends OpenSSLSocketImpl {
    private static final ByteBuffer EMPTY_BUFFER = ByteBuffer.allocate(0);
    private BufferAllocator bufferAllocator;
    private final ConscryptEngine engine;
    private final Object handshakeLock;
    private SSLInputStream in;
    private SSLOutputStream out;
    private int state;
    private final Object stateLock;

    /* renamed from: org.conscrypt.ConscryptEngineSocket$3  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class AnonymousClass3 {
        public static final /* synthetic */ int[] $SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus;
        public static final /* synthetic */ int[] $SwitchMap$javax$net$ssl$SSLEngineResult$Status;

        static {
            int[] iArr = new int[SSLEngineResult.Status.values().length];
            $SwitchMap$javax$net$ssl$SSLEngineResult$Status = iArr;
            try {
                iArr[SSLEngineResult.Status.BUFFER_UNDERFLOW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$javax$net$ssl$SSLEngineResult$Status[SSLEngineResult.Status.OK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$javax$net$ssl$SSLEngineResult$Status[SSLEngineResult.Status.CLOSED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[SSLEngineResult.HandshakeStatus.values().length];
            $SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus = iArr2;
            try {
                iArr2[SSLEngineResult.HandshakeStatus.NEED_UNWRAP.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus[SSLEngineResult.HandshakeStatus.NEED_WRAP.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus[SSLEngineResult.HandshakeStatus.NEED_TASK.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus[SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus[SSLEngineResult.HandshakeStatus.FINISHED.ordinal()] = 5;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    public ConscryptEngineSocket(SSLParametersImpl sSLParametersImpl) throws IOException {
        this.stateLock = new Object();
        this.handshakeLock = new Object();
        this.bufferAllocator = ConscryptEngine.getDefaultBufferAllocator();
        this.state = 0;
        this.engine = newEngine(sSLParametersImpl, this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doHandshake() throws IOException {
        boolean z = false;
        while (!z) {
            try {
                int i2 = AnonymousClass3.$SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus[this.engine.getHandshakeStatus().ordinal()];
                if (i2 != 1) {
                    if (i2 == 2) {
                        this.out.writeInternal(EMPTY_BUFFER);
                        this.out.flushInternal();
                    } else if (i2 == 3) {
                        throw new IllegalStateException("Engine tasks are unsupported");
                    } else {
                        if (i2 != 4 && i2 != 5) {
                            throw new IllegalStateException("Unknown handshake status: " + this.engine.getHandshakeStatus());
                        }
                        z = true;
                    }
                } else if (this.in.processDataFromSocket(EmptyArray.BYTE, 0, 0) < 0) {
                    throw SSLUtils.toSSLHandshakeException(new EOFException());
                }
            } catch (SSLException e2) {
                drainOutgoingQueue();
                close();
                throw e2;
            } catch (IOException e3) {
                close();
                throw e3;
            } catch (Exception e4) {
                close();
                throw SSLUtils.toSSLHandshakeException(e4);
            }
        }
    }

    private void drainOutgoingQueue() {
        while (this.engine.pendingOutboundEncryptedBytes() > 0) {
            try {
                this.out.writeInternal(EMPTY_BUFFER);
                this.out.flushInternal();
            } catch (IOException unused) {
                return;
            }
        }
    }

    private static X509TrustManager getDelegatingTrustManager(X509TrustManager x509TrustManager, final ConscryptEngineSocket conscryptEngineSocket) {
        if (x509TrustManager instanceof X509ExtendedTrustManager) {
            final X509ExtendedTrustManager x509ExtendedTrustManager = (X509ExtendedTrustManager) x509TrustManager;
            return new X509ExtendedTrustManager() { // from class: org.conscrypt.ConscryptEngineSocket.2
                @Override // javax.net.ssl.X509ExtendedTrustManager
                public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str, Socket socket) throws CertificateException {
                    throw new AssertionError("Should not be called");
                }

                @Override // javax.net.ssl.X509ExtendedTrustManager
                public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str, Socket socket) throws CertificateException {
                    throw new AssertionError("Should not be called");
                }

                @Override // javax.net.ssl.X509TrustManager
                public X509Certificate[] getAcceptedIssuers() {
                    return x509ExtendedTrustManager.getAcceptedIssuers();
                }

                @Override // javax.net.ssl.X509ExtendedTrustManager
                public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str, SSLEngine sSLEngine) throws CertificateException {
                    x509ExtendedTrustManager.checkClientTrusted(x509CertificateArr, str, conscryptEngineSocket);
                }

                @Override // javax.net.ssl.X509ExtendedTrustManager
                public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str, SSLEngine sSLEngine) throws CertificateException {
                    x509ExtendedTrustManager.checkServerTrusted(x509CertificateArr, str, conscryptEngineSocket);
                }

                @Override // javax.net.ssl.X509TrustManager
                public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
                    x509ExtendedTrustManager.checkClientTrusted(x509CertificateArr, str);
                }

                @Override // javax.net.ssl.X509TrustManager
                public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
                    x509ExtendedTrustManager.checkServerTrusted(x509CertificateArr, str);
                }
            };
        }
        return x509TrustManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public InputStream getUnderlyingInputStream() throws IOException {
        return super.getInputStream();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public OutputStream getUnderlyingOutputStream() throws IOException {
        return super.getOutputStream();
    }

    private static ConscryptEngine newEngine(SSLParametersImpl sSLParametersImpl, ConscryptEngineSocket conscryptEngineSocket) {
        ConscryptEngine conscryptEngine = new ConscryptEngine(Platform.supportsX509ExtendedTrustManager() ? sSLParametersImpl.cloneWithTrustManager(getDelegatingTrustManager(sSLParametersImpl.getX509TrustManager(), conscryptEngineSocket)) : sSLParametersImpl, conscryptEngineSocket.peerInfoProvider());
        conscryptEngine.setHandshakeListener(new HandshakeListener() { // from class: org.conscrypt.ConscryptEngineSocket.1
            @Override // org.conscrypt.HandshakeListener
            public void onHandshakeFinished() {
                ConscryptEngineSocket.this.onHandshakeFinished();
            }
        });
        conscryptEngine.setUseClientMode(sSLParametersImpl.getUseClientMode());
        return conscryptEngine;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onHandshakeFinished() {
        boolean z;
        synchronized (this.stateLock) {
            int i2 = this.state;
            if (i2 != 8) {
                if (i2 == 2) {
                    this.state = 4;
                } else if (i2 == 3) {
                    this.state = 5;
                }
                this.stateLock.notifyAll();
                z = true;
            } else {
                z = false;
            }
        }
        if (z) {
            notifyHandshakeCompletedListeners();
        }
    }

    private void waitForHandshake() throws IOException {
        startHandshake();
        synchronized (this.stateLock) {
            while (true) {
                int i2 = this.state;
                if (i2 == 5 || i2 == 4 || i2 == 8) {
                    break;
                }
                try {
                    this.stateLock.wait();
                } catch (InterruptedException e2) {
                    Thread.currentThread().interrupt();
                    throw new IOException("Interrupted waiting for handshake", e2);
                }
            }
            throw new SocketException("Socket is closed");
        }
    }

    @Override // org.conscrypt.OpenSSLSocketImpl, org.conscrypt.AbstractConscryptSocket, java.net.Socket, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        Object obj = this.stateLock;
        if (obj == null) {
            return;
        }
        synchronized (obj) {
            if (this.state == 8) {
                return;
            }
            this.state = 8;
            this.stateLock.notifyAll();
            try {
                super.close();
                this.engine.closeInbound();
                this.engine.closeOutbound();
                SSLInputStream sSLInputStream = this.in;
                if (sSLInputStream != null) {
                    sSLInputStream.release();
                }
            } catch (Throwable th) {
                this.engine.closeInbound();
                this.engine.closeOutbound();
                if (this.in != null) {
                    this.in.release();
                }
                throw th;
            }
        }
    }

    @Override // org.conscrypt.AbstractConscryptSocket
    public byte[] exportKeyingMaterial(String str, byte[] bArr, int i2) throws SSLException {
        return this.engine.exportKeyingMaterial(str, bArr, i2);
    }

    @Override // org.conscrypt.AbstractConscryptSocket
    public final SSLSession getActiveSession() {
        return this.engine.getSession();
    }

    @Override // org.conscrypt.AbstractConscryptSocket, javax.net.ssl.SSLSocket
    public final String getApplicationProtocol() {
        return this.engine.getApplicationProtocol();
    }

    @Override // org.conscrypt.AbstractConscryptSocket
    public final String[] getApplicationProtocols() {
        return this.engine.getApplicationProtocols();
    }

    @Override // org.conscrypt.OpenSSLSocketImpl, org.conscrypt.AbstractConscryptSocket
    public final byte[] getChannelId() throws SSLException {
        return this.engine.getChannelId();
    }

    @Override // javax.net.ssl.SSLSocket
    public final boolean getEnableSessionCreation() {
        return this.engine.getEnableSessionCreation();
    }

    @Override // javax.net.ssl.SSLSocket
    public final String[] getEnabledCipherSuites() {
        return this.engine.getEnabledCipherSuites();
    }

    @Override // javax.net.ssl.SSLSocket
    public final String[] getEnabledProtocols() {
        return this.engine.getEnabledProtocols();
    }

    @Override // org.conscrypt.AbstractConscryptSocket, javax.net.ssl.SSLSocket
    public final String getHandshakeApplicationProtocol() {
        return this.engine.getHandshakeApplicationProtocol();
    }

    @Override // org.conscrypt.OpenSSLSocketImpl, org.conscrypt.AbstractConscryptSocket, javax.net.ssl.SSLSocket
    public final SSLSession getHandshakeSession() {
        return this.engine.handshakeSession();
    }

    @Override // org.conscrypt.OpenSSLSocketImpl, org.conscrypt.AbstractConscryptSocket, java.net.Socket
    public final InputStream getInputStream() throws IOException {
        checkOpen();
        waitForHandshake();
        return this.in;
    }

    @Override // javax.net.ssl.SSLSocket
    public final boolean getNeedClientAuth() {
        return this.engine.getNeedClientAuth();
    }

    @Override // org.conscrypt.OpenSSLSocketImpl, org.conscrypt.AbstractConscryptSocket, java.net.Socket
    public final OutputStream getOutputStream() throws IOException {
        checkOpen();
        waitForHandshake();
        return this.out;
    }

    @Override // javax.net.ssl.SSLSocket
    public final SSLParameters getSSLParameters() {
        return this.engine.getSSLParameters();
    }

    @Override // javax.net.ssl.SSLSocket
    public final SSLSession getSession() {
        if (isConnected()) {
            try {
                waitForHandshake();
            } catch (IOException unused) {
            }
        }
        return this.engine.getSession();
    }

    @Override // javax.net.ssl.SSLSocket
    public final String[] getSupportedCipherSuites() {
        return this.engine.getSupportedCipherSuites();
    }

    @Override // javax.net.ssl.SSLSocket
    public final String[] getSupportedProtocols() {
        return this.engine.getSupportedProtocols();
    }

    @Override // org.conscrypt.AbstractConscryptSocket
    public byte[] getTlsUnique() {
        return this.engine.getTlsUnique();
    }

    @Override // javax.net.ssl.SSLSocket
    public final boolean getUseClientMode() {
        return this.engine.getUseClientMode();
    }

    @Override // javax.net.ssl.SSLSocket
    public final boolean getWantClientAuth() {
        return this.engine.getWantClientAuth();
    }

    @Override // org.conscrypt.AbstractConscryptSocket
    public final void setApplicationProtocolSelector(ApplicationProtocolSelector applicationProtocolSelector) {
        setApplicationProtocolSelector(applicationProtocolSelector == null ? null : new ApplicationProtocolSelectorAdapter(this, applicationProtocolSelector));
    }

    @Override // org.conscrypt.AbstractConscryptSocket
    public final void setApplicationProtocols(String[] strArr) {
        this.engine.setApplicationProtocols(strArr);
    }

    public void setBufferAllocator(BufferAllocator bufferAllocator) {
        this.engine.setBufferAllocator(bufferAllocator);
        this.bufferAllocator = bufferAllocator;
    }

    @Override // org.conscrypt.OpenSSLSocketImpl, org.conscrypt.AbstractConscryptSocket
    public final void setChannelIdEnabled(boolean z) {
        this.engine.setChannelIdEnabled(z);
    }

    @Override // org.conscrypt.OpenSSLSocketImpl, org.conscrypt.AbstractConscryptSocket
    public final void setChannelIdPrivateKey(PrivateKey privateKey) {
        this.engine.setChannelIdPrivateKey(privateKey);
    }

    @Override // javax.net.ssl.SSLSocket
    public final void setEnableSessionCreation(boolean z) {
        this.engine.setEnableSessionCreation(z);
    }

    @Override // javax.net.ssl.SSLSocket
    public final void setEnabledCipherSuites(String[] strArr) {
        this.engine.setEnabledCipherSuites(strArr);
    }

    @Override // javax.net.ssl.SSLSocket
    public final void setEnabledProtocols(String[] strArr) {
        this.engine.setEnabledProtocols(strArr);
    }

    @Override // org.conscrypt.OpenSSLSocketImpl, org.conscrypt.AbstractConscryptSocket
    public final void setHostname(String str) {
        this.engine.setHostname(str);
        super.setHostname(str);
    }

    @Override // javax.net.ssl.SSLSocket
    public final void setNeedClientAuth(boolean z) {
        this.engine.setNeedClientAuth(z);
    }

    @Override // javax.net.ssl.SSLSocket
    public final void setSSLParameters(SSLParameters sSLParameters) {
        this.engine.setSSLParameters(sSLParameters);
    }

    @Override // javax.net.ssl.SSLSocket
    public final void setUseClientMode(boolean z) {
        this.engine.setUseClientMode(z);
    }

    @Override // org.conscrypt.OpenSSLSocketImpl, org.conscrypt.AbstractConscryptSocket
    public final void setUseSessionTickets(boolean z) {
        this.engine.setUseSessionTickets(z);
    }

    @Override // javax.net.ssl.SSLSocket
    public final void setWantClientAuth(boolean z) {
        this.engine.setWantClientAuth(z);
    }

    @Override // javax.net.ssl.SSLSocket
    public final void startHandshake() throws IOException {
        checkOpen();
        try {
            synchronized (this.handshakeLock) {
                synchronized (this.stateLock) {
                    if (this.state == 0) {
                        this.state = 2;
                        this.engine.beginHandshake();
                        this.in = new SSLInputStream();
                        this.out = new SSLOutputStream();
                        doHandshake();
                    }
                }
            }
        } catch (SSLException e2) {
            close();
            throw e2;
        } catch (IOException e3) {
            close();
            throw e3;
        } catch (Exception e4) {
            close();
            throw SSLUtils.toSSLHandshakeException(e4);
        }
    }

    @Override // org.conscrypt.AbstractConscryptSocket
    public final void setApplicationProtocolSelector(ApplicationProtocolSelectorAdapter applicationProtocolSelectorAdapter) {
        this.engine.setApplicationProtocolSelector(applicationProtocolSelectorAdapter);
    }

    /* loaded from: classes4.dex */
    public final class SSLOutputStream extends OutputStream {
        private OutputStream socketOutputStream;
        private final ByteBuffer target;
        private final int targetArrayOffset;
        private final Object writeLock = new Object();

        public SSLOutputStream() {
            ByteBuffer allocate = ByteBuffer.allocate(ConscryptEngineSocket.this.engine.getSession().getPacketBufferSize());
            this.target = allocate;
            this.targetArrayOffset = allocate.arrayOffset();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void flushInternal() throws IOException {
            ConscryptEngineSocket.this.checkOpen();
            init();
            this.socketOutputStream.flush();
        }

        private void init() throws IOException {
            if (this.socketOutputStream == null) {
                this.socketOutputStream = ConscryptEngineSocket.this.getUnderlyingOutputStream();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void writeInternal(ByteBuffer byteBuffer) throws IOException {
            Platform.blockGuardOnNetwork();
            ConscryptEngineSocket.this.checkOpen();
            init();
            int remaining = byteBuffer.remaining();
            do {
                this.target.clear();
                SSLEngineResult wrap = ConscryptEngineSocket.this.engine.wrap(byteBuffer, this.target);
                if (wrap.getStatus() == SSLEngineResult.Status.OK) {
                    if (this.target.position() == wrap.bytesProduced()) {
                        remaining -= wrap.bytesConsumed();
                        if (remaining == byteBuffer.remaining()) {
                            this.target.flip();
                            writeToSocket();
                        } else {
                            throw new SSLException("Engine did not read the correct number of bytes");
                        }
                    } else {
                        throw new SSLException("Engine bytesProduced " + wrap.bytesProduced() + " does not match bytes written " + this.target.position());
                    }
                } else {
                    throw new SSLException("Unexpected engine result " + wrap.getStatus());
                }
            } while (remaining > 0);
        }

        private void writeToSocket() throws IOException {
            this.socketOutputStream.write(this.target.array(), this.targetArrayOffset, this.target.limit());
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            ConscryptEngineSocket.this.close();
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() throws IOException {
            ConscryptEngineSocket.this.startHandshake();
            synchronized (this.writeLock) {
                flushInternal();
            }
        }

        @Override // java.io.OutputStream
        public void write(int i2) throws IOException {
            ConscryptEngineSocket.this.startHandshake();
            synchronized (this.writeLock) {
                write(new byte[]{(byte) i2});
            }
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr) throws IOException {
            ConscryptEngineSocket.this.startHandshake();
            synchronized (this.writeLock) {
                writeInternal(ByteBuffer.wrap(bArr));
            }
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i2, int i3) throws IOException {
            ConscryptEngineSocket.this.startHandshake();
            synchronized (this.writeLock) {
                writeInternal(ByteBuffer.wrap(bArr, i2, i3));
            }
        }
    }

    /* loaded from: classes4.dex */
    public final class SSLInputStream extends InputStream {
        private final AllocatedBuffer allocatedBuffer;
        private final ByteBuffer fromEngine;
        private final ByteBuffer fromSocket;
        private final int fromSocketArrayOffset;
        private final Object readLock = new Object();
        private final byte[] singleByte = new byte[1];
        private InputStream socketInputStream;

        public SSLInputStream() {
            if (ConscryptEngineSocket.this.bufferAllocator != null) {
                AllocatedBuffer allocateDirectBuffer = ConscryptEngineSocket.this.bufferAllocator.allocateDirectBuffer(ConscryptEngineSocket.this.engine.getSession().getApplicationBufferSize());
                this.allocatedBuffer = allocateDirectBuffer;
                this.fromEngine = allocateDirectBuffer.nioBuffer();
            } else {
                this.allocatedBuffer = null;
                this.fromEngine = ByteBuffer.allocateDirect(ConscryptEngineSocket.this.engine.getSession().getApplicationBufferSize());
            }
            this.fromEngine.flip();
            ByteBuffer allocate = ByteBuffer.allocate(ConscryptEngineSocket.this.engine.getSession().getPacketBufferSize());
            this.fromSocket = allocate;
            this.fromSocketArrayOffset = allocate.arrayOffset();
        }

        private void init() throws IOException {
            if (this.socketInputStream == null) {
                this.socketInputStream = ConscryptEngineSocket.this.getUnderlyingInputStream();
            }
        }

        private boolean isHandshakeFinished() {
            boolean z;
            synchronized (ConscryptEngineSocket.this.stateLock) {
                z = ConscryptEngineSocket.this.state >= 4;
            }
            return z;
        }

        private boolean isHandshaking(SSLEngineResult.HandshakeStatus handshakeStatus) {
            int i2 = AnonymousClass3.$SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus[handshakeStatus.ordinal()];
            return i2 == 1 || i2 == 2 || i2 == 3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Code restructure failed: missing block: B:24:0x00a0, code lost:
            if (r1.bytesProduced() == 0) goto L18;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public int processDataFromSocket(byte[] r7, int r8, int r9) throws java.io.IOException {
            /*
                r6 = this;
                org.conscrypt.Platform.blockGuardOnNetwork()
                org.conscrypt.ConscryptEngineSocket r0 = org.conscrypt.ConscryptEngineSocket.this
                r0.checkOpen()
                r6.init()
            Lb:
                java.nio.ByteBuffer r0 = r6.fromEngine
                int r0 = r0.remaining()
                if (r0 <= 0) goto L23
                java.nio.ByteBuffer r0 = r6.fromEngine
                int r0 = r0.remaining()
                int r9 = java.lang.Math.min(r0, r9)
                java.nio.ByteBuffer r0 = r6.fromEngine
                r0.get(r7, r8, r9)
                return r9
            L23:
                java.nio.ByteBuffer r0 = r6.fromSocket
                r0.flip()
                java.nio.ByteBuffer r0 = r6.fromEngine
                r0.clear()
                org.conscrypt.ConscryptEngineSocket r0 = org.conscrypt.ConscryptEngineSocket.this
                org.conscrypt.ConscryptEngine r0 = org.conscrypt.ConscryptEngineSocket.access$400(r0)
                javax.net.ssl.SSLEngineResult$HandshakeStatus r0 = r0.getHandshakeStatus()
                boolean r0 = r6.isHandshaking(r0)
                org.conscrypt.ConscryptEngineSocket r1 = org.conscrypt.ConscryptEngineSocket.this
                org.conscrypt.ConscryptEngine r1 = org.conscrypt.ConscryptEngineSocket.access$400(r1)
                java.nio.ByteBuffer r2 = r6.fromSocket
                java.nio.ByteBuffer r3 = r6.fromEngine
                javax.net.ssl.SSLEngineResult r1 = r1.unwrap(r2, r3)
                java.nio.ByteBuffer r2 = r6.fromSocket
                r2.compact()
                java.nio.ByteBuffer r2 = r6.fromEngine
                r2.flip()
                int[] r2 = org.conscrypt.ConscryptEngineSocket.AnonymousClass3.$SwitchMap$javax$net$ssl$SSLEngineResult$Status
                javax.net.ssl.SSLEngineResult$Status r3 = r1.getStatus()
                int r3 = r3.ordinal()
                r2 = r2[r3]
                r3 = 1
                r4 = -1
                r5 = 0
                if (r2 == r3) goto L9c
                r3 = 2
                if (r2 == r3) goto L86
                r7 = 3
                if (r2 != r7) goto L6b
                return r4
            L6b:
                javax.net.ssl.SSLException r7 = new javax.net.ssl.SSLException
                java.lang.StringBuilder r8 = new java.lang.StringBuilder
                r8.<init>()
                java.lang.String r9 = "Unexpected engine result "
                r8.append(r9)
                javax.net.ssl.SSLEngineResult$Status r9 = r1.getStatus()
                r8.append(r9)
                java.lang.String r8 = r8.toString()
                r7.<init>(r8)
                throw r7
            L86:
                if (r0 != 0) goto La3
                javax.net.ssl.SSLEngineResult$HandshakeStatus r0 = r1.getHandshakeStatus()
                boolean r0 = r6.isHandshaking(r0)
                if (r0 == 0) goto La3
                boolean r0 = r6.isHandshakeFinished()
                if (r0 == 0) goto La3
                r6.renegotiate()
                return r5
            L9c:
                int r0 = r1.bytesProduced()
                if (r0 != 0) goto La3
                goto La4
            La3:
                r3 = 0
            La4:
                if (r3 != 0) goto Lad
                int r0 = r1.bytesProduced()
                if (r0 != 0) goto Lad
                return r5
            Lad:
                if (r3 == 0) goto Lb
                int r0 = r6.readFromSocket()
                if (r0 != r4) goto Lb
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: org.conscrypt.ConscryptEngineSocket.SSLInputStream.processDataFromSocket(byte[], int, int):int");
        }

        private int readFromSocket() throws IOException {
            try {
                int position = this.fromSocket.position();
                int read = this.socketInputStream.read(this.fromSocket.array(), this.fromSocketArrayOffset + position, this.fromSocket.limit() - position);
                if (read > 0) {
                    this.fromSocket.position(position + read);
                }
                return read;
            } catch (EOFException unused) {
                return -1;
            }
        }

        private int readUntilDataAvailable(byte[] bArr, int i2, int i3) throws IOException {
            int processDataFromSocket;
            do {
                processDataFromSocket = processDataFromSocket(bArr, i2, i3);
            } while (processDataFromSocket == 0);
            return processDataFromSocket;
        }

        private void renegotiate() throws IOException {
            synchronized (ConscryptEngineSocket.this.handshakeLock) {
                ConscryptEngineSocket.this.doHandshake();
            }
        }

        @Override // java.io.InputStream
        public int available() throws IOException {
            int remaining;
            ConscryptEngineSocket.this.startHandshake();
            synchronized (this.readLock) {
                init();
                remaining = this.fromEngine.remaining();
            }
            return remaining;
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            ConscryptEngineSocket.this.close();
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            ConscryptEngineSocket.this.startHandshake();
            synchronized (this.readLock) {
                int read = read(this.singleByte, 0, 1);
                if (read == -1) {
                    return -1;
                }
                if (read == 1) {
                    return this.singleByte[0];
                }
                throw new SSLException("read incorrect number of bytes " + read);
            }
        }

        public void release() {
            synchronized (this.readLock) {
                AllocatedBuffer allocatedBuffer = this.allocatedBuffer;
                if (allocatedBuffer != null) {
                    allocatedBuffer.release();
                }
            }
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr) throws IOException {
            int read;
            ConscryptEngineSocket.this.startHandshake();
            synchronized (this.readLock) {
                read = read(bArr, 0, bArr.length);
            }
            return read;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i2, int i3) throws IOException {
            int readUntilDataAvailable;
            ConscryptEngineSocket.this.startHandshake();
            synchronized (this.readLock) {
                readUntilDataAvailable = readUntilDataAvailable(bArr, i2, i3);
            }
            return readUntilDataAvailable;
        }
    }

    public ConscryptEngineSocket(String str, int i2, SSLParametersImpl sSLParametersImpl) throws IOException {
        super(str, i2);
        this.stateLock = new Object();
        this.handshakeLock = new Object();
        this.bufferAllocator = ConscryptEngine.getDefaultBufferAllocator();
        this.state = 0;
        this.engine = newEngine(sSLParametersImpl, this);
    }

    public ConscryptEngineSocket(InetAddress inetAddress, int i2, SSLParametersImpl sSLParametersImpl) throws IOException {
        super(inetAddress, i2);
        this.stateLock = new Object();
        this.handshakeLock = new Object();
        this.bufferAllocator = ConscryptEngine.getDefaultBufferAllocator();
        this.state = 0;
        this.engine = newEngine(sSLParametersImpl, this);
    }

    public ConscryptEngineSocket(String str, int i2, InetAddress inetAddress, int i3, SSLParametersImpl sSLParametersImpl) throws IOException {
        super(str, i2, inetAddress, i3);
        this.stateLock = new Object();
        this.handshakeLock = new Object();
        this.bufferAllocator = ConscryptEngine.getDefaultBufferAllocator();
        this.state = 0;
        this.engine = newEngine(sSLParametersImpl, this);
    }

    public ConscryptEngineSocket(InetAddress inetAddress, int i2, InetAddress inetAddress2, int i3, SSLParametersImpl sSLParametersImpl) throws IOException {
        super(inetAddress, i2, inetAddress2, i3);
        this.stateLock = new Object();
        this.handshakeLock = new Object();
        this.bufferAllocator = ConscryptEngine.getDefaultBufferAllocator();
        this.state = 0;
        this.engine = newEngine(sSLParametersImpl, this);
    }

    public ConscryptEngineSocket(Socket socket, String str, int i2, boolean z, SSLParametersImpl sSLParametersImpl) throws IOException {
        super(socket, str, i2, z);
        this.stateLock = new Object();
        this.handshakeLock = new Object();
        this.bufferAllocator = ConscryptEngine.getDefaultBufferAllocator();
        this.state = 0;
        this.engine = newEngine(sSLParametersImpl, this);
    }
}
