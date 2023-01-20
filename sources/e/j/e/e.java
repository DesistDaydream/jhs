package e.j.e;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public final class e extends h implements Iterable<h> {
    private final List<h> a;

    public e() {
        this.a = new ArrayList();
    }

    public void B(h hVar) {
        if (hVar == null) {
            hVar = i.a;
        }
        this.a.add(hVar);
    }

    public void C(Boolean bool) {
        this.a.add(bool == null ? i.a : new l(bool));
    }

    public void D(Character ch) {
        this.a.add(ch == null ? i.a : new l(ch));
    }

    public void E(Number number) {
        this.a.add(number == null ? i.a : new l(number));
    }

    public void F(String str) {
        this.a.add(str == null ? i.a : new l(str));
    }

    public void G(e eVar) {
        this.a.addAll(eVar.a);
    }

    public boolean H(h hVar) {
        return this.a.contains(hVar);
    }

    @Override // e.j.e.h
    /* renamed from: I */
    public e a() {
        if (!this.a.isEmpty()) {
            e eVar = new e(this.a.size());
            for (h hVar : this.a) {
                eVar.B(hVar.a());
            }
            return eVar;
        }
        return new e();
    }

    public h J(int i2) {
        return this.a.get(i2);
    }

    public h K(int i2) {
        return this.a.remove(i2);
    }

    public boolean L(h hVar) {
        return this.a.remove(hVar);
    }

    public h M(int i2, h hVar) {
        return this.a.set(i2, hVar);
    }

    @Override // e.j.e.h
    public BigDecimal b() {
        if (this.a.size() == 1) {
            return this.a.get(0).b();
        }
        throw new IllegalStateException();
    }

    @Override // e.j.e.h
    public BigInteger d() {
        if (this.a.size() == 1) {
            return this.a.get(0).d();
        }
        throw new IllegalStateException();
    }

    @Override // e.j.e.h
    public boolean e() {
        if (this.a.size() == 1) {
            return this.a.get(0).e();
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof e) && ((e) obj).a.equals(this.a));
    }

    @Override // e.j.e.h
    public byte f() {
        if (this.a.size() == 1) {
            return this.a.get(0).f();
        }
        throw new IllegalStateException();
    }

    @Override // e.j.e.h
    public char g() {
        if (this.a.size() == 1) {
            return this.a.get(0).g();
        }
        throw new IllegalStateException();
    }

    @Override // e.j.e.h
    public double h() {
        if (this.a.size() == 1) {
            return this.a.get(0).h();
        }
        throw new IllegalStateException();
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    @Override // e.j.e.h
    public float i() {
        if (this.a.size() == 1) {
            return this.a.get(0).i();
        }
        throw new IllegalStateException();
    }

    public boolean isEmpty() {
        return this.a.isEmpty();
    }

    @Override // java.lang.Iterable
    public Iterator<h> iterator() {
        return this.a.iterator();
    }

    @Override // e.j.e.h
    public int m() {
        if (this.a.size() == 1) {
            return this.a.get(0).m();
        }
        throw new IllegalStateException();
    }

    public int size() {
        return this.a.size();
    }

    @Override // e.j.e.h
    public long t() {
        if (this.a.size() == 1) {
            return this.a.get(0).t();
        }
        throw new IllegalStateException();
    }

    @Override // e.j.e.h
    public Number u() {
        if (this.a.size() == 1) {
            return this.a.get(0).u();
        }
        throw new IllegalStateException();
    }

    @Override // e.j.e.h
    public short v() {
        if (this.a.size() == 1) {
            return this.a.get(0).v();
        }
        throw new IllegalStateException();
    }

    @Override // e.j.e.h
    public String w() {
        if (this.a.size() == 1) {
            return this.a.get(0).w();
        }
        throw new IllegalStateException();
    }

    public e(int i2) {
        this.a = new ArrayList(i2);
    }
}
