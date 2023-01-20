package com.moor.imkf.lib.http.request;

import java.util.Map;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class MoorPostFormRequest extends MoorHttpRequest {
    public MoorPostFormRequest(String str, Object obj, Map<String, Object> map, int i2, Request.Builder builder) {
        super(str, obj, map, i2, builder);
    }

    private void addParams(FormBody.Builder builder) {
        Map<String, Object> map = this.params;
        if (map != null) {
            for (String str : map.keySet()) {
                builder.add(str, this.params.get(str) + "");
            }
        }
    }

    @Override // com.moor.imkf.lib.http.request.MoorHttpRequest
    public Request buildRequest(RequestBody requestBody) {
        return this.builder.post(requestBody).build();
    }

    @Override // com.moor.imkf.lib.http.request.MoorHttpRequest
    public RequestBody buildRequestBody() {
        FormBody.Builder builder = new FormBody.Builder();
        if (this.params != null) {
            return RequestBody.create(MediaType.parse("application/json; charset=utf-8"), new JSONObject(this.params).toString());
        }
        return builder.build();
    }
}
