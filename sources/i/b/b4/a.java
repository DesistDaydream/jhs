package i.b.b4;

import androidx.exifinterface.media.ExifInterface;
import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.huawei.hms.push.e;
import com.qiniu.android.collect.ReportItem;
import com.umeng.analytics.pro.am;
import e.j.a.b.c.f;
import h.i;
import h.k2.u.l;
import h.k2.u.p;
import h.k2.v.u;
import h.q0;
import h.t1;
import i.b.e1;
import i.b.i1;
import i.b.n;
import i.b.r0;
import i.b.v0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import k.e.a.d;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineExceptionHandler;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0001CB\u0013\u0012\n\b\u0002\u0010:\u001a\u0004\u0018\u00010*¢\u0006\u0004\bS\u0010TJ\u001b\u0010\u0006\u001a\u00020\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J#\u0010\u000b\u001a\u00020\n2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J7\u0010\u0017\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00122\u0006\u0010\u0013\u001a\u00028\u00002\u0018\u0010\u0016\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00028\u00000\u0014H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J*\u0010\u001b\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0006*\u00020\u00152\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019H\u0096\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u001b\u0010\u001d\u001a\u00020\u00012\n\u0010\u001a\u001a\u0006\u0012\u0002\b\u00030\u0019H\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010!\u001a\u00020\b2\b\b\u0002\u0010 \u001a\u00020\u001f¢\u0006\u0004\b!\u0010\"J\u001f\u0010#\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010 \u001a\u00020\u001f¢\u0006\u0004\b#\u0010$J\u001f\u0010%\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\b2\b\b\u0002\u0010 \u001a\u00020\u001f¢\u0006\u0004\b%\u0010&J\r\u0010'\u001a\u00020\u0005¢\u0006\u0004\b'\u0010(J\r\u0010)\u001a\u00020\u0005¢\u0006\u0004\b)\u0010(J+\u00100\u001a\u00020\u00052\b\b\u0002\u0010+\u001a\u00020*2\u0012\u0010/\u001a\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020.0,¢\u0006\u0004\b0\u00101J+\u00102\u001a\u00020\u00052\b\b\u0002\u0010+\u001a\u00020*2\u0012\u0010/\u001a\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020.0,¢\u0006\u0004\b2\u00101J+\u00103\u001a\u00020\u00052\b\b\u0002\u0010+\u001a\u00020*2\u0012\u0010/\u001a\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020.0,¢\u0006\u0004\b3\u00101J1\u00105\u001a\u00020\u00052\b\b\u0002\u0010+\u001a\u00020*2\u0018\u0010/\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020-04\u0012\u0004\u0012\u00020.0,¢\u0006\u0004\b5\u00101J\u000f\u00106\u001a\u00020*H\u0016¢\u0006\u0004\b6\u00107R\u0018\u0010:\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010=\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u0010<R\u001c\u0010A\u001a\b\u0012\u0004\u0012\u00020-0>8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b?\u0010@R\u001a\u0010E\u001a\u00060BR\u00020\u00008\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010I\u001a\u00020F8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010K\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bJ\u0010<R\u0019\u0010N\u001a\b\u0012\u0004\u0012\u00020-048F@\u0006¢\u0006\u0006\u001a\u0004\bL\u0010MR\u001c\u0010R\u001a\b\u0012\u0004\u0012\u00020\n0O8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bP\u0010Q¨\u0006U"}, d2 = {"Li/b/b4/a;", "Lkotlin/coroutines/CoroutineContext;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", ReportItem.LogTypeBlock, "Lh/t1;", ExifInterface.LONGITUDE_EAST, "(Ljava/lang/Runnable;)V", "", "delayTime", "Li/b/b4/c;", "L", "(Ljava/lang/Runnable;J)Li/b/b4/c;", "N", "()J", "targetTime", "P", "(J)V", "R", "initial", "Lkotlin/Function2;", "Lkotlin/coroutines/CoroutineContext$a;", "operation", "fold", "(Ljava/lang/Object;Lh/k2/u/p;)Ljava/lang/Object;", "Lkotlin/coroutines/CoroutineContext$b;", "key", "get", "(Lkotlin/coroutines/CoroutineContext$b;)Lkotlin/coroutines/CoroutineContext$a;", "minusKey", "(Lkotlin/coroutines/CoroutineContext$b;)Lkotlin/coroutines/CoroutineContext;", "Ljava/util/concurrent/TimeUnit;", "unit", ExpandableTextView.P, "(Ljava/util/concurrent/TimeUnit;)J", "m", "(JLjava/util/concurrent/TimeUnit;)J", am.aI, "(JLjava/util/concurrent/TimeUnit;)V", "O", "()V", "D", "", "message", "Lkotlin/Function1;", "", "", "predicate", "B", "(Ljava/lang/String;Lh/k2/u/l;)V", "v", "x", "", am.aD, "toString", "()Ljava/lang/String;", "g", "Ljava/lang/String;", "name", e.a, "J", "counter", "", am.av, "Ljava/util/List;", "uncaughtExceptions", "Li/b/b4/a$b;", "b", "Li/b/b4/a$b;", "ctxDispatcher", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "c", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "ctxHandler", "f", "time", "G", "()Ljava/util/List;", "exceptions", "Li/b/w3/q0;", f.f10128d, "Li/b/w3/q0;", "queue", "<init>", "(Ljava/lang/String;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
@i(level = DeprecationLevel.WARNING, message = "This API has been deprecated to integrate with Structured Concurrency.", replaceWith = @q0(expression = "TestCoroutineScope", imports = {"kotlin.coroutines.test"}))
/* loaded from: classes4.dex */
public final class a implements CoroutineContext {
    private final List<Throwable> a;
    private final b b;

