package h.t2.b0;

import com.caverock.androidsvg.SVG;
import h.k2.g;
import h.s0;
import h.t2.h;
import h.t2.i;
import h.t2.j;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;

@g(name = "RegexExtensionsJDK8Kt")
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u0017\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\u0002¨\u0006\u0005"}, d2 = {"get", "Lkotlin/text/MatchGroup;", "Lkotlin/text/MatchGroupCollection;", "name", "", "kotlin-stdlib-jdk8"}, k = 2, mv = {1, 5, 1}, pn = "kotlin.text")
/* loaded from: classes4.dex */
public final class a {
    @e
    @s0(version = SVG.f2474i)
    public static final h a(@d i iVar, @d String str) {
        if (!(iVar instanceof j)) {
            iVar = null;
        }
        j jVar = (j) iVar;
        if (jVar != null) {
            return jVar.get(str);
        }
        throw new UnsupportedOperationException("Retrieving groups by name is not supported on this platform.");
    }
}
