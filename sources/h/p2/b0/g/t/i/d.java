package h.p2.b0.g.t.i;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes3.dex */
public abstract class d implements Iterable<Byte> {
    public static final d a = new m(new byte[0]);
    public static final /* synthetic */ boolean b = false;

    /* loaded from: classes3.dex */
    public interface a extends Iterator<Byte> {
        byte k();
    }

    private static d a(Iterator<d> it, int i2) {
        if (i2 == 1) {
            return it.next();
        }
        int i3 = i2 >>> 1;
        return a(it, i3).b(a(it, i2 - i3));
    }

    public static d d(Iterable<d> iterable) {
        Collection collection;
        if (!(iterable instanceof Collection)) {
            collection = new ArrayList();
            for (d dVar : iterable) {
                collection.add(dVar);
            }
        } else {
            collection = (Collection) iterable;
        }
        if (collection.isEmpty()) {
            return a;
        }
        return a(collection.iterator(), collection.size());
    }

    public static d e(byte[] bArr) {
        return f(bArr, 0, bArr.length);
    }

    public static d f(byte[] bArr, int i2, int i3) {
        byte[] bArr2 = new byte[i3];
        System.arraycopy(bArr, i2, bArr2, 0, i3);
        return new m(bArr2);
    }

    public static d g(String str) {
        try {
            return new m(str.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException("UTF-8 not supported?", e2);
        }
    }

    public static b t() {
        return new b(128);
    }

    public void A(OutputStream outputStream, int i2, int i3) throws IOException {
        if (i2 < 0) {
            StringBuilder sb = new StringBuilder(30);
            sb.append("Source offset < 0: ");
            sb.append(i2);
            throw new IndexOutOfBoundsException(sb.toString());
        } else if (i3 >= 0) {
            int i4 = i2 + i3;
            if (i4 <= size()) {
                if (i3 > 0) {
                    B(outputStream, i2, i3);
                    return;
                }
                return;
            }
            StringBuilder sb2 = new StringBuilder(39);
            sb2.append("Source end offset exceeded: ");
            sb2.append(i4);
            throw new IndexOutOfBoundsException(sb2.toString());
        } else {
            StringBuilder sb3 = new StringBuilder(23);
            sb3.append("Length < 0: ");
            sb3.append(i3);
            throw new IndexOutOfBoundsException(sb3.toString());
        }
    }

    public abstract void B(OutputStream outputStream, int i2, int i3) throws IOException;

    public d b(d dVar) {
        int size = size();
        int size2 = dVar.size();
        if (size + size2 < 2147483647L) {
            return r.F(this, dVar);
        }
        StringBuilder sb = new StringBuilder(53);
        sb.append("ByteString would be too long: ");
        sb.append(size);
        sb.append("+");
        sb.append(size2);
        throw new IllegalArgumentException(sb.toString());
    }

    public void h(byte[] bArr, int i2, int i3, int i4) {
        if (i2 < 0) {
            StringBuilder sb = new StringBuilder(30);
            sb.append("Source offset < 0: ");
            sb.append(i2);
            throw new IndexOutOfBoundsException(sb.toString());
        } else if (i3 < 0) {
            StringBuilder sb2 = new StringBuilder(30);
            sb2.append("Target offset < 0: ");
            sb2.append(i3);
            throw new IndexOutOfBoundsException(sb2.toString());
        } else if (i4 >= 0) {
            int i5 = i2 + i4;
            if (i5 <= size()) {
                int i6 = i3 + i4;
                if (i6 <= bArr.length) {
                    if (i4 > 0) {
                        i(bArr, i2, i3, i4);
                        return;
                    }
                    return;
                }
                StringBuilder sb3 = new StringBuilder(34);
                sb3.append("Target end offset < 0: ");
                sb3.append(i6);
                throw new IndexOutOfBoundsException(sb3.toString());
            }
            StringBuilder sb4 = new StringBuilder(34);
            sb4.append("Source end offset < 0: ");
            sb4.append(i5);
            throw new IndexOutOfBoundsException(sb4.toString());
        } else {
            StringBuilder sb5 = new StringBuilder(23);
            sb5.append("Length < 0: ");
            sb5.append(i4);
            throw new IndexOutOfBoundsException(sb5.toString());
        }
    }

    public abstract void i(byte[] bArr, int i2, int i3, int i4);

    public boolean isEmpty() {
        return size() == 0;
    }

    public abstract int m();

    public abstract boolean p();

    public abstract boolean q();

    @Override // java.lang.Iterable
    /* renamed from: r */
    public abstract a iterator();

    public abstract e s();

    public abstract int size();

    public String toString() {
        return String.format("<ByteString@%s size=%d>", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()));
    }

