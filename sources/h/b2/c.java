package h.b2;

import androidx.exifinterface.media.ExifInterface;
import com.umeng.analytics.pro.am;
import h.s0;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000F\n\u0002\b\u0002\n\u0002\u0010\u000f\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0005\n\u0002\u0010\u0012\n\u0002\u0010\u0006\n\u0002\u0010\u0013\n\u0002\u0010\u0007\n\u0002\u0010\u0014\n\u0002\u0010\b\n\u0002\u0010\u0015\n\u0002\u0010\t\n\u0002\u0010\u0016\n\u0002\u0010\n\n\u0002\u0010\u0017\n\u0002\b\u0002\u001a-\u0010\u0000\u001a\u0002H\u0001\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u0006\u0010\u0003\u001a\u0002H\u00012\u0006\u0010\u0004\u001a\u0002H\u0001H\u0007¢\u0006\u0002\u0010\u0005\u001a5\u0010\u0000\u001a\u0002H\u0001\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u0006\u0010\u0003\u001a\u0002H\u00012\u0006\u0010\u0004\u001a\u0002H\u00012\u0006\u0010\u0006\u001a\u0002H\u0001H\u0007¢\u0006\u0002\u0010\u0007\u001a9\u0010\u0000\u001a\u0002H\u0001\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u0006\u0010\u0003\u001a\u0002H\u00012\u0012\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00010\t\"\u0002H\u0001H\u0007¢\u0006\u0002\u0010\n\u001a\u0019\u0010\u0000\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u000bH\u0087\b\u001a!\u0010\u0000\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u000bH\u0087\b\u001a\u001c\u0010\u0000\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u000b2\n\u0010\b\u001a\u00020\f\"\u00020\u000bH\u0007\u001a\u0019\u0010\u0000\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\rH\u0087\b\u001a!\u0010\u0000\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\rH\u0087\b\u001a\u001c\u0010\u0000\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r2\n\u0010\b\u001a\u00020\u000e\"\u00020\rH\u0007\u001a\u0019\u0010\u0000\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u000fH\u0087\b\u001a!\u0010\u0000\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u000fH\u0087\b\u001a\u001c\u0010\u0000\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u000f2\n\u0010\b\u001a\u00020\u0010\"\u00020\u000fH\u0007\u001a\u0019\u0010\u0000\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u0011H\u0087\b\u001a!\u0010\u0000\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u0011H\u0087\b\u001a\u001c\u0010\u0000\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00112\n\u0010\b\u001a\u00020\u0012\"\u00020\u0011H\u0007\u001a\u0019\u0010\u0000\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u0013H\u0087\b\u001a!\u0010\u0000\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u0013H\u0087\b\u001a\u001c\u0010\u0000\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00132\n\u0010\b\u001a\u00020\u0014\"\u00020\u0013H\u0007\u001a\u0019\u0010\u0000\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u0015H\u0087\b\u001a!\u0010\u0000\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u0015H\u0087\b\u001a\u001c\u0010\u0000\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00152\n\u0010\b\u001a\u00020\u0016\"\u00020\u0015H\u0007\u001a-\u0010\u0017\u001a\u0002H\u0001\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u0006\u0010\u0003\u001a\u0002H\u00012\u0006\u0010\u0004\u001a\u0002H\u0001H\u0007¢\u0006\u0002\u0010\u0005\u001a5\u0010\u0017\u001a\u0002H\u0001\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u0006\u0010\u0003\u001a\u0002H\u00012\u0006\u0010\u0004\u001a\u0002H\u00012\u0006\u0010\u0006\u001a\u0002H\u0001H\u0007¢\u0006\u0002\u0010\u0007\u001a9\u0010\u0017\u001a\u0002H\u0001\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u0006\u0010\u0003\u001a\u0002H\u00012\u0012\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00010\t\"\u0002H\u0001H\u0007¢\u0006\u0002\u0010\n\u001a\u0019\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u000bH\u0087\b\u001a!\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u000bH\u0087\b\u001a\u001c\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u000b2\n\u0010\b\u001a\u00020\f\"\u00020\u000bH\u0007\u001a\u0019\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\rH\u0087\b\u001a!\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\rH\u0087\b\u001a\u001c\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r2\n\u0010\b\u001a\u00020\u000e\"\u00020\rH\u0007\u001a\u0019\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u000fH\u0087\b\u001a!\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u000fH\u0087\b\u001a\u001c\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u000f2\n\u0010\b\u001a\u00020\u0010\"\u00020\u000fH\u0007\u001a\u0019\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u0011H\u0087\b\u001a!\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u0011H\u0087\b\u001a\u001c\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00112\n\u0010\b\u001a\u00020\u0012\"\u00020\u0011H\u0007\u001a\u0019\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u0013H\u0087\b\u001a!\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u0013H\u0087\b\u001a\u001c\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00132\n\u0010\b\u001a\u00020\u0014\"\u00020\u0013H\u0007\u001a\u0019\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u0015H\u0087\b\u001a!\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u0015H\u0087\b\u001a\u001c\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00152\n\u0010\b\u001a\u00020\u0016\"\u00020\u0015H\u0007¨\u0006\u0018"}, d2 = {"maxOf", ExifInterface.GPS_DIRECTION_TRUE, "", am.av, "b", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)Ljava/lang/Comparable;", "c", "(Ljava/lang/Comparable;Ljava/lang/Comparable;Ljava/lang/Comparable;)Ljava/lang/Comparable;", "other", "", "(Ljava/lang/Comparable;[Ljava/lang/Comparable;)Ljava/lang/Comparable;", "", "", "", "", "", "", "", "", "", "", "", "", "minOf", "kotlin-stdlib"}, k = 5, mv = {1, 5, 1}, xi = 1, xs = "kotlin/comparisons/ComparisonsKt")
/* loaded from: classes3.dex */
public class c extends b {
    @h.g2.f
    @s0(version = "1.1")
    private static final byte A(byte b, byte b2, byte b3) {
        return (byte) Math.max((int) b, Math.max((int) b2, (int) b3));
    }

    @s0(version = "1.4")
    public static final byte B(byte b, @k.e.a.d byte... bArr) {
        for (byte b2 : bArr) {
            b = (byte) Math.max((int) b, (int) b2);
        }
        return b;
    }

    @h.g2.f
    @s0(version = "1.1")
    private static final double C(double d2, double d3) {
        return Math.max(d2, d3);
    }

    @h.g2.f
    @s0(version = "1.1")
    private static final double D(double d2, double d3, double d4) {
        return Math.max(d2, Math.max(d3, d4));
    }

    @s0(version = "1.4")
    public static final double E(double d2, @k.e.a.d double... dArr) {
        for (double d3 : dArr) {
            d2 = Math.max(d2, d3);
        }
        return d2;
    }

    @h.g2.f
    @s0(version = "1.1")
    private static final float F(float f2, float f3) {
        return Math.max(f2, f3);
    }

    @h.g2.f
    @s0(version = "1.1")
    private static final float G(float f2, float f3, float f4) {
        return Math.max(f2, Math.max(f3, f4));
    }

    @s0(version = "1.4")
    public static final float H(float f2, @k.e.a.d float... fArr) {
        for (float f3 : fArr) {
            f2 = Math.max(f2, f3);
        }
        return f2;
    }

    @h.g2.f
    @s0(version = "1.1")
    private static final int I(int i2, int i3) {
        return Math.max(i2, i3);
    }

    @h.g2.f
    @s0(version = "1.1")
    private static final int J(int i2, int i3, int i4) {
        return Math.max(i2, Math.max(i3, i4));
    }

    @s0(version = "1.4")
    public static final int K(int i2, @k.e.a.d int... iArr) {
        for (int i3 : iArr) {
            i2 = Math.max(i2, i3);
        }
        return i2;
    }

    @h.g2.f
    @s0(version = "1.1")
    private static final long L(long j2, long j3) {
        return Math.max(j2, j3);
    }

    @h.g2.f
    @s0(version = "1.1")
    private static final long M(long j2, long j3, long j4) {
        return Math.max(j2, Math.max(j3, j4));
    }

    @s0(version = "1.4")
    public static final long N(long j2, @k.e.a.d long... jArr) {
        for (long j3 : jArr) {
            j2 = Math.max(j2, j3);
        }
        return j2;
    }

    @s0(version = "1.1")
    @k.e.a.d
    public static final <T extends Comparable<? super T>> T O(@k.e.a.d T t, @k.e.a.d T t2) {
        return t.compareTo(t2) >= 0 ? t : t2;
    }

    @s0(version = "1.1")
    @k.e.a.d
    public static final <T extends Comparable<? super T>> T P(@k.e.a.d T t, @k.e.a.d T t2, @k.e.a.d T t3) {
        return (T) O(t, O(t2, t3));
    }

    @s0(version = "1.4")
    @k.e.a.d
    public static final <T extends Comparable<? super T>> T Q(@k.e.a.d T t, @k.e.a.d T... tArr) {
        for (T t2 : tArr) {
            t = (T) O(t, t2);
        }
        return t;
    }

    @h.g2.f
    @s0(version = "1.1")
    private static final short R(short s, short s2) {
        return (short) Math.max((int) s, (int) s2);
    }

    @h.g2.f
    @s0(version = "1.1")
    private static final short S(short s, short s2, short s3) {
        return (short) Math.max((int) s, Math.max((int) s2, (int) s3));
    }

    @s0(version = "1.4")
    public static final short T(short s, @k.e.a.d short... sArr) {
        for (short s2 : sArr) {
            s = (short) Math.max((int) s, (int) s2);
        }
        return s;
    }

    @h.g2.f
    @s0(version = "1.1")
    private static final byte U(byte b, byte b2) {
        return (byte) Math.min((int) b, (int) b2);
    }

    @h.g2.f
    @s0(version = "1.1")
    private static final byte V(byte b, byte b2, byte b3) {
        return (byte) Math.min((int) b, Math.min((int) b2, (int) b3));
    }

    @s0(version = "1.4")
    public static final byte W(byte b, @k.e.a.d byte... bArr) {
        for (byte b2 : bArr) {
            b = (byte) Math.min((int) b, (int) b2);
        }
        return b;
    }

    @h.g2.f
    @s0(version = "1.1")
    private static final double X(double d2, double d3) {
        return Math.min(d2, d3);
    }

    @h.g2.f
    @s0(version = "1.1")
    private static final double Y(double d2, double d3, double d4) {
        return Math.min(d2, Math.min(d3, d4));
    }

    @s0(version = "1.4")
    public static final double Z(double d2, @k.e.a.d double... dArr) {
        for (double d3 : dArr) {
            d2 = Math.min(d2, d3);
        }
        return d2;
    }

    @h.g2.f
    @s0(version = "1.1")
    private static final float a0(float f2, float f3) {
        return Math.min(f2, f3);
    }

    @h.g2.f
    @s0(version = "1.1")
    private static final float b0(float f2, float f3, float f4) {
        return Math.min(f2, Math.min(f3, f4));
    }

    @s0(version = "1.4")
    public static final float c0(float f2, @k.e.a.d float... fArr) {
        for (float f3 : fArr) {
            f2 = Math.min(f2, f3);
        }
        return f2;
    }

    @h.g2.f
    @s0(version = "1.1")
    private static final int d0(int i2, int i3) {
        return Math.min(i2, i3);
    }

    @h.g2.f
    @s0(version = "1.1")
    private static final int e0(int i2, int i3, int i4) {
        return Math.min(i2, Math.min(i3, i4));
    }

    @s0(version = "1.4")
    public static final int f0(int i2, @k.e.a.d int... iArr) {
        for (int i3 : iArr) {
            i2 = Math.min(i2, i3);
        }
        return i2;
    }

    @h.g2.f
    @s0(version = "1.1")
    private static final long g0(long j2, long j3) {
        return Math.min(j2, j3);
    }

    @h.g2.f
    @s0(version = "1.1")
    private static final long h0(long j2, long j3, long j4) {
        return Math.min(j2, Math.min(j3, j4));
    }

    @s0(version = "1.4")
    public static final long i0(long j2, @k.e.a.d long... jArr) {
        for (long j3 : jArr) {
            j2 = Math.min(j2, j3);
        }
        return j2;
    }

    @s0(version = "1.1")
    @k.e.a.d
    public static final <T extends Comparable<? super T>> T j0(@k.e.a.d T t, @k.e.a.d T t2) {
        return t.compareTo(t2) <= 0 ? t : t2;
    }

    @s0(version = "1.1")
    @k.e.a.d
    public static final <T extends Comparable<? super T>> T k0(@k.e.a.d T t, @k.e.a.d T t2, @k.e.a.d T t3) {
        return (T) j0(t, j0(t2, t3));
    }

    @s0(version = "1.4")
    @k.e.a.d
    public static final <T extends Comparable<? super T>> T l0(@k.e.a.d T t, @k.e.a.d T... tArr) {
        for (T t2 : tArr) {
            t = (T) j0(t, t2);
        }
        return t;
    }

    @h.g2.f
    @s0(version = "1.1")
    private static final short m0(short s, short s2) {
        return (short) Math.min((int) s, (int) s2);
    }

    @h.g2.f
    @s0(version = "1.1")
    private static final short n0(short s, short s2, short s3) {
        return (short) Math.min((int) s, Math.min((int) s2, (int) s3));
    }

    @s0(version = "1.4")
    public static final short o0(short s, @k.e.a.d short... sArr) {
        for (short s2 : sArr) {
            s = (short) Math.min((int) s, (int) s2);
        }
        return s;
    }

    @h.g2.f
    @s0(version = "1.1")
    private static final byte z(byte b, byte b2) {
        return (byte) Math.max((int) b, (int) b2);
    }
}
