package okhttp3;

import h.k2.k;
import h.k2.v.f0;
import h.k2.v.u;
import java.io.IOException;
import k.e.a.d;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u0011\b\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006j\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lokhttp3/Protocol;", "", "", "toString", "()Ljava/lang/String;", "protocol", "Ljava/lang/String;", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "Companion", "HTTP_1_0", "HTTP_1_1", "SPDY_3", "HTTP_2", "H2_PRIOR_KNOWLEDGE", "QUIC", "okhttp"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public enum Protocol {
    HTTP_1_0("http/1.0"),
    HTTP_1_1("http/1.1"),
    SPDY_3("spdy/3.1"),
    HTTP_2("h2"),
    H2_PRIOR_KNOWLEDGE("h2_prior_knowledge"),
    QUIC("quic");
    
    public static final Companion Companion = new Companion(null);
    private final String protocol;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lokhttp3/Protocol$Companion;", "", "", "protocol", "Lokhttp3/Protocol;", "get", "(Ljava/lang/String;)Lokhttp3/Protocol;", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class Companion {
        private Companion() {
        }

        @k
        @d
        public final Protocol get(@d String str) throws IOException {
            Protocol protocol = Protocol.HTTP_1_0;
            if (!f0.g(str, protocol.protocol)) {
                protocol = Protocol.HTTP_1_1;
                if (!f0.g(str, protocol.protocol)) {
                    protocol = Protocol.H2_PRIOR_KNOWLEDGE;
                    if (!f0.g(str, protocol.protocol)) {
                        protocol = Protocol.HTTP_2;
                        if (!f0.g(str, protocol.protocol)) {
                            protocol = Protocol.SPDY_3;
                            if (!f0.g(str, protocol.protocol)) {
                                protocol = Protocol.QUIC;
                                if (!f0.g(str, protocol.protocol)) {
                                    throw new IOException("Unexpected protocol: " + str);
                                }
                            }
                        }
                    }
                }
            }
            return protocol;
        }

        public /* synthetic */ Companion(u uVar) {
            this();
        }
    }

    Protocol(String str) {
        this.protocol = str;
    }

    @k
    @d
    public static final Protocol get(@d String str) throws IOException {
        return Companion.get(str);
    }

    @Override // java.lang.Enum
    @d
    public String toString() {
        return this.protocol;
    }
}
