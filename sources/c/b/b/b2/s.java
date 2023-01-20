package c.b.b.b2;

import androidx.camera.core.impl.Config;
import java.util.Comparator;

/* loaded from: classes.dex */
public final /* synthetic */ class s implements Comparator {
    public static final /* synthetic */ s a = new s();

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        int compareTo;
        compareTo = ((Config.Option) obj).getId().compareTo(((Config.Option) obj2).getId());
        return compareTo;
    }
}
