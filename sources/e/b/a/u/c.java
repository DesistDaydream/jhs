package e.b.a.u;

import androidx.annotation.NonNull;
import java.security.MessageDigest;

/* loaded from: classes.dex */
public final class c implements e.b.a.p.c {

    /* renamed from: c  reason: collision with root package name */
    private static final c f9937c = new c();

    private c() {
    }

    @NonNull
    public static c a() {
        return f9937c;
    }

    public String toString() {
        return "EmptySignature";
    }

    @Override // e.b.a.p.c
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
    }
}
