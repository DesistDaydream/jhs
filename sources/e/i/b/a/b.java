package e.i.b.a;

import e.i.b.a.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

/* loaded from: classes.dex */
public final class b implements j {
    public static final a.C0332a a = new a.C0332a();

    @Override // e.i.b.a.j
    public List<k.a.b.a> a(Collection<k.a.b.a> collection) {
        if (collection == null) {
            return null;
        }
        ArrayList<k.a.b.a> arrayList = new ArrayList(collection);
        Collections.sort(arrayList, a);
        int i2 = -1;
        TreeSet treeSet = new TreeSet();
        for (k.a.b.a aVar : arrayList) {
            if (aVar.getStart() > i2 && aVar.H() > i2) {
                i2 = aVar.H();
            } else {
                treeSet.add(aVar);
            }
        }
        arrayList.removeAll(treeSet);
        return arrayList;
    }
}
