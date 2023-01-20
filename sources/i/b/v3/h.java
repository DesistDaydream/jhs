package i.b.v3;

import h.a2.i0;
import h.j0;
import h.p0;
import h.q0;
import h.t1;
import i.b.b2;
import i.b.n0;
import i.b.r1;
import i.b.s1;
import i.b.t3.c0;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt__BuildersKt;
import kotlinx.coroutines.flow.FlowKt__ChannelsKt;
import kotlinx.coroutines.flow.FlowKt__CollectKt;
import kotlinx.coroutines.flow.FlowKt__CollectionKt;
import kotlinx.coroutines.flow.FlowKt__CountKt;
import kotlinx.coroutines.flow.FlowKt__DelayKt;
import kotlinx.coroutines.flow.FlowKt__DistinctKt;
import kotlinx.coroutines.flow.FlowKt__EmittersKt;
import kotlinx.coroutines.flow.FlowKt__ErrorsKt;
import kotlinx.coroutines.flow.FlowKt__LimitKt;
import kotlinx.coroutines.flow.FlowKt__MergeKt;
import kotlinx.coroutines.flow.FlowKt__MigrationKt;
import kotlinx.coroutines.flow.FlowKt__ReduceKt;
import kotlinx.coroutines.flow.FlowKt__ShareKt;
import kotlinx.coroutines.flow.FlowKt__TransformKt;
import kotlinx.coroutines.flow.FlowKt__ZipKt;

