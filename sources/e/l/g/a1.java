package e.l.g;

import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.model.WantCard;
import e.t.o.d;

/* loaded from: classes2.dex */
public final class a1 extends e.t.k.a.c.a<WantCard> {
    @k.e.a.d

    /* renamed from: d  reason: collision with root package name */
    private final e.t.r.a.b f12012d;

    public a1() {
        super(null, 1, null);
        this.f12012d = new e.t.r.a.b(d.a.c(e.t.o.d.a, null, 1, null).d(3));
    }

    @Override // e.t.k.a.c.a
    public int t() {
        return R.layout.item_want_card_new;
    }

    @k.e.a.d
    public final e.t.r.a.b v() {
        return this.f12012d;
    }

    @Override // e.t.k.a.c.a
    /* renamed from: w */
    public void u(@k.e.a.d WantCard wantCard, @k.e.a.d ViewDataBinding viewDataBinding) {
        viewDataBinding.setVariable(8, wantCard);
        viewDataBinding.setVariable(17, this.f12012d);
    }
}
