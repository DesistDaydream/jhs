package e.l.g;

import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;

/* loaded from: classes2.dex */
public final class q0 extends e.t.k.a.c.a<String> {

    /* renamed from: d  reason: collision with root package name */
    private int f12045d;

    public q0() {
        super(null, 1, null);
    }

    @Override // e.t.k.a.c.a
    public int t() {
        return R.layout.item_report_seller;
    }

    public final int v() {
        return this.f12045d;
    }

    @Override // e.t.k.a.c.a
    /* renamed from: w */
    public void u(@k.e.a.d String str, @k.e.a.d ViewDataBinding viewDataBinding) {
        viewDataBinding.setVariable(15, Boolean.valueOf(this.f12045d == j()));
        viewDataBinding.setVariable(9, str);
    }

    public final void x(int i2) {
        this.f12045d = i2;
    }
}
