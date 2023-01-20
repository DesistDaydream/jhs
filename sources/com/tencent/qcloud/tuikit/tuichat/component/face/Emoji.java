package com.tencent.qcloud.tuikit.tuichat.component.face;

import android.graphics.Bitmap;
import com.tencent.qcloud.tuicore.util.ScreenUtil;
import java.io.Serializable;

/* loaded from: classes3.dex */
public class Emoji implements Serializable {
    private static final int deaultSize = ScreenUtil.getPxByDp(32.0f);
    private String desc;
    private String filter;
    private int height;
    private Bitmap icon;
    private int width;

    public Emoji() {
        int i2 = deaultSize;
        this.width = i2;
        this.height = i2;
    }

    public String getDesc() {
        return this.desc;
    }

    public String getFilter() {
        return this.filter;
    }

    public int getHeight() {
        return this.height;
    }

    public Bitmap getIcon() {
        return this.icon;
    }

    public int getWidth() {
        return this.width;
    }

    public void setDesc(String str) {
        this.desc = str;
    }

    public void setFilter(String str) {
        this.filter = str;
    }

    public void setHeight(int i2) {
        this.height = i2;
    }

    public void setIcon(Bitmap bitmap) {
        this.icon = bitmap;
    }

    public void setWidth(int i2) {
        this.width = i2;
    }
}
