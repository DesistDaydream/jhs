package e.b.a.n;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.InputStream;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public interface a {
    public static final int a = 0;
    public static final int b = 1;

    /* renamed from: c  reason: collision with root package name */
    public static final int f9394c = 2;

    /* renamed from: d  reason: collision with root package name */
    public static final int f9395d = 3;

    /* renamed from: e  reason: collision with root package name */
    public static final int f9396e = 0;

    /* renamed from: e.b.a.n.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0304a {
        void a(@NonNull Bitmap bitmap);

        @NonNull
        byte[] b(int i2);

        @NonNull
        Bitmap c(int i2, int i3, @NonNull Bitmap.Config config);

        @NonNull
        int[] d(int i2);

        void e(@NonNull byte[] bArr);

        void f(@NonNull int[] iArr);
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface b {
    }

    @Nullable
    Bitmap a();

    void b();

    int c();

    void clear();

    void d(@NonNull Bitmap.Config config);

    int e(int i2);

    int f();

    @Deprecated
    int g();

    @NonNull
    ByteBuffer getData();

    int getHeight();

    int getStatus();

    int getWidth();

    void h(@NonNull c cVar, @NonNull byte[] bArr);

    int i();

    void j();

    void k(@NonNull c cVar, @NonNull ByteBuffer byteBuffer);

    int l();

    void m(@NonNull c cVar, @NonNull ByteBuffer byteBuffer, int i2);

    int n();

    int o(@Nullable InputStream inputStream, int i2);

    int p();

    int read(@Nullable byte[] bArr);
}
