package kotlin.reflect.jvm.internal;

import com.moor.imkf.lib.jsoup.nodes.Attributes;
import h.k2.u.a;
import h.p2.b0.g.t.c.f1.a.f;
import h.t2.u;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.KPackageImpl;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Ljava/lang/Class;", "invoke"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class KPackageImpl$Data$multifileFacade$2 extends Lambda implements a<Class<?>> {
    public final /* synthetic */ KPackageImpl.Data this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KPackageImpl$Data$multifileFacade$2(KPackageImpl.Data data) {
        super(0);
        this.this$0 = data;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h.k2.u.a
    @e
    public final Class<?> invoke() {
        f c2;
        KotlinClassHeader c3;
        c2 = this.this$0.c();
        String e2 = (c2 == null || (c3 = c2.c()) == null) ? null : c3.e();
        if (e2 != null) {
            if (e2.length() > 0) {
                return KPackageImpl.this.d().getClassLoader().loadClass(u.j2(e2, Attributes.InternalPrefix, '.', false, 4, null));
            }
            return null;
        }
        return null;
    }
}
