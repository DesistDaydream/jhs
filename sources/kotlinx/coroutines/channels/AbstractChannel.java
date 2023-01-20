package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.qiniu.android.collect.ReportItem;
import com.umeng.analytics.pro.am;
import h.r0;
import h.t1;
import i.b.e1;
import i.b.n;
import i.b.o;
import i.b.q;
import i.b.q0;
import i.b.t3.b0;
import i.b.t3.g0;
import i.b.t3.l;
import i.b.t3.p;
import i.b.t3.x;
import i.b.t3.z;
import i.b.w3.h0;
import i.b.w3.i0;
import i.b.w3.r;
import i.b.w3.s;
import i.b.w3.t;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b \u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003:\u000704_`aVbB)\u0012 \u0010\\\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0015\u0018\u00010Zj\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`[¢\u0006\u0004\b]\u0010^J\u001d\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\u000b\u001a\u0004\u0018\u00018\u00002\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJT\u0010\u0016\u001a\u00020\u0015\"\u0004\b\u0001\u0010\r2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00010\u000e2\u0006\u0010\u0011\u001a\u00020\u00102$\u0010\u0014\u001a \b\u0001\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0013\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0012H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017JZ\u0010\u0019\u001a\u00020\u0015\"\u0004\b\u0001\u0010\r* \b\u0001\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0013\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00122\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00010\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0018\u001a\u0004\u0018\u00010\tH\u0002ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001aJT\u0010\u001b\u001a\u00020\u0006\"\u0004\b\u0001\u0010\r2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00010\u000e2$\u0010\u0014\u001a \b\u0001\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0013\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0002ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ'\u0010\u001f\u001a\u00020\u00152\n\u0010\u001e\u001a\u0006\u0012\u0002\b\u00030\u001d2\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0002¢\u0006\u0004\b\u001f\u0010 J\u0011\u0010!\u001a\u0004\u0018\u00010\tH\u0014¢\u0006\u0004\b!\u0010\"J\u001d\u0010#\u001a\u0004\u0018\u00010\t2\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u000eH\u0014¢\u0006\u0004\b#\u0010$J\u0013\u0010%\u001a\u00028\u0000H\u0086@ø\u0001\u0000¢\u0006\u0004\b%\u0010&J!\u0010'\u001a\u00028\u0001\"\u0004\b\u0001\u0010\r2\u0006\u0010\u0011\u001a\u00020\u0010H\u0082@ø\u0001\u0000¢\u0006\u0004\b'\u0010(J\u001d\u0010)\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0014¢\u0006\u0004\b)\u0010\bJ\u0015\u0010*\u001a\u0004\u0018\u00018\u0000H\u0086@ø\u0001\u0000¢\u0006\u0004\b*\u0010&J\u001f\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00000+H\u0086@ø\u0001\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b,\u0010&J\u000f\u0010-\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b-\u0010\"J\u0019\u00100\u001a\u00020\u00062\b\u0010/\u001a\u0004\u0018\u00010.H\u0007¢\u0006\u0004\b0\u00101J\u001d\u00104\u001a\u00020\u00152\u000e\u0010/\u001a\n\u0018\u000102j\u0004\u0018\u0001`3¢\u0006\u0004\b4\u00105J\u0019\u00106\u001a\u00020\u00062\b\u0010/\u001a\u0004\u0018\u00010.H\u0000¢\u0006\u0004\b6\u00101J\u0017\u00108\u001a\u00020\u00152\u0006\u00107\u001a\u00020\u0006H\u0014¢\u0006\u0004\b8\u00109J\u0016\u0010;\u001a\b\u0012\u0004\u0012\u00028\u00000:H\u0086\u0002¢\u0006\u0004\b;\u0010<J\u0015\u0010>\u001a\b\u0012\u0004\u0012\u00028\u00000=H\u0004¢\u0006\u0004\b>\u0010?J\u0017\u0010A\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010@H\u0014¢\u0006\u0004\bA\u0010BJ\u000f\u0010C\u001a\u00020\u0015H\u0014¢\u0006\u0004\bC\u0010DJ\u000f\u0010E\u001a\u00020\u0015H\u0014¢\u0006\u0004\bE\u0010DR\u0019\u0010I\u001a\b\u0012\u0004\u0012\u00028\u00000F8F@\u0006¢\u0006\u0006\u001a\u0004\bG\u0010HR\u0016\u0010L\u001a\u00020\u00068$@$X¤\u0004¢\u0006\u0006\u001a\u0004\bJ\u0010KR\u0016\u0010N\u001a\u00020\u00068$@$X¤\u0004¢\u0006\u0006\u001a\u0004\bM\u0010KR\u0016\u0010P\u001a\u00020\u00068D@\u0004X\u0084\u0004¢\u0006\u0006\u001a\u0004\bO\u0010KR\u0016\u0010R\u001a\u00020\u00068D@\u0004X\u0084\u0004¢\u0006\u0006\u001a\u0004\bQ\u0010KR\u0016\u0010S\u001a\u00020\u00068V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\bS\u0010KR\u001b\u0010U\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000F8F@\u0006¢\u0006\u0006\u001a\u0004\bT\u0010HR\u0016\u0010W\u001a\u00020\u00068V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\bV\u0010KR\"\u0010Y\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000+0F8F@\u0006ø\u0001\u0000¢\u0006\u0006\u001a\u0004\bX\u0010H\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006c"}, d2 = {"Lkotlinx/coroutines/channels/AbstractChannel;", ExifInterface.LONGITUDE_EAST, "Li/b/t3/b;", "Li/b/t3/l;", "Li/b/t3/x;", "receive", "", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "(Li/b/t3/x;)Z", "", "result", "h0", "(Ljava/lang/Object;)Ljava/lang/Object;", "R", "Li/b/z3/f;", "select", "", "receiveMode", "Lkotlin/Function2;", "Lh/e2/c;", ReportItem.LogTypeBlock, "Lh/t1;", "j0", "(Li/b/z3/f;ILh/k2/u/p;)V", "value", "l0", "(Lh/k2/u/p;Li/b/z3/f;ILjava/lang/Object;)V", "X", "(Li/b/z3/f;Lh/k2/u/p;I)Z", "Li/b/n;", "cont", "k0", "(Li/b/n;Li/b/t3/x;)V", "f0", "()Ljava/lang/Object;", "g0", "(Li/b/z3/f;)Ljava/lang/Object;", ExpandableTextView.P, "(Lh/e2/c;)Ljava/lang/Object;", "i0", "(ILh/e2/c;)Ljava/lang/Object;", ExifInterface.LONGITUDE_WEST, "C", "Li/b/t3/g0;", "y", "poll", "", "cause", am.av, "(Ljava/lang/Throwable;)Z", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "b", "(Ljava/util/concurrent/CancellationException;)V", ExifInterface.GPS_DIRECTION_TRUE, "wasClosed", "c0", "(Z)V", "Lkotlinx/coroutines/channels/ChannelIterator;", "iterator", "()Lkotlinx/coroutines/channels/ChannelIterator;", "Lkotlinx/coroutines/channels/AbstractChannel$g;", "U", "()Lkotlinx/coroutines/channels/AbstractChannel$g;", "Li/b/t3/z;", "M", "()Li/b/t3/z;", "e0", "()V", "d0", "Li/b/z3/d;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "()Li/b/z3/d;", "onReceive", "Z", "()Z", "isBufferAlwaysEmpty", "a0", "isBufferEmpty", "b0", "isEmptyImpl", "Y", "hasReceiveOrClosed", "isEmpty", "B", "onReceiveOrNull", "f", "isClosedForReceive", "L", "onReceiveOrClosed", "Lkotlin/Function1;", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "onUndeliveredElement", "<init>", "(Lh/k2/u/l;)V", "c", e.j.a.b.c.f.f10128d, com.huawei.hms.push.e.a, "g", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public abstract class AbstractChannel<E> extends i.b.t3.b<E> implements l<E> {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u00028\u00010\u0002B\u0015\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00010\u0012¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\b\u001a\u00020\u0005H\u0096Bø\u0001\u0000¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\n\u001a\u00020\u0005H\u0082@ø\u0001\u0000¢\u0006\u0004\b\n\u0010\tJ\u0010\u0010\u000b\u001a\u00028\u0001H\u0096\u0002¢\u0006\u0004\b\u000b\u0010\fR$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00010\u00128\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0013\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0017"}, d2 = {"kotlinx/coroutines/channels/AbstractChannel$a", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/ChannelIterator;", "", "result", "", e.j.a.b.c.f.f10128d, "(Ljava/lang/Object;)Z", "b", "(Lh/e2/c;)Ljava/lang/Object;", com.huawei.hms.push.e.a, "next", "()Ljava/lang/Object;", am.av, "Ljava/lang/Object;", "c", "setResult", "(Ljava/lang/Object;)V", "Lkotlinx/coroutines/channels/AbstractChannel;", "Lkotlinx/coroutines/channels/AbstractChannel;", "channel", "<init>", "(Lkotlinx/coroutines/channels/AbstractChannel;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class a<E> implements ChannelIterator<E> {
        @k.e.a.e
        private Object a = i.b.t3.a.f15801g;
        @h.k2.d
        @k.e.a.d
        public final AbstractChannel<E> b;

        public a(@k.e.a.d AbstractChannel<E> abstractChannel) {
            this.b = abstractChannel;
        }

        private final boolean d(Object obj) {
            if (obj instanceof p) {
                p pVar = (p) obj;
                if (pVar.f15835d == null) {
                    return false;
                }
                throw h0.p(pVar.q0());
            }
            return true;
        }

        @Override // kotlinx.coroutines.channels.ChannelIterator
        @h.k2.g(name = "next")
        @k.e.a.e
        @h.i(level = DeprecationLevel.HIDDEN, message = "Since 1.3.0, binary compatibility with versions <= 1.2.x")
        public /* synthetic */ Object a(@k.e.a.d h.e2.c<? super E> cVar) {
            return ChannelIterator.DefaultImpls.a(this, cVar);
        }

        @Override // kotlinx.coroutines.channels.ChannelIterator
        @k.e.a.e
        public Object b(@k.e.a.d h.e2.c<? super Boolean> cVar) {
            Object obj = this.a;
            i0 i0Var = i.b.t3.a.f15801g;
            if (obj != i0Var) {
                return h.e2.k.a.a.a(d(obj));
            }
            Object f0 = this.b.f0();
            this.a = f0;
            if (f0 != i0Var) {
                return h.e2.k.a.a.a(d(f0));
            }
            return e(cVar);
        }

        @k.e.a.e
        public final Object c() {
            return this.a;
        }

        @k.e.a.e
        public final /* synthetic */ Object e(@k.e.a.d h.e2.c<? super Boolean> cVar) {
            o b = q.b(IntrinsicsKt__IntrinsicsJvmKt.d(cVar));
            d dVar = new d(this, b);
            while (true) {
                if (this.b.V(dVar)) {
                    this.b.k0(b, dVar);
                    break;
                }
                Object f0 = this.b.f0();
                setResult(f0);
                if (f0 instanceof p) {
                    p pVar = (p) f0;
                    if (pVar.f15835d == null) {
                        Boolean a = h.e2.k.a.a.a(false);
                        Result.a aVar = Result.Companion;
                        b.resumeWith(Result.m106constructorimpl(a));
                    } else {
                        Throwable q0 = pVar.q0();
                        Result.a aVar2 = Result.Companion;
                        b.resumeWith(Result.m106constructorimpl(r0.a(q0)));
                    }
                } else if (f0 != i.b.t3.a.f15801g) {
                    Boolean a2 = h.e2.k.a.a.a(true);
                    h.k2.u.l<E, t1> lVar = this.b.b;
                    b.w(a2, lVar != null ? OnUndeliveredElementKt.a(lVar, f0, b.getContext()) : null);
                }
            }
            Object B = b.B();
            if (B == h.e2.j.b.h()) {
                h.e2.k.a.f.c(cVar);
            }
            return B;
        }

        @Override // kotlinx.coroutines.channels.ChannelIterator
        public E next() {
            E e2 = (E) this.a;
            if (!(e2 instanceof p)) {
                i0 i0Var = i.b.t3.a.f15801g;
                if (e2 != i0Var) {
                    this.a = i0Var;
                    return e2;
                }
                throw new IllegalStateException("'hasNext' should be called prior to 'next' invocation");
            }
            throw h0.p(((p) e2).q0());
        }

        public final void setResult(@k.e.a.e Object obj) {
            this.a = obj;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\b\u0012\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00002\b\u0012\u0004\u0012\u00028\u00010\u0002B\u001f\u0012\u000e\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0016\u0012\u0006\u0010\u001d\u001a\u00020\u001a¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00028\u0001¢\u0006\u0004\b\u0005\u0010\u0006J#\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0003\u001a\u00028\u00012\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u001b\u0010\u0011\u001a\u00020\f2\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00168\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006 "}, d2 = {"kotlinx/coroutines/channels/AbstractChannel$b", ExifInterface.LONGITUDE_EAST, "Li/b/t3/x;", "value", "", "m0", "(Ljava/lang/Object;)Ljava/lang/Object;", "Li/b/w3/s$d;", "otherOp", "Li/b/w3/i0;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Ljava/lang/Object;Li/b/w3/s$d;)Li/b/w3/i0;", "Lh/t1;", "i", "(Ljava/lang/Object;)V", "Li/b/t3/p;", "closed", "l0", "(Li/b/t3/p;)V", "", "toString", "()Ljava/lang/String;", "Li/b/n;", e.j.a.b.c.f.f10128d, "Li/b/n;", "cont", "", com.huawei.hms.push.e.a, ExpandableTextView.P, "receiveMode", "<init>", "(Li/b/n;I)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static class b<E> extends x<E> {
        @h.k2.d
        @k.e.a.d

        /* renamed from: d  reason: collision with root package name */
        public final n<Object> f16913d;
        @h.k2.d

        /* renamed from: e  reason: collision with root package name */
        public final int f16914e;

        public b(@k.e.a.d n<Object> nVar, int i2) {
            this.f16913d = nVar;
            this.f16914e = i2;
        }

        @Override // i.b.t3.z
        @k.e.a.e
        public i0 A(E e2, @k.e.a.e s.d dVar) {
            Object D = this.f16913d.D(m0(e2), dVar != null ? dVar.f15896c : null, k0(e2));
            if (D != null) {
                if (q0.b()) {
                    if (!(D == i.b.p.f15778d)) {
                        throw new AssertionError();
                    }
                }
                if (dVar != null) {
                    dVar.d();
                }
                return i.b.p.f15778d;
            }
            return null;
        }

        @Override // i.b.t3.z
        public void i(E e2) {
            this.f16913d.P(i.b.p.f15778d);
        }

        @Override // i.b.t3.x
        public void l0(@k.e.a.d p<?> pVar) {
            int i2 = this.f16914e;
            if (i2 == 1 && pVar.f15835d == null) {
                n<Object> nVar = this.f16913d;
                Result.a aVar = Result.Companion;
                nVar.resumeWith(Result.m106constructorimpl(null));
            } else if (i2 == 2) {
                n<Object> nVar2 = this.f16913d;
                g0.b bVar = g0.b;
                g0 a = g0.a(g0.b(new g0.a(pVar.f15835d)));
                Result.a aVar2 = Result.Companion;
                nVar2.resumeWith(Result.m106constructorimpl(a));
            } else {
                n<Object> nVar3 = this.f16913d;
                Throwable q0 = pVar.q0();
                Result.a aVar3 = Result.Companion;
                nVar3.resumeWith(Result.m106constructorimpl(r0.a(q0)));
            }
        }

        @k.e.a.e
        public final Object m0(E e2) {
            if (this.f16914e != 2) {
                return e2;
            }
            g0.b bVar = g0.b;
            return g0.a(g0.b(e2));
        }

        @Override // i.b.w3.s
        @k.e.a.d
        public String toString() {
            return "ReceiveElement@" + i.b.r0.b(this) + "[receiveMode=" + this.f16914e + ']';
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0002\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00002\b\u0012\u0004\u0012\u00028\u00010\u0002B=\u0012\u000e\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\r\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u001c\u0010\f\u001a\u0018\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u00060\u0004j\b\u0012\u0004\u0012\u00028\u0001`\t¢\u0006\u0004\b\u0012\u0010\u0013J%\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u0007\u0010\bR,\u0010\f\u001a\u0018\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u00060\u0004j\b\u0012\u0004\u0012\u00028\u0001`\t8\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"kotlinx/coroutines/channels/AbstractChannel$c", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/AbstractChannel$b;", "value", "Lkotlin/Function1;", "", "Lh/t1;", "k0", "(Ljava/lang/Object;)Lh/k2/u/l;", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "f", "Lh/k2/u/l;", "onUndeliveredElement", "Li/b/n;", "", "cont", "", "receiveMode", "<init>", "(Li/b/n;ILh/k2/u/l;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class c<E> extends b<E> {
        @h.k2.d
        @k.e.a.d

        /* renamed from: f  reason: collision with root package name */
        public final h.k2.u.l<E, t1> f16915f;

        /* JADX WARN: Multi-variable type inference failed */
        public c(@k.e.a.d n<Object> nVar, int i2, @k.e.a.d h.k2.u.l<? super E, t1> lVar) {
            super(nVar, i2);
            this.f16915f = lVar;
        }

        @Override // i.b.t3.x
        @k.e.a.e
        public h.k2.u.l<Throwable, t1> k0(E e2) {
            return OnUndeliveredElementKt.a(this.f16915f, e2, this.f16913d.getContext());
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0012\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u00028\u00010\u0002B#\u0012\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00010\u0017\u0012\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b¢\u0006\u0004\b \u0010!J#\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00028\u00012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\u000e\u001a\u00020\t2\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ%\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\t\u0018\u00010\u00102\u0006\u0010\u0003\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\u001c\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00010\u00178\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b8\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006\""}, d2 = {"kotlinx/coroutines/channels/AbstractChannel$d", ExifInterface.LONGITUDE_EAST, "Li/b/t3/x;", "value", "Li/b/w3/s$d;", "otherOp", "Li/b/w3/i0;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Ljava/lang/Object;Li/b/w3/s$d;)Li/b/w3/i0;", "Lh/t1;", "i", "(Ljava/lang/Object;)V", "Li/b/t3/p;", "closed", "l0", "(Li/b/t3/p;)V", "Lkotlin/Function1;", "", "k0", "(Ljava/lang/Object;)Lh/k2/u/l;", "", "toString", "()Ljava/lang/String;", "Lkotlinx/coroutines/channels/AbstractChannel$a;", e.j.a.b.c.f.f10128d, "Lkotlinx/coroutines/channels/AbstractChannel$a;", "iterator", "Li/b/n;", "", com.huawei.hms.push.e.a, "Li/b/n;", "cont", "<init>", "(Lkotlinx/coroutines/channels/AbstractChannel$a;Li/b/n;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static class d<E> extends x<E> {
        @h.k2.d
        @k.e.a.d

        /* renamed from: d  reason: collision with root package name */
        public final a<E> f16916d;
        @h.k2.d
        @k.e.a.d

        /* renamed from: e  reason: collision with root package name */
        public final n<Boolean> f16917e;

        /* JADX WARN: Multi-variable type inference failed */
        public d(@k.e.a.d a<E> aVar, @k.e.a.d n<? super Boolean> nVar) {
            this.f16916d = aVar;
            this.f16917e = nVar;
        }

        @Override // i.b.t3.z
        @k.e.a.e
        public i0 A(E e2, @k.e.a.e s.d dVar) {
            Object D = this.f16917e.D(Boolean.TRUE, dVar != null ? dVar.f15896c : null, k0(e2));
            if (D != null) {
                if (q0.b()) {
                    if (!(D == i.b.p.f15778d)) {
                        throw new AssertionError();
                    }
                }
                if (dVar != null) {
                    dVar.d();
                }
                return i.b.p.f15778d;
            }
            return null;
        }

        @Override // i.b.t3.z
        public void i(E e2) {
            this.f16916d.setResult(e2);
            this.f16917e.P(i.b.p.f15778d);
        }

        @Override // i.b.t3.x
        @k.e.a.e
        public h.k2.u.l<Throwable, t1> k0(E e2) {
            h.k2.u.l<E, t1> lVar = this.f16916d.b.b;
            if (lVar != null) {
                return OnUndeliveredElementKt.a(lVar, e2, this.f16917e.getContext());
            }
            return null;
        }

        @Override // i.b.t3.x
        public void l0(@k.e.a.d p<?> pVar) {
            Object t;
            if (pVar.f15835d == null) {
                t = n.a.b(this.f16917e, Boolean.FALSE, null, 2, null);
            } else {
                t = this.f16917e.t(pVar.q0());
            }
            if (t != null) {
                this.f16916d.setResult(pVar);
                this.f16917e.P(t);
            }
        }

        @Override // i.b.w3.s
        @k.e.a.d
        public String toString() {
            return "ReceiveHasNext@" + i.b.r0.b(this);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u0001*\u0004\b\u0002\u0010\u00022\b\u0012\u0004\u0012\u00028\u00020\u00032\u00020\u0004BT\u0012\f\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00020%\u0012\f\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00010)\u0012$\u0010$\u001a \b\u0001\u0012\u0006\u0012\u0004\u0018\u00010 \u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010!\u0012\u0006\u0012\u0004\u0018\u00010 0\u001f\u0012\u0006\u0010\u001e\u001a\u00020\u001bø\u0001\u0000¢\u0006\u0004\b-\u0010.J#\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00028\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00028\u0002H\u0016¢\u0006\u0004\b\f\u0010\rJ\u001b\u0010\u0010\u001a\u00020\u000b2\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J%\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00142\u0006\u0010\u0005\u001a\u00028\u0002H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001e\u001a\u00020\u001b8\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR7\u0010$\u001a \b\u0001\u0012\u0006\u0012\u0004\u0018\u00010 \u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010!\u0012\u0006\u0012\u0004\u0018\u00010 0\u001f8\u0006@\u0007X\u0087\u0004ø\u0001\u0000¢\u0006\u0006\n\u0004\b\"\u0010#R\u001c\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00020%8\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u001c\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00010)8\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b*\u0010+\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006/"}, d2 = {"kotlinx/coroutines/channels/AbstractChannel$e", "R", ExifInterface.LONGITUDE_EAST, "Li/b/t3/x;", "Li/b/e1;", "value", "Li/b/w3/s$d;", "otherOp", "Li/b/w3/i0;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Ljava/lang/Object;Li/b/w3/s$d;)Li/b/w3/i0;", "Lh/t1;", "i", "(Ljava/lang/Object;)V", "Li/b/t3/p;", "closed", "l0", "(Li/b/t3/p;)V", "dispose", "()V", "Lkotlin/Function1;", "", "k0", "(Ljava/lang/Object;)Lh/k2/u/l;", "", "toString", "()Ljava/lang/String;", "", "g", ExpandableTextView.P, "receiveMode", "Lkotlin/Function2;", "", "Lh/e2/c;", "f", "Lh/k2/u/p;", ReportItem.LogTypeBlock, "Lkotlinx/coroutines/channels/AbstractChannel;", e.j.a.b.c.f.f10128d, "Lkotlinx/coroutines/channels/AbstractChannel;", "channel", "Li/b/z3/f;", com.huawei.hms.push.e.a, "Li/b/z3/f;", "select", "<init>", "(Lkotlinx/coroutines/channels/AbstractChannel;Li/b/z3/f;Lh/k2/u/p;I)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class e<R, E> extends x<E> implements e1 {
        @h.k2.d
        @k.e.a.d

        /* renamed from: d  reason: collision with root package name */
        public final AbstractChannel<E> f16918d;
        @h.k2.d
        @k.e.a.d

        /* renamed from: e  reason: collision with root package name */
        public final i.b.z3.f<R> f16919e;
        @h.k2.d
        @k.e.a.d

        /* renamed from: f  reason: collision with root package name */
        public final h.k2.u.p<Object, h.e2.c<? super R>, Object> f16920f;
        @h.k2.d

        /* renamed from: g  reason: collision with root package name */
        public final int f16921g;

        /* JADX WARN: Multi-variable type inference failed */
        public e(@k.e.a.d AbstractChannel<E> abstractChannel, @k.e.a.d i.b.z3.f<? super R> fVar, @k.e.a.d h.k2.u.p<Object, ? super h.e2.c<? super R>, ? extends Object> pVar, int i2) {
            this.f16918d = abstractChannel;
            this.f16919e = fVar;
            this.f16920f = pVar;
            this.f16921g = i2;
        }

        @Override // i.b.t3.z
        @k.e.a.e
        public i0 A(E e2, @k.e.a.e s.d dVar) {
            return (i0) this.f16919e.n(dVar);
        }

        @Override // i.b.e1
        public void dispose() {
            if (c0()) {
                this.f16918d.d0();
            }
        }

        @Override // i.b.t3.z
        public void i(E e2) {
            Object obj;
            h.k2.u.p<Object, h.e2.c<? super R>, Object> pVar = this.f16920f;
            if (this.f16921g == 2) {
                g0.b bVar = g0.b;
                obj = g0.a(g0.b(e2));
            } else {
                obj = e2;
            }
            i.b.x3.a.d(pVar, obj, this.f16919e.v(), k0(e2));
        }

        @Override // i.b.t3.x
        @k.e.a.e
        public h.k2.u.l<Throwable, t1> k0(E e2) {
            h.k2.u.l<E, t1> lVar = this.f16918d.b;
            if (lVar != null) {
                return OnUndeliveredElementKt.a(lVar, e2, this.f16919e.v().getContext());
            }
            return null;
        }

        @Override // i.b.t3.x
        public void l0(@k.e.a.d p<?> pVar) {
            if (this.f16919e.s()) {
                int i2 = this.f16921g;
                if (i2 == 0) {
                    this.f16919e.y(pVar.q0());
                } else if (i2 == 1) {
                    if (pVar.f15835d == null) {
                        i.b.x3.a.e(this.f16920f, null, this.f16919e.v(), null, 4, null);
                    } else {
                        this.f16919e.y(pVar.q0());
                    }
                } else if (i2 != 2) {
                } else {
                    h.k2.u.p<Object, h.e2.c<? super R>, Object> pVar2 = this.f16920f;
                    g0.b bVar = g0.b;
                    i.b.x3.a.e(pVar2, g0.a(g0.b(new g0.a(pVar.f15835d))), this.f16919e.v(), null, 4, null);
                }
            }
        }

        @Override // i.b.w3.s
        @k.e.a.d
        public String toString() {
            return "ReceiveSelect@" + i.b.r0.b(this) + '[' + this.f16919e + ",receiveMode=" + this.f16921g + ']';
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\n¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0096\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tR\u001a\u0010\f\u001a\u0006\u0012\u0002\b\u00030\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u000b¨\u0006\u000f"}, d2 = {"kotlinx/coroutines/channels/AbstractChannel$f", "Li/b/d;", "", "cause", "Lh/t1;", am.av, "(Ljava/lang/Throwable;)V", "", "toString", "()Ljava/lang/String;", "Li/b/t3/x;", "Li/b/t3/x;", "receive", "<init>", "(Lkotlinx/coroutines/channels/AbstractChannel;Li/b/t3/x;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public final class f extends i.b.d {
        private final x<?> a;

        public f(@k.e.a.d x<?> xVar) {
            this.a = xVar;
        }

        @Override // i.b.m
        public void a(@k.e.a.e Throwable th) {
            if (this.a.c0()) {
                AbstractChannel.this.d0();
            }
        }

        @Override // h.k2.u.l
        public /* bridge */ /* synthetic */ t1 invoke(Throwable th) {
            a(th);
            return t1.a;
        }

        @k.e.a.d
        public String toString() {
            return "RemoveReceiveOnCancel[" + this.a + ']';
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0004\u0018\u0000*\u0004\b\u0001\u0010\u00012\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\r\u001a\u0004\u0018\u00010\u00072\n\u0010\f\u001a\u00060\nj\u0002`\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0016"}, d2 = {"kotlinx/coroutines/channels/AbstractChannel$g", ExifInterface.LONGITUDE_EAST, "Li/b/w3/s$e;", "Li/b/t3/b0;", "Lkotlinx/coroutines/internal/RemoveFirstDesc;", "Li/b/w3/s;", "affected", "", com.huawei.hms.push.e.a, "(Li/b/w3/s;)Ljava/lang/Object;", "Li/b/w3/s$d;", "Lkotlinx/coroutines/internal/PrepareOp;", "prepareOp", "j", "(Li/b/w3/s$d;)Ljava/lang/Object;", "Lh/t1;", "k", "(Li/b/w3/s;)V", "Li/b/w3/q;", "queue", "<init>", "(Li/b/w3/q;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class g<E> extends s.e<b0> {
        public g(@k.e.a.d i.b.w3.q qVar) {
            super(qVar);
        }

        @Override // i.b.w3.s.e, i.b.w3.s.a
        @k.e.a.e
        public Object e(@k.e.a.d s sVar) {
            if (sVar instanceof p) {
                return sVar;
            }
            if (sVar instanceof b0) {
                return null;
            }
            return i.b.t3.a.f15801g;
        }

        @Override // i.b.w3.s.a
        @k.e.a.e
        public Object j(@k.e.a.d s.d dVar) {
            s sVar = dVar.a;
            Objects.requireNonNull(sVar, "null cannot be cast to non-null type kotlinx.coroutines.channels.Send");
            i0 m0 = ((b0) sVar).m0(dVar);
            if (m0 != null) {
                Object obj = i.b.w3.c.b;
                if (m0 == obj) {
                    return obj;
                }
                if (q0.b()) {
                    if (m0 == i.b.p.f15778d) {
                        return null;
                    }
                    throw new AssertionError();
                }
                return null;
            }
            return t.a;
        }

        @Override // i.b.w3.s.a
        public void k(@k.e.a.d s sVar) {
            Objects.requireNonNull(sVar, "null cannot be cast to non-null type kotlinx.coroutines.channels.Send");
            ((b0) sVar).n0();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\n\u0018\u00002\u00020\u0001J\u001d\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b¸\u0006\t"}, d2 = {"kotlinx/coroutines/channels/AbstractChannel$h", "Li/b/w3/s$c;", "Li/b/w3/s;", "Lkotlinx/coroutines/internal/Node;", "affected", "", "k", "(Li/b/w3/s;)Ljava/lang/Object;", "kotlinx-coroutines-core", "i/b/w3/s$f"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class h extends s.c {

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ s f16922d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AbstractChannel f16923e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(s sVar, s sVar2, AbstractChannel abstractChannel) {
            super(sVar2);
            this.f16922d = sVar;
            this.f16923e = abstractChannel;
        }

        @Override // i.b.w3.d
        @k.e.a.e
        /* renamed from: k */
        public Object i(@k.e.a.d s sVar) {
            if (this.f16923e.a0()) {
                return null;
            }
            return r.a();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001JJ\u0010\n\u001a\u00020\t\"\u0004\b\u0001\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u00032\"\u0010\b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005H\u0016ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"kotlinx/coroutines/channels/AbstractChannel$i", "Li/b/z3/d;", "R", "Li/b/z3/f;", "select", "Lkotlin/Function2;", "Lh/e2/c;", "", ReportItem.LogTypeBlock, "Lh/t1;", com.huawei.hms.push.e.a, "(Li/b/z3/f;Lh/k2/u/p;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class i implements i.b.z3.d<E> {
        public i() {
        }

        @Override // i.b.z3.d
        public <R> void e(@k.e.a.d i.b.z3.f<? super R> fVar, @k.e.a.d h.k2.u.p<? super E, ? super h.e2.c<? super R>, ? extends Object> pVar) {
            AbstractChannel abstractChannel = AbstractChannel.this;
            Objects.requireNonNull(pVar, "null cannot be cast to non-null type suspend (kotlin.Any?) -> R");
            abstractChannel.j0(fVar, 0, pVar);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001JS\u0010\u000b\u001a\u00020\n\"\u0004\b\u0001\u0010\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u00042(\u0010\t\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0006H\u0016ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fø\u0001\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\r"}, d2 = {"kotlinx/coroutines/channels/AbstractChannel$j", "Li/b/z3/d;", "Li/b/t3/g0;", "R", "Li/b/z3/f;", "select", "Lkotlin/Function2;", "Lh/e2/c;", "", ReportItem.LogTypeBlock, "Lh/t1;", com.huawei.hms.push.e.a, "(Li/b/z3/f;Lh/k2/u/p;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class j implements i.b.z3.d<g0<? extends E>> {
        public j() {
        }

        @Override // i.b.z3.d
        public <R> void e(@k.e.a.d i.b.z3.f<? super R> fVar, @k.e.a.d h.k2.u.p<? super g0<? extends E>, ? super h.e2.c<? super R>, ? extends Object> pVar) {
            AbstractChannel abstractChannel = AbstractChannel.this;
            Objects.requireNonNull(pVar, "null cannot be cast to non-null type suspend (kotlin.Any?) -> R");
            abstractChannel.j0(fVar, 2, pVar);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0001JL\u0010\n\u001a\u00020\t\"\u0004\b\u0001\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u00032$\u0010\b\u001a \b\u0001\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005H\u0016ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"kotlinx/coroutines/channels/AbstractChannel$k", "Li/b/z3/d;", "R", "Li/b/z3/f;", "select", "Lkotlin/Function2;", "Lh/e2/c;", "", ReportItem.LogTypeBlock, "Lh/t1;", com.huawei.hms.push.e.a, "(Li/b/z3/f;Lh/k2/u/p;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class k implements i.b.z3.d<E> {
        public k() {
        }

        @Override // i.b.z3.d
        public <R> void e(@k.e.a.d i.b.z3.f<? super R> fVar, @k.e.a.d h.k2.u.p<? super E, ? super h.e2.c<? super R>, ? extends Object> pVar) {
            AbstractChannel abstractChannel = AbstractChannel.this;
            Objects.requireNonNull(pVar, "null cannot be cast to non-null type suspend (kotlin.Any?) -> R");
            abstractChannel.j0(fVar, 1, pVar);
        }
    }

    public AbstractChannel(@k.e.a.e h.k2.u.l<? super E, t1> lVar) {
        super(lVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean V(x<? super E> xVar) {
        boolean W = W(xVar);
        if (W) {
            e0();
        }
        return W;
    }

    private final <R> boolean X(i.b.z3.f<? super R> fVar, h.k2.u.p<Object, ? super h.e2.c<? super R>, ? extends Object> pVar, int i2) {
        e eVar = new e(this, fVar, pVar, i2);
        boolean V = V(eVar);
        if (V) {
            fVar.k(eVar);
        }
        return V;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final E h0(Object obj) {
        if (obj instanceof p) {
            Throwable th = ((p) obj).f15835d;
            if (th == null) {
                return null;
            }
            throw h0.p(th);
        }
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final <R> void j0(i.b.z3.f<? super R> fVar, int i2, h.k2.u.p<Object, ? super h.e2.c<? super R>, ? extends Object> pVar) {
        while (!fVar.b()) {
            if (b0()) {
                if (X(fVar, pVar, i2)) {
                    return;
                }
            } else {
                Object g0 = g0(fVar);
                if (g0 == i.b.z3.g.d()) {
                    return;
                }
                if (g0 != i.b.t3.a.f15801g && g0 != i.b.w3.c.b) {
                    l0(pVar, fVar, i2, g0);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k0(n<?> nVar, x<?> xVar) {
        nVar.p(new f(xVar));
    }

    private final <R> void l0(h.k2.u.p<Object, ? super h.e2.c<? super R>, ? extends Object> pVar, i.b.z3.f<? super R> fVar, int i2, Object obj) {
        Object b2;
        boolean z = obj instanceof p;
        if (!z) {
            if (i2 == 2) {
                g0.b bVar = g0.b;
                if (z) {
                    b2 = g0.b(new g0.a(((p) obj).f15835d));
                } else {
                    b2 = g0.b(obj);
                }
                i.b.x3.b.d(pVar, g0.a(b2), fVar.v());
                return;
            }
            i.b.x3.b.d(pVar, obj, fVar.v());
        } else if (i2 == 0) {
            throw h0.p(((p) obj).q0());
        } else {
            if (i2 != 1) {
                if (i2 == 2 && fVar.s()) {
                    g0.b bVar2 = g0.b;
                    i.b.x3.b.d(pVar, g0.a(g0.b(new g0.a(((p) obj).f15835d))), fVar.v());
                    return;
                }
                return;
            }
            p pVar2 = (p) obj;
            if (pVar2.f15835d == null) {
                if (fVar.s()) {
                    i.b.x3.b.d(pVar, null, fVar.v());
                    return;
                }
                return;
            }
            throw h0.p(pVar2.q0());
        }
    }

    @Override // i.b.t3.y
    @k.e.a.d
    public final i.b.z3.d<E> A() {
        return new i();
    }

    @Override // i.b.t3.y
    @k.e.a.d
    public final i.b.z3.d<E> B() {
        return new k();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // i.b.t3.y
    @k.e.a.e
    public final Object C(@k.e.a.d h.e2.c<? super E> cVar) {
        Object f0 = f0();
        return (f0 == i.b.t3.a.f15801g || (f0 instanceof p)) ? i0(1, cVar) : f0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // i.b.t3.y
    @k.e.a.e
    public final Object I(@k.e.a.d h.e2.c<? super E> cVar) {
        Object f0 = f0();
        return (f0 == i.b.t3.a.f15801g || (f0 instanceof p)) ? i0(0, cVar) : f0;
    }

    @Override // i.b.t3.y
    @k.e.a.d
    public final i.b.z3.d<g0<E>> L() {
        return new j();
    }

    @Override // i.b.t3.b
    @k.e.a.e
    public z<E> M() {
        z<E> M = super.M();
        if (M != null && !(M instanceof p)) {
            d0();
        }
        return M;
    }

    @Override // i.b.t3.y
    /* renamed from: T */
    public final boolean a(@k.e.a.e Throwable th) {
        boolean K = K(th);
        c0(K);
        return K;
    }

    @k.e.a.d
    public final g<E> U() {
        return new g<>(o());
    }

    public boolean W(@k.e.a.d x<? super E> xVar) {
        int h0;
        s W;
        if (Z()) {
            s o = o();
            do {
                W = o.W();
                if (!(!(W instanceof b0))) {
                    return false;
                }
            } while (!W.M(xVar, o));
        } else {
            s o2 = o();
            h hVar = new h(xVar, xVar, this);
            do {
                s W2 = o2.W();
                if (!(!(W2 instanceof b0))) {
                    return false;
                }
                h0 = W2.h0(xVar, o2, hVar);
                if (h0 != 1) {
                }
            } while (h0 != 2);
            return false;
        }
        return true;
    }

    public final boolean Y() {
        return o().V() instanceof z;
    }

    public abstract boolean Z();

    public abstract boolean a0();

    @Override // i.b.t3.y
    public final void b(@k.e.a.e CancellationException cancellationException) {
        if (cancellationException == null) {
            cancellationException = new CancellationException(i.b.r0.a(this) + " was cancelled");
        }
        a(cancellationException);
    }

    public final boolean b0() {
        return !(o().V() instanceof b0) && a0();
    }

    public void c0(boolean z) {
        p<?> n = n();
        if (n != null) {
            Object c2 = i.b.w3.n.c(null, 1, null);
            while (true) {
                s W = n.W();
                if (W instanceof i.b.w3.q) {
                    if (c2 == null) {
                        return;
                    }
                    if (!(c2 instanceof ArrayList)) {
                        ((b0) c2).l0(n);
                        return;
                    }
                    Objects.requireNonNull(c2, "null cannot be cast to non-null type kotlin.collections.ArrayList<E> /* = java.util.ArrayList<E> */");
                    ArrayList arrayList = (ArrayList) c2;
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        ((b0) arrayList.get(size)).l0(n);
                    }
                    return;
                } else if (q0.b() && !(W instanceof b0)) {
                    throw new AssertionError();
                } else {
                    if (!W.c0()) {
                        W.X();
                    } else {
                        Objects.requireNonNull(W, "null cannot be cast to non-null type kotlinx.coroutines.channels.Send");
                        c2 = i.b.w3.n.h(c2, (b0) W);
                    }
                }
            }
        } else {
            throw new IllegalStateException("Cannot happen".toString());
        }
    }

    @Override // i.b.t3.y
    @h.i(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public /* synthetic */ void cancel() {
        b(null);
    }

    public void d0() {
    }

    public void e0() {
    }

    public boolean f() {
        return m() != null && a0();
    }

    @k.e.a.e
    public Object f0() {
        while (true) {
            b0 P = P();
            if (P != null) {
                i0 m0 = P.m0(null);
                if (m0 != null) {
                    if (q0.b()) {
                        if (!(m0 == i.b.p.f15778d)) {
                            throw new AssertionError();
                        }
                    }
                    P.j0();
                    return P.k0();
                }
                P.n0();
            } else {
                return i.b.t3.a.f15801g;
            }
        }
    }

    @k.e.a.e
    public Object g0(@k.e.a.d i.b.z3.f<?> fVar) {
        g<E> U = U();
        Object z = fVar.z(U);
        if (z != null) {
            return z;
        }
        U.o().j0();
        return U.o().k0();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v3, types: [kotlinx.coroutines.channels.AbstractChannel$b] */
    @k.e.a.e
    public final /* synthetic */ <R> Object i0(int i2, @k.e.a.d h.e2.c<? super R> cVar) {
        c cVar2;
        o b2 = q.b(IntrinsicsKt__IntrinsicsJvmKt.d(cVar));
        if (this.b == null) {
            Objects.requireNonNull(b2, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Any?>");
            cVar2 = new b(b2, i2);
        } else {
            Objects.requireNonNull(b2, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Any?>");
            cVar2 = new c(b2, i2, this.b);
        }
        while (true) {
            if (V(cVar2)) {
                k0(b2, cVar2);
                break;
            }
            Object f0 = f0();
            if (f0 instanceof p) {
                cVar2.l0((p) f0);
                break;
            } else if (f0 != i.b.t3.a.f15801g) {
                b2.w(cVar2.m0(f0), cVar2.k0(f0));
                break;
            }
        }
        Object B = b2.B();
        if (B == h.e2.j.b.h()) {
            h.e2.k.a.f.c(cVar);
        }
        return B;
    }

    public boolean isEmpty() {
        return b0();
    }

    @Override // i.b.t3.y
    @k.e.a.d
    public final ChannelIterator<E> iterator() {
        return new a(this);
    }

    @Override // i.b.t3.y
    @k.e.a.e
    public final E poll() {
        Object f0 = f0();
        if (f0 == i.b.t3.a.f15801g) {
            return null;
        }
        return h0(f0);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0037  */
    @Override // i.b.t3.y
    @k.e.a.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object y(@k.e.a.d h.e2.c<? super i.b.t3.g0<? extends E>> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof kotlinx.coroutines.channels.AbstractChannel$receiveOrClosed$1
            if (r0 == 0) goto L13
            r0 = r5
            kotlinx.coroutines.channels.AbstractChannel$receiveOrClosed$1 r0 = (kotlinx.coroutines.channels.AbstractChannel$receiveOrClosed$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.channels.AbstractChannel$receiveOrClosed$1 r0 = new kotlinx.coroutines.channels.AbstractChannel$receiveOrClosed$1
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = h.e2.j.b.h()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            java.lang.Object r1 = r0.L$1
            java.lang.Object r0 = r0.L$0
            kotlinx.coroutines.channels.AbstractChannel r0 = (kotlinx.coroutines.channels.AbstractChannel) r0
            h.r0.n(r5)
            goto L6b
        L2f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L37:
            h.r0.n(r5)
            java.lang.Object r5 = r4.f0()
            i.b.w3.i0 r2 = i.b.t3.a.f15801g
            if (r5 == r2) goto L5d
            boolean r0 = r5 instanceof i.b.t3.p
            if (r0 == 0) goto L56
            i.b.t3.g0$b r0 = i.b.t3.g0.b
            i.b.t3.p r5 = (i.b.t3.p) r5
            java.lang.Throwable r5 = r5.f15835d
            i.b.t3.g0$a r0 = new i.b.t3.g0$a
            r0.<init>(r5)
            java.lang.Object r5 = i.b.t3.g0.b(r0)
            goto L5c
        L56:
            i.b.t3.g0$b r0 = i.b.t3.g0.b
            java.lang.Object r5 = i.b.t3.g0.b(r5)
        L5c:
            return r5
        L5d:
            r2 = 2
            r0.L$0 = r4
            r0.L$1 = r5
            r0.label = r3
            java.lang.Object r5 = r4.i0(r2, r0)
            if (r5 != r1) goto L6b
            return r1
        L6b:
            i.b.t3.g0 r5 = (i.b.t3.g0) r5
            java.lang.Object r5 = r5.n()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.AbstractChannel.y(h.e2.c):java.lang.Object");
    }
}
