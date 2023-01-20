package com.tencent.android.tpns.mqtt.internal.websocket;

import com.jihuanshe.model.NetCode;
import com.tencent.android.tpns.mqtt.MqttException;
import com.tencent.android.tpns.mqtt.internal.TCPNetworkModule;
import com.tencent.android.tpns.mqtt.logging.Logger;
import com.tencent.android.tpns.mqtt.logging.LoggerFactory;
import com.xiaomi.mipush.sdk.Constants;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.nio.ByteBuffer;
import javax.net.SocketFactory;

/* loaded from: classes3.dex */
public class WebSocketNetworkModule extends TCPNetworkModule {
    private static final String CLASS_NAME = "WebSocketNetworkModule";
    private static final Logger log = LoggerFactory.getLogger(LoggerFactory.MQTT_CLIENT_MSG_CAT, CLASS_NAME);
    private String host;
    private ByteArrayOutputStream outputStream;
    private PipedInputStream pipedInputStream;
    private int port;
    public ByteBuffer recievedPayload;
    private String uri;
    private WebSocketReceiver webSocketReceiver;

    public WebSocketNetworkModule(SocketFactory socketFactory, String str, String str2, int i2, String str3) {
        super(socketFactory, str2, i2, str3);
        this.outputStream = new ExtendedByteArrayOutputStream(this);
        this.uri = str;
        this.host = str2;
        this.port = i2;
        this.pipedInputStream = new PipedInputStream();
        log.setResourceName(str3);
    }

    @Override // com.tencent.android.tpns.mqtt.internal.TCPNetworkModule, com.tencent.android.tpns.mqtt.internal.NetworkModule
    public InputStream getInputStream() throws IOException {
        return this.pipedInputStream;
    }

    @Override // com.tencent.android.tpns.mqtt.internal.TCPNetworkModule, com.tencent.android.tpns.mqtt.internal.NetworkModule
    public OutputStream getOutputStream() throws IOException {
        return this.outputStream;
    }

    @Override // com.tencent.android.tpns.mqtt.internal.TCPNetworkModule, com.tencent.android.tpns.mqtt.internal.NetworkModule
    public String getServerURI() {
        return "ws://" + this.host + Constants.COLON_SEPARATOR + this.port;
    }

    public InputStream getSocketInputStream() throws IOException {
        return super.getInputStream();
    }

    public OutputStream getSocketOutputStream() throws IOException {
        return super.getOutputStream();
    }

    @Override // com.tencent.android.tpns.mqtt.internal.TCPNetworkModule, com.tencent.android.tpns.mqtt.internal.NetworkModule
    public void start() throws IOException, MqttException {
        super.start();
        new WebSocketHandshake(getSocketInputStream(), getSocketOutputStream(), this.uri, this.host, this.port).execute();
        WebSocketReceiver webSocketReceiver = new WebSocketReceiver(getSocketInputStream(), this.pipedInputStream);
        this.webSocketReceiver = webSocketReceiver;
        webSocketReceiver.start("webSocketReceiver");
    }

    @Override // com.tencent.android.tpns.mqtt.internal.TCPNetworkModule, com.tencent.android.tpns.mqtt.internal.NetworkModule
    public void stop() throws IOException {
        getSocketOutputStream().write(new WebSocketFrame((byte) 8, true, NetCode.CODE_NO_ENOUGH_COIN.getBytes()).encodeFrame());
        getSocketOutputStream().flush();
        WebSocketReceiver webSocketReceiver = this.webSocketReceiver;
        if (webSocketReceiver != null) {
            webSocketReceiver.stop();
        }
        super.stop();
    }
}
