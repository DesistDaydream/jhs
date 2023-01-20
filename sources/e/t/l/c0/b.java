package e.t.l.c0;

import androidx.exifinterface.media.ExifInterface;
import h.k2.u.p;
import h.k2.v.f0;
import h.m2.e;
import h.p2.n;
import k.e.a.d;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003:\u0001\u000eB#\u0012\u001c\u0010\u0004\u001a\u0018\u0012\u0004\u0012\u00028\u0000\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006\u0012\u0004\u0012\u00028\u00010\u0005¢\u0006\u0002\u0010\u0007J\"\u0010\n\u001a\u00028\u00012\u0006\u0010\u000b\u001a\u00028\u00002\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u0006H\u0096\u0002¢\u0006\u0002\u0010\rR$\u0010\u0004\u001a\u0018\u0012\u0004\u0012\u00028\u0000\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006\u0012\u0004\u0012\u00028\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/vector/ext/bind/LazyFrag;", ExifInterface.GPS_DIRECTION_TRUE, ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlin/properties/ReadOnlyProperty;", "initializer", "Lkotlin/Function2;", "Lkotlin/reflect/KProperty;", "(Lkotlin/jvm/functions/Function2;)V", "value", "", "getValue", "thisRef", "property", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "EMPTY", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class b<T, V> implements e<T, V> {
    @d
    private final p<T, n<?>, V> a;
    @k.e.a.e
    private Object b = a.a;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/vector/ext/bind/LazyFrag$EMPTY;", "", "()V", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class a {
        @d
        public static final a a = new a();

        private a() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(@d p<? super T, ? super n<?>, ? extends V> pVar) {
        this.a = pVar;
    }

    @Override // h.m2.e
    public V a(T t, @d n<?> nVar) {
        if (f0.g(this.b, a.a)) {
            this.b = this.a.invoke(t, nVar);
        }
        return (V) this.b;
    }
}
