package com.meizu.cloud.pushsdk.platform.b;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.bytedance.msdk.adapter.config.TTBaseAdapterConfiguration;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.platform.PlatformMessageSender;
import com.meizu.cloud.pushsdk.platform.message.BasicPushStatus;
import com.meizu.cloud.pushsdk.platform.message.PushSwitchStatus;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes2.dex */
public class f extends c<PushSwitchStatus> {

    /* renamed from: h */
    private String f4962h;

    /* renamed from: i */
    private int f4963i;

    /* renamed from: j */
    private boolean f4964j;

    /* renamed from: k */
    private final Map<String, Boolean> f4965k;

    public f(Context context, com.meizu.cloud.pushsdk.platform.a.a aVar, ScheduledExecutorService scheduledExecutorService) {
        this(context, null, null, null, aVar, scheduledExecutorService);
    }

    public f(Context context, com.meizu.cloud.pushsdk.platform.a.a aVar, ScheduledExecutorService scheduledExecutorService, boolean z) {
        this(context, aVar, scheduledExecutorService);
        this.f4952g = z;
    }

    public f(Context context, String str, String str2, com.meizu.cloud.pushsdk.platform.a.a aVar, ScheduledExecutorService scheduledExecutorService) {
        super(context, str, str2, aVar, scheduledExecutorService);
        this.f4963i = 0;
        this.f4965k = new HashMap();
    }

    public f(Context context, String str, String str2, String str3, com.meizu.cloud.pushsdk.platform.a.a aVar, ScheduledExecutorService scheduledExecutorService) {
        this(context, str, str2, aVar, scheduledExecutorService);
        this.f4962h = str3;
    }

    private com.meizu.cloud.pushsdk.c.a.c<String> b(PushSwitchStatus pushSwitchStatus) {
        boolean z;
        boolean r;
        boolean p;
        int i2 = this.f4963i;
        if (i2 != 0) {
            if (i2 == 1) {
                pushSwitchStatus.setMessage("SWITCH_THROUGH_MESSAGE");
                if (r() != this.f4964j || t()) {
                    f(true);
                    d(this.f4964j);
                    return this.f4950e.a(this.b, this.f4948c, this.f4962h, this.f4963i, this.f4964j);
                }
                p = p();
            } else if (i2 != 2) {
                if (i2 == 3) {
                    pushSwitchStatus.setMessage("SWITCH_ALL");
                    if (p() != this.f4964j || r() != this.f4964j || t()) {
                        f(true);
                        e(this.f4964j);
                        return this.f4950e.a(this.b, this.f4948c, this.f4962h, this.f4964j);
                    }
                    p = this.f4964j;
                }
                return null;
            } else {
                pushSwitchStatus.setMessage("CHECK_PUSH");
                if (!q() || !s() || t()) {
                    f(true);
                    return this.f4950e.c(this.b, this.f4948c, this.f4962h);
                }
                z = p();
                pushSwitchStatus.setSwitchNotificationMessage(z);
                r = r();
            }
            pushSwitchStatus.setSwitchNotificationMessage(p);
            r = this.f4964j;
        } else {
            pushSwitchStatus.setMessage("SWITCH_NOTIFICATION");
            if (p() != this.f4964j || t()) {
                f(true);
                c(this.f4964j);
                return this.f4950e.a(this.b, this.f4948c, this.f4962h, this.f4963i, this.f4964j);
            }
            z = this.f4964j;
            pushSwitchStatus.setSwitchNotificationMessage(z);
            r = r();
        }
        pushSwitchStatus.setSwitchThroughMessage(r);
        return null;
    }

    private void c(boolean z) {
        com.meizu.cloud.pushsdk.util.b.a(this.a, !TextUtils.isEmpty(this.f4949d) ? this.f4949d : this.a.getPackageName(), z);
    }

    private void d(boolean z) {
        com.meizu.cloud.pushsdk.util.b.b(this.a, !TextUtils.isEmpty(this.f4949d) ? this.f4949d : this.a.getPackageName(), z);
    }

    private void e(boolean z) {
        com.meizu.cloud.pushsdk.util.b.a(this.a, !TextUtils.isEmpty(this.f4949d) ? this.f4949d : this.a.getPackageName(), z);
        com.meizu.cloud.pushsdk.util.b.b(this.a, !TextUtils.isEmpty(this.f4949d) ? this.f4949d : this.a.getPackageName(), z);
    }

    private void f(boolean z) {
        Map<String, Boolean> map = this.f4965k;
        map.put(this.f4949d + "_" + this.f4963i, Boolean.valueOf(z));
    }

    private void o() {
        int i2 = this.f4963i;
        if (i2 == 0 || i2 == 1) {
            PlatformMessageSender.a(this.a, i2, this.f4964j, this.f4949d);
        } else if (i2 != 3) {
        } else {
            PlatformMessageSender.a(this.a, 0, this.f4964j, this.f4949d);
            PlatformMessageSender.a(this.a, 1, this.f4964j, this.f4949d);
        }
    }

    private boolean p() {
        return com.meizu.cloud.pushsdk.util.b.e(this.a, !TextUtils.isEmpty(this.f4949d) ? this.f4949d : this.a.getPackageName());
    }

