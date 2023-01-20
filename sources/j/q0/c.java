package j.q0;

import com.baidu.mobads.sdk.api.IAdInterListener;
import com.meizu.cloud.pushsdk.notification.model.NotifyType;
import com.tencent.android.tpush.common.MessageKey;
import com.umeng.analytics.pro.am;
import j.g0;
import j.k0;
import j.m;
import j.m0;
import j.n;
import j.o0;
import java.io.EOFException;
import kotlin.Metadata;
import okio.ByteString;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a$\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003H\u0080\b¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u001c\u0010\u000b\u001a\u00020\n*\u00020\u00002\u0006\u0010\t\u001a\u00020\bH\u0080\b¢\u0006\u0004\b\u000b\u0010\f\u001a,\u0010\u000f\u001a\u00020\n*\u00020\u00002\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\rH\u0080\b¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u001c\u0010\u0013\u001a\u00020\n*\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0011H\u0080\b¢\u0006\u0004\b\u0013\u0010\u0014\u001a,\u0010\u0017\u001a\u00020\n*\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\rH\u0080\b¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u001c\u0010\u001a\u001a\u00020\n*\u00020\u00002\u0006\u0010\u0019\u001a\u00020\rH\u0080\b¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u001c\u0010\u001d\u001a\u00020\n*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u001cH\u0080\b¢\u0006\u0004\b\u001d\u0010\u001e\u001a,\u0010\u001f\u001a\u00020\n*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u001c2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\rH\u0080\b¢\u0006\u0004\b\u001f\u0010 \u001a\u001c\u0010\"\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020!H\u0080\b¢\u0006\u0004\b\"\u0010#\u001a$\u0010$\u001a\u00020\n*\u00020\u00002\u0006\u0010\u0002\u001a\u00020!2\u0006\u0010\u0004\u001a\u00020\u0003H\u0080\b¢\u0006\u0004\b$\u0010%\u001a\u001c\u0010'\u001a\u00020\n*\u00020\u00002\u0006\u0010&\u001a\u00020\rH\u0080\b¢\u0006\u0004\b'\u0010\u001b\u001a\u001c\u0010)\u001a\u00020\n*\u00020\u00002\u0006\u0010(\u001a\u00020\rH\u0080\b¢\u0006\u0004\b)\u0010\u001b\u001a\u001c\u0010*\u001a\u00020\n*\u00020\u00002\u0006\u0010(\u001a\u00020\rH\u0080\b¢\u0006\u0004\b*\u0010\u001b\u001a\u001c\u0010+\u001a\u00020\n*\u00020\u00002\u0006\u0010$\u001a\u00020\rH\u0080\b¢\u0006\u0004\b+\u0010\u001b\u001a\u001c\u0010,\u001a\u00020\n*\u00020\u00002\u0006\u0010$\u001a\u00020\rH\u0080\b¢\u0006\u0004\b,\u0010\u001b\u001a\u001c\u0010(\u001a\u00020\n*\u00020\u00002\u0006\u0010*\u001a\u00020\u0003H\u0080\b¢\u0006\u0004\b(\u0010-\u001a\u001c\u0010.\u001a\u00020\n*\u00020\u00002\u0006\u0010*\u001a\u00020\u0003H\u0080\b¢\u0006\u0004\b.\u0010-\u001a\u001c\u0010/\u001a\u00020\n*\u00020\u00002\u0006\u0010*\u001a\u00020\u0003H\u0080\b¢\u0006\u0004\b/\u0010-\u001a\u001c\u00100\u001a\u00020\n*\u00020\u00002\u0006\u0010*\u001a\u00020\u0003H\u0080\b¢\u0006\u0004\b0\u0010-\u001a\u0014\u00101\u001a\u00020\n*\u00020\u0000H\u0080\b¢\u0006\u0004\b1\u00102\u001a\u0014\u0010&\u001a\u00020\n*\u00020\u0000H\u0080\b¢\u0006\u0004\b&\u00102\u001a\u0014\u00103\u001a\u00020\u0005*\u00020\u0000H\u0080\b¢\u0006\u0004\b3\u00104\u001a\u0014\u00105\u001a\u00020\u0005*\u00020\u0000H\u0080\b¢\u0006\u0004\b5\u00104\u001a\u0014\u00107\u001a\u000206*\u00020\u0000H\u0080\b¢\u0006\u0004\b7\u00108\u001a\u0014\u00109\u001a\u00020\u0011*\u00020\u0000H\u0080\b¢\u0006\u0004\b9\u0010:¨\u0006;"}, d2 = {"Lj/g0;", "Lj/m;", MessageKey.MSG_SOURCE, "", "byteCount", "Lh/t1;", NotifyType.LIGHTS, "(Lj/g0;Lj/m;J)V", "Lokio/ByteString;", "byteString", "Lj/n;", "g", "(Lj/g0;Lokio/ByteString;)Lj/n;", "", "offset", "h", "(Lj/g0;Lokio/ByteString;II)Lj/n;", "", "string", IAdInterListener.AdReqParam.WIDTH, "(Lj/g0;Ljava/lang/String;)Lj/n;", "beginIndex", "endIndex", "x", "(Lj/g0;Ljava/lang/String;II)Lj/n;", "codePoint", "y", "(Lj/g0;I)Lj/n;", "", "j", "(Lj/g0;[B)Lj/n;", "k", "(Lj/g0;[BII)Lj/n;", "Lj/m0;", "m", "(Lj/g0;Lj/m0;)J", "i", "(Lj/g0;Lj/m0;J)Lj/n;", "b", "n", "s", am.aH, "v", "q", "r", "(Lj/g0;J)Lj/n;", am.aI, "o", am.ax, "c", "(Lj/g0;)Lj/n;", e.j.a.b.c.f.f10128d, "(Lj/g0;)V", am.av, "Lj/o0;", com.huawei.hms.push.e.a, "(Lj/g0;)Lj/o0;", "f", "(Lj/g0;)Ljava/lang/String;", "okio"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class c {
    public static final void a(@k.e.a.d g0 g0Var) {
        if (g0Var.b) {
            return;
        }
        Throwable th = null;
        try {
            if (g0Var.a.O0() > 0) {
                k0 k0Var = g0Var.f15977c;
                m mVar = g0Var.a;
                k0Var.write(mVar, mVar.O0());
            }
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            g0Var.f15977c.close();
        } catch (Throwable th3) {
            if (th == null) {
                th = th3;
            }
        }
        g0Var.b = true;
        if (th != null) {
            throw th;
        }
    }

    @k.e.a.d
    public static final n b(@k.e.a.d g0 g0Var) {
        if (!g0Var.b) {
            long O0 = g0Var.a.O0();
            if (O0 > 0) {
                g0Var.f15977c.write(g0Var.a, O0);
            }
            return g0Var;
        }
        throw new IllegalStateException("closed".toString());
    }

    @k.e.a.d
    public static final n c(@k.e.a.d g0 g0Var) {
        if (!g0Var.b) {
            long o = g0Var.a.o();
            if (o > 0) {
                g0Var.f15977c.write(g0Var.a, o);
            }
            return g0Var;
        }
        throw new IllegalStateException("closed".toString());
    }

    public static final void d(@k.e.a.d g0 g0Var) {
        if (!g0Var.b) {
            if (g0Var.a.O0() > 0) {
                k0 k0Var = g0Var.f15977c;
                m mVar = g0Var.a;
                k0Var.write(mVar, mVar.O0());
            }
            g0Var.f15977c.flush();
            return;
        }
        throw new IllegalStateException("closed".toString());
    }

    @k.e.a.d
    public static final o0 e(@k.e.a.d g0 g0Var) {
        return g0Var.f15977c.timeout();
    }

    @k.e.a.d
    public static final String f(@k.e.a.d g0 g0Var) {
        return "buffer(" + g0Var.f15977c + ')';
    }

    @k.e.a.d
    public static final n g(@k.e.a.d g0 g0Var, @k.e.a.d ByteString byteString) {
        if (!g0Var.b) {
            g0Var.a.r0(byteString);
            return g0Var.z();
        }
        throw new IllegalStateException("closed".toString());
    }

    @k.e.a.d
    public static final n h(@k.e.a.d g0 g0Var, @k.e.a.d ByteString byteString, int i2, int i3) {
        if (!g0Var.b) {
            g0Var.a.W(byteString, i2, i3);
            return g0Var.z();
        }
        throw new IllegalStateException("closed".toString());
    }

    @k.e.a.d
    public static final n i(@k.e.a.d g0 g0Var, @k.e.a.d m0 m0Var, long j2) {
        while (j2 > 0) {
            long read = m0Var.read(g0Var.a, j2);
            if (read != -1) {
                j2 -= read;
                g0Var.z();
            } else {
                throw new EOFException();
            }
        }
        return g0Var;
    }

    @k.e.a.d
    public static final n j(@k.e.a.d g0 g0Var, @k.e.a.d byte[] bArr) {
        if (!g0Var.b) {
            g0Var.a.write(bArr);
            return g0Var.z();
        }
        throw new IllegalStateException("closed".toString());
    }

    @k.e.a.d
    public static final n k(@k.e.a.d g0 g0Var, @k.e.a.d byte[] bArr, int i2, int i3) {
        if (!g0Var.b) {
            g0Var.a.write(bArr, i2, i3);
            return g0Var.z();
        }
        throw new IllegalStateException("closed".toString());
    }

    public static final void l(@k.e.a.d g0 g0Var, @k.e.a.d m mVar, long j2) {
        if (!g0Var.b) {
            g0Var.a.write(mVar, j2);
            g0Var.z();
            return;
        }
        throw new IllegalStateException("closed".toString());
    }

    public static final long m(@k.e.a.d g0 g0Var, @k.e.a.d m0 m0Var) {
        long j2 = 0;
        while (true) {
            long read = m0Var.read(g0Var.a, 8192);
            if (read == -1) {
                return j2;
            }
            j2 += read;
            g0Var.z();
        }
    }

    @k.e.a.d
    public static final n n(@k.e.a.d g0 g0Var, int i2) {
        if (!g0Var.b) {
            g0Var.a.writeByte(i2);
            return g0Var.z();
        }
        throw new IllegalStateException("closed".toString());
    }

    @k.e.a.d
    public static final n o(@k.e.a.d g0 g0Var, long j2) {
        if (!g0Var.b) {
            g0Var.a.S(j2);
            return g0Var.z();
        }
        throw new IllegalStateException("closed".toString());
    }

    @k.e.a.d
    public static final n p(@k.e.a.d g0 g0Var, long j2) {
        if (!g0Var.b) {
            g0Var.a.i0(j2);
            return g0Var.z();
        }
        throw new IllegalStateException("closed".toString());
    }

    @k.e.a.d
    public static final n q(@k.e.a.d g0 g0Var, int i2) {
        if (!g0Var.b) {
            g0Var.a.writeInt(i2);
            return g0Var.z();
        }
        throw new IllegalStateException("closed".toString());
    }

    @k.e.a.d
    public static final n r(@k.e.a.d g0 g0Var, int i2) {
        if (!g0Var.b) {
            g0Var.a.a0(i2);
            return g0Var.z();
        }
        throw new IllegalStateException("closed".toString());
    }

    @k.e.a.d
    public static final n s(@k.e.a.d g0 g0Var, long j2) {
        if (!g0Var.b) {
            g0Var.a.t0(j2);
            return g0Var.z();
        }
        throw new IllegalStateException("closed".toString());
    }

    @k.e.a.d
    public static final n t(@k.e.a.d g0 g0Var, long j2) {
        if (!g0Var.b) {
            g0Var.a.x(j2);
            return g0Var.z();
        }
        throw new IllegalStateException("closed".toString());
    }

    @k.e.a.d
    public static final n u(@k.e.a.d g0 g0Var, int i2) {
        if (!g0Var.b) {
            g0Var.a.writeShort(i2);
            return g0Var.z();
        }
        throw new IllegalStateException("closed".toString());
    }

    @k.e.a.d
    public static final n v(@k.e.a.d g0 g0Var, int i2) {
        if (!g0Var.b) {
            g0Var.a.e0(i2);
            return g0Var.z();
        }
        throw new IllegalStateException("closed".toString());
    }

    @k.e.a.d
    public static final n w(@k.e.a.d g0 g0Var, @k.e.a.d String str) {
        if (!g0Var.b) {
            g0Var.a.B(str);
            return g0Var.z();
        }
        throw new IllegalStateException("closed".toString());
    }

    @k.e.a.d
    public static final n x(@k.e.a.d g0 g0Var, @k.e.a.d String str, int i2, int i3) {
        if (!g0Var.b) {
            g0Var.a.D(str, i2, i3);
            return g0Var.z();
        }
        throw new IllegalStateException("closed".toString());
    }

    @k.e.a.d
    public static final n y(@k.e.a.d g0 g0Var, int i2) {
        if (!g0Var.b) {
            g0Var.a.w(i2);
            return g0Var.z();
        }
        throw new IllegalStateException("closed".toString());
    }
}
