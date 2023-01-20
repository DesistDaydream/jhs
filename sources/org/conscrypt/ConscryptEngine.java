package org.conscrypt;

import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.nio.ByteBuffer;
import java.nio.ReadOnlyBufferException;
import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.security.interfaces.ECKey;
import java.security.spec.ECParameterSpec;
import javax.crypto.SecretKey;
import javax.net.ssl.SSLEngineResult;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSession;
import javax.net.ssl.X509ExtendedKeyManager;
import javax.net.ssl.X509KeyManager;
import javax.net.ssl.X509TrustManager;
import javax.security.auth.x500.X500Principal;
import org.conscrypt.ExternalSession;
import org.conscrypt.NativeCrypto;
import org.conscrypt.NativeRef;
import org.conscrypt.NativeSsl;
import org.conscrypt.SSLParametersImpl;

/* loaded from: classes4.dex */
public final class ConscryptEngine extends AbstractConscryptEngine implements NativeCrypto.SSLHandshakeCallbacks, SSLParametersImpl.AliasChooser, SSLParametersImpl.PSKCallbacks {
    private ActiveSession activeSession;
    private BufferAllocator bufferAllocator;
    private OpenSSLKey channelIdPrivateKey;
    private SessionSnapshot closedSession;
    private final SSLSession externalSession;
    private boolean handshakeFinished;
    private HandshakeListener handshakeListener;
    private ByteBuffer lazyDirectBuffer;
    private int maxSealOverhead;
    private final NativeSsl.BioWrapper networkBio;
    private String peerHostname;
    private final PeerInfoProvider peerInfoProvider;
    private final ByteBuffer[] singleDstBuffer;
    private final ByteBuffer[] singleSrcBuffer;
    private final NativeSsl ssl;
    private final SSLParametersImpl sslParameters;
    private int state;
    private static final SSLEngineResult NEED_UNWRAP_OK = new SSLEngineResult(SSLEngineResult.Status.OK, SSLEngineResult.HandshakeStatus.NEED_UNWRAP, 0, 0);
    private static final SSLEngineResult NEED_UNWRAP_CLOSED = new SSLEngineResult(SSLEngineResult.Status.CLOSED, SSLEngineResult.HandshakeStatus.NEED_UNWRAP, 0, 0);
    private static final SSLEngineResult NEED_WRAP_OK = new SSLEngineResult(SSLEngineResult.Status.OK, SSLEngineResult.HandshakeStatus.NEED_WRAP, 0, 0);
    private static final SSLEngineResult NEED_WRAP_CLOSED = new SSLEngineResult(SSLEngineResult.Status.CLOSED, SSLEngineResult.HandshakeStatus.NEED_WRAP, 0, 0);
    private static final SSLEngineResult CLOSED_NOT_HANDSHAKING = new SSLEngineResult(SSLEngineResult.Status.CLOSED, SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING, 0, 0);
    private static BufferAllocator defaultBufferAllocator = null;

    public ConscryptEngine(SSLParametersImpl sSLParametersImpl) {
        this.bufferAllocator = defaultBufferAllocator;
        this.state = 0;
        this.externalSession = Platform.wrapSSLSession(new ExternalSession(new ExternalSession.Provider() { // from class: org.conscrypt.ConscryptEngine.1
            {
                ConscryptEngine.this = this;
            }

            @Override // org.conscrypt.ExternalSession.Provider
            public ConscryptSession provideSession() {
                return ConscryptEngine.this.provideSession();
            }
        }));
        this.singleSrcBuffer = new ByteBuffer[1];
        this.singleDstBuffer = new ByteBuffer[1];
        this.sslParameters = sSLParametersImpl;
        this.peerInfoProvider = PeerInfoProvider.nullProvider();
        NativeSsl newSsl = newSsl(sSLParametersImpl, this);
        this.ssl = newSsl;
        this.networkBio = newSsl.newBio();
    }

    private void beginHandshakeInternal() throws SSLException {
        NativeSslSession cachedSession;
        int i2 = this.state;
        if (i2 == 0) {
            throw new IllegalStateException("Client/server mode must be set before handshake");
        }
        if (i2 != 1) {
            if (i2 == 6 || i2 == 7 || i2 == 8) {
                throw new IllegalStateException("Engine has already been closed");
            }
            return;
        }
        transitionTo(2);
        try {
            try {
                this.ssl.initialize(getHostname(), this.channelIdPrivateKey);
                if (getUseClientMode() && (cachedSession = clientSessionContext().getCachedSession(getHostname(), getPeerPort(), this.sslParameters)) != null) {
                    cachedSession.offerToResume(this.ssl);
                }
                this.maxSealOverhead = this.ssl.getMaxSealOverhead();
                handshake();
            } catch (IOException e2) {
                if (e2.getMessage().contains("unexpected CCS")) {
                    Platform.logEvent(String.format("ssl_unexpected_ccs: host=%s", getPeerHost()));
                }
                throw SSLUtils.toSSLHandshakeException(e2);
            }
        } catch (Throwable th) {
            closeAndFreeResources();
            throw th;
        }
    }

    private static int calcDstsLength(ByteBuffer[] byteBufferArr, int i2, int i3) {
        int i4 = 0;
        for (int i5 = 0; i5 < byteBufferArr.length; i5++) {
            ByteBuffer byteBuffer = byteBufferArr[i5];
            Preconditions.checkArgument(byteBuffer != null, "dsts[%d] is null", Integer.valueOf(i5));
            if (byteBuffer.isReadOnly()) {
                throw new ReadOnlyBufferException();
            }
            if (i5 >= i2 && i5 < i2 + i3) {
                i4 += byteBuffer.remaining();
            }
        }
        return i4;
    }

    private static long calcSrcsLength(ByteBuffer[] byteBufferArr, int i2, int i3) {
        long j2 = 0;
        while (i2 < i3) {
            ByteBuffer byteBuffer = byteBufferArr[i2];
            if (byteBuffer != null) {
                j2 += byteBuffer.remaining();
                i2++;
            } else {
                throw new IllegalArgumentException("srcs[" + i2 + "] is null");
            }
        }
        return j2;
    }

    private ClientSessionContext clientSessionContext() {
        return this.sslParameters.getClientSessionContext();
    }

    private void closeAll() {
        closeOutbound();
        closeInbound();
    }

    private void closeAndFreeResources() {
        transitionTo(8);
        if (this.ssl.isClosed()) {
            return;
        }
        this.ssl.close();
        this.networkBio.close();
    }

    private SSLException convertException(Throwable th) {
        if (!(th instanceof SSLHandshakeException) && this.handshakeFinished) {
            return SSLUtils.toSSLException(th);
        }
        return SSLUtils.toSSLHandshakeException(th);
    }

    private long directByteBufferAddress(ByteBuffer byteBuffer, int i2) {
        return NativeCrypto.getDirectBufferAddress(byteBuffer) + i2;
    }

    private void finishHandshake() throws SSLException {
        this.handshakeFinished = true;
        HandshakeListener handshakeListener = this.handshakeListener;
        if (handshakeListener != null) {
            handshakeListener.onHandshakeFinished();
        }
    }

