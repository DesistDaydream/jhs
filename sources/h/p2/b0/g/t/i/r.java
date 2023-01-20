package h.p2.b0.g.t.i;

import h.p2.b0.g.t.i.d;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Stack;

/* loaded from: classes3.dex */
public class r extends h.p2.b0.g.t.i.d {

    /* renamed from: i  reason: collision with root package name */
    private static final int[] f15449i;

    /* renamed from: c  reason: collision with root package name */
    private final int f15450c;

    /* renamed from: d  reason: collision with root package name */
    private final h.p2.b0.g.t.i.d f15451d;

    /* renamed from: e  reason: collision with root package name */
    private final h.p2.b0.g.t.i.d f15452e;

    /* renamed from: f  reason: collision with root package name */
    private final int f15453f;

    /* renamed from: g  reason: collision with root package name */
    private final int f15454g;

    /* renamed from: h  reason: collision with root package name */
    private int f15455h;

    /* loaded from: classes3.dex */
    public static class b {
        private final Stack<h.p2.b0.g.t.i.d> a;

        private b() {
            this.a = new Stack<>();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public h.p2.b0.g.t.i.d b(h.p2.b0.g.t.i.d dVar, h.p2.b0.g.t.i.d dVar2) {
            c(dVar);
            c(dVar2);
            h.p2.b0.g.t.i.d pop = this.a.pop();
            while (!this.a.isEmpty()) {
                pop = new r(this.a.pop(), pop);
            }
            return pop;
        }

        private void c(h.p2.b0.g.t.i.d dVar) {
            if (dVar.p()) {
                insert(dVar);
            } else if (dVar instanceof r) {
                r rVar = (r) dVar;
                c(rVar.f15451d);
                c(rVar.f15452e);
            } else {
                String valueOf = String.valueOf(String.valueOf(dVar.getClass()));
                StringBuilder sb = new StringBuilder(valueOf.length() + 49);
                sb.append("Has a new type of ByteString been created? Found ");
                sb.append(valueOf);
                throw new IllegalArgumentException(sb.toString());
            }
        }

        private int d(int i2) {
            int binarySearch = Arrays.binarySearch(r.f15449i, i2);
            return binarySearch < 0 ? (-(binarySearch + 1)) - 1 : binarySearch;
        }

        private void insert(h.p2.b0.g.t.i.d dVar) {
            int d2 = d(dVar.size());
            int i2 = r.f15449i[d2 + 1];
            if (!this.a.isEmpty() && this.a.peek().size() < i2) {
                int i3 = r.f15449i[d2];
                h.p2.b0.g.t.i.d pop = this.a.pop();
                while (!this.a.isEmpty() && this.a.peek().size() < i3) {
                    pop = new r(this.a.pop(), pop);
                }
                r rVar = new r(pop, dVar);
                while (!this.a.isEmpty()) {
                    if (this.a.peek().size() >= r.f15449i[d(rVar.size()) + 1]) {
                        break;
                    }
                    rVar = new r(this.a.pop(), rVar);
                }
                this.a.push(rVar);
                return;
            }
            this.a.push(dVar);
        }
    }

    /* loaded from: classes3.dex */
    public static class c implements Iterator<m> {
        private final Stack<r> a;
        private m b;

        private m a(h.p2.b0.g.t.i.d dVar) {
            while (dVar instanceof r) {
                r rVar = (r) dVar;
                this.a.push(rVar);
                dVar = rVar.f15451d;
            }
            return (m) dVar;
        }

        private m b() {
            while (!this.a.isEmpty()) {
                m a = a(this.a.pop().f15452e);
                if (!a.isEmpty()) {
                    return a;
                }
            }
            return null;
        }

