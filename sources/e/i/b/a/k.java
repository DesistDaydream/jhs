package e.i.b.a;

import java.util.List;
import java.util.TreeSet;
import k.a.b.f;

/* loaded from: classes.dex */
public final class k {
    private k() {
    }

    public static k.a.b.f a(List<h> list) {
        TreeSet<String> treeSet = new TreeSet();
        f.b j2 = k.a.b.f.j();
        if (list != null) {
            for (h hVar : list) {
                if (hVar != null && hVar.a() != null) {
                    treeSet.addAll(hVar.a());
                }
            }
            if (treeSet.size() > 0) {
                for (String str : treeSet) {
                    j2.a(str);
                }
                return j2.d();
            }
            return null;
        }
        return null;
    }
}
