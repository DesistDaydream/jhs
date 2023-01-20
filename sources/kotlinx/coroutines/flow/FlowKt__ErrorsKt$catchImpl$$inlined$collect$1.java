package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import h.e2.c;
import h.e2.k.a.d;
import i.b.v3.f;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Ref;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Li/b/v3/f;", "value", "Lh/t1;", "emit", "(Ljava/lang/Object;Lh/e2/c;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class FlowKt__ErrorsKt$catchImpl$$inlined$collect$1 implements f<T> {
    public final /* synthetic */ f a;
    public final /* synthetic */ Ref.ObjectRef b;

    @d(c = "kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$$inlined$collect$1", f = "Errors.kt", i = {0, 0, 0, 0}, l = {134}, m = "emit", n = {"this", "value", "continuation", AdvanceSetting.NETWORK_TYPE}, s = {"L$0", "L$1", "L$2", "L$3"})
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0096@¨\u0006\u0006"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "value", "Lh/e2/c;", "Lh/t1;", "continuation", "", "kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3$emit$1", "emit"}, k = 3, mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$$inlined$collect$1$1  reason: invalid class name */
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
            return FlowKt__ErrorsKt$catchImpl$$inlined$collect$1.this.emit(null, this);
        }
    }

    public FlowKt__ErrorsKt$catchImpl$$inlined$collect$1(f fVar, Ref.ObjectRef objectRef) {
        this.a = fVar;
        this.b = objectRef;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003f  */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r6v4, types: [java.lang.Throwable, T] */
    /* JADX WARN: Type inference failed for: r6v6, types: [java.lang.Throwable] */
    @Override // i.b.v3.f
    @k.e.a.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object emit(java.lang.Object r5, @k.e.a.d h.e2.c r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$$inlined$collect$1.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r6
            kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$$inlined$collect$1$1 r0 = (kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$$inlined$collect$1.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$$inlined$collect$1$1 r0 = new kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$$inlined$collect$1$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = h.e2.j.b.h()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3f
            if (r2 != r3) goto L37
            java.lang.Object r5 = r0.L$3
            java.lang.Object r5 = r0.L$2
            h.e2.c r5 = (h.e2.c) r5
            java.lang.Object r5 = r0.L$1
            java.lang.Object r5 = r0.L$0
            kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$$inlined$collect$1 r5 = (kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$$inlined$collect$1) r5
            h.r0.n(r6)     // Catch: java.lang.Throwable -> L35
            goto L55
        L35:
            r6 = move-exception
            goto L5a
        L37:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L3f:
            h.r0.n(r6)
            i.b.v3.f r6 = r4.a     // Catch: java.lang.Throwable -> L58
            r0.L$0 = r4     // Catch: java.lang.Throwable -> L58
            r0.L$1 = r5     // Catch: java.lang.Throwable -> L58
            r0.L$2 = r0     // Catch: java.lang.Throwable -> L58
            r0.L$3 = r5     // Catch: java.lang.Throwable -> L58
            r0.label = r3     // Catch: java.lang.Throwable -> L58
            java.lang.Object r5 = r6.emit(r5, r0)     // Catch: java.lang.Throwable -> L58
            if (r5 != r1) goto L55
            return r1
        L55:
            h.t1 r5 = h.t1.a
            return r5
        L58:
            r6 = move-exception
            r5 = r4
        L5a:
            kotlin.jvm.internal.Ref$ObjectRef r5 = r5.b
            r5.element = r6
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$$inlined$collect$1.emit(java.lang.Object, h.e2.c):java.lang.Object");
    }
}
