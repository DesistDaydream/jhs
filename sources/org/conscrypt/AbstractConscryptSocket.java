package org.conscrypt;

import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.nio.channels.SocketChannel;
import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.List;
import javax.net.ssl.HandshakeCompletedEvent;
import javax.net.ssl.HandshakeCompletedListener;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;

/* loaded from: classes4.dex */
public abstract class AbstractConscryptSocket extends SSLSocket {
    private final boolean autoClose;
    private final List<HandshakeCompletedListener> listeners;
    private String peerHostname;
    private final PeerInfoProvider peerInfoProvider;
    private final int peerPort;
    private int readTimeoutMilliseconds;
    public final Socket socket;

    public AbstractConscryptSocket() throws IOException {
        this.peerInfoProvider = new PeerInfoProvider() { // from class: org.conscrypt.AbstractConscryptSocket.1
            @Override // org.conscrypt.PeerInfoProvider
            public String getHostname() {
                return AbstractConscryptSocket.this.getHostname();
            }

            @Override // org.conscrypt.PeerInfoProvider
            public String getHostnameOrIP() {
                return AbstractConscryptSocket.this.getHostnameOrIP();
            }

            @Override // org.conscrypt.PeerInfoProvider
            public int getPort() {
                return AbstractConscryptSocket.this.getPort();
            }
        };
        this.listeners = new ArrayList(2);
        this.socket = this;
        this.peerHostname = null;
        this.peerPort = -1;
        this.autoClose = false;
    }

    private boolean isDelegating() {
        Socket socket = this.socket;
        return (socket == null || socket == this) ? false : true;
    }

    @Override // javax.net.ssl.SSLSocket
    public void addHandshakeCompletedListener(HandshakeCompletedListener handshakeCompletedListener) {
        Preconditions.checkArgument(handshakeCompletedListener != null, "Provided listener is null");
        this.listeners.add(handshakeCompletedListener);
    }

    @Override // java.net.Socket
    public void bind(SocketAddress socketAddress) throws IOException {
        if (isDelegating()) {
            this.socket.bind(socketAddress);
        } else {
            super.bind(socketAddress);
        }
    }

    public final void checkOpen() throws SocketException {
        if (isClosed()) {
            throw new SocketException("Socket is closed");
        }
    }

