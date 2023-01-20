package com.jihuanshe.ui.page.shop;

import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.ui.widget.GameBar;
import com.jihuanshe.viewmodel.shop.ChooseCardViewModel;
import com.vector.design.ui.delegate.LoadMore;
import e.g.d.a;
import e.t.v.j.g;
import h.k2.u.p;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class ChooseCardActivity$onLoadMore$1 extends Lambda implements p<g<?>, LoadMore.State, t1> {
    public final /* synthetic */ ChooseCardActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChooseCardActivity$onLoadMore$1(ChooseCardActivity chooseCardActivity) {
        super(2);
        this.this$0 = chooseCardActivity;
    }

    @Override // h.k2.u.p
    public /* bridge */ /* synthetic */ t1 invoke(g<?> gVar, LoadMore.State state) {
        invoke2(gVar, state);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d g<?> gVar, @d LoadMore.State state) {
        a<?> E0 = ((ChooseCardViewModel) this.this$0.L()).E0(GameBar.b.a().getValue(), this.this$0.a0(), this.this$0.d0(), null, state);
        if (E0 == null) {
            return;
        }
        BinderKt.d(E0, this.this$0, gVar, true);
    }
}
