package okhttp3;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import h.i;
import h.k2.g;
import h.k2.k;
import h.k2.u.a;
import h.k2.v.f0;
import h.k2.v.u;
import h.q0;
import h.w;
import h.z;
import java.io.IOException;
import java.security.Principal;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import k.e.a.d;
import k.e.a.e;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import okhttp3.internal.Util;
import org.conscrypt.SSLNullSession;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 -2\u00020\u0001:\u0001-B;\b\u0000\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0012\u0010*\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0)¢\u0006\u0004\b+\u0010,J\u000f\u0010\u0005\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\t\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0007¢\u0006\u0004\b\f\u0010\rJ\u0011\u0010\u0012\u001a\u0004\u0018\u00010\u000fH\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0007¢\u0006\u0004\b\u0013\u0010\rJ\u0011\u0010\u0016\u001a\u0004\u0018\u00010\u000fH\u0007¢\u0006\u0004\b\u0015\u0010\u0011J\u001a\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b\u001f\u0010 R\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u000f8G@\u0006¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0011R\u001f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0007@\u0006¢\u0006\f\n\u0004\b\u0014\u0010!\u001a\u0004\b\u0014\u0010\rR\u0019\u0010\t\u001a\u00020\u00068\u0007@\u0006¢\u0006\f\n\u0004\b\t\u0010\"\u001a\u0004\b\t\u0010\bR\u0015\u0010\u0016\u001a\u0004\u0018\u00010\u000f8G@\u0006¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0011R\u0019\u0010\u0005\u001a\u00020\u00028\u0007@\u0006¢\u0006\f\n\u0004\b\u0005\u0010#\u001a\u0004\b\u0005\u0010\u0004R\u001a\u0010&\u001a\u00020\u001e*\u00020\u000b8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%R#\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8G@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b\u000e\u0010\r¨\u0006."}, d2 = {"Lokhttp3/Handshake;", "", "Lokhttp3/TlsVersion;", "-deprecated_tlsVersion", "()Lokhttp3/TlsVersion;", "tlsVersion", "Lokhttp3/CipherSuite;", "-deprecated_cipherSuite", "()Lokhttp3/CipherSuite;", "cipherSuite", "", "Ljava/security/cert/Certificate;", "-deprecated_peerCertificates", "()Ljava/util/List;", "peerCertificates", "Ljava/security/Principal;", "-deprecated_peerPrincipal", "()Ljava/security/Principal;", "peerPrincipal", "-deprecated_localCertificates", "localCertificates", "-deprecated_localPrincipal", "localPrincipal", "other", "", "equals", "(Ljava/lang/Object;)Z", "", TTDownloadField.TT_HASHCODE, "()I", "", "toString", "()Ljava/lang/String;", "Ljava/util/List;", "Lokhttp3/CipherSuite;", "Lokhttp3/TlsVersion;", "getName", "(Ljava/security/cert/Certificate;)Ljava/lang/String;", "name", "peerCertificates$delegate", "Lh/w;", "Lkotlin/Function0;", "peerCertificatesFn", "<init>", "(Lokhttp3/TlsVersion;Lokhttp3/CipherSuite;Ljava/util/List;Lh/k2/u/a;)V", "Companion", "okhttp"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class Handshake {
    public static final Companion Companion = new Companion(null);
    @d
    private final CipherSuite cipherSuite;
    @d
    private final List<Certificate> localCertificates;
    @d
    private final w peerCertificates$delegate;
    @d
    private final TlsVersion tlsVersion;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0015\u0010\u0016J#\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0004*\f\u0012\u0006\b\u0001\u0012\u00020\u0003\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\u000b\u001a\u00020\b*\u00020\u0007H\u0007¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\r\u0010\nJ;\u0010\t\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u00042\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u0004H\u0007¢\u0006\u0004\b\t\u0010\u0014¨\u0006\u0017"}, d2 = {"Lokhttp3/Handshake$Companion;", "", "", "Ljava/security/cert/Certificate;", "", "toImmutableList", "([Ljava/security/cert/Certificate;)Ljava/util/List;", "Ljavax/net/ssl/SSLSession;", "Lokhttp3/Handshake;", "get", "(Ljavax/net/ssl/SSLSession;)Lokhttp3/Handshake;", "handshake", "sslSession", "-deprecated_get", "Lokhttp3/TlsVersion;", "tlsVersion", "Lokhttp3/CipherSuite;", "cipherSuite", "peerCertificates", "localCertificates", "(Lokhttp3/TlsVersion;Lokhttp3/CipherSuite;Ljava/util/List;Ljava/util/List;)Lokhttp3/Handshake;", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class Companion {
        private Companion() {
        }

        private final List<Certificate> toImmutableList(Certificate[] certificateArr) {
            if (certificateArr != null) {
                return Util.immutableListOf((Certificate[]) Arrays.copyOf(certificateArr, certificateArr.length));
            }
            return CollectionsKt__CollectionsKt.E();
        }

        @g(name = "-deprecated_get")
        @i(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @q0(expression = "sslSession.handshake()", imports = {}))
        @d
        /* renamed from: -deprecated_get  reason: not valid java name */
        public final Handshake m165deprecated_get(@d SSLSession sSLSession) throws IOException {
            return get(sSLSession);
        }

        @g(name = "get")
        @k
        @d
        public final Handshake get(@d SSLSession sSLSession) throws IOException {
            List<Certificate> E;
            String cipherSuite = sSLSession.getCipherSuite();
            if (cipherSuite != null) {
                int hashCode = cipherSuite.hashCode();
                if (hashCode == 1019404634 ? !cipherSuite.equals("TLS_NULL_WITH_NULL_NULL") : !(hashCode == 1208658923 && cipherSuite.equals(SSLNullSession.INVALID_CIPHER))) {
                    CipherSuite forJavaName = CipherSuite.Companion.forJavaName(cipherSuite);
                    String protocol = sSLSession.getProtocol();
                    if (protocol != null) {
                        if (!f0.g("NONE", protocol)) {
                            TlsVersion forJavaName2 = TlsVersion.Companion.forJavaName(protocol);
                            try {
                                E = toImmutableList(sSLSession.getPeerCertificates());
                            } catch (SSLPeerUnverifiedException unused) {
                                E = CollectionsKt__CollectionsKt.E();
                            }
                            return new Handshake(forJavaName2, forJavaName, toImmutableList(sSLSession.getLocalCertificates()), new Handshake$Companion$handshake$1(E));
                        }
                        throw new IOException("tlsVersion == NONE");
                    }
                    throw new IllegalStateException("tlsVersion == null".toString());
                }
                throw new IOException("cipherSuite == " + cipherSuite);
            }
            throw new IllegalStateException("cipherSuite == null".toString());
        }

        public /* synthetic */ Companion(u uVar) {
            this();
        }

        @k
        @d
        public final Handshake get(@d TlsVersion tlsVersion, @d CipherSuite cipherSuite, @d List<? extends Certificate> list, @d List<? extends Certificate> list2) {
            return new Handshake(tlsVersion, cipherSuite, Util.toImmutableList(list2), new Handshake$Companion$get$1(Util.toImmutableList(list)));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Handshake(@d TlsVersion tlsVersion, @d CipherSuite cipherSuite, @d List<? extends Certificate> list, @d a<? extends List<? extends Certificate>> aVar) {
        this.tlsVersion = tlsVersion;
        this.cipherSuite = cipherSuite;
        this.localCertificates = list;
        this.peerCertificates$delegate = z.c(new Handshake$peerCertificates$2(aVar));
    }

    @g(name = "get")
    @k
    @d
    public static final Handshake get(@d SSLSession sSLSession) throws IOException {
        return Companion.get(sSLSession);
    }

    @k
    @d
    public static final Handshake get(@d TlsVersion tlsVersion, @d CipherSuite cipherSuite, @d List<? extends Certificate> list, @d List<? extends Certificate> list2) {
        return Companion.get(tlsVersion, cipherSuite, list, list2);
    }

    private final String getName(Certificate certificate) {
        return certificate instanceof X509Certificate ? ((X509Certificate) certificate).getSubjectDN().toString() : certificate.getType();
    }

    @g(name = "-deprecated_cipherSuite")
    @i(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @q0(expression = "cipherSuite", imports = {}))
    @d
    /* renamed from: -deprecated_cipherSuite  reason: not valid java name */
    public final CipherSuite m159deprecated_cipherSuite() {
        return this.cipherSuite;
    }

    @g(name = "-deprecated_localCertificates")
    @i(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @q0(expression = "localCertificates", imports = {}))
    @d
    /* renamed from: -deprecated_localCertificates  reason: not valid java name */
    public final List<Certificate> m160deprecated_localCertificates() {
        return this.localCertificates;
    }

    @g(name = "-deprecated_localPrincipal")
    @e
    @i(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @q0(expression = "localPrincipal", imports = {}))
    /* renamed from: -deprecated_localPrincipal  reason: not valid java name */
    public final Principal m161deprecated_localPrincipal() {
        return localPrincipal();
    }

    @g(name = "-deprecated_peerCertificates")
    @i(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @q0(expression = "peerCertificates", imports = {}))
    @d
    /* renamed from: -deprecated_peerCertificates  reason: not valid java name */
    public final List<Certificate> m162deprecated_peerCertificates() {
        return peerCertificates();
    }

    @g(name = "-deprecated_peerPrincipal")
    @e
    @i(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @q0(expression = "peerPrincipal", imports = {}))
    /* renamed from: -deprecated_peerPrincipal  reason: not valid java name */
    public final Principal m163deprecated_peerPrincipal() {
        return peerPrincipal();
    }

    @g(name = "-deprecated_tlsVersion")
    @i(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @q0(expression = "tlsVersion", imports = {}))
    @d
    /* renamed from: -deprecated_tlsVersion  reason: not valid java name */
    public final TlsVersion m164deprecated_tlsVersion() {
        return this.tlsVersion;
    }

    @g(name = "cipherSuite")
    @d
    public final CipherSuite cipherSuite() {
        return this.cipherSuite;
    }

    public boolean equals(@e Object obj) {
        if (obj instanceof Handshake) {
            Handshake handshake = (Handshake) obj;
            if (handshake.tlsVersion == this.tlsVersion && f0.g(handshake.cipherSuite, this.cipherSuite) && f0.g(handshake.peerCertificates(), peerCertificates()) && f0.g(handshake.localCertificates, this.localCertificates)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((((527 + this.tlsVersion.hashCode()) * 31) + this.cipherSuite.hashCode()) * 31) + peerCertificates().hashCode()) * 31) + this.localCertificates.hashCode();
    }

    @g(name = "localCertificates")
    @d
    public final List<Certificate> localCertificates() {
        return this.localCertificates;
    }

    @g(name = "localPrincipal")
    @e
    public final Principal localPrincipal() {
        Object t2 = CollectionsKt___CollectionsKt.t2(this.localCertificates);
        if (!(t2 instanceof X509Certificate)) {
            t2 = null;
        }
        X509Certificate x509Certificate = (X509Certificate) t2;
        if (x509Certificate != null) {
            return x509Certificate.getSubjectX500Principal();
        }
        return null;
    }

    @g(name = "peerCertificates")
    @d
    public final List<Certificate> peerCertificates() {
        return (List) this.peerCertificates$delegate.getValue();
    }

    @g(name = "peerPrincipal")
    @e
    public final Principal peerPrincipal() {
        Object t2 = CollectionsKt___CollectionsKt.t2(peerCertificates());
        if (!(t2 instanceof X509Certificate)) {
            t2 = null;
        }
        X509Certificate x509Certificate = (X509Certificate) t2;
        if (x509Certificate != null) {
            return x509Certificate.getSubjectX500Principal();
        }
        return null;
    }

    @g(name = "tlsVersion")
    @d
    public final TlsVersion tlsVersion() {
        return this.tlsVersion;
    }

    @d
    public String toString() {
        List<Certificate> peerCertificates = peerCertificates();
        ArrayList arrayList = new ArrayList(h.a2.u.Y(peerCertificates, 10));
        for (Certificate certificate : peerCertificates) {
            arrayList.add(getName(certificate));
        }
        String obj = arrayList.toString();
        StringBuilder sb = new StringBuilder();
        sb.append("Handshake{");
        sb.append("tlsVersion=");
        sb.append(this.tlsVersion);
        sb.append(' ');
        sb.append("cipherSuite=");
        sb.append(this.cipherSuite);
        sb.append(' ');
        sb.append("peerCertificates=");
        sb.append(obj);
        sb.append(' ');
        sb.append("localCertificates=");
        List<Certificate> list = this.localCertificates;
        ArrayList arrayList2 = new ArrayList(h.a2.u.Y(list, 10));
        for (Certificate certificate2 : list) {
            arrayList2.add(getName(certificate2));
        }
        sb.append(arrayList2);
        sb.append('}');
        return sb.toString();
    }
}
