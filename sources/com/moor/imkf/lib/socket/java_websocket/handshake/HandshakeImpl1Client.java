package com.moor.imkf.lib.socket.java_websocket.handshake;

/* loaded from: classes2.dex */
public class HandshakeImpl1Client extends HandshakedataImpl1 implements ClientHandshakeBuilder {
    private String resourceDescriptor = "*";

    @Override // com.moor.imkf.lib.socket.java_websocket.handshake.ClientHandshake
    public String getResourceDescriptor() {
        return this.resourceDescriptor;
    }

    @Override // com.moor.imkf.lib.socket.java_websocket.handshake.ClientHandshakeBuilder
    public void setResourceDescriptor(String str) {
        if (str != null) {
            this.resourceDescriptor = str;
            return;
        }
        throw new IllegalArgumentException("http resource descriptor must not be null");
    }
}
