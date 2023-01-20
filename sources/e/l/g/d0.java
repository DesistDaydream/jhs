package e.l.g;

import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;

/* loaded from: classes2.dex */
public final class d0 extends e.t.k.a.c.a<z> {

    /* renamed from: d  reason: collision with root package name */
    private int f12025d;

    public d0() {
        this(0, 1, null);
    }

    public d0(int i2) {
        super(null, 1, null);
        this.f12025d = i2;
    }

    @Override // e.t.k.a.c.a
    public int t() {
        return R.layout.item_choose;
    }

    public final int v() {
        return this.f12025d;
    }

    @Override // e.t.k.a.c.a
    /* renamed from: w */
    public void u(@k.e.a.d z zVar, @k.e.a.d ViewDataBinding viewDataBinding) {
        viewDataBinding.setVariable(8, zVar);
        viewDataBinding.setVariable(14, Boolean.valueOf(j() == this.f12025d));
    }

    public final void x(int i2) {
        this.f12025d = i2;
    }

    public /* synthetic */ d0(int i2, int i3, h.k2.v.u uVar) {
        this((i3 & 1) != 0 ? -1 : i2);
    }
}
