package com.moor.imkf.lib.socket.websocket.response;

import android.text.TextUtils;
import com.moor.imkf.lib.socket.websocket.dispatcher.IResponseDispatcher;
import com.moor.imkf.lib.socket.websocket.dispatcher.ResponseDelivery;

/* loaded from: classes2.dex */
public class TextResponse implements Response<String> {
    private String responseText;

    @Override // com.moor.imkf.lib.socket.websocket.response.Response
    public void onResponse(IResponseDispatcher iResponseDispatcher, ResponseDelivery responseDelivery) {
        iResponseDispatcher.onMessage(this.responseText, responseDelivery);
        release();
    }

    @Override // com.moor.imkf.lib.socket.websocket.response.Response
    public void release() {
        ResponseFactory.releaseTextResponse(this);
    }

    public String toString() {
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(hashCode());
        objArr[1] = TextUtils.isEmpty(this.responseText) ? "null" : this.responseText;
        return String.format("[@TextResponse%s->responseText:%s]", objArr);
    }

    @Override // com.moor.imkf.lib.socket.websocket.response.Response
    public String getResponseData() {
        return this.responseText;
    }

    @Override // com.moor.imkf.lib.socket.websocket.response.Response
    public void setResponseData(String str) {
        this.responseText = str;
    }
}
