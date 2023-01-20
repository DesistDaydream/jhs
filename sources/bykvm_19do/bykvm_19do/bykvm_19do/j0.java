package bykvm_19do.bykvm_19do.bykvm_19do;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.util.HashSet;

/* loaded from: classes.dex */
public class j0 implements Application.ActivityLifecycleCallbacks {
    private static int b;

    /* renamed from: c */
    private static b0 f124c;

    /* renamed from: d */
    private static b0 f125d;

    /* renamed from: e */
    private static long f126e;

    /* renamed from: f */
    private static String f127f;

    /* renamed from: g */
    private static Object f128g;

    /* renamed from: h */
    private static final HashSet<Integer> f129h = new HashSet<>(8);
    private final f a;

    public j0(f fVar) {
        this.a = fVar;
    }

    public static b0 a(b0 b0Var, long j2) {
        b0 b0Var2 = (b0) b0Var.clone();
        b0Var2.a = j2;
        long j3 = j2 - b0Var.a;
        if (j3 >= 0) {
            b0Var2.f75i = j3;
        } else {
            l0.a(null);
        }
        v1.a(b0Var2);
        return b0Var2;
    }

    public static b0 a(String str, String str2, long j2, String str3) {
        b0 b0Var = new b0();
        if (!TextUtils.isEmpty(str2)) {
            str = str + Constants.COLON_SEPARATOR + str2;
        }
        b0Var.f77k = str;
        b0Var.a = j2;
        b0Var.f75i = -1L;
        if (str3 == null) {
            str3 = "";
        }
        b0Var.f76j = str3;
        v1.a(b0Var);
        return b0Var;
    }

    public static void a(Object obj) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        f129h.add(Integer.valueOf(activity.hashCode()));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        f129h.remove(Integer.valueOf(activity.hashCode()));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        if (f125d != null) {
            a(f128g);
        }
        b0 b0Var = f124c;
        if (b0Var != null) {
            f127f = b0Var.f77k;
            long currentTimeMillis = System.currentTimeMillis();
            f126e = currentTimeMillis;
            a(f124c, currentTimeMillis);
            f124c = null;
            activity.isChild();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        b0 a = a(activity.getClass().getName(), "", System.currentTimeMillis(), f127f);
        f124c = a;
        a.f78l = !f129h.remove(Integer.valueOf(activity.hashCode())) ? 1 : 0;
        if (activity.isChild()) {
            return;
        }
        try {
            activity.getWindow().getDecorView().hashCode();
        } catch (Exception e2) {
            l0.a(e2);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        f fVar;
        int i2 = b + 1;
        b = i2;
        if (i2 != 1 || (fVar = this.a) == null) {
            return;
        }
        fVar.a(true);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        if (f127f != null) {
            int i2 = b - 1;
            b = i2;
            if (i2 <= 0) {
                f127f = null;
                f126e = 0L;
                f fVar = this.a;
                if (fVar != null) {
                    fVar.a(false);
                }
            }
        }
    }
}
