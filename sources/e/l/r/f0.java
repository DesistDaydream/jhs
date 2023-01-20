package e.l.r;

import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class f0 {
    @k.e.a.d
    public static final f0 a = new f0();
    private static Gson b = new e.j.e.d().d();

    private f0() {
    }

    public final Gson a() {
        return b;
    }

    @k.e.a.d
    public final <T> List<T> b(@k.e.a.e String str, @k.e.a.e Class<T> cls) throws Exception {
        e.j.e.e p = new e.j.e.k().c(str).p();
        ArrayList arrayList = new ArrayList();
        Iterator<e.j.e.h> it = p.iterator();
        while (it.hasNext()) {
            e.j.e.h next = it.next();
            Objects.requireNonNull(next, "null cannot be cast to non-null type com.google.gson.JsonElement");
            arrayList.add(b.i(next, cls));
        }
        return arrayList;
    }

    public final void c(Gson gson) {
        b = gson;
    }

    public final String d(@k.e.a.d Object obj) {
        return b.z(obj);
    }
}
