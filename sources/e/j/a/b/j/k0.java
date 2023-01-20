package e.j.a.b.j;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public final class k0 implements c<Void, List<TResult>> {
    private final /* synthetic */ Collection a;

    public k0(Collection collection) {
        this.a = collection;
    }

    @Override // e.j.a.b.j.c
    public final /* synthetic */ Object a(@NonNull k<Void> kVar) throws Exception {
        if (this.a.size() == 0) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (k kVar2 : this.a) {
            arrayList.add(kVar2.r());
        }
        return arrayList;
    }
}
