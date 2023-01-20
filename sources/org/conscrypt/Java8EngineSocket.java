package org.conscrypt;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.List;
import java.util.function.BiFunction;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLSocket;

/* loaded from: classes4.dex */
public final class Java8EngineSocket extends ConscryptEngineSocket {
    private BiFunction<SSLSocket, List<String>, String> selector;

    public Java8EngineSocket(SSLParametersImpl sSLParametersImpl) throws IOException {
        super(sSLParametersImpl);
    }

    private static ApplicationProtocolSelector toApplicationProtocolSelector(final BiFunction<SSLSocket, List<String>, String> biFunction) {
        if (biFunction == null) {
            return null;
        }
        return new ApplicationProtocolSelector() { // from class: org.conscrypt.Java8EngineSocket.1
            @Override // org.conscrypt.ApplicationProtocolSelector
            public String selectApplicationProtocol(SSLEngine sSLEngine, List<String> list) {
                throw new UnsupportedOperationException();
            }

            @Override // org.conscrypt.ApplicationProtocolSelector
            public String selectApplicationProtocol(SSLSocket sSLSocket, List<String> list) {
                return (String) biFunction.apply(sSLSocket, list);
            }
        };
    }

    @Override // javax.net.ssl.SSLSocket
    public BiFunction<SSLSocket, List<String>, String> getHandshakeApplicationProtocolSelector() {
        return this.selector;
    }

    @Override // javax.net.ssl.SSLSocket
    public void setHandshakeApplicationProtocolSelector(BiFunction<SSLSocket, List<String>, String> biFunction) {
        this.selector = biFunction;
        setApplicationProtocolSelector(toApplicationProtocolSelector(biFunction));
    }

    public Java8EngineSocket(String str, int i2, SSLParametersImpl sSLParametersImpl) throws IOException {
        super(str, i2, sSLParametersImpl);
    }

    public Java8EngineSocket(InetAddress inetAddress, int i2, SSLParametersImpl sSLParametersImpl) throws IOException {
        super(inetAddress, i2, sSLParametersImpl);
    }

    public Java8EngineSocket(String str, int i2, InetAddress inetAddress, int i3, SSLParametersImpl sSLParametersImpl) throws IOException {
        super(str, i2, inetAddress, i3, sSLParametersImpl);
    }

    public Java8EngineSocket(InetAddress inetAddress, int i2, InetAddress inetAddress2, int i3, SSLParametersImpl sSLParametersImpl) throws IOException {
        super(inetAddress, i2, inetAddress2, i3, sSLParametersImpl);
    }

    public Java8EngineSocket(Socket socket, String str, int i2, boolean z, SSLParametersImpl sSLParametersImpl) throws IOException {
        super(socket, str, i2, z, sSLParametersImpl);
    }
}
