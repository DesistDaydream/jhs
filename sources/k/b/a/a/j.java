package k.b.a.a;

import java.util.Comparator;
import org.apache.commons.codec.EncoderException;

/* loaded from: classes4.dex */
public class j implements Comparator {
    private final i a;

    @Deprecated
    public j() {
        this.a = null;
    }

    @Override // java.util.Comparator
    public int compare(Object obj, Object obj2) {
        try {
            return ((Comparable) this.a.encode(obj)).compareTo((Comparable) this.a.encode(obj2));
        } catch (EncoderException unused) {
            return 0;
        }
    }

    public j(i iVar) {
        this.a = iVar;
    }
}