    public abstract int u(int i2, int i3, int i4);

    public abstract int v(int i2, int i3, int i4);

    public abstract int w();

    public byte[] x() {
        int size = size();
        if (size == 0) {
            return h.a;
        }
        byte[] bArr = new byte[size];
        i(bArr, 0, 0, size);
        return bArr;
    }

    public abstract String y(String str) throws UnsupportedEncodingException;

    public String z() {
        try {
            return y("UTF-8");
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException("UTF-8 not supported?", e2);
        }
    }

    /* loaded from: classes3.dex */
    public static final class b extends OutputStream {

        /* renamed from: f  reason: collision with root package name */
        private static final byte[] f15425f = new byte[0];
        private final int a;
        private final ArrayList<d> b;

        /* renamed from: c  reason: collision with root package name */
        private int f15426c;

        /* renamed from: d  reason: collision with root package name */
        private byte[] f15427d;

        /* renamed from: e  reason: collision with root package name */
        private int f15428e;

        public b(int i2) {
            if (i2 >= 0) {
                this.a = i2;
                this.b = new ArrayList<>();
                this.f15427d = new byte[i2];
                return;
            }
            throw new IllegalArgumentException("Buffer size < 0");
        }

        private byte[] a(byte[] bArr, int i2) {
            byte[] bArr2 = new byte[i2];
            System.arraycopy(bArr, 0, bArr2, 0, Math.min(bArr.length, i2));
            return bArr2;
        }

        private void b(int i2) {
            this.b.add(new m(this.f15427d));
            int length = this.f15426c + this.f15427d.length;
            this.f15426c = length;
            this.f15427d = new byte[Math.max(this.a, Math.max(i2, length >>> 1))];
            this.f15428e = 0;
        }

        private void j() {
            int i2 = this.f15428e;
            byte[] bArr = this.f15427d;
            if (i2 >= bArr.length) {
                this.b.add(new m(this.f15427d));
                this.f15427d = f15425f;
            } else if (i2 > 0) {
                this.b.add(new m(a(bArr, i2)));
            }
            this.f15426c += this.f15428e;
            this.f15428e = 0;
        }

        public synchronized int k() {
            return this.f15426c + this.f15428e;
        }

        public synchronized d l() {
            j();
            return d.d(this.b);
        }

        public String toString() {
            return String.format("<ByteString.Output@%s size=%d>", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(k()));
        }

        @Override // java.io.OutputStream
        public synchronized void write(int i2) {
            if (this.f15428e == this.f15427d.length) {
                b(1);
            }
            byte[] bArr = this.f15427d;
            int i3 = this.f15428e;
            this.f15428e = i3 + 1;
            bArr[i3] = (byte) i2;
        }

        @Override // java.io.OutputStream
        public synchronized void write(byte[] bArr, int i2, int i3) {
            byte[] bArr2 = this.f15427d;
            int length = bArr2.length;
            int i4 = this.f15428e;
            if (i3 <= length - i4) {
                System.arraycopy(bArr, i2, bArr2, i4, i3);
                this.f15428e += i3;
            } else {
                int length2 = bArr2.length - i4;
                System.arraycopy(bArr, i2, bArr2, i4, length2);
                int i5 = i3 - length2;
                b(i5);
                System.arraycopy(bArr, i2 + length2, this.f15427d, 0, i5);
                this.f15428e = i5;
            }
        }
    }
}
