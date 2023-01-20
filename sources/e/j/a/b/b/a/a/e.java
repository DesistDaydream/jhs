package e.j.a.b.b.a.a;

import com.google.android.gms.common.api.Scope;
import java.util.Comparator;

/* loaded from: classes2.dex */
public final class e implements Comparator<Scope> {
    @Override // java.util.Comparator
    public final /* synthetic */ int compare(Scope scope, Scope scope2) {
        return scope.getScopeUri().compareTo(scope2.getScopeUri());
    }
}
