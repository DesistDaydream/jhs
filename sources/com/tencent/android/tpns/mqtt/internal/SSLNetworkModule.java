package com.tencent.android.tpns.mqtt.internal;

import com.tencent.android.tpns.mqtt.MqttException;
import com.tencent.android.tpns.mqtt.logging.Logger;
import com.tencent.android.tpns.mqtt.logging.LoggerFactory;
import com.xiaomi.mipush.sdk.Constants;
import java.io.IOException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: classes3.dex */
public class SSLNetworkModule extends TCPNetworkModule {
    private static final String CLASS_NAME = "SSLNetworkModule";
    private static final Logger log = LoggerFactory.getLogger(LoggerFactory.MQTT_CLIENT_MSG_CAT, CLASS_NAME);
    private String[] enabledCiphers;
    private int handshakeTimeoutSecs;
    private String host;
    private HostnameVerifier hostnameVerifier;
    private int port;

    public SSLNetworkModule(SSLSocketFactory sSLSocketFactory, String str, int i2, String str2) {
        super(sSLSocketFactory, str, i2, str2);
        this.host = str;
        this.port = i2;
        log.setResourceName(str2);
    }

    public String[] getEnabledCiphers() {
        return this.enabledCiphers;
    }

    public HostnameVerifier getSSLHostnameVerifier() {
        return this.hostnameVerifier;
    }

    @Override // com.tencent.android.tpns.mqtt.internal.TCPNetworkModule, com.tencent.android.tpns.mqtt.internal.NetworkModule
    public String getServerURI() {
        return "ssl://" + this.host + Constants.COLON_SEPARATOR + this.port;
    }

    public void setEnabledCiphers(String[] strArr) {
        this.enabledCiphers = strArr;
        if (this.socket == null || strArr == null) {
            return;
        }
        if (log.isLoggable(5)) {
            String str = "";
            for (int i2 = 0; i2 < strArr.length; i2++) {
                if (i2 > 0) {
                    str = str + Constants.ACCEPT_TIME_SEPARATOR_SP;
                }
                str = str + strArr[i2];
            }
            log.fine(CLASS_NAME, "setEnabledCiphers", "260", new Object[]{str});
        }
        ((SSLSocket) this.socket).setEnabledCipherSuites(strArr);
    }

    public void setSSLHostnameVerifier(HostnameVerifier hostnameVerifier) {
        this.hostnameVerifier = hostnameVerifier;
    }

    public void setSSLhandshakeTimeout(int i2) {
        super.setConnectTimeout(i2);
        this.handshakeTimeoutSecs = i2;
    }

    @Override // com.tencent.android.tpns.mqtt.internal.TCPNetworkModule, com.tencent.android.tpns.mqtt.internal.NetworkModule
    public void start() throws IOException, MqttException {
        super.start();
        setEnabledCiphers(this.enabledCiphers);
        int soTimeout = this.socket.getSoTimeout();
        this.socket.setSoTimeout(this.handshakeTimeoutSecs * 1000);
        ((SSLSocket) this.socket).startHandshake();
        if (this.hostnameVerifier != null) {
            this.hostnameVerifier.verify(this.host, ((SSLSocket) this.socket).getSession());
        }
        this.socket.setSoTimeout(soTimeout);
    }
}
