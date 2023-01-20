package okhttp3;

import h.k2.u.a;
import java.security.cert.Certificate;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import k.e.a.d;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "Ljava/security/cert/Certificate;", "invoke", "()Ljava/util/List;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class Handshake$peerCertificates$2 extends Lambda implements a<List<? extends Certificate>> {
    public final /* synthetic */ a $peerCertificatesFn;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Handshake$peerCertificates$2(a aVar) {
        super(0);
        this.$peerCertificatesFn = aVar;
    }

    @Override // h.k2.u.a
    @d
    public final List<? extends Certificate> invoke() {
        try {
            return (List) this.$peerCertificatesFn.invoke();
        } catch (SSLPeerUnverifiedException unused) {
            return CollectionsKt__CollectionsKt.E();
        }
    }
}
