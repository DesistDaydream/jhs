package e.l.g;

import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;

/* loaded from: classes2.dex */
public final class r extends e.t.k.a.c.a<String> {

    /* renamed from: d */
    private int f12046d;

    public r() {
        super(null, 1, null);
    }

    @Override // e.t.k.a.c.a
    public int t() {
        return R.layout.item_condition;
    }

    public final int v() {
        return this.f12046d;
    }

    @Override // e.t.k.a.c.a
    /* renamed from: w */
    public void u(@k.e.a.d String str, @k.e.a.d ViewDataBinding viewDataBinding) {
        viewDataBinding.setVariable(10, this);
        viewDataBinding.setVariable(8, str);
        viewDataBinding.setVariable(11, Integer.valueOf(j()));
    }

    public final void x(int i2) {
        this.f12046d = i2;
        notifyDataSetChanged();
    }
}
