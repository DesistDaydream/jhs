package com.jihuanshe.model;

import h.k2.v.f0;
import k.e.a.d;
import k.e.a.e;

/* loaded from: classes2.dex */
public final class NetResponse<T> {
    @e
    private T data;
    @d
    private String code = "";
    @d
    private String message = "";

    @d
    public final String getCode() {
        return this.code;
    }

    @e
    public final T getData() {
        return this.data;
    }

    @d
    public final String getMessage() {
        return this.message;
    }

    public final boolean isSuccessful() {
        return f0.g(this.code, "1");
    }

    public final void setCode(@d String str) {
        this.code = str;
    }

    public final void setData(@e T t) {
        this.data = t;
    }

    public final void setMessage(@d String str) {
        this.message = str;
    }
}
