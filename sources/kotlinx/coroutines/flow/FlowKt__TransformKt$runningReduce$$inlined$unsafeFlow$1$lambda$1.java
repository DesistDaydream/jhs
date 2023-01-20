package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import h.e2.c;
import i.b.v3.f;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Ref;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006¸\u0006\u0007"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Li/b/v3/f;", "value", "Lh/t1;", "emit", "(Ljava/lang/Object;Lh/e2/c;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__TransformKt$$special$$inlined$collect$10"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class FlowKt__TransformKt$runningReduce$$inlined$unsafeFlow$1$lambda$1 implements f<T> {
    public final /* synthetic */ f a;
    public final /* synthetic */ Ref.ObjectRef b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ FlowKt__TransformKt$runningReduce$$inlined$unsafeFlow$1 f16954c;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0096@¨\u0006\u0006"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "value", "Lh/e2/c;", "Lh/t1;", "continuation", "", "kotlinx/coroutines/flow/FlowKt__TransformKt$$special$$inlined$collect$10$1", "emit"}, k = 3, mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__TransformKt$runningReduce$$inlined$unsafeFlow$1$lambda$1$1  reason: invalid class name */
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
            return FlowKt__TransformKt$runningReduce$$inlined$unsafeFlow$1$lambda$1.this.emit(null, this);
        }
    }

    public FlowKt__TransformKt$runningReduce$$inlined$unsafeFlow$1$lambda$1(f fVar, Ref.ObjectRef objectRef, FlowKt__TransformKt$runningReduce$$inlined$unsafeFlow$1 flowKt__TransformKt$runningReduce$$inlined$unsafeFlow$1) {
        this.a = fVar;
        this.b = objectRef;
        this.f16954c = flowKt__TransformKt$runningReduce$$inlined$unsafeFlow$1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00a4 A[RETURN] */
    @Override // i.b.v3.f
    @k.e.a.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object emit(java.lang.Object r9, @k.e.a.d h.e2.c r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof kotlinx.coroutines.flow.FlowKt__TransformKt$runningReduce$$inlined$unsafeFlow$1$lambda$1.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r10
            kotlinx.coroutines.flow.FlowKt__TransformKt$runningReduce$$inlined$unsafeFlow$1$lambda$1$1 r0 = (kotlinx.coroutines.flow.FlowKt__TransformKt$runningReduce$$inlined$unsafeFlow$1$lambda$1.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__TransformKt$runningReduce$$inlined$unsafeFlow$1$lambda$1$1 r0 = new kotlinx.coroutines.flow.FlowKt__TransformKt$runningReduce$$inlined$unsafeFlow$1$lambda$1$1
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = h.e2.j.b.h()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L58
            if (r2 == r4) goto L41
            if (r2 != r3) goto L39
            java.lang.Object r9 = r0.L$3
            java.lang.Object r9 = r0.L$2
            h.e2.c r9 = (h.e2.c) r9
            java.lang.Object r9 = r0.L$1
            java.lang.Object r9 = r0.L$0
            kotlinx.coroutines.flow.FlowKt__TransformKt$runningReduce$$inlined$unsafeFlow$1$lambda$1 r9 = (kotlinx.coroutines.flow.FlowKt__TransformKt$runningReduce$$inlined$unsafeFlow$1$lambda$1) r9
            h.r0.n(r10)
            goto La5
        L39:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L41:
            java.lang.Object r9 = r0.L$4
            kotlin.jvm.internal.Ref$ObjectRef r9 = (kotlin.jvm.internal.Ref.ObjectRef) r9
            java.lang.Object r2 = r0.L$3
            java.lang.Object r4 = r0.L$2
            h.e2.c r4 = (h.e2.c) r4
            java.lang.Object r5 = r0.L$1
            java.lang.Object r6 = r0.L$0
            kotlinx.coroutines.flow.FlowKt__TransformKt$runningReduce$$inlined$unsafeFlow$1$lambda$1 r6 = (kotlinx.coroutines.flow.FlowKt__TransformKt$runningReduce$$inlined$unsafeFlow$1$lambda$1) r6
            h.r0.n(r10)
            r7 = r10
            r10 = r9
            r9 = r7
            goto L8c
        L58:
            h.r0.n(r10)
            kotlin.jvm.internal.Ref$ObjectRef r10 = r8.b
            T r2 = r10.element
            i.b.w3.i0 r5 = i.b.v3.c0.n.a
            if (r2 != r5) goto L68
            r6 = r8
            r2 = r9
            r5 = r2
            r4 = r0
            goto L8c
        L68:
            kotlinx.coroutines.flow.FlowKt__TransformKt$runningReduce$$inlined$unsafeFlow$1 r5 = r8.f16954c
            h.k2.u.q r5 = r5.b
            r0.L$0 = r8
            r0.L$1 = r9
            r0.L$2 = r0
            r0.L$3 = r9
            r0.L$4 = r10
            r0.label = r4
            r4 = 6
            h.k2.v.c0.e(r4)
            java.lang.Object r2 = r5.invoke(r2, r9, r0)
            r4 = 7
            h.k2.v.c0.e(r4)
            if (r2 != r1) goto L87
            return r1
        L87:
            r6 = r8
            r5 = r9
            r4 = r0
            r9 = r2
            r2 = r5
        L8c:
            r10.element = r9
            i.b.v3.f r9 = r6.a
            kotlin.jvm.internal.Ref$ObjectRef r10 = r6.b
            T r10 = r10.element
            r0.L$0 = r6
            r0.L$1 = r5
            r0.L$2 = r4
            r0.L$3 = r2
            r0.label = r3
            java.lang.Object r9 = r9.emit(r10, r0)
            if (r9 != r1) goto La5
            return r1
        La5:
            h.t1 r9 = h.t1.a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__TransformKt$runningReduce$$inlined$unsafeFlow$1$lambda$1.emit(java.lang.Object, h.e2.c):java.lang.Object");
    }
}
