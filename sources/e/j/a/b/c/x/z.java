package e.j.a.b.c.x;

import android.text.TextUtils;
import com.google.android.gms.common.api.Scope;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@e.j.a.b.c.m.a
/* loaded from: classes2.dex */
public final class z {
    private z() {
    }

    @e.j.a.b.c.m.a
    public static Set<Scope> a(Collection<String> collection) {
        e.j.a.b.c.r.a0.l(collection, "scopeStrings can't be null.");
        return b((String[]) collection.toArray(new String[collection.size()]));
    }

    @e.j.a.b.c.m.a
    public static Set<Scope> b(String... strArr) {
        e.j.a.b.c.r.a0.l(strArr, "scopeStrings can't be null.");
        HashSet hashSet = new HashSet(strArr.length);
        for (String str : strArr) {
            if (!TextUtils.isEmpty(str)) {
                hashSet.add(new Scope(str));
            }
        }
        return hashSet;
    }

    @e.j.a.b.c.m.a
    public static String[] c(Set<Scope> set) {
        e.j.a.b.c.r.a0.l(set, "scopes can't be null.");
        return d((Scope[]) set.toArray(new Scope[set.size()]));
    }

    @e.j.a.b.c.m.a
    public static String[] d(Scope[] scopeArr) {
        e.j.a.b.c.r.a0.l(scopeArr, "scopes can't be null.");
        String[] strArr = new String[scopeArr.length];
        for (int i2 = 0; i2 < scopeArr.length; i2++) {
            strArr[i2] = scopeArr[i2].getScopeUri();
        }
        return strArr;
    }
}
