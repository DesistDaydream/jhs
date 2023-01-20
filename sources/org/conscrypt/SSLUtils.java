package org.conscrypt;

import com.tencent.bugly.Bugly;
import java.io.ByteArrayInputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import k.b.a.a.c;

/* loaded from: classes4.dex */
public final class SSLUtils {
    private static final String KEY_TYPE_EC = "EC";
    private static final String KEY_TYPE_RSA = "RSA";
    private static final int MAX_ENCRYPTION_OVERHEAD_DIFF = 2147483561;
    private static final int MAX_ENCRYPTION_OVERHEAD_LENGTH = 86;
    private static final int MAX_PROTOCOL_LENGTH = 255;
    public static final boolean USE_ENGINE_SOCKET_BY_DEFAULT = Boolean.parseBoolean(System.getProperty("org.conscrypt.useEngineSocketByDefault", Bugly.SDK_IS_DEV));
    private static final Charset US_ASCII = Charset.forName(c.b);

    /* loaded from: classes4.dex */
    public static final class EngineStates {
        public static final int STATE_CLOSED = 8;
        public static final int STATE_CLOSED_INBOUND = 6;
        public static final int STATE_CLOSED_OUTBOUND = 7;
        public static final int STATE_HANDSHAKE_COMPLETED = 3;
        public static final int STATE_HANDSHAKE_STARTED = 2;
        public static final int STATE_MODE_SET = 1;
        public static final int STATE_NEW = 0;
        public static final int STATE_READY = 5;
        public static final int STATE_READY_HANDSHAKE_CUT_THROUGH = 4;

        private EngineStates() {
        }
    }

    /* loaded from: classes4.dex */
    public enum SessionType {
        OPEN_SSL(1),
        OPEN_SSL_WITH_OCSP(2),
        OPEN_SSL_WITH_TLS_SCT(3);
        
        public final int value;

        SessionType(int i2) {
            this.value = i2;
        }

        public static boolean isSupportedType(int i2) {
            return i2 == OPEN_SSL.value || i2 == OPEN_SSL_WITH_OCSP.value || i2 == OPEN_SSL_WITH_TLS_SCT.value;
        }
    }

    private SSLUtils() {
    }

    public static int calculateOutNetBufSize(int i2) {
        return Math.min((int) NativeConstants.SSL3_RT_MAX_PACKET_SIZE, Math.min((int) MAX_ENCRYPTION_OVERHEAD_DIFF, i2) + 86);
    }

    public static String[] concat(String[]... strArr) {
        int i2 = 0;
        for (String[] strArr2 : strArr) {
            i2 += strArr2.length;
        }
        String[] strArr3 = new String[i2];
        int i3 = 0;
        for (String[] strArr4 : strArr) {
            System.arraycopy(strArr4, 0, strArr3, i3, strArr4.length);
            i3 += strArr4.length;
        }
        return strArr3;
    }

