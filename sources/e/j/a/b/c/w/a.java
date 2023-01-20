package e.j.a.b.c.w;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.util.Log;
import e.j.a.b.c.x.d0;
import java.util.Collections;
import java.util.List;

@e.j.a.b.c.m.a
/* loaded from: classes2.dex */
public class a {

    /* renamed from: e  reason: collision with root package name */
    private static final Object f10445e = new Object();

    /* renamed from: f  reason: collision with root package name */
    private static volatile a f10446f = null;
    @d0

    /* renamed from: g  reason: collision with root package name */
    private static boolean f10447g = false;
    private final List<String> a;
    private final List<String> b;

    /* renamed from: c  reason: collision with root package name */
    private final List<String> f10448c;

    /* renamed from: d  reason: collision with root package name */
    private final List<String> f10449d;

    private a() {
        List<String> list = Collections.EMPTY_LIST;
        this.a = list;
        this.b = list;
        this.f10448c = list;
        this.f10449d = list;
    }

    @e.j.a.b.c.m.a
    public static a a() {
        if (f10446f == null) {
            synchronized (f10445e) {
                if (f10446f == null) {
                    f10446f = new a();
                }
            }
        }
        return f10446f;
    }

    public final boolean b(Context context, String str, Intent intent, ServiceConnection serviceConnection, int i2) {
        ComponentName component = intent.getComponent();
        if (component == null ? false : e.j.a.b.c.x.e.d(context, component.getPackageName())) {
            Log.w("ConnectionTracker", "Attempted to bind to a service in a STOPPED package.");
            return false;
        }
        return context.bindService(intent, serviceConnection, i2);
    }

    @e.j.a.b.c.m.a
    public boolean bindService(Context context, Intent intent, ServiceConnection serviceConnection, int i2) {
        return b(context, context.getClass().getName(), intent, serviceConnection, i2);
    }

    @e.j.a.b.c.m.a
    @SuppressLint({"UntrackedBindService"})
    public void unbindService(Context context, ServiceConnection serviceConnection) {
        context.unbindService(serviceConnection);
    }
}
