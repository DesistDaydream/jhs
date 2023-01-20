package org.conscrypt;

import com.caverock.androidsvg.SVG;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.SocketException;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.X509KeyManager;
import javax.security.auth.x500.X500Principal;
import k.b.a.a.c;
import org.conscrypt.NativeCrypto;
import org.conscrypt.SSLParametersImpl;

/* loaded from: classes4.dex */
public final class NativeSsl {
    private final SSLParametersImpl.AliasChooser aliasChooser;
    private final NativeCrypto.SSLHandshakeCallbacks handshakeCallbacks;
    private X509Certificate[] localCertificates;
    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private final SSLParametersImpl parameters;
    private final SSLParametersImpl.PSKCallbacks pskCallbacks;
    private volatile long ssl;

    /* loaded from: classes4.dex */
    public final class BioWrapper {
        private volatile long bio;

        public void close() {
            long j2 = this.bio;
            this.bio = 0L;
            NativeCrypto.BIO_free_all(j2);
        }

        public int getPendingWrittenBytes() {
            if (this.bio != 0) {
                return NativeCrypto.SSL_pending_written_bytes_in_BIO(this.bio);
            }
            return 0;
        }

        public int readDirectByteBuffer(long j2, int i2) throws IOException {
            return NativeCrypto.ENGINE_SSL_read_BIO_direct(NativeSsl.this.ssl, NativeSsl.this, this.bio, j2, i2, NativeSsl.this.handshakeCallbacks);
        }

        public int writeDirectByteBuffer(long j2, int i2) throws IOException {
            return NativeCrypto.ENGINE_SSL_write_BIO_direct(NativeSsl.this.ssl, NativeSsl.this, this.bio, j2, i2, NativeSsl.this.handshakeCallbacks);
        }

        private BioWrapper() throws SSLException {
            this.bio = NativeCrypto.SSL_BIO_new(NativeSsl.this.ssl, NativeSsl.this);
        }
    }

    private NativeSsl(long j2, SSLParametersImpl sSLParametersImpl, NativeCrypto.SSLHandshakeCallbacks sSLHandshakeCallbacks, SSLParametersImpl.AliasChooser aliasChooser, SSLParametersImpl.PSKCallbacks pSKCallbacks) {
        this.ssl = j2;
        this.parameters = sSLParametersImpl;
        this.handshakeCallbacks = sSLHandshakeCallbacks;
        this.aliasChooser = aliasChooser;
        this.pskCallbacks = pSKCallbacks;
    }

    private void enablePSKKeyManagerIfRequested() throws SSLException {
        PSKKeyManager pSKKeyManager = this.parameters.getPSKKeyManager();
        if (pSKKeyManager != null) {
            String[] strArr = this.parameters.enabledCipherSuites;
            int length = strArr.length;
            boolean z = false;
            int i2 = 0;
            while (true) {
                if (i2 < length) {
                    String str = strArr[i2];
                    if (str != null && str.contains("PSK")) {
                        z = true;
                        break;
                    }
                    i2++;
                } else {
                    break;
                }
            }
            if (z) {
                if (isClient()) {
                    NativeCrypto.set_SSL_psk_client_callback_enabled(this.ssl, this, true);
                    return;
                }
                NativeCrypto.set_SSL_psk_server_callback_enabled(this.ssl, this, true);
                NativeCrypto.SSL_use_psk_identity_hint(this.ssl, this, this.pskCallbacks.chooseServerPSKIdentityHint(pSKKeyManager));
            }
        }
    }

    private boolean isClient() {
        return this.parameters.getUseClientMode();
    }

    public static NativeSsl newInstance(SSLParametersImpl sSLParametersImpl, NativeCrypto.SSLHandshakeCallbacks sSLHandshakeCallbacks, SSLParametersImpl.AliasChooser aliasChooser, SSLParametersImpl.PSKCallbacks pSKCallbacks) throws SSLException {
        AbstractSessionContext sessionContext = sSLParametersImpl.getSessionContext();
        return new NativeSsl(NativeCrypto.SSL_new(sessionContext.sslCtxNativePointer, sessionContext), sSLParametersImpl, sSLHandshakeCallbacks, aliasChooser, pSKCallbacks);
    }

