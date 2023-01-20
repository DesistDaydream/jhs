package e.l.g;

import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.model.CardVersionInfo;
import com.jihuanshe.ui.dialog.CardPackListDialog;
import e.t.o.d;

/* loaded from: classes2.dex */
public final class k extends e.t.k.a.c.a<CardVersionInfo> {
    @k.e.a.d

    /* renamed from: d  reason: collision with root package name */
    private final CardPackListDialog f12033d;
    @k.e.a.d

    /* renamed from: e  reason: collision with root package name */
    private final e.t.r.a.b f12034e;

    public k(@k.e.a.d CardPackListDialog cardPackListDialog) {
        super(null, 1, null);
        this.f12033d = cardPackListDialog;
        this.f12034e = new e.t.r.a.b(d.a.c(e.t.o.d.a, null, 1, null).d(4));
    }

    @Override // e.t.k.a.c.a
    public int t() {
        return R.layout.item_card_pack_list;
    }

    @k.e.a.d
    public final CardPackListDialog v() {
        return this.f12033d;
    }

    @k.e.a.d
    public final e.t.r.a.b w() {
        return this.f12034e;
    }

    @Override // e.t.k.a.c.a
    /* renamed from: x */
    public void u(@k.e.a.d CardVersionInfo cardVersionInfo, @k.e.a.d ViewDataBinding viewDataBinding) {
        viewDataBinding.setVariable(4, this.f12033d);
        viewDataBinding.setVariable(2, this);
        viewDataBinding.setVariable(8, cardVersionInfo);
    }
}
