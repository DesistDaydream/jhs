package j;

import com.meizu.cloud.pushsdk.notification.model.NotifyType;
import com.umeng.analytics.pro.am;
import com.umeng.analytics.pro.cb;
import kotlin.Metadata;

@h.k2.g(name = "-Util")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0005\n\u0002\b\f\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u001a'\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0013\u0010\b\u001a\u00020\u0007*\u00020\u0007H\u0000¢\u0006\u0004\b\b\u0010\t\u001a\u0013\u0010\u000b\u001a\u00020\n*\u00020\nH\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a\u0013\u0010\r\u001a\u00020\u0000*\u00020\u0000H\u0000¢\u0006\u0004\b\r\u0010\u000e\u001a\u001c\u0010\u0011\u001a\u00020\n*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\nH\u0080\f¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u001c\u0010\u0013\u001a\u00020\n*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\nH\u0080\f¢\u0006\u0004\b\u0013\u0010\u0012\u001a\u001c\u0010\u0014\u001a\u00020\n*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\nH\u0080\f¢\u0006\u0004\b\u0014\u0010\u0012\u001a\u001c\u0010\u0015\u001a\u00020\u0000*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0000H\u0080\f¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u001c\u0010\u0017\u001a\u00020\u0000*\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0000H\u0080\f¢\u0006\u0004\b\u0017\u0010\u0018\u001a \u0010\u0019\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\nH\u0080\b¢\u0006\u0004\b\u0019\u0010\u001a\u001a \u0010\u001b\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0000H\u0080\b¢\u0006\u0004\b\u001b\u0010\u0018\u001a7\u0010 \u001a\u00020\u001f2\u0006\u0010\u0014\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\nH\u0000¢\u0006\u0004\b \u0010!\u001a\u0013\u0010#\u001a\u00020\"*\u00020\u000fH\u0000¢\u0006\u0004\b#\u0010$\u001a\u0013\u0010%\u001a\u00020\"*\u00020\nH\u0000¢\u0006\u0004\b%\u0010&\u001a\u0013\u0010'\u001a\u00020\"*\u00020\u0000H\u0000¢\u0006\u0004\b'\u0010(¨\u0006)"}, d2 = {"", "size", "offset", "byteCount", "Lh/t1;", com.huawei.hms.push.e.a, "(JJJ)V", "", "j", "(S)S", "", "h", "(I)I", "i", "(J)J", "", "other", NotifyType.LIGHTS, "(BI)I", "k", am.av, "b", "(BJ)J", "c", "(IJ)J", "g", "(JI)J", "f", "", "aOffset", "bOffset", "", e.j.a.b.c.f.f10128d, "([BI[BII)Z", "", "m", "(B)Ljava/lang/String;", "n", "(I)Ljava/lang/String;", "o", "(J)Ljava/lang/String;", "okio"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class j {
    public static final int a(byte b, int i2) {
        return b & i2;
    }

    public static final long b(byte b, long j2) {
        return b & j2;
    }

    public static final long c(int i2, long j2) {
        return i2 & j2;
    }

    public static final boolean d(@k.e.a.d byte[] bArr, int i2, @k.e.a.d byte[] bArr2, int i3, int i4) {
        for (int i5 = 0; i5 < i4; i5++) {
            if (bArr[i5 + i2] != bArr2[i5 + i3]) {
                return false;
            }
        }
        return true;
    }

    public static final void e(long j2, long j3, long j4) {
        if ((j3 | j4) < 0 || j3 > j2 || j2 - j3 < j4) {
            throw new ArrayIndexOutOfBoundsException("size=" + j2 + " offset=" + j3 + " byteCount=" + j4);
        }
    }

    public static final long f(int i2, long j2) {
        return Math.min(i2, j2);
    }

    public static final long g(long j2, int i2) {
        return Math.min(j2, i2);
    }

    public static final int h(int i2) {
        return ((i2 & 255) << 24) | (((-16777216) & i2) >>> 24) | ((16711680 & i2) >>> 8) | ((65280 & i2) << 8);
    }

    public static final long i(long j2) {
        return ((j2 & 255) << 56) | (((-72057594037927936L) & j2) >>> 56) | ((71776119061217280L & j2) >>> 40) | ((280375465082880L & j2) >>> 24) | ((1095216660480L & j2) >>> 8) | ((4278190080L & j2) << 8) | ((16711680 & j2) << 24) | ((65280 & j2) << 40);
    }

    public static final short j(short s) {
        int i2 = s & 65535;
        return (short) (((i2 & 255) << 8) | ((65280 & i2) >>> 8));
    }

    public static final int k(byte b, int i2) {
        return b << i2;
    }

    public static final int l(byte b, int i2) {
        return b >> i2;
    }

    @k.e.a.d
    public static final String m(byte b) {
        return new String(new char[]{j.q0.b.I()[(b >> 4) & 15], j.q0.b.I()[b & cb.f7124m]});
    }

    @k.e.a.d
    public static final String n(int i2) {
        if (i2 == 0) {
            return "0";
        }
        int i3 = 0;
        char[] cArr = {j.q0.b.I()[(i2 >> 28) & 15], j.q0.b.I()[(i2 >> 24) & 15], j.q0.b.I()[(i2 >> 20) & 15], j.q0.b.I()[(i2 >> 16) & 15], j.q0.b.I()[(i2 >> 12) & 15], j.q0.b.I()[(i2 >> 8) & 15], j.q0.b.I()[(i2 >> 4) & 15], j.q0.b.I()[i2 & 15]};
        while (i3 < 8 && cArr[i3] == '0') {
            i3++;
        }
        return new String(cArr, i3, 8 - i3);
    }

    @k.e.a.d
    public static final String o(long j2) {
        if (j2 == 0) {
            return "0";
        }
        int i2 = 0;
        char[] cArr = {j.q0.b.I()[(int) ((j2 >> 60) & 15)], j.q0.b.I()[(int) ((j2 >> 56) & 15)], j.q0.b.I()[(int) ((j2 >> 52) & 15)], j.q0.b.I()[(int) ((j2 >> 48) & 15)], j.q0.b.I()[(int) ((j2 >> 44) & 15)], j.q0.b.I()[(int) ((j2 >> 40) & 15)], j.q0.b.I()[(int) ((j2 >> 36) & 15)], j.q0.b.I()[(int) ((j2 >> 32) & 15)], j.q0.b.I()[(int) ((j2 >> 28) & 15)], j.q0.b.I()[(int) ((j2 >> 24) & 15)], j.q0.b.I()[(int) ((j2 >> 20) & 15)], j.q0.b.I()[(int) ((j2 >> 16) & 15)], j.q0.b.I()[(int) ((j2 >> 12) & 15)], j.q0.b.I()[(int) ((j2 >> 8) & 15)], j.q0.b.I()[(int) ((j2 >> 4) & 15)], j.q0.b.I()[(int) (j2 & 15)]};
        while (i2 < 16 && cArr[i2] == '0') {
            i2++;
        }
        return new String(cArr, i2, 16 - i2);
    }
}
