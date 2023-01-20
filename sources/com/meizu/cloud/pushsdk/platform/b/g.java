package com.meizu.cloud.pushsdk.platform.b;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.bytedance.msdk.adapter.config.TTBaseAdapterConfiguration;
import com.meizu.cloud.pushsdk.platform.PlatformMessageSender;
import com.meizu.cloud.pushsdk.platform.message.BasicPushStatus;
import com.meizu.cloud.pushsdk.platform.message.UnRegisterStatus;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes2.dex */
public class g extends c<UnRegisterStatus> {
    public g(Context context, com.meizu.cloud.pushsdk.platform.a.a aVar, ScheduledExecutorService scheduledExecutorService) {
        this(context, null, null, aVar, scheduledExecutorService);
    }

    public g(Context context, com.meizu.cloud.pushsdk.platform.a.a aVar, ScheduledExecutorService scheduledExecutorService, boolean z) {
        this(context, aVar, scheduledExecutorService);
        this.f4952g = z;
    }

    public g(Context context, String str, String str2, com.meizu.cloud.pushsdk.platform.a.a aVar, ScheduledExecutorService scheduledExecutorService) {
        super(context, str, str2, aVar, scheduledExecutorService);
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    public void a(UnRegisterStatus unRegisterStatus) {
        PlatformMessageSender.a(this.a, !TextUtils.isEmpty(this.f4949d) ? this.f4949d : this.a.getPackageName(), unRegisterStatus);
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    public boolean a() {
        return (TextUtils.isEmpty(this.b) || TextUtils.isEmpty(this.f4948c)) ? false : true;
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
        return 32;
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    /* renamed from: h */
    public UnRegisterStatus b() {
        String str;
        UnRegisterStatus unRegisterStatus = new UnRegisterStatus();
        unRegisterStatus.setCode("20001");
        if (!TextUtils.isEmpty(this.b)) {
            str = TextUtils.isEmpty(this.f4948c) ? "appKey not empty" : "appKey not empty";
            return unRegisterStatus;
        }
        str = "appId not empty";
        unRegisterStatus.setMessage(str);
        return unRegisterStatus;
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    /* renamed from: i */
    public UnRegisterStatus e() {
        UnRegisterStatus unRegisterStatus = new UnRegisterStatus();
        if (TextUtils.isEmpty(com.meizu.cloud.pushsdk.util.b.a(this.a, this.f4949d))) {
            unRegisterStatus.setCode(BasicPushStatus.SUCCESS_CODE);
            unRegisterStatus.setMessage("already unRegister PushId,don't unRegister frequently");
            unRegisterStatus.setIsUnRegisterSuccess(true);
        } else {
            com.meizu.cloud.pushsdk.c.a.c b = this.f4950e.b(this.b, this.f4948c, com.meizu.cloud.pushsdk.b.c.a(this.a));
            if (b.b()) {
                unRegisterStatus = new UnRegisterStatus((String) b.a());
                e.p.a.a.a.f("Strategy", "network unRegisterStatus " + unRegisterStatus);
                if (BasicPushStatus.SUCCESS_CODE.equals(unRegisterStatus.getCode())) {
                    com.meizu.cloud.pushsdk.util.b.g(this.a, "", this.f4949d);
                }
            } else {
                com.meizu.cloud.pushsdk.c.b.a c2 = b.c();
                if (c2.a() != null) {
                    e.p.a.a.a.f("Strategy", "status code=" + c2.b() + " data=" + c2.a());
                }
                unRegisterStatus.setCode(String.valueOf(c2.b()));
                unRegisterStatus.setMessage(c2.c());
                e.p.a.a.a.f("Strategy", "unRegisterStatus " + unRegisterStatus);
            }
        }
        return unRegisterStatus;
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    /* renamed from: j */
    public UnRegisterStatus f() {
        return null;
    }
}
