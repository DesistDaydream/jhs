package com.jihuanshe.ui.page.im;

import com.jihuanshe.model.InteractData;
import e.l.h.d.f;
import e.l.h.d.i;
import e.l.j.a;
import h.k2.u.l;
import h.t1;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class AtMeFragment$onItemClick$1$1$1 extends Lambda implements l<t1, t1> {
    public final /* synthetic */ InteractData $data;
    public final /* synthetic */ int $position;
    public final /* synthetic */ AtMeFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AtMeFragment$onItemClick$1$1$1(InteractData interactData, AtMeFragment atMeFragment, int i2) {
        super(1);
        this.$data = interactData;
        this.this$0 = atMeFragment;
        this.$position = i2;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(t1 t1Var) {
        invoke2(t1Var);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@e t1 t1Var) {
        this.$data.setReaded(Boolean.TRUE);
        this.this$0.e0().notifyItemChanged(this.$position);
        i.d(f.b, a.y, null, 2, null);
    }
}
