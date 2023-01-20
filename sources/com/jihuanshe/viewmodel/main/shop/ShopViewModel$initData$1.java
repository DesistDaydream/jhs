package com.jihuanshe.viewmodel.main.shop;

import com.jihuanshe.model.Game;
import com.jihuanshe.ui.widget.GameBar;
import e.l.m.b;
import e.l.o.a.a.a;
import h.k2.u.l;
import h.k2.v.f0;
import h.t1;
import java.util.Iterator;
import java.util.List;
import k.e.a.e;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class ShopViewModel$initData$1 extends Lambda implements l<List<? extends Game>, t1> {
    public static final ShopViewModel$initData$1 INSTANCE = new ShopViewModel$initData$1();

    public ShopViewModel$initData$1() {
        super(1);
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(List<? extends Game> list) {
        invoke2((List<Game>) list);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@e List<Game> list) {
        Object obj;
        Game game;
        Game game2 = null;
        a.k(a.a, list == null ? CollectionsKt__CollectionsKt.E() : list, false, 2, null);
        String r = b.f14084c.r();
        if (list == null) {
            game = null;
        } else {
            Iterator<T> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (f0.g(((Game) obj).getName(), r)) {
                    break;
                }
            }
            game = (Game) obj;
        }
        if (game != null) {
            game2 = game;
        } else if (list != null) {
            game2 = (Game) CollectionsKt___CollectionsKt.J2(list, 0);
        }
        GameBar.b.a().r(game2);
    }
}
