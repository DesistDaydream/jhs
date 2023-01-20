package org.conscrypt;

import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.InvalidParameterException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.InvalidParameterSpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import java.util.Locale;
import java.util.Objects;
import javax.crypto.BadPaddingException;
import javax.crypto.CipherSpi;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes4.dex */
public abstract class OpenSSLCipher extends CipherSpi {
    private int blockSize;
    public byte[] encodedKey;
    private boolean encrypting;
    public byte[] iv;
    public Mode mode;
    private Padding padding;

    /* loaded from: classes4.dex */
    public enum Mode {
        NONE,
        CBC,
        CTR,
        ECB,
        GCM,
        GCM_SIV,
        POLY1305;

        public static Mode getNormalized(String str) {
            String upperCase = str.toUpperCase(Locale.US);
            if (upperCase.equals("GCM-SIV")) {
                return GCM_SIV;
            }
            if (!upperCase.equals("GCM_SIV")) {
                return valueOf(upperCase);
            }
            throw new IllegalArgumentException("Invalid mode");
        }
    }

    /* loaded from: classes4.dex */
    public enum Padding {
        NOPADDING,
        PKCS5PADDING,
        PKCS7PADDING;

        public static Padding getNormalized(String str) {
            Padding valueOf = valueOf(str.toUpperCase(Locale.US));
            return valueOf == PKCS7PADDING ? PKCS5PADDING : valueOf;
        }
    }

    public OpenSSLCipher() {
        this.mode = Mode.ECB;
        this.padding = Padding.PKCS5PADDING;
    }

    private byte[] checkAndSetEncodedKey(int i2, Key key) throws InvalidKeyException {
        if (i2 == 1 || i2 == 3) {
            this.encrypting = true;
        } else if (i2 != 2 && i2 != 4) {
            throw new InvalidParameterException("Unsupported opmode " + i2);
        } else {
            this.encrypting = false;
        }
        if (key instanceof SecretKey) {
            byte[] encoded = key.getEncoded();
            if (encoded != null) {
                checkSupportedKeySize(encoded.length);
                this.encodedKey = encoded;
                return encoded;
            }
            throw new InvalidKeyException("key.getEncoded() == null");
        }
        throw new InvalidKeyException("Only SecretKey is supported");
    }

    public abstract void checkSupportedKeySize(int i2) throws InvalidKeyException;

    public abstract void checkSupportedMode(Mode mode) throws NoSuchAlgorithmException;

    public abstract void checkSupportedPadding(Padding padding) throws NoSuchPaddingException;

    public abstract int doFinalInternal(byte[] bArr, int i2, int i3) throws IllegalBlockSizeException, BadPaddingException, ShortBufferException;

    @Override // javax.crypto.CipherSpi
    public byte[] engineDoFinal(byte[] bArr, int i2, int i3) throws IllegalBlockSizeException, BadPaddingException {
        int i4;
        int outputSizeForFinal = getOutputSizeForFinal(i3);
        byte[] bArr2 = new byte[outputSizeForFinal];
        if (i3 > 0) {
            try {
                i4 = updateInternal(bArr, i2, i3, bArr2, 0, outputSizeForFinal);
            } catch (ShortBufferException e2) {
                throw new RuntimeException("our calculated buffer was too small", e2);
            }
        } else {
            i4 = 0;
        }
        try {
            int doFinalInternal = i4 + doFinalInternal(bArr2, i4, outputSizeForFinal - i4);
            if (doFinalInternal == outputSizeForFinal) {
                return bArr2;
            }
            if (doFinalInternal == 0) {
                return EmptyArray.BYTE;
            }
            return Arrays.copyOfRange(bArr2, 0, doFinalInternal);
        } catch (ShortBufferException e3) {
            throw new RuntimeException("our calculated buffer was too small", e3);
        }
    }

    @Override // javax.crypto.CipherSpi
    public int engineGetBlockSize() {
        return this.blockSize;
    }

    @Override // javax.crypto.CipherSpi
    public byte[] engineGetIV() {
        return this.iv;
    }

