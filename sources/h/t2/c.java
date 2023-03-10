package h.t2;

import h.s0;
import h.x1;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\f\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0007\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0007\u001a\f\u0010\u0004\u001a\u00020\u0002*\u00020\u0001H\u0007\u001a\u0014\u0010\u0004\u001a\u00020\u0002*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0007\u001a\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0002*\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0006\u001a\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u0002*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0002\u0010\u0007\u001a\u001c\u0010\b\u001a\u00020\t*\u00020\u00012\u0006\u0010\n\u001a\u00020\u00012\b\b\u0002\u0010\u000b\u001a\u00020\t\u001a\n\u0010\f\u001a\u00020\t*\u00020\u0001\u001a\u0015\u0010\r\u001a\u00020\u000e*\u00020\u00012\u0006\u0010\n\u001a\u00020\u000eH\u0087\n\u001a\f\u0010\u000f\u001a\u00020\u000e*\u00020\u0001H\u0007¨\u0006\u0010"}, d2 = {"digitToChar", "", "", "radix", "digitToInt", "digitToIntOrNull", "(C)Ljava/lang/Integer;", "(CI)Ljava/lang/Integer;", "equals", "", "other", "ignoreCase", "isSurrogate", "plus", "", "titlecase", "kotlin-stdlib"}, k = 5, mv = {1, 5, 1}, xi = 1, xs = "kotlin/text/CharsKt")
/* loaded from: classes4.dex */
public class c extends b {
    @x1(markerClass = {h.o.class})
    @s0(version = "1.5")
    public static final char D(int i2) {
        if (i2 < 0 || 9 < i2) {
            throw new IllegalArgumentException("Int " + i2 + " is not a decimal digit");
        }
        return (char) (i2 + 48);
    }

    @x1(markerClass = {h.o.class})
    @s0(version = "1.5")
    public static final char E(int i2, int i3) {
        if (2 > i3 || 36 < i3) {
            throw new IllegalArgumentException("Invalid radix: " + i3 + ". Valid radix values are in range 2..36");
        } else if (i2 >= 0 && i2 < i3) {
            return (char) (i2 < 10 ? i2 + 48 : ((char) (i2 + 65)) - '\n');
        } else {
            throw new IllegalArgumentException("Digit " + i2 + " does not represent a valid digit in radix " + i3);
        }
    }

    @x1(markerClass = {h.o.class})
    @s0(version = "1.5")
    public static final int F(char c2) {
        int b = b.b(c2, 10);
        if (b >= 0) {
            return b;
        }
        throw new IllegalArgumentException("Char " + c2 + " is not a decimal digit");
    }

    @x1(markerClass = {h.o.class})
    @s0(version = "1.5")
    public static final int G(char c2, int i2) {
        Integer I = I(c2, i2);
        if (I != null) {
            return I.intValue();
        }
        throw new IllegalArgumentException("Char " + c2 + " is not a digit in the given radix=" + i2);
    }

    @x1(markerClass = {h.o.class})
    @k.e.a.e
    @s0(version = "1.5")
    public static final Integer H(char c2) {
        Integer valueOf = Integer.valueOf(b.b(c2, 10));
        if (valueOf.intValue() >= 0) {
            return valueOf;
        }
        return null;
    }

    @x1(markerClass = {h.o.class})
    @k.e.a.e
    @s0(version = "1.5")
    public static final Integer I(char c2, int i2) {
        b.a(i2);
        Integer valueOf = Integer.valueOf(b.b(c2, i2));
        if (valueOf.intValue() >= 0) {
            return valueOf;
        }
        return null;
    }

    public static final boolean J(char c2, char c3, boolean z) {
        if (c2 == c3) {
            return true;
        }
        if (z) {
            char upperCase = Character.toUpperCase(c2);
            char upperCase2 = Character.toUpperCase(c3);
            return upperCase == upperCase2 || Character.toLowerCase(upperCase) == Character.toLowerCase(upperCase2);
        }
        return false;
    }

    public static /* synthetic */ boolean K(char c2, char c3, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return J(c2, c3, z);
    }

    public static final boolean L(char c2) {
        return 55296 <= c2 && 57343 >= c2;
    }

    @h.g2.f
    private static final String M(char c2, String str) {
        return String.valueOf(c2) + str;
    }

    @s0(version = "1.5")
    @k.e.a.d
    public static final String N(char c2) {
        return a0.a(c2);
    }
}