    public static String[] decodeProtocols(byte[] bArr) {
        String str;
        if (bArr.length == 0) {
            return EmptyArray.STRING;
        }
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i3 < bArr.length) {
            byte b = bArr[i3];
            if (b < 0 || b > bArr.length - i3) {
                StringBuilder sb = new StringBuilder();
                sb.append("Protocol has invalid length (");
                sb.append((int) b);
                sb.append(" at position ");
                sb.append(i3);
                sb.append("): ");
                if (bArr.length < 50) {
                    str = Arrays.toString(bArr);
                } else {
                    str = bArr.length + " byte array";
                }
                sb.append(str);
                throw new IllegalArgumentException(sb.toString());
            }
            i4++;
            i3 += b + 1;
        }
        String[] strArr = new String[i4];
        int i5 = 0;
        while (i2 < bArr.length) {
            byte b2 = bArr[i2];
            int i6 = i5 + 1;
            strArr[i5] = b2 > 0 ? new String(bArr, i2 + 1, b2, US_ASCII) : "";
            i2 += b2 + 1;
            i5 = i6;
        }
        return strArr;
    }

    private static X509Certificate decodeX509Certificate(CertificateFactory certificateFactory, byte[] bArr) throws CertificateException {
        if (certificateFactory != null) {
            return (X509Certificate) certificateFactory.generateCertificate(new ByteArrayInputStream(bArr));
        }
        return OpenSSLX509Certificate.fromX509Der(bArr);
    }

    public static X509Certificate[] decodeX509CertificateChain(byte[][] bArr) throws CertificateException {
        CertificateFactory certificateFactory = getCertificateFactory();
        int length = bArr.length;
        X509Certificate[] x509CertificateArr = new X509Certificate[length];
        for (int i2 = 0; i2 < length; i2++) {
            x509CertificateArr[i2] = decodeX509Certificate(certificateFactory, bArr[i2]);
        }
        return x509CertificateArr;
    }

    public static byte[] encodeProtocols(String[] strArr) {
        if (strArr != null) {
            if (strArr.length == 0) {
                return EmptyArray.BYTE;
            }
            int i2 = 0;
            for (int i3 = 0; i3 < strArr.length; i3++) {
                if (strArr[i3] != null) {
                    int length = strArr[i3].length();
                    if (length == 0 || length > 255) {
                        throw new IllegalArgumentException("protocol[" + i3 + "] has invalid length: " + length);
                    }
                    i2 += length + 1;
                } else {
                    throw new IllegalArgumentException("protocol[" + i3 + "] is null");
                }
            }
            byte[] bArr = new byte[i2];
            int i4 = 0;
            for (String str : strArr) {
                int length2 = str.length();
                bArr[i4] = (byte) length2;
                i4++;
                int i5 = 0;
                while (i5 < length2) {
                    char charAt = str.charAt(i5);
                    if (charAt <= 127) {
                        bArr[i4] = (byte) charAt;
                        i5++;
                        i4++;
                    } else {
                        throw new IllegalArgumentException("Protocol contains invalid character: " + charAt + "(protocol=" + str + ")");
                    }
                }
            }
            return bArr;
        }
        throw new IllegalArgumentException("protocols array must be non-null");
    }

    public static byte[][] encodeSubjectX509Principals(X509Certificate[] x509CertificateArr) throws CertificateEncodingException {
        byte[][] bArr = new byte[x509CertificateArr.length];
        for (int i2 = 0; i2 < x509CertificateArr.length; i2++) {
            bArr[i2] = x509CertificateArr[i2].getSubjectX500Principal().getEncoded();
        }
        return bArr;
    }

    private static CertificateFactory getCertificateFactory() {
        try {
            return CertificateFactory.getInstance("X.509");
        } catch (CertificateException unused) {
            return null;
        }
    }

    public static String getClientKeyType(byte b) {
        if (b != 1) {
            if (b != 64) {
                return null;
            }
            return KEY_TYPE_EC;
        }
        return KEY_TYPE_RSA;
    }

    public static String getClientKeyTypeFromSignatureAlg(int i2) {
        int SSL_get_signature_algorithm_key_type = NativeCrypto.SSL_get_signature_algorithm_key_type(i2);
        if (SSL_get_signature_algorithm_key_type != 6) {
            if (SSL_get_signature_algorithm_key_type != 408) {
                return null;
            }
            return KEY_TYPE_EC;
        }
        return KEY_TYPE_RSA;
    }

    public static int getEncryptedPacketLength(ByteBuffer[] byteBufferArr, int i2) {
        ByteBuffer byteBuffer = byteBufferArr[i2];
        if (byteBuffer.remaining() >= 5) {
            return getEncryptedPacketLength(byteBuffer);
        }
        ByteBuffer allocate = ByteBuffer.allocate(5);
        while (true) {
            int i3 = i2 + 1;
            ByteBuffer byteBuffer2 = byteBufferArr[i2];
            int position = byteBuffer2.position();
            int limit = byteBuffer2.limit();
            if (byteBuffer2.remaining() > allocate.remaining()) {
                byteBuffer2.limit(allocate.remaining() + position);
            }
            try {
                allocate.put(byteBuffer2);
                byteBuffer2.limit(limit);
                byteBuffer2.position(position);
                if (!allocate.hasRemaining()) {
                    allocate.flip();
                    return getEncryptedPacketLength(allocate);
                }
                i2 = i3;
            } catch (Throwable th) {
                byteBuffer2.limit(limit);
                byteBuffer2.position(position);
                throw th;
            }
        }
    }

    public static String getServerX509KeyType(long j2) throws SSLException {
        String SSL_CIPHER_get_kx_name = NativeCrypto.SSL_CIPHER_get_kx_name(j2);
        if (SSL_CIPHER_get_kx_name.equals(KEY_TYPE_RSA) || SSL_CIPHER_get_kx_name.equals("DHE_RSA") || SSL_CIPHER_get_kx_name.equals("ECDHE_RSA")) {
            return KEY_TYPE_RSA;
        }
        if (SSL_CIPHER_get_kx_name.equals("ECDHE_ECDSA")) {
            return KEY_TYPE_EC;
        }
        return null;
    }

    public static Set<String> getSupportedClientKeyTypes(byte[] bArr, int[] iArr) {
        HashSet hashSet = new HashSet(bArr.length);
        for (byte b : bArr) {
            String clientKeyType = getClientKeyType(b);
            if (clientKeyType != null) {
                hashSet.add(clientKeyType);
            }
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(iArr.length);
        for (int i2 : iArr) {
            String clientKeyTypeFromSignatureAlg = getClientKeyTypeFromSignatureAlg(i2);
            if (clientKeyTypeFromSignatureAlg != null) {
                linkedHashSet.add(clientKeyTypeFromSignatureAlg);
            }
        }
        if (bArr.length <= 0 || iArr.length <= 0) {
            return iArr.length > 0 ? linkedHashSet : hashSet;
        }
        linkedHashSet.retainAll(hashSet);
        return linkedHashSet;
    }

    public static javax.security.cert.X509Certificate[] toCertificateChain(X509Certificate[] x509CertificateArr) throws SSLPeerUnverifiedException {
        try {
            javax.security.cert.X509Certificate[] x509CertificateArr2 = new javax.security.cert.X509Certificate[x509CertificateArr.length];
            for (int i2 = 0; i2 < x509CertificateArr.length; i2++) {
                x509CertificateArr2[i2] = javax.security.cert.X509Certificate.getInstance(x509CertificateArr[i2].getEncoded());
            }
            return x509CertificateArr2;
        } catch (CertificateEncodingException e2) {
            SSLPeerUnverifiedException sSLPeerUnverifiedException = new SSLPeerUnverifiedException(e2.getMessage());
            sSLPeerUnverifiedException.initCause(sSLPeerUnverifiedException);
            throw sSLPeerUnverifiedException;
        } catch (javax.security.cert.CertificateException e3) {
            SSLPeerUnverifiedException sSLPeerUnverifiedException2 = new SSLPeerUnverifiedException(e3.getMessage());
            sSLPeerUnverifiedException2.initCause(sSLPeerUnverifiedException2);
            throw sSLPeerUnverifiedException2;
        }
    }

    public static byte[] toProtocolBytes(String str) {
        if (str == null) {
            return null;
        }
        return str.getBytes(US_ASCII);
    }

    public static String toProtocolString(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return new String(bArr, US_ASCII);
    }

    public static SSLException toSSLException(Throwable th) {
        if (th instanceof SSLException) {
            return (SSLException) th;
        }
        return new SSLException(th);
    }

    public static SSLHandshakeException toSSLHandshakeException(Throwable th) {
        if (th instanceof SSLHandshakeException) {
            return (SSLHandshakeException) th;
        }
        return (SSLHandshakeException) new SSLHandshakeException(th.getMessage()).initCause(th);
    }

    private static short unsignedByte(byte b) {
        return (short) (b & 255);
    }

    private static int unsignedShort(short s) {
        return s & 65535;
    }

    private static int getEncryptedPacketLength(ByteBuffer byteBuffer) {
        int unsignedShort;
        int position = byteBuffer.position();
        switch (unsignedByte(byteBuffer.get(position))) {
            case 20:
            case 21:
            case 22:
            case 23:
                if (unsignedByte(byteBuffer.get(position + 1)) == 3 && (unsignedShort = unsignedShort(byteBuffer.getShort(position + 3)) + 5) > 5) {
                    return unsignedShort;
                }
                return -1;
            default:
                return -1;
        }
    }
}
