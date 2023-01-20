package e.l.o.a.a;

import com.jihuanshe.base.model.Result;
import com.jihuanshe.model.Category;
import com.jihuanshe.model.Game;
import com.jihuanshe.model.GameCard;
import e.l.h.i.b;
import e.l.h.i.e;
import e.l.n.c.g;
import e.l.n.c.j;
import e.l.n.c.k;
import e.n.f;
import java.util.ArrayList;
import java.util.List;
import k.e.a.d;
import kotlinx.coroutines.flow.Flow;

/* loaded from: classes2.dex */
public final class a {
    @d
    public static final a a = new a();
    @d
    private static final List<Game> b = new ArrayList();
    @d

    /* renamed from: c */
    private static final f<List<Game>> f14120c = new f<>(null, 1, null);

    private a() {
    }

    public static /* synthetic */ void k(a aVar, List list, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        aVar.j(list, z);
    }

    @d
    public final Flow<List<Game>> a() {
        return g.a.b((g) e.l.n.a.d(g.class, true, false, false, 60L, true), null, 1, null);
    }

    @d
    public final Flow<List<Category>> b(@d Game game) {
        g gVar = (g) e.l.n.a.d(g.class, true, false, false, 60L, true);
        String path = game.getPath();
        if (path == null) {
            path = "";
        }
        return gVar.c(path);
    }

    @d
    public final Flow<Result<b<e<GameCard>>>> c(@k.e.a.e Integer num, @k.e.a.e Integer num2, @k.e.a.e Integer num3, @d Game game, @k.e.a.e String str, @k.e.a.e Integer num4, @k.e.a.e Integer num5, @k.e.a.e String str2, @k.e.a.e String str3, @k.e.a.e String str4, int i2) {
        return ((j) e.l.n.a.d(j.class, false, true, true, 60L, true)).d(num, num2, num3, str, num4, num5, str2, str3, str4, game.getGameKey(), game.getGameSubKey(), i2);
    }

    @d
    public final List<Game> e() {
        return b;
    }

    @d
    public final f<List<Game>> f() {
        return f14120c;
    }

    @d
    public final Flow<Result<b<e<GameCard>>>> g(@d Game game, @k.e.a.e String str, @k.e.a.e String str2, @k.e.a.e String str3, int i2) {
        return ((j) e.l.n.a.d(j.class, false, true, true, 60L, true)).f(str, str2, game.getGameKey(), game.getGameSubKey(), str3, i2);
    }

    @d
    public final Flow<List<List<String>>> i(@d String str, @d String str2) {
        return ((k) e.l.n.a.d(k.class, true, false, false, 60L, true)).a0(str, str2);
    }

    public final void j(@d List<Game> list, boolean z) {
        if (!z) {
            e.l.m.b.f14084c.B(list);
        }
        List<Game> list2 = b;
        list2.clear();
        list2.addAll(list);
        f14120c.r(list2);
    }
}
