package com.bytedance.pangle.g;

import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class p extends r {
    private final byte[] a;
    private int b;

    public p(X509Certificate x509Certificate, byte[] bArr) {
        super(x509Certificate);
        this.b = -1;
        this.a = bArr;
    }

    @Override // java.security.cert.Certificate
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof p) {
            try {
                return Arrays.equals(getEncoded(), ((p) obj).getEncoded());
            } catch (CertificateEncodingException unused) {
                return false;
            }
        }
        return false;
    }

    @Override // com.bytedance.pangle.g.r, java.security.cert.Certificate
    public final byte[] getEncoded() {
        return this.a;
    }

    @Override // java.security.cert.Certificate
    public final int hashCode() {
        if (this.b == -1) {
            try {
                this.b = Arrays.hashCode(getEncoded());
            } catch (CertificateEncodingException unused) {
                this.b = 0;
            }
        }
        return this.b;
    }
}
