package com.xiaomi.push;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import java.util.HashMap;

/* loaded from: classes3.dex */
public final class di {
    private static volatile di a;
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private HashMap<dk, dl> f8446c;

    /* renamed from: d  reason: collision with root package name */
    private String f8447d;

    /* renamed from: e  reason: collision with root package name */
    private String f8448e;

    /* renamed from: f  reason: collision with root package name */
    private int f8449f;

    /* renamed from: g  reason: collision with root package name */
    private dm f8450g;

    private di(Context context) {
        HashMap<dk, dl> hashMap = new HashMap<>();
        this.f8446c = hashMap;
        this.b = context;
        hashMap.put(dk.SERVICE_ACTION, new Cdo());
        this.f8446c.put(dk.SERVICE_COMPONENT, new dp());
        this.f8446c.put(dk.ACTIVITY, new dg());
        this.f8446c.put(dk.PROVIDER, new dn());
    }

    public static di a(Context context) {
        if (a == null) {
            synchronized (di.class) {
                if (a == null) {
                    a = new di(context);
                }
            }
        }
        return a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(dk dkVar, Context context, dh dhVar) {
        this.f8446c.get(dkVar).a(context, dhVar);
    }

    public static boolean b(Context context) {
        return com.xiaomi.push.service.n.a(context, context.getPackageName());
    }

    public dm a() {
        return this.f8450g;
    }

    public void a(int i2) {
        this.f8449f = i2;
    }

    public void a(Context context, String str, int i2, String str2, String str3) {
        if (context != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            a(i2);
            m.a(this.b).a(new dj(this, str, context, str2, str3));
            return;
        }
        dd.a(context, "" + str, 1008, "A receive a incorrect message");
    }

    public void a(dk dkVar, Context context, Intent intent, String str) {
        if (dkVar != null) {
            this.f8446c.get(dkVar).a(context, intent, str);
        } else {
            dd.a(context, "null", 1008, "A receive a incorrect message with empty type");
        }
    }

    public void a(dm dmVar) {
        this.f8450g = dmVar;
    }

    public void a(String str) {
        this.f8447d = str;
    }

    public void a(String str, String str2, int i2, dm dmVar) {
        a(str);
        b(str2);
        a(i2);
        a(dmVar);
    }

    public String b() {
        return this.f8447d;
    }

    public void b(String str) {
        this.f8448e = str;
    }

    public String c() {
        return this.f8448e;
    }

    public int d() {
        return this.f8449f;
    }
}
