package i.b;

import androidx.exifinterface.media.ExifInterface;
import com.umeng.analytics.pro.am;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0002\b\u0004B\u001d\u0012\u0014\u0010\n\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00028\u00000\u00070\u0006¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005R$\u0010\n\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00028\u00000\u00070\u00068\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\r"}, d2 = {"Li/b/c;", ExifInterface.GPS_DIRECTION_TRUE, "", "", "b", "(Lh/e2/c;)Ljava/lang/Object;", "", "Li/b/u0;", am.av, "[Lkotlinx/coroutines/Deferred;", "deferreds", "<init>", "([Lkotlinx/coroutines/Deferred;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class c<T> {
    public static final AtomicIntegerFieldUpdater b = AtomicIntegerFieldUpdater.newUpdater(c.class, "notCompletedCount");
    private final u0<T>[] a;
    public volatile int notCompletedCount;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B#\u0012\u0012\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\t0\b\u0012\u0006\u0010\u001d\u001a\u00020\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u001a\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0096\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\"\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\t0\b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\"\u0010\u0014\u001a\u00020\r8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R<\u0010\u001c\u001a\u000e\u0018\u00010\u0015R\b\u0012\u0004\u0012\u00028\u00000\u00162\u0012\u0010\u0017\u001a\u000e\u0018\u00010\u0015R\b\u0012\u0004\u0012\u00028\u00000\u00168F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006 "}, d2 = {"i/b/c$a", "Li/b/h2;", "Li/b/b2;", "", "cause", "Lh/t1;", "j0", "(Ljava/lang/Throwable;)V", "Li/b/n;", "", "f", "Li/b/n;", "continuation", "Li/b/e1;", com.huawei.hms.push.e.a, "Li/b/e1;", "l0", "()Li/b/e1;", "n0", "(Li/b/e1;)V", "handle", "Li/b/c$b;", "Li/b/c;", "value", "k0", "()Li/b/c$b;", "m0", "(Li/b/c$b;)V", "disposer", "job", "<init>", "(Li/b/c;Li/b/n;Li/b/b2;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public final class a extends h2<b2> {
        private volatile Object _disposer;
        @k.e.a.d

        /* renamed from: e */
        public e1 f15732e;

        /* renamed from: f */
        private final n<List<? extends T>> f15733f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public a(@k.e.a.d n<? super List<? extends T>> nVar, @k.e.a.d b2 b2Var) {
            super(b2Var);
            c.this = r1;
            this.f15733f = nVar;
            this._disposer = null;
        }

        @Override // h.k2.u.l
        public /* bridge */ /* synthetic */ h.t1 invoke(Throwable th) {
            j0(th);
            return h.t1.a;
        }

        @Override // i.b.d0
        public void j0(@k.e.a.e Throwable th) {
            if (th != null) {
                Object t = this.f15733f.t(th);
                if (t != null) {
                    this.f15733f.P(t);
                    c<T>.b k0 = k0();
                    if (k0 != null) {
                        k0.b();
                        return;
                    }
                    return;
                }
                return;
            }
            if (c.b.decrementAndGet(c.this) == 0) {
                n<List<? extends T>> nVar = this.f15733f;
                u0[] u0VarArr = c.this.a;
                ArrayList arrayList = new ArrayList(u0VarArr.length);
                for (u0 u0Var : u0VarArr) {
                    arrayList.add(u0Var.n());
                }
                Result.a aVar = Result.Companion;
                nVar.resumeWith(Result.m106constructorimpl(arrayList));
            }
        }

        @k.e.a.e
        public final c<T>.b k0() {
            return (b) this._disposer;
        }

        @k.e.a.d
        public final e1 l0() {
            return this.f15732e;
        }

        public final void m0(@k.e.a.e c<T>.b bVar) {
            this._disposer = bVar;
        }

        public final void n0(@k.e.a.d e1 e1Var) {
            this.f15732e = e1Var;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\u00020\u0001B\u001f\u0012\u0016\u0010\u0010\u001a\u0012\u0012\u000e\u0012\f0\rR\b\u0012\u0004\u0012\u00028\u00000\u000e0\f¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0007\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bR&\u0010\u0010\u001a\u0012\u0012\u000e\u0012\f0\rR\b\u0012\u0004\u0012\u00028\u00000\u000e0\f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u000f¨\u0006\u0013"}, d2 = {"i/b/c$b", "Li/b/l;", "Lh/t1;", "b", "()V", "", "cause", am.av, "(Ljava/lang/Throwable;)V", "", "toString", "()Ljava/lang/String;", "", "Li/b/c$a;", "Li/b/c;", "[Lkotlinx/coroutines/AwaitAll$AwaitAllNode;", "nodes", "<init>", "(Li/b/c;[Lkotlinx/coroutines/AwaitAll$AwaitAllNode;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public final class b extends l {
        private final c<T>.a[] a;

        public b(@k.e.a.d c<T>.a[] aVarArr) {
            c.this = r1;
            this.a = aVarArr;
        }

        @Override // i.b.m
        public void a(@k.e.a.e Throwable th) {
            b();
        }

        public final void b() {
            for (c<T>.a aVar : this.a) {
                aVar.l0().dispose();
            }
        }

        @Override // h.k2.u.l
        public /* bridge */ /* synthetic */ h.t1 invoke(Throwable th) {
            a(th);
            return h.t1.a;
        }

        @k.e.a.d
        public String toString() {
            return "DisposeHandlersOnCancel[" + this.a + ']';
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(@k.e.a.d u0<? extends T>[] u0VarArr) {
        this.a = u0VarArr;
        this.notCompletedCount = u0VarArr.length;
    }

    @k.e.a.e
    public final Object b(@k.e.a.d h.e2.c<? super List<? extends T>> cVar) {
        o oVar = new o(IntrinsicsKt__IntrinsicsJvmKt.d(cVar), 1);
        oVar.G();
        int length = this.a.length;
        a[] aVarArr = new a[length];
        for (int i2 = 0; i2 < length; i2++) {
            u0 u0Var = this.a[h.e2.k.a.a.f(i2).intValue()];
            u0Var.start();
            a aVar = new a(oVar, u0Var);
            aVar.n0(u0Var.H(aVar));
            aVarArr[i2] = aVar;
        }
        c<T>.b bVar = new b(aVarArr);
        for (int i3 = 0; i3 < length; i3++) {
            aVarArr[i3].m0(bVar);
        }
        if (oVar.l()) {
            bVar.b();
        } else {
            oVar.p(bVar);
        }
        Object B = oVar.B();
        if (B == h.e2.j.b.h()) {
            h.e2.k.a.f.c(cVar);
        }
        return B;
    }
}
