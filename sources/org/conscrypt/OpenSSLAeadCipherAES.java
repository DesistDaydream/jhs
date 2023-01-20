package org.conscrypt;

import e.j.a.b.i.a;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import org.conscrypt.OpenSSLCipher;

/* loaded from: classes4.dex */
public abstract class OpenSSLAeadCipherAES extends OpenSSLAeadCipher {
    private static final int AES_BLOCK_SIZE = 16;

    /* loaded from: classes4.dex */
    public static class GCM extends OpenSSLAeadCipherAES {

        /* loaded from: classes4.dex */
        public static class AES_128 extends GCM {
            @Override // org.conscrypt.OpenSSLAeadCipherAES, org.conscrypt.OpenSSLCipher
            public void checkSupportedKeySize(int i2) throws InvalidKeyException {
                if (i2 == 16) {
                    return;
                }
                throw new InvalidKeyException("Unsupported key size: " + i2 + " bytes (must be 16)");
            }
        }

        /* loaded from: classes4.dex */
        public static class AES_256 extends GCM {
            @Override // org.conscrypt.OpenSSLAeadCipherAES, org.conscrypt.OpenSSLCipher
            public void checkSupportedKeySize(int i2) throws InvalidKeyException {
                if (i2 == 32) {
                    return;
                }
                throw new InvalidKeyException("Unsupported key size: " + i2 + " bytes (must be 32)");
            }
        }

        public GCM() {
            super(OpenSSLCipher.Mode.GCM);
        }

        @Override // org.conscrypt.OpenSSLCipher
        public void checkSupportedMode(OpenSSLCipher.Mode mode) throws NoSuchAlgorithmException {
            if (mode != OpenSSLCipher.Mode.GCM) {
                throw new NoSuchAlgorithmException("Mode must be GCM");
            }
        }

        @Override // org.conscrypt.OpenSSLAeadCipher
        public long getEVP_AEAD(int i2) throws InvalidKeyException {
            if (i2 == 16) {
                return NativeCrypto.EVP_aead_aes_128_gcm();
            }
            if (i2 == 32) {
                return NativeCrypto.EVP_aead_aes_256_gcm();
            }
            throw new RuntimeException("Unexpected key length: " + i2);
        }
    }

    /* loaded from: classes4.dex */
    public static class GCM_SIV extends OpenSSLAeadCipherAES {

        /* loaded from: classes4.dex */
        public static class AES_128 extends GCM_SIV {
            @Override // org.conscrypt.OpenSSLAeadCipherAES, org.conscrypt.OpenSSLCipher
            public void checkSupportedKeySize(int i2) throws InvalidKeyException {
                if (i2 == 16) {
                    return;
                }
                throw new InvalidKeyException("Unsupported key size: " + i2 + " bytes (must be 16)");
            }
        }

        /* loaded from: classes4.dex */
        public static class AES_256 extends GCM_SIV {
            @Override // org.conscrypt.OpenSSLAeadCipherAES, org.conscrypt.OpenSSLCipher
            public void checkSupportedKeySize(int i2) throws InvalidKeyException {
                if (i2 == 32) {
                    return;
                }
                throw new InvalidKeyException("Unsupported key size: " + i2 + " bytes (must be 32)");
            }
        }

        public GCM_SIV() {
            super(OpenSSLCipher.Mode.GCM_SIV);
        }

        @Override // org.conscrypt.OpenSSLAeadCipher
        public boolean allowsNonceReuse() {
            return true;
        }

        @Override // org.conscrypt.OpenSSLCipher
        public void checkSupportedMode(OpenSSLCipher.Mode mode) throws NoSuchAlgorithmException {
            if (mode != OpenSSLCipher.Mode.GCM_SIV) {
                throw new NoSuchAlgorithmException("Mode must be GCM-SIV");
            }
        }

        @Override // org.conscrypt.OpenSSLAeadCipher
        public void checkSupportedTagLength(int i2) throws InvalidAlgorithmParameterException {
            if (i2 != 128) {
                throw new InvalidAlgorithmParameterException("Tag length must be 128 bits");
            }
        }

        @Override // org.conscrypt.OpenSSLAeadCipher
        public long getEVP_AEAD(int i2) throws InvalidKeyException {
            if (i2 == 16) {
                return NativeCrypto.EVP_aead_aes_128_gcm_siv();
            }
            if (i2 == 32) {
                return NativeCrypto.EVP_aead_aes_256_gcm_siv();
            }
            throw new RuntimeException("Unexpected key length: " + i2);
        }
    }

    public OpenSSLAeadCipherAES(OpenSSLCipher.Mode mode) {
        super(mode);
    }

    @Override // org.conscrypt.OpenSSLCipher
    public void checkSupportedKeySize(int i2) throws InvalidKeyException {
        if (i2 == 16 || i2 == 32) {
            return;
        }
        throw new InvalidKeyException("Unsupported key size: " + i2 + " bytes (must be 16 or 32)");
    }

    @Override // org.conscrypt.OpenSSLCipher, javax.crypto.CipherSpi
    public AlgorithmParameters engineGetParameters() {
        byte[] bArr = this.iv;
        if (bArr == null) {
            return null;
        }
        AlgorithmParameterSpec gCMParameterSpec = Platform.toGCMParameterSpec(this.tagLengthInBytes * 8, bArr);
        if (gCMParameterSpec == null) {
            return super.engineGetParameters();
        }
        try {
            AlgorithmParameters algorithmParameters = AlgorithmParameters.getInstance(a.M);
            algorithmParameters.init(gCMParameterSpec);
            return algorithmParameters;
        } catch (NoSuchAlgorithmException e2) {
            throw ((Error) new AssertionError("GCM not supported").initCause(e2));
        } catch (InvalidParameterSpecException unused) {
            return null;
        }
    }

    @Override // org.conscrypt.OpenSSLCipher
    public String getBaseCipherName() {
        return "AES";
    }

    @Override // org.conscrypt.OpenSSLCipher
    public int getCipherBlockSize() {
        return 16;
    }

    @Override // org.conscrypt.OpenSSLAeadCipher, org.conscrypt.OpenSSLCipher
    public int getOutputSizeForFinal(int i2) {
        if (isEncrypting()) {
            return this.bufCount + i2 + this.tagLengthInBytes;
        }
        return Math.max(0, (this.bufCount + i2) - this.tagLengthInBytes);
    }

    @Override // org.conscrypt.OpenSSLCipher
    public AlgorithmParameterSpec getParameterSpec(AlgorithmParameters algorithmParameters) throws InvalidAlgorithmParameterException {
        if (algorithmParameters != null) {
            AlgorithmParameterSpec fromGCMParameters = Platform.fromGCMParameters(algorithmParameters);
            return fromGCMParameters != null ? fromGCMParameters : super.getParameterSpec(algorithmParameters);
        }
        return null;
    }
}
