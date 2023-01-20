package e.k.c.a.a.j.q;

import android.net.http.SslCertificate;
import java.io.ByteArrayInputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Principal;
import java.security.SignatureException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateFactory;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.X509CRL;
import java.security.cert.X509CRLEntry;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Set;

/* loaded from: classes2.dex */
public class d {
    private static final String a = "b";
    private static final int b = 5;

    public static X509Certificate a(SslCertificate sslCertificate) {
        byte[] byteArray = SslCertificate.saveState(sslCertificate).getByteArray("x509-certificate");
        if (byteArray != null) {
            try {
                return (X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(byteArray));
            } catch (CertificateException e2) {
                i.c(a, "exception", e2);
            }
        }
        return null;
    }

    public static X509Certificate b(String str) {
        try {
            return (X509Certificate) CertificateFactory.getInstance("X509").generateCertificate(new ByteArrayInputStream(str.getBytes()));
        } catch (CertificateException e2) {
            String str2 = a;
            i.d(str2, "generateX509FromStr: CertificateException" + e2.getMessage());
            return null;
        }
    }

    public static boolean c(X509Certificate x509Certificate) {
        if (x509Certificate == null || x509Certificate.getBasicConstraints() == -1) {
            return false;
        }
        return x509Certificate.getKeyUsage()[5];
    }

    public static boolean d(X509Certificate x509Certificate, String str) {
        if (str.equals(x509Certificate.getSubjectDN().getName())) {
            return true;
        }
        i.d(a, "verify: subject name is error");
        return false;
    }

    public static boolean e(X509Certificate x509Certificate, X509Certificate x509Certificate2) {
        try {
            x509Certificate2.verify(x509Certificate.getPublicKey());
            if (j(new X509Certificate[]{x509Certificate, x509Certificate2})) {
                return true;
            }
            i.d(a, "verify: date not right");
            return false;
        } catch (InvalidKeyException e2) {
            String str = a;
            i.d(str, "verify: publickey InvalidKeyException " + e2.getMessage());
            return false;
        } catch (NoSuchAlgorithmException e3) {
            String str2 = a;
            i.d(str2, "verify: publickey NoSuchAlgorithmException " + e3.getMessage());
            return false;
        } catch (NoSuchProviderException e4) {
            String str3 = a;
            i.d(str3, "verify: publickey NoSuchProviderException " + e4.getMessage());
            return false;
        } catch (SignatureException e5) {
            String str4 = a;
            i.d(str4, "verify: publickey SignatureException " + e5.getMessage());
            return false;
        } catch (CertificateException e6) {
            String str5 = a;
            i.d(str5, "verify: publickey CertificateException " + e6.getMessage());
            return false;
        } catch (Exception e7) {
            String str6 = a;
            i.d(str6, "verify: Exception " + e7.getMessage());
            return false;
        }
    }

    public static boolean f(X509Certificate x509Certificate, X509Certificate[] x509CertificateArr) throws NoSuchProviderException, CertificateException, NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        Principal principal = null;
        int i2 = 0;
        while (i2 < x509CertificateArr.length) {
            X509Certificate x509Certificate2 = x509CertificateArr[i2];
            Principal issuerDN = x509Certificate2.getIssuerDN();
            Principal subjectDN = x509Certificate2.getSubjectDN();
            if (principal != null) {
                if (issuerDN.equals(principal)) {
                    x509CertificateArr[i2].verify(x509CertificateArr[i2 - 1].getPublicKey());
                } else {
                    i.d(a, "verify: principalIssuer not match");
                    return false;
                }
            }
            i2++;
            principal = subjectDN;
        }
        return e(x509Certificate, x509CertificateArr[0]) && j(x509CertificateArr) && c(x509Certificate) && h(x509CertificateArr);
    }

    public static boolean g(X509Certificate x509Certificate, X509Certificate[] x509CertificateArr, X509CRL x509crl, String str) throws NoSuchAlgorithmException, CertificateException, NoSuchProviderException, InvalidKeyException, SignatureException {
        return !f(x509Certificate, x509CertificateArr) && !i(x509CertificateArr, x509crl) && d(x509CertificateArr[x509CertificateArr.length - 1], str) && j(x509CertificateArr);
    }

    public static boolean h(X509Certificate[] x509CertificateArr) {
        for (int i2 = 0; i2 < x509CertificateArr.length - 1; i2++) {
            if (!c(x509CertificateArr[i2])) {
                return false;
            }
        }
        return true;
    }

    public static boolean i(X509Certificate[] x509CertificateArr, X509CRL x509crl) {
        ArrayList arrayList = new ArrayList();
        for (X509Certificate x509Certificate : x509CertificateArr) {
            arrayList.add(x509Certificate.getSerialNumber());
        }
        if (x509crl != null) {
            try {
                Set<? extends X509CRLEntry> revokedCertificates = x509crl.getRevokedCertificates();
                if (revokedCertificates == null || revokedCertificates.isEmpty()) {
                    return true;
                }
                for (X509CRLEntry x509CRLEntry : revokedCertificates) {
                    if (arrayList.contains(x509CRLEntry.getSerialNumber())) {
                        i.d(a, "verify: certificate revoked");
                        return false;
                    }
                }
                return true;
            } catch (Exception e2) {
                i.d(a, "verify: revoked verify exception : " + e2.getMessage());
                return false;
            }
        }
        return true;
    }

    public static boolean j(X509Certificate[] x509CertificateArr) {
        Date date = new Date();
        for (X509Certificate x509Certificate : x509CertificateArr) {
            try {
                x509Certificate.checkValidity(date);
            } catch (CertificateExpiredException e2) {
                e = e2;
                i.d(a, "verifyCertificateDate: exception : " + e.getMessage());
                return false;
            } catch (CertificateNotYetValidException e3) {
                e = e3;
                i.d(a, "verifyCertificateDate: exception : " + e.getMessage());
                return false;
            } catch (Exception e4) {
                i.d(a, "verifyCertificateDate : exception : " + e4.getMessage());
                return false;
            }
        }
        return true;
    }
}
