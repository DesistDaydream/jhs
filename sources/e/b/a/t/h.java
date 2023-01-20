package e.b.a.t;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import androidx.annotation.CheckResult;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;

/* loaded from: classes.dex */
public class h extends a<h> {
    @Nullable
    private static h V;
    @Nullable
    private static h W;
    @Nullable
    private static h X;
    @Nullable
    private static h Y;
    @Nullable
    private static h Z;
    @Nullable
    private static h a0;
    @Nullable
    private static h b0;
    @Nullable
    private static h c0;

    @NonNull
    @CheckResult
    public static h U0(@NonNull e.b.a.p.i<Bitmap> iVar) {
        return new h().L0(iVar);
    }

    @NonNull
    @CheckResult
    public static h V0() {
        if (Z == null) {
            Z = new h().n().m();
        }
        return Z;
    }

    @NonNull
    @CheckResult
    public static h W0() {
        if (Y == null) {
            Y = new h().o().m();
        }
        return Y;
    }

    @NonNull
    @CheckResult
    public static h X0() {
        if (a0 == null) {
            a0 = new h().p().m();
        }
        return a0;
    }

    @NonNull
    @CheckResult
    public static h Y0(@NonNull Class<?> cls) {
        return new h().r(cls);
    }

    @NonNull
    @CheckResult
    public static h Z0(@NonNull e.b.a.p.k.h hVar) {
        return new h().t(hVar);
    }

    @NonNull
    @CheckResult
    public static h a1(@NonNull DownsampleStrategy downsampleStrategy) {
        return new h().w(downsampleStrategy);
    }

    @NonNull
    @CheckResult
    public static h b1(@NonNull Bitmap.CompressFormat compressFormat) {
        return new h().x(compressFormat);
    }

    @NonNull
    @CheckResult
    public static h c1(@IntRange(from = 0, to = 100) int i2) {
        return new h().y(i2);
    }

    @NonNull
    @CheckResult
    public static h d1(@DrawableRes int i2) {
        return new h().z(i2);
    }

    @NonNull
    @CheckResult
    public static h e1(@Nullable Drawable drawable) {
        return new h().A(drawable);
    }

    @NonNull
    @CheckResult
    public static h f1() {
        if (X == null) {
            X = new h().D().m();
        }
        return X;
    }

    @NonNull
    @CheckResult
    public static h g1(@NonNull DecodeFormat decodeFormat) {
        return new h().E(decodeFormat);
    }

    @NonNull
    @CheckResult
    public static h h1(@IntRange(from = 0) long j2) {
        return new h().F(j2);
    }

    @NonNull
    @CheckResult
    public static h i1() {
        if (c0 == null) {
            c0 = new h().u().m();
        }
        return c0;
    }

    @NonNull
    @CheckResult
    public static h j1() {
        if (b0 == null) {
            b0 = new h().v().m();
        }
        return b0;
    }

    @NonNull
    @CheckResult
    public static <T> h k1(@NonNull e.b.a.p.e<T> eVar, @NonNull T t) {
        return new h().F0(eVar, t);
    }

    @NonNull
    @CheckResult
    public static h l1(int i2) {
        return m1(i2, i2);
    }

    @NonNull
    @CheckResult
    public static h m1(int i2, int i3) {
        return new h().x0(i2, i3);
    }

    @NonNull
    @CheckResult
    public static h n1(@DrawableRes int i2) {
        return new h().y0(i2);
    }

    @NonNull
    @CheckResult
    public static h o1(@Nullable Drawable drawable) {
        return new h().z0(drawable);
    }

    @NonNull
    @CheckResult
    public static h p1(@NonNull Priority priority) {
        return new h().A0(priority);
    }

    @NonNull
    @CheckResult
    public static h q1(@NonNull e.b.a.p.c cVar) {
        return new h().G0(cVar);
    }

    @NonNull
    @CheckResult
    public static h r1(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        return new h().H0(f2);
    }

    @NonNull
    @CheckResult
    public static h s1(boolean z) {
        if (z) {
            if (V == null) {
                V = new h().I0(true).m();
            }
            return V;
        }
        if (W == null) {
            W = new h().I0(false).m();
        }
        return W;
    }

    @NonNull
    @CheckResult
    public static h t1(@IntRange(from = 0) int i2) {
        return new h().K0(i2);
    }
}
