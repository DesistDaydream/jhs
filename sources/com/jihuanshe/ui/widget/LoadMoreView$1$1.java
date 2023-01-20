package com.jihuanshe.ui.widget;

import android.view.View;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class LoadMoreView$1$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ LoadMoreView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoadMoreView$1$1(LoadMoreView loadMoreView) {
        super(1);
        this.this$0 = loadMoreView;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(View view) {
        invoke2(view);
        return t1.a;
    }

    /* renamed from: invoke */
    public final void invoke2(@d View view) {
        l<View, t1> onRetryClick = this.this$0.getOnRetryClick();
        if (onRetryClick == null) {
            return;
        }
        onRetryClick.invoke(view);
    }
}
