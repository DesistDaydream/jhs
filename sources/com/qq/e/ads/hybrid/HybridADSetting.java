package com.qq.e.ads.hybrid;

/* loaded from: classes3.dex */
public class HybridADSetting {
    public static final int TYPE_REWARD_VIDEO = 1;

    /* renamed from: f  reason: collision with root package name */
    private String f5011f;

    /* renamed from: g  reason: collision with root package name */
    private String f5012g;

    /* renamed from: h  reason: collision with root package name */
    private String f5013h;
    private int a = 1;
    private int b = 44;

    /* renamed from: c  reason: collision with root package name */
    private int f5008c = -1;

    /* renamed from: d  reason: collision with root package name */
    private int f5009d = -14013133;

    /* renamed from: e  reason: collision with root package name */
    private int f5010e = 16;

    /* renamed from: i  reason: collision with root package name */
    private int f5014i = -1776153;

    /* renamed from: j  reason: collision with root package name */
    private int f5015j = 16;

    public HybridADSetting backButtonImage(String str) {
        this.f5012g = str;
        return this;
    }

    public HybridADSetting backSeparatorLength(int i2) {
        this.f5015j = i2;
        return this;
    }

    public HybridADSetting closeButtonImage(String str) {
        this.f5013h = str;
        return this;
    }

    public String getBackButtonImage() {
        return this.f5012g;
    }

    public int getBackSeparatorLength() {
        return this.f5015j;
    }

    public String getCloseButtonImage() {
        return this.f5013h;
    }

    public int getSeparatorColor() {
        return this.f5014i;
    }

    public String getTitle() {
        return this.f5011f;
    }

    public int getTitleBarColor() {
        return this.f5008c;
    }

    public int getTitleBarHeight() {
        return this.b;
    }

    public int getTitleColor() {
        return this.f5009d;
    }

    public int getTitleSize() {
        return this.f5010e;
    }

    public int getType() {
        return this.a;
    }

    public HybridADSetting separatorColor(int i2) {
        this.f5014i = i2;
        return this;
    }

    public HybridADSetting title(String str) {
        this.f5011f = str;
        return this;
    }

    public HybridADSetting titleBarColor(int i2) {
        this.f5008c = i2;
        return this;
    }

    public HybridADSetting titleBarHeight(int i2) {
        this.b = i2;
        return this;
    }

    public HybridADSetting titleColor(int i2) {
        this.f5009d = i2;
        return this;
    }

    public HybridADSetting titleSize(int i2) {
        this.f5010e = i2;
        return this;
    }

    public HybridADSetting type(int i2) {
        this.a = i2;
        return this;
    }
}
