package i.b.t3;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.meizu.cloud.pushsdk.notification.model.NotifyType;
import com.qiniu.android.collect.ReportItem;
import com.umeng.analytics.pro.am;
import h.k2.v.t0;
import h.t1;
import i.b.e1;
import i.b.q0;
import i.b.r0;
import i.b.w3.h0;
import i.b.w3.i0;
import i.b.w3.s;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.UndeliveredElementException;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b \u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002:\u0004`TehB)\u0012 \u0010V\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\n\u0018\u000105j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`S¢\u0006\u0004\bg\u00109J#\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00028\u00002\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ+\u0010\u000b\u001a\u00020\n*\u0006\u0012\u0002\b\u00030\t2\u0006\u0010\u0003\u001a\u00028\u00002\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u000e\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\u0010\u001a\u00020\n2\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0002¢\u0006\u0004\b\u0010\u0010\u0011JX\u0010\u0018\u001a\u00020\n\"\u0004\b\u0001\u0010\u00122\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00010\u00132\u0006\u0010\u0003\u001a\u00028\u00002(\u0010\u0017\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\t\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u0015H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u0003\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\u001d\u0010\u001eJ#\u0010\u0001\u001a\u00020\u00162\u0006\u0010\u0003\u001a\u00028\u00002\n\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\u0013H\u0014¢\u0006\u0004\b\u0001\u0010\u001fJ\u0011\u0010!\u001a\u0004\u0018\u00010 H\u0004¢\u0006\u0004\b!\u0010\"J\u001d\u0010$\u001a\b\u0012\u0002\b\u0003\u0018\u00010#2\u0006\u0010\u0003\u001a\u00028\u0000H\u0004¢\u0006\u0004\b$\u0010%J#\u0010(\u001a\u000e\u0012\u0002\b\u00030&j\u0006\u0012\u0002\b\u0003`'2\u0006\u0010\u0003\u001a\u00028\u0000H\u0004¢\u0006\u0004\b(\u0010)J\u001b\u0010*\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00028\u0000H\u0086@ø\u0001\u0000¢\u0006\u0004\b*\u0010+J\u0015\u0010-\u001a\u00020,2\u0006\u0010\u0003\u001a\u00028\u0000¢\u0006\u0004\b-\u0010.J\u001b\u0010/\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00028\u0000H\u0082@ø\u0001\u0000¢\u0006\u0004\b/\u0010+J\u0019\u00101\u001a\u0004\u0018\u00010\u00162\u0006\u00100\u001a\u00020 H\u0014¢\u0006\u0004\b1\u00102J\u0019\u00103\u001a\u00020,2\b\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b3\u00104J)\u00108\u001a\u00020\n2\u0018\u00107\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\n05j\u0002`6H\u0016¢\u0006\u0004\b8\u00109J\u0017\u0010;\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020:H\u0014¢\u0006\u0004\b;\u0010<J\u0017\u0010=\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010#H\u0014¢\u0006\u0004\b=\u0010>J\u001d\u0010@\u001a\b\u0012\u0004\u0012\u00028\u00000?2\u0006\u0010\u0003\u001a\u00028\u0000H\u0004¢\u0006\u0004\b@\u0010AJ\u000f\u0010C\u001a\u00020BH\u0016¢\u0006\u0004\bC\u0010DR\u0016\u0010G\u001a\u00020,8D@\u0004X\u0084\u0004¢\u0006\u0006\u001a\u0004\bE\u0010FR\u0016\u0010I\u001a\u00020B8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\bH\u0010DR\u001c\u0010L\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00048D@\u0004X\u0084\u0004¢\u0006\u0006\u001a\u0004\bJ\u0010KR\u0013\u0010N\u001a\u00020,8F@\u0006¢\u0006\u0006\u001a\u0004\bM\u0010FR\u0016\u0010P\u001a\u00020B8T@\u0014X\u0094\u0004¢\u0006\u0006\u001a\u0004\bO\u0010DR\u0016\u0010R\u001a\u00020,8$@$X¤\u0004¢\u0006\u0006\u001a\u0004\bQ\u0010FR0\u0010V\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\n\u0018\u000105j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`S8\u0004@\u0005X\u0085\u0004¢\u0006\u0006\n\u0004\bT\u0010UR\u001c\u0010X\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00048D@\u0004X\u0084\u0004¢\u0006\u0006\u001a\u0004\bW\u0010KR\u0016\u0010Z\u001a\u00020,8$@$X¤\u0004¢\u0006\u0006\u001a\u0004\bY\u0010FR%\u0010^\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020[8F@\u0006¢\u0006\u0006\u001a\u0004\b\\\u0010]R\u001c\u0010d\u001a\u00020_8\u0004@\u0004X\u0084\u0004¢\u0006\f\n\u0004\b`\u0010a\u001a\u0004\bb\u0010cR\u0016\u0010f\u001a\u00020,8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\be\u0010F\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006i"}, d2 = {"Li/b/t3/b;", ExifInterface.LONGITUDE_EAST, "Li/b/t3/c0;", "element", "Li/b/t3/p;", "closed", "", "r", "(Ljava/lang/Object;Li/b/t3/p;)Ljava/lang/Throwable;", "Lh/e2/c;", "Lh/t1;", "s", "(Lh/e2/c;Ljava/lang/Object;Li/b/t3/p;)V", "cause", am.aI, "(Ljava/lang/Throwable;)V", "q", "(Li/b/t3/p;)V", "R", "Li/b/z3/f;", "select", "Lkotlin/Function2;", "", ReportItem.LogTypeBlock, "G", "(Li/b/z3/f;Ljava/lang/Object;Lh/k2/u/p;)V", "", "g", "()I", "D", "(Ljava/lang/Object;)Ljava/lang/Object;", "(Ljava/lang/Object;Li/b/z3/f;)Ljava/lang/Object;", "Li/b/t3/b0;", "P", "()Li/b/t3/b0;", "Li/b/t3/z;", "H", "(Ljava/lang/Object;)Li/b/t3/z;", "Li/b/w3/s$b;", "Lkotlinx/coroutines/internal/AddLastDesc;", "i", "(Ljava/lang/Object;)Li/b/w3/s$b;", "N", "(Ljava/lang/Object;Lh/e2/c;)Ljava/lang/Object;", "", "offer", "(Ljava/lang/Object;)Z", "J", "send", "k", "(Li/b/t3/b0;)Ljava/lang/Object;", "K", "(Ljava/lang/Throwable;)Z", "Lkotlin/Function1;", "Lkotlinx/coroutines/channels/Handler;", "handler", "x", "(Lh/k2/u/l;)V", "Li/b/w3/s;", "F", "(Li/b/w3/s;)V", "M", "()Li/b/t3/z;", "Li/b/t3/b$d;", "j", "(Ljava/lang/Object;)Li/b/t3/b$d;", "", "toString", "()Ljava/lang/String;", am.aD, "()Z", "isFullImpl", am.ax, "queueDebugStateString", "m", "()Li/b/t3/p;", "closedForReceive", "O", "isClosedForSend", NotifyType.LIGHTS, "bufferDebugString", am.aH, "isBufferAlwaysFull", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "b", "Lh/k2/u/l;", "onUndeliveredElement", "n", "closedForSend", IAdInterListener.AdReqParam.WIDTH, "isBufferFull", "Li/b/z3/e;", "h", "()Li/b/z3/e;", "onSend", "Li/b/w3/q;", am.av, "Li/b/w3/q;", "o", "()Li/b/w3/q;", "queue", "c", "isFull", "<init>", e.j.a.b.c.f.f10128d, "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public abstract class b<E> implements c0<E> {

    /* renamed from: c  reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f15804c = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "onCloseHandler");
    @h.k2.d
    @k.e.a.e
    public final h.k2.u.l<E, t1> b;
    @k.e.a.d
    private final i.b.w3.q a = new i.b.w3.q();
    private volatile Object onCloseHandler = null;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\t\b\u0000\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0018\u001a\u00028\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u001b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\r\u001a\u00020\b2\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00128V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0018\u001a\u00028\u00018\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"i/b/t3/b$a", ExifInterface.LONGITUDE_EAST, "Li/b/t3/b0;", "Li/b/w3/s$d;", "otherOp", "Li/b/w3/i0;", "m0", "(Li/b/w3/s$d;)Li/b/w3/i0;", "Lh/t1;", "j0", "()V", "Li/b/t3/p;", "closed", "l0", "(Li/b/t3/p;)V", "", "toString", "()Ljava/lang/String;", "", "k0", "()Ljava/lang/Object;", "pollResult", e.j.a.b.c.f.f10128d, "Ljava/lang/Object;", "element", "<init>", "(Ljava/lang/Object;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class a<E> extends b0 {
        @h.k2.d

        /* renamed from: d  reason: collision with root package name */
        public final E f15805d;

        public a(E e2) {
            this.f15805d = e2;
        }

        @Override // i.b.t3.b0
        public void j0() {
        }

        @Override // i.b.t3.b0
        @k.e.a.e
        public Object k0() {
            return this.f15805d;
        }

        @Override // i.b.t3.b0
        public void l0(@k.e.a.d p<?> pVar) {
        }

        @Override // i.b.t3.b0
        @k.e.a.e
        public i0 m0(@k.e.a.e s.d dVar) {
            i0 i0Var = i.b.p.f15778d;
            if (dVar != null) {
                dVar.d();
            }
            return i0Var;
        }

        @Override // i.b.w3.s
        @k.e.a.d
        public String toString() {
            return "SendBuffered@" + r0.b(this) + '(' + this.f15805d + ')';
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0012\u0018\u0000*\u0004\b\u0001\u0010\u00012\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00030\u0002j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0003`\u0004B\u0017\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00028\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\b\u0010\t¨\u0006\u000f"}, d2 = {"i/b/t3/b$b", ExifInterface.LONGITUDE_EAST, "Li/b/w3/s$b;", "Li/b/t3/b$a;", "Lkotlinx/coroutines/internal/AddLastDesc;", "Li/b/w3/s;", "affected", "", com.huawei.hms.push.e.a, "(Li/b/w3/s;)Ljava/lang/Object;", "Li/b/w3/q;", "queue", "element", "<init>", "(Li/b/w3/q;Ljava/lang/Object;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* renamed from: i.b.t3.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0481b<E> extends s.b<a<? extends E>> {
        public C0481b(@k.e.a.d i.b.w3.q qVar, E e2) {
            super(qVar, new a(e2));
        }

        @Override // i.b.w3.s.a
        @k.e.a.e
        public Object e(@k.e.a.d i.b.w3.s sVar) {
            if (sVar instanceof p) {
                return sVar;
            }
            if (sVar instanceof z) {
                return i.b.t3.a.f15800f;
            }
            return null;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u0001*\u0004\b\u0002\u0010\u00022\u00020\u00032\u00020\u0004BX\u0012\u0006\u0010\u001a\u001a\u00028\u0001\u0012\f\u0010)\u001a\b\u0012\u0004\u0012\u00028\u00010&\u0012\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00020\u001b\u0012(\u0010%\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010 \u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020!\u0012\u0006\u0012\u0004\u0018\u00010\"0\u001fø\u0001\u0000¢\u0006\u0004\b*\u0010+J\u001b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\fJ\u001b\u0010\u0010\u001a\u00020\n2\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0012\u0010\fJ\u000f\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u001c\u0010\u001a\u001a\u00028\u00018\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00020\u001b8\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR;\u0010%\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010 \u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020!\u0012\u0006\u0012\u0004\u0018\u00010\"0\u001f8\u0006@\u0007X\u0087\u0004ø\u0001\u0000¢\u0006\u0006\n\u0004\b#\u0010$R\u001c\u0010)\u001a\b\u0012\u0004\u0012\u00028\u00010&8\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b'\u0010(\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006,"}, d2 = {"i/b/t3/b$c", ExifInterface.LONGITUDE_EAST, "R", "Li/b/t3/b0;", "Li/b/e1;", "Li/b/w3/s$d;", "otherOp", "Li/b/w3/i0;", "m0", "(Li/b/w3/s$d;)Li/b/w3/i0;", "Lh/t1;", "j0", "()V", "dispose", "Li/b/t3/p;", "closed", "l0", "(Li/b/t3/p;)V", "n0", "", "toString", "()Ljava/lang/String;", e.j.a.b.c.f.f10128d, "Ljava/lang/Object;", "k0", "()Ljava/lang/Object;", "pollResult", "Li/b/z3/f;", "f", "Li/b/z3/f;", "select", "Lkotlin/Function2;", "Li/b/t3/c0;", "Lh/e2/c;", "", "g", "Lh/k2/u/p;", ReportItem.LogTypeBlock, "Li/b/t3/b;", com.huawei.hms.push.e.a, "Li/b/t3/b;", "channel", "<init>", "(Ljava/lang/Object;Li/b/t3/b;Li/b/z3/f;Lh/k2/u/p;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class c<E, R> extends b0 implements e1 {

        /* renamed from: d  reason: collision with root package name */
        private final E f15806d;
        @h.k2.d
        @k.e.a.d

        /* renamed from: e  reason: collision with root package name */
        public final b<E> f15807e;
        @h.k2.d
        @k.e.a.d

        /* renamed from: f  reason: collision with root package name */
        public final i.b.z3.f<R> f15808f;
        @h.k2.d
        @k.e.a.d

        /* renamed from: g  reason: collision with root package name */
        public final h.k2.u.p<c0<? super E>, h.e2.c<? super R>, Object> f15809g;

        /* JADX WARN: Multi-variable type inference failed */
        public c(E e2, @k.e.a.d b<E> bVar, @k.e.a.d i.b.z3.f<? super R> fVar, @k.e.a.d h.k2.u.p<? super c0<? super E>, ? super h.e2.c<? super R>, ? extends Object> pVar) {
            this.f15806d = e2;
            this.f15807e = bVar;
            this.f15808f = fVar;
            this.f15809g = pVar;
        }

        @Override // i.b.e1
        public void dispose() {
            if (c0()) {
                n0();
            }
        }

        @Override // i.b.t3.b0
        public void j0() {
            i.b.x3.a.e(this.f15809g, this.f15807e, this.f15808f.v(), null, 4, null);
        }

        @Override // i.b.t3.b0
        public E k0() {
            return this.f15806d;
        }

        @Override // i.b.t3.b0
        public void l0(@k.e.a.d p<?> pVar) {
            if (this.f15808f.s()) {
                this.f15808f.y(pVar.r0());
            }
        }

        @Override // i.b.t3.b0
        @k.e.a.e
        public i0 m0(@k.e.a.e s.d dVar) {
            return (i0) this.f15808f.n(dVar);
        }

        @Override // i.b.t3.b0
        public void n0() {
            h.k2.u.l<E, t1> lVar = this.f15807e.b;
            if (lVar != null) {
                OnUndeliveredElementKt.b(lVar, k0(), this.f15808f.v().getContext());
            }
        }

        @Override // i.b.w3.s
        @k.e.a.d
        public String toString() {
            return "SendSelect@" + r0.b(this) + '(' + k0() + ")[" + this.f15807e + ", " + this.f15808f + ']';
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0004\u0018\u0000*\u0004\b\u0001\u0010\u00012\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00030\u0002j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0003`\u0004B\u0017\u0012\u0006\u0010\u0010\u001a\u00028\u0001\u0012\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\r\u001a\u0004\u0018\u00010\u00072\n\u0010\f\u001a\u00060\nj\u0002`\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\u0010\u001a\u00028\u00018\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u000f¨\u0006\u0015"}, d2 = {"i/b/t3/b$d", ExifInterface.LONGITUDE_EAST, "Li/b/w3/s$e;", "Li/b/t3/z;", "Lkotlinx/coroutines/internal/RemoveFirstDesc;", "Li/b/w3/s;", "affected", "", com.huawei.hms.push.e.a, "(Li/b/w3/s;)Ljava/lang/Object;", "Li/b/w3/s$d;", "Lkotlinx/coroutines/internal/PrepareOp;", "prepareOp", "j", "(Li/b/w3/s$d;)Ljava/lang/Object;", "Ljava/lang/Object;", "element", "Li/b/w3/q;", "queue", "<init>", "(Ljava/lang/Object;Li/b/w3/q;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class d<E> extends s.e<z<? super E>> {
        @h.k2.d

        /* renamed from: e  reason: collision with root package name */
        public final E f15810e;

        public d(E e2, @k.e.a.d i.b.w3.q qVar) {
            super(qVar);
            this.f15810e = e2;
        }

        @Override // i.b.w3.s.e, i.b.w3.s.a
        @k.e.a.e
        public Object e(@k.e.a.d i.b.w3.s sVar) {
            if (sVar instanceof p) {
                return sVar;
            }
            if (sVar instanceof z) {
                return null;
            }
            return i.b.t3.a.f15800f;
        }

        @Override // i.b.w3.s.a
        @k.e.a.e
        public Object j(@k.e.a.d s.d dVar) {
            i.b.w3.s sVar = dVar.a;
            Objects.requireNonNull(sVar, "null cannot be cast to non-null type kotlinx.coroutines.channels.ReceiveOrClosed<E>");
            i0 A = ((z) sVar).A(this.f15810e, dVar);
            if (A != null) {
                Object obj = i.b.w3.c.b;
                if (A == obj) {
                    return obj;
                }
                if (q0.b()) {
                    if (A == i.b.p.f15778d) {
                        return null;
                    }
                    throw new AssertionError();
                }
                return null;
            }
            return i.b.w3.t.a;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\n\u0018\u00002\u00020\u0001J\u001d\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b¸\u0006\t"}, d2 = {"i/b/t3/b$e", "Li/b/w3/s$c;", "Li/b/w3/s;", "Lkotlinx/coroutines/internal/Node;", "affected", "", "k", "(Li/b/w3/s;)Ljava/lang/Object;", "kotlinx-coroutines-core", "i/b/w3/s$f"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class e extends s.c {

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ i.b.w3.s f15811d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f15812e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(i.b.w3.s sVar, i.b.w3.s sVar2, b bVar) {
            super(sVar2);
            this.f15811d = sVar;
            this.f15812e = bVar;
        }

        @Override // i.b.w3.d
        @k.e.a.e
        /* renamed from: k */
        public Object i(@k.e.a.d i.b.w3.s sVar) {
            if (this.f15812e.w()) {
                return null;
            }
            return i.b.w3.r.a();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\n\u0018\u00002\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001JX\u0010\f\u001a\u00020\u000b\"\u0004\b\u0001\u0010\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u00042\u0006\u0010\u0006\u001a\u00028\u00002(\u0010\n\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0007H\u0016ø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, d2 = {"i/b/t3/b$f", "Li/b/z3/e;", "Li/b/t3/c0;", "R", "Li/b/z3/f;", "select", RemoteMessageConst.MessageBody.PARAM, "Lkotlin/Function2;", "Lh/e2/c;", "", ReportItem.LogTypeBlock, "Lh/t1;", am.aD, "(Li/b/z3/f;Ljava/lang/Object;Lh/k2/u/p;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class f implements i.b.z3.e<E, c0<? super E>> {
        public f() {
        }

        @Override // i.b.z3.e
        public <R> void z(@k.e.a.d i.b.z3.f<? super R> fVar, E e2, @k.e.a.d h.k2.u.p<? super c0<? super E>, ? super h.e2.c<? super R>, ? extends Object> pVar) {
            b.this.G(fVar, e2, pVar);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(@k.e.a.e h.k2.u.l<? super E, t1> lVar) {
        this.b = lVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final <R> void G(i.b.z3.f<? super R> fVar, E e2, h.k2.u.p<? super c0<? super E>, ? super h.e2.c<? super R>, ? extends Object> pVar) {
        while (!fVar.b()) {
            if (z()) {
                c cVar = new c(e2, this, fVar, pVar);
                Object k2 = k(cVar);
                if (k2 == null) {
                    fVar.k(cVar);
                    return;
                } else if (!(k2 instanceof p)) {
                    if (k2 != i.b.t3.a.f15802h && !(k2 instanceof x)) {
                        throw new IllegalStateException(("enqueueSend returned " + k2 + ' ').toString());
                    }
                } else {
                    throw h0.p(r(e2, (p) k2));
                }
            }
            Object E = E(e2, fVar);
            if (E == i.b.z3.g.d()) {
                return;
            }
            if (E != i.b.t3.a.f15800f && E != i.b.w3.c.b) {
                if (E == i.b.t3.a.f15799e) {
                    i.b.x3.b.d(pVar, this, fVar.v());
                    return;
                } else if (E instanceof p) {
                    throw h0.p(r(e2, (p) E));
                } else {
                    throw new IllegalStateException(("offerSelectInternal returned " + E).toString());
                }
            }
        }
    }

    private final int g() {
        i.b.w3.q qVar = this.a;
        Object U = qVar.U();
        Objects.requireNonNull(U, "null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
        int i2 = 0;
        for (i.b.w3.s sVar = (i.b.w3.s) U; !h.k2.v.f0.g(sVar, qVar); sVar = sVar.V()) {
            if (sVar instanceof i.b.w3.s) {
                i2++;
            }
        }
        return i2;
    }

    private final String p() {
        String str;
        i.b.w3.s V = this.a.V();
        if (V == this.a) {
            return "EmptyQueue";
        }
        if (V instanceof p) {
            str = V.toString();
        } else if (V instanceof x) {
            str = "ReceiveQueued";
        } else if (V instanceof b0) {
            str = "SendQueued";
        } else {
            str = "UNEXPECTED:" + V;
        }
        i.b.w3.s W = this.a.W();
        if (W != V) {
            String str2 = str + ",queueSize=" + g();
            if (W instanceof p) {
                return str2 + ",closedForSend=" + W;
            }
            return str2;
        }
        return str;
    }

    private final void q(p<?> pVar) {
        Object c2 = i.b.w3.n.c(null, 1, null);
        while (true) {
            i.b.w3.s W = pVar.W();
            if (!(W instanceof x)) {
                W = null;
            }
            x xVar = (x) W;
            if (xVar == null) {
                break;
            } else if (!xVar.c0()) {
                xVar.X();
            } else {
                c2 = i.b.w3.n.h(c2, xVar);
            }
        }
        if (c2 != null) {
            if (!(c2 instanceof ArrayList)) {
                ((x) c2).l0(pVar);
            } else {
                Objects.requireNonNull(c2, "null cannot be cast to non-null type kotlin.collections.ArrayList<E> /* = java.util.ArrayList<E> */");
                ArrayList arrayList = (ArrayList) c2;
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    ((x) arrayList.get(size)).l0(pVar);
                }
            }
        }
        F(pVar);
    }

    private final Throwable r(E e2, p<?> pVar) {
        UndeliveredElementException d2;
        q(pVar);
        h.k2.u.l<E, t1> lVar = this.b;
        if (lVar != null && (d2 = OnUndeliveredElementKt.d(lVar, e2, null, 2, null)) != null) {
            h.m.a(d2, pVar.r0());
            throw d2;
        }
        return pVar.r0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s(h.e2.c<?> cVar, E e2, p<?> pVar) {
        UndeliveredElementException d2;
        q(pVar);
        Throwable r0 = pVar.r0();
        h.k2.u.l<E, t1> lVar = this.b;
        if (lVar != null && (d2 = OnUndeliveredElementKt.d(lVar, e2, null, 2, null)) != null) {
            h.m.a(d2, r0);
            Result.a aVar = Result.Companion;
            cVar.resumeWith(Result.m106constructorimpl(h.r0.a(d2)));
            return;
        }
        Result.a aVar2 = Result.Companion;
        cVar.resumeWith(Result.m106constructorimpl(h.r0.a(r0)));
    }

    private final void t(Throwable th) {
        i0 i0Var;
        Object obj = this.onCloseHandler;
        if (obj == null || obj == (i0Var = i.b.t3.a.f15803i) || !f15804c.compareAndSet(this, obj, i0Var)) {
            return;
        }
        ((h.k2.u.l) t0.q(obj, 1)).invoke(th);
    }

    @k.e.a.d
    public Object D(E e2) {
        z<E> M;
        i0 A;
        do {
            M = M();
            if (M != null) {
                A = M.A(e2, null);
            } else {
                return i.b.t3.a.f15800f;
            }
        } while (A == null);
        if (q0.b()) {
            if (!(A == i.b.p.f15778d)) {
                throw new AssertionError();
            }
        }
        M.i(e2);
        return M.e();
    }

    @k.e.a.d
    public Object E(E e2, @k.e.a.d i.b.z3.f<?> fVar) {
        d<E> j2 = j(e2);
        Object z = fVar.z(j2);
        if (z != null) {
            return z;
        }
        z<? super E> o = j2.o();
        o.i(e2);
        return o.e();
    }

    public void F(@k.e.a.d i.b.w3.s sVar) {
    }

    @k.e.a.e
    public final z<?> H(E e2) {
        i.b.w3.s W;
        i.b.w3.s sVar = this.a;
        a aVar = new a(e2);
        do {
            W = sVar.W();
            if (W instanceof z) {
                return (z) W;
            }
        } while (!W.M(aVar, sVar));
        return null;
    }

    @k.e.a.e
    public final /* synthetic */ Object J(E e2, @k.e.a.d h.e2.c<? super t1> cVar) {
        b0 e0Var;
        i.b.o b = i.b.q.b(IntrinsicsKt__IntrinsicsJvmKt.d(cVar));
        while (true) {
            if (z()) {
                if (this.b == null) {
                    e0Var = new d0(e2, b);
                } else {
                    e0Var = new e0(e2, b, this.b);
                }
                Object k2 = k(e0Var);
                if (k2 == null) {
                    i.b.q.c(b, e0Var);
                    break;
                } else if (k2 instanceof p) {
                    s(b, e2, (p) k2);
                    break;
                } else if (k2 != i.b.t3.a.f15802h && !(k2 instanceof x)) {
                    throw new IllegalStateException(("enqueueSend returned " + k2).toString());
                }
            }
            Object D = D(e2);
            if (D == i.b.t3.a.f15799e) {
                t1 t1Var = t1.a;
                Result.a aVar = Result.Companion;
                b.resumeWith(Result.m106constructorimpl(t1Var));
                break;
            } else if (D != i.b.t3.a.f15800f) {
                if (D instanceof p) {
                    s(b, e2, (p) D);
                } else {
                    throw new IllegalStateException(("offerInternal returned " + D).toString());
                }
            }
        }
        Object B = b.B();
        if (B == h.e2.j.b.h()) {
            h.e2.k.a.f.c(cVar);
        }
        return B;
    }

    @Override // i.b.t3.c0
    public boolean K(@k.e.a.e Throwable th) {
        boolean z;
        p<?> pVar = new p<>(th);
        i.b.w3.s sVar = this.a;
        while (true) {
            i.b.w3.s W = sVar.W();
            z = true;
            if (!(!(W instanceof p))) {
                z = false;
                break;
            } else if (W.M(pVar, sVar)) {
                break;
            }
        }
        if (!z) {
            i.b.w3.s W2 = this.a.W();
            Objects.requireNonNull(W2, "null cannot be cast to non-null type kotlinx.coroutines.channels.Closed<*>");
            pVar = (p) W2;
        }
        q(pVar);
        if (z) {
            t(th);
        }
        return z;
    }

    @k.e.a.e
    public z<E> M() {
        i.b.w3.s sVar;
        i.b.w3.s f0;
        i.b.w3.q qVar = this.a;
        while (true) {
            Object U = qVar.U();
            Objects.requireNonNull(U, "null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
            sVar = (i.b.w3.s) U;
            if (sVar != qVar && (sVar instanceof z)) {
                if (((((z) sVar) instanceof p) && !sVar.Z()) || (f0 = sVar.f0()) == null) {
                    break;
                }
                f0.Y();
            }
        }
        sVar = null;
        return (z) sVar;
    }

    @Override // i.b.t3.c0
    @k.e.a.e
    public final Object N(E e2, @k.e.a.d h.e2.c<? super t1> cVar) {
        Object J;
        return (D(e2) != i.b.t3.a.f15799e && (J = J(e2, cVar)) == h.e2.j.b.h()) ? J : t1.a;
    }

    @Override // i.b.t3.c0
    public final boolean O() {
        return n() != null;
    }

    @k.e.a.e
    public final b0 P() {
        i.b.w3.s sVar;
        i.b.w3.s f0;
        i.b.w3.q qVar = this.a;
        while (true) {
            Object U = qVar.U();
            Objects.requireNonNull(U, "null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
            sVar = (i.b.w3.s) U;
            if (sVar != qVar && (sVar instanceof b0)) {
                if (((((b0) sVar) instanceof p) && !sVar.Z()) || (f0 = sVar.f0()) == null) {
                    break;
                }
                f0.Y();
            }
        }
        sVar = null;
        return (b0) sVar;
    }

    @Override // i.b.t3.c0
    public boolean c() {
        return z();
    }

    @Override // i.b.t3.c0
    @k.e.a.d
    public final i.b.z3.e<E, c0<E>> h() {
        return new f();
    }

    @k.e.a.d
    public final s.b<?> i(E e2) {
        return new C0481b(this.a, e2);
    }

    @k.e.a.d
    public final d<E> j(E e2) {
        return new d<>(e2, this.a);
    }

    @k.e.a.e
    public Object k(@k.e.a.d b0 b0Var) {
        boolean z;
        i.b.w3.s W;
        if (u()) {
            i.b.w3.s sVar = this.a;
            do {
                W = sVar.W();
                if (W instanceof z) {
                    return W;
                }
            } while (!W.M(b0Var, sVar));
            return null;
        }
        i.b.w3.s sVar2 = this.a;
        e eVar = new e(b0Var, b0Var, this);
        while (true) {
            i.b.w3.s W2 = sVar2.W();
            if (!(W2 instanceof z)) {
                int h0 = W2.h0(b0Var, sVar2, eVar);
                z = true;
                if (h0 != 1) {
                    if (h0 == 2) {
                        z = false;
                        break;
                    }
                } else {
                    break;
                }
            } else {
                return W2;
            }
        }
        if (z) {
            return null;
        }
        return i.b.t3.a.f15802h;
    }

    @k.e.a.d
    public String l() {
        return "";
    }

    @k.e.a.e
    public final p<?> m() {
        i.b.w3.s V = this.a.V();
        if (!(V instanceof p)) {
            V = null;
        }
        p<?> pVar = (p) V;
        if (pVar != null) {
            q(pVar);
            return pVar;
        }
        return null;
    }

    @k.e.a.e
    public final p<?> n() {
        i.b.w3.s W = this.a.W();
        if (!(W instanceof p)) {
            W = null;
        }
        p<?> pVar = (p) W;
        if (pVar != null) {
            q(pVar);
            return pVar;
        }
        return null;
    }

    @k.e.a.d
    public final i.b.w3.q o() {
        return this.a;
    }

    @Override // i.b.t3.c0
    public final boolean offer(E e2) {
        Object D = D(e2);
        if (D == i.b.t3.a.f15799e) {
            return true;
        }
        if (D == i.b.t3.a.f15800f) {
            p<?> n = n();
            if (n == null) {
                return false;
            }
            throw h0.p(r(e2, n));
        } else if (D instanceof p) {
            throw h0.p(r(e2, (p) D));
        } else {
            throw new IllegalStateException(("offerInternal returned " + D).toString());
        }
    }

    @k.e.a.d
    public String toString() {
        return r0.a(this) + '@' + r0.b(this) + '{' + p() + '}' + l();
    }

    public abstract boolean u();

    public abstract boolean w();

    @Override // i.b.t3.c0
    public void x(@k.e.a.d h.k2.u.l<? super Throwable, t1> lVar) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f15804c;
        if (!atomicReferenceFieldUpdater.compareAndSet(this, null, lVar)) {
            Object obj = this.onCloseHandler;
            if (obj == i.b.t3.a.f15803i) {
                throw new IllegalStateException("Another handler was already registered and successfully invoked");
            }
            throw new IllegalStateException("Another handler was already registered: " + obj);
        }
        p<?> n = n();
        if (n == null || !atomicReferenceFieldUpdater.compareAndSet(this, lVar, i.b.t3.a.f15803i)) {
            return;
        }
        lVar.invoke(n.f15835d);
    }

    public final boolean z() {
        return !(this.a.V() instanceof z) && w();
    }
}
