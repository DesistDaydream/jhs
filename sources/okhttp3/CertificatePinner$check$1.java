package okhttp3;

import h.a2.u;
import h.k2.u.a;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import k.e.a.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;
import okhttp3.internal.tls.CertificateChainCleaner;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "Ljava/security/cert/X509Certificate;", "invoke", "()Ljava/util/List;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class CertificatePinner$check$1 extends Lambda implements a<List<? extends X509Certificate>> {
    public final /* synthetic */ String $hostname;
    public final /* synthetic */ List $peerCertificates;
    public final /* synthetic */ CertificatePinner this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CertificatePinner$check$1(CertificatePinner certificatePinner, List list, String str) {
        super(0);
        this.this$0 = certificatePinner;
        this.$peerCertificates = list;
        this.$hostname = str;
    }

    @Override // h.k2.u.a
    @d
    public final List<? extends X509Certificate> invoke() {
        List<Certificate> list;
        CertificateChainCleaner certificateChainCleaner$okhttp = this.this$0.getCertificateChainCleaner$okhttp();
        if (certificateChainCleaner$okhttp == null || (list = certificateChainCleaner$okhttp.clean(this.$peerCertificates, this.$hostname)) == null) {
            list = this.$peerCertificates;
        }
        ArrayList arrayList = new ArrayList(u.Y(list, 10));
        for (Certificate certificate : list) {
            Objects.requireNonNull(certificate, "null cannot be cast to non-null type java.security.cert.X509Certificate");
            arrayList.add((X509Certificate) certificate);
        }
        return arrayList;
    }
}
