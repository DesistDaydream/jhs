package com.vector.design.ui.decor;

import android.content.Context;
import android.widget.RelativeLayout;
import com.vector.R;
import com.vector.util.Res;
import com.vector.view.ProgressView;
import e.t.l.k;
import e.t.u.p;
import h.k2.u.a;
import k.e.a.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcom/vector/view/ProgressView;"}, k = 3, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class LoadingView$pvDelegate$1 extends Lambda implements a<ProgressView> {
    public final /* synthetic */ Context $context;
    public final /* synthetic */ LoadingView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoadingView$pvDelegate$1(Context context, LoadingView loadingView) {
        super(0);
        this.$context = context;
        this.this$0 = loadingView;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h.k2.u.a
    @d
    public final ProgressView invoke() {
        ProgressView progressView = (ProgressView) k.i(this.$context, R.layout.layout_progress, null, false, 6, null);
        int m2 = (int) Res.a.m(this.$context, R.dimen.loading_icon_size);
        RelativeLayout.LayoutParams p = p.p(m2, m2);
        p.addRule(13);
        this.this$0.addView(progressView, p);
        return progressView;
    }
}
