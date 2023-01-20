package com.baidu.mobads.sdk.internal;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.mobads.sdk.api.IXAdContainerFactory;
import com.tencent.android.tpns.mqtt.MqttTopic;
import java.io.File;
import java.io.FileInputStream;
import java.lang.Thread;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import java.util.jar.JarFile;

/* loaded from: classes.dex */
public class bp {
    public static final String a = "ApkLoader";
    public static Thread.UncaughtExceptionHandler b = null;

    /* renamed from: c  reason: collision with root package name */
    public static final String f1524c = "__badApkVersion__9.24";

    /* renamed from: d  reason: collision with root package name */
    public static final String f1525d = "previousProxyVersion";

    /* renamed from: e  reason: collision with root package name */
    public static final String f1526e = "__xadsdk__remote__final__";

    /* renamed from: f  reason: collision with root package name */
    public static final String f1527f = "bdxadsdk.jar";

    /* renamed from: g  reason: collision with root package name */
    public static final String f1528g = "__xadsdk__remote__final__builtin__.jar";

    /* renamed from: h  reason: collision with root package name */
    public static final String f1529h = "__xadsdk__remote__final__builtinversion__.jar";

    /* renamed from: i  reason: collision with root package name */
    public static final String f1530i = "__xadsdk__remote__final__downloaded__.jar";

    /* renamed from: j  reason: collision with root package name */
    public static final String f1531j = "__xadsdk__remote__final__running__.jar";

    /* renamed from: k  reason: collision with root package name */
    public static final String f1532k = "OK";

    /* renamed from: l  reason: collision with root package name */
    public static final String f1533l = "ERROR";

    /* renamed from: m  reason: collision with root package name */
    public static final String f1534m = "APK_INFO";
    public static final String n = "CODE";
    public static final String o = "success";
    public static volatile be p = null;
    public static volatile be q = null;
    public static volatile Class r = null;
    public static String s = null;
    public static final Handler t = new bq(Looper.getMainLooper());
    private static final String x = "baidu_sdk_remote";
    private boolean A;
    private CopyOnWriteArrayList<c> B;
    private c C;
    public Handler u;
    @SuppressLint({"HandlerLeak"})
    public final Handler v;
    private bn w;
    private final Context y;
    private bj z;

    /* loaded from: classes.dex */
    public static final class a extends Exception {
        private static final long a = 2978543166232984104L;

