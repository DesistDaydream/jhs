package kotlinx.coroutines.internal;

import com.huawei.hms.push.e;
import h.k2.u.l;
import h.r0;
import java.lang.reflect.Constructor;
import k.e.a.d;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0003\n\u0002\b\u0005\u0010\u0005\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"", e.a, "invoke", "(Ljava/lang/Throwable;)Ljava/lang/Throwable;", "kotlinx/coroutines/internal/ExceptionsConstuctorKt$safeCtor$1", "<anonymous>"}, k = 3, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class ExceptionsConstuctorKt$createConstructor$$inlined$safeCtor$2 extends Lambda implements l<Throwable, Throwable> {
    public final /* synthetic */ Constructor $constructor$inlined;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExceptionsConstuctorKt$createConstructor$$inlined$safeCtor$2(Constructor constructor) {
        super(1);
        this.$constructor$inlined = constructor;
    }

    @Override // h.k2.u.l
    @k.e.a.e
    public final Throwable invoke(@d Throwable th) {
        Object m106constructorimpl;
        Object newInstance;
        try {
            Result.a aVar = Result.Companion;
            newInstance = this.$constructor$inlined.newInstance(th);
        } catch (Throwable th2) {
            Result.a aVar2 = Result.Companion;
            m106constructorimpl = Result.m106constructorimpl(r0.a(th2));
        }
        if (newInstance != null) {
            m106constructorimpl = Result.m106constructorimpl((Throwable) newInstance);
            if (Result.m112isFailureimpl(m106constructorimpl)) {
                m106constructorimpl = null;
            }
            return (Throwable) m106constructorimpl;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Throwable");
    }
}