    private void setCertificateValidation() throws SSLException {
        X509Certificate[] acceptedIssuers;
        if (isClient()) {
            return;
        }
        boolean z = false;
        if (this.parameters.getNeedClientAuth()) {
            NativeCrypto.SSL_set_verify(this.ssl, this, 3);
        } else if (this.parameters.getWantClientAuth()) {
            NativeCrypto.SSL_set_verify(this.ssl, this, 1);
        } else {
            NativeCrypto.SSL_set_verify(this.ssl, this, 0);
            if (z || (acceptedIssuers = this.parameters.getX509TrustManager().getAcceptedIssuers()) == null || acceptedIssuers.length == 0) {
                return;
            }
            try {
                NativeCrypto.SSL_set_client_CA_list(this.ssl, this, SSLUtils.encodeSubjectX509Principals(acceptedIssuers));
                return;
            } catch (CertificateEncodingException e2) {
                throw new SSLException("Problem encoding principals", e2);
            }
        }
        z = true;
        if (z) {
        }
    }

    private void setTlsChannelId(OpenSSLKey openSSLKey) throws SSLException {
        SSLParametersImpl sSLParametersImpl = this.parameters;
        if (sSLParametersImpl.channelIdEnabled) {
            if (!sSLParametersImpl.getUseClientMode()) {
                NativeCrypto.SSL_enable_tls_channel_id(this.ssl, this);
            } else if (openSSLKey != null) {
                NativeCrypto.SSL_set1_tls_channel_id(this.ssl, this, openSSLKey.getNativeRef());
            } else {
                throw new SSLHandshakeException("Invalid TLS channel ID key specified");
            }
        }
    }

    public void chooseClientCertificate(byte[] bArr, int[] iArr, byte[][] bArr2) throws SSLException, CertificateEncodingException {
        X500Principal[] x500PrincipalArr;
        Set<String> supportedClientKeyTypes = SSLUtils.getSupportedClientKeyTypes(bArr, iArr);
        String[] strArr = (String[]) supportedClientKeyTypes.toArray(new String[supportedClientKeyTypes.size()]);
        if (bArr2 == null) {
            x500PrincipalArr = null;
        } else {
            x500PrincipalArr = new X500Principal[bArr2.length];
            for (int i2 = 0; i2 < bArr2.length; i2++) {
                x500PrincipalArr[i2] = new X500Principal(bArr2[i2]);
            }
        }
        X509KeyManager x509KeyManager = this.parameters.getX509KeyManager();
        setCertificate(x509KeyManager != null ? this.aliasChooser.chooseClientAlias(x509KeyManager, x500PrincipalArr, strArr) : null);
    }

    public int clientPSKKeyRequested(String str, byte[] bArr, byte[] bArr2) {
        byte[] bytes;
        String str2;
        byte[] bArr3;
        PSKKeyManager pSKKeyManager = this.parameters.getPSKKeyManager();
        if (pSKKeyManager == null) {
            return 0;
        }
        String chooseClientPSKIdentity = this.pskCallbacks.chooseClientPSKIdentity(pSKKeyManager, str);
        if (chooseClientPSKIdentity == null) {
            bArr3 = EmptyArray.BYTE;
            str2 = "";
        } else {
            if (chooseClientPSKIdentity.isEmpty()) {
                bytes = EmptyArray.BYTE;
            } else {
                try {
                    bytes = chooseClientPSKIdentity.getBytes("UTF-8");
                } catch (UnsupportedEncodingException e2) {
                    throw new RuntimeException("UTF-8 encoding not supported", e2);
                }
            }
            byte[] bArr4 = bytes;
            str2 = chooseClientPSKIdentity;
            bArr3 = bArr4;
        }
        if (bArr3.length + 1 > bArr.length) {
            return 0;
        }
        if (bArr3.length > 0) {
            System.arraycopy(bArr3, 0, bArr, 0, bArr3.length);
        }
        bArr[bArr3.length] = 0;
        byte[] encoded = this.pskCallbacks.getPSKKey(pSKKeyManager, str, str2).getEncoded();
        if (encoded != null && encoded.length <= bArr2.length) {
            System.arraycopy(encoded, 0, bArr2, 0, encoded.length);
            return encoded.length;
        }
        return 0;
    }

