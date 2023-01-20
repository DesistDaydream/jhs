package e.j.a.b.c;

import android.os.RemoteException;
import android.util.Log;
import e.j.a.b.c.r.g1;
import e.j.a.b.c.r.h1;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/* loaded from: classes2.dex */
public abstract class e0 extends h1 {
    private int b;

    public e0(byte[] bArr) {
        e.j.a.b.c.r.a0.a(bArr.length == 25);
        this.b = Arrays.hashCode(bArr);
    }

    public static byte[] c0(String str) {
        try {
            return str.getBytes("ISO-8859-1");
        } catch (UnsupportedEncodingException e2) {
            throw new AssertionError(e2);
        }
    }

    @Override // e.j.a.b.c.r.g1
    public final e.j.a.b.d.d Z() {
        return e.j.a.b.d.f.b0(b0());
    }

    @Override // e.j.a.b.c.r.g1
    public final int a0() {
        return hashCode();
    }

    public abstract byte[] b0();

    public boolean equals(Object obj) {
        e.j.a.b.d.d Z;
        if (obj != null && (obj instanceof g1)) {
            try {
                g1 g1Var = (g1) obj;
                if (g1Var.a0() == hashCode() && (Z = g1Var.Z()) != null) {
                    return Arrays.equals(b0(), (byte[]) e.j.a.b.d.f.c(Z));
                }
                return false;
            } catch (RemoteException e2) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e2);
            }
        }
        return false;
    }

    public int hashCode() {
        return this.b;
    }
}
