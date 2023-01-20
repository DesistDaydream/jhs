package e.j.e;

import java.io.IOException;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.math.BigInteger;

/* loaded from: classes2.dex */
public abstract class h {
    public boolean A() {
        return this instanceof l;
    }

    public abstract h a();

    public BigDecimal b() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public BigInteger d() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public boolean e() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public byte f() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    @Deprecated
    public char g() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public double h() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public float i() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public int m() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public e p() {
        if (x()) {
            return (e) this;
        }
        throw new IllegalStateException("Not a JSON Array: " + this);
    }

    public i q() {
        if (y()) {
            return (i) this;
        }
        throw new IllegalStateException("Not a JSON Null: " + this);
    }

    public j r() {
        if (z()) {
            return (j) this;
        }
        throw new IllegalStateException("Not a JSON Object: " + this);
    }

    public l s() {
        if (A()) {
            return (l) this;
        }
        throw new IllegalStateException("Not a JSON Primitive: " + this);
    }

    public long t() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public String toString() {
        try {
            StringWriter stringWriter = new StringWriter();
            e.j.e.u.c cVar = new e.j.e.u.c(stringWriter);
            cVar.z0(true);
            e.j.e.s.i.b(this, cVar);
            return stringWriter.toString();
        } catch (IOException e2) {
            throw new AssertionError(e2);
        }
    }

    public Number u() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public short v() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public String w() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public boolean x() {
        return this instanceof e;
    }

    public boolean y() {
        return this instanceof i;
    }

    public boolean z() {
        return this instanceof j;
    }
}
