package e.j.a.b.d;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import e.j.a.b.d.d;

/* loaded from: classes2.dex */
public interface c extends IInterface {

    /* loaded from: classes2.dex */
    public static abstract class a extends e.j.a.b.f.b.b implements c {

        /* renamed from: e.j.a.b.d.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static class C0346a extends e.j.a.b.f.b.a implements c {
            public C0346a(IBinder iBinder) {
                super(iBinder, "com.google.android.gms.dynamic.IFragmentWrapper");
            }

            @Override // e.j.a.b.d.c
            public final d A() throws RemoteException {
                Parcel c0 = c0(6, b0());
                d b = d.a.b(c0.readStrongBinder());
                c0.recycle();
                return b;
            }

            @Override // e.j.a.b.d.c
            public final c B() throws RemoteException {
                Parcel c0 = c0(9, b0());
                c b = a.b(c0.readStrongBinder());
                c0.recycle();
                return b;
            }

            @Override // e.j.a.b.d.c
            public final d D() throws RemoteException {
                Parcel c0 = c0(2, b0());
                d b = d.a.b(c0.readStrongBinder());
                c0.recycle();
                return b;
            }

            @Override // e.j.a.b.d.c
            public final c F() throws RemoteException {
                Parcel c0 = c0(5, b0());
                c b = a.b(c0.readStrongBinder());
                c0.recycle();
                return b;
            }

            @Override // e.j.a.b.d.c
            public final void G(d dVar) throws RemoteException {
                Parcel b0 = b0();
                e.j.a.b.f.b.c.c(b0, dVar);
                d0(27, b0);
            }

            @Override // e.j.a.b.d.c
            public final boolean H() throws RemoteException {
                Parcel c0 = c0(13, b0());
                boolean e2 = e.j.a.b.f.b.c.e(c0);
                c0.recycle();
                return e2;
            }

            @Override // e.j.a.b.d.c
            public final void I(d dVar) throws RemoteException {
                Parcel b0 = b0();
                e.j.a.b.f.b.c.c(b0, dVar);
                d0(20, b0);
            }

            @Override // e.j.a.b.d.c
            public final int J() throws RemoteException {
                Parcel c0 = c0(10, b0());
                int readInt = c0.readInt();
                c0.recycle();
                return readInt;
            }

            @Override // e.j.a.b.d.c
            public final d K() throws RemoteException {
                Parcel c0 = c0(12, b0());
                d b = d.a.b(c0.readStrongBinder());
                c0.recycle();
                return b;
            }

            @Override // e.j.a.b.d.c
            public final void M(boolean z) throws RemoteException {
                Parcel b0 = b0();
                e.j.a.b.f.b.c.a(b0, z);
                d0(23, b0);
            }

            @Override // e.j.a.b.d.c
            public final void N(boolean z) throws RemoteException {
                Parcel b0 = b0();
                e.j.a.b.f.b.c.a(b0, z);
                d0(21, b0);
            }

            @Override // e.j.a.b.d.c
            public final boolean O() throws RemoteException {
                Parcel c0 = c0(14, b0());
                boolean e2 = e.j.a.b.f.b.c.e(c0);
                c0.recycle();
                return e2;
            }

            @Override // e.j.a.b.d.c
            public final boolean P() throws RemoteException {
                Parcel c0 = c0(7, b0());
                boolean e2 = e.j.a.b.f.b.c.e(c0);
                c0.recycle();
                return e2;
            }

            @Override // e.j.a.b.d.c
            public final boolean S() throws RemoteException {
                Parcel c0 = c0(16, b0());
                boolean e2 = e.j.a.b.f.b.c.e(c0);
                c0.recycle();
                return e2;
            }

            @Override // e.j.a.b.d.c
            public final boolean U() throws RemoteException {
                Parcel c0 = c0(17, b0());
                boolean e2 = e.j.a.b.f.b.c.e(c0);
                c0.recycle();
                return e2;
            }

            @Override // e.j.a.b.d.c
            public final boolean V() throws RemoteException {
                Parcel c0 = c0(18, b0());
                boolean e2 = e.j.a.b.f.b.c.e(c0);
                c0.recycle();
                return e2;
            }

            @Override // e.j.a.b.d.c
            public final int getId() throws RemoteException {
                Parcel c0 = c0(4, b0());
                int readInt = c0.readInt();
                c0.recycle();
                return readInt;
            }

            @Override // e.j.a.b.d.c
            public final boolean isVisible() throws RemoteException {
                Parcel c0 = c0(19, b0());
                boolean e2 = e.j.a.b.f.b.c.e(c0);
                c0.recycle();
                return e2;
            }

            @Override // e.j.a.b.d.c
            public final void startActivity(Intent intent) throws RemoteException {
                Parcel b0 = b0();
                e.j.a.b.f.b.c.d(b0, intent);
                d0(25, b0);
            }

            @Override // e.j.a.b.d.c
            public final void startActivityForResult(Intent intent, int i2) throws RemoteException {
                Parcel b0 = b0();
                e.j.a.b.f.b.c.d(b0, intent);
                b0.writeInt(i2);
                d0(26, b0);
            }

            @Override // e.j.a.b.d.c
            public final Bundle u() throws RemoteException {
                Parcel c0 = c0(3, b0());
                Bundle bundle = (Bundle) e.j.a.b.f.b.c.b(c0, Bundle.CREATOR);
                c0.recycle();
                return bundle;
            }

            @Override // e.j.a.b.d.c
            public final String v() throws RemoteException {
                Parcel c0 = c0(8, b0());
                String readString = c0.readString();
                c0.recycle();
                return readString;
            }

            @Override // e.j.a.b.d.c
            public final boolean w() throws RemoteException {
                Parcel c0 = c0(15, b0());
                boolean e2 = e.j.a.b.f.b.c.e(c0);
                c0.recycle();
                return e2;
            }

            @Override // e.j.a.b.d.c
            public final boolean x() throws RemoteException {
                Parcel c0 = c0(11, b0());
                boolean e2 = e.j.a.b.f.b.c.e(c0);
                c0.recycle();
                return e2;
            }

            @Override // e.j.a.b.d.c
            public final void y(boolean z) throws RemoteException {
                Parcel b0 = b0();
                e.j.a.b.f.b.c.a(b0, z);
                d0(24, b0);
            }

            @Override // e.j.a.b.d.c
            public final void z(boolean z) throws RemoteException {
                Parcel b0 = b0();
                e.j.a.b.f.b.c.a(b0, z);
                d0(22, b0);
            }
        }

        public a() {
            super("com.google.android.gms.dynamic.IFragmentWrapper");
        }

        public static c b(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamic.IFragmentWrapper");
            if (queryLocalInterface instanceof c) {
                return (c) queryLocalInterface;
            }
            return new C0346a(iBinder);
        }

        @Override // e.j.a.b.f.b.b
        public final boolean a(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            switch (i2) {
                case 2:
                    d D = D();
                    parcel2.writeNoException();
                    e.j.a.b.f.b.c.c(parcel2, D);
                    return true;
                case 3:
                    Bundle u = u();
                    parcel2.writeNoException();
                    e.j.a.b.f.b.c.f(parcel2, u);
                    return true;
                case 4:
                    int id = getId();
                    parcel2.writeNoException();
                    parcel2.writeInt(id);
                    return true;
                case 5:
                    c F = F();
                    parcel2.writeNoException();
                    e.j.a.b.f.b.c.c(parcel2, F);
                    return true;
                case 6:
                    d A = A();
                    parcel2.writeNoException();
                    e.j.a.b.f.b.c.c(parcel2, A);
                    return true;
                case 7:
                    boolean P = P();
                    parcel2.writeNoException();
                    e.j.a.b.f.b.c.a(parcel2, P);
                    return true;
                case 8:
                    String v = v();
                    parcel2.writeNoException();
                    parcel2.writeString(v);
                    return true;
                case 9:
                    c B = B();
                    parcel2.writeNoException();
                    e.j.a.b.f.b.c.c(parcel2, B);
                    return true;
                case 10:
                    int J = J();
                    parcel2.writeNoException();
                    parcel2.writeInt(J);
                    return true;
                case 11:
                    boolean x = x();
                    parcel2.writeNoException();
                    e.j.a.b.f.b.c.a(parcel2, x);
                    return true;
                case 12:
                    d K = K();
                    parcel2.writeNoException();
                    e.j.a.b.f.b.c.c(parcel2, K);
                    return true;
                case 13:
                    boolean H = H();
                    parcel2.writeNoException();
                    e.j.a.b.f.b.c.a(parcel2, H);
                    return true;
                case 14:
                    boolean O = O();
                    parcel2.writeNoException();
                    e.j.a.b.f.b.c.a(parcel2, O);
                    return true;
                case 15:
                    boolean w = w();
                    parcel2.writeNoException();
                    e.j.a.b.f.b.c.a(parcel2, w);
                    return true;
                case 16:
                    boolean S = S();
                    parcel2.writeNoException();
                    e.j.a.b.f.b.c.a(parcel2, S);
                    return true;
                case 17:
                    boolean U = U();
                    parcel2.writeNoException();
                    e.j.a.b.f.b.c.a(parcel2, U);
                    return true;
                case 18:
                    boolean V = V();
                    parcel2.writeNoException();
                    e.j.a.b.f.b.c.a(parcel2, V);
                    return true;
                case 19:
                    boolean isVisible = isVisible();
                    parcel2.writeNoException();
                    e.j.a.b.f.b.c.a(parcel2, isVisible);
                    return true;
                case 20:
                    I(d.a.b(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 21:
                    N(e.j.a.b.f.b.c.e(parcel));
                    parcel2.writeNoException();
                    return true;
                case 22:
                    z(e.j.a.b.f.b.c.e(parcel));
                    parcel2.writeNoException();
                    return true;
                case 23:
                    M(e.j.a.b.f.b.c.e(parcel));
                    parcel2.writeNoException();
                    return true;
                case 24:
                    y(e.j.a.b.f.b.c.e(parcel));
                    parcel2.writeNoException();
                    return true;
                case 25:
                    startActivity((Intent) e.j.a.b.f.b.c.b(parcel, Intent.CREATOR));
                    parcel2.writeNoException();
                    return true;
                case 26:
                    startActivityForResult((Intent) e.j.a.b.f.b.c.b(parcel, Intent.CREATOR), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 27:
                    G(d.a.b(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                default:
                    return false;
            }
        }
    }

    d A() throws RemoteException;

    c B() throws RemoteException;

    d D() throws RemoteException;

    c F() throws RemoteException;

    void G(d dVar) throws RemoteException;

    boolean H() throws RemoteException;

    void I(d dVar) throws RemoteException;

    int J() throws RemoteException;

    d K() throws RemoteException;

    void M(boolean z) throws RemoteException;

    void N(boolean z) throws RemoteException;

    boolean O() throws RemoteException;

    boolean P() throws RemoteException;

    boolean S() throws RemoteException;

    boolean U() throws RemoteException;

    boolean V() throws RemoteException;

    int getId() throws RemoteException;

    boolean isVisible() throws RemoteException;

    void startActivity(Intent intent) throws RemoteException;

    void startActivityForResult(Intent intent, int i2) throws RemoteException;

    Bundle u() throws RemoteException;

    String v() throws RemoteException;

    boolean w() throws RemoteException;

    boolean x() throws RemoteException;

    void y(boolean z) throws RemoteException;

    void z(boolean z) throws RemoteException;
}
