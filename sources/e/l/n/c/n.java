package e.l.n.c;

import com.jihuanshe.model.CardProduct;
import java.util.List;

/* loaded from: classes2.dex */
public final class n {
    @e.j.e.r.c("order_preview_id")
    private final int a;
    @e.j.e.r.c("product_price")
    @k.e.a.d
    private final String b;
    @e.j.e.r.c("shipping_price")
    @k.e.a.d

    /* renamed from: c  reason: collision with root package name */
    private final String f14097c;
    @e.j.e.r.c("total_price")
    @k.e.a.d

    /* renamed from: d  reason: collision with root package name */
    private final String f14098d;
    @e.j.e.r.c("carts")
    @k.e.a.e

    /* renamed from: e  reason: collision with root package name */
    private final List<CardProduct> f14099e;

    public n() {
        this(0, null, null, null, null, 31, null);
    }

    public n(int i2, @k.e.a.d String str, @k.e.a.d String str2, @k.e.a.d String str3, @k.e.a.e List<CardProduct> list) {
        this.a = i2;
        this.b = str;
        this.f14097c = str2;
        this.f14098d = str3;
        this.f14099e = list;
    }

    public final int a() {
        return this.a;
    }

    @k.e.a.e
    public final List<CardProduct> b() {
        return this.f14099e;
    }

    @k.e.a.d
    public final String c() {
        return this.b;
    }

    @k.e.a.d
    public final String d() {
        return this.f14097c;
    }

    @k.e.a.d
    public final String e() {
        return this.f14098d;
    }

    public /* synthetic */ n(int i2, String str, String str2, String str3, List list, int i3, h.k2.v.u uVar) {
        this((i3 & 1) != 0 ? 0 : i2, (i3 & 2) != 0 ? "" : str, (i3 & 4) != 0 ? "" : str2, (i3 & 8) == 0 ? str3 : "", (i3 & 16) != 0 ? null : list);
    }
}
