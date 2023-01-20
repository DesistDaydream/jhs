package h.l2;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0006\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0000X\u0081\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00048\u0000X\u0081\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00048\u0000X\u0081\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\u00048\u0000X\u0081\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\u00048\u0000X\u0081\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\u00048\u0000X\u0081\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lkotlin/math/Constants;", "", "()V", "LN2", "", "epsilon", "taylor_2_bound", "taylor_n_bound", "upper_taylor_2_bound", "upper_taylor_n_bound", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class a {
    @h.k2.d
    public static final double b;
    @h.k2.d

    /* renamed from: c  reason: collision with root package name */
    public static final double f14952c;
    @h.k2.d

    /* renamed from: d  reason: collision with root package name */
    public static final double f14953d;
    @h.k2.d

    /* renamed from: e  reason: collision with root package name */
    public static final double f14954e;
    @h.k2.d

    /* renamed from: f  reason: collision with root package name */
    public static final double f14955f;
    @k.e.a.d

    /* renamed from: g  reason: collision with root package name */
    public static final a f14956g = new a();
    @h.k2.d
    public static final double a = Math.log(2.0d);

    static {
        double ulp = Math.ulp(1.0d);
        b = ulp;
        double sqrt = Math.sqrt(ulp);
        f14952c = sqrt;
        double sqrt2 = Math.sqrt(sqrt);
        f14953d = sqrt2;
        double d2 = 1;
        f14954e = d2 / sqrt;
        f14955f = d2 / sqrt2;
    }

    private a() {
    }
}
