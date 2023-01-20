package org.conscrypt;

import java.io.FileDescriptor;
import java.io.IOException;
import java.io.OutputStream;
import java.net.SocketTimeoutException;
import java.nio.Buffer;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.SignatureException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateParsingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.ShortBufferException;
import javax.net.ssl.SSLException;
import javax.security.auth.x500.X500Principal;
import org.conscrypt.NativeRef;
import org.conscrypt.OpenSSLX509CertificateFactory;

/* loaded from: classes4.dex */
public final class NativeCrypto {
    public static final String[] DEFAULT_PROTOCOLS;
    public static final String[] DEFAULT_PSK_CIPHER_SUITES;
    public static final String[] DEFAULT_X509_CIPHER_SUITES;
    public static final int EXTENSION_TYPE_CRITICAL = 1;
    public static final int EXTENSION_TYPE_NON_CRITICAL = 0;
    public static final int GN_STACK_ISSUER_ALT_NAME = 2;
    public static final int GN_STACK_SUBJECT_ALT_NAME = 1;
    private static final boolean HAS_AES_HARDWARE;
    public static final String OBSOLETE_PROTOCOL_SSLV3 = "SSLv3";
    public static final int PKCS7_CERTS = 1;
    public static final int PKCS7_CRLS = 2;
    private static final Set<String> SUPPORTED_LEGACY_CIPHER_SUITES_SET;
    private static final String[] SUPPORTED_PROTOCOLS;
    private static final String SUPPORTED_PROTOCOL_TLSV1 = "TLSv1";
    private static final String SUPPORTED_PROTOCOL_TLSV1_1 = "TLSv1.1";
    private static final String SUPPORTED_PROTOCOL_TLSV1_2 = "TLSv1.2";
    public static final String SUPPORTED_PROTOCOL_TLSV1_3 = "TLSv1.3";
    private static final String[] SUPPORTED_TLS_1_2_CIPHER_SUITES;
    public static final Set<String> SUPPORTED_TLS_1_2_CIPHER_SUITES_SET;
    public static final String[] SUPPORTED_TLS_1_3_CIPHER_SUITES;
    public static final Set<String> SUPPORTED_TLS_1_3_CIPHER_SUITES_SET;
    public static final String[] TLSV11_PROTOCOLS;
    public static final String[] TLSV12_PROTOCOLS;
    public static final String[] TLSV13_PROTOCOLS;
    public static final String[] TLSV1_PROTOCOLS;
    public static final String TLS_EMPTY_RENEGOTIATION_INFO_SCSV = "TLS_EMPTY_RENEGOTIATION_INFO_SCSV";
    private static final String TLS_FALLBACK_SCSV = "TLS_FALLBACK_SCSV";
    private static final UnsatisfiedLinkError loadError;

    /* loaded from: classes4.dex */
    public static class Range {
        public final String max;
        public final String min;

        public Range(String str, String str2) {
            this.min = str;
            this.max = str2;
        }
    }

    /* loaded from: classes4.dex */
    public interface SSLHandshakeCallbacks {
        void clientCertificateRequested(byte[] bArr, int[] iArr, byte[][] bArr2) throws CertificateEncodingException, SSLException;

        int clientPSKKeyRequested(String str, byte[] bArr, byte[] bArr2);

        void onNewSessionEstablished(long j2);

        void onSSLStateChange(int i2, int i3);

        int serverPSKKeyRequested(String str, String str2, byte[] bArr);

        long serverSessionRequested(byte[] bArr);

        void verifyCertificateChain(byte[][] bArr, String str) throws CertificateException;
    }

