package com.meizu.cloud.pushsdk.b;

/* loaded from: classes2.dex */
public class h<T> {
    private T a;
    private T b;

    public h(T t) {
        if (t == null) {
            throw new RuntimeException("proxy must be has a default implementation");
        }
        this.b = t;
    }

    public T c() {
        T t = this.a;
        return t != null ? t : this.b;
    }
}
