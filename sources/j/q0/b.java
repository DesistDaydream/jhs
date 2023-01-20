package j.q0;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.meizu.cloud.pushsdk.notification.model.NotifyType;
import com.umeng.analytics.pro.am;
import com.umeng.analytics.pro.cb;
import h.a2.n;
import h.t2.u;
import j.i;
import j.j;
import j.m;
import java.util.Arrays;
import java.util.Objects;
import kotlin.Metadata;
import okio.ByteString;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0005\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\u0000\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0006\n\u0002\u0010\u0019\n\u0002\b\u0006\u001a\u0014\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0080\b¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0014\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\u0080\b¢\u0006\u0004\b\u0004\u0010\u0003\u001a\u0014\u0010\u0005\u001a\u00020\u0001*\u00020\u0000H\u0080\b¢\u0006\u0004\b\u0005\u0010\u0003\u001a\u0014\u0010\u0006\u001a\u00020\u0001*\u00020\u0000H\u0080\b¢\u0006\u0004\b\u0006\u0010\u0003\u001a\u0014\u0010\u0007\u001a\u00020\u0000*\u00020\u0000H\u0080\b¢\u0006\u0004\b\u0007\u0010\b\u001a\u0014\u0010\t\u001a\u00020\u0000*\u00020\u0000H\u0080\b¢\u0006\u0004\b\t\u0010\b\u001a$\u0010\r\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0080\b¢\u0006\u0004\b\r\u0010\u000e\u001a\u001c\u0010\u0011\u001a\u00020\u0010*\u00020\u00002\u0006\u0010\u000f\u001a\u00020\nH\u0080\b¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u0014\u0010\u0013\u001a\u00020\n*\u00020\u0000H\u0080\b¢\u0006\u0004\b\u0013\u0010\u0014\u001a\u0014\u0010\u0016\u001a\u00020\u0015*\u00020\u0000H\u0080\b¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u0014\u0010\u0018\u001a\u00020\u0015*\u00020\u0000H\u0080\b¢\u0006\u0004\b\u0018\u0010\u0017\u001a4\u0010\u001e\u001a\u00020\u001d*\u00020\u00002\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\nH\u0080\b¢\u0006\u0004\b\u001e\u0010\u001f\u001a4\u0010 \u001a\u00020\u001d*\u00020\u00002\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\nH\u0080\b¢\u0006\u0004\b \u0010!\u001a\u001c\u0010#\u001a\u00020\u001d*\u00020\u00002\u0006\u0010\"\u001a\u00020\u0000H\u0080\b¢\u0006\u0004\b#\u0010$\u001a\u001c\u0010%\u001a\u00020\u001d*\u00020\u00002\u0006\u0010\"\u001a\u00020\u0015H\u0080\b¢\u0006\u0004\b%\u0010&\u001a\u001c\u0010(\u001a\u00020\u001d*\u00020\u00002\u0006\u0010'\u001a\u00020\u0000H\u0080\b¢\u0006\u0004\b(\u0010$\u001a\u001c\u0010)\u001a\u00020\u001d*\u00020\u00002\u0006\u0010'\u001a\u00020\u0015H\u0080\b¢\u0006\u0004\b)\u0010&\u001a$\u0010+\u001a\u00020\n*\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u00152\u0006\u0010*\u001a\u00020\nH\u0080\b¢\u0006\u0004\b+\u0010,\u001a$\u0010-\u001a\u00020\n*\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u00002\u0006\u0010*\u001a\u00020\nH\u0080\b¢\u0006\u0004\b-\u0010.\u001a$\u0010/\u001a\u00020\n*\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u00152\u0006\u0010*\u001a\u00020\nH\u0080\b¢\u0006\u0004\b/\u0010,\u001a\u001e\u00101\u001a\u00020\u001d*\u00020\u00002\b\u0010\u001a\u001a\u0004\u0018\u000100H\u0080\b¢\u0006\u0004\b1\u00102\u001a\u0014\u00103\u001a\u00020\n*\u00020\u0000H\u0080\b¢\u0006\u0004\b3\u0010\u0014\u001a\u001c\u00104\u001a\u00020\n*\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u0000H\u0080\b¢\u0006\u0004\b4\u00105\u001a\u0018\u00107\u001a\u00020\u00002\u0006\u00106\u001a\u00020\u0015H\u0080\b¢\u0006\u0004\b7\u00108\u001a$\u00109\u001a\u00020\u0000*\u00020\u00152\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\nH\u0080\b¢\u0006\u0004\b9\u0010:\u001a\u0014\u0010;\u001a\u00020\u0000*\u00020\u0001H\u0080\b¢\u0006\u0004\b;\u0010<\u001a\u0016\u0010=\u001a\u0004\u0018\u00010\u0000*\u00020\u0001H\u0080\b¢\u0006\u0004\b=\u0010<\u001a\u0014\u0010>\u001a\u00020\u0000*\u00020\u0001H\u0080\b¢\u0006\u0004\b>\u0010<\u001a+\u0010B\u001a\u00020A*\u00020\u00002\u0006\u0010@\u001a\u00020?2\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\nH\u0000¢\u0006\u0004\bB\u0010C\u001a\u0017\u0010F\u001a\u00020\n2\u0006\u0010E\u001a\u00020DH\u0002¢\u0006\u0004\bF\u0010G\u001a\u0014\u0010H\u001a\u00020\u0001*\u00020\u0000H\u0080\b¢\u0006\u0004\bH\u0010\u0003\u001a\u001f\u0010E\u001a\u00020\n2\u0006\u0010-\u001a\u00020\u00152\u0006\u0010I\u001a\u00020\nH\u0002¢\u0006\u0004\bE\u0010J\"\u001c\u0010P\u001a\u00020K8\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\bL\u0010M\u001a\u0004\bN\u0010O¨\u0006Q"}, d2 = {"Lokio/ByteString;", "", "F", "(Lokio/ByteString;)Ljava/lang/String;", e.j.a.b.c.f.f10128d, com.huawei.hms.push.e.a, am.ax, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Lokio/ByteString;)Lokio/ByteString;", "B", "", "beginIndex", "endIndex", am.aD, "(Lokio/ByteString;II)Lokio/ByteString;", "pos", "", "m", "(Lokio/ByteString;I)B", "n", "(Lokio/ByteString;)I", "", "C", "(Lokio/ByteString;)[B", "r", "offset", "other", "otherOffset", "byteCount", "", "v", "(Lokio/ByteString;ILokio/ByteString;II)Z", IAdInterListener.AdReqParam.WIDTH, "(Lokio/ByteString;I[BII)Z", "prefix", "x", "(Lokio/ByteString;Lokio/ByteString;)Z", "y", "(Lokio/ByteString;[B)Z", "suffix", "j", "k", "fromIndex", "q", "(Lokio/ByteString;[BI)I", "s", "(Lokio/ByteString;Lokio/ByteString;I)I", am.aI, "", NotifyType.LIGHTS, "(Lokio/ByteString;Ljava/lang/Object;)Z", "o", "f", "(Lokio/ByteString;Lokio/ByteString;)I", "data", am.aH, "([B)Lokio/ByteString;", "D", "([BII)Lokio/ByteString;", "i", "(Ljava/lang/String;)Lokio/ByteString;", "g", "h", "Lj/m;", "buffer", "Lh/t1;", "G", "(Lokio/ByteString;Lj/m;II)V", "", "c", "H", "(C)I", ExifInterface.LONGITUDE_EAST, "codePointCount", "([BI)I", "", am.av, "[C", ExpandableTextView.P, "()[C", "HEX_DIGIT_CHARS", "okio"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class b {
    @k.e.a.d
    private static final char[] a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    @k.e.a.d
    public static final ByteString A(@k.e.a.d ByteString byteString) {
        byte b;
        for (int i2 = 0; i2 < byteString.getData$okio().length; i2++) {
            byte b2 = byteString.getData$okio()[i2];
            byte b3 = (byte) 65;
            if (b2 >= b3 && b2 <= (b = (byte) 90)) {
                byte[] data$okio = byteString.getData$okio();
                byte[] copyOf = Arrays.copyOf(data$okio, data$okio.length);
                copyOf[i2] = (byte) (b2 + 32);
                for (int i3 = i2 + 1; i3 < copyOf.length; i3++) {
                    byte b4 = copyOf[i3];
                    if (b4 >= b3 && b4 <= b) {
                        copyOf[i3] = (byte) (b4 + 32);
                    }
                }
                return new ByteString(copyOf);
            }
        }
        return byteString;
    }

    @k.e.a.d
    public static final ByteString B(@k.e.a.d ByteString byteString) {
        byte b;
        for (int i2 = 0; i2 < byteString.getData$okio().length; i2++) {
            byte b2 = byteString.getData$okio()[i2];
            byte b3 = (byte) 97;
            if (b2 >= b3 && b2 <= (b = (byte) 122)) {
                byte[] data$okio = byteString.getData$okio();
                byte[] copyOf = Arrays.copyOf(data$okio, data$okio.length);
                copyOf[i2] = (byte) (b2 - 32);
                for (int i3 = i2 + 1; i3 < copyOf.length; i3++) {
                    byte b4 = copyOf[i3];
                    if (b4 >= b3 && b4 <= b) {
                        copyOf[i3] = (byte) (b4 - 32);
                    }
                }
                return new ByteString(copyOf);
            }
        }
        return byteString;
    }

    @k.e.a.d
    public static final byte[] C(@k.e.a.d ByteString byteString) {
        byte[] data$okio = byteString.getData$okio();
        return Arrays.copyOf(data$okio, data$okio.length);
    }

    @k.e.a.d
    public static final ByteString D(@k.e.a.d byte[] bArr, int i2, int i3) {
        j.e(bArr.length, i2, i3);
        return new ByteString(n.G1(bArr, i2, i3 + i2));
    }

    @k.e.a.d
    public static final String E(@k.e.a.d ByteString byteString) {
        if (byteString.getData$okio().length == 0) {
            return "[size=0]";
        }
        int c2 = c(byteString.getData$okio(), 64);
        if (c2 == -1) {
            if (byteString.getData$okio().length <= 64) {
                return "[hex=" + byteString.hex() + ']';
            }
            StringBuilder sb = new StringBuilder();
            sb.append("[size=");
            sb.append(byteString.getData$okio().length);
            sb.append(" hex=");
            if (64 <= byteString.getData$okio().length) {
                sb.append((64 == byteString.getData$okio().length ? byteString : new ByteString(n.G1(byteString.getData$okio(), 0, 64))).hex());
                sb.append("…]");
                return sb.toString();
            }
            throw new IllegalArgumentException(("endIndex > length(" + byteString.getData$okio().length + ')').toString());
        }
        String utf8 = byteString.utf8();
        Objects.requireNonNull(utf8, "null cannot be cast to non-null type java.lang.String");
        String k2 = u.k2(u.k2(u.k2(utf8.substring(0, c2), "\\", "\\\\", false, 4, null), "\n", "\\n", false, 4, null), "\r", "\\r", false, 4, null);
        if (c2 < utf8.length()) {
            return "[size=" + byteString.getData$okio().length + " text=" + k2 + "…]";
        }
        return "[text=" + k2 + ']';
    }

    @k.e.a.d
    public static final String F(@k.e.a.d ByteString byteString) {
        String utf8$okio = byteString.getUtf8$okio();
        if (utf8$okio == null) {
            String c2 = i.c(byteString.internalArray$okio());
            byteString.setUtf8$okio(c2);
            return c2;
        }
        return utf8$okio;
    }

    public static final void G(@k.e.a.d ByteString byteString, @k.e.a.d m mVar, int i2, int i3) {
        mVar.write(byteString.getData$okio(), i2, i3);
    }

    public static final int H(char c2) {
        if ('0' <= c2 && '9' >= c2) {
            return c2 - '0';
        }
        char c3 = 'a';
        if ('a' > c2 || 'f' < c2) {
            c3 = 'A';
            if ('A' > c2 || 'F' < c2) {
                throw new IllegalArgumentException("Unexpected hex digit: " + c2);
            }
        }
        return (c2 - c3) + 10;
    }

    @k.e.a.d
    public static final char[] I() {
        return a;
    }

    public static final /* synthetic */ int a(byte[] bArr, int i2) {
        return c(bArr, i2);
    }

    public static final /* synthetic */ int b(char c2) {
        return H(c2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:304:0x0068, code lost:
        return -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final int c(byte[] r19, int r20) {
        /*
            Method dump skipped, instructions count: 478
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: j.q0.b.c(byte[], int):int");
    }

    @k.e.a.d
    public static final String d(@k.e.a.d ByteString byteString) {
        return j.a.c(byteString.getData$okio(), null, 1, null);
    }

    @k.e.a.d
    public static final String e(@k.e.a.d ByteString byteString) {
        return j.a.b(byteString.getData$okio(), j.a.e());
    }

    public static final int f(@k.e.a.d ByteString byteString, @k.e.a.d ByteString byteString2) {
        int size = byteString.size();
        int size2 = byteString2.size();
        int min = Math.min(size, size2);
        for (int i2 = 0; i2 < min; i2++) {
            int i3 = byteString.getByte(i2) & 255;
            int i4 = byteString2.getByte(i2) & 255;
            if (i3 != i4) {
                return i3 < i4 ? -1 : 1;
            }
        }
        if (size == size2) {
            return 0;
        }
        return size < size2 ? -1 : 1;
    }

    @k.e.a.e
    public static final ByteString g(@k.e.a.d String str) {
        byte[] a2 = j.a.a(str);
        if (a2 != null) {
            return new ByteString(a2);
        }
        return null;
    }

    @k.e.a.d
    public static final ByteString h(@k.e.a.d String str) {
        if (str.length() % 2 == 0) {
            int length = str.length() / 2;
            byte[] bArr = new byte[length];
            for (int i2 = 0; i2 < length; i2++) {
                int i3 = i2 * 2;
                bArr[i2] = (byte) ((H(str.charAt(i3)) << 4) + H(str.charAt(i3 + 1)));
            }
            return new ByteString(bArr);
        }
        throw new IllegalArgumentException(("Unexpected hex string: " + str).toString());
    }

    @k.e.a.d
    public static final ByteString i(@k.e.a.d String str) {
        ByteString byteString = new ByteString(i.a(str));
        byteString.setUtf8$okio(str);
        return byteString;
    }

    public static final boolean j(@k.e.a.d ByteString byteString, @k.e.a.d ByteString byteString2) {
        return byteString.rangeEquals(byteString.size() - byteString2.size(), byteString2, 0, byteString2.size());
    }

    public static final boolean k(@k.e.a.d ByteString byteString, @k.e.a.d byte[] bArr) {
        return byteString.rangeEquals(byteString.size() - bArr.length, bArr, 0, bArr.length);
    }

    public static final boolean l(@k.e.a.d ByteString byteString, @k.e.a.e Object obj) {
        if (obj == byteString) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString2 = (ByteString) obj;
            if (byteString2.size() == byteString.getData$okio().length && byteString2.rangeEquals(0, byteString.getData$okio(), 0, byteString.getData$okio().length)) {
                return true;
            }
        }
        return false;
    }

    public static final byte m(@k.e.a.d ByteString byteString, int i2) {
        return byteString.getData$okio()[i2];
    }

    public static final int n(@k.e.a.d ByteString byteString) {
        return byteString.getData$okio().length;
    }

    public static final int o(@k.e.a.d ByteString byteString) {
        int hashCode$okio = byteString.getHashCode$okio();
        if (hashCode$okio != 0) {
            return hashCode$okio;
        }
        int hashCode = Arrays.hashCode(byteString.getData$okio());
        byteString.setHashCode$okio(hashCode);
        return hashCode;
    }

    @k.e.a.d
    public static final String p(@k.e.a.d ByteString byteString) {
        byte[] data$okio;
        char[] cArr = new char[byteString.getData$okio().length * 2];
        int i2 = 0;
        for (byte b : byteString.getData$okio()) {
            int i3 = i2 + 1;
            cArr[i2] = I()[(b >> 4) & 15];
            i2 = i3 + 1;
            cArr[i3] = I()[b & cb.f7124m];
        }
        return new String(cArr);
    }

    public static final int q(@k.e.a.d ByteString byteString, @k.e.a.d byte[] bArr, int i2) {
        int length = byteString.getData$okio().length - bArr.length;
        int max = Math.max(i2, 0);
        if (max <= length) {
            while (!j.d(byteString.getData$okio(), max, bArr, 0, bArr.length)) {
                if (max == length) {
                    return -1;
                }
                max++;
            }
            return max;
        }
        return -1;
    }

    @k.e.a.d
    public static final byte[] r(@k.e.a.d ByteString byteString) {
        return byteString.getData$okio();
    }

    public static final int s(@k.e.a.d ByteString byteString, @k.e.a.d ByteString byteString2, int i2) {
        return byteString.lastIndexOf(byteString2.internalArray$okio(), i2);
    }

    public static final int t(@k.e.a.d ByteString byteString, @k.e.a.d byte[] bArr, int i2) {
        for (int min = Math.min(i2, byteString.getData$okio().length - bArr.length); min >= 0; min--) {
            if (j.d(byteString.getData$okio(), min, bArr, 0, bArr.length)) {
                return min;
            }
        }
        return -1;
    }

    @k.e.a.d
    public static final ByteString u(@k.e.a.d byte[] bArr) {
        return new ByteString(Arrays.copyOf(bArr, bArr.length));
    }

    public static final boolean v(@k.e.a.d ByteString byteString, int i2, @k.e.a.d ByteString byteString2, int i3, int i4) {
        return byteString2.rangeEquals(i3, byteString.getData$okio(), i2, i4);
    }

    public static final boolean w(@k.e.a.d ByteString byteString, int i2, @k.e.a.d byte[] bArr, int i3, int i4) {
        return i2 >= 0 && i2 <= byteString.getData$okio().length - i4 && i3 >= 0 && i3 <= bArr.length - i4 && j.d(byteString.getData$okio(), i2, bArr, i3, i4);
    }

    public static final boolean x(@k.e.a.d ByteString byteString, @k.e.a.d ByteString byteString2) {
        return byteString.rangeEquals(0, byteString2, 0, byteString2.size());
    }

    public static final boolean y(@k.e.a.d ByteString byteString, @k.e.a.d byte[] bArr) {
        return byteString.rangeEquals(0, bArr, 0, bArr.length);
    }

    @k.e.a.d
    public static final ByteString z(@k.e.a.d ByteString byteString, int i2, int i3) {
        if (i2 >= 0) {
            if (i3 <= byteString.getData$okio().length) {
                if (i3 - i2 >= 0) {
                    return (i2 == 0 && i3 == byteString.getData$okio().length) ? byteString : new ByteString(n.G1(byteString.getData$okio(), i2, i3));
                }
                throw new IllegalArgumentException("endIndex < beginIndex".toString());
            }
            throw new IllegalArgumentException(("endIndex > length(" + byteString.getData$okio().length + ')').toString());
        }
        throw new IllegalArgumentException("beginIndex < 0".toString());
    }
}
