package i.b.t3;

import androidx.exifinterface.media.ExifInterface;
import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.umeng.analytics.pro.am;
import h.q0;
import i.b.q2;
import i.b.r1;
import i.b.x1;
import java.util.concurrent.CancellationException;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlinx.coroutines.channels.ChannelIterator;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\bf\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002J\u0013\u0010\u0003\u001a\u00028\u0000H¦@ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\u0004\u0018\u00018\u0000H§@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0004J\u001f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H§@ø\u0001\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0007\u0010\u0004J\u0011\u0010\b\u001a\u0004\u0018\u00018\u0000H&¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\nH¦\u0002¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u0011\u001a\u00020\u00102\u0010\b\u0002\u0010\u000f\u001a\n\u0018\u00010\rj\u0004\u0018\u0001`\u000eH&¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0010H\u0017¢\u0006\u0004\b\u0013\u0010\u0014J\u001b\u0010\u0017\u001a\u00020\u00162\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0015H'¢\u0006\u0004\b\u0017\u0010\u0018R+\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00060\u00198&@'X§\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u001c\u0010\u0014\u001a\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00198&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001bR$\u0010\"\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u00198&@'X§\u0004¢\u0006\f\u0012\u0004\b!\u0010\u0014\u001a\u0004\b \u0010\u001bR\u001c\u0010#\u001a\u00020\u00168&@'X§\u0004¢\u0006\f\u0012\u0004\b%\u0010\u0014\u001a\u0004\b#\u0010$R\u001c\u0010(\u001a\u00020\u00168&@'X§\u0004¢\u0006\f\u0012\u0004\b'\u0010\u0014\u001a\u0004\b&\u0010$\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006)"}, d2 = {"Li/b/t3/y;", ExifInterface.LONGITUDE_EAST, "", ExpandableTextView.P, "(Lh/e2/c;)Ljava/lang/Object;", "C", "Li/b/t3/g0;", "y", "poll", "()Ljava/lang/Object;", "Lkotlinx/coroutines/channels/ChannelIterator;", "iterator", "()Lkotlinx/coroutines/channels/ChannelIterator;", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "cause", "Lh/t1;", "b", "(Ljava/util/concurrent/CancellationException;)V", "cancel", "()V", "", "", am.av, "(Ljava/lang/Throwable;)Z", "Li/b/z3/d;", "L", "()Li/b/z3/d;", "getOnReceiveOrClosed$annotations", "onReceiveOrClosed", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "onReceive", "B", "getOnReceiveOrNull$annotations", "onReceiveOrNull", "isEmpty", "()Z", "isEmpty$annotations", "f", "isClosedForReceive$annotations", "isClosedForReceive", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public interface y<E> {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class a {
        public static /* synthetic */ void b(y yVar, CancellationException cancellationException, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 1) != 0) {
                    cancellationException = null;
                }
                yVar.b(cancellationException);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
        }

        public static /* synthetic */ boolean c(y yVar, Throwable th, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 1) != 0) {
                    th = null;
                }
                return yVar.a(th);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
        }

        @x1
        public static /* synthetic */ void d() {
        }

        @q2
        @h.g2.g
        @h.i(level = DeprecationLevel.WARNING, message = "Deprecated in favor of onReceiveOrClosed and onReceiveOrNull extension", replaceWith = @q0(expression = "onReceiveOrNull", imports = {"kotlinx.coroutines.channels.onReceiveOrNull"}))
        public static /* synthetic */ void e() {
        }

        @r1
        public static /* synthetic */ void f() {
        }

        @r1
        public static /* synthetic */ void g() {
        }
    }

    @k.e.a.d
    i.b.z3.d<E> A();

    @k.e.a.d
    i.b.z3.d<E> B();

    @h.i(level = DeprecationLevel.WARNING, message = "Deprecated in favor of receiveOrClosed and receiveOrNull extension", replaceWith = @q0(expression = "receiveOrNull", imports = {"kotlinx.coroutines.channels.receiveOrNull"}))
    @q2
    @h.g2.g
    @k.e.a.e
    Object C(@k.e.a.d h.e2.c<? super E> cVar);

    @k.e.a.e
    Object I(@k.e.a.d h.e2.c<? super E> cVar);

    @k.e.a.d
    i.b.z3.d<g0<E>> L();

    @h.i(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    /* synthetic */ boolean a(@k.e.a.e Throwable th);

    void b(@k.e.a.e CancellationException cancellationException);

    @h.i(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    /* synthetic */ void cancel();

    boolean f();

    boolean isEmpty();

    @k.e.a.d
    ChannelIterator<E> iterator();

    @k.e.a.e
    E poll();

    @x1
    @k.e.a.e
    Object y(@k.e.a.d h.e2.c<? super g0<? extends E>> cVar);
}
