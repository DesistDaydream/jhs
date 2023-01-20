package e.b.a.n;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/* loaded from: classes.dex */
public class d {

    /* renamed from: e  reason: collision with root package name */
    private static final String f9419e = "GifHeaderParser";

    /* renamed from: f  reason: collision with root package name */
    private static final int f9420f = 255;

    /* renamed from: g  reason: collision with root package name */
    private static final int f9421g = 44;

    /* renamed from: h  reason: collision with root package name */
    private static final int f9422h = 33;

    /* renamed from: i  reason: collision with root package name */
    private static final int f9423i = 59;

    /* renamed from: j  reason: collision with root package name */
    private static final int f9424j = 249;

    /* renamed from: k  reason: collision with root package name */
    private static final int f9425k = 255;

    /* renamed from: l  reason: collision with root package name */
    private static final int f9426l = 254;

    /* renamed from: m  reason: collision with root package name */
    private static final int f9427m = 1;
    private static final int n = 28;
    private static final int o = 2;
    private static final int p = 1;
    private static final int q = 128;
    private static final int r = 64;
    private static final int s = 7;
    private static final int t = 128;
    private static final int u = 7;
    public static final int v = 2;
    public static final int w = 10;
    private static final int x = 256;
    private ByteBuffer b;

    /* renamed from: c  reason: collision with root package name */
    private c f9428c;
    private final byte[] a = new byte[256];

    /* renamed from: d  reason: collision with root package name */
    private int f9429d = 0;

    private boolean b() {
        return this.f9428c.b != 0;
    }

    private int e() {
        try {
            return this.b.get() & 255;
        } catch (Exception unused) {
            this.f9428c.b = 1;
            return 0;
        }
    }

    private void f() {
        this.f9428c.f9409d.a = o();
        this.f9428c.f9409d.b = o();
        this.f9428c.f9409d.f9399c = o();
        this.f9428c.f9409d.f9400d = o();
        int e2 = e();
        boolean z = (e2 & 128) != 0;
        int pow = (int) Math.pow(2.0d, (e2 & 7) + 1);
        b bVar = this.f9428c.f9409d;
        bVar.f9401e = (e2 & 64) != 0;
        if (z) {
            bVar.f9407k = h(pow);
        } else {
            bVar.f9407k = null;
        }
        this.f9428c.f9409d.f9406j = this.b.position();
        t();
        if (b()) {
            return;
        }
        c cVar = this.f9428c;
        cVar.f9408c++;
        cVar.f9410e.add(cVar.f9409d);
    }

    private void g() {
        int e2 = e();
        this.f9429d = e2;
        if (e2 <= 0) {
            return;
        }
        int i2 = 0;
        int i3 = 0;
        while (true) {
            try {
                i3 = this.f9429d;
                if (i2 >= i3) {
                    return;
                }
                i3 -= i2;
                this.b.get(this.a, i2, i3);
                i2 += i3;
            } catch (Exception e3) {
                if (Log.isLoggable(f9419e, 3)) {
                    Log.d(f9419e, "Error Reading Block n: " + i2 + " count: " + i3 + " blockSize: " + this.f9429d, e3);
                }
                this.f9428c.b = 1;
                return;
            }
        }
    }

    @Nullable
    private int[] h(int i2) {
        byte[] bArr = new byte[i2 * 3];
        int[] iArr = null;
        try {
            this.b.get(bArr);
            iArr = new int[256];
            int i3 = 0;
            int i4 = 0;
            while (i3 < i2) {
                int i5 = i4 + 1;
                int i6 = i5 + 1;
                int i7 = i6 + 1;
                int i8 = i3 + 1;
                iArr[i3] = ((bArr[i4] & 255) << 16) | ViewCompat.MEASURED_STATE_MASK | ((bArr[i5] & 255) << 8) | (bArr[i6] & 255);
                i4 = i7;
                i3 = i8;
            }
        } catch (BufferUnderflowException e2) {
            if (Log.isLoggable(f9419e, 3)) {
                Log.d(f9419e, "Format Error Reading Color Table", e2);
            }
            this.f9428c.b = 1;
        }
        return iArr;
    }

    private void i() {
        j(Integer.MAX_VALUE);
    }

