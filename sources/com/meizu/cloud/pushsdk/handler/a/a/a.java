package com.meizu.cloud.pushsdk.handler.a.a;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.meizu.cloud.pushsdk.handler.MessageV3;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSettingEx;

/* loaded from: classes2.dex */
public class a {
    private Context a;
    private com.meizu.cloud.pushsdk.b.a.a b;

    /* renamed from: c  reason: collision with root package name */
    private int f4893c;

    /* renamed from: d  reason: collision with root package name */
    private Notification f4894d;

    public a(Context context) {
        this.a = context;
    }

    private void a(int i2, Notification notification) {
        this.f4893c = i2;
        this.f4894d = notification;
    }

    private void b() {
        this.f4893c = 0;
        this.f4894d = null;
        com.meizu.cloud.pushsdk.b.a.a aVar = this.b;
        try {
            if (aVar != null) {
                try {
                    aVar.b();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        } finally {
            this.b = null;
        }
    }

    private void b(int i2) {
        if (i2 <= 0) {
            return;
        }
        com.meizu.cloud.pushsdk.b.a.a aVar = this.b;
        if (aVar != null) {
            try {
                try {
                    aVar.b();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } finally {
                this.b = null;
            }
        }
        com.meizu.cloud.pushsdk.b.a.a aVar2 = new com.meizu.cloud.pushsdk.b.a.a(this.a, new Runnable() { // from class: com.meizu.cloud.pushsdk.handler.a.a.a.1
            @Override // java.lang.Runnable
            public void run() {
                e.p.a.a.a.e("AdNotification", "ad priority valid time out");
                a.this.a();
            }
        }, i2 * 60 * 1000);
        this.b = aVar2;
        aVar2.a();
    }

    public void a() {
        if (this.f4893c <= 0 || this.f4894d == null) {
            return;
        }
        try {
            ((NotificationManager) this.a.getSystemService(RemoteMessageConst.NOTIFICATION)).notify(this.f4893c, this.f4894d);
            e.p.a.a.a.e("AdNotification", "again show old ad notification, notifyId:" + this.f4893c);
        } catch (Exception e2) {
            e2.printStackTrace();
            e.p.a.a.a.f("AdNotification", "again show old ad notification error:" + e2.getMessage());
        }
        b();
    }

    public void a(int i2) {
        int i3;
        if (i2 <= 0 || (i3 = this.f4893c) <= 0 || i2 != i3) {
            return;
        }
        b();
        e.p.a.a.a.e("AdNotification", "clean ad notification, notifyId:" + i2);
    }

    public void a(int i2, Notification notification, int i3) {
        if (i2 <= 0 || notification == null) {
            return;
        }
        a(i2, notification);
        b(i3);
        e.p.a.a.a.e("AdNotification", "save ad notification, notifyId:" + i2);
    }

    public void a(MessageV3 messageV3) {
        AdvanceSetting advanceSetting = messageV3.getAdvanceSetting();
        if (advanceSetting != null) {
            advanceSetting.getNotifyType().setSound(false);
            advanceSetting.getNotifyType().setLights(false);
            advanceSetting.getNotifyType().setVibrate(false);
        }
        AdvanceSettingEx advanceSettingEx = messageV3.getAdvanceSettingEx();
        if (advanceSettingEx != null) {
            advanceSettingEx.setSoundTitle(null);
            if (Build.VERSION.SDK_INT < 29 || advanceSetting == null || !advanceSetting.isHeadUpNotification()) {
                advanceSettingEx.setPriorityDisplay(0);
            } else {
                advanceSettingEx.setPriorityDisplay(1);
            }
        }
    }
}
