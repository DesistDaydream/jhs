package h.l2;

import com.caverock.androidsvg.SVG;
import com.tencent.android.tpush.common.MessageKey;
import com.umeng.analytics.pro.am;
import h.g2.f;
import h.s0;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b7\u001a\u0011\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\b\u001a\u0011\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0011\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\tH\u0087\b\u001a\u0011\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\fH\u0087\b\u001a\u0011\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\b\u001a\u0011\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0010\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0007\u001a\u0011\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0011\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\b\u001a\u0011\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0010\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0007\u001a\u0011\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0011\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\b\u001a\u0011\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0019\u0010\u001e\u001a\u00020\u00012\u0006\u0010\u001f\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\b\u001a\u0019\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0010\u0010 \u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0007\u001a\u0011\u0010 \u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0011\u0010!\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\b\u001a\u0011\u0010!\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0011\u0010\"\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\b\u001a\u0011\u0010\"\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0011\u0010#\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\b\u001a\u0011\u0010#\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0011\u0010$\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\b\u001a\u0011\u0010$\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0011\u0010%\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\b\u001a\u0011\u0010%\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0011\u0010&\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\b\u001a\u0011\u0010&\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0019\u0010'\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u001f\u001a\u00020\u0001H\u0087\b\u001a\u0019\u0010'\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u0006H\u0087\b\u001a\u0011\u0010(\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\b\u001a\u0011\u0010(\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0011\u0010)\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\b\u001a\u0011\u0010)\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0018\u0010*\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u00012\u0006\u0010+\u001a\u00020\u0001H\u0007\u001a\u0018\u0010*\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010+\u001a\u00020\u0006H\u0007\u001a\u0011\u0010,\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\b\u001a\u0011\u0010,\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0010\u0010-\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0007\u001a\u0010\u0010-\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0007\u001a\u0019\u0010.\u001a\u00020\u00012\u0006\u0010/\u001a\u00020\u00012\u0006\u00100\u001a\u00020\u0001H\u0087\b\u001a\u0019\u0010.\u001a\u00020\u00062\u0006\u0010/\u001a\u00020\u00062\u0006\u00100\u001a\u00020\u0006H\u0087\b\u001a\u0019\u0010.\u001a\u00020\t2\u0006\u0010/\u001a\u00020\t2\u0006\u00100\u001a\u00020\tH\u0087\b\u001a\u0019\u0010.\u001a\u00020\f2\u0006\u0010/\u001a\u00020\f2\u0006\u00100\u001a\u00020\fH\u0087\b\u001a\u0019\u00101\u001a\u00020\u00012\u0006\u0010/\u001a\u00020\u00012\u0006\u00100\u001a\u00020\u0001H\u0087\b\u001a\u0019\u00101\u001a\u00020\u00062\u0006\u0010/\u001a\u00020\u00062\u0006\u00100\u001a\u00020\u0006H\u0087\b\u001a\u0019\u00101\u001a\u00020\t2\u0006\u0010/\u001a\u00020\t2\u0006\u00100\u001a\u00020\tH\u0087\b\u001a\u0019\u00101\u001a\u00020\f2\u0006\u0010/\u001a\u00020\f2\u0006\u00100\u001a\u00020\fH\u0087\b\u001a\u0011\u00102\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\b\u001a\u0011\u00102\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0011\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\b\u001a\u0011\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0011\u00103\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\b\u001a\u0011\u00103\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0011\u00104\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\b\u001a\u0011\u00104\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0011\u00105\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\b\u001a\u0011\u00105\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0011\u00106\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\b\u001a\u0011\u00106\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0011\u00107\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\b\u001a\u0011\u00107\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0010\u00108\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0007\u001a\u0010\u00108\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0007\u001a\u0015\u00109\u001a\u00020\u0001*\u00020\u00012\u0006\u0010:\u001a\u00020\u0001H\u0087\b\u001a\u0015\u00109\u001a\u00020\u0006*\u00020\u00062\u0006\u0010:\u001a\u00020\u0006H\u0087\b\u001a\r\u0010;\u001a\u00020\u0001*\u00020\u0001H\u0087\b\u001a\r\u0010;\u001a\u00020\u0006*\u00020\u0006H\u0087\b\u001a\u0015\u0010<\u001a\u00020\u0001*\u00020\u00012\u0006\u0010=\u001a\u00020\u0001H\u0087\b\u001a\u0015\u0010<\u001a\u00020\u0006*\u00020\u00062\u0006\u0010=\u001a\u00020\u0006H\u0087\b\u001a\r\u0010>\u001a\u00020\u0001*\u00020\u0001H\u0087\b\u001a\r\u0010>\u001a\u00020\u0006*\u00020\u0006H\u0087\b\u001a\u0015\u0010?\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\b\u001a\u0015\u0010?\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0018\u001a\u00020\tH\u0087\b\u001a\u0015\u0010?\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0015\u0010?\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u0018\u001a\u00020\tH\u0087\b\u001a\f\u0010@\u001a\u00020\t*\u00020\u0001H\u0007\u001a\f\u0010@\u001a\u00020\t*\u00020\u0006H\u0007\u001a\f\u0010A\u001a\u00020\f*\u00020\u0001H\u0007\u001a\f\u0010A\u001a\u00020\f*\u00020\u0006H\u0007\u001a\u0015\u0010B\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0001H\u0087\b\u001a\u0015\u0010B\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u000f\u001a\u00020\tH\u0087\b\u001a\u0015\u0010B\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0006H\u0087\b\u001a\u0015\u0010B\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u000f\u001a\u00020\tH\u0087\b\"\u001f\u0010\u0000\u001a\u00020\u0001*\u00020\u00018Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005\"\u001f\u0010\u0000\u001a\u00020\u0006*\u00020\u00068Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0002\u0010\u0007\u001a\u0004\b\u0004\u0010\b\"\u001f\u0010\u0000\u001a\u00020\t*\u00020\t8Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0002\u0010\n\u001a\u0004\b\u0004\u0010\u000b\"\u001f\u0010\u0000\u001a\u00020\f*\u00020\f8Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0002\u0010\r\u001a\u0004\b\u0004\u0010\u000e\"\u001f\u0010\u000f\u001a\u00020\u0001*\u00020\u00018Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u0003\u001a\u0004\b\u0011\u0010\u0005\"\u001f\u0010\u000f\u001a\u00020\u0006*\u00020\u00068Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u0007\u001a\u0004\b\u0011\u0010\b\"\u001e\u0010\u000f\u001a\u00020\t*\u00020\t8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\n\u001a\u0004\b\u0011\u0010\u000b\"\u001e\u0010\u000f\u001a\u00020\t*\u00020\f8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u0012\"\u001f\u0010\u0013\u001a\u00020\u0001*\u00020\u00018Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u0003\u001a\u0004\b\u0015\u0010\u0005\"\u001f\u0010\u0013\u001a\u00020\u0006*\u00020\u00068Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u0007\u001a\u0004\b\u0015\u0010\b¨\u0006C"}, d2 = {"absoluteValue", "", "getAbsoluteValue$annotations", "(D)V", "getAbsoluteValue", "(D)D", "", "(F)V", "(F)F", "", "(I)V", "(I)I", "", "(J)V", "(J)J", "sign", "getSign$annotations", "getSign", "(J)I", "ulp", "getUlp$annotations", "getUlp", "abs", "x", "n", "acos", "acosh", "asin", "asinh", "atan", "atan2", "y", "atanh", "ceil", "cos", "cosh", "exp", "expm1", "floor", "hypot", "ln", "ln1p", "log", "base", "log10", "log2", "max", am.av, "b", MessageKey.MSG_ACCEPT_TIME_MIN, "round", "sin", "sinh", "sqrt", "tan", "tanh", "truncate", "IEEErem", "divisor", "nextDown", "nextTowards", "to", "nextUp", "pow", "roundToInt", "roundToLong", "withSign", "kotlin-stdlib"}, k = 5, mv = {1, 5, 1}, xi = 1, xs = "kotlin/math/MathKt")
/* loaded from: classes3.dex */
public class d extends c {
    @f
    @s0(version = SVG.f2474i)
    private static final double A(double d2) {
        return Math.exp(d2);
    }

