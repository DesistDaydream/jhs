package com.jihuanshe.binding;

import android.view.View;
import e.t.j.h.m;
import h.k2.u.p;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class RecyclerViewBinding$setOnItemClick$1$2 extends Lambda implements p<View, Integer, Boolean> {
    public final /* synthetic */ m $binding2;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecyclerViewBinding$setOnItemClick$1$2(m mVar) {
        super(2);
        this.$binding2 = mVar;
    }

    @Override // h.k2.u.p
    public /* bridge */ /* synthetic */ Boolean invoke(View view, Integer num) {
        return Boolean.valueOf(invoke(view, num.intValue()));
    }

    public final boolean invoke(@d View view, int i2) {
        p<View, Integer, Boolean> a;
        m mVar = this.$binding2;
        return (mVar == null || (a = mVar.a()) == null || !a.invoke(view, Integer.valueOf(i2)).booleanValue()) ? false : true;
    }
}