    private void freeIfDone() {
        if (isInboundDone() && isOutboundDone()) {
            closeAndFreeResources();
        }
    }

    public static BufferAllocator getDefaultBufferAllocator() {
        return defaultBufferAllocator;
    }

    private SSLEngineResult.Status getEngineStatus() {
        int i2 = this.state;
        if (i2 != 6 && i2 != 7 && i2 != 8) {
            return SSLEngineResult.Status.OK;
        }
        return SSLEngineResult.Status.CLOSED;
    }

    private SSLEngineResult.HandshakeStatus getHandshakeStatusInternal() {
        if (this.handshakeFinished) {
            return SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING;
        }
        switch (this.state) {
            case 0:
            case 1:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                return SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING;
            case 2:
                return pendingStatus(pendingOutboundEncryptedBytes());
            case 3:
                return SSLEngineResult.HandshakeStatus.NEED_WRAP;
            default:
                throw new IllegalStateException("Unexpected engine state: " + this.state);
        }
    }

    private ByteBuffer getOrCreateLazyDirectBuffer() {
        if (this.lazyDirectBuffer == null) {
            this.lazyDirectBuffer = ByteBuffer.allocateDirect(Math.max(16384, (int) NativeConstants.SSL3_RT_MAX_PACKET_SIZE));
        }
        this.lazyDirectBuffer.clear();
        return this.lazyDirectBuffer;
    }

    private SSLEngineResult.HandshakeStatus handshake() throws SSLException {
        try {
            try {
                try {
                    int doHandshake = this.ssl.doHandshake();
                    if (doHandshake != 2) {
                        if (doHandshake != 3) {
                            this.activeSession.onPeerCertificateAvailable(getPeerHost(), getPeerPort());
                            finishHandshake();
                            return SSLEngineResult.HandshakeStatus.FINISHED;
                        }
                        return SSLEngineResult.HandshakeStatus.NEED_WRAP;
                    }
                    return pendingStatus(pendingOutboundEncryptedBytes());
                } catch (IOException e2) {
                    sendSSLShutdown();
                    throw e2;
                }
            } catch (SSLException e3) {
                sendSSLShutdown();
                throw e3;
            }
        } catch (Exception e4) {
            throw SSLUtils.toSSLHandshakeException(e4);
        }
    }

    private boolean isHandshakeStarted() {
        int i2 = this.state;
        return (i2 == 0 || i2 == 1) ? false : true;
    }

    private SSLEngineResult.HandshakeStatus mayFinishHandshake(SSLEngineResult.HandshakeStatus handshakeStatus) throws SSLException {
        return (this.handshakeFinished || handshakeStatus != SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING) ? handshakeStatus : handshake();
    }

    private SSLEngineResult newResult(int i2, int i3, SSLEngineResult.HandshakeStatus handshakeStatus) throws SSLException {
        SSLEngineResult.Status engineStatus = getEngineStatus();
        if (handshakeStatus != SSLEngineResult.HandshakeStatus.FINISHED) {
            handshakeStatus = getHandshakeStatusInternal();
        }
        return new SSLEngineResult(engineStatus, mayFinishHandshake(handshakeStatus), i2, i3);
    }

    private static NativeSsl newSsl(SSLParametersImpl sSLParametersImpl, ConscryptEngine conscryptEngine) {
        try {
            return NativeSsl.newInstance(sSLParametersImpl, conscryptEngine, conscryptEngine, conscryptEngine);
        } catch (SSLException e2) {
            throw new RuntimeException(e2);
        }
    }

    private SSLException newSslExceptionWithMessage(String str) {
        if (!this.handshakeFinished) {
            return new SSLException(str);
        }
        return new SSLHandshakeException(str);
    }

    private int pendingInboundCleartextBytes() {
        return this.ssl.getPendingReadableBytes();
    }

    private static SSLEngineResult.HandshakeStatus pendingStatus(int i2) {
        return i2 > 0 ? SSLEngineResult.HandshakeStatus.NEED_WRAP : SSLEngineResult.HandshakeStatus.NEED_UNWRAP;
    }

    public ConscryptSession provideHandshakeSession() {
        ConscryptSession nullSession;
        synchronized (this.ssl) {
            nullSession = this.state == 2 ? this.activeSession : SSLNullSession.getNullSession();
        }
        return nullSession;
    }

    public ConscryptSession provideSession() {
        synchronized (this.ssl) {
            int i2 = this.state;
            if (i2 == 8) {
                ConscryptSession conscryptSession = this.closedSession;
                if (conscryptSession == null) {
                    conscryptSession = SSLNullSession.getNullSession();
                }
                return conscryptSession;
            } else if (i2 < 3) {
                return SSLNullSession.getNullSession();
            } else {
                return this.activeSession;
            }
        }
    }

    private int readEncryptedData(ByteBuffer byteBuffer, int i2) throws SSLException {
        try {
            int position = byteBuffer.position();
            if (byteBuffer.remaining() >= i2) {
                int min = Math.min(i2, byteBuffer.limit() - position);
                if (byteBuffer.isDirect()) {
                    int readEncryptedDataDirect = readEncryptedDataDirect(byteBuffer, position, min);
                    if (readEncryptedDataDirect > 0) {
                        byteBuffer.position(position + readEncryptedDataDirect);
                        return readEncryptedDataDirect;
                    }
                    return readEncryptedDataDirect;
                }
                return readEncryptedDataHeap(byteBuffer, min);
            }
            return 0;
        } catch (Exception e2) {
            throw convertException(e2);
        }
    }

    private int readEncryptedDataDirect(ByteBuffer byteBuffer, int i2, int i3) throws IOException {
        return this.networkBio.readDirectByteBuffer(directByteBufferAddress(byteBuffer, i2), i3);
    }

    private int readEncryptedDataHeap(ByteBuffer byteBuffer, int i2) throws IOException {
        ByteBuffer orCreateLazyDirectBuffer;
        AllocatedBuffer allocatedBuffer = null;
        try {
            BufferAllocator bufferAllocator = this.bufferAllocator;
            if (bufferAllocator != null) {
                allocatedBuffer = bufferAllocator.allocateDirectBuffer(i2);
                orCreateLazyDirectBuffer = allocatedBuffer.nioBuffer();
            } else {
                orCreateLazyDirectBuffer = getOrCreateLazyDirectBuffer();
            }
            int readEncryptedDataDirect = readEncryptedDataDirect(orCreateLazyDirectBuffer, 0, Math.min(i2, orCreateLazyDirectBuffer.remaining()));
            if (readEncryptedDataDirect > 0) {
                orCreateLazyDirectBuffer.position(readEncryptedDataDirect);
                orCreateLazyDirectBuffer.flip();
                byteBuffer.put(orCreateLazyDirectBuffer);
            }
            return readEncryptedDataDirect;
        } finally {
            if (allocatedBuffer != null) {
                allocatedBuffer.release();
            }
        }
    }

