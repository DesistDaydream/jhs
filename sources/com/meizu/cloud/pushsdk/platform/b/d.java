package com.meizu.cloud.pushsdk.platform.b;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.bytedance.msdk.adapter.config.TTBaseAdapterConfiguration;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.platform.PlatformMessageSender;
import com.meizu.cloud.pushsdk.platform.message.BasicPushStatus;
import com.meizu.cloud.pushsdk.platform.message.SubAliasStatus;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes2.dex */
public class d extends c<SubAliasStatus> {

    /* renamed from: h */
    private String f4955h;

    /* renamed from: i */
    private int f4956i;

    /* renamed from: j */
    private String f4957j;

    /* renamed from: k */
    private final Map<String, Boolean> f4958k;

    public d(Context context, com.meizu.cloud.pushsdk.platform.a.a aVar, ScheduledExecutorService scheduledExecutorService) {
        this(context, null, null, null, aVar, scheduledExecutorService);
    }

    public d(Context context, com.meizu.cloud.pushsdk.platform.a.a aVar, ScheduledExecutorService scheduledExecutorService, boolean z) {
        this(context, aVar, scheduledExecutorService);
        this.f4952g = z;
    }

    public d(Context context, String str, String str2, com.meizu.cloud.pushsdk.platform.a.a aVar, ScheduledExecutorService scheduledExecutorService) {
        super(context, str, str2, aVar, scheduledExecutorService);
        this.f4958k = new HashMap();
    }

    public d(Context context, String str, String str2, String str3, com.meizu.cloud.pushsdk.platform.a.a aVar, ScheduledExecutorService scheduledExecutorService) {
        this(context, str, str2, aVar, scheduledExecutorService);
        this.f4955h = str3;
    }

    private void b(boolean z) {
        Map<String, Boolean> map = this.f4958k;
        map.put(this.f4949d + "_" + this.f4956i, Boolean.valueOf(z));
    }

    private void f(String str) {
        com.meizu.cloud.pushsdk.util.b.h(this.a, !TextUtils.isEmpty(this.f4949d) ? this.f4949d : this.a.getPackageName(), str);
    }

    private String o() {
        return com.meizu.cloud.pushsdk.util.b.g(this.a, !TextUtils.isEmpty(this.f4949d) ? this.f4949d : this.a.getPackageName());
    }

    private boolean p() {
        Map<String, Boolean> map = this.f4958k;
        Boolean bool = map.get(this.f4949d + "_" + this.f4956i);
        return bool == null || bool.booleanValue();
    }

    private boolean q() {
        return !this.f4951f && PushConstants.PUSH_PACKAGE_NAME.equals(this.f4949d);
    }

    public void a(int i2) {
        this.f4956i = i2;
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    public void a(SubAliasStatus subAliasStatus) {
        PlatformMessageSender.a(this.a, !TextUtils.isEmpty(this.f4949d) ? this.f4949d : this.a.getPackageName(), subAliasStatus);
    }

    public void a(String str) {
        this.f4957j = str;
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    public boolean a() {
        return (TextUtils.isEmpty(this.b) || TextUtils.isEmpty(this.f4948c) || TextUtils.isEmpty(this.f4955h)) ? false : true;
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    public Intent c() {
        if (this.f4956i != 2) {
            Intent intent = new Intent();
            intent.putExtra("app_id", this.b);
            intent.putExtra(TTBaseAdapterConfiguration.APP_KEY_EXTRA_KEY, this.f4948c);
            intent.putExtra("strategy_package_name", this.a.getPackageName());
            intent.putExtra(PushConstants.REGISTER_STATUS_PUSH_ID, this.f4955h);
            intent.putExtra("strategy_type", g());
            intent.putExtra("strategy_child_type", this.f4956i);
            intent.putExtra("strategy_params", this.f4957j);
            return intent;
        }
        return null;
    }

    public void e(String str) {
        this.f4955h = str;
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    public int g() {
        return 8;
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    /* renamed from: h */
    public SubAliasStatus b() {
        String str;
        SubAliasStatus subAliasStatus = new SubAliasStatus();
        subAliasStatus.setCode("20001");
        if (TextUtils.isEmpty(this.b)) {
            str = "appId not empty";
        } else if (!TextUtils.isEmpty(this.f4948c)) {
            if (TextUtils.isEmpty(this.f4955h)) {
                str = "pushId not empty";
            }
            return subAliasStatus;
        } else {
            str = "appKey not empty";
        }
        subAliasStatus.setMessage(str);
        return subAliasStatus;
    }

    /* JADX WARN: Removed duplicated region for block: B:70:0x0090  */
    @Override // com.meizu.cloud.pushsdk.platform.b.c
    /* renamed from: i */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.meizu.cloud.pushsdk.platform.message.SubAliasStatus e() {
        /*
            Method dump skipped, instructions count: 283
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.cloud.pushsdk.platform.b.d.e():com.meizu.cloud.pushsdk.platform.message.SubAliasStatus");
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    /* renamed from: j */
    public SubAliasStatus f() {
        if (this.f4956i == 2) {
            SubAliasStatus subAliasStatus = new SubAliasStatus();
            subAliasStatus.setCode(BasicPushStatus.SUCCESS_CODE);
            subAliasStatus.setPushId(this.f4955h);
            subAliasStatus.setAlias(o());
            subAliasStatus.setMessage("check alias success");
            return subAliasStatus;
        }
        return null;
    }
}
