package com.didichuxing.doraemonkit.kit.core;

/* loaded from: classes.dex */
public class DokitViewLayoutParams {
    public static int FLAG_LAYOUT_NO_LIMITS = 512;
    public static int FLAG_NOT_FOCUSABLE = 8;
    public static int FLAG_NOT_FOCUSABLE_AND_NOT_TOUCHABLE = 24;
    public static int FLAG_NOT_TOUCHABLE = 16;
    public static int MATCH_PARENT = -1;
    public static int WRAP_CONTENT = -2;
    public int flags;
    public int gravity;
    public int height;
    public int width;
    public int x;
    public int y;

    public String toString() {
        return "DokitViewLayoutParams{flags=" + this.flags + ", gravity=" + this.gravity + ", x=" + this.x + ", y=" + this.y + ", width=" + this.width + ", height=" + this.height + '}';
    }
}
