package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.push.service.XMPushService;
import java.io.File;

/* loaded from: classes3.dex */
public class gk implements XMPushService.n {
    private static boolean a = false;
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f8676c;

    /* renamed from: d  reason: collision with root package name */
    private int f8677d;

    public gk(Context context) {
        this.b = context;
    }

    private String a(String str) {
        return "com.xiaomi.xmsf".equals(str) ? "1000271" : this.b.getSharedPreferences("pref_registered_pkg_names", 0).getString(str, null);
    }

    private void a(Context context) {
        this.f8676c = com.xiaomi.push.service.ad.a(context).a(gv.TinyDataUploadSwitch.a(), true);
        int a2 = com.xiaomi.push.service.ad.a(context).a(gv.TinyDataUploadFrequency.a(), 7200);
        this.f8677d = a2;
        this.f8677d = Math.max(60, a2);
    }

    public static void a(boolean z) {
        a = z;
    }

    private boolean a(go goVar) {
        if (!al.c(this.b) || goVar == null || TextUtils.isEmpty(a(this.b.getPackageName())) || !new File(this.b.getFilesDir(), "tiny_data.data").exists() || a) {
            return false;
        }
        return !com.xiaomi.push.service.ad.a(this.b).a(gv.ScreenOnOrChargingTinyDataUploadSwitch.a(), false) || ii.l(this.b) || ii.m(this.b);
    }

    private boolean b() {
        return Math.abs((System.currentTimeMillis() / 1000) - this.b.getSharedPreferences("mipush_extra", 4).getLong("last_tiny_data_upload_timestamp", -1L)) > ((long) this.f8677d);
    }

    @Override // com.xiaomi.push.service.XMPushService.n
    public void a() {
        go a2 = gn.a(this.b).a();
        if (gp.a(this.b) && a2 != null) {
            gm.a(this.b, a2, com.xiaomi.push.service.be.b);
            com.xiaomi.push.service.be.a();
            com.xiaomi.a.a.a.c.c("coord data upload");
        }
        a(this.b);
        if (this.f8676c && b()) {
            com.xiaomi.a.a.a.c.a("TinyData TinyDataCacheProcessor.pingFollowUpAction ts:" + System.currentTimeMillis());
            if (a(a2)) {
                a = true;
                gl.a(this.b, a2);
                return;
            }
            com.xiaomi.a.a.a.c.a("TinyData TinyDataCacheProcessor.pingFollowUpAction !canUpload(uploader) ts:" + System.currentTimeMillis());
        }
    }
}
