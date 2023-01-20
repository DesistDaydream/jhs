package j;

import com.umeng.analytics.pro.am;
import java.util.zip.Inflater;
import kotlin.Metadata;

@h.k2.g(name = "-InflaterSourceExtensions")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001e\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0001H\u0086\b¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lj/m0;", "Ljava/util/zip/Inflater;", "inflater", "Lj/x;", am.av, "(Lj/m0;Ljava/util/zip/Inflater;)Lj/x;", "okio"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class h {
    @k.e.a.d
    public static final x a(@k.e.a.d m0 m0Var, @k.e.a.d Inflater inflater) {
        return new x(m0Var, inflater);
    }

    public static /* synthetic */ x b(m0 m0Var, Inflater inflater, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            inflater = new Inflater();
        }
        return new x(m0Var, inflater);
    }
}
