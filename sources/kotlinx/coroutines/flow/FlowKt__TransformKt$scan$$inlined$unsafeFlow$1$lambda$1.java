package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import h.e2.c;
import i.b.v3.f;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Ref;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006¸\u0006\u0007"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Li/b/v3/f;", "value", "Lh/t1;", "emit", "(Ljava/lang/Object;Lh/e2/c;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__TransformKt$$special$$inlined$collect$9"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class FlowKt__TransformKt$scan$$inlined$unsafeFlow$1$lambda$1 implements f<T> {
    public final /* synthetic */ f a;
    public final /* synthetic */ Ref.ObjectRef b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ FlowKt__TransformKt$scan$$inlined$unsafeFlow$1 f16956c;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0096@¨\u0006\u0006"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "value", "Lh/e2/c;", "Lh/t1;", "continuation", "", "kotlinx/coroutines/flow/FlowKt__TransformKt$$special$$inlined$collect$9$1", "emit"}, k = 3, mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__TransformKt$scan$$inlined$unsafeFlow$1$lambda$1$1  reason: invalid class name */
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
        public final Object invokeSuspend(@d Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FlowKt__TransformKt$scan$$inlined$unsafeFlow$1$lambda$1.this.emit(null, this);
        }
    }

    public FlowKt__TransformKt$scan$$inlined$unsafeFlow$1$lambda$1(f fVar, Ref.ObjectRef objectRef, FlowKt__TransformKt$scan$$inlined$unsafeFlow$1 flowKt__TransformKt$scan$$inlined$unsafeFlow$1) {
        this.a = fVar;
        this.b = objectRef;
        this.f16956c = flowKt__TransformKt$scan$$inlined$unsafeFlow$1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0098 A[RETURN] */
    @Override // i.b.v3.f
    @k.e.a.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object emit(java.lang.Object r8, @k.e.a.d h.e2.c r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof kotlinx.coroutines.flow.FlowKt__TransformKt$scan$$inlined$unsafeFlow$1$lambda$1.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r9
            kotlinx.coroutines.flow.FlowKt__TransformKt$scan$$inlined$unsafeFlow$1$lambda$1$1 r0 = (kotlinx.coroutines.flow.FlowKt__TransformKt$scan$$inlined$unsafeFlow$1$lambda$1.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__TransformKt$scan$$inlined$unsafeFlow$1$lambda$1$1 r0 = new kotlinx.coroutines.flow.FlowKt__TransformKt$scan$$inlined$unsafeFlow$1$lambda$1$1
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = h.e2.j.b.h()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L54
            if (r2 == r4) goto L40
            if (r2 != r3) goto L38
            java.lang.Object r8 = r0.L$3
            java.lang.Object r8 = r0.L$2
            h.e2.c r8 = (h.e2.c) r8
            java.lang.Object r8 = r0.L$1
            java.lang.Object r8 = r0.L$0
            kotlinx.coroutines.flow.FlowKt__TransformKt$scan$$inlined$unsafeFlow$1$lambda$1 r8 = (kotlinx.coroutines.flow.FlowKt__TransformKt$scan$$inlined$unsafeFlow$1$lambda$1) r8
            h.r0.n(r9)
            goto L99
        L38:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L40:
            java.lang.Object r8 = r0.L$4
            kotlin.jvm.internal.Ref$ObjectRef r8 = (kotlin.jvm.internal.Ref.ObjectRef) r8
            java.lang.Object r2 = r0.L$3
            java.lang.Object r4 = r0.L$2
            h.e2.c r4 = (h.e2.c) r4
            java.lang.Object r5 = r0.L$1
            java.lang.Object r6 = r0.L$0
            kotlinx.coroutines.flow.FlowKt__TransformKt$scan$$inlined$unsafeFlow$1$lambda$1 r6 = (kotlinx.coroutines.flow.FlowKt__TransformKt$scan$$inlined$unsafeFlow$1$lambda$1) r6
            h.r0.n(r9)
            goto L80
        L54:
            h.r0.n(r9)
            kotlin.jvm.internal.Ref$ObjectRef r9 = r7.b
            kotlinx.coroutines.flow.FlowKt__TransformKt$scan$$inlined$unsafeFlow$1 r2 = r7.f16956c
            h.k2.u.q r2 = r2.f16955c
            T r5 = r9.element
            r0.L$0 = r7
            r0.L$1 = r8
            r0.L$2 = r0
            r0.L$3 = r8
            r0.L$4 = r9
            r0.label = r4
            r4 = 6
            h.k2.v.c0.e(r4)
            java.lang.Object r2 = r2.invoke(r5, r8, r0)
            r4 = 7
            h.k2.v.c0.e(r4)
            if (r2 != r1) goto L7a
            return r1
        L7a:
            r6 = r7
            r5 = r8
            r4 = r0
            r8 = r9
            r9 = r2
            r2 = r5
        L80:
            r8.element = r9
            i.b.v3.f r8 = r6.a
            kotlin.jvm.internal.Ref$ObjectRef r9 = r6.b
            T r9 = r9.element
            r0.L$0 = r6
            r0.L$1 = r5
            r0.L$2 = r4
            r0.L$3 = r2
            r0.label = r3
            java.lang.Object r8 = r8.emit(r9, r0)
            if (r8 != r1) goto L99
            return r1
        L99:
            h.t1 r8 = h.t1.a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__TransformKt$scan$$inlined$unsafeFlow$1$lambda$1.emit(java.lang.Object, h.e2.c):java.lang.Object");
    }
}