    private SSLEngineResult readPendingBytesFromBIO(ByteBuffer byteBuffer, int i2, int i3, SSLEngineResult.HandshakeStatus handshakeStatus) throws SSLException {
        try {
            int pendingOutboundEncryptedBytes = pendingOutboundEncryptedBytes();
            if (pendingOutboundEncryptedBytes > 0) {
                if (byteBuffer.remaining() < pendingOutboundEncryptedBytes) {
                    SSLEngineResult.Status status = SSLEngineResult.Status.BUFFER_OVERFLOW;
                    if (handshakeStatus != SSLEngineResult.HandshakeStatus.FINISHED) {
                        handshakeStatus = getHandshakeStatus(pendingOutboundEncryptedBytes);
                    }
                    return new SSLEngineResult(status, mayFinishHandshake(handshakeStatus), i2, i3);
                }
                int readEncryptedData = readEncryptedData(byteBuffer, pendingOutboundEncryptedBytes);
                if (readEncryptedData <= 0) {
                    NativeCrypto.SSL_clear_error();
                } else {
                    i3 += readEncryptedData;
                    pendingOutboundEncryptedBytes -= readEncryptedData;
                }
                SSLEngineResult.Status engineStatus = getEngineStatus();
                if (handshakeStatus != SSLEngineResult.HandshakeStatus.FINISHED) {
                    handshakeStatus = getHandshakeStatus(pendingOutboundEncryptedBytes);
                }
                return new SSLEngineResult(engineStatus, mayFinishHandshake(handshakeStatus), i2, i3);
            }
            return null;
        } catch (Exception e2) {
            throw convertException(e2);
        }
    }

    private int readPlaintextData(ByteBuffer byteBuffer) throws IOException {
        try {
            int position = byteBuffer.position();
            int min = Math.min((int) NativeConstants.SSL3_RT_MAX_PACKET_SIZE, byteBuffer.limit() - position);
            if (byteBuffer.isDirect()) {
                int readPlaintextDataDirect = readPlaintextDataDirect(byteBuffer, position, min);
                if (readPlaintextDataDirect > 0) {
                    byteBuffer.position(position + readPlaintextDataDirect);
                }
                return readPlaintextDataDirect;
            }
            return readPlaintextDataHeap(byteBuffer, min);
        } catch (CertificateException e2) {
            throw convertException(e2);
        }
    }

    private int readPlaintextDataDirect(ByteBuffer byteBuffer, int i2, int i3) throws IOException, CertificateException {
        return this.ssl.readDirectByteBuffer(directByteBufferAddress(byteBuffer, i2), i3);
    }

    private int readPlaintextDataHeap(ByteBuffer byteBuffer, int i2) throws IOException, CertificateException {
        ByteBuffer orCreateLazyDirectBuffer;
        AllocatedBuffer allocatedBuffer = null;
        try {
            BufferAllocator bufferAllocator = this.bufferAllocator;
            if (bufferAllocator != null) {
                allocatedBuffer = bufferAllocator.allocateDirectBuffer(i2);
                orCreateLazyDirectBuffer = allocatedBuffer.nioBuffer();
            } else {
                orCreateLazyDirectBuffer = getOrCreateLazyDirectBuffer();
            }
            int readPlaintextDataDirect = readPlaintextDataDirect(orCreateLazyDirectBuffer, 0, Math.min(i2, orCreateLazyDirectBuffer.remaining()));
            if (readPlaintextDataDirect > 0) {
                orCreateLazyDirectBuffer.position(readPlaintextDataDirect);
                orCreateLazyDirectBuffer.flip();
                byteBuffer.put(orCreateLazyDirectBuffer);
            }
            return readPlaintextDataDirect;
        } finally {
            if (allocatedBuffer != null) {
                allocatedBuffer.release();
            }
        }
    }

    private void resetSingleDstBuffer() {
        this.singleDstBuffer[0] = null;
    }

    private void resetSingleSrcBuffer() {
        this.singleSrcBuffer[0] = null;
    }

    private void sendSSLShutdown() {
        try {
            this.ssl.shutdown();
        } catch (IOException unused) {
        }
    }

    private AbstractSessionContext sessionContext() {
        return this.sslParameters.getSessionContext();
    }

    public static void setDefaultBufferAllocator(BufferAllocator bufferAllocator) {
        defaultBufferAllocator = bufferAllocator;
    }

    private ByteBuffer[] singleDstBuffer(ByteBuffer byteBuffer) {
        ByteBuffer[] byteBufferArr = this.singleDstBuffer;
        byteBufferArr[0] = byteBuffer;
        return byteBufferArr;
    }

    private ByteBuffer[] singleSrcBuffer(ByteBuffer byteBuffer) {
        ByteBuffer[] byteBufferArr = this.singleSrcBuffer;
        byteBufferArr[0] = byteBuffer;
        return byteBufferArr;
    }

    private void transitionTo(int i2) {
        int i3;
        if (i2 != 2) {
            if (i2 == 8 && !this.ssl.isClosed() && (i3 = this.state) >= 2 && i3 < 8) {
                this.closedSession = new SessionSnapshot(this.activeSession);
            }
        } else {
            this.handshakeFinished = false;
            this.activeSession = new ActiveSession(this.ssl, this.sslParameters.getSessionContext());
        }
        this.state = i2;
    }

    private int writeEncryptedData(ByteBuffer byteBuffer, int i2) throws SSLException {
        int writeEncryptedDataHeap;
        try {
            int position = byteBuffer.position();
            if (byteBuffer.isDirect()) {
                writeEncryptedDataHeap = writeEncryptedDataDirect(byteBuffer, position, i2);
            } else {
                writeEncryptedDataHeap = writeEncryptedDataHeap(byteBuffer, position, i2);
            }
            if (writeEncryptedDataHeap > 0) {
                byteBuffer.position(position + writeEncryptedDataHeap);
            }
            return writeEncryptedDataHeap;
        } catch (IOException e2) {
            throw new SSLException(e2);
        }
    }

    private int writeEncryptedDataDirect(ByteBuffer byteBuffer, int i2, int i3) throws IOException {
        return this.networkBio.writeDirectByteBuffer(directByteBufferAddress(byteBuffer, i2), i3);
    }

    private int writeEncryptedDataHeap(ByteBuffer byteBuffer, int i2, int i3) throws IOException {
        ByteBuffer orCreateLazyDirectBuffer;
        AllocatedBuffer allocatedBuffer = null;
        try {
            BufferAllocator bufferAllocator = this.bufferAllocator;
            if (bufferAllocator != null) {
                allocatedBuffer = bufferAllocator.allocateDirectBuffer(i3);
                orCreateLazyDirectBuffer = allocatedBuffer.nioBuffer();
            } else {
                orCreateLazyDirectBuffer = getOrCreateLazyDirectBuffer();
            }
            int limit = byteBuffer.limit();
            int min = Math.min(Math.min(limit - i2, i3), orCreateLazyDirectBuffer.remaining());
            byteBuffer.limit(i2 + min);
            orCreateLazyDirectBuffer.put(byteBuffer);
            byteBuffer.limit(limit);
            byteBuffer.position(i2);
            int writeEncryptedDataDirect = writeEncryptedDataDirect(orCreateLazyDirectBuffer, 0, min);
            byteBuffer.position(i2);
            return writeEncryptedDataDirect;
        } finally {
            if (allocatedBuffer != null) {
                allocatedBuffer.release();
            }
        }
    }