    static {
        String[] strArr;
        try {
            NativeCryptoJni.init();
            clinit();
            e = null;
        } catch (UnsatisfiedLinkError e2) {
            e = e2;
        }
        loadError = e;
        String[] strArr2 = {"TLS_AES_128_GCM_SHA256", "TLS_AES_256_GCM_SHA384", "TLS_CHACHA20_POLY1305_SHA256"};
        SUPPORTED_TLS_1_3_CIPHER_SUITES = strArr2;
        SUPPORTED_TLS_1_2_CIPHER_SUITES_SET = new HashSet();
        SUPPORTED_LEGACY_CIPHER_SUITES_SET = new HashSet();
        SUPPORTED_TLS_1_3_CIPHER_SUITES_SET = new HashSet(Arrays.asList(strArr2));
        if (e == null) {
            String[] strArr3 = get_cipher_names("ALL:!DHE");
            int length = strArr3.length;
            if (length % 2 == 0) {
                int i2 = length / 2;
                SUPPORTED_TLS_1_2_CIPHER_SUITES = new String[i2 + 2];
                for (int i3 = 0; i3 < length; i3 += 2) {
                    String cipherSuiteToJava = cipherSuiteToJava(strArr3[i3]);
                    SUPPORTED_TLS_1_2_CIPHER_SUITES[i3 / 2] = cipherSuiteToJava;
                    SUPPORTED_TLS_1_2_CIPHER_SUITES_SET.add(cipherSuiteToJava);
                    SUPPORTED_LEGACY_CIPHER_SUITES_SET.add(strArr3[i3 + 1]);
                }
                String[] strArr4 = SUPPORTED_TLS_1_2_CIPHER_SUITES;
                strArr4[i2] = TLS_EMPTY_RENEGOTIATION_INFO_SCSV;
                strArr4[i2 + 1] = TLS_FALLBACK_SCSV;
                HAS_AES_HARDWARE = EVP_has_aes_hardware() == 1;
            } else {
                throw new IllegalArgumentException("Invalid cipher list returned by get_cipher_names");
            }
        } else {
            HAS_AES_HARDWARE = false;
            SUPPORTED_TLS_1_2_CIPHER_SUITES = new String[0];
        }
        if (HAS_AES_HARDWARE) {
            strArr = new String[]{"TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256", "TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", "TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256", "TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256", "TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384", "TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256", "TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA", "TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA", "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA", "TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA", "TLS_RSA_WITH_AES_128_GCM_SHA256", "TLS_RSA_WITH_AES_256_GCM_SHA384", "TLS_RSA_WITH_AES_128_CBC_SHA", "TLS_RSA_WITH_AES_256_CBC_SHA"};
        } else {
            strArr = new String[]{"TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256", "TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256", "TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", "TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256", "TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256", "TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384", "TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA", "TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA", "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA", "TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA", "TLS_RSA_WITH_AES_128_GCM_SHA256", "TLS_RSA_WITH_AES_256_GCM_SHA384", "TLS_RSA_WITH_AES_128_CBC_SHA", "TLS_RSA_WITH_AES_256_CBC_SHA"};
        }
        DEFAULT_X509_CIPHER_SUITES = strArr;
        DEFAULT_PSK_CIPHER_SUITES = new String[]{"TLS_ECDHE_PSK_WITH_CHACHA20_POLY1305_SHA256", "TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA", "TLS_ECDHE_PSK_WITH_AES_256_CBC_SHA", "TLS_PSK_WITH_AES_128_CBC_SHA", "TLS_PSK_WITH_AES_256_CBC_SHA"};
        String[] strArr5 = {SUPPORTED_PROTOCOL_TLSV1, SUPPORTED_PROTOCOL_TLSV1_1, SUPPORTED_PROTOCOL_TLSV1_2, SUPPORTED_PROTOCOL_TLSV1_3};
        TLSV13_PROTOCOLS = strArr5;
        String[] strArr6 = {SUPPORTED_PROTOCOL_TLSV1, SUPPORTED_PROTOCOL_TLSV1_1, SUPPORTED_PROTOCOL_TLSV1_2};
        TLSV12_PROTOCOLS = strArr6;
        TLSV11_PROTOCOLS = strArr6;
        TLSV1_PROTOCOLS = strArr6;
        DEFAULT_PROTOCOLS = strArr5;
        SUPPORTED_PROTOCOLS = new String[]{SUPPORTED_PROTOCOL_TLSV1, SUPPORTED_PROTOCOL_TLSV1_1, SUPPORTED_PROTOCOL_TLSV1_2, SUPPORTED_PROTOCOL_TLSV1_3};
    }

    public static native void ASN1_TIME_to_Calendar(long j2, Calendar calendar) throws OpenSSLX509CertificateFactory.ParsingException;

    public static native byte[] ASN1_seq_pack_X509(long[] jArr);

    public static native long[] ASN1_seq_unpack_X509_bio(long j2) throws OpenSSLX509CertificateFactory.ParsingException;

    public static native void BIO_free_all(long j2);

    public static native int BIO_read(long j2, byte[] bArr) throws IOException;

    public static native void BIO_write(long j2, byte[] bArr, int i2, int i3) throws IOException, IndexOutOfBoundsException;

    public static native int ECDH_compute_key(byte[] bArr, int i2, NativeRef.EVP_PKEY evp_pkey, NativeRef.EVP_PKEY evp_pkey2) throws InvalidKeyException, IndexOutOfBoundsException;

    public static native int ECDSA_sign(byte[] bArr, byte[] bArr2, NativeRef.EVP_PKEY evp_pkey);

    public static native int ECDSA_size(NativeRef.EVP_PKEY evp_pkey);

    public static native int ECDSA_verify(byte[] bArr, byte[] bArr2, NativeRef.EVP_PKEY evp_pkey);

    public static native void EC_GROUP_clear_free(long j2);

    public static native byte[] EC_GROUP_get_cofactor(NativeRef.EC_GROUP ec_group);

    public static native byte[][] EC_GROUP_get_curve(NativeRef.EC_GROUP ec_group);

    public static native String EC_GROUP_get_curve_name(NativeRef.EC_GROUP ec_group);

    public static native int EC_GROUP_get_degree(NativeRef.EC_GROUP ec_group);

    public static native long EC_GROUP_get_generator(NativeRef.EC_GROUP ec_group);

    public static native byte[] EC_GROUP_get_order(NativeRef.EC_GROUP ec_group);

    public static native long EC_GROUP_new_arbitrary(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5, byte[] bArr6, int i2);

    public static native long EC_GROUP_new_by_curve_name(String str);

    public static native long EC_KEY_generate_key(NativeRef.EC_GROUP ec_group);

    public static native long EC_KEY_get1_group(NativeRef.EVP_PKEY evp_pkey);

    public static native byte[] EC_KEY_get_private_key(NativeRef.EVP_PKEY evp_pkey);

    public static native long EC_KEY_get_public_key(NativeRef.EVP_PKEY evp_pkey);

    public static native byte[] EC_KEY_marshal_curve_name(NativeRef.EC_GROUP ec_group) throws IOException;

    public static native long EC_KEY_parse_curve_name(byte[] bArr) throws IOException;

    public static native void EC_POINT_clear_free(long j2);

    public static native byte[][] EC_POINT_get_affine_coordinates(NativeRef.EC_GROUP ec_group, NativeRef.EC_POINT ec_point);

    public static native long EC_POINT_new(NativeRef.EC_GROUP ec_group);

    public static native void EC_POINT_set_affine_coordinates(NativeRef.EC_GROUP ec_group, NativeRef.EC_POINT ec_point, byte[] bArr, byte[] bArr2);

    public static native int ENGINE_SSL_do_handshake(long j2, NativeSsl nativeSsl, SSLHandshakeCallbacks sSLHandshakeCallbacks) throws IOException;

    public static native void ENGINE_SSL_force_read(long j2, NativeSsl nativeSsl, SSLHandshakeCallbacks sSLHandshakeCallbacks) throws IOException;

