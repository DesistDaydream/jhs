package e.l.g;

import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.model.CardVersionInfo;
import e.t.o.d;

/* loaded from: classes2.dex */
public final class l extends e.t.k.a.c.a<CardVersionInfo> {
    @k.e.a.d

    /* renamed from: d  reason: collision with root package name */
    private final e.t.r.a.b f12036d;

    public l() {
        super(null, 1, null);
        this.f12036d = new e.t.r.a.b(d.a.c(e.t.o.d.a, null, 1, null).d(6));
    }

    @Override // e.t.k.a.c.a
    public int t() {
        return R.layout.item_pack_card_list;
    }

    @k.e.a.d
    public final e.t.r.a.b v() {
        return this.f12036d;
    }

    @Override // e.t.k.a.c.a
    /* renamed from: w */
    public void u(@k.e.a.d CardVersionInfo cardVersionInfo, @k.e.a.d ViewDataBinding viewDataBinding) {
        viewDataBinding.setVariable(2, this);
        viewDataBinding.setVariable(8, cardVersionInfo);
    }
}
