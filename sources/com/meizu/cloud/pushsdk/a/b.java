package com.meizu.cloud.pushsdk.a;

import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.text.TextUtils;
import com.meizu.cloud.pushsdk.d.f.e;
import com.meizu.cloud.pushsdk.notification.model.BrightRemindSetting;
import com.meizu.cloud.pushsdk.util.MzSystemUtils;
import e.t.u.b0;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class b {
    private static final String a = "b";
    private final HashMap<String, String> b;

    /* renamed from: c  reason: collision with root package name */
    private final HashMap<String, Object> f4619c;

    /* renamed from: d  reason: collision with root package name */
    private final HashMap<String, Object> f4620d;

    /* loaded from: classes2.dex */
    public static class a {
        private Context a = null;

        public a a(Context context) {
            this.a = context;
            return this;
        }

        public b a() {
            return new b(this);
        }
    }

    private b(a aVar) {
        this.b = new HashMap<>();
        this.f4619c = new HashMap<>();
        this.f4620d = new HashMap<>();
        d();
        if (aVar.a != null) {
            b(aVar.a);
            a(aVar.a);
            c(aVar.a);
            d(aVar.a);
        }
        e.p.a.a.a.c(a, "Subject created successfully.");
    }

    private void a(String str, int i2, int i3) {
        this.b.put(str, i2 + "." + i3);
    }

    private void a(String str, Object obj) {
        if (TextUtils.isEmpty(str) || obj == null) {
            return;
        }
        if ((obj instanceof String) && ((String) obj).isEmpty()) {
            return;
        }
        this.f4619c.put(str, obj);
    }

    private void a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.b.put(str, str2);
    }

    private void b(Context context) {
        a("op", e.c(context));
    }

    private void b(String str, Object obj) {
        if (TextUtils.isEmpty(str) || obj == null) {
            return;
        }
        if ((obj instanceof String) && ((String) obj).isEmpty()) {
            return;
        }
        this.f4620d.put(str, obj);
    }

    private void c(Context context) {
        b("nt", MzSystemUtils.getNetWorkType(context));
    }

    private void d() {
        a(BrightRemindSetting.BRIGHT_REMIND, Build.BRAND);
        a("dc", Build.MODEL);
        a("ot", Build.VERSION.RELEASE);
        a("ov", Build.DISPLAY);
        a("ll", MzSystemUtils.getCurrentLanguage());
    }

    private void d(Context context) {
        a("pn", (Object) context.getPackageName());
        a("pv", (Object) MzSystemUtils.getAppVersionName(context));
        a("pvc", Integer.valueOf(MzSystemUtils.getAppVersionCode(context)));
        a("st", Integer.valueOf(!TextUtils.isEmpty(MzSystemUtils.findReceiver(context, "com.meizu.ups.push.intent.MESSAGE", context.getPackageName())) ? 1 : 0));
    }

    public Map<String, String> a() {
        return this.b;
    }

    public void a(Context context) {
        Point d2 = e.d(context);
        if (d2 == null) {
            e.p.a.a.a.f(a, "screen information not available.");
        } else {
            a(b0.a.f14656g, d2.x, d2.y);
        }
    }

    public Map<String, Object> b() {
        return this.f4619c;
    }

    public Map<String, Object> c() {
        return this.f4620d;
    }
}
