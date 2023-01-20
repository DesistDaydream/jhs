package com.tencent.qcloud.tuicore.component.action;

import android.graphics.Bitmap;

/* loaded from: classes3.dex */
public class PopMenuAction {
    private PopActionClickListener actionClickListener;
    private String actionName;
    private Bitmap icon;
    private int iconResId;

    public PopActionClickListener getActionClickListener() {
        return this.actionClickListener;
    }

    public String getActionName() {
        return this.actionName;
    }

    public Bitmap getIcon() {
        return this.icon;
    }

    public int getIconResId() {
        return this.iconResId;
    }

    public void setActionClickListener(PopActionClickListener popActionClickListener) {
        this.actionClickListener = popActionClickListener;
    }

    public void setActionName(String str) {
        this.actionName = str;
    }

    public void setIcon(Bitmap bitmap) {
        this.icon = bitmap;
    }

    public void setIconResId(int i2) {
        this.iconResId = i2;
    }
}
