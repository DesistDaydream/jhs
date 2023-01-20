package kotlinx.coroutines.sync;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.sync.MutexImpl;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"R", "", AdvanceSetting.NETWORK_TYPE, "Lh/t1;", "invoke", "(Ljava/lang/Throwable;)V", "<anonymous>"}, k = 3, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class MutexImpl$LockSelect$completeResumeLockWaiter$2 extends Lambda implements l<Throwable, t1> {
    public final /* synthetic */ MutexImpl.LockSelect this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MutexImpl$LockSelect$completeResumeLockWaiter$2(MutexImpl.LockSelect lockSelect) {
        super(1);
        this.this$0 = lockSelect;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(Throwable th) {
        invoke2(th);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d Throwable th) {
        MutexImpl.LockSelect lockSelect = this.this$0;
        MutexImpl.this.d(lockSelect.f17007d);
    }
}
