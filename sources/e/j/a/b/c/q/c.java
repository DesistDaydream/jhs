package e.j.a.b.c.q;

import android.net.Uri;
import e.j.a.b.c.r.y;

/* loaded from: classes2.dex */
public final class c {
    public final Uri a;

    public c(Uri uri) {
        this.a = uri;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof c) {
            if (this == obj) {
                return true;
            }
            return y.a(((c) obj).a, this.a);
        }
        return false;
    }

    public final int hashCode() {
        return y.b(this.a);
    }
}
