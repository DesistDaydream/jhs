package j.q0;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.meizu.cloud.pushsdk.notification.model.NotifyType;
import com.moor.imkf.YKFConstants;
import com.tencent.android.tpush.common.MessageKey;
import com.umeng.analytics.pro.am;
import com.umeng.analytics.pro.cb;
import h.k2.u.p;
import h.k2.v.n;
import h.t2.y;
import j.c0;
import j.i;
import j.i0;
import j.j;
import j.j0;
import j.k0;
import j.m;
import j.m0;
import j.p0;
import java.io.EOFException;
import kotlin.Metadata;
import okhttp3.internal.connection.RealConnection;
import okio.ByteString;
import okio.SegmentedByteString;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u0000\n\u0002\b\u0011\u001a7\u0010\t\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\t\u0010\n\u001a\u001b\u0010\u000f\u001a\u00020\u000e*\u00020\u000b2\u0006\u0010\r\u001a\u00020\fH\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001aA\u0010\u0015\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0011*\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\f2\u001a\u0010\u0014\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0000\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00028\u00000\u0013H\u0080\bø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a%\u0010\u001a\u001a\u00020\u0002*\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u00172\b\b\u0002\u0010\u0019\u001a\u00020\bH\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u001a,\u0010\u001f\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\fH\u0080\b¢\u0006\u0004\b\u001f\u0010 \u001a\u0014\u0010!\u001a\u00020\f*\u00020\u000bH\u0080\b¢\u0006\u0004\b!\u0010\"\u001a\u0014\u0010$\u001a\u00020#*\u00020\u000bH\u0080\b¢\u0006\u0004\b$\u0010%\u001a\u0014\u0010'\u001a\u00020&*\u00020\u000bH\u0080\b¢\u0006\u0004\b'\u0010(\u001a\u0014\u0010)\u001a\u00020\u0002*\u00020\u000bH\u0080\b¢\u0006\u0004\b)\u0010*\u001a\u0014\u0010+\u001a\u00020\f*\u00020\u000bH\u0080\b¢\u0006\u0004\b+\u0010\"\u001a\u001c\u0010-\u001a\u00020#*\u00020\u000b2\u0006\u0010,\u001a\u00020\fH\u0080\b¢\u0006\u0004\b-\u0010.\u001a\u0014\u00100\u001a\u00020/*\u00020\u000bH\u0080\b¢\u0006\u0004\b0\u00101\u001a\u001c\u00102\u001a\u00020/*\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\fH\u0080\b¢\u0006\u0004\b2\u00103\u001a0\u00106\u001a\u00020\u000b*\u00020\u000b2\u0006\u00105\u001a\u0002042\b\b\u0002\u0010\u001d\u001a\u00020\u00022\b\b\u0002\u0010\u001e\u001a\u00020\u0002H\u0080\b¢\u0006\u0004\b6\u00107\u001a\u001c\u00109\u001a\u00020\u000b*\u00020\u000b2\u0006\u00108\u001a\u00020\fH\u0080\b¢\u0006\u0004\b9\u0010:\u001a\u001c\u0010\u0011\u001a\u00020\u000b*\u00020\u000b2\u0006\u00108\u001a\u00020\fH\u0080\b¢\u0006\u0004\b\u0011\u0010:\u001a\u001c\u0010<\u001a\u00020\u0000*\u00020\u000b2\u0006\u0010;\u001a\u00020\u0002H\u0080\b¢\u0006\u0004\b<\u0010=\u001a\u001c\u0010?\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010>\u001a\u00020\u0004H\u0080\b¢\u0006\u0004\b?\u0010@\u001a,\u0010A\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010>\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u0002H\u0080\b¢\u0006\u0004\bA\u0010B\u001a\u0014\u0010C\u001a\u00020\u0004*\u00020\u000bH\u0080\b¢\u0006\u0004\bC\u0010D\u001a\u001c\u0010E\u001a\u00020\u0004*\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\fH\u0080\b¢\u0006\u0004\bE\u0010F\u001a\u001c\u0010H\u001a\u00020\u0002*\u00020\u000b2\u0006\u0010G\u001a\u00020\u0004H\u0080\b¢\u0006\u0004\bH\u0010I\u001a\u001c\u0010J\u001a\u00020/*\u00020\u000b2\u0006\u0010G\u001a\u00020\u0004H\u0080\b¢\u0006\u0004\bJ\u0010K\u001a,\u0010L\u001a\u00020\u0002*\u00020\u000b2\u0006\u0010G\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u0002H\u0080\b¢\u0006\u0004\bL\u0010M\u001a\u0014\u0010N\u001a\u00020\f*\u00020\u000bH\u0080\b¢\u0006\u0004\bN\u0010\"\u001a\u0014\u0010O\u001a\u00020\f*\u00020\u000bH\u0080\b¢\u0006\u0004\bO\u0010\"\u001a\u0014\u0010P\u001a\u000204*\u00020\u000bH\u0080\b¢\u0006\u0004\bP\u0010Q\u001a\u001c\u0010R\u001a\u000204*\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\fH\u0080\b¢\u0006\u0004\bR\u0010S\u001a\u001c\u0010T\u001a\u00020\u0002*\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u0017H\u0080\b¢\u0006\u0004\bT\u0010U\u001a$\u00108\u001a\u00020/*\u00020\u000b2\u0006\u0010G\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\fH\u0080\b¢\u0006\u0004\b8\u0010V\u001a\u001c\u0010X\u001a\u00020\f*\u00020\u000b2\u0006\u0010G\u001a\u00020WH\u0080\b¢\u0006\u0004\bX\u0010Y\u001a\u001c\u0010Z\u001a\u00020\u000e*\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\fH\u0080\b¢\u0006\u0004\bZ\u0010\u0010\u001a\u0016\u0010[\u001a\u0004\u0018\u00010\u000e*\u00020\u000bH\u0080\b¢\u0006\u0004\b[\u0010\\\u001a\u001c\u0010^\u001a\u00020\u000e*\u00020\u000b2\u0006\u0010]\u001a\u00020\fH\u0080\b¢\u0006\u0004\b^\u0010\u0010\u001a\u0014\u0010_\u001a\u00020\u0002*\u00020\u000bH\u0080\b¢\u0006\u0004\b_\u0010*\u001a,\u0010c\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010`\u001a\u00020\u000e2\u0006\u0010a\u001a\u00020\u00022\u0006\u0010b\u001a\u00020\u0002H\u0080\b¢\u0006\u0004\bc\u0010d\u001a\u001c\u0010f\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010e\u001a\u00020\u0002H\u0080\b¢\u0006\u0004\bf\u0010g\u001a\u001c\u0010i\u001a\u00020\f*\u00020\u000b2\u0006\u0010>\u001a\u00020hH\u0080\b¢\u0006\u0004\bi\u0010j\u001a$\u0010k\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010>\u001a\u00020h2\u0006\u0010\u001e\u001a\u00020\fH\u0080\b¢\u0006\u0004\bk\u0010l\u001a\u001c\u0010m\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010!\u001a\u00020\u0002H\u0080\b¢\u0006\u0004\bm\u0010g\u001a\u001c\u0010n\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010P\u001a\u00020\u0002H\u0080\b¢\u0006\u0004\bn\u0010g\u001a\u001c\u0010p\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010o\u001a\u00020\u0002H\u0080\b¢\u0006\u0004\bp\u0010g\u001a\u001c\u0010q\u001a\u00020\u000b*\u00020\u000b2\u0006\u00108\u001a\u00020\fH\u0080\b¢\u0006\u0004\bq\u0010:\u001a$\u0010r\u001a\u00020/*\u00020\u000b2\u0006\u0010>\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\fH\u0080\b¢\u0006\u0004\br\u0010V\u001a$\u0010s\u001a\u00020\f*\u00020\u000b2\u0006\u0010G\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\fH\u0080\b¢\u0006\u0004\bs\u0010t\u001a,\u0010v\u001a\u00020\f*\u00020\u000b2\u0006\u0010!\u001a\u00020#2\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010u\u001a\u00020\fH\u0080\b¢\u0006\u0004\bv\u0010w\u001a$\u0010o\u001a\u00020\f*\u00020\u000b2\u0006\u0010\u0005\u001a\u0002042\u0006\u0010\u0012\u001a\u00020\fH\u0080\b¢\u0006\u0004\bo\u0010x\u001a$\u0010z\u001a\u00020\f*\u00020\u000b2\u0006\u0010y\u001a\u0002042\u0006\u0010\u0012\u001a\u00020\fH\u0080\b¢\u0006\u0004\bz\u0010x\u001a4\u0010{\u001a\u00020\b*\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\f2\u0006\u0010\u0005\u001a\u0002042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u0002H\u0080\b¢\u0006\u0004\b{\u0010|\u001a\u001f\u0010\u007f\u001a\u00020\b*\u00020\u000b2\b\u0010~\u001a\u0004\u0018\u00010}H\u0080\b¢\u0006\u0005\b\u007f\u0010\u0080\u0001\u001a\u0016\u0010\u0081\u0001\u001a\u00020\u0002*\u00020\u000bH\u0080\b¢\u0006\u0005\b\u0081\u0001\u0010*\u001a\u0017\u0010\u0082\u0001\u001a\u00020\u000b*\u00020\u000bH\u0080\b¢\u0006\u0006\b\u0082\u0001\u0010\u0083\u0001\u001a\u0016\u0010\u0084\u0001\u001a\u000204*\u00020\u000bH\u0080\b¢\u0006\u0005\b\u0084\u0001\u0010Q\u001a\u001f\u0010\u0085\u0001\u001a\u000204*\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u0002H\u0080\b¢\u0006\u0006\b\u0085\u0001\u0010\u0086\u0001\" \u0010\u008a\u0001\u001a\u00020\u00048\u0000@\u0000X\u0080\u0004¢\u0006\u000f\n\u0005\b0\u0010\u0087\u0001\u001a\u0006\b\u0088\u0001\u0010\u0089\u0001\"\u0018\u0010\u008b\u0001\u001a\u00020\f8\u0000@\u0000X\u0080T¢\u0006\u0007\n\u0005\b\u0082\u0001\u0010<\"\u0017\u0010\u008c\u0001\u001a\u00020\f8\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u001f\u0010<\"\u0018\u0010\u008d\u0001\u001a\u00020\u00028\u0000@\u0000X\u0080T¢\u0006\u0007\n\u0005\b!\u0010\u0085\u0001\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u008e\u0001"}, d2 = {"Lj/i0;", "segment", "", "segmentPos", "", "bytes", "bytesOffset", "bytesLimit", "", "a0", "(Lj/i0;I[BII)Z", "Lj/m;", "", "newline", "", "b0", "(Lj/m;J)Ljava/lang/String;", ExifInterface.GPS_DIRECTION_TRUE, "fromIndex", "Lkotlin/Function2;", "lambda", "c0", "(Lj/m;JLh/k2/u/p;)Ljava/lang/Object;", "Lj/c0;", "options", "selectTruncated", "d0", "(Lj/m;Lj/c0;Z)I", YKFConstants.INVESTIGATE_TYPE_OUT, "offset", "byteCount", e.j.a.b.c.f.f10128d, "(Lj/m;Lj/m;JJ)Lj/m;", "b", "(Lj/m;)J", "", am.ax, "(Lj/m;)B", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Lj/m;)S", "y", "(Lj/m;)I", am.aD, "pos", "f", "(Lj/m;J)B", "Lh/t1;", am.av, "(Lj/m;)V", "G", "(Lj/m;J)V", "Lokio/ByteString;", "byteString", "K", "(Lj/m;Lokio/ByteString;II)Lj/m;", "v", ExifInterface.LATITUDE_SOUTH, "(Lj/m;J)Lj/m;", "minimumCapacity", "J", "(Lj/m;I)Lj/i0;", MessageKey.MSG_SOURCE, "M", "(Lj/m;[B)Lj/m;", "N", "(Lj/m;[BII)Lj/m;", "q", "(Lj/m;)[B", "r", "(Lj/m;J)[B", "sink", NotifyType.LIGHTS, "(Lj/m;[B)I", IAdInterListener.AdReqParam.WIDTH, "(Lj/m;[B)V", "m", "(Lj/m;[BII)I", am.aH, "x", "s", "(Lj/m;)Lokio/ByteString;", am.aI, "(Lj/m;J)Lokio/ByteString;", "F", "(Lj/m;Lj/c0;)I", "(Lj/m;Lj/m;J)V", "Lj/k0;", "o", "(Lj/m;Lj/k0;)J", "B", "D", "(Lj/m;)Ljava/lang/String;", "limit", ExifInterface.LONGITUDE_EAST, "C", "string", "beginIndex", "endIndex", "X", "(Lj/m;Ljava/lang/String;II)Lj/m;", "codePoint", "Y", "(Lj/m;I)Lj/m;", "Lj/m0;", "Q", "(Lj/m;Lj/m0;)J", "L", "(Lj/m;Lj/m0;J)Lj/m;", "R", ExifInterface.LONGITUDE_WEST, "i", "U", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "O", "n", "(Lj/m;Lj/m;J)J", "toIndex", "h", "(Lj/m;BJJ)J", "(Lj/m;Lokio/ByteString;J)J", "targetBytes", "j", "k", "(Lj/m;JLokio/ByteString;II)Z", "", "other", com.huawei.hms.push.e.a, "(Lj/m;Ljava/lang/Object;)Z", "g", "c", "(Lj/m;)Lj/m;", "H", ExpandableTextView.P, "(Lj/m;I)Lokio/ByteString;", "[B", "Z", "()[B", "HEX_DIGIT_BYTES", "OVERFLOW_ZONE", "OVERFLOW_DIGIT_START", "SEGMENTING_THRESHOLD", "okio"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class a {
    @k.e.a.d
    private static final byte[] a = i.a("0123456789abcdef");
    public static final int b = 4096;

    /* renamed from: c */
    public static final long f16004c = -922337203685477580L;

    /* renamed from: d */
    public static final long f16005d = -7;

    public static final short A(@k.e.a.d m mVar) {
        if (mVar.O0() >= 2) {
            i0 i0Var = mVar.a;
            int i2 = i0Var.b;
            int i3 = i0Var.f15982c;
            if (i3 - i2 < 2) {
                return (short) ((mVar.readByte() & 255) | ((mVar.readByte() & 255) << 8));
            }
            byte[] bArr = i0Var.a;
            int i4 = i2 + 1;
            int i5 = i4 + 1;
            int i6 = ((bArr[i2] & 255) << 8) | (bArr[i4] & 255);
            mVar.K0(mVar.O0() - 2);
            if (i5 == i3) {
                mVar.a = i0Var.b();
                j0.d(i0Var);
            } else {
                i0Var.b = i5;
            }
            return (short) i6;
        }
        throw new EOFException();
    }

    @k.e.a.d
    public static final String B(@k.e.a.d m mVar, long j2) {
        int i2 = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
        if (i2 >= 0 && j2 <= ((long) Integer.MAX_VALUE)) {
            if (mVar.O0() >= j2) {
                if (i2 == 0) {
                    return "";
                }
                i0 i0Var = mVar.a;
                int i3 = i0Var.b;
                if (i3 + j2 > i0Var.f15982c) {
                    return f.c(mVar.L(j2), 0, 0, 3, null);
                }
                int i4 = (int) j2;
                String b2 = f.b(i0Var.a, i3, i3 + i4);
                i0Var.b += i4;
                mVar.K0(mVar.O0() - j2);
                if (i0Var.b == i0Var.f15982c) {
                    mVar.a = i0Var.b();
                    j0.d(i0Var);
                }
                return b2;
            }
            throw new EOFException();
        }
        throw new IllegalArgumentException(("byteCount: " + j2).toString());
    }

    public static final int C(@k.e.a.d m mVar) {
        int i2;
        int i3;
        int i4;
        if (mVar.O0() != 0) {
            byte m0 = mVar.m0(0L);
            if ((m0 & n.a) == 0) {
                i2 = m0 & n.b;
                i3 = 1;
                i4 = 0;
            } else if ((m0 & 224) == 192) {
                i2 = m0 & 31;
                i3 = 2;
                i4 = 128;
            } else if ((m0 & 240) == 224) {
                i2 = m0 & cb.f7124m;
                i3 = 3;
                i4 = 2048;
            } else if ((m0 & 248) != 240) {
                mVar.skip(1L);
                return p0.f15998c;
            } else {
                i2 = m0 & 7;
                i3 = 4;
                i4 = 65536;
            }
            long j2 = i3;
            if (mVar.O0() >= j2) {
                for (int i5 = 1; i5 < i3; i5++) {
                    long j3 = i5;
                    byte m02 = mVar.m0(j3);
                    if ((m02 & 192) != 128) {
                        mVar.skip(j3);
                        return p0.f15998c;
                    }
                    i2 = (i2 << 6) | (m02 & p0.a);
                }
                mVar.skip(j2);
                return i2 > 1114111 ? p0.f15998c : ((55296 <= i2 && 57343 >= i2) || i2 < i4) ? p0.f15998c : i2;
            }
            throw new EOFException("size < " + i3 + ": " + mVar.O0() + " (to read code point prefixed 0x" + j.m(m0) + ')');
        }
        throw new EOFException();
    }

    @k.e.a.e
    public static final String D(@k.e.a.d m mVar) {
        long T = mVar.T((byte) 10);
        if (T != -1) {
            return b0(mVar, T);
        }
        if (mVar.O0() != 0) {
            return mVar.U(mVar.O0());
        }
        return null;
    }

    @k.e.a.d
    public static final String E(@k.e.a.d m mVar, long j2) {
        if (j2 >= 0) {
            long j3 = j2 != Long.MAX_VALUE ? j2 + 1 : Long.MAX_VALUE;
            byte b2 = (byte) 10;
            long m2 = mVar.m(b2, 0L, j3);
            if (m2 != -1) {
                return b0(mVar, m2);
            }
            if (j3 < mVar.O0() && mVar.m0(j3 - 1) == ((byte) 13) && mVar.m0(j3) == b2) {
                return b0(mVar, j3);
            }
            m mVar2 = new m();
            mVar.H(mVar2, 0L, Math.min(32, mVar.O0()));
            throw new EOFException("\\n not found: limit=" + Math.min(mVar.O0(), j2) + " content=" + mVar2.j0().hex() + y.E);
        }
        throw new IllegalArgumentException(("limit < 0: " + j2).toString());
    }

    public static final int F(@k.e.a.d m mVar, @k.e.a.d c0 c0Var) {
        int e0 = e0(mVar, c0Var, false, 2, null);
        if (e0 == -1) {
            return -1;
        }
        mVar.skip(c0Var.g()[e0].size());
        return e0;
    }

    public static final void G(@k.e.a.d m mVar, long j2) {
        while (j2 > 0) {
            i0 i0Var = mVar.a;
            if (i0Var != null) {
                int min = (int) Math.min(j2, i0Var.f15982c - i0Var.b);
                long j3 = min;
                mVar.K0(mVar.O0() - j3);
                j2 -= j3;
                int i2 = i0Var.b + min;
                i0Var.b = i2;
                if (i2 == i0Var.f15982c) {
                    mVar.a = i0Var.b();
                    j0.d(i0Var);
                }
            } else {
                throw new EOFException();
            }
        }
    }

    @k.e.a.d
    public static final ByteString H(@k.e.a.d m mVar) {
        if (mVar.O0() <= ((long) Integer.MAX_VALUE)) {
            return mVar.Q0((int) mVar.O0());
        }
        throw new IllegalStateException(("size > Int.MAX_VALUE: " + mVar.O0()).toString());
    }

    @k.e.a.d
    public static final ByteString I(@k.e.a.d m mVar, int i2) {
        if (i2 == 0) {
            return ByteString.EMPTY;
        }
        j.e(mVar.O0(), 0L, i2);
        i0 i0Var = mVar.a;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i4 < i2) {
            int i6 = i0Var.f15982c;
            int i7 = i0Var.b;
            if (i6 != i7) {
                i4 += i6 - i7;
                i5++;
                i0Var = i0Var.f15985f;
            } else {
                throw new AssertionError("s.limit == s.pos");
            }
        }
        byte[][] bArr = new byte[i5];
        int[] iArr = new int[i5 * 2];
        i0 i0Var2 = mVar.a;
        int i8 = 0;
        while (i3 < i2) {
            bArr[i8] = i0Var2.a;
            i3 += i0Var2.f15982c - i0Var2.b;
            iArr[i8] = Math.min(i3, i2);
            iArr[i8 + i5] = i0Var2.b;
            i0Var2.f15983d = true;
            i8++;
            i0Var2 = i0Var2.f15985f;
        }
        return new SegmentedByteString(bArr, iArr);
    }

    @k.e.a.d
    public static final i0 J(@k.e.a.d m mVar, int i2) {
        boolean z = true;
        if ((i2 < 1 || i2 > 8192) ? false : false) {
            i0 i0Var = mVar.a;
            if (i0Var == null) {
                i0 e2 = j0.e();
                mVar.a = e2;
                e2.f15986g = e2;
                e2.f15985f = e2;
                return e2;
            }
            i0 i0Var2 = i0Var.f15986g;
            return (i0Var2.f15982c + i2 > 8192 || !i0Var2.f15984e) ? i0Var2.c(j0.e()) : i0Var2;
        }
        throw new IllegalArgumentException("unexpected capacity".toString());
    }

    @k.e.a.d
    public static final m K(@k.e.a.d m mVar, @k.e.a.d ByteString byteString, int i2, int i3) {
        byteString.write$okio(mVar, i2, i3);
        return mVar;
    }

    @k.e.a.d
    public static final m L(@k.e.a.d m mVar, @k.e.a.d m0 m0Var, long j2) {
        while (j2 > 0) {
            long read = m0Var.read(mVar, j2);
            if (read == -1) {
                throw new EOFException();
            }
            j2 -= read;
        }
        return mVar;
    }

    @k.e.a.d
    public static final m M(@k.e.a.d m mVar, @k.e.a.d byte[] bArr) {
        return mVar.write(bArr, 0, bArr.length);
    }

    @k.e.a.d
    public static final m N(@k.e.a.d m mVar, @k.e.a.d byte[] bArr, int i2, int i3) {
        long j2 = i3;
        j.e(bArr.length, i2, j2);
        int i4 = i3 + i2;
        while (i2 < i4) {
            i0 R0 = mVar.R0(1);
            int min = Math.min(i4 - i2, 8192 - R0.f15982c);
            int i5 = i2 + min;
            h.a2.n.W0(bArr, R0.a, R0.f15982c, i2, i5);
            R0.f15982c += min;
            i2 = i5;
        }
        mVar.K0(mVar.O0() + j2);
        return mVar;
    }

    public static final void O(@k.e.a.d m mVar, @k.e.a.d m mVar2, long j2) {
        if (mVar2 != mVar) {
            j.e(mVar2.O0(), 0L, j2);
            while (j2 > 0) {
                if (j2 < mVar2.a.f15982c - mVar2.a.b) {
                    i0 i0Var = mVar.a;
                    i0 i0Var2 = i0Var != null ? i0Var.f15986g : null;
                    if (i0Var2 != null && i0Var2.f15984e) {
                        if ((i0Var2.f15982c + j2) - (i0Var2.f15983d ? 0 : i0Var2.b) <= 8192) {
                            mVar2.a.g(i0Var2, (int) j2);
                            mVar2.K0(mVar2.O0() - j2);
                            mVar.K0(mVar.O0() + j2);
                            return;
                        }
                    }
                    mVar2.a = mVar2.a.e((int) j2);
                }
                i0 i0Var3 = mVar2.a;
                long j3 = i0Var3.f15982c - i0Var3.b;
                mVar2.a = i0Var3.b();
                i0 i0Var4 = mVar.a;
                if (i0Var4 == null) {
                    mVar.a = i0Var3;
                    i0Var3.f15986g = i0Var3;
                    i0Var3.f15985f = i0Var3;
                } else {
                    i0Var4.f15986g.c(i0Var3).a();
                }
                mVar2.K0(mVar2.O0() - j3);
                mVar.K0(mVar.O0() + j3);
                j2 -= j3;
            }
            return;
        }
        throw new IllegalArgumentException("source == this".toString());
    }

    public static /* synthetic */ m P(m mVar, ByteString byteString, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = byteString.size();
        }
        byteString.write$okio(mVar, i2, i3);
        return mVar;
    }

    public static final long Q(@k.e.a.d m mVar, @k.e.a.d m0 m0Var) {
        long j2 = 0;
        while (true) {
            long read = m0Var.read(mVar, 8192);
            if (read == -1) {
                return j2;
            }
            j2 += read;
        }
    }

    @k.e.a.d
    public static final m R(@k.e.a.d m mVar, int i2) {
        i0 R0 = mVar.R0(1);
        byte[] bArr = R0.a;
        int i3 = R0.f15982c;
        R0.f15982c = i3 + 1;
        bArr[i3] = (byte) i2;
        mVar.K0(mVar.O0() + 1);
        return mVar;
    }

    @k.e.a.d
    public static final m S(@k.e.a.d m mVar, long j2) {
        int i2 = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
        if (i2 == 0) {
            return mVar.writeByte(48);
        }
        boolean z = false;
        int i3 = 1;
        if (i2 < 0) {
            j2 = -j2;
            if (j2 < 0) {
                return mVar.B("-9223372036854775808");
            }
            z = true;
        }
        if (j2 >= 100000000) {
            i3 = j2 < 1000000000000L ? j2 < RealConnection.IDLE_CONNECTION_HEALTHY_NS ? j2 < 1000000000 ? 9 : 10 : j2 < 100000000000L ? 11 : 12 : j2 < 1000000000000000L ? j2 < 10000000000000L ? 13 : j2 < 100000000000000L ? 14 : 15 : j2 < 100000000000000000L ? j2 < 10000000000000000L ? 16 : 17 : j2 < 1000000000000000000L ? 18 : 19;
        } else if (j2 >= com.heytap.mcssdk.constant.a.q) {
            i3 = j2 < 1000000 ? j2 < 100000 ? 5 : 6 : j2 < 10000000 ? 7 : 8;
        } else if (j2 >= 100) {
            i3 = j2 < 1000 ? 3 : 4;
        } else if (j2 >= 10) {
            i3 = 2;
        }
        if (z) {
            i3++;
        }
        i0 R0 = mVar.R0(i3);
        byte[] bArr = R0.a;
        int i4 = R0.f15982c + i3;
        while (j2 != 0) {
            long j3 = 10;
            i4--;
            bArr[i4] = Z()[(int) (j2 % j3)];
            j2 /= j3;
        }
        if (z) {
            bArr[i4 - 1] = (byte) 45;
        }
        R0.f15982c += i3;
        mVar.K0(mVar.O0() + i3);
        return mVar;
    }

    @k.e.a.d
    public static final m T(@k.e.a.d m mVar, long j2) {
        if (j2 == 0) {
            return mVar.writeByte(48);
        }
        long j3 = (j2 >>> 1) | j2;
        long j4 = j3 | (j3 >>> 2);
        long j5 = j4 | (j4 >>> 4);
        long j6 = j5 | (j5 >>> 8);
        long j7 = j6 | (j6 >>> 16);
        long j8 = j7 | (j7 >>> 32);
        long j9 = j8 - ((j8 >>> 1) & 6148914691236517205L);
        long j10 = ((j9 >>> 2) & 3689348814741910323L) + (j9 & 3689348814741910323L);
        long j11 = ((j10 >>> 4) + j10) & 1085102592571150095L;
        long j12 = j11 + (j11 >>> 8);
        long j13 = j12 + (j12 >>> 16);
        int i2 = (int) ((((j13 & 63) + ((j13 >>> 32) & 63)) + 3) / 4);
        i0 R0 = mVar.R0(i2);
        byte[] bArr = R0.a;
        int i3 = R0.f15982c;
        for (int i4 = (i3 + i2) - 1; i4 >= i3; i4--) {
            bArr[i4] = Z()[(int) (15 & j2)];
            j2 >>>= 4;
        }
        R0.f15982c += i2;
        mVar.K0(mVar.O0() + i2);
        return mVar;
    }

    @k.e.a.d
    public static final m U(@k.e.a.d m mVar, int i2) {
        i0 R0 = mVar.R0(4);
        byte[] bArr = R0.a;
        int i3 = R0.f15982c;
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((i2 >>> 24) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((i2 >>> 16) & 255);
        int i6 = i5 + 1;
        bArr[i5] = (byte) ((i2 >>> 8) & 255);
        bArr[i6] = (byte) (i2 & 255);
        R0.f15982c = i6 + 1;
        mVar.K0(mVar.O0() + 4);
        return mVar;
    }

    @k.e.a.d
    public static final m V(@k.e.a.d m mVar, long j2) {
        i0 R0 = mVar.R0(8);
        byte[] bArr = R0.a;
        int i2 = R0.f15982c;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((j2 >>> 56) & 255);
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((j2 >>> 48) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((j2 >>> 40) & 255);
        int i6 = i5 + 1;
        bArr[i5] = (byte) ((j2 >>> 32) & 255);
        int i7 = i6 + 1;
        bArr[i6] = (byte) ((j2 >>> 24) & 255);
        int i8 = i7 + 1;
        bArr[i7] = (byte) ((j2 >>> 16) & 255);
        int i9 = i8 + 1;
        bArr[i8] = (byte) ((j2 >>> 8) & 255);
        bArr[i9] = (byte) (j2 & 255);
        R0.f15982c = i9 + 1;
        mVar.K0(mVar.O0() + 8);
        return mVar;
    }

    @k.e.a.d
    public static final m W(@k.e.a.d m mVar, int i2) {
        i0 R0 = mVar.R0(2);
        byte[] bArr = R0.a;
        int i3 = R0.f15982c;
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((i2 >>> 8) & 255);
        bArr[i4] = (byte) (i2 & 255);
        R0.f15982c = i4 + 1;
        mVar.K0(mVar.O0() + 2);
        return mVar;
    }

    @k.e.a.d
    public static final m X(@k.e.a.d m mVar, @k.e.a.d String str, int i2, int i3) {
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(("beginIndex < 0: " + i2).toString());
        }
        if (i3 >= i2) {
            if (!(i3 <= str.length())) {
                throw new IllegalArgumentException(("endIndex > string.length: " + i3 + " > " + str.length()).toString());
            }
            while (i2 < i3) {
                char charAt = str.charAt(i2);
                if (charAt < 128) {
                    i0 R0 = mVar.R0(1);
                    byte[] bArr = R0.a;
                    int i4 = R0.f15982c - i2;
                    int min = Math.min(i3, 8192 - i4);
                    int i5 = i2 + 1;
                    bArr[i2 + i4] = (byte) charAt;
                    while (i5 < min) {
                        char charAt2 = str.charAt(i5);
                        if (charAt2 >= 128) {
                            break;
                        }
                        bArr[i5 + i4] = (byte) charAt2;
                        i5++;
                    }
                    int i6 = R0.f15982c;
                    int i7 = (i4 + i5) - i6;
                    R0.f15982c = i6 + i7;
                    mVar.K0(mVar.O0() + i7);
                    i2 = i5;
                } else {
                    if (charAt < 2048) {
                        i0 R02 = mVar.R0(2);
                        byte[] bArr2 = R02.a;
                        int i8 = R02.f15982c;
                        bArr2[i8] = (byte) ((charAt >> 6) | 192);
                        bArr2[i8 + 1] = (byte) ((charAt & k.b.a.a.o.e.a) | 128);
                        R02.f15982c = i8 + 2;
                        mVar.K0(mVar.O0() + 2);
                    } else if (charAt >= 55296 && charAt <= 57343) {
                        int i9 = i2 + 1;
                        char charAt3 = i9 < i3 ? str.charAt(i9) : (char) 0;
                        if (charAt <= 56319 && 56320 <= charAt3 && 57343 >= charAt3) {
                            int i10 = (((charAt & 1023) << 10) | (charAt3 & 1023)) + 65536;
                            i0 R03 = mVar.R0(4);
                            byte[] bArr3 = R03.a;
                            int i11 = R03.f15982c;
                            bArr3[i11] = (byte) ((i10 >> 18) | 240);
                            bArr3[i11 + 1] = (byte) (((i10 >> 12) & 63) | 128);
                            bArr3[i11 + 2] = (byte) (((i10 >> 6) & 63) | 128);
                            bArr3[i11 + 3] = (byte) ((i10 & 63) | 128);
                            R03.f15982c = i11 + 4;
                            mVar.K0(mVar.O0() + 4);
                            i2 += 2;
                        } else {
                            mVar.writeByte(63);
                            i2 = i9;
                        }
                    } else {
                        i0 R04 = mVar.R0(3);
                        byte[] bArr4 = R04.a;
                        int i12 = R04.f15982c;
                        bArr4[i12] = (byte) ((charAt >> '\f') | 224);
                        bArr4[i12 + 1] = (byte) ((63 & (charAt >> 6)) | 128);
                        bArr4[i12 + 2] = (byte) ((charAt & k.b.a.a.o.e.a) | 128);
                        R04.f15982c = i12 + 3;
                        mVar.K0(mVar.O0() + 3);
                    }
                    i2++;
                }
            }
            return mVar;
        }
        throw new IllegalArgumentException(("endIndex < beginIndex: " + i3 + " < " + i2).toString());
    }

    @k.e.a.d
    public static final m Y(@k.e.a.d m mVar, int i2) {
        if (i2 < 128) {
            mVar.writeByte(i2);
        } else if (i2 < 2048) {
            i0 R0 = mVar.R0(2);
            byte[] bArr = R0.a;
            int i3 = R0.f15982c;
            bArr[i3] = (byte) ((i2 >> 6) | 192);
            bArr[i3 + 1] = (byte) ((i2 & 63) | 128);
            R0.f15982c = i3 + 2;
            mVar.K0(mVar.O0() + 2);
        } else if (55296 <= i2 && 57343 >= i2) {
            mVar.writeByte(63);
        } else if (i2 < 65536) {
            i0 R02 = mVar.R0(3);
            byte[] bArr2 = R02.a;
            int i4 = R02.f15982c;
            bArr2[i4] = (byte) ((i2 >> 12) | 224);
            bArr2[i4 + 1] = (byte) (((i2 >> 6) & 63) | 128);
            bArr2[i4 + 2] = (byte) ((i2 & 63) | 128);
            R02.f15982c = i4 + 3;
            mVar.K0(mVar.O0() + 3);
        } else if (i2 <= 1114111) {
            i0 R03 = mVar.R0(4);
            byte[] bArr3 = R03.a;
            int i5 = R03.f15982c;
            bArr3[i5] = (byte) ((i2 >> 18) | 240);
            bArr3[i5 + 1] = (byte) (((i2 >> 12) & 63) | 128);
            bArr3[i5 + 2] = (byte) (((i2 >> 6) & 63) | 128);
            bArr3[i5 + 3] = (byte) ((i2 & 63) | 128);
            R03.f15982c = i5 + 4;
            mVar.K0(mVar.O0() + 4);
        } else {
            throw new IllegalArgumentException("Unexpected code point: 0x" + j.n(i2));
        }
        return mVar;
    }

    @k.e.a.d
    public static final byte[] Z() {
        return a;
    }

    public static final void a(@k.e.a.d m mVar) {
        mVar.skip(mVar.O0());
    }

    public static final boolean a0(@k.e.a.d i0 i0Var, int i2, @k.e.a.d byte[] bArr, int i3, int i4) {
        int i5 = i0Var.f15982c;
        byte[] bArr2 = i0Var.a;
        while (i3 < i4) {
            if (i2 == i5) {
                i0Var = i0Var.f15985f;
                byte[] bArr3 = i0Var.a;
                bArr2 = bArr3;
                i2 = i0Var.b;
                i5 = i0Var.f15982c;
            }
            if (bArr2[i2] != bArr[i3]) {
                return false;
            }
            i2++;
            i3++;
        }
        return true;
    }

    public static final long b(@k.e.a.d m mVar) {
        long O0 = mVar.O0();
        if (O0 == 0) {
            return 0L;
        }
        i0 i0Var = mVar.a.f15986g;
        int i2 = i0Var.f15982c;
        return (i2 >= 8192 || !i0Var.f15984e) ? O0 : O0 - (i2 - i0Var.b);
    }

    @k.e.a.d
    public static final String b0(@k.e.a.d m mVar, long j2) {
        if (j2 > 0) {
            long j3 = j2 - 1;
            if (mVar.m0(j3) == ((byte) 13)) {
                String U = mVar.U(j3);
                mVar.skip(2L);
                return U;
            }
        }
        String U2 = mVar.U(j2);
        mVar.skip(1L);
        return U2;
    }

    @k.e.a.d
    public static final m c(@k.e.a.d m mVar) {
        m mVar2 = new m();
        if (mVar.O0() == 0) {
            return mVar2;
        }
        i0 i0Var = mVar.a;
        i0 d2 = i0Var.d();
        mVar2.a = d2;
        d2.f15986g = d2;
        d2.f15985f = d2;
        for (i0 i0Var2 = i0Var.f15985f; i0Var2 != i0Var; i0Var2 = i0Var2.f15985f) {
            d2.f15986g.c(i0Var2.d());
        }
        mVar2.K0(mVar.O0());
        return mVar2;
    }

    public static final <T> T c0(@k.e.a.d m mVar, long j2, @k.e.a.d p<? super i0, ? super Long, ? extends T> pVar) {
        i0 i0Var = mVar.a;
        if (i0Var != null) {
            if (mVar.O0() - j2 < j2) {
                long O0 = mVar.O0();
                while (O0 > j2) {
                    i0Var = i0Var.f15986g;
                    O0 -= i0Var.f15982c - i0Var.b;
                }
                return pVar.invoke(i0Var, Long.valueOf(O0));
            }
            long j3 = 0;
            while (true) {
                long j4 = (i0Var.f15982c - i0Var.b) + j3;
                if (j4 > j2) {
                    return pVar.invoke(i0Var, Long.valueOf(j3));
                }
                i0Var = i0Var.f15985f;
                j3 = j4;
            }
        } else {
            return pVar.invoke(null, -1L);
        }
    }

    @k.e.a.d
    public static final m d(@k.e.a.d m mVar, @k.e.a.d m mVar2, long j2, long j3) {
        j.e(mVar.O0(), j2, j3);
        if (j3 == 0) {
            return mVar;
        }
        mVar2.K0(mVar2.O0() + j3);
        i0 i0Var = mVar.a;
        while (true) {
            int i2 = i0Var.f15982c;
            int i3 = i0Var.b;
            if (j2 < i2 - i3) {
                break;
            }
            j2 -= i2 - i3;
            i0Var = i0Var.f15985f;
        }
        while (j3 > 0) {
            i0 d2 = i0Var.d();
            int i4 = d2.b + ((int) j2);
            d2.b = i4;
            d2.f15982c = Math.min(i4 + ((int) j3), d2.f15982c);
            i0 i0Var2 = mVar2.a;
            if (i0Var2 == null) {
                d2.f15986g = d2;
                d2.f15985f = d2;
                mVar2.a = d2;
            } else {
                i0Var2.f15986g.c(d2);
            }
            j3 -= d2.f15982c - d2.b;
            i0Var = i0Var.f15985f;
            j2 = 0;
        }
        return mVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:139:0x004b, code lost:
        if (r19 == false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x004d, code lost:
        return -2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:141:0x004e, code lost:
        return r10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final int d0(@k.e.a.d j.m r17, @k.e.a.d j.c0 r18, boolean r19) {
        /*
            r0 = r17
            j.i0 r0 = r0.a
            r1 = -2
            r2 = -1
            if (r0 == 0) goto L96
            byte[] r3 = r0.a
            int r4 = r0.b
            int r5 = r0.f15982c
            int[] r6 = r18.h()
            r7 = 0
            r9 = r0
            r8 = 0
            r10 = -1
        L16:
            int r11 = r8 + 1
            r8 = r6[r8]
            int r12 = r11 + 1
            r11 = r6[r11]
            if (r11 == r2) goto L21
            r10 = r11
        L21:
            if (r9 != 0) goto L24
            goto L4b
        L24:
            r11 = 0
            if (r8 >= 0) goto L6b
            int r8 = r8 * (-1)
            int r13 = r12 + r8
        L2b:
            int r8 = r4 + 1
            r4 = r3[r4]
            r4 = r4 & 255(0xff, float:3.57E-43)
            int r14 = r12 + 1
            r12 = r6[r12]
            if (r4 == r12) goto L38
            return r10
        L38:
            if (r14 != r13) goto L3c
            r4 = 1
            goto L3d
        L3c:
            r4 = 0
        L3d:
            if (r8 != r5) goto L58
            j.i0 r3 = r9.f15985f
            int r5 = r3.b
            byte[] r8 = r3.a
            int r9 = r3.f15982c
            if (r3 != r0) goto L52
            if (r4 != 0) goto L4f
        L4b:
            if (r19 == 0) goto L4e
            return r1
        L4e:
            return r10
        L4f:
            r3 = r8
            r8 = r11
            goto L5e
        L52:
            r16 = r8
            r8 = r3
            r3 = r16
            goto L5e
        L58:
            r16 = r9
            r9 = r5
            r5 = r8
            r8 = r16
        L5e:
            if (r4 == 0) goto L66
            r4 = r6[r14]
            r13 = r5
            r5 = r9
            r9 = r8
            goto L8d
        L66:
            r4 = r5
            r5 = r9
            r12 = r14
            r9 = r8
            goto L2b
        L6b:
            int r13 = r4 + 1
            r4 = r3[r4]
            r4 = r4 & 255(0xff, float:3.57E-43)
            int r14 = r12 + r8
        L73:
            if (r12 != r14) goto L76
            return r10
        L76:
            r15 = r6[r12]
            if (r4 != r15) goto L93
            int r12 = r12 + r8
            r4 = r6[r12]
            if (r13 != r5) goto L8d
            j.i0 r9 = r9.f15985f
            int r3 = r9.b
            byte[] r5 = r9.a
            int r8 = r9.f15982c
            r13 = r3
            r3 = r5
            r5 = r8
            if (r9 != r0) goto L8d
            r9 = r11
        L8d:
            if (r4 < 0) goto L90
            return r4
        L90:
            int r8 = -r4
            r4 = r13
            goto L16
        L93:
            int r12 = r12 + 1
            goto L73
        L96:
            if (r19 == 0) goto L99
            goto L9a
        L99:
            r1 = -1
        L9a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: j.q0.a.d0(j.m, j.c0, boolean):int");
    }

    public static final boolean e(@k.e.a.d m mVar, @k.e.a.e Object obj) {
        if (mVar == obj) {
            return true;
        }
        if (obj instanceof m) {
            m mVar2 = (m) obj;
            if (mVar.O0() != mVar2.O0()) {
                return false;
            }
            if (mVar.O0() == 0) {
                return true;
            }
            i0 i0Var = mVar.a;
            i0 i0Var2 = mVar2.a;
            int i2 = i0Var.b;
            int i3 = i0Var2.b;
            long j2 = 0;
            while (j2 < mVar.O0()) {
                long min = Math.min(i0Var.f15982c - i2, i0Var2.f15982c - i3);
                long j3 = 0;
                while (j3 < min) {
                    int i4 = i2 + 1;
                    int i5 = i3 + 1;
                    if (i0Var.a[i2] != i0Var2.a[i3]) {
                        return false;
                    }
                    j3++;
                    i2 = i4;
                    i3 = i5;
                }
                if (i2 == i0Var.f15982c) {
                    i0Var = i0Var.f15985f;
                    i2 = i0Var.b;
                }
                if (i3 == i0Var2.f15982c) {
                    i0Var2 = i0Var2.f15985f;
                    i3 = i0Var2.b;
                }
                j2 += min;
            }
            return true;
        }
        return false;
    }

    public static /* synthetic */ int e0(m mVar, c0 c0Var, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return d0(mVar, c0Var, z);
    }

    public static final byte f(@k.e.a.d m mVar, long j2) {
        j.e(mVar.O0(), j2, 1L);
        i0 i0Var = mVar.a;
        if (i0Var != null) {
            if (mVar.O0() - j2 < j2) {
                long O0 = mVar.O0();
                while (O0 > j2) {
                    i0Var = i0Var.f15986g;
                    O0 -= i0Var.f15982c - i0Var.b;
                }
                return i0Var.a[(int) ((i0Var.b + j2) - O0)];
            }
            long j3 = 0;
            while (true) {
                long j4 = (i0Var.f15982c - i0Var.b) + j3;
                if (j4 > j2) {
                    return i0Var.a[(int) ((i0Var.b + j2) - j3)];
                }
                i0Var = i0Var.f15985f;
                j3 = j4;
            }
        } else {
            i0 i0Var2 = null;
            return i0Var2.a[(int) ((i0Var2.b + j2) - (-1))];
        }
    }

    public static final int g(@k.e.a.d m mVar) {
        i0 i0Var = mVar.a;
        if (i0Var != null) {
            int i2 = 1;
            do {
                int i3 = i0Var.f15982c;
                for (int i4 = i0Var.b; i4 < i3; i4++) {
                    i2 = (i2 * 31) + i0Var.a[i4];
                }
                i0Var = i0Var.f15985f;
            } while (i0Var != mVar.a);
            return i2;
        }
        return 0;
    }

    public static final long h(@k.e.a.d m mVar, byte b2, long j2, long j3) {
        i0 i0Var;
        int i2;
        long j4 = 0;
        if (0 <= j2 && j3 >= j2) {
            if (j3 > mVar.O0()) {
                j3 = mVar.O0();
            }
            if (j2 == j3 || (i0Var = mVar.a) == null) {
                return -1L;
            }
            if (mVar.O0() - j2 < j2) {
                j4 = mVar.O0();
                while (j4 > j2) {
                    i0Var = i0Var.f15986g;
                    j4 -= i0Var.f15982c - i0Var.b;
                }
                if (i0Var != null) {
                    while (j4 < j3) {
                        byte[] bArr = i0Var.a;
                        int min = (int) Math.min(i0Var.f15982c, (i0Var.b + j3) - j4);
                        i2 = (int) ((i0Var.b + j2) - j4);
                        while (i2 < min) {
                            if (bArr[i2] != b2) {
                                i2++;
                            }
                        }
                        j4 += i0Var.f15982c - i0Var.b;
                        i0Var = i0Var.f15985f;
                        j2 = j4;
                    }
                }
                return -1L;
            }
            while (true) {
                long j5 = (i0Var.f15982c - i0Var.b) + j4;
                if (j5 > j2) {
                    break;
                }
                i0Var = i0Var.f15985f;
                j4 = j5;
            }
            if (i0Var != null) {
                while (j4 < j3) {
                    byte[] bArr2 = i0Var.a;
                    int min2 = (int) Math.min(i0Var.f15982c, (i0Var.b + j3) - j4);
                    i2 = (int) ((i0Var.b + j2) - j4);
                    while (i2 < min2) {
                        if (bArr2[i2] != b2) {
                            i2++;
                        }
                    }
                    j4 += i0Var.f15982c - i0Var.b;
                    i0Var = i0Var.f15985f;
                    j2 = j4;
                }
            }
            return -1L;
            return (i2 - i0Var.b) + j4;
        }
        throw new IllegalArgumentException(("size=" + mVar.O0() + " fromIndex=" + j2 + " toIndex=" + j3).toString());
    }

    public static final long i(@k.e.a.d m mVar, @k.e.a.d ByteString byteString, long j2) {
        long j3 = j2;
        if (byteString.size() > 0) {
            long j4 = 0;
            if (j3 >= 0) {
                i0 i0Var = mVar.a;
                if (i0Var != null) {
                    if (mVar.O0() - j3 < j3) {
                        long O0 = mVar.O0();
                        while (O0 > j3) {
                            i0Var = i0Var.f15986g;
                            O0 -= i0Var.f15982c - i0Var.b;
                        }
                        if (i0Var != null) {
                            byte[] internalArray$okio = byteString.internalArray$okio();
                            byte b2 = internalArray$okio[0];
                            int size = byteString.size();
                            long O02 = (mVar.O0() - size) + 1;
                            while (O0 < O02) {
                                byte[] bArr = i0Var.a;
                                int min = (int) Math.min(i0Var.f15982c, (i0Var.b + O02) - O0);
                                for (int i2 = (int) ((i0Var.b + j3) - O0); i2 < min; i2++) {
                                    if (bArr[i2] == b2 && a0(i0Var, i2 + 1, internalArray$okio, 1, size)) {
                                        return (i2 - i0Var.b) + O0;
                                    }
                                }
                                O0 += i0Var.f15982c - i0Var.b;
                                i0Var = i0Var.f15985f;
                                j3 = O0;
                            }
                            return -1L;
                        }
                        return -1L;
                    }
                    while (true) {
                        long j5 = (i0Var.f15982c - i0Var.b) + j4;
                        if (j5 > j3) {
                            break;
                        }
                        i0Var = i0Var.f15985f;
                        j4 = j5;
                    }
                    if (i0Var != null) {
                        byte[] internalArray$okio2 = byteString.internalArray$okio();
                        byte b3 = internalArray$okio2[0];
                        int size2 = byteString.size();
                        long O03 = (mVar.O0() - size2) + 1;
                        while (j4 < O03) {
                            byte[] bArr2 = i0Var.a;
                            long j6 = j4;
                            int min2 = (int) Math.min(i0Var.f15982c, (i0Var.b + O03) - j4);
                            for (int i3 = (int) ((i0Var.b + j3) - j6); i3 < min2; i3++) {
                                if (bArr2[i3] == b3 && a0(i0Var, i3 + 1, internalArray$okio2, 1, size2)) {
                                    return (i3 - i0Var.b) + j6;
                                }
                            }
                            j4 = j6 + (i0Var.f15982c - i0Var.b);
                            i0Var = i0Var.f15985f;
                            j3 = j4;
                        }
                        return -1L;
                    }
                    return -1L;
                }
                return -1L;
            }
            throw new IllegalArgumentException(("fromIndex < 0: " + j3).toString());
        }
        throw new IllegalArgumentException("bytes is empty".toString());
    }

    public static final long j(@k.e.a.d m mVar, @k.e.a.d ByteString byteString, long j2) {
        int i2;
        int i3;
        long j3 = 0;
        if (j2 >= 0) {
            i0 i0Var = mVar.a;
            if (i0Var != null) {
                if (mVar.O0() - j2 < j2) {
                    j3 = mVar.O0();
                    while (j3 > j2) {
                        i0Var = i0Var.f15986g;
                        j3 -= i0Var.f15982c - i0Var.b;
                    }
                    if (i0Var != null) {
                        if (byteString.size() == 2) {
                            byte b2 = byteString.getByte(0);
                            byte b3 = byteString.getByte(1);
                            while (j3 < mVar.O0()) {
                                byte[] bArr = i0Var.a;
                                i2 = (int) ((i0Var.b + j2) - j3);
                                int i4 = i0Var.f15982c;
                                while (i2 < i4) {
                                    byte b4 = bArr[i2];
                                    if (b4 != b2 && b4 != b3) {
                                        i2++;
                                    }
                                    i3 = i0Var.b;
                                }
                                j3 += i0Var.f15982c - i0Var.b;
                                i0Var = i0Var.f15985f;
                                j2 = j3;
                            }
                        } else {
                            byte[] internalArray$okio = byteString.internalArray$okio();
                            while (j3 < mVar.O0()) {
                                byte[] bArr2 = i0Var.a;
                                i2 = (int) ((i0Var.b + j2) - j3);
                                int i5 = i0Var.f15982c;
                                while (i2 < i5) {
                                    byte b5 = bArr2[i2];
                                    for (byte b6 : internalArray$okio) {
                                        if (b5 == b6) {
                                            i3 = i0Var.b;
                                        }
                                    }
                                    i2++;
                                }
                                j3 += i0Var.f15982c - i0Var.b;
                                i0Var = i0Var.f15985f;
                                j2 = j3;
                            }
                        }
                    }
                    return -1L;
                }
                while (true) {
                    long j4 = (i0Var.f15982c - i0Var.b) + j3;
                    if (j4 > j2) {
                        break;
                    }
                    i0Var = i0Var.f15985f;
                    j3 = j4;
                }
                if (i0Var != null) {
                    if (byteString.size() == 2) {
                        byte b7 = byteString.getByte(0);
                        byte b8 = byteString.getByte(1);
                        while (j3 < mVar.O0()) {
                            byte[] bArr3 = i0Var.a;
                            i2 = (int) ((i0Var.b + j2) - j3);
                            int i6 = i0Var.f15982c;
                            while (i2 < i6) {
                                byte b9 = bArr3[i2];
                                if (b9 != b7 && b9 != b8) {
                                    i2++;
                                }
                                i3 = i0Var.b;
                            }
                            j3 += i0Var.f15982c - i0Var.b;
                            i0Var = i0Var.f15985f;
                            j2 = j3;
                        }
                    } else {
                        byte[] internalArray$okio2 = byteString.internalArray$okio();
                        while (j3 < mVar.O0()) {
                            byte[] bArr4 = i0Var.a;
                            i2 = (int) ((i0Var.b + j2) - j3);
                            int i7 = i0Var.f15982c;
                            while (i2 < i7) {
                                byte b10 = bArr4[i2];
                                for (byte b11 : internalArray$okio2) {
                                    if (b10 == b11) {
                                        i3 = i0Var.b;
                                    }
                                }
                                i2++;
                            }
                            j3 += i0Var.f15982c - i0Var.b;
                            i0Var = i0Var.f15985f;
                            j2 = j3;
                        }
                    }
                }
                return -1L;
                return (i2 - i3) + j3;
            }
            return -1L;
        }
        throw new IllegalArgumentException(("fromIndex < 0: " + j2).toString());
    }

    public static final boolean k(@k.e.a.d m mVar, long j2, @k.e.a.d ByteString byteString, int i2, int i3) {
        if (j2 < 0 || i2 < 0 || i3 < 0 || mVar.O0() - j2 < i3 || byteString.size() - i2 < i3) {
            return false;
        }
        for (int i4 = 0; i4 < i3; i4++) {
            if (mVar.m0(i4 + j2) != byteString.getByte(i2 + i4)) {
                return false;
            }
        }
        return true;
    }

    public static final int l(@k.e.a.d m mVar, @k.e.a.d byte[] bArr) {
        return mVar.read(bArr, 0, bArr.length);
    }

    public static final int m(@k.e.a.d m mVar, @k.e.a.d byte[] bArr, int i2, int i3) {
        j.e(bArr.length, i2, i3);
        i0 i0Var = mVar.a;
        if (i0Var != null) {
            int min = Math.min(i3, i0Var.f15982c - i0Var.b);
            byte[] bArr2 = i0Var.a;
            int i4 = i0Var.b;
            h.a2.n.W0(bArr2, bArr, i2, i4, i4 + min);
            i0Var.b += min;
            mVar.K0(mVar.O0() - min);
            if (i0Var.b == i0Var.f15982c) {
                mVar.a = i0Var.b();
                j0.d(i0Var);
            }
            return min;
        }
        return -1;
    }

    public static final long n(@k.e.a.d m mVar, @k.e.a.d m mVar2, long j2) {
        if (j2 >= 0) {
            if (mVar.O0() == 0) {
                return -1L;
            }
            if (j2 > mVar.O0()) {
                j2 = mVar.O0();
            }
            mVar2.write(mVar, j2);
            return j2;
        }
        throw new IllegalArgumentException(("byteCount < 0: " + j2).toString());
    }

    public static final long o(@k.e.a.d m mVar, @k.e.a.d k0 k0Var) {
        long O0 = mVar.O0();
        if (O0 > 0) {
            k0Var.write(mVar, O0);
        }
        return O0;
    }

    public static final byte p(@k.e.a.d m mVar) {
        if (mVar.O0() != 0) {
            i0 i0Var = mVar.a;
            int i2 = i0Var.b;
            int i3 = i0Var.f15982c;
            int i4 = i2 + 1;
            byte b2 = i0Var.a[i2];
            mVar.K0(mVar.O0() - 1);
            if (i4 == i3) {
                mVar.a = i0Var.b();
                j0.d(i0Var);
            } else {
                i0Var.b = i4;
            }
            return b2;
        }
        throw new EOFException();
    }

    @k.e.a.d
    public static final byte[] q(@k.e.a.d m mVar) {
        return mVar.L(mVar.O0());
    }

    @k.e.a.d
    public static final byte[] r(@k.e.a.d m mVar, long j2) {
        if (j2 >= 0 && j2 <= ((long) Integer.MAX_VALUE)) {
            if (mVar.O0() >= j2) {
                byte[] bArr = new byte[(int) j2];
                mVar.readFully(bArr);
                return bArr;
            }
            throw new EOFException();
        }
        throw new IllegalArgumentException(("byteCount: " + j2).toString());
    }

    @k.e.a.d
    public static final ByteString s(@k.e.a.d m mVar) {
        return mVar.V(mVar.O0());
    }

    @k.e.a.d
    public static final ByteString t(@k.e.a.d m mVar, long j2) {
        if (j2 >= 0 && j2 <= ((long) Integer.MAX_VALUE)) {
            if (mVar.O0() >= j2) {
                if (j2 >= 4096) {
                    ByteString Q0 = mVar.Q0((int) j2);
                    mVar.skip(j2);
                    return Q0;
                }
                return new ByteString(mVar.L(j2));
            }
            throw new EOFException();
        }
        throw new IllegalArgumentException(("byteCount: " + j2).toString());
    }

    /* JADX WARN: Removed duplicated region for block: B:154:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x00bf A[EDGE_INSN: B:168:0x00bf->B:159:0x00bf ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final long u(@k.e.a.d j.m r17) {
        /*
            Method dump skipped, instructions count: 211
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: j.q0.a.u(j.m):long");
    }

    public static final void v(@k.e.a.d m mVar, @k.e.a.d m mVar2, long j2) {
        if (mVar.O0() >= j2) {
            mVar2.write(mVar, j2);
        } else {
            mVar2.write(mVar, mVar.O0());
            throw new EOFException();
        }
    }

    public static final void w(@k.e.a.d m mVar, @k.e.a.d byte[] bArr) {
        int i2 = 0;
        while (i2 < bArr.length) {
            int read = mVar.read(bArr, i2, bArr.length - i2);
            if (read == -1) {
                throw new EOFException();
            }
            i2 += read;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:128:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x00ab A[EDGE_INSN: B:138:0x00ab->B:133:0x00ab ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final long x(@k.e.a.d j.m r15) {
        /*
            long r0 = r15.O0()
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto Lb5
            r0 = 0
            r4 = r2
            r1 = 0
        Ld:
            j.i0 r6 = r15.a
            byte[] r7 = r6.a
            int r8 = r6.b
            int r9 = r6.f15982c
        L15:
            if (r8 >= r9) goto L97
            r10 = r7[r8]
            r11 = 48
            byte r11 = (byte) r11
            if (r10 < r11) goto L26
            r12 = 57
            byte r12 = (byte) r12
            if (r10 > r12) goto L26
            int r11 = r10 - r11
            goto L40
        L26:
            r11 = 97
            byte r11 = (byte) r11
            if (r10 < r11) goto L35
            r12 = 102(0x66, float:1.43E-43)
            byte r12 = (byte) r12
            if (r10 > r12) goto L35
        L30:
            int r11 = r10 - r11
            int r11 = r11 + 10
            goto L40
        L35:
            r11 = 65
            byte r11 = (byte) r11
            if (r10 < r11) goto L78
            r12 = 70
            byte r12 = (byte) r12
            if (r10 > r12) goto L78
            goto L30
        L40:
            r12 = -1152921504606846976(0xf000000000000000, double:-3.105036184601418E231)
            long r12 = r12 & r4
            int r14 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r14 != 0) goto L50
            r10 = 4
            long r4 = r4 << r10
            long r10 = (long) r11
            long r4 = r4 | r10
            int r8 = r8 + 1
            int r0 = r0 + 1
            goto L15
        L50:
            j.m r15 = new j.m
            r15.<init>()
            j.m r15 = r15.i0(r4)
            j.m r15 = r15.writeByte(r10)
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Number too large: "
            r1.append(r2)
            java.lang.String r15 = r15.p0()
            r1.append(r15)
            java.lang.String r15 = r1.toString()
            r0.<init>(r15)
            throw r0
        L78:
            if (r0 == 0) goto L7c
            r1 = 1
            goto L97
        L7c:
            java.lang.NumberFormatException r15 = new java.lang.NumberFormatException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Expected leading [0-9a-fA-F] character but was 0x"
            r0.append(r1)
            java.lang.String r1 = j.j.m(r10)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r15.<init>(r0)
            throw r15
        L97:
            if (r8 != r9) goto La3
            j.i0 r7 = r6.b()
            r15.a = r7
            j.j0.d(r6)
            goto La5
        La3:
            r6.b = r8
        La5:
            if (r1 != 0) goto Lab
            j.i0 r6 = r15.a
            if (r6 != 0) goto Ld
        Lab:
            long r1 = r15.O0()
            long r6 = (long) r0
            long r1 = r1 - r6
            r15.K0(r1)
            return r4
        Lb5:
            java.io.EOFException r15 = new java.io.EOFException
            r15.<init>()
            throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: j.q0.a.x(j.m):long");
    }

    public static final int y(@k.e.a.d m mVar) {
        if (mVar.O0() >= 4) {
            i0 i0Var = mVar.a;
            int i2 = i0Var.b;
            int i3 = i0Var.f15982c;
            if (i3 - i2 < 4) {
                return (mVar.readByte() & 255) | ((mVar.readByte() & 255) << 24) | ((mVar.readByte() & 255) << 16) | ((mVar.readByte() & 255) << 8);
            }
            byte[] bArr = i0Var.a;
            int i4 = i2 + 1;
            int i5 = i4 + 1;
            int i6 = ((bArr[i2] & 255) << 24) | ((bArr[i4] & 255) << 16);
            int i7 = i5 + 1;
            int i8 = i6 | ((bArr[i5] & 255) << 8);
            int i9 = i7 + 1;
            int i10 = i8 | (bArr[i7] & 255);
            mVar.K0(mVar.O0() - 4);
            if (i9 == i3) {
                mVar.a = i0Var.b();
                j0.d(i0Var);
            } else {
                i0Var.b = i9;
            }
            return i10;
        }
        throw new EOFException();
    }

    public static final long z(@k.e.a.d m mVar) {
        if (mVar.O0() >= 8) {
            i0 i0Var = mVar.a;
            int i2 = i0Var.b;
            int i3 = i0Var.f15982c;
            if (i3 - i2 < 8) {
                return ((mVar.readInt() & 4294967295L) << 32) | (4294967295L & mVar.readInt());
            }
            byte[] bArr = i0Var.a;
            int i4 = i2 + 1;
            int i5 = i4 + 1;
            int i6 = i5 + 1;
            long j2 = ((bArr[i2] & 255) << 56) | ((bArr[i4] & 255) << 48) | ((bArr[i5] & 255) << 40);
            int i7 = i6 + 1;
            long j3 = ((bArr[i6] & 255) << 32) | j2;
            int i8 = i7 + 1;
            int i9 = i8 + 1;
            long j4 = j3 | ((bArr[i7] & 255) << 24) | ((bArr[i8] & 255) << 16);
            int i10 = i9 + 1;
            int i11 = i10 + 1;
            long j5 = j4 | ((bArr[i9] & 255) << 8) | (bArr[i10] & 255);
            mVar.K0(mVar.O0() - 8);
            if (i11 == i3) {
                mVar.a = i0Var.b();
                j0.d(i0Var);
            } else {
                i0Var.b = i11;
            }
            return j5;
        }
        throw new EOFException();
    }
}