    private int writePlaintextData(ByteBuffer byteBuffer, int i2) throws SSLException {
        int writePlaintextDataHeap;
        try {
            int position = byteBuffer.position();
            if (byteBuffer.isDirect()) {
                writePlaintextDataHeap = writePlaintextDataDirect(byteBuffer, position, i2);
            } else {
                writePlaintextDataHeap = writePlaintextDataHeap(byteBuffer, position, i2);
            }
            if (writePlaintextDataHeap > 0) {
                byteBuffer.position(position + writePlaintextDataHeap);
            }
            return writePlaintextDataHeap;
        } catch (Exception e2) {
            throw convertException(e2);
        }
    }

    private int writePlaintextDataDirect(ByteBuffer byteBuffer, int i2, int i3) throws IOException {
        return this.ssl.writeDirectByteBuffer(directByteBufferAddress(byteBuffer, i2), i3);
    }

    private int writePlaintextDataHeap(ByteBuffer byteBuffer, int i2, int i3) throws IOException {
        ByteBuffer orCreateLazyDirectBuffer;
        AllocatedBuffer allocatedBuffer = null;
        try {
            BufferAllocator bufferAllocator = this.bufferAllocator;
            if (bufferAllocator != null) {
                allocatedBuffer = bufferAllocator.allocateDirectBuffer(i3);
                orCreateLazyDirectBuffer = allocatedBuffer.nioBuffer();
            } else {
                orCreateLazyDirectBuffer = getOrCreateLazyDirectBuffer();
            }
            int limit = byteBuffer.limit();
            int min = Math.min(i3, orCreateLazyDirectBuffer.remaining());
            byteBuffer.limit(i2 + min);
            orCreateLazyDirectBuffer.put(byteBuffer);
            orCreateLazyDirectBuffer.flip();
            byteBuffer.limit(limit);
            byteBuffer.position(i2);
            return writePlaintextDataDirect(orCreateLazyDirectBuffer, 0, min);
        } finally {
            if (allocatedBuffer != null) {
                allocatedBuffer.release();
            }
        }
    }

    @Override // javax.net.ssl.SSLEngine
    public void beginHandshake() throws SSLException {
        synchronized (this.ssl) {
            beginHandshakeInternal();
        }
    }

    @Override // org.conscrypt.SSLParametersImpl.AliasChooser
    public String chooseClientAlias(X509KeyManager x509KeyManager, X500Principal[] x500PrincipalArr, String[] strArr) {
        if (x509KeyManager instanceof X509ExtendedKeyManager) {
            return ((X509ExtendedKeyManager) x509KeyManager).chooseEngineClientAlias(strArr, x500PrincipalArr, this);
        }
        return x509KeyManager.chooseClientAlias(strArr, x500PrincipalArr, null);
    }

    @Override // org.conscrypt.SSLParametersImpl.PSKCallbacks
    public String chooseClientPSKIdentity(PSKKeyManager pSKKeyManager, String str) {
        return pSKKeyManager.chooseClientKeyIdentity(str, this);
    }

    @Override // org.conscrypt.SSLParametersImpl.AliasChooser
    public String chooseServerAlias(X509KeyManager x509KeyManager, String str) {
        if (x509KeyManager instanceof X509ExtendedKeyManager) {
            return ((X509ExtendedKeyManager) x509KeyManager).chooseEngineServerAlias(str, null, this);
        }
        return x509KeyManager.chooseServerAlias(str, null, null);
    }

    @Override // org.conscrypt.SSLParametersImpl.PSKCallbacks
    public String chooseServerPSKIdentityHint(PSKKeyManager pSKKeyManager) {
        return pSKKeyManager.chooseServerKeyIdentityHint(this);
    }

    @Override // org.conscrypt.NativeCrypto.SSLHandshakeCallbacks
    public void clientCertificateRequested(byte[] bArr, int[] iArr, byte[][] bArr2) throws CertificateEncodingException, SSLException {
        this.ssl.chooseClientCertificate(bArr, iArr, bArr2);
    }

    @Override // org.conscrypt.NativeCrypto.SSLHandshakeCallbacks
    public int clientPSKKeyRequested(String str, byte[] bArr, byte[] bArr2) {
        return this.ssl.clientPSKKeyRequested(str, bArr, bArr2);
    }

    @Override // javax.net.ssl.SSLEngine
    public void closeInbound() {
        synchronized (this.ssl) {
            int i2 = this.state;
            if (i2 != 8 && i2 != 6) {
                if (isHandshakeStarted()) {
                    if (this.state == 7) {
                        transitionTo(8);
                    } else {
                        transitionTo(6);
                    }
                    freeIfDone();
                } else {
                    closeAndFreeResources();
                }
            }
        }
    }

    @Override // javax.net.ssl.SSLEngine
    public void closeOutbound() {
        synchronized (this.ssl) {
            int i2 = this.state;
            if (i2 != 8 && i2 != 7) {
                if (isHandshakeStarted()) {
                    if (this.state == 6) {
                        transitionTo(8);
                    } else {
                        transitionTo(7);
                    }
                    sendSSLShutdown();
                    freeIfDone();
                } else {
                    closeAndFreeResources();
                }
            }
        }
    }

    @Override // org.conscrypt.AbstractConscryptEngine
    public byte[] exportKeyingMaterial(String str, byte[] bArr, int i2) throws SSLException {
        synchronized (this.ssl) {
            int i3 = this.state;
            if (i3 >= 3 && i3 != 8) {
                return this.ssl.exportKeyingMaterial(str, bArr, i2);
            }
            return null;
        }
    }

    public void finalize() throws Throwable {
        try {
            transitionTo(8);
        } finally {
            super.finalize();
        }
    }

    @Override // org.conscrypt.AbstractConscryptEngine, javax.net.ssl.SSLEngine
    public String getApplicationProtocol() {
        return SSLUtils.toProtocolString(this.ssl.getApplicationProtocol());
    }

    @Override // org.conscrypt.AbstractConscryptEngine
    public String[] getApplicationProtocols() {
        return this.sslParameters.getApplicationProtocols();
    }

    @Override // org.conscrypt.AbstractConscryptEngine
    public byte[] getChannelId() throws SSLException {
        byte[] tlsChannelId;
        synchronized (this.ssl) {
            if (!getUseClientMode()) {
                if (!isHandshakeStarted()) {
                    tlsChannelId = this.ssl.getTlsChannelId();
                } else {
                    throw new IllegalStateException("Channel ID is only available after handshake completes");
                }
            } else {
                throw new IllegalStateException("Not allowed in client mode");
            }
        }
        return tlsChannelId;
    }

    @Override // javax.net.ssl.SSLEngine
    public Runnable getDelegatedTask() {
        return null;
    }

