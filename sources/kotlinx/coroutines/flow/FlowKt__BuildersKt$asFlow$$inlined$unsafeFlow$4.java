package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import com.huawei.hms.push.e;
import h.e2.c;
import h.e2.k.a.d;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J!\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "Li/b/v3/f;", "collector", "Lh/t1;", e.a, "(Li/b/v3/f;Lh/e2/c;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$4 implements Flow<T> {
    public final /* synthetic */ Iterator a;

    @d(c = "kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$4", f = "Builders.kt", i = {0, 0, 0, 0, 0, 0, 0}, l = {115}, m = "collect", n = {"this", "collector", "continuation", "$receiver", "$this$forEach$iv", "element$iv", "value"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$6", "L$7"})
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0006\"\u0004\b\u0000\u0010\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0096@¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Li/b/v3/f;", "collector", "Lh/e2/c;", "Lh/t1;", "continuation", "", "collect", "(Li/b/v3/f;Lh/e2/c;)Ljava/lang/Object;", "kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1$collect$1"}, k = 3, mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$4$1  reason: invalid class name */
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
            return FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$4.this.e(null, this);
        }
    }

    public FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$4(Iterator it) {
        this.a = it;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0067  */
    /* JADX WARN: Type inference failed for: r5v3, types: [h.e2.c] */
    @Override // kotlinx.coroutines.flow.Flow
    @k.e.a.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object e(@k.e.a.d i.b.v3.f r10, @k.e.a.d h.e2.c r11) {
        /*
            r9 = this;
            boolean r0 = r11 instanceof kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$4.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r11
            kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$4$1 r0 = (kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$4.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$4$1 r0 = new kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$4$1
            r0.<init>(r11)
        L18:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = h.e2.j.b.h()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L54
            if (r2 != r3) goto L4c
            java.lang.Object r10 = r0.L$7
            java.lang.Object r10 = r0.L$6
            java.lang.Object r10 = r0.L$5
            java.util.Iterator r10 = (java.util.Iterator) r10
            java.lang.Object r2 = r0.L$4
            java.util.Iterator r2 = (java.util.Iterator) r2
            java.lang.Object r4 = r0.L$3
            i.b.v3.f r4 = (i.b.v3.f) r4
            java.lang.Object r5 = r0.L$2
            h.e2.c r5 = (h.e2.c) r5
            java.lang.Object r6 = r0.L$1
            i.b.v3.f r6 = (i.b.v3.f) r6
            java.lang.Object r7 = r0.L$0
            kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$4 r7 = (kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$4) r7
            h.r0.n(r11)
            r11 = r4
            r4 = r1
            r1 = r0
            r0 = r6
            r8 = r5
            r5 = r2
            r2 = r8
            goto L61
        L4c:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L54:
            h.r0.n(r11)
            java.util.Iterator r11 = r9.a
            r7 = r9
            r5 = r11
            r2 = r0
            r4 = r1
            r1 = r2
            r11 = r10
            r0 = r11
            r10 = r5
        L61:
            boolean r6 = r10.hasNext()
            if (r6 == 0) goto L84
            java.lang.Object r6 = r10.next()
            r1.L$0 = r7
            r1.L$1 = r0
            r1.L$2 = r2
            r1.L$3 = r11
            r1.L$4 = r5
            r1.L$5 = r10
            r1.L$6 = r6
            r1.L$7 = r6
            r1.label = r3
            java.lang.Object r6 = r11.emit(r6, r1)
            if (r6 != r4) goto L61
            return r4
        L84:
            h.t1 r10 = h.t1.a
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$4.e(i.b.v3.f, h.e2.c):java.lang.Object");
    }
}
