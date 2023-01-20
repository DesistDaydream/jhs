package com.moor.imkf.lib.http.builder;

import com.moor.imkf.lib.http.builder.MoorHttpRequestBuilder;
import com.moor.imkf.lib.http.request.MoorRequestCall;
import java.util.Map;

/* loaded from: classes2.dex */
public abstract class MoorHttpRequestBuilder<T extends MoorHttpRequestBuilder> {
    public int id;
    public Map<String, Object> params;
    public Object tag;
    public String url;

    public abstract MoorRequestCall build();

    public T id(int i2) {
        this.id = i2;
        return this;
    }

    public T tag(Object obj) {
        this.tag = obj;
        return this;
    }

    public T url(String str) {
        this.url = str;
        return this;
    }
}
