package com.jihuanshe.viewmodel;

import h.k2.u.l;
import h.t1;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class FilterRarityImpl$observeRarity$1 extends Lambda implements l<String, t1> {
    public final /* synthetic */ l<String, t1> $block;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FilterRarityImpl$observeRarity$1(l<? super String, t1> lVar) {
        super(1);
        this.$block = lVar;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(String str) {
        invoke2(str);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@e String str) {
        this.$block.invoke(str);
    }
}
