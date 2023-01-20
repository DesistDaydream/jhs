package com.jihuanshe.ui.page.detail;

import android.view.ViewGroup;
import android.widget.TextView;
import com.google.android.material.appbar.AppBarLayout;
import h.k2.u.p;
import h.r0;
import h.t1;
import k.e.a.d;
import kotlin.Result;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class CardDetailActivity$onScroll$1 extends Lambda implements p<AppBarLayout, Integer, t1> {
    public final /* synthetic */ CardDetailActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardDetailActivity$onScroll$1(CardDetailActivity cardDetailActivity) {
        super(2);
        this.this$0 = cardDetailActivity;
    }

    @Override // h.k2.u.p
    public /* bridge */ /* synthetic */ t1 invoke(AppBarLayout appBarLayout, Integer num) {
        invoke(appBarLayout, num.intValue());
        return t1.a;
    }

    public final void invoke(@d AppBarLayout appBarLayout, int i2) {
        CardDetailActivity cardDetailActivity = this.this$0;
        try {
            Result.a aVar = Result.Companion;
            float abs = Math.abs(i2) / (appBarLayout.getTotalScrollRange() / 4);
            float f2 = 255;
            int H0 = h.l2.d.H0(Math.min(abs, 1.0f) * f2);
            TextView C0 = cardDetailActivity.C0();
            if (C0 != null) {
                C0.setAlpha(H0 / f2);
            }
            ViewGroup v0 = cardDetailActivity.v0();
            if (v0 != null) {
                v0.setAlpha(H0 / f2);
            }
            Result.m106constructorimpl(t1.a);
        } catch (Throwable th) {
            Result.a aVar2 = Result.Companion;
            Result.m106constructorimpl(r0.a(th));
        }
    }
}
