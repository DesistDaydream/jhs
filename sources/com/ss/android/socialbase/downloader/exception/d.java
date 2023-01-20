package com.ss.android.socialbase.downloader.exception;

/* loaded from: classes3.dex */
public class d extends BaseException {
    private final long a;
    private final long b;

    public d(long j2, long j3) {
        super(1006, String.format("space is not enough required space is : %s but available space is :%s", String.valueOf(j3), String.valueOf(j2)));
        this.a = j2;
        this.b = j3;
    }

    public long a() {
        return this.a;
    }

    public long b() {
        return this.b;
    }
}
