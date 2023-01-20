package bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122;

import com.xiaomi.mipush.sdk.Constants;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;

/* loaded from: classes.dex */
public final class g {

    /* renamed from: c  reason: collision with root package name */
    public static final g f576c = new a().a();
    private final Set<b> a;
    private final bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_case1.c b;

    /* loaded from: classes.dex */
    public static final class a {
        private final List<b> a = new ArrayList();

        public g a() {
            return new g(new LinkedHashSet(this.a), null);
        }
    }

    /* loaded from: classes.dex */
    public static final class b {
        public final String a;
        public final String b;

        /* renamed from: c  reason: collision with root package name */
        public final String f577c;

        /* renamed from: d  reason: collision with root package name */
        public final bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f f578d;

        public boolean a(String str) {
            if (this.a.startsWith("*.")) {
                int indexOf = str.indexOf(46);
                if ((str.length() - indexOf) - 1 == this.b.length()) {
                    String str2 = this.b;
                    if (str.regionMatches(false, indexOf + 1, str2, 0, str2.length())) {
                        return true;
                    }
                }
                return false;
            }
            return str.equals(this.b);
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                b bVar = (b) obj;
                if (this.a.equals(bVar.a) && this.f577c.equals(bVar.f577c) && this.f578d.equals(bVar.f578d)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return ((((this.a.hashCode() + 527) * 31) + this.f577c.hashCode()) * 31) + this.f578d.hashCode();
        }

        public String toString() {
            return this.f577c + this.f578d.a();
        }
    }

    public g(Set<b> set, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_case1.c cVar) {
        this.a = set;
        this.b = cVar;
    }

    public static bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f a(X509Certificate x509Certificate) {
        return bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f.a(x509Certificate.getPublicKey().getEncoded()).c();
    }

    public static String a(Certificate certificate) {
        if (certificate instanceof X509Certificate) {
            return "sha256/" + b((X509Certificate) certificate).a();
        }
        throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
    }

    public static bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f b(X509Certificate x509Certificate) {
        return bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f.a(x509Certificate.getPublicKey().getEncoded()).d();
    }

    public g a(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_case1.c cVar) {
        return bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(this.b, cVar) ? this : new g(this.a, cVar);
    }

    public List<b> a(String str) {
        List<b> emptyList = Collections.emptyList();
        for (b bVar : this.a) {
            if (bVar.a(str)) {
                if (emptyList.isEmpty()) {
                    emptyList = new ArrayList<>();
                }
                emptyList.add(bVar);
            }
        }
        return emptyList;
    }

    public void a(String str, List<Certificate> list) throws SSLPeerUnverifiedException {
        List<b> a2 = a(str);
        if (a2.isEmpty()) {
            return;
        }
        bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_case1.c cVar = this.b;
        if (cVar != null) {
            list = cVar.a(list, str);
        }
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            X509Certificate x509Certificate = (X509Certificate) list.get(i2);
            int size2 = a2.size();
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f fVar = null;
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f fVar2 = null;
            for (int i3 = 0; i3 < size2; i3++) {
                b bVar = a2.get(i3);
                if (bVar.f577c.equals("sha256/")) {
                    if (fVar == null) {
                        fVar = b(x509Certificate);
                    }
                    if (bVar.f578d.equals(fVar)) {
                        return;
                    }
                } else if (!bVar.f577c.equals("sha1/")) {
                    throw new AssertionError("unsupported hashAlgorithm: " + bVar.f577c);
                } else {
                    if (fVar2 == null) {
                        fVar2 = a(x509Certificate);
                    }
                    if (bVar.f578d.equals(fVar2)) {
                        return;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Certificate pinning failure!");
        sb.append("\n  Peer certificate chain:");
        int size3 = list.size();
        for (int i4 = 0; i4 < size3; i4++) {
            X509Certificate x509Certificate2 = (X509Certificate) list.get(i4);
            sb.append("\n    ");
            sb.append(a((Certificate) x509Certificate2));
            sb.append(": ");
            sb.append(x509Certificate2.getSubjectDN().getName());
        }
        sb.append("\n  Pinned certificates for ");
        sb.append(str);
        sb.append(Constants.COLON_SEPARATOR);
        int size4 = a2.size();
        for (int i5 = 0; i5 < size4; i5++) {
            sb.append("\n    ");
            sb.append(a2.get(i5));
        }
        throw new SSLPeerUnverifiedException(sb.toString());
    }

    public boolean equals(Object obj) {
        if (obj != this) {
            if (obj instanceof g) {
                g gVar = (g) obj;
                if (!bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(this.b, gVar.b) || !this.a.equals(gVar.a)) {
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_case1.c cVar = this.b;
        return ((cVar != null ? cVar.hashCode() : 0) * 31) + this.a.hashCode();
    }
}
