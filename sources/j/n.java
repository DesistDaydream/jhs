package j;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.tencent.android.tpush.common.MessageKey;
import com.umeng.analytics.pro.am;
import h.q0;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.channels.WritableByteChannel;
import java.nio.charset.Charset;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import okio.ByteString;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u00012\u00020\u0002J\u000f\u0010\u0004\u001a\u00020\u0003H'¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\b\u0010\tJ'\u0010\r\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH&¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000fH&¢\u0006\u0004\b\u0011\u0010\u0012J'\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH&¢\u0006\u0004\b\u0011\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u0014H&¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u00142\u0006\u0010\f\u001a\u00020\u0015H&¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001aH&¢\u0006\u0004\b\u001c\u0010\u001dJ'\u0010 \u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\nH&¢\u0006\u0004\b \u0010!J\u0017\u0010#\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020\nH&¢\u0006\u0004\b#\u0010$J\u001f\u0010'\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010&\u001a\u00020%H&¢\u0006\u0004\b'\u0010(J/\u0010)\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\n2\u0006\u0010&\u001a\u00020%H&¢\u0006\u0004\b)\u0010*J\u0017\u0010,\u001a\u00020\u00002\u0006\u0010+\u001a\u00020\nH&¢\u0006\u0004\b,\u0010$J\u0017\u0010.\u001a\u00020\u00002\u0006\u0010-\u001a\u00020\nH&¢\u0006\u0004\b.\u0010$J\u0017\u0010/\u001a\u00020\u00002\u0006\u0010-\u001a\u00020\nH&¢\u0006\u0004\b/\u0010$J\u0017\u00101\u001a\u00020\u00002\u0006\u00100\u001a\u00020\nH&¢\u0006\u0004\b1\u0010$J\u0017\u00102\u001a\u00020\u00002\u0006\u00100\u001a\u00020\nH&¢\u0006\u0004\b2\u0010$J\u0017\u00104\u001a\u00020\u00002\u0006\u00103\u001a\u00020\u0015H&¢\u0006\u0004\b4\u00105J\u0017\u00106\u001a\u00020\u00002\u0006\u00103\u001a\u00020\u0015H&¢\u0006\u0004\b6\u00105J\u0017\u00107\u001a\u00020\u00002\u0006\u00103\u001a\u00020\u0015H&¢\u0006\u0004\b7\u00105J\u0017\u00108\u001a\u00020\u00002\u0006\u00103\u001a\u00020\u0015H&¢\u0006\u0004\b8\u00105J\u000f\u0010:\u001a\u000209H&¢\u0006\u0004\b:\u0010;J\u000f\u00103\u001a\u00020\u0000H&¢\u0006\u0004\b3\u0010<J\u000f\u0010=\u001a\u00020\u0000H&¢\u0006\u0004\b=\u0010<J\u000f\u0010?\u001a\u00020>H&¢\u0006\u0004\b?\u0010@R\u0016\u0010B\u001a\u00020\u00038&@&X¦\u0004¢\u0006\u0006\u001a\u0004\bA\u0010\u0005¨\u0006C"}, d2 = {"Lj/n;", "Lj/k0;", "Ljava/nio/channels/WritableByteChannel;", "Lj/m;", am.aH, "()Lj/m;", "Lokio/ByteString;", "byteString", "r0", "(Lokio/ByteString;)Lj/n;", "", "offset", "byteCount", ExifInterface.LONGITUDE_WEST, "(Lokio/ByteString;II)Lj/n;", "", MessageKey.MSG_SOURCE, "write", "([B)Lj/n;", "([BII)Lj/n;", "Lj/m0;", "", ExifInterface.LONGITUDE_EAST, "(Lj/m0;)J", "l0", "(Lj/m0;J)Lj/n;", "", "string", "B", "(Ljava/lang/String;)Lj/n;", "beginIndex", "endIndex", "D", "(Ljava/lang/String;II)Lj/n;", "codePoint", IAdInterListener.AdReqParam.WIDTH, "(I)Lj/n;", "Ljava/nio/charset/Charset;", "charset", "k0", "(Ljava/lang/String;Ljava/nio/charset/Charset;)Lj/n;", "P", "(Ljava/lang/String;IILjava/nio/charset/Charset;)Lj/n;", "b", "writeByte", "s", "writeShort", "e0", "i", "writeInt", "a0", "v", "t0", "(J)Lj/n;", "x", ExifInterface.LATITUDE_SOUTH, "i0", "Lh/t1;", "flush", "()V", "()Lj/n;", am.aD, "Ljava/io/OutputStream;", "v0", "()Ljava/io/OutputStream;", "getBuffer", "buffer", "okio"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public interface n extends k0, WritableByteChannel {
    @k.e.a.d
    n B(@k.e.a.d String str) throws IOException;

    @k.e.a.d
    n D(@k.e.a.d String str, int i2, int i3) throws IOException;

    long E(@k.e.a.d m0 m0Var) throws IOException;

    @k.e.a.d
    n P(@k.e.a.d String str, int i2, int i3, @k.e.a.d Charset charset) throws IOException;

    @k.e.a.d
    n S(long j2) throws IOException;

    @k.e.a.d
    n W(@k.e.a.d ByteString byteString, int i2, int i3) throws IOException;

    @k.e.a.d
    n a0(int i2) throws IOException;

    @k.e.a.d
    n e0(int i2) throws IOException;

    @Override // j.k0, java.io.Flushable
    void flush() throws IOException;

    @k.e.a.d
    m getBuffer();

    @k.e.a.d
    n i0(long j2) throws IOException;

    @k.e.a.d
    n k0(@k.e.a.d String str, @k.e.a.d Charset charset) throws IOException;

    @k.e.a.d
    n l0(@k.e.a.d m0 m0Var, long j2) throws IOException;

    @k.e.a.d
    n r0(@k.e.a.d ByteString byteString) throws IOException;

    @k.e.a.d
    n t0(long j2) throws IOException;

    @h.i(level = DeprecationLevel.WARNING, message = "moved to val: use getBuffer() instead", replaceWith = @q0(expression = "buffer", imports = {}))
    @k.e.a.d
    m u();

    @k.e.a.d
    n v() throws IOException;

    @k.e.a.d
    OutputStream v0();

    @k.e.a.d
    n w(int i2) throws IOException;

    @k.e.a.d
    n write(@k.e.a.d byte[] bArr) throws IOException;

    @k.e.a.d
    n write(@k.e.a.d byte[] bArr, int i2, int i3) throws IOException;

    @k.e.a.d
    n writeByte(int i2) throws IOException;

    @k.e.a.d
    n writeInt(int i2) throws IOException;

    @k.e.a.d
    n writeShort(int i2) throws IOException;

    @k.e.a.d
    n x(long j2) throws IOException;

    @k.e.a.d
    n z() throws IOException;
}