    @Override // javax.net.ssl.SSLEngine
    public boolean getEnableSessionCreation() {
        return this.sslParameters.getEnableSessionCreation();
    }

    @Override // javax.net.ssl.SSLEngine
    public String[] getEnabledCipherSuites() {
        return this.sslParameters.getEnabledCipherSuites();
    }

    @Override // javax.net.ssl.SSLEngine
    public String[] getEnabledProtocols() {
        return this.sslParameters.getEnabledProtocols();
    }

    @Override // org.conscrypt.AbstractConscryptEngine, javax.net.ssl.SSLEngine
    public String getHandshakeApplicationProtocol() {
        String applicationProtocol;
        synchronized (this.ssl) {
            applicationProtocol = this.state == 2 ? getApplicationProtocol() : null;
        }
        return applicationProtocol;
    }

    @Override // javax.net.ssl.SSLEngine
    public SSLEngineResult.HandshakeStatus getHandshakeStatus() {
        SSLEngineResult.HandshakeStatus handshakeStatusInternal;
        synchronized (this.ssl) {
            handshakeStatusInternal = getHandshakeStatusInternal();
        }
        return handshakeStatusInternal;
    }

    @Override // org.conscrypt.AbstractConscryptEngine
    public String getHostname() {
        String str = this.peerHostname;
        return str != null ? str : this.peerInfoProvider.getHostname();
    }

    @Override // javax.net.ssl.SSLEngine
    public boolean getNeedClientAuth() {
        return this.sslParameters.getNeedClientAuth();
    }

    @Override // org.conscrypt.SSLParametersImpl.PSKCallbacks
    public SecretKey getPSKKey(PSKKeyManager pSKKeyManager, String str, String str2) {
        return pSKKeyManager.getKey(str, str2, this);
    }

    @Override // org.conscrypt.AbstractConscryptEngine, javax.net.ssl.SSLEngine
    public String getPeerHost() {
        String str = this.peerHostname;
        return str != null ? str : this.peerInfoProvider.getHostnameOrIP();
    }

    @Override // org.conscrypt.AbstractConscryptEngine, javax.net.ssl.SSLEngine
    public int getPeerPort() {
        return this.peerInfoProvider.getPort();
    }

    @Override // javax.net.ssl.SSLEngine
    public SSLParameters getSSLParameters() {
        SSLParameters sSLParameters = super.getSSLParameters();
        Platform.getSSLParameters(sSLParameters, this.sslParameters, this);
        return sSLParameters;
    }

    @Override // javax.net.ssl.SSLEngine
    public SSLSession getSession() {
        return this.externalSession;
    }

    @Override // javax.net.ssl.SSLEngine
    public String[] getSupportedCipherSuites() {
        return NativeCrypto.getSupportedCipherSuites();
    }

    @Override // javax.net.ssl.SSLEngine
    public String[] getSupportedProtocols() {
        return NativeCrypto.getSupportedProtocols();
    }

    @Override // org.conscrypt.AbstractConscryptEngine
    public byte[] getTlsUnique() {
        return this.ssl.getTlsUnique();
    }

    @Override // javax.net.ssl.SSLEngine
    public boolean getUseClientMode() {
        return this.sslParameters.getUseClientMode();
    }

    @Override // javax.net.ssl.SSLEngine
    public boolean getWantClientAuth() {
        return this.sslParameters.getWantClientAuth();
    }

    @Override // org.conscrypt.AbstractConscryptEngine
    public SSLSession handshakeSession() {
        synchronized (this.ssl) {
            if (this.state == 2) {
                return Platform.wrapSSLSession(new ExternalSession(new ExternalSession.Provider() { // from class: org.conscrypt.ConscryptEngine.2
                    {
                        ConscryptEngine.this = this;
                    }

                    @Override // org.conscrypt.ExternalSession.Provider
                    public ConscryptSession provideSession() {
                        return ConscryptEngine.this.provideHandshakeSession();
                    }
                }));
            }
            return null;
        }
    }

    @Override // javax.net.ssl.SSLEngine
    public boolean isInboundDone() {
        boolean z;
        synchronized (this.ssl) {
            int i2 = this.state;
            z = (i2 == 8 || i2 == 6 || this.ssl.wasShutdownReceived()) && pendingInboundCleartextBytes() == 0;
        }
        return z;
    }

    @Override // javax.net.ssl.SSLEngine
    public boolean isOutboundDone() {
        boolean z;
        synchronized (this.ssl) {
            int i2 = this.state;
            z = (i2 == 8 || i2 == 7 || this.ssl.wasShutdownSent()) && pendingOutboundEncryptedBytes() == 0;
        }
        return z;
    }

    @Override // org.conscrypt.AbstractConscryptEngine
    public int maxSealOverhead() {
        return this.maxSealOverhead;
    }

    @Override // org.conscrypt.NativeCrypto.SSLHandshakeCallbacks
    public void onNewSessionEstablished(long j2) {
        try {
            NativeCrypto.SSL_SESSION_up_ref(j2);
            sessionContext().cacheSession(NativeSslSession.newInstance(new NativeRef.SSL_SESSION(j2), this.activeSession));
        } catch (Exception unused) {
        }
    }

    @Override // org.conscrypt.NativeCrypto.SSLHandshakeCallbacks
    public void onSSLStateChange(int i2, int i3) {
        synchronized (this.ssl) {
            if (i2 == 16) {
                transitionTo(2);
            } else if (i2 == 32) {
                int i4 = this.state;
                if (i4 != 2 && i4 != 4) {
                    throw new IllegalStateException("Completed handshake while in mode " + this.state);
                }
                transitionTo(3);
            }
        }
    }

    public int pendingOutboundEncryptedBytes() {
        return this.networkBio.getPendingWrittenBytes();
    }

    @Override // org.conscrypt.NativeCrypto.SSLHandshakeCallbacks
    public int serverPSKKeyRequested(String str, String str2, byte[] bArr) {
        return this.ssl.serverPSKKeyRequested(str, str2, bArr);
    }

    @Override // org.conscrypt.NativeCrypto.SSLHandshakeCallbacks
    public long serverSessionRequested(byte[] bArr) {
        return 0L;
    }

    @Override // org.conscrypt.AbstractConscryptEngine
    public void setApplicationProtocolSelector(ApplicationProtocolSelector applicationProtocolSelector) {
        setApplicationProtocolSelector(applicationProtocolSelector == null ? null : new ApplicationProtocolSelectorAdapter(this, applicationProtocolSelector));
    }

    @Override // org.conscrypt.AbstractConscryptEngine
    public void setApplicationProtocols(String[] strArr) {
        this.sslParameters.setApplicationProtocols(strArr);
    }

    @Override // org.conscrypt.AbstractConscryptEngine
    public void setBufferAllocator(BufferAllocator bufferAllocator) {
        synchronized (this.ssl) {
            if (!isHandshakeStarted()) {
                this.bufferAllocator = bufferAllocator;
            } else {
                throw new IllegalStateException("Could not set buffer allocator after the initial handshake has begun.");
            }
        }
    }

