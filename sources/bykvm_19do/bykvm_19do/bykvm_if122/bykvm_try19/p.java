package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19;

import android.content.Context;
import android.text.TextUtils;
import bykvm_19do.bykvm_19do.bykvm_19do.e;
import com.bytedance.mapplog.util.TTEncryptUtils;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.adapter.util.ThreadHelper;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class p {
    private static volatile String a = "";
    private static volatile String b = "";

    /* renamed from: c  reason: collision with root package name */
    private static volatile boolean f1022c;

    /* renamed from: d  reason: collision with root package name */
    private static volatile ExecutorService f1023d;

    /* loaded from: classes.dex */
    public static final class a implements RejectedExecutionHandler {
        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
        }
    }

    /* loaded from: classes.dex */
    public static final class b implements Runnable {
        public final /* synthetic */ String a;

        public b(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            String unused = p.a = this.a;
            v.a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d(), p.a);
            if (TextUtils.isEmpty(p.a)) {
                return;
            }
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.e.f();
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.e.g();
        }
    }

    /* loaded from: classes.dex */
    public static final class c implements bykvm_19do.bykvm_19do.bykvm_19do.c {
        @Override // bykvm_19do.bykvm_19do.bykvm_19do.c
        public void a(String str, String str2, String str3) {
            Logger.i("TTMediationSDK_SDK_Init", "applod from onIdLoaded ------------: did = " + str);
            p.d(str);
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_19do.c
        public void a(boolean z, String str, String str2, String str3, String str4, String str5, String str6) {
            Logger.i("TTMediationSDK_SDK_Init", "applod from onRemoteIdGet ------------: did = " + str2);
            p.d(str2);
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_19do.c
        public void a(boolean z, JSONObject jSONObject) {
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_19do.c
        public void b(boolean z, JSONObject jSONObject) {
        }
    }

    /* loaded from: classes.dex */
    public static final class d implements bykvm_19do.bykvm_19do.bykvm_19do.e {
        @Override // bykvm_19do.bykvm_19do.bykvm_19do.e
        public void a(e.a aVar) {
            if (!TextUtils.isEmpty(p.b) || aVar == null || TextUtils.isEmpty(aVar.a)) {
                return;
            }
            Logger.i("TTMediationSDK_SDK_Init", "applod ------------: oaid = " + aVar.a);
            String unused = p.b = aVar.a;
        }
    }

    /* loaded from: classes.dex */
    public static final class e implements bykvm_19do.bykvm_19do.bykvm_19do.g {
        public final /* synthetic */ Context a;

        public e(Context context) {
            this.a = context;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_19do.g
        public String a() {
            return v.i(this.a);
        }
    }

    public static void a(Context context) {
        b(context);
    }

    public static byte[] a(byte[] bArr, int i2) {
        return TTEncryptUtils.a(bArr, i2);
    }

    private static void b(Context context) {
        if (f1022c) {
            return;
        }
        f1022c = true;
        bykvm_19do.bykvm_19do.bykvm_19do.h hVar = new bykvm_19do.bykvm_19do.bykvm_19do.h("299838", "gromore");
        hVar.a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.I().s().isCanUsePhoneState());
        hVar.b(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.I().s().isCanUseLocation());
        hVar.a(new e(context));
        bykvm_19do.bykvm_19do.bykvm_19do.a.a(context, hVar);
        c();
        d();
        HashMap hashMap = new HashMap();
        hashMap.put("host_appid", bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.I().b());
        hashMap.put("is_plugin", Boolean.FALSE);
        hashMap.put("sdk_version", "3.7.0.2");
        hashMap.put(PluginConstants.KEY_PLUGIN_VERSION, "3.7.0.2");
        hashMap.put("channel", "gromore");
        hashMap.put("sdk_api_version", "3.7.0.2");
        bykvm_19do.bykvm_19do.bykvm_19do.a.a(hashMap);
        Logger.i("TTMediationSDK_SDK_Init", "applod ------------: init end ");
    }

    public static String c() {
        if (TextUtils.isEmpty(a)) {
            a = bykvm_19do.bykvm_19do.bykvm_19do.a.g();
            Logger.i("TTMediationSDK_SDK_Init", "applod ------------: did from get = " + a);
            if (TextUtils.isEmpty(a)) {
                e();
            }
        }
        return a;
    }

    public static String d() {
        if (TextUtils.isEmpty(b) && TextUtils.isEmpty(b)) {
            f();
        }
        return b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        g();
        f1023d.execute(new b(str));
    }

    private static void e() {
        bykvm_19do.bykvm_19do.bykvm_19do.a.a(new c());
    }

    private static void f() {
        bykvm_19do.bykvm_19do.bykvm_19do.a.a(new d());
    }

    private static void g() {
        if (f1023d == null) {
            synchronized (p.class) {
                if (f1023d == null) {
                    f1023d = ThreadHelper.initSingleThreadExecutor("applog", 5, new a());
                }
            }
        }
    }
}
