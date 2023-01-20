package com.jihuanshe.binding;

import android.view.View;
import e.t.j.h.l;
import h.k2.u.p;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class RecyclerViewBinding$setOnItemClick$1$1 extends Lambda implements p<View, Integer, t1> {
    public final /* synthetic */ l $binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecyclerViewBinding$setOnItemClick$1$1(l lVar) {
        super(2);
        this.$binding = lVar;
    }

    @Override // h.k2.u.p
    public /* bridge */ /* synthetic */ t1 invoke(View view, Integer num) {
        invoke(view, num.intValue());
        return t1.a;
    }

    public final void invoke(@d View view, int i2) {
        p<View, Integer, t1> a;
        l lVar = this.$binding;
        if (lVar == null || (a = lVar.a()) == null) {
            return;
        }
        a.invoke(view, Integer.valueOf(i2));
    }
}
