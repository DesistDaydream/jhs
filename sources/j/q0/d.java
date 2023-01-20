package j.q0;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.meizu.cloud.pushsdk.notification.model.NotifyType;
import com.umeng.analytics.pro.am;
import j.c0;
import j.e0;
import j.h0;
import j.j;
import j.k0;
import j.m;
import j.o;
import j.o0;
import j.z;
import java.io.EOFException;
import kotlin.Metadata;
import okio.ByteString;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\n\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a$\u0010\u0005\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003H\u0080\b¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0014\u0010\b\u001a\u00020\u0007*\u00020\u0000H\u0080\b¢\u0006\u0004\b\b\u0010\t\u001a\u001c\u0010\u000b\u001a\u00020\n*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\u0080\b¢\u0006\u0004\b\u000b\u0010\f\u001a\u001c\u0010\r\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\u0080\b¢\u0006\u0004\b\r\u0010\u000e\u001a\u0014\u0010\u0010\u001a\u00020\u000f*\u00020\u0000H\u0080\b¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u0014\u0010\u0013\u001a\u00020\u0012*\u00020\u0000H\u0080\b¢\u0006\u0004\b\u0013\u0010\u0014\u001a\u001c\u0010\u0015\u001a\u00020\u0012*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\u0080\b¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u001c\u0010\u001a\u001a\u00020\u0019*\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0017H\u0080\b¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u0014\u0010\u001d\u001a\u00020\u001c*\u00020\u0000H\u0080\b¢\u0006\u0004\b\u001d\u0010\u001e\u001a\u001c\u0010\u001f\u001a\u00020\u001c*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\u0080\b¢\u0006\u0004\b\u001f\u0010 \u001a\u001c\u0010!\u001a\u00020\n*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u001cH\u0080\b¢\u0006\u0004\b!\u0010\"\u001a,\u0010$\u001a\u00020\u0019*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020\u00192\u0006\u0010\u0004\u001a\u00020\u0019H\u0080\b¢\u0006\u0004\b$\u0010%\u001a$\u0010&\u001a\u00020\n*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003H\u0080\b¢\u0006\u0004\b&\u0010'\u001a\u001c\u0010)\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020(H\u0080\b¢\u0006\u0004\b)\u0010*\u001a\u0014\u0010,\u001a\u00020+*\u00020\u0000H\u0080\b¢\u0006\u0004\b,\u0010-\u001a\u001c\u0010.\u001a\u00020+*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\u0080\b¢\u0006\u0004\b.\u0010/\u001a\u0016\u00100\u001a\u0004\u0018\u00010+*\u00020\u0000H\u0080\b¢\u0006\u0004\b0\u0010-\u001a\u001c\u00102\u001a\u00020+*\u00020\u00002\u0006\u00101\u001a\u00020\u0003H\u0080\b¢\u0006\u0004\b2\u0010/\u001a\u0014\u00103\u001a\u00020\u0019*\u00020\u0000H\u0080\b¢\u0006\u0004\b3\u00104\u001a\u0014\u00106\u001a\u000205*\u00020\u0000H\u0080\b¢\u0006\u0004\b6\u00107\u001a\u0014\u00108\u001a\u000205*\u00020\u0000H\u0080\b¢\u0006\u0004\b8\u00107\u001a\u0014\u00109\u001a\u00020\u0019*\u00020\u0000H\u0080\b¢\u0006\u0004\b9\u00104\u001a\u0014\u0010:\u001a\u00020\u0019*\u00020\u0000H\u0080\b¢\u0006\u0004\b:\u00104\u001a\u0014\u0010;\u001a\u00020\u0003*\u00020\u0000H\u0080\b¢\u0006\u0004\b;\u0010<\u001a\u0014\u0010=\u001a\u00020\u0003*\u00020\u0000H\u0080\b¢\u0006\u0004\b=\u0010<\u001a\u0014\u0010>\u001a\u00020\u0003*\u00020\u0000H\u0080\b¢\u0006\u0004\b>\u0010<\u001a\u0014\u0010?\u001a\u00020\u0003*\u00020\u0000H\u0080\b¢\u0006\u0004\b?\u0010<\u001a\u001c\u0010@\u001a\u00020\n*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\u0080\b¢\u0006\u0004\b@\u0010\f\u001a,\u0010C\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\b\u001a\u00020\u000f2\u0006\u0010A\u001a\u00020\u00032\u0006\u0010B\u001a\u00020\u0003H\u0080\b¢\u0006\u0004\bC\u0010D\u001a$\u0010F\u001a\u00020\u0003*\u00020\u00002\u0006\u0010E\u001a\u00020\u00122\u0006\u0010A\u001a\u00020\u0003H\u0080\b¢\u0006\u0004\bF\u0010G\u001a$\u0010I\u001a\u00020\u0003*\u00020\u00002\u0006\u0010H\u001a\u00020\u00122\u0006\u0010A\u001a\u00020\u0003H\u0080\b¢\u0006\u0004\bI\u0010G\u001a4\u0010K\u001a\u00020\u0007*\u00020\u00002\u0006\u0010#\u001a\u00020\u00032\u0006\u0010E\u001a\u00020\u00122\u0006\u0010J\u001a\u00020\u00192\u0006\u0010\u0004\u001a\u00020\u0019H\u0080\b¢\u0006\u0004\bK\u0010L\u001a\u0014\u0010N\u001a\u00020M*\u00020\u0000H\u0080\b¢\u0006\u0004\bN\u0010O\u001a\u0014\u0010P\u001a\u00020\n*\u00020\u0000H\u0080\b¢\u0006\u0004\bP\u0010Q\u001a\u0014\u0010S\u001a\u00020R*\u00020\u0000H\u0080\b¢\u0006\u0004\bS\u0010T\u001a\u0014\u0010U\u001a\u00020+*\u00020\u0000H\u0080\b¢\u0006\u0004\bU\u0010-¨\u0006V"}, d2 = {"Lj/h0;", "Lj/m;", "sink", "", "byteCount", "i", "(Lj/h0;Lj/m;J)J", "", "b", "(Lj/h0;)Z", "Lh/t1;", "F", "(Lj/h0;J)V", ExifInterface.LONGITUDE_EAST, "(Lj/h0;J)Z", "", "k", "(Lj/h0;)B", "Lokio/ByteString;", "n", "(Lj/h0;)Lokio/ByteString;", "o", "(Lj/h0;J)Lokio/ByteString;", "Lj/c0;", "options", "", "G", "(Lj/h0;Lj/c0;)I", "", NotifyType.LIGHTS, "(Lj/h0;)[B", "m", "(Lj/h0;J)[B", "r", "(Lj/h0;[B)V", "offset", "h", "(Lj/h0;[BII)I", "q", "(Lj/h0;Lj/m;J)V", "Lj/k0;", "j", "(Lj/h0;Lj/k0;)J", "", am.aD, "(Lj/h0;)Ljava/lang/String;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Lj/h0;J)Ljava/lang/String;", "C", "limit", "D", "B", "(Lj/h0;)I", "", "x", "(Lj/h0;)S", "y", am.aI, am.aH, "v", "(Lj/h0;)J", IAdInterListener.AdReqParam.WIDTH, am.ax, "s", "H", "fromIndex", "toIndex", "c", "(Lj/h0;BJJ)J", "bytes", e.j.a.b.c.f.f10128d, "(Lj/h0;Lokio/ByteString;J)J", "targetBytes", com.huawei.hms.push.e.a, "bytesOffset", "g", "(Lj/h0;JLokio/ByteString;II)Z", "Lj/o;", "f", "(Lj/h0;)Lj/o;", am.av, "(Lj/h0;)V", "Lj/o0;", ExpandableTextView.P, "(Lj/h0;)Lj/o0;", "J", "okio"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class d {
    @k.e.a.d
    public static final String A(@k.e.a.d h0 h0Var, long j2) {
        h0Var.R(j2);
        return h0Var.a.U(j2);
    }

    public static final int B(@k.e.a.d h0 h0Var) {
        h0Var.R(1L);
        byte m0 = h0Var.a.m0(0L);
        if ((m0 & 224) == 192) {
            h0Var.R(2L);
        } else if ((m0 & 240) == 224) {
            h0Var.R(3L);
        } else if ((m0 & 248) == 240) {
            h0Var.R(4L);
        }
        return h0Var.a.h0();
    }

    @k.e.a.e
    public static final String C(@k.e.a.d h0 h0Var) {
        long T = h0Var.T((byte) 10);
        if (T == -1) {
            if (h0Var.a.O0() != 0) {
                return h0Var.U(h0Var.a.O0());
            }
            return null;
        }
        return a.b0(h0Var.a, T);
    }

    @k.e.a.d
    public static final String D(@k.e.a.d h0 h0Var, long j2) {
        if (j2 >= 0) {
            long j3 = j2 == Long.MAX_VALUE ? Long.MAX_VALUE : j2 + 1;
            byte b = (byte) 10;
            long m2 = h0Var.m(b, 0L, j3);
            if (m2 != -1) {
                return a.b0(h0Var.a, m2);
            }
            if (j3 < Long.MAX_VALUE && h0Var.G(j3) && h0Var.a.m0(j3 - 1) == ((byte) 13) && h0Var.G(1 + j3) && h0Var.a.m0(j3) == b) {
                return a.b0(h0Var.a, j3);
            }
            m mVar = new m();
            m mVar2 = h0Var.a;
            mVar2.H(mVar, 0L, Math.min(32, mVar2.O0()));
            throw new EOFException("\\n not found: limit=" + Math.min(h0Var.a.O0(), j2) + " content=" + mVar.j0().hex() + "…");
        }
        throw new IllegalArgumentException(("limit < 0: " + j2).toString());
    }

    public static final boolean E(@k.e.a.d h0 h0Var, long j2) {
        if (j2 >= 0) {
            if (!h0Var.b) {
                while (h0Var.a.O0() < j2) {
                    if (h0Var.f15978c.read(h0Var.a, 8192) == -1) {
                        return false;
                    }
                }
                return true;
            }
            throw new IllegalStateException("closed".toString());
        }
        throw new IllegalArgumentException(("byteCount < 0: " + j2).toString());
    }

    public static final void F(@k.e.a.d h0 h0Var, long j2) {
        if (!h0Var.G(j2)) {
            throw new EOFException();
        }
    }

    public static final int G(@k.e.a.d h0 h0Var, @k.e.a.d c0 c0Var) {
        if (!h0Var.b) {
            do {
                int d0 = a.d0(h0Var.a, c0Var, true);
                if (d0 != -2) {
                    if (d0 != -1) {
                        h0Var.a.skip(c0Var.g()[d0].size());
                        return d0;
                    }
                    return -1;
                }
            } while (h0Var.f15978c.read(h0Var.a, 8192) != -1);
            return -1;
        }
        throw new IllegalStateException("closed".toString());
    }

    public static final void H(@k.e.a.d h0 h0Var, long j2) {
        if (!(!h0Var.b)) {
            throw new IllegalStateException("closed".toString());
        }
        while (j2 > 0) {
            if (h0Var.a.O0() == 0 && h0Var.f15978c.read(h0Var.a, 8192) == -1) {
                throw new EOFException();
            }
            long min = Math.min(j2, h0Var.a.O0());
            h0Var.a.skip(min);
            j2 -= min;
        }
    }

    @k.e.a.d
    public static final o0 I(@k.e.a.d h0 h0Var) {
        return h0Var.f15978c.timeout();
    }

    @k.e.a.d
    public static final String J(@k.e.a.d h0 h0Var) {
        return "buffer(" + h0Var.f15978c + ')';
    }

    public static final void a(@k.e.a.d h0 h0Var) {
        if (h0Var.b) {
            return;
        }
        h0Var.b = true;
        h0Var.f15978c.close();
        h0Var.a.l();
    }

    public static final boolean b(@k.e.a.d h0 h0Var) {
        if (!h0Var.b) {
            return h0Var.a.b0() && h0Var.f15978c.read(h0Var.a, (long) 8192) == -1;
        }
        throw new IllegalStateException("closed".toString());
    }

    public static final long c(@k.e.a.d h0 h0Var, byte b, long j2, long j3) {
        boolean z = true;
        if (!h0Var.b) {
            if (!((0 > j2 || j3 < j2) ? false : false)) {
                throw new IllegalArgumentException(("fromIndex=" + j2 + " toIndex=" + j3).toString());
            }
            while (j2 < j3) {
                long m2 = h0Var.a.m(b, j2, j3);
                if (m2 == -1) {
                    long O0 = h0Var.a.O0();
                    if (O0 >= j3 || h0Var.f15978c.read(h0Var.a, 8192) == -1) {
                        break;
                    }
                    j2 = Math.max(j2, O0);
                } else {
                    return m2;
                }
            }
            return -1L;
        }
        throw new IllegalStateException("closed".toString());
    }

    public static final long d(@k.e.a.d h0 h0Var, @k.e.a.d ByteString byteString, long j2) {
        if (!(!h0Var.b)) {
            throw new IllegalStateException("closed".toString());
        }
        while (true) {
            long e2 = h0Var.a.e(byteString, j2);
            if (e2 != -1) {
                return e2;
            }
            long O0 = h0Var.a.O0();
            if (h0Var.f15978c.read(h0Var.a, 8192) == -1) {
                return -1L;
            }
            j2 = Math.max(j2, (O0 - byteString.size()) + 1);
        }
    }

    public static final long e(@k.e.a.d h0 h0Var, @k.e.a.d ByteString byteString, long j2) {
        if (!(!h0Var.b)) {
            throw new IllegalStateException("closed".toString());
        }
        while (true) {
            long Q = h0Var.a.Q(byteString, j2);
            if (Q != -1) {
                return Q;
            }
            long O0 = h0Var.a.O0();
            if (h0Var.f15978c.read(h0Var.a, 8192) == -1) {
                return -1L;
            }
            j2 = Math.max(j2, O0);
        }
    }

    @k.e.a.d
    public static final o f(@k.e.a.d h0 h0Var) {
        return z.d(new e0(h0Var));
    }

    public static final boolean g(@k.e.a.d h0 h0Var, long j2, @k.e.a.d ByteString byteString, int i2, int i3) {
        if (!h0Var.b) {
            if (j2 < 0 || i2 < 0 || i3 < 0 || byteString.size() - i2 < i3) {
                return false;
            }
            for (int i4 = 0; i4 < i3; i4++) {
                long j3 = i4 + j2;
                if (!h0Var.G(1 + j3) || h0Var.a.m0(j3) != byteString.getByte(i2 + i4)) {
                    return false;
                }
            }
            return true;
        }
        throw new IllegalStateException("closed".toString());
    }

    public static final int h(@k.e.a.d h0 h0Var, @k.e.a.d byte[] bArr, int i2, int i3) {
        long j2 = i3;
        j.e(bArr.length, i2, j2);
        if (h0Var.a.O0() == 0 && h0Var.f15978c.read(h0Var.a, 8192) == -1) {
            return -1;
        }
        return h0Var.a.read(bArr, i2, (int) Math.min(j2, h0Var.a.O0()));
    }

    public static final long i(@k.e.a.d h0 h0Var, @k.e.a.d m mVar, long j2) {
        if (j2 >= 0) {
            if (true ^ h0Var.b) {
                if (h0Var.a.O0() == 0 && h0Var.f15978c.read(h0Var.a, 8192) == -1) {
                    return -1L;
                }
                return h0Var.a.read(mVar, Math.min(j2, h0Var.a.O0()));
            }
            throw new IllegalStateException("closed".toString());
        }
        throw new IllegalArgumentException(("byteCount < 0: " + j2).toString());
    }

    public static final long j(@k.e.a.d h0 h0Var, @k.e.a.d k0 k0Var) {
        long j2 = 0;
        while (h0Var.f15978c.read(h0Var.a, 8192) != -1) {
            long o = h0Var.a.o();
            if (o > 0) {
                j2 += o;
                k0Var.write(h0Var.a, o);
            }
        }
        if (h0Var.a.O0() > 0) {
            long O0 = j2 + h0Var.a.O0();
            m mVar = h0Var.a;
            k0Var.write(mVar, mVar.O0());
            return O0;
        }
        return j2;
    }

    public static final byte k(@k.e.a.d h0 h0Var) {
        h0Var.R(1L);
        return h0Var.a.readByte();
    }

    @k.e.a.d
    public static final byte[] l(@k.e.a.d h0 h0Var) {
        h0Var.a.E(h0Var.f15978c);
        return h0Var.a.Z();
    }

    @k.e.a.d
    public static final byte[] m(@k.e.a.d h0 h0Var, long j2) {
        h0Var.R(j2);
        return h0Var.a.L(j2);
    }

    @k.e.a.d
    public static final ByteString n(@k.e.a.d h0 h0Var) {
        h0Var.a.E(h0Var.f15978c);
        return h0Var.a.j0();
    }

    @k.e.a.d
    public static final ByteString o(@k.e.a.d h0 h0Var, long j2) {
        h0Var.R(j2);
        return h0Var.a.V(j2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x002c, code lost:
        if (r9 == 0) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0053, code lost:
        throw new java.lang.NumberFormatException("Expected leading [0-9] or '-' character but was 0x" + java.lang.Integer.toString(r8, h.t2.b.a(h.t2.b.a(16))));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final long p(@k.e.a.d j.h0 r10) {
        /*
            r0 = 1
            r10.R(r0)
            r2 = 0
            r4 = r2
        L8:
            long r6 = r4 + r0
            boolean r8 = r10.G(r6)
            if (r8 == 0) goto L54
            j.m r8 = r10.a
            byte r8 = r8.m0(r4)
            r9 = 48
            byte r9 = (byte) r9
            if (r8 < r9) goto L20
            r9 = 57
            byte r9 = (byte) r9
            if (r8 <= r9) goto L2a
        L20:
            int r9 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r9 != 0) goto L2c
            r4 = 45
            byte r4 = (byte) r4
            if (r8 == r4) goto L2a
            goto L2c
        L2a:
            r4 = r6
            goto L8
        L2c:
            if (r9 == 0) goto L2f
            goto L54
        L2f:
            java.lang.NumberFormatException r10 = new java.lang.NumberFormatException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Expected leading [0-9] or '-' character but was 0x"
            r0.append(r1)
            r1 = 16
            int r1 = h.t2.b.a(r1)
            int r1 = h.t2.b.a(r1)
            java.lang.String r1 = java.lang.Integer.toString(r8, r1)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r10.<init>(r0)
            throw r10
        L54:
            j.m r10 = r10.a
            long r0 = r10.d0()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: j.q0.d.p(j.h0):long");
    }

    public static final void q(@k.e.a.d h0 h0Var, @k.e.a.d m mVar, long j2) {
        try {
            h0Var.R(j2);
            h0Var.a.h(mVar, j2);
        } catch (EOFException e2) {
            mVar.E(h0Var.a);
            throw e2;
        }
    }

    public static final void r(@k.e.a.d h0 h0Var, @k.e.a.d byte[] bArr) {
        try {
            h0Var.R(bArr.length);
            h0Var.a.readFully(bArr);
        } catch (EOFException e2) {
            int i2 = 0;
            while (h0Var.a.O0() > 0) {
                m mVar = h0Var.a;
                int read = mVar.read(bArr, i2, (int) mVar.O0());
                if (read == -1) {
                    throw new AssertionError();
                }
                i2 += read;
            }
            throw e2;
        }
    }

    public static final long s(@k.e.a.d h0 h0Var) {
        byte m0;
        h0Var.R(1L);
        int i2 = 0;
        while (true) {
            int i3 = i2 + 1;
            if (!h0Var.G(i3)) {
                break;
            }
            m0 = h0Var.a.m0(i2);
            if ((m0 < ((byte) 48) || m0 > ((byte) 57)) && ((m0 < ((byte) 97) || m0 > ((byte) 102)) && (m0 < ((byte) 65) || m0 > ((byte) 70)))) {
                break;
            }
            i2 = i3;
        }
        if (i2 == 0) {
            throw new NumberFormatException("Expected leading [0-9a-fA-F] character but was 0x" + Integer.toString(m0, h.t2.b.a(h.t2.b.a(16))));
        }
        return h0Var.a.w0();
    }

    public static final int t(@k.e.a.d h0 h0Var) {
        h0Var.R(4L);
        return h0Var.a.readInt();
    }

    public static final int u(@k.e.a.d h0 h0Var) {
        h0Var.R(4L);
        return h0Var.a.n0();
    }

    public static final long v(@k.e.a.d h0 h0Var) {
        h0Var.R(8L);
        return h0Var.a.readLong();
    }

    public static final long w(@k.e.a.d h0 h0Var) {
        h0Var.R(8L);
        return h0Var.a.O();
    }

    public static final short x(@k.e.a.d h0 h0Var) {
        h0Var.R(2L);
        return h0Var.a.readShort();
    }

    public static final short y(@k.e.a.d h0 h0Var) {
        h0Var.R(2L);
        return h0Var.a.N();
    }

    @k.e.a.d
    public static final String z(@k.e.a.d h0 h0Var) {
        h0Var.a.E(h0Var.f15978c);
        return h0Var.a.p0();
    }
}
