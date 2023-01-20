package com.moor.imkf.lib.socket.websocket.response;

import com.moor.imkf.lib.socket.java_websocket.framing.Framedata;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.Queue;

/* loaded from: classes2.dex */
public class ResponseFactory {
    private static final int POOL_SIZE = 7;
    private static Queue<ErrorResponse> ERROR_RESPONSE_POOL = new ArrayDeque(7);
    private static Queue<TextResponse> TEXT_RESPONSE_POOL = new ArrayDeque(7);
    private static Queue<ByteBufferResponse> BYTE_BUFFER_RESPONSE_POOL = new ArrayDeque(7);
    private static Queue<PingResponse> PING_RESPONSE_POOL = new ArrayDeque(7);
    private static Queue<PongResponse> PONG_RESPONSE_POOL = new ArrayDeque(7);

    public static Response<ByteBuffer> createByteBufferResponse() {
        ByteBufferResponse poll = BYTE_BUFFER_RESPONSE_POOL.poll();
        return poll == null ? new ByteBufferResponse() : poll;
    }

    public static ErrorResponse createErrorResponse() {
        ErrorResponse poll = ERROR_RESPONSE_POOL.poll();
        return poll == null ? new ErrorResponse() : poll;
    }

    public static Response<Framedata> createPingResponse() {
        PingResponse poll = PING_RESPONSE_POOL.poll();
        return poll == null ? new PingResponse() : poll;
    }

    public static Response<Framedata> createPongResponse() {
        PongResponse poll = PONG_RESPONSE_POOL.poll();
        return poll == null ? new PongResponse() : poll;
    }

    public static Response<String> createTextResponse() {
        TextResponse poll = TEXT_RESPONSE_POOL.poll();
        return poll == null ? new TextResponse() : poll;
    }

    public static void releaseByteBufferResponse(ByteBufferResponse byteBufferResponse) {
        BYTE_BUFFER_RESPONSE_POOL.offer(byteBufferResponse);
    }

    public static void releaseErrorResponse(ErrorResponse errorResponse) {
        ERROR_RESPONSE_POOL.offer(errorResponse);
    }

    public static void releasePingResponse(PingResponse pingResponse) {
        PING_RESPONSE_POOL.offer(pingResponse);
    }

    public static void releasePongResponse(PongResponse pongResponse) {
        PONG_RESPONSE_POOL.offer(pongResponse);
    }

    public static void releaseTextResponse(TextResponse textResponse) {
        TEXT_RESPONSE_POOL.offer(textResponse);
    }
}
