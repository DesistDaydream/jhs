package com.m7.imkfsdk.chat.model;

import java.io.Serializable;
import java.util.List;

/* loaded from: classes2.dex */
public class Option implements Serializable {
    public String _id;
    public boolean isSelected;
    public String key;
    public String name;
    public List<Option> options;

    public boolean isSelected() {
        return this.isSelected;
    }

    public void setSelected(boolean z) {
        this.isSelected = z;
    }
}
