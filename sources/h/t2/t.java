package h.t2;

import h.k2.v.f0;
import h.s0;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\n\n\u0002\b\u0003\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005*\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0006\u001a\u001b\u0010\u0004\u001a\u0004\u0018\u00010\u0005*\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0007¢\u0006\u0002\u0010\t\u001a\u0013\u0010\n\u001a\u0004\u0018\u00010\b*\u00020\u0003H\u0007¢\u0006\u0002\u0010\u000b\u001a\u001b\u0010\n\u001a\u0004\u0018\u00010\b*\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0007¢\u0006\u0002\u0010\f\u001a\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e*\u00020\u0003H\u0007¢\u0006\u0002\u0010\u000f\u001a\u001b\u0010\r\u001a\u0004\u0018\u00010\u000e*\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0007¢\u0006\u0002\u0010\u0010\u001a\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012*\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0013\u001a\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u0012*\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0007¢\u0006\u0002\u0010\u0014¨\u0006\u0015"}, d2 = {"numberFormatError", "", "input", "", "toByteOrNull", "", "(Ljava/lang/String;)Ljava/lang/Byte;", "radix", "", "(Ljava/lang/String;I)Ljava/lang/Byte;", "toIntOrNull", "(Ljava/lang/String;)Ljava/lang/Integer;", "(Ljava/lang/String;I)Ljava/lang/Integer;", "toLongOrNull", "", "(Ljava/lang/String;)Ljava/lang/Long;", "(Ljava/lang/String;I)Ljava/lang/Long;", "toShortOrNull", "", "(Ljava/lang/String;)Ljava/lang/Short;", "(Ljava/lang/String;I)Ljava/lang/Short;", "kotlin-stdlib"}, k = 5, mv = {1, 5, 1}, xi = 1, xs = "kotlin/text/StringsKt")
/* loaded from: classes4.dex */
public class t extends s {
    @k.e.a.d
    public static final Void U0(@k.e.a.d String str) {
        throw new NumberFormatException("Invalid number format: '" + str + '\'');
    }

    @k.e.a.e
    @s0(version = "1.1")
    public static final Byte V0(@k.e.a.d String str) {
        return W0(str, 10);
    }

    @k.e.a.e
    @s0(version = "1.1")
    public static final Byte W0(@k.e.a.d String str, int i2) {
        int intValue;
        Integer Y0 = Y0(str, i2);
        if (Y0 == null || (intValue = Y0.intValue()) < -128 || intValue > 127) {
            return null;
        }
        return Byte.valueOf((byte) intValue);
    }

    @k.e.a.e
    @s0(version = "1.1")
    public static final Integer X0(@k.e.a.d String str) {
        return Y0(str, 10);
    }

    @k.e.a.e
    @s0(version = "1.1")
    public static final Integer Y0(@k.e.a.d String str, int i2) {
        boolean z;
        int i3;
        b.a(i2);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i4 = 0;
        char charAt = str.charAt(0);
        int i5 = -2147483647;
        int i6 = 1;
        if (f0.t(charAt, 48) >= 0) {
            z = false;
            i6 = 0;
        } else if (length == 1) {
            return null;
        } else {
            if (charAt == '-') {
                i5 = Integer.MIN_VALUE;
                z = true;
            } else if (charAt != '+') {
                return null;
            } else {
                z = false;
            }
        }
        int i7 = -59652323;
        while (i6 < length) {
            int b = b.b(str.charAt(i6), i2);
            if (b < 0) {
                return null;
            }
            if ((i4 < i7 && (i7 != -59652323 || i4 < (i7 = i5 / i2))) || (i3 = i4 * i2) < i5 + b) {
                return null;
            }
            i4 = i3 - b;
            i6++;
        }
        return z ? Integer.valueOf(i4) : Integer.valueOf(-i4);
    }

    @k.e.a.e
    @s0(version = "1.1")
    public static final Long Z0(@k.e.a.d String str) {
        return a1(str, 10);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0075  */
    @k.e.a.e
    @h.s0(version = "1.1")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Long a1(@k.e.a.d java.lang.String r18, int r19) {
        /*
            r0 = r18
            r1 = r19
            h.t2.b.a(r19)
            int r2 = r18.length()
            r3 = 0
            if (r2 != 0) goto Lf
            return r3
        Lf:
            r4 = 0
            char r5 = r0.charAt(r4)
            r6 = 48
            int r6 = h.k2.v.f0.t(r5, r6)
            r7 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r9 = 1
            if (r6 >= 0) goto L34
            if (r2 != r9) goto L25
            return r3
        L25:
            r6 = 45
            if (r5 != r6) goto L2d
            r7 = -9223372036854775808
            r4 = 1
            goto L35
        L2d:
            r6 = 43
            if (r5 != r6) goto L33
            r4 = 1
            goto L34
        L33:
            return r3
        L34:
            r9 = 0
        L35:
            r5 = -256204778801521550(0xfc71c71c71c71c72, double:-2.772000429909333E291)
            r10 = 0
            r12 = r5
        L3d:
            if (r4 >= r2) goto L6e
            char r14 = r0.charAt(r4)
            int r14 = h.t2.b.b(r14, r1)
            if (r14 >= 0) goto L4a
            return r3
        L4a:
            int r15 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r15 >= 0) goto L5a
            int r15 = (r12 > r5 ? 1 : (r12 == r5 ? 0 : -1))
            if (r15 != 0) goto L59
            long r12 = (long) r1
            long r12 = r7 / r12
            int r15 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r15 >= 0) goto L5a
        L59:
            return r3
        L5a:
            long r5 = (long) r1
            long r10 = r10 * r5
            long r5 = (long) r14
            long r16 = r7 + r5
            int r14 = (r10 > r16 ? 1 : (r10 == r16 ? 0 : -1))
            if (r14 >= 0) goto L65
            return r3
        L65:
            long r10 = r10 - r5
            int r4 = r4 + 1
            r5 = -256204778801521550(0xfc71c71c71c71c72, double:-2.772000429909333E291)
            goto L3d
        L6e:
            if (r9 == 0) goto L75
            java.lang.Long r0 = java.lang.Long.valueOf(r10)
            goto L7a
        L75:
            long r0 = -r10
            java.lang.Long r0 = java.lang.Long.valueOf(r0)
        L7a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: h.t2.t.a1(java.lang.String, int):java.lang.Long");
    }

    @k.e.a.e
    @s0(version = "1.1")
    public static final Short b1(@k.e.a.d String str) {
        return c1(str, 10);
    }

    @k.e.a.e
    @s0(version = "1.1")
    public static final Short c1(@k.e.a.d String str, int i2) {
        int intValue;
        Integer Y0 = Y0(str, i2);
        if (Y0 == null || (intValue = Y0.intValue()) < -32768 || intValue > 32767) {
            return null;
        }
        return Short.valueOf((short) intValue);
    }
}
