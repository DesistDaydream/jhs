package com.tencent.android.tpush;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.android.tpush.message.d;

@JgClassChecked(author = 1, fComment = "确认已进行安全校验", lastDate = "20150316", reviewer = 3, vComment = {EType.RECEIVERCHECK, EType.INTENTCHECK})
/* loaded from: classes3.dex */
public class XGNotifaction {
    private int a;
    private Notification b;

    /* renamed from: c  reason: collision with root package name */
    private String f5932c;

    /* renamed from: d  reason: collision with root package name */
    private String f5933d;

    /* renamed from: e  reason: collision with root package name */
    private String f5934e;

    /* renamed from: f  reason: collision with root package name */
    private Context f5935f;

    /* renamed from: g  reason: collision with root package name */
    private String f5936g;

    /* renamed from: h  reason: collision with root package name */
    private String f5937h;

    /* renamed from: i  reason: collision with root package name */
    private String f5938i;

    public XGNotifaction(Context context, int i2, Notification notification, d dVar) {
        this.a = 0;
        this.b = null;
        this.f5932c = null;
        this.f5933d = null;
        this.f5934e = null;
        this.f5935f = null;
        this.f5936g = null;
        this.f5937h = null;
        this.f5938i = null;
        if (dVar == null) {
            return;
        }
        this.f5935f = context.getApplicationContext();
        this.a = i2;
        this.b = notification;
        this.f5932c = dVar.d();
        this.f5933d = dVar.e();
        this.f5934e = dVar.f();
        this.f5936g = dVar.l().f6169d;
        this.f5937h = dVar.l().f6171f;
        this.f5938i = dVar.l().b;
    }

    public boolean doNotify() {
        Context context;
        NotificationManager notificationManager;
        if (this.b == null || (context = this.f5935f) == null || (notificationManager = (NotificationManager) context.getSystemService(RemoteMessageConst.NOTIFICATION)) == null) {
            return false;
        }
        notificationManager.notify(this.a, this.b);
        return true;
    }

    public String getContent() {
        return this.f5933d;
    }

    public String getCustomContent() {
        return this.f5934e;
    }

    public Notification getNotifaction() {
        return this.b;
    }

    public int getNotifyId() {
        return this.a;
    }

    public String getTargetActivity() {
        return this.f5938i;
    }

    public String getTargetIntent() {
        return this.f5936g;
    }

    public String getTargetUrl() {
        return this.f5937h;
    }

    public String getTitle() {
        return this.f5932c;
    }

    public void setNotifyId(int i2) {
        this.a = i2;
    }

    public String toString() {
        return "XGNotifaction [notifyId=" + this.a + ", title=" + this.f5932c + ", content=" + this.f5933d + ", customContent=" + this.f5934e + "]";
    }
}
