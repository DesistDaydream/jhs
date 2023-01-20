package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import com.huawei.hms.push.e;
import h.e2.c;
import h.e2.j.b;
import h.e2.k.a.d;
import h.k2.u.p;
import h.k2.v.c0;
import h.t1;
import i.b.v3.f;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J!\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\b"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "Li/b/v3/f;", "collector", "Lh/t1;", e.a, "(Li/b/v3/f;Lh/e2/c;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__MergeKt$unsafeTransform$$inlined$unsafeFlow$1"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class FlowKt__MergeKt$map$$inlined$unsafeTransform$1 implements Flow<R> {
    public final /* synthetic */ Flow a;
    public final /* synthetic */ p b;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006¸\u0006\u0007"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Li/b/v3/f;", "value", "Lh/t1;", "emit", "(Ljava/lang/Object;Lh/e2/c;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__MergeKt$unsafeTransform$$inlined$unsafeFlow$1$lambda$1"}, k = 1, mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__MergeKt$map$$inlined$unsafeTransform$1$2  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static final class AnonymousClass2 implements f<T> {
        public final /* synthetic */ f a;
        public final /* synthetic */ FlowKt__MergeKt$map$$inlined$unsafeTransform$1 b;

        @d(c = "kotlinx.coroutines.flow.FlowKt__MergeKt$map$$inlined$unsafeTransform$1$2", f = "Transform.kt", i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1}, l = {134, 134}, m = "emit", n = {"this", "value", "continuation", "value", "continuation", "value", "$receiver", "this", "value", "continuation", "value", "continuation", "value", "$receiver"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6"})
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0096@¨\u0006\u0006"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "value", "Lh/e2/c;", "Lh/t1;", "continuation", "", "kotlinx/coroutines/flow/FlowKt__MergeKt$unsafeTransform$$inlined$unsafeFlow$1$lambda$1$1", "emit"}, k = 3, mv = {1, 4, 0})
        /* renamed from: kotlinx.coroutines.flow.FlowKt__MergeKt$map$$inlined$unsafeTransform$1$2$1  reason: invalid class name */
        /* loaded from: classes4.dex */
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
            @k.e.a.e
            public final Object invokeSuspend(@k.e.a.d Object obj) {
                this.result = obj;
                this.label |= Integer.MIN_VALUE;
                return AnonymousClass2.this.emit(null, this);
            }
        }

        public AnonymousClass2(f fVar, FlowKt__MergeKt$map$$inlined$unsafeTransform$1 flowKt__MergeKt$map$$inlined$unsafeTransform$1) {
            this.a = fVar;
            this.b = flowKt__MergeKt$map$$inlined$unsafeTransform$1;
        }

        @k.e.a.e
        public Object a(Object obj, @k.e.a.d c cVar) {
            c0.e(4);
            new AnonymousClass1(cVar);
            c0.e(5);
            f fVar = this.a;
            Object invoke = this.b.b.invoke(obj, cVar);
            c0.e(0);
            Object emit = fVar.emit(invoke, cVar);
            c0.e(2);
            c0.e(1);
            return emit;
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
        /* JADX WARN: Removed duplicated region for block: B:16:0x0069  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x00aa A[RETURN] */
        @Override // i.b.v3.f
        @k.e.a.e
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.lang.Object emit(java.lang.Object r11, @k.e.a.d h.e2.c r12) {
            /*
                r10 = this;
                boolean r0 = r12 instanceof kotlinx.coroutines.flow.FlowKt__MergeKt$map$$inlined$unsafeTransform$1.AnonymousClass2.AnonymousClass1
                if (r0 == 0) goto L13
                r0 = r12
                kotlinx.coroutines.flow.FlowKt__MergeKt$map$$inlined$unsafeTransform$1$2$1 r0 = (kotlinx.coroutines.flow.FlowKt__MergeKt$map$$inlined$unsafeTransform$1.AnonymousClass2.AnonymousClass1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.label = r1
                goto L18
            L13:
                kotlinx.coroutines.flow.FlowKt__MergeKt$map$$inlined$unsafeTransform$1$2$1 r0 = new kotlinx.coroutines.flow.FlowKt__MergeKt$map$$inlined$unsafeTransform$1$2$1
                r0.<init>(r12)
            L18:
                java.lang.Object r12 = r0.result
                java.lang.Object r1 = h.e2.j.b.h()
                int r2 = r0.label
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L69
                if (r2 == r4) goto L4b
                if (r2 != r3) goto L43
                java.lang.Object r11 = r0.L$6
                i.b.v3.f r11 = (i.b.v3.f) r11
                java.lang.Object r11 = r0.L$5
                java.lang.Object r11 = r0.L$4
                h.e2.c r11 = (h.e2.c) r11
                java.lang.Object r11 = r0.L$3
                java.lang.Object r11 = r0.L$2
                kotlinx.coroutines.flow.FlowKt__MergeKt$map$$inlined$unsafeTransform$1$2$1 r11 = (kotlinx.coroutines.flow.FlowKt__MergeKt$map$$inlined$unsafeTransform$1.AnonymousClass2.AnonymousClass1) r11
                java.lang.Object r11 = r0.L$1
                java.lang.Object r11 = r0.L$0
                kotlinx.coroutines.flow.FlowKt__MergeKt$map$$inlined$unsafeTransform$1$2 r11 = (kotlinx.coroutines.flow.FlowKt__MergeKt$map$$inlined$unsafeTransform$1.AnonymousClass2) r11
                h.r0.n(r12)
                goto Lab
            L43:
                java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
                r11.<init>(r12)
                throw r11
            L4b:
                java.lang.Object r11 = r0.L$7
                i.b.v3.f r11 = (i.b.v3.f) r11
                java.lang.Object r2 = r0.L$6
                i.b.v3.f r2 = (i.b.v3.f) r2
                java.lang.Object r4 = r0.L$5
                java.lang.Object r5 = r0.L$4
                h.e2.c r5 = (h.e2.c) r5
                java.lang.Object r6 = r0.L$3
                java.lang.Object r7 = r0.L$2
                kotlinx.coroutines.flow.FlowKt__MergeKt$map$$inlined$unsafeTransform$1$2$1 r7 = (kotlinx.coroutines.flow.FlowKt__MergeKt$map$$inlined$unsafeTransform$1.AnonymousClass2.AnonymousClass1) r7
                java.lang.Object r8 = r0.L$1
                java.lang.Object r9 = r0.L$0
                kotlinx.coroutines.flow.FlowKt__MergeKt$map$$inlined$unsafeTransform$1$2 r9 = (kotlinx.coroutines.flow.FlowKt__MergeKt$map$$inlined$unsafeTransform$1.AnonymousClass2) r9
                h.r0.n(r12)
                goto L94
            L69:
                h.r0.n(r12)
                i.b.v3.f r12 = r10.a
                kotlinx.coroutines.flow.FlowKt__MergeKt$map$$inlined$unsafeTransform$1 r2 = r10.b
                h.k2.u.p r2 = r2.b
                r0.L$0 = r10
                r0.L$1 = r11
                r0.L$2 = r0
                r0.L$3 = r11
                r0.L$4 = r0
                r0.L$5 = r11
                r0.L$6 = r12
                r0.L$7 = r12
                r0.label = r4
                java.lang.Object r2 = r2.invoke(r11, r0)
                if (r2 != r1) goto L8b
                return r1
            L8b:
                r9 = r10
                r4 = r11
                r6 = r4
                r8 = r6
                r11 = r12
                r5 = r0
                r7 = r5
                r12 = r2
                r2 = r11
            L94:
                r0.L$0 = r9
                r0.L$1 = r8
                r0.L$2 = r7
                r0.L$3 = r6
                r0.L$4 = r5
                r0.L$5 = r4
                r0.L$6 = r2
                r0.label = r3
                java.lang.Object r11 = r11.emit(r12, r0)
                if (r11 != r1) goto Lab
                return r1
            Lab:
                h.t1 r11 = h.t1.a
                return r11
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__MergeKt$map$$inlined$unsafeTransform$1.AnonymousClass2.emit(java.lang.Object, h.e2.c):java.lang.Object");
        }
    }

    public FlowKt__MergeKt$map$$inlined$unsafeTransform$1(Flow flow, p pVar) {
        this.a = flow;
        this.b = pVar;
    }

    @Override // kotlinx.coroutines.flow.Flow
    @k.e.a.e
    public Object e(@k.e.a.d f fVar, @k.e.a.d c cVar) {
        Object e2 = this.a.e(new AnonymousClass2(fVar, this), cVar);
        return e2 == b.h() ? e2 : t1.a;
    }

    @k.e.a.e
    public Object h(@k.e.a.d f fVar, @k.e.a.d c cVar) {
        c0.e(4);
        new ContinuationImpl(cVar) { // from class: kotlinx.coroutines.flow.FlowKt__MergeKt$map$$inlined$unsafeTransform$1.1
            public int label;
            public /* synthetic */ Object result;

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @k.e.a.e
            public final Object invokeSuspend(@k.e.a.d Object obj) {
                this.result = obj;
                this.label |= Integer.MIN_VALUE;
                return FlowKt__MergeKt$map$$inlined$unsafeTransform$1.this.e(null, this);
            }
        };
        c0.e(5);
        Flow flow = this.a;
        AnonymousClass2 anonymousClass2 = new AnonymousClass2(fVar, this);
        c0.e(0);
        flow.e(anonymousClass2, cVar);
        c0.e(2);
        c0.e(1);
        return t1.a;
    }
}
