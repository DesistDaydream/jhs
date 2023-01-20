package e.l.q.b.b.a;

import android.text.TextWatcher;

/* loaded from: classes2.dex */
public interface d {

    /* loaded from: classes2.dex */
    public static final class a {
        public static /* synthetic */ Float a(d dVar, boolean z, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 1) != 0) {
                    z = false;
                }
                return dVar.c(z);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getPrice");
        }

        public static /* synthetic */ int b(d dVar, boolean z, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 1) != 0) {
                    z = false;
                }
                return dVar.a(z);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getQuantity");
        }

        public static /* synthetic */ String c(d dVar, boolean z, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 1) != 0) {
                    z = false;
                }
                return dVar.d(z);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getRemark");
        }
    }

    int a(boolean z);

    @k.e.a.d
    TextWatcher b();

    @k.e.a.e
    Float c(boolean z);

    @k.e.a.d
    String d(boolean z);

    int e();
}
