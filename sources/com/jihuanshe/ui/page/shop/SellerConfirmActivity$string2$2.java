package com.jihuanshe.ui.page.shop;

import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.jihuanshe.R;
import com.jihuanshe.ui.page.web.CommonWebViewActivityCreator;
import com.vector.util.Res;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class SellerConfirmActivity$string2$2 extends Lambda implements h.k2.u.a<SpannableStringBuilder> {
    public final /* synthetic */ SellerConfirmActivity this$0;

    /* loaded from: classes2.dex */
    public static final class a extends ClickableSpan {
        public final /* synthetic */ SellerConfirmActivity a;

        public a(SellerConfirmActivity sellerConfirmActivity) {
            this.a = sellerConfirmActivity;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@d View view) {
            CommonWebViewActivityCreator.create("https://api.jihuanshe.com/api/market/articles?type=seller_agreement").urlTitle(Res.w(Res.a, R.string.confirm_protocol_title, null, 2, null)).start(this.a);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@d TextPaint textPaint) {
            textPaint.setColor(textPaint.linkColor);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SellerConfirmActivity$string2$2(SellerConfirmActivity sellerConfirmActivity) {
        super(0);
        this.this$0 = sellerConfirmActivity;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h.k2.u.a
    @d
    public final SpannableStringBuilder invoke() {
        String w = Res.w(Res.a, R.string.confirm_protocol, null, 2, null);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(w);
        spannableStringBuilder.setSpan(new a(this.this$0), w.length() - 8, w.length(), 18);
        return spannableStringBuilder;
    }
}
