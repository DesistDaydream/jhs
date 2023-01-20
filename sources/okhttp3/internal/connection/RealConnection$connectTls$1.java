package okhttp3.internal.connection;

import h.k2.u.a;
import java.security.cert.Certificate;
import java.util.List;
import k.e.a.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;
import okhttp3.Address;
import okhttp3.CertificatePinner;
import okhttp3.Handshake;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "Ljava/security/cert/Certificate;", "invoke", "()Ljava/util/List;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class RealConnection$connectTls$1 extends Lambda implements a<List<? extends Certificate>> {
    public final /* synthetic */ Address $address;
    public final /* synthetic */ CertificatePinner $certificatePinner;
    public final /* synthetic */ Handshake $unverifiedHandshake;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RealConnection$connectTls$1(CertificatePinner certificatePinner, Handshake handshake, Address address) {
        super(0);
        this.$certificatePinner = certificatePinner;
        this.$unverifiedHandshake = handshake;
        this.$address = address;
    }

    @Override // h.k2.u.a
    @d
    public final List<? extends Certificate> invoke() {
        return this.$certificatePinner.getCertificateChainCleaner$okhttp().clean(this.$unverifiedHandshake.peerCertificates(), this.$address.url().host());
    }
}
