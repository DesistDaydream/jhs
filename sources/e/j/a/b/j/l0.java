package e.j.a.b.j;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: classes2.dex */
public final class l0 implements c<Void, k<List<k<?>>>> {
    private final /* synthetic */ Collection a;

    public l0(Collection collection) {
        this.a = collection;
    }

    @Override // e.j.a.b.j.c
    public final /* synthetic */ k<List<k<?>>> a(@NonNull k<Void> kVar) throws Exception {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.a);
        return n.e(arrayList);
    }
}
