package bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122;

import android.text.TextUtils;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.d;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.a0;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.e;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.f;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.r;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.u;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.v;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.y;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.z;
import java.io.IOException;
import java.util.HashMap;

/* loaded from: classes.dex */
public class c extends b {

    /* renamed from: e  reason: collision with root package name */
    public z f266e;

    /* loaded from: classes.dex */
    public class a implements f {
        public final /* synthetic */ bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.a a;

        public a(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.a aVar) {
            this.a = aVar;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.f
        public void a(e eVar, a0 a0Var) throws IOException {
            if (this.a != null) {
                HashMap hashMap = new HashMap();
                if (a0Var != null) {
                    r m2 = a0Var.m();
                    if (m2 != null) {
                        for (int i2 = 0; i2 < m2.b(); i2++) {
                            hashMap.put(m2.a(i2), m2.b(i2));
                        }
                    }
                    this.a.a(c.this, new bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.b(a0Var.n(), a0Var.k(), a0Var.o(), hashMap, a0Var.i().l(), a0Var.t(), a0Var.r()));
                }
            }
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.f
        public void a(e eVar, IOException iOException) {
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.a aVar = this.a;
            if (aVar != null) {
                aVar.a(c.this, iOException);
            }
        }
    }

    public c(v vVar) {
        super(vVar);
        this.f266e = null;
    }

    public void a(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.a aVar) {
        IOException iOException;
        y.a aVar2 = new y.a();
        if (TextUtils.isEmpty(this.f265d)) {
            iOException = new IOException("Url is Empty");
        } else {
            try {
                aVar2.b(this.f265d);
                if (this.f266e != null) {
                    a(aVar2);
                    aVar2.a((Object) a());
                    this.a.a(aVar2.a(this.f266e).a()).a(new a(aVar));
                    return;
                } else if (aVar == null) {
                    return;
                } else {
                    iOException = new IOException("RequestBody is null, content type is not support!!");
                }
            } catch (IllegalArgumentException unused) {
                iOException = new IOException("Url is not a valid HTTP or HTTPS URL");
            }
        }
        aVar.a(this, iOException);
    }

    public void a(String str, byte[] bArr) {
        this.f266e = z.a(u.a(str), bArr);
    }

    public bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.b b() {
        String str;
        y.a aVar = new y.a();
        if (TextUtils.isEmpty(this.f265d)) {
            str = "execute: Url is Empty";
        } else {
            try {
                aVar.b(this.f265d);
                if (this.f266e != null) {
                    a(aVar);
                    aVar.a((Object) a());
                    try {
                        a0 i2 = this.a.a(aVar.a(this.f266e).a()).i();
                        if (i2 != null) {
                            HashMap hashMap = new HashMap();
                            r m2 = i2.m();
                            if (m2 != null) {
                                for (int i3 = 0; i3 < m2.b(); i3++) {
                                    hashMap.put(m2.a(i3), m2.b(i3));
                                }
                                return new bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.b(i2.n(), i2.k(), i2.o(), hashMap, i2.i().l(), i2.t(), i2.r());
                            }
                            return null;
                        }
                        return null;
                    } catch (IOException e2) {
                        e2.printStackTrace();
                        return null;
                    }
                }
                str = "RequestBody is null, content type is not support!!";
            } catch (IllegalArgumentException unused) {
                str = "execute: Url is not a valid HTTP or HTTPS URL";
            }
        }
        d.a("PostExecutor", str);
        return null;
    }

    public void c(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "{}";
        }
        this.f266e = z.a(u.a("application/json; charset=utf-8"), str);
    }
}