        @Override // java.util.Iterator
        /* renamed from: c */
        public m next() {
            m mVar = this.b;
            if (mVar != null) {
                this.b = b();
                return mVar;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.b != null;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        private c(h.p2.b0.g.t.i.d dVar) {
            this.a = new Stack<>();
            this.b = a(dVar);
        }
    }

    /* loaded from: classes3.dex */
    public class d implements d.a {
        private final c a;
        private d.a b;

        /* renamed from: c  reason: collision with root package name */
        public int f15456c;

        @Override // java.util.Iterator
        /* renamed from: a */
        public Byte next() {
            return Byte.valueOf(k());
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f15456c > 0;
        }

        @Override // h.p2.b0.g.t.i.d.a
        public byte k() {
            if (!this.b.hasNext()) {
                this.b = this.a.next().iterator();
            }
            this.f15456c--;
            return this.b.k();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        private d() {
            c cVar = new c(r.this);
            this.a = cVar;
            this.b = cVar.next().iterator();
            this.f15456c = r.this.size();
        }
    }

    static {
        ArrayList arrayList = new ArrayList();
        int i2 = 1;
        int i3 = 1;
        while (i2 > 0) {
            arrayList.add(Integer.valueOf(i2));
            int i4 = i3 + i2;
            i3 = i2;
            i2 = i4;
        }
        arrayList.add(Integer.MAX_VALUE);
        f15449i = new int[arrayList.size()];
        int i5 = 0;
        while (true) {
            int[] iArr = f15449i;
            if (i5 >= iArr.length) {
                return;
            }
            iArr[i5] = ((Integer) arrayList.get(i5)).intValue();
            i5++;
        }
    }

    public static h.p2.b0.g.t.i.d F(h.p2.b0.g.t.i.d dVar, h.p2.b0.g.t.i.d dVar2) {
        r rVar = dVar instanceof r ? (r) dVar : null;
        if (dVar2.size() == 0) {
            return dVar;
        }
        if (dVar.size() != 0) {
            int size = dVar.size() + dVar2.size();
            if (size < 128) {
                return G(dVar, dVar2);
            }
            if (rVar != null && rVar.f15452e.size() + dVar2.size() < 128) {
                dVar2 = new r(rVar.f15451d, G(rVar.f15452e, dVar2));
            } else if (rVar != null && rVar.f15451d.m() > rVar.f15452e.m() && rVar.m() > dVar2.m()) {
                dVar2 = new r(rVar.f15451d, new r(rVar.f15452e, dVar2));
            } else {
                if (size < f15449i[Math.max(dVar.m(), dVar2.m()) + 1]) {
                    return new b().b(dVar, dVar2);
                }
                return new r(dVar, dVar2);
            }
        }
        return dVar2;
    }

    private static m G(h.p2.b0.g.t.i.d dVar, h.p2.b0.g.t.i.d dVar2) {
        int size = dVar.size();
        int size2 = dVar2.size();
        byte[] bArr = new byte[size + size2];
        dVar.h(bArr, 0, 0, size);
        dVar2.h(bArr, 0, size, size2);
        return new m(bArr);
    }

    private boolean H(h.p2.b0.g.t.i.d dVar) {
        c cVar = new c(this);
        m next = cVar.next();
        c cVar2 = new c(dVar);
        m next2 = cVar2.next();
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            int size = next.size() - i2;
            int size2 = next2.size() - i3;
            int min = Math.min(size, size2);
            if (!(i2 == 0 ? next.D(next2, i3, min) : next2.D(next, i2, min))) {
                return false;
            }
            i4 += min;
            int i5 = this.f15450c;
            if (i4 >= i5) {
                if (i4 == i5) {
                    return true;
                }
                throw new IllegalStateException();
            }
            if (min == size) {
                next = cVar.next();
                i2 = 0;
            } else {
                i2 += min;
            }
            if (min == size2) {
                next2 = cVar2.next();
                i3 = 0;
            } else {
                i3 += min;
            }
        }
    }

    @Override // h.p2.b0.g.t.i.d
    public void B(OutputStream outputStream, int i2, int i3) throws IOException {
        int i4 = i2 + i3;
        int i5 = this.f15453f;
        if (i4 <= i5) {
            this.f15451d.B(outputStream, i2, i3);
        } else if (i2 >= i5) {
            this.f15452e.B(outputStream, i2 - i5, i3);
        } else {
            int i6 = i5 - i2;
            this.f15451d.B(outputStream, i2, i6);
            this.f15452e.B(outputStream, 0, i3 - i6);
        }
    }

    public boolean equals(Object obj) {
        int w;
        if (obj == this) {
            return true;
        }
        if (obj instanceof h.p2.b0.g.t.i.d) {
            h.p2.b0.g.t.i.d dVar = (h.p2.b0.g.t.i.d) obj;
            if (this.f15450c != dVar.size()) {
                return false;
            }
            if (this.f15450c == 0) {
                return true;
            }
            if (this.f15455h == 0 || (w = dVar.w()) == 0 || this.f15455h == w) {
                return H(dVar);
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        int i2 = this.f15455h;
        if (i2 == 0) {
            int i3 = this.f15450c;
            i2 = u(i3, 0, i3);
            if (i2 == 0) {
                i2 = 1;
            }
            this.f15455h = i2;
        }
        return i2;
    }

    @Override // h.p2.b0.g.t.i.d
    public void i(byte[] bArr, int i2, int i3, int i4) {
        int i5 = i2 + i4;
        int i6 = this.f15453f;
        if (i5 <= i6) {
            this.f15451d.i(bArr, i2, i3, i4);
        } else if (i2 >= i6) {
            this.f15452e.i(bArr, i2 - i6, i3, i4);
        } else {
            int i7 = i6 - i2;
            this.f15451d.i(bArr, i2, i3, i7);
            this.f15452e.i(bArr, 0, i3 + i7, i4 - i7);
        }
    }

    @Override // h.p2.b0.g.t.i.d
    public int m() {
        return this.f15454g;
    }

    @Override // h.p2.b0.g.t.i.d
    public boolean p() {
        return this.f15450c >= f15449i[this.f15454g];
    }

    @Override // h.p2.b0.g.t.i.d
    public boolean q() {
        int v = this.f15451d.v(0, 0, this.f15453f);
        h.p2.b0.g.t.i.d dVar = this.f15452e;
        return dVar.v(v, 0, dVar.size()) == 0;
    }

    @Override // h.p2.b0.g.t.i.d, java.lang.Iterable
    /* renamed from: r */
    public d.a iterator() {
        return new d();
    }

    @Override // h.p2.b0.g.t.i.d
    public h.p2.b0.g.t.i.e s() {
        return h.p2.b0.g.t.i.e.g(new e());
    }

    @Override // h.p2.b0.g.t.i.d
    public int size() {
        return this.f15450c;
    }

    @Override // h.p2.b0.g.t.i.d
    public int u(int i2, int i3, int i4) {
        int i5 = i3 + i4;
        int i6 = this.f15453f;
        if (i5 <= i6) {
            return this.f15451d.u(i2, i3, i4);
        }
        if (i3 >= i6) {
            return this.f15452e.u(i2, i3 - i6, i4);
        }
        int i7 = i6 - i3;
        return this.f15452e.u(this.f15451d.u(i2, i3, i7), 0, i4 - i7);
    }

    @Override // h.p2.b0.g.t.i.d
    public int v(int i2, int i3, int i4) {
        int i5 = i3 + i4;
        int i6 = this.f15453f;
        if (i5 <= i6) {
            return this.f15451d.v(i2, i3, i4);
        }
        if (i3 >= i6) {
            return this.f15452e.v(i2, i3 - i6, i4);
        }
        int i7 = i6 - i3;
        return this.f15452e.v(this.f15451d.v(i2, i3, i7), 0, i4 - i7);
    }

    @Override // h.p2.b0.g.t.i.d
    public int w() {
        return this.f15455h;
    }

    @Override // h.p2.b0.g.t.i.d
    public String y(String str) throws UnsupportedEncodingException {
        return new String(x(), str);
    }

    private r(h.p2.b0.g.t.i.d dVar, h.p2.b0.g.t.i.d dVar2) {
        this.f15455h = 0;
        this.f15451d = dVar;
        this.f15452e = dVar2;
        int size = dVar.size();
        this.f15453f = size;
        this.f15450c = size + dVar2.size();
        this.f15454g = Math.max(dVar.m(), dVar2.m()) + 1;
    }

    /* loaded from: classes3.dex */
    public class e extends InputStream {
        private c a;
        private m b;

        /* renamed from: c  reason: collision with root package name */
        private int f15458c;

        /* renamed from: d  reason: collision with root package name */
        private int f15459d;

        /* renamed from: e  reason: collision with root package name */
        private int f15460e;

        /* renamed from: f  reason: collision with root package name */
        private int f15461f;

        public e() {
            k();
        }

        private void j() {
            if (this.b != null) {
                int i2 = this.f15459d;
                int i3 = this.f15458c;
                if (i2 == i3) {
                    this.f15460e += i3;
                    this.f15459d = 0;
                    if (this.a.hasNext()) {
                        m next = this.a.next();
                        this.b = next;
                        this.f15458c = next.size();
                        return;
                    }
                    this.b = null;
                    this.f15458c = 0;
                }
            }
        }

        private void k() {
            c cVar = new c(r.this);
            this.a = cVar;
            m next = cVar.next();
            this.b = next;
            this.f15458c = next.size();
            this.f15459d = 0;
            this.f15460e = 0;
        }

        private int l(byte[] bArr, int i2, int i3) {
            int i4 = i3;
            while (true) {
                if (i4 <= 0) {
                    break;
                }
                j();
                if (this.b != null) {
                    int min = Math.min(this.f15458c - this.f15459d, i4);
                    if (bArr != null) {
                        this.b.h(bArr, this.f15459d, i2, min);
                        i2 += min;
                    }
                    this.f15459d += min;
                    i4 -= min;
                } else if (i4 == i3) {
                    return -1;
                }
            }
            return i3 - i4;
        }

        @Override // java.io.InputStream
        public int available() throws IOException {
            return r.this.size() - (this.f15460e + this.f15459d);
        }

        @Override // java.io.InputStream
        public void mark(int i2) {
            this.f15461f = this.f15460e + this.f15459d;
        }

        @Override // java.io.InputStream
        public boolean markSupported() {
            return true;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i2, int i3) {
            Objects.requireNonNull(bArr);
            if (i2 >= 0 && i3 >= 0 && i3 <= bArr.length - i2) {
                return l(bArr, i2, i3);
            }
            throw new IndexOutOfBoundsException();
        }

        @Override // java.io.InputStream
        public synchronized void reset() {
            k();
            l(null, 0, this.f15461f);
        }

        @Override // java.io.InputStream
        public long skip(long j2) {
            if (j2 >= 0) {
                if (j2 > 2147483647L) {
                    j2 = 2147483647L;
                }
                return l(null, 0, (int) j2);
            }
            throw new IndexOutOfBoundsException();
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            j();
            m mVar = this.b;
            if (mVar == null) {
                return -1;
            }
            int i2 = this.f15459d;
            this.f15459d = i2 + 1;
            return mVar.C(i2) & 255;
        }
    }
}
