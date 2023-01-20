package e.b.a.u;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* loaded from: classes.dex */
public final class b {
    private static final String a = "AppVersionSignature";
    private static final ConcurrentMap<String, e.b.a.p.c> b = new ConcurrentHashMap();

    private b() {
    }

    @Nullable
    private static PackageInfo a(@NonNull Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e2) {
            Log.e(a, "Cannot resolve info for" + context.getPackageName(), e2);
            return null;
        }
    }

    @NonNull
    private static String b(@Nullable PackageInfo packageInfo) {
        if (packageInfo != null) {
            return String.valueOf(packageInfo.versionCode);
        }
        return UUID.randomUUID().toString();
    }

    @NonNull
    public static e.b.a.p.c c(@NonNull Context context) {
        String packageName = context.getPackageName();
        ConcurrentMap<String, e.b.a.p.c> concurrentMap = b;
        e.b.a.p.c cVar = concurrentMap.get(packageName);
        if (cVar == null) {
            e.b.a.p.c d2 = d(context);
            e.b.a.p.c putIfAbsent = concurrentMap.putIfAbsent(packageName, d2);
            return putIfAbsent == null ? d2 : putIfAbsent;
        }
        return cVar;
    }

    @NonNull
    private static e.b.a.p.c d(@NonNull Context context) {
        return new e(b(a(context)));
    }

    @VisibleForTesting
    public static void e() {
        b.clear();
    }
}
