package e.b.a.p;

import androidx.annotation.NonNull;
import java.nio.charset.Charset;
import java.security.MessageDigest;

/* loaded from: classes.dex */
public interface c {
    public static final String a = "UTF-8";
    public static final Charset b = Charset.forName("UTF-8");

    boolean equals(Object obj);

    int hashCode();

    void updateDiskCacheKey(@NonNull MessageDigest messageDigest);
}
