package e.l.s.n;

import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.ViewModelKt;
import com.eth.ext.FlowKt;
import com.jihuanshe.model.CardProductNew;
import com.jihuanshe.viewmodel.UploadViewModel;
import com.jihuanshe.viewmodel.plugins.impl.ProductBySellerCardVersionIdImpl;
import e.l.n.c.k;
import e.n.f;
import e.n.i;
import h.t1;
import k.e.a.d;
import k.e.a.e;

/* loaded from: classes2.dex */
public final class a extends UploadViewModel implements e.l.s.l.b.b {

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ ProductBySellerCardVersionIdImpl f14349d = new ProductBySellerCardVersionIdImpl();
    @d

    /* renamed from: e  reason: collision with root package name */
    private final f<CardProductNew> f14350e = new f<>(null, 1, null);
    @d

    /* renamed from: f  reason: collision with root package name */
    private final i f14351f = new i(Boolean.FALSE);

    @d
    public final f<CardProductNew> A0() {
        return this.f14350e;
    }

    @d
    public final i B0() {
        return this.f14351f;
    }

    @Override // e.l.s.l.b.b
    @d
    public e.g.d.a<CardProductNew> h(int i2, int i3, int i4, @d String str, @d LifecycleCoroutineScope lifecycleCoroutineScope) {
        return this.f14349d.h(i2, i3, i4, str, lifecycleCoroutineScope);
    }

    @d
    public final e.g.d.a<t1> z0(@e Integer num, @e Float f2, @e Integer num2, @e Integer num3, @e String str, @e String str2, @d String str3) {
        return e.g.d.a.h(FlowKt.c(((k) e.l.n.a.d(k.class, true, false, false, 60L, true)).q(num, f2, num2, num3, str, str2, str3)), ViewModelKt.getViewModelScope(this), null, 2, null);
    }
}
