package j;

import com.umeng.analytics.pro.am;
import java.util.zip.Deflater;
import kotlin.Metadata;

@h.k2.g(name = "-DeflaterSinkExtensions")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001e\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0001H\u0086\b¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lj/k0;", "Ljava/util/zip/Deflater;", "deflater", "Lj/p;", am.av, "(Lj/k0;Ljava/util/zip/Deflater;)Lj/p;", "okio"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class b {
    @k.e.a.d
    public static final p a(@k.e.a.d k0 k0Var, @k.e.a.d Deflater deflater) {
        return new p(k0Var, deflater);
    }

    public static /* synthetic */ p b(k0 k0Var, Deflater deflater, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            deflater = new Deflater();
        }
        return new p(k0Var, deflater);
    }
}
