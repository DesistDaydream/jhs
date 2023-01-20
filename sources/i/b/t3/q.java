package i.b.t3;

import androidx.exifinterface.media.ExifInterface;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.meizu.cloud.pushsdk.notification.model.NotifyType;
import com.qiniu.android.collect.ReportItem;
import com.umeng.analytics.pro.am;
import h.k2.v.t0;
import h.t1;
import i.b.q0;
import i.b.r1;
import i.b.w3.i0;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlinx.coroutines.channels.ClosedSendChannelException;

@r1
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0007\u0018\u0000 \u0006*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002:\u0004*-3EB\u0007¢\u0006\u0004\bC\u0010=B\u0011\b\u0016\u0012\u0006\u0010>\u001a\u00028\u0000¢\u0006\u0004\bC\u0010DJ\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J?\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\b2\u0014\u0010\t\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0003\u0018\u00010\b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0002¢\u0006\u0004\b\n\u0010\u000bJ?\u0010\f\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0003\u0018\u00010\b2\u0012\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0002¢\u0006\u0004\b\f\u0010\u000bJ\u0019\u0010\u000f\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0011\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0013\u0010\u0014JX\u0010\u001d\u001a\u00020\u0005\"\u0004\b\u0001\u0010\u00152\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00010\u00162\u0006\u0010\u0011\u001a\u00028\u00002(\u0010\u001c\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u0018H\u0002ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001eJ\u0015\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000\u001fH\u0016¢\u0006\u0004\b \u0010!J\u0019\u0010#\u001a\u00020\"2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b#\u0010$J)\u0010(\u001a\u00020\u00052\u0018\u0010'\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0004\u0012\u00020\u00050%j\u0002`&H\u0016¢\u0006\u0004\b(\u0010)J\u0019\u0010*\u001a\u00020\"2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0017¢\u0006\u0004\b*\u0010$J\u001f\u0010-\u001a\u00020\u00052\u000e\u0010\u000e\u001a\n\u0018\u00010+j\u0004\u0018\u0001`,H\u0016¢\u0006\u0004\b-\u0010.J\u001b\u0010/\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b/\u00100J\u0017\u00101\u001a\u00020\"2\u0006\u0010\u0011\u001a\u00028\u0000H\u0016¢\u0006\u0004\b1\u00102R\u0016\u00105\u001a\u00020\"8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b3\u00104R(\u00109\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0019068V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b7\u00108R\u0019\u0010>\u001a\u00028\u00008F@\u0006¢\u0006\f\u0012\u0004\b<\u0010=\u001a\u0004\b:\u0010;R\u0016\u0010@\u001a\u00020\"8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b?\u00104R\u0015\u0010B\u001a\u0004\u0018\u00018\u00008F@\u0006¢\u0006\u0006\u001a\u0004\bA\u0010;\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006F"}, d2 = {"Li/b/t3/q;", ExifInterface.LONGITUDE_EAST, "Li/b/t3/i;", "Li/b/t3/q$d;", "subscriber", "Lh/t1;", "g", "(Li/b/t3/q$d;)V", "", "list", "f", "([Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Subscriber;Li/b/t3/q$d;)[Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Subscriber;", "o", "", "cause", NotifyType.LIGHTS, "(Ljava/lang/Throwable;)V", "element", "Li/b/t3/q$a;", "m", "(Ljava/lang/Object;)Li/b/t3/q$a;", "R", "Li/b/z3/f;", "select", "Lkotlin/Function2;", "Li/b/t3/c0;", "Lh/e2/c;", "", ReportItem.LogTypeBlock, "n", "(Li/b/z3/f;Ljava/lang/Object;Lh/k2/u/p;)V", "Li/b/t3/y;", "v", "()Li/b/t3/y;", "", "K", "(Ljava/lang/Throwable;)Z", "Lkotlin/Function1;", "Lkotlinx/coroutines/channels/Handler;", "handler", "x", "(Lh/k2/u/l;)V", am.av, "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "b", "(Ljava/util/concurrent/CancellationException;)V", "N", "(Ljava/lang/Object;Lh/e2/c;)Ljava/lang/Object;", "offer", "(Ljava/lang/Object;)Z", "c", "()Z", "isFull", "Li/b/z3/e;", "h", "()Li/b/z3/e;", "onSend", "i", "()Ljava/lang/Object;", "getValue$annotations", "()V", "value", "O", "isClosedForSend", "k", "valueOrNull", "<init>", "(Ljava/lang/Object;)V", e.j.a.b.c.f.f10128d, "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class q<E> implements i<E> {
    private static final AtomicReferenceFieldUpdater a;
    private static final AtomicIntegerFieldUpdater b;

    /* renamed from: c  reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f15836c;

    /* renamed from: e  reason: collision with root package name */
    private static final i0 f15838e;

    /* renamed from: f  reason: collision with root package name */
    private static final c<Object> f15839f;
    private volatile Object _state;
    private volatile int _updating;
    private volatile Object onCloseHandler;

    /* renamed from: g  reason: collision with root package name */
    private static final b f15840g = new b(null);

    /* renamed from: d  reason: collision with root package name */
    private static final a f15837d = new a(null);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u0003\n\u0002\b\n\b\u0002\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\n\u0010\u000bR\u0013\u0010\u0005\u001a\u00020\u00028F@\u0006¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0013\u0010\u0007\u001a\u00020\u00028F@\u0006¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\b¨\u0006\f"}, d2 = {"i/b/t3/q$a", "", "", "b", "()Ljava/lang/Throwable;", "valueException", am.av, "sendException", "Ljava/lang/Throwable;", "closeCause", "<init>", "(Ljava/lang/Throwable;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class a {
        @h.k2.d
        @k.e.a.e
        public final Throwable a;

        public a(@k.e.a.e Throwable th) {
            this.a = th;
        }

        @k.e.a.d
        public final Throwable a() {
            Throwable th = this.a;
            return th != null ? th : new ClosedSendChannelException(o.a);
        }

        @k.e.a.d
        public final Throwable b() {
            Throwable th = this.a;
            return th != null ? th : new IllegalStateException(o.a);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u001e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00058\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\t\u001a\u00020\b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"i/b/t3/q$b", "", "Li/b/t3/q$a;", "CLOSED", "Li/b/t3/q$a;", "Li/b/t3/q$c;", "INITIAL_STATE", "Li/b/t3/q$c;", "Li/b/w3/i0;", "UNDEFINED", "Li/b/w3/i0;", "<init>", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(h.k2.v.u uVar) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\t\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u0002B'\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\u0014\u0010\u0007\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000b\u0010\fR$\u0010\u0007\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0004\u0018\u00010\u00038\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"i/b/t3/q$c", ExifInterface.LONGITUDE_EAST, "", "", "Li/b/t3/q$d;", "b", "[Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Subscriber;", "subscribers", am.av, "Ljava/lang/Object;", "value", "<init>", "(Ljava/lang/Object;[Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Subscriber;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class c<E> {
        @h.k2.d
        @k.e.a.e
        public final Object a;
        @h.k2.d
        @k.e.a.e
        public final d<E>[] b;

        public c(@k.e.a.e Object obj, @k.e.a.e d<E>[] dVarArr) {
            this.a = obj;
            this.b = dVarArr;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u00028\u00010\u00022\b\u0012\u0004\u0012\u00028\u00010\u0003B\u0015\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00010\r¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u000b\u0010\fR\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00010\r8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"i/b/t3/q$d", ExifInterface.LONGITUDE_EAST, "Li/b/t3/r;", "Li/b/t3/y;", "", "wasClosed", "Lh/t1;", "c0", "(Z)V", "element", "", "D", "(Ljava/lang/Object;)Ljava/lang/Object;", "Li/b/t3/q;", "f", "Li/b/t3/q;", "broadcastChannel", "<init>", "(Li/b/t3/q;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class d<E> extends r<E> implements y<E> {

        /* renamed from: f  reason: collision with root package name */
        private final q<E> f15841f;

        public d(@k.e.a.d q<E> qVar) {
            super(null);
            this.f15841f = qVar;
        }

        @Override // i.b.t3.r, i.b.t3.b
        @k.e.a.d
        public Object D(E e2) {
            return super.D(e2);
        }

        @Override // i.b.t3.r, kotlinx.coroutines.channels.AbstractChannel
        public void c0(boolean z) {
            if (z) {
                this.f15841f.g(this);
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\n\u0018\u00002\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001JX\u0010\f\u001a\u00020\u000b\"\u0004\b\u0001\u0010\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u00042\u0006\u0010\u0006\u001a\u00028\u00002(\u0010\n\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0007H\u0016ø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, d2 = {"i/b/t3/q$e", "Li/b/z3/e;", "Li/b/t3/c0;", "R", "Li/b/z3/f;", "select", RemoteMessageConst.MessageBody.PARAM, "Lkotlin/Function2;", "Lh/e2/c;", "", ReportItem.LogTypeBlock, "Lh/t1;", am.aD, "(Li/b/z3/f;Ljava/lang/Object;Lh/k2/u/p;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class e implements i.b.z3.e<E, c0<? super E>> {
        public e() {
        }

        @Override // i.b.z3.e
        public <R> void z(@k.e.a.d i.b.z3.f<? super R> fVar, E e2, @k.e.a.d h.k2.u.p<? super c0<? super E>, ? super h.e2.c<? super R>, ? extends Object> pVar) {
            q.this.n(fVar, e2, pVar);
        }
    }

    static {
        i0 i0Var = new i0("UNDEFINED");
        f15838e = i0Var;
        f15839f = new c<>(i0Var, null);
        a = AtomicReferenceFieldUpdater.newUpdater(q.class, Object.class, "_state");
        b = AtomicIntegerFieldUpdater.newUpdater(q.class, "_updating");
        f15836c = AtomicReferenceFieldUpdater.newUpdater(q.class, Object.class, "onCloseHandler");
    }

    public q() {
        this._state = f15839f;
        this._updating = 0;
        this.onCloseHandler = null;
    }

    private final d<E>[] f(d<E>[] dVarArr, d<E> dVar) {
        if (dVarArr == null) {
            d<E>[] dVarArr2 = new d[1];
            for (int i2 = 0; i2 < 1; i2++) {
                dVarArr2[i2] = dVar;
            }
            return dVarArr2;
        }
        return (d[]) h.a2.n.T2(dVarArr, dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g(d<E> dVar) {
        Object obj;
        c cVar;
        Object obj2;
        do {
            obj = this._state;
            if (obj instanceof a) {
                return;
            }
            if (obj instanceof c) {
                cVar = (c) obj;
                obj2 = cVar.a;
                Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.channels.ConflatedBroadcastChannel.State<E>");
            } else {
                throw new IllegalStateException(("Invalid state " + obj).toString());
            }
        } while (!a.compareAndSet(this, obj, new c(obj2, o(cVar.b, dVar))));
    }

    public static /* synthetic */ void j() {
    }

    private final void l(Throwable th) {
        i0 i0Var;
        Object obj = this.onCloseHandler;
        if (obj == null || obj == (i0Var = i.b.t3.a.f15803i) || !f15836c.compareAndSet(this, obj, i0Var)) {
            return;
        }
        ((h.k2.u.l) t0.q(obj, 1)).invoke(th);
    }

    private final a m(E e2) {
        Object obj;
        if (b.compareAndSet(this, 0, 1)) {
            do {
                try {
                    obj = this._state;
                    if (obj instanceof a) {
                        return (a) obj;
                    }
                    if (!(obj instanceof c)) {
                        throw new IllegalStateException(("Invalid state " + obj).toString());
                    } else if (obj == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.channels.ConflatedBroadcastChannel.State<E>");
                    }
                } finally {
                    this._updating = 0;
                }
            } while (!a.compareAndSet(this, obj, new c(e2, ((c) obj).b)));
            d<E>[] dVarArr = ((c) obj).b;
            if (dVarArr != null) {
                for (d<E> dVar : dVarArr) {
                    dVar.D(e2);
                }
            }
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final <R> void n(i.b.z3.f<? super R> fVar, E e2, h.k2.u.p<? super c0<? super E>, ? super h.e2.c<? super R>, ? extends Object> pVar) {
        if (fVar.s()) {
            a m2 = m(e2);
            if (m2 != null) {
                fVar.y(m2.a());
            } else {
                i.b.x3.b.d(pVar, this, fVar.v());
            }
        }
    }

    private final d<E>[] o(d<E>[] dVarArr, d<E> dVar) {
        int length = dVarArr.length;
        int ff = ArraysKt___ArraysKt.ff(dVarArr, dVar);
        if (q0.b()) {
            if (!(ff >= 0)) {
                throw new AssertionError();
            }
        }
        if (length == 1) {
            return null;
        }
        d<E>[] dVarArr2 = new d[length - 1];
        h.a2.n.l1(dVarArr, dVarArr2, 0, 0, ff, 6, null);
        h.a2.n.l1(dVarArr, dVarArr2, ff, ff + 1, 0, 8, null);
        return dVarArr2;
    }

    @Override // i.b.t3.i
    /* renamed from: K */
    public boolean a(@k.e.a.e Throwable th) {
        Object obj;
        int i2;
        do {
            obj = this._state;
            if (obj instanceof a) {
                return false;
            }
            if (!(obj instanceof c)) {
                throw new IllegalStateException(("Invalid state " + obj).toString());
            }
        } while (!a.compareAndSet(this, obj, th == null ? f15837d : new a(th)));
        Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.channels.ConflatedBroadcastChannel.State<E>");
        d<E>[] dVarArr = ((c) obj).b;
        if (dVarArr != null) {
            for (d<E> dVar : dVarArr) {
                dVar.K(th);
            }
        }
        l(th);
        return true;
    }

    @Override // i.b.t3.c0
    @k.e.a.e
    public Object N(E e2, @k.e.a.d h.e2.c<? super t1> cVar) {
        a m2 = m(e2);
        if (m2 == null) {
            return m2 == h.e2.j.b.h() ? m2 : t1.a;
        }
        throw m2.a();
    }

    @Override // i.b.t3.c0
    public boolean O() {
        return this._state instanceof a;
    }

    @Override // i.b.t3.i
    public void b(@k.e.a.e CancellationException cancellationException) {
        a(cancellationException);
    }

    @Override // i.b.t3.c0
    public boolean c() {
        return false;
    }

    @Override // i.b.t3.c0
    @k.e.a.d
    public i.b.z3.e<E, c0<E>> h() {
        return new e();
    }

    public final E i() {
        Object obj = this._state;
        if (!(obj instanceof a)) {
            if (obj instanceof c) {
                E e2 = (E) ((c) obj).a;
                if (e2 != f15838e) {
                    return e2;
                }
                throw new IllegalStateException("No value");
            }
            throw new IllegalStateException(("Invalid state " + obj).toString());
        }
        throw ((a) obj).b();
    }

    @k.e.a.e
    public final E k() {
        Object obj = this._state;
        if (obj instanceof a) {
            return null;
        }
        if (!(obj instanceof c)) {
            throw new IllegalStateException(("Invalid state " + obj).toString());
        }
        i0 i0Var = f15838e;
        E e2 = (E) ((c) obj).a;
        if (e2 == i0Var) {
            return null;
        }
        return e2;
    }

    @Override // i.b.t3.c0
    public boolean offer(E e2) {
        a m2 = m(e2);
        if (m2 == null) {
            return true;
        }
        throw m2.a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // i.b.t3.i
    @k.e.a.d
    public y<E> v() {
        Object obj;
        c cVar;
        Object obj2;
        d dVar = new d(this);
        do {
            obj = this._state;
            if (obj instanceof a) {
                dVar.K(((a) obj).a);
                return dVar;
            } else if (obj instanceof c) {
                cVar = (c) obj;
                Object obj3 = cVar.a;
                if (obj3 != f15838e) {
                    dVar.D(obj3);
                }
                obj2 = cVar.a;
                Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.channels.ConflatedBroadcastChannel.State<E>");
            } else {
                throw new IllegalStateException(("Invalid state " + obj).toString());
            }
        } while (!a.compareAndSet(this, obj, new c(obj2, f(cVar.b, dVar))));
        return dVar;
    }

    @Override // i.b.t3.c0
    public void x(@k.e.a.d h.k2.u.l<? super Throwable, t1> lVar) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f15836c;
        if (!atomicReferenceFieldUpdater.compareAndSet(this, null, lVar)) {
            Object obj = this.onCloseHandler;
            if (obj == i.b.t3.a.f15803i) {
                throw new IllegalStateException("Another handler was already registered and successfully invoked");
            }
            throw new IllegalStateException("Another handler was already registered: " + obj);
        }
        Object obj2 = this._state;
        if ((obj2 instanceof a) && atomicReferenceFieldUpdater.compareAndSet(this, lVar, i.b.t3.a.f15803i)) {
            lVar.invoke(((a) obj2).a);
        }
    }

    public q(E e2) {
        this();
        a.lazySet(this, new c(e2, null));
    }
}
