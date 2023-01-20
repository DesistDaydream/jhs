package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.xiaomi.push.bm;
import com.xiaomi.push.m;

/* loaded from: classes3.dex */
public class az {

    /* renamed from: e  reason: collision with root package name */
    private static volatile az f8264e;

    /* renamed from: f  reason: collision with root package name */
    private Context f8267f;

    /* renamed from: g  reason: collision with root package name */
    private String f8268g;

    /* renamed from: h  reason: collision with root package name */
    private String f8269h;

    /* renamed from: i  reason: collision with root package name */
    private bp f8270i;

    /* renamed from: j  reason: collision with root package name */
    private bq f8271j;
    private final String a = "push_stat_sp";
    private final String b = "upload_time";

    /* renamed from: c  reason: collision with root package name */
    private final String f8265c = "delete_time";

    /* renamed from: d  reason: collision with root package name */
    private final String f8266d = "check_time";

    /* renamed from: k  reason: collision with root package name */
    private m.a f8272k = new ba(this);

    /* renamed from: l  reason: collision with root package name */
    private m.a f8273l = new bb(this);

    /* renamed from: m  reason: collision with root package name */
    private m.a f8274m = new bd(this);

    private az(Context context) {
        this.f8267f = context;
    }

    public static az a(Context context) {
        if (f8264e == null) {
            synchronized (az.class) {
                if (f8264e == null) {
                    f8264e = new az(context);
                }
            }
        }
        return f8264e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        SharedPreferences.Editor edit = this.f8267f.getSharedPreferences("push_stat_sp", 0).edit();
        edit.putLong(str, System.currentTimeMillis());
        jj.a(edit);
    }

    private boolean c() {
        return com.xiaomi.push.service.ad.a(this.f8267f).a(gv.StatDataSwitch.a(), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String d() {
        return this.f8267f.getDatabasePath(be.a).getAbsolutePath();
    }

    public String a() {
        return this.f8268g;
    }

    public void a(bm.a aVar) {
        bm.a(this.f8267f).a(aVar);
    }

    public void a(gu guVar) {
        if (c() && com.xiaomi.push.service.bc.a(guVar.q())) {
            a(bj.a(this.f8267f, d(), guVar));
        }
    }

    public void a(String str) {
        if (c() && !TextUtils.isEmpty(str)) {
            a(br.a(this.f8267f, str));
        }
    }

    public void a(String str, String str2, Boolean bool) {
        if (this.f8270i != null) {
            if (bool.booleanValue()) {
                this.f8270i.a(this.f8267f, str2, str);
            } else {
                this.f8270i.b(this.f8267f, str2, str);
            }
        }
    }

    public String b() {
        return this.f8269h;
    }
}
