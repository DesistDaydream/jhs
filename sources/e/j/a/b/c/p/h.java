package e.j.a.b.c.p;

import android.os.Bundle;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class h {
    @e.j.a.b.c.m.a
    public static final String a = "next_page_token";
    @e.j.a.b.c.m.a
    public static final String b = "prev_page_token";

    private h() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T, E extends j<T>> ArrayList<T> a(b<E> bVar) {
        ArrayList<T> arrayList = (ArrayList<T>) new ArrayList(bVar.getCount());
        try {
            for (E e2 : bVar) {
                arrayList.add(e2.freeze());
            }
            return arrayList;
        } finally {
            bVar.close();
        }
    }

    public static boolean b(b<?> bVar) {
        return bVar != null && bVar.getCount() > 0;
    }

    public static boolean c(b<?> bVar) {
        Bundle metadata = bVar.getMetadata();
        return (metadata == null || metadata.getString(a) == null) ? false : true;
    }

    public static boolean d(b<?> bVar) {
        Bundle metadata = bVar.getMetadata();
        return (metadata == null || metadata.getString(b) == null) ? false : true;
    }
}
