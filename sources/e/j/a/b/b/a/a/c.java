package e.j.a.b.b.a.a;

import com.google.android.gms.common.api.Scope;
import java.util.Comparator;

/* loaded from: classes2.dex */
public final /* synthetic */ class c implements Comparator {
    public static final Comparator a = new c();

    private c() {
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        int compareTo;
        compareTo = ((Scope) obj).getScopeUri().compareTo(((Scope) obj2).getScopeUri());
        return compareTo;
    }
}
