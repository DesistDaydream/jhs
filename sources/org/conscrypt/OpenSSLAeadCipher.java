package org.conscrypt;

import java.nio.ByteBuffer;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Arrays;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.IvParameterSpec;
import org.conscrypt.OpenSSLCipher;

/* loaded from: classes4.dex */
public abstract class OpenSSLAeadCipher extends OpenSSLCipher {
    public static final int DEFAULT_TAG_SIZE_BITS = 128;
    private static int lastGlobalMessageSize = 32;
    private byte[] aad;
    public byte[] buf;
    public int bufCount;
    public long evpAead;
    private boolean mustInitialize;
    private byte[] previousIv;
    private byte[] previousKey;
    public int tagLengthInBytes;

    public OpenSSLAeadCipher(OpenSSLCipher.Mode mode) {
        super(mode, OpenSSLCipher.Padding.NOPADDING);
    }

    private boolean arraysAreEqual(byte[] bArr, byte[] bArr2) {
        if (bArr.length != bArr2.length) {
            return false;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < bArr.length; i3++) {
            i2 |= bArr[i3] ^ bArr2[i3];
        }
        return i2 == 0;
    }

    private void checkInitialization() {
        if (this.mustInitialize) {
            throw new IllegalStateException("Cannot re-use same key and IV for multiple encryptions");
        }
    }

    private void expand(int i2) {
        int i3 = this.bufCount;
        int i4 = i3 + i2;
        byte[] bArr = this.buf;
        if (i4 <= bArr.length) {
            return;
        }
        byte[] bArr2 = new byte[(i2 + i3) * 2];
        System.arraycopy(bArr, 0, bArr2, 0, i3);
        this.buf = bArr2;
    }

