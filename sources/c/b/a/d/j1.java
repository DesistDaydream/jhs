package c.b.a.d;

import android.util.Size;
import java.util.Comparator;

/* loaded from: classes.dex */
public final /* synthetic */ class j1 implements Comparator {
    public static final /* synthetic */ j1 a = new j1();

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        int signum;
        Size size = (Size) obj;
        Size size2 = (Size) obj2;
        signum = Long.signum((size.getWidth() * size.getHeight()) - (size2.getWidth() * size2.getHeight()));
        return signum;
    }
}
