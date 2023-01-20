package h;

import com.caverock.androidsvg.SVG;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u0087\b\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0087\b\u001a\r\u0010\u0003\u001a\u00020\u0001*\u00020\u0001H\u0087\b\u001a\r\u0010\u0003\u001a\u00020\u0001*\u00020\u0002H\u0087\b\u001a\r\u0010\u0004\u001a\u00020\u0001*\u00020\u0001H\u0087\b\u001a\r\u0010\u0004\u001a\u00020\u0001*\u00020\u0002H\u0087\b\u001a\u0015\u0010\u0005\u001a\u00020\u0006*\u00020\u00072\u0006\u0010\b\u001a\u00020\u0002H\u0087\b\u001a\u0015\u0010\u0005\u001a\u00020\t*\u00020\n2\u0006\u0010\b\u001a\u00020\u0001H\u0087\b\u001a\r\u0010\u000b\u001a\u00020\f*\u00020\u0006H\u0087\b\u001a\r\u0010\u000b\u001a\u00020\f*\u00020\tH\u0087\b\u001a\r\u0010\r\u001a\u00020\f*\u00020\u0006H\u0087\b\u001a\r\u0010\r\u001a\u00020\f*\u00020\tH\u0087\b\u001a\r\u0010\u000e\u001a\u00020\f*\u00020\u0006H\u0087\b\u001a\r\u0010\u000e\u001a\u00020\f*\u00020\tH\u0087\b\u001a\u0015\u0010\u000f\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u0001H\u0087\b\u001a\u0015\u0010\u000f\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0001H\u0087\b\u001a\u0015\u0010\u0011\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u0001H\u0087\b\u001a\u0015\u0010\u0011\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0001H\u0087\b\u001a\r\u0010\u0012\u001a\u00020\u0001*\u00020\u0001H\u0087\b\u001a\r\u0010\u0012\u001a\u00020\u0002*\u00020\u0002H\u0087\b\u001a\r\u0010\u0013\u001a\u00020\u0001*\u00020\u0001H\u0087\b\u001a\r\u0010\u0013\u001a\u00020\u0002*\u00020\u0002H\u0087\b\u001a\r\u0010\u0014\u001a\u00020\u0002*\u00020\u0006H\u0087\b\u001a\r\u0010\u0014\u001a\u00020\u0001*\u00020\tH\u0087\b\u001a\r\u0010\u0015\u001a\u00020\u0002*\u00020\u0006H\u0087\b\u001a\r\u0010\u0015\u001a\u00020\u0001*\u00020\tH\u0087\b¨\u0006\u0016"}, d2 = {"countLeadingZeroBits", "", "", "countOneBits", "countTrailingZeroBits", "fromBits", "", "Lkotlin/Double$Companion;", "bits", "", "Lkotlin/Float$Companion;", "isFinite", "", "isInfinite", "isNaN", "rotateLeft", "bitCount", "rotateRight", "takeHighestOneBit", "takeLowestOneBit", "toBits", "toRawBits", "kotlin-stdlib"}, k = 5, mv = {1, 5, 1}, xi = 1, xs = "kotlin/NumbersKt")
/* loaded from: classes3.dex */
public class f0 extends e0 {
    @h.g2.f
    @s0(version = SVG.f2474i)
    private static final float A0(h.k2.v.y yVar, int i2) {
        return Float.intBitsToFloat(i2);
    }

    @h.g2.f
    private static final boolean B0(double d2) {
        return (Double.isInfinite(d2) || Double.isNaN(d2)) ? false : true;
    }

    @h.g2.f
    private static final boolean C0(float f2) {
        return (Float.isInfinite(f2) || Float.isNaN(f2)) ? false : true;
    }

    @h.g2.f
    private static final boolean D0(double d2) {
        return Double.isInfinite(d2);
    }

    @h.g2.f
    private static final boolean E0(float f2) {
        return Float.isInfinite(f2);
    }

    @h.g2.f
    private static final boolean F0(double d2) {
        return Double.isNaN(d2);
    }

    @h.g2.f
    private static final boolean G0(float f2) {
        return Float.isNaN(f2);
    }

    @o
    @h.g2.f
    @s0(version = "1.3")
    private static final int H0(int i2, int i3) {
        return Integer.rotateLeft(i2, i3);
    }

    @o
    @h.g2.f
    @s0(version = "1.3")
    private static final long I0(long j2, int i2) {
        return Long.rotateLeft(j2, i2);
    }

    @o
    @h.g2.f
    @s0(version = "1.3")
    private static final int J0(int i2, int i3) {
        return Integer.rotateRight(i2, i3);
    }

    @o
    @h.g2.f
    @s0(version = "1.3")
    private static final long K0(long j2, int i2) {
        return Long.rotateRight(j2, i2);
    }

    @h.g2.f
    @x1(markerClass = {o.class})
    @s0(version = "1.4")
    private static final int L0(int i2) {
        return Integer.highestOneBit(i2);
    }

    @h.g2.f
    @x1(markerClass = {o.class})
    @s0(version = "1.4")
    private static final long M0(long j2) {
        return Long.highestOneBit(j2);
    }

    @h.g2.f
    @x1(markerClass = {o.class})
    @s0(version = "1.4")
    private static final int N0(int i2) {
        return Integer.lowestOneBit(i2);
    }

    @h.g2.f
    @x1(markerClass = {o.class})
    @s0(version = "1.4")
    private static final long O0(long j2) {
        return Long.lowestOneBit(j2);
    }

    @h.g2.f
    @s0(version = SVG.f2474i)
    private static final int P0(float f2) {
        return Float.floatToIntBits(f2);
    }

    @h.g2.f
    @s0(version = SVG.f2474i)
    private static final long Q0(double d2) {
        return Double.doubleToLongBits(d2);
    }

    @h.g2.f
    @s0(version = SVG.f2474i)
    private static final int R0(float f2) {
        return Float.floatToRawIntBits(f2);
    }

    @h.g2.f
    @s0(version = SVG.f2474i)
    private static final long S0(double d2) {
        return Double.doubleToRawLongBits(d2);
    }

    @h.g2.f
    @x1(markerClass = {o.class})
    @s0(version = "1.4")
    private static final int t0(int i2) {
        return Integer.numberOfLeadingZeros(i2);
    }

    @h.g2.f
    @x1(markerClass = {o.class})
    @s0(version = "1.4")
    private static final int u0(long j2) {
        return Long.numberOfLeadingZeros(j2);
    }

    @h.g2.f
    @x1(markerClass = {o.class})
    @s0(version = "1.4")
    private static final int v0(int i2) {
        return Integer.bitCount(i2);
    }

    @h.g2.f
    @x1(markerClass = {o.class})
    @s0(version = "1.4")
    private static final int w0(long j2) {
        return Long.bitCount(j2);
    }

    @h.g2.f
    @x1(markerClass = {o.class})
    @s0(version = "1.4")
    private static final int x0(int i2) {
        return Integer.numberOfTrailingZeros(i2);
    }

    @h.g2.f
    @x1(markerClass = {o.class})
    @s0(version = "1.4")
    private static final int y0(long j2) {
        return Long.numberOfTrailingZeros(j2);
    }

    @h.g2.f
    @s0(version = SVG.f2474i)
    private static final double z0(h.k2.v.v vVar, long j2) {
        return Double.longBitsToDouble(j2);
    }
}
