package com.moor.imkf.lib.http.request;

import com.moor.imkf.lib.http.callback.MoorCallback;
import com.moor.imkf.lib.http.utils.MoorExceptions;
import java.util.Map;
import okhttp3.Request;
import okhttp3.RequestBody;

/* loaded from: classes2.dex */
public abstract class MoorHttpRequest {
    public Request.Builder builder;
    public int id;
    public Map<String, Object> params;
    public Object tag;
    public String url;

    public MoorHttpRequest(String str, Object obj, Map<String, Object> map, int i2, Request.Builder builder) {
        this.url = str;
        this.tag = obj;
        this.params = map;
        this.id = i2;
        this.builder = builder;
        if (str == null) {
            MoorExceptions.illegalArgument("url can not be null.", new Object[0]);
        }
        initBuilder();
    }

    private void initBuilder() {
        if (this.builder == null) {
            this.builder = new Request.Builder();
        }
        this.builder.url(this.url).tag(this.tag);
    }

    public MoorRequestCall build() {
        return new MoorRequestCall(this);
    }

    public abstract Request buildRequest(RequestBody requestBody);

    public abstract RequestBody buildRequestBody();

    public Request generateRequest(MoorCallback moorCallback) {
        return buildRequest(wrapRequestBody(buildRequestBody(), moorCallback));
    }

    public int getId() {
        return this.id;
    }

    public RequestBody wrapRequestBody(RequestBody requestBody, MoorCallback moorCallback) {
        return requestBody;
    }
}
