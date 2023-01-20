package com.tencent.tpns.baseapi.core.net;

import android.os.Build;
import java.net.InetAddress;
import java.net.Socket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import org.conscrypt.NativeCrypto;

/* loaded from: classes3.dex */
public class TlsCompatSocketFactory extends SSLSocketFactory {
    private static final String TAG = "TlsCompatSocketFactory";
    private static final String[] TLS_VERSION_LIST_FOR_API_LEVEL_UNDER_20 = {NativeCrypto.OBSOLETE_PROTOCOL_SSLV3, "TLSv1", "TLSv1.1", "TLSv1.2"};
    public final SSLSocketFactory target;

    public TlsCompatSocketFactory(SSLSocketFactory sSLSocketFactory) {
        this.target = sSLSocketFactory;
    }

    private Socket supportTLS(Socket socket) {
        if ((socket instanceof SSLSocket) && Build.VERSION.SDK_INT < 20) {
            ((SSLSocket) socket).setEnabledProtocols(TLS_VERSION_LIST_FOR_API_LEVEL_UNDER_20);
        }
        return socket;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(Socket socket, String str, int i2, boolean z) {
        return supportTLS(this.target.createSocket(socket, str, i2, z));
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        return this.target.getDefaultCipherSuites();
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        return this.target.getSupportedCipherSuites();
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i2) {
        return supportTLS(this.target.createSocket(str, i2));
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i2, InetAddress inetAddress, int i3) {
        return supportTLS(this.target.createSocket(str, i2, inetAddress, i3));
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i2) {
        return supportTLS(this.target.createSocket(inetAddress, i2));
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i2, InetAddress inetAddress2, int i3) {
        return supportTLS(this.target.createSocket(inetAddress, i2, inetAddress2, i3));
    }
}
