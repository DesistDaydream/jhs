package j;

import com.tencent.android.tpush.common.MessageKey;
import com.umeng.analytics.pro.am;
import h.q0;
import h.t1;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import okio.ByteString;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 \u001d2\u00020\u0001:\u0001\u0010B\u0019\b\u0010\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aB!\b\u0010\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\u0006\u0010\u001b\u001a\u00020\b\u0012\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001cJ\u001f\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\t\u0010\nR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0014\u001a\u00020\b8G@\u0006¢\u0006\u0006\u001a\u0004\b\u0013\u0010\n¨\u0006\u001e"}, d2 = {"Lj/w;", "Lj/r;", "Lj/m;", "sink", "", "byteCount", "read", "(Lj/m;J)J", "Lokio/ByteString;", "j", "()Lokio/ByteString;", "Ljavax/crypto/Mac;", "b", "Ljavax/crypto/Mac;", "mac", "Ljava/security/MessageDigest;", am.av, "Ljava/security/MessageDigest;", "messageDigest", "k", "hash", "Lj/m0;", MessageKey.MSG_SOURCE, "", "algorithm", "<init>", "(Lj/m0;Ljava/lang/String;)V", "key", "(Lj/m0;Lokio/ByteString;Ljava/lang/String;)V", "c", "okio"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class w extends r {

    /* renamed from: c  reason: collision with root package name */
    public static final a f16013c = new a(null);
    private final MessageDigest a;
    private final Mac b;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\b\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\t\u0010\u0006J\u001f\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0007¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0007¢\u0006\u0004\b\u000e\u0010\rJ\u001f\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0007¢\u0006\u0004\b\u000f\u0010\r¨\u0006\u0012"}, d2 = {"j/w$a", "", "Lj/m0;", MessageKey.MSG_SOURCE, "Lj/w;", e.j.a.b.c.f.f10128d, "(Lj/m0;)Lj/w;", com.huawei.hms.push.e.a, "f", "g", "Lokio/ByteString;", "key", am.av, "(Lj/m0;Lokio/ByteString;)Lj/w;", "b", "c", "<init>", "()V", "okio"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class a {
        private a() {
        }

        @h.k2.k
        @k.e.a.d
        public final w a(@k.e.a.d m0 m0Var, @k.e.a.d ByteString byteString) {
            return new w(m0Var, byteString, "HmacSHA1");
        }

        @h.k2.k
        @k.e.a.d
        public final w b(@k.e.a.d m0 m0Var, @k.e.a.d ByteString byteString) {
            return new w(m0Var, byteString, "HmacSHA256");
        }

        @h.k2.k
        @k.e.a.d
        public final w c(@k.e.a.d m0 m0Var, @k.e.a.d ByteString byteString) {
            return new w(m0Var, byteString, "HmacSHA512");
        }

        @h.k2.k
        @k.e.a.d
        public final w d(@k.e.a.d m0 m0Var) {
            return new w(m0Var, "MD5");
        }

        @h.k2.k
        @k.e.a.d
        public final w e(@k.e.a.d m0 m0Var) {
            return new w(m0Var, "SHA-1");
        }

        @h.k2.k
        @k.e.a.d
        public final w f(@k.e.a.d m0 m0Var) {
            return new w(m0Var, "SHA-256");
        }

        @h.k2.k
        @k.e.a.d
        public final w g(@k.e.a.d m0 m0Var) {
            return new w(m0Var, "SHA-512");
        }

        public /* synthetic */ a(h.k2.v.u uVar) {
            this();
        }
    }

    public w(@k.e.a.d m0 m0Var, @k.e.a.d String str) {
        super(m0Var);
        this.a = MessageDigest.getInstance(str);
        this.b = null;
    }

    @h.k2.k
    @k.e.a.d
    public static final w l(@k.e.a.d m0 m0Var, @k.e.a.d ByteString byteString) {
        return f16013c.a(m0Var, byteString);
    }

    @h.k2.k
    @k.e.a.d
    public static final w n(@k.e.a.d m0 m0Var, @k.e.a.d ByteString byteString) {
        return f16013c.b(m0Var, byteString);
    }

    @h.k2.k
    @k.e.a.d
    public static final w o(@k.e.a.d m0 m0Var, @k.e.a.d ByteString byteString) {
        return f16013c.c(m0Var, byteString);
    }

    @h.k2.k
    @k.e.a.d
    public static final w q(@k.e.a.d m0 m0Var) {
        return f16013c.d(m0Var);
    }

    @h.k2.k
    @k.e.a.d
    public static final w r(@k.e.a.d m0 m0Var) {
        return f16013c.e(m0Var);
    }

    @h.k2.k
    @k.e.a.d
    public static final w s(@k.e.a.d m0 m0Var) {
        return f16013c.f(m0Var);
    }

    @h.k2.k
    @k.e.a.d
    public static final w t(@k.e.a.d m0 m0Var) {
        return f16013c.g(m0Var);
    }

    @h.k2.g(name = "-deprecated_hash")
    @h.i(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @q0(expression = "hash", imports = {}))
    @k.e.a.d
    public final ByteString j() {
        return k();
    }

    @h.k2.g(name = "hash")
    @k.e.a.d
    public final ByteString k() {
        MessageDigest messageDigest = this.a;
        return new ByteString(messageDigest != null ? messageDigest.digest() : this.b.doFinal());
    }

    @Override // j.r, j.m0
    public long read(@k.e.a.d m mVar, long j2) throws IOException {
        long read = super.read(mVar, j2);
        if (read != -1) {
            long O0 = mVar.O0() - read;
            long O02 = mVar.O0();
            i0 i0Var = mVar.a;
            while (O02 > O0) {
                i0Var = i0Var.f15986g;
                O02 -= i0Var.f15982c - i0Var.b;
            }
            while (O02 < mVar.O0()) {
                int i2 = (int) ((i0Var.b + O0) - O02);
                MessageDigest messageDigest = this.a;
                if (messageDigest != null) {
                    messageDigest.update(i0Var.a, i2, i0Var.f15982c - i2);
                } else {
                    this.b.update(i0Var.a, i2, i0Var.f15982c - i2);
                }
                O02 += i0Var.f15982c - i0Var.b;
                i0Var = i0Var.f15985f;
                O0 = O02;
            }
        }
        return read;
    }

    public w(@k.e.a.d m0 m0Var, @k.e.a.d ByteString byteString, @k.e.a.d String str) {
        super(m0Var);
        try {
            Mac mac = Mac.getInstance(str);
            mac.init(new SecretKeySpec(byteString.toByteArray(), str));
            t1 t1Var = t1.a;
            this.b = mac;
            this.a = null;
        } catch (InvalidKeyException e2) {
            throw new IllegalArgumentException(e2);
        }
    }
}
