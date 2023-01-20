package e.l.g;

import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import kotlin.Pair;

/* loaded from: classes2.dex */
public final class w0 extends e.t.k.a.c.a<Pair<? extends String, ? extends String>> {
    public w0() {
        super(null, 1, null);
    }

    @Override // e.t.k.a.c.a
    public int t() {
        return R.layout.item_sort;
    }

    @Override // e.t.k.a.c.a
    /* renamed from: v */
    public void u(@k.e.a.d Pair<String, String> pair, @k.e.a.d ViewDataBinding viewDataBinding) {
        viewDataBinding.setVariable(8, pair);
        viewDataBinding.setVariable(10, this);
    }
}
