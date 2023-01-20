package com.xiaomi.push;

import com.xiaomi.push.cj;
import java.io.File;
import java.util.Date;

/* loaded from: classes3.dex */
public class ck extends cj.b {
    public File a;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f8340d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Date f8341e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ Date f8342f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ String f8343g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ String f8344h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ boolean f8345i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ cj f8346j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ck(cj cjVar, int i2, Date date, Date date2, String str, String str2, boolean z) {
        super();
        this.f8346j = cjVar;
        this.f8340d = i2;
        this.f8341e = date;
        this.f8342f = date2;
        this.f8343g = str;
        this.f8344h = str2;
        this.f8345i = z;
    }

    @Override // com.xiaomi.push.cj.b, com.xiaomi.push.p.b
    public void b() {
        if (e.d()) {
            try {
                File file = new File(this.f8346j.b.getExternalFilesDir(null) + "/.logcache");
                file.mkdirs();
                if (file.isDirectory()) {
                    ci ciVar = new ci();
                    ciVar.a(this.f8340d);
                    this.a = ciVar.a(this.f8346j.b, this.f8341e, this.f8342f, file);
                }
            } catch (NullPointerException unused) {
            }
        }
    }

    @Override // com.xiaomi.push.p.b
    public void c() {
        File file = this.a;
        if (file != null && file.exists()) {
            this.f8346j.a.add(new cj.c(this.f8343g, this.f8344h, this.a, this.f8345i));
        }
        this.f8346j.a(0L);
    }
}
