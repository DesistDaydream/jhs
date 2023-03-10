package org.conscrypt;

import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.security.cert.CRL;
import java.security.cert.CRLException;
import java.security.cert.CertPath;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactorySpi;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes4.dex */
public class OpenSSLX509CertificateFactory extends CertificateFactorySpi {
    private static final byte[] PKCS7_MARKER = {45, 45, 45, 45, 45, 66, 69, 71, 73, 78, 32, 80, 75, 67, 83, 55};
    private static final int PUSHBACK_SIZE = 64;
    private Parser<OpenSSLX509Certificate> certificateParser = new Parser<OpenSSLX509Certificate>() { // from class: org.conscrypt.OpenSSLX509CertificateFactory.1
        @Override // org.conscrypt.OpenSSLX509CertificateFactory.Parser
        public List<? extends OpenSSLX509Certificate> fromPkcs7DerInputStream(InputStream inputStream) throws ParsingException {
            return OpenSSLX509Certificate.fromPkcs7DerInputStream(inputStream);
        }

        @Override // org.conscrypt.OpenSSLX509CertificateFactory.Parser
        public List<? extends OpenSSLX509Certificate> fromPkcs7PemInputStream(InputStream inputStream) throws ParsingException {
            return OpenSSLX509Certificate.fromPkcs7PemInputStream(inputStream);
        }

        @Override // org.conscrypt.OpenSSLX509CertificateFactory.Parser
        public OpenSSLX509Certificate fromX509DerInputStream(InputStream inputStream) throws ParsingException {
            return OpenSSLX509Certificate.fromX509DerInputStream(inputStream);
        }

        @Override // org.conscrypt.OpenSSLX509CertificateFactory.Parser
        public OpenSSLX509Certificate fromX509PemInputStream(InputStream inputStream) throws ParsingException {
            return OpenSSLX509Certificate.fromX509PemInputStream(inputStream);
        }
    };
    private Parser<OpenSSLX509CRL> crlParser = new Parser<OpenSSLX509CRL>() { // from class: org.conscrypt.OpenSSLX509CertificateFactory.2
        @Override // org.conscrypt.OpenSSLX509CertificateFactory.Parser
        public List<? extends OpenSSLX509CRL> fromPkcs7DerInputStream(InputStream inputStream) throws ParsingException {
            return OpenSSLX509CRL.fromPkcs7DerInputStream(inputStream);
        }

        @Override // org.conscrypt.OpenSSLX509CertificateFactory.Parser
        public List<? extends OpenSSLX509CRL> fromPkcs7PemInputStream(InputStream inputStream) throws ParsingException {
            return OpenSSLX509CRL.fromPkcs7PemInputStream(inputStream);
        }

        @Override // org.conscrypt.OpenSSLX509CertificateFactory.Parser
        public OpenSSLX509CRL fromX509DerInputStream(InputStream inputStream) throws ParsingException {
            return OpenSSLX509CRL.fromX509DerInputStream(inputStream);
        }

        @Override // org.conscrypt.OpenSSLX509CertificateFactory.Parser
        public OpenSSLX509CRL fromX509PemInputStream(InputStream inputStream) throws ParsingException {
            return OpenSSLX509CRL.fromX509PemInputStream(inputStream);
        }
    };

    /* loaded from: classes4.dex */
    public static abstract class Parser<T> {
        private Parser() {
        }

        public abstract List<? extends T> fromPkcs7DerInputStream(InputStream inputStream) throws ParsingException;

        public abstract List<? extends T> fromPkcs7PemInputStream(InputStream inputStream) throws ParsingException;

        public abstract T fromX509DerInputStream(InputStream inputStream) throws ParsingException;

        public abstract T fromX509PemInputStream(InputStream inputStream) throws ParsingException;

        public T generateItem(InputStream inputStream) throws ParsingException {
            if (inputStream != null) {
                boolean markSupported = inputStream.markSupported();
                if (markSupported) {
                    inputStream.mark(OpenSSLX509CertificateFactory.PKCS7_MARKER.length);
                }
                PushbackInputStream pushbackInputStream = new PushbackInputStream(inputStream, 64);
                try {
                    byte[] bArr = new byte[OpenSSLX509CertificateFactory.PKCS7_MARKER.length];
                    int read = pushbackInputStream.read(bArr);
                    if (read >= 0) {
                        pushbackInputStream.unread(bArr, 0, read);
                        if (bArr[0] == 45) {
                            if (read == OpenSSLX509CertificateFactory.PKCS7_MARKER.length && Arrays.equals(OpenSSLX509CertificateFactory.PKCS7_MARKER, bArr)) {
                                List<? extends T> fromPkcs7PemInputStream = fromPkcs7PemInputStream(pushbackInputStream);
                                if (fromPkcs7PemInputStream.size() == 0) {
                                    return null;
                                }
                                fromPkcs7PemInputStream.get(0);
                            } else {
                                return fromX509PemInputStream(pushbackInputStream);
                            }
                        }
                        if (bArr[4] == 6) {
                            List<? extends T> fromPkcs7DerInputStream = fromPkcs7DerInputStream(pushbackInputStream);
                            if (fromPkcs7DerInputStream.size() == 0) {
                                return null;
                            }
                            return fromPkcs7DerInputStream.get(0);
                        }
                        return fromX509DerInputStream(pushbackInputStream);
                    }
                    throw new ParsingException("inStream is empty");
                } catch (Exception e2) {
                    if (markSupported) {
                        try {
                            inputStream.reset();
                        } catch (IOException unused) {
                        }
                    }
                    throw new ParsingException(e2);
                }
            }
            throw new ParsingException("inStream == null");
        }

