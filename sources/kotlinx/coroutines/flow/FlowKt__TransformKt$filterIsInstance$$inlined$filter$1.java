package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import com.huawei.hms.push.e;
import h.e2.c;
import h.e2.j.b;
import h.e2.k.a.d;
import h.k2.v.c0;
import h.k2.v.f0;
import h.t1;
import i.b.v3.f;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J!\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\b"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "Li/b/v3/f;", "collector", "Lh/t1;", e.a, "(Li/b/v3/f;Lh/e2/c;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$2"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class FlowKt__TransformKt$filterIsInstance$$inlined$filter$1 implements Flow<Object> {
    public final /* synthetic */ Flow a;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006¸\u0006\u0007"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Li/b/v3/f;", "value", "Lh/t1;", "emit", "(Ljava/lang/Object;Lh/e2/c;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$2$2"}, k = 1, mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__TransformKt$filterIsInstance$$inlined$filter$1$2  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static final class AnonymousClass2 implements f<Object> {
        public final /* synthetic */ f a;
        public final /* synthetic */ FlowKt__TransformKt$filterIsInstance$$inlined$filter$1 b;

        @d(c = "kotlinx.coroutines.flow.FlowKt__TransformKt$filterIsInstance$$inlined$filter$1$2", f = "Transform.kt", i = {0, 0, 0, 0, 0, 0, 0}, l = {135}, m = "emit", n = {"this", "value", "continuation", "value", "continuation", "value", "$receiver"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6"})
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0096@¨\u0006\u0006"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "value", "Lh/e2/c;", "Lh/t1;", "continuation", "", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$2$2$1", "emit"}, k = 3, mv = {1, 4, 0})
        /* renamed from: kotlinx.coroutines.flow.FlowKt__TransformKt$filterIsInstance$$inlined$filter$1$2$1  reason: invalid class name */
        /* loaded from: classes4.dex */
        public static final class AnonymousClass1 extends ContinuationImpl {
            public Object L$0;
            public Object L$1;
            public Object L$2;
            public Object L$3;
            public Object L$4;
            public Object L$5;
            public Object L$6;
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

        public AnonymousClass2(f fVar, FlowKt__TransformKt$filterIsInstance$$inlined$filter$1 flowKt__TransformKt$filterIsInstance$$inlined$filter$1) {
            this.a = fVar;
            this.b = flowKt__TransformKt$filterIsInstance$$inlined$filter$1;
        }

        @k.e.a.e
        public Object a(Object obj, @k.e.a.d c cVar) {
            c0.e(4);
            new AnonymousClass1(cVar);
            c0.e(5);
            f fVar = this.a;
            f0.y(3, "R");
            if (obj instanceof Object) {
                c0.e(0);
                Object emit = fVar.emit(obj, cVar);
                c0.e(2);
                c0.e(1);
                return emit;
            }
            return t1.a;
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0047  */
        @Override // i.b.v3.f
        @k.e.a.e
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.lang.Object emit(java.lang.Object r6, @k.e.a.d h.e2.c r7) {
            /*
                r5 = this;
                boolean r0 = r7 instanceof kotlinx.coroutines.flow.FlowKt__TransformKt$filterIsInstance$$inlined$filter$1.AnonymousClass2.AnonymousClass1
                if (r0 == 0) goto L13
                r0 = r7
                kotlinx.coroutines.flow.FlowKt__TransformKt$filterIsInstance$$inlined$filter$1$2$1 r0 = (kotlinx.coroutines.flow.FlowKt__TransformKt$filterIsInstance$$inlined$filter$1.AnonymousClass2.AnonymousClass1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.label = r1
                goto L18
            L13:
                kotlinx.coroutines.flow.FlowKt__TransformKt$filterIsInstance$$inlined$filter$1$2$1 r0 = new kotlinx.coroutines.flow.FlowKt__TransformKt$filterIsInstance$$inlined$filter$1$2$1
                r0.<init>(r7)
            L18:
                java.lang.Object r7 = r0.result
                java.lang.Object r1 = h.e2.j.b.h()
                int r2 = r0.label
                r3 = 1
                if (r2 == 0) goto L47
                if (r2 != r3) goto L3f
                java.lang.Object r6 = r0.L$6
                i.b.v3.f r6 = (i.b.v3.f) r6
                java.lang.Object r6 = r0.L$5
                java.lang.Object r6 = r0.L$4
                kotlinx.coroutines.flow.FlowKt__TransformKt$filterIsInstance$$inlined$filter$1$2$1 r6 = (kotlinx.coroutines.flow.FlowKt__TransformKt$filterIsInstance$$inlined$filter$1.AnonymousClass2.AnonymousClass1) r6
                java.lang.Object r6 = r0.L$3
                java.lang.Object r6 = r0.L$2
                kotlinx.coroutines.flow.FlowKt__TransformKt$filterIsInstance$$inlined$filter$1$2$1 r6 = (kotlinx.coroutines.flow.FlowKt__TransformKt$filterIsInstance$$inlined$filter$1.AnonymousClass2.AnonymousClass1) r6
                java.lang.Object r6 = r0.L$1
                java.lang.Object r6 = r0.L$0
                kotlinx.coroutines.flow.FlowKt__TransformKt$filterIsInstance$$inlined$filter$1$2 r6 = (kotlinx.coroutines.flow.FlowKt__TransformKt$filterIsInstance$$inlined$filter$1.AnonymousClass2) r6
                h.r0.n(r7)
                goto L75
            L3f:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r7)
                throw r6
            L47:
                h.r0.n(r7)
                i.b.v3.f r7 = r5.a
                r2 = 3
                java.lang.String r4 = "R"
                h.k2.v.f0.y(r2, r4)
                boolean r2 = r6 instanceof java.lang.Object
                java.lang.Boolean r2 = h.e2.k.a.a.a(r2)
                boolean r2 = r2.booleanValue()
                if (r2 == 0) goto L78
                r0.L$0 = r5
                r0.L$1 = r6
                r0.L$2 = r0
                r0.L$3 = r6
                r0.L$4 = r0
                r0.L$5 = r6
                r0.L$6 = r7
                r0.label = r3
                java.lang.Object r6 = r7.emit(r6, r0)
                if (r6 != r1) goto L75
                return r1
            L75:
                h.t1 r6 = h.t1.a
                goto L7a
            L78:
                h.t1 r6 = h.t1.a
            L7a:
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__TransformKt$filterIsInstance$$inlined$filter$1.AnonymousClass2.emit(java.lang.Object, h.e2.c):java.lang.Object");
        }
    }

    public FlowKt__TransformKt$filterIsInstance$$inlined$filter$1(Flow flow) {
        this.a = flow;
    }

    @Override // kotlinx.coroutines.flow.Flow
    @k.e.a.e
    public Object e(@k.e.a.d f<? super Object> fVar, @k.e.a.d c cVar) {
        Flow flow = this.a;
        f0.w();
        Object e2 = flow.e(new AnonymousClass2(fVar, this), cVar);
        return e2 == b.h() ? e2 : t1.a;
    }

    @k.e.a.e
    public Object h(@k.e.a.d f fVar, @k.e.a.d c cVar) {
        c0.e(4);
        new ContinuationImpl(cVar) { // from class: kotlinx.coroutines.flow.FlowKt__TransformKt$filterIsInstance$$inlined$filter$1.1
            public int label;
            public /* synthetic */ Object result;

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @k.e.a.e
            public final Object invokeSuspend(@k.e.a.d Object obj) {
                this.result = obj;
                this.label |= Integer.MIN_VALUE;
                return FlowKt__TransformKt$filterIsInstance$$inlined$filter$1.this.e(null, this);
            }
        };
        c0.e(5);
        Flow flow = this.a;
        f0.w();
        AnonymousClass2 anonymousClass2 = new AnonymousClass2(fVar, this);
        c0.e(0);
        flow.e(anonymousClass2, cVar);
        c0.e(2);
        c0.e(1);
        return t1.a;
    }
}
