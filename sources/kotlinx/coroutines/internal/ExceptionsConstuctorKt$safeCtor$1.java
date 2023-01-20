package kotlinx.coroutines.internal;

import com.huawei.hms.push.e;
import h.k2.u.l;
import h.r0;
import k.e.a.d;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0003\n\u0002\b\u0004\u0010\u0004\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", e.a, "invoke", "(Ljava/lang/Throwable;)Ljava/lang/Throwable;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class ExceptionsConstuctorKt$safeCtor$1 extends Lambda implements l<Throwable, Throwable> {
    public final /* synthetic */ l $block;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExceptionsConstuctorKt$safeCtor$1(l lVar) {
        super(1);
        this.$block = lVar;
    }

    @Override // h.k2.u.l
    @k.e.a.e
    public final Throwable invoke(@d Throwable th) {
        Object m106constructorimpl;
        try {
            Result.a aVar = Result.Companion;
            m106constructorimpl = Result.m106constructorimpl((Throwable) this.$block.invoke(th));
        } catch (Throwable th2) {
            Result.a aVar2 = Result.Companion;
            m106constructorimpl = Result.m106constructorimpl(r0.a(th2));
        }
        if (Result.m112isFailureimpl(m106constructorimpl)) {
            m106constructorimpl = null;
        }
        return (Throwable) m106constructorimpl;
    }
}
