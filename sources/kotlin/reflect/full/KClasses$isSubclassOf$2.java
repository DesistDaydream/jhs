package kotlin.reflect.full;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import h.k2.u.l;
import h.k2.v.f0;
import h.p2.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012\u0016\u0010\u0003\u001a\u0012\u0012\u0002\b\u0003 \u0002*\b\u0012\u0002\b\u0003\u0018\u00010\u00040\u0004H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "kotlin.jvm.PlatformType", AdvanceSetting.NETWORK_TYPE, "Lkotlin/reflect/KClass;", "invoke", "(Lkotlin/reflect/KClass;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class KClasses$isSubclassOf$2 extends Lambda implements l<d<?>, Boolean> {
    public final /* synthetic */ d $base;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KClasses$isSubclassOf$2(d dVar) {
        super(1);
        this.$base = dVar;
    }

    @Override // h.k2.u.l
    public final Boolean invoke(d<?> dVar) {
        return Boolean.valueOf(f0.g(dVar, this.$base));
    }
}