    @Override // java.net.Socket, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (isDelegating()) {
            if (!this.autoClose || this.socket.isClosed()) {
                return;
            }
            this.socket.close();
        } else if (super.isClosed()) {
        } else {
            super.close();
        }
    }

    @Override // java.net.Socket
    public final void connect(SocketAddress socketAddress) throws IOException {
        connect(socketAddress, 0);
    }

    public abstract byte[] exportKeyingMaterial(String str, byte[] bArr, int i2) throws SSLException;

    public abstract SSLSession getActiveSession();

    @Deprecated
    public abstract byte[] getAlpnSelectedProtocol();

    @Override // javax.net.ssl.SSLSocket
    public abstract String getApplicationProtocol();

    public abstract String[] getApplicationProtocols();

    @Override // java.net.Socket
    public SocketChannel getChannel() {
        return null;
    }

    public abstract byte[] getChannelId() throws SSLException;

    public FileDescriptor getFileDescriptor$() {
        if (isDelegating()) {
            return Platform.getFileDescriptor(this.socket);
        }
        return Platform.getFileDescriptorFromSSLSocket(this);
    }

    @Override // javax.net.ssl.SSLSocket
    public abstract String getHandshakeApplicationProtocol();

    @Override // javax.net.ssl.SSLSocket
    public abstract SSLSession getHandshakeSession();

    public String getHostname() {
        return this.peerHostname;
    }

    public String getHostnameOrIP() {
        String str = this.peerHostname;
        if (str != null) {
            return str;
        }
        InetAddress inetAddress = getInetAddress();
        if (inetAddress != null) {
            return Platform.getOriginalHostNameFromInetAddress(inetAddress);
        }
        return null;
    }

    @Override // java.net.Socket
    public InetAddress getInetAddress() {
        if (isDelegating()) {
            return this.socket.getInetAddress();
        }
        return super.getInetAddress();
    }

    @Override // java.net.Socket
    public InputStream getInputStream() throws IOException {
        if (isDelegating()) {
            return this.socket.getInputStream();
        }
        return super.getInputStream();
    }

    @Override // java.net.Socket
    public boolean getKeepAlive() throws SocketException {
        if (isDelegating()) {
            return this.socket.getKeepAlive();
        }
        return super.getKeepAlive();
    }

    @Override // java.net.Socket
    public InetAddress getLocalAddress() {
        if (isDelegating()) {
            return this.socket.getLocalAddress();
        }
        return super.getLocalAddress();
    }

    @Override // java.net.Socket
    public int getLocalPort() {
        if (isDelegating()) {
            return this.socket.getLocalPort();
        }
        return super.getLocalPort();
    }

    @Override // java.net.Socket
    public SocketAddress getLocalSocketAddress() {
        if (isDelegating()) {
            return this.socket.getLocalSocketAddress();
        }
        return super.getLocalSocketAddress();
    }

    @Deprecated
    public byte[] getNpnSelectedProtocol() {
        return null;
    }

    @Override // java.net.Socket
    public boolean getOOBInline() throws SocketException {
        return false;
    }

    @Override // java.net.Socket
    public OutputStream getOutputStream() throws IOException {
        if (isDelegating()) {
            return this.socket.getOutputStream();
        }
        return super.getOutputStream();
    }

    @Override // java.net.Socket
    public final int getPort() {
        if (isDelegating()) {
            return this.socket.getPort();
        }
        int i2 = this.peerPort;
        return i2 != -1 ? i2 : super.getPort();
    }

    @Override // java.net.Socket
    public int getReceiveBufferSize() throws SocketException {
        if (isDelegating()) {
            return this.socket.getReceiveBufferSize();
        }
        return super.getReceiveBufferSize();
    }

    @Override // java.net.Socket
    public SocketAddress getRemoteSocketAddress() {
        if (isDelegating()) {
            return this.socket.getRemoteSocketAddress();
        }
        return super.getRemoteSocketAddress();
    }

    @Override // java.net.Socket
    public boolean getReuseAddress() throws SocketException {
        if (isDelegating()) {
            return this.socket.getReuseAddress();
        }
        return super.getReuseAddress();
    }

    @Override // java.net.Socket
    public int getSendBufferSize() throws SocketException {
        if (isDelegating()) {
            return this.socket.getSendBufferSize();
        }
        return super.getSendBufferSize();
    }

    @Override // java.net.Socket
    public int getSoLinger() throws SocketException {
        if (isDelegating()) {
            return this.socket.getSoLinger();
        }
        return super.getSoLinger();
    }

    @Override // java.net.Socket
    public final int getSoTimeout() throws SocketException {
        if (isDelegating()) {
            return this.socket.getSoTimeout();
        }
        return this.readTimeoutMilliseconds;
    }

    public int getSoWriteTimeout() throws SocketException {
        return 0;
    }

    @Override // java.net.Socket
    public boolean getTcpNoDelay() throws SocketException {
        if (isDelegating()) {
            return this.socket.getTcpNoDelay();
        }
        return super.getTcpNoDelay();
    }

    public abstract byte[] getTlsUnique();

    @Override // java.net.Socket
    public int getTrafficClass() throws SocketException {
        if (isDelegating()) {
            return this.socket.getTrafficClass();
        }
        return super.getTrafficClass();
    }

    @Override // java.net.Socket
    public boolean isBound() {
        if (isDelegating()) {
            return this.socket.isBound();
        }
        return super.isBound();
    }

    @Override // java.net.Socket
    public boolean isClosed() {
        if (isDelegating()) {
            return this.socket.isClosed();
        }
        return super.isClosed();
    }

    @Override // java.net.Socket
    public boolean isConnected() {
        if (isDelegating()) {
            return this.socket.isConnected();
        }
        return super.isConnected();
    }

    @Override // java.net.Socket
    public boolean isInputShutdown() {
        if (isDelegating()) {
            return this.socket.isInputShutdown();
        }
        return super.isInputShutdown();
    }

    @Override // java.net.Socket
    public boolean isOutputShutdown() {
        if (isDelegating()) {
            return this.socket.isOutputShutdown();
        }
        return super.isOutputShutdown();
    }

    public final void notifyHandshakeCompletedListeners() {
        List<HandshakeCompletedListener> list = this.listeners;
        if (list == null || list.isEmpty()) {
            return;
        }
        HandshakeCompletedEvent handshakeCompletedEvent = new HandshakeCompletedEvent(this, getActiveSession());
        for (HandshakeCompletedListener handshakeCompletedListener : this.listeners) {
            try {
                handshakeCompletedListener.handshakeCompleted(handshakeCompletedEvent);
            } catch (RuntimeException e2) {
                Thread currentThread = Thread.currentThread();
                currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, e2);
            }
        }
    }

    public final PeerInfoProvider peerInfoProvider() {
        return this.peerInfoProvider;
    }

    @Override // javax.net.ssl.SSLSocket
    public void removeHandshakeCompletedListener(HandshakeCompletedListener handshakeCompletedListener) {
        Preconditions.checkArgument(handshakeCompletedListener != null, "Provided listener is null");
        if (!this.listeners.remove(handshakeCompletedListener)) {
            throw new IllegalArgumentException("Provided listener is not registered");
        }
    }

    @Override // java.net.Socket
    public final void sendUrgentData(int i2) throws IOException {
        throw new SocketException("Method sendUrgentData() is not supported.");
    }

    @Deprecated
    public abstract void setAlpnProtocols(byte[] bArr);

    @Deprecated
    public abstract void setAlpnProtocols(String[] strArr);

    public abstract void setApplicationProtocolSelector(ApplicationProtocolSelector applicationProtocolSelector);

    public abstract void setApplicationProtocolSelector(ApplicationProtocolSelectorAdapter applicationProtocolSelectorAdapter);

    public abstract void setApplicationProtocols(String[] strArr);

    public abstract void setChannelIdEnabled(boolean z);

    public abstract void setChannelIdPrivateKey(PrivateKey privateKey);

    public void setHandshakeTimeout(int i2) throws SocketException {
        throw new SocketException("Method setHandshakeTimeout() is not supported.");
    }

    public void setHostname(String str) {
        this.peerHostname = str;
    }

    @Override // java.net.Socket
    public void setKeepAlive(boolean z) throws SocketException {
        if (isDelegating()) {
            this.socket.setKeepAlive(z);
        } else {
            super.setKeepAlive(z);
        }
    }

    @Deprecated
    public void setNpnProtocols(byte[] bArr) {
    }

    @Override // java.net.Socket
    public final void setOOBInline(boolean z) throws SocketException {
        throw new SocketException("Method setOOBInline() is not supported.");
    }

    @Override // java.net.Socket
    public void setPerformancePreferences(int i2, int i3, int i4) {
        if (isDelegating()) {
            this.socket.setPerformancePreferences(i2, i3, i4);
        } else {
            super.setPerformancePreferences(i2, i3, i4);
        }
    }

    @Override // java.net.Socket
    public void setReceiveBufferSize(int i2) throws SocketException {
        if (isDelegating()) {
            this.socket.setReceiveBufferSize(i2);
        } else {
            super.setReceiveBufferSize(i2);
        }
    }

    @Override // java.net.Socket
    public void setReuseAddress(boolean z) throws SocketException {
        if (isDelegating()) {
            this.socket.setReuseAddress(z);
        } else {
            super.setReuseAddress(z);
        }
    }

    @Override // java.net.Socket
    public void setSendBufferSize(int i2) throws SocketException {
        if (isDelegating()) {
            this.socket.setSendBufferSize(i2);
        } else {
            super.setSendBufferSize(i2);
        }
    }

    @Override // java.net.Socket
    public void setSoLinger(boolean z, int i2) throws SocketException {
        if (isDelegating()) {
            this.socket.setSoLinger(z, i2);
        } else {
            super.setSoLinger(z, i2);
        }
    }

    @Override // java.net.Socket
    public final void setSoTimeout(int i2) throws SocketException {
        if (isDelegating()) {
            this.socket.setSoTimeout(i2);
            return;
        }
        super.setSoTimeout(i2);
        this.readTimeoutMilliseconds = i2;
    }

    public void setSoWriteTimeout(int i2) throws SocketException {
        throw new SocketException("Method setSoWriteTimeout() is not supported.");
    }

    @Override // java.net.Socket
    public void setTcpNoDelay(boolean z) throws SocketException {
        if (isDelegating()) {
            this.socket.setTcpNoDelay(z);
        } else {
            super.setTcpNoDelay(z);
        }
    }

    @Override // java.net.Socket
    public void setTrafficClass(int i2) throws SocketException {
        if (isDelegating()) {
            this.socket.setTrafficClass(i2);
        } else {
            super.setTrafficClass(i2);
        }
    }

    public abstract void setUseSessionTickets(boolean z);

    @Override // java.net.Socket
    public void shutdownInput() throws IOException {
        if (isDelegating()) {
            this.socket.shutdownInput();
        } else {
            super.shutdownInput();
        }
    }

    @Override // java.net.Socket
    public void shutdownOutput() throws IOException {
        if (isDelegating()) {
            this.socket.shutdownOutput();
        } else {
            super.shutdownOutput();
        }
    }

    @Override // javax.net.ssl.SSLSocket, java.net.Socket
    public String toString() {
        StringBuilder sb = new StringBuilder("SSL socket over ");
        if (isDelegating()) {
            sb.append(this.socket.toString());
        } else {
            sb.append(super.toString());
        }
        return sb.toString();
    }

    @Override // java.net.Socket
    public final void connect(SocketAddress socketAddress, int i2) throws IOException {
        if (this.peerHostname == null && (socketAddress instanceof InetSocketAddress)) {
            this.peerHostname = Platform.getHostStringFromInetSocketAddress((InetSocketAddress) socketAddress);
        }
        if (isDelegating()) {
            this.socket.connect(socketAddress, i2);
        } else {
            super.connect(socketAddress, i2);
        }
    }

    public AbstractConscryptSocket(String str, int i2) throws IOException {
        super(str, i2);
        this.peerInfoProvider = new PeerInfoProvider() { // from class: org.conscrypt.AbstractConscryptSocket.1
            @Override // org.conscrypt.PeerInfoProvider
            public String getHostname() {
                return AbstractConscryptSocket.this.getHostname();
            }

            @Override // org.conscrypt.PeerInfoProvider
            public String getHostnameOrIP() {
                return AbstractConscryptSocket.this.getHostnameOrIP();
            }

            @Override // org.conscrypt.PeerInfoProvider
            public int getPort() {
                return AbstractConscryptSocket.this.getPort();
            }
        };
        this.listeners = new ArrayList(2);
        this.socket = this;
        this.peerHostname = str;
        this.peerPort = i2;
        this.autoClose = false;
    }

    public AbstractConscryptSocket(InetAddress inetAddress, int i2) throws IOException {
        super(inetAddress, i2);
        this.peerInfoProvider = new PeerInfoProvider() { // from class: org.conscrypt.AbstractConscryptSocket.1
            @Override // org.conscrypt.PeerInfoProvider
            public String getHostname() {
                return AbstractConscryptSocket.this.getHostname();
            }

            @Override // org.conscrypt.PeerInfoProvider
            public String getHostnameOrIP() {
                return AbstractConscryptSocket.this.getHostnameOrIP();
            }

            @Override // org.conscrypt.PeerInfoProvider
            public int getPort() {
                return AbstractConscryptSocket.this.getPort();
            }
        };
        this.listeners = new ArrayList(2);
        this.socket = this;
        this.peerHostname = null;
        this.peerPort = -1;
        this.autoClose = false;
    }

    public AbstractConscryptSocket(String str, int i2, InetAddress inetAddress, int i3) throws IOException {
        super(str, i2, inetAddress, i3);
        this.peerInfoProvider = new PeerInfoProvider() { // from class: org.conscrypt.AbstractConscryptSocket.1
            @Override // org.conscrypt.PeerInfoProvider
            public String getHostname() {
                return AbstractConscryptSocket.this.getHostname();
            }

            @Override // org.conscrypt.PeerInfoProvider
            public String getHostnameOrIP() {
                return AbstractConscryptSocket.this.getHostnameOrIP();
            }

            @Override // org.conscrypt.PeerInfoProvider
            public int getPort() {
                return AbstractConscryptSocket.this.getPort();
            }
        };
        this.listeners = new ArrayList(2);
        this.socket = this;
        this.peerHostname = str;
        this.peerPort = i2;
        this.autoClose = false;
    }

    public AbstractConscryptSocket(InetAddress inetAddress, int i2, InetAddress inetAddress2, int i3) throws IOException {
        super(inetAddress, i2, inetAddress2, i3);
        this.peerInfoProvider = new PeerInfoProvider() { // from class: org.conscrypt.AbstractConscryptSocket.1
            @Override // org.conscrypt.PeerInfoProvider
            public String getHostname() {
                return AbstractConscryptSocket.this.getHostname();
            }

            @Override // org.conscrypt.PeerInfoProvider
            public String getHostnameOrIP() {
                return AbstractConscryptSocket.this.getHostnameOrIP();
            }

            @Override // org.conscrypt.PeerInfoProvider
            public int getPort() {
                return AbstractConscryptSocket.this.getPort();
            }
        };
        this.listeners = new ArrayList(2);
        this.socket = this;
        this.peerHostname = null;
        this.peerPort = -1;
        this.autoClose = false;
    }

    public AbstractConscryptSocket(Socket socket, String str, int i2, boolean z) throws IOException {
        this.peerInfoProvider = new PeerInfoProvider() { // from class: org.conscrypt.AbstractConscryptSocket.1
            @Override // org.conscrypt.PeerInfoProvider
            public String getHostname() {
                return AbstractConscryptSocket.this.getHostname();
            }

            @Override // org.conscrypt.PeerInfoProvider
            public String getHostnameOrIP() {
                return AbstractConscryptSocket.this.getHostnameOrIP();
            }

            @Override // org.conscrypt.PeerInfoProvider
            public int getPort() {
                return AbstractConscryptSocket.this.getPort();
            }
        };
        this.listeners = new ArrayList(2);
        this.socket = (Socket) Preconditions.checkNotNull(socket, "socket");
        this.peerHostname = str;
        this.peerPort = i2;
        this.autoClose = z;
    }
}
