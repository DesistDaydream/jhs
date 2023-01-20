package k.c.a.r;

import k.c.a.n;

/* loaded from: classes4.dex */
public class b extends a {

    /* renamed from: d  reason: collision with root package name */
    private final e[] f16298d;

    public b(Class cls, boolean z, e[] eVarArr) {
        super(cls, null, z);
        this.f16298d = eVarArr;
    }

    @Override // k.c.a.r.c
    public synchronized n[] a() {
        n[] nVarArr;
        int length = this.f16298d.length;
        nVarArr = new n[length];
        for (int i2 = 0; i2 < length; i2++) {
            e eVar = this.f16298d[i2];
            nVarArr[i2] = g(eVar.a, eVar.f16299c, eVar.b, eVar.f16300d, eVar.f16301e);
        }
        return nVarArr;
    }
}
