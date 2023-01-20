package com.umeng.analytics.pro;

import com.j256.ormlite.stmt.query.SimpleComparison;

/* loaded from: classes3.dex */
public final class bs {
    public final String a;
    public final byte b;

    /* renamed from: c  reason: collision with root package name */
    public final int f7104c;

    public bs() {
        this("", (byte) 0, 0);
    }

    public boolean a(bs bsVar) {
        return this.a.equals(bsVar.a) && this.b == bsVar.b && this.f7104c == bsVar.f7104c;
    }

    public boolean equals(Object obj) {
        if (obj instanceof bs) {
            return a((bs) obj);
        }
        return false;
    }

    public String toString() {
        return "<TMessage name:'" + this.a + "' type: " + ((int) this.b) + " seqid:" + this.f7104c + SimpleComparison.GREATER_THAN_OPERATION;
    }

    public bs(String str, byte b, int i2) {
        this.a = str;
        this.b = b;
        this.f7104c = i2;
    }
}