    private void reset() {
        this.aad = null;
        int i2 = lastGlobalMessageSize;
        byte[] bArr = this.buf;
        if (bArr == null) {
            this.buf = new byte[i2];
        } else {
            int i3 = this.bufCount;
            if (i3 > 0 && i3 != i2) {
                lastGlobalMessageSize = i3;
                if (bArr.length != i3) {
                    this.buf = new byte[i3];
                }
            }
        }
        this.bufCount = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0037 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0038  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void throwAEADBadTagExceptionIfAvailable(java.lang.String r6, java.lang.Throwable r7) throws javax.crypto.BadPaddingException {
        /*
            r5 = this;
            java.lang.String r0 = "javax.crypto.AEADBadTagException"
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch: java.lang.Exception -> L39
            r1 = 1
            java.lang.Class[] r2 = new java.lang.Class[r1]     // Catch: java.lang.Exception -> L39
            java.lang.Class<java.lang.String> r3 = java.lang.String.class
            r4 = 0
            r2[r4] = r3     // Catch: java.lang.Exception -> L39
            java.lang.reflect.Constructor r0 = r0.getConstructor(r2)     // Catch: java.lang.Exception -> L39
            r2 = 0
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch: java.lang.reflect.InvocationTargetException -> L23 java.lang.Throwable -> L34
            r1[r4] = r6     // Catch: java.lang.reflect.InvocationTargetException -> L23 java.lang.Throwable -> L34
            java.lang.Object r6 = r0.newInstance(r1)     // Catch: java.lang.reflect.InvocationTargetException -> L23 java.lang.Throwable -> L34
            javax.crypto.BadPaddingException r6 = (javax.crypto.BadPaddingException) r6     // Catch: java.lang.reflect.InvocationTargetException -> L23 java.lang.Throwable -> L34
            r6.initCause(r7)     // Catch: java.lang.Throwable -> L21 java.lang.reflect.InvocationTargetException -> L23
            goto L35
        L21:
            r2 = r6
            goto L34
        L23:
            r6 = move-exception
            javax.crypto.BadPaddingException r7 = new javax.crypto.BadPaddingException
            r7.<init>()
            java.lang.Throwable r6 = r6.getTargetException()
            java.lang.Throwable r6 = r7.initCause(r6)
            javax.crypto.BadPaddingException r6 = (javax.crypto.BadPaddingException) r6
            throw r6
        L34:
            r6 = r2
        L35:
            if (r6 != 0) goto L38
            return
        L38:
            throw r6
        L39:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.conscrypt.OpenSSLAeadCipher.throwAEADBadTagExceptionIfAvailable(java.lang.String, java.lang.Throwable):void");
    }

    public boolean allowsNonceReuse() {
        return false;
    }

    @Override // org.conscrypt.OpenSSLCipher
    public void checkSupportedPadding(OpenSSLCipher.Padding padding) throws NoSuchPaddingException {
        if (padding != OpenSSLCipher.Padding.NOPADDING) {
            throw new NoSuchPaddingException("Must be NoPadding for AEAD ciphers");
        }
    }

    public void checkSupportedTagLength(int i2) throws InvalidAlgorithmParameterException {
        if (i2 % 8 == 0) {
            return;
        }
        throw new InvalidAlgorithmParameterException("Tag length must be a multiple of 8; was " + i2);
    }

    @Override // org.conscrypt.OpenSSLCipher
    public int doFinalInternal(byte[] bArr, int i2, int i3) throws ShortBufferException, IllegalBlockSizeException, BadPaddingException {
        int EVP_AEAD_CTX_open;
        checkInitialization();
        try {
            if (isEncrypting()) {
                EVP_AEAD_CTX_open = NativeCrypto.EVP_AEAD_CTX_seal(this.evpAead, this.encodedKey, this.tagLengthInBytes, bArr, i2, this.iv, this.buf, 0, this.bufCount, this.aad);
            } else {
                EVP_AEAD_CTX_open = NativeCrypto.EVP_AEAD_CTX_open(this.evpAead, this.encodedKey, this.tagLengthInBytes, bArr, i2, this.iv, this.buf, 0, this.bufCount, this.aad);
            }
            if (isEncrypting()) {
                this.mustInitialize = true;
            }
            reset();
            return EVP_AEAD_CTX_open;
        } catch (BadPaddingException e2) {
            throwAEADBadTagExceptionIfAvailable(e2.getMessage(), e2.getCause());
            throw e2;
        }
    }

    @Override // org.conscrypt.OpenSSLCipher, javax.crypto.CipherSpi
    public int engineDoFinal(byte[] bArr, int i2, int i3, byte[] bArr2, int i4) throws ShortBufferException, IllegalBlockSizeException, BadPaddingException {
        if (bArr2 != null && getOutputSizeForFinal(i3) > bArr2.length - i4) {
            throw new ShortBufferException("Insufficient output space");
        }
        return super.engineDoFinal(bArr, i2, i3, bArr2, i4);
    }

    @Override // org.conscrypt.OpenSSLCipher
    public void engineInitInternal(byte[] bArr, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        byte[] bArr2 = null;
        int i2 = 128;
        if (algorithmParameterSpec != null) {
            GCMParameters fromGCMParameterSpec = Platform.fromGCMParameterSpec(algorithmParameterSpec);
            if (fromGCMParameterSpec != null) {
                bArr2 = fromGCMParameterSpec.getIV();
                i2 = fromGCMParameterSpec.getTLen();
            } else if (algorithmParameterSpec instanceof IvParameterSpec) {
                bArr2 = ((IvParameterSpec) algorithmParameterSpec).getIV();
            }
        }
        checkSupportedTagLength(i2);
        this.tagLengthInBytes = i2 / 8;
        boolean isEncrypting = isEncrypting();
        long evp_aead = getEVP_AEAD(bArr.length);
        this.evpAead = evp_aead;
        int EVP_AEAD_nonce_length = NativeCrypto.EVP_AEAD_nonce_length(evp_aead);
        if (bArr2 != null || EVP_AEAD_nonce_length == 0) {
            if (EVP_AEAD_nonce_length == 0 && bArr2 != null) {
                throw new InvalidAlgorithmParameterException("IV not used in " + this.mode + " mode");
            } else if (bArr2 != null && bArr2.length != EVP_AEAD_nonce_length) {
                throw new InvalidAlgorithmParameterException("Expected IV length of " + EVP_AEAD_nonce_length + " but was " + bArr2.length);
            }
        } else if (isEncrypting) {
            bArr2 = new byte[EVP_AEAD_nonce_length];
            if (secureRandom != null) {
                secureRandom.nextBytes(bArr2);
            } else {
                NativeCrypto.RAND_bytes(bArr2);
            }
        } else {
            throw new InvalidAlgorithmParameterException("IV must be specified in " + this.mode + " mode");
        }
        if (isEncrypting() && bArr2 != null && !allowsNonceReuse()) {
            byte[] bArr3 = this.previousKey;
            if (bArr3 != null && this.previousIv != null && arraysAreEqual(bArr3, bArr) && arraysAreEqual(this.previousIv, bArr2)) {
                this.mustInitialize = true;
                throw new InvalidAlgorithmParameterException("When using AEAD key and IV must not be re-used");
            } else {
                this.previousKey = bArr;
                this.previousIv = bArr2;
            }
        }
        this.mustInitialize = false;
        this.iv = bArr2;
        reset();
    }

    @Override // javax.crypto.CipherSpi
    public void engineUpdateAAD(byte[] bArr, int i2, int i3) {
        checkInitialization();
        byte[] bArr2 = this.aad;
        if (bArr2 == null) {
            this.aad = Arrays.copyOfRange(bArr, i2, i3 + i2);
            return;
        }
        byte[] bArr3 = new byte[bArr2.length + i3];
        System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length);
        System.arraycopy(bArr, i2, bArr3, this.aad.length, i3);
        this.aad = bArr3;
    }

    public abstract long getEVP_AEAD(int i2) throws InvalidKeyException;

    @Override // org.conscrypt.OpenSSLCipher
    public int getOutputSizeForFinal(int i2) {
        return this.bufCount + i2 + (isEncrypting() ? NativeCrypto.EVP_AEAD_max_overhead(this.evpAead) : 0);
    }

    @Override // org.conscrypt.OpenSSLCipher
    public int getOutputSizeForUpdate(int i2) {
        return 0;
    }

    @Override // org.conscrypt.OpenSSLCipher
    public int updateInternal(byte[] bArr, int i2, int i3, byte[] bArr2, int i4, int i5) throws ShortBufferException {
        checkInitialization();
        if (this.buf != null) {
            ArrayUtils.checkOffsetAndCount(bArr.length, i2, i3);
            if (i3 > 0) {
                expand(i3);
                System.arraycopy(bArr, i2, this.buf, this.bufCount, i3);
                this.bufCount += i3;
                return 0;
            }
            return 0;
        }
        throw new IllegalStateException("Cipher not initialized");
    }

    @Override // javax.crypto.CipherSpi
    public void engineUpdateAAD(ByteBuffer byteBuffer) {
        checkInitialization();
        byte[] bArr = this.aad;
        if (bArr == null) {
            byte[] bArr2 = new byte[byteBuffer.remaining()];
            this.aad = bArr2;
            byteBuffer.get(bArr2);
            return;
        }
        byte[] bArr3 = new byte[bArr.length + byteBuffer.remaining()];
        byte[] bArr4 = this.aad;
        System.arraycopy(bArr4, 0, bArr3, 0, bArr4.length);
        byteBuffer.get(bArr3, this.aad.length, byteBuffer.remaining());
        this.aad = bArr3;
    }
}
