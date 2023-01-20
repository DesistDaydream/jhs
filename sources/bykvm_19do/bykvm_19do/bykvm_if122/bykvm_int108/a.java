package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.bykvm_19do.g;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.bykvm_19do.h;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.bykvm_19do.j;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.bykvm_19do.l;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.bykvm_19do.m;
import com.bytedance.msdk.adapter.config.IGMInitAdnResult;
import com.bytedance.msdk.adapter.config.ITTAdapterConfiguration;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.adapter.util.ThreadHelper;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.v2.ad.custom.init.GMCustomAdapterConfiguration;
import com.vector.view.pager.ViewPager;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public class a {

    /* renamed from: e  reason: collision with root package name */
    private static final bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_int108.a f968e = new bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_int108.a();

    /* renamed from: f  reason: collision with root package name */
    private static Map<String, Pair<Boolean, String>> f969f = new ConcurrentHashMap();

    /* renamed from: g  reason: collision with root package name */
    private static final CountDownLatch f970g = new CountDownLatch(1);
    private final AtomicBoolean a = new AtomicBoolean(false);
    private final AtomicBoolean b = new AtomicBoolean(false);

    /* renamed from: c  reason: collision with root package name */
    private final AtomicBoolean f971c = new AtomicBoolean(false);

    /* renamed from: d  reason: collision with root package name */
    private bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_int108.b f972d;

    /* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class RunnableC0044a implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            StringBuilder sb;
            String str;
            if (a.f969f.containsKey("pangle")) {
                a.k();
            }
            Logger.i("TTMediationSDK_SDK_Init", "------------------ GroMore 支持ADN初始化信息 start ---------------------");
            for (Map.Entry entry : a.f969f.entrySet()) {
                if (entry.getValue() != null) {
                    if (!((Boolean) ((Pair) entry.getValue()).first).booleanValue()) {
                        sb = new StringBuilder();
                        sb.append("adnName = ");
                        sb.append((String) entry.getKey());
                        sb.append(" 初始化失败 ");
                        str = (String) ((Pair) entry.getValue()).second;
                    } else if (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f().g((String) entry.getKey())) {
                        sb = new StringBuilder();
                        sb.append("adnName = ");
                        sb.append((String) entry.getKey());
                        str = " 自定义ADN调用初始化方法成功，请开发者确保接入的自定义ADN初始化结果";
                    } else {
                        Logger.i("TTMediationSDK_SDK_Init", "adnName = " + ((String) entry.getKey()) + " 初始化成功");
                    }
                    sb.append(str);
                    Logger.e("TTMediationSDK_SDK_Init", sb.toString());
                }
            }
            Logger.i("TTMediationSDK_SDK_Init", "------------------ GroMore 支持ADN初始化信息 end ---------------------");
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public final /* synthetic */ Context a;

        /* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0045a implements IGMInitAdnResult {
            public C0045a() {
            }

            @Override // com.bytedance.msdk.adapter.config.IGMInitAdnResult
            public void fail(@NonNull AdError adError) {
                a.this.b.set(true);
                a.this.h();
            }

            @Override // com.bytedance.msdk.adapter.config.IGMInitAdnResult
            public void success() {
                a.this.b.set(true);
                a.this.h();
            }
        }

        public b(Context context) {
            this.a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.a(this.a, new C0045a());
            a.this.f(this.a);
            a.this.h(this.a);
            a.this.a.set(true);
            a.this.h();
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public final /* synthetic */ Context a;

        public c(Context context) {
            this.a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.b(this.a);
            a.this.a(this.a);
            a.this.c(this.a);
            a.this.i(this.a);
            a.this.g(this.a);
            a.j(this.a);
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.c.a(this.a);
            a.this.f971c.set(true);
            a.this.h();
        }
    }

    /* loaded from: classes.dex */
    public class d implements IGMInitAdnResult {
        public final /* synthetic */ IGMInitAdnResult a;

        public d(a aVar, IGMInitAdnResult iGMInitAdnResult) {
            this.a = iGMInitAdnResult;
        }

        @Override // com.bytedance.msdk.adapter.config.IGMInitAdnResult
        public void fail(@NonNull AdError adError) {
            a.j();
            IGMInitAdnResult iGMInitAdnResult = this.a;
            if (iGMInitAdnResult != null) {
                iGMInitAdnResult.fail(adError);
            }
        }

        @Override // com.bytedance.msdk.adapter.config.IGMInitAdnResult
        public void success() {
            a.j();
            IGMInitAdnResult iGMInitAdnResult = this.a;
            if (iGMInitAdnResult != null) {
                iGMInitAdnResult.success();
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements Runnable {
        public final /* synthetic */ Context a;

        public e(Context context) {
            this.a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.d(this.a);
            a.this.e(this.a);
        }
    }

    /* loaded from: classes.dex */
    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.b.get() && a.this.a.get() && a.this.f971c.get() && a.this.f972d != null) {
                a.this.f972d.a();
            }
        }
    }

    public static GMCustomAdapterConfiguration a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return f968e.b(str);
    }

    public static String a(Map<String, Object> map, String str) {
        return f968e.a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d(), map, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context) {
        new bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.bykvm_19do.a(context).e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, IGMInitAdnResult iGMInitAdnResult) {
        j.a(context).a(new d(this, iGMInitAdnResult));
    }

    public static void a(String str, Pair<Boolean, String> pair) {
        f969f.put(str, pair);
    }

    public static Map<String, Object> b(Map<String, Object> map, String str) {
        return f968e.b(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d(), map, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Context context) {
        new bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.bykvm_19do.b(context).e();
    }

    public static int c() {
        return f969f.size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Context context) {
        new bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.bykvm_19do.e(context).e();
    }

    public static bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_int108.a d() {
        return f968e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(Context context) {
        b bVar = new b(context);
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            bVar.run();
        } else {
            ThreadHelper.runOnUiThread(bVar);
        }
    }

    public static Map<String, ITTAdapterConfiguration> e() {
        return f968e.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(Context context) {
        ThreadHelper.runOnThreadPool(new c(context));
    }

    public static String f() {
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.a a = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f().a("pangle");
        String a2 = a != null ? a.a() : null;
        return TextUtils.isEmpty(a2) ? bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.I().b() : a2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(Context context) {
        new bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.bykvm_19do.f(context).e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(Context context) {
        new g(context).e();
    }

    public static boolean g() {
        return f970g.getCount() != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        ThreadHelper.runOnUiThread(new f());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(Context context) {
        new h(context).e();
    }

    public static void i() {
        synchronized (a.class) {
            ThreadHelper.runOnThreadPool(new RunnableC0044a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(Context context) {
        new l(context).e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void j() {
        f970g.countDown();
    }

    public static void j(Context context) {
        new m(context).e();
    }

    public static void k() {
        try {
            f970g.await(ViewPager.DEFAULT_INTERVAL, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
    }

    public void a(Context context, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_int108.b bVar) {
        this.f972d = bVar;
        this.a.set(false);
        this.f971c.set(false);
        this.b.set(false);
        ThreadHelper.runOnUiThread(new e(context));
    }
}