    public void close() {
        this.lock.writeLock().lock();
        try {
            if (!isClosed()) {
                long j2 = this.ssl;
                this.ssl = 0L;
                NativeCrypto.SSL_free(j2, this);
            }
        } finally {
            this.lock.writeLock().unlock();
        }
    }

    public void doHandshake(FileDescriptor fileDescriptor, int i2) throws CertificateException, IOException {
        this.lock.readLock().lock();
        try {
            if (!isClosed() && fileDescriptor != null && fileDescriptor.valid()) {
                NativeCrypto.SSL_do_handshake(this.ssl, this, fileDescriptor, this.handshakeCallbacks, i2);
                return;
            }
            throw new SocketException("Socket is closed");
        } finally {
            this.lock.readLock().unlock();
        }
    }

    public byte[] exportKeyingMaterial(String str, byte[] bArr, int i2) throws SSLException {
        Objects.requireNonNull(str, "Label is null");
        return NativeCrypto.SSL_export_keying_material(this.ssl, this, str.getBytes(Charset.forName(c.b)), bArr, i2);
    }

    public final void finalize() throws Throwable {
        try {
            close();
        } finally {
            super.finalize();
        }
    }

    public void forceRead() throws IOException {
        this.lock.readLock().lock();
        try {
            NativeCrypto.ENGINE_SSL_force_read(this.ssl, this, this.handshakeCallbacks);
        } finally {
            this.lock.readLock().unlock();
        }
    }

    public byte[] getApplicationProtocol() {
        return NativeCrypto.getApplicationProtocol(this.ssl, this);
    }

    public String getCipherSuite() {
        return NativeCrypto.cipherSuiteToJava(NativeCrypto.SSL_get_current_cipher(this.ssl, this));
    }

    public int getError(int i2) {
        return NativeCrypto.SSL_get_error(this.ssl, this, i2);
    }

    public X509Certificate[] getLocalCertificates() {
        return this.localCertificates;
    }

    public int getMaxSealOverhead() {
        return NativeCrypto.SSL_max_seal_overhead(this.ssl, this);
    }

    public byte[] getPeerCertificateOcspData() {
        return NativeCrypto.SSL_get_ocsp_response(this.ssl, this);
    }

    public X509Certificate[] getPeerCertificates() throws CertificateException {
        byte[][] SSL_get0_peer_certificates = NativeCrypto.SSL_get0_peer_certificates(this.ssl, this);
        if (SSL_get0_peer_certificates == null) {
            return null;
        }
        return SSLUtils.decodeX509CertificateChain(SSL_get0_peer_certificates);
    }

    public byte[] getPeerTlsSctData() {
        return NativeCrypto.SSL_get_signed_cert_timestamp_list(this.ssl, this);
    }

    public int getPendingReadableBytes() {
        this.lock.readLock().lock();
        try {
            return !isClosed() ? NativeCrypto.SSL_pending_readable_bytes(this.ssl, this) : 0;
        } finally {
            this.lock.readLock().unlock();
        }
    }

    public String getRequestedServerName() {
        return NativeCrypto.SSL_get_servername(this.ssl, this);
    }

    public byte[] getSessionId() {
        return NativeCrypto.SSL_session_id(this.ssl, this);
    }

    public long getTime() {
        return NativeCrypto.SSL_get_time(this.ssl, this);
    }

    public long getTimeout() {
        return NativeCrypto.SSL_get_timeout(this.ssl, this);
    }

    public byte[] getTlsChannelId() throws SSLException {
        return NativeCrypto.SSL_get_tls_channel_id(this.ssl, this);
    }

    public byte[] getTlsUnique() {
        return NativeCrypto.SSL_get_tls_unique(this.ssl, this);
    }

    public String getVersion() {
        return NativeCrypto.SSL_get_version(this.ssl, this);
    }

