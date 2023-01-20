package e.j.e.s;

import java.util.Objects;

/* loaded from: classes2.dex */
public final class a {
    private a() {
        throw new UnsupportedOperationException();
    }

    public static void a(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }

    public static <T> T b(T t) {
        Objects.requireNonNull(t);
        return t;
    }
}
