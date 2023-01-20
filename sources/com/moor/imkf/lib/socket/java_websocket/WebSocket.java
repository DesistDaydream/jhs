package com.moor.imkf.lib.socket.java_websocket;

import com.moor.imkf.lib.socket.java_websocket.drafts.Draft;
import com.moor.imkf.lib.socket.java_websocket.enums.Opcode;
import com.moor.imkf.lib.socket.java_websocket.enums.ReadyState;
import com.moor.imkf.lib.socket.java_websocket.framing.Framedata;
import com.moor.imkf.lib.socket.java_websocket.protocols.IProtocol;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.util.Collection;
import javax.net.ssl.SSLSession;

/* loaded from: classes2.dex */
public interface WebSocket {
    void close();

    void close(int i2);

    void close(int i2, String str);

    void closeConnection(int i2, String str);

    <T> T getAttachment();

    Draft getDraft();

    InetSocketAddress getLocalSocketAddress();

    IProtocol getProtocol();

    ReadyState getReadyState();

    InetSocketAddress getRemoteSocketAddress();

    String getResourceDescriptor();

    SSLSession getSSLSession() throws IllegalArgumentException;

    boolean hasBufferedData();

    boolean hasSSLSupport();

    boolean isClosed();

    boolean isClosing();

    boolean isFlushAndClose();

    boolean isOpen();

    void send(String str);

    void send(ByteBuffer byteBuffer);

    void send(byte[] bArr);

    void sendFragmentedFrame(Opcode opcode, ByteBuffer byteBuffer, boolean z);

    void sendFrame(Framedata framedata);

    void sendFrame(Collection<Framedata> collection);

    void sendPing();

    <T> void setAttachment(T t);
}
