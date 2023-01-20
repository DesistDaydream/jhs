package com.tencent.android.tpns.mqtt.internal.websocket;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;

/* loaded from: classes3.dex */
public class ExtendedByteArrayOutputStream extends ByteArrayOutputStream {
    public final WebSocketNetworkModule webSocketNetworkModule;
    public final WebSocketSecureNetworkModule webSocketSecureNetworkModule;

    public ExtendedByteArrayOutputStream(WebSocketNetworkModule webSocketNetworkModule) {
        this.webSocketNetworkModule = webSocketNetworkModule;
        this.webSocketSecureNetworkModule = null;
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        ByteBuffer wrap;
        synchronized (this) {
            wrap = ByteBuffer.wrap(toByteArray());
            reset();
        }
        byte[] encodeFrame = new WebSocketFrame((byte) 2, true, wrap.array()).encodeFrame();
        OutputStream socketOutputStream = getSocketOutputStream();
        if (socketOutputStream != null) {
            socketOutputStream.write(encodeFrame);
            socketOutputStream.flush();
        }
    }

    public OutputStream getSocketOutputStream() throws IOException {
        WebSocketNetworkModule webSocketNetworkModule = this.webSocketNetworkModule;
        if (webSocketNetworkModule != null) {
            return webSocketNetworkModule.getSocketOutputStream();
        }
        WebSocketSecureNetworkModule webSocketSecureNetworkModule = this.webSocketSecureNetworkModule;
        if (webSocketSecureNetworkModule != null) {
            return webSocketSecureNetworkModule.getSocketOutputStream();
        }
        return null;
    }

    public ExtendedByteArrayOutputStream(WebSocketSecureNetworkModule webSocketSecureNetworkModule) {
        this.webSocketNetworkModule = null;
        this.webSocketSecureNetworkModule = webSocketSecureNetworkModule;
    }
}
