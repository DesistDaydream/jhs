package e.t.r.a.m;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, d2 = {"Lcom/vector/network/image/https/CustomHostnameVerifier;", "Ljavax/net/ssl/HostnameVerifier;", "()V", "verify", "", "hostname", "", com.umeng.analytics.pro.d.aw, "Ljavax/net/ssl/SSLSession;", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class a implements HostnameVerifier {
    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(@e String str, @e SSLSession sSLSession) {
        String obj;
        return (str == null ? 1 : str.length()) + ((sSLSession != null && (obj = sSLSession.toString()) != null) ? obj.length() : 0) > 0;
    }
}
