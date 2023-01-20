package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import h.e2.c;
import h.e2.j.b;
import h.e2.k.a.a;
import h.e2.k.a.d;
import h.k2.u.p;
import h.r0;
import h.t1;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@d(c = "kotlinx.coroutines.flow.FlowKt__ErrorsKt$retry$1", f = "Errors.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "", AdvanceSetting.NETWORK_TYPE, "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class FlowKt__ErrorsKt$retry$1 extends SuspendLambda implements p<Throwable, c<? super Boolean>, Object> {
    public int label;
    private Throwable p$0;

    public FlowKt__ErrorsKt$retry$1(c cVar) {
        super(2, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k.e.a.d
    public final c<t1> create(@e Object obj, @k.e.a.d c<?> cVar) {
        FlowKt__ErrorsKt$retry$1 flowKt__ErrorsKt$retry$1 = new FlowKt__ErrorsKt$retry$1(cVar);
        flowKt__ErrorsKt$retry$1.p$0 = (Throwable) obj;
        return flowKt__ErrorsKt$retry$1;
    }

    @Override // h.k2.u.p
    public final Object invoke(Throwable th, c<? super Boolean> cVar) {
        return ((FlowKt__ErrorsKt$retry$1) create(th, cVar)).invokeSuspend(t1.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @e
    public final Object invokeSuspend(@k.e.a.d Object obj) {
        b.h();
        if (this.label == 0) {
            r0.n(obj);
            return a.a(true);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