    @f
    @s0(version = SVG.f2474i)
    private static final double A0(double d2, double d3) {
        return Math.pow(d2, d3);
    }

    @f
    @s0(version = SVG.f2474i)
    private static final float B(float f2) {
        return (float) Math.exp(f2);
    }

    @f
    @s0(version = SVG.f2474i)
    private static final double B0(double d2, int i2) {
        return Math.pow(d2, i2);
    }

    @f
    @s0(version = SVG.f2474i)
    private static final double C(double d2) {
        return Math.expm1(d2);
    }

    @f
    @s0(version = SVG.f2474i)
    private static final float C0(float f2, float f3) {
        return (float) Math.pow(f2, f3);
    }

    @f
    @s0(version = SVG.f2474i)
    private static final float D(float f2) {
        return (float) Math.expm1(f2);
    }

    @f
    @s0(version = SVG.f2474i)
    private static final float D0(float f2, int i2) {
        return (float) Math.pow(f2, i2);
    }

    @f
    @s0(version = SVG.f2474i)
    private static final double E(double d2) {
        return Math.floor(d2);
    }

    @f
    @s0(version = SVG.f2474i)
    private static final double E0(double d2) {
        return Math.rint(d2);
    }

    @f
    @s0(version = SVG.f2474i)
    private static final float F(float f2) {
        return (float) Math.floor(f2);
    }