        public a(String str) {
            bj.a().c(str);
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends Exception {
        private static final long a = -7838296421993681751L;

        public b(String str) {
            bj.a().c(str);
        }
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(boolean z);
    }

    public bp(Activity activity) {
        this(activity.getApplicationContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        try {
            File[] listFiles = this.y.getFilesDir().listFiles();
            int i2 = 0;
            while (listFiles != null) {
                if (i2 >= listFiles.length) {
                    return;
                }
                if (listFiles[i2].getAbsolutePath().contains(f1526e) && listFiles[i2].getAbsolutePath().endsWith("dex")) {
                    listFiles[i2].delete();
                }
                i2++;
            }
        } catch (Exception e2) {
            bj.a().c(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SharedPreferences m() {
        return this.y.getSharedPreferences(v.aw, 0);
    }

    private boolean n() {
        String string = m().getString(f1525d, null);
        return string == null || !string.equals(a());
    }

    private boolean o() {
        try {
            if (!bh.a(c())) {
                if (!bh.a(f())) {
                    return false;
                }
            }
            return true;
        } catch (Exception e2) {
            this.z.a(e2);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean p() {
        bi biVar = new bi(f(), this.y);
        if (bh.a(biVar)) {
            try {
                if (!n()) {
                    synchronized (this) {
                        bj bjVar = this.z;
                        bjVar.a(a, "loadDownloadedOrBuiltInApk len=" + biVar.length() + ", path=" + biVar.getAbsolutePath());
                        b(biVar);
                        double d2 = (double) m().getFloat(f1524c, -1.0f);
                        bj bjVar2 = this.z;
                        bjVar2.a(a, "downloadedApkFile.getApkVersion(): " + biVar.c() + ", badApkVersion: " + d2);
                        if (biVar.c() != d2) {
                            bj bjVar3 = this.z;
                            bjVar3.a(a, "loaded: " + biVar.getPath());
                        } else {
                            throw new a("downloaded file marked bad, drop it and use built-in");
                        }
                    }
                    return true;
                }
                throw new a("XAdApkLoader upgraded, drop stale downloaded file, use built-in instead");
            } catch (a e2) {
                bj bjVar4 = this.z;
                bjVar4.a(a, "load downloaded apk failed: " + e2.toString() + ", fallback to built-in");
                if (biVar.exists()) {
                    biVar.delete();
                }
                k();
                return false;
            }
        }
        return false;
    }

    public final String a() {
        return "9.24";
    }

    public int h() {
        return this.y.getApplicationContext().getSharedPreferences("baidu_cloudControlConfig", 0).getInt("baidu_cloudConfig_pktype", 1);
    }

    public IXAdContainerFactory i() {
        return a(p);
    }

    public IXAdContainerFactory j() {
        return a(q);
    }

    public void k() {
        if (p != null) {
            p.b();
            p = null;
        }
    }

    public bp(Context context) {
        this.z = bj.a();
        this.A = false;
        this.u = t;
        this.B = new CopyOnWriteArrayList<>();
        this.v = new br(this, Looper.getMainLooper());
        this.y = context;
        c(context);
        if (b == null) {
            b = cd.a(context);
            cd.a(context).a(new bs(this));
        }
        if (Thread.getDefaultUncaughtExceptionHandler() instanceof cd) {
            return;
        }
        Thread.setDefaultUncaughtExceptionHandler(b);
    }

    public static String f() {
        if (TextUtils.isEmpty(s)) {
            return "";
        }
        return s + f1530i;
    }

    public void e() {
        this.z.a(a, "start load assets file");
        d(this.y);
        String c2 = c();
        bi biVar = new bi(c2, this.y);
        if (bh.a(biVar)) {
            this.z.a(a, "assets file can read ,will use it ");
            if (c(biVar)) {
                b(true);
                return;
            }
            return;
        }
        throw new b("loadBuiltInApk failed: " + c2);
    }

    public void g() {
        if (h() != 2 ? p() : false) {
            this.z.a(a, "load downloaded file success,use it");
            b(true);
            return;
        }
        this.z.a(a, "no downloaded file yet, use built-in apk file");
        try {
            e();
        } catch (b e2) {
            bj bjVar = this.z;
            bjVar.a(a, "loadBuiltInApk failed: " + e2.toString());
            throw new a("load built-in apk failed" + e2.toString());
        }
    }

    private static void c(Context context) {
        if (TextUtils.isEmpty(s)) {
            File dir = context.getDir(x, 0);
            s = dir.getAbsolutePath() + MqttTopic.TOPIC_LEVEL_SEPARATOR;
        }
    }

    public static String d() {
        if (TextUtils.isEmpty(s)) {
            return "";
        }
        return s + f1529h;
    }

    public void b() {
        new File(f()).delete();
    }

    private static synchronized void d(Context context) {
        synchronized (bp.class) {
            try {
                String c2 = c();
                double b2 = b(c2);
                bj a2 = bj.a();
                a2.a(a, "copy assets,compare version=" + Double.valueOf("9.24") + "remote=" + b2);
                if (Double.valueOf("9.24").doubleValue() != b2) {
                    bi biVar = new bi(c2, context);
                    if (biVar.exists()) {
                        biVar.delete();
                    }
                    bh.a(context, f1527f, c2);
                }
            } catch (Exception e2) {
                throw new b("loadBuiltInApk failed: " + e2.toString());
            }
        }
    }

    private void b(bi biVar) {
        bj bjVar = this.z;
        bjVar.a(a, "len=" + biVar.length() + ", path=" + biVar.getAbsolutePath());
        if (p == null) {
            String a2 = a(this.y);
            bi biVar2 = new bi(a2, this.y);
            if (biVar2.exists()) {
                biVar2.delete();
            }
            try {
                bh.a(new FileInputStream(biVar), a2);
            } catch (Exception e2) {
                this.z.c(e2);
            }
            p = new be(biVar2.b(), this.y);
            try {
                IXAdContainerFactory a3 = p.a();
                bj bjVar2 = this.z;
                bjVar2.a(a, "preloaded apk.version=" + a3.getRemoteVersion());
                return;
            } catch (a e3) {
                bj bjVar3 = this.z;
                bjVar3.a(a, "preload local apk " + biVar.getAbsolutePath() + " failed, msg:" + e3.getMessage() + ", v=" + p.b);
                a(e3.getMessage());
                throw e3;
            }
        }
        bj bjVar4 = this.z;
        bjVar4.a(a, "mApkBuilder already initialized, version: " + p.b);
    }

    public static String c() {
        if (TextUtils.isEmpty(s)) {
            return "";
        }
        return s + f1528g;
    }

    @TargetApi(9)
    public void a(String str) {
        if (p != null) {
            SharedPreferences.Editor edit = m().edit();
            edit.putFloat(f1524c, (float) p.b);
            edit.apply();
        }
    }

    private boolean c(bi biVar) {
        synchronized (this) {
            b(biVar);
            bj bjVar = this.z;
            bjVar.a(a, "loaded: " + biVar.getPath());
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        Message obtainMessage = this.u.obtainMessage();
        Bundle bundle = new Bundle();
        bundle.putBoolean(o, z);
        obtainMessage.setData(bundle);
        obtainMessage.what = 0;
        this.u.sendMessage(obtainMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z) {
        double d2;
        if (z) {
            try {
                d2 = p.b;
            } catch (Exception unused) {
                return;
            }
        } else {
            d2 = 0.0d;
        }
        al.a(d2, new bv(this, d2), new bw(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(bi biVar) {
        Class<?> b2 = biVar.b();
        synchronized (this) {
            q = new be(b2, this.y);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(boolean z, String str) {
        try {
            cd.a(this.y).c();
            CopyOnWriteArrayList<c> copyOnWriteArrayList = this.B;
            if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0) {
                for (int i2 = 0; i2 < this.B.size(); i2++) {
                    c cVar = this.B.get(i2);
                    if (cVar != null) {
                        cVar.a(z);
                    }
                }
            }
            CopyOnWriteArrayList<c> copyOnWriteArrayList2 = this.B;
            if (copyOnWriteArrayList2 != null) {
                copyOnWriteArrayList2.clear();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        if (!z && !o()) {
            this.A = true;
        } else {
            a(z, z ? "apk Successfully Loaded" : "apk Load Failed");
        }
        if (this.A) {
            at.a().a((h) new bt(this, z));
        } else {
            at.a().a(new bu(this, z), 5L, TimeUnit.SECONDS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(c cVar, Handler handler) {
        CopyOnWriteArrayList<c> copyOnWriteArrayList = this.B;
        if (copyOnWriteArrayList != null && !copyOnWriteArrayList.contains(cVar)) {
            this.B.add(cVar);
        }
        this.u = handler;
        if (p == null) {
            g();
        } else {
            b(true);
        }
    }

    public static String a(Context context) {
        if (TextUtils.isEmpty(s)) {
            File dir = context.getDir(x, 0);
            s = dir.getAbsolutePath() + MqttTopic.TOPIC_LEVEL_SEPARATOR;
        }
        if (TextUtils.isEmpty(s)) {
            return "";
        }
        return s + f1531j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(bn bnVar) {
        if (bnVar.a().booleanValue()) {
            bl a2 = bl.a(this.y, bnVar, s, this.v);
            if (!a2.isAlive()) {
                this.z.a(a, "XApkDownloadThread starting ...");
                a2.start();
                return;
            }
            this.z.a(a, "XApkDownloadThread already started");
            a2.a(bnVar.c());
        }
    }

    public static double b(Context context) {
        try {
            c(context);
            double b2 = b(f());
            String d2 = d();
            if (Double.valueOf("9.24").doubleValue() > b(d2)) {
                bi biVar = new bi(d2, context);
                if (biVar.exists()) {
                    biVar.delete();
                }
                bh.a(context, f1527f, d2);
            }
            return Math.max(b2, b(d()));
        } catch (Exception unused) {
            return 0.0d;
        }
    }

    @TargetApi(9)
    public void a(c cVar, Handler handler) {
        at.a().a((h) new bx(this, cVar, handler));
    }

    public void a(c cVar) {
        a(cVar, t);
    }

    private IXAdContainerFactory a(be beVar) {
        if (beVar != null) {
            try {
                return beVar.a();
            } catch (Exception unused) {
                return null;
            }
        }
        return null;
    }

    public static double b(String str) {
        JarFile jarFile = null;
        try {
            try {
            } catch (Exception unused) {
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (cc.f1561d.booleanValue()) {
            File file = new File(str);
            if (bh.a(file)) {
                JarFile jarFile2 = new JarFile(file);
                try {
                    double parseDouble = Double.parseDouble(jarFile2.getManifest().getMainAttributes().getValue("Implementation-Version"));
                    if (parseDouble > 0.0d) {
                        try {
                            jarFile2.close();
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                        return parseDouble;
                    }
                    jarFile = jarFile2;
                } catch (Exception unused2) {
                    jarFile = jarFile2;
                    if (jarFile != null) {
                        jarFile.close();
                    }
                    return 0.0d;
                } catch (Throwable th2) {
                    th = th2;
                    jarFile = jarFile2;
                    if (jarFile != null) {
                        try {
                            jarFile.close();
                        } catch (Exception e4) {
                            e4.printStackTrace();
                        }
                    }
                    throw th;
                }
            }
            if (jarFile != null) {
                jarFile.close();
            }
            return 0.0d;
        }
        return Double.valueOf("9.24").doubleValue();
    }
}
