package e.l.g;

import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.model.IllegalData;

/* loaded from: classes2.dex */
public final class a0 extends e.t.k.a.c.a<IllegalData> {
    public a0() {
        super(null, 1, null);
    }

    @Override // e.t.k.a.c.a
    public int t() {
        return R.layout.item_illegal;
    }

    @Override // e.t.k.a.c.a
    /* renamed from: v */
    public void u(@k.e.a.d IllegalData illegalData, @k.e.a.d ViewDataBinding viewDataBinding) {
        viewDataBinding.setVariable(8, illegalData);
    }
}
