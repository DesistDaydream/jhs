package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import com.huawei.hms.push.e;
import h.e2.c;
import h.e2.j.b;
import h.e2.k.a.d;
import h.t1;
import i.b.v3.f;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Ref;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J!\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "Li/b/v3/f;", "collector", "Lh/t1;", e.a, "(Li/b/v3/f;Lh/e2/c;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class FlowKt__LimitKt$take$$inlined$unsafeFlow$1 implements Flow<T> {
    public final /* synthetic */ Flow a;
    public final /* synthetic */ int b;

    @d(c = "kotlinx.coroutines.flow.FlowKt__LimitKt$take$$inlined$unsafeFlow$1", f = "Limit.kt", i = {0, 0, 0, 0, 0, 0}, l = {116}, m = "collect", n = {"this", "collector", "continuation", "$receiver", "consumed", "$this$collect$iv"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5"})
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0006\"\u0004\b\u0000\u0010\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0096@¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Li/b/v3/f;", "collector", "Lh/e2/c;", "Lh/t1;", "continuation", "", "collect", "(Li/b/v3/f;Lh/e2/c;)Ljava/lang/Object;", "kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1$collect$1"}, k = 3, mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__LimitKt$take$$inlined$unsafeFlow$1$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static final class AnonymousClass1 extends ContinuationImpl {
        public Object L$0;
        public Object L$1;
        public Object L$2;
        public Object L$3;
        public Object L$4;
        public Object L$5;
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
            return FlowKt__LimitKt$take$$inlined$unsafeFlow$1.this.e(null, this);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006¸\u0006\u0007"}, d2 = {"kotlinx/coroutines/flow/FlowKt__LimitKt$take$$inlined$unsafeFlow$1$a", "Li/b/v3/f;", "value", "Lh/t1;", "emit", "(Ljava/lang/Object;Lh/e2/c;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__LimitKt$$special$$inlined$collect$3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class a implements f<T> {
        public final /* synthetic */ f a;
        public final /* synthetic */ Ref.IntRef b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ FlowKt__LimitKt$take$$inlined$unsafeFlow$1 f16951c;

        public a(f fVar, Ref.IntRef intRef, FlowKt__LimitKt$take$$inlined$unsafeFlow$1 flowKt__LimitKt$take$$inlined$unsafeFlow$1) {
            this.a = fVar;
            this.b = intRef;
            this.f16951c = flowKt__LimitKt$take$$inlined$unsafeFlow$1;
        }

        @Override // i.b.v3.f
        @k.e.a.e
        public Object emit(Object obj, @k.e.a.d c cVar) {
            Ref.IntRef intRef = this.b;
            int i2 = intRef.element + 1;
            intRef.element = i2;
            if (i2 < this.f16951c.b) {
                Object emit = this.a.emit(obj, cVar);
                return emit == b.h() ? emit : t1.a;
            }
            Object e2 = FlowKt__LimitKt.e(this.a, obj, cVar);
            return e2 == b.h() ? e2 : t1.a;
        }
    }

    public FlowKt__LimitKt$take$$inlined$unsafeFlow$1(Flow flow, int i2) {
        this.a = flow;
        this.b = i2;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:1|(2:3|(7:5|6|7|(1:(2:10|11)(2:17|18))(3:19|20|(1:22))|12|13|14))|25|6|7|(0)(0)|12|13|14) */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0070, code lost:
        r7 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0071, code lost:
        i.b.v3.c0.i.b(r7, r6);
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0049  */
    @Override // kotlinx.coroutines.flow.Flow
    @k.e.a.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object e(@k.e.a.d i.b.v3.f r6, @k.e.a.d h.e2.c r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof kotlinx.coroutines.flow.FlowKt__LimitKt$take$$inlined$unsafeFlow$1.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r7
            kotlinx.coroutines.flow.FlowKt__LimitKt$take$$inlined$unsafeFlow$1$1 r0 = (kotlinx.coroutines.flow.FlowKt__LimitKt$take$$inlined$unsafeFlow$1.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__LimitKt$take$$inlined$unsafeFlow$1$1 r0 = new kotlinx.coroutines.flow.FlowKt__LimitKt$take$$inlined$unsafeFlow$1$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = h.e2.j.b.h()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L49
            if (r2 != r3) goto L41
            java.lang.Object r6 = r0.L$5
            kotlinx.coroutines.flow.Flow r6 = (kotlinx.coroutines.flow.Flow) r6
            java.lang.Object r6 = r0.L$4
            kotlin.jvm.internal.Ref$IntRef r6 = (kotlin.jvm.internal.Ref.IntRef) r6
            java.lang.Object r6 = r0.L$3
            i.b.v3.f r6 = (i.b.v3.f) r6
            java.lang.Object r1 = r0.L$2
            h.e2.c r1 = (h.e2.c) r1
            java.lang.Object r1 = r0.L$1
            i.b.v3.f r1 = (i.b.v3.f) r1
            java.lang.Object r0 = r0.L$0
            kotlinx.coroutines.flow.FlowKt__LimitKt$take$$inlined$unsafeFlow$1 r0 = (kotlinx.coroutines.flow.FlowKt__LimitKt$take$$inlined$unsafeFlow$1) r0
            h.r0.n(r7)     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L70
            goto L74
        L41:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L49:
            h.r0.n(r7)
            kotlin.jvm.internal.Ref$IntRef r7 = new kotlin.jvm.internal.Ref$IntRef
            r7.<init>()
            r2 = 0
            r7.element = r2
            kotlinx.coroutines.flow.Flow r2 = r5.a     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L70
            kotlinx.coroutines.flow.FlowKt__LimitKt$take$$inlined$unsafeFlow$1$a r4 = new kotlinx.coroutines.flow.FlowKt__LimitKt$take$$inlined$unsafeFlow$1$a     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L70
            r4.<init>(r6, r7, r5)     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L70
            r0.L$0 = r5     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L70
            r0.L$1 = r6     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L70
            r0.L$2 = r0     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L70
            r0.L$3 = r6     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L70
            r0.L$4 = r7     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L70
            r0.L$5 = r2     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L70
            r0.label = r3     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L70
            java.lang.Object r6 = r2.e(r4, r0)     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L70
            if (r6 != r1) goto L74
            return r1
        L70:
            r7 = move-exception
            i.b.v3.c0.i.b(r7, r6)
        L74:
            h.t1 r6 = h.t1.a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__LimitKt$take$$inlined$unsafeFlow$1.e(i.b.v3.f, h.e2.c):java.lang.Object");
    }
}
