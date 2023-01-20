package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.util.Objects;

@RequiresApi(21)
/* loaded from: classes.dex */
public class LensFacingConverter {
    private LensFacingConverter() {
    }

    @NonNull
    public static String nameOf(int i2) {
        if (i2 != 0) {
            if (i2 == 1) {
                return "BACK";
            }
            throw new IllegalArgumentException("Unknown lens facing " + i2);
        }
        return "FRONT";
    }

    public static int valueOf(@Nullable String str) {
        Objects.requireNonNull(str, "name cannot be null");
        str.hashCode();
        if (str.equals("BACK")) {
            return 1;
        }
        if (str.equals("FRONT")) {
            return 0;
        }
        throw new IllegalArgumentException("Unknown len facing name " + str);
    }

    @NonNull
    public static Integer[] values() {
        return new Integer[]{0, 1};
    }
}
