package c.b.a.d;

import androidx.arch.core.util.Function;
import java.util.List;

/* loaded from: classes.dex */
public final /* synthetic */ class k0 implements Function {
    public static final /* synthetic */ k0 a = new k0();

    @Override // androidx.arch.core.util.Function
    public final Object apply(Object obj) {
        Boolean valueOf;
        valueOf = Boolean.valueOf(((List) obj).contains(Boolean.TRUE));
        return valueOf;
    }
}
