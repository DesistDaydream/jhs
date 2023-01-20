package kotlin.reflect.full;

import h.k2.u.a;
import h.p2.d;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.KClassImpl;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Ljava/lang/reflect/Type;", "invoke"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class KClasses$defaultType$1 extends Lambda implements a<Type> {
    public final /* synthetic */ d $this_defaultType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KClasses$defaultType$1(d dVar) {
        super(0);
        this.$this_defaultType = dVar;
    }

    @Override // h.k2.u.a
    @k.e.a.d
    public final Type invoke() {
        return ((KClassImpl) this.$this_defaultType).d();
    }
}
