package com.google.zxing.oned.rss.expanded.decoders;

/* loaded from: classes2.dex */
public final class CurrentParsingState {
    private int a = 0;
    private State b = State.NUMERIC;

    /* loaded from: classes2.dex */
    public enum State {
        NUMERIC,
        ALPHA,
        ISO_IEC_646
    }

    public int a() {
        return this.a;
    }

    public void b(int i2) {
        this.a += i2;
    }

    public boolean c() {
        return this.b == State.ALPHA;
    }

    public boolean d() {
        return this.b == State.ISO_IEC_646;
    }

    public boolean e() {
        return this.b == State.NUMERIC;
    }

    public void f() {
        this.b = State.ALPHA;
    }

    public void g() {
        this.b = State.ISO_IEC_646;
    }

    public void h() {
        this.b = State.NUMERIC;
    }

    public void i(int i2) {
        this.a = i2;
    }
}
