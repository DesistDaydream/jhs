package com.moor.imkf.model.entity;

import java.io.Serializable;

/* loaded from: classes2.dex */
public class FlowBean implements Serializable {
    private String button;
    private int button_type;
    private boolean isChoose;
    private String text;

    public String getButton() {
        return this.button;
    }

    public int getButton_type() {
        return this.button_type;
    }

    public String getText() {
        return this.text;
    }

    public boolean isChoose() {
        return this.isChoose;
    }

    public void setButton(String str) {
        this.button = str;
    }

    public void setButton_type(int i2) {
        this.button_type = i2;
    }

    public void setChoose(boolean z) {
        this.isChoose = z;
    }

    public void setText(String str) {
        this.text = str;
    }
}
