package com.meizu.cloud.pushsdk.platform.b;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.bytedance.msdk.adapter.config.TTBaseAdapterConfiguration;
import com.meizu.cloud.pushsdk.platform.PlatformMessageSender;
import com.meizu.cloud.pushsdk.platform.message.BasicPushStatus;
import com.meizu.cloud.pushsdk.platform.message.RegisterStatus;
import com.meizu.cloud.pushsdk.util.MzSystemUtils;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class b extends c<RegisterStatus> {

    /* renamed from: h */
    private Handler f4945h;

    /* renamed from: i */
    private ScheduledExecutorService f4946i;

    /* renamed from: j */
    private int f4947j;

    public b(Context context, com.meizu.cloud.pushsdk.platform.a.a aVar, ScheduledExecutorService scheduledExecutorService) {
        this(context, null, null, aVar, scheduledExecutorService);
        this.f4946i = (ScheduledExecutorService) com.meizu.cloud.pushsdk.d.b.a.b.a();
        this.f4945h = new Handler(context.getMainLooper()) { // from class: com.meizu.cloud.pushsdk.platform.b.b.1
            {
                b.this = this;
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 0) {
                    b.this.m();
                }
            }
        };
    }

    public b(Context context, com.meizu.cloud.pushsdk.platform.a.a aVar, ScheduledExecutorService scheduledExecutorService, boolean z) {
        this(context, aVar, scheduledExecutorService);
        this.f4952g = z;
    }

    public b(Context context, String str, String str2, com.meizu.cloud.pushsdk.platform.a.a aVar, ScheduledExecutorService scheduledExecutorService) {
        super(context, str, str2, aVar, scheduledExecutorService);
        this.f4947j = 0;
    }

    private boolean a(String str, String str2, int i2) {
        return TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !str2.startsWith(str) || System.currentTimeMillis() / 1000 > ((long) i2);
    }

    public void a(long j2) {
        this.f4946i.schedule(new Runnable() { // from class: com.meizu.cloud.pushsdk.platform.b.b.2
            {
                b.this = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.meizu.cloud.pushsdk.b.c.a(b.this.a);
                b.this.f4945h.sendEmptyMessage(0);
            }
        }, j2, TimeUnit.SECONDS);
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    public void a(RegisterStatus registerStatus) {
        PlatformMessageSender.a(this.a, !TextUtils.isEmpty(this.f4949d) ? this.f4949d : this.a.getPackageName(), registerStatus);
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    public boolean a() {
        e.p.a.a.a.f("Strategy", "isBrandMeizu " + MzSystemUtils.isBrandMeizu(this.a));
        return (TextUtils.isEmpty(this.b) || TextUtils.isEmpty(this.f4948c)) ? false : true;
    }

    public boolean a(String str, int i2) {
        String a = com.meizu.cloud.pushsdk.b.c.a(this.a);
        boolean a2 = a(a, str, i2);
        return a2 ? a(a, com.meizu.cloud.pushsdk.platform.a.a(str), i2) : a2;
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    public Intent c() {
        Intent intent = new Intent();
        intent.putExtra("app_id", this.b);
        intent.putExtra(TTBaseAdapterConfiguration.APP_KEY_EXTRA_KEY, this.f4948c);
        intent.putExtra("strategy_package_name", this.a.getPackageName());
        intent.putExtra("strategy_type", g());
        return intent;
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    public int g() {
        return 2;
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    /* renamed from: h */
    public RegisterStatus b() {
        String str;
        RegisterStatus registerStatus = new RegisterStatus();
        registerStatus.setCode("20001");
        if (!TextUtils.isEmpty(this.b)) {
            str = TextUtils.isEmpty(this.f4948c) ? "appKey not empty" : "appKey not empty";
            return registerStatus;
        }
        str = "appId not empty";
        registerStatus.setMessage(str);
        return registerStatus;
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    /* renamed from: i */
    public RegisterStatus f() {
        return null;
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    /* renamed from: j */
    public RegisterStatus e() {
        RegisterStatus registerStatus = new RegisterStatus();
        String a = com.meizu.cloud.pushsdk.util.b.a(this.a, this.f4949d);
        int b = com.meizu.cloud.pushsdk.util.b.b(this.a, this.f4949d);
        if (a(a, b)) {
            com.meizu.cloud.pushsdk.util.b.g(this.a, "", this.f4949d);
            String a2 = com.meizu.cloud.pushsdk.b.c.a(this.a);
            if (!TextUtils.isEmpty(a2) || this.f4947j >= 3) {
                this.f4947j = 0;
                com.meizu.cloud.pushsdk.c.a.c a3 = this.f4950e.a(this.b, this.f4948c, a2);
                if (a3.b()) {
                    registerStatus = new RegisterStatus((String) a3.a());
                    e.p.a.a.a.f("Strategy", "registerStatus " + registerStatus);
                    if (!TextUtils.isEmpty(registerStatus.getPushId())) {
                        com.meizu.cloud.pushsdk.util.b.g(this.a, registerStatus.getPushId(), this.f4949d);
                        com.meizu.cloud.pushsdk.util.b.a(this.a, (int) ((System.currentTimeMillis() / 1000) + registerStatus.getExpireTime()), this.f4949d);
                    }
                } else {
                    com.meizu.cloud.pushsdk.c.b.a c2 = a3.c();
                    if (c2.a() != null) {
                        e.p.a.a.a.f("Strategy", "status code=" + c2.b() + " data=" + c2.a());
                    }
                    registerStatus.setCode(String.valueOf(c2.b()));
                    registerStatus.setMessage(c2.c());
                    e.p.a.a.a.f("Strategy", "registerStatus " + registerStatus);
                }
            } else {
                e.p.a.a.a.c("Strategy", "after " + (this.f4947j * 10) + " seconds start register");
                a((long) (this.f4947j * 10));
                this.f4947j = this.f4947j + 1;
                registerStatus.setCode("20000");
                registerStatus.setMessage("deviceId is empty");
            }
        } else {
            registerStatus.setCode(BasicPushStatus.SUCCESS_CODE);
            registerStatus.setMessage("already register PushId,don't register frequently");
            registerStatus.setPushId(a);
            registerStatus.setExpireTime((int) (b - (System.currentTimeMillis() / 1000)));
        }
        return registerStatus;
    }
}
