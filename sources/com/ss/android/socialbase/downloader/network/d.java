package com.ss.android.socialbase.downloader.network;

/* loaded from: classes3.dex */
public class d {
    private final double a;
    private final int b;

    /* renamed from: c  reason: collision with root package name */
    private double f5867c = -1.0d;

    /* renamed from: d  reason: collision with root package name */
    private int f5868d;

    public d(double d2) {
        this.a = d2;
        this.b = d2 == 0.0d ? Integer.MAX_VALUE : (int) Math.ceil(1.0d / d2);
    }

    public void a(double d2) {
        double d3 = 1.0d - this.a;
        int i2 = this.f5868d;
        if (i2 > this.b) {
            this.f5867c = Math.exp((d3 * Math.log(this.f5867c)) + (this.a * Math.log(d2)));
        } else if (i2 > 0) {
            double d4 = (d3 * i2) / (i2 + 1.0d);
            this.f5867c = Math.exp((d4 * Math.log(this.f5867c)) + ((1.0d - d4) * Math.log(d2)));
        } else {
            this.f5867c = d2;
        }
        this.f5868d++;
    }

    public double a() {
        return this.f5867c;
    }
}
