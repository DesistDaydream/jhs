package h;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u0005\n\u0002\u0010\n\n\u0002\b\b\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0087\b\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0003H\u0087\b\u001a\r\u0010\u0004\u001a\u00020\u0001*\u00020\u0002H\u0087\b\u001a\r\u0010\u0004\u001a\u00020\u0001*\u00020\u0003H\u0087\b\u001a\r\u0010\u0005\u001a\u00020\u0001*\u00020\u0002H\u0087\b\u001a\r\u0010\u0005\u001a\u00020\u0001*\u00020\u0003H\u0087\b\u001a\u0014\u0010\u0006\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0001H\u0007\u001a\u0014\u0010\u0006\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0001H\u0007\u001a\u0014\u0010\b\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0001H\u0007\u001a\u0014\u0010\b\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0001H\u0007\u001a\r\u0010\t\u001a\u00020\u0002*\u00020\u0002H\u0087\b\u001a\r\u0010\t\u001a\u00020\u0003*\u00020\u0003H\u0087\b\u001a\r\u0010\n\u001a\u00020\u0002*\u00020\u0002H\u0087\b\u001a\r\u0010\n\u001a\u00020\u0003*\u00020\u0003H\u0087\b¨\u0006\u000b"}, d2 = {"countLeadingZeroBits", "", "", "", "countOneBits", "countTrailingZeroBits", "rotateLeft", "bitCount", "rotateRight", "takeHighestOneBit", "takeLowestOneBit", "kotlin-stdlib"}, k = 5, mv = {1, 5, 1}, xi = 1, xs = "kotlin/NumbersKt")
/* loaded from: classes3.dex */
public class g0 extends f0 {
    @h.g2.f
    @x1(markerClass = {o.class})
    @s0(version = "1.4")
    private static final int T0(byte b) {
        return Integer.numberOfLeadingZeros(b & 255) - 24;
    }

    @h.g2.f
    @x1(markerClass = {o.class})
    @s0(version = "1.4")
    private static final int U0(short s) {
        return Integer.numberOfLeadingZeros(s & 65535) - 16;
    }

    @h.g2.f
    @x1(markerClass = {o.class})
    @s0(version = "1.4")
    private static final int V0(byte b) {
        return Integer.bitCount(b & 255);
    }

    @h.g2.f
    @x1(markerClass = {o.class})
    @s0(version = "1.4")
    private static final int W0(short s) {
        return Integer.bitCount(s & 65535);
    }

    @h.g2.f
    @x1(markerClass = {o.class})
    @s0(version = "1.4")
    private static final int X0(byte b) {
        return Integer.numberOfTrailingZeros(b | 256);
    }

    @h.g2.f
    @x1(markerClass = {o.class})
    @s0(version = "1.4")
    private static final int Y0(short s) {
        return Integer.numberOfTrailingZeros(s | 65536);
    }

    @o
    @s0(version = "1.3")
    public static final byte Z0(byte b, int i2) {
        int i3 = i2 & 7;
        return (byte) (((b & 255) >>> (8 - i3)) | (b << i3));
    }

    @o
    @s0(version = "1.3")
    public static final short a1(short s, int i2) {
        int i3 = i2 & 15;
        return (short) (((s & 65535) >>> (16 - i3)) | (s << i3));
    }

    @o
    @s0(version = "1.3")
    public static final byte b1(byte b, int i2) {
        int i3 = i2 & 7;
        return (byte) (((b & 255) >>> i3) | (b << (8 - i3)));
    }

    @o
    @s0(version = "1.3")
    public static final short c1(short s, int i2) {
        int i3 = i2 & 15;
        return (short) (((s & 65535) >>> i3) | (s << (16 - i3)));
    }

    @h.g2.f
    @x1(markerClass = {o.class})
    @s0(version = "1.4")
    private static final byte d1(byte b) {
        return (byte) Integer.highestOneBit(b & 255);
    }

    @h.g2.f
    @x1(markerClass = {o.class})
    @s0(version = "1.4")
    private static final short e1(short s) {
        return (short) Integer.highestOneBit(s & 65535);
    }

    @h.g2.f
    @x1(markerClass = {o.class})
    @s0(version = "1.4")
    private static final byte f1(byte b) {
        return (byte) Integer.lowestOneBit(b);
    }

    @h.g2.f
    @x1(markerClass = {o.class})
    @s0(version = "1.4")
    private static final short g1(short s) {
        return (short) Integer.lowestOneBit(s);
    }
}
