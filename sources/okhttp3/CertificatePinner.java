package okhttp3;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.moor.imkf.lib.jsoup.nodes.Attributes;
import com.xiaomi.mipush.sdk.Constants;
import h.i;
import h.k2.d;
import h.k2.k;
import h.k2.u.a;
import h.k2.v.f0;
import h.k2.v.t0;
import h.k2.v.u;
import h.q0;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.text.StringsKt__StringsKt;
import okhttp3.internal.HostnamesKt;
import okhttp3.internal.tls.CertificateChainCleaner;
import okio.ByteString;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\b\n\u0018\u0000 *2\u00020\u0001:\u0003+*,B#\b\u0000\u0012\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00110#\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b(\u0010)J#\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\b\u0010\tJ+\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00040\nH\u0000¢\u0006\u0004\b\r\u0010\u000eJ+\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u000f\"\u00020\u0005H\u0007¢\u0006\u0004\b\b\u0010\u0010J\u001b\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0014H\u0000¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001e\u0010\u001fR\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0015\u0010 \u001a\u0004\b!\u0010\"R\u001f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00110#8\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'¨\u0006-"}, d2 = {"Lokhttp3/CertificatePinner;", "", "", "hostname", "", "Ljava/security/cert/Certificate;", "peerCertificates", "Lh/t1;", "check", "(Ljava/lang/String;Ljava/util/List;)V", "Lkotlin/Function0;", "Ljava/security/cert/X509Certificate;", "cleanedPeerCertificatesFn", "check$okhttp", "(Ljava/lang/String;Lh/k2/u/a;)V", "", "(Ljava/lang/String;[Ljava/security/cert/Certificate;)V", "Lokhttp3/CertificatePinner$Pin;", "findMatchingPins", "(Ljava/lang/String;)Ljava/util/List;", "Lokhttp3/internal/tls/CertificateChainCleaner;", "certificateChainCleaner", "withCertificateChainCleaner$okhttp", "(Lokhttp3/internal/tls/CertificateChainCleaner;)Lokhttp3/CertificatePinner;", "withCertificateChainCleaner", "other", "", "equals", "(Ljava/lang/Object;)Z", "", TTDownloadField.TT_HASHCODE, "()I", "Lokhttp3/internal/tls/CertificateChainCleaner;", "getCertificateChainCleaner$okhttp", "()Lokhttp3/internal/tls/CertificateChainCleaner;", "", "pins", "Ljava/util/Set;", "getPins", "()Ljava/util/Set;", "<init>", "(Ljava/util/Set;Lokhttp3/internal/tls/CertificateChainCleaner;)V", "Companion", "Builder", "Pin", "okhttp"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class CertificatePinner {
    public static final Companion Companion = new Companion(null);
    @d
    @k.e.a.d
    public static final CertificatePinner DEFAULT = new Builder().build();
    @e
    private final CertificateChainCleaner certificateChainCleaner;
    @k.e.a.d
    private final Set<Pin> pins;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011J)\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0004\"\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\t\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nR\u001f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lokhttp3/CertificatePinner$Builder;", "", "", "pattern", "", "pins", "add", "(Ljava/lang/String;[Ljava/lang/String;)Lokhttp3/CertificatePinner$Builder;", "Lokhttp3/CertificatePinner;", "build", "()Lokhttp3/CertificatePinner;", "", "Lokhttp3/CertificatePinner$Pin;", "Ljava/util/List;", "getPins", "()Ljava/util/List;", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class Builder {
        @k.e.a.d
        private final List<Pin> pins = new ArrayList();

        @k.e.a.d
        public final Builder add(@k.e.a.d String str, @k.e.a.d String... strArr) {
            for (String str2 : strArr) {
                this.pins.add(new Pin(str, str2));
            }
            return this;
        }

        @k.e.a.d
        public final CertificatePinner build() {
            return new CertificatePinner(CollectionsKt___CollectionsKt.N5(this.pins), null, 2, null);
        }

        @k.e.a.d
        public final List<Pin> getPins() {
            return this.pins;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0013\u0010\u0004\u001a\u00020\u0003*\u00020\u0002H\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\u0006\u001a\u00020\u0003*\u00020\u0002H\u0007¢\u0006\u0004\b\u0006\u0010\u0005J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\r\u001a\u00020\f8\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lokhttp3/CertificatePinner$Companion;", "", "Ljava/security/cert/X509Certificate;", "Lokio/ByteString;", "sha1Hash", "(Ljava/security/cert/X509Certificate;)Lokio/ByteString;", "sha256Hash", "Ljava/security/cert/Certificate;", "certificate", "", "pin", "(Ljava/security/cert/Certificate;)Ljava/lang/String;", "Lokhttp3/CertificatePinner;", "DEFAULT", "Lokhttp3/CertificatePinner;", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class Companion {
        private Companion() {
        }

        @k
        @k.e.a.d
        public final String pin(@k.e.a.d Certificate certificate) {
            if (certificate instanceof X509Certificate) {
                return "sha256/" + sha256Hash((X509Certificate) certificate).base64();
            }
            throw new IllegalArgumentException("Certificate pinning requires X509 certificates".toString());
        }

        @k
        @k.e.a.d
        public final ByteString sha1Hash(@k.e.a.d X509Certificate x509Certificate) {
            return ByteString.a.p(ByteString.Companion, x509Certificate.getPublicKey().getEncoded(), 0, 0, 3, null).sha1();
        }

        @k
        @k.e.a.d
        public final ByteString sha256Hash(@k.e.a.d X509Certificate x509Certificate) {
            return ByteString.a.p(ByteString.Companion, x509Certificate.getPublicKey().getEncoded(), 0, 0, 3, null).sha256();
        }

        public /* synthetic */ Companion(u uVar) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u001d\u001a\u00020\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000e\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0013\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\fR\u0019\u0010\u0016\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0014\u001a\u0004\b\u0017\u0010\fR\u0019\u0010\u0019\u001a\u00020\u00188\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u0006 "}, d2 = {"Lokhttp3/CertificatePinner$Pin;", "", "", "hostname", "", "matchesHostname", "(Ljava/lang/String;)Z", "Ljava/security/cert/X509Certificate;", "certificate", "matchesCertificate", "(Ljava/security/cert/X509Certificate;)Z", "toString", "()Ljava/lang/String;", "other", "equals", "(Ljava/lang/Object;)Z", "", TTDownloadField.TT_HASHCODE, "()I", "pattern", "Ljava/lang/String;", "getPattern", "hashAlgorithm", "getHashAlgorithm", "Lokio/ByteString;", "hash", "Lokio/ByteString;", "getHash", "()Lokio/ByteString;", "pin", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "okhttp"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class Pin {
        @k.e.a.d
        private final ByteString hash;
        @k.e.a.d
        private final String hashAlgorithm;
        @k.e.a.d
        private final String pattern;

        public Pin(@k.e.a.d String str, @k.e.a.d String str2) {
            if ((h.t2.u.u2(str, "*.", false, 2, null) && StringsKt__StringsKt.r3(str, "*", 1, false, 4, null) == -1) || (h.t2.u.u2(str, "**.", false, 2, null) && StringsKt__StringsKt.r3(str, "*", 2, false, 4, null) == -1) || StringsKt__StringsKt.r3(str, "*", 0, false, 6, null) == -1) {
                String canonicalHost = HostnamesKt.toCanonicalHost(str);
                if (canonicalHost != null) {
                    this.pattern = canonicalHost;
                    if (h.t2.u.u2(str2, "sha1/", false, 2, null)) {
                        this.hashAlgorithm = "sha1";
                        ByteString h2 = ByteString.Companion.h(str2.substring(5));
                        if (h2 != null) {
                            this.hash = h2;
                            return;
                        }
                        throw new IllegalArgumentException("Invalid pin hash: " + str2);
                    } else if (h.t2.u.u2(str2, "sha256/", false, 2, null)) {
                        this.hashAlgorithm = "sha256";
                        ByteString h3 = ByteString.Companion.h(str2.substring(7));
                        if (h3 != null) {
                            this.hash = h3;
                            return;
                        }
                        throw new IllegalArgumentException("Invalid pin hash: " + str2);
                    } else {
                        throw new IllegalArgumentException("pins must start with 'sha256/' or 'sha1/': " + str2);
                    }
                }
                throw new IllegalArgumentException("Invalid pattern: " + str);
            }
            throw new IllegalArgumentException(("Unexpected pattern: " + str).toString());
        }

        public boolean equals(@e Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Pin) {
                Pin pin = (Pin) obj;
                return ((f0.g(this.pattern, pin.pattern) ^ true) || (f0.g(this.hashAlgorithm, pin.hashAlgorithm) ^ true) || (f0.g(this.hash, pin.hash) ^ true)) ? false : true;
            }
            return false;
        }

        @k.e.a.d
        public final ByteString getHash() {
            return this.hash;
        }

        @k.e.a.d
        public final String getHashAlgorithm() {
            return this.hashAlgorithm;
        }

        @k.e.a.d
        public final String getPattern() {
            return this.pattern;
        }

        public int hashCode() {
            return (((this.pattern.hashCode() * 31) + this.hashAlgorithm.hashCode()) * 31) + this.hash.hashCode();
        }

        public final boolean matchesCertificate(@k.e.a.d X509Certificate x509Certificate) {
            String str = this.hashAlgorithm;
            int hashCode = str.hashCode();
            if (hashCode != -903629273) {
                if (hashCode == 3528965 && str.equals("sha1")) {
                    return f0.g(this.hash, CertificatePinner.Companion.sha1Hash(x509Certificate));
                }
            } else if (str.equals("sha256")) {
                return f0.g(this.hash, CertificatePinner.Companion.sha256Hash(x509Certificate));
            }
            return false;
        }

        public final boolean matchesHostname(@k.e.a.d String str) {
            boolean d2;
            boolean d22;
            if (h.t2.u.u2(this.pattern, "**.", false, 2, null)) {
                int length = this.pattern.length() - 3;
                int length2 = str.length() - length;
                d22 = h.t2.u.d2(str, str.length() - length, this.pattern, 3, length, (r12 & 16) != 0 ? false : false);
                if (!d22) {
                    return false;
                }
                if (length2 != 0 && str.charAt(length2 - 1) != '.') {
                    return false;
                }
            } else if (h.t2.u.u2(this.pattern, "*.", false, 2, null)) {
                int length3 = this.pattern.length() - 1;
                int length4 = str.length() - length3;
                d2 = h.t2.u.d2(str, str.length() - length3, this.pattern, 1, length3, (r12 & 16) != 0 ? false : false);
                if (!d2 || StringsKt__StringsKt.E3(str, '.', length4 - 1, false, 4, null) != -1) {
                    return false;
                }
            } else {
                return f0.g(str, this.pattern);
            }
            return true;
        }

        @k.e.a.d
        public String toString() {
            return this.hashAlgorithm + Attributes.InternalPrefix + this.hash.base64();
        }
    }

    public CertificatePinner(@k.e.a.d Set<Pin> set, @e CertificateChainCleaner certificateChainCleaner) {
        this.pins = set;
        this.certificateChainCleaner = certificateChainCleaner;
    }

    @k
    @k.e.a.d
    public static final String pin(@k.e.a.d Certificate certificate) {
        return Companion.pin(certificate);
    }

    @k
    @k.e.a.d
    public static final ByteString sha1Hash(@k.e.a.d X509Certificate x509Certificate) {
        return Companion.sha1Hash(x509Certificate);
    }

    @k
    @k.e.a.d
    public static final ByteString sha256Hash(@k.e.a.d X509Certificate x509Certificate) {
        return Companion.sha256Hash(x509Certificate);
    }

    public final void check(@k.e.a.d String str, @k.e.a.d List<? extends Certificate> list) throws SSLPeerUnverifiedException {
        check$okhttp(str, new CertificatePinner$check$1(this, list, str));
    }

    public final void check$okhttp(@k.e.a.d String str, @k.e.a.d a<? extends List<? extends X509Certificate>> aVar) {
        List<Pin> findMatchingPins = findMatchingPins(str);
        if (findMatchingPins.isEmpty()) {
            return;
        }
        List<? extends X509Certificate> invoke = aVar.invoke();
        for (X509Certificate x509Certificate : invoke) {
            ByteString byteString = null;
            ByteString byteString2 = null;
            for (Pin pin : findMatchingPins) {
                String hashAlgorithm = pin.getHashAlgorithm();
                int hashCode = hashAlgorithm.hashCode();
                if (hashCode != -903629273) {
                    if (hashCode == 3528965 && hashAlgorithm.equals("sha1")) {
                        if (byteString2 == null) {
                            byteString2 = Companion.sha1Hash(x509Certificate);
                        }
                        if (f0.g(pin.getHash(), byteString2)) {
                            return;
                        }
                    }
                    throw new AssertionError("unsupported hashAlgorithm: " + pin.getHashAlgorithm());
                } else if (hashAlgorithm.equals("sha256")) {
                    if (byteString == null) {
                        byteString = Companion.sha256Hash(x509Certificate);
                    }
                    if (f0.g(pin.getHash(), byteString)) {
                        return;
                    }
                } else {
                    throw new AssertionError("unsupported hashAlgorithm: " + pin.getHashAlgorithm());
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Certificate pinning failure!");
        sb.append("\n  Peer certificate chain:");
        for (X509Certificate x509Certificate2 : invoke) {
            sb.append("\n    ");
            sb.append(Companion.pin(x509Certificate2));
            sb.append(": ");
            sb.append(x509Certificate2.getSubjectDN().getName());
        }
        sb.append("\n  Pinned certificates for ");
        sb.append(str);
        sb.append(Constants.COLON_SEPARATOR);
        for (Pin pin2 : findMatchingPins) {
            sb.append("\n    ");
            sb.append(pin2);
        }
        throw new SSLPeerUnverifiedException(sb.toString());
    }

    public boolean equals(@e Object obj) {
        if (obj instanceof CertificatePinner) {
            CertificatePinner certificatePinner = (CertificatePinner) obj;
            if (f0.g(certificatePinner.pins, this.pins) && f0.g(certificatePinner.certificateChainCleaner, this.certificateChainCleaner)) {
                return true;
            }
        }
        return false;
    }

    @k.e.a.d
    public final List<Pin> findMatchingPins(@k.e.a.d String str) {
        Set<Pin> set = this.pins;
        List<Pin> E = CollectionsKt__CollectionsKt.E();
        for (Object obj : set) {
            if (((Pin) obj).matchesHostname(str)) {
                if (E.isEmpty()) {
                    E = new ArrayList<>();
                }
                Objects.requireNonNull(E, "null cannot be cast to non-null type kotlin.collections.MutableList<T>");
                t0.g(E).add(obj);
            }
        }
        return E;
    }

    @e
    public final CertificateChainCleaner getCertificateChainCleaner$okhttp() {
        return this.certificateChainCleaner;
    }

    @k.e.a.d
    public final Set<Pin> getPins() {
        return this.pins;
    }

    public int hashCode() {
        int hashCode = (1517 + this.pins.hashCode()) * 41;
        CertificateChainCleaner certificateChainCleaner = this.certificateChainCleaner;
        return hashCode + (certificateChainCleaner != null ? certificateChainCleaner.hashCode() : 0);
    }

    @k.e.a.d
    public final CertificatePinner withCertificateChainCleaner$okhttp(@k.e.a.d CertificateChainCleaner certificateChainCleaner) {
        return f0.g(this.certificateChainCleaner, certificateChainCleaner) ? this : new CertificatePinner(this.pins, certificateChainCleaner);
    }

    public /* synthetic */ CertificatePinner(Set set, CertificateChainCleaner certificateChainCleaner, int i2, u uVar) {
        this(set, (i2 & 2) != 0 ? null : certificateChainCleaner);
    }

    @i(message = "replaced with {@link #check(String, List)}.", replaceWith = @q0(expression = "check(hostname, peerCertificates.toList())", imports = {}))
    public final void check(@k.e.a.d String str, @k.e.a.d Certificate... certificateArr) throws SSLPeerUnverifiedException {
        check(str, ArraysKt___ArraysKt.ey(certificateArr));
    }
}
