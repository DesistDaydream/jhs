package e.l.l;

import com.jihuanshe.mmkv.UserKV;
import com.jihuanshe.model.Game;
import com.jihuanshe.ui.page.exam.EtiquetteExamActivityCreator;
import com.jihuanshe.ui.page.login.LoginActivityCreator;
import h.k2.v.f0;
import h.t1;
import java.util.Iterator;
import k.e.a.d;
import k.e.a.e;

/* loaded from: classes2.dex */
public final class a {
    @e
    public static final Game a(@e String str) {
        Object obj = null;
        if (str == null) {
            return null;
        }
        Iterator<T> it = e.l.o.a.a.a.a.e().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (f0.g(((Game) next).getGameKey(), str)) {
                obj = next;
                break;
            }
        }
        return (Game) obj;
    }

    @e
    public static final Game b(@e String str, @e String str2) {
        boolean z;
        Object obj = null;
        if (str == null || str2 == null) {
            return null;
        }
        Iterator<T> it = e.l.o.a.a.a.a.e().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            Game game = (Game) next;
            if (f0.g(game.getGameKey(), str) && f0.g(game.getGameSubKey(), str2)) {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (z) {
                obj = next;
                break;
            }
        }
        return (Game) obj;
    }

    public static final boolean c(@d h.k2.u.a<t1> aVar) {
        if (d(null)) {
            if (!UserKV.f3913c.s()) {
                EtiquetteExamActivityCreator.create().start(e.t.a.b());
                return false;
            }
            aVar.invoke();
            return true;
        }
        return false;
    }

    public static final boolean d(@e h.k2.u.a<t1> aVar) {
        if (UserKV.f3913c.u().length() == 0) {
            LoginActivityCreator.create().start(e.t.a.b());
            return false;
        }
        if (aVar != null) {
            aVar.invoke();
        }
        return true;
    }
}
