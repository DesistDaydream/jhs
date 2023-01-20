package com.jihuanshe.ui.widget;

import com.jihuanshe.model.Game;
import e.l.m.b;
import e.n.f;
import h.k2.u.a;
import h.k2.v.f0;
import java.util.Iterator;
import java.util.List;
import k.e.a.d;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class GameBar$Companion$curGame$2 extends Lambda implements a<f<Game>> {
    public static final GameBar$Companion$curGame$2 INSTANCE = new GameBar$Companion$curGame$2();

    public GameBar$Companion$curGame$2() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h.k2.u.a
    @d
    public final f<Game> invoke() {
        Object obj;
        b bVar = b.f14084c;
        List<Game> t = bVar.t();
        String r = bVar.r();
        Iterator<T> it = t.iterator();
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
        Game game = (Game) obj;
        if (game == null) {
            game = (Game) CollectionsKt___CollectionsKt.J2(t, 0);
        }
        return new f<>(game);
    }
}