    public static native int ENGINE_SSL_read_BIO_direct(long j2, NativeSsl nativeSsl, long j3, long j4, int i2, SSLHandshakeCallbacks sSLHandshakeCallbacks) throws IOException;

    public static native int ENGINE_SSL_read_BIO_heap(long j2, NativeSsl nativeSsl, long j3, byte[] bArr, int i2, int i3, SSLHandshakeCallbacks sSLHandshakeCallbacks) throws IOException, IndexOutOfBoundsException;

    public static native int ENGINE_SSL_read_direct(long j2, NativeSsl nativeSsl, long j3, int i2, SSLHandshakeCallbacks sSLHandshakeCallbacks) throws IOException, CertificateException;

    public static native void ENGINE_SSL_shutdown(long j2, NativeSsl nativeSsl, SSLHandshakeCallbacks sSLHandshakeCallbacks) throws IOException;

    public static native int ENGINE_SSL_write_BIO_direct(long j2, NativeSsl nativeSsl, long j3, long j4, int i2, SSLHandshakeCallbacks sSLHandshakeCallbacks) throws IOException;

    public static native int ENGINE_SSL_write_BIO_heap(long j2, NativeSsl nativeSsl, long j3, byte[] bArr, int i2, int i3, SSLHandshakeCallbacks sSLHandshakeCallbacks) throws IOException, IndexOutOfBoundsException;

    public static native int ENGINE_SSL_write_direct(long j2, NativeSsl nativeSsl, long j3, int i2, SSLHandshakeCallbacks sSLHandshakeCallbacks) throws IOException;

    public static native int EVP_AEAD_CTX_open(long j2, byte[] bArr, int i2, byte[] bArr2, int i3, byte[] bArr3, byte[] bArr4, int i4, int i5, byte[] bArr5) throws ShortBufferException, BadPaddingException, IndexOutOfBoundsException;

    public static native int EVP_AEAD_CTX_seal(long j2, byte[] bArr, int i2, byte[] bArr2, int i3, byte[] bArr3, byte[] bArr4, int i4, int i5, byte[] bArr5) throws ShortBufferException, BadPaddingException, IndexOutOfBoundsException;

    public static native int EVP_AEAD_max_overhead(long j2);

    public static native int EVP_AEAD_nonce_length(long j2);

    public static native int EVP_CIPHER_CTX_block_size(NativeRef.EVP_CIPHER_CTX evp_cipher_ctx);

    public static native void EVP_CIPHER_CTX_free(long j2);

    public static native long EVP_CIPHER_CTX_new();

    public static native void EVP_CIPHER_CTX_set_key_length(NativeRef.EVP_CIPHER_CTX evp_cipher_ctx, int i2);

    public static native void EVP_CIPHER_CTX_set_padding(NativeRef.EVP_CIPHER_CTX evp_cipher_ctx, boolean z);

    public static native int EVP_CIPHER_iv_length(long j2);

    public static native int EVP_CipherFinal_ex(NativeRef.EVP_CIPHER_CTX evp_cipher_ctx, byte[] bArr, int i2) throws BadPaddingException, IllegalBlockSizeException;

    public static native void EVP_CipherInit_ex(NativeRef.EVP_CIPHER_CTX evp_cipher_ctx, long j2, byte[] bArr, byte[] bArr2, boolean z);

    public static native int EVP_CipherUpdate(NativeRef.EVP_CIPHER_CTX evp_cipher_ctx, byte[] bArr, int i2, byte[] bArr2, int i3, int i4) throws IndexOutOfBoundsException;

    public static native int EVP_DigestFinal_ex(NativeRef.EVP_MD_CTX evp_md_ctx, byte[] bArr, int i2);

    public static native int EVP_DigestInit_ex(NativeRef.EVP_MD_CTX evp_md_ctx, long j2);

    public static native byte[] EVP_DigestSignFinal(NativeRef.EVP_MD_CTX evp_md_ctx);

    public static native long EVP_DigestSignInit(NativeRef.EVP_MD_CTX evp_md_ctx, long j2, NativeRef.EVP_PKEY evp_pkey);

    public static native void EVP_DigestSignUpdate(NativeRef.EVP_MD_CTX evp_md_ctx, byte[] bArr, int i2, int i3);

    public static native void EVP_DigestSignUpdateDirect(NativeRef.EVP_MD_CTX evp_md_ctx, long j2, int i2);

    public static native void EVP_DigestUpdate(NativeRef.EVP_MD_CTX evp_md_ctx, byte[] bArr, int i2, int i3);

    public static native void EVP_DigestUpdateDirect(NativeRef.EVP_MD_CTX evp_md_ctx, long j2, int i2);

    public static native boolean EVP_DigestVerifyFinal(NativeRef.EVP_MD_CTX evp_md_ctx, byte[] bArr, int i2, int i3) throws IndexOutOfBoundsException;

    public static native long EVP_DigestVerifyInit(NativeRef.EVP_MD_CTX evp_md_ctx, long j2, NativeRef.EVP_PKEY evp_pkey);

    public static native void EVP_DigestVerifyUpdate(NativeRef.EVP_MD_CTX evp_md_ctx, byte[] bArr, int i2, int i3);

    public static native void EVP_DigestVerifyUpdateDirect(NativeRef.EVP_MD_CTX evp_md_ctx, long j2, int i2);

    public static native void EVP_MD_CTX_cleanup(NativeRef.EVP_MD_CTX evp_md_ctx);

    public static native int EVP_MD_CTX_copy_ex(NativeRef.EVP_MD_CTX evp_md_ctx, NativeRef.EVP_MD_CTX evp_md_ctx2);

    public static native long EVP_MD_CTX_create();

