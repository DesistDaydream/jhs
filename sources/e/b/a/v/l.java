package e.b.a.v;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Collection;
import java.util.Objects;

/* loaded from: classes.dex */
public final class l {
    private l() {
    }

    public static void a(boolean z, @NonNull String str) {
        if (!z) {
            throw new IllegalArgumentException(str);
        }
    }

    @NonNull
    public static String b(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Must not be null or empty");
        }
        return str;
    }

    @NonNull
    public static <T extends Collection<Y>, Y> T c(@NonNull T t) {
        if (t.isEmpty()) {
            throw new IllegalArgumentException("Must not be empty.");
        }
        return t;
    }

    @NonNull
    public static <T> T d(@Nullable T t) {
        return (T) e(t, "Argument must not be null");
    }

    @NonNull
    public static <T> T e(@Nullable T t, @NonNull String str) {
        Objects.requireNonNull(t, str);
        return t;
    }
}
