package k.a.a;

import java.util.Collections;
import java.util.List;
import java.util.TreeSet;
import org.ahocorasick.interval.IntervalNode;

/* loaded from: classes4.dex */
public class b {
    private final IntervalNode a;

    public b(List<c> list) {
        this.a = new IntervalNode(list);
    }

    public List<c> a(c cVar) {
        return this.a.g(cVar);
    }

    public List<c> b(List<c> list) {
        Collections.sort(list, new e());
        TreeSet<c> treeSet = new TreeSet();
        for (c cVar : list) {
            if (!treeSet.contains(cVar)) {
                treeSet.addAll(a(cVar));
            }
        }
        for (c cVar2 : treeSet) {
            list.remove(cVar2);
        }
        Collections.sort(list, new d());
        return list;
    }
}
