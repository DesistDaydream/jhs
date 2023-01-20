package e.t.u;

import android.os.Build;
import h.t1;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u000e\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u000e\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\"\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\tH\u0086\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\n"}, d2 = {"isSdkAtLeast", "", "api", "", "isSdkAtMost", "isSdkLessThan", "sdkFrom", "", "action", "Lkotlin/Function0;", "vector_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class y {
    public static final boolean a(int i2) {
        return Build.VERSION.SDK_INT >= i2;
    }

    public static final boolean b(int i2) {
        return Build.VERSION.SDK_INT <= i2;
    }

    public static final boolean c(int i2) {
        return Build.VERSION.SDK_INT < i2;
    }

    public static final void d(int i2, @k.e.a.d h.k2.u.a<t1> aVar) {
        if (Build.VERSION.SDK_INT >= i2) {
            aVar.invoke();
        }
    }
}
