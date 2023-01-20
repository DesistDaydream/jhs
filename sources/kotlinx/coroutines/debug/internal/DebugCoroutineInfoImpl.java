package kotlinx.coroutines.debug.internal;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.huawei.hms.push.e;
import com.umeng.analytics.pro.am;
import e.j.a.b.c.f;
import h.k2.d;
import h.k2.v.f0;
import h.q2.q;
import i.b.u3.b.c;
import i.b.u3.b.g;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.sequences.SequencesKt___SequencesKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0018\u0012\b\u0010\"\u001a\u0004\u0018\u00010\u001e\u0012\u0006\u0010*\u001a\u00020(¢\u0006\u0004\b2\u00103J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0006\u0010\u0005J'\u0010\u000b\u001a\u00020\n*\b\u0012\u0004\u0012\u00020\u00030\u00072\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0082Pø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fJ#\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r2\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\u000fH\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0015\u0010\u001b\u001a\u0004\u0018\u00010\u00188F@\u0006¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\u000e\u001a\u00020\r8F@\u0006¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0013R\u001e\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u00148\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0016R\u001b\u0010\"\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001f\u001a\u0004\b \u0010!R(\u0010'\u001a\u0004\u0018\u00010\b2\b\u0010#\u001a\u0004\u0018\u00010\b8@@@X\u0080\u000e¢\u0006\f\u001a\u0004\b\u0015\u0010$\"\u0004\b%\u0010&R\u0016\u0010*\u001a\u00020(8\u0000@\u0001X\u0081\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010)R\u0016\u0010,\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010+R\u0019\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028F@\u0006¢\u0006\u0006\u001a\u0004\b-\u0010\u0005R\u0018\u00101\u001a\u0004\u0018\u00010/8\u0000@\u0000X\u0081\u000e¢\u0006\u0006\n\u0004\b-\u00100\u0082\u0002\u0004\n\u0002\b\u0019¨\u00064"}, d2 = {"Lkotlinx/coroutines/debug/internal/DebugCoroutineInfoImpl;", "", "", "Ljava/lang/StackTraceElement;", am.av, "()Ljava/util/List;", "f", "Lh/q2/o;", "Lh/e2/k/a/c;", TypedValues.Attributes.S_FRAME, "Lh/t1;", "i", "(Lh/q2/o;Lh/e2/k/a/c;Lh/e2/c;)Ljava/lang/Object;", "", "state", "Lh/e2/c;", "h", "(Ljava/lang/String;Lh/e2/c;)V", "toString", "()Ljava/lang/String;", "Ljava/lang/ref/WeakReference;", f.f10128d, "Ljava/lang/ref/WeakReference;", "_lastObservedFrame", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "context", e.a, "_context", "Li/b/u3/b/g;", "Li/b/u3/b/g;", "b", "()Li/b/u3/b/g;", "creationStackBottom", "value", "()Lh/e2/k/a/c;", "g", "(Lh/e2/k/a/c;)V", "lastObservedFrame", "", "J", "sequenceNumber", "Ljava/lang/String;", "_state", "c", "creationStackTrace", "Ljava/lang/Thread;", "Ljava/lang/Thread;", "lastObservedThread", "<init>", "(Lkotlin/coroutines/CoroutineContext;Li/b/u3/b/g;J)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class DebugCoroutineInfoImpl {
    private final WeakReference<CoroutineContext> a;
    private String b = c.a;
    @d
    @k.e.a.e

    /* renamed from: c  reason: collision with root package name */
    public Thread f16932c;

    /* renamed from: d  reason: collision with root package name */
    private WeakReference<h.e2.k.a.c> f16933d;
    @k.e.a.e

    /* renamed from: e  reason: collision with root package name */
    private final g f16934e;
    @d

    /* renamed from: f  reason: collision with root package name */
    public final long f16935f;

    public DebugCoroutineInfoImpl(@k.e.a.e CoroutineContext coroutineContext, @k.e.a.e g gVar, long j2) {
        this.f16934e = gVar;
        this.f16935f = j2;
        this.a = new WeakReference<>(coroutineContext);
    }

    private final List<StackTraceElement> a() {
        g gVar = this.f16934e;
        if (gVar != null) {
            return SequencesKt___SequencesKt.V2(q.e(new DebugCoroutineInfoImpl$creationStackTrace$1(this, gVar, null)));
        }
        return CollectionsKt__CollectionsKt.E();
    }

    @k.e.a.e
    public final g b() {
        return this.f16934e;
    }

    @k.e.a.d
    public final List<StackTraceElement> c() {
        return a();
    }

    @k.e.a.e
    public final h.e2.k.a.c d() {
        WeakReference<h.e2.k.a.c> weakReference = this.f16933d;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @k.e.a.d
    public final String e() {
        return this.b;
    }

    @k.e.a.d
    public final List<StackTraceElement> f() {
        h.e2.k.a.c d2 = d();
        if (d2 != null) {
            ArrayList arrayList = new ArrayList();
            while (d2 != null) {
                StackTraceElement stackTraceElement = d2.getStackTraceElement();
                if (stackTraceElement != null) {
                    arrayList.add(stackTraceElement);
                }
                d2 = d2.getCallerFrame();
            }
            return arrayList;
        }
        return CollectionsKt__CollectionsKt.E();
    }

    public final void g(@k.e.a.e h.e2.k.a.c cVar) {
        this.f16933d = cVar != null ? new WeakReference<>(cVar) : null;
    }

    @k.e.a.e
    public final CoroutineContext getContext() {
        return this.a.get();
    }

    public final void h(@k.e.a.d String str, @k.e.a.d h.e2.c<?> cVar) {
        if (f0.g(this.b, str) && f0.g(str, c.f15858c) && d() != null) {
            return;
        }
        this.b = str;
        if (!(cVar instanceof h.e2.k.a.c)) {
            cVar = null;
        }
        g((h.e2.k.a.c) cVar);
        this.f16932c = f0.g(str, c.b) ? Thread.currentThread() : null;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x006e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x004e -> B:25:0x0067). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0061 -> B:24:0x0064). Please submit an issue!!! */
    @k.e.a.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final /* synthetic */ java.lang.Object i(@k.e.a.d h.q2.o<? super java.lang.StackTraceElement> r6, @k.e.a.e h.e2.k.a.c r7, @k.e.a.d h.e2.c<? super h.t1> r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof kotlinx.coroutines.debug.internal.DebugCoroutineInfoImpl$yieldFrames$1
            if (r0 == 0) goto L13
            r0 = r8
            kotlinx.coroutines.debug.internal.DebugCoroutineInfoImpl$yieldFrames$1 r0 = (kotlinx.coroutines.debug.internal.DebugCoroutineInfoImpl$yieldFrames$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.debug.internal.DebugCoroutineInfoImpl$yieldFrames$1 r0 = new kotlinx.coroutines.debug.internal.DebugCoroutineInfoImpl$yieldFrames$1
            r0.<init>(r5, r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = h.e2.j.b.h()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L41
            if (r2 != r3) goto L39
            java.lang.Object r6 = r0.L$3
            java.lang.StackTraceElement r6 = (java.lang.StackTraceElement) r6
            java.lang.Object r6 = r0.L$2
            h.e2.k.a.c r6 = (h.e2.k.a.c) r6
            java.lang.Object r7 = r0.L$1
            h.q2.o r7 = (h.q2.o) r7
            java.lang.Object r2 = r0.L$0
            kotlinx.coroutines.debug.internal.DebugCoroutineInfoImpl r2 = (kotlinx.coroutines.debug.internal.DebugCoroutineInfoImpl) r2
            h.r0.n(r8)
            goto L64
        L39:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L41:
            h.r0.n(r8)
            r2 = r5
        L45:
            if (r7 != 0) goto L4a
            h.t1 r6 = h.t1.a
            return r6
        L4a:
            java.lang.StackTraceElement r8 = r7.getStackTraceElement()
            if (r8 == 0) goto L67
            r0.L$0 = r2
            r0.L$1 = r6
            r0.L$2 = r7
            r0.L$3 = r8
            r0.label = r3
            java.lang.Object r8 = r6.d(r8, r0)
            if (r8 != r1) goto L61
            return r1
        L61:
            r4 = r7
            r7 = r6
            r6 = r4
        L64:
            r4 = r7
            r7 = r6
            r6 = r4
        L67:
            h.e2.k.a.c r7 = r7.getCallerFrame()
            if (r7 == 0) goto L6e
            goto L45
        L6e:
            h.t1 r6 = h.t1.a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.debug.internal.DebugCoroutineInfoImpl.i(h.q2.o, h.e2.k.a.c, h.e2.c):java.lang.Object");
    }

    @k.e.a.d
    public String toString() {
        return "DebugCoroutineInfo(state=" + e() + ",context=" + getContext() + ')';
    }
}
