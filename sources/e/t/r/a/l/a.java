package e.t.r.a.l;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.fragment.app.FragmentActivity;
import java.io.File;

/* loaded from: classes3.dex */
public final class a {
    private a() {
    }

    @SuppressLint({"VisibleForTests"})
    @VisibleForTesting
    public static void a() {
        e.b.a.c.d();
    }

    @NonNull
    public static e.b.a.c b(@NonNull Context context) {
        return e.b.a.c.e(context);
    }

    @Nullable
    public static File c(@NonNull Context context) {
        return e.b.a.c.k(context);
    }

    @Nullable
    public static File d(@NonNull Context context, @NonNull String str) {
        return e.b.a.c.l(context, str);
    }

    @SuppressLint({"VisibleForTests"})
    @VisibleForTesting
    public static void e(@NonNull Context context, @NonNull e.b.a.d dVar) {
        e.b.a.c.p(context, dVar);
    }

    @SuppressLint({"VisibleForTests"})
    @VisibleForTesting
    @Deprecated
    public static void f(e.b.a.c cVar) {
        e.b.a.c.q(cVar);
    }

    @SuppressLint({"VisibleForTests"})
    @VisibleForTesting
    public static void g() {
        e.b.a.c.x();
    }

    @NonNull
    public static e h(@NonNull Activity activity) {
        return (e) e.b.a.c.B(activity);
    }

    @NonNull
    @Deprecated
    public static e i(@NonNull Fragment fragment) {
        return (e) e.b.a.c.C(fragment);
    }

    @NonNull
    public static e j(@NonNull Context context) {
        return (e) e.b.a.c.D(context);
    }

    @NonNull
    public static e k(@NonNull View view) {
        return (e) e.b.a.c.E(view);
    }

    @NonNull
    public static e l(@NonNull androidx.fragment.app.Fragment fragment) {
        return (e) e.b.a.c.F(fragment);
    }

    @NonNull
    public static e m(@NonNull FragmentActivity fragmentActivity) {
        return (e) e.b.a.c.G(fragmentActivity);
    }
}
