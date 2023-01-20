package com.jihuanshe.ui.page.search.fragments.global;

import com.jihuanshe.model.Game;
import e.l.s.m.d.a;
import e.n.i;
import h.k2.u.l;
import h.t1;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class GlobalSearchProductFragment$onFilterGame$1 extends Lambda implements l<Game, t1> {
    public final /* synthetic */ GlobalSearchProductFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GlobalSearchProductFragment$onFilterGame$1(GlobalSearchProductFragment globalSearchProductFragment) {
        super(1);
        this.this$0 = globalSearchProductFragment;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(Game game) {
        invoke2(game);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@e Game game) {
        ((a) this.this$0.T()).p0().setValue(game);
        ((a) this.this$0.T()).q0().n();
        i u0 = ((a) this.this$0.T()).u0();
        Integer value = ((a) this.this$0.T()).r0().getValue();
        u0.setValue(Boolean.valueOf((value == null || value.intValue() != 1) && game != null));
    }
}
