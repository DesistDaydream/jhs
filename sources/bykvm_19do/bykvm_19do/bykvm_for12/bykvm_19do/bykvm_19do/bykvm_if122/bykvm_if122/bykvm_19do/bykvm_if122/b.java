package bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122;

import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.k;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.UnknownServiceException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import javax.net.ssl.SSLSocket;

/* loaded from: classes.dex */
public final class b {
    private final List<k> a;
    private int b = 0;

    /* renamed from: c  reason: collision with root package name */
    private boolean f368c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f369d;

    public b(List<k> list) {
        this.a = list;
    }

    private boolean b(SSLSocket sSLSocket) {
        for (int i2 = this.b; i2 < this.a.size(); i2++) {
            if (this.a.get(i2).a(sSLSocket)) {
                return true;
            }
        }
        return false;
    }

    public k a(SSLSocket sSLSocket) throws IOException {
        k kVar;
        int i2 = this.b;
        int size = this.a.size();
        while (true) {
            if (i2 >= size) {
                kVar = null;
                break;
            }
            kVar = this.a.get(i2);
            i2++;
            if (kVar.a(sSLSocket)) {
                this.b = i2;
                break;
            }
        }
        if (kVar != null) {
            this.f368c = b(sSLSocket);
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.a.a.a(kVar, sSLSocket, this.f369d);
            return kVar;
        }
        throw new UnknownServiceException("Unable to find acceptable protocols. isFallback=" + this.f369d + ", modes=" + this.a + ", supported protocols=" + Arrays.toString(sSLSocket.getEnabledProtocols()));
    }

    public boolean a(IOException iOException) {
        boolean z;
        this.f369d = true;
        return (!this.f368c || (iOException instanceof ProtocolException) || (iOException instanceof InterruptedIOException) || (((z = iOException instanceof SSLHandshakeException)) && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException) || (!z && !(iOException instanceof SSLProtocolException))) ? false : true;
    }
}
