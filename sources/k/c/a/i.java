package k.c.a;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public final class i {

    /* renamed from: d  reason: collision with root package name */
    private static final List<i> f16275d = new ArrayList();
    public Object a;
    public p b;

    /* renamed from: c  reason: collision with root package name */
    public i f16276c;

    private i(Object obj, p pVar) {
        this.a = obj;
        this.b = pVar;
    }

    public static i a(p pVar, Object obj) {
        List<i> list = f16275d;
        synchronized (list) {
            int size = list.size();
            if (size > 0) {
                i remove = list.remove(size - 1);
                remove.a = obj;
                remove.b = pVar;
                remove.f16276c = null;
                return remove;
            }
            return new i(obj, pVar);
        }
    }

    public static void b(i iVar) {
        iVar.a = null;
        iVar.b = null;
        iVar.f16276c = null;
        List<i> list = f16275d;
        synchronized (list) {
            if (list.size() < 10000) {
                list.add(iVar);
            }
        }
    }
}
