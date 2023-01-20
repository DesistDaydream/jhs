package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import h.e2.c;
import h.e2.k.a.d;
import i.b.v3.f;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Ref;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Li/b/v3/f;", "value", "Lh/t1;", "emit", "(Ljava/lang/Object;Lh/e2/c;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class DistinctFlowImpl$collect$$inlined$collect$1 implements f<T> {
    public final /* synthetic */ DistinctFlowImpl a;
    public final /* synthetic */ Ref.ObjectRef b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ f f16949c;

    @d(c = "kotlinx.coroutines.flow.DistinctFlowImpl$collect$$inlined$collect$1", f = "Distinct.kt", i = {0, 0, 0, 0, 0}, l = {137}, m = "emit", n = {"this", "value", "continuation", "value", "key"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4"})
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0096@¨\u0006\u0006"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "value", "Lh/e2/c;", "Lh/t1;", "continuation", "", "kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3$emit$1", "emit"}, k = 3, mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.flow.DistinctFlowImpl$collect$$inlined$collect$1$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static final class AnonymousClass1 extends ContinuationImpl {
        public Object L$0;
        public Object L$1;
        public Object L$2;
        public Object L$3;
        public Object L$4;
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
            return DistinctFlowImpl$collect$$inlined$collect$1.this.emit(null, this);
        }
    }

    public DistinctFlowImpl$collect$$inlined$collect$1(DistinctFlowImpl distinctFlowImpl, Ref.ObjectRef objectRef, f fVar) {
        this.a = distinctFlowImpl;
        this.b = objectRef;
        this.f16949c = fVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003f  */
    /* JADX WARN: Type inference failed for: r7v4, types: [T, java.lang.Object] */
    @Override // i.b.v3.f
    @k.e.a.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object emit(java.lang.Object r6, @k.e.a.d h.e2.c r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof kotlinx.coroutines.flow.DistinctFlowImpl$collect$$inlined$collect$1.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r7
            kotlinx.coroutines.flow.DistinctFlowImpl$collect$$inlined$collect$1$1 r0 = (kotlinx.coroutines.flow.DistinctFlowImpl$collect$$inlined$collect$1.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.DistinctFlowImpl$collect$$inlined$collect$1$1 r0 = new kotlinx.coroutines.flow.DistinctFlowImpl$collect$$inlined$collect$1$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = h.e2.j.b.h()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3f
            if (r2 != r3) goto L37
            java.lang.Object r6 = r0.L$4
            java.lang.Object r6 = r0.L$3
            java.lang.Object r6 = r0.L$2
            h.e2.c r6 = (h.e2.c) r6
            java.lang.Object r6 = r0.L$1
            java.lang.Object r6 = r0.L$0
            kotlinx.coroutines.flow.DistinctFlowImpl$collect$$inlined$collect$1 r6 = (kotlinx.coroutines.flow.DistinctFlowImpl$collect$$inlined$collect$1) r6
            h.r0.n(r7)
            goto L7b
        L37:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3f:
            h.r0.n(r7)
            kotlinx.coroutines.flow.DistinctFlowImpl r7 = r5.a
            h.k2.u.l<T, java.lang.Object> r7 = r7.b
            java.lang.Object r7 = r7.invoke(r6)
            kotlin.jvm.internal.Ref$ObjectRef r2 = r5.b
            T r2 = r2.element
            i.b.w3.i0 r4 = i.b.v3.c0.n.a
            if (r2 == r4) goto L62
            kotlinx.coroutines.flow.DistinctFlowImpl r4 = r5.a
            h.k2.u.p<java.lang.Object, java.lang.Object, java.lang.Boolean> r4 = r4.f16948c
            java.lang.Object r2 = r4.invoke(r2, r7)
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            if (r2 != 0) goto L7b
        L62:
            kotlin.jvm.internal.Ref$ObjectRef r2 = r5.b
            r2.element = r7
            i.b.v3.f r2 = r5.f16949c
            r0.L$0 = r5
            r0.L$1 = r6
            r0.L$2 = r0
            r0.L$3 = r6
            r0.L$4 = r7
            r0.label = r3
            java.lang.Object r6 = r2.emit(r6, r0)
            if (r6 != r1) goto L7b
            return r1
        L7b:
            h.t1 r6 = h.t1.a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.DistinctFlowImpl$collect$$inlined$collect$1.emit(java.lang.Object, h.e2.c):java.lang.Object");
    }
}
