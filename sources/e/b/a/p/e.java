package e.b.a.p;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import e.b.a.v.l;
import java.security.MessageDigest;

/* loaded from: classes.dex */
public final class e<T> {

    /* renamed from: e  reason: collision with root package name */
    private static final b<Object> f9444e = new a();
    private final T a;
    private final b<T> b;

    /* renamed from: c  reason: collision with root package name */
    private final String f9445c;

    /* renamed from: d  reason: collision with root package name */
    private volatile byte[] f9446d;

    /* loaded from: classes.dex */
    public class a implements b<Object> {
        @Override // e.b.a.p.e.b
        public void update(@NonNull byte[] bArr, @NonNull Object obj, @NonNull MessageDigest messageDigest) {
        }
    }

    /* loaded from: classes.dex */
    public interface b<T> {
        void update(@NonNull byte[] bArr, @NonNull T t, @NonNull MessageDigest messageDigest);
    }

    private e(@NonNull String str, @Nullable T t, @NonNull b<T> bVar) {
        this.f9445c = l.b(str);
        this.a = t;
        this.b = (b) l.d(bVar);
    }

    @NonNull
    public static <T> e<T> a(@NonNull String str, @NonNull b<T> bVar) {
        return new e<>(str, null, bVar);
    }

    @NonNull
    public static <T> e<T> b(@NonNull String str, @Nullable T t, @NonNull b<T> bVar) {
        return new e<>(str, t, bVar);
    }

    @NonNull
    private static <T> b<T> c() {
        return (b<T>) f9444e;
    }

    @NonNull
    private byte[] e() {
        if (this.f9446d == null) {
            this.f9446d = this.f9445c.getBytes(c.b);
        }
        return this.f9446d;
    }

    @NonNull
    public static <T> e<T> f(@NonNull String str) {
        return new e<>(str, null, c());
    }

    @NonNull
    public static <T> e<T> g(@NonNull String str, @NonNull T t) {
        return new e<>(str, t, c());
    }

    @Nullable
    public T d() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj instanceof e) {
            return this.f9445c.equals(((e) obj).f9445c);
        }
        return false;
    }

    public int hashCode() {
        return this.f9445c.hashCode();
    }

    public String toString() {
        return "Option{key='" + this.f9445c + "'}";
    }

    public void update(@NonNull T t, @NonNull MessageDigest messageDigest) {
        this.b.update(e(), t, messageDigest);
    }
}
