package e.j.a.b.c.x;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Process;
import android.os.WorkSource;
import android.util.Log;
import androidx.annotation.Nullable;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@e.j.a.b.c.m.a
/* loaded from: classes2.dex */
public class e0 {
    private static final int a = Process.myUid();
    private static final Method b = n();

    /* renamed from: c  reason: collision with root package name */
    private static final Method f10459c = o();

    /* renamed from: d  reason: collision with root package name */
    private static final Method f10460d = p();

    /* renamed from: e  reason: collision with root package name */
    private static final Method f10461e = i();

    /* renamed from: f  reason: collision with root package name */
    private static final Method f10462f = j();

    /* renamed from: g  reason: collision with root package name */
    private static final Method f10463g = k();

    /* renamed from: h  reason: collision with root package name */
    private static final Method f10464h = l();

    private e0() {
    }

    @Nullable
    @e.j.a.b.c.m.a
    public static WorkSource a(Context context, @Nullable String str) {
        if (context != null && context.getPackageManager() != null && str != null) {
            try {
                ApplicationInfo c2 = e.j.a.b.c.y.c.a(context).c(str, 0);
                if (c2 == null) {
                    String valueOf = String.valueOf(str);
                    Log.e("WorkSourceUtil", valueOf.length() != 0 ? "Could not get applicationInfo from package: ".concat(valueOf) : new String("Could not get applicationInfo from package: "));
                    return null;
                }
                return f(c2.uid, str);
            } catch (PackageManager.NameNotFoundException unused) {
                String valueOf2 = String.valueOf(str);
                Log.e("WorkSourceUtil", valueOf2.length() != 0 ? "Could not find package: ".concat(valueOf2) : new String("Could not find package: "));
            }
        }
        return null;
    }

    @e.j.a.b.c.m.a
    public static WorkSource b(Context context, String str, String str2) {
        Method method;
        if (context != null && context.getPackageManager() != null && str2 != null && str != null) {
            int m2 = m(context, str);
            if (m2 < 0) {
                return null;
            }
            WorkSource workSource = new WorkSource();
            Method method2 = f10463g;
            if (method2 != null && (method = f10464h) != null) {
                try {
                    Object invoke = method2.invoke(workSource, new Object[0]);
                    int i2 = a;
                    if (m2 != i2) {
                        method.invoke(invoke, Integer.valueOf(m2), str);
                    }
                    method.invoke(invoke, Integer.valueOf(i2), str2);
                } catch (Exception e2) {
                    Log.w("WorkSourceUtil", "Unable to assign chained blame through WorkSource", e2);
                }
            } else {
                h(workSource, m2, str);
            }
            return workSource;
        }
        Log.w("WorkSourceUtil", "Unexpected null arguments");
        return null;
    }

    @e.j.a.b.c.m.a
    public static List<String> c(@Nullable WorkSource workSource) {
        int e2 = workSource == null ? 0 : e(workSource);
        if (e2 == 0) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < e2; i2++) {
            String g2 = g(workSource, i2);
            if (!b0.b(g2)) {
                arrayList.add(g2);
            }
        }
        return arrayList;
    }

    @e.j.a.b.c.m.a
    public static boolean d(Context context) {
        return (context == null || context.getPackageManager() == null || e.j.a.b.c.y.c.a(context).b("android.permission.UPDATE_DEVICE_STATS", context.getPackageName()) != 0) ? false : true;
    }

    private static int e(WorkSource workSource) {
        Method method = f10460d;
        if (method != null) {
            try {
                return ((Integer) method.invoke(workSource, new Object[0])).intValue();
            } catch (Exception e2) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e2);
            }
        }
        return 0;
    }

    private static WorkSource f(int i2, String str) {
        WorkSource workSource = new WorkSource();
        h(workSource, i2, str);
        return workSource;
    }

    @Nullable
    private static String g(WorkSource workSource, int i2) {
        Method method = f10462f;
        if (method != null) {
            try {
                return (String) method.invoke(workSource, Integer.valueOf(i2));
            } catch (Exception e2) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e2);
                return null;
            }
        }
        return null;
    }

    private static void h(WorkSource workSource, int i2, @Nullable String str) {
        Method method = f10459c;
        if (method != null) {
            if (str == null) {
                str = "";
            }
            try {
                method.invoke(workSource, Integer.valueOf(i2), str);
                return;
            } catch (Exception e2) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e2);
                return;
            }
        }
        Method method2 = b;
        if (method2 != null) {
            try {
                method2.invoke(workSource, Integer.valueOf(i2));
            } catch (Exception e3) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e3);
            }
        }
    }

    private static Method i() {
        try {
            return WorkSource.class.getMethod("get", Integer.TYPE);
        } catch (Exception unused) {
            return null;
        }
    }

    private static Method j() {
        if (v.g()) {
            try {
                return WorkSource.class.getMethod("getName", Integer.TYPE);
            } catch (Exception unused) {
            }
        }
        return null;
    }

    private static final Method k() {
        if (v.o()) {
            try {
                return WorkSource.class.getMethod("createWorkChain", new Class[0]);
            } catch (Exception e2) {
                Log.w("WorkSourceUtil", "Missing WorkChain API createWorkChain", e2);
            }
        }
        return null;
    }

    @SuppressLint({"PrivateApi"})
    private static final Method l() {
        if (v.o()) {
            try {
                return Class.forName("android.os.WorkSource$WorkChain").getMethod("addNode", Integer.TYPE, String.class);
            } catch (Exception e2) {
                Log.w("WorkSourceUtil", "Missing WorkChain class", e2);
            }
        }
        return null;
    }

    private static int m(Context context, String str) {
        try {
            ApplicationInfo c2 = e.j.a.b.c.y.c.a(context).c(str, 0);
            if (c2 == null) {
                String valueOf = String.valueOf(str);
                Log.e("WorkSourceUtil", valueOf.length() != 0 ? "Could not get applicationInfo from package: ".concat(valueOf) : new String("Could not get applicationInfo from package: "));
                return -1;
            }
            return c2.uid;
        } catch (PackageManager.NameNotFoundException unused) {
            String valueOf2 = String.valueOf(str);
            Log.e("WorkSourceUtil", valueOf2.length() != 0 ? "Could not find package: ".concat(valueOf2) : new String("Could not find package: "));
            return -1;
        }
    }

    private static Method n() {
        try {
            return WorkSource.class.getMethod("add", Integer.TYPE);
        } catch (Exception unused) {
            return null;
        }
    }

    private static Method o() {
        if (v.g()) {
            try {
                return WorkSource.class.getMethod("add", Integer.TYPE, String.class);
            } catch (Exception unused) {
            }
        }
        return null;
    }

    private static Method p() {
        try {
            return WorkSource.class.getMethod("size", new Class[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
