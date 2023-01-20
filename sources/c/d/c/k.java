package c.d.c;

import androidx.core.location.LocationManagerCompat;
import java.lang.ref.WeakReference;
import java.util.function.Predicate;

/* loaded from: classes.dex */
public final /* synthetic */ class k implements Predicate {
    public static final /* synthetic */ k a = new k();

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        return LocationManagerCompat.LocationListenerTransport.n((WeakReference) obj);
    }
}
