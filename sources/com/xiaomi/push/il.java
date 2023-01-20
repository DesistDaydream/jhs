package com.xiaomi.push;

import com.j256.ormlite.stmt.query.SimpleComparison;

/* loaded from: classes3.dex */
public class il {
    public final String a;
    public final byte b;

    /* renamed from: c  reason: collision with root package name */
    public final short f9004c;

    public il() {
        this("", (byte) 0, (short) 0);
    }

    public il(String str, byte b, short s) {
        this.a = str;
        this.b = b;
        this.f9004c = s;
    }

    public String toString() {
        return "<TField name:'" + this.a + "' type:" + ((int) this.b) + " field-id:" + ((int) this.f9004c) + SimpleComparison.GREATER_THAN_OPERATION;
    }
}
