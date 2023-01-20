package kotlinx.coroutines.flow;

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

@d(c = "kotlinx.coroutines.flow.StartedWhileSubscribed$command$2", f = "SharingStarted.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlinx/coroutines/flow/SharingCommand;", AdvanceSetting.NETWORK_TYPE, "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class StartedWhileSubscribed$command$2 extends SuspendLambda implements p<SharingCommand, c<? super Boolean>, Object> {
    public int label;
    private SharingCommand p$0;

    public StartedWhileSubscribed$command$2(c cVar) {
        super(2, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k.e.a.d
    public final c<t1> create(@e Object obj, @k.e.a.d c<?> cVar) {
        StartedWhileSubscribed$command$2 startedWhileSubscribed$command$2 = new StartedWhileSubscribed$command$2(cVar);
        startedWhileSubscribed$command$2.p$0 = (SharingCommand) obj;
        return startedWhileSubscribed$command$2;
    }

    @Override // h.k2.u.p
    public final Object invoke(SharingCommand sharingCommand, c<? super Boolean> cVar) {
        return ((StartedWhileSubscribed$command$2) create(sharingCommand, cVar)).invokeSuspend(t1.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @e
    public final Object invokeSuspend(@k.e.a.d Object obj) {
        b.h();
        if (this.label == 0) {
            r0.n(obj);
            return a.a(this.p$0 != SharingCommand.START);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
