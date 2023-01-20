package bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_for12;

import android.content.Context;
import android.content.SharedPreferences;
import android.location.Address;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.a;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.g;
import com.baidu.mobads.sdk.internal.bp;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class a implements g.a {
    private final boolean a;

    /* renamed from: i */
    private final Context f230i;

    /* renamed from: k */
    private bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.a f232k;

    /* renamed from: l */
    private int f233l;
    private volatile boolean b = false;

    /* renamed from: c */
    private boolean f224c = true;

    /* renamed from: d */
    private boolean f225d = false;

    /* renamed from: e */
    private long f226e = 0;

    /* renamed from: f */
    private long f227f = 0;

    /* renamed from: g */
    private ThreadPoolExecutor f228g = null;

    /* renamed from: h */
    private AtomicBoolean f229h = new AtomicBoolean(false);

    /* renamed from: j */
    private volatile boolean f231j = false;

    /* renamed from: m */
    public final bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.g f234m = new bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.g(Looper.getMainLooper(), this);

    /* renamed from: bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_for12.a$a */
    /* loaded from: classes.dex */
    public class RunnableC0016a implements Runnable {
        public RunnableC0016a() {
            a.this = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.c();
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public final /* synthetic */ boolean a;

        public b(boolean z) {
            a.this = r1;
            this.a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.c(this.a);
        }
    }

    /* loaded from: classes.dex */
    public class c extends bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.a {
        public final /* synthetic */ int a;

        public c(int i2) {
            a.this = r1;
            this.a = i2;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.a
        public void a(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.b bVar, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.b bVar2) {
            JSONObject jSONObject;
            if (bVar2 != null && bVar2.e()) {
                String str = null;
                try {
                    jSONObject = new JSONObject(bVar2.a());
                } catch (Exception unused) {
                    jSONObject = null;
                }
                if (jSONObject != null) {
                    try {
                        str = jSONObject.getString("message");
                    } catch (Exception unused2) {
                    }
                    if (bp.o.equals(str)) {
                        try {
                            if (a.this.a(jSONObject)) {
                                a.this.b(101);
                            } else {
                                a.this.a(this.a + 1);
                            }
                            return;
                        } catch (Exception unused3) {
                            return;
                        }
                    }
                }
            }
            a.this.a(this.a + 1);
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.a
        public void a(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.b bVar, IOException iOException) {
            a.this.a(this.a + 1);
        }
    }

    public a(Context context, int i2) {
        this.f230i = context;
        this.a = bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.f.b(context);
        this.f233l = i2;
    }

    private String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return "https://" + str + "/get_domains/v4/";
    }

    public void a(int i2) {
        String[] a = a();
        if (a != null && a.length > i2) {
            String str = a[i2];
            if (!TextUtils.isEmpty(str)) {
                try {
                    String a2 = a(str);
                    if (TextUtils.isEmpty(a2)) {
                        b(102);
                    } else {
                        bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.a a3 = h().a();
                        a3.b(a2);
                        a(a3);
                        a3.a(new c(i2));
                    }
                    return;
                } catch (Throwable th) {
                    bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.b.a("AppConfig", "try app config exception: " + th);
                    return;
                }
            }
        }
        b(102);
    }

    private void a(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.a aVar) {
        if (aVar == null) {
            return;
        }
        Address a = h.a().a(this.f233l).b() != null ? h.a().a(this.f233l).b().a(this.f230i) : null;
        if (a != null && a.hasLatitude() && a.hasLongitude()) {
            aVar.b("latitude", a.getLatitude() + "");
            aVar.b("longitude", a.getLongitude() + "");
            String locality = a.getLocality();
            if (!TextUtils.isEmpty(locality)) {
                aVar.b("city", Uri.encode(locality));
            }
        }
        if (this.b) {
            aVar.b(TTDownloadField.TT_FORCE, "1");
        }
        try {
            aVar.b("abi", Build.VERSION.SDK_INT < 21 ? Build.CPU_ABI : Build.SUPPORTED_ABIS[0]);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (h.a().a(this.f233l).b() != null) {
            aVar.b("aid", h.a().a(this.f233l).b().c() + "");
            aVar.b("device_platform", h.a().a(this.f233l).b().b());
            aVar.b("channel", h.a().a(this.f233l).b().d());
            aVar.b("version_code", h.a().a(this.f233l).b().e() + "");
            aVar.b("custom_info_1", h.a().a(this.f233l).b().f());
        }
    }

    public boolean a(Object obj) throws Exception {
        JSONObject jSONObject;
        if (obj instanceof String) {
            String str = (String) obj;
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            jSONObject = new JSONObject(str);
            if (!bp.o.equals(jSONObject.getString("message"))) {
                return false;
            }
        } else {
            jSONObject = obj instanceof JSONObject ? (JSONObject) obj : null;
        }
        if (jSONObject != null) {
            JSONObject jSONObject2 = jSONObject.getJSONObject("data");
            synchronized (this) {
                SharedPreferences.Editor edit = this.f230i.getSharedPreferences("m_ss_app_config", 0).edit();
                edit.putLong("last_refresh_time", System.currentTimeMillis());
                edit.apply();
            }
            if (h.a().a(this.f233l).d() != null) {
                h.a().a(this.f233l).d().a(jSONObject2);
            }
            return true;
        }
        return false;
    }

    public void b(int i2) {
        bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.g gVar = this.f234m;
        if (gVar != null) {
            gVar.sendEmptyMessage(i2);
        }
    }

    private void d(boolean z) {
        if (this.f225d) {
            return;
        }
        if (this.f224c) {
            this.f224c = false;
            this.f226e = 0L;
            this.f227f = 0L;
        }
        long j2 = z ? 10800000L : com.heytap.mcssdk.constant.a.f3317g;
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f226e <= j2 || currentTimeMillis - this.f227f <= 120000) {
            return;
        }
        boolean a = bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.e.a(this.f230i);
        if (!this.f231j || a) {
            a(a);
        }
    }

    private boolean g() {
        String[] a = a();
        if (a != null && a.length != 0) {
            a(0);
        }
        return false;
    }

    private bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.a h() {
        if (this.f232k == null) {
            a.b bVar = new a.b();
            TimeUnit timeUnit = TimeUnit.SECONDS;
            this.f232k = bVar.a(10L, timeUnit).b(10L, timeUnit).c(10L, timeUnit).a();
        }
        return this.f232k;
    }

    public boolean a(boolean z) {
        bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.b.a("TNCManager", "doRefresh: updating state " + this.f229h.get());
        if (!this.f229h.compareAndSet(false, true)) {
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.b.a("TNCManager", "doRefresh, already running");
            return false;
        }
        if (z) {
            this.f227f = System.currentTimeMillis();
        }
        b().execute(new b(z));
        return true;
    }

    public String[] a() {
        String[] a = h.a().a(this.f233l).b() != null ? h.a().a(this.f233l).b().a() : null;
        return (a == null || a.length <= 0) ? new String[0] : a;
    }

    public ThreadPoolExecutor b() {
        if (this.f228g == null) {
            synchronized (a.class) {
                if (this.f228g == null) {
                    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 2, 20L, TimeUnit.SECONDS, new LinkedBlockingQueue());
                    this.f228g = threadPoolExecutor;
                    threadPoolExecutor.allowCoreThreadTimeOut(true);
                }
            }
        }
        return this.f228g;
    }

    public void b(boolean z) {
        synchronized (this) {
            if (this.a) {
                d(z);
            } else if (this.f226e <= 0) {
                try {
                    b().execute(new RunnableC0016a());
                } catch (Throwable unused) {
                }
            }
        }
    }

    public void c() {
        synchronized (this) {
            if (System.currentTimeMillis() - this.f226e > com.heytap.mcssdk.constant.a.f3315e) {
                this.f226e = System.currentTimeMillis();
                try {
                    if (h.a().a(this.f233l).d() != null) {
                        h.a().a(this.f233l).d().c();
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    public void c(boolean z) {
        bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.b.a("TNCManager", "doRefresh, actual request");
        d();
        this.f225d = true;
        if (!z) {
            this.f234m.sendEmptyMessage(102);
            return;
        }
        try {
            g();
        } catch (Exception unused) {
            this.f229h.set(false);
        }
    }

    public void d() {
        synchronized (this) {
            if (!this.f231j) {
                this.f231j = true;
                long j2 = this.f230i.getSharedPreferences("m_ss_app_config", 0).getLong("last_refresh_time", 0L);
                long currentTimeMillis = System.currentTimeMillis();
                if (j2 > currentTimeMillis) {
                    j2 = currentTimeMillis;
                }
                this.f226e = j2;
                if (h.a().a(this.f233l).d() != null) {
                    h.a().a(this.f233l).d().b();
                }
            }
        }
    }

    public void e() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            try {
                if (this.a) {
                    d();
                } else {
                    c();
                }
            } catch (Throwable unused) {
            }
        }
    }

    public void f() {
        b(false);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.g.a
    public void handleMsg(Message message) {
        int i2 = message.what;
        if (i2 == 101) {
            this.f225d = false;
            this.f226e = System.currentTimeMillis();
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.b.a("TNCManager", "doRefresh, succ");
            if (this.f224c) {
                f();
            }
        } else if (i2 != 102) {
            return;
        } else {
            this.f225d = false;
            if (this.f224c) {
                f();
            }
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.b.a("TNCManager", "doRefresh, error");
        }
        this.f229h.set(false);
    }
}
