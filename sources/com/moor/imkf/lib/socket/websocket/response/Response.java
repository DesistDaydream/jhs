package com.moor.imkf.lib.socket.websocket.response;

import com.moor.imkf.lib.socket.websocket.dispatcher.IResponseDispatcher;
import com.moor.imkf.lib.socket.websocket.dispatcher.ResponseDelivery;

/* loaded from: classes2.dex */
public interface Response<T> {
    T getResponseData();

    void onResponse(IResponseDispatcher iResponseDispatcher, ResponseDelivery responseDelivery);

    void release();

    void setResponseData(T t);
}
