package com.tencent.android.tpns.mqtt.internal;

import com.tencent.android.tpns.mqtt.MqttException;
import com.tencent.android.tpns.mqtt.logging.Logger;
import com.tencent.android.tpns.mqtt.logging.LoggerFactory;
import com.tencent.android.tpush.common.MessageKey;
import com.xiaomi.mipush.sdk.Constants;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.Socket;
import javax.net.SocketFactory;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: classes3.dex */
public class TCPNetworkModule implements NetworkModule {
    private static final String CLASS_NAME = "TCPNetworkModule";
    private static final Logger log = LoggerFactory.getLogger(LoggerFactory.MQTT_CLIENT_MSG_CAT, CLASS_NAME);
    private int conTimeout;
    private SocketFactory factory;
    private String host;
    private int port;
    public Socket socket;
    public Socket tempsocket;

    public TCPNetworkModule(SocketFactory socketFactory, String str, int i2, String str2) {
        log.setResourceName(str2);
        this.factory = socketFactory;
        this.host = str;
        this.port = i2;
    }

    @Override // com.tencent.android.tpns.mqtt.internal.NetworkModule
    public InputStream getInputStream() throws IOException {
        return this.socket.getInputStream();
    }

    @Override // com.tencent.android.tpns.mqtt.internal.NetworkModule
    public OutputStream getOutputStream() throws IOException {
        return this.socket.getOutputStream();
    }

    @Override // com.tencent.android.tpns.mqtt.internal.NetworkModule
    public String getServerURI() {
        return "tcp://" + this.host + Constants.COLON_SEPARATOR + this.port;
    }

    public void setConnectTimeout(int i2) {
        this.conTimeout = i2;
    }

    @Override // com.tencent.android.tpns.mqtt.internal.NetworkModule
    public void start() throws IOException, MqttException {
        try {
            InetSocketAddress inetSocketAddress = new InetSocketAddress(this.host, this.port);
            SocketFactory socketFactory = this.factory;
            if (socketFactory instanceof SSLSocketFactory) {
                Socket socket = new Socket();
                this.tempsocket = socket;
                socket.connect(inetSocketAddress, this.conTimeout * 1000);
                this.socket = ((SSLSocketFactory) this.factory).createSocket(this.tempsocket, this.host, this.port, true);
                return;
            }
            Socket createSocket = socketFactory.createSocket();
            this.socket = createSocket;
            createSocket.connect(inetSocketAddress, this.conTimeout * 1000);
        } catch (ConnectException e2) {
            log.fine(CLASS_NAME, MessageKey.MSG_ACCEPT_TIME_START, "250", null, e2);
            throw new MqttException(32103, e2);
        }
    }

    @Override // com.tencent.android.tpns.mqtt.internal.NetworkModule
    public void stop() throws IOException {
        Socket socket = this.socket;
        if (socket != null) {
            socket.shutdownInput();
            this.socket.close();
        }
        Socket socket2 = this.tempsocket;
        if (socket2 != null) {
            try {
                socket2.shutdownInput();
                this.tempsocket.close();
            } catch (Throwable unused) {
            }
        }
    }
}
