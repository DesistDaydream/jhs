package com.jihuanshe.ui.page.user.wish;

import com.jihuanshe.model.Game;
import e.l.s.o.e.a;
import h.k2.u.l;
import h.t1;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class DesireFragment$onFilterGame$1 extends Lambda implements l<Game, t1> {
    public final /* synthetic */ DesireFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DesireFragment$onFilterGame$1(DesireFragment desireFragment) {
        super(1);
        this.this$0 = desireFragment;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(Game game) {
        invoke2(game);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@e Game game) {
        ((a) this.this$0.T()).p0().r(game);
    }
}
