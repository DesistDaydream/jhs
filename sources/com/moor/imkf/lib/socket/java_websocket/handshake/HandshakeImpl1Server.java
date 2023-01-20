package com.moor.imkf.lib.socket.java_websocket.handshake;

/* loaded from: classes2.dex */
public class HandshakeImpl1Server extends HandshakedataImpl1 implements ServerHandshakeBuilder {
    private short httpstatus;
    private String httpstatusmessage;

    @Override // com.moor.imkf.lib.socket.java_websocket.handshake.ServerHandshake
    public short getHttpStatus() {
        return this.httpstatus;
    }

    @Override // com.moor.imkf.lib.socket.java_websocket.handshake.ServerHandshake
    public String getHttpStatusMessage() {
        return this.httpstatusmessage;
    }

    @Override // com.moor.imkf.lib.socket.java_websocket.handshake.ServerHandshakeBuilder
    public void setHttpStatus(short s) {
        this.httpstatus = s;
    }

    @Override // com.moor.imkf.lib.socket.java_websocket.handshake.ServerHandshakeBuilder
    public void setHttpStatusMessage(String str) {
        this.httpstatusmessage = str;
    }
}
