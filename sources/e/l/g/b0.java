package e.l.g;

import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.model.Category;

/* loaded from: classes2.dex */
public final class b0 extends e.t.k.a.c.a<Category> {

    /* renamed from: d  reason: collision with root package name */
    private int f12014d;

    public b0() {
        super(null, 1, null);
    }

    @Override // e.t.k.a.c.a
    public int t() {
        return R.layout.item_kind;
    }

    public final int v() {
        return this.f12014d;
    }

    @Override // e.t.k.a.c.a
    /* renamed from: w */
    public void u(@k.e.a.d Category category, @k.e.a.d ViewDataBinding viewDataBinding) {
        viewDataBinding.setVariable(8, category);
        viewDataBinding.setVariable(16, Boolean.valueOf(this.f12014d == j()));
    }

    public final void x(int i2) {
        this.f12014d = i2;
        notifyDataSetChanged();
    }
}
