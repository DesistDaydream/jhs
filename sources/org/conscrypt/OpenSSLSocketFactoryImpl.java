package org.conscrypt;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.security.KeyManagementException;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: classes4.dex */
public final class OpenSSLSocketFactoryImpl extends SSLSocketFactory {
    private static boolean useEngineSocketByDefault = SSLUtils.USE_ENGINE_SOCKET_BY_DEFAULT;
    private final IOException instantiationException;
    private final SSLParametersImpl sslParameters;
    private boolean useEngineSocket;

    public OpenSSLSocketFactoryImpl() {
        IOException iOException;
        this.useEngineSocket = useEngineSocketByDefault;
        SSLParametersImpl sSLParametersImpl = null;
        try {
            iOException = null;
            sSLParametersImpl = SSLParametersImpl.getDefault();
        } catch (KeyManagementException e2) {
            iOException = new IOException("Delayed instantiation exception:", e2);
        }
        this.sslParameters = sSLParametersImpl;
        this.instantiationException = iOException;
    }

    private boolean hasFileDescriptor(Socket socket) {
        try {
            Platform.getFileDescriptor(socket);
            return true;
        } catch (RuntimeException unused) {
            return false;
        }
    }

    public static void setUseEngineSocketByDefault(boolean z) {
        useEngineSocketByDefault = z;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket() throws IOException {
        IOException iOException = this.instantiationException;
        if (iOException == null) {
            if (this.useEngineSocket) {
                return Platform.createEngineSocket((SSLParametersImpl) this.sslParameters.clone());
            }
            return Platform.createFileDescriptorSocket((SSLParametersImpl) this.sslParameters.clone());
        }
        throw iOException;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        return this.sslParameters.getEnabledCipherSuites();
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        return NativeCrypto.getSupportedCipherSuites();
    }

    public void setUseEngineSocket(boolean z) {
        this.useEngineSocket = z;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i2) throws IOException, UnknownHostException {
        if (this.useEngineSocket) {
            return Platform.createEngineSocket(str, i2, (SSLParametersImpl) this.sslParameters.clone());
        }
        return Platform.createFileDescriptorSocket(str, i2, (SSLParametersImpl) this.sslParameters.clone());
    }

    public OpenSSLSocketFactoryImpl(SSLParametersImpl sSLParametersImpl) {
        this.useEngineSocket = useEngineSocketByDefault;
        this.sslParameters = sSLParametersImpl;
        this.instantiationException = null;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i2, InetAddress inetAddress, int i3) throws IOException, UnknownHostException {
        if (this.useEngineSocket) {
            return Platform.createEngineSocket(str, i2, inetAddress, i3, (SSLParametersImpl) this.sslParameters.clone());
        }
        return Platform.createFileDescriptorSocket(str, i2, inetAddress, i3, (SSLParametersImpl) this.sslParameters.clone());
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i2) throws IOException {
        if (this.useEngineSocket) {
            return Platform.createEngineSocket(inetAddress, i2, (SSLParametersImpl) this.sslParameters.clone());
        }
        return Platform.createFileDescriptorSocket(inetAddress, i2, (SSLParametersImpl) this.sslParameters.clone());
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i2, InetAddress inetAddress2, int i3) throws IOException {
        if (this.useEngineSocket) {
            return Platform.createEngineSocket(inetAddress, i2, inetAddress2, i3, (SSLParametersImpl) this.sslParameters.clone());
        }
        return Platform.createFileDescriptorSocket(inetAddress, i2, inetAddress2, i3, (SSLParametersImpl) this.sslParameters.clone());
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(Socket socket, String str, int i2, boolean z) throws IOException {
        Preconditions.checkNotNull(socket, "socket");
        if (socket.isConnected()) {
            if (!this.useEngineSocket && hasFileDescriptor(socket)) {
                return Platform.createFileDescriptorSocket(socket, str, i2, z, (SSLParametersImpl) this.sslParameters.clone());
            }
            return Platform.createEngineSocket(socket, str, i2, z, (SSLParametersImpl) this.sslParameters.clone());
        }
        throw new SocketException("Socket is not connected.");
    }
}
