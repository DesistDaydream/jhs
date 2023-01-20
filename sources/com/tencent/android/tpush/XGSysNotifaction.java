package com.tencent.android.tpush;

import android.app.Notification;
import android.content.Intent;
import com.jg.EType;
import com.jg.JgClassChecked;

@JgClassChecked(author = 1, fComment = "确认已进行安全校验", lastDate = "20150316", reviewer = 3, vComment = {EType.RECEIVERCHECK, EType.INTENTCHECK})
/* loaded from: classes3.dex */
public class XGSysNotifaction {
    private int a;
    private Notification b;

    /* renamed from: c  reason: collision with root package name */
    private String f6045c;

    /* renamed from: d  reason: collision with root package name */
    private Intent f6046d;

    /* renamed from: e  reason: collision with root package name */
    private int f6047e;

    /* renamed from: f  reason: collision with root package name */
    private Object f6048f;

    public XGSysNotifaction(String str, int i2, Notification notification, Intent intent, int i3, Object obj) {
        this.f6045c = str;
        this.a = i2;
        this.b = notification;
        this.f6046d = intent;
        this.f6047e = i3;
        this.f6048f = obj;
    }

    public String getAppPkg() {
        return this.f6045c;
    }

    public Notification getNotifaction() {
        return this.b;
    }

    public Object getNotificationChannle() {
        return this.f6048f;
    }

    public int getNotifyId() {
        return this.a;
    }

    public Intent getPendintIntent() {
        return this.f6046d;
    }

    public int getPendintIntentFlag() {
        return this.f6047e;
    }
}
