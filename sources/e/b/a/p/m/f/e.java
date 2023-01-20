package e.b.a.p.m.f;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import e.b.a.p.g;
import e.b.a.p.k.s;
import java.util.List;

/* loaded from: classes.dex */
public class e implements g<Uri, Drawable> {
    private static final String b = "android";

    /* renamed from: c  reason: collision with root package name */
    private static final int f9796c = 0;

    /* renamed from: d  reason: collision with root package name */
    private static final int f9797d = 2;

    /* renamed from: e  reason: collision with root package name */
    private static final int f9798e = 0;

    /* renamed from: f  reason: collision with root package name */
    private static final int f9799f = 1;

    /* renamed from: g  reason: collision with root package name */
    private static final int f9800g = 1;

    /* renamed from: h  reason: collision with root package name */
    private static final int f9801h = 0;
    private final Context a;

    public e(Context context) {
        this.a = context.getApplicationContext();
    }

    @NonNull
    private Context d(Uri uri, String str) {
        if (str.equals(this.a.getPackageName())) {
            return this.a;
        }
        try {
            return this.a.createPackageContext(str, 0);
        } catch (PackageManager.NameNotFoundException e2) {
            if (str.contains(this.a.getPackageName())) {
                return this.a;
            }
            throw new IllegalArgumentException("Failed to obtain context or unrecognized Uri format for: " + uri, e2);
        }
    }

    @DrawableRes
    private int e(Uri uri) {
        try {
            return Integer.parseInt(uri.getPathSegments().get(0));
        } catch (NumberFormatException e2) {
            throw new IllegalArgumentException("Unrecognized Uri format: " + uri, e2);
        }
    }

    @DrawableRes
    private int f(Context context, Uri uri) {
        List<String> pathSegments = uri.getPathSegments();
        String authority = uri.getAuthority();
        String str = pathSegments.get(0);
        String str2 = pathSegments.get(1);
        int identifier = context.getResources().getIdentifier(str2, str, authority);
        if (identifier == 0) {
            identifier = Resources.getSystem().getIdentifier(str2, str, "android");
        }
        if (identifier != 0) {
            return identifier;
        }
        throw new IllegalArgumentException("Failed to find resource id for: " + uri);
    }

    @DrawableRes
    private int g(Context context, Uri uri) {
        List<String> pathSegments = uri.getPathSegments();
        if (pathSegments.size() == 2) {
            return f(context, uri);
        }
        if (pathSegments.size() == 1) {
            return e(uri);
        }
        throw new IllegalArgumentException("Unrecognized Uri format: " + uri);
    }

    @Override // e.b.a.p.g
    @Nullable
    /* renamed from: c */
    public s<Drawable> b(@NonNull Uri uri, int i2, int i3, @NonNull e.b.a.p.f fVar) {
        Context d2 = d(uri, uri.getAuthority());
        return d.d(a.b(this.a, d2, g(d2, uri)));
    }

    @Override // e.b.a.p.g
    /* renamed from: h */
    public boolean a(@NonNull Uri uri, @NonNull e.b.a.p.f fVar) {
        return uri.getScheme().equals("android.resource");
    }
}
