package e.l.g;

import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.model.Category;

/* loaded from: classes2.dex */
public final class m0 extends e.t.k.a.c.f<Object> {
    public m0() {
        super(null, 1, null);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        return !(getItem(i2) instanceof Category) ? 1 : 0;
    }

    @Override // e.t.k.a.c.f
    public int h(int i2) {
        return i2 == 0 ? R.layout.item_title_kind : R.layout.item_pack;
    }

    @Override // e.t.k.a.c.f
    public void n(int i2, @k.e.a.d Object obj, @k.e.a.d ViewDataBinding viewDataBinding) {
        viewDataBinding.setVariable(8, obj);
        viewDataBinding.setVariable(11, Integer.valueOf(j()));
    }
}
