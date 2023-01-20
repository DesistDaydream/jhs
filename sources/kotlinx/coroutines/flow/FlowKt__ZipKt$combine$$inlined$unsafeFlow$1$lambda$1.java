package kotlinx.coroutines.flow;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import h.e2.c;
import h.e2.j.b;
import h.k2.u.q;
import h.k2.v.c0;
import h.r0;
import h.t1;
import i.b.v3.f;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u000b\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00020\u00032\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004H\u008a@¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"T1", "T2", "R", "Li/b/v3/f;", "", "", AdvanceSetting.NETWORK_TYPE, "Lh/t1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__ZipKt$combine$1$1", "<anonymous>"}, k = 3, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class FlowKt__ZipKt$combine$$inlined$unsafeFlow$1$lambda$1 extends SuspendLambda implements q<f<? super R>, Object[], c<? super t1>, Object> {
    public Object L$0;
    public Object L$1;
    public Object L$2;
    public int label;
    private f p$;
    private Object[] p$0;
    public final /* synthetic */ FlowKt__ZipKt$combine$$inlined$unsafeFlow$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowKt__ZipKt$combine$$inlined$unsafeFlow$1$lambda$1(c cVar, FlowKt__ZipKt$combine$$inlined$unsafeFlow$1 flowKt__ZipKt$combine$$inlined$unsafeFlow$1) {
        super(3, cVar);
        this.this$0 = flowKt__ZipKt$combine$$inlined$unsafeFlow$1;
    }

    @d
    public final c<t1> create(@d f<? super R> fVar, @d Object[] objArr, @d c<? super t1> cVar) {
        FlowKt__ZipKt$combine$$inlined$unsafeFlow$1$lambda$1 flowKt__ZipKt$combine$$inlined$unsafeFlow$1$lambda$1 = new FlowKt__ZipKt$combine$$inlined$unsafeFlow$1$lambda$1(cVar, this.this$0);
        flowKt__ZipKt$combine$$inlined$unsafeFlow$1$lambda$1.p$ = fVar;
        flowKt__ZipKt$combine$$inlined$unsafeFlow$1$lambda$1.p$0 = objArr;
        return flowKt__ZipKt$combine$$inlined$unsafeFlow$1$lambda$1;
    }

    @Override // h.k2.u.q
    public final Object invoke(Object obj, Object[] objArr, c<? super t1> cVar) {
        return ((FlowKt__ZipKt$combine$$inlined$unsafeFlow$1$lambda$1) create((f) obj, objArr, cVar)).invokeSuspend(t1.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @e
    public final Object invokeSuspend(@d Object obj) {
        f fVar;
        f fVar2;
        Object[] objArr;
        Object h2 = b.h();
        int i2 = this.label;
        if (i2 == 0) {
            r0.n(obj);
            fVar = this.p$;
            Object[] objArr2 = this.p$0;
            q qVar = this.this$0.f16957c;
            Object obj2 = objArr2[0];
            Object obj3 = objArr2[1];
            this.L$0 = fVar;
            this.L$1 = objArr2;
            this.L$2 = fVar;
            this.label = 1;
            c0.e(6);
            Object invoke = qVar.invoke(obj2, obj3, this);
            c0.e(7);
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
}
