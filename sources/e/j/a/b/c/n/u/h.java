package e.j.a.b.c.n.u;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.google.android.gms.common.R;
import com.google.android.gms.common.api.Status;
import javax.annotation.concurrent.GuardedBy;

@e.j.a.b.c.m.a
@Deprecated
/* loaded from: classes2.dex */
public final class h {

    /* renamed from: e  reason: collision with root package name */
    private static final Object f10257e = new Object();
    @GuardedBy("sLock")

    /* renamed from: f  reason: collision with root package name */
    private static h f10258f;
    private final String a;
    private final Status b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f10259c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f10260d;

    @e.j.a.b.c.m.a
    @e.j.a.b.c.x.d0
    public h(Context context) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("google_app_measurement_enable", "integer", resources.getResourcePackageName(R.string.common_google_play_services_unknown_issue));
        boolean z = true;
        if (identifier != 0) {
            boolean z2 = resources.getInteger(identifier) != 0;
            this.f10260d = !z2;
            z = z2;
        } else {
            this.f10260d = false;
        }
        this.f10259c = z;
        String a = e.j.a.b.c.r.n1.a(context);
        a = a == null ? new e.j.a.b.c.r.f0(context).a("google_app_id") : a;
        if (TextUtils.isEmpty(a)) {
            this.b = new Status(10, "Missing google app id value from from string resources with name google_app_id.");
            this.a = null;
            return;
        }
        this.a = a;
        this.b = Status.RESULT_SUCCESS;
    }

    @e.j.a.b.c.m.a
    private static h b(String str) {
        h hVar;
        synchronized (f10257e) {
            hVar = f10258f;
            if (hVar == null) {
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 34);
                sb.append("Initialize must be called before ");
                sb.append(str);
                sb.append(".");
                throw new IllegalStateException(sb.toString());
            }
        }
        return hVar;
    }

    @e.j.a.b.c.m.a
    @e.j.a.b.c.x.d0
    public static void c() {
        synchronized (f10257e) {
            f10258f = null;
        }
    }

    @e.j.a.b.c.m.a
    public static String d() {
        return b("getGoogleAppId").a;
    }

    @e.j.a.b.c.m.a
    public static Status e(Context context) {
        Status status;
        e.j.a.b.c.r.a0.l(context, "Context must not be null.");
        synchronized (f10257e) {
            if (f10258f == null) {
                f10258f = new h(context);
            }
            status = f10258f.b;
        }
        return status;
    }

    @e.j.a.b.c.m.a
    public static Status f(Context context, String str, boolean z) {
        e.j.a.b.c.r.a0.l(context, "Context must not be null.");
        e.j.a.b.c.r.a0.h(str, "App ID must be nonempty.");
        synchronized (f10257e) {
            h hVar = f10258f;
            if (hVar != null) {
                return hVar.a(str);
            }
            h hVar2 = new h(str, z);
            f10258f = hVar2;
            return hVar2.b;
        }
    }

    @e.j.a.b.c.m.a
    public static boolean g() {
        h b = b("isMeasurementEnabled");
        return b.b.isSuccess() && b.f10259c;
    }

    @e.j.a.b.c.m.a
    public static boolean h() {
        return b("isMeasurementExplicitlyDisabled").f10260d;
    }

    @e.j.a.b.c.m.a
    @e.j.a.b.c.x.d0
    public final Status a(String str) {
        String str2 = this.a;
        if (str2 != null && !str2.equals(str)) {
            String str3 = this.a;
            StringBuilder sb = new StringBuilder(String.valueOf(str3).length() + 97);
            sb.append("Initialize was called with two different Google App IDs.  Only the first app ID will be used: '");
            sb.append(str3);
            sb.append("'.");
            return new Status(10, sb.toString());
        }
        return Status.RESULT_SUCCESS;
    }

    @e.j.a.b.c.m.a
    @e.j.a.b.c.x.d0
    public h(String str, boolean z) {
        this.a = str;
        this.b = Status.RESULT_SUCCESS;
        this.f10259c = z;
        this.f10260d = !z;
    }
}
