package h.p2.b0.g.t.i;

import h.p2.b0.g.t.i.d;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.NoSuchElementException;

/* loaded from: classes3.dex */
public class m extends d {

    /* renamed from: c  reason: collision with root package name */
    public final byte[] f15446c;

    /* renamed from: d  reason: collision with root package name */
    private int f15447d = 0;

    /* loaded from: classes3.dex */
    public class b implements d.a {
        private int a;
        private final int b;

        @Override // java.util.Iterator
        /* renamed from: a */
        public Byte next() {
            return Byte.valueOf(k());
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.a < this.b;
        }

        @Override // h.p2.b0.g.t.i.d.a
        public byte k() {
            try {
                byte[] bArr = m.this.f15446c;
                int i2 = this.a;
                this.a = i2 + 1;
                return bArr[i2];
            } catch (ArrayIndexOutOfBoundsException e2) {
                throw new NoSuchElementException(e2.getMessage());
            }
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        private b() {
            this.a = 0;
            this.b = m.this.size();
        }
    }

    public m(byte[] bArr) {
        this.f15446c = bArr;
    }

    public static int F(int i2, byte[] bArr, int i3, int i4) {
        for (int i5 = i3; i5 < i3 + i4; i5++) {
            i2 = (i2 * 31) + bArr[i5];
        }
        return i2;
    }

    @Override // h.p2.b0.g.t.i.d
    public void B(OutputStream outputStream, int i2, int i3) throws IOException {
        outputStream.write(this.f15446c, E() + i2, i3);
    }

    public byte C(int i2) {
        return this.f15446c[i2];
    }

    public boolean D(m mVar, int i2, int i3) {
        if (i3 <= mVar.size()) {
            if (i2 + i3 <= mVar.size()) {
                byte[] bArr = this.f15446c;
                byte[] bArr2 = mVar.f15446c;
                int E = E() + i3;
                int E2 = E();
                int E3 = mVar.E() + i2;
                while (E2 < E) {
                    if (bArr[E2] != bArr2[E3]) {
                        return false;
                    }
                    E2++;
                    E3++;
                }
                return true;
            }
            int size = mVar.size();
            StringBuilder sb = new StringBuilder(59);
            sb.append("Ran off end of other: ");
            sb.append(i2);
            sb.append(", ");
            sb.append(i3);
            sb.append(", ");
            sb.append(size);
            throw new IllegalArgumentException(sb.toString());
        }
        int size2 = size();
        StringBuilder sb2 = new StringBuilder(40);
        sb2.append("Length too large: ");
        sb2.append(i3);
        sb2.append(size2);
        throw new IllegalArgumentException(sb2.toString());
    }

    public int E() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof d) && size() == ((d) obj).size()) {
            if (size() == 0) {
                return true;
            }
            if (obj instanceof m) {
                return D((m) obj, 0, size());
            }
            if (obj instanceof r) {
                return obj.equals(this);
            }
            String valueOf = String.valueOf(String.valueOf(obj.getClass()));
            StringBuilder sb = new StringBuilder(valueOf.length() + 49);
            sb.append("Has a new type of ByteString been created? Found ");
            sb.append(valueOf);
            throw new IllegalArgumentException(sb.toString());
        }
        return false;
    }

    public int hashCode() {
        int i2 = this.f15447d;
        if (i2 == 0) {
            int size = size();
            i2 = u(size, 0, size);
            if (i2 == 0) {
                i2 = 1;
            }
            this.f15447d = i2;
        }
        return i2;
    }

    @Override // h.p2.b0.g.t.i.d
    public void i(byte[] bArr, int i2, int i3, int i4) {
        System.arraycopy(this.f15446c, i2, bArr, i3, i4);
    }

    @Override // h.p2.b0.g.t.i.d
    public int m() {
        return 0;
    }

    @Override // h.p2.b0.g.t.i.d
    public boolean p() {
        return true;
    }

    @Override // h.p2.b0.g.t.i.d
    public boolean q() {
        int E = E();
        return u.f(this.f15446c, E, size() + E);
    }

    @Override // h.p2.b0.g.t.i.d, java.lang.Iterable
    /* renamed from: r */
    public d.a iterator() {
        return new b();
    }

    @Override // h.p2.b0.g.t.i.d
    public e s() {
        return e.h(this);
    }

    @Override // h.p2.b0.g.t.i.d
    public int size() {
        return this.f15446c.length;
    }

    @Override // h.p2.b0.g.t.i.d
    public int u(int i2, int i3, int i4) {
        return F(i2, this.f15446c, E() + i3, i4);
    }

    @Override // h.p2.b0.g.t.i.d
    public int v(int i2, int i3, int i4) {
        int E = E() + i3;
        return u.g(i2, this.f15446c, E, i4 + E);
    }

    @Override // h.p2.b0.g.t.i.d
    public int w() {
        return this.f15447d;
    }

    @Override // h.p2.b0.g.t.i.d
    public String y(String str) throws UnsupportedEncodingException {
        return new String(this.f15446c, E(), size(), str);
    }
}
