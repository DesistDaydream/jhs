package com.tencent.imsdk.message;

import java.io.Serializable;

/* loaded from: classes3.dex */
public class MessageBaseElement implements Serializable {
    public static int UUID_TYPE_AUDIO = 3;
    public static int UUID_TYPE_FILE = 1;
    public static int UUID_TYPE_VIDEO = 2;
    public static int UUID_TYPE_VIDEO_THUMB;
    public int elementType;

    public int getElementType() {
        return this.elementType;
    }

    public void setElementType(int i2) {
        this.elementType = i2;
    }

    public boolean update(MessageBaseElement messageBaseElement) {
        return false;
    }
}
