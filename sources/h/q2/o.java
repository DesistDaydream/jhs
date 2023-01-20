package h.q2;

import androidx.exifinterface.media.ExifInterface;
import com.tencent.android.tpush.common.MessageKey;
import h.s0;
import h.t1;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;

@h.e2.g
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u001c\n\u0002\b\u0002\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u0002B\u0007\b\u0000¢\u0006\u0002\u0010\u0003J\u0019\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00028\u0000H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0007J\u001f\u0010\b\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\nH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u000bJ\u001f\u0010\b\u001a\u00020\u00052\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\rH¦@ø\u0001\u0000¢\u0006\u0002\u0010\u000eJ\u001f\u0010\b\u001a\u00020\u00052\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0011\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"Lkotlin/sequences/SequenceScope;", ExifInterface.GPS_DIRECTION_TRUE, "", "()V", "yield", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "yieldAll", MessageKey.CUSTOM_LAYOUT_ELEMENTS, "", "(Ljava/lang/Iterable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "iterator", "", "(Ljava/util/Iterator;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sequence", "Lkotlin/sequences/Sequence;", "(Lkotlin/sequences/Sequence;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
@s0(version = "1.3")
/* loaded from: classes4.dex */
public abstract class o<T> {
    @k.e.a.e
    public abstract Object d(T t, @k.e.a.d h.e2.c<? super t1> cVar);

    @k.e.a.e
    public final Object f(@k.e.a.d Iterable<? extends T> iterable, @k.e.a.d h.e2.c<? super t1> cVar) {
        Object g2;
        return (!((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) && (g2 = g(iterable.iterator(), cVar)) == h.e2.j.b.h()) ? g2 : t1.a;
    }

    @k.e.a.e
    public abstract Object g(@k.e.a.d Iterator<? extends T> it, @k.e.a.d h.e2.c<? super t1> cVar);

    @k.e.a.e
    public final Object h(@k.e.a.d m<? extends T> mVar, @k.e.a.d h.e2.c<? super t1> cVar) {
        Object g2 = g(mVar.iterator(), cVar);
        return g2 == h.e2.j.b.h() ? g2 : t1.a;
    }
}