    @Override // org.conscrypt.AbstractConscryptEngine
    public void setChannelIdEnabled(boolean z) {
        synchronized (this.ssl) {
            if (!getUseClientMode()) {
                if (!isHandshakeStarted()) {
                    this.sslParameters.channelIdEnabled = z;
                } else {
                    throw new IllegalStateException("Could not enable/disable Channel ID after the initial handshake has begun.");
                }
            } else {
                throw new IllegalStateException("Not allowed in client mode");
            }
        }
    }

    @Override // org.conscrypt.AbstractConscryptEngine
    public void setChannelIdPrivateKey(PrivateKey privateKey) {
        if (getUseClientMode()) {
            synchronized (this.ssl) {
                if (isHandshakeStarted()) {
                    throw new IllegalStateException("Could not change Channel ID private key after the initial handshake has begun.");
                }
                if (privateKey == null) {
                    this.sslParameters.channelIdEnabled = false;
                    this.channelIdPrivateKey = null;
                    return;
                }
                this.sslParameters.channelIdEnabled = true;
                try {
                    ECParameterSpec params = privateKey instanceof ECKey ? ((ECKey) privateKey).getParams() : null;
                    if (params == null) {
                        params = OpenSSLECGroupContext.getCurveByName("prime256v1").getECParameterSpec();
                    }
                    this.channelIdPrivateKey = OpenSSLKey.fromECPrivateKeyForTLSStackOnly(privateKey, params);
                } catch (InvalidKeyException unused) {
                }
                return;
            }
        }
        throw new IllegalStateException("Not allowed in server mode");
    }

    @Override // javax.net.ssl.SSLEngine
    public void setEnableSessionCreation(boolean z) {
        this.sslParameters.setEnableSessionCreation(z);
    }

    @Override // javax.net.ssl.SSLEngine
    public void setEnabledCipherSuites(String[] strArr) {
        this.sslParameters.setEnabledCipherSuites(strArr);
    }

    @Override // javax.net.ssl.SSLEngine
    public void setEnabledProtocols(String[] strArr) {
        this.sslParameters.setEnabledProtocols(strArr);
    }

    @Override // org.conscrypt.AbstractConscryptEngine
    public void setHandshakeListener(HandshakeListener handshakeListener) {
        synchronized (this.ssl) {
            if (!isHandshakeStarted()) {
                this.handshakeListener = handshakeListener;
            } else {
                throw new IllegalStateException("Handshake listener must be set before starting the handshake.");
            }
        }
    }

    @Override // org.conscrypt.AbstractConscryptEngine
    public void setHostname(String str) {
        this.sslParameters.setUseSni(str != null);
        this.peerHostname = str;
    }

    @Override // javax.net.ssl.SSLEngine
    public void setNeedClientAuth(boolean z) {
        this.sslParameters.setNeedClientAuth(z);
    }

    @Override // javax.net.ssl.SSLEngine
    public void setSSLParameters(SSLParameters sSLParameters) {
        super.setSSLParameters(sSLParameters);
        Platform.setSSLParameters(sSLParameters, this.sslParameters, this);
    }

    @Override // javax.net.ssl.SSLEngine
    public void setUseClientMode(boolean z) {
        synchronized (this.ssl) {
            if (!isHandshakeStarted()) {
                transitionTo(1);
                this.sslParameters.setUseClientMode(z);
            } else {
                throw new IllegalArgumentException("Can not change mode after handshake: state == " + this.state);
            }
        }
    }

    @Override // org.conscrypt.AbstractConscryptEngine
    public void setUseSessionTickets(boolean z) {
        this.sslParameters.setUseSessionTickets(z);
    }

    @Override // javax.net.ssl.SSLEngine
    public void setWantClientAuth(boolean z) {
        this.sslParameters.setWantClientAuth(z);
    }

    @Override // org.conscrypt.AbstractConscryptEngine, javax.net.ssl.SSLEngine
    public SSLEngineResult unwrap(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) throws SSLException {
        SSLEngineResult unwrap;
        synchronized (this.ssl) {
            unwrap = unwrap(singleSrcBuffer(byteBuffer), singleDstBuffer(byteBuffer2));
            resetSingleSrcBuffer();
            resetSingleDstBuffer();
        }
        return unwrap;
    }

    @Override // org.conscrypt.NativeCrypto.SSLHandshakeCallbacks
    public void verifyCertificateChain(byte[][] bArr, String str) throws CertificateException {
        if (bArr != null) {
            try {
                if (bArr.length != 0) {
                    X509Certificate[] decodeX509CertificateChain = SSLUtils.decodeX509CertificateChain(bArr);
                    X509TrustManager x509TrustManager = this.sslParameters.getX509TrustManager();
                    if (x509TrustManager != null) {
                        this.activeSession.onPeerCertificatesReceived(getPeerHost(), getPeerPort(), decodeX509CertificateChain);
                        if (getUseClientMode()) {
                            Platform.checkServerTrusted(x509TrustManager, decodeX509CertificateChain, str, this);
                            return;
                        } else {
                            Platform.checkClientTrusted(x509TrustManager, decodeX509CertificateChain, decodeX509CertificateChain[0].getPublicKey().getAlgorithm(), this);
                            return;
                        }
                    }
                    throw new CertificateException("No X.509 TrustManager");
                }
            } catch (CertificateException e2) {
                throw e2;
            } catch (Exception e3) {
                throw new CertificateException(e3);
            }
        }
        throw new CertificateException("Peer sent no certificate");
    }

    @Override // org.conscrypt.AbstractConscryptEngine, javax.net.ssl.SSLEngine
    public SSLEngineResult wrap(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) throws SSLException {
        SSLEngineResult wrap;
        synchronized (this.ssl) {
            wrap = wrap(singleSrcBuffer(byteBuffer), byteBuffer2);
            resetSingleSrcBuffer();
        }
        return wrap;
    }

    public void setApplicationProtocolSelector(ApplicationProtocolSelectorAdapter applicationProtocolSelectorAdapter) {
        this.sslParameters.setApplicationProtocolSelector(applicationProtocolSelectorAdapter);
    }

    private SSLEngineResult.HandshakeStatus getHandshakeStatus(int i2) {
        return !this.handshakeFinished ? pendingStatus(i2) : SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING;
    }