    @Override // javax.crypto.CipherSpi
    public int engineGetKeySize(Key key) throws InvalidKeyException {
        if (key instanceof SecretKey) {
            byte[] encoded = key.getEncoded();
            if (encoded != null) {
                checkSupportedKeySize(encoded.length);
                return encoded.length * 8;
            }
            throw new InvalidKeyException("key.getEncoded() == null");
        }
        throw new InvalidKeyException("Only SecretKey is supported");
    }

    @Override // javax.crypto.CipherSpi
    public int engineGetOutputSize(int i2) {
        return Math.max(getOutputSizeForUpdate(i2), getOutputSizeForFinal(i2));
    }

    @Override // javax.crypto.CipherSpi
    public AlgorithmParameters engineGetParameters() {
        byte[] bArr = this.iv;
        if (bArr != null && bArr.length > 0) {
            try {
                AlgorithmParameters algorithmParameters = AlgorithmParameters.getInstance(getBaseCipherName());
                algorithmParameters.init(new IvParameterSpec(this.iv));
                return algorithmParameters;
            } catch (NoSuchAlgorithmException | InvalidParameterSpecException unused) {
            }
        }
        return null;
    }

    @Override // javax.crypto.CipherSpi
    public void engineInit(int i2, Key key, SecureRandom secureRandom) throws InvalidKeyException {
        checkAndSetEncodedKey(i2, key);
        try {
            engineInitInternal(this.encodedKey, null, secureRandom);
        } catch (InvalidAlgorithmParameterException e2) {
            throw new RuntimeException(e2);
        }
    }

