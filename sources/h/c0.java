package h;

import com.caverock.androidsvg.SVG;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\b\u0002\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u0087\n\u001a\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0087\n\u001a\r\u0010\u0004\u001a\u00020\u0001*\u00020\u0001H\u0087\n\u001a\u0015\u0010\u0005\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0087\n\u001a\u0015\u0010\u0006\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0087\n\u001a\u0015\u0010\u0007\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0087\n\u001a\u0015\u0010\b\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0087\n\u001a\r\u0010\t\u001a\u00020\u0001*\u00020\nH\u0087\b\u001a\u0015\u0010\t\u001a\u00020\u0001*\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0087\b\u001a\r\u0010\t\u001a\u00020\u0001*\u00020\rH\u0087\b\u001a\u0015\u0010\t\u001a\u00020\u0001*\u00020\r2\u0006\u0010\u000b\u001a\u00020\fH\u0087\b\u001a\r\u0010\t\u001a\u00020\u0001*\u00020\u000eH\u0087\b\u001a\u0015\u0010\t\u001a\u00020\u0001*\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\fH\u0087\b\u001a\r\u0010\t\u001a\u00020\u0001*\u00020\u000fH\u0087\b\u001a\u0015\u0010\t\u001a\u00020\u0001*\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\fH\u0087\b\u001a\r\u0010\u0010\u001a\u00020\u0001*\u00020\u0001H\u0087\n¨\u0006\u0011"}, d2 = {"dec", "Ljava/math/BigDecimal;", "div", "other", "inc", "minus", "plus", "rem", "times", "toBigDecimal", "", "mathContext", "Ljava/math/MathContext;", "", "", "", "unaryMinus", "kotlin-stdlib"}, k = 5, mv = {1, 5, 1}, xi = 1, xs = "kotlin/NumbersKt")
/* loaded from: classes3.dex */
public class c0 {
    @h.g2.f
    @s0(version = SVG.f2474i)
    private static final BigDecimal a(BigDecimal bigDecimal) {
        return bigDecimal.subtract(BigDecimal.ONE);
    }

    @h.g2.f
    private static final BigDecimal b(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        return bigDecimal.divide(bigDecimal2, RoundingMode.HALF_EVEN);
    }

    @h.g2.f
    @s0(version = SVG.f2474i)
    private static final BigDecimal c(BigDecimal bigDecimal) {
        return bigDecimal.add(BigDecimal.ONE);
    }

    @h.g2.f
    private static final BigDecimal d(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        return bigDecimal.subtract(bigDecimal2);
    }

    @h.g2.f
    private static final BigDecimal e(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        return bigDecimal.add(bigDecimal2);
    }

    @h.g2.f
    private static final BigDecimal f(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        return bigDecimal.remainder(bigDecimal2);
    }

    @h.g2.f
    private static final BigDecimal g(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        return bigDecimal.multiply(bigDecimal2);
    }

    @h.g2.f
    @s0(version = SVG.f2474i)
    private static final BigDecimal h(double d2) {
        return new BigDecimal(String.valueOf(d2));
    }

    @h.g2.f
    @s0(version = SVG.f2474i)
    private static final BigDecimal i(double d2, MathContext mathContext) {
        return new BigDecimal(String.valueOf(d2), mathContext);
    }

    @h.g2.f
    @s0(version = SVG.f2474i)
    private static final BigDecimal j(float f2) {
        return new BigDecimal(String.valueOf(f2));
    }

    @h.g2.f
    @s0(version = SVG.f2474i)
    private static final BigDecimal k(float f2, MathContext mathContext) {
        return new BigDecimal(String.valueOf(f2), mathContext);
    }

    @h.g2.f
    @s0(version = SVG.f2474i)
    private static final BigDecimal l(int i2) {
        return BigDecimal.valueOf(i2);
    }

    @h.g2.f
    @s0(version = SVG.f2474i)
    private static final BigDecimal m(int i2, MathContext mathContext) {
        return new BigDecimal(i2, mathContext);
    }

    @h.g2.f
    @s0(version = SVG.f2474i)
    private static final BigDecimal n(long j2) {
        return BigDecimal.valueOf(j2);
    }

    @h.g2.f
    @s0(version = SVG.f2474i)
    private static final BigDecimal o(long j2, MathContext mathContext) {
        return new BigDecimal(j2, mathContext);
    }

    @h.g2.f
    private static final BigDecimal p(BigDecimal bigDecimal) {
        return bigDecimal.negate();
    }
}