    public void initialize(String str, OpenSSLKey openSSLKey) throws IOException {
        if (!this.parameters.getEnableSessionCreation()) {
            NativeCrypto.SSL_set_session_creation_enabled(this.ssl, this, false);
        }
        NativeCrypto.SSL_accept_renegotiations(this.ssl, this);
        if (isClient()) {
            NativeCrypto.SSL_set_connect_state(this.ssl, this);
            NativeCrypto.SSL_enable_ocsp_stapling(this.ssl, this);
            if (this.parameters.isCTVerificationEnabled(str)) {
                NativeCrypto.SSL_enable_signed_cert_timestamps(this.ssl, this);
            }
        } else {
            NativeCrypto.SSL_set_accept_state(this.ssl, this);
            if (this.parameters.getOCSPResponse() != null) {
                NativeCrypto.SSL_enable_ocsp_stapling(this.ssl, this);
            }
        }
        if (this.parameters.getEnabledProtocols().length == 0 && this.parameters.isEnabledProtocolsFiltered) {
            throw new SSLHandshakeException("No enabled protocols; SSLv3 is no longer supported and was filtered from the list");
        }
        NativeCrypto.setEnabledProtocols(this.ssl, this, this.parameters.enabledProtocols);
        long j2 = this.ssl;
        SSLParametersImpl sSLParametersImpl = this.parameters;
        NativeCrypto.setEnabledCipherSuites(j2, this, sSLParametersImpl.enabledCipherSuites, sSLParametersImpl.enabledProtocols);
        if (this.parameters.applicationProtocols.length > 0) {
            NativeCrypto.setApplicationProtocols(this.ssl, this, isClient(), this.parameters.applicationProtocols);
        }
        if (!isClient() && this.parameters.applicationProtocolSelector != null) {
            NativeCrypto.setApplicationProtocolSelector(this.ssl, this, this.parameters.applicationProtocolSelector);
        }
        if (!isClient()) {
            HashSet<String> hashSet = new HashSet();
            for (long j3 : NativeCrypto.SSL_get_ciphers(this.ssl, this)) {
                String serverX509KeyType = SSLUtils.getServerX509KeyType(j3);
                if (serverX509KeyType != null) {
                    hashSet.add(serverX509KeyType);
                }
            }
            X509KeyManager x509KeyManager = this.parameters.getX509KeyManager();
            if (x509KeyManager != null) {
                for (String str2 : hashSet) {
                    try {
                        setCertificate(this.aliasChooser.chooseServerAlias(x509KeyManager, str2));
                    } catch (CertificateEncodingException e2) {
                        throw new IOException(e2);
                    }
                }
            }
            NativeCrypto.SSL_set_options(this.ssl, this, SVG.J);
            if (this.parameters.sctExtension != null) {
                NativeCrypto.SSL_set_signed_cert_timestamp_list(this.ssl, this, this.parameters.sctExtension);
            }
            if (this.parameters.ocspResponse != null) {
                NativeCrypto.SSL_set_ocsp_response(this.ssl, this, this.parameters.ocspResponse);
            }
        }
        enablePSKKeyManagerIfRequested();
        if (this.parameters.useSessionTickets) {
            NativeCrypto.SSL_clear_options(this.ssl, this, 16384L);
        } else {
            NativeCrypto.SSL_set_options(this.ssl, this, NativeCrypto.SSL_get_options(this.ssl, this) | 16384);
        }
        if (this.parameters.getUseSni() && AddressUtils.isValidSniHostname(str)) {
            NativeCrypto.SSL_set_tlsext_host_name(this.ssl, this, str);
        }
        NativeCrypto.SSL_set_mode(this.ssl, this, 256L);
        setCertificateValidation();
        setTlsChannelId(openSSLKey);
    }

    public void interrupt() {
        NativeCrypto.SSL_interrupt(this.ssl, this);
    }

    public boolean isClosed() {
        return this.ssl == 0;
    }

    public BioWrapper newBio() {
        try {
            return new BioWrapper();
        } catch (SSLException e2) {
            throw new RuntimeException(e2);
        }
    }

    public void offerToResumeSession(long j2) throws SSLException {
        NativeCrypto.SSL_set_session(this.ssl, this, j2);
    }

    public int read(FileDescriptor fileDescriptor, byte[] bArr, int i2, int i3, int i4) throws IOException {
        this.lock.readLock().lock();
        try {
            if (!isClosed() && fileDescriptor != null && fileDescriptor.valid()) {
                return NativeCrypto.SSL_read(this.ssl, this, fileDescriptor, this.handshakeCallbacks, bArr, i2, i3, i4);
            }
            throw new SocketException("Socket is closed");
        } finally {
            this.lock.readLock().unlock();
        }
    }

