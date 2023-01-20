package com.meizu.cloud.pushsdk.platform.b;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.meizu.cloud.pushsdk.platform.message.BasicPushStatus;
import com.meizu.cloud.pushsdk.util.MinSdkChecker;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes2.dex */
public class a extends c {

    /* renamed from: h  reason: collision with root package name */
    private int[] f4942h;

    /* renamed from: i  reason: collision with root package name */
    private int f4943i;

    /* renamed from: j  reason: collision with root package name */
    private String f4944j;

    public a(Context context, String str, String str2, com.meizu.cloud.pushsdk.platform.a.a aVar, ScheduledExecutorService scheduledExecutorService) {
        super(context, str, str2, aVar, scheduledExecutorService);
        this.f4951f = MinSdkChecker.isSupportSetDrawableSmallIcon();
    }

    public a(Context context, ScheduledExecutorService scheduledExecutorService, boolean z) {
        this(context, null, null, null, scheduledExecutorService);
        this.f4952g = z;
    }

    public void a(int i2) {
        this.f4943i = i2;
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    public void a(BasicPushStatus basicPushStatus) {
    }

    public void a(String str) {
        this.f4944j = str;
    }

    public void a(int... iArr) {
        this.f4942h = iArr;
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    public boolean a() {
        int i2 = this.f4943i;
        if (i2 != 0) {
            int[] iArr = this.f4942h;
            if (iArr == null || iArr.length <= 0 || i2 != 1) {
                return i2 == 2 && !TextUtils.isEmpty(this.f4944j);
            }
            return true;
        }
        return true;
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    public BasicPushStatus b() {
        return null;
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    public Intent c() {
        Intent intent = new Intent();
        intent.putExtra("strategy_package_name", this.a.getPackageName());
        intent.putExtra("strategy_type", g());
        intent.putExtra("strategy_child_type", this.f4943i);
        int i2 = this.f4943i;
        if (i2 == 2) {
            intent.putExtra("strategy_params", this.f4944j);
            return intent;
        } else if (i2 == 1) {
            return null;
        } else {
            return intent;
        }
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    public Intent[] d() {
        int[] iArr = this.f4942h;
        if (iArr != null) {
            Intent[] intentArr = new Intent[iArr.length];
            for (int i2 = 0; i2 < this.f4942h.length; i2++) {
                e.p.a.a.a.c("Strategy", "send notifyId " + this.f4942h[i2] + " to PushManagerService");
                Intent intent = new Intent();
                intent.putExtra("strategy_package_name", this.a.getPackageName());
                intent.putExtra("strategy_type", g());
                intent.putExtra("strategy_child_type", this.f4943i);
                intent.putExtra("strategy_params", "" + this.f4942h[i2]);
                intentArr[i2] = intent;
            }
            return intentArr;
        }
        return null;
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    public BasicPushStatus e() {
        int i2 = this.f4943i;
        if (i2 == 0) {
            if (!MinSdkChecker.isSupportSetDrawableSmallIcon()) {
                e.p.a.a.a.f("Strategy", "android 6.0 blow so cancel all by context");
                com.meizu.cloud.pushsdk.notification.c.b.a(this.a);
            }
            com.meizu.cloud.pushsdk.notification.c.b.a(this.a, this.f4949d);
            return null;
        } else if (i2 != 1) {
            if (i2 != 2) {
                return null;
            }
            com.meizu.cloud.pushsdk.notification.c.b.a(this.a, this.f4949d, this.f4944j);
            return null;
        } else {
            int[] iArr = this.f4942h;
            if (iArr != null) {
                for (int i3 : iArr) {
                    e.p.a.a.a.f("Strategy", "clear notifyId " + i3);
                    com.meizu.cloud.pushsdk.notification.c.b.a(this.a, this.f4949d, i3);
                }
                return null;
            }
            return null;
        }
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    public BasicPushStatus f() {
        return null;
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    public int g() {
        return 64;
    }
}
