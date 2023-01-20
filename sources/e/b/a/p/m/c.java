package e.b.a.p.m;

import android.content.Context;
import androidx.annotation.NonNull;
import e.b.a.p.i;
import e.b.a.p.k.s;
import java.security.MessageDigest;

/* loaded from: classes.dex */
public final class c<T> implements i<T> {

    /* renamed from: c  reason: collision with root package name */
    private static final i<?> f9735c = new c();

    private c() {
    }

    @NonNull
    public static <T> c<T> a() {
        return (c) f9735c;
    }

    @Override // e.b.a.p.i
    @NonNull
    public s<T> transform(@NonNull Context context, @NonNull s<T> sVar, int i2, int i3) {
        return sVar;
    }

    @Override // e.b.a.p.c
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
    }
}
