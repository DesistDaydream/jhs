package kotlinx.coroutines.debug.internal;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import h.k2.u.l;
import k.e.a.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.debug.internal.DebugProbesImpl;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\n\u0010\u0001\u001a\u0006\u0012\u0002\b\u00030\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlinx/coroutines/debug/internal/DebugProbesImpl$e;", AdvanceSetting.NETWORK_TYPE, "", "invoke", "(Lkotlinx/coroutines/debug/internal/DebugProbesImpl$e;)Z", "<anonymous>"}, k = 3, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class DebugProbesImpl$dumpCoroutinesSynchronized$1$2 extends Lambda implements l<DebugProbesImpl.e<?>, Boolean> {
    public static final DebugProbesImpl$dumpCoroutinesSynchronized$1$2 INSTANCE = new DebugProbesImpl$dumpCoroutinesSynchronized$1$2();

    public DebugProbesImpl$dumpCoroutinesSynchronized$1$2() {
        super(1);
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ Boolean invoke(DebugProbesImpl.e<?> eVar) {
        return Boolean.valueOf(invoke2(eVar));
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final boolean invoke2(@d DebugProbesImpl.e<?> eVar) {
        return !DebugProbesImpl.f16945l.y(eVar);
    }
}
