package org.conscrypt;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.IvParameterSpec;
import org.conscrypt.OpenSSLCipher;

/* loaded from: classes4.dex */
public class OpenSSLCipherChaCha20 extends OpenSSLCipher {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int BLOCK_SIZE_BYTES = 64;
    private static final int NONCE_SIZE_BYTES = 12;
    private int currentBlockConsumedBytes = 0;
    private int blockCounter = 0;

    private void reset() {
        this.blockCounter = 0;
        this.currentBlockConsumedBytes = 0;
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
        if (mode != OpenSSLCipher.Mode.NONE) {
            throw new NoSuchAlgorithmException("Mode must be NONE");
        }
    }

    @Override // org.conscrypt.OpenSSLCipher
    public void checkSupportedPadding(OpenSSLCipher.Padding padding) throws NoSuchPaddingException {
        if (padding != OpenSSLCipher.Padding.NOPADDING) {
            throw new NoSuchPaddingException("Must be NoPadding");
        }
    }

    @Override // org.conscrypt.OpenSSLCipher
    public int doFinalInternal(byte[] bArr, int i2, int i3) throws IllegalBlockSizeException, BadPaddingException, ShortBufferException {
        reset();
        return 0;
    }

    @Override // org.conscrypt.OpenSSLCipher
    public void engineInitInternal(byte[] bArr, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        if (algorithmParameterSpec instanceof IvParameterSpec) {
            IvParameterSpec ivParameterSpec = (IvParameterSpec) algorithmParameterSpec;
            if (ivParameterSpec.getIV().length == 12) {
                this.iv = ivParameterSpec.getIV();
                return;
            }
            throw new InvalidAlgorithmParameterException("IV must be 12 bytes long");
        } else if (isEncrypting()) {
            byte[] bArr2 = new byte[12];
            this.iv = bArr2;
            if (secureRandom != null) {
                secureRandom.nextBytes(bArr2);
            } else {
                NativeCrypto.RAND_bytes(bArr2);
            }
        } else {
            throw new InvalidAlgorithmParameterException("IV must be specified when decrypting");
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

    @Override // org.conscrypt.OpenSSLCipher
    public int getOutputSizeForFinal(int i2) {
        return i2;
    }

    @Override // org.conscrypt.OpenSSLCipher
    public int getOutputSizeForUpdate(int i2) {
        return i2;
    }

    @Override // org.conscrypt.OpenSSLCipher
    public int updateInternal(byte[] bArr, int i2, int i3, byte[] bArr2, int i4, int i5) throws ShortBufferException {
        int i6;
        int i7;
        int i8;
        if (i3 <= bArr2.length - i4) {
            int i9 = this.currentBlockConsumedBytes;
            if (i9 > 0) {
                int min = Math.min(64 - i9, i3);
                byte[] bArr3 = new byte[64];
                byte[] bArr4 = new byte[64];
                System.arraycopy(bArr, i2, bArr3, this.currentBlockConsumedBytes, min);
                NativeCrypto.chacha20_encrypt_decrypt(bArr3, 0, bArr4, 0, 64, this.encodedKey, this.iv, this.blockCounter);
                System.arraycopy(bArr4, this.currentBlockConsumedBytes, bArr2, i4, min);
                int i10 = this.currentBlockConsumedBytes + min;
                this.currentBlockConsumedBytes = i10;
                if (i10 < 64) {
                    return min;
                }
                this.currentBlockConsumedBytes = 0;
                int i11 = i2 + min;
                int i12 = i4 + min;
                int i13 = i3 - min;
                this.blockCounter++;
                i8 = i12;
                i6 = i11;
                i7 = i13;
            } else {
                i6 = i2;
                i7 = i3;
                i8 = i4;
            }
            NativeCrypto.chacha20_encrypt_decrypt(bArr, i6, bArr2, i8, i7, this.encodedKey, this.iv, this.blockCounter);
            this.currentBlockConsumedBytes = i7 % 64;
            this.blockCounter += i7 / 64;
            return i3;
        }
        throw new ShortBufferException("Insufficient output space");
    }
}