    private void j(int i2) {
        boolean z = false;
        while (!z && !b() && this.f9428c.f9408c <= i2) {
            int e2 = e();
            if (e2 == 33) {
                int e3 = e();
                if (e3 == 1) {
                    s();
                } else if (e3 == f9424j) {
                    this.f9428c.f9409d = new b();
                    k();
                } else if (e3 == f9426l) {
                    s();
                } else if (e3 != 255) {
                    s();
                } else {
                    g();
                    StringBuilder sb = new StringBuilder();
                    for (int i3 = 0; i3 < 11; i3++) {
                        sb.append((char) this.a[i3]);
                    }
                    if (sb.toString().equals("NETSCAPE2.0")) {
                        n();
                    } else {
                        s();
                    }
                }
            } else if (e2 == 44) {
                c cVar = this.f9428c;
                if (cVar.f9409d == null) {
                    cVar.f9409d = new b();
                }
                f();
            } else if (e2 != 59) {
                this.f9428c.b = 1;
            } else {
                z = true;
            }
        }
    }

    private void k() {
        e();
        int e2 = e();
        b bVar = this.f9428c.f9409d;
        int i2 = (e2 & 28) >> 2;
        bVar.f9403g = i2;
        if (i2 == 0) {
            bVar.f9403g = 1;
        }
        bVar.f9402f = (e2 & 1) != 0;
        int o2 = o();
        if (o2 < 2) {
            o2 = 10;
        }
        b bVar2 = this.f9428c.f9409d;
        bVar2.f9405i = o2 * 10;
        bVar2.f9404h = e();
        e();
    }

    private void l() {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < 6; i2++) {
            sb.append((char) e());
        }
        if (!sb.toString().startsWith("GIF")) {
            this.f9428c.b = 1;
            return;
        }
        m();
        if (!this.f9428c.f9413h || b()) {
            return;
        }
        c cVar = this.f9428c;
        cVar.a = h(cVar.f9414i);
        c cVar2 = this.f9428c;
        cVar2.f9417l = cVar2.a[cVar2.f9415j];
    }

    private void m() {
        this.f9428c.f9411f = o();
        this.f9428c.f9412g = o();
        int e2 = e();
        c cVar = this.f9428c;
        cVar.f9413h = (e2 & 128) != 0;
        cVar.f9414i = (int) Math.pow(2.0d, (e2 & 7) + 1);
        this.f9428c.f9415j = e();
        this.f9428c.f9416k = e();
    }

    private void n() {
        do {
            g();
            byte[] bArr = this.a;
            if (bArr[0] == 1) {
                this.f9428c.f9418m = ((bArr[2] & 255) << 8) | (bArr[1] & 255);
            }
            if (this.f9429d <= 0) {
                return;
            }
        } while (!b());
    }

    private int o() {
        return this.b.getShort();
    }

    private void p() {
        this.b = null;
        Arrays.fill(this.a, (byte) 0);
        this.f9428c = new c();
        this.f9429d = 0;
    }

    private void s() {
        int e2;
        do {
            e2 = e();
            this.b.position(Math.min(this.b.position() + e2, this.b.limit()));
        } while (e2 > 0);
    }

    private void t() {
        e();
        s();
    }

    public void a() {
        this.b = null;
        this.f9428c = null;
    }

    public boolean c() {
        l();
        if (!b()) {
            j(2);
        }
        return this.f9428c.f9408c > 1;
    }

    @NonNull
    public c d() {
        if (this.b != null) {
            if (b()) {
                return this.f9428c;
            }
            l();
            if (!b()) {
                i();
                c cVar = this.f9428c;
                if (cVar.f9408c < 0) {
                    cVar.b = 1;
                }
            }
            return this.f9428c;
        }
        throw new IllegalStateException("You must call setData() before parseHeader()");
    }

    public d q(@NonNull ByteBuffer byteBuffer) {
        p();
        ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        this.b = asReadOnlyBuffer;
        asReadOnlyBuffer.position(0);
        this.b.order(ByteOrder.LITTLE_ENDIAN);
        return this;
    }

    public d r(@Nullable byte[] bArr) {
        if (bArr != null) {
            q(ByteBuffer.wrap(bArr));
        } else {
            this.b = null;
            this.f9428c.b = 2;
        }
        return this;
    }
}
