package com.moor.imkf.lib.http.builder;

import com.moor.imkf.lib.http.request.MoorPostFormRequest;
import com.moor.imkf.lib.http.request.MoorRequestCall;
import java.util.LinkedHashMap;
import java.util.Map;
import okhttp3.Request;

/* loaded from: classes2.dex */
public class MoorPostFormBuilder extends MoorHttpRequestBuilder<MoorPostFormBuilder> implements IMoorHasParamsable {
    private Request.Builder builder;

    public MoorPostFormBuilder(Request.Builder builder) {
        this.builder = builder;
    }

    @Override // com.moor.imkf.lib.http.builder.MoorHttpRequestBuilder
    public MoorRequestCall build() {
        return new MoorPostFormRequest(this.url, this.tag, this.params, this.id, this.builder).build();
    }

    @Override // com.moor.imkf.lib.http.builder.IMoorHasParamsable
    public /* bridge */ /* synthetic */ MoorHttpRequestBuilder params(Map map) {
        return params((Map<String, Object>) map);
    }

    @Override // com.moor.imkf.lib.http.builder.IMoorHasParamsable
    public MoorPostFormBuilder addParams(String str, String str2) {
        if (this.params == null) {
            this.params = new LinkedHashMap();
        }
        this.params.put(str, str2);
        return this;
    }

    @Override // com.moor.imkf.lib.http.builder.IMoorHasParamsable
    public MoorPostFormBuilder params(Map<String, Object> map) {
        this.params = map;
        return this;
    }
}
