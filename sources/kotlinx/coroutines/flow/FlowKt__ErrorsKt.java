package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.mobads.sdk.internal.bp;
import com.huawei.hms.push.e;
import com.meizu.cloud.pushsdk.notification.model.NotifyType;
import e.j.a.b.c.f;
import h.e2.c;
import h.i;
import h.k2.u.l;
import h.k2.u.p;
import h.k2.u.q;
import h.k2.u.r;
import h.k2.v.f0;
import h.q0;
import h.t1;
import i.b.b2;
import i.b.s1;
import i.b.v3.h;
import i.b.w3.h0;
import k.e.a.d;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000v\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aj\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012B\u0010\f\u001a>\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0002¢\u0006\u0002\b\u000bø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000e\u001aI\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00012\u0014\b\u0002\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00110\u0010H\u0007¢\u0006\u0004\b\u0013\u0010\u0014\u001ae\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\b\u0002\u0010\u0016\u001a\u00020\u001523\b\u0002\u0010\u0012\u001a-\b\u0001\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\b\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0017ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u001aE\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\b\u0002\u0010\u0016\u001a\u00020\u001a2\u0014\b\u0002\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00110\u0010H\u0007¢\u0006\u0004\b\u001b\u0010\u001c\u001a\u007f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012W\u0010\u0012\u001aS\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\b\u0012\u0006\u0012\u0004\u0018\u00010\n0\u001d¢\u0006\u0002\b\u000bø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 \u001a3\u0010\"\u001a\u0004\u0018\u00010\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0080@ø\u0001\u0000¢\u0006\u0004\b\"\u0010#\u001a\u001b\u0010&\u001a\u00020\u0011*\u00020\u00042\u0006\u0010%\u001a\u00020$H\u0002¢\u0006\u0004\b&\u0010'\u001a\u001d\u0010)\u001a\u00020\u0011*\u00020\u00042\b\u0010(\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b)\u0010**\\\b\u0007\u00106\"\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00110\u00102\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00110\u0010B6\b+\u0012\n\b,\u0012\u0006\b\n0-8.\u0012\b\b/\u0012\u0004\b\b(0\u0012\u001c\b1\u0012\u0018\b\u000bB\u0014\b2\u0012\u0006\b3\u0012\u0002\b\f\u0012\b\b4\u0012\u0004\b\b(5\u0082\u0002\u0004\n\u0002\b\u0019¨\u00067"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Function3;", "Li/b/v3/f;", "", "Lh/k0;", "name", "cause", "Lh/e2/c;", "Lh/t1;", "", "Lh/q;", "action", "b", "(Lkotlinx/coroutines/flow/Flow;Lh/k2/u/q;)Lkotlinx/coroutines/flow/Flow;", "fallback", "Lkotlin/Function1;", "", "predicate", "f", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lh/k2/u/l;)Lkotlinx/coroutines/flow/Flow;", "", "retries", "Lkotlin/Function2;", "i", "(Lkotlinx/coroutines/flow/Flow;JLh/k2/u/p;)Lkotlinx/coroutines/flow/Flow;", "", "h", "(Lkotlinx/coroutines/flow/Flow;ILh/k2/u/l;)Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Function4;", "attempt", NotifyType.LIGHTS, "(Lkotlinx/coroutines/flow/Flow;Lh/k2/u/r;)Lkotlinx/coroutines/flow/Flow;", "collector", "c", "(Lkotlinx/coroutines/flow/Flow;Li/b/v3/f;Lh/e2/c;)Ljava/lang/Object;", "Lkotlin/coroutines/CoroutineContext;", "coroutineContext", f.f10128d, "(Ljava/lang/Throwable;Lkotlin/coroutines/CoroutineContext;)Z", "other", e.a, "(Ljava/lang/Throwable;Ljava/lang/Throwable;)Z", "Lh/i;", "level", "Lkotlin/DeprecationLevel;", bp.f1533l, "message", "Use (Throwable) -> Boolean functional type", "replaceWith", "Lh/q0;", "imports", "expression", "(Throwable) -> Boolean", "ExceptionPredicate", "kotlinx-coroutines-core"}, k = 5, mv = {1, 4, 0}, xs = "kotlinx/coroutines/flow/FlowKt")
/* loaded from: classes4.dex */
public final /* synthetic */ class FlowKt__ErrorsKt {
    @i(level = DeprecationLevel.ERROR, message = "Use (Throwable) -> Boolean functional type", replaceWith = @q0(expression = "(Throwable) -> Boolean", imports = {}))
    public static /* synthetic */ void a() {
    }

    @d
    public static final <T> Flow<T> b(@d Flow<? extends T> flow, @d q<? super i.b.v3.f<? super T>, ? super Throwable, ? super c<? super t1>, ? extends Object> qVar) {
        return new FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1(flow, qVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0044  */
    @k.e.a.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <T> java.lang.Object c(@k.e.a.d kotlinx.coroutines.flow.Flow<? extends T> r5, @k.e.a.d i.b.v3.f<? super T> r6, @k.e.a.d h.e2.c<? super java.lang.Throwable> r7) {
        /*
            boolean r0 = r7 instanceof kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$1
            if (r0 == 0) goto L13
            r0 = r7
            kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$1 r0 = (kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$1 r0 = new kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = h.e2.j.b.h()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L44
            if (r2 != r4) goto L3c
            java.lang.Object r5 = r0.L$3
            kotlinx.coroutines.flow.Flow r5 = (kotlinx.coroutines.flow.Flow) r5
            java.lang.Object r5 = r0.L$2
            kotlin.jvm.internal.Ref$ObjectRef r5 = (kotlin.jvm.internal.Ref.ObjectRef) r5
            java.lang.Object r6 = r0.L$1
            i.b.v3.f r6 = (i.b.v3.f) r6
            java.lang.Object r6 = r0.L$0
            kotlinx.coroutines.flow.Flow r6 = (kotlinx.coroutines.flow.Flow) r6
            h.r0.n(r7)     // Catch: java.lang.Throwable -> L3a
            goto L64
        L3a:
            r6 = move-exception
            goto L67
        L3c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L44:
            h.r0.n(r7)
            kotlin.jvm.internal.Ref$ObjectRef r7 = new kotlin.jvm.internal.Ref$ObjectRef
            r7.<init>()
            r7.element = r3
            kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$$inlined$collect$1 r2 = new kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$$inlined$collect$1     // Catch: java.lang.Throwable -> L65
            r2.<init>(r6, r7)     // Catch: java.lang.Throwable -> L65
            r0.L$0 = r5     // Catch: java.lang.Throwable -> L65
            r0.L$1 = r6     // Catch: java.lang.Throwable -> L65
            r0.L$2 = r7     // Catch: java.lang.Throwable -> L65
            r0.L$3 = r5     // Catch: java.lang.Throwable -> L65
            r0.label = r4     // Catch: java.lang.Throwable -> L65
            java.lang.Object r5 = r5.e(r2, r0)     // Catch: java.lang.Throwable -> L65
            if (r5 != r1) goto L64
            return r1
        L64:
            return r3
        L65:
            r6 = move-exception
            r5 = r7
        L67:
            T r5 = r5.element
            java.lang.Throwable r5 = (java.lang.Throwable) r5
            boolean r5 = e(r6, r5)
            if (r5 != 0) goto L7c
            kotlin.coroutines.CoroutineContext r5 = r0.getContext()
            boolean r5 = d(r6, r5)
            if (r5 != 0) goto L7c
            return r6
        L7c:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ErrorsKt.c(kotlinx.coroutines.flow.Flow, i.b.v3.f, h.e2.c):java.lang.Object");
    }

    private static final boolean d(Throwable th, CoroutineContext coroutineContext) {
        b2 b2Var = (b2) coroutineContext.get(b2.y0);
        if (b2Var == null || !b2Var.isCancelled()) {
            return false;
        }
        return e(th, b2Var.q());
    }

    private static final boolean e(Throwable th, Throwable th2) {
        if (th2 != null) {
            if (i.b.q0.e()) {
                th2 = h0.t(th2);
            }
            if (i.b.q0.e()) {
                th = h0.t(th);
            }
            if (f0.g(th2, th)) {
                return true;
            }
        }
        return false;
    }

    @i(level = DeprecationLevel.ERROR, message = "Use catch { e -> if (predicate(e)) emitAll(fallback) else throw e }", replaceWith = @q0(expression = "catch { e -> if (predicate(e)) emitAll(fallback) else throw e }", imports = {}))
    @d
    public static final <T> Flow<T> f(@d Flow<? extends T> flow, @d Flow<? extends T> flow2, @d l<? super Throwable, Boolean> lVar) {
        return h.w(flow, new FlowKt__ErrorsKt$onErrorCollect$2(lVar, flow2, null));
    }

    public static /* synthetic */ Flow g(Flow flow, Flow flow2, l lVar, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            lVar = FlowKt__ErrorsKt$onErrorCollect$1.INSTANCE;
        }
        return h.o1(flow, flow2, lVar);
    }

    @s1
    @i(level = DeprecationLevel.HIDDEN, message = "binary compatibility with retries: Int preview version")
    @d
    public static final /* synthetic */ <T> Flow<T> h(@d Flow<? extends T> flow, int i2, @d l<? super Throwable, Boolean> lVar) {
        if (i2 > 0) {
            return h.J1(flow, new FlowKt__ErrorsKt$retry$6(i2, lVar, null));
        }
        throw new IllegalArgumentException(("Expected positive amount of retries, but had " + i2).toString());
    }

    @d
    public static final <T> Flow<T> i(@d Flow<? extends T> flow, long j2, @d p<? super Throwable, ? super c<? super Boolean>, ? extends Object> pVar) {
        if (j2 > 0) {
            return h.J1(flow, new FlowKt__ErrorsKt$retry$3(j2, pVar, null));
        }
        throw new IllegalArgumentException(("Expected positive amount of retries, but had " + j2).toString());
    }

    public static /* synthetic */ Flow j(Flow flow, int i2, l lVar, int i3, Object obj) {
        Flow h2;
        if ((i3 & 1) != 0) {
            i2 = Integer.MAX_VALUE;
        }
        if ((i3 & 2) != 0) {
            lVar = FlowKt__ErrorsKt$retry$4.INSTANCE;
        }
        h2 = h(flow, i2, lVar);
        return h2;
    }

    public static /* synthetic */ Flow k(Flow flow, long j2, p pVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j2 = Long.MAX_VALUE;
        }
        if ((i2 & 2) != 0) {
            pVar = new FlowKt__ErrorsKt$retry$1(null);
        }
        return h.G1(flow, j2, pVar);
    }

    @d
    public static final <T> Flow<T> l(@d Flow<? extends T> flow, @d r<? super i.b.v3.f<? super T>, ? super Throwable, ? super Long, ? super c<? super Boolean>, ? extends Object> rVar) {
        return new FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1(flow, rVar);
    }
}
