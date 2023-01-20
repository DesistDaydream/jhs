package com.moor.imkf.lib.http.request;

import java.util.Map;
import okhttp3.Request;
import okhttp3.RequestBody;

/* loaded from: classes2.dex */
public class MoorGetRequest extends MoorHttpRequest {
    public MoorGetRequest(String str, Object obj, Map<String, Object> map, int i2, Request.Builder builder) {
        super(str, obj, map, i2, builder);
    }

    @Override // com.moor.imkf.lib.http.request.MoorHttpRequest
    public Request buildRequest(RequestBody requestBody) {
        return this.builder.get().build();
    }

    @Override // com.moor.imkf.lib.http.request.MoorHttpRequest
    public RequestBody buildRequestBody() {
        return null;
    }
}