        public Collection<? extends T> generateItems(InputStream inputStream) throws ParsingException {
            T t;
            if (inputStream != null) {
                try {
                    if (inputStream.available() == 0) {
                        return Collections.emptyList();
                    }
                    boolean markSupported = inputStream.markSupported();
                    if (markSupported) {
                        inputStream.mark(64);
                    }
                    PushbackInputStream pushbackInputStream = new PushbackInputStream(inputStream, 64);
                    try {
                        byte[] bArr = new byte[OpenSSLX509CertificateFactory.PKCS7_MARKER.length];
                        int read = pushbackInputStream.read(bArr);
                        if (read >= 0) {
                            pushbackInputStream.unread(bArr, 0, read);
                            if (read == OpenSSLX509CertificateFactory.PKCS7_MARKER.length && Arrays.equals(OpenSSLX509CertificateFactory.PKCS7_MARKER, bArr)) {
                                return fromPkcs7PemInputStream(pushbackInputStream);
                            }
                            if (bArr[4] == 6) {
                                return fromPkcs7DerInputStream(pushbackInputStream);
                            }
                            ArrayList arrayList = new ArrayList();
                            do {
                                if (markSupported) {
                                    inputStream.mark(64);
                                }
                                try {
                                    t = generateItem(pushbackInputStream);
                                    arrayList.add(t);
                                    continue;
                                } catch (ParsingException unused) {
                                    if (markSupported) {
                                        try {
                                            inputStream.reset();
                                        } catch (IOException unused2) {
                                        }
                                    }
                                    t = null;
                                    continue;
                                }
                            } while (t != null);
                            return arrayList;
                        }
                        throw new ParsingException("inStream is empty");
                    } catch (Exception e2) {
                        if (markSupported) {
                            try {
                                inputStream.reset();
                            } catch (IOException unused3) {
                            }
                        }
                        throw new ParsingException(e2);
                    }
                } catch (IOException e3) {
                    throw new ParsingException("Problem reading input stream", e3);
                }
            }
            throw new ParsingException("inStream == null");
        }
    }

    /* loaded from: classes4.dex */
    public static class ParsingException extends Exception {
        private static final long serialVersionUID = 8390802697728301325L;

        public ParsingException(String str) {
            super(str);
        }

        public ParsingException(Exception exc) {
            super(exc);
        }

        public ParsingException(String str, Exception exc) {
            super(str, exc);
        }
    }

    @Override // java.security.cert.CertificateFactorySpi
    public CRL engineGenerateCRL(InputStream inputStream) throws CRLException {
        try {
            return this.crlParser.generateItem(inputStream);
        } catch (ParsingException e2) {
            throw new CRLException(e2);
        }
    }

    @Override // java.security.cert.CertificateFactorySpi
    public Collection<? extends CRL> engineGenerateCRLs(InputStream inputStream) throws CRLException {
        if (inputStream == null) {
            return Collections.emptyList();
        }
        try {
            return this.crlParser.generateItems(inputStream);
        } catch (ParsingException e2) {
            throw new CRLException(e2);
        }
    }

    @Override // java.security.cert.CertificateFactorySpi
    public CertPath engineGenerateCertPath(InputStream inputStream) throws CertificateException {
        return OpenSSLX509CertPath.fromEncoding(inputStream);
    }

    @Override // java.security.cert.CertificateFactorySpi
    public Certificate engineGenerateCertificate(InputStream inputStream) throws CertificateException {
        try {
            return this.certificateParser.generateItem(inputStream);
        } catch (ParsingException e2) {
            throw new CertificateException(e2);
        }
    }

    @Override // java.security.cert.CertificateFactorySpi
    public Collection<? extends Certificate> engineGenerateCertificates(InputStream inputStream) throws CertificateException {
        try {
            return this.certificateParser.generateItems(inputStream);
        } catch (ParsingException e2) {
            throw new CertificateException(e2);
        }
    }

    @Override // java.security.cert.CertificateFactorySpi
    public Iterator<String> engineGetCertPathEncodings() {
        return OpenSSLX509CertPath.getEncodingsIterator();
    }

    @Override // java.security.cert.CertificateFactorySpi
    public CertPath engineGenerateCertPath(InputStream inputStream, String str) throws CertificateException {
        return OpenSSLX509CertPath.fromEncoding(inputStream, str);
    }

    @Override // java.security.cert.CertificateFactorySpi
    public CertPath engineGenerateCertPath(List<? extends Certificate> list) throws CertificateException {
        ArrayList arrayList = new ArrayList(list.size());
        for (int i2 = 0; i2 < list.size(); i2++) {
            Certificate certificate = list.get(i2);
            if (certificate instanceof X509Certificate) {
                arrayList.add((X509Certificate) certificate);
            } else {
                throw new CertificateException("Certificate not X.509 type at index " + i2);
            }
        }
        return new OpenSSLX509CertPath(arrayList);
    }
}