    public static native void EVP_MD_CTX_destroy(long j2);

    public static native int EVP_MD_size(long j2);

    public static native void EVP_PKEY_CTX_free(long j2);

    public static native void EVP_PKEY_CTX_set_rsa_mgf1_md(long j2, long j3) throws InvalidAlgorithmParameterException;

    public static native void EVP_PKEY_CTX_set_rsa_oaep_label(long j2, byte[] bArr) throws InvalidAlgorithmParameterException;

    public static native void EVP_PKEY_CTX_set_rsa_oaep_md(long j2, long j3) throws InvalidAlgorithmParameterException;

    public static native void EVP_PKEY_CTX_set_rsa_padding(long j2, int i2) throws InvalidAlgorithmParameterException;

    public static native void EVP_PKEY_CTX_set_rsa_pss_saltlen(long j2, int i2) throws InvalidAlgorithmParameterException;

    public static native int EVP_PKEY_cmp(NativeRef.EVP_PKEY evp_pkey, NativeRef.EVP_PKEY evp_pkey2);

    public static native int EVP_PKEY_decrypt(NativeRef.EVP_PKEY_CTX evp_pkey_ctx, byte[] bArr, int i2, byte[] bArr2, int i3, int i4) throws IndexOutOfBoundsException, BadPaddingException;

    public static native long EVP_PKEY_decrypt_init(NativeRef.EVP_PKEY evp_pkey) throws InvalidKeyException;

    public static native int EVP_PKEY_encrypt(NativeRef.EVP_PKEY_CTX evp_pkey_ctx, byte[] bArr, int i2, byte[] bArr2, int i3, int i4) throws IndexOutOfBoundsException, BadPaddingException;

    public static native long EVP_PKEY_encrypt_init(NativeRef.EVP_PKEY evp_pkey) throws InvalidKeyException;

    public static native void EVP_PKEY_free(long j2);

    public static native long EVP_PKEY_new_EC_KEY(NativeRef.EC_GROUP ec_group, NativeRef.EC_POINT ec_point, byte[] bArr);

    public static native long EVP_PKEY_new_RSA(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5, byte[] bArr6, byte[] bArr7, byte[] bArr8);

    public static native String EVP_PKEY_print_params(NativeRef.EVP_PKEY evp_pkey);

    public static native String EVP_PKEY_print_public(NativeRef.EVP_PKEY evp_pkey);

    public static native int EVP_PKEY_type(NativeRef.EVP_PKEY evp_pkey);

    public static native long EVP_aead_aes_128_gcm();

    public static native long EVP_aead_aes_128_gcm_siv();

    public static native long EVP_aead_aes_256_gcm();

    public static native long EVP_aead_aes_256_gcm_siv();

    public static native long EVP_aead_chacha20_poly1305();

    public static native long EVP_get_cipherbyname(String str);

    public static native long EVP_get_digestbyname(String str);

    public static native int EVP_has_aes_hardware();

    public static native byte[] EVP_marshal_private_key(NativeRef.EVP_PKEY evp_pkey);

    public static native byte[] EVP_marshal_public_key(NativeRef.EVP_PKEY evp_pkey);

    public static native long EVP_parse_private_key(byte[] bArr) throws OpenSSLX509CertificateFactory.ParsingException;

    public static native long EVP_parse_public_key(byte[] bArr) throws OpenSSLX509CertificateFactory.ParsingException;

    public static native void HMAC_CTX_free(long j2);

    public static native long HMAC_CTX_new();

    public static native byte[] HMAC_Final(NativeRef.HMAC_CTX hmac_ctx);

    public static native void HMAC_Init_ex(NativeRef.HMAC_CTX hmac_ctx, byte[] bArr, long j2);

    public static native void HMAC_Update(NativeRef.HMAC_CTX hmac_ctx, byte[] bArr, int i2, int i3);

    public static native void HMAC_UpdateDirect(NativeRef.HMAC_CTX hmac_ctx, long j2, int i2);

    public static native long[] PEM_read_bio_PKCS7(long j2, int i2);

    public static native long PEM_read_bio_PUBKEY(long j2);

    public static native long PEM_read_bio_PrivateKey(long j2);

    public static native long PEM_read_bio_X509(long j2);

    public static native long PEM_read_bio_X509_CRL(long j2);

    public static native void RAND_bytes(byte[] bArr);

    public static native long RSA_generate_key_ex(int i2, byte[] bArr);

    public static native int RSA_private_decrypt(int i2, byte[] bArr, byte[] bArr2, NativeRef.EVP_PKEY evp_pkey, int i3) throws BadPaddingException, SignatureException;

    public static native int RSA_private_encrypt(int i2, byte[] bArr, byte[] bArr2, NativeRef.EVP_PKEY evp_pkey, int i3);

    public static native int RSA_public_decrypt(int i2, byte[] bArr, byte[] bArr2, NativeRef.EVP_PKEY evp_pkey, int i3) throws BadPaddingException, SignatureException;

    public static native int RSA_public_encrypt(int i2, byte[] bArr, byte[] bArr2, NativeRef.EVP_PKEY evp_pkey, int i3);

    public static native int RSA_size(NativeRef.EVP_PKEY evp_pkey);

    public static native long SSL_BIO_new(long j2, NativeSsl nativeSsl) throws SSLException;

    public static native String SSL_CIPHER_get_kx_name(long j2);

    public static native void SSL_CTX_free(long j2, AbstractSessionContext abstractSessionContext);

    public static native long SSL_CTX_new();

    public static native void SSL_CTX_set_session_id_context(long j2, AbstractSessionContext abstractSessionContext, byte[] bArr);

    public static native long SSL_CTX_set_timeout(long j2, AbstractSessionContext abstractSessionContext, long j3);

    public static native String SSL_SESSION_cipher(long j2);

