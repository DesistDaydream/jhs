package com.vivo.push.b;

import android.content.Context;
import android.text.TextUtils;
import com.qiniu.android.collect.ReportItem;

/* loaded from: classes3.dex */
public class c extends com.vivo.push.o {
    private String a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private long f8091c;

    /* renamed from: d  reason: collision with root package name */
    private int f8092d;

    /* renamed from: e  reason: collision with root package name */
    private int f8093e;

    /* renamed from: f  reason: collision with root package name */
    private String f8094f;

    public c(int i2, String str) {
        super(i2);
        this.f8091c = -1L;
        this.f8092d = -1;
        this.a = null;
        this.b = str;
    }

    public final void a(int i2) {
        this.f8093e = i2;
    }

    public final void b(String str) {
        this.a = str;
    }

    @Override // com.vivo.push.o
    public void c(com.vivo.push.a aVar) {
        aVar.a(ReportItem.RequestKeyRequestId, this.a);
        aVar.a("package_name", this.b);
        aVar.a("sdk_version", 323L);
        aVar.a("PUSH_APP_STATUS", this.f8092d);
        if (TextUtils.isEmpty(this.f8094f)) {
            return;
        }
        aVar.a("BaseAppCommand.EXTRA__HYBRIDVERSION", this.f8094f);
    }

    @Override // com.vivo.push.o
    public void d(com.vivo.push.a aVar) {
        this.a = aVar.a(ReportItem.RequestKeyRequestId);
        this.b = aVar.a("package_name");
        this.f8091c = aVar.b("sdk_version", 0L);
        this.f8092d = aVar.b("PUSH_APP_STATUS", 0);
        this.f8094f = aVar.a("BaseAppCommand.EXTRA__HYBRIDVERSION");
    }

    public final int f() {
        return this.f8093e;
    }

    public final void g() {
        this.f8094f = null;
    }

    public final String h() {
        return this.a;
    }

    @Override // com.vivo.push.o
    public String toString() {
        return "BaseAppCommand";
    }

    public final int a(Context context) {
        if (this.f8092d == -1) {
            String str = this.b;
            if (TextUtils.isEmpty(str)) {
                com.vivo.push.util.p.a("BaseAppCommand", "pkg name is null");
                String a = a();
                if (TextUtils.isEmpty(a)) {
                    com.vivo.push.util.p.a("BaseAppCommand", "src is null");
                    return -1;
                }
                str = a;
            }
            this.f8092d = com.vivo.push.util.t.b(context, str);
            if (!TextUtils.isEmpty(this.f8094f)) {
                this.f8092d = 2;
            }
        }
        return this.f8092d;
    }
}