    @Override // org.conscrypt.AbstractConscryptEngine, javax.net.ssl.SSLEngine
    public SSLEngineResult wrap(ByteBuffer[] byteBufferArr, int i2, int i3, ByteBuffer byteBuffer) throws SSLException {
        SSLEngineResult readPendingBytesFromBIO;
        Preconditions.checkArgument(byteBufferArr != null, "srcs is null");
        Preconditions.checkArgument(byteBuffer != null, "dst is null");
        int i4 = i3 + i2;
        Preconditions.checkPositionIndexes(i2, i4, byteBufferArr.length);
        if (!byteBuffer.isReadOnly()) {
            synchronized (this.ssl) {
                int i5 = this.state;
                if (i5 != 0) {
                    if (i5 == 1) {
                        beginHandshakeInternal();
                    } else if (i5 == 7 || i5 == 8) {
                        SSLEngineResult readPendingBytesFromBIO2 = readPendingBytesFromBIO(byteBuffer, 0, 0, SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING);
                        if (readPendingBytesFromBIO2 != null) {
                            freeIfDone();
                            return readPendingBytesFromBIO2;
                        }
                        return new SSLEngineResult(SSLEngineResult.Status.CLOSED, getHandshakeStatusInternal(), 0, 0);
                    }
                    SSLEngineResult.HandshakeStatus handshakeStatus = SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING;
                    if (!this.handshakeFinished) {
                        handshakeStatus = handshake();
                        if (handshakeStatus == SSLEngineResult.HandshakeStatus.NEED_UNWRAP) {
                            return NEED_UNWRAP_OK;
                        }
                        if (this.state == 8) {
                            return NEED_UNWRAP_CLOSED;
                        }
                    }
                    int i6 = 0;
                    for (int i7 = i2; i7 < i4; i7++) {
                        ByteBuffer byteBuffer2 = byteBufferArr[i7];
                        if (byteBuffer2 == null) {
                            throw new IllegalArgumentException("srcs[" + i7 + "] is null");
                        }
                        if (i6 != 16384 && ((i6 = i6 + byteBuffer2.remaining()) > 16384 || i6 < 0)) {
                            i6 = 16384;
                        }
                    }
                    if (byteBuffer.remaining() < SSLUtils.calculateOutNetBufSize(i6)) {
                        return new SSLEngineResult(SSLEngineResult.Status.BUFFER_OVERFLOW, getHandshakeStatusInternal(), 0, 0);
                    }
                    int i8 = 0;
                    int i9 = 0;
                    loop1: while (i2 < i4) {
                        ByteBuffer byteBuffer3 = byteBufferArr[i2];
                        Preconditions.checkArgument(byteBuffer3 != null, "srcs[%d] is null", Integer.valueOf(i2));
                        while (byteBuffer3.hasRemaining()) {
                            int writePlaintextData = writePlaintextData(byteBuffer3, Math.min(byteBuffer3.remaining(), 16384 - i9));
                            if (writePlaintextData > 0) {
                                i9 += writePlaintextData;
                                SSLEngineResult readPendingBytesFromBIO3 = readPendingBytesFromBIO(byteBuffer, i9, i8, handshakeStatus);
                                if (readPendingBytesFromBIO3 != null) {
                                    if (readPendingBytesFromBIO3.getStatus() != SSLEngineResult.Status.OK) {
                                        return readPendingBytesFromBIO3;
                                    }
                                    i8 = readPendingBytesFromBIO3.bytesProduced();
                                    continue;
                                }
                                if (i9 == 16384) {
                                    break loop1;
                                }
                            } else {
                                int error = this.ssl.getError(writePlaintextData);
                                if (error == 2) {
                                    SSLEngineResult readPendingBytesFromBIO4 = readPendingBytesFromBIO(byteBuffer, i9, i8, handshakeStatus);
                                    if (readPendingBytesFromBIO4 == null) {
                                        readPendingBytesFromBIO4 = new SSLEngineResult(getEngineStatus(), SSLEngineResult.HandshakeStatus.NEED_UNWRAP, i9, i8);
                                    }
                                    return readPendingBytesFromBIO4;
                                } else if (error == 3) {
                                    SSLEngineResult readPendingBytesFromBIO5 = readPendingBytesFromBIO(byteBuffer, i9, i8, handshakeStatus);
                                    if (readPendingBytesFromBIO5 == null) {
                                        readPendingBytesFromBIO5 = NEED_WRAP_CLOSED;
                                    }
                                    return readPendingBytesFromBIO5;
                                } else if (error == 6) {
                                    closeAll();
                                    SSLEngineResult readPendingBytesFromBIO6 = readPendingBytesFromBIO(byteBuffer, i9, i8, handshakeStatus);
                                    if (readPendingBytesFromBIO6 == null) {
                                        readPendingBytesFromBIO6 = CLOSED_NOT_HANDSHAKING;
                                    }
                                    return readPendingBytesFromBIO6;
                                } else {
                                    sendSSLShutdown();
                                    throw newSslExceptionWithMessage("SSL_write");
                                }
                            }
                        }
                        i2++;
                    }
                    return (i9 != 0 || (readPendingBytesFromBIO = readPendingBytesFromBIO(byteBuffer, 0, i8, handshakeStatus)) == null) ? newResult(i9, i8, handshakeStatus) : readPendingBytesFromBIO;
                }
                throw new IllegalStateException("Client/server mode must be set before calling wrap");
            }
        }
        throw new ReadOnlyBufferException();
    }

    @Override // org.conscrypt.AbstractConscryptEngine, javax.net.ssl.SSLEngine
    public SSLEngineResult unwrap(ByteBuffer byteBuffer, ByteBuffer[] byteBufferArr) throws SSLException {
        SSLEngineResult unwrap;
        synchronized (this.ssl) {
            unwrap = unwrap(singleSrcBuffer(byteBuffer), byteBufferArr);
            resetSingleSrcBuffer();
        }
        return unwrap;
    }

    public ConscryptEngine(String str, int i2, SSLParametersImpl sSLParametersImpl) {
        this.bufferAllocator = defaultBufferAllocator;
        this.state = 0;
        this.externalSession = Platform.wrapSSLSession(new ExternalSession(new ExternalSession.Provider() { // from class: org.conscrypt.ConscryptEngine.1
            {
                ConscryptEngine.this = this;
            }

            @Override // org.conscrypt.ExternalSession.Provider
            public ConscryptSession provideSession() {
                return ConscryptEngine.this.provideSession();
            }
        }));
        this.singleSrcBuffer = new ByteBuffer[1];
        this.singleDstBuffer = new ByteBuffer[1];
        this.sslParameters = sSLParametersImpl;
        this.peerInfoProvider = PeerInfoProvider.forHostAndPort(str, i2);
        NativeSsl newSsl = newSsl(sSLParametersImpl, this);
        this.ssl = newSsl;
        this.networkBio = newSsl.newBio();
    }

    @Override // org.conscrypt.AbstractConscryptEngine, javax.net.ssl.SSLEngine
    public SSLEngineResult unwrap(ByteBuffer byteBuffer, ByteBuffer[] byteBufferArr, int i2, int i3) throws SSLException {
        SSLEngineResult unwrap;
        synchronized (this.ssl) {
            unwrap = unwrap(singleSrcBuffer(byteBuffer), 0, 1, byteBufferArr, i2, i3);
            resetSingleSrcBuffer();
        }
        return unwrap;
    }

    @Override // org.conscrypt.AbstractConscryptEngine
    public SSLEngineResult unwrap(ByteBuffer[] byteBufferArr, ByteBuffer[] byteBufferArr2) throws SSLException {
        Preconditions.checkArgument(byteBufferArr != null, "srcs is null");
        Preconditions.checkArgument(byteBufferArr2 != null, "dsts is null");
        return unwrap(byteBufferArr, 0, byteBufferArr.length, byteBufferArr2, 0, byteBufferArr2.length);
    }

