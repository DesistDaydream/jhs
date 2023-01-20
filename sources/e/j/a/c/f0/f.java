package e.j.a.c.f0;

import androidx.annotation.IntRange;
import androidx.annotation.StringRes;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes2.dex */
public interface f {

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface a {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface b {
    }

    void a(int i2);

    void b(int i2, int i3, @IntRange(from = 0) int i4);

    void c(String[] strArr, @StringRes int i2);

    void d(float f2);
}
