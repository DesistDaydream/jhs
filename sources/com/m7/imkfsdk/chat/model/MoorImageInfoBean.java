package com.m7.imkfsdk.chat.model;

import androidx.annotation.NonNull;

/* loaded from: classes2.dex */
public class MoorImageInfoBean {
    @NonNull
    private String from;
    private String id;
    private String path;
    private float startScale;
    private MoorImageType type;
    private int layoutW = 0;
    private int layoutH = 0;
    private int realSize = 0;

    public String getFrom() {
        return this.from;
    }

    public String getId() {
        return this.id;
    }

    public int getLayoutH() {
        return this.layoutH;
    }

    public int getLayoutW() {
        return this.layoutW;
    }

    public String getPath() {
        return this.path;
    }

    public int getRealSize() {
        return this.realSize;
    }

    public float getStartScale() {
        return this.startScale;
    }

    public MoorImageType getType() {
        return this.type;
    }

    public MoorImageInfoBean setFrom(String str) {
        this.from = str;
        return this;
    }

    public MoorImageInfoBean setId(String str) {
        this.id = str;
        return this;
    }

    public MoorImageInfoBean setLayoutH(int i2) {
        this.layoutH = i2;
        return this;
    }

    public MoorImageInfoBean setLayoutW(int i2) {
        this.layoutW = i2;
        return this;
    }

    public MoorImageInfoBean setPath(String str) {
        this.path = str;
        return this;
    }

    public MoorImageInfoBean setRealSize(int i2) {
        this.realSize = i2;
        return this;
    }

    public MoorImageInfoBean setStartScale(float f2) {
        this.startScale = f2;
        return this;
    }

    public MoorImageInfoBean setType(MoorImageType moorImageType) {
        this.type = moorImageType;
        return this;
    }
}
