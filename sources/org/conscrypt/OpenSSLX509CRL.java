package org.conscrypt;

import e.j.a.c.m.o;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Principal;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.CRLException;
import java.security.cert.Certificate;
import java.security.cert.X509CRL;
import java.security.cert.X509CRLEntry;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.security.auth.x500.X500Principal;
import org.conscrypt.OpenSSLX509CertificateFactory;

/* loaded from: classes4.dex */
public final class OpenSSLX509CRL extends X509CRL {
    private final long mContext;
    private final Date nextUpdate;
    private final Date thisUpdate;

    private OpenSSLX509CRL(long j2) throws OpenSSLX509CertificateFactory.ParsingException {
        this.mContext = j2;
        this.thisUpdate = toDate(NativeCrypto.X509_CRL_get_lastUpdate(j2, this));
        this.nextUpdate = toDate(NativeCrypto.X509_CRL_get_nextUpdate(j2, this));
    }

    public static List<OpenSSLX509CRL> fromPkcs7DerInputStream(InputStream inputStream) throws OpenSSLX509CertificateFactory.ParsingException {
        OpenSSLBIOInputStream openSSLBIOInputStream = new OpenSSLBIOInputStream(inputStream, true);
        try {
            try {
                long[] d2i_PKCS7_bio = NativeCrypto.d2i_PKCS7_bio(openSSLBIOInputStream.getBioContext(), 2);
                openSSLBIOInputStream.release();
                ArrayList arrayList = new ArrayList(d2i_PKCS7_bio.length);
                for (int i2 = 0; i2 < d2i_PKCS7_bio.length; i2++) {
                    if (d2i_PKCS7_bio[i2] != 0) {
                        arrayList.add(new OpenSSLX509CRL(d2i_PKCS7_bio[i2]));
                    }
                }
                return arrayList;
            } catch (Exception e2) {
                throw new OpenSSLX509CertificateFactory.ParsingException(e2);
            }
        } catch (Throwable th) {
            openSSLBIOInputStream.release();
            throw th;
        }
    }

    public static List<OpenSSLX509CRL> fromPkcs7PemInputStream(InputStream inputStream) throws OpenSSLX509CertificateFactory.ParsingException {
        OpenSSLBIOInputStream openSSLBIOInputStream = new OpenSSLBIOInputStream(inputStream, true);
        try {
            try {
                long[] PEM_read_bio_PKCS7 = NativeCrypto.PEM_read_bio_PKCS7(openSSLBIOInputStream.getBioContext(), 2);
                openSSLBIOInputStream.release();
                ArrayList arrayList = new ArrayList(PEM_read_bio_PKCS7.length);
                for (int i2 = 0; i2 < PEM_read_bio_PKCS7.length; i2++) {
                    if (PEM_read_bio_PKCS7[i2] != 0) {
                        arrayList.add(new OpenSSLX509CRL(PEM_read_bio_PKCS7[i2]));
                    }
                }
                return arrayList;
            } catch (Exception e2) {
                throw new OpenSSLX509CertificateFactory.ParsingException(e2);
            }
        } catch (Throwable th) {
            openSSLBIOInputStream.release();
            throw th;
        }
    }

    public static OpenSSLX509CRL fromX509DerInputStream(InputStream inputStream) throws OpenSSLX509CertificateFactory.ParsingException {
        OpenSSLBIOInputStream openSSLBIOInputStream = new OpenSSLBIOInputStream(inputStream, true);
        try {
            try {
                long d2i_X509_CRL_bio = NativeCrypto.d2i_X509_CRL_bio(openSSLBIOInputStream.getBioContext());
                if (d2i_X509_CRL_bio == 0) {
                    return null;
                }
                return new OpenSSLX509CRL(d2i_X509_CRL_bio);
            } catch (Exception e2) {
                throw new OpenSSLX509CertificateFactory.ParsingException(e2);
            }
        } finally {
            openSSLBIOInputStream.release();
        }
    }

    public static OpenSSLX509CRL fromX509PemInputStream(InputStream inputStream) throws OpenSSLX509CertificateFactory.ParsingException {
        OpenSSLBIOInputStream openSSLBIOInputStream = new OpenSSLBIOInputStream(inputStream, true);
        try {
            try {
                long PEM_read_bio_X509_CRL = NativeCrypto.PEM_read_bio_X509_CRL(openSSLBIOInputStream.getBioContext());
                if (PEM_read_bio_X509_CRL == 0) {
                    return null;
                }
                return new OpenSSLX509CRL(PEM_read_bio_X509_CRL);
            } catch (Exception e2) {
                throw new OpenSSLX509CertificateFactory.ParsingException(e2);
            }
        } finally {
            openSSLBIOInputStream.release();
        }
    }

