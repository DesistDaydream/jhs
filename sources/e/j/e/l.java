package e.j.e;

import com.google.gson.internal.LazilyParsedNumber;
import java.math.BigDecimal;
import java.math.BigInteger;

/* loaded from: classes2.dex */
public final class l extends h {
    private final Object a;

    public l(Boolean bool) {
        this.a = e.j.e.s.a.b(bool);
    }

    private static boolean D(l lVar) {
        Object obj = lVar.a;
        if (obj instanceof Number) {
            Number number = (Number) obj;
            return (number instanceof BigInteger) || (number instanceof Long) || (number instanceof Integer) || (number instanceof Short) || (number instanceof Byte);
        }
        return false;
    }

    @Override // e.j.e.h
    /* renamed from: B */
    public l a() {
        return this;
    }

    public boolean C() {
        return this.a instanceof Boolean;
    }

    public boolean E() {
        return this.a instanceof Number;
    }

    public boolean F() {
        return this.a instanceof String;
    }

    @Override // e.j.e.h
    public BigDecimal b() {
        Object obj = this.a;
        return obj instanceof BigDecimal ? (BigDecimal) obj : new BigDecimal(this.a.toString());
    }

    @Override // e.j.e.h
    public BigInteger d() {
        Object obj = this.a;
        return obj instanceof BigInteger ? (BigInteger) obj : new BigInteger(this.a.toString());
    }

    @Override // e.j.e.h
    public boolean e() {
        if (C()) {
            return ((Boolean) this.a).booleanValue();
        }
        return Boolean.parseBoolean(w());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || l.class != obj.getClass()) {
            return false;
        }
        l lVar = (l) obj;
        if (this.a == null) {
            return lVar.a == null;
        } else if (D(this) && D(lVar)) {
            return u().longValue() == lVar.u().longValue();
        } else {
            Object obj2 = this.a;
            if ((obj2 instanceof Number) && (lVar.a instanceof Number)) {
                double doubleValue = u().doubleValue();
                double doubleValue2 = lVar.u().doubleValue();
                if (doubleValue != doubleValue2) {
                    return Double.isNaN(doubleValue) && Double.isNaN(doubleValue2);
                }
                return true;
            }
            return obj2.equals(lVar.a);
        }
    }

    @Override // e.j.e.h
    public byte f() {
        return E() ? u().byteValue() : Byte.parseByte(w());
    }

    @Override // e.j.e.h
    public char g() {
        return w().charAt(0);
    }

    @Override // e.j.e.h
    public double h() {
        return E() ? u().doubleValue() : Double.parseDouble(w());
    }

    public int hashCode() {
        long doubleToLongBits;
        if (this.a == null) {
            return 31;
        }
        if (D(this)) {
            doubleToLongBits = u().longValue();
        } else {
            Object obj = this.a;
            if (obj instanceof Number) {
                doubleToLongBits = Double.doubleToLongBits(u().doubleValue());
            } else {
                return obj.hashCode();
            }
        }
        return (int) ((doubleToLongBits >>> 32) ^ doubleToLongBits);
    }

    @Override // e.j.e.h
    public float i() {
        return E() ? u().floatValue() : Float.parseFloat(w());
    }

    @Override // e.j.e.h
    public int m() {
        return E() ? u().intValue() : Integer.parseInt(w());
    }

    @Override // e.j.e.h
    public long t() {
        return E() ? u().longValue() : Long.parseLong(w());
    }

    @Override // e.j.e.h
    public Number u() {
        Object obj = this.a;
        return obj instanceof String ? new LazilyParsedNumber((String) this.a) : (Number) obj;
    }

    @Override // e.j.e.h
    public short v() {
        return E() ? u().shortValue() : Short.parseShort(w());
    }

    @Override // e.j.e.h
    public String w() {
        if (E()) {
            return u().toString();
        }
        if (C()) {
            return ((Boolean) this.a).toString();
        }
        return (String) this.a;
    }

    public l(Number number) {
        this.a = e.j.e.s.a.b(number);
    }

    public l(String str) {
        this.a = e.j.e.s.a.b(str);
    }

    public l(Character ch) {
        this.a = ((Character) e.j.e.s.a.b(ch)).toString();
    }
}
