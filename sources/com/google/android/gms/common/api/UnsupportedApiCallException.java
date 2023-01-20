package com.google.android.gms.common.api;

import com.google.android.gms.common.Feature;
import e.j.a.b.c.m.a;

/* loaded from: classes2.dex */
public final class UnsupportedApiCallException extends UnsupportedOperationException {
    private final Feature zzas;

    @a
    public UnsupportedApiCallException(Feature feature) {
        this.zzas = feature;
    }

    @Override // java.lang.Throwable
    public final String getMessage() {
        String valueOf = String.valueOf(this.zzas);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 8);
        sb.append("Missing ");
        sb.append(valueOf);
        return sb.toString();
    }
}
