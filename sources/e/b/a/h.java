package e.b.a;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.annotation.CheckResult;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import java.io.File;
import java.net.URL;

/* loaded from: classes.dex */
public interface h<T> {
    @CheckResult
    @Deprecated
    T a(@Nullable URL url);

    @NonNull
    @CheckResult
    T b(@Nullable Uri uri);

    @NonNull
    @CheckResult
    T c(@Nullable byte[] bArr);

    @NonNull
    @CheckResult
    T e(@Nullable File file);

    @NonNull
    @CheckResult
    T f(@Nullable Drawable drawable);

    @NonNull
    @CheckResult
    T g(@Nullable Bitmap bitmap);

    @NonNull
    @CheckResult
    T h(@Nullable Object obj);

    @NonNull
    @CheckResult
    T j(@Nullable @DrawableRes @RawRes Integer num);

    @NonNull
    @CheckResult
    T k(@Nullable String str);
}