    public abstract void engineInitInternal(byte[] bArr, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException;

    @Override // javax.crypto.CipherSpi
    public void engineSetMode(String str) throws NoSuchAlgorithmException {
        try {
            Mode normalized = Mode.getNormalized(str);
            checkSupportedMode(normalized);
            this.mode = normalized;
        } catch (IllegalArgumentException e2) {
            NoSuchAlgorithmException noSuchAlgorithmException = new NoSuchAlgorithmException("No such mode: " + str);
            noSuchAlgorithmException.initCause(e2);
            throw noSuchAlgorithmException;
        }
    }

    @Override // javax.crypto.CipherSpi
    public void engineSetPadding(String str) throws NoSuchPaddingException {
        try {
            Padding normalized = Padding.getNormalized(str);
            checkSupportedPadding(normalized);
            this.padding = normalized;
        } catch (IllegalArgumentException e2) {
            NoSuchPaddingException noSuchPaddingException = new NoSuchPaddingException("No such padding: " + str);
            noSuchPaddingException.initCause(e2);
            throw noSuchPaddingException;
        }
    }

    @Override // javax.crypto.CipherSpi
    public Key engineUnwrap(byte[] bArr, String str, int i2) throws InvalidKeyException, NoSuchAlgorithmException {
        try {
            byte[] engineDoFinal = engineDoFinal(bArr, 0, bArr.length);
            if (i2 == 1) {
                return KeyFactory.getInstance(str).generatePublic(new X509EncodedKeySpec(engineDoFinal));
            }
            if (i2 == 2) {
                return KeyFactory.getInstance(str).generatePrivate(new PKCS8EncodedKeySpec(engineDoFinal));
            }
            if (i2 == 3) {
                return new SecretKeySpec(engineDoFinal, str);
            }
            throw new UnsupportedOperationException("wrappedKeyType == " + i2);
        } catch (InvalidKeySpecException e2) {
            throw new InvalidKeyException(e2);
        } catch (BadPaddingException e3) {
            throw new InvalidKeyException(e3);
        } catch (IllegalBlockSizeException e4) {
            throw new InvalidKeyException(e4);
        }
    }

    @Override // javax.crypto.CipherSpi
    public byte[] engineUpdate(byte[] bArr, int i2, int i3) {
        byte[] bArr2;
        int outputSizeForUpdate = getOutputSizeForUpdate(i3);
        if (outputSizeForUpdate > 0) {
            bArr2 = new byte[outputSizeForUpdate];
        } else {
            bArr2 = EmptyArray.BYTE;
        }
        byte[] bArr3 = bArr2;
        try {
            int updateInternal = updateInternal(bArr, i2, i3, bArr3, 0, outputSizeForUpdate);
            if (bArr3.length == updateInternal) {
                return bArr3;
            }
            if (updateInternal == 0) {
                return EmptyArray.BYTE;
            }
            return Arrays.copyOfRange(bArr3, 0, updateInternal);
        } catch (ShortBufferException unused) {
            throw new RuntimeException("calculated buffer size was wrong: " + outputSizeForUpdate);
        }
    }

    @Override // javax.crypto.CipherSpi
    public byte[] engineWrap(Key key) throws IllegalBlockSizeException, InvalidKeyException {
        try {
            byte[] encoded = key.getEncoded();
            return engineDoFinal(encoded, 0, encoded.length);
        } catch (BadPaddingException e2) {
            IllegalBlockSizeException illegalBlockSizeException = new IllegalBlockSizeException();
            illegalBlockSizeException.initCause(e2);
            throw illegalBlockSizeException;
        }
    }

    public abstract String getBaseCipherName();

    public abstract int getCipherBlockSize();

    public abstract int getOutputSizeForFinal(int i2);

    public abstract int getOutputSizeForUpdate(int i2);

    public Padding getPadding() {
        return this.padding;
    }

    public AlgorithmParameterSpec getParameterSpec(AlgorithmParameters algorithmParameters) throws InvalidAlgorithmParameterException {
        if (algorithmParameters != null) {
            try {
                return algorithmParameters.getParameterSpec(IvParameterSpec.class);
            } catch (InvalidParameterSpecException e2) {
                throw new InvalidAlgorithmParameterException("Params must be convertible to IvParameterSpec", e2);
            }
        }
        return null;
    }

    public boolean isEncrypting() {
        return this.encrypting;
    }

    public boolean supportsVariableSizeIv() {
        return false;
    }

    public boolean supportsVariableSizeKey() {
        return false;
    }

    public abstract int updateInternal(byte[] bArr, int i2, int i3, byte[] bArr2, int i4, int i5) throws ShortBufferException;

    public OpenSSLCipher(Mode mode, Padding padding) {
        this.mode = Mode.ECB;
        this.padding = Padding.PKCS5PADDING;
        this.mode = mode;
        this.padding = padding;
        this.blockSize = getCipherBlockSize();
    }

    @Override // javax.crypto.CipherSpi
    public void engineInit(int i2, Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        checkAndSetEncodedKey(i2, key);
        engineInitInternal(this.encodedKey, algorithmParameterSpec, secureRandom);
    }

    @Override // javax.crypto.CipherSpi
    public void engineInit(int i2, Key key, AlgorithmParameters algorithmParameters, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        engineInit(i2, key, getParameterSpec(algorithmParameters), secureRandom);
    }

    @Override // javax.crypto.CipherSpi
    public int engineDoFinal(byte[] bArr, int i2, int i3, byte[] bArr2, int i4) throws ShortBufferException, IllegalBlockSizeException, BadPaddingException {
        int i5;
        Objects.requireNonNull(bArr2, "output == null");
        int outputSizeForFinal = getOutputSizeForFinal(i3);
        if (i3 > 0) {
            i5 = updateInternal(bArr, i2, i3, bArr2, i4, outputSizeForFinal);
            i4 += i5;
            outputSizeForFinal -= i5;
        } else {
            i5 = 0;
        }
        return i5 + doFinalInternal(bArr2, i4, outputSizeForFinal);
    }

    @Override // javax.crypto.CipherSpi
    public int engineUpdate(byte[] bArr, int i2, int i3, byte[] bArr2, int i4) throws ShortBufferException {
        return updateInternal(bArr, i2, i3, bArr2, i4, getOutputSizeForUpdate(i3));
    }
}
