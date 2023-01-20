package org.conscrypt.ct;

import java.security.cert.X509Certificate;

/* loaded from: classes4.dex */
public interface CTPolicy {
    boolean doesResultConformToPolicy(CTVerificationResult cTVerificationResult, String str, X509Certificate[] x509CertificateArr);
}
