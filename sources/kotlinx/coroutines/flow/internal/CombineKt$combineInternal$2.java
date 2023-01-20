package kotlinx.coroutines.flow.internal;

import androidx.exifinterface.media.ExifInterface;
import com.tencent.qcloud.tuikit.tuichat.component.camera.view.CameraInterface;
import h.e2.c;
import h.e2.j.b;
import h.e2.k.a.d;
import h.k2.u.a;
import h.k2.u.p;
import h.k2.u.q;
import h.r0;
import h.t1;
import i.b.n0;
import i.b.t3.c0;
import i.b.t3.l;
import i.b.v3.f;
import java.util.concurrent.atomic.AtomicInteger;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.flow.Flow;

@d(c = "kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2", f = "Combine.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, l = {57, 79, 82}, m = "invokeSuspend", n = {"$this$flowScope", "size", "latestValues", "resultChannel", "nonClosed", "remainingAbsentValues", "lastReceivedEpoch", "currentEpoch", "$this$flowScope", "size", "latestValues", "resultChannel", "nonClosed", "remainingAbsentValues", "lastReceivedEpoch", "currentEpoch", "element", "results", "$this$flowScope", "size", "latestValues", "resultChannel", "nonClosed", "remainingAbsentValues", "lastReceivedEpoch", "currentEpoch", "element", "results"}, s = {"L$0", "I$0", "L$1", "L$2", "L$3", "I$1", "L$4", "B$0", "L$0", "I$0", "L$1", "L$2", "L$3", "I$1", "L$4", "I$2", "L$5", "L$6", "L$0", "I$0", "L$1", "L$2", "L$3", "I$1", "L$4", "I$2", "L$5", "L$6"})
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"R", ExifInterface.GPS_DIRECTION_TRUE, "Li/b/n0;", "Lh/t1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class CombineKt$combineInternal$2 extends SuspendLambda implements p<n0, c<? super t1>, Object> {
    public final /* synthetic */ a $arrayFactory;
    public final /* synthetic */ Flow[] $flows;
    public final /* synthetic */ f $this_combineInternal;
    public final /* synthetic */ q $transform;
    public byte B$0;
    public int I$0;
    public int I$1;
    public int I$2;
    public Object L$0;
    public Object L$1;
    public Object L$2;
    public Object L$3;
    public Object L$4;
    public Object L$5;
    public Object L$6;
    public int label;
    private n0 p$;

    @d(c = "kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1", f = "Combine.kt", i = {0, 0}, l = {CameraInterface.TYPE_CAPTURE}, m = "invokeSuspend", n = {"$this$launch", "$this$collect$iv"}, s = {"L$0", "L$1"})
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"R", ExifInterface.GPS_DIRECTION_TRUE, "Li/b/n0;", "Lh/t1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements p<n0, c<? super t1>, Object> {
        public final /* synthetic */ int $i;
        public final /* synthetic */ AtomicInteger $nonClosed;
        public final /* synthetic */ l $resultChannel;
        public Object L$0;
        public Object L$1;
        public int label;
        private n0 p$;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(int i2, l lVar, AtomicInteger atomicInteger, c cVar) {
            super(2, cVar);
            this.$i = i2;
            this.$resultChannel = lVar;
            this.$nonClosed = atomicInteger;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @k.e.a.d
        public final c<t1> create(@e Object obj, @k.e.a.d c<?> cVar) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$i, this.$resultChannel, this.$nonClosed, cVar);
            anonymousClass1.p$ = (n0) obj;
            return anonymousClass1;
        }

        @Override // h.k2.u.p
        public final Object invoke(n0 n0Var, c<? super t1> cVar) {
            return ((AnonymousClass1) create(n0Var, cVar)).invokeSuspend(t1.a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @e
        public final Object invokeSuspend(@k.e.a.d Object obj) {
            AtomicInteger atomicInteger;
            Object h2 = b.h();
            int i2 = this.label;
            try {
                if (i2 == 0) {
                    r0.n(obj);
                    n0 n0Var = this.p$;
                    Flow flow = CombineKt$combineInternal$2.this.$flows[this.$i];
                    CombineKt$combineInternal$2$1$invokeSuspend$$inlined$collect$1 combineKt$combineInternal$2$1$invokeSuspend$$inlined$collect$1 = new CombineKt$combineInternal$2$1$invokeSuspend$$inlined$collect$1(this);
                    this.L$0 = n0Var;
                    this.L$1 = flow;
                    this.label = 1;
                    if (flow.e(combineKt$combineInternal$2$1$invokeSuspend$$inlined$collect$1, this) == h2) {
                        return h2;
                    }
                } else if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    Flow flow2 = (Flow) this.L$1;
                    n0 n0Var2 = (n0) this.L$0;
                    r0.n(obj);
                }
                if (atomicInteger.decrementAndGet() == 0) {
                    c0.a.a(this.$resultChannel, null, 1, null);
                }
                return t1.a;
            } finally {
                if (this.$nonClosed.decrementAndGet() == 0) {
                    c0.a.a(this.$resultChannel, null, 1, null);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CombineKt$combineInternal$2(f fVar, Flow[] flowArr, a aVar, q qVar, c cVar) {
        super(2, cVar);
        this.$this_combineInternal = fVar;
        this.$flows = flowArr;
        this.$arrayFactory = aVar;
        this.$transform = qVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k.e.a.d
    public final c<t1> create(@e Object obj, @k.e.a.d c<?> cVar) {
        CombineKt$combineInternal$2 combineKt$combineInternal$2 = new CombineKt$combineInternal$2(this.$this_combineInternal, this.$flows, this.$arrayFactory, this.$transform, cVar);
        combineKt$combineInternal$2.p$ = (n0) obj;
        return combineKt$combineInternal$2;
    }

    @Override // h.k2.u.p
    public final Object invoke(n0 n0Var, c<? super t1> cVar) {
        return ((CombineKt$combineInternal$2) create(n0Var, cVar)).invokeSuspend(t1.a);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0119 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x012b A[LOOP:0: B:26:0x012b->B:34:0x014c, LOOP_START, PHI: r2 r5 
      PHI: (r2v6 int) = (r2v5 int), (r2v7 int) binds: [B:25:0x0129, B:34:0x014c] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r5v8 h.a2.i0) = (r5v7 h.a2.i0), (r5v12 h.a2.i0) binds: [B:25:0x0129, B:34:0x014c] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x01d4  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:0x0187 -> B:49:0x01d0). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x01c2 -> B:46:0x01c5). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:47:0x01cd -> B:48:0x01ce). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k.e.a.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(@k.e.a.d java.lang.Object r25) {
        /*
            Method dump skipped, instructions count: 471
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
