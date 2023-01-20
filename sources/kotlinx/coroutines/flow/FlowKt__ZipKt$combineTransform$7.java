package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import h.e2.c;
import h.e2.j.b;
import h.e2.k.a.d;
import h.k2.u.a;
import h.k2.u.p;
import h.k2.u.q;
import h.k2.v.c0;
import h.k2.v.f0;
import h.r0;
import h.t1;
import i.b.v3.f;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.flow.internal.CombineKt;

@d(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$7", f = "Zip.kt", i = {0}, l = {308}, m = "invokeSuspend", n = {"$this$flow"}, s = {"L$0"})
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0006\b\u0000\u0010\u0000\u0018\u0001\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00010\u0002H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "R", "Li/b/v3/f;", "Lh/t1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class FlowKt__ZipKt$combineTransform$7 extends SuspendLambda implements p<f<? super R>, c<? super t1>, Object> {
    public final /* synthetic */ Flow[] $flowArray;
    public final /* synthetic */ q $transform;
    public Object L$0;
    public int label;
    private f p$;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0018\u00010\u0002\"\u0006\b\u0000\u0010\u0000\u0018\u0001\"\u0004\b\u0001\u0010\u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "R", "", "invoke", "()[Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$7$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static final class AnonymousClass1 extends Lambda implements a<T[]> {
        public AnonymousClass1() {
            super(0);
        }

        /* JADX WARN: Type inference failed for: r0v3, types: [T[], java.lang.Object[]] */
        @Override // h.k2.u.a
        @e
        public final T[] invoke() {
            int length = FlowKt__ZipKt$combineTransform$7.this.$flowArray.length;
            f0.y(0, "T?");
            return new Object[length];
        }
    }

    @d(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$7$2", f = "Zip.kt", i = {0, 0}, l = {308}, m = "invokeSuspend", n = {"$this$combineInternal", AdvanceSetting.NETWORK_TYPE}, s = {"L$0", "L$1"})
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u0005\"\u0006\b\u0000\u0010\u0000\u0018\u0001\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u008a@¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "R", "Li/b/v3/f;", "", AdvanceSetting.NETWORK_TYPE, "Lh/t1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$7$2  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements q<f<? super R>, T[], c<? super t1>, Object> {
        public Object L$0;
        public Object L$1;
        public int label;
        private f p$;
        private Object[] p$0;

        public AnonymousClass2(c cVar) {
            super(3, cVar);
        }

        @k.e.a.d
        public final c<t1> create(@k.e.a.d f<? super R> fVar, @k.e.a.d T[] tArr, @k.e.a.d c<? super t1> cVar) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(cVar);
            anonymousClass2.p$ = fVar;
            anonymousClass2.p$0 = tArr;
            return anonymousClass2;
        }

        @Override // h.k2.u.q
        public final Object invoke(Object obj, Object obj2, c<? super t1> cVar) {
            return ((AnonymousClass2) create((f) obj, (Object[]) obj2, cVar)).invokeSuspend(t1.a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @e
        public final Object invokeSuspend(@k.e.a.d Object obj) {
            Object h2 = b.h();
            int i2 = this.label;
            if (i2 == 0) {
                r0.n(obj);
                f fVar = this.p$;
                Object[] objArr = this.p$0;
                q qVar = FlowKt__ZipKt$combineTransform$7.this.$transform;
                this.L$0 = fVar;
                this.L$1 = objArr;
                this.label = 1;
                if (qVar.invoke(fVar, objArr, this) == h2) {
                    return h2;
                }
            } else if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                Object[] objArr2 = (Object[]) this.L$1;
                f fVar2 = (f) this.L$0;
                r0.n(obj);
            }
            return t1.a;
        }

        @e
        public final Object invokeSuspend$$forInline(@k.e.a.d Object obj) {
            FlowKt__ZipKt$combineTransform$7.this.$transform.invoke(this.p$, this.p$0, this);
            return t1.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowKt__ZipKt$combineTransform$7(Flow[] flowArr, q qVar, c cVar) {
        super(2, cVar);
        this.$flowArray = flowArr;
        this.$transform = qVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k.e.a.d
    public final c<t1> create(@e Object obj, @k.e.a.d c<?> cVar) {
        FlowKt__ZipKt$combineTransform$7 flowKt__ZipKt$combineTransform$7 = new FlowKt__ZipKt$combineTransform$7(this.$flowArray, this.$transform, cVar);
        flowKt__ZipKt$combineTransform$7.p$ = (f) obj;
        return flowKt__ZipKt$combineTransform$7;
    }

    @Override // h.k2.u.p
    public final Object invoke(Object obj, c<? super t1> cVar) {
        return ((FlowKt__ZipKt$combineTransform$7) create(obj, cVar)).invokeSuspend(t1.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @e
    public final Object invokeSuspend(@k.e.a.d Object obj) {
        Object h2 = b.h();
        int i2 = this.label;
        if (i2 == 0) {
            r0.n(obj);
            f fVar = this.p$;
            Flow[] flowArr = this.$flowArray;
            f0.w();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1();
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(null);
            this.L$0 = fVar;
            this.label = 1;
            if (CombineKt.a(fVar, flowArr, anonymousClass1, anonymousClass2, this) == h2) {
                return h2;
            }
        } else if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            f fVar2 = (f) this.L$0;
            r0.n(obj);
        }
        return t1.a;
    }

    @e
    public final Object invokeSuspend$$forInline(@k.e.a.d Object obj) {
        f fVar = this.p$;
        Flow[] flowArr = this.$flowArray;
        f0.w();
        AnonymousClass1 anonymousClass1 = new AnonymousClass1();
        AnonymousClass2 anonymousClass2 = new AnonymousClass2(null);
        c0.e(0);
        CombineKt.a(fVar, flowArr, anonymousClass1, anonymousClass2, this);
        c0.e(2);
        c0.e(1);
        return t1.a;
    }
}
