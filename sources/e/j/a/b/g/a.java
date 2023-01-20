package e.j.a.b.g;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.util.Log;
import androidx.annotation.Nullable;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.dynamite.DynamiteModule;
import e.j.a.b.c.f;
import e.j.a.b.c.h;
import e.j.a.b.c.r.a0;
import e.j.a.b.c.x.i;
import java.lang.reflect.Method;

/* loaded from: classes2.dex */
public class a {
    private static final f a = f.i();
    private static final Object b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private static Method f10507c = null;

    /* renamed from: d  reason: collision with root package name */
    public static final String f10508d = "GmsCore_OpenSSL";

    /* renamed from: e.j.a.b.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0348a {
        void a();

        void b(int i2, Intent intent);
    }

    public static void a(Context context) throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException {
        a0.l(context, "Context must not be null");
        a.p(context, 11925000);
        Context d2 = d(context);
        if (d2 == null) {
            d2 = e(context);
        }
        if (d2 != null) {
            synchronized (b) {
                try {
                    if (f10507c == null) {
                        f10507c = d2.getClassLoader().loadClass("com.google.android.gms.common.security.ProviderInstallerImpl").getMethod("insertProvider", Context.class);
                    }
                    f10507c.invoke(null, d2);
                } catch (Exception e2) {
                    e = e2;
                    Throwable cause = e.getCause();
                    if (Log.isLoggable("ProviderInstaller", 6)) {
                        String valueOf = String.valueOf(cause == null ? e.getMessage() : cause.getMessage());
                        Log.e("ProviderInstaller", valueOf.length() != 0 ? "Failed to install provider: ".concat(valueOf) : new String("Failed to install provider: "));
                    }
                    if (cause != null) {
                        e = cause;
                    }
                    i.a(context, e);
                    throw new GooglePlayServicesNotAvailableException(8);
                } finally {
                }
            }
            return;
        }
        Log.e("ProviderInstaller", "Failed to get remote context");
        throw new GooglePlayServicesNotAvailableException(8);
    }

    public static void b(Context context, InterfaceC0348a interfaceC0348a) {
        a0.l(context, "Context must not be null");
        a0.l(interfaceC0348a, "Listener must not be null");
        a0.f("Must be called on the UI thread");
        new b(context, interfaceC0348a).execute(new Void[0]);
    }

    @Nullable
    private static Context d(Context context) {
        try {
            return DynamiteModule.e(context, DynamiteModule.f2674l, "providerinstaller").b();
        } catch (DynamiteModule.LoadingException e2) {
            String valueOf = String.valueOf(e2.getMessage());
            Log.w("ProviderInstaller", valueOf.length() != 0 ? "Failed to load providerinstaller module: ".concat(valueOf) : new String("Failed to load providerinstaller module: "));
            return null;
        }
    }

    @Nullable
    private static Context e(Context context) {
        try {
            return h.i(context);
        } catch (Resources.NotFoundException e2) {
            String valueOf = String.valueOf(e2.getMessage());
            Log.w("ProviderInstaller", valueOf.length() != 0 ? "Failed to load GMS Core context for providerinstaller: ".concat(valueOf) : new String("Failed to load GMS Core context for providerinstaller: "));
            i.a(context, e2);
            return null;
        }
    }
}
