package kotlin.reflect.jvm.internal;

import h.k2.u.a;
import h.p2.b0.g.t.c.f1.a.f;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.KPackageImpl;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lkotlin/reflect/jvm/internal/impl/resolve/scopes/MemberScope;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class KPackageImpl$Data$scope$2 extends Lambda implements a<MemberScope> {
    public final /* synthetic */ KPackageImpl.Data this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KPackageImpl$Data$scope$2(KPackageImpl.Data data) {
        super(0);
        this.this$0 = data;
    }

    @Override // h.k2.u.a
    public final MemberScope invoke() {
        f c2;
        c2 = this.this$0.c();
        if (c2 != null) {
            return this.this$0.a().c().a(c2);
        }
        return MemberScope.b.b;
    }
}
