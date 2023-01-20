package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.baidu.mobads.sdk.api.IXAdContainerFactory;
import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class cd implements Thread.UncaughtExceptionHandler {
    public static String a = "";
    private static final String b = "remote";

    /* renamed from: c  reason: collision with root package name */
    private static final String f1566c = "proxy";

    /* renamed from: d  reason: collision with root package name */
    private static final String f1567d = "third-mtj";

    /* renamed from: e  reason: collision with root package name */
    private static final String f1568e = "third-novel";

    /* renamed from: f  reason: collision with root package name */
    private static Thread.UncaughtExceptionHandler f1569f = null;

    /* renamed from: g  reason: collision with root package name */
    private static volatile cd f1570g = null;

    /* renamed from: j  reason: collision with root package name */
    private static final String f1571j = "key_crash_source";

    /* renamed from: k  reason: collision with root package name */
    private static final String f1572k = "key_crash_trace";

    /* renamed from: l  reason: collision with root package name */
    private static final String f1573l = "key_crash_ad";

    /* renamed from: h  reason: collision with root package name */
    private Context f1574h;

    /* renamed from: i  reason: collision with root package name */
    private a f1575i;

    /* loaded from: classes.dex */
    public interface a {
        void a(String str);
    }

    private cd(Context context) {
        this.f1574h = context.getApplicationContext();
        f1569f = Thread.getDefaultUncaughtExceptionHandler();
    }

    private List<String> d() {
        IXAdContainerFactory c2;
        ArrayList arrayList = new ArrayList();
        try {
            y a2 = y.a();
            if (a2 != null && (c2 = a2.c()) != null) {
                Object remoteParam = c2.getRemoteParam("appCommonConfig", "getCrashPackage");
                if (remoteParam instanceof List) {
                    arrayList.addAll((List) remoteParam);
                }
            }
        } catch (Throwable unused) {
        }
        return arrayList;
    }

    private SharedPreferences e() {
        return this.f1574h.getSharedPreferences("baidu_mobads_crash", 0);
    }

    private SharedPreferences.Editor f() {
        return e().edit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        SharedPreferences.Editor f2 = f();
        f2.clear();
        f2.apply();
    }

    public void c() {
        this.f1575i = null;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        try {
            String a2 = a(th);
            if (a2 != null) {
                a(a2, Log.getStackTraceString(th));
                a aVar = this.f1575i;
                if (aVar != null) {
                    aVar.a(a2);
                }
            }
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = f1569f;
            if (uncaughtExceptionHandler != null) {
                uncaughtExceptionHandler.uncaughtException(thread, th);
            }
        } catch (Exception e2) {
            bj.a().c(e2);
        }
    }

    public void b() {
        if (Thread.getDefaultUncaughtExceptionHandler() instanceof cd) {
            return;
        }
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    public static cd a(Context context) {
        if (f1570g == null) {
            synchronized (cd.class) {
                if (f1570g == null) {
                    f1570g = new cd(context);
                }
            }
        }
        return f1570g;
    }

    public void a() {
        at.a().a((h) new ce(this));
    }

    public void a(a aVar) {
        this.f1575i = aVar;
    }

    private String a(Throwable th) {
        Throwable cause = th.getCause();
        if (cause != null) {
            th = cause;
        }
        StackTraceElement[] stackTrace = th.getStackTrace();
        if (stackTrace != null && stackTrace.length > 0) {
            List<String> d2 = d();
            for (StackTraceElement stackTraceElement : stackTrace) {
                String className = stackTraceElement.getClassName();
                if (className.startsWith("junit.framework")) {
                    break;
                } else if (className.startsWith(v.an) || className.startsWith(v.ao) || className.startsWith(v.ap)) {
                    return b;
                } else {
                    if (className.startsWith(v.aq) || className.startsWith(v.ar) || className.startsWith(v.as)) {
                        return f1566c;
                    }
                    if (className.startsWith(v.at)) {
                        return f1567d;
                    }
                    if (!className.startsWith(v.au) && !className.startsWith(v.av)) {
                        if (a(className, d2)) {
                            return b;
                        }
                    } else if (cc.f1564g.booleanValue()) {
                        return f1568e;
                    }
                }
            }
        }
        return null;
    }

    private boolean a(String str, List<String> list) {
        for (String str2 : list) {
            if (str.startsWith(str2)) {
                return true;
            }
        }
        return false;
    }

    public void a(String str, String str2) {
        SharedPreferences.Editor f2 = f();
        f2.putString(f1571j, str);
        f2.putString(f1572k, ("crashtime:" + System.currentTimeMillis() + ExpandableTextView.N) + str2);
        f2.putString(f1573l, a);
        f2.commit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(String str) {
        return e().getString(str, "");
    }
}
