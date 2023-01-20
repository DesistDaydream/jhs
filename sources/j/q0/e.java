package j.q0;

import com.meizu.cloud.pushsdk.notification.model.NotifyType;
import h.a2.n;
import h.k2.u.q;
import h.t1;
import j.i0;
import j.j;
import j.m;
import kotlin.Metadata;
import okio.ByteString;
import okio.SegmentedByteString;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0010\u0015\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0004\u001a+\u0010\u0005\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u001b\u0010\t\u001a\u00020\u0001*\u00020\u00072\u0006\u0010\b\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\t\u0010\n\u001ad\u0010\u0014\u001a\u00020\u0012*\u00020\u00072K\u0010\u0013\u001aG\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00120\u000bH\u0080\bø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u001aq\u0010\u0018\u001a\u00020\u0012*\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u00012K\u0010\u0013\u001aG\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00120\u000bH\u0082\b¢\u0006\u0004\b\u0018\u0010\u0019\u001a$\u0010\u001b\u001a\u00020\u001a*\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0080\b¢\u0006\u0004\b\u001b\u0010\u001c\u001a\u001c\u0010\u001e\u001a\u00020\u001d*\u00020\u00072\u0006\u0010\b\u001a\u00020\u0001H\u0080\b¢\u0006\u0004\b\u001e\u0010\u001f\u001a\u0014\u0010 \u001a\u00020\u0001*\u00020\u0007H\u0080\b¢\u0006\u0004\b \u0010!\u001a\u0014\u0010\"\u001a\u00020\f*\u00020\u0007H\u0080\b¢\u0006\u0004\b\"\u0010#\u001a,\u0010&\u001a\u00020\u0012*\u00020\u00072\u0006\u0010%\u001a\u00020$2\u0006\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u0001H\u0080\b¢\u0006\u0004\b&\u0010'\u001a4\u0010+\u001a\u00020**\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00012\u0006\u0010(\u001a\u00020\u001a2\u0006\u0010)\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u0001H\u0080\b¢\u0006\u0004\b+\u0010,\u001a4\u0010-\u001a\u00020**\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00012\u0006\u0010(\u001a\u00020\f2\u0006\u0010)\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u0001H\u0080\b¢\u0006\u0004\b-\u0010.\u001a\u001e\u00100\u001a\u00020**\u00020\u00072\b\u0010(\u001a\u0004\u0018\u00010/H\u0080\b¢\u0006\u0004\b0\u00101\u001a\u0014\u00102\u001a\u00020\u0001*\u00020\u0007H\u0080\b¢\u0006\u0004\b2\u0010!\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u00063"}, d2 = {"", "", "value", "fromIndex", "toIndex", "b", "([IIII)I", "Lokio/SegmentedByteString;", "pos", "n", "(Lokio/SegmentedByteString;I)I", "Lkotlin/Function3;", "", "Lh/k0;", "name", "data", "offset", "byteCount", "Lh/t1;", "action", "m", "(Lokio/SegmentedByteString;Lh/k2/u/q;)V", "beginIndex", "endIndex", NotifyType.LIGHTS, "(Lokio/SegmentedByteString;IILh/k2/u/q;)V", "Lokio/ByteString;", "i", "(Lokio/SegmentedByteString;II)Lokio/ByteString;", "", "f", "(Lokio/SegmentedByteString;I)B", e.j.a.b.c.f.f10128d, "(Lokio/SegmentedByteString;)I", "j", "(Lokio/SegmentedByteString;)[B", "Lj/m;", "buffer", "k", "(Lokio/SegmentedByteString;Lj/m;II)V", "other", "otherOffset", "", "g", "(Lokio/SegmentedByteString;ILokio/ByteString;II)Z", "h", "(Lokio/SegmentedByteString;I[BII)Z", "", "c", "(Lokio/SegmentedByteString;Ljava/lang/Object;)Z", com.huawei.hms.push.e.a, "okio"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class e {
    public static final int b(@k.e.a.d int[] iArr, int i2, int i3, int i4) {
        int i5 = i4 - 1;
        while (i3 <= i5) {
            int i6 = (i3 + i5) >>> 1;
            int i7 = iArr[i6];
            if (i7 < i2) {
                i3 = i6 + 1;
            } else if (i7 <= i2) {
                return i6;
            } else {
                i5 = i6 - 1;
            }
        }
        return (-i3) - 1;
    }

    public static final boolean c(@k.e.a.d SegmentedByteString segmentedByteString, @k.e.a.e Object obj) {
        if (obj == segmentedByteString) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            if (byteString.size() == segmentedByteString.size() && segmentedByteString.rangeEquals(0, byteString, 0, segmentedByteString.size())) {
                return true;
            }
        }
        return false;
    }

    public static final int d(@k.e.a.d SegmentedByteString segmentedByteString) {
        return segmentedByteString.getDirectory$okio()[segmentedByteString.getSegments$okio().length - 1];
    }

    public static final int e(@k.e.a.d SegmentedByteString segmentedByteString) {
        int hashCode$okio = segmentedByteString.getHashCode$okio();
        if (hashCode$okio != 0) {
            return hashCode$okio;
        }
        int length = segmentedByteString.getSegments$okio().length;
        int i2 = 0;
        int i3 = 0;
        int i4 = 1;
        while (i2 < length) {
            int i5 = segmentedByteString.getDirectory$okio()[length + i2];
            int i6 = segmentedByteString.getDirectory$okio()[i2];
            byte[] bArr = segmentedByteString.getSegments$okio()[i2];
            int i7 = (i6 - i3) + i5;
            while (i5 < i7) {
                i4 = (i4 * 31) + bArr[i5];
                i5++;
            }
            i2++;
            i3 = i6;
        }
        segmentedByteString.setHashCode$okio(i4);
        return i4;
    }

    public static final byte f(@k.e.a.d SegmentedByteString segmentedByteString, int i2) {
        j.e(segmentedByteString.getDirectory$okio()[segmentedByteString.getSegments$okio().length - 1], i2, 1L);
        int n = n(segmentedByteString, i2);
        return segmentedByteString.getSegments$okio()[n][(i2 - (n == 0 ? 0 : segmentedByteString.getDirectory$okio()[n - 1])) + segmentedByteString.getDirectory$okio()[segmentedByteString.getSegments$okio().length + n]];
    }

    public static final boolean g(@k.e.a.d SegmentedByteString segmentedByteString, int i2, @k.e.a.d ByteString byteString, int i3, int i4) {
        if (i2 < 0 || i2 > segmentedByteString.size() - i4) {
            return false;
        }
        int i5 = i4 + i2;
        int n = n(segmentedByteString, i2);
        while (i2 < i5) {
            int i6 = n == 0 ? 0 : segmentedByteString.getDirectory$okio()[n - 1];
            int i7 = segmentedByteString.getDirectory$okio()[segmentedByteString.getSegments$okio().length + n];
            int min = Math.min(i5, (segmentedByteString.getDirectory$okio()[n] - i6) + i6) - i2;
            if (!byteString.rangeEquals(i3, segmentedByteString.getSegments$okio()[n], i7 + (i2 - i6), min)) {
                return false;
            }
            i3 += min;
            i2 += min;
            n++;
        }
        return true;
    }

    public static final boolean h(@k.e.a.d SegmentedByteString segmentedByteString, int i2, @k.e.a.d byte[] bArr, int i3, int i4) {
        if (i2 < 0 || i2 > segmentedByteString.size() - i4 || i3 < 0 || i3 > bArr.length - i4) {
            return false;
        }
        int i5 = i4 + i2;
        int n = n(segmentedByteString, i2);
        while (i2 < i5) {
            int i6 = n == 0 ? 0 : segmentedByteString.getDirectory$okio()[n - 1];
            int i7 = segmentedByteString.getDirectory$okio()[segmentedByteString.getSegments$okio().length + n];
            int min = Math.min(i5, (segmentedByteString.getDirectory$okio()[n] - i6) + i6) - i2;
            if (!j.d(segmentedByteString.getSegments$okio()[n], i7 + (i2 - i6), bArr, i3, min)) {
                return false;
            }
            i3 += min;
            i2 += min;
            n++;
        }
        return true;
    }

    @k.e.a.d
    public static final ByteString i(@k.e.a.d SegmentedByteString segmentedByteString, int i2, int i3) {
        if (i2 >= 0) {
            if (!(i3 <= segmentedByteString.size())) {
                throw new IllegalArgumentException(("endIndex=" + i3 + " > length(" + segmentedByteString.size() + ')').toString());
            }
            int i4 = i3 - i2;
            if (i4 >= 0) {
                if (i2 == 0 && i3 == segmentedByteString.size()) {
                    return segmentedByteString;
                }
                if (i2 == i3) {
                    return ByteString.EMPTY;
                }
                int n = n(segmentedByteString, i2);
                int n2 = n(segmentedByteString, i3 - 1);
                byte[][] bArr = (byte[][]) n.M1(segmentedByteString.getSegments$okio(), n, n2 + 1);
                int[] iArr = new int[bArr.length * 2];
                if (n <= n2) {
                    int i5 = n;
                    int i6 = 0;
                    while (true) {
                        iArr[i6] = Math.min(segmentedByteString.getDirectory$okio()[i5] - i2, i4);
                        int i7 = i6 + 1;
                        iArr[i6 + bArr.length] = segmentedByteString.getDirectory$okio()[segmentedByteString.getSegments$okio().length + i5];
                        if (i5 == n2) {
                            break;
                        }
                        i5++;
                        i6 = i7;
                    }
                }
                int i8 = n != 0 ? segmentedByteString.getDirectory$okio()[n - 1] : 0;
                int length = bArr.length;
                iArr[length] = iArr[length] + (i2 - i8);
                return new SegmentedByteString(bArr, iArr);
            }
            throw new IllegalArgumentException(("endIndex=" + i3 + " < beginIndex=" + i2).toString());
        }
        throw new IllegalArgumentException(("beginIndex=" + i2 + " < 0").toString());
    }

    @k.e.a.d
    public static final byte[] j(@k.e.a.d SegmentedByteString segmentedByteString) {
        byte[] bArr = new byte[segmentedByteString.size()];
        int length = segmentedByteString.getSegments$okio().length;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i2 < length) {
            int i5 = segmentedByteString.getDirectory$okio()[length + i2];
            int i6 = segmentedByteString.getDirectory$okio()[i2];
            int i7 = i6 - i3;
            n.W0(segmentedByteString.getSegments$okio()[i2], bArr, i4, i5, i5 + i7);
            i4 += i7;
            i2++;
            i3 = i6;
        }
        return bArr;
    }

    public static final void k(@k.e.a.d SegmentedByteString segmentedByteString, @k.e.a.d m mVar, int i2, int i3) {
        int i4 = i3 + i2;
        int n = n(segmentedByteString, i2);
        while (i2 < i4) {
            int i5 = n == 0 ? 0 : segmentedByteString.getDirectory$okio()[n - 1];
            int i6 = segmentedByteString.getDirectory$okio()[segmentedByteString.getSegments$okio().length + n];
            int min = Math.min(i4, (segmentedByteString.getDirectory$okio()[n] - i5) + i5) - i2;
            int i7 = i6 + (i2 - i5);
            i0 i0Var = new i0(segmentedByteString.getSegments$okio()[n], i7, i7 + min, true, false);
            i0 i0Var2 = mVar.a;
            if (i0Var2 == null) {
                i0Var.f15986g = i0Var;
                i0Var.f15985f = i0Var;
                mVar.a = i0Var;
            } else {
                i0Var2.f15986g.c(i0Var);
            }
            i2 += min;
            n++;
        }
        mVar.K0(mVar.O0() + segmentedByteString.size());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(SegmentedByteString segmentedByteString, int i2, int i3, q<? super byte[], ? super Integer, ? super Integer, t1> qVar) {
        int n = n(segmentedByteString, i2);
        while (i2 < i3) {
            int i4 = n == 0 ? 0 : segmentedByteString.getDirectory$okio()[n - 1];
            int i5 = segmentedByteString.getDirectory$okio()[segmentedByteString.getSegments$okio().length + n];
            int min = Math.min(i3, (segmentedByteString.getDirectory$okio()[n] - i4) + i4) - i2;
            qVar.invoke(segmentedByteString.getSegments$okio()[n], Integer.valueOf(i5 + (i2 - i4)), Integer.valueOf(min));
            i2 += min;
            n++;
        }
    }

    public static final void m(@k.e.a.d SegmentedByteString segmentedByteString, @k.e.a.d q<? super byte[], ? super Integer, ? super Integer, t1> qVar) {
        int length = segmentedByteString.getSegments$okio().length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            int i4 = segmentedByteString.getDirectory$okio()[length + i2];
            int i5 = segmentedByteString.getDirectory$okio()[i2];
            qVar.invoke(segmentedByteString.getSegments$okio()[i2], Integer.valueOf(i4), Integer.valueOf(i5 - i3));
            i2++;
            i3 = i5;
        }
    }

    public static final int n(@k.e.a.d SegmentedByteString segmentedByteString, int i2) {
        int b = b(segmentedByteString.getDirectory$okio(), i2 + 1, 0, segmentedByteString.getSegments$okio().length);
        return b >= 0 ? b : ~b;
    }
}