    public static native void SSL_SESSION_free(long j2);

    public static native long SSL_SESSION_get_time(long j2);

    public static native long SSL_SESSION_get_timeout(long j2);

    public static native String SSL_SESSION_get_version(long j2);

    public static native byte[] SSL_SESSION_session_id(long j2);

    public static native boolean SSL_SESSION_should_be_single_use(long j2);

    public static native void SSL_SESSION_up_ref(long j2);

    public static native void SSL_accept_renegotiations(long j2, NativeSsl nativeSsl) throws SSLException;

    public static native void SSL_clear_error();

    public static native long SSL_clear_mode(long j2, NativeSsl nativeSsl, long j3);

    public static native long SSL_clear_options(long j2, NativeSsl nativeSsl, long j3);

    public static native void SSL_do_handshake(long j2, NativeSsl nativeSsl, FileDescriptor fileDescriptor, SSLHandshakeCallbacks sSLHandshakeCallbacks, int i2) throws SSLException, SocketTimeoutException, CertificateException;

    public static native void SSL_enable_ocsp_stapling(long j2, NativeSsl nativeSsl);

    public static native void SSL_enable_signed_cert_timestamps(long j2, NativeSsl nativeSsl);

    public static native void SSL_enable_tls_channel_id(long j2, NativeSsl nativeSsl) throws SSLException;

    public static native byte[] SSL_export_keying_material(long j2, NativeSsl nativeSsl, byte[] bArr, byte[] bArr2, int i2) throws SSLException;

    public static native void SSL_free(long j2, NativeSsl nativeSsl);

    public static native byte[][] SSL_get0_peer_certificates(long j2, NativeSsl nativeSsl);

    public static native long SSL_get1_session(long j2, NativeSsl nativeSsl);

    public static native long[] SSL_get_ciphers(long j2, NativeSsl nativeSsl);

    public static native String SSL_get_current_cipher(long j2, NativeSsl nativeSsl);

    public static native int SSL_get_error(long j2, NativeSsl nativeSsl, int i2);

    public static native long SSL_get_mode(long j2, NativeSsl nativeSsl);

    public static native byte[] SSL_get_ocsp_response(long j2, NativeSsl nativeSsl);

    public static native long SSL_get_options(long j2, NativeSsl nativeSsl);

    public static native String SSL_get_servername(long j2, NativeSsl nativeSsl);

    public static native int SSL_get_shutdown(long j2, NativeSsl nativeSsl);

    public static native int SSL_get_signature_algorithm_key_type(int i2);

    public static native byte[] SSL_get_signed_cert_timestamp_list(long j2, NativeSsl nativeSsl);

    public static native long SSL_get_time(long j2, NativeSsl nativeSsl);

    public static native long SSL_get_timeout(long j2, NativeSsl nativeSsl);

    public static native byte[] SSL_get_tls_channel_id(long j2, NativeSsl nativeSsl) throws SSLException;

    public static native byte[] SSL_get_tls_unique(long j2, NativeSsl nativeSsl);

    public static native String SSL_get_version(long j2, NativeSsl nativeSsl);

    public static native void SSL_interrupt(long j2, NativeSsl nativeSsl);

    public static native int SSL_max_seal_overhead(long j2, NativeSsl nativeSsl);

    public static native long SSL_new(long j2, AbstractSessionContext abstractSessionContext) throws SSLException;

    public static native int SSL_pending_readable_bytes(long j2, NativeSsl nativeSsl);

    public static native int SSL_pending_written_bytes_in_BIO(long j2);

    public static native int SSL_read(long j2, NativeSsl nativeSsl, FileDescriptor fileDescriptor, SSLHandshakeCallbacks sSLHandshakeCallbacks, byte[] bArr, int i2, int i3, int i4) throws IOException;

    public static native byte[] SSL_session_id(long j2, NativeSsl nativeSsl);

    public static native boolean SSL_session_reused(long j2, NativeSsl nativeSsl);

    public static native void SSL_set1_tls_channel_id(long j2, NativeSsl nativeSsl, NativeRef.EVP_PKEY evp_pkey);

    public static native void SSL_set_accept_state(long j2, NativeSsl nativeSsl);

    public static native void SSL_set_cipher_lists(long j2, NativeSsl nativeSsl, String[] strArr);

    public static native void SSL_set_client_CA_list(long j2, NativeSsl nativeSsl, byte[][] bArr) throws SSLException;

    public static native void SSL_set_connect_state(long j2, NativeSsl nativeSsl);

    public static native long SSL_set_mode(long j2, NativeSsl nativeSsl, long j3);

    public static native void SSL_set_ocsp_response(long j2, NativeSsl nativeSsl, byte[] bArr);

    public static native long SSL_set_options(long j2, NativeSsl nativeSsl, long j3);

    public static native int SSL_set_protocol_versions(long j2, NativeSsl nativeSsl, int i2, int i3);

    public static native void SSL_set_session(long j2, NativeSsl nativeSsl, long j3) throws SSLException;

    public static native void SSL_set_session_creation_enabled(long j2, NativeSsl nativeSsl, boolean z) throws SSLException;

    public static native void SSL_set_signed_cert_timestamp_list(long j2, NativeSsl nativeSsl, byte[] bArr);

    public static native long SSL_set_timeout(long j2, NativeSsl nativeSsl, long j3);

    public static native void SSL_set_tlsext_host_name(long j2, NativeSsl nativeSsl, String str) throws SSLException;

    public static native void SSL_set_verify(long j2, NativeSsl nativeSsl, int i2);

    public static native void SSL_shutdown(long j2, NativeSsl nativeSsl, FileDescriptor fileDescriptor, SSLHandshakeCallbacks sSLHandshakeCallbacks) throws IOException;

