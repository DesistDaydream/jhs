package k.a.b.h;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class b implements d {
    private final List<k.a.b.a> a = new ArrayList();

    @Override // k.a.b.h.d
    public List<k.a.b.a> a() {
        return this.a;
    }

    @Override // k.a.b.h.c
    public boolean b(k.a.b.a aVar) {
        this.a.add(aVar);
        return true;
    }
}
