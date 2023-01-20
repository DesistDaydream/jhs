package e.j.d.d;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.VisibleForTesting;
import com.google.firebase.components.ComponentDiscoveryService;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public final class g<T> {

    /* renamed from: c  reason: collision with root package name */
    private static final String f11213c = "ComponentDiscovery";

    /* renamed from: d  reason: collision with root package name */
    private static final String f11214d = "com.google.firebase.components.ComponentRegistrar";

    /* renamed from: e  reason: collision with root package name */
    private static final String f11215e = "com.google.firebase.components:";
    private final T a;
    private final c<T> b;

    /* loaded from: classes2.dex */
    public static class b implements c<Context> {
        private b() {
        }

        private static Bundle b(Context context) {
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager == null) {
                    Log.w(g.f11213c, "Context has no PackageManager.");
                    return null;
                }
                ServiceInfo serviceInfo = packageManager.getServiceInfo(new ComponentName(context, ComponentDiscoveryService.class), 128);
                if (serviceInfo == null) {
                    Log.w(g.f11213c, "ComponentDiscoveryService has no service info.");
                    return null;
                }
                return serviceInfo.metaData;
            } catch (PackageManager.NameNotFoundException unused) {
                Log.w(g.f11213c, "Application info not found.");
                return null;
            }
        }

        @Override // e.j.d.d.g.c
        /* renamed from: c */
        public List<String> a(Context context) {
            Bundle b = b(context);
            if (b == null) {
                Log.w(g.f11213c, "Could not retrieve metadata, returning empty list of registrars.");
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            for (String str : b.keySet()) {
                if (g.f11214d.equals(b.get(str)) && str.startsWith(g.f11215e)) {
                    arrayList.add(str.substring(31));
                }
            }
            return arrayList;
        }
    }

    @VisibleForTesting
    /* loaded from: classes2.dex */
    public interface c<T> {
        List<String> a(T t);
    }

    @VisibleForTesting
    public g(T t, c<T> cVar) {
        this.a = t;
        this.b = cVar;
    }

    public static g<Context> b(Context context) {
        return new g<>(context, new b());
    }

    private static List<i> c(List<String> list) {
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            try {
                Class<?> cls = Class.forName(str);
                if (!i.class.isAssignableFrom(cls)) {
                    Log.w(f11213c, String.format("Class %s is not an instance of %s", str, f11214d));
                } else {
                    arrayList.add((i) cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
                }
            } catch (ClassNotFoundException e2) {
                Log.w(f11213c, String.format("Class %s is not an found.", str), e2);
            } catch (IllegalAccessException e3) {
                Log.w(f11213c, String.format("Could not instantiate %s.", str), e3);
            } catch (InstantiationException e4) {
                Log.w(f11213c, String.format("Could not instantiate %s.", str), e4);
            } catch (NoSuchMethodException e5) {
                Log.w(f11213c, String.format("Could not instantiate %s", str), e5);
            } catch (InvocationTargetException e6) {
                Log.w(f11213c, String.format("Could not instantiate %s", str), e6);
            }
        }
        return arrayList;
    }

    public List<i> a() {
        return c(this.b.a(this.a));
    }
}
