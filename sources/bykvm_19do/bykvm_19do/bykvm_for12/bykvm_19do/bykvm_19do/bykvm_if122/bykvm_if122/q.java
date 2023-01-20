package bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122;

import java.security.cert.Certificate;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;

/* loaded from: classes.dex */
public final class q {
    private final d0 a;
    private final h b;

    /* renamed from: c  reason: collision with root package name */
    private final List<Certificate> f619c;

    /* renamed from: d  reason: collision with root package name */
    private final List<Certificate> f620d;

    private q(d0 d0Var, h hVar, List<Certificate> list, List<Certificate> list2) {
        this.a = d0Var;
        this.b = hVar;
        this.f619c = list;
        this.f620d = list2;
    }

    public static q a(SSLSession sSLSession) {
        String str;
        Certificate[] certificateArr = null;
        try {
            str = sSLSession.getCipherSuite();
        } catch (Exception unused) {
            str = null;
        }
        if (str != null) {
            h a = h.a(str);
            String protocol = sSLSession.getProtocol();
            if (protocol != null) {
                d0 a2 = d0.a(protocol);
                try {
                    certificateArr = sSLSession.getPeerCertificates();
                } catch (SSLPeerUnverifiedException unused2) {
                }
                List a3 = certificateArr != null ? bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(certificateArr) : Collections.emptyList();
                Certificate[] localCertificates = sSLSession.getLocalCertificates();
                return new q(a2, a, a3, localCertificates != null ? bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(localCertificates) : Collections.emptyList());
            }
            throw new IllegalStateException("tlsVersion == null");
        }
        throw new IllegalStateException("cipherSuite == null");
    }

    public h a() {
        return this.b;
    }

    public List<Certificate> b() {
        return this.f619c;
    }

    public boolean equals(Object obj) {
        if (obj instanceof q) {
            q qVar = (q) obj;
            if (this.a.equals(qVar.a) && this.b.equals(qVar.b) && this.f619c.equals(qVar.f619c) && this.f620d.equals(qVar.f620d)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((((this.a.hashCode() + 527) * 31) + this.b.hashCode()) * 31) + this.f619c.hashCode()) * 31) + this.f620d.hashCode();
    }
}
