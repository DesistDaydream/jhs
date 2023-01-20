package com.baidu.mobads.sdk.internal;

import android.text.TextUtils;
import com.moor.imkf.model.entity.FromToMessage;

/* loaded from: classes.dex */
public enum i {
    NEWS("news", 0),
    IMAGE(FromToMessage.MSG_TYPE_IMAGE, 1),
    VIDEO("video", 2),
    TOPIC("topic", 3),
    AD(com.umeng.analytics.pro.am.aw, 4),
    HOTDOC("hotkey", 5),
    SMALLVIDEO("smallvideo", 6),
    RECALLNEWS("recallNews", 8),
    POLICETASK("policetask", 9);
    

    /* renamed from: j  reason: collision with root package name */
    public String f1607j;

    /* renamed from: k  reason: collision with root package name */
    public int f1608k;

    i(String str, int i2) {
        this.f1607j = str;
        this.f1608k = i2;
    }

    public String b() {
        return this.f1607j;
    }

    public int c() {
        return this.f1608k;
    }

    public static i b(String str) {
        i[] values;
        for (i iVar : values()) {
            if (iVar != null && TextUtils.isEmpty(iVar.f1607j) && iVar.f1607j.equals(str)) {
                return iVar;
            }
        }
        return null;
    }
}
