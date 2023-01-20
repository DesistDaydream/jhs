package i.b.t3;

import androidx.exifinterface.media.ExifInterface;
import h.t1;
import i.b.r1;
import kotlin.DeprecationLevel;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\bf\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u0002J\u001b\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000H¦@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00028\u0000H&¢\u0006\u0004\b\b\u0010\tJ\u001b\u0010\f\u001a\u00020\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\nH&¢\u0006\u0004\b\f\u0010\rJ4\u0010\u0012\u001a\u00020\u00042#\u0010\u0011\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\n¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u00040\u000eH'¢\u0006\u0004\b\u0012\u0010\u0013R(\u0010\u0017\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00000\u00148&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u001c\u001a\u00020\u00078&@'X§\u0004¢\u0006\f\u0012\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001f\u001a\u00020\u00078&@'X§\u0004¢\u0006\f\u0012\u0004\b\u001e\u0010\u001b\u001a\u0004\b\u001d\u0010\u0019\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006 "}, d2 = {"Li/b/t3/c0;", ExifInterface.LONGITUDE_EAST, "", "element", "Lh/t1;", "N", "(Ljava/lang/Object;Lh/e2/c;)Ljava/lang/Object;", "", "offer", "(Ljava/lang/Object;)Z", "", "cause", "K", "(Ljava/lang/Throwable;)Z", "Lkotlin/Function1;", "Lh/k0;", "name", "handler", "x", "(Lh/k2/u/l;)V", "Li/b/z3/e;", "h", "()Li/b/z3/e;", "onSend", "c", "()Z", "isFull$annotations", "()V", "isFull", "O", "isClosedForSend$annotations", "isClosedForSend", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public interface c0<E> {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class a {
        public static /* synthetic */ boolean a(c0 c0Var, Throwable th, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 1) != 0) {
                    th = null;
                }
                return c0Var.K(th);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: close");
        }

        @r1
        public static /* synthetic */ void b() {
        }

        @r1
        @h.i(level = DeprecationLevel.ERROR, message = "Will be removed in next releases without replacement")
        public static /* synthetic */ void c() {
        }
    }

    boolean K(@k.e.a.e Throwable th);

    @k.e.a.e
    Object N(E e2, @k.e.a.d h.e2.c<? super t1> cVar);

    boolean O();

    boolean c();

    @k.e.a.d
    i.b.z3.e<E, c0<E>> h();

    boolean offer(E e2);

    @r1
    void x(@k.e.a.d h.k2.u.l<? super Throwable, t1> lVar);
}
