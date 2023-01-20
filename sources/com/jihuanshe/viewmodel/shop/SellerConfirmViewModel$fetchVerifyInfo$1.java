package com.jihuanshe.viewmodel.shop;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.jihuanshe.model.VerifyInfo;
import com.jihuanshe.ui.page.web.CommonWebViewActivityCreator;
import e.n.f;
import h.k2.u.l;
import h.t1;
import java.util.List;
import k.e.a.d;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class SellerConfirmViewModel$fetchVerifyInfo$1 extends Lambda implements l<VerifyInfo, t1> {
    public final /* synthetic */ Context $context;
    public final /* synthetic */ SellerConfirmViewModel this$0;

    /* loaded from: classes2.dex */
    public static final class a extends ClickableSpan {
        public final /* synthetic */ Context a;

        public a(Context context) {
            this.a = context;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@d View view) {
            CommonWebViewActivityCreator.create("https://api.jihuanshe.com/api/market/articles?type=wechat_pay_apply_merchant_faq").start(this.a);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@d TextPaint textPaint) {
            textPaint.setColor(textPaint.linkColor);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SellerConfirmViewModel$fetchVerifyInfo$1(SellerConfirmViewModel sellerConfirmViewModel, Context context) {
        super(1);
        this.this$0 = sellerConfirmViewModel;
        this.$context = context;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(VerifyInfo verifyInfo) {
        invoke2(verifyInfo);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@e VerifyInfo verifyInfo) {
        List<String> banks;
        String tips;
        String tips2;
        int i2 = 0;
        this.this$0.F0().r((verifyInfo == null || (banks = verifyInfo.getBanks()) == null) ? null : banks.subList(0, verifyInfo.getBanks().size() - 1));
        f<CharSequence> N0 = this.this$0.N0();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(verifyInfo != null ? verifyInfo.getTips() : null);
        a aVar = new a(this.$context);
        int length = ((verifyInfo == null || (tips = verifyInfo.getTips()) == null) ? 0 : tips.length()) - 15;
        if (verifyInfo != null && (tips2 = verifyInfo.getTips()) != null) {
            i2 = tips2.length();
        }
        spannableStringBuilder.setSpan(aVar, length, i2, 18);
        t1 t1Var = t1.a;
        N0.r(spannableStringBuilder);
    }
}