    /* renamed from: c  reason: collision with root package name */
    private final CoroutineExceptionHandler f15723c;

    /* renamed from: d  reason: collision with root package name */
    private final i.b.w3.q0<c> f15724d;

    /* renamed from: e  reason: collision with root package name */
    private long f15725e;

    /* renamed from: f  reason: collision with root package name */
    private long f15726f;

    /* renamed from: g  reason: collision with root package name */
    private final String f15727g;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\t¨\u0006\n¸\u0006\u000b"}, d2 = {"i/b/b4/a$a", "Lh/e2/a;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "Lkotlin/coroutines/CoroutineContext;", "context", "", "exception", "Lh/t1;", "handleException", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Throwable;)V", "kotlinx-coroutines-core", "i/b/k0$a"}, k = 1, mv = {1, 4, 0})
    /* renamed from: i.b.b4.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static final class C0477a extends h.e2.a implements CoroutineExceptionHandler {
        public final /* synthetic */ a a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0477a(CoroutineContext.b bVar, a aVar) {
            super(bVar);
            this.a = aVar;
        }

        @Override // kotlinx.coroutines.CoroutineExceptionHandler
        public void handleException(@d CoroutineContext coroutineContext, @d Throwable th) {
            this.a.a.add(th);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ#\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\n\u0010\u0007\u001a\u00060\u0005j\u0002`\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ%\u0010\u0012\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\b0\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J+\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u000e2\n\u0010\u0007\u001a\u00060\u0005j\u0002`\u00062\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001a\u0010\u001b¨\u0006\u001e"}, d2 = {"i/b/b4/a$b", "Li/b/i1;", "Li/b/v0;", "Lkotlin/coroutines/CoroutineContext;", "context", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", ReportItem.LogTypeBlock, "Lh/t1;", "dispatch", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Runnable;)V", "", "L0", "()Z", "", "timeMillis", "Li/b/n;", "continuation", "c", "(JLi/b/n;)V", "Li/b/e1;", am.aI, "(JLjava/lang/Runnable;Lkotlin/coroutines/CoroutineContext;)Li/b/e1;", "J0", "()J", "", "toString", "()Ljava/lang/String;", "<init>", "(Li/b/b4/a;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public final class b extends i1 implements v0 {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"i/b/b4/a$b$a", "Li/b/e1;", "Lh/t1;", "dispose", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
        /* renamed from: i.b.b4.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public static final class C0478a implements e1 {
            public final /* synthetic */ c b;

            public C0478a(c cVar) {
                this.b = cVar;
            }

            @Override // i.b.e1
            public void dispose() {
                a.this.f15724d.j(this.b);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0004\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002¨\u0006\u0003"}, d2 = {"Lh/t1;", "run", "()V", "i/b/x2$a", "<anonymous>"}, k = 3, mv = {1, 4, 0})
        /* renamed from: i.b.b4.a$b$b  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public static final class RunnableC0479b implements Runnable {
            public final /* synthetic */ n b;

            public RunnableC0479b(n nVar) {
                this.b = nVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.b.E(b.this, t1.a);
            }
        }

        public b() {
            i1.F0(this, false, 1, null);
        }

        @Override // i.b.i1
        public long J0() {
            return a.this.N();
        }

        @Override // i.b.i1
        public boolean L0() {
            return true;
        }

        @Override // i.b.v0
        public void c(long j2, @d n<? super t1> nVar) {
            a.this.L(new RunnableC0479b(nVar), j2);
        }

        @Override // kotlinx.coroutines.CoroutineDispatcher
        public void dispatch(@d CoroutineContext coroutineContext, @d Runnable runnable) {
            a.this.E(runnable);
        }

        @Override // i.b.v0
        @k.e.a.e
        public Object m0(long j2, @d h.e2.c<? super t1> cVar) {
            return v0.a.a(this, j2, cVar);
        }

        @Override // i.b.v0
        @d
        public e1 t(long j2, @d Runnable runnable, @d CoroutineContext coroutineContext) {
            return new C0478a(a.this.L(runnable, j2));
        }

        @Override // kotlinx.coroutines.CoroutineDispatcher
        @d
        public String toString() {
            return "Dispatcher(" + a.this + ')';
        }
    }

    public a() {
        this(null, 1, null);
    }

    public a(@k.e.a.e String str) {
        this.f15727g = str;
        this.a = new ArrayList();
        this.b = new b();
        this.f15723c = new C0477a(CoroutineExceptionHandler.x0, this);
        this.f15724d = new i.b.w3.q0<>();
    }

    public static /* synthetic */ void A(a aVar, String str, l lVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = "";
        }
        aVar.z(str, lVar);
    }

    public static /* synthetic */ void C(a aVar, String str, l lVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = "";
        }
        aVar.B(str, lVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E(Runnable runnable) {
        i.b.w3.q0<c> q0Var = this.f15724d;
        long j2 = this.f15725e;
        this.f15725e = 1 + j2;
        q0Var.b(new c(runnable, j2, 0L, 4, null));
    }

    public static /* synthetic */ long K(a aVar, TimeUnit timeUnit, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            timeUnit = TimeUnit.MILLISECONDS;
        }
        return aVar.I(timeUnit);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final c L(Runnable runnable, long j2) {
        long j3 = this.f15725e;
        this.f15725e = 1 + j3;
        c cVar = new c(runnable, j3, this.f15726f + TimeUnit.MILLISECONDS.toNanos(j2));
        this.f15724d.b(cVar);
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long N() {
        c h2 = this.f15724d.h();
        if (h2 != null) {
            P(h2.f15731e);
        }
        return this.f15724d.g() ? Long.MAX_VALUE : 0L;
    }

    private final void P(long j2) {
        c cVar;
        while (true) {
            i.b.w3.q0<c> q0Var = this.f15724d;
            synchronized (q0Var) {
                c e2 = q0Var.e();
                if (e2 != null) {
                    cVar = (e2.f15731e > j2 ? 1 : (e2.f15731e == j2 ? 0 : -1)) <= 0 ? q0Var.k(0) : null;
                }
            }
            c cVar2 = cVar;
            if (cVar2 == null) {
                return;
            }
            long j3 = cVar2.f15731e;
            if (j3 != 0) {
                this.f15726f = j3;
            }
            cVar2.run();
        }
    }

    public static /* synthetic */ long p(a aVar, long j2, TimeUnit timeUnit, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            timeUnit = TimeUnit.MILLISECONDS;
        }
        return aVar.m(j2, timeUnit);
    }

    public static /* synthetic */ void u(a aVar, long j2, TimeUnit timeUnit, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            timeUnit = TimeUnit.MILLISECONDS;
        }
        aVar.t(j2, timeUnit);
    }

    public static /* synthetic */ void w(a aVar, String str, l lVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = "";
        }
        aVar.v(str, lVar);
    }

    public static /* synthetic */ void y(a aVar, String str, l lVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = "";
        }
        aVar.x(str, lVar);
    }

    public final void B(@d String str, @d l<? super Throwable, Boolean> lVar) {
        if (this.a.size() == 1 && lVar.invoke(this.a.get(0)).booleanValue()) {
            this.a.clear();
            return;
        }
        throw new AssertionError(str);
    }

    public final void D() {
        if (this.f15724d.g()) {
            return;
        }
        this.f15724d.d();
    }

    @d
    public final List<Throwable> G() {
        return this.a;
    }

    public final long I(@d TimeUnit timeUnit) {
        return timeUnit.convert(this.f15726f, TimeUnit.NANOSECONDS);
    }

    public final void O() {
        P(this.f15726f);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public <R> R fold(R r, @d p<? super R, ? super CoroutineContext.a, ? extends R> pVar) {
        return pVar.invoke((R) pVar.invoke(r, this.b), this.f15723c);
    }

    @Override // kotlin.coroutines.CoroutineContext
    @k.e.a.e
    public <E extends CoroutineContext.a> E get(@d CoroutineContext.b<E> bVar) {
        if (bVar == h.e2.d.v0) {
            b bVar2 = this.b;
            Objects.requireNonNull(bVar2, "null cannot be cast to non-null type E");
            return bVar2;
        } else if (bVar == CoroutineExceptionHandler.x0) {
            CoroutineExceptionHandler coroutineExceptionHandler = this.f15723c;
            Objects.requireNonNull(coroutineExceptionHandler, "null cannot be cast to non-null type E");
            return coroutineExceptionHandler;
        } else {
            return null;
        }
    }

    public final long m(long j2, @d TimeUnit timeUnit) {
        long j3 = this.f15726f;
        TimeUnit timeUnit2 = TimeUnit.NANOSECONDS;
        t(timeUnit.toNanos(j2) + j3, timeUnit2);
        return timeUnit.convert(this.f15726f - j3, timeUnit2);
    }

    @Override // kotlin.coroutines.CoroutineContext
    @d
    public CoroutineContext minusKey(@d CoroutineContext.b<?> bVar) {
        return bVar == h.e2.d.v0 ? this.f15723c : bVar == CoroutineExceptionHandler.x0 ? this.b : this;
    }

    @Override // kotlin.coroutines.CoroutineContext
    @d
    public CoroutineContext plus(@d CoroutineContext coroutineContext) {
        return CoroutineContext.DefaultImpls.a(this, coroutineContext);
    }

    public final void t(long j2, @d TimeUnit timeUnit) {
        long nanos = timeUnit.toNanos(j2);
        P(nanos);
        if (nanos > this.f15726f) {
            this.f15726f = nanos;
        }
    }

    @d
    public String toString() {
        String str = this.f15727g;
        if (str != null) {
            return str;
        }
        return "TestCoroutineContext@" + r0.b(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void v(@d String str, @d l<? super Throwable, Boolean> lVar) {
        List<Throwable> list = this.a;
        boolean z = true;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (!lVar.invoke(it.next()).booleanValue()) {
                    z = false;
                    break;
                }
            }
        }
        if (z) {
            this.a.clear();
            return;
        }
        throw new AssertionError(str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void x(@d String str, @d l<? super Throwable, Boolean> lVar) {
        List<Throwable> list = this.a;
        boolean z = false;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (lVar.invoke(it.next()).booleanValue()) {
                    z = true;
                    break;
                }
            }
        }
        if (z) {
            this.a.clear();
            return;
        }
        throw new AssertionError(str);
    }

    public final void z(@d String str, @d l<? super List<? extends Throwable>, Boolean> lVar) {
        if (lVar.invoke(this.a).booleanValue()) {
            this.a.clear();
            return;
        }
        throw new AssertionError(str);
    }

    public /* synthetic */ a(String str, int i2, u uVar) {
        this((i2 & 1) != 0 ? null : str);
    }
}
