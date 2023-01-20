package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19;

import android.text.TextUtils;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.adapter.util.ThreadHelper;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class g {

    /* renamed from: c  reason: collision with root package name */
    private static volatile g f1016c;
    private volatile String a = "";
    private volatile ExecutorService b = ThreadHelper.initSingleThreadExecutor("gaid", 2, new a(this));

    /* loaded from: classes.dex */
    public class a implements RejectedExecutionHandler {
        public a(g gVar) {
        }

        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
        }
    }

    /* loaded from: classes.dex */
    public class b implements Callable<String> {
        private b() {
        }

        public /* synthetic */ b(g gVar, a aVar) {
            this();
        }

        @Override // java.util.concurrent.Callable
        public String call() throws Exception {
            long currentTimeMillis = System.currentTimeMillis();
            try {
                AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d());
                if (advertisingIdInfo != null) {
                    String id = advertisingIdInfo.getId();
                    Logger.d("gaid-", "getAdvertisingId: " + id);
                    g.b(id);
                }
            } catch (Throwable unused) {
            }
            try {
                AdvertisingIdClient.Info advertisingIdInfo2 = AdvertisingIdClient.getAdvertisingIdInfo(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d());
                if (advertisingIdInfo2 != null) {
                    g.this.a = advertisingIdInfo2.getId();
                    advertisingIdInfo2.isLimitAdTrackingEnabled();
                }
            } catch (Throwable unused2) {
            }
            Logger.d("AdvertisingIdHelper", "mGAId:" + g.this.a + " , get gaid consume time :" + (System.currentTimeMillis() - currentTimeMillis));
            return g.this.a;
        }
    }

    private g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        c0.a("tt_device_info", bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d()).b("gaid", str);
    }

    public static g c() {
        if (f1016c == null) {
            synchronized (g.class) {
                if (f1016c == null) {
                    f1016c = new g();
                }
            }
        }
        return f1016c;
    }

    public String a() {
        try {
            this.a = c0.a("tt_device_info", bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d()).a("gaid", "");
            Logger.d("gaid", "--==-- getGAIdTimeOut-mGAId = " + this.a);
            if (TextUtils.isEmpty(this.a)) {
                synchronized (this) {
                    if (this.b != null) {
                        FutureTask futureTask = new FutureTask(new b(this, null));
                        this.b.execute(futureTask);
                        this.a = (String) futureTask.get(500000L, TimeUnit.MICROSECONDS);
                        if (!TextUtils.isEmpty(this.a)) {
                            this.b.shutdown();
                            this.b = null;
                        }
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return this.a;
    }

    public void b() {
        synchronized (this) {
            try {
                this.a = c0.a("tt_device_info", bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d()).a("gaid", "");
                Logger.d("gaid", "--==-- initGAIdByAsyc-mGAId = " + this.a);
                if (TextUtils.isEmpty(this.a) && this.b != null) {
                    this.b.execute(new FutureTask(new b(this, null)));
                }
            } catch (Throwable unused) {
            }
        }
    }
}
