package com.tencent.bugly.crashreport.crash;

import android.content.Context;
import android.os.Process;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.proguard.aa;
import com.tencent.bugly.proguard.ab;
import com.tencent.bugly.proguard.y;
import com.xiaomi.mipush.sdk.Constants;
import java.lang.Thread;
import java.util.HashMap;

/* loaded from: classes3.dex */
public final class e implements Thread.UncaughtExceptionHandler {

    /* renamed from: h  reason: collision with root package name */
    private static String f6622h;

    /* renamed from: i  reason: collision with root package name */
    private static final Object f6623i = new Object();
    private Context a;
    private b b;

    /* renamed from: c  reason: collision with root package name */
    private com.tencent.bugly.crashreport.common.strategy.a f6624c;

    /* renamed from: d  reason: collision with root package name */
    private com.tencent.bugly.crashreport.common.info.a f6625d;

    /* renamed from: e  reason: collision with root package name */
    private Thread.UncaughtExceptionHandler f6626e;

    /* renamed from: f  reason: collision with root package name */
    private Thread.UncaughtExceptionHandler f6627f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f6628g = false;

    /* renamed from: j  reason: collision with root package name */
    private int f6629j;

    public e(Context context, b bVar, com.tencent.bugly.crashreport.common.strategy.a aVar, com.tencent.bugly.crashreport.common.info.a aVar2) {
        this.a = context;
        this.b = bVar;
        this.f6624c = aVar;
        this.f6625d = aVar2;
    }

    public final synchronized void a() {
        if (this.f6629j >= 10) {
            y.a("java crash handler over %d, no need set.", 10);
            return;
        }
        this.f6628g = true;
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        if (defaultUncaughtExceptionHandler != null) {
            if (getClass().getName().equals(defaultUncaughtExceptionHandler.getClass().getName())) {
                return;
            }
            if ("com.android.internal.os.RuntimeInit$UncaughtHandler".equals(defaultUncaughtExceptionHandler.getClass().getName())) {
                y.a("backup system java handler: %s", defaultUncaughtExceptionHandler.toString());
                this.f6627f = defaultUncaughtExceptionHandler;
                this.f6626e = defaultUncaughtExceptionHandler;
            } else {
                y.a("backup java handler: %s", defaultUncaughtExceptionHandler.toString());
                this.f6626e = defaultUncaughtExceptionHandler;
            }
        }
        Thread.setDefaultUncaughtExceptionHandler(this);
        this.f6629j++;
        y.a("registered java monitor: %s", toString());
    }