    public static native void SSL_use_psk_identity_hint(long j2, NativeSsl nativeSsl, String str) throws SSLException;

    public static native void SSL_write(long j2, NativeSsl nativeSsl, FileDescriptor fileDescriptor, SSLHandshakeCallbacks sSLHandshakeCallbacks, byte[] bArr, int i2, int i3, int i4) throws IOException;

    public static native void X509_CRL_free(long j2, OpenSSLX509CRL openSSLX509CRL);

    public static native long X509_CRL_get0_by_cert(long j2, OpenSSLX509CRL openSSLX509CRL, long j3, OpenSSLX509Certificate openSSLX509Certificate);

    public static native long X509_CRL_get0_by_serial(long j2, OpenSSLX509CRL openSSLX509CRL, byte[] bArr);

    public static native long[] X509_CRL_get_REVOKED(long j2, OpenSSLX509CRL openSSLX509CRL);

    public static native long X509_CRL_get_ext(long j2, OpenSSLX509CRL openSSLX509CRL, String str);

    public static native byte[] X509_CRL_get_ext_oid(long j2, OpenSSLX509CRL openSSLX509CRL, String str);

    public static native byte[] X509_CRL_get_issuer_name(long j2, OpenSSLX509CRL openSSLX509CRL);

    public static native long X509_CRL_get_lastUpdate(long j2, OpenSSLX509CRL openSSLX509CRL);

    public static native long X509_CRL_get_nextUpdate(long j2, OpenSSLX509CRL openSSLX509CRL);

    public static native long X509_CRL_get_version(long j2, OpenSSLX509CRL openSSLX509CRL);

    public static native void X509_CRL_print(long j2, long j3, OpenSSLX509CRL openSSLX509CRL);

    public static native void X509_CRL_verify(long j2, OpenSSLX509CRL openSSLX509CRL, NativeRef.EVP_PKEY evp_pkey) throws BadPaddingException, SignatureException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException;

    public static int X509_NAME_hash(X500Principal x500Principal) {
        return X509_NAME_hash(x500Principal, "SHA1");
    }

    public static int X509_NAME_hash_old(X500Principal x500Principal) {
        return X509_NAME_hash(x500Principal, "MD5");
    }

    public static native long X509_REVOKED_dup(long j2);

    public static native long X509_REVOKED_get_ext(long j2, String str);

    public static native byte[] X509_REVOKED_get_ext_oid(long j2, String str);

    public static native byte[] X509_REVOKED_get_serialNumber(long j2);

    public static native void X509_REVOKED_print(long j2, long j3);

    public static native int X509_check_issued(long j2, OpenSSLX509Certificate openSSLX509Certificate, long j3, OpenSSLX509Certificate openSSLX509Certificate2);

    public static native int X509_cmp(long j2, OpenSSLX509Certificate openSSLX509Certificate, long j3, OpenSSLX509Certificate openSSLX509Certificate2);

    public static native void X509_delete_ext(long j2, OpenSSLX509Certificate openSSLX509Certificate, String str);

    public static native long X509_dup(long j2, OpenSSLX509Certificate openSSLX509Certificate);

    public static native void X509_free(long j2, OpenSSLX509Certificate openSSLX509Certificate);

    public static native byte[] X509_get_ext_oid(long j2, OpenSSLX509Certificate openSSLX509Certificate, String str);

    public static native byte[] X509_get_issuer_name(long j2, OpenSSLX509Certificate openSSLX509Certificate);

    public static native long X509_get_notAfter(long j2, OpenSSLX509Certificate openSSLX509Certificate);

    public static native long X509_get_notBefore(long j2, OpenSSLX509Certificate openSSLX509Certificate);

    public static native long X509_get_pubkey(long j2, OpenSSLX509Certificate openSSLX509Certificate) throws NoSuchAlgorithmException, InvalidKeyException;

    public static native byte[] X509_get_serialNumber(long j2, OpenSSLX509Certificate openSSLX509Certificate);

    public static native byte[] X509_get_subject_name(long j2, OpenSSLX509Certificate openSSLX509Certificate);

    public static native long X509_get_version(long j2, OpenSSLX509Certificate openSSLX509Certificate);

    public static native void X509_print_ex(long j2, long j3, OpenSSLX509Certificate openSSLX509Certificate, long j4, long j5);

    public static native int X509_supported_extension(long j2);

    public static native void X509_verify(long j2, OpenSSLX509Certificate openSSLX509Certificate, NativeRef.EVP_PKEY evp_pkey) throws BadPaddingException;

    public static native void asn1_read_free(long j2);

    public static native long asn1_read_init(byte[] bArr) throws IOException;

    public static native boolean asn1_read_is_empty(long j2);

    public static native boolean asn1_read_next_tag_is(long j2, int i2) throws IOException;

    public static native void asn1_read_null(long j2) throws IOException;

    public static native byte[] asn1_read_octetstring(long j2) throws IOException;

    public static native String asn1_read_oid(long j2) throws IOException;

    public static native long asn1_read_sequence(long j2) throws IOException;

    public static native long asn1_read_tagged(long j2) throws IOException;

    public static native long asn1_read_uint64(long j2) throws IOException;

    public static native void asn1_write_cleanup(long j2);

    public static native byte[] asn1_write_finish(long j2) throws IOException;

    public static native void asn1_write_flush(long j2) throws IOException;

    public static native void asn1_write_free(long j2);

    public static native long asn1_write_init() throws IOException;

    public static native void asn1_write_null(long j2) throws IOException;

    public static native void asn1_write_octetstring(long j2, byte[] bArr) throws IOException;

    public static native void asn1_write_oid(long j2, String str) throws IOException;

    public static native long asn1_write_sequence(long j2) throws IOException;

    public static native long asn1_write_tag(long j2, int i2) throws IOException;

