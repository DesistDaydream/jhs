package bykvm_19do.bykvm_19do.bykvm_19do;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.IBinder;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import bykvm_19do.bykvm_19do.bykvm_19do.a1;
import bykvm_19do.bykvm_19do.bykvm_19do.h1;
import bykvm_19do.bykvm_19do.bykvm_19do.j1;

/* loaded from: classes.dex */
public final class v0 implements a1 {
    private static final o0<Boolean> a = new a();

    /* loaded from: classes.dex */
    public static final class a extends o0<Boolean> {
        @Override // bykvm_19do.bykvm_19do.bykvm_19do.o0
        /* renamed from: c */
        public Boolean a(Object... objArr) {
            return Boolean.valueOf(u0.a((Context) objArr[0], "com.huawei.hwid"));
        }
    }

    /* loaded from: classes.dex */
    public static final class b implements j1.b<h1, Pair<String, Boolean>> {
        @Override // bykvm_19do.bykvm_19do.bykvm_19do.j1.b
        public Pair<String, Boolean> a(h1 h1Var) {
            if (h1Var == null) {
                return null;
            }
            return new Pair<>(h1Var.a(), Boolean.valueOf(h1Var.c()));
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_19do.j1.b
        /* renamed from: b */
        public h1 a(IBinder iBinder) {
            return h1.a.a(iBinder);
        }
    }

    /* loaded from: classes.dex */
    public static class c extends a1.a {

        /* renamed from: c  reason: collision with root package name */
        public long f175c = 0;
    }

    public static boolean d(Context context) {
        if (context == null) {
            return false;
        }
        return a.b(context).booleanValue();
    }

    private static int e(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.huawei.hwid", 0);
            if (packageInfo != null) {
                return packageInfo.versionCode;
            }
            return 0;
        } catch (Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    @Nullable
    private static Pair<String, Boolean> f(Context context) {
        return (Pair) new j1(context, new Intent("com.uodis.opendevice.OPENIDS_SERVICE").setPackage("com.huawei.hwid"), new b()).a();
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.a1
    public boolean a(Context context) {
        return d(context);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.a1
    @Nullable
    @WorkerThread
    /* renamed from: c */
    public c b(Context context) {
        String string;
        String string2;
        c cVar = new c();
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                string = Settings.Global.getString(context.getContentResolver(), "pps_oaid");
                string2 = Settings.Global.getString(context.getContentResolver(), "pps_track_limit");
            } catch (Throwable th) {
                th.printStackTrace();
            }
            if (!TextUtils.isEmpty(string)) {
                cVar.a = string;
                cVar.b = Boolean.parseBoolean(string2);
                cVar.f175c = 202003021704L;
                return cVar;
            }
        }
        Pair<String, Boolean> f2 = f(context);
        if (f2 != null) {
            cVar.a = (String) f2.first;
            cVar.b = ((Boolean) f2.second).booleanValue();
            cVar.f175c = e(context);
        }
        return cVar;
    }
}
