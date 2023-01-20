package org.conscrypt;

import java.util.Objects;

/* loaded from: classes4.dex */
public final class Preconditions {
    private Preconditions() {
    }

    private static String badPositionIndex(int i2, int i3, String str) {
        if (i2 < 0) {
            return String.format("%s (%s) must not be negative", str, Integer.valueOf(i2));
        }
        if (i3 >= 0) {
            return String.format("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i2), Integer.valueOf(i3));
        }
        throw new IllegalArgumentException("negative size: " + i3);
    }

    private static String badPositionIndexes(int i2, int i3, int i4) {
        if (i2 < 0 || i2 > i4) {
            return badPositionIndex(i2, i4, "start index");
        }
        return (i3 < 0 || i3 > i4) ? badPositionIndex(i3, i4, "end index") : String.format("end index (%s) must not be less than start index (%s)", Integer.valueOf(i3), Integer.valueOf(i2));
    }

    public static void checkArgument(boolean z, String str) {
        if (!z) {
            throw new IllegalArgumentException(str);
        }
    }

    public static <T> T checkNotNull(T t, String str) {
        Objects.requireNonNull(t, str);
        return t;
    }

    public static void checkPositionIndexes(int i2, int i3, int i4) {
        if (i2 < 0 || i3 < i2 || i3 > i4) {
            throw new IndexOutOfBoundsException(badPositionIndexes(i2, i3, i4));
        }
    }

    public static void checkArgument(boolean z, String str, Object obj) {
        if (!z) {
            throw new IllegalArgumentException(String.format(str, obj));
        }
    }
}
