package h.q2;

import androidx.exifinterface.media.ExifInterface;
import com.tencent.android.tpush.common.MessageKey;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B'\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007¢\u0006\u0002\u0010\bJ\b\u0010\f\u001a\u00020\rH\u0014R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u0012\u0012\u0004\u0012\u00028\u00010\nj\b\u0012\u0004\u0012\u00028\u0001`\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lkotlin/sequences/DistinctIterator;", ExifInterface.GPS_DIRECTION_TRUE, "K", "Lkotlin/collections/AbstractIterator;", MessageKey.MSG_SOURCE, "", "keySelector", "Lkotlin/Function1;", "(Ljava/util/Iterator;Lkotlin/jvm/functions/Function1;)V", "observed", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "computeNext", "", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes4.dex */
public final class b<T, K> extends h.a2.b<T> {

    /* renamed from: c  reason: collision with root package name */
    private final HashSet<K> f15644c = new HashSet<>();

    /* renamed from: d  reason: collision with root package name */
    private final Iterator<T> f15645d;

    /* renamed from: e  reason: collision with root package name */
    private final h.k2.u.l<T, K> f15646e;

    /* JADX WARN: Multi-variable type inference failed */
    public b(@k.e.a.d Iterator<? extends T> it, @k.e.a.d h.k2.u.l<? super T, ? extends K> lVar) {
        this.f15645d = it;
        this.f15646e = lVar;
    }

    @Override // h.a2.b
    public void a() {
        while (this.f15645d.hasNext()) {
            T next = this.f15645d.next();
            if (this.f15644c.add(this.f15646e.invoke(next))) {
                f(next);
                return;
            }
        }
        d();
    }
}
