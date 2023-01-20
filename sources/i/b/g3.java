package i.b;

import androidx.exifinterface.media.ExifInterface;
import com.umeng.analytics.pro.am;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a-\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\b\u0002\u0010\u0002\u001a\u00028\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001b\u0010\u0007\u001a\u00020\u0006*\u0006\u0012\u0002\b\u00030\u0001H\u0086Hø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a\u001b\u0010\n\u001a\u00020\t*\u0006\u0012\u0002\b\u00030\u0001H\u0086Hø\u0001\u0000¢\u0006\u0004\b\n\u0010\b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000b"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Ljava/lang/ThreadLocal;", "value", "Li/b/f3;", am.av, "(Ljava/lang/ThreadLocal;Ljava/lang/Object;)Li/b/f3;", "", com.huawei.hms.push.e.a, "(Ljava/lang/ThreadLocal;Lh/e2/c;)Ljava/lang/Object;", "Lh/t1;", "c", "kotlinx-coroutines-core"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class g3 {
    @k.e.a.d
    public static final <T> f3<T> a(@k.e.a.d ThreadLocal<T> threadLocal, T t) {
        return new i.b.w3.n0(t, threadLocal);
    }

    public static /* synthetic */ f3 b(ThreadLocal threadLocal, Object obj, int i2, Object obj2) {
        if ((i2 & 1) != 0) {
            obj = threadLocal.get();
        }
        return a(threadLocal, obj);
    }

    @k.e.a.e
    public static final Object c(@k.e.a.d ThreadLocal<?> threadLocal, @k.e.a.d h.e2.c<? super h.t1> cVar) {
        if (h.e2.k.a.a.a(cVar.getContext().get(new i.b.w3.o0(threadLocal)) != null).booleanValue()) {
            return h.t1.a;
        }
        throw new IllegalStateException(("ThreadLocal " + threadLocal + " is missing from context " + cVar.getContext()).toString());
    }

    @k.e.a.e
    private static final Object d(@k.e.a.d ThreadLocal threadLocal, @k.e.a.d h.e2.c cVar) {
        h.k2.v.c0.e(3);
        h.e2.c cVar2 = null;
        if (cVar2.getContext().get(new i.b.w3.o0(threadLocal)) != null) {
            return h.t1.a;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("ThreadLocal ");
        sb.append(threadLocal);
        sb.append(" is missing from context ");
        h.k2.v.c0.e(3);
        sb.append(cVar2.getContext());
        throw new IllegalStateException(sb.toString().toString());
    }

    @k.e.a.e
    public static final Object e(@k.e.a.d ThreadLocal<?> threadLocal, @k.e.a.d h.e2.c<? super Boolean> cVar) {
        return h.e2.k.a.a.a(cVar.getContext().get(new i.b.w3.o0(threadLocal)) != null);
    }

    @k.e.a.e
    private static final Object f(@k.e.a.d ThreadLocal threadLocal, @k.e.a.d h.e2.c cVar) {
        h.k2.v.c0.e(3);
        h.e2.c cVar2 = null;
        return Boolean.valueOf(cVar2.getContext().get(new i.b.w3.o0(threadLocal)) != null);
    }
}
