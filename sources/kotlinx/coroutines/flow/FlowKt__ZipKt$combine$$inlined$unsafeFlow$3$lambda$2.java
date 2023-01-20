package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import h.e2.c;
import h.e2.j.b;
import h.e2.k.a.d;
import h.k2.u.p;
import h.k2.u.q;
import h.k2.v.c0;
import h.r0;
import h.t1;
import i.b.v3.f;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@d(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$unsafeFlow$3$lambda$2", f = "Zip.kt", i = {0, 0, 1, 1}, l = {238, 238}, m = "invokeSuspend", n = {"$this$combineInternal", AdvanceSetting.NETWORK_TYPE, "$this$combineInternal", AdvanceSetting.NETWORK_TYPE}, s = {"L$0", "L$1", "L$0", "L$1"})
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\t\u001a\u00020\u0005\"\u0006\b\u0000\u0010\u0000\u0018\u0001\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u008a@¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "R", "Li/b/v3/f;", "", AdvanceSetting.NETWORK_TYPE, "Lh/t1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__ZipKt$combine$5$2", "<anonymous>"}, k = 3, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class FlowKt__ZipKt$combine$$inlined$unsafeFlow$3$lambda$2 extends SuspendLambda implements q<f<? super R>, T[], c<? super t1>, Object> {
    public Object L$0;
    public Object L$1;
    public Object L$2;
    public int label;
    private f p$;
    private Object[] p$0;
    public final /* synthetic */ FlowKt__ZipKt$combine$$inlined$unsafeFlow$3 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowKt__ZipKt$combine$$inlined$unsafeFlow$3$lambda$2(c cVar, FlowKt__ZipKt$combine$$inlined$unsafeFlow$3 flowKt__ZipKt$combine$$inlined$unsafeFlow$3) {
        super(3, cVar);
        this.this$0 = flowKt__ZipKt$combine$$inlined$unsafeFlow$3;
    }

    @k.e.a.d
    public final c<t1> create(@k.e.a.d f<? super R> fVar, @k.e.a.d T[] tArr, @k.e.a.d c<? super t1> cVar) {
        FlowKt__ZipKt$combine$$inlined$unsafeFlow$3$lambda$2 flowKt__ZipKt$combine$$inlined$unsafeFlow$3$lambda$2 = new FlowKt__ZipKt$combine$$inlined$unsafeFlow$3$lambda$2(cVar, this.this$0);
        flowKt__ZipKt$combine$$inlined$unsafeFlow$3$lambda$2.p$ = fVar;
        flowKt__ZipKt$combine$$inlined$unsafeFlow$3$lambda$2.p$0 = tArr;
        return flowKt__ZipKt$combine$$inlined$unsafeFlow$3$lambda$2;
    }

    @Override // h.k2.u.q
    public final Object invoke(Object obj, Object obj2, c<? super t1> cVar) {
        return ((FlowKt__ZipKt$combine$$inlined$unsafeFlow$3$lambda$2) create((f) obj, (Object[]) obj2, cVar)).invokeSuspend(t1.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @e
    public final Object invokeSuspend(@k.e.a.d Object obj) {
        f fVar;
        f fVar2;
        Object[] objArr;
        Object h2 = b.h();
        int i2 = this.label;
        if (i2 == 0) {
            r0.n(obj);
            fVar = this.p$;
            Object[] objArr2 = this.p$0;
            p pVar = this.this$0.b;
            this.L$0 = fVar;
            this.L$1 = objArr2;
            this.L$2 = fVar;
            this.label = 1;
            Object invoke = pVar.invoke(objArr2, this);
            if (invoke == h2) {
                return h2;
            }
            fVar2 = fVar;
            objArr = objArr2;
            obj = invoke;
        } else if (i2 != 1) {
            if (i2 == 2) {
                Object[] objArr3 = (Object[]) this.L$1;
                f fVar3 = (f) this.L$0;
                r0.n(obj);
                return t1.a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            fVar = (f) this.L$2;
            objArr = (Object[]) this.L$1;
            fVar2 = (f) this.L$0;
            r0.n(obj);
        }
        this.L$0 = fVar2;
        this.L$1 = objArr;
        this.label = 2;
        if (fVar.emit(obj, this) == h2) {
            return h2;
        }
        return t1.a;
    }

    @e
    public final Object invokeSuspend$$forInline(@k.e.a.d Object obj) {
        f fVar = this.p$;
        Object invoke = this.this$0.b.invoke(this.p$0, this);
        c0.e(0);
        fVar.emit(invoke, this);
        c0.e(2);
        c0.e(1);
        return t1.a;
    }
}