    public static Date toDate(long j2) throws OpenSSLX509CertificateFactory.ParsingException {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone(o.a));
        calendar.set(14, 0);
        NativeCrypto.ASN1_TIME_to_Calendar(j2, calendar);
        return calendar.getTime();
    }

    private void verifyInternal(PublicKey publicKey, String str) throws CRLException, NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException, SignatureException {
        Signature signature;
        String sigAlgName = getSigAlgName();
        if (sigAlgName == null) {
            sigAlgName = getSigAlgOID();
        }
        if (str == null) {
            signature = Signature.getInstance(sigAlgName);
        } else {
            signature = Signature.getInstance(sigAlgName, str);
        }
        signature.initVerify(publicKey);
        signature.update(getTBSCertList());
        if (!signature.verify(getSignature())) {
            throw new SignatureException("signature did not verify");
        }
    }

    private void verifyOpenSSL(OpenSSLKey openSSLKey) throws NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        try {
            NativeCrypto.X509_CRL_verify(this.mContext, this, openSSLKey.getNativeRef());
        } catch (BadPaddingException | IllegalBlockSizeException e2) {
            throw new SignatureException(e2);
        }
    }

    public void finalize() throws Throwable {
        try {
            long j2 = this.mContext;
            if (j2 != 0) {
                NativeCrypto.X509_CRL_free(j2, this);
            }
        } finally {
            super.finalize();
        }
    }

    @Override // java.security.cert.X509Extension
    public Set<String> getCriticalExtensionOIDs() {
        String[] strArr = NativeCrypto.get_X509_CRL_ext_oids(this.mContext, this, 1);
        if (strArr.length == 0 && NativeCrypto.get_X509_CRL_ext_oids(this.mContext, this, 0).length == 0) {
            return null;
        }
        return new HashSet(Arrays.asList(strArr));
    }

    @Override // java.security.cert.X509CRL
    public byte[] getEncoded() throws CRLException {
        return NativeCrypto.i2d_X509_CRL(this.mContext, this);
    }

    @Override // java.security.cert.X509Extension
    public byte[] getExtensionValue(String str) {
        return NativeCrypto.X509_CRL_get_ext_oid(this.mContext, this, str);
    }

    @Override // java.security.cert.X509CRL
    public Principal getIssuerDN() {
        return getIssuerX500Principal();
    }

    @Override // java.security.cert.X509CRL
    public X500Principal getIssuerX500Principal() {
        return new X500Principal(NativeCrypto.X509_CRL_get_issuer_name(this.mContext, this));
    }

    @Override // java.security.cert.X509CRL
    public Date getNextUpdate() {
        return (Date) this.nextUpdate.clone();
    }

    @Override // java.security.cert.X509Extension
    public Set<String> getNonCriticalExtensionOIDs() {
        String[] strArr = NativeCrypto.get_X509_CRL_ext_oids(this.mContext, this, 0);
        if (strArr.length == 0 && NativeCrypto.get_X509_CRL_ext_oids(this.mContext, this, 1).length == 0) {
            return null;
        }
        return new HashSet(Arrays.asList(strArr));
    }

    @Override // java.security.cert.X509CRL
    public X509CRLEntry getRevokedCertificate(BigInteger bigInteger) {
        long X509_CRL_get0_by_serial = NativeCrypto.X509_CRL_get0_by_serial(this.mContext, this, bigInteger.toByteArray());
        if (X509_CRL_get0_by_serial == 0) {
            return null;
        }
        try {
            return new OpenSSLX509CRLEntry(NativeCrypto.X509_REVOKED_dup(X509_CRL_get0_by_serial));
        } catch (OpenSSLX509CertificateFactory.ParsingException unused) {
            return null;
        }
    }

    @Override // java.security.cert.X509CRL
    public Set<? extends X509CRLEntry> getRevokedCertificates() {
        long[] X509_CRL_get_REVOKED = NativeCrypto.X509_CRL_get_REVOKED(this.mContext, this);
        if (X509_CRL_get_REVOKED == null || X509_CRL_get_REVOKED.length == 0) {
            return null;
        }
        HashSet hashSet = new HashSet();
        for (long j2 : X509_CRL_get_REVOKED) {
            try {
                hashSet.add(new OpenSSLX509CRLEntry(j2));
            } catch (OpenSSLX509CertificateFactory.ParsingException unused) {
            }
        }
        return hashSet;
    }

    @Override // java.security.cert.X509CRL
    public String getSigAlgName() {
        String sigAlgOID = getSigAlgOID();
        String oidToAlgorithmName = OidData.oidToAlgorithmName(sigAlgOID);
        if (oidToAlgorithmName != null) {
            return oidToAlgorithmName;
        }
        String oidToAlgorithmName2 = Platform.oidToAlgorithmName(sigAlgOID);
        return oidToAlgorithmName2 != null ? oidToAlgorithmName2 : sigAlgOID;
    }

    @Override // java.security.cert.X509CRL
    public String getSigAlgOID() {
        return NativeCrypto.get_X509_CRL_sig_alg_oid(this.mContext, this);
    }

    @Override // java.security.cert.X509CRL
    public byte[] getSigAlgParams() {
        return NativeCrypto.get_X509_CRL_sig_alg_parameter(this.mContext, this);
    }

    @Override // java.security.cert.X509CRL
    public byte[] getSignature() {
        return NativeCrypto.get_X509_CRL_signature(this.mContext, this);
    }

    @Override // java.security.cert.X509CRL
    public byte[] getTBSCertList() throws CRLException {
        return NativeCrypto.get_X509_CRL_crl_enc(this.mContext, this);
    }

    @Override // java.security.cert.X509CRL
    public Date getThisUpdate() {
        return (Date) this.thisUpdate.clone();
    }

    @Override // java.security.cert.X509CRL
    public int getVersion() {
        return ((int) NativeCrypto.X509_CRL_get_version(this.mContext, this)) + 1;
    }

    @Override // java.security.cert.X509Extension
    public boolean hasUnsupportedCriticalExtension() {
        for (String str : NativeCrypto.get_X509_CRL_ext_oids(this.mContext, this, 1)) {
            if (NativeCrypto.X509_supported_extension(NativeCrypto.X509_CRL_get_ext(this.mContext, this, str)) != 1) {
                return true;
            }
        }
        return false;
    }

    @Override // java.security.cert.CRL
    public boolean isRevoked(Certificate certificate) {
        OpenSSLX509Certificate fromX509DerInputStream;
        if (certificate instanceof X509Certificate) {
            if (certificate instanceof OpenSSLX509Certificate) {
                fromX509DerInputStream = (OpenSSLX509Certificate) certificate;
            } else {
                try {
                    fromX509DerInputStream = OpenSSLX509Certificate.fromX509DerInputStream(new ByteArrayInputStream(certificate.getEncoded()));
                } catch (Exception e2) {
                    throw new RuntimeException("cannot convert certificate", e2);
                }
            }
            OpenSSLX509Certificate openSSLX509Certificate = fromX509DerInputStream;
            return NativeCrypto.X509_CRL_get0_by_cert(this.mContext, this, openSSLX509Certificate.getContext(), openSSLX509Certificate) != 0;
        }
        return false;
    }

    @Override // java.security.cert.CRL
    public String toString() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        long create_BIO_OutputStream = NativeCrypto.create_BIO_OutputStream(byteArrayOutputStream);
        try {
            NativeCrypto.X509_CRL_print(create_BIO_OutputStream, this.mContext, this);
            return byteArrayOutputStream.toString();
        } finally {
            NativeCrypto.BIO_free_all(create_BIO_OutputStream);
        }
    }

    @Override // java.security.cert.X509CRL
    public void verify(PublicKey publicKey) throws CRLException, NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException, SignatureException {
        if (publicKey instanceof OpenSSLKeyHolder) {
            verifyOpenSSL(((OpenSSLKeyHolder) publicKey).getOpenSSLKey());
        } else {
            verifyInternal(publicKey, null);
        }
    }

    @Override // java.security.cert.X509CRL
    public X509CRLEntry getRevokedCertificate(X509Certificate x509Certificate) {
        if (x509Certificate instanceof OpenSSLX509Certificate) {
            OpenSSLX509Certificate openSSLX509Certificate = (OpenSSLX509Certificate) x509Certificate;
            long X509_CRL_get0_by_cert = NativeCrypto.X509_CRL_get0_by_cert(this.mContext, this, openSSLX509Certificate.getContext(), openSSLX509Certificate);
            if (X509_CRL_get0_by_cert == 0) {
                return null;
            }
            try {
                return new OpenSSLX509CRLEntry(NativeCrypto.X509_REVOKED_dup(X509_CRL_get0_by_cert));
            } catch (OpenSSLX509CertificateFactory.ParsingException unused) {
                return null;
            }
        }
        return getRevokedCertificate(x509Certificate.getSerialNumber());
    }

    @Override // java.security.cert.X509CRL
    public void verify(PublicKey publicKey, String str) throws CRLException, NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException, SignatureException {
        verifyInternal(publicKey, str);
    }
}