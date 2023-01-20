package com.meizu.cloud.pushsdk.platform.b;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.bytedance.msdk.adapter.config.TTBaseAdapterConfiguration;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.platform.PlatformMessageSender;
import com.meizu.cloud.pushsdk.platform.message.SubTagsStatus;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes2.dex */
public class e extends c<SubTagsStatus> {

    /* renamed from: h */
    private String f4959h;

    /* renamed from: i */
    private int f4960i;

    /* renamed from: j */
    private String f4961j;

    public e(Context context, com.meizu.cloud.pushsdk.platform.a.a aVar, ScheduledExecutorService scheduledExecutorService) {
        this(context, null, null, null, aVar, scheduledExecutorService);
    }

    public e(Context context, com.meizu.cloud.pushsdk.platform.a.a aVar, ScheduledExecutorService scheduledExecutorService, boolean z) {
        this(context, aVar, scheduledExecutorService);
        this.f4952g = z;
    }

    public e(Context context, String str, String str2, com.meizu.cloud.pushsdk.platform.a.a aVar, ScheduledExecutorService scheduledExecutorService) {
        super(context, str, str2, aVar, scheduledExecutorService);
        this.f4960i = 3;
    }

    public e(Context context, String str, String str2, String str3, com.meizu.cloud.pushsdk.platform.a.a aVar, ScheduledExecutorService scheduledExecutorService) {
        this(context, str, str2, aVar, scheduledExecutorService);
        this.f4959h = str3;
    }

    public void a(int i2) {
        this.f4960i = i2;
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    public void a(SubTagsStatus subTagsStatus) {
        PlatformMessageSender.a(this.a, !TextUtils.isEmpty(this.f4949d) ? this.f4949d : this.a.getPackageName(), subTagsStatus);
    }

    public void a(String str) {
        this.f4961j = str;
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    public boolean a() {
        return (TextUtils.isEmpty(this.b) || TextUtils.isEmpty(this.f4948c) || TextUtils.isEmpty(this.f4959h)) ? false : true;
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    public Intent c() {
        Intent intent = new Intent();
        intent.putExtra("app_id", this.b);
        intent.putExtra(TTBaseAdapterConfiguration.APP_KEY_EXTRA_KEY, this.f4948c);
        intent.putExtra("strategy_package_name", this.a.getPackageName());
        intent.putExtra(PushConstants.REGISTER_STATUS_PUSH_ID, this.f4959h);
        intent.putExtra("strategy_type", g());
        intent.putExtra("strategy_child_type", this.f4960i);
        intent.putExtra("strategy_params", this.f4961j);
        return intent;
    }

    public void e(String str) {
        this.f4959h = str;
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    public int g() {
        return 4;
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    /* renamed from: h */
    public SubTagsStatus b() {
        String str;
        SubTagsStatus subTagsStatus = new SubTagsStatus();
        subTagsStatus.setCode("20001");
        if (TextUtils.isEmpty(this.b)) {
            str = "appId not empty";
        } else if (!TextUtils.isEmpty(this.f4948c)) {
            if (TextUtils.isEmpty(this.f4959h)) {
                str = "pushId not empty";
            }
            return subTagsStatus;
        } else {
            str = "appKey not empty";
        }
        subTagsStatus.setMessage(str);
        return subTagsStatus;
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    /* renamed from: i */
    public SubTagsStatus e() {
        StringBuilder sb;
        String str;
        SubTagsStatus subTagsStatus = new SubTagsStatus();
        int i2 = this.f4960i;
        com.meizu.cloud.pushsdk.c.a.c e2 = i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? null : this.f4950e.e(this.b, this.f4948c, this.f4959h) : this.f4950e.d(this.b, this.f4948c, this.f4959h) : this.f4950e.b(this.b, this.f4948c, this.f4959h, this.f4961j) : this.f4950e.a(this.b, this.f4948c, this.f4959h, this.f4961j);
        if (e2 == null) {
            e.p.a.a.a.f("Strategy", "network anResponse is null");
            return null;
        }
        if (e2.b()) {
            subTagsStatus = new SubTagsStatus((String) e2.a());
            sb = new StringBuilder();
            str = "network subTagsStatus ";
        } else {
            com.meizu.cloud.pushsdk.c.b.a c2 = e2.c();
            if (c2.a() != null) {
                e.p.a.a.a.f("Strategy", "status code=" + c2.b() + " data=" + c2.a());
            }
            subTagsStatus.setCode(String.valueOf(c2.b()));
            subTagsStatus.setMessage(c2.c());
            sb = new StringBuilder();
            str = "subTagsStatus ";
        }
        sb.append(str);
        sb.append(subTagsStatus);
        e.p.a.a.a.f("Strategy", sb.toString());
        return subTagsStatus;
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    /* renamed from: j */
    public SubTagsStatus f() {
        return null;
    }
}
