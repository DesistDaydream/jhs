package org.conscrypt;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import org.conscrypt.OpenSSLCipher;

/* loaded from: classes4.dex */
public class OpenSSLAeadCipherChaCha20 extends OpenSSLAeadCipher {
    public OpenSSLAeadCipherChaCha20() {
        super(OpenSSLCipher.Mode.POLY1305);
    }

    @Override // org.conscrypt.OpenSSLCipher
    public void checkSupportedKeySize(int i2) throws InvalidKeyException {
        if (i2 == 32) {
            return;
        }
        throw new InvalidKeyException("Unsupported key size: " + i2 + " bytes (must be 32)");
    }

    @Override // org.conscrypt.OpenSSLCipher
    public void checkSupportedMode(OpenSSLCipher.Mode mode) throws NoSuchAlgorithmException {
        if (mode != OpenSSLCipher.Mode.POLY1305) {
            throw new NoSuchAlgorithmException("Mode must be Poly1305");
        }
    }

    @Override // org.conscrypt.OpenSSLCipher
    public String getBaseCipherName() {
        return "ChaCha20";
    }

    @Override // org.conscrypt.OpenSSLCipher
    public int getCipherBlockSize() {
        return 0;
    }

    @Override // org.conscrypt.OpenSSLAeadCipher
    public long getEVP_AEAD(int i2) throws InvalidKeyException {
        if (i2 == 32) {
            return NativeCrypto.EVP_aead_chacha20_poly1305();
        }
        throw new RuntimeException("Unexpected key length: " + i2);
    }

    @Override // org.conscrypt.OpenSSLAeadCipher, org.conscrypt.OpenSSLCipher
    public int getOutputSizeForFinal(int i2) {
        if (isEncrypting()) {
            return this.bufCount + i2 + 16;
        }
        return Math.max(0, (this.bufCount + i2) - 16);
    }
}
