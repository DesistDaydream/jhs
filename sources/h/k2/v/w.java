package h.k2.v;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0013\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\u0002J\f\u0010\f\u001a\u00020\u0004*\u00020\u0002H\u0014R\u000e\u0010\u0006\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lkotlin/jvm/internal/DoubleSpreadBuilder;", "Lkotlin/jvm/internal/PrimitiveSpreadBuilder;", "", "size", "", "(I)V", "values", "add", "", "value", "", "toArray", "getSize", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class w extends m0<double[]> {

    /* renamed from: d  reason: collision with root package name */
    private final double[] f14944d;

    public w(int i2) {
        super(i2);
        this.f14944d = new double[i2];
    }

    public final void h(double d2) {
        double[] dArr = this.f14944d;
        int b = b();
        e(b + 1);
        dArr[b] = d2;
    }

    @Override // h.k2.v.m0
    /* renamed from: i */
    public int c(@k.e.a.d double[] dArr) {
        return dArr.length;
    }

    @k.e.a.d
    public final double[] j() {
        return g(this.f14944d, new double[f()]);
    }
}
