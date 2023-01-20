package org.conscrypt;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.KeyAgreementSpi;
import javax.crypto.SecretKey;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.SecretKeySpec;
import org.conscrypt.NativeRef;

/* loaded from: classes4.dex */
public final class OpenSSLECDHKeyAgreement extends KeyAgreementSpi {
    private int mExpectedResultLength;
    private OpenSSLKey mOpenSslPrivateKey;
    private byte[] mResult;

    private void checkCompleted() {
        if (this.mResult == null) {
            throw new IllegalStateException("Key agreement not completed");
        }
    }

    @Override // javax.crypto.KeyAgreementSpi
    public Key engineDoPhase(Key key, boolean z) throws InvalidKeyException {
        if (this.mOpenSslPrivateKey != null) {
            if (z) {
                if (key != null) {
                    if (key instanceof PublicKey) {
                        OpenSSLKey fromPublicKey = OpenSSLKey.fromPublicKey((PublicKey) key);
                        byte[] bArr = new byte[this.mExpectedResultLength];
                        int ECDH_compute_key = NativeCrypto.ECDH_compute_key(bArr, 0, fromPublicKey.getNativeRef(), this.mOpenSslPrivateKey.getNativeRef());
                        if (ECDH_compute_key != -1) {
                            int i2 = this.mExpectedResultLength;
                            if (ECDH_compute_key != i2) {
                                if (ECDH_compute_key < i2) {
                                    byte[] bArr2 = this.mResult;
                                    System.arraycopy(bArr, 0, bArr2, 0, bArr2.length);
                                    bArr = new byte[ECDH_compute_key];
                                } else {
                                    throw new RuntimeException("Engine produced a longer than expected result. Expected: " + this.mExpectedResultLength + ", actual: " + ECDH_compute_key);
                                }
                            }
                            this.mResult = bArr;
                            return null;
                        }
                        throw new RuntimeException("Engine returned " + ECDH_compute_key);
                    }
                    throw new InvalidKeyException("Not a public key: " + key.getClass());
                }
                throw new InvalidKeyException("key == null");
            }
            throw new IllegalStateException("ECDH only has one phase");
        }
        throw new IllegalStateException("Not initialized");
    }

    @Override // javax.crypto.KeyAgreementSpi
    public int engineGenerateSecret(byte[] bArr, int i2) throws ShortBufferException {
        checkCompleted();
        int length = bArr.length - i2;
        byte[] bArr2 = this.mResult;
        if (bArr2.length <= length) {
            System.arraycopy(bArr2, 0, bArr, i2, bArr2.length);
            return this.mResult.length;
        }
        throw new ShortBufferException("Needed: " + this.mResult.length + ", available: " + length);
    }

    @Override // javax.crypto.KeyAgreementSpi
    public void engineInit(Key key, SecureRandom secureRandom) throws InvalidKeyException {
        if (key != null) {
            if (key instanceof PrivateKey) {
                OpenSSLKey fromPrivateKey = OpenSSLKey.fromPrivateKey((PrivateKey) key);
                this.mExpectedResultLength = (NativeCrypto.EC_GROUP_get_degree(new NativeRef.EC_GROUP(NativeCrypto.EC_KEY_get1_group(fromPrivateKey.getNativeRef()))) + 7) / 8;
                this.mOpenSslPrivateKey = fromPrivateKey;
                return;
            }
            throw new InvalidKeyException("Not a private key: " + key.getClass());
        }
        throw new InvalidKeyException("key == null");
    }

    @Override // javax.crypto.KeyAgreementSpi
    public byte[] engineGenerateSecret() {
        checkCompleted();
        return this.mResult;
    }

    @Override // javax.crypto.KeyAgreementSpi
    public SecretKey engineGenerateSecret(String str) {
        checkCompleted();
        return new SecretKeySpec(engineGenerateSecret(), str);
    }

    @Override // javax.crypto.KeyAgreementSpi
    public void engineInit(Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        if (algorithmParameterSpec == null) {
            engineInit(key, secureRandom);
            return;
        }
        throw new InvalidAlgorithmParameterException("No algorithm parameters supported");
    }
}
