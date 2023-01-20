package com.moor.imkf.lib.socket.java_websocket;

import com.moor.imkf.lib.socket.java_websocket.interfaces.ISSLChannel;
import com.moor.imkf.lib.socket.java_websocket.util.ByteBufferUtils;
import com.moor.imkf.lib.utils.MoorLogUtils;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLEngineResult;
import javax.net.ssl.SSLException;

/* loaded from: classes2.dex */
public class SSLSocketChannel implements WrappedByteChannel, ByteChannel, ISSLChannel {
    private final SSLEngine engine;
    private ExecutorService executor;
    private ByteBuffer myAppData;
    private ByteBuffer myNetData;
    private ByteBuffer peerAppData;
    private ByteBuffer peerNetData;
    private final SocketChannel socketChannel;

    /* renamed from: com.moor.imkf.lib.socket.java_websocket.SSLSocketChannel$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus;
        public static final /* synthetic */ int[] $SwitchMap$javax$net$ssl$SSLEngineResult$Status;

        static {
            int[] iArr = new int[SSLEngineResult.HandshakeStatus.values().length];
            $SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus = iArr;
            try {
                iArr[SSLEngineResult.HandshakeStatus.FINISHED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus[SSLEngineResult.HandshakeStatus.NEED_UNWRAP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus[SSLEngineResult.HandshakeStatus.NEED_WRAP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus[SSLEngineResult.HandshakeStatus.NEED_TASK.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus[SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            int[] iArr2 = new int[SSLEngineResult.Status.values().length];
            $SwitchMap$javax$net$ssl$SSLEngineResult$Status = iArr2;
            try {
                iArr2[SSLEngineResult.Status.OK.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$javax$net$ssl$SSLEngineResult$Status[SSLEngineResult.Status.BUFFER_UNDERFLOW.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$javax$net$ssl$SSLEngineResult$Status[SSLEngineResult.Status.BUFFER_OVERFLOW.ordinal()] = 3;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$javax$net$ssl$SSLEngineResult$Status[SSLEngineResult.Status.CLOSED.ordinal()] = 4;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    public SSLSocketChannel(SocketChannel socketChannel, SSLEngine sSLEngine, ExecutorService executorService, SelectionKey selectionKey) throws IOException {
        if (socketChannel != null && sSLEngine != null && this.executor != executorService) {
            this.socketChannel = socketChannel;
            this.engine = sSLEngine;
            this.executor = executorService;
            this.myNetData = ByteBuffer.allocate(sSLEngine.getSession().getPacketBufferSize());
            this.peerNetData = ByteBuffer.allocate(sSLEngine.getSession().getPacketBufferSize());
            sSLEngine.beginHandshake();
            if (doHandshake()) {
                if (selectionKey != null) {
                    selectionKey.interestOps(selectionKey.interestOps() | 4);
                    return;
                }
                return;
            }
            try {
                socketChannel.close();
                return;
            } catch (IOException e2) {
                MoorLogUtils.e("Exception during the closing of the channel", e2);
                return;
            }
        }
        throw new IllegalArgumentException("parameter must not be null");
    }

    private void closeConnection() throws IOException {
        this.engine.closeOutbound();
        try {
            doHandshake();
        } catch (IOException unused) {
        }
        this.socketChannel.close();
    }

    private boolean doHandshake() throws IOException {
        SSLEngineResult.HandshakeStatus handshakeStatus;
        int applicationBufferSize = this.engine.getSession().getApplicationBufferSize();
        this.myAppData = ByteBuffer.allocate(applicationBufferSize);
        this.peerAppData = ByteBuffer.allocate(applicationBufferSize);
        this.myNetData.clear();
        this.peerNetData.clear();
        SSLEngineResult.HandshakeStatus handshakeStatus2 = this.engine.getHandshakeStatus();
        boolean z = false;
        while (!z) {
            int i2 = AnonymousClass1.$SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus[handshakeStatus2.ordinal()];
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 == 3) {
                        this.myNetData.clear();
                        try {
                            SSLEngineResult wrap = this.engine.wrap(this.myAppData, this.myNetData);
                            handshakeStatus = wrap.getHandshakeStatus();
                            int i3 = AnonymousClass1.$SwitchMap$javax$net$ssl$SSLEngineResult$Status[wrap.getStatus().ordinal()];
                            if (i3 == 1) {
                                this.myNetData.flip();
                                while (this.myNetData.hasRemaining()) {
                                    this.socketChannel.write(this.myNetData);
                                }
                            } else if (i3 == 2) {
                                throw new SSLException("Buffer underflow occurred after a wrap. I don't think we should ever get here.");
                            } else {
                                if (i3 == 3) {
                                    this.myNetData = enlargePacketBuffer(this.myNetData);
                                } else if (i3 == 4) {
                                    try {
                                        this.myNetData.flip();
                                        while (this.myNetData.hasRemaining()) {
                                            this.socketChannel.write(this.myNetData);
                                        }
                                        this.peerNetData.clear();
                                    } catch (Exception unused) {
                                        handshakeStatus2 = this.engine.getHandshakeStatus();
                                    }
                                } else {
                                    throw new IllegalStateException("Invalid SSL status: " + wrap.getStatus());
                                }
                            }
                        } catch (SSLException unused2) {
                            this.engine.closeOutbound();
                            handshakeStatus2 = this.engine.getHandshakeStatus();
                        }
                    } else if (i2 == 4) {
                        while (true) {
                            Runnable delegatedTask = this.engine.getDelegatedTask();
                            if (delegatedTask == null) {
                                break;
                            }
                            this.executor.execute(delegatedTask);
                        }
                        handshakeStatus2 = this.engine.getHandshakeStatus();
                    } else if (i2 != 5) {
                        throw new IllegalStateException("Invalid SSL status: " + handshakeStatus2);
                    }
                } else if (this.socketChannel.read(this.peerNetData) < 0) {
                    if (this.engine.isInboundDone() && this.engine.isOutboundDone()) {
                        return false;
                    }
                    try {
                        this.engine.closeInbound();
                    } catch (SSLException unused3) {
                    }
                    this.engine.closeOutbound();
                    handshakeStatus2 = this.engine.getHandshakeStatus();
                } else {
                    this.peerNetData.flip();
                    try {
                        SSLEngineResult unwrap = this.engine.unwrap(this.peerNetData, this.peerAppData);
                        this.peerNetData.compact();
                        handshakeStatus = unwrap.getHandshakeStatus();
                        int i4 = AnonymousClass1.$SwitchMap$javax$net$ssl$SSLEngineResult$Status[unwrap.getStatus().ordinal()];
                        if (i4 != 1) {
                            if (i4 == 2) {
                                this.peerNetData = handleBufferUnderflow(this.peerNetData);
                            } else if (i4 == 3) {
                                this.peerAppData = enlargeApplicationBuffer(this.peerAppData);
                            } else if (i4 == 4) {
                                if (this.engine.isOutboundDone()) {
                                    return false;
                                }
                                this.engine.closeOutbound();
                                handshakeStatus2 = this.engine.getHandshakeStatus();
                            } else {
                                throw new IllegalStateException("Invalid SSL status: " + unwrap.getStatus());
                            }
                        }
                    } catch (SSLException unused4) {
                        this.engine.closeOutbound();
                        handshakeStatus2 = this.engine.getHandshakeStatus();
                    }
                }
                handshakeStatus2 = handshakeStatus;
            } else {
                z = !this.peerNetData.hasRemaining();
                if (z) {
                    return true;
                }
                this.socketChannel.write(this.peerNetData);
            }
        }
        return true;
    }

    private ByteBuffer enlargeApplicationBuffer(ByteBuffer byteBuffer) {
        return enlargeBuffer(byteBuffer, this.engine.getSession().getApplicationBufferSize());
    }

    private ByteBuffer enlargeBuffer(ByteBuffer byteBuffer, int i2) {
        if (i2 > byteBuffer.capacity()) {
            return ByteBuffer.allocate(i2);
        }
        return ByteBuffer.allocate(byteBuffer.capacity() * 2);
    }

    private ByteBuffer enlargePacketBuffer(ByteBuffer byteBuffer) {
        return enlargeBuffer(byteBuffer, this.engine.getSession().getPacketBufferSize());
    }

    private ByteBuffer handleBufferUnderflow(ByteBuffer byteBuffer) {
        if (this.engine.getSession().getPacketBufferSize() < byteBuffer.limit()) {
            return byteBuffer;
        }
        ByteBuffer enlargePacketBuffer = enlargePacketBuffer(byteBuffer);
        byteBuffer.flip();
        enlargePacketBuffer.put(byteBuffer);
        return enlargePacketBuffer;
    }

    private void handleEndOfStream() throws IOException {
        try {
            this.engine.closeInbound();
        } catch (Exception unused) {
            MoorLogUtils.e("This engine was forced to close inbound, without having received the proper SSL/TLS close notification message from the peer, due to end of stream.");
        }
        closeConnection();
    }

    @Override // java.nio.channels.Channel, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        closeConnection();
    }

    @Override // com.moor.imkf.lib.socket.java_websocket.interfaces.ISSLChannel
    public SSLEngine getSSLEngine() {
        return this.engine;
    }

    @Override // com.moor.imkf.lib.socket.java_websocket.WrappedByteChannel
    public boolean isBlocking() {
        return this.socketChannel.isBlocking();
    }

    @Override // com.moor.imkf.lib.socket.java_websocket.WrappedByteChannel
    public boolean isNeedRead() {
        return this.peerNetData.hasRemaining() || this.peerAppData.hasRemaining();
    }

    @Override // com.moor.imkf.lib.socket.java_websocket.WrappedByteChannel
    public boolean isNeedWrite() {
        return false;
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return this.socketChannel.isOpen();
    }

    @Override // java.nio.channels.ReadableByteChannel
    public synchronized int read(ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer.hasRemaining()) {
            if (this.peerAppData.hasRemaining()) {
                this.peerAppData.flip();
                return ByteBufferUtils.transferByteBuffer(this.peerAppData, byteBuffer);
            }
            this.peerNetData.compact();
            int read = this.socketChannel.read(this.peerNetData);
            if (read <= 0 && !this.peerNetData.hasRemaining()) {
                if (read < 0) {
                    handleEndOfStream();
                }
                ByteBufferUtils.transferByteBuffer(this.peerAppData, byteBuffer);
                return read;
            }
            this.peerNetData.flip();
            if (this.peerNetData.hasRemaining()) {
                this.peerAppData.compact();
                try {
                    SSLEngineResult unwrap = this.engine.unwrap(this.peerNetData, this.peerAppData);
                    int i2 = AnonymousClass1.$SwitchMap$javax$net$ssl$SSLEngineResult$Status[unwrap.getStatus().ordinal()];
                    if (i2 == 1) {
                        this.peerAppData.flip();
                        return ByteBufferUtils.transferByteBuffer(this.peerAppData, byteBuffer);
                    } else if (i2 == 2) {
                        this.peerAppData.flip();
                        return ByteBufferUtils.transferByteBuffer(this.peerAppData, byteBuffer);
                    } else if (i2 == 3) {
                        this.peerAppData = enlargeApplicationBuffer(this.peerAppData);
                        return read(byteBuffer);
                    } else if (i2 == 4) {
                        closeConnection();
                        byteBuffer.clear();
                        return -1;
                    } else {
                        throw new IllegalStateException("Invalid SSL status: " + unwrap.getStatus());
                    }
                } catch (SSLException e2) {
                    MoorLogUtils.e("SSLException during unwrap", e2);
                    throw e2;
                }
            }
            ByteBufferUtils.transferByteBuffer(this.peerAppData, byteBuffer);
            return read;
        }
        return 0;
    }

    @Override // com.moor.imkf.lib.socket.java_websocket.WrappedByteChannel
    public int readMore(ByteBuffer byteBuffer) throws IOException {
        return read(byteBuffer);
    }

    @Override // java.nio.channels.WritableByteChannel
    public synchronized int write(ByteBuffer byteBuffer) throws IOException {
        int i2 = 0;
        while (byteBuffer.hasRemaining()) {
            this.myNetData.clear();
            SSLEngineResult wrap = this.engine.wrap(byteBuffer, this.myNetData);
            int i3 = AnonymousClass1.$SwitchMap$javax$net$ssl$SSLEngineResult$Status[wrap.getStatus().ordinal()];
            if (i3 == 1) {
                this.myNetData.flip();
                while (this.myNetData.hasRemaining()) {
                    i2 += this.socketChannel.write(this.myNetData);
                }
            } else if (i3 == 2) {
                throw new SSLException("Buffer underflow occurred after a wrap. I don't think we should ever get here.");
            } else {
                if (i3 != 3) {
                    if (i3 == 4) {
                        closeConnection();
                        return 0;
                    }
                    throw new IllegalStateException("Invalid SSL status: " + wrap.getStatus());
                }
                this.myNetData = enlargePacketBuffer(this.myNetData);
            }
        }
        return i2;
    }

    @Override // com.moor.imkf.lib.socket.java_websocket.WrappedByteChannel
    public void writeMore() throws IOException {
    }
}
