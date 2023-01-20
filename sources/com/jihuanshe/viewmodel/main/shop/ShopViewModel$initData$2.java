package com.jihuanshe.viewmodel.main.shop;

import com.jihuanshe.model.Game;
import com.jihuanshe.ui.widget.GameBar;
import e.g.e.a;
import e.l.m.b;
import h.k2.u.l;
import h.t1;
import java.util.List;
import k.e.a.d;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class ShopViewModel$initData$2 extends Lambda implements l<a, t1> {
    public static final ShopViewModel$initData$2 INSTANCE = new ShopViewModel$initData$2();

    public ShopViewModel$initData$2() {
        super(1);
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(a aVar) {
        invoke2(aVar);
        return t1.a;
    }

    /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.Object] */
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d a aVar) {
        List<Game> t = b.f14084c.t();
        if (!t.isEmpty()) {
            e.l.o.a.a.a.a.j(t, true);
            GameBar.b.a().r(CollectionsKt___CollectionsKt.J2(t, 0));
        }
    }
}
