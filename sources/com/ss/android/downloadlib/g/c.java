package com.ss.android.downloadlib.g;

import java.lang.ref.SoftReference;

/* loaded from: classes3.dex */
public class c<P, R> implements Runnable {
    private P a;
    private R b;

    /* renamed from: c  reason: collision with root package name */
    private int f5401c;

    /* renamed from: d  reason: collision with root package name */
    private SoftReference<a<P, R>> f5402d;

    /* renamed from: e  reason: collision with root package name */
    private c<?, P> f5403e;

    /* renamed from: f  reason: collision with root package name */
    private c<R, ?> f5404f;

    /* loaded from: classes3.dex */
    public interface a<PARAM, RESULT> {
        RESULT a(PARAM param);
    }

    private c(int i2, a<P, R> aVar, P p) {
        this.f5401c = i2;
        this.f5402d = new SoftReference<>(aVar);
        this.a = p;
    }

    public static <P, R> c<P, R> a(a<P, R> aVar, P p) {
        return new c<>(2, aVar, p);
    }

    private R b() {
        return this.b;
    }

    @Override // java.lang.Runnable
    public void run() {
        c<?, P> cVar;
        if (this.f5401c == 0 && !l.a()) {
            com.ss.android.downloadlib.f.a().b().post(this);
        } else if (this.f5401c == 1 && l.a()) {
            com.ss.android.downloadlib.d.a().a(this);
        } else if (this.f5401c == 2 && l.a()) {
            com.ss.android.downloadlib.d.a().b(this);
        } else {
            if (this.a == null && (cVar = this.f5403e) != null) {
                this.a = cVar.b();
            }
            a<P, R> aVar = this.f5402d.get();
            if (aVar == null) {
                return;
            }
            this.b = aVar.a(this.a);
            c<R, ?> cVar2 = this.f5404f;
            if (cVar2 != null) {
                cVar2.run();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <NR> c<R, NR> a(int i2, a<R, NR> aVar) {
        c cVar = (c<R, ?>) new c(i2, aVar, null);
        this.f5404f = cVar;
        cVar.f5403e = this;
        return cVar;
    }

    public <NR> c<R, NR> a(a<R, NR> aVar) {
        return a(0, aVar);
    }

    public void a() {
        c<?, P> cVar = this.f5403e;
        if (cVar != null) {
            cVar.a();
        } else {
            run();
        }
    }
}
