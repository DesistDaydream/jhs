package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import com.huawei.hms.push.e;
import h.e2.c;
import h.e2.k.a.d;
import h.k2.u.p;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J!\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "Li/b/v3/f;", "collector", "Lh/t1;", e.a, "(Li/b/v3/f;Lh/e2/c;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1 implements Flow<T> {
    public final /* synthetic */ Flow a;
    public final /* synthetic */ p b;

    @d(c = "kotlinx.coroutines.flow.FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1", f = "Emitters.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1}, l = {116, 120}, m = "collect", n = {"this", "collector", "continuation", "$receiver", "safeCollector", "this", "collector", "continuation", "$receiver", "safeCollector"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4"})
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0006\"\u0004\b\u0000\u0010\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0096@¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Li/b/v3/f;", "collector", "Lh/e2/c;", "Lh/t1;", "continuation", "", "collect", "(Li/b/v3/f;Lh/e2/c;)Ljava/lang/Object;", "kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1$collect$1"}, k = 3, mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1$1 */
    /* loaded from: classes4.dex */
    public static final class AnonymousClass1 extends ContinuationImpl {
        public Object L$0;
        public Object L$1;
        public Object L$2;
        public Object L$3;
        public Object L$4;
        public int label;
        public /* synthetic */ Object result;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(c cVar) {
            super(cVar);
            FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1.this = r1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @k.e.a.e
        public final Object invokeSuspend(@k.e.a.d Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1.this.e(null, this);
        }
    }

    public FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1(Flow flow, p pVar) {
        this.a = flow;
        this.b = pVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00a7 A[RETURN] */
    @Override // kotlinx.coroutines.flow.Flow
    @k.e.a.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object e(@k.e.a.d i.b.v3.f r8, @k.e.a.d h.e2.c r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof kotlinx.coroutines.flow.FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r9
            kotlinx.coroutines.flow.FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1$1 r0 = (kotlinx.coroutines.flow.FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1$1 r0 = new kotlinx.coroutines.flow.FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1$1
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = h.e2.j.b.h()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L62
            if (r2 == r4) goto L48
            if (r2 != r3) goto L40
            java.lang.Object r8 = r0.L$4
            kotlinx.coroutines.flow.internal.SafeCollector r8 = (kotlinx.coroutines.flow.internal.SafeCollector) r8
            java.lang.Object r8 = r0.L$3
            i.b.v3.f r8 = (i.b.v3.f) r8
            java.lang.Object r8 = r0.L$2
            h.e2.c r8 = (h.e2.c) r8
            java.lang.Object r8 = r0.L$1
            i.b.v3.f r8 = (i.b.v3.f) r8
            java.lang.Object r8 = r0.L$0
            kotlinx.coroutines.flow.FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1 r8 = (kotlinx.coroutines.flow.FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1) r8
            h.r0.n(r9)
            goto La8
        L40:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L48:
            java.lang.Object r8 = r0.L$4
            kotlinx.coroutines.flow.internal.SafeCollector r8 = (kotlinx.coroutines.flow.internal.SafeCollector) r8
            java.lang.Object r2 = r0.L$3
            i.b.v3.f r2 = (i.b.v3.f) r2
            java.lang.Object r4 = r0.L$2
            h.e2.c r4 = (h.e2.c) r4
            java.lang.Object r5 = r0.L$1
            i.b.v3.f r5 = (i.b.v3.f) r5
            java.lang.Object r6 = r0.L$0
            kotlinx.coroutines.flow.FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1 r6 = (kotlinx.coroutines.flow.FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1) r6
            h.r0.n(r9)     // Catch: java.lang.Throwable -> L60
            goto L90
        L60:
            r9 = move-exception
            goto Lad
        L62:
            h.r0.n(r9)
            kotlin.coroutines.CoroutineContext r9 = r0.getContext()
            kotlinx.coroutines.flow.internal.SafeCollector r2 = new kotlinx.coroutines.flow.internal.SafeCollector
            r2.<init>(r8, r9)
            h.k2.u.p r9 = r7.b     // Catch: java.lang.Throwable -> Lab
            r0.L$0 = r7     // Catch: java.lang.Throwable -> Lab
            r0.L$1 = r8     // Catch: java.lang.Throwable -> Lab
            r0.L$2 = r0     // Catch: java.lang.Throwable -> Lab
            r0.L$3 = r8     // Catch: java.lang.Throwable -> Lab
            r0.L$4 = r2     // Catch: java.lang.Throwable -> Lab
            r0.label = r4     // Catch: java.lang.Throwable -> Lab
            r4 = 6
            h.k2.v.c0.e(r4)     // Catch: java.lang.Throwable -> Lab
            java.lang.Object r9 = r9.invoke(r2, r0)     // Catch: java.lang.Throwable -> Lab
            r4 = 7
            h.k2.v.c0.e(r4)     // Catch: java.lang.Throwable -> Lab
            if (r9 != r1) goto L8b
            return r1
        L8b:
            r6 = r7
            r5 = r8
            r4 = r0
            r8 = r2
            r2 = r5
        L90:
            r8.releaseIntercepted()
            kotlinx.coroutines.flow.Flow r9 = r6.a
            r0.L$0 = r6
            r0.L$1 = r5
            r0.L$2 = r4
            r0.L$3 = r2
            r0.L$4 = r8
            r0.label = r3
            java.lang.Object r8 = r9.e(r2, r0)
            if (r8 != r1) goto La8
            return r1
        La8:
            h.t1 r8 = h.t1.a
            return r8
        Lab:
            r9 = move-exception
            r8 = r2
        Lad:
            r8.releaseIntercepted()
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1.e(i.b.v3.f, h.e2.c):java.lang.Object");
    }
}
