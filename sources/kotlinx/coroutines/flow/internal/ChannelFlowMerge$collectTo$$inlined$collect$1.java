package kotlinx.coroutines.flow.internal;

import androidx.exifinterface.media.ExifInterface;
import h.e2.c;
import i.b.a4.d;
import i.b.b2;
import i.b.t3.w;
import i.b.v3.c0.o;
import i.b.v3.f;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.flow.Flow;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Li/b/v3/f;", "value", "Lh/t1;", "emit", "(Ljava/lang/Object;Lh/e2/c;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class ChannelFlowMerge$collectTo$$inlined$collect$1 implements f<Flow<? extends T>> {
    public final /* synthetic */ b2 a;
    public final /* synthetic */ d b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ w f16973c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ o f16974d;

    @h.e2.k.a.d(c = "kotlinx.coroutines.flow.internal.ChannelFlowMerge$collectTo$$inlined$collect$1", f = "Merge.kt", i = {0, 0, 0, 0}, l = {134}, m = "emit", n = {"this", "value", "continuation", "inner"}, s = {"L$0", "L$1", "L$2", "L$3"})
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0096@¨\u0006\u0006"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "value", "Lh/e2/c;", "Lh/t1;", "continuation", "", "kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3$emit$1", "emit"}, k = 3, mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.flow.internal.ChannelFlowMerge$collectTo$$inlined$collect$1$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static final class AnonymousClass1 extends ContinuationImpl {
        public Object L$0;
        public Object L$1;
        public Object L$2;
        public Object L$3;
        public int label;
        public /* synthetic */ Object result;

        public AnonymousClass1(c cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @e
        public final Object invokeSuspend(@k.e.a.d Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ChannelFlowMerge$collectTo$$inlined$collect$1.this.emit(null, this);
        }
    }

    public ChannelFlowMerge$collectTo$$inlined$collect$1(b2 b2Var, d dVar, w wVar, o oVar) {
        this.a = b2Var;
        this.b = dVar;
        this.f16973c = wVar;
        this.f16974d = oVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003f  */
    @Override // i.b.v3.f
    @k.e.a.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object emit(java.lang.Object r8, @k.e.a.d h.e2.c r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof kotlinx.coroutines.flow.internal.ChannelFlowMerge$collectTo$$inlined$collect$1.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r9
            kotlinx.coroutines.flow.internal.ChannelFlowMerge$collectTo$$inlined$collect$1$1 r0 = (kotlinx.coroutines.flow.internal.ChannelFlowMerge$collectTo$$inlined$collect$1.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.internal.ChannelFlowMerge$collectTo$$inlined$collect$1$1 r0 = new kotlinx.coroutines.flow.internal.ChannelFlowMerge$collectTo$$inlined$collect$1$1
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = h.e2.j.b.h()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3f
            if (r2 != r3) goto L37
            java.lang.Object r8 = r0.L$3
            kotlinx.coroutines.flow.Flow r8 = (kotlinx.coroutines.flow.Flow) r8
            java.lang.Object r1 = r0.L$2
            h.e2.c r1 = (h.e2.c) r1
            java.lang.Object r1 = r0.L$1
            java.lang.Object r0 = r0.L$0
            kotlinx.coroutines.flow.internal.ChannelFlowMerge$collectTo$$inlined$collect$1 r0 = (kotlinx.coroutines.flow.internal.ChannelFlowMerge$collectTo$$inlined$collect$1) r0
            h.r0.n(r9)
            goto L61
        L37:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L3f:
            h.r0.n(r9)
            r9 = r8
            kotlinx.coroutines.flow.Flow r9 = (kotlinx.coroutines.flow.Flow) r9
            i.b.b2 r2 = r7.a
            if (r2 == 0) goto L4c
            i.b.e2.B(r2)
        L4c:
            i.b.a4.d r2 = r7.b
            r0.L$0 = r7
            r0.L$1 = r8
            r0.L$2 = r0
            r0.L$3 = r9
            r0.label = r3
            java.lang.Object r8 = r2.c(r0)
            if (r8 != r1) goto L5f
            return r1
        L5f:
            r0 = r7
            r8 = r9
        L61:
            i.b.t3.w r1 = r0.f16973c
            r2 = 0
            r3 = 0
            kotlinx.coroutines.flow.internal.ChannelFlowMerge$collectTo$$inlined$collect$1$lambda$1 r4 = new kotlinx.coroutines.flow.internal.ChannelFlowMerge$collectTo$$inlined$collect$1$lambda$1
            r9 = 0
            r4.<init>(r8, r9, r0)
            r5 = 3
            r6 = 0
            i.b.g.f(r1, r2, r3, r4, r5, r6)
            h.t1 r8 = h.t1.a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.internal.ChannelFlowMerge$collectTo$$inlined$collect$1.emit(java.lang.Object, h.e2.c):java.lang.Object");
    }
}
