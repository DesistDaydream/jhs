package k.a.a;

import java.util.Comparator;

/* loaded from: classes4.dex */
public class e implements Comparator<c> {
    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(c cVar, c cVar2) {
        int size = cVar2.size() - cVar.size();
        return size == 0 ? cVar.getStart() - cVar2.getStart() : size;
    }
}
