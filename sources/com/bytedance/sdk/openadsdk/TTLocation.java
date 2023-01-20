package com.bytedance.sdk.openadsdk;

/* loaded from: classes.dex */
public class TTLocation implements LocationProvider {
    private double a;
    private double b;

    public TTLocation(double d2, double d3) {
        this.a = 0.0d;
        this.b = 0.0d;
        this.a = d2;
        this.b = d3;
    }

    @Override // com.bytedance.sdk.openadsdk.LocationProvider
    public double getLatitude() {
        return this.a;
    }

    @Override // com.bytedance.sdk.openadsdk.LocationProvider
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
