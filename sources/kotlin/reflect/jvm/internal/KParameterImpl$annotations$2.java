package kotlin.reflect.jvm.internal;

import h.k2.u.a;
import h.p2.b0.g.q;
import h.p2.b0.g.t.c.g0;
import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0002\u0010\u0000\u001a\u0016\u0012\u0004\u0012\u00020\u0002 \u0003*\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class KParameterImpl$annotations$2 extends Lambda implements a<List<? extends Annotation>> {
    public final /* synthetic */ KParameterImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KParameterImpl$annotations$2(KParameterImpl kParameterImpl) {
        super(0);
        this.this$0 = kParameterImpl;
    }

    @Override // h.k2.u.a
    public final List<? extends Annotation> invoke() {
        g0 h2;
        h2 = this.this$0.h();
        return q.d(h2);
    }
}
