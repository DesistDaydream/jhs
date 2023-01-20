package e.b.a.r;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

@Deprecated
/* loaded from: classes.dex */
public final class e {
    private static final String b = "ManifestParser";

    /* renamed from: c  reason: collision with root package name */
    private static final String f9866c = "GlideModule";
    private final Context a;

    public e(Context context) {
        this.a = context;
    }

    private static c b(String str) {
        try {
            Class<?> cls = Class.forName(str);
            Object obj = null;
            try {
                obj = cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (IllegalAccessException e2) {
                c(cls, e2);
            } catch (InstantiationException e3) {
                c(cls, e3);
            } catch (NoSuchMethodException e4) {
                c(cls, e4);
            } catch (InvocationTargetException e5) {
                c(cls, e5);
            }
            if (obj instanceof c) {
                return (c) obj;
            }
            throw new RuntimeException("Expected instanceof GlideModule, but found: " + obj);
        } catch (ClassNotFoundException e6) {
            throw new IllegalArgumentException("Unable to find GlideModule implementation", e6);
        }
    }

    private static void c(Class<?> cls, Exception exc) {
        throw new RuntimeException("Unable to instantiate GlideModule implementation for " + cls, exc);
    }

    public List<c> a() {
        if (Log.isLoggable(b, 3)) {
            Log.d(b, "Loading Glide modules");
        }
        ArrayList arrayList = new ArrayList();
        try {
            ApplicationInfo applicationInfo = this.a.getPackageManager().getApplicationInfo(this.a.getPackageName(), 128);
            if (applicationInfo.metaData == null) {
                if (Log.isLoggable(b, 3)) {
                    Log.d(b, "Got null app info metadata");
                }
                return arrayList;
            }
            if (Log.isLoggable(b, 2)) {
                Log.v(b, "Got app info metadata: " + applicationInfo.metaData);
            }
            for (String str : applicationInfo.metaData.keySet()) {
                if (f9866c.equals(applicationInfo.metaData.get(str))) {
                    arrayList.add(b(str));
                    if (Log.isLoggable(b, 3)) {
                        Log.d(b, "Loaded Glide module: " + str);
                    }
                }
            }
            if (Log.isLoggable(b, 3)) {
                Log.d(b, "Finished loading Glide modules");
            }
            return arrayList;
        } catch (PackageManager.NameNotFoundException e2) {
            throw new RuntimeException("Unable to find metadata to parse GlideModules", e2);
        }
    }
}
