package k.c.a.s;

import android.annotation.TargetApi;
import android.app.Fragment;
import android.os.Bundle;
import k.c.a.s.d;

/* loaded from: classes4.dex */
public abstract class c<T> {
    public final k.c.a.s.b a;

    @TargetApi(11)
    /* loaded from: classes4.dex */
    public static class a extends c<Fragment> {
        public a(k.c.a.s.b bVar) {
            super(bVar);
        }

        @Override // k.c.a.s.c
        /* renamed from: e */
        public Fragment a(h hVar, Bundle bundle) {
            d.a aVar = new d.a();
            aVar.setArguments(bundle);
            return aVar;
        }
    }

    /* loaded from: classes4.dex */
    public static class b extends c<androidx.fragment.app.Fragment> {
        public b(k.c.a.s.b bVar) {
            super(bVar);
        }

        @Override // k.c.a.s.c
        /* renamed from: e */
        public androidx.fragment.app.Fragment a(h hVar, Bundle bundle) {
            d.b bVar = new d.b();
            bVar.setArguments(bundle);
            return bVar;
        }
    }

    public c(k.c.a.s.b bVar) {
        this.a = bVar;
    }

    public abstract T a(h hVar, Bundle bundle);

    public String b(h hVar, Bundle bundle) {
        return this.a.a.getString(this.a.d(hVar.a));
    }

    public String c(h hVar, Bundle bundle) {
        k.c.a.s.b bVar = this.a;
        return bVar.a.getString(bVar.b);
    }

    public T d(h hVar, boolean z, Bundle bundle) {
        Bundle bundle2;
        int i2;
        Class<?> cls;
        if (hVar.d()) {
            return null;
        }
        if (bundle != null) {
            bundle2 = (Bundle) bundle.clone();
        } else {
            bundle2 = new Bundle();
        }
        if (!bundle2.containsKey(e.f16313d)) {
            bundle2.putString(e.f16313d, c(hVar, bundle2));
        }
        if (!bundle2.containsKey(e.f16314e)) {
            bundle2.putString(e.f16314e, b(hVar, bundle2));
        }
        if (!bundle2.containsKey(e.f16315f)) {
            bundle2.putBoolean(e.f16315f, z);
        }
        if (!bundle2.containsKey(e.f16317h) && (cls = this.a.f16311i) != null) {
            bundle2.putSerializable(e.f16317h, cls);
        }
        if (!bundle2.containsKey(e.f16316g) && (i2 = this.a.f16310h) != 0) {
            bundle2.putInt(e.f16316g, i2);
        }
        return a(hVar, bundle2);
    }
}
