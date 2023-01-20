package e.j.d.f;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.VisibleForTesting;
import com.google.firebase.FirebaseApp;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.umeng.analytics.pro.d;
import java.io.IOException;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class m0 {
    private final FirebaseApp a;
    private final j b;

    /* renamed from: c  reason: collision with root package name */
    private final p f11243c;

    /* renamed from: d  reason: collision with root package name */
    private final Executor f11244d;

    /* renamed from: e  reason: collision with root package name */
    private final e.j.d.j.g f11245e;

    public m0(FirebaseApp firebaseApp, j jVar, Executor executor, e.j.d.j.g gVar) {
        this(firebaseApp, jVar, executor, new p(firebaseApp.getApplicationContext(), jVar), gVar);
    }

    private final <T> e.j.a.b.j.k<Void> a(e.j.a.b.j.k<T> kVar) {
        return kVar.n(f0.b(), new n0(this));
    }

    private final e.j.a.b.j.k<Bundle> d(String str, String str2, String str3, Bundle bundle) {
        bundle.putString("scope", str3);
        bundle.putString("sender", str2);
        bundle.putString("subtype", str2);
        bundle.putString("appid", str);
        bundle.putString("gmp_app_id", this.a.getOptions().getApplicationId());
        bundle.putString("gmsv", Integer.toString(this.b.g()));
        bundle.putString("osv", Integer.toString(Build.VERSION.SDK_INT));
        bundle.putString("app_ver", this.b.e());
        bundle.putString("app_ver_name", this.b.f());
        String valueOf = String.valueOf(e.j.a.b.c.r.x.a().b("firebase-iid"));
        bundle.putString("cliv", valueOf.length() != 0 ? "fiid-".concat(valueOf) : new String("fiid-"));
        bundle.putString("Firebase-Client", this.f11245e.a());
        e.j.a.b.j.l lVar = new e.j.a.b.j.l();
        this.f11244d.execute(new Runnable(this, bundle, lVar) { // from class: e.j.d.f.o0
            private final m0 a;
            private final Bundle b;

            /* renamed from: c  reason: collision with root package name */
            private final e.j.a.b.j.l f11246c;

            {
                this.a = this;
                this.b = bundle;
                this.f11246c = lVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.g(this.b, this.f11246c);
            }
        });
        return lVar.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String e(Bundle bundle) throws IOException {
        if (bundle != null) {
            String string = bundle.getString("registration_id");
            if (string != null) {
                return string;
            }
            String string2 = bundle.getString(PushConstants.EXTRA_UNREGISTERED);
            if (string2 != null) {
                return string2;
            }
            String string3 = bundle.getString(d.O);
            if ("RST".equals(string3)) {
                throw new IOException("INSTANCE_ID_RESET");
            }
            if (string3 != null) {
                throw new IOException(string3);
            }
            String valueOf = String.valueOf(bundle);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 21);
            sb.append("Unexpected response: ");
            sb.append(valueOf);
            Log.w("FirebaseInstanceId", sb.toString(), new Throwable());
            throw new IOException("SERVICE_NOT_AVAILABLE");
        }
        throw new IOException("SERVICE_NOT_AVAILABLE");
    }

    private final e.j.a.b.j.k<String> h(e.j.a.b.j.k<Bundle> kVar) {
        return kVar.n(this.f11244d, new q0(this));
    }

    public final e.j.a.b.j.k<Void> b(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("iid-operation", "delete");
        bundle.putString("delete", "1");
        return a(h(d(str, "*", "*", bundle)));
    }

    public final e.j.a.b.j.k<String> c(String str, String str2, String str3) {
        return h(d(str, str2, str3, new Bundle()));
    }

    public final /* synthetic */ void g(Bundle bundle, e.j.a.b.j.l lVar) {
        try {
            lVar.setResult(this.f11243c.a(bundle));
        } catch (IOException e2) {
            lVar.b(e2);
        }
    }

    public final e.j.a.b.j.k<Void> i(String str, String str2, String str3) {
        Bundle bundle = new Bundle();
        bundle.putString("delete", "1");
        return a(h(d(str, str2, str3, bundle)));
    }

    public final e.j.a.b.j.k<Void> j(String str, String str2, String str3) {
        Bundle bundle = new Bundle();
        String valueOf = String.valueOf(str3);
        bundle.putString("gcm.topic", valueOf.length() != 0 ? "/topics/".concat(valueOf) : new String("/topics/"));
        String valueOf2 = String.valueOf(str3);
        return a(h(d(str, str2, valueOf2.length() != 0 ? "/topics/".concat(valueOf2) : new String("/topics/"), bundle)));
    }

    public final e.j.a.b.j.k<Void> k(String str, String str2, String str3) {
        Bundle bundle = new Bundle();
        String valueOf = String.valueOf(str3);
        bundle.putString("gcm.topic", valueOf.length() != 0 ? "/topics/".concat(valueOf) : new String("/topics/"));
        bundle.putString("delete", "1");
        String valueOf2 = String.valueOf(str3);
        return a(h(d(str, str2, valueOf2.length() != 0 ? "/topics/".concat(valueOf2) : new String("/topics/"), bundle)));
    }

    @VisibleForTesting
    private m0(FirebaseApp firebaseApp, j jVar, Executor executor, p pVar, e.j.d.j.g gVar) {
        this.a = firebaseApp;
        this.b = jVar;
        this.f11243c = pVar;
        this.f11244d = executor;
        this.f11245e = gVar;
    }
}
