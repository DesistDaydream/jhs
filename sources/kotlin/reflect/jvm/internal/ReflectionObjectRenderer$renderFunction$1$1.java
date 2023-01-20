package kotlin.reflect.jvm.internal;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import h.k2.u.l;
import h.p2.b0.g.t.c.v0;
import k.e.a.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", AdvanceSetting.NETWORK_TYPE, "Lkotlin/reflect/jvm/internal/impl/descriptors/ValueParameterDescriptor;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class ReflectionObjectRenderer$renderFunction$1$1 extends Lambda implements l<v0, CharSequence> {
    public static final ReflectionObjectRenderer$renderFunction$1$1 INSTANCE = new ReflectionObjectRenderer$renderFunction$1$1();

    public ReflectionObjectRenderer$renderFunction$1$1() {
        super(1);
    }

    @Override // h.k2.u.l
    @d
    public final CharSequence invoke(v0 v0Var) {
        return ReflectionObjectRenderer.b.h(v0Var.getType());
    }
}
