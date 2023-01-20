package com.qq.e.comm.managers.plugin;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.jihuanshe.mmkv.UserKV;
import com.qq.e.comm.constants.Sig;
import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.GDTLogger;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class PM {
    private static final Map<Class<?>, String> q = new b();
    private final Context b;

    /* renamed from: c */
    private String f5079c;

    /* renamed from: d */
    private File f5080d;

    /* renamed from: e */
    private volatile int f5081e;

    /* renamed from: f */
    private DexClassLoader f5082f;

    /* renamed from: g */
    private RandomAccessFile f5083g;

    /* renamed from: h */
    private FileLock f5084h;

    /* renamed from: i */
    private boolean f5085i;

    /* renamed from: j */
    private final f f5086j;

    /* renamed from: k */
    private volatile POFactory f5087k;

    /* renamed from: l */
    private int f5088l;

    /* renamed from: m */
    private Future<Boolean> f5089m;
    private boolean o;
    private String p;
    public final ExecutorService a = Executors.newSingleThreadExecutor();
    private boolean n = false;

    /* loaded from: classes3.dex */
    public class a implements Callable<Boolean> {
        public a() {
            PM.this = r1;
        }

        @Override // java.util.concurrent.Callable
        public Boolean call() throws Exception {
            long currentTimeMillis = System.currentTimeMillis();
            if (!PM.this.f5085i) {
                PM pm = PM.this;
                pm.f5085i = pm.tryLockUpdate();
            }
            if (PM.f(PM.this)) {
                PM.g(PM.this);
            }
            PM.this.f5088l = (int) (System.currentTimeMillis() - currentTimeMillis);
            return Boolean.TRUE;
        }
    }

    /* loaded from: classes3.dex */
    public static class b extends HashMap<Class<?>, String> {
        public b() {
            put(POFactory.class, "com.qq.e.comm.plugin.POFactoryImpl");
        }
    }

    public PM(Context context, f fVar) {
        this.b = context.getApplicationContext();
        this.f5086j = fVar;
        com.qq.e.comm.managers.plugin.b.a(context);
        i();
    }

    private JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            int pluginVersion = getPluginVersion();
            if (pluginVersion > 10000) {
                jSONObject.put("vas", this.p);
            }
            jSONObject.put("pv", pluginVersion);
            jSONObject.put(UserKV.f3916f, this.f5079c);
            jSONObject.put("appId", com.qq.e.comm.managers.b.b().a());
            jSONObject.put("pn", com.qq.e.comm.managers.plugin.b.a(this.b));
            jSONObject.put("ict", this.f5088l);
            jSONObject.put("mup", this.f5085i);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    private boolean e() {
        if (this.f5085i) {
            try {
                Context context = this.b;
                com.qq.e.comm.managers.plugin.b.b(context, h.g(context), h.h(this.b));
                this.f5079c = Sig.ASSET_PLUGIN_SIG;
                this.f5080d = h.g(this.b);
                this.f5081e = SDKStatus.getBuildInPluginVersion();
                return true;
            } catch (Throwable th) {
                GDTLogger.e("插件初始化失败 ");
                com.qq.e.comm.managers.plugin.a.a(th, th.getMessage());
                return false;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0028, code lost:
        if (r5.e() != false) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean f(com.qq.e.comm.managers.plugin.PM r5) {
        /*
            java.lang.String r0 = "TimeStap_AFTER_PLUGIN_INIT:"
            java.util.Objects.requireNonNull(r5)
            r1 = 0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L32
            r2.<init>()     // Catch: java.lang.Throwable -> L32
            java.lang.String r3 = "TimeStap_BEFORE_PLUGIN_INIT:"
            r2.append(r3)     // Catch: java.lang.Throwable -> L32
            long r3 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L32
            r2.append(r3)     // Catch: java.lang.Throwable -> L32
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L32
            com.qq.e.comm.util.GDTLogger.d(r2)     // Catch: java.lang.Throwable -> L32
            boolean r2 = r5.h()     // Catch: java.lang.Throwable -> L32
            if (r2 != 0) goto L2a
            boolean r5 = r5.e()     // Catch: java.lang.Throwable -> L32
            if (r5 == 0) goto L2c
        L2a:
            r5 = 1
            r1 = 1
        L2c:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            goto L45
        L32:
            r5 = move-exception
            java.lang.String r2 = "插件加载出现异常"
            com.qq.e.comm.util.GDTLogger.e(r2, r5)     // Catch: java.lang.Throwable -> L57
            java.lang.String r2 = r5.getMessage()     // Catch: java.lang.Throwable -> L57
            com.qq.e.comm.managers.plugin.a.a(r5, r2)     // Catch: java.lang.Throwable -> L57
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
        L45:
            r5.append(r0)
            long r2 = java.lang.System.currentTimeMillis()
            r5.append(r2)
            java.lang.String r5 = r5.toString()
            com.qq.e.comm.util.GDTLogger.d(r5)
            return r1
        L57:
            r5 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            long r2 = java.lang.System.currentTimeMillis()
            r1.append(r2)
            java.lang.String r0 = r1.toString()
            com.qq.e.comm.util.GDTLogger.d(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.managers.plugin.PM.f(com.qq.e.comm.managers.plugin.PM):boolean");
    }

    public static void g(PM pm) {
        Objects.requireNonNull(pm);
        StringBuilder sb = new StringBuilder();
        sb.append("PluginFile:\t");
        File file = pm.f5080d;
        sb.append(file == null ? "null" : file.getAbsolutePath());
        GDTLogger.d(sb.toString());
        if (pm.f5079c == null || pm.f5080d == null) {
            pm.f5082f = null;
            return;
        }
        try {
            pm.f5082f = new DexClassLoader(pm.f5080d.getAbsolutePath(), h.a(pm.b).getAbsolutePath(), null, pm.getClass().getClassLoader());
            f fVar = pm.f5086j;
            if (fVar != null) {
                fVar.a();
            }
        } catch (Throwable th) {
            GDTLogger.e("插件ClassLoader构造发生异常", th);
            f fVar2 = pm.f5086j;
            if (fVar2 != null) {
                fVar2.b();
            }
            com.qq.e.comm.managers.plugin.a.a(th, th.getMessage());
        }
    }

    private boolean h() {
        if (this.o) {
            return false;
        }
        if (this.f5085i) {
            g gVar = new g(h.e(this.b), h.f(this.b));
            if (gVar.b()) {
                boolean c2 = gVar.c(h.g(this.b), h.h(this.b));
                GDTLogger.d("NextExist,Updated=" + c2);
            }
        }
        g gVar2 = new g(h.g(this.b), h.h(this.b));
        if (gVar2.b()) {
            if (gVar2.f() >= SDKStatus.getBuildInPluginVersion()) {
                this.f5079c = gVar2.e();
                this.f5081e = gVar2.f();
                this.f5080d = h.g(this.b);
                this.p = gVar2.d();
                this.n = true;
                return true;
            }
            GDTLogger.d("last updated plugin version =" + this.f5081e + ";asset plugin version=" + SDKStatus.getBuildInPluginVersion());
            return false;
        }
        return false;
    }

    private void i() {
        this.n = false;
        SharedPreferences sharedPreferences = this.b.getSharedPreferences("start_crash", 0);
        if (sharedPreferences.getInt("crash_count", 0) >= 2) {
            this.o = true;
            sharedPreferences.edit().remove("crash_count").commit();
            GDTLogger.e("加载本地插件");
        }
        this.f5089m = this.a.submit(new a());
    }

    public <T> T getFactory(Class<T> cls) throws e {
        Future<Boolean> future = this.f5089m;
        if (future != null) {
            try {
                future.get();
            } catch (InterruptedException | ExecutionException unused) {
            }
        }
        GDTLogger.d("GetFactoryInstaceforInterface:" + cls);
        ClassLoader classLoader = Sig.ASSET_PLUGIN_SIG == null ? PM.class.getClassLoader() : this.f5082f;
        StringBuilder sb = new StringBuilder();
        sb.append("PluginClassLoader is parent");
        sb.append(PM.class.getClassLoader() == classLoader);
        GDTLogger.d(sb.toString());
        if (classLoader == null) {
            throw new e("Fail to init GDTADPLugin,PluginClassLoader == null;while loading factory impl for:" + cls);
        }
        try {
            String str = q.get(cls);
            if (TextUtils.isEmpty(str)) {
                throw new e("factory  implemention name is not specified for interface:" + cls.getName());
            }
            Class<?> loadClass = classLoader.loadClass(str);
            T cast = cls.cast(loadClass.getDeclaredMethod("getInstance", Context.class, JSONObject.class).invoke(loadClass, this.b, b()));
            GDTLogger.d("ServiceDelegateFactory =" + cast);
            return cast;
        } catch (Throwable th) {
            throw new e("Fail to getfactory implement instance for interface:" + cls.getName(), th);
        }
    }

    public POFactory getPOFactory() throws e {
        if (this.f5087k == null) {
            synchronized (this) {
                if (this.f5087k == null) {
                    try {
                        this.f5087k = (POFactory) getFactory(POFactory.class);
                    } catch (e e2) {
                        if (!this.n) {
                            throw e2;
                        }
                        GDTLogger.e("插件加载错误，回退到内置版本");
                        this.o = true;
                        i();
                        this.f5087k = (POFactory) getFactory(POFactory.class);
                    }
                }
            }
        }
        return this.f5087k;
    }

    public int getPluginVersion() {
        Future<Boolean> future = this.f5089m;
        if (future != null) {
            try {
                future.get();
            } catch (InterruptedException | ExecutionException unused) {
            }
        }
        return this.f5081e;
    }

    public boolean tryLockUpdate() {
        try {
            File d2 = h.d(this.b);
            if (!d2.exists()) {
                d2.createNewFile();
                h.c("lock", d2);
            }
            if (d2.exists()) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(d2, "rw");
                this.f5083g = randomAccessFile;
                FileLock tryLock = randomAccessFile.getChannel().tryLock();
                this.f5084h = tryLock;
                if (tryLock != null) {
                    this.f5083g.writeByte(37);
                    return true;
                }
                return false;
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }
}
