package i.b;

import com.meizu.cloud.pushsdk.notification.model.NotifyType;
import com.tencent.android.tpush.common.MessageKey;
import com.umeng.analytics.pro.am;
import i.b.b2;
import java.util.concurrent.CancellationException;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.sequences.SequencesKt__SequencesKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0002¢\u0006\u0004\b9\u0010+J\u000f\u0010\u0004\u001a\u00020\u0003H\u0017¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\u0007\u001a\u00020\u0006H\u0097@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u0013\u0010\u000b\u001a\u00060\tj\u0002`\nH\u0017¢\u0006\u0004\b\u000b\u0010\fJ8\u0010\u0015\u001a\u00020\u00142'\u0010\u0013\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00060\rj\u0002`\u0012H\u0017¢\u0006\u0004\b\u0015\u0010\u0016JH\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00032'\u0010\u0013\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00060\rj\u0002`\u0012H\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ\u001f\u0010\u001b\u001a\u00020\u00062\u000e\u0010\u0011\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\nH\u0017¢\u0006\u0004\b\u001b\u0010\u001cJ\u0019\u0010\u001d\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u000eH\u0017¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\"\u001a\u00020!2\u0006\u0010 \u001a\u00020\u001fH\u0017¢\u0006\u0004\b\"\u0010#J\u000f\u0010%\u001a\u00020$H\u0016¢\u0006\u0004\b%\u0010&R\"\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00020'8V@\u0017X\u0097\u0004¢\u0006\f\u0012\u0004\b*\u0010+\u001a\u0004\b(\u0010)R\u001c\u0010/\u001a\u00020\u00038V@\u0017X\u0097\u0004¢\u0006\f\u0012\u0004\b.\u0010+\u001a\u0004\b-\u0010\u0005R\u001c\u00100\u001a\u00020\u00038V@\u0017X\u0097\u0004¢\u0006\f\u0012\u0004\b1\u0010+\u001a\u0004\b0\u0010\u0005R\u001c\u00104\u001a\u00020\u00038V@\u0017X\u0097\u0004¢\u0006\f\u0012\u0004\b3\u0010+\u001a\u0004\b2\u0010\u0005R\u0016\u00108\u001a\u0002058V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b6\u00107\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006:"}, d2 = {"Li/b/n2;", "Lh/e2/a;", "Li/b/b2;", "", MessageKey.MSG_ACCEPT_TIME_START, "()Z", "Lh/t1;", "Y", "(Lh/e2/c;)Ljava/lang/Object;", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "q", "()Ljava/util/concurrent/CancellationException;", "Lkotlin/Function1;", "", "Lh/k0;", "name", "cause", "Lkotlinx/coroutines/CompletionHandler;", "handler", "Li/b/e1;", "H", "(Lh/k2/u/l;)Li/b/e1;", "onCancelling", "invokeImmediately", "i", "(ZZLh/k2/u/l;)Li/b/e1;", "b", "(Ljava/util/concurrent/CancellationException;)V", am.av, "(Ljava/lang/Throwable;)Z", "Li/b/v;", "child", "Li/b/t;", "x0", "(Li/b/v;)Li/b/t;", "", "toString", "()Ljava/lang/String;", "Lh/q2/m;", "k", "()Lh/q2/m;", "getChildren$annotations", "()V", "children", "j", "isActive$annotations", "isActive", "isCancelled", "isCancelled$annotations", NotifyType.LIGHTS, "isCompleted$annotations", "isCompleted", "Li/b/z3/c;", "o0", "()Li/b/z3/c;", "onJoin", "<init>", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class n2 extends h.e2.a implements b2 {
    public static final n2 a = new n2();

    private n2() {
        super(b2.y0);
    }

    @x1
    public static /* synthetic */ void A0() {
    }

    @x1
    public static /* synthetic */ void B0() {
    }

    @x1
    public static /* synthetic */ void C0() {
    }

    @x1
    public static /* synthetic */ void z0() {
    }

    @Override // i.b.b2
    @h.i(level = DeprecationLevel.ERROR, message = "Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
    @k.e.a.d
    public b2 F(@k.e.a.d b2 b2Var) {
        return b2.a.i(this, b2Var);
    }

    @Override // i.b.b2
    @x1
    @k.e.a.d
    public e1 H(@k.e.a.d h.k2.u.l<? super Throwable, h.t1> lVar) {
        return o2.a;
    }

    @Override // i.b.b2
    @x1
    @k.e.a.e
    public Object Y(@k.e.a.d h.e2.c<? super h.t1> cVar) {
        throw new UnsupportedOperationException("This job is always active");
    }

    @Override // i.b.b2
    @h.i(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public /* synthetic */ boolean a(@k.e.a.e Throwable th) {
        return false;
    }

    @Override // i.b.b2
    @x1
    public void b(@k.e.a.e CancellationException cancellationException) {
    }

    @Override // i.b.b2
    @h.i(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public /* synthetic */ void cancel() {
        b(null);
    }

    @Override // i.b.b2
    @x1
    @k.e.a.d
    public e1 i(boolean z, boolean z2, @k.e.a.d h.k2.u.l<? super Throwable, h.t1> lVar) {
        return o2.a;
    }

    @Override // i.b.b2
    public boolean isCancelled() {
        return false;
    }

    @Override // i.b.b2
    public boolean j() {
        return true;
    }

    @Override // i.b.b2
    @k.e.a.d
    public h.q2.m<b2> k() {
        return SequencesKt__SequencesKt.j();
    }

    @Override // i.b.b2
    public boolean l() {
        return false;
    }

    @Override // i.b.b2
    @k.e.a.d
    public i.b.z3.c o0() {
        throw new UnsupportedOperationException("This job is always active");
    }

    @Override // i.b.b2
    @x1
    @k.e.a.d
    public CancellationException q() {
        throw new IllegalStateException("This job is always active");
    }

    @Override // i.b.b2
    @x1
    public boolean start() {
        return false;
    }

    @k.e.a.d
    public String toString() {
        return "NonCancellable";
    }

    @Override // i.b.b2
    @x1
    @k.e.a.d
    public t x0(@k.e.a.d v vVar) {
        return o2.a;
    }
}
