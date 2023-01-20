package okhttp3;

import h.i;
import h.k2.g;
import h.k2.k;
import h.k2.v.u;
import h.q0;
import k.e.a.d;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import org.conscrypt.NativeCrypto;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u0011\b\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\u0005\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004R\u0019\u0010\u0005\u001a\u00020\u00028\u0007@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0005\u0010\u0004j\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lokhttp3/TlsVersion;", "", "", "-deprecated_javaName", "()Ljava/lang/String;", "javaName", "Ljava/lang/String;", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "Companion", "TLS_1_3", "TLS_1_2", "TLS_1_1", "TLS_1_0", "SSL_3_0", "okhttp"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public enum TlsVersion {
    TLS_1_3(NativeCrypto.SUPPORTED_PROTOCOL_TLSV1_3),
    TLS_1_2("TLSv1.2"),
    TLS_1_1("TLSv1.1"),
    TLS_1_0("TLSv1"),
    SSL_3_0(NativeCrypto.OBSOLETE_PROTOCOL_SSLV3);
    
    public static final Companion Companion = new Companion(null);
    @d
    private final String javaName;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lokhttp3/TlsVersion$Companion;", "", "", "javaName", "Lokhttp3/TlsVersion;", "forJavaName", "(Ljava/lang/String;)Lokhttp3/TlsVersion;", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class Companion {
        private Companion() {
        }

        @k
        @d
        public final TlsVersion forJavaName(@d String str) {
            int hashCode = str.hashCode();
            if (hashCode != 79201641) {
                if (hashCode != 79923350) {
                    switch (hashCode) {
                        case -503070503:
                            if (str.equals("TLSv1.1")) {
                                return TlsVersion.TLS_1_1;
                            }
                            break;
                        case -503070502:
                            if (str.equals("TLSv1.2")) {
                                return TlsVersion.TLS_1_2;
                            }
                            break;
                        case -503070501:
                            if (str.equals(NativeCrypto.SUPPORTED_PROTOCOL_TLSV1_3)) {
                                return TlsVersion.TLS_1_3;
                            }
                            break;
                    }
                } else if (str.equals("TLSv1")) {
                    return TlsVersion.TLS_1_0;
                }
            } else if (str.equals(NativeCrypto.OBSOLETE_PROTOCOL_SSLV3)) {
                return TlsVersion.SSL_3_0;
            }
            throw new IllegalArgumentException("Unexpected TLS version: " + str);
        }

        public /* synthetic */ Companion(u uVar) {
            this();
        }
    }

    TlsVersion(String str) {
        this.javaName = str;
    }

    @k
    @d
    public static final TlsVersion forJavaName(@d String str) {
        return Companion.forJavaName(str);
    }

    @g(name = "-deprecated_javaName")
    @i(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @q0(expression = "javaName", imports = {}))
    @d
    /* renamed from: -deprecated_javaName  reason: not valid java name */
    public final String m251deprecated_javaName() {
        return this.javaName;
    }

    @g(name = "javaName")
    @d
    public final String javaName() {
        return this.javaName;
    }
}
