package com.bytedance.msdk.api.v2;

/* loaded from: classes.dex */
public class GMLocation {
    private double a;
    private double b;

    public GMLocation(double d2, double d3) {
        this.a = 0.0d;
        this.b = 0.0d;
        this.a = d2;
        this.b = d3;
    }

    public double getLatitude() {
        return this.a;
    }

    public double getLongitude() {
        return this.b;
    }

    public void setLatitude(double d2) {
        this.a = d2;
    }

    public void setLongitude(double d2) {
        this.b = d2;
    }
}
