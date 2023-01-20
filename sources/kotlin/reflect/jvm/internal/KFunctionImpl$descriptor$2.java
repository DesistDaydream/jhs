package kotlin.reflect.jvm.internal;

import h.k2.u.a;
import h.p2.b0.g.t.c.v;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class KFunctionImpl$descriptor$2 extends Lambda implements a<v> {
    public final /* synthetic */ String $name;
    public final /* synthetic */ KFunctionImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KFunctionImpl$descriptor$2(KFunctionImpl kFunctionImpl, String str) {
        super(0);
        this.this$0 = kFunctionImpl;
        this.$name = str;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h.k2.u.a
    public final v invoke() {
        String str;
        KDeclarationContainerImpl H = this.this$0.H();
        String str2 = this.$name;
        str = this.this$0.f16356i;
        return H.G(str2, str);
    }
}
