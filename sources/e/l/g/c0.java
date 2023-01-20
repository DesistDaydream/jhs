package e.l.g;

import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;

/* loaded from: classes2.dex */
public final class c0 extends e<String> {
    @Override // e.l.g.e
    public int b() {
        return R.layout.item_pop_list;
    }

    @Override // e.l.g.e
    /* renamed from: h */
    public void d(@k.e.a.e String str, @k.e.a.e ViewDataBinding viewDataBinding) {
        if (viewDataBinding == null) {
            return;
        }
        viewDataBinding.setVariable(8, str);
    }
}
