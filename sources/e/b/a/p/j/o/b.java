package e.b.a.p.j.o;

import android.net.Uri;

/* loaded from: classes.dex */
public final class b {
    private static final int a = 512;
    private static final int b = 384;

    private b() {
    }

    public static boolean a(Uri uri) {
        return b(uri) && !e(uri);
    }

    public static boolean b(Uri uri) {
        return uri != null && "content".equals(uri.getScheme()) && "media".equals(uri.getAuthority());
    }

    public static boolean c(Uri uri) {
        return b(uri) && e(uri);
    }

    public static boolean d(int i2, int i3) {
        return i2 != Integer.MIN_VALUE && i3 != Integer.MIN_VALUE && i2 <= 512 && i3 <= b;
    }

    private static boolean e(Uri uri) {
        return uri.getPathSegments().contains("video");
    }
}