@Metadata(bv = {1, 0, 3}, d1 = {"kotlinx/coroutines/flow/FlowKt__BuildersKt", "kotlinx/coroutines/flow/FlowKt__ChannelsKt", "kotlinx/coroutines/flow/FlowKt__CollectKt", "kotlinx/coroutines/flow/FlowKt__CollectionKt", "i/b/v3/i", "kotlinx/coroutines/flow/FlowKt__CountKt", "kotlinx/coroutines/flow/FlowKt__DelayKt", "kotlinx/coroutines/flow/FlowKt__DistinctKt", "kotlinx/coroutines/flow/FlowKt__EmittersKt", "kotlinx/coroutines/flow/FlowKt__ErrorsKt", "kotlinx/coroutines/flow/FlowKt__LimitKt", "kotlinx/coroutines/flow/FlowKt__MergeKt", "kotlinx/coroutines/flow/FlowKt__MigrationKt", "kotlinx/coroutines/flow/FlowKt__ReduceKt", "kotlinx/coroutines/flow/FlowKt__ShareKt", "kotlinx/coroutines/flow/FlowKt__TransformKt", "kotlinx/coroutines/flow/FlowKt__ZipKt"}, d2 = {}, k = 4, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class h {
    @k.e.a.d
    public static final String a = "kotlinx.coroutines.flow.defaultConcurrency";

    @k.e.a.e
    public static final <T> Object A(@k.e.a.d Flow<? extends T> flow, @k.e.a.d h.k2.u.p<? super T, ? super h.e2.c<? super t1>, ? extends Object> pVar, @k.e.a.d h.e2.c<? super t1> cVar) {
        return FlowKt__CollectKt.b(flow, pVar, cVar);
    }

    @k.e.a.e
    public static final <T> Object A0(@k.e.a.d Flow<? extends T> flow, @k.e.a.d h.e2.c<? super T> cVar) {
        return FlowKt__ReduceKt.c(flow, cVar);
    }

    @h.i(level = DeprecationLevel.ERROR, message = "Collect flow in the desired context instead")
    @k.e.a.d
    public static final <T> Flow<T> A1(@k.e.a.d Flow<? extends T> flow, @k.e.a.d CoroutineContext coroutineContext) {
        return FlowKt__MigrationKt.y(flow, coroutineContext);
    }

    @k.e.a.e
    private static final Object B(@k.e.a.d Flow flow, @k.e.a.d h.k2.u.p pVar, @k.e.a.d h.e2.c cVar) {
        return FlowKt__CollectKt.b(flow, pVar, cVar);
    }

    @k.e.a.e
    public static final <T> Object B0(@k.e.a.d Flow<? extends T> flow, @k.e.a.d h.k2.u.p<? super T, ? super h.e2.c<? super Boolean>, ? extends Object> pVar, @k.e.a.d h.e2.c<? super T> cVar) {
        return FlowKt__ReduceKt.d(flow, pVar, cVar);
    }

    @k.e.a.d
    public static final <T> Flow<T> B1(@k.e.a.d i.b.t3.y<? extends T> yVar) {
        return FlowKt__ChannelsKt.h(yVar);
    }

    @k.e.a.e
    public static final <T> Object C(@k.e.a.d Flow<? extends T> flow, @k.e.a.d h.k2.u.q<? super Integer, ? super T, ? super h.e2.c<? super t1>, ? extends Object> qVar, @k.e.a.d h.e2.c<? super t1> cVar) {
        return FlowKt__CollectKt.d(flow, qVar, cVar);
    }

    @k.e.a.d
    public static final i.b.t3.y<t1> C0(@k.e.a.d n0 n0Var, long j2, long j3) {
        return FlowKt__DelayKt.f(n0Var, j2, j3);
    }

    @k.e.a.e
    public static final <S, T extends S> Object C1(@k.e.a.d Flow<? extends T> flow, @k.e.a.d h.k2.u.q<? super S, ? super T, ? super h.e2.c<? super S>, ? extends Object> qVar, @k.e.a.d h.e2.c<? super S> cVar) {
        return FlowKt__ReduceKt.g(flow, qVar, cVar);
    }

    @k.e.a.e
    private static final Object D(@k.e.a.d Flow flow, @k.e.a.d h.k2.u.q qVar, @k.e.a.d h.e2.c cVar) {
        return FlowKt__CollectKt.d(flow, qVar, cVar);
    }

    @h.i(level = DeprecationLevel.ERROR, message = "Flow analogue of 'replay()' is 'shareIn' with unlimited replay. \nreplay().connect() is the default strategy (no extra call is needed), \nreplay().autoConnect() translates to 'started = SharingStared.Lazily' argument, \nreplay().refCount() translates to 'started = SharingStared.WhileSubscribed()' argument.", replaceWith = @q0(expression = "this.shareIn(scope, Int.MAX_VALUE)", imports = {}))
    @k.e.a.d
    public static final <T> Flow<T> D1(@k.e.a.d Flow<? extends T> flow) {
        return FlowKt__MigrationKt.z(flow);
    }

    @k.e.a.e
    public static final <T> Object E(@k.e.a.d Flow<? extends T> flow, @k.e.a.d h.k2.u.p<? super T, ? super h.e2.c<? super t1>, ? extends Object> pVar, @k.e.a.d h.e2.c<? super t1> cVar) {
        return FlowKt__CollectKt.f(flow, pVar, cVar);
    }

    @h.i(level = DeprecationLevel.ERROR, message = "Flow analogue is 'flatMapConcat'", replaceWith = @q0(expression = "flatMapConcat(mapper)", imports = {}))
    @k.e.a.d
    public static final <T, R> Flow<R> E0(@k.e.a.d Flow<? extends T> flow, @k.e.a.d h.k2.u.p<? super T, ? super h.e2.c<? super Flow<? extends R>>, ? extends Object> pVar) {
        return FlowKt__MigrationKt.l(flow, pVar);
    }

    @h.i(level = DeprecationLevel.ERROR, message = "Flow analogue of 'replay(bufferSize)' is 'shareIn' with the specified replay parameter. \nreplay().connect() is the default strategy (no extra call is needed), \nreplay().autoConnect() translates to 'started = SharingStared.Lazily' argument, \nreplay().refCount() translates to 'started = SharingStared.WhileSubscribed()' argument.", replaceWith = @q0(expression = "this.shareIn(scope, bufferSize)", imports = {}))
    @k.e.a.d
    public static final <T> Flow<T> E1(@k.e.a.d Flow<? extends T> flow, int i2) {
        return FlowKt__MigrationKt.A(flow, i2);
    }

    @k.e.a.e
    public static final <T> Object F(@k.e.a.d Flow<? extends T> flow, @k.e.a.d h.k2.u.p<? super T, ? super h.e2.c<? super Boolean>, ? extends Object> pVar, @k.e.a.d h.e2.c<? super t1> cVar) {
        return FlowKt__LimitKt.a(flow, pVar, cVar);
    }

    @s1
    @k.e.a.d
    public static final <T, R> Flow<R> F0(@k.e.a.d Flow<? extends T> flow, @k.e.a.d h.k2.u.p<? super T, ? super h.e2.c<? super Flow<? extends R>>, ? extends Object> pVar) {
        return FlowKt__MergeKt.a(flow, pVar);
    }

    @k.e.a.e
    private static final Object G(@k.e.a.d Flow flow, @k.e.a.d h.k2.u.p pVar, @k.e.a.d h.e2.c cVar) {
        return FlowKt__LimitKt.a(flow, pVar, cVar);
    }

    @r1
    @k.e.a.d
    public static final <T, R> Flow<R> G0(@k.e.a.d Flow<? extends T> flow, @h.b @k.e.a.d h.k2.u.p<? super T, ? super h.e2.c<? super Flow<? extends R>>, ? extends Object> pVar) {
        return FlowKt__MergeKt.b(flow, pVar);
    }

    @k.e.a.d
    public static final <T> Flow<T> G1(@k.e.a.d Flow<? extends T> flow, long j2, @k.e.a.d h.k2.u.p<? super Throwable, ? super h.e2.c<? super Boolean>, ? extends Object> pVar) {
        return FlowKt__ErrorsKt.i(flow, j2, pVar);
    }

    @s1
    @k.e.a.d
    public static final <T, R> Flow<R> H0(@k.e.a.d Flow<? extends T> flow, int i2, @k.e.a.d h.k2.u.p<? super T, ? super h.e2.c<? super Flow<? extends R>>, ? extends Object> pVar) {
        return FlowKt__MergeKt.c(flow, i2, pVar);
    }

    @k.e.a.d
    public static final <T1, T2, R> Flow<R> I(@k.e.a.d Flow<? extends T1> flow, @k.e.a.d Flow<? extends T2> flow2, @k.e.a.d h.k2.u.q<? super T1, ? super T2, ? super h.e2.c<? super R>, ? extends Object> qVar) {
        return FlowKt__ZipKt.c(flow, flow2, qVar);
    }

    @k.e.a.d
    public static final <T1, T2, T3, R> Flow<R> J(@k.e.a.d Flow<? extends T1> flow, @k.e.a.d Flow<? extends T2> flow2, @k.e.a.d Flow<? extends T3> flow3, @h.b @k.e.a.d h.k2.u.r<? super T1, ? super T2, ? super T3, ? super h.e2.c<? super R>, ? extends Object> rVar) {
        return FlowKt__ZipKt.d(flow, flow2, flow3, rVar);
    }

    @h.i(level = DeprecationLevel.ERROR, message = "Flow analogue of 'flatten' is 'flattenConcat'", replaceWith = @q0(expression = "flattenConcat()", imports = {}))
    @k.e.a.d
    public static final <T> Flow<T> J0(@k.e.a.d Flow<? extends Flow<? extends T>> flow) {
        return FlowKt__MigrationKt.m(flow);
    }

    @k.e.a.d
    public static final <T> Flow<T> J1(@k.e.a.d Flow<? extends T> flow, @k.e.a.d h.k2.u.r<? super f<? super T>, ? super Throwable, ? super Long, ? super h.e2.c<? super Boolean>, ? extends Object> rVar) {
        return FlowKt__ErrorsKt.l(flow, rVar);
    }

    @k.e.a.d
    public static final <T1, T2, T3, T4, R> Flow<R> K(@k.e.a.d Flow<? extends T1> flow, @k.e.a.d Flow<? extends T2> flow2, @k.e.a.d Flow<? extends T3> flow3, @k.e.a.d Flow<? extends T4> flow4, @k.e.a.d h.k2.u.s<? super T1, ? super T2, ? super T3, ? super T4, ? super h.e2.c<? super R>, ? extends Object> sVar) {
        return FlowKt__ZipKt.e(flow, flow2, flow3, flow4, sVar);
    }

    @s1
    @k.e.a.d
    public static final <T> Flow<T> K0(@k.e.a.d Flow<? extends Flow<? extends T>> flow) {
        return FlowKt__MergeKt.e(flow);
    }

    @r1
    @k.e.a.d
    public static final <T> Flow<T> K1(@k.e.a.d Flow<? extends T> flow, @k.e.a.d h.k2.u.q<? super T, ? super T, ? super h.e2.c<? super T>, ? extends Object> qVar) {
        return FlowKt__TransformKt.h(flow, qVar);
    }

    @k.e.a.d
    public static final <T1, T2, T3, T4, T5, R> Flow<R> L(@k.e.a.d Flow<? extends T1> flow, @k.e.a.d Flow<? extends T2> flow2, @k.e.a.d Flow<? extends T3> flow3, @k.e.a.d Flow<? extends T4> flow4, @k.e.a.d Flow<? extends T5> flow5, @k.e.a.d h.k2.u.t<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super h.e2.c<? super R>, ? extends Object> tVar) {
        return FlowKt__ZipKt.f(flow, flow2, flow3, flow4, flow5, tVar);
    }

    @s1
    @k.e.a.d
    public static final <T> Flow<T> L0(@k.e.a.d Flow<? extends Flow<? extends T>> flow, int i2) {
        return FlowKt__MergeKt.f(flow, i2);
    }

    @s1
    @k.e.a.d
    public static final <T> Flow<T> L1(@k.e.a.d Flow<? extends T> flow, long j2) {
        return FlowKt__DelayKt.h(flow, j2);
    }

    @h.u2.j
    @s1
    @k.e.a.d
    public static final <T> Flow<T> M1(@k.e.a.d Flow<? extends T> flow, double d2) {
        return FlowKt__DelayKt.i(flow, d2);
    }

    @h.i(level = DeprecationLevel.ERROR, message = "Flow analogue of 'combineLatest' is 'combine'", replaceWith = @q0(expression = "this.combine(other, transform)", imports = {}))
    @k.e.a.d
    public static final <T1, T2, R> Flow<R> N(@k.e.a.d Flow<? extends T1> flow, @k.e.a.d Flow<? extends T2> flow2, @k.e.a.d h.k2.u.q<? super T1, ? super T2, ? super h.e2.c<? super R>, ? extends Object> qVar) {
        return FlowKt__MigrationKt.b(flow, flow2, qVar);
    }

    @k.e.a.d
    public static final <T> Flow<T> N0(@h.b @k.e.a.d h.k2.u.p<? super f<? super T>, ? super h.e2.c<? super t1>, ? extends Object> pVar) {
        return FlowKt__BuildersKt.n(pVar);
    }

    @r1
    @k.e.a.d
    public static final <T, R> Flow<R> N1(@k.e.a.d Flow<? extends T> flow, R r, @h.b @k.e.a.d h.k2.u.q<? super R, ? super T, ? super h.e2.c<? super R>, ? extends Object> qVar) {
        return FlowKt__TransformKt.i(flow, r, qVar);
    }

    @h.i(level = DeprecationLevel.ERROR, message = "Flow analogue of 'combineLatest' is 'combine'", replaceWith = @q0(expression = "combine(this, other, other2, transform)", imports = {}))
    @k.e.a.d
    public static final <T1, T2, T3, R> Flow<R> O(@k.e.a.d Flow<? extends T1> flow, @k.e.a.d Flow<? extends T2> flow2, @k.e.a.d Flow<? extends T3> flow3, @k.e.a.d h.k2.u.r<? super T1, ? super T2, ? super T3, ? super h.e2.c<? super R>, ? extends Object> rVar) {
        return FlowKt__MigrationKt.c(flow, flow2, flow3, rVar);
    }

    @h.k2.g(name = "flowCombine")
    @k.e.a.d
    public static final <T1, T2, R> Flow<R> O0(@k.e.a.d Flow<? extends T1> flow, @k.e.a.d Flow<? extends T2> flow2, @k.e.a.d h.k2.u.q<? super T1, ? super T2, ? super h.e2.c<? super R>, ? extends Object> qVar) {
        return FlowKt__ZipKt.p(flow, flow2, qVar);
    }

    @h.i(level = DeprecationLevel.ERROR, message = "Flow has less verbose 'scan' shortcut", replaceWith = @q0(expression = "scan(initial, operation)", imports = {}))
    @k.e.a.d
    public static final <T, R> Flow<R> O1(@k.e.a.d Flow<? extends T> flow, R r, @h.b @k.e.a.d h.k2.u.q<? super R, ? super T, ? super h.e2.c<? super R>, ? extends Object> qVar) {
        return FlowKt__MigrationKt.B(flow, r, qVar);
    }

    @h.i(level = DeprecationLevel.ERROR, message = "Flow analogue of 'combineLatest' is 'combine'", replaceWith = @q0(expression = "combine(this, other, other2, other3, transform)", imports = {}))
    @k.e.a.d
    public static final <T1, T2, T3, T4, R> Flow<R> P(@k.e.a.d Flow<? extends T1> flow, @k.e.a.d Flow<? extends T2> flow2, @k.e.a.d Flow<? extends T3> flow3, @k.e.a.d Flow<? extends T4> flow4, @k.e.a.d h.k2.u.s<? super T1, ? super T2, ? super T3, ? super T4, ? super h.e2.c<? super R>, ? extends Object> sVar) {
        return FlowKt__MigrationKt.d(flow, flow2, flow3, flow4, sVar);
    }

    @h.k2.g(name = "flowCombineTransform")
    @k.e.a.d
    public static final <T1, T2, R> Flow<R> P0(@k.e.a.d Flow<? extends T1> flow, @k.e.a.d Flow<? extends T2> flow2, @h.b @k.e.a.d h.k2.u.r<? super f<? super R>, ? super T1, ? super T2, ? super h.e2.c<? super t1>, ? extends Object> rVar) {
        return FlowKt__ZipKt.q(flow, flow2, rVar);
    }

    @h.i(level = DeprecationLevel.WARNING, message = "'scanReduce' was renamed to 'runningReduce' to be consistent with Kotlin standard library", replaceWith = @q0(expression = "runningReduce(operation)", imports = {}))
    @k.e.a.d
    public static final <T> Flow<T> P1(@k.e.a.d Flow<? extends T> flow, @k.e.a.d h.k2.u.q<? super T, ? super T, ? super h.e2.c<? super T>, ? extends Object> qVar) {
        return FlowKt__MigrationKt.C(flow, qVar);
    }

    @h.i(level = DeprecationLevel.ERROR, message = "Flow analogue of 'combineLatest' is 'combine'", replaceWith = @q0(expression = "combine(this, other, other2, other3, transform)", imports = {}))
    @k.e.a.d
    public static final <T1, T2, T3, T4, T5, R> Flow<R> Q(@k.e.a.d Flow<? extends T1> flow, @k.e.a.d Flow<? extends T2> flow2, @k.e.a.d Flow<? extends T3> flow3, @k.e.a.d Flow<? extends T4> flow4, @k.e.a.d Flow<? extends T5> flow5, @k.e.a.d h.k2.u.t<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super h.e2.c<? super R>, ? extends Object> tVar) {
        return FlowKt__MigrationKt.e(flow, flow2, flow3, flow4, flow5, tVar);
    }

    @k.e.a.d
    public static final <T> Flow<T> Q0(T t) {
        return FlowKt__BuildersKt.o(t);
    }

    @k.e.a.d
    public static final <T> p<T> Q1(@k.e.a.d Flow<? extends T> flow, @k.e.a.d n0 n0Var, @k.e.a.d u uVar, int i2) {
        return FlowKt__ShareKt.g(flow, n0Var, uVar, i2);
    }

    @k.e.a.d
    public static final <T> Flow<T> R0(@k.e.a.d T... tArr) {
        return FlowKt__BuildersKt.p(tArr);
    }

    @k.e.a.d
    public static final <T1, T2, R> Flow<R> S(@k.e.a.d Flow<? extends T1> flow, @k.e.a.d Flow<? extends T2> flow2, @h.b @k.e.a.d h.k2.u.r<? super f<? super R>, ? super T1, ? super T2, ? super h.e2.c<? super t1>, ? extends Object> rVar) {
        return FlowKt__ZipKt.i(flow, flow2, rVar);
    }

    @k.e.a.d
    public static final <T> Flow<T> S0(@k.e.a.d Flow<? extends T> flow, @k.e.a.d CoroutineContext coroutineContext) {
        return i.h(flow, coroutineContext);
    }

    @k.e.a.e
    public static final <T> Object S1(@k.e.a.d Flow<? extends T> flow, @k.e.a.d h.e2.c<? super T> cVar) {
        return FlowKt__ReduceKt.h(flow, cVar);
    }

    @k.e.a.d
    public static final <T1, T2, T3, R> Flow<R> T(@k.e.a.d Flow<? extends T1> flow, @k.e.a.d Flow<? extends T2> flow2, @k.e.a.d Flow<? extends T3> flow3, @h.b @k.e.a.d h.k2.u.s<? super f<? super R>, ? super T1, ? super T2, ? super T3, ? super h.e2.c<? super t1>, ? extends Object> sVar) {
        return FlowKt__ZipKt.j(flow, flow2, flow3, sVar);
    }

    @s1
    @h.i(level = DeprecationLevel.ERROR, message = "Use channelFlow with awaitClose { } instead of flowViaChannel and invokeOnClose { }.")
    @k.e.a.d
    public static final <T> Flow<T> T0(int i2, @h.b @k.e.a.d h.k2.u.p<? super n0, ? super c0<? super T>, t1> pVar) {
        return FlowKt__BuildersKt.q(i2, pVar);
    }

    @k.e.a.e
    public static final <T> Object T1(@k.e.a.d Flow<? extends T> flow, @k.e.a.d h.e2.c<? super T> cVar) {
        return FlowKt__ReduceKt.i(flow, cVar);
    }

    @k.e.a.d
    public static final <T1, T2, T3, T4, R> Flow<R> U(@k.e.a.d Flow<? extends T1> flow, @k.e.a.d Flow<? extends T2> flow2, @k.e.a.d Flow<? extends T3> flow3, @k.e.a.d Flow<? extends T4> flow4, @h.b @k.e.a.d h.k2.u.t<? super f<? super R>, ? super T1, ? super T2, ? super T3, ? super T4, ? super h.e2.c<? super t1>, ? extends Object> tVar) {
        return FlowKt__ZipKt.k(flow, flow2, flow3, flow4, tVar);
    }

    @h.i(level = DeprecationLevel.ERROR, message = "Flow analogue of 'skip' is 'drop'", replaceWith = @q0(expression = "drop(count)", imports = {}))
    @k.e.a.d
    public static final <T> Flow<T> U1(@k.e.a.d Flow<? extends T> flow, int i2) {
        return FlowKt__MigrationKt.D(flow, i2);
    }

    @k.e.a.d
    public static final <T1, T2, T3, T4, T5, R> Flow<R> V(@k.e.a.d Flow<? extends T1> flow, @k.e.a.d Flow<? extends T2> flow2, @k.e.a.d Flow<? extends T3> flow3, @k.e.a.d Flow<? extends T4> flow4, @k.e.a.d Flow<? extends T5> flow5, @h.b @k.e.a.d h.k2.u.u<? super f<? super R>, ? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super h.e2.c<? super t1>, ? extends Object> uVar) {
        return FlowKt__ZipKt.l(flow, flow2, flow3, flow4, flow5, uVar);
    }

    @s1
    @h.i(level = DeprecationLevel.ERROR, message = "flowWith is deprecated without replacement, please refer to its KDoc for an explanation")
    @k.e.a.d
    public static final <T, R> Flow<R> V0(@k.e.a.d Flow<? extends T> flow, @k.e.a.d CoroutineContext coroutineContext, int i2, @k.e.a.d h.k2.u.l<? super Flow<? extends T>, ? extends Flow<? extends R>> lVar) {
        return i.i(flow, coroutineContext, i2, lVar);
    }

    @h.i(level = DeprecationLevel.ERROR, message = "Flow analogue of 'startWith' is 'onStart'. Use 'onStart { emit(value) }'", replaceWith = @q0(expression = "onStart { emit(value) }", imports = {}))
    @k.e.a.d
    public static final <T> Flow<T> V1(@k.e.a.d Flow<? extends T> flow, T t) {
        return FlowKt__MigrationKt.E(flow, t);
    }

    @h.i(level = DeprecationLevel.ERROR, message = "Flow analogue of 'startWith' is 'onStart'. Use 'onStart { emitAll(other) }'", replaceWith = @q0(expression = "onStart { emitAll(other) }", imports = {}))
    @k.e.a.d
    public static final <T> Flow<T> W1(@k.e.a.d Flow<? extends T> flow, @k.e.a.d Flow<? extends T> flow2) {
        return FlowKt__MigrationKt.F(flow, flow2);
    }

    @h.i(level = DeprecationLevel.ERROR, message = "Flow analogue of 'compose' is 'let'", replaceWith = @q0(expression = "let(transformer)", imports = {}))
    @k.e.a.d
    public static final <T, R> Flow<R> X(@k.e.a.d Flow<? extends T> flow, @k.e.a.d h.k2.u.l<? super Flow<? extends T>, ? extends Flow<? extends R>> lVar) {
        return FlowKt__MigrationKt.f(flow, lVar);
    }

    @k.e.a.e
    public static final <T, R> Object X0(@k.e.a.d Flow<? extends T> flow, R r, @k.e.a.d h.k2.u.q<? super R, ? super T, ? super h.e2.c<? super R>, ? extends Object> qVar, @k.e.a.d h.e2.c<? super R> cVar) {
        return FlowKt__ReduceKt.e(flow, r, qVar, cVar);
    }

    @k.e.a.e
    public static final <T> Object X1(@k.e.a.d Flow<? extends T> flow, @k.e.a.d n0 n0Var, @k.e.a.d h.e2.c<? super x<? extends T>> cVar) {
        return FlowKt__ShareKt.i(flow, n0Var, cVar);
    }

    @h.i(level = DeprecationLevel.ERROR, message = "Flow analogue of 'concatMap' is 'flatMapConcat'", replaceWith = @q0(expression = "flatMapConcat(mapper)", imports = {}))
    @k.e.a.d
    public static final <T, R> Flow<R> Y(@k.e.a.d Flow<? extends T> flow, @k.e.a.d h.k2.u.l<? super T, ? extends Flow<? extends R>> lVar) {
        return FlowKt__MigrationKt.g(flow, lVar);
    }

    @k.e.a.e
    private static final Object Y0(@k.e.a.d Flow flow, Object obj, @k.e.a.d h.k2.u.q qVar, @k.e.a.d h.e2.c cVar) {
        return FlowKt__ReduceKt.e(flow, obj, qVar, cVar);
    }

    @k.e.a.d
    public static final <T> x<T> Y1(@k.e.a.d Flow<? extends T> flow, @k.e.a.d n0 n0Var, @k.e.a.d u uVar, T t) {
        return FlowKt__ShareKt.j(flow, n0Var, uVar, t);
    }

    @h.i(level = DeprecationLevel.ERROR, message = "Flow analogue of 'concatWith' is 'onCompletion'. Use 'onCompletion { emit(value) }'", replaceWith = @q0(expression = "onCompletion { emit(value) }", imports = {}))
    @k.e.a.d
    public static final <T> Flow<T> Z(@k.e.a.d Flow<? extends T> flow, T t) {
        return FlowKt__MigrationKt.h(flow, t);
    }

    @h.i(level = DeprecationLevel.ERROR, message = "Flow analogue of 'forEach' is 'collect'", replaceWith = @q0(expression = "collect(block)", imports = {}))
    public static final <T> void Z0(@k.e.a.d Flow<? extends T> flow, @k.e.a.d h.k2.u.p<? super T, ? super h.e2.c<? super t1>, ? extends Object> pVar) {
        FlowKt__MigrationKt.n(flow, pVar);
    }

    @h.i(level = DeprecationLevel.ERROR, message = "Use 'launchIn' with 'onEach', 'onCompletion' and 'catch' instead")
    public static final <T> void Z1(@k.e.a.d Flow<? extends T> flow) {
        FlowKt__MigrationKt.G(flow);
    }

    @k.e.a.d
    public static final <T> Flow<T> a(@k.e.a.d Iterable<? extends T> iterable) {
        return FlowKt__BuildersKt.a(iterable);
    }

    @h.i(level = DeprecationLevel.ERROR, message = "Flow analogue of 'concatWith' is 'onCompletion'. Use 'onCompletion { emitAll(other) }'", replaceWith = @q0(expression = "onCompletion { emitAll(other) }", imports = {}))
    @k.e.a.d
    public static final <T> Flow<T> a0(@k.e.a.d Flow<? extends T> flow, @k.e.a.d Flow<? extends T> flow2) {
        return FlowKt__MigrationKt.i(flow, flow2);
    }

    public static final int a1() {
        return FlowKt__MergeKt.h();
    }

    @h.i(level = DeprecationLevel.ERROR, message = "Use 'launchIn' with 'onEach', 'onCompletion' and 'catch' instead")
    public static final <T> void a2(@k.e.a.d Flow<? extends T> flow, @k.e.a.d h.k2.u.p<? super T, ? super h.e2.c<? super t1>, ? extends Object> pVar) {
        FlowKt__MigrationKt.H(flow, pVar);
    }

    @k.e.a.d
    public static final <T> Flow<T> b(@k.e.a.d Iterator<? extends T> it) {
        return FlowKt__BuildersKt.b(it);
    }

    @k.e.a.d
    public static final <T> Flow<T> b0(@k.e.a.d Flow<? extends T> flow) {
        return i.g(flow);
    }

    @s1
    public static /* synthetic */ void b1() {
    }

    @h.i(level = DeprecationLevel.ERROR, message = "Use 'launchIn' with 'onEach', 'onCompletion' and 'catch' instead")
    public static final <T> void b2(@k.e.a.d Flow<? extends T> flow, @k.e.a.d h.k2.u.p<? super T, ? super h.e2.c<? super t1>, ? extends Object> pVar, @k.e.a.d h.k2.u.p<? super Throwable, ? super h.e2.c<? super t1>, ? extends Object> pVar2) {
        FlowKt__MigrationKt.I(flow, pVar, pVar2);
    }

    @s1
    @k.e.a.d
    public static final <T> Flow<T> c(@k.e.a.d h.k2.u.a<? extends T> aVar) {
        return FlowKt__BuildersKt.c(aVar);
    }

    @k.e.a.d
    public static final <T> Flow<T> c0(@k.e.a.d i.b.t3.y<? extends T> yVar) {
        return FlowKt__ChannelsKt.d(yVar);
    }

    @k.e.a.d
    public static final <T> b2 c1(@k.e.a.d Flow<? extends T> flow, @k.e.a.d n0 n0Var) {
        return FlowKt__CollectKt.i(flow, n0Var);
    }

    @h.i(level = DeprecationLevel.ERROR, message = "Use 'flowOn' instead")
    @k.e.a.d
    public static final <T> Flow<T> c2(@k.e.a.d Flow<? extends T> flow, @k.e.a.d CoroutineContext coroutineContext) {
        return FlowKt__MigrationKt.J(flow, coroutineContext);
    }

    @s1
    @k.e.a.d
    public static final <T> Flow<T> d(@k.e.a.d h.k2.u.l<? super h.e2.c<? super T>, ? extends Object> lVar) {
        return FlowKt__BuildersKt.d(lVar);
    }

    @k.e.a.e
    public static final <T> Object d0(@k.e.a.d Flow<? extends T> flow, @k.e.a.d h.e2.c<? super Integer> cVar) {
        return FlowKt__CountKt.a(flow, cVar);
    }

    @k.e.a.d
    public static final <T, R> Flow<R> d1(@k.e.a.d Flow<? extends T> flow, @k.e.a.d h.k2.u.p<? super T, ? super h.e2.c<? super R>, ? extends Object> pVar) {
        return FlowKt__TransformKt.e(flow, pVar);
    }

    @h.i(level = DeprecationLevel.ERROR, message = "Flow analogues of 'switchMap' are 'transformLatest', 'flatMapLatest' and 'mapLatest'", replaceWith = @q0(expression = "this.flatMapLatest(transform)", imports = {}))
    @k.e.a.d
    public static final <T, R> Flow<R> d2(@k.e.a.d Flow<? extends T> flow, @k.e.a.d h.k2.u.p<? super T, ? super h.e2.c<? super Flow<? extends R>>, ? extends Object> pVar) {
        return FlowKt__MigrationKt.K(flow, pVar);
    }

    @k.e.a.d
    public static final Flow<Integer> e(@k.e.a.d h.o2.k kVar) {
        return FlowKt__BuildersKt.e(kVar);
    }

    @k.e.a.e
    public static final <T> Object e0(@k.e.a.d Flow<? extends T> flow, @k.e.a.d h.k2.u.p<? super T, ? super h.e2.c<? super Boolean>, ? extends Object> pVar, @k.e.a.d h.e2.c<? super Integer> cVar) {
        return FlowKt__CountKt.b(flow, pVar, cVar);
    }

    @r1
    @k.e.a.d
    public static final <T, R> Flow<R> e1(@k.e.a.d Flow<? extends T> flow, @h.b @k.e.a.d h.k2.u.p<? super T, ? super h.e2.c<? super R>, ? extends Object> pVar) {
        return FlowKt__MergeKt.j(flow, pVar);
    }

    @k.e.a.d
    public static final <T> Flow<T> e2(@k.e.a.d Flow<? extends T> flow, int i2) {
        return FlowKt__LimitKt.f(flow, i2);
    }

    @k.e.a.d
    public static final Flow<Long> f(@k.e.a.d h.o2.n nVar) {
        return FlowKt__BuildersKt.f(nVar);
    }

    @s1
    @k.e.a.d
    public static final <T> Flow<T> f0(@k.e.a.d Flow<? extends T> flow, long j2) {
        return FlowKt__DelayKt.a(flow, j2);
    }

    @k.e.a.d
    public static final <T, R> Flow<R> f1(@k.e.a.d Flow<? extends T> flow, @k.e.a.d h.k2.u.p<? super T, ? super h.e2.c<? super R>, ? extends Object> pVar) {
        return FlowKt__TransformKt.f(flow, pVar);
    }

    @k.e.a.d
    public static final <T> Flow<T> f2(@k.e.a.d Flow<? extends T> flow, @k.e.a.d h.k2.u.p<? super T, ? super h.e2.c<? super Boolean>, ? extends Object> pVar) {
        return FlowKt__LimitKt.g(flow, pVar);
    }

    @k.e.a.d
    public static final <T> Flow<T> g(@k.e.a.d h.q2.m<? extends T> mVar) {
        return FlowKt__BuildersKt.g(mVar);
    }

    @s1
    @j0
    @k.e.a.d
    public static final <T> Flow<T> g0(@k.e.a.d Flow<? extends T> flow, @k.e.a.d h.k2.u.l<? super T, Long> lVar) {
        return FlowKt__DelayKt.b(flow, lVar);
    }

    @r1
    @k.e.a.d
    public static final <T> Flow<T> g1(@k.e.a.d Iterable<? extends Flow<? extends T>> iterable) {
        return FlowKt__MergeKt.k(iterable);
    }

    @k.e.a.e
    public static final <T, C extends Collection<? super T>> Object g2(@k.e.a.d Flow<? extends T> flow, @k.e.a.d C c2, @k.e.a.d h.e2.c<? super C> cVar) {
        return FlowKt__CollectionKt.a(flow, c2, cVar);
    }

    @s1
    @k.e.a.d
    public static final <T> Flow<T> h(@k.e.a.d i.b.t3.i<T> iVar) {
        return FlowKt__ChannelsKt.a(iVar);
    }

    @h.u2.j
    @s1
    @k.e.a.d
    public static final <T> Flow<T> h0(@k.e.a.d Flow<? extends T> flow, double d2) {
        return FlowKt__DelayKt.c(flow, d2);
    }

    @h.i(level = DeprecationLevel.ERROR, message = "Flow analogue of 'merge' is 'flattenConcat'", replaceWith = @q0(expression = "flattenConcat()", imports = {}))
    @k.e.a.d
    public static final <T> Flow<T> h1(@k.e.a.d Flow<? extends Flow<? extends T>> flow) {
        return FlowKt__MigrationKt.o(flow);
    }

    @k.e.a.e
    public static final <T> Object h2(@k.e.a.d Flow<? extends T> flow, @k.e.a.d List<T> list, @k.e.a.d h.e2.c<? super List<? extends T>> cVar) {
        return FlowKt__CollectionKt.b(flow, list, cVar);
    }

    @k.e.a.d
    public static final Flow<Integer> i(@k.e.a.d int[] iArr) {
        return FlowKt__BuildersKt.h(iArr);
    }

    @h.k2.g(name = "debounceDuration")
    @s1
    @j0
    @h.u2.j
    @k.e.a.d
    public static final <T> Flow<T> i0(@k.e.a.d Flow<? extends T> flow, @k.e.a.d h.k2.u.l<? super T, h.u2.d> lVar) {
        return FlowKt__DelayKt.d(flow, lVar);
    }

    @r1
    @k.e.a.d
    public static final <T> Flow<T> i1(@k.e.a.d Flow<? extends T>... flowArr) {
        return FlowKt__MergeKt.l(flowArr);
    }

    @k.e.a.d
    public static final Flow<Long> j(@k.e.a.d long[] jArr) {
        return FlowKt__BuildersKt.i(jArr);
    }

    @h.i(level = DeprecationLevel.WARNING, message = "Use 'onEach { delay(timeMillis) }'", replaceWith = @q0(expression = "onEach { delay(timeMillis) }", imports = {}))
    @k.e.a.d
    public static final <T> Flow<T> j0(@k.e.a.d Flow<? extends T> flow, long j2) {
        return FlowKt__MigrationKt.j(flow, j2);
    }

    @k.e.a.d
    public static final Void j1() {
        return FlowKt__MigrationKt.p();
    }

    @k.e.a.e
    public static final <T> Object j2(@k.e.a.d Flow<? extends T> flow, @k.e.a.d Set<T> set, @k.e.a.d h.e2.c<? super Set<? extends T>> cVar) {
        return FlowKt__CollectionKt.d(flow, set, cVar);
    }

    @k.e.a.d
    public static final <T> Flow<T> k(@k.e.a.d T[] tArr) {
        return FlowKt__BuildersKt.j(tArr);
    }

    @h.i(level = DeprecationLevel.WARNING, message = "Use 'onStart { delay(timeMillis) }'", replaceWith = @q0(expression = "onStart { delay(timeMillis) }", imports = {}))
    @k.e.a.d
    public static final <T> Flow<T> k0(@k.e.a.d Flow<? extends T> flow, long j2) {
        return FlowKt__MigrationKt.k(flow, j2);
    }

    @h.i(level = DeprecationLevel.ERROR, message = "Collect flow in the desired context instead")
    @k.e.a.d
    public static final <T> Flow<T> k1(@k.e.a.d Flow<? extends T> flow, @k.e.a.d CoroutineContext coroutineContext) {
        return FlowKt__MigrationKt.q(flow, coroutineContext);
    }

    @k.e.a.d
    public static final <T> p<T> l(@k.e.a.d k<T> kVar) {
        return FlowKt__ShareKt.a(kVar);
    }

    @k.e.a.d
    public static final <T> Flow<T> l0(@k.e.a.d Flow<? extends T> flow) {
        return FlowKt__DistinctKt.a(flow);
    }

    @k.e.a.d
    public static final <T> Flow<T> l1(@k.e.a.d Flow<? extends T> flow, @k.e.a.d h.k2.u.q<? super f<? super T>, ? super Throwable, ? super h.e2.c<? super t1>, ? extends Object> qVar) {
        return FlowKt__EmittersKt.b(flow, qVar);
    }

    @k.e.a.d
    public static final <T, R> Flow<R> l2(@k.e.a.d Flow<? extends T> flow, @h.b @k.e.a.d h.k2.u.q<? super f<? super R>, ? super T, ? super h.e2.c<? super t1>, ? extends Object> qVar) {
        return FlowKt__EmittersKt.e(flow, qVar);
    }

    @k.e.a.d
    public static final <T> x<T> m(@k.e.a.d l<T> lVar) {
        return FlowKt__ShareKt.b(lVar);
    }

    @k.e.a.d
    public static final <T> Flow<T> m0(@k.e.a.d Flow<? extends T> flow, @k.e.a.d h.k2.u.p<? super T, ? super T, Boolean> pVar) {
        return FlowKt__DistinctKt.b(flow, pVar);
    }

    @k.e.a.d
    public static final <T> Flow<T> m1(@k.e.a.d Flow<? extends T> flow, @k.e.a.d h.k2.u.p<? super T, ? super h.e2.c<? super t1>, ? extends Object> pVar) {
        return FlowKt__TransformKt.g(flow, pVar);
    }

    @r1
    @k.e.a.d
    public static final <T, R> Flow<R> m2(@k.e.a.d Flow<? extends T> flow, @h.b @k.e.a.d h.k2.u.q<? super f<? super R>, ? super T, ? super h.e2.c<? super t1>, ? extends Object> qVar) {
        return FlowKt__MergeKt.m(flow, qVar);
    }

    @h.i(level = DeprecationLevel.WARNING, message = "Use shareIn operator and the resulting SharedFlow as a replacement for BroadcastChannel", replaceWith = @q0(expression = "shareIn(scope, 0, SharingStarted.Lazily)", imports = {}))
    @k.e.a.d
    public static final <T> i.b.t3.i<T> n(@k.e.a.d Flow<? extends T> flow, @k.e.a.d n0 n0Var, @k.e.a.d CoroutineStart coroutineStart) {
        return FlowKt__ChannelsKt.b(flow, n0Var, coroutineStart);
    }

    @k.e.a.d
    public static final <T, K> Flow<T> n0(@k.e.a.d Flow<? extends T> flow, @k.e.a.d h.k2.u.l<? super T, ? extends K> lVar) {
        return FlowKt__DistinctKt.c(flow, lVar);
    }

    @k.e.a.d
    public static final <T> Flow<T> n1(@k.e.a.d Flow<? extends T> flow, @k.e.a.d h.k2.u.p<? super f<? super T>, ? super h.e2.c<? super t1>, ? extends Object> pVar) {
        return FlowKt__EmittersKt.c(flow, pVar);
    }

    @r1
    @k.e.a.d
    public static final <T, R> Flow<R> n2(@k.e.a.d Flow<? extends T> flow, @h.b @k.e.a.d h.k2.u.q<? super f<? super R>, ? super T, ? super h.e2.c<? super Boolean>, ? extends Object> qVar) {
        return FlowKt__LimitKt.h(flow, qVar);
    }

    @k.e.a.d
    public static final <T> Flow<T> o0(@k.e.a.d Flow<? extends T> flow, int i2) {
        return FlowKt__LimitKt.c(flow, i2);
    }

    @h.i(level = DeprecationLevel.ERROR, message = "Use catch { e -> if (predicate(e)) emitAll(fallback) else throw e }", replaceWith = @q0(expression = "catch { e -> if (predicate(e)) emitAll(fallback) else throw e }", imports = {}))
    @k.e.a.d
    public static final <T> Flow<T> o1(@k.e.a.d Flow<? extends T> flow, @k.e.a.d Flow<? extends T> flow2, @k.e.a.d h.k2.u.l<? super Throwable, Boolean> lVar) {
        return FlowKt__ErrorsKt.f(flow, flow2, lVar);
    }

    @p0
    @k.e.a.d
    public static final <T, R> Flow<R> o2(@k.e.a.d Flow<? extends T> flow, @h.b @k.e.a.d h.k2.u.q<? super f<? super R>, ? super T, ? super h.e2.c<? super t1>, ? extends Object> qVar) {
        return FlowKt__EmittersKt.f(flow, qVar);
    }

    @k.e.a.d
    public static final <T> Flow<T> p0(@k.e.a.d Flow<? extends T> flow, @k.e.a.d h.k2.u.p<? super T, ? super h.e2.c<? super Boolean>, ? extends Object> pVar) {
        return FlowKt__LimitKt.d(flow, pVar);
    }

    @k.e.a.d
    public static final <T> Flow<i0<T>> p2(@k.e.a.d Flow<? extends T> flow) {
        return FlowKt__TransformKt.j(flow);
    }

    @k.e.a.d
    public static final <T> Flow<T> q(@k.e.a.d Flow<? extends T> flow, int i2, @k.e.a.d BufferOverflow bufferOverflow) {
        return i.b(flow, i2, bufferOverflow);
    }

    @k.e.a.e
    public static final <T> Object q0(@k.e.a.d f<? super T> fVar, @k.e.a.d i.b.t3.y<? extends T> yVar, @k.e.a.d h.e2.c<? super t1> cVar) {
        return FlowKt__ChannelsKt.e(fVar, yVar, cVar);
    }

    @h.i(level = DeprecationLevel.ERROR, message = "Flow analogue of 'onErrorXxx' is 'catch'. Use 'catch { emitAll(fallback) }'", replaceWith = @q0(expression = "catch { emitAll(fallback) }", imports = {}))
    @k.e.a.d
    public static final <T> Flow<T> q1(@k.e.a.d Flow<? extends T> flow, @k.e.a.d Flow<? extends T> flow2) {
        return FlowKt__MigrationKt.r(flow, flow2);
    }

    @k.e.a.d
    public static final <T1, T2, R> Flow<R> q2(@k.e.a.d Flow<? extends T1> flow, @k.e.a.d Flow<? extends T2> flow2, @k.e.a.d h.k2.u.q<? super T1, ? super T2, ? super h.e2.c<? super R>, ? extends Object> qVar) {
        return FlowKt__ZipKt.s(flow, flow2, qVar);
    }

    @h.b
    @k.e.a.e
    public static final <T> Object r0(@k.e.a.d f<? super T> fVar, @k.e.a.d Flow<? extends T> flow, @k.e.a.d h.e2.c<? super t1> cVar) {
        return FlowKt__CollectKt.g(fVar, flow, cVar);
    }

    @h.i(level = DeprecationLevel.ERROR, message = "Flow analogue of 'onErrorXxx' is 'catch'. Use 'catch { emitAll(fallback) }'", replaceWith = @q0(expression = "catch { emitAll(fallback) }", imports = {}))
    @k.e.a.d
    public static final <T> Flow<T> r1(@k.e.a.d Flow<? extends T> flow, @k.e.a.d Flow<? extends T> flow2) {
        return FlowKt__MigrationKt.s(flow, flow2);
    }

    @h.b
    @k.e.a.e
    private static final Object s0(@k.e.a.d f fVar, @k.e.a.d Flow flow, @k.e.a.d h.e2.c cVar) {
        return FlowKt__CollectKt.g(fVar, flow, cVar);
    }

    @h.i(level = DeprecationLevel.ERROR, message = "Flow analogue of 'onErrorXxx' is 'catch'. Use 'catch { emit(fallback) }'", replaceWith = @q0(expression = "catch { emit(fallback) }", imports = {}))
    @k.e.a.d
    public static final <T> Flow<T> s1(@k.e.a.d Flow<? extends T> flow, T t) {
        return FlowKt__MigrationKt.t(flow, t);
    }

    @h.i(level = DeprecationLevel.ERROR, message = "Flow analogue of 'cache()' is 'shareIn' with unlimited replay and 'started = SharingStared.Lazily' argument'", replaceWith = @q0(expression = "this.shareIn(scope, Int.MAX_VALUE, started = SharingStared.Lazily)", imports = {}))
    @k.e.a.d
    public static final <T> Flow<T> t(@k.e.a.d Flow<? extends T> flow) {
        return FlowKt__MigrationKt.a(flow);
    }

    @k.e.a.d
    public static final <T> Flow<T> t0() {
        return FlowKt__BuildersKt.m();
    }

    @h.i(level = DeprecationLevel.ERROR, message = "Flow analogue of 'onErrorXxx' is 'catch'. Use 'catch { e -> if (predicate(e)) emit(fallback) else throw e }'", replaceWith = @q0(expression = "catch { e -> if (predicate(e)) emit(fallback) else throw e }", imports = {}))
    @k.e.a.d
    public static final <T> Flow<T> t1(@k.e.a.d Flow<? extends T> flow, T t, @k.e.a.d h.k2.u.l<? super Throwable, Boolean> lVar) {
        return FlowKt__MigrationKt.u(flow, t, lVar);
    }

    @r1
    @k.e.a.d
    public static final <T> Flow<T> u(@h.b @k.e.a.d h.k2.u.p<? super i.b.t3.w<? super T>, ? super h.e2.c<? super t1>, ? extends Object> pVar) {
        return FlowKt__BuildersKt.k(pVar);
    }

    @k.e.a.d
    public static final <T> Flow<T> u0(@k.e.a.d Flow<? extends T> flow, @k.e.a.d h.k2.u.p<? super T, ? super h.e2.c<? super Boolean>, ? extends Object> pVar) {
        return FlowKt__TransformKt.a(flow, pVar);
    }

    @k.e.a.d
    public static final <T> Flow<T> v(@k.e.a.d Flow<? extends T> flow) {
        return i.e(flow);
    }

    @k.e.a.d
    public static final <T> Flow<T> v1(@k.e.a.d Flow<? extends T> flow, @k.e.a.d h.k2.u.p<? super f<? super T>, ? super h.e2.c<? super t1>, ? extends Object> pVar) {
        return FlowKt__EmittersKt.d(flow, pVar);
    }

    @k.e.a.d
    public static final <T> Flow<T> w(@k.e.a.d Flow<? extends T> flow, @k.e.a.d h.k2.u.q<? super f<? super T>, ? super Throwable, ? super h.e2.c<? super t1>, ? extends Object> qVar) {
        return FlowKt__ErrorsKt.b(flow, qVar);
    }

    @k.e.a.d
    public static final <T> Flow<T> w0(@k.e.a.d Flow<? extends T> flow, @k.e.a.d h.k2.u.p<? super T, ? super h.e2.c<? super Boolean>, ? extends Object> pVar) {
        return FlowKt__TransformKt.c(flow, pVar);
    }

    @k.e.a.d
    public static final <T> p<T> w1(@k.e.a.d p<? extends T> pVar, @k.e.a.d h.k2.u.p<? super f<? super T>, ? super h.e2.c<? super t1>, ? extends Object> pVar2) {
        return FlowKt__ShareKt.f(pVar, pVar2);
    }

    @k.e.a.e
    public static final <T> Object x(@k.e.a.d Flow<? extends T> flow, @k.e.a.d f<? super T> fVar, @k.e.a.d h.e2.c<? super Throwable> cVar) {
        return FlowKt__ErrorsKt.c(flow, fVar, cVar);
    }

    @k.e.a.d
    public static final <T> Flow<T> x0(@k.e.a.d Flow<? extends T> flow) {
        return FlowKt__TransformKt.d(flow);
    }

    @s1
    @k.e.a.d
    public static final <T> i.b.t3.y<T> x1(@k.e.a.d Flow<? extends T> flow, @k.e.a.d n0 n0Var) {
        return FlowKt__ChannelsKt.g(flow, n0Var);
    }

    @r1
    @k.e.a.d
    public static final <T> Flow<T> y(@h.b @k.e.a.d h.k2.u.p<? super i.b.t3.w<? super T>, ? super h.e2.c<? super t1>, ? extends Object> pVar) {
        return FlowKt__BuildersKt.l(pVar);
    }

    @k.e.a.e
    public static final <T> Object y0(@k.e.a.d Flow<? extends T> flow, @k.e.a.d h.e2.c<? super T> cVar) {
        return FlowKt__ReduceKt.a(flow, cVar);
    }

    @h.i(level = DeprecationLevel.ERROR, message = "Flow analogue of 'publish()' is 'shareIn'. \npublish().connect() is the default strategy (no extra call is needed), \npublish().autoConnect() translates to 'started = SharingStared.Lazily' argument, \npublish().refCount() translates to 'started = SharingStared.WhileSubscribed()' argument.", replaceWith = @q0(expression = "this.shareIn(scope, 0)", imports = {}))
    @k.e.a.d
    public static final <T> Flow<T> y1(@k.e.a.d Flow<? extends T> flow) {
        return FlowKt__MigrationKt.w(flow);
    }

    @k.e.a.e
    public static final Object z(@k.e.a.d Flow<?> flow, @k.e.a.d h.e2.c<? super t1> cVar) {
        return FlowKt__CollectKt.a(flow, cVar);
    }

    @k.e.a.e
    public static final <T> Object z0(@k.e.a.d Flow<? extends T> flow, @k.e.a.d h.k2.u.p<? super T, ? super h.e2.c<? super Boolean>, ? extends Object> pVar, @k.e.a.d h.e2.c<? super T> cVar) {
        return FlowKt__ReduceKt.b(flow, pVar, cVar);
    }

    @h.i(level = DeprecationLevel.ERROR, message = "Flow analogue of 'publish(bufferSize)' is 'buffer' followed by 'shareIn'. \npublish().connect() is the default strategy (no extra call is needed), \npublish().autoConnect() translates to 'started = SharingStared.Lazily' argument, \npublish().refCount() translates to 'started = SharingStared.WhileSubscribed()' argument.", replaceWith = @q0(expression = "this.buffer(bufferSize).shareIn(scope, 0)", imports = {}))
    @k.e.a.d
    public static final <T> Flow<T> z1(@k.e.a.d Flow<? extends T> flow, int i2) {
        return FlowKt__MigrationKt.x(flow, i2);
    }
}
