package com.eth.binder;

import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.eth.ext.CoroutineKt;
import com.eth.model.NLive;
import com.eth.model.NetException;
import com.tencent.android.tpush.common.MessageKey;
import com.tencent.qcloud.tuicore.TUIConstants;
import e.g.d.a;
import e.g.e.b;
import h.e2.c;
import h.t1;
import i.b.b1;
import i.b.b2;
import i.b.n0;
import i.b.o0;
import i.b.v3.f;
import i.b.v3.h;
import java.net.ConnectException;
import java.util.concurrent.CancellationException;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.flow.Flow;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0002J7\u0010\r\u001a\u00020\t2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0000¢\u0006\u0002\b\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/eth/binder/BaseFlowBinder;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/eth/binder/Binder;", "live", "Lcom/eth/model/NLive;", "(Lcom/eth/model/NLive;)V", "job", "Lkotlinx/coroutines/Job;", "cancel", "", "doCatch", "cause", "", "launch", "flow", "Lkotlinx/coroutines/flow/Flow;", TUIConstants.TUIChat.OWNER, "Landroidx/lifecycle/LifecycleOwner;", "scope", "Lkotlinx/coroutines/CoroutineScope;", MessageKey.MSG_ACCEPT_TIME_START, "Lkotlinx/coroutines/CoroutineStart;", "launch$eth_release", "eth_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public abstract class BaseFlowBinder<T> extends a<T> {
    @e

    /* renamed from: g  reason: collision with root package name */
    private b2 f2568g;

    public BaseFlowBinder(@d NLive<T> nLive) {
        super(nLive);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w(Throwable th) {
        String str;
        String str2;
        Log.e("api", Log.getStackTraceString(th));
        if (th instanceof CancellationException) {
            return;
        }
        boolean z = th instanceof NetException;
        if (z) {
            str = ((NetException) th).getCode();
        } else {
            str = th instanceof ConnectException ? b.f10025d : b.f10024c;
        }
        if (z) {
            str2 = th.getMessage();
        } else {
            str2 = th instanceof ConnectException ? "网络异常" : "内部错误";
        }
        r(new e.g.e.a(str, str2, th));
        t(NLive.State.ERROR);
    }

    @Override // e.g.d.a
    public void b() {
        b2 b2Var = this.f2568g;
        if (b2Var != null) {
            b2.a.b(b2Var, null, 1, null);
        }
        t(NLive.State.CANCEL);
    }

    public final void x(@d Flow<? extends T> flow, @e LifecycleOwner lifecycleOwner, @e n0 n0Var, @d CoroutineStart coroutineStart) {
        if (n0Var == null) {
            n0Var = lifecycleOwner == null ? null : LifecycleOwnerKt.getLifecycleScope(lifecycleOwner);
            if (n0Var == null) {
                n0Var = o0.b();
            }
        }
        final Flow S0 = h.S0(h.v1(flow, new BaseFlowBinder$launch$1(this, null)), b1.e());
        this.f2568g = CoroutineKt.c(h.S0(h.w(h.l1(h.m1(h.S0(new Flow<Pair<? extends T, ? extends T>>() { // from class: com.eth.binder.BaseFlowBinder$launch$$inlined$map$1

            @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006¸\u0006\t"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__TransformKt$$special$$inlined$collect$5", "kotlinx/coroutines/flow/FlowKt__TransformKt$unsafeTransform$$inlined$unsafeFlow$5$lambda$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 1, mv = {1, 5, 1})
            /* renamed from: com.eth.binder.BaseFlowBinder$launch$$inlined$map$1$2  reason: invalid class name */
            /* loaded from: classes.dex */
            public static final class AnonymousClass2 implements f<T> {
                public final /* synthetic */ f a;
                public final /* synthetic */ BaseFlowBinder$launch$$inlined$map$1 b;

                @h.e2.k.a.d(c = "com.eth.binder.BaseFlowBinder$launch$$inlined$map$1$2", f = "FlowBinder.kt", i = {}, l = {136}, m = "emit", n = {}, s = {})
                @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0096@¨\u0006\n"}, d2 = {"emit", "", ExifInterface.GPS_DIRECTION_TRUE, "value", "continuation", "Lkotlin/coroutines/Continuation;", "", "kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3$emit$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$$special$$inlined$collect$5$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$unsafeTransform$$inlined$unsafeFlow$5$lambda$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2$1"}, k = 3, mv = {1, 5, 1})
                /* renamed from: com.eth.binder.BaseFlowBinder$launch$$inlined$map$1$2$1  reason: invalid class name */
                /* loaded from: classes.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    public Object L$0;
                    public Object L$1;
                    public Object L$2;
                    public Object L$3;
                    public Object L$4;
                    public Object L$5;
                    public Object L$6;
                    public Object L$7;
                    public int label;
                    public /* synthetic */ Object result;

                    public AnonymousClass1(c cVar) {
                        super(cVar);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @e
                    public final Object invokeSuspend(@d Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(f fVar, BaseFlowBinder$launch$$inlined$map$1 baseFlowBinder$launch$$inlined$map$1) {
                    this.a = fVar;
                    this.b = baseFlowBinder$launch$$inlined$map$1;
                }

                /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
                /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
                @Override // i.b.v3.f
                @k.e.a.e
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public java.lang.Object emit(java.lang.Object r6, @k.e.a.d h.e2.c r7) {
                    /*
                        r5 = this;
                        boolean r0 = r7 instanceof com.eth.binder.BaseFlowBinder$launch$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r7
                        com.eth.binder.BaseFlowBinder$launch$$inlined$map$1$2$1 r0 = (com.eth.binder.BaseFlowBinder$launch$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.eth.binder.BaseFlowBinder$launch$$inlined$map$1$2$1 r0 = new com.eth.binder.BaseFlowBinder$launch$$inlined$map$1$2$1
                        r0.<init>(r7)
                    L18:
                        java.lang.Object r7 = r0.result
                        java.lang.Object r1 = h.e2.j.b.h()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        h.r0.n(r7)
                        goto L62
                    L29:
                        java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                        java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                        r6.<init>(r7)
                        throw r6
                    L31:
                        h.r0.n(r7)
                        i.b.v3.f r7 = r5.a
                        com.eth.binder.BaseFlowBinder$launch$$inlined$map$1 r2 = r5.b
                        com.eth.binder.BaseFlowBinder r2 = r2
                        e.g.d.e r2 = r2.d()
                        if (r2 != 0) goto L41
                        goto L53
                    L41:
                        com.eth.binder.BaseFlowBinder$launch$$inlined$map$1 r4 = r5.b
                        com.eth.binder.BaseFlowBinder r4 = r2
                        com.eth.model.NLive r4 = r4.c()
                        java.lang.Object r4 = r4.getValue()
                        java.lang.Object r2 = r2.a(r4, r6)
                        if (r2 != 0) goto L54
                    L53:
                        r2 = r6
                    L54:
                        kotlin.Pair r4 = new kotlin.Pair
                        r4.<init>(r2, r6)
                        r0.label = r3
                        java.lang.Object r6 = r7.emit(r4, r0)
                        if (r6 != r1) goto L62
                        return r1
                    L62:
                        h.t1 r6 = h.t1.a
                        return r6
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.eth.binder.BaseFlowBinder$launch$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, h.e2.c):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            @e
            public Object e(@d f fVar, @d c cVar) {
                Object e2 = Flow.this.e(new AnonymousClass2(fVar, this), cVar);
                return e2 == h.e2.j.b.h() ? e2 : t1.a;
            }
        }, b1.c()), new BaseFlowBinder$launch$3(this, null)), new BaseFlowBinder$launch$4(this, null)), new BaseFlowBinder$launch$5(this, null)), b1.e()), n0Var, b1.c(), coroutineStart);
    }
}
