package i.b.w3;

import com.umeng.analytics.pro.am;
import i.b.l2;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;
import kotlin.Metadata;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlinx.coroutines.internal.MainDispatcherFactory;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00058\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Li/b/w3/x;", "", "Li/b/l2;", am.av, "()Li/b/l2;", "", "Z", "FAST_SERVICE_LOADER_ENABLED", "b", "Li/b/l2;", "dispatcher", "<init>", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class x {
    private static final boolean a;
    @h.k2.d
    @k.e.a.d
    public static final l2 b;

    /* renamed from: c */
    public static final x f15913c;

    static {
        x xVar = new x();
        f15913c = xVar;
        a = k0.e("kotlinx.coroutines.fast.service.loader", true);
        b = xVar.a();
    }

    private x() {
    }

    private final l2 a() {
        List<MainDispatcherFactory> V2;
        Object next;
        l2 f2;
        try {
            if (a) {
                V2 = l.b.d();
            } else {
                V2 = SequencesKt___SequencesKt.V2(SequencesKt__SequencesKt.h(ServiceLoader.load(MainDispatcherFactory.class, MainDispatcherFactory.class.getClassLoader()).iterator()));
            }
            Iterator<T> it = V2.iterator();
            if (it.hasNext()) {
                next = it.next();
                if (it.hasNext()) {
                    int loadPriority = ((MainDispatcherFactory) next).getLoadPriority();
                    do {
                        Object next2 = it.next();
                        int loadPriority2 = ((MainDispatcherFactory) next2).getLoadPriority();
                        if (loadPriority < loadPriority2) {
                            next = next2;
                            loadPriority = loadPriority2;
                        }
                    } while (it.hasNext());
                }
            } else {
                next = null;
            }
            MainDispatcherFactory mainDispatcherFactory = (MainDispatcherFactory) next;
            return (mainDispatcherFactory == null || (f2 = y.f(mainDispatcherFactory, V2)) == null) ? y.b(null, null, 3, null) : f2;
        } catch (Throwable th) {
            return y.b(th, null, 2, null);
        }
    }
}
