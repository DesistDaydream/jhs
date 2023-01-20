package com.moor.imkf.lib.http.builder;

import android.net.Uri;
import com.moor.imkf.lib.http.request.MoorGetRequest;
import com.moor.imkf.lib.http.request.MoorRequestCall;
import java.util.LinkedHashMap;
import java.util.Map;
import okhttp3.Request;

/* loaded from: classes2.dex */
public class MoorGetBuilder extends MoorHttpRequestBuilder<MoorGetBuilder> implements IMoorHasParamsable {
    private Request.Builder builder;

    public MoorGetBuilder(Request.Builder builder) {
        this.builder = builder;
    }

    public String appendParams(String str, Map<String, Object> map) {
        if (str == null || map == null || map.isEmpty()) {
            return str;
        }
        Uri.Builder buildUpon = Uri.parse(str).buildUpon();
        for (String str2 : map.keySet()) {
            buildUpon.appendQueryParameter(str2, map.get(str2) + "");
        }
        return buildUpon.build().toString();
    }

    @Override // com.moor.imkf.lib.http.builder.MoorHttpRequestBuilder
    public MoorRequestCall build() {
        Map<String, Object> map = this.params;
        if (map != null) {
            this.url = appendParams(this.url, map);
        }
        return new MoorGetRequest(this.url, this.tag, this.params, this.id, this.builder).build();
    }

    @Override // com.moor.imkf.lib.http.builder.IMoorHasParamsable
    public /* bridge */ /* synthetic */ MoorHttpRequestBuilder params(Map map) {
        return params((Map<String, Object>) map);
    }

    @Override // com.moor.imkf.lib.http.builder.IMoorHasParamsable
    public MoorGetBuilder addParams(String str, String str2) {
        if (this.params == null) {
            this.params = new LinkedHashMap();
        }
        this.params.put(str, str2);
        return this;
    }

    @Override // com.moor.imkf.lib.http.builder.IMoorHasParamsable
    public MoorGetBuilder params(Map<String, Object> map) {
        this.params = map;
        return this;
    }
}