    public static native void asn1_write_uint64(long j2, long j3) throws IOException;

    public static native void chacha20_encrypt_decrypt(byte[] bArr, int i2, byte[] bArr2, int i3, int i4, byte[] bArr3, byte[] bArr4, int i5);

    public static void checkAvailability() {
        UnsatisfiedLinkError unsatisfiedLinkError = loadError;
        if (unsatisfiedLinkError != null) {
            throw unsatisfiedLinkError;
        }
    }

    public static String[] checkEnabledCipherSuites(String[] strArr) {
        if (strArr != null) {
            for (int i2 = 0; i2 < strArr.length; i2++) {
                if (strArr[i2] != null) {
                    if (!strArr[i2].equals(TLS_EMPTY_RENEGOTIATION_INFO_SCSV) && !strArr[i2].equals(TLS_FALLBACK_SCSV) && !SUPPORTED_TLS_1_2_CIPHER_SUITES_SET.contains(strArr[i2]) && !SUPPORTED_LEGACY_CIPHER_SUITES_SET.contains(strArr[i2])) {
                        throw new IllegalArgumentException("cipherSuite " + strArr[i2] + " is not supported.");
                    }
                } else {
                    throw new IllegalArgumentException("cipherSuites[" + i2 + "] == null");
                }
            }
            return strArr;
        }
        throw new IllegalArgumentException("cipherSuites == null");
    }

    public static String[] checkEnabledProtocols(String[] strArr) {
        if (strArr != null) {
            for (String str : strArr) {
                if (str != null) {
                    if (!str.equals(SUPPORTED_PROTOCOL_TLSV1) && !str.equals(SUPPORTED_PROTOCOL_TLSV1_1) && !str.equals(SUPPORTED_PROTOCOL_TLSV1_2) && !str.equals(SUPPORTED_PROTOCOL_TLSV1_3) && !str.equals(OBSOLETE_PROTOCOL_SSLV3)) {
                        throw new IllegalArgumentException("protocol " + str + " is not supported");
                    }
                } else {
                    throw new IllegalArgumentException("protocols contains null");
                }
            }
            return strArr;
        }
        throw new IllegalArgumentException("protocols == null");
    }

    public static String cipherSuiteFromJava(String str) {
        return "SSL_RSA_WITH_3DES_EDE_CBC_SHA".equals(str) ? "TLS_RSA_WITH_3DES_EDE_CBC_SHA" : str;
    }

    public static String cipherSuiteToJava(String str) {
        return "TLS_RSA_WITH_3DES_EDE_CBC_SHA".equals(str) ? "SSL_RSA_WITH_3DES_EDE_CBC_SHA" : str;
    }

    private static native void clinit();

    public static native long create_BIO_InputStream(OpenSSLBIOInputStream openSSLBIOInputStream, boolean z);

    public static native long create_BIO_OutputStream(OutputStream outputStream);

    public static native long[] d2i_PKCS7_bio(long j2, int i2) throws OpenSSLX509CertificateFactory.ParsingException;

    public static native long d2i_SSL_SESSION(byte[] bArr) throws IOException;

    public static native long d2i_X509(byte[] bArr) throws OpenSSLX509CertificateFactory.ParsingException;

    public static native long d2i_X509_CRL_bio(long j2);

    public static native long d2i_X509_bio(long j2);

    public static native byte[] getApplicationProtocol(long j2, NativeSsl nativeSsl);

    public static native long getDirectBufferAddress(Buffer buffer);

    public static native long getECPrivateKeyWrapper(PrivateKey privateKey, NativeRef.EC_GROUP ec_group);

    private static int getProtocolConstant(String str) {
        if (str.equals(SUPPORTED_PROTOCOL_TLSV1)) {
            return NativeConstants.TLS1_VERSION;
        }
        if (str.equals(SUPPORTED_PROTOCOL_TLSV1_1)) {
            return NativeConstants.TLS1_1_VERSION;
        }
        if (str.equals(SUPPORTED_PROTOCOL_TLSV1_2)) {
            return NativeConstants.TLS1_2_VERSION;
        }
        if (str.equals(SUPPORTED_PROTOCOL_TLSV1_3)) {
            return NativeConstants.TLS1_3_VERSION;
        }
        throw new AssertionError("Unknown protocol encountered: " + str);
    }

    private static Range getProtocolRange(String[] strArr) {
        List asList = Arrays.asList(strArr);
        String str = null;
        String str2 = null;
        int i2 = 0;
        while (true) {
            String[] strArr2 = SUPPORTED_PROTOCOLS;
            if (i2 >= strArr2.length) {
                break;
            }
            String str3 = strArr2[i2];
            if (asList.contains(str3)) {
                if (str == null) {
                    str = str3;
                }
                str2 = str3;
            } else if (str != null) {
                break;
            }
            i2++;
        }
        if (str != null && str2 != null) {
            return new Range(str, str2);
        }
        throw new IllegalArgumentException("No protocols enabled.");
    }

    public static native long getRSAPrivateKeyWrapper(PrivateKey privateKey, byte[] bArr);

    public static String[] getSupportedCipherSuites() {
        return SSLUtils.concat(SUPPORTED_TLS_1_3_CIPHER_SUITES, (String[]) SUPPORTED_TLS_1_2_CIPHER_SUITES.clone());
    }

    public static String[] getSupportedProtocols() {
        return (String[]) SUPPORTED_PROTOCOLS.clone();
    }

    public static native int get_EVP_CIPHER_CTX_buf_len(NativeRef.EVP_CIPHER_CTX evp_cipher_ctx);

    public static native boolean get_EVP_CIPHER_CTX_final_used(NativeRef.EVP_CIPHER_CTX evp_cipher_ctx);

    public static native byte[][] get_RSA_private_params(NativeRef.EVP_PKEY evp_pkey);

