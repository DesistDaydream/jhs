package com.jihuanshe.ui.page;

import android.view.View;
import com.jihuanshe.model.GlobalConfig;
import com.jihuanshe.ui.page.web.CommonWebViewActivityCreator;
import com.jihuanshe.ui.widget.CountDownTextView;
import e.l.r.o0;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class SplashActivity$tryShowPoster$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ SplashActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SplashActivity$tryShowPoster$1(SplashActivity splashActivity) {
        super(1);
        this.this$0 = splashActivity;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(View view) {
        invoke2(view);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d View view) {
        CountDownTextView w;
        GlobalConfig u = o0.f14291c.u();
        String posterLink = u == null ? null : u.getPosterLink();
        if (posterLink == null) {
            posterLink = "";
        }
        CommonWebViewActivityCreator.create(posterLink).start(this.this$0);
        w = this.this$0.w();
        w.e();
    }
}
