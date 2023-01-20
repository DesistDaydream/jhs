package e.j.a.b.c.r;

import android.accounts.Account;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes2.dex */
public interface q extends IInterface {

    /* loaded from: classes2.dex */
    public static abstract class a extends e.j.a.b.f.b.b implements q {

        /* renamed from: e.j.a.b.c.r.q$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static class C0340a extends e.j.a.b.f.b.a implements q {
            public C0340a(IBinder iBinder) {
                super(iBinder, "com.google.android.gms.common.internal.IAccountAccessor");
            }

            @Override // e.j.a.b.c.r.q
            public final Account getAccount() throws RemoteException {
                Parcel c0 = c0(2, b0());
                Account account = (Account) e.j.a.b.f.b.c.b(c0, Account.CREATOR);
                c0.recycle();
                return account;
            }
        }

        public a() {
            super("com.google.android.gms.common.internal.IAccountAccessor");
        }

        public static q b(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
            if (queryLocalInterface instanceof q) {
                return (q) queryLocalInterface;
            }
            return new C0340a(iBinder);
        }

        @Override // e.j.a.b.f.b.b
        public final boolean a(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            if (i2 == 2) {
                Account account = getAccount();
                parcel2.writeNoException();
                e.j.a.b.f.b.c.f(parcel2, account);
                return true;
            }
            return false;
        }
    }

    Account getAccount() throws RemoteException;
}
