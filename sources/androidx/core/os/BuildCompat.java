package androidx.core.os;

import android.os.Build;
import androidx.annotation.ChecksSdkIntAtLeast;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresOptIn;
import androidx.annotation.RestrictTo;
import androidx.exifinterface.media.ExifInterface;

/* loaded from: classes.dex */
public class BuildCompat {

    @RequiresOptIn
    /* loaded from: classes.dex */
    public @interface PrereleaseSdkCheck {
    }

    private BuildCompat() {
    }

    @ChecksSdkIntAtLeast(api = 24)
    @Deprecated
    public static boolean isAtLeastN() {
        return Build.VERSION.SDK_INT >= 24;
    }

    @ChecksSdkIntAtLeast(api = 25)
    @Deprecated
    public static boolean isAtLeastNMR1() {
        return Build.VERSION.SDK_INT >= 25;
    }

    @ChecksSdkIntAtLeast(api = 26)
    @Deprecated
    public static boolean isAtLeastO() {
        return Build.VERSION.SDK_INT >= 26;
    }

    @ChecksSdkIntAtLeast(api = 27)
    @Deprecated
    public static boolean isAtLeastOMR1() {
        return Build.VERSION.SDK_INT >= 27;
    }

    @ChecksSdkIntAtLeast(api = 28)
    @Deprecated
    public static boolean isAtLeastP() {
        return Build.VERSION.SDK_INT >= 28;
    }

    @RestrictTo({RestrictTo.Scope.TESTS})
    public static boolean isAtLeastPreReleaseCodename(@NonNull String str, @NonNull String str2) {
        return !"REL".equals(str2) && str2.compareTo(str) >= 0;
    }

    @ChecksSdkIntAtLeast(api = 29)
    @Deprecated
    public static boolean isAtLeastQ() {
        return Build.VERSION.SDK_INT >= 29;
    }

    @ChecksSdkIntAtLeast(api = 30)
    @Deprecated
    public static boolean isAtLeastR() {
        return Build.VERSION.SDK_INT >= 30;
    }

    @ChecksSdkIntAtLeast(api = 31, codename = ExifInterface.LATITUDE_SOUTH)
    public static boolean isAtLeastS() {
        return Build.VERSION.SDK_INT >= 31 || isAtLeastPreReleaseCodename(ExifInterface.LATITUDE_SOUTH, Build.VERSION.CODENAME);
    }

    @ChecksSdkIntAtLeast(codename = ExifInterface.GPS_DIRECTION_TRUE)
    @PrereleaseSdkCheck
    public static boolean isAtLeastT() {
        return isAtLeastPreReleaseCodename(ExifInterface.GPS_DIRECTION_TRUE, Build.VERSION.CODENAME);
    }
}