    @f
    @s0(version = SVG.f2474i)
    private static final float F0(float f2) {
        return (float) Math.rint(f2);
    }

    private static final double G(double d2) {
        return Math.abs(d2);
    }

    @s0(version = SVG.f2474i)
    public static final int G0(double d2) {
        if (Double.isNaN(d2)) {
            throw new IllegalArgumentException("Cannot round NaN value.");
        }
        if (d2 > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (d2 < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return (int) Math.round(d2);
    }

    private static final float H(float f2) {
        return Math.abs(f2);
    }

    @s0(version = SVG.f2474i)
    public static final int H0(float f2) {
        if (Float.isNaN(f2)) {
            throw new IllegalArgumentException("Cannot round NaN value.");
        }
        return Math.round(f2);
    }

    private static final int I(int i2) {
        return Math.abs(i2);
    }

    @s0(version = SVG.f2474i)
    public static final long I0(double d2) {
        if (Double.isNaN(d2)) {
            throw new IllegalArgumentException("Cannot round NaN value.");
        }
        return Math.round(d2);
    }

    private static final long J(long j2) {
        return Math.abs(j2);
    }

    @s0(version = SVG.f2474i)
    public static final long J0(float f2) {
        return I0(f2);
    }

    @f
    @s0(version = SVG.f2474i)
    public static /* synthetic */ void K(double d2) {
    }

    @f
    @s0(version = SVG.f2474i)
    private static final double K0(double d2) {
        return Math.signum(d2);
    }

    @f
    @s0(version = SVG.f2474i)
    public static /* synthetic */ void L(float f2) {
    }

    @f
    @s0(version = SVG.f2474i)
    private static final float L0(float f2) {
        return Math.signum(f2);
    }

    @f
    @s0(version = SVG.f2474i)
    public static /* synthetic */ void M(int i2) {
    }

    @f
    @s0(version = SVG.f2474i)
    private static final double M0(double d2) {
        return Math.sin(d2);
    }

    @f
    @s0(version = SVG.f2474i)
    public static /* synthetic */ void N(long j2) {
    }

    @f
    @s0(version = SVG.f2474i)
    private static final float N0(float f2) {
        return (float) Math.sin(f2);
    }

    private static final double O(double d2) {
        return Math.signum(d2);
    }

    @f
    @s0(version = SVG.f2474i)
    private static final double O0(double d2) {
        return Math.sinh(d2);
    }

    private static final float P(float f2) {
        return Math.signum(f2);
    }

    @f
    @s0(version = SVG.f2474i)
    private static final float P0(float f2) {
        return (float) Math.sinh(f2);
    }

    public static final int Q(int i2) {
        if (i2 < 0) {
            return -1;
        }
        return i2 > 0 ? 1 : 0;
    }

    @f
    @s0(version = SVG.f2474i)
    private static final double Q0(double d2) {
        return Math.sqrt(d2);
    }

    public static final int R(long j2) {
        int i2 = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
        if (i2 < 0) {
            return -1;
        }
        return i2 > 0 ? 1 : 0;
    }

    @f
    @s0(version = SVG.f2474i)
    private static final float R0(float f2) {
        return (float) Math.sqrt(f2);
    }

    @f
    @s0(version = SVG.f2474i)
    public static /* synthetic */ void S(double d2) {
    }

    @f
    @s0(version = SVG.f2474i)
    private static final double S0(double d2) {
        return Math.tan(d2);
    }

    @f
    @s0(version = SVG.f2474i)
    public static /* synthetic */ void T(float f2) {
    }

    @f
    @s0(version = SVG.f2474i)
    private static final float T0(float f2) {
        return (float) Math.tan(f2);
    }

    @s0(version = SVG.f2474i)
    public static /* synthetic */ void U(int i2) {
    }

    @f
    @s0(version = SVG.f2474i)
    private static final double U0(double d2) {
        return Math.tanh(d2);
    }

    @s0(version = SVG.f2474i)
    public static /* synthetic */ void V(long j2) {
    }

    @f
    @s0(version = SVG.f2474i)
    private static final float V0(float f2) {
        return (float) Math.tanh(f2);
    }

    private static final double W(double d2) {
        return Math.ulp(d2);
    }

    @s0(version = SVG.f2474i)
    public static final double W0(double d2) {
        if (Double.isNaN(d2) || Double.isInfinite(d2)) {
            return d2;
        }
        if (d2 > 0) {
            return Math.floor(d2);
        }
        return Math.ceil(d2);
    }

    private static final float X(float f2) {
        return Math.ulp(f2);
    }

    @s0(version = SVG.f2474i)
    public static final float X0(float f2) {
        double ceil;
        if (Float.isNaN(f2) || Float.isInfinite(f2)) {
            return f2;
        }
        if (f2 > 0) {
            ceil = Math.floor(f2);
        } else {
            ceil = Math.ceil(f2);
        }
        return (float) ceil;
    }

    @f
    @s0(version = SVG.f2474i)
    public static /* synthetic */ void Y(double d2) {
    }

    @f
    @s0(version = SVG.f2474i)
    private static final double Y0(double d2, double d3) {
        return Math.copySign(d2, d3);
    }

    @f
    @s0(version = SVG.f2474i)
    public static /* synthetic */ void Z(float f2) {
    }

    @f
    @s0(version = SVG.f2474i)
    private static final double Z0(double d2, int i2) {
        return Math.copySign(d2, i2);
    }

    @f
    @s0(version = SVG.f2474i)
    private static final double a(double d2, double d3) {
        return Math.IEEEremainder(d2, d3);
    }

    @f
    @s0(version = SVG.f2474i)
    private static final double a0(double d2, double d3) {
        return Math.hypot(d2, d3);
    }

    @f
    @s0(version = SVG.f2474i)
    private static final float a1(float f2, float f3) {
        return Math.copySign(f2, f3);
    }

    @f
    @s0(version = SVG.f2474i)
    private static final float b(float f2, float f3) {
        return (float) Math.IEEEremainder(f2, f3);
    }

    @f
    @s0(version = SVG.f2474i)
    private static final float b0(float f2, float f3) {
        return (float) Math.hypot(f2, f3);
    }

    @f
    @s0(version = SVG.f2474i)
    private static final float b1(float f2, int i2) {
        return Math.copySign(f2, i2);
    }

    @f
    @s0(version = SVG.f2474i)
    private static final double c(double d2) {
        return Math.abs(d2);
    }

    @f
    @s0(version = SVG.f2474i)
    private static final double c0(double d2) {
        return Math.log(d2);
    }

    @f
    @s0(version = SVG.f2474i)
    private static final float d(float f2) {
        return Math.abs(f2);
    }

    @f
    @s0(version = SVG.f2474i)
    private static final float d0(float f2) {
        return (float) Math.log(f2);
    }

    @f
    @s0(version = SVG.f2474i)
    private static final int e(int i2) {
        return Math.abs(i2);
    }

    @f
    @s0(version = SVG.f2474i)
    private static final double e0(double d2) {
        return Math.log1p(d2);
    }

    @f
    @s0(version = SVG.f2474i)
    private static final long f(long j2) {
        return Math.abs(j2);
    }

    @f
    @s0(version = SVG.f2474i)
    private static final float f0(float f2) {
        return (float) Math.log1p(f2);
    }

    @f
    @s0(version = SVG.f2474i)
    private static final double g(double d2) {
        return Math.acos(d2);
    }

    @s0(version = SVG.f2474i)
    public static final double g0(double d2, double d3) {
        if (d3 <= 0.0d || d3 == 1.0d) {
            return Double.NaN;
        }
        return Math.log(d2) / Math.log(d3);
    }

    @f
    @s0(version = SVG.f2474i)
    private static final float h(float f2) {
        return (float) Math.acos(f2);
    }

    @s0(version = SVG.f2474i)
    public static final float h0(float f2, float f3) {
        if (f3 <= 0.0f || f3 == 1.0f) {
            return Float.NaN;
        }
        return (float) (Math.log(f2) / Math.log(f3));
    }

    @s0(version = SVG.f2474i)
    public static final double i(double d2) {
        double d3 = 1;
        if (d2 < d3) {
            return Double.NaN;
        }
        if (d2 > a.f14954e) {
            return Math.log(d2) + a.a;
        }
        double d4 = d2 - d3;
        if (d4 >= a.f14953d) {
            return Math.log(d2 + Math.sqrt((d2 * d2) - d3));
        }
        double sqrt = Math.sqrt(d4);
        if (sqrt >= a.f14952c) {
            sqrt -= ((sqrt * sqrt) * sqrt) / 12;
        }
        return sqrt * Math.sqrt(2.0d);
    }

    @f
    @s0(version = SVG.f2474i)
    private static final double i0(double d2) {
        return Math.log10(d2);
    }

    @f
    @s0(version = SVG.f2474i)
    private static final float j(float f2) {
        return (float) i(f2);
    }

    @f
    @s0(version = SVG.f2474i)
    private static final float j0(float f2) {
        return (float) Math.log10(f2);
    }

    @f
    @s0(version = SVG.f2474i)
    private static final double k(double d2) {
        return Math.asin(d2);
    }

    @s0(version = SVG.f2474i)
    public static final double k0(double d2) {
        return Math.log(d2) / a.a;
    }

    @f
    @s0(version = SVG.f2474i)
    private static final float l(float f2) {
        return (float) Math.asin(f2);
    }

    @s0(version = SVG.f2474i)
    public static final float l0(float f2) {
        return (float) (Math.log(f2) / a.a);
    }

    @s0(version = SVG.f2474i)
    public static final double m(double d2) {
        double d3 = a.f14953d;
        if (d2 < d3) {
            if (d2 <= (-d3)) {
                return -m(-d2);
            }
            return Math.abs(d2) >= a.f14952c ? d2 - (((d2 * d2) * d2) / 6) : d2;
        } else if (d2 > a.f14955f) {
            if (d2 > a.f14954e) {
                return Math.log(d2) + a.a;
            }
            double d4 = d2 * 2;
            return Math.log(d4 + (1 / d4));
        } else {
            return Math.log(d2 + Math.sqrt((d2 * d2) + 1));
        }
    }

    @f
    @s0(version = SVG.f2474i)
    private static final double m0(double d2, double d3) {
        return Math.max(d2, d3);
    }

    @f
    @s0(version = SVG.f2474i)
    private static final float n(float f2) {
        return (float) m(f2);
    }

    @f
    @s0(version = SVG.f2474i)
    private static final float n0(float f2, float f3) {
        return Math.max(f2, f3);
    }

    @f
    @s0(version = SVG.f2474i)
    private static final double o(double d2) {
        return Math.atan(d2);
    }

    @f
    @s0(version = SVG.f2474i)
    private static final int o0(int i2, int i3) {
        return Math.max(i2, i3);
    }

    @f
    @s0(version = SVG.f2474i)
    private static final float p(float f2) {
        return (float) Math.atan(f2);
    }

    @f
    @s0(version = SVG.f2474i)
    private static final long p0(long j2, long j3) {
        return Math.max(j2, j3);
    }

    @f
    @s0(version = SVG.f2474i)
    private static final double q(double d2, double d3) {
        return Math.atan2(d2, d3);
    }

    @f
    @s0(version = SVG.f2474i)
    private static final double q0(double d2, double d3) {
        return Math.min(d2, d3);
    }

    @f
    @s0(version = SVG.f2474i)
    private static final float r(float f2, float f3) {
        return (float) Math.atan2(f2, f3);
    }

    @f
    @s0(version = SVG.f2474i)
    private static final float r0(float f2, float f3) {
        return Math.min(f2, f3);
    }

    @s0(version = SVG.f2474i)
    public static final double s(double d2) {
        if (Math.abs(d2) < a.f14953d) {
            return Math.abs(d2) > a.f14952c ? d2 + (((d2 * d2) * d2) / 3) : d2;
        }
        double d3 = 1;
        return Math.log((d3 + d2) / (d3 - d2)) / 2;
    }

    @f
    @s0(version = SVG.f2474i)
    private static final int s0(int i2, int i3) {
        return Math.min(i2, i3);
    }

    @f
    @s0(version = SVG.f2474i)
    private static final float t(float f2) {
        return (float) s(f2);
    }

    @f
    @s0(version = SVG.f2474i)
    private static final long t0(long j2, long j3) {
        return Math.min(j2, j3);
    }

    @f
    @s0(version = SVG.f2474i)
    private static final double u(double d2) {
        return Math.ceil(d2);
    }

    @f
    @s0(version = SVG.f2474i)
    private static final double u0(double d2) {
        return Math.nextAfter(d2, Double.NEGATIVE_INFINITY);
    }

    @f
    @s0(version = SVG.f2474i)
    private static final float v(float f2) {
        return (float) Math.ceil(f2);
    }

    @f
    @s0(version = SVG.f2474i)
    private static final float v0(float f2) {
        return Math.nextAfter(f2, Double.NEGATIVE_INFINITY);
    }

    @f
    @s0(version = SVG.f2474i)
    private static final double w(double d2) {
        return Math.cos(d2);
    }

    @f
    @s0(version = SVG.f2474i)
    private static final double w0(double d2, double d3) {
        return Math.nextAfter(d2, d3);
    }

    @f
    @s0(version = SVG.f2474i)
    private static final float x(float f2) {
        return (float) Math.cos(f2);
    }

    @f
    @s0(version = SVG.f2474i)
    private static final float x0(float f2, float f3) {
        return Math.nextAfter(f2, f3);
    }

    @f
    @s0(version = SVG.f2474i)
    private static final double y(double d2) {
        return Math.cosh(d2);
    }

    @f
    @s0(version = SVG.f2474i)
    private static final double y0(double d2) {
        return Math.nextUp(d2);
    }

    @f
    @s0(version = SVG.f2474i)
    private static final float z(float f2) {
        return (float) Math.cosh(f2);
    }

    @f
    @s0(version = SVG.f2474i)
    private static final float z0(float f2) {
        return Math.nextUp(f2);
    }
}
