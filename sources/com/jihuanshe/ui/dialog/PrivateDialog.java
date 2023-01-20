package com.jihuanshe.ui.dialog;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.ui.page.web.CommonWebViewActivityCreator;
import com.vector.util.Res;
import e.l.k.m5;
import e.t.j.h.g;
import h.k2.u.l;
import h.t1;
import k.e.a.d;

/* loaded from: classes2.dex */
public final class PrivateDialog extends BaseDialog {
    @d
    private final l<PrivateDialog, t1> t;
    @d
    private final h.k2.u.a<t1> u;
    @d
    private final LinkMovementMethod v;
    @d
    private final SpannableStringBuilder w;
    @d
    private final g x;
    @d
    private final g y;

    /* loaded from: classes2.dex */
    public static final class a extends ClickableSpan {
        public final /* synthetic */ Context a;

        public a(Context context) {
            this.a = context;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@d View view) {
            CommonWebViewActivityCreator.create("https://api.jihuanshe.com/api/market/articles?type=service_agreement").start(this.a);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@d TextPaint textPaint) {
            textPaint.setColor(Res.k(R.color.common_color_1));
        }
    }

    /* loaded from: classes2.dex */
    public static final class b extends ClickableSpan {
        public final /* synthetic */ Context a;

        public b(Context context) {
            this.a = context;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@d View view) {
            CommonWebViewActivityCreator.create("https://api.jihuanshe.com/api/market/articles?type=privacy_policy").start(this.a);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@d TextPaint textPaint) {
            textPaint.setColor(Res.k(R.color.common_color_1));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PrivateDialog(@d Context context, @d l<? super PrivateDialog, t1> lVar, @d h.k2.u.a<t1> aVar) {
        super(context);
        this.t = lVar;
        this.u = aVar;
        this.v = new LinkMovementMethod();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(Res.w(Res.a, R.string.guide_content, null, 2, null));
        spannableStringBuilder.setSpan(new a(context), 32, 40, 18);
        spannableStringBuilder.setSpan(new b(context), 41, 47, 18);
        t1 t1Var = t1.a;
        this.w = spannableStringBuilder;
        e.t.j.h.d dVar = e.t.j.h.d.a;
        this.x = dVar.a(new PrivateDialog$onRejectClick$1(this));
        this.y = dVar.a(new PrivateDialog$onOKClick$1(this));
    }

    @Override // com.jihuanshe.ui.dialog.BaseDialog
    @d
    public ViewDataBinding d() {
        m5 e2 = m5.e(getLayoutInflater(), this, false);
        e2.h(this);
        return e2;
    }

    @d
    public final LinkMovementMethod getMovementMethod() {
        return this.v;
    }

    @d
    public final g getOnOKClick() {
        return this.y;
    }

    @d
    public final g getOnRejectClick() {
        return this.x;
    }

    @d
    public final SpannableStringBuilder getPrivateTips() {
        return this.w;
    }

    @Override // com.jihuanshe.ui.dialog.BaseDialog
    public void k() {
        setGravity(17);
    }
}
