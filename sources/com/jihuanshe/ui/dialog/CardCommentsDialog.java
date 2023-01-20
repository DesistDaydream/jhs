package com.jihuanshe.ui.dialog;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.EditText;
import android.widget.RatingBar;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.mmkv.UserKV;
import com.jihuanshe.model.CommentBean;
import com.jihuanshe.model.Constants;
import com.jihuanshe.model.User;
import com.jihuanshe.ui.dialog.CardCommentsDialog;
import com.jihuanshe.ui.page.detail.AtUserActivityCreator;
import com.vector.util.Res;
import e.l.k.s3;
import e.l.l.a;
import e.l.q.a.i;
import e.l.q.a.k0.k;
import e.l.q.a.k0.r;
import e.l.q.c.o0;
import e.t.j.h.g;
import h.k2.u.l;
import h.t1;
import java.util.Objects;
import k.e.a.d;
import k.e.a.e;

/* loaded from: classes2.dex */
public final class CardCommentsDialog extends BaseDialog implements o0.a {
    private final boolean t;
    @d
    private final l<CommentBean, t1> u;
    @e
    private s3 v;
    @d
    private final g w;
    @e
    private o0 x;
    @d
    private final g y;

    /* JADX WARN: Multi-variable type inference failed */
    public CardCommentsDialog(@d Context context, boolean z, @d l<? super CommentBean, t1> lVar) {
        super(context);
        this.t = z;
        this.u = lVar;
        e.t.j.h.d dVar = e.t.j.h.d.a;
        this.w = dVar.a(new CardCommentsDialog$onClickSubmit$1(this));
        this.y = dVar.a(new CardCommentsDialog$onClickClose$1(this));
    }

    private final void E() {
        this.v.b.setOnFocusChangeListener(i.a);
        this.v.f13546c.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() { // from class: e.l.q.a.j
            @Override // android.widget.RatingBar.OnRatingBarChangeListener
            public final void onRatingChanged(RatingBar ratingBar, float f2, boolean z) {
                CardCommentsDialog.J(CardCommentsDialog.this, ratingBar, f2, z);
            }
        });
        this.x = new o0(this.v.b, Res.k(R.color.service_charge_color), this);
        this.v.b.addTextChangedListener(this.x);
    }

    public static final void F(View view, boolean z) {
        if (z) {
            a.d(new CardCommentsDialog$initEvent$1$1(view));
        }
    }

    public static final void G(CardCommentsDialog cardCommentsDialog, RatingBar ratingBar, float f2, boolean z) {
        if (cardCommentsDialog.H()) {
            cardCommentsDialog.getBinding().f13547d.setText(Constants.Companion.getSCORE_CONTENT_CARD().get((int) f2));
        } else {
            cardCommentsDialog.getBinding().f13547d.setText(Constants.Companion.getSCORE_CONTENT_PACK().get((int) f2));
        }
    }

    public static /* synthetic */ void J(CardCommentsDialog cardCommentsDialog, RatingBar ratingBar, float f2, boolean z) {
        G(cardCommentsDialog, ratingBar, f2, z);
    }

    public final void D() {
        String obj = this.v.b.getText().toString();
        EditText editText = this.v.b;
        Objects.requireNonNull(obj, "null cannot be cast to non-null type java.lang.String");
        editText.setText(obj.substring(0, obj.length() - 1));
    }

    public final boolean H() {
        return this.t;
    }

    public final void K(@d User user) {
        o0 o0Var = this.x;
        if (o0Var == null) {
            return;
        }
        String name = user.getName();
        if (name == null) {
            name = "";
        }
        o0Var.g(name, user.getId());
    }

    @Override // com.jihuanshe.ui.dialog.BaseDialog
    @d
    public ViewDataBinding d() {
        s3 e2 = s3.e(getLayoutInflater(), this, false);
        this.v = e2;
        e2.h(this);
        E();
        return this.v;
    }

    @e
    public final s3 getBinding() {
        return this.v;
    }

    @d
    public final g getOnClickClose() {
        return this.y;
    }

    @d
    public final g getOnClickSubmit() {
        return this.w;
    }

    @d
    public final l<CommentBean, t1> getSubmit() {
        return this.u;
    }

    @Override // e.l.q.c.o0.a
    public void i() {
        AtUserActivityCreator create = AtUserActivityCreator.create(Integer.valueOf(UserKV.f3913c.v()));
        Context context = getContext();
        Objects.requireNonNull(context, "null cannot be cast to non-null type android.app.Activity");
        create.start((Activity) context, 10001);
    }

    @Override // com.jihuanshe.ui.dialog.BaseDialog
    public void k() {
        setMoveWithKeyboard(true);
        setGravity(80);
    }

    @Override // com.jihuanshe.ui.dialog.BaseDialog
    @d
    public k l(@d View view) {
        return new r(view);
    }

    public final void setBinding(@e s3 s3Var) {
        this.v = s3Var;
    }
}
