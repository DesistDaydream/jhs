package kotlinx.coroutines.sync;

import com.qiniu.android.collect.ReportItem;
import com.tencent.qcloud.tuicore.TUIConstants;
import com.umeng.analytics.pro.am;
import h.k2.u.p;
import h.t1;
import i.b.e1;
import i.b.n;
import i.b.o;
import i.b.q0;
import i.b.w3.b0;
import i.b.w3.i0;
import i.b.w3.q;
import i.b.w3.r;
import i.b.w3.s;
import i.b.z3.g;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0000\u0018\u00002\u00020\u00012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u00010\u0002:\u0006%&\u0006 \t\u0015B\u000f\u0012\u0006\u0010\"\u001a\u00020\u0005¢\u0006\u0004\b#\u0010$J\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\t\u001a\u00020\b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0096@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u000b\u001a\u00020\b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0082@ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\nJT\u0010\u0012\u001a\u00020\b\"\u0004\b\u0000\u0010\f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\r2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\"\u0010\u0011\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u000fH\u0016ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0014\u0010\u0007J\u0019\u0010\u0015\u001a\u00020\b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001c\u001a\u00020\u00058@@\u0000X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR$\u0010\u001f\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u00010\u00028V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0016\u0010!\u001a\u00020\u00058V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b \u0010\u001b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006'"}, d2 = {"Lkotlinx/coroutines/sync/MutexImpl;", "Li/b/a4/c;", "Li/b/z3/e;", "", TUIConstants.TUIChat.OWNER, "", am.av, "(Ljava/lang/Object;)Z", "Lh/t1;", "c", "(Ljava/lang/Object;Lh/e2/c;)Ljava/lang/Object;", "h", "R", "Li/b/z3/f;", "select", "Lkotlin/Function2;", "Lh/e2/c;", ReportItem.LogTypeBlock, am.aD, "(Li/b/z3/f;Ljava/lang/Object;Lh/k2/u/p;)V", com.huawei.hms.push.e.a, e.j.a.b.c.f.f10128d, "(Ljava/lang/Object;)V", "", "toString", "()Ljava/lang/String;", "g", "()Z", "isLockedEmptyQueueState", "f", "()Li/b/z3/e;", "onLock", "b", "isLocked", "locked", "<init>", "(Z)V", "LockCont", "LockSelect", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class MutexImpl implements i.b.a4.c, i.b.z3.e<Object, i.b.a4.c> {
    public static final AtomicReferenceFieldUpdater a = AtomicReferenceFieldUpdater.newUpdater(MutexImpl.class, Object.class, "_state");
    public volatile Object _state;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0082\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u001f\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\r¢\u0006\u0004\b\u0012\u0010\u0013J\u0011\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\r8\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0014"}, d2 = {"Lkotlinx/coroutines/sync/MutexImpl$LockCont;", "Lkotlinx/coroutines/sync/MutexImpl$a;", "Lkotlinx/coroutines/sync/MutexImpl;", "", "k0", "()Ljava/lang/Object;", "token", "Lh/t1;", "j0", "(Ljava/lang/Object;)V", "", "toString", "()Ljava/lang/String;", "Li/b/n;", "f", "Li/b/n;", "cont", TUIConstants.TUIChat.OWNER, "<init>", "(Lkotlinx/coroutines/sync/MutexImpl;Ljava/lang/Object;Li/b/n;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public final class LockCont extends a {
        @h.k2.d
        @k.e.a.d

        /* renamed from: f  reason: collision with root package name */
        public final n<t1> f17002f;

        /* JADX WARN: Multi-variable type inference failed */
        public LockCont(@k.e.a.e Object obj, @k.e.a.d n<? super t1> nVar) {
            super(obj);
            this.f17002f = nVar;
        }

        @Override // kotlinx.coroutines.sync.MutexImpl.a
        public void j0(@k.e.a.d Object obj) {
            this.f17002f.P(obj);
        }

        @Override // kotlinx.coroutines.sync.MutexImpl.a
        @k.e.a.e
        public Object k0() {
            return this.f17002f.D(t1.a, null, new MutexImpl$LockCont$tryResumeLockWaiter$1(this));
        }

        @Override // i.b.w3.s
        @k.e.a.d
        public String toString() {
            return "LockCont[" + this.f17007d + ", " + this.f17002f + "] for " + MutexImpl.this;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0082\u0004\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00060\u0002R\u00020\u0003BF\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0004\u0012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014\u0012\"\u0010\u0013\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u000eø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ\u0011\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rR5\u0010\u0013\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u000e8\u0006@\u0007X\u0087\u0004ø\u0001\u0000¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u00148\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001b"}, d2 = {"Lkotlinx/coroutines/sync/MutexImpl$LockSelect;", "R", "Lkotlinx/coroutines/sync/MutexImpl$a;", "Lkotlinx/coroutines/sync/MutexImpl;", "", "k0", "()Ljava/lang/Object;", "token", "Lh/t1;", "j0", "(Ljava/lang/Object;)V", "", "toString", "()Ljava/lang/String;", "Lkotlin/Function2;", "Li/b/a4/c;", "Lh/e2/c;", "g", "Lh/k2/u/p;", ReportItem.LogTypeBlock, "Li/b/z3/f;", "f", "Li/b/z3/f;", "select", TUIConstants.TUIChat.OWNER, "<init>", "(Lkotlinx/coroutines/sync/MutexImpl;Ljava/lang/Object;Li/b/z3/f;Lh/k2/u/p;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public final class LockSelect<R> extends a {
        @h.k2.d
        @k.e.a.d

        /* renamed from: f  reason: collision with root package name */
        public final i.b.z3.f<R> f17004f;
        @h.k2.d
        @k.e.a.d

        /* renamed from: g  reason: collision with root package name */
        public final p<i.b.a4.c, h.e2.c<? super R>, Object> f17005g;

        /* JADX WARN: Multi-variable type inference failed */
        public LockSelect(@k.e.a.e Object obj, @k.e.a.d i.b.z3.f<? super R> fVar, @k.e.a.d p<? super i.b.a4.c, ? super h.e2.c<? super R>, ? extends Object> pVar) {
            super(obj);
            this.f17004f = fVar;
            this.f17005g = pVar;
        }

        @Override // kotlinx.coroutines.sync.MutexImpl.a
        public void j0(@k.e.a.d Object obj) {
            i0 i0Var;
            if (q0.b()) {
                i0Var = MutexKt.f17020c;
                if (!(obj == i0Var)) {
                    throw new AssertionError();
                }
            }
            i.b.x3.a.d(this.f17005g, MutexImpl.this, this.f17004f.v(), new MutexImpl$LockSelect$completeResumeLockWaiter$2(this));
        }

        @Override // kotlinx.coroutines.sync.MutexImpl.a
        @k.e.a.e
        public Object k0() {
            i0 i0Var;
            if (this.f17004f.s()) {
                i0Var = MutexKt.f17020c;
                return i0Var;
            }
            return null;
        }

        @Override // i.b.w3.s
        @k.e.a.d
        public String toString() {
            return "LockSelect[" + this.f17007d + ", " + this.f17004f + "] for " + MutexImpl.this;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u000b\b¢\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0011\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0006H&¢\u0006\u0004\b\n\u0010\u000bR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"kotlinx/coroutines/sync/MutexImpl$a", "Li/b/w3/s;", "Li/b/e1;", "Lh/t1;", "dispose", "()V", "", "k0", "()Ljava/lang/Object;", "token", "j0", "(Ljava/lang/Object;)V", e.j.a.b.c.f.f10128d, "Ljava/lang/Object;", TUIConstants.TUIChat.OWNER, "<init>", "(Lkotlinx/coroutines/sync/MutexImpl;Ljava/lang/Object;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public abstract class a extends s implements e1 {
        @h.k2.d
        @k.e.a.e

        /* renamed from: d  reason: collision with root package name */
        public final Object f17007d;

        public a(@k.e.a.e Object obj) {
            this.f17007d = obj;
        }

        @Override // i.b.e1
        public final void dispose() {
            c0();
        }

        public abstract void j0(@k.e.a.d Object obj);

        @k.e.a.e
        public abstract Object k0();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"kotlinx/coroutines/sync/MutexImpl$b", "Li/b/w3/q;", "", "toString", "()Ljava/lang/String;", "", e.j.a.b.c.f.f10128d, "Ljava/lang/Object;", TUIConstants.TUIChat.OWNER, "<init>", "(Ljava/lang/Object;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class b extends q {
        @h.k2.d
        @k.e.a.d

        /* renamed from: d  reason: collision with root package name */
        public Object f17009d;

        public b(@k.e.a.d Object obj) {
            this.f17009d = obj;
        }

        @Override // i.b.w3.s
        @k.e.a.d
        public String toString() {
            return "LockedQueue[" + this.f17009d + ']';
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001:\u0001\tB\u0019\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0011\u0010\u0012J\u001d\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J%\u0010\t\u001a\u00020\b2\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00048\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u000f¨\u0006\u0013"}, d2 = {"kotlinx/coroutines/sync/MutexImpl$c", "Li/b/w3/b;", "Li/b/w3/d;", "op", "", "c", "(Li/b/w3/d;)Ljava/lang/Object;", "failure", "Lh/t1;", am.av, "(Li/b/w3/d;Ljava/lang/Object;)V", "Lkotlinx/coroutines/sync/MutexImpl;", "b", "Lkotlinx/coroutines/sync/MutexImpl;", "mutex", "Ljava/lang/Object;", TUIConstants.TUIChat.OWNER, "<init>", "(Lkotlinx/coroutines/sync/MutexImpl;Ljava/lang/Object;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class c extends i.b.w3.b {
        @h.k2.d
        @k.e.a.d
        public final MutexImpl b;
        @h.k2.d
        @k.e.a.e

        /* renamed from: c  reason: collision with root package name */
        public final Object f17010c;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u0006¢\u0006\u0004\b\u000b\u0010\fJ\u001b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005R \u0010\n\u001a\u0006\u0012\u0002\b\u00030\u00068\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0007\u0010\t¨\u0006\r"}, d2 = {"kotlinx/coroutines/sync/MutexImpl$c$a", "Li/b/w3/b0;", "", "affected", "c", "(Ljava/lang/Object;)Ljava/lang/Object;", "Li/b/w3/d;", am.av, "Li/b/w3/d;", "()Li/b/w3/d;", "atomicOp", "<init>", "(Lkotlinx/coroutines/sync/MutexImpl$c;Li/b/w3/d;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
        /* loaded from: classes4.dex */
        public final class a extends b0 {
            @k.e.a.d
            private final i.b.w3.d<?> a;

            public a(@k.e.a.d i.b.w3.d<?> dVar) {
                this.a = dVar;
            }

            @Override // i.b.w3.b0
            @k.e.a.d
            public i.b.w3.d<?> a() {
                return this.a;
            }

            @Override // i.b.w3.b0
            @k.e.a.e
            public Object c(@k.e.a.e Object obj) {
                Object a = a().h() ? MutexKt.f17024g : a();
                Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.sync.MutexImpl");
                MutexImpl.a.compareAndSet((MutexImpl) obj, this, a);
                return null;
            }
        }

        public c(@k.e.a.d MutexImpl mutexImpl, @k.e.a.e Object obj) {
            this.b = mutexImpl;
            this.f17010c = obj;
        }

        @Override // i.b.w3.b
        public void a(@k.e.a.d i.b.w3.d<?> dVar, @k.e.a.e Object obj) {
            i.b.a4.b bVar;
            if (obj != null) {
                bVar = MutexKt.f17024g;
            } else {
                Object obj2 = this.f17010c;
                bVar = obj2 == null ? MutexKt.f17023f : new i.b.a4.b(obj2);
            }
            MutexImpl.a.compareAndSet(this.b, dVar, bVar);
        }

        @Override // i.b.w3.b
        @k.e.a.e
        public Object c(@k.e.a.d i.b.w3.d<?> dVar) {
            i.b.a4.b bVar;
            i0 i0Var;
            a aVar = new a(dVar);
            MutexImpl mutexImpl = this.b;
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = MutexImpl.a;
            bVar = MutexKt.f17024g;
            if (!atomicReferenceFieldUpdater.compareAndSet(mutexImpl, bVar, aVar)) {
                i0Var = MutexKt.a;
                return i0Var;
            }
            return aVar.c(this.b);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"kotlinx/coroutines/sync/MutexImpl$d", "Li/b/w3/d;", "Lkotlinx/coroutines/sync/MutexImpl;", "affected", "", "k", "(Lkotlinx/coroutines/sync/MutexImpl;)Ljava/lang/Object;", "failure", "Lh/t1;", "j", "(Lkotlinx/coroutines/sync/MutexImpl;Ljava/lang/Object;)V", "Lkotlinx/coroutines/sync/MutexImpl$b;", "b", "Lkotlinx/coroutines/sync/MutexImpl$b;", "queue", "<init>", "(Lkotlinx/coroutines/sync/MutexImpl$b;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class d extends i.b.w3.d<MutexImpl> {
        @h.k2.d
        @k.e.a.d
        public final b b;

        public d(@k.e.a.d b bVar) {
            this.b = bVar;
        }

        @Override // i.b.w3.d
        /* renamed from: j */
        public void d(@k.e.a.d MutexImpl mutexImpl, @k.e.a.e Object obj) {
            MutexImpl.a.compareAndSet(mutexImpl, this, obj == null ? MutexKt.f17024g : this.b);
        }

        @Override // i.b.w3.d
        @k.e.a.e
        /* renamed from: k */
        public Object i(@k.e.a.d MutexImpl mutexImpl) {
            i0 i0Var;
            if (this.b.k0()) {
                return null;
            }
            i0Var = MutexKt.b;
            return i0Var;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\n\u0018\u00002\u00020\u0001J\u001d\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b¸\u0006\t"}, d2 = {"kotlinx/coroutines/sync/MutexImpl$e", "Li/b/w3/s$c;", "Li/b/w3/s;", "Lkotlinx/coroutines/internal/Node;", "affected", "", "k", "(Li/b/w3/s;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/sync/MutexImpl$$special$$inlined$loop$lambda$1"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class e extends s.c {

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ s f17011d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Object f17012e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ n f17013f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ LockCont f17014g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ MutexImpl f17015h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Object f17016i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(s sVar, s sVar2, Object obj, n nVar, LockCont lockCont, MutexImpl mutexImpl, Object obj2) {
            super(sVar2);
            this.f17011d = sVar;
            this.f17012e = obj;
            this.f17013f = nVar;
            this.f17014g = lockCont;
            this.f17015h = mutexImpl;
            this.f17016i = obj2;
        }

        @Override // i.b.w3.d
        @k.e.a.e
        /* renamed from: k */
        public Object i(@k.e.a.d s sVar) {
            if (this.f17015h._state == this.f17012e) {
                return null;
            }
            return r.a();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\n\u0018\u00002\u00020\u0001J\u001d\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b¸\u0006\t"}, d2 = {"kotlinx/coroutines/sync/MutexImpl$f", "Li/b/w3/s$c;", "Li/b/w3/s;", "Lkotlinx/coroutines/internal/Node;", "affected", "", "k", "(Li/b/w3/s;)Ljava/lang/Object;", "kotlinx-coroutines-core", "i/b/w3/s$f"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class f extends s.c {

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ s f17017d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MutexImpl f17018e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Object f17019f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(s sVar, s sVar2, MutexImpl mutexImpl, Object obj) {
            super(sVar2);
            this.f17017d = sVar;
            this.f17018e = mutexImpl;
            this.f17019f = obj;
        }

        @Override // i.b.w3.d
        @k.e.a.e
        /* renamed from: k */
        public Object i(@k.e.a.d s sVar) {
            if (this.f17018e._state == this.f17019f) {
                return null;
            }
            return r.a();
        }
    }

    public MutexImpl(boolean z) {
        this._state = z ? MutexKt.f17023f : MutexKt.f17024g;
    }

    @Override // i.b.a4.c
    public boolean a(@k.e.a.e Object obj) {
        i0 i0Var;
        while (true) {
            Object obj2 = this._state;
            if (obj2 instanceof i.b.a4.b) {
                Object obj3 = ((i.b.a4.b) obj2).a;
                i0Var = MutexKt.f17022e;
                if (obj3 != i0Var) {
                    return false;
                }
                if (a.compareAndSet(this, obj2, obj == null ? MutexKt.f17023f : new i.b.a4.b(obj))) {
                    return true;
                }
            } else if (obj2 instanceof b) {
                if (((b) obj2).f17009d != obj) {
                    return false;
                }
                throw new IllegalStateException(("Already locked by " + obj).toString());
            } else if (!(obj2 instanceof b0)) {
                throw new IllegalStateException(("Illegal state " + obj2).toString());
            } else {
                ((b0) obj2).c(this);
            }
        }
    }

    @Override // i.b.a4.c
    public boolean b() {
        i0 i0Var;
        while (true) {
            Object obj = this._state;
            if (obj instanceof i.b.a4.b) {
                Object obj2 = ((i.b.a4.b) obj).a;
                i0Var = MutexKt.f17022e;
                return obj2 != i0Var;
            } else if (obj instanceof b) {
                return true;
            } else {
                if (!(obj instanceof b0)) {
                    throw new IllegalStateException(("Illegal state " + obj).toString());
                }
                ((b0) obj).c(this);
            }
        }
    }

    @Override // i.b.a4.c
    @k.e.a.e
    public Object c(@k.e.a.e Object obj, @k.e.a.d h.e2.c<? super t1> cVar) {
        Object h2;
        return (!a(obj) && (h2 = h(obj, cVar)) == h.e2.j.b.h()) ? h2 : t1.a;
    }

    @Override // i.b.a4.c
    public void d(@k.e.a.e Object obj) {
        i.b.a4.b bVar;
        i0 i0Var;
        while (true) {
            Object obj2 = this._state;
            if (obj2 instanceof i.b.a4.b) {
                if (obj == null) {
                    Object obj3 = ((i.b.a4.b) obj2).a;
                    i0Var = MutexKt.f17022e;
                    if (!(obj3 != i0Var)) {
                        throw new IllegalStateException("Mutex is not locked".toString());
                    }
                } else {
                    i.b.a4.b bVar2 = (i.b.a4.b) obj2;
                    if (!(bVar2.a == obj)) {
                        throw new IllegalStateException(("Mutex is locked by " + bVar2.a + " but expected " + obj).toString());
                    }
                }
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = a;
                bVar = MutexKt.f17024g;
                if (atomicReferenceFieldUpdater.compareAndSet(this, obj2, bVar)) {
                    return;
                }
            } else if (obj2 instanceof b0) {
                ((b0) obj2).c(this);
            } else if (obj2 instanceof b) {
                if (obj != null) {
                    b bVar3 = (b) obj2;
                    if (!(bVar3.f17009d == obj)) {
                        throw new IllegalStateException(("Mutex is locked by " + bVar3.f17009d + " but expected " + obj).toString());
                    }
                }
                b bVar4 = (b) obj2;
                s e0 = bVar4.e0();
                if (e0 == null) {
                    d dVar = new d(bVar4);
                    if (a.compareAndSet(this, obj2, dVar) && dVar.c(this) == null) {
                        return;
                    }
                } else {
                    a aVar = (a) e0;
                    Object k0 = aVar.k0();
                    if (k0 != null) {
                        Object obj4 = aVar.f17007d;
                        if (obj4 == null) {
                            obj4 = MutexKt.f17021d;
                        }
                        bVar4.f17009d = obj4;
                        aVar.j0(k0);
                        return;
                    }
                }
            } else {
                throw new IllegalStateException(("Illegal state " + obj2).toString());
            }
        }
    }

    @Override // i.b.a4.c
    public boolean e(@k.e.a.d Object obj) {
        Object obj2 = this._state;
        if (obj2 instanceof i.b.a4.b) {
            if (((i.b.a4.b) obj2).a == obj) {
                return true;
            }
        } else if ((obj2 instanceof b) && ((b) obj2).f17009d == obj) {
            return true;
        }
        return false;
    }

    @Override // i.b.a4.c
    @k.e.a.d
    public i.b.z3.e<Object, i.b.a4.c> f() {
        return this;
    }

    public final boolean g() {
        Object obj = this._state;
        return (obj instanceof b) && ((b) obj).k0();
    }

    @k.e.a.e
    public final /* synthetic */ Object h(@k.e.a.e Object obj, @k.e.a.d h.e2.c<? super t1> cVar) {
        i0 i0Var;
        o b2 = i.b.q.b(IntrinsicsKt__IntrinsicsJvmKt.d(cVar));
        LockCont lockCont = new LockCont(obj, b2);
        while (true) {
            Object obj2 = this._state;
            if (obj2 instanceof i.b.a4.b) {
                i.b.a4.b bVar = (i.b.a4.b) obj2;
                Object obj3 = bVar.a;
                i0Var = MutexKt.f17022e;
                if (obj3 != i0Var) {
                    a.compareAndSet(this, obj2, new b(bVar.a));
                } else {
                    if (a.compareAndSet(this, obj2, obj == null ? MutexKt.f17023f : new i.b.a4.b(obj))) {
                        t1 t1Var = t1.a;
                        Result.a aVar = Result.Companion;
                        b2.resumeWith(Result.m106constructorimpl(t1Var));
                        break;
                    }
                }
            } else if (obj2 instanceof b) {
                b bVar2 = (b) obj2;
                boolean z = false;
                if (bVar2.f17009d != obj) {
                    e eVar = new e(lockCont, lockCont, obj2, b2, lockCont, this, obj);
                    while (true) {
                        int h0 = bVar2.W().h0(lockCont, bVar2, eVar);
                        if (h0 == 1) {
                            z = true;
                            break;
                        } else if (h0 == 2) {
                            break;
                        }
                    }
                    if (z) {
                        i.b.q.c(b2, lockCont);
                        break;
                    }
                } else {
                    throw new IllegalStateException(("Already locked by " + obj).toString());
                }
            } else if (!(obj2 instanceof b0)) {
                throw new IllegalStateException(("Illegal state " + obj2).toString());
            } else {
                ((b0) obj2).c(this);
            }
        }
        Object B = b2.B();
        if (B == h.e2.j.b.h()) {
            h.e2.k.a.f.c(cVar);
        }
        return B;
    }

    @k.e.a.d
    public String toString() {
        while (true) {
            Object obj = this._state;
            if (obj instanceof i.b.a4.b) {
                return "Mutex[" + ((i.b.a4.b) obj).a + ']';
            } else if (!(obj instanceof b0)) {
                if (!(obj instanceof b)) {
                    throw new IllegalStateException(("Illegal state " + obj).toString());
                }
                return "Mutex[" + ((b) obj).f17009d + ']';
            } else {
                ((b0) obj).c(this);
            }
        }
    }

    @Override // i.b.z3.e
    public <R> void z(@k.e.a.d i.b.z3.f<? super R> fVar, @k.e.a.e Object obj, @k.e.a.d p<? super i.b.a4.c, ? super h.e2.c<? super R>, ? extends Object> pVar) {
        i0 i0Var;
        i0 i0Var2;
        while (!fVar.b()) {
            Object obj2 = this._state;
            if (obj2 instanceof i.b.a4.b) {
                i.b.a4.b bVar = (i.b.a4.b) obj2;
                Object obj3 = bVar.a;
                i0Var = MutexKt.f17022e;
                if (obj3 != i0Var) {
                    a.compareAndSet(this, obj2, new b(bVar.a));
                } else {
                    Object z = fVar.z(new c(this, obj));
                    if (z == null) {
                        i.b.x3.b.d(pVar, this, fVar.v());
                        return;
                    } else if (z == g.d()) {
                        return;
                    } else {
                        i0Var2 = MutexKt.a;
                        if (z != i0Var2 && z != i.b.w3.c.b) {
                            throw new IllegalStateException(("performAtomicTrySelect(TryLockDesc) returned " + z).toString());
                        }
                    }
                }
            } else if (obj2 instanceof b) {
                b bVar2 = (b) obj2;
                boolean z2 = false;
                if (bVar2.f17009d != obj) {
                    LockSelect lockSelect = new LockSelect(obj, fVar, pVar);
                    f fVar2 = new f(lockSelect, lockSelect, this, obj2);
                    while (true) {
                        int h0 = bVar2.W().h0(lockSelect, bVar2, fVar2);
                        if (h0 == 1) {
                            z2 = true;
                            break;
                        } else if (h0 == 2) {
                            break;
                        }
                    }
                    if (z2) {
                        fVar.k(lockSelect);
                        return;
                    }
                } else {
                    throw new IllegalStateException(("Already locked by " + obj).toString());
                }
            } else if (!(obj2 instanceof b0)) {
                throw new IllegalStateException(("Illegal state " + obj2).toString());
            } else {
                ((b0) obj2).c(this);
            }
        }
    }
}
