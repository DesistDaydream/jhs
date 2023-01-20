package e.j.a.c.a0;

import androidx.annotation.NonNull;
import java.util.Locale;

/* loaded from: classes2.dex */
public final class c implements d {

    /* renamed from: d  reason: collision with root package name */
    private static final long f10560d = 1000000000000L;

    /* renamed from: e  reason: collision with root package name */
    private static final int f10561e = 1000000000;

    /* renamed from: f  reason: collision with root package name */
    private static final int f10562f = 1000000;

    /* renamed from: g  reason: collision with root package name */
    private static final int f10563g = 1000;

    @Override // e.j.a.c.a0.d
    @NonNull
    public String a(float f2) {
        return f2 >= 1.0E12f ? String.format(Locale.US, "%.1fT", Float.valueOf(f2 / 1.0E12f)) : f2 >= 1.0E9f ? String.format(Locale.US, "%.1fB", Float.valueOf(f2 / 1.0E9f)) : f2 >= 1000000.0f ? String.format(Locale.US, "%.1fM", Float.valueOf(f2 / 1000000.0f)) : f2 >= 1000.0f ? String.format(Locale.US, "%.1fK", Float.valueOf(f2 / 1000.0f)) : String.format(Locale.US, "%.0f", Float.valueOf(f2));
    }
}