    public static native byte[][] get_RSA_public_params(NativeRef.EVP_PKEY evp_pkey);

    public static native byte[] get_X509_CRL_crl_enc(long j2, OpenSSLX509CRL openSSLX509CRL);

    public static native String[] get_X509_CRL_ext_oids(long j2, OpenSSLX509CRL openSSLX509CRL, int i2);

    public static native String get_X509_CRL_sig_alg_oid(long j2, OpenSSLX509CRL openSSLX509CRL);

    public static native byte[] get_X509_CRL_sig_alg_parameter(long j2, OpenSSLX509CRL openSSLX509CRL);

    public static native byte[] get_X509_CRL_signature(long j2, OpenSSLX509CRL openSSLX509CRL);

    public static native Object[][] get_X509_GENERAL_NAME_stack(long j2, OpenSSLX509Certificate openSSLX509Certificate, int i2) throws CertificateParsingException;

    public static native String[] get_X509_REVOKED_ext_oids(long j2, int i2);

    public static native long get_X509_REVOKED_revocationDate(long j2);

    public static native byte[] get_X509_cert_info_enc(long j2, OpenSSLX509Certificate openSSLX509Certificate);

    public static native int get_X509_ex_flags(long j2, OpenSSLX509Certificate openSSLX509Certificate);

    public static native boolean[] get_X509_ex_kusage(long j2, OpenSSLX509Certificate openSSLX509Certificate);

    public static native int get_X509_ex_pathlen(long j2, OpenSSLX509Certificate openSSLX509Certificate);

    public static native String[] get_X509_ex_xkusage(long j2, OpenSSLX509Certificate openSSLX509Certificate);

    public static native String[] get_X509_ext_oids(long j2, OpenSSLX509Certificate openSSLX509Certificate, int i2);

    public static native boolean[] get_X509_issuerUID(long j2, OpenSSLX509Certificate openSSLX509Certificate);

    public static native String get_X509_pubkey_oid(long j2, OpenSSLX509Certificate openSSLX509Certificate);

    public static native String get_X509_sig_alg_oid(long j2, OpenSSLX509Certificate openSSLX509Certificate);

    public static native byte[] get_X509_sig_alg_parameter(long j2, OpenSSLX509Certificate openSSLX509Certificate);

    public static native byte[] get_X509_signature(long j2, OpenSSLX509Certificate openSSLX509Certificate);

    public static native boolean[] get_X509_subjectUID(long j2, OpenSSLX509Certificate openSSLX509Certificate);

    public static native String[] get_cipher_names(String str);

    public static native byte[] get_ocsp_single_extension(byte[] bArr, String str, long j2, OpenSSLX509Certificate openSSLX509Certificate, long j3, OpenSSLX509Certificate openSSLX509Certificate2);

    public static native byte[] i2d_PKCS7(long[] jArr);

    public static native byte[] i2d_SSL_SESSION(long j2);

    public static native byte[] i2d_X509(long j2, OpenSSLX509Certificate openSSLX509Certificate);

    public static native byte[] i2d_X509_CRL(long j2, OpenSSLX509CRL openSSLX509CRL);

    public static native byte[] i2d_X509_PUBKEY(long j2, OpenSSLX509Certificate openSSLX509Certificate);

    public static native byte[] i2d_X509_REVOKED(long j2);

    public static native void setApplicationProtocolSelector(long j2, NativeSsl nativeSsl, ApplicationProtocolSelectorAdapter applicationProtocolSelectorAdapter) throws IOException;

    public static native void setApplicationProtocols(long j2, NativeSsl nativeSsl, boolean z, byte[] bArr) throws IOException;

    public static void setEnabledCipherSuites(long j2, NativeSsl nativeSsl, String[] strArr, String[] strArr2) {
        checkEnabledCipherSuites(strArr);
        String str = getProtocolRange(strArr2).max;
        ArrayList arrayList = new ArrayList();
        for (String str2 : strArr) {
            if (!str2.equals(TLS_EMPTY_RENEGOTIATION_INFO_SCSV)) {
                if (str2.equals(TLS_FALLBACK_SCSV) && (str.equals(SUPPORTED_PROTOCOL_TLSV1) || str.equals(SUPPORTED_PROTOCOL_TLSV1_1))) {
                    SSL_set_mode(j2, nativeSsl, 1024L);
                } else {
                    arrayList.add(cipherSuiteFromJava(str2));
                }
            }
        }
        SSL_set_cipher_lists(j2, nativeSsl, (String[]) arrayList.toArray(new String[arrayList.size()]));
    }

    public static void setEnabledProtocols(long j2, NativeSsl nativeSsl, String[] strArr) {
        checkEnabledProtocols(strArr);
        Range protocolRange = getProtocolRange(strArr);
        SSL_set_protocol_versions(j2, nativeSsl, getProtocolConstant(protocolRange.min), getProtocolConstant(protocolRange.max));
    }

    public static native void setLocalCertsAndPrivateKey(long j2, NativeSsl nativeSsl, byte[][] bArr, NativeRef.EVP_PKEY evp_pkey) throws SSLException;

    public static native void set_SSL_psk_client_callback_enabled(long j2, NativeSsl nativeSsl, boolean z);

    public static native void set_SSL_psk_server_callback_enabled(long j2, NativeSsl nativeSsl, boolean z);

    private static int X509_NAME_hash(X500Principal x500Principal, String str) {
        try {
            byte[] digest = MessageDigest.getInstance(str).digest(x500Principal.getEncoded());
            return ((digest[3] & 255) << 24) | ((digest[1] & 255) << 8) | ((digest[0] & 255) << 0) | ((digest[2] & 255) << 16);
        } catch (NoSuchAlgorithmException e2) {
            throw new AssertionError(e2);
        }
    }
}
