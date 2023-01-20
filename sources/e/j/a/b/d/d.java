package e.j.a.b.d;

import android.os.IBinder;
import android.os.IInterface;

/* loaded from: classes2.dex */
public interface d extends IInterface {

    /* loaded from: classes2.dex */
    public static abstract class a extends e.j.a.b.f.b.b implements d {

        /* renamed from: e.j.a.b.d.d$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static class C0347a extends e.j.a.b.f.b.a implements d {
            public C0347a(IBinder iBinder) {
                super(iBinder, "com.google.android.gms.dynamic.IObjectWrapper");
            }
        }

        public a() {
            super("com.google.android.gms.dynamic.IObjectWrapper");
        }

        public static d b(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamic.IObjectWrapper");
            if (queryLocalInterface instanceof d) {
                return (d) queryLocalInterface;
            }
            return new C0347a(iBinder);
        }
    }
}
