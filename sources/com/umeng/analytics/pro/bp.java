package com.umeng.analytics.pro;

import com.j256.ormlite.stmt.query.SimpleComparison;

/* loaded from: classes3.dex */
public class bp {
    public final String a;
    public final byte b;

    /* renamed from: c  reason: collision with root package name */
    public final short f7102c;

    public bp() {
        this("", (byte) 0, (short) 0);
    }

    public boolean a(bp bpVar) {
        return this.b == bpVar.b && this.f7102c == bpVar.f7102c;
    }

    public String toString() {
        return "<TField name:'" + this.a + "' type:" + ((int) this.b) + " field-id:" + ((int) this.f7102c) + SimpleComparison.GREATER_THAN_OPERATION;
    }

    public bp(String str, byte b, short s) {
        this.a = str;
        this.b = b;
        this.f7102c = s;
    }
}
