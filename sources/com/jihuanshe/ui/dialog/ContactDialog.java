package com.jihuanshe.ui.dialog;

import android.content.Context;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.model.GameCard;
import com.jihuanshe.viewmodel.user.SellerDetailViewModel;
import com.vector.network.image.NImageView;
import e.l.k.i4;
import e.l.q.a.k0.k;
import e.l.q.a.k0.r;
import e.t.j.h.g;
import k.e.a.d;

/* loaded from: classes2.dex */
public final class ContactDialog extends BaseDialog {
    @d
    private final GameCard t;
    @d
    private final SellerDetailViewModel u;
    @d
    private final g v;
    @d
    private final g w;

    public ContactDialog(@d Context context, @d GameCard gameCard, @d SellerDetailViewModel sellerDetailViewModel) {
        super(context);
        this.t = gameCard;
        this.u = sellerDetailViewModel;
        e.t.j.h.d dVar = e.t.j.h.d.a;
        this.v = dVar.a(new ContactDialog$onClickClose$1(this));
        this.w = dVar.a(new ContactDialog$onContact$1(context, this));
    }

    @d
    public final g C(@d NImageView nImageView) {
        return e.t.j.h.d.a.a(new ContactDialog$onClickImage$1(this, nImageView));
    }

    @Override // com.jihuanshe.ui.dialog.BaseDialog
    @d
    public ViewDataBinding d() {
        i4 e2 = i4.e(getLayoutInflater(), this, false);
        e2.h(this);
        return e2;
    }

    @d
    public final g getOnClickClose() {
        return this.v;
    }

    @d
    public final g getOnContact() {
        return this.w;
    }

    @d
    public final GameCard getProduct() {
        return this.t;
    }

    @d
    public final SellerDetailViewModel getViewModel() {
        return this.u;
    }

    @Override // com.jihuanshe.ui.dialog.BaseDialog
    public void k() {
        super.k();
        setGravity(80);
    }

    @Override // com.jihuanshe.ui.dialog.BaseDialog
    @d
    public k l(@d View view) {
        return new r(view);
    }
}