    private boolean q() {
        return com.meizu.cloud.pushsdk.util.b.f(this.a, !TextUtils.isEmpty(this.f4949d) ? this.f4949d : this.a.getPackageName());
    }

    private boolean r() {
        return com.meizu.cloud.pushsdk.util.b.h(this.a, !TextUtils.isEmpty(this.f4949d) ? this.f4949d : this.a.getPackageName());
    }

    private boolean s() {
        return com.meizu.cloud.pushsdk.util.b.i(this.a, !TextUtils.isEmpty(this.f4949d) ? this.f4949d : this.a.getPackageName());
    }

    private boolean t() {
        Map<String, Boolean> map = this.f4965k;
        Boolean bool = map.get(this.f4949d + "_" + this.f4963i);
        boolean z = bool == null || bool.booleanValue();
        e.p.a.a.a.f("Strategy", "isSyncPushStatus " + this.f4949d + " switch type->" + this.f4963i + " flag->" + z);
        return z;
    }

    public void a(int i2) {
        this.f4963i = i2;
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    public void a(PushSwitchStatus pushSwitchStatus) {
        PlatformMessageSender.a(this.a, !TextUtils.isEmpty(this.f4949d) ? this.f4949d : this.a.getPackageName(), pushSwitchStatus);
    }

    public void a(String str) {
        this.f4962h = str;
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    public boolean a() {
        return (TextUtils.isEmpty(this.b) || TextUtils.isEmpty(this.f4948c) || TextUtils.isEmpty(this.f4962h)) ? false : true;
    }

    public void b(boolean z) {
        this.f4964j = z;
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    public Intent c() {
        Intent intent = new Intent();
        intent.putExtra("app_id", this.b);
        intent.putExtra(TTBaseAdapterConfiguration.APP_KEY_EXTRA_KEY, this.f4948c);
        intent.putExtra("strategy_package_name", this.a.getPackageName());
        intent.putExtra(PushConstants.REGISTER_STATUS_PUSH_ID, this.f4962h);
        intent.putExtra("strategy_type", g());
        intent.putExtra("strategy_child_type", this.f4963i);
        intent.putExtra("strategy_params", this.f4964j ? "1" : "0");
        return intent;
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    public int g() {
        return 16;
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    /* renamed from: h */
    public PushSwitchStatus b() {
        String str;
        PushSwitchStatus pushSwitchStatus = new PushSwitchStatus();
        pushSwitchStatus.setCode("20001");
        if (TextUtils.isEmpty(this.b)) {
            str = "appId not empty";
        } else if (!TextUtils.isEmpty(this.f4948c)) {
            if (TextUtils.isEmpty(this.f4962h)) {
                str = "pushId not empty";
            }
            return pushSwitchStatus;
        } else {
            str = "appKey not empty";
        }
        pushSwitchStatus.setMessage(str);
        return pushSwitchStatus;
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    /* renamed from: i */
    public PushSwitchStatus e() {
        PushSwitchStatus pushSwitchStatus = new PushSwitchStatus();
        pushSwitchStatus.setPushId(this.f4962h);
        pushSwitchStatus.setCode(BasicPushStatus.SUCCESS_CODE);
        com.meizu.cloud.pushsdk.c.a.c<String> b = b(pushSwitchStatus);
        if (b != null) {
            if (b.b()) {
                PushSwitchStatus pushSwitchStatus2 = new PushSwitchStatus(b.a());
                e.p.a.a.a.f("Strategy", "network pushSwitchStatus " + pushSwitchStatus2);
                if (BasicPushStatus.SUCCESS_CODE.equals(pushSwitchStatus.getCode())) {
                    f(false);
                    e.p.a.a.a.f("Strategy", "update local switch preference");
                    pushSwitchStatus.setSwitchNotificationMessage(pushSwitchStatus2.isSwitchNotificationMessage());
                    pushSwitchStatus.setSwitchThroughMessage(pushSwitchStatus2.isSwitchThroughMessage());
                    c(pushSwitchStatus2.isSwitchNotificationMessage());
                    d(pushSwitchStatus2.isSwitchThroughMessage());
                }
            } else {
                com.meizu.cloud.pushsdk.c.b.a c2 = b.c();
                if (c2.a() != null) {
                    e.p.a.a.a.f("Strategy", "status code=" + c2.b() + " data=" + c2.a());
                }
                pushSwitchStatus.setCode(String.valueOf(c2.b()));
                pushSwitchStatus.setMessage(c2.c());
                e.p.a.a.a.f("Strategy", "pushSwitchStatus " + pushSwitchStatus);
            }
        }
        e.p.a.a.a.f("Strategy", "enableRpc " + this.f4952g + " isSupportRemoteInvoke " + this.f4951f);
        if (this.f4952g && !this.f4951f) {
            o();
        }
        return pushSwitchStatus;
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    /* renamed from: j */
    public PushSwitchStatus f() {
        int i2 = this.f4963i;
        if (i2 == 0) {
            c(this.f4964j);
            return null;
        } else if (i2 == 1) {
            d(this.f4964j);
            return null;
        } else if (i2 == 2 || i2 == 3) {
            e(this.f4964j);
            return null;
        } else {
            return null;
        }
    }
}
