package okhttp3.internal;

import com.xiaomi.mipush.sdk.Constants;
import h.k2.v.f0;
import h.t2.u;
import j.m;
import java.net.IDN;
import java.net.InetAddress;
import java.util.Locale;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.text.StringsKt__StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0007\u001a\u0013\u0010\u0001\u001a\u0004\u0018\u00010\u0000*\u00020\u0000¢\u0006\u0004\b\u0001\u0010\u0002\u001a\u0013\u0010\u0004\u001a\u00020\u0003*\u00020\u0000H\u0002¢\u0006\u0004\b\u0004\u0010\u0005\u001a)\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0006\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000b\u0010\f\u001a7\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u0017\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"", "toCanonicalHost", "(Ljava/lang/String;)Ljava/lang/String;", "", "containsInvalidHostnameAsciiCodes", "(Ljava/lang/String;)Z", "input", "", "pos", "limit", "Ljava/net/InetAddress;", "decodeIpv6", "(Ljava/lang/String;II)Ljava/net/InetAddress;", "", "address", "addressOffset", "decodeIpv4Suffix", "(Ljava/lang/String;II[BI)Z", "inet6AddressToAscii", "([B)Ljava/lang/String;", "okhttp"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class HostnamesKt {
    private static final boolean containsInvalidHostnameAsciiCodes(String str) {
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            if (f0.t(charAt, 31) <= 0 || f0.t(charAt, 127) >= 0 || StringsKt__StringsKt.q3(" #%/:?@[\\]", charAt, 0, false, 6, null) != -1) {
                return true;
            }
        }
        return false;
    }

    private static final boolean decodeIpv4Suffix(String str, int i2, int i3, byte[] bArr, int i4) {
        int i5 = i4;
        while (i2 < i3) {
            if (i5 == bArr.length) {
                return false;
            }
            if (i5 != i4) {
                if (str.charAt(i2) != '.') {
                    return false;
                }
                i2++;
            }
            int i6 = i2;
            int i7 = 0;
            while (i6 < i3) {
                char charAt = str.charAt(i6);
                if (f0.t(charAt, 48) < 0 || f0.t(charAt, 57) > 0) {
                    break;
                } else if ((i7 == 0 && i2 != i6) || (i7 = ((i7 * 10) + charAt) - 48) > 255) {
                    return false;
                } else {
                    i6++;
                }
            }
            if (i6 - i2 == 0) {
                return false;
            }
            bArr[i5] = (byte) i7;
            i5++;
            i2 = i6;
        }
        return i5 == i4 + 4;
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x0099, code lost:
        if (r14 != (-1)) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x009b, code lost:
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x009c, code lost:
        r0 = r13 - r14;
        java.lang.System.arraycopy(r9, r14, r9, 16 - r0, r0);
        java.util.Arrays.fill(r9, r14, (16 - r13) + r14, (byte) 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x00ae, code lost:
        return java.net.InetAddress.getByAddress(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x0097, code lost:
        if (r13 == 16) goto L35;
     */
    /* JADX WARN: Removed duplicated region for block: B:88:0x006b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final java.net.InetAddress decodeIpv6(java.lang.String r18, int r19, int r20) {
        /*
            Method dump skipped, instructions count: 175
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.HostnamesKt.decodeIpv6(java.lang.String, int, int):java.net.InetAddress");
    }

    private static final String inet6AddressToAscii(byte[] bArr) {
        int i2 = 0;
        int i3 = -1;
        int i4 = 0;
        int i5 = 0;
        while (i4 < bArr.length) {
            int i6 = i4;
            while (i6 < 16 && bArr[i6] == 0 && bArr[i6 + 1] == 0) {
                i6 += 2;
            }
            int i7 = i6 - i4;
            if (i7 > i5 && i7 >= 4) {
                i3 = i4;
                i5 = i7;
            }
            i4 = i6 + 2;
        }
        m mVar = new m();
        while (i2 < bArr.length) {
            if (i2 == i3) {
                mVar.writeByte(58);
                i2 += i5;
                if (i2 == 16) {
                    mVar.writeByte(58);
                }
            } else {
                if (i2 > 0) {
                    mVar.writeByte(58);
                }
                mVar.i0((Util.and(bArr[i2], 255) << 8) | Util.and(bArr[i2 + 1], 255));
                i2 += 2;
            }
        }
        return mVar.p0();
    }

    @e
    public static final String toCanonicalHost(@d String str) {
        InetAddress decodeIpv6;
        if (StringsKt__StringsKt.V2(str, Constants.COLON_SEPARATOR, false, 2, null)) {
            if (u.u2(str, "[", false, 2, null) && u.J1(str, "]", false, 2, null)) {
                decodeIpv6 = decodeIpv6(str, 1, str.length() - 1);
            } else {
                decodeIpv6 = decodeIpv6(str, 0, str.length());
            }
            if (decodeIpv6 != null) {
                byte[] address = decodeIpv6.getAddress();
                if (address.length == 16) {
                    return inet6AddressToAscii(address);
                }
                if (address.length == 4) {
                    return decodeIpv6.getHostAddress();
                }
                throw new AssertionError("Invalid IPv6 address: '" + str + '\'');
            }
            return null;
        }
        try {
            String ascii = IDN.toASCII(str);
            Locale locale = Locale.US;
            if (ascii != null) {
                String lowerCase = ascii.toLowerCase(locale);
                if (!(lowerCase.length() == 0) && !containsInvalidHostnameAsciiCodes(lowerCase)) {
                    return lowerCase;
                }
                return null;
            }
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }
}
