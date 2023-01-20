package com.moor.imkf.lib.http.builder;

import java.util.Map;

/* loaded from: classes2.dex */
public interface IMoorHasParamsable {
    MoorHttpRequestBuilder addParams(String str, String str2);

    MoorHttpRequestBuilder params(Map<String, Object> map);
}
