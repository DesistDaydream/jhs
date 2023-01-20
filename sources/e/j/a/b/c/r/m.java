package e.j.a.b.c.r;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import com.tencent.android.tpush.stat.ServiceStat;

@e.j.a.b.c.m.a
/* loaded from: classes2.dex */
public abstract class m {
    private static final Object a = new Object();
    private static m b;

    @e.j.a.b.c.m.a
    public static m a(Context context) {
        synchronized (a) {
            if (b == null) {
                b = new c1(context.getApplicationContext());
            }
        }
        return b;
    }

    public final void b(String str, String str2, int i2, ServiceConnection serviceConnection, String str3) {
        d(new a(str, str2, i2), serviceConnection, str3);
    }

    @e.j.a.b.c.m.a
    public boolean bindService(String str, ServiceConnection serviceConnection, String str2) {
        return c(new a(str, (int) ServiceStat.EnumPushAction_IN_MSG_ACTION_MOBILE_USER_DISABLED), serviceConnection, str2);
    }

    public abstract boolean c(a aVar, ServiceConnection serviceConnection, String str);

    public abstract void d(a aVar, ServiceConnection serviceConnection, String str);

    @e.j.a.b.c.m.a
    public void unbindService(String str, ServiceConnection serviceConnection, String str2) {
        d(new a(str, (int) ServiceStat.EnumPushAction_IN_MSG_ACTION_MOBILE_USER_DISABLED), serviceConnection, str2);
    }

    @e.j.a.b.c.m.a
    public boolean bindService(ComponentName componentName, ServiceConnection serviceConnection, String str) {
        return c(new a(componentName, (int) ServiceStat.EnumPushAction_IN_MSG_ACTION_MOBILE_USER_DISABLED), serviceConnection, str);
    }

    @e.j.a.b.c.m.a
    public void unbindService(ComponentName componentName, ServiceConnection serviceConnection, String str) {
        d(new a(componentName, (int) ServiceStat.EnumPushAction_IN_MSG_ACTION_MOBILE_USER_DISABLED), serviceConnection, str);
    }

    /* loaded from: classes2.dex */
    public static final class a {
        private final String a;
        private final String b;

        /* renamed from: c  reason: collision with root package name */
        private final ComponentName f10431c;

        /* renamed from: d  reason: collision with root package name */
        private final int f10432d;

        public a(String str, int i2) {
            this.a = a0.g(str);
            this.b = "com.google.android.gms";
            this.f10431c = null;
            this.f10432d = ServiceStat.EnumPushAction_IN_MSG_ACTION_MOBILE_USER_DISABLED;
        }

        public final ComponentName a() {
            return this.f10431c;
        }

        public final String b() {
            return this.b;
        }

        public final Intent c(Context context) {
            if (this.a != null) {
                return new Intent(this.a).setPackage(this.b);
            }
            return new Intent().setComponent(this.f10431c);
        }

        public final int d() {
            return this.f10432d;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof a) {
                a aVar = (a) obj;
                return y.a(this.a, aVar.a) && y.a(this.b, aVar.b) && y.a(this.f10431c, aVar.f10431c) && this.f10432d == aVar.f10432d;
            }
            return false;
        }

        public final int hashCode() {
            return y.b(this.a, this.b, this.f10431c, Integer.valueOf(this.f10432d));
        }

        public final String toString() {
            String str = this.a;
            return str == null ? this.f10431c.flattenToString() : str;
        }

        public a(String str, String str2, int i2) {
            this.a = a0.g(str);
            this.b = a0.g(str2);
            this.f10431c = null;
            this.f10432d = i2;
        }

        public a(ComponentName componentName, int i2) {
            this.a = null;
            this.b = null;
            this.f10431c = (ComponentName) a0.k(componentName);
            this.f10432d = ServiceStat.EnumPushAction_IN_MSG_ACTION_MOBILE_USER_DISABLED;
        }
    }
}