    @Override // org.conscrypt.AbstractConscryptEngine
    public SSLEngineResult unwrap(ByteBuffer[] byteBufferArr, int i2, int i3, ByteBuffer[] byteBufferArr2, int i4, int i5) throws SSLException {
        int i6;
        int i7;
        int i8;
        int i9 = i2;
        int i10 = i4;
        boolean z = true;
        Preconditions.checkArgument(byteBufferArr != null, "srcs is null");
        Preconditions.checkArgument(byteBufferArr2 != null, "dsts is null");
        int i11 = i9 + i3;
        Preconditions.checkPositionIndexes(i9, i11, byteBufferArr.length);
        int i12 = i10 + i5;
        Preconditions.checkPositionIndexes(i10, i12, byteBufferArr2.length);
        int calcDstsLength = calcDstsLength(byteBufferArr2, i4, i5);
        long calcSrcsLength = calcSrcsLength(byteBufferArr, i9, i11);
        synchronized (this.ssl) {
            int i13 = this.state;
            if (i13 != 0) {
                if (i13 == 1) {
                    beginHandshakeInternal();
                } else if (i13 == 6 || i13 == 8) {
                    freeIfDone();
                    return new SSLEngineResult(SSLEngineResult.Status.CLOSED, getHandshakeStatusInternal(), 0, 0);
                }
                SSLEngineResult.HandshakeStatus handshakeStatus = SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING;
                if (!this.handshakeFinished) {
                    handshakeStatus = handshake();
                    if (handshakeStatus == SSLEngineResult.HandshakeStatus.NEED_WRAP) {
                        return NEED_WRAP_OK;
                    } else if (this.state == 8) {
                        return NEED_WRAP_CLOSED;
                    }
                }
                if (pendingInboundCleartextBytes() > 0) {
                    z = false;
                }
                if (calcSrcsLength <= 0 || !z) {
                    if (z) {
                        return new SSLEngineResult(SSLEngineResult.Status.BUFFER_UNDERFLOW, getHandshakeStatus(), 0, 0);
                    }
                    i6 = 0;
                } else if (calcSrcsLength < 5) {
                    return new SSLEngineResult(SSLEngineResult.Status.BUFFER_UNDERFLOW, getHandshakeStatus(), 0, 0);
                } else {
                    i6 = SSLUtils.getEncryptedPacketLength(byteBufferArr, i2);
                    if (i6 < 0) {
                        throw new SSLException("Unable to parse TLS packet header");
                    }
                    if (calcSrcsLength < i6) {
                        return new SSLEngineResult(SSLEngineResult.Status.BUFFER_UNDERFLOW, getHandshakeStatus(), 0, 0);
                    }
                }
                if (i6 > 0 && i9 < i11) {
                    i7 = 0;
                    while (true) {
                        ByteBuffer byteBuffer = byteBufferArr[i9];
                        int remaining = byteBuffer.remaining();
                        if (remaining != 0) {
                            int writeEncryptedData = writeEncryptedData(byteBuffer, Math.min(i6, remaining));
                            if (writeEncryptedData <= 0) {
                                NativeCrypto.SSL_clear_error();
                                break;
                            }
                            i7 += writeEncryptedData;
                            i6 -= writeEncryptedData;
                            if (i6 != 0 && writeEncryptedData == remaining) {
                            }
                        }
                        i9++;
                        if (i9 >= i11) {
                            break;
                        }
                    }
                } else {
                    i7 = 0;
                }
                try {
                    try {
                        if (calcDstsLength > 0) {
                            i8 = 0;
                            while (i10 < i12) {
                                try {
                                    ByteBuffer byteBuffer2 = byteBufferArr2[i10];
                                    if (byteBuffer2.hasRemaining()) {
                                        int readPlaintextData = readPlaintextData(byteBuffer2);
                                        if (readPlaintextData <= 0) {
                                            if (readPlaintextData != -6) {
                                                if (readPlaintextData != -3 && readPlaintextData != -2) {
                                                    sendSSLShutdown();
                                                    throw newSslExceptionWithMessage("SSL_read");
                                                }
                                                return newResult(i7, i8, handshakeStatus);
                                            }
                                            closeInbound();
                                            sendSSLShutdown();
                                            return new SSLEngineResult(SSLEngineResult.Status.CLOSED, pendingOutboundEncryptedBytes() > 0 ? SSLEngineResult.HandshakeStatus.NEED_WRAP : SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING, i7, i8);
                                        }
                                        i8 += readPlaintextData;
                                        if (byteBuffer2.hasRemaining()) {
                                            break;
                                        }
                                    }
                                    i10++;
                                } catch (InterruptedIOException unused) {
                                    r6 = i8;
                                    return newResult(i7, r6, handshakeStatus);
                                }
                            }
                        } else {
                            try {
                                this.ssl.forceRead();
                                i8 = 0;
                            } catch (InterruptedIOException unused2) {
                                return newResult(i7, r6, handshakeStatus);
                            }
                        }
                        if ((this.handshakeFinished ? pendingInboundCleartextBytes() : 0) > 0) {
                            SSLEngineResult.Status status = SSLEngineResult.Status.BUFFER_OVERFLOW;
                            if (handshakeStatus != SSLEngineResult.HandshakeStatus.FINISHED) {
                                handshakeStatus = getHandshakeStatusInternal();
                            }
                            return new SSLEngineResult(status, mayFinishHandshake(handshakeStatus), i7, i8);
                        }
                        return newResult(i7, i8, handshakeStatus);
                    } catch (EOFException e2) {
                        closeAll();
                        throw convertException(e2);
                    } catch (SSLException e3) {
                        sendSSLShutdown();
                        throw convertException(e3);
                    }
                } catch (IOException e4) {
                    sendSSLShutdown();
                    throw convertException(e4);
                }
            }
            throw new IllegalStateException("Client/server mode must be set before calling unwrap");
        }
    }

    public ConscryptEngine(SSLParametersImpl sSLParametersImpl, PeerInfoProvider peerInfoProvider) {
        this.bufferAllocator = defaultBufferAllocator;
        this.state = 0;
        this.externalSession = Platform.wrapSSLSession(new ExternalSession(new ExternalSession.Provider() { // from class: org.conscrypt.ConscryptEngine.1
            {
                ConscryptEngine.this = this;
            }

            @Override // org.conscrypt.ExternalSession.Provider
            public ConscryptSession provideSession() {
                return ConscryptEngine.this.provideSession();
            }
        }));
        this.singleSrcBuffer = new ByteBuffer[1];
        this.singleDstBuffer = new ByteBuffer[1];
        this.sslParameters = sSLParametersImpl;
        this.peerInfoProvider = (PeerInfoProvider) Preconditions.checkNotNull(peerInfoProvider, "peerInfoProvider");
        NativeSsl newSsl = newSsl(sSLParametersImpl, this);
        this.ssl = newSsl;
        this.networkBio = newSsl.newBio();
    }
}
