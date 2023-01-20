package j;

import androidx.exifinterface.media.ExifInterface;
import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.umeng.analytics.pro.am;
import h.q0;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import okio.ByteString;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u00012\u00020\u0002J\u000f\u0010\u0004\u001a\u00020\u0003H'¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000e\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H&¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H&¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0013H&¢\u0006\u0004\b\u0016\u0010\u0015J\u000f\u0010\u0018\u001a\u00020\u0017H&¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0017H&¢\u0006\u0004\b\u001a\u0010\u0019J\u000f\u0010\u001b\u001a\u00020\tH&¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\tH&¢\u0006\u0004\b\u001d\u0010\u001cJ\u000f\u0010\u001e\u001a\u00020\tH&¢\u0006\u0004\b\u001e\u0010\u001cJ\u000f\u0010\u001f\u001a\u00020\tH&¢\u0006\u0004\b\u001f\u0010\u001cJ\u0017\u0010 \u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b \u0010\rJ\u000f\u0010\"\u001a\u00020!H&¢\u0006\u0004\b\"\u0010#J\u0017\u0010$\u001a\u00020!2\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b$\u0010%J\u0017\u0010(\u001a\u00020\u00172\u0006\u0010'\u001a\u00020&H&¢\u0006\u0004\b(\u0010)J\u000f\u0010+\u001a\u00020*H&¢\u0006\u0004\b+\u0010,J\u0017\u0010-\u001a\u00020*2\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b-\u0010.J\u0017\u00100\u001a\u00020\u00172\u0006\u0010/\u001a\u00020*H&¢\u0006\u0004\b0\u00101J\u0017\u00102\u001a\u00020\u000b2\u0006\u0010/\u001a\u00020*H&¢\u0006\u0004\b2\u00103J'\u00100\u001a\u00020\u00172\u0006\u0010/\u001a\u00020*2\u0006\u00104\u001a\u00020\u00172\u0006\u0010\n\u001a\u00020\u0017H&¢\u0006\u0004\b0\u00105J\u001f\u00106\u001a\u00020\u000b2\u0006\u0010/\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b6\u00107J\u0017\u00109\u001a\u00020\t2\u0006\u0010/\u001a\u000208H&¢\u0006\u0004\b9\u0010:J\u000f\u0010<\u001a\u00020;H&¢\u0006\u0004\b<\u0010=J\u0017\u0010>\u001a\u00020;2\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b>\u0010?J\u0011\u0010@\u001a\u0004\u0018\u00010;H&¢\u0006\u0004\b@\u0010=J\u000f\u0010A\u001a\u00020;H&¢\u0006\u0004\bA\u0010=J\u0017\u0010C\u001a\u00020;2\u0006\u0010B\u001a\u00020\tH&¢\u0006\u0004\bC\u0010?J\u000f\u0010D\u001a\u00020\u0017H&¢\u0006\u0004\bD\u0010\u0019J\u0017\u0010G\u001a\u00020;2\u0006\u0010F\u001a\u00020EH&¢\u0006\u0004\bG\u0010HJ\u001f\u0010I\u001a\u00020;2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010F\u001a\u00020EH&¢\u0006\u0004\bI\u0010JJ\u0017\u0010L\u001a\u00020\t2\u0006\u0010K\u001a\u00020\u0010H&¢\u0006\u0004\bL\u0010MJ\u001f\u0010O\u001a\u00020\t2\u0006\u0010K\u001a\u00020\u00102\u0006\u0010N\u001a\u00020\tH&¢\u0006\u0004\bO\u0010PJ'\u0010R\u001a\u00020\t2\u0006\u0010K\u001a\u00020\u00102\u0006\u0010N\u001a\u00020\t2\u0006\u0010Q\u001a\u00020\tH&¢\u0006\u0004\bR\u0010SJ\u0017\u0010U\u001a\u00020\t2\u0006\u0010T\u001a\u00020!H&¢\u0006\u0004\bU\u0010VJ\u001f\u0010W\u001a\u00020\t2\u0006\u0010T\u001a\u00020!2\u0006\u0010N\u001a\u00020\tH&¢\u0006\u0004\bW\u0010XJ\u0017\u0010Z\u001a\u00020\t2\u0006\u0010Y\u001a\u00020!H&¢\u0006\u0004\bZ\u0010VJ\u001f\u0010[\u001a\u00020\t2\u0006\u0010Y\u001a\u00020!2\u0006\u0010N\u001a\u00020\tH&¢\u0006\u0004\b[\u0010XJ\u001f\u0010\\\u001a\u00020\u00062\u0006\u00104\u001a\u00020\t2\u0006\u0010T\u001a\u00020!H&¢\u0006\u0004\b\\\u0010]J/\u0010_\u001a\u00020\u00062\u0006\u00104\u001a\u00020\t2\u0006\u0010T\u001a\u00020!2\u0006\u0010^\u001a\u00020\u00172\u0006\u0010\n\u001a\u00020\u0017H&¢\u0006\u0004\b_\u0010`J\u000f\u0010a\u001a\u00020\u0000H&¢\u0006\u0004\ba\u0010bJ\u000f\u0010d\u001a\u00020cH&¢\u0006\u0004\bd\u0010eR\u0016\u0010g\u001a\u00020\u00038&@&X¦\u0004¢\u0006\u0006\u001a\u0004\bf\u0010\u0005¨\u0006h"}, d2 = {"Lj/o;", "Lj/m0;", "Ljava/nio/channels/ReadableByteChannel;", "Lj/m;", am.aH, "()Lj/m;", "", "b0", "()Z", "", "byteCount", "Lh/t1;", "R", "(J)V", "G", "(J)Z", "", "readByte", "()B", "", "readShort", "()S", "N", "", "readInt", "()I", "n0", "readLong", "()J", "O", "d0", "w0", "skip", "Lokio/ByteString;", "j0", "()Lokio/ByteString;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "(J)Lokio/ByteString;", "Lj/c0;", "options", "y0", "(Lj/c0;)I", "", "Z", "()[B", "L", "(J)[B", "sink", "read", "([B)I", "readFully", "([B)V", "offset", "([BII)I", "h", "(Lj/m;J)V", "Lj/k0;", "s0", "(Lj/k0;)J", "", "p0", "()Ljava/lang/String;", "U", "(J)Ljava/lang/String;", "y", ExpandableTextView.P, "limit", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "h0", "Ljava/nio/charset/Charset;", "charset", "g0", "(Ljava/nio/charset/Charset;)Ljava/lang/String;", "q0", "(JLjava/nio/charset/Charset;)Ljava/lang/String;", "b", ExifInterface.GPS_DIRECTION_TRUE, "(B)J", "fromIndex", "g", "(BJ)J", "toIndex", "m", "(BJJ)J", "bytes", "f", "(Lokio/ByteString;)J", com.huawei.hms.push.e.a, "(Lokio/ByteString;J)J", "targetBytes", am.ax, "Q", "C", "(JLokio/ByteString;)Z", "bytesOffset", "K", "(JLokio/ByteString;II)Z", "peek", "()Lj/o;", "Ljava/io/InputStream;", "inputStream", "()Ljava/io/InputStream;", "getBuffer", "buffer", "okio"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public interface o extends m0, ReadableByteChannel {
    @k.e.a.d
    String A(long j2) throws IOException;

    boolean C(long j2, @k.e.a.d ByteString byteString) throws IOException;

    boolean G(long j2) throws IOException;

    @k.e.a.d
    String I() throws IOException;

    boolean K(long j2, @k.e.a.d ByteString byteString, int i2, int i3) throws IOException;

    @k.e.a.d
    byte[] L(long j2) throws IOException;

    short N() throws IOException;

    long O() throws IOException;

    long Q(@k.e.a.d ByteString byteString, long j2) throws IOException;

    void R(long j2) throws IOException;

    long T(byte b) throws IOException;

    @k.e.a.d
    String U(long j2) throws IOException;

    @k.e.a.d
    ByteString V(long j2) throws IOException;

    @k.e.a.d
    byte[] Z() throws IOException;

    boolean b0() throws IOException;

    long d0() throws IOException;

    long e(@k.e.a.d ByteString byteString, long j2) throws IOException;

    long f(@k.e.a.d ByteString byteString) throws IOException;

    long g(byte b, long j2) throws IOException;

    @k.e.a.d
    String g0(@k.e.a.d Charset charset) throws IOException;

    @k.e.a.d
    m getBuffer();

    void h(@k.e.a.d m mVar, long j2) throws IOException;

    int h0() throws IOException;

    @k.e.a.d
    InputStream inputStream();

    @k.e.a.d
    ByteString j0() throws IOException;

    long m(byte b, long j2, long j3) throws IOException;

    int n0() throws IOException;

    long p(@k.e.a.d ByteString byteString) throws IOException;

    @k.e.a.d
    String p0() throws IOException;

    @k.e.a.d
    o peek();

    @k.e.a.d
    String q0(long j2, @k.e.a.d Charset charset) throws IOException;

    int read(@k.e.a.d byte[] bArr) throws IOException;

    int read(@k.e.a.d byte[] bArr, int i2, int i3) throws IOException;

    byte readByte() throws IOException;

    void readFully(@k.e.a.d byte[] bArr) throws IOException;

    int readInt() throws IOException;

    long readLong() throws IOException;

    short readShort() throws IOException;

    long s0(@k.e.a.d k0 k0Var) throws IOException;

    void skip(long j2) throws IOException;

    @h.i(level = DeprecationLevel.WARNING, message = "moved to val: use getBuffer() instead", replaceWith = @q0(expression = "buffer", imports = {}))
    @k.e.a.d
    m u();

    long w0() throws IOException;

    @k.e.a.e
    String y() throws IOException;

    int y0(@k.e.a.d c0 c0Var) throws IOException;
}
