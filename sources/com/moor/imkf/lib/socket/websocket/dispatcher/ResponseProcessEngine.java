package com.moor.imkf.lib.socket.websocket.dispatcher;

import com.moor.imkf.lib.socket.websocket.response.ErrorResponse;
import com.moor.imkf.lib.socket.websocket.response.Response;
import java.util.ArrayDeque;
import java.util.Queue;

/* loaded from: classes2.dex */
public class ResponseProcessEngine {
    private EngineThread mThread;

    /* loaded from: classes2.dex */
    public static class EngineEntity {
        private static Queue<EngineEntity> ENTITY_POOL = new ArrayDeque(10);
        public ResponseDelivery delivery;
        public IResponseDispatcher dispatcher;
        public ErrorResponse errorResponse;
        public boolean isError;
        public Response response;

        public static EngineEntity obtain() {
            EngineEntity poll = ENTITY_POOL.poll();
            return poll == null ? new EngineEntity() : poll;
        }

        public static void release(EngineEntity engineEntity) {
            ENTITY_POOL.offer(engineEntity);
        }
    }

    public ResponseProcessEngine() {
        EngineThread engineThread = new EngineThread();
        this.mThread = engineThread;
        engineThread.start();
    }

    public void onMessageReceive(Response response, IResponseDispatcher iResponseDispatcher, ResponseDelivery responseDelivery) {
        if (response == null || iResponseDispatcher == null || responseDelivery == null) {
            return;
        }
        EngineEntity obtain = EngineEntity.obtain();
        obtain.dispatcher = iResponseDispatcher;
        obtain.delivery = responseDelivery;
        obtain.isError = false;
        obtain.response = response;
        obtain.errorResponse = null;
        this.mThread.add(obtain);
    }

    public void onSendDataError(ErrorResponse errorResponse, IResponseDispatcher iResponseDispatcher, ResponseDelivery responseDelivery) {
        if (errorResponse == null || iResponseDispatcher == null || responseDelivery == null) {
            return;
        }
        EngineEntity obtain = EngineEntity.obtain();
        obtain.dispatcher = iResponseDispatcher;
        obtain.delivery = responseDelivery;
        obtain.isError = true;
        obtain.errorResponse = errorResponse;
        obtain.response = null;
        this.mThread.add(obtain);
    }
}