    public final synchronized void b() {
        this.f6628g = false;
        y.a("close java monitor!", new Object[0]);
        if ("bugly".equals(Thread.getDefaultUncaughtExceptionHandler().getClass().getName())) {
            y.a("Java monitor to unregister: %s", toString());
            Thread.setDefaultUncaughtExceptionHandler(this.f6626e);
            this.f6629j--;
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th) {
        synchronized (f6623i) {
            a(thread, th, true, null, null, this.f6625d.h());
        }
    }

    private CrashDetailBean b(Thread thread, Throwable th, boolean z, String str, byte[] bArr, boolean z2) {
        if (th == null) {
            y.d("We can do nothing with a null throwable.", new Object[0]);
            return null;
        }
        CrashDetailBean crashDetailBean = new CrashDetailBean();
        crashDetailBean.r = System.currentTimeMillis();
        crashDetailBean.C = com.tencent.bugly.crashreport.common.info.b.j();
        crashDetailBean.D = com.tencent.bugly.crashreport.common.info.b.e();
        crashDetailBean.E = com.tencent.bugly.crashreport.common.info.b.l();
        crashDetailBean.F = this.f6625d.o();
        crashDetailBean.G = this.f6625d.n();
        crashDetailBean.H = this.f6625d.p();
        crashDetailBean.I = com.tencent.bugly.crashreport.common.info.b.f();
        crashDetailBean.J = com.tencent.bugly.crashreport.common.info.b.g();
        crashDetailBean.K = com.tencent.bugly.crashreport.common.info.b.h();
        crashDetailBean.w = ab.a(c.f6600e, (String) null);
        byte[] a = aa.a();
        crashDetailBean.y = a;
        Object[] objArr = new Object[1];
        objArr[0] = Integer.valueOf(a == null ? 0 : a.length);
        y.a("user log size:%d", objArr);
        crashDetailBean.b = z ? 0 : 2;
        crashDetailBean.f6553e = this.f6625d.k();
        com.tencent.bugly.crashreport.common.info.a aVar = this.f6625d;
        crashDetailBean.f6554f = aVar.f6525i;
        crashDetailBean.f6555g = aVar.u();
        crashDetailBean.f6561m = this.f6625d.g();
        crashDetailBean.z = ab.a(z2, c.f6601f, false);
        crashDetailBean.A = this.f6625d.f6520d;
        crashDetailBean.B = thread.getName() + "(" + thread.getId() + ")";
        crashDetailBean.L = this.f6625d.w();
        crashDetailBean.f6556h = this.f6625d.t();
        crashDetailBean.f6557i = this.f6625d.F();
        com.tencent.bugly.crashreport.common.info.a aVar2 = this.f6625d;
        crashDetailBean.P = aVar2.a;
        crashDetailBean.Q = aVar2.a();
        a(crashDetailBean, th, z);
        try {
            if (z) {
                this.b.d(crashDetailBean);
            } else {
                boolean z3 = str != null && str.length() > 0;
                boolean z4 = bArr != null && bArr.length > 0;
                if (z3) {
                    HashMap hashMap = new HashMap(1);
                    crashDetailBean.R = hashMap;
                    hashMap.put("UserData", str);
                }
                if (z4) {
                    crashDetailBean.X = bArr;
                }
            }
            crashDetailBean.T = this.f6625d.D();
            crashDetailBean.U = this.f6625d.E();
            crashDetailBean.V = this.f6625d.x();
            crashDetailBean.W = this.f6625d.C();
        } catch (Throwable th2) {
            y.e("handle crash error %s", th2.toString());
        }
        return crashDetailBean;
    }

    private static String b(Throwable th, int i2) {
        String message = th.getMessage();
        if (message == null) {
            return "";
        }
        if (message.length() <= 1000) {
            return message;
        }
        return message.substring(0, 1000) + "\n[Message over limit size:1000, has been cutted!]";
    }

    private static void a(CrashDetailBean crashDetailBean, Throwable th, boolean z) {
        String a;
        String name = th.getClass().getName();
        String b = b(th, 1000);
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(th.getStackTrace().length);
        objArr[1] = Boolean.valueOf(th.getCause() != null);
        y.e("stack frame :%d, has cause %b", objArr);
        String str = "";
        String stackTraceElement = th.getStackTrace().length > 0 ? th.getStackTrace()[0].toString() : "";
        Throwable th2 = th;
        while (th2 != null && th2.getCause() != null) {
            th2 = th2.getCause();
        }
        if (th2 != null && th2 != th) {
            crashDetailBean.n = th2.getClass().getName();
            crashDetailBean.o = b(th2, 1000);
            if (th2.getStackTrace().length > 0) {
                crashDetailBean.p = th2.getStackTrace()[0].toString();
            }
            StringBuilder sb = new StringBuilder();
            sb.append(name);
            sb.append(Constants.COLON_SEPARATOR);
            sb.append(b);
            sb.append("\n");
            sb.append(stackTraceElement);
            sb.append("\n......");
            sb.append("\nCaused by:\n");
            sb.append(crashDetailBean.n);
            sb.append(Constants.COLON_SEPARATOR);
            sb.append(crashDetailBean.o);
            sb.append("\n");
            a = a(th2, c.f6601f);
            sb.append(a);
            crashDetailBean.q = sb.toString();
        } else {
            crashDetailBean.n = name;
            if (c.a().m() && z) {
                y.e("This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful!", new Object[0]);
                str = " This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful![Bugly]";
            }
            crashDetailBean.o = b + str;
            crashDetailBean.p = stackTraceElement;
            a = a(th, c.f6601f);
            crashDetailBean.q = a;
        }
        crashDetailBean.u = ab.a(crashDetailBean.q.getBytes());
        crashDetailBean.z.put(crashDetailBean.B, a);
    }

    private static boolean a(Thread thread) {
        synchronized (f6623i) {
            if (f6622h == null || !thread.getName().equals(f6622h)) {
                f6622h = thread.getName();
                return false;
            }
            return true;
        }
    }

    public final void a(Thread thread, Throwable th, boolean z, String str, byte[] bArr, boolean z2) {
        if (z) {
            y.e("Java Crash Happen cause by %s(%d)", thread.getName(), Long.valueOf(thread.getId()));
            if (a(thread)) {
                y.a("this class has handled this exception", new Object[0]);
                if (this.f6627f != null) {
                    y.a("call system handler", new Object[0]);
                    this.f6627f.uncaughtException(thread, th);
                } else {
                    y.e("current process die", new Object[0]);
                    Process.killProcess(Process.myPid());
                    System.exit(1);
                }
            }
        } else {
            y.e("Java Catch Happen", new Object[0]);
        }
        try {
            if (!this.f6628g) {
                y.c("Java crash handler is disable. Just return.", new Object[0]);
                if (z) {
                    Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f6626e;
                    if (uncaughtExceptionHandler != null && a(uncaughtExceptionHandler)) {
                        y.e("sys default last handle start!", new Object[0]);
                        this.f6626e.uncaughtException(thread, th);
                        y.e("sys default last handle end!", new Object[0]);
                        return;
                    } else if (this.f6627f != null) {
                        y.e("system handle start!", new Object[0]);
                        this.f6627f.uncaughtException(thread, th);
                        y.e("system handle end!", new Object[0]);
                        return;
                    } else {
                        y.e("crashreport last handle start!", new Object[0]);
                        y.e("current process die", new Object[0]);
                        Process.killProcess(Process.myPid());
                        System.exit(1);
                        y.e("crashreport last handle end!", new Object[0]);
                        return;
                    }
                }
                return;
            }
            if (!this.f6624c.b()) {
                y.d("no remote but still store!", new Object[0]);
            }
            if (!this.f6624c.c().f6533e && this.f6624c.b()) {
                y.e("crash report was closed by remote , will not upload to Bugly , print local for helpful!", new Object[0]);
                b.a(z ? "JAVA_CRASH" : "JAVA_CATCH", ab.a(), this.f6625d.f6520d, thread.getName(), ab.a(th), (CrashDetailBean) null);
                if (z) {
                    Thread.UncaughtExceptionHandler uncaughtExceptionHandler2 = this.f6626e;
                    if (uncaughtExceptionHandler2 != null && a(uncaughtExceptionHandler2)) {
                        y.e("sys default last handle start!", new Object[0]);
                        this.f6626e.uncaughtException(thread, th);
                        y.e("sys default last handle end!", new Object[0]);
                        return;
                    } else if (this.f6627f != null) {
                        y.e("system handle start!", new Object[0]);
                        this.f6627f.uncaughtException(thread, th);
                        y.e("system handle end!", new Object[0]);
                        return;
                    } else {
                        y.e("crashreport last handle start!", new Object[0]);
                        y.e("current process die", new Object[0]);
                        Process.killProcess(Process.myPid());
                        System.exit(1);
                        y.e("crashreport last handle end!", new Object[0]);
                        return;
                    }
                }
                return;
            }
            CrashDetailBean b = b(thread, th, z, str, bArr, z2);
            if (b == null) {
                y.e("pkg crash datas fail!", new Object[0]);
                if (z) {
                    Thread.UncaughtExceptionHandler uncaughtExceptionHandler3 = this.f6626e;
                    if (uncaughtExceptionHandler3 != null && a(uncaughtExceptionHandler3)) {
                        y.e("sys default last handle start!", new Object[0]);
                        this.f6626e.uncaughtException(thread, th);
                        y.e("sys default last handle end!", new Object[0]);
                        return;
                    } else if (this.f6627f != null) {
                        y.e("system handle start!", new Object[0]);
                        this.f6627f.uncaughtException(thread, th);
                        y.e("system handle end!", new Object[0]);
                        return;
                    } else {
                        y.e("crashreport last handle start!", new Object[0]);
                        y.e("current process die", new Object[0]);
                        Process.killProcess(Process.myPid());
                        System.exit(1);
                        y.e("crashreport last handle end!", new Object[0]);
                        return;
                    }
                }
                return;
            }
            b.a(z ? "JAVA_CRASH" : "JAVA_CATCH", ab.a(), this.f6625d.f6520d, thread.getName(), ab.a(th), b);
            if (!this.b.a(b)) {
                this.b.a(b, 3000L, z);
            }
            if (z) {
                this.b.c(b);
            }
            if (z) {
                Thread.UncaughtExceptionHandler uncaughtExceptionHandler4 = this.f6626e;
                if (uncaughtExceptionHandler4 != null && a(uncaughtExceptionHandler4)) {
                    y.e("sys default last handle start!", new Object[0]);
                    this.f6626e.uncaughtException(thread, th);
                    y.e("sys default last handle end!", new Object[0]);
                } else if (this.f6627f != null) {
                    y.e("system handle start!", new Object[0]);
                    this.f6627f.uncaughtException(thread, th);
                    y.e("system handle end!", new Object[0]);
                } else {
                    y.e("crashreport last handle start!", new Object[0]);
                    y.e("current process die", new Object[0]);
                    Process.killProcess(Process.myPid());
                    System.exit(1);
                    y.e("crashreport last handle end!", new Object[0]);
                }
            }
        } catch (Throwable th2) {
            try {
                if (!y.a(th2)) {
                    th2.printStackTrace();
                }
                if (z) {
                    Thread.UncaughtExceptionHandler uncaughtExceptionHandler5 = this.f6626e;
                    if (uncaughtExceptionHandler5 != null && a(uncaughtExceptionHandler5)) {
                        y.e("sys default last handle start!", new Object[0]);
                        this.f6626e.uncaughtException(thread, th);
                        y.e("sys default last handle end!", new Object[0]);
                    } else if (this.f6627f != null) {
                        y.e("system handle start!", new Object[0]);
                        this.f6627f.uncaughtException(thread, th);
                        y.e("system handle end!", new Object[0]);
                    } else {
                        y.e("crashreport last handle start!", new Object[0]);
                        y.e("current process die", new Object[0]);
                        Process.killProcess(Process.myPid());
                        System.exit(1);
                        y.e("crashreport last handle end!", new Object[0]);
                    }
                }
            } catch (Throwable th3) {
                if (z) {
                    Thread.UncaughtExceptionHandler uncaughtExceptionHandler6 = this.f6626e;
                    if (uncaughtExceptionHandler6 != null && a(uncaughtExceptionHandler6)) {
                        y.e("sys default last handle start!", new Object[0]);
                        this.f6626e.uncaughtException(thread, th);
                        y.e("sys default last handle end!", new Object[0]);
                    } else if (this.f6627f != null) {
                        y.e("system handle start!", new Object[0]);
                        this.f6627f.uncaughtException(thread, th);
                        y.e("system handle end!", new Object[0]);
                    } else {
                        y.e("crashreport last handle start!", new Object[0]);
                        y.e("current process die", new Object[0]);
                        Process.killProcess(Process.myPid());
                        System.exit(1);
                        y.e("crashreport last handle end!", new Object[0]);
                    }
                }
                throw th3;
            }
        }
    }

    private static boolean a(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        StackTraceElement[] stackTrace;
        if (uncaughtExceptionHandler == null) {
            return true;
        }
        String name = uncaughtExceptionHandler.getClass().getName();
        for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
            String className = stackTraceElement.getClassName();
            String methodName = stackTraceElement.getMethodName();
            if (name.equals(className) && "uncaughtException".equals(methodName)) {
                return false;
            }
        }
        return true;
    }

    public final synchronized void a(StrategyBean strategyBean) {
        if (strategyBean != null) {
            boolean z = strategyBean.f6533e;
            if (z != this.f6628g) {
                y.a("java changed to %b", Boolean.valueOf(z));
                if (strategyBean.f6533e) {
                    a();
                    return;
                }
                b();
            }
        }
    }

    private static String a(Throwable th, int i2) {
        StackTraceElement[] stackTrace;
        if (th == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        try {
            if (th.getStackTrace() != null) {
                for (StackTraceElement stackTraceElement : th.getStackTrace()) {
                    if (i2 > 0 && sb.length() >= i2) {
                        sb.append("\n[Stack over limit size :" + i2 + " , has been cutted !]");
                        return sb.toString();
                    }
                    sb.append(stackTraceElement.toString());
                    sb.append("\n");
                }
            }
        } catch (Throwable th2) {
            y.e("gen stack error %s", th2.toString());
        }
        return sb.toString();
    }
}
