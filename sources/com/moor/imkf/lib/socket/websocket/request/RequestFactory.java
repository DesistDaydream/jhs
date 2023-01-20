package com.moor.imkf.lib.socket.websocket.request;

import com.moor.imkf.lib.socket.java_websocket.framing.Framedata;
import com.moor.imkf.lib.socket.java_websocket.framing.PingFrame;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Queue;

/* loaded from: classes2.dex */
public class RequestFactory {
    private static final int POLL_SIZE = 7;
    private static Queue<ByteArrayRequest> BYTE_ARRAY_REQUEST_POOL = new ArrayDeque(7);
    private static Queue<ByteBufferRequest> BYTE_BUFFER_REQUEST_POOL = new ArrayDeque(7);
    private static Queue<StringRequest> STRING_REQUEST_POOL = new ArrayDeque(7);
    private static Queue<PingRequest> PING_REQUEST_POOL = new ArrayDeque(7);
    private static Queue<PongRequest> PONG_REQUEST_POOL = new ArrayDeque(7);
    private static Queue<FrameDataRequest> FRAME_DATA_REQUEST_POOL = new ArrayDeque(7);
    private static Queue<CollectionFrameDataRequest> COLLECTION_FRAME_REQUEST_POOL = new ArrayDeque(7);

    public static Request<byte[]> createByteArrayRequest() {
        ByteArrayRequest poll = BYTE_ARRAY_REQUEST_POOL.poll();
        return poll == null ? new ByteArrayRequest() : poll;
    }

    public static Request<ByteBuffer> createByteBufferRequest() {
        ByteBufferRequest poll = BYTE_BUFFER_REQUEST_POOL.poll();
        return poll == null ? new ByteBufferRequest() : poll;
    }

    public static Request<Collection<Framedata>> createCollectionFrameRequest() {
        CollectionFrameDataRequest poll = COLLECTION_FRAME_REQUEST_POOL.poll();
        return poll == null ? new CollectionFrameDataRequest() : poll;
    }

    public static Request<Framedata> createFrameDataRequest() {
        FrameDataRequest poll = FRAME_DATA_REQUEST_POOL.poll();
        return poll == null ? new FrameDataRequest() : poll;
    }

    public static Request createPingRequest() {
        PingRequest poll = PING_REQUEST_POOL.poll();
        return poll == null ? new PingRequest() : poll;
    }

    public static Request<PingFrame> createPongRequest() {
        PongRequest poll = PONG_REQUEST_POOL.poll();
        return poll == null ? new PongRequest() : poll;
    }

    public static Request<String> createStringRequest() {
        StringRequest poll = STRING_REQUEST_POOL.poll();
        return poll == null ? new StringRequest() : poll;
    }

    public static void releaseByteArrayRequest(ByteArrayRequest byteArrayRequest) {
        BYTE_ARRAY_REQUEST_POOL.offer(byteArrayRequest);
    }

    public static void releaseByteBufferRequest(ByteBufferRequest byteBufferRequest) {
        BYTE_BUFFER_REQUEST_POOL.offer(byteBufferRequest);
    }

    public static void releaseCollectionFrameRequest(CollectionFrameDataRequest collectionFrameDataRequest) {
        COLLECTION_FRAME_REQUEST_POOL.offer(collectionFrameDataRequest);
    }

    public static void releaseFrameDataRequest(FrameDataRequest frameDataRequest) {
        FRAME_DATA_REQUEST_POOL.offer(frameDataRequest);
    }

    public static void releasePingRequest(PingRequest pingRequest) {
        PING_REQUEST_POOL.offer(pingRequest);
    }

    public static void releasePongRequest(PongRequest pongRequest) {
        PONG_REQUEST_POOL.offer(pongRequest);
    }

    public static void releaseStringRequest(StringRequest stringRequest) {
        STRING_REQUEST_POOL.offer(stringRequest);
    }
}
