package com.eth.ext;

import androidx.exifinterface.media.ExifInterface;
import com.eth.binder.FlowBinder;
import com.eth.model.NLive;
import h.e2.c;
import h.e2.j.b;
import h.t1;
import i.b.v3.f;
import java.util.List;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.flow.Flow;

@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a*\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005\u001aB\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0006\"\u000e\b\u0001\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00060\u0007*\b\u0012\u0004\u0012\u0002H\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00052\u0006\u0010\b\u001a\u00020\t\u001a\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003\u001a(\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00070\u0003\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\f0\u0003¨\u0006\r"}, d2 = {"bind", "Lcom/eth/binder/FlowBinder;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/Flow;", "live", "Lcom/eth/model/NLive;", ExifInterface.LONGITUDE_EAST, "", "refresh", "", "toBinder", "unpackList", "Lcom/eth/model/PackList;", "eth_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class FlowKt {
    @d
    public static final <T> FlowBinder<T> a(@d Flow<? extends T> flow, @d NLive<T> nLive) {
        return new FlowBinder<>(flow, nLive);
    }

    @d
    public static final <E, T extends List<? extends E>> FlowBinder<T> b(@d Flow<? extends T> flow, @d NLive<T> nLive, boolean z) {
        return (FlowBinder) new FlowBinder(flow, nLive).a(new FlowKt$bind$1(z));
    }

    @d
    public static final <T> FlowBinder<T> c(@d Flow<? extends T> flow) {
        return a(flow, new NLive(null, 1, null));
    }

    @d
    public static final <T> Flow<List<T>> d(@d final Flow<e.g.e.d<T>> flow) {
        return (Flow<List<? extends T>>) new Flow<List<? extends T>>() { // from class: com.eth.ext.FlowKt$unpackList$$inlined$map$1

            @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006¸\u0006\t"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__TransformKt$$special$$inlined$collect$5", "kotlinx/coroutines/flow/FlowKt__TransformKt$unsafeTransform$$inlined$unsafeFlow$5$lambda$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 1, mv = {1, 5, 1})
            /* renamed from: com.eth.ext.FlowKt$unpackList$$inlined$map$1$2 */
            /* loaded from: classes.dex */
            public static final class AnonymousClass2 implements f<e.g.e.d<T>> {
                public final /* synthetic */ f a;
                public final /* synthetic */ FlowKt$unpackList$$inlined$map$1 b;

                @h.e2.k.a.d(c = "com.eth.ext.FlowKt$unpackList$$inlined$map$1$2", f = "Flow.kt", i = {}, l = {135}, m = "emit", n = {}, s = {})
                @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0096@¨\u0006\n"}, d2 = {"emit", "", ExifInterface.GPS_DIRECTION_TRUE, "value", "continuation", "Lkotlin/coroutines/Continuation;", "", "kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3$emit$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$$special$$inlined$collect$5$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$unsafeTransform$$inlined$unsafeFlow$5$lambda$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2$1"}, k = 3, mv = {1, 5, 1})
                /* renamed from: com.eth.ext.FlowKt$unpackList$$inlined$map$1$2$1 */
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

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public AnonymousClass1(c cVar) {
                        super(cVar);
                        AnonymousClass2.this = r1;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @e
                    public final Object invokeSuspend(@d Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(f fVar, FlowKt$unpackList$$inlined$map$1 flowKt$unpackList$$inlined$map$1) {
                    this.a = fVar;
                    this.b = flowKt$unpackList$$inlined$map$1;
                }

                /* JADX WARN: Removed duplicated region for block: B:48:0x0023  */
                /* JADX WARN: Removed duplicated region for block: B:52:0x0031  */
                @Override // i.b.v3.f
                @k.e.a.e
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public java.lang.Object emit(java.lang.Object r5, @k.e.a.d h.e2.c r6) {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof com.eth.ext.FlowKt$unpackList$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r6
                        com.eth.ext.FlowKt$unpackList$$inlined$map$1$2$1 r0 = (com.eth.ext.FlowKt$unpackList$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.eth.ext.FlowKt$unpackList$$inlined$map$1$2$1 r0 = new com.eth.ext.FlowKt$unpackList$$inlined$map$1$2$1
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.result
                        java.lang.Object r1 = h.e2.j.b.h()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        h.r0.n(r6)
                        goto L45
                    L29:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L31:
                        h.r0.n(r6)
                        i.b.v3.f r6 = r4.a
                        e.g.e.d r5 = (e.g.e.d) r5
                        java.util.List r5 = r5.a()
                        r0.label = r3
                        java.lang.Object r5 = r6.emit(r5, r0)
                        if (r5 != r1) goto L45
                        return r1
                    L45:
                        h.t1 r5 = h.t1.a
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.eth.ext.FlowKt$unpackList$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, h.e2.c):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            @e
            public Object e(@d f fVar, @d c cVar) {
                Object e2 = flow.e(new AnonymousClass2(fVar, this), cVar);
                return e2 == b.h() ? e2 : t1.a;
            }
        };
    }
}
