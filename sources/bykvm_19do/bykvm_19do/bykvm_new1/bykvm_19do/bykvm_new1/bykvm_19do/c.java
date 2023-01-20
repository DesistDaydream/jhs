package bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_new1.bykvm_19do;

import android.content.Context;
import android.os.Process;
import bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_case1.n;
import bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.i;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import com.tencent.android.tpush.XGPushNotificationBuilder;
import com.umeng.analytics.pro.am;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.json.JSONObject;

/* loaded from: classes.dex */
public abstract class c {
    public bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.c a;
    public Context b;

    /* renamed from: c */
    public bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.e f1199c = i.e().a();

    /* renamed from: d */
    public b f1200d;

    /* renamed from: e */
    public d f1201e;

    public c(bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.c cVar, Context context, b bVar, d dVar) {
        this.a = cVar;
        this.b = context;
        this.f1200d = bVar;
        this.f1201e = dVar;
    }

    private void e(bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_for12.a aVar) {
        List<bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.a> a = i.d().a(this.a);
        if (a != null) {
            JSONObject jSONObject = new JSONObject();
            for (bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.a aVar2 : a) {
                Map<? extends String, ? extends String> a2 = aVar2.a(this.a);
                if (a2 != null) {
                    try {
                        for (String str : a2.keySet()) {
                            jSONObject.put(str, a2.get(str));
                        }
                    } catch (Throwable unused) {
                    }
                }
            }
            aVar.a(XGPushNotificationBuilder.CUSTOM_NOTIFICATION_BUILDER_TYPE, jSONObject);
        }
    }

    public void a(bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_for12.a aVar) {
        Map<String, Object> d2 = i.e().d();
        if (d2 == null) {
            return;
        }
        if (d2.containsKey("app_version")) {
            aVar.a("crash_version", d2.get("app_version"));
        }
        if (d2.containsKey(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME)) {
            aVar.a("app_version", d2.get(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME));
        }
        if (d2.containsKey("version_code")) {
            try {
                aVar.a("crash_version_code", Integer.valueOf(Integer.parseInt(d2.get("version_code").toString())));
            } catch (Exception unused) {
                aVar.a("crash_version_code", d2.get("version_code"));
            }
        }
        if (d2.containsKey("update_version_code")) {
            try {
                aVar.a("crash_update_version_code", Integer.valueOf(Integer.parseInt(d2.get("update_version_code").toString())));
            } catch (Exception unused2) {
                aVar.a("crash_update_version_code", d2.get("update_version_code"));
            }
        }
    }

    public boolean a() {
        return true;
    }

    public bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_for12.a b(bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_for12.a aVar) {
        if (aVar == null) {
            aVar = new bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_for12.a();
        }
        c(aVar);
        e(aVar);
        return aVar;
    }

    public boolean b() {
        return true;
    }

    public void c(bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_for12.a aVar) {
        b bVar;
        if (a() && (bVar = this.f1200d) != null) {
            aVar.a(bVar);
        }
        aVar.a(i.a());
        aVar.a("is_background", Boolean.valueOf(!bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_case1.a.e(this.b)));
        aVar.a("pid", Integer.valueOf(Process.myPid()));
        aVar.a(am.Z, Integer.valueOf(this.f1201e.a()));
        aVar.b(this.f1199c.g());
        aVar.c(i.i());
        aVar.a(i.g(), i.h());
        aVar.b(this.f1199c.b());
        aVar.a(n.c(this.b));
        if (b()) {
            d(aVar);
        }
        aVar.a(this.f1199c.d());
        String c2 = i.c();
        if (c2 != null) {
            aVar.a("business", c2);
        }
        if (i.k()) {
            aVar.a("is_mp", (Object) 1);
        }
        aVar.a(i.d().d());
        aVar.a("crash_uuid", UUID.randomUUID().toString());
    }

    public void d(bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_for12.a aVar) {
        aVar.a(bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_new1.e.a(i.f().b(), i.f().c()));
    }
}
