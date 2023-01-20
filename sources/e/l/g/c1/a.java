package e.l.g.c1;

import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.model.Constants;
import com.jihuanshe.model.Product;
import e.t.k.a.c.f;
import e.t.o.d;
import h.k2.v.f0;
import k.e.a.d;

/* loaded from: classes2.dex */
public final class a extends f<Product> {

    /* renamed from: d  reason: collision with root package name */
    private final int f12020d;

    /* renamed from: e  reason: collision with root package name */
    private final int f12021e;
    @d

    /* renamed from: f  reason: collision with root package name */
    private final e.t.r.a.b f12022f;

    public a() {
        super(null, 1, null);
        this.f12021e = 1;
        this.f12022f = new e.t.r.a.b(d.a.c(e.t.o.d.a, null, 1, null).d(2));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        Product item = getItem(i2);
        if (f0.g(item == null ? null : item.getType(), Constants.Companion.getTYPE_PACK())) {
            return this.f12021e;
        }
        return this.f12020d;
    }

    @Override // e.t.k.a.c.f
    public int h(int i2) {
        return i2 == this.f12021e ? R.layout.item_search_pack : R.layout.item_search_product;
    }

    @k.e.a.d
    public final e.t.r.a.b t() {
        return this.f12022f;
    }

    @Override // e.t.k.a.c.f
    /* renamed from: u */
    public void n(int i2, @k.e.a.d Product product, @k.e.a.d ViewDataBinding viewDataBinding) {
        viewDataBinding.setVariable(10, this);
        viewDataBinding.setVariable(8, product);
    }
}
