package h;

import com.caverock.androidsvg.SVG;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\f\u001a\r\u0010\u0003\u001a\u00020\u0001*\u00020\u0001H\u0087\n\u001a\u0015\u0010\u0004\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\n\u001a\r\u0010\u0005\u001a\u00020\u0001*\u00020\u0001H\u0087\n\u001a\r\u0010\u0006\u001a\u00020\u0001*\u00020\u0001H\u0087\b\u001a\u0015\u0010\u0007\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\n\u001a\u0015\u0010\b\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\f\u001a\u0015\u0010\t\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\n\u001a\u0015\u0010\n\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\n\u001a\u0015\u0010\u000b\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\f\u001a\u00020\rH\u0087\f\u001a\u0015\u0010\u000e\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\f\u001a\u00020\rH\u0087\f\u001a\u0015\u0010\u000f\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\n\u001a\r\u0010\u0010\u001a\u00020\u0011*\u00020\u0001H\u0087\b\u001a!\u0010\u0010\u001a\u00020\u0011*\u00020\u00012\b\b\u0002\u0010\u0012\u001a\u00020\r2\b\b\u0002\u0010\u0013\u001a\u00020\u0014H\u0087\b\u001a\r\u0010\u0015\u001a\u00020\u0001*\u00020\rH\u0087\b\u001a\r\u0010\u0015\u001a\u00020\u0001*\u00020\u0016H\u0087\b\u001a\r\u0010\u0017\u001a\u00020\u0001*\u00020\u0001H\u0087\n\u001a\u0015\u0010\u0018\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\f¨\u0006\u0019"}, d2 = {"and", "Ljava/math/BigInteger;", "other", "dec", "div", "inc", "inv", "minus", "or", "plus", "rem", "shl", "n", "", "shr", "times", "toBigDecimal", "Ljava/math/BigDecimal;", "scale", "mathContext", "Ljava/math/MathContext;", "toBigInteger", "", "unaryMinus", "xor", "kotlin-stdlib"}, k = 5, mv = {1, 5, 1}, xi = 1, xs = "kotlin/NumbersKt")
/* loaded from: classes3.dex */
public class d0 extends c0 {
    @h.g2.f
    @s0(version = SVG.f2474i)
    private static final BigInteger A(BigInteger bigInteger, int i2) {
        return bigInteger.shiftRight(i2);
    }

    @h.g2.f
    private static final BigInteger B(BigInteger bigInteger, BigInteger bigInteger2) {
        return bigInteger.multiply(bigInteger2);
    }

    @h.g2.f
    @s0(version = SVG.f2474i)
    private static final BigDecimal C(BigInteger bigInteger) {
        return new BigDecimal(bigInteger);
    }

    @h.g2.f
    @s0(version = SVG.f2474i)
    private static final BigDecimal D(BigInteger bigInteger, int i2, MathContext mathContext) {
        return new BigDecimal(bigInteger, i2, mathContext);
    }

    public static /* synthetic */ BigDecimal E(BigInteger bigInteger, int i2, MathContext mathContext, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = 0;
        }
        if ((i3 & 2) != 0) {
            mathContext = MathContext.UNLIMITED;
        }
        return new BigDecimal(bigInteger, i2, mathContext);
    }

    @h.g2.f
    @s0(version = SVG.f2474i)
    private static final BigInteger F(int i2) {
        return BigInteger.valueOf(i2);
    }

    @h.g2.f
    @s0(version = SVG.f2474i)
    private static final BigInteger G(long j2) {
        return BigInteger.valueOf(j2);
    }

    @h.g2.f
    private static final BigInteger H(BigInteger bigInteger) {
        return bigInteger.negate();
    }

    @h.g2.f
    @s0(version = SVG.f2474i)
    private static final BigInteger I(BigInteger bigInteger, BigInteger bigInteger2) {
        return bigInteger.xor(bigInteger2);
    }

    @h.g2.f
    @s0(version = SVG.f2474i)
    private static final BigInteger q(BigInteger bigInteger, BigInteger bigInteger2) {
        return bigInteger.and(bigInteger2);
    }

    @h.g2.f
    @s0(version = SVG.f2474i)
    private static final BigInteger r(BigInteger bigInteger) {
        return bigInteger.subtract(BigInteger.ONE);
    }

    @h.g2.f
    private static final BigInteger s(BigInteger bigInteger, BigInteger bigInteger2) {
        return bigInteger.divide(bigInteger2);
    }

    @h.g2.f
    @s0(version = SVG.f2474i)
    private static final BigInteger t(BigInteger bigInteger) {
        return bigInteger.add(BigInteger.ONE);
    }

    @h.g2.f
    @s0(version = SVG.f2474i)
    private static final BigInteger u(BigInteger bigInteger) {
        return bigInteger.not();
    }

    @h.g2.f
    private static final BigInteger v(BigInteger bigInteger, BigInteger bigInteger2) {
        return bigInteger.subtract(bigInteger2);
    }

    @h.g2.f
    @s0(version = SVG.f2474i)
    private static final BigInteger w(BigInteger bigInteger, BigInteger bigInteger2) {
        return bigInteger.or(bigInteger2);
    }

    @h.g2.f
    private static final BigInteger x(BigInteger bigInteger, BigInteger bigInteger2) {
        return bigInteger.add(bigInteger2);
    }

    @h.g2.f
    @s0(version = "1.1")
    private static final BigInteger y(BigInteger bigInteger, BigInteger bigInteger2) {
        return bigInteger.remainder(bigInteger2);
    }

    @h.g2.f
    @s0(version = SVG.f2474i)
    private static final BigInteger z(BigInteger bigInteger, int i2) {
        return bigInteger.shiftLeft(i2);
    }
}
