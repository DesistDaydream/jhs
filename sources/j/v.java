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

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 \u001e2\u00020\u0001:\u0001\u0013B\u0019\b\u0010\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bB!\b\u0010\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\u0006\u0010\u001c\u001a\u00020\t\u0012\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001dJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0007¢\u0006\u0004\b\n\u0010\u000bR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0013\u0010\u0011\u001a\u00020\t8G@\u0006¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u000bR\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u001f"}, d2 = {"Lj/v;", "Lj/q;", "Lj/m;", MessageKey.MSG_SOURCE, "", "byteCount", "Lh/t1;", "write", "(Lj/m;J)V", "Lokio/ByteString;", "j", "()Lokio/ByteString;", "Ljavax/crypto/Mac;", "b", "Ljavax/crypto/Mac;", "mac", "k", "hash", "Ljava/security/MessageDigest;", am.av, "Ljava/security/MessageDigest;", "messageDigest", "Lj/k0;", "sink", "", "algorithm", "<init>", "(Lj/k0;Ljava/lang/String;)V", "key", "(Lj/k0;Lokio/ByteString;Ljava/lang/String;)V", "c", "okio"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class v extends q {

    /* renamed from: c  reason: collision with root package name */
    public static final a f16012c = new a(null);
    private final MessageDigest a;
    private final Mac b;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\b\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\t\u0010\u0006J\u001f\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0007¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0007¢\u0006\u0004\b\u000e\u0010\rJ\u001f\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0007¢\u0006\u0004\b\u000f\u0010\r¨\u0006\u0012"}, d2 = {"j/v$a", "", "Lj/k0;", "sink", "Lj/v;", e.j.a.b.c.f.f10128d, "(Lj/k0;)Lj/v;", com.huawei.hms.push.e.a, "f", "g", "Lokio/ByteString;", "key", am.av, "(Lj/k0;Lokio/ByteString;)Lj/v;", "b", "c", "<init>", "()V", "okio"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class a {
        private a() {
        }

        @h.k2.k
        @k.e.a.d
        public final v a(@k.e.a.d k0 k0Var, @k.e.a.d ByteString byteString) {
            return new v(k0Var, byteString, "HmacSHA1");
        }

        @h.k2.k
        @k.e.a.d
        public final v b(@k.e.a.d k0 k0Var, @k.e.a.d ByteString byteString) {
            return new v(k0Var, byteString, "HmacSHA256");
        }

        @h.k2.k
        @k.e.a.d
        public final v c(@k.e.a.d k0 k0Var, @k.e.a.d ByteString byteString) {
            return new v(k0Var, byteString, "HmacSHA512");
        }

        @h.k2.k
        @k.e.a.d
        public final v d(@k.e.a.d k0 k0Var) {
            return new v(k0Var, "MD5");
        }

        @h.k2.k
        @k.e.a.d
        public final v e(@k.e.a.d k0 k0Var) {
            return new v(k0Var, "SHA-1");
        }

        @h.k2.k
        @k.e.a.d
        public final v f(@k.e.a.d k0 k0Var) {
            return new v(k0Var, "SHA-256");
        }

        @h.k2.k
        @k.e.a.d
        public final v g(@k.e.a.d k0 k0Var) {
            return new v(k0Var, "SHA-512");
        }

        public /* synthetic */ a(h.k2.v.u uVar) {
            this();
        }
    }

    public v(@k.e.a.d k0 k0Var, @k.e.a.d String str) {
        super(k0Var);
        this.a = MessageDigest.getInstance(str);
        this.b = null;
    }

    @h.k2.k
    @k.e.a.d
    public static final v l(@k.e.a.d k0 k0Var, @k.e.a.d ByteString byteString) {
        return f16012c.a(k0Var, byteString);
    }

    @h.k2.k
    @k.e.a.d
    public static final v n(@k.e.a.d k0 k0Var, @k.e.a.d ByteString byteString) {
        return f16012c.b(k0Var, byteString);
    }

    @h.k2.k
    @k.e.a.d
    public static final v o(@k.e.a.d k0 k0Var, @k.e.a.d ByteString byteString) {
        return f16012c.c(k0Var, byteString);
    }

    @h.k2.k
    @k.e.a.d
    public static final v q(@k.e.a.d k0 k0Var) {
        return f16012c.d(k0Var);
    }

    @h.k2.k
    @k.e.a.d
    public static final v r(@k.e.a.d k0 k0Var) {
        return f16012c.e(k0Var);
    }

    @h.k2.k
    @k.e.a.d
    public static final v s(@k.e.a.d k0 k0Var) {
        return f16012c.f(k0Var);
    }

    @h.k2.k
    @k.e.a.d
    public static final v t(@k.e.a.d k0 k0Var) {
        return f16012c.g(k0Var);
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

    @Override // j.q, j.k0
    public void write(@k.e.a.d m mVar, long j2) throws IOException {
        j.e(mVar.O0(), 0L, j2);
        i0 i0Var = mVar.a;
        long j3 = 0;
        while (j3 < j2) {
            int min = (int) Math.min(j2 - j3, i0Var.f15982c - i0Var.b);
            MessageDigest messageDigest = this.a;
            if (messageDigest != null) {
                messageDigest.update(i0Var.a, i0Var.b, min);
            } else {
                this.b.update(i0Var.a, i0Var.b, min);
            }
            j3 += min;
            i0Var = i0Var.f15985f;
        }
        super.write(mVar, j2);
    }

    public v(@k.e.a.d k0 k0Var, @k.e.a.d ByteString byteString, @k.e.a.d String str) {
        super(k0Var);
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
