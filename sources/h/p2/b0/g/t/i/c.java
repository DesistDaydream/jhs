package h.p2.b0.g.t.i;

import h.p2.b0.g.t.i.d;
import java.util.NoSuchElementException;

/* loaded from: classes3.dex */
public class c extends m {

    /* renamed from: e  reason: collision with root package name */
    private final int f15422e;

    /* renamed from: f  reason: collision with root package name */
    private final int f15423f;

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
            int i2 = this.a;
            if (i2 < this.b) {
                byte[] bArr = c.this.f15446c;
                this.a = i2 + 1;
                return bArr[i2];
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        private b() {
            int E = c.this.E();
            this.a = E;
            this.b = E + c.this.size();
        }
    }

    public c(byte[] bArr, int i2, int i3) {
        super(bArr);
        if (i2 < 0) {
            StringBuilder sb = new StringBuilder(29);
            sb.append("Offset too small: ");
            sb.append(i2);
            throw new IllegalArgumentException(sb.toString());
        } else if (i3 >= 0) {
            if (i2 + i3 <= bArr.length) {
                this.f15422e = i2;
                this.f15423f = i3;
                return;
            }
            StringBuilder sb2 = new StringBuilder(48);
            sb2.append("Offset+Length too large: ");
            sb2.append(i2);
            sb2.append("+");
            sb2.append(i3);
            throw new IllegalArgumentException(sb2.toString());
        } else {
            StringBuilder sb3 = new StringBuilder(29);
            sb3.append("Length too small: ");
            sb3.append(i2);
            throw new IllegalArgumentException(sb3.toString());
        }
    }

    @Override // h.p2.b0.g.t.i.m
    public byte C(int i2) {
        if (i2 >= 0) {
            if (i2 < size()) {
                return this.f15446c[this.f15422e + i2];
            }
            int size = size();
            StringBuilder sb = new StringBuilder(41);
            sb.append("Index too large: ");
            sb.append(i2);
            sb.append(", ");
            sb.append(size);
            throw new ArrayIndexOutOfBoundsException(sb.toString());
        }
        StringBuilder sb2 = new StringBuilder(28);
        sb2.append("Index too small: ");
        sb2.append(i2);
        throw new ArrayIndexOutOfBoundsException(sb2.toString());
    }

    @Override // h.p2.b0.g.t.i.m
    public int E() {
        return this.f15422e;
    }

    @Override // h.p2.b0.g.t.i.m, h.p2.b0.g.t.i.d
    public void i(byte[] bArr, int i2, int i3, int i4) {
        System.arraycopy(this.f15446c, E() + i2, bArr, i3, i4);
    }

    @Override // h.p2.b0.g.t.i.m, h.p2.b0.g.t.i.d, java.lang.Iterable
    /* renamed from: r */
    public d.a iterator() {
        return new b();
    }

    @Override // h.p2.b0.g.t.i.m, h.p2.b0.g.t.i.d
    public int size() {
        return this.f15423f;
    }
}