    public int readDirectByteBuffer(long j2, int i2) throws IOException, CertificateException {
        this.lock.readLock().lock();
        try {
            return NativeCrypto.ENGINE_SSL_read_direct(this.ssl, this, j2, i2, this.handshakeCallbacks);
        } finally {
            this.lock.readLock().unlock();
        }
    }

    public int serverPSKKeyRequested(String str, String str2, byte[] bArr) {
        byte[] encoded;
        PSKKeyManager pSKKeyManager = this.parameters.getPSKKeyManager();
        if (pSKKeyManager == null || (encoded = this.pskCallbacks.getPSKKey(pSKKeyManager, str, str2).getEncoded()) == null || encoded.length > bArr.length) {
            return 0;
        }
        System.arraycopy(encoded, 0, bArr, 0, encoded.length);
        return encoded.length;
    }

    public void setCertificate(String str) throws CertificateEncodingException, SSLException {
        X509KeyManager x509KeyManager;
        PrivateKey privateKey;
        if (str == null || (x509KeyManager = this.parameters.getX509KeyManager()) == null || (privateKey = x509KeyManager.getPrivateKey(str)) == null) {
            return;
        }
        X509Certificate[] certificateChain = x509KeyManager.getCertificateChain(str);
        this.localCertificates = certificateChain;
        if (certificateChain == null) {
            return;
        }
        int length = certificateChain.length;
        PublicKey publicKey = length > 0 ? certificateChain[0].getPublicKey() : null;
        byte[][] bArr = new byte[length];
        for (int i2 = 0; i2 < length; i2++) {
            bArr[i2] = this.localCertificates[i2].getEncoded();
        }
        try {
            NativeCrypto.setLocalCertsAndPrivateKey(this.ssl, this, bArr, OpenSSLKey.fromPrivateKeyForTLSStackOnly(privateKey, publicKey).getNativeRef());
        } catch (InvalidKeyException e2) {
            throw new SSLException(e2);
        }
    }

    public void setTimeout(long j2) {
        NativeCrypto.SSL_set_timeout(this.ssl, this, j2);
    }

    public void shutdown(FileDescriptor fileDescriptor) throws IOException {
        NativeCrypto.SSL_shutdown(this.ssl, this, fileDescriptor, this.handshakeCallbacks);
    }

    public boolean wasShutdownReceived() {
        this.lock.readLock().lock();
        try {
            return (NativeCrypto.SSL_get_shutdown(this.ssl, this) & 2) != 0;
        } finally {
            this.lock.readLock().unlock();
        }
    }

    public boolean wasShutdownSent() {
        this.lock.readLock().lock();
        try {
            return (NativeCrypto.SSL_get_shutdown(this.ssl, this) & 1) != 0;
        } finally {
            this.lock.readLock().unlock();
        }
    }

    public void write(FileDescriptor fileDescriptor, byte[] bArr, int i2, int i3, int i4) throws IOException {
        this.lock.readLock().lock();
        try {
            if (!isClosed() && fileDescriptor != null && fileDescriptor.valid()) {
                NativeCrypto.SSL_write(this.ssl, this, fileDescriptor, this.handshakeCallbacks, bArr, i2, i3, i4);
                return;
            }
            throw new SocketException("Socket is closed");
        } finally {
            this.lock.readLock().unlock();
        }
    }

    public int writeDirectByteBuffer(long j2, int i2) throws IOException {
        this.lock.readLock().lock();
        try {
            return NativeCrypto.ENGINE_SSL_write_direct(this.ssl, this, j2, i2, this.handshakeCallbacks);
        } finally {
            this.lock.readLock().unlock();
        }
    }

    public void shutdown() throws IOException {
        this.lock.readLock().lock();
        try {
            NativeCrypto.ENGINE_SSL_shutdown(this.ssl, this, this.handshakeCallbacks);
        } finally {
            this.lock.readLock().unlock();
        }
    }

    public int doHandshake() throws IOException {
        this.lock.readLock().lock();
        try {
            return NativeCrypto.ENGINE_SSL_do_handshake(this.ssl, this, this.handshakeCallbacks);
        } finally {
            this.lock.readLock().unlock();
        }
    }
}
