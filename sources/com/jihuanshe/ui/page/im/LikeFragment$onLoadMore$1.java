package com.jihuanshe.ui.page.im;

import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.viewmodel.im.LikeViewModel;
import com.vector.design.ui.delegate.LoadMore;
import e.t.v.j.g;
import h.k2.u.p;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class LikeFragment$onLoadMore$1 extends Lambda implements p<g<?>, LoadMore.State, t1> {
    public final /* synthetic */ LikeFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LikeFragment$onLoadMore$1(LikeFragment likeFragment) {
        super(2);
        this.this$0 = likeFragment;
    }

    @Override // h.k2.u.p
    public /* bridge */ /* synthetic */ t1 invoke(g<?> gVar, LoadMore.State state) {
        invoke2(gVar, state);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d g<?> gVar, @d LoadMore.State state) {
        BinderKt.d(((LikeViewModel) this.this$0.T()).q0(state), this.this$0, gVar, true);
    }
}