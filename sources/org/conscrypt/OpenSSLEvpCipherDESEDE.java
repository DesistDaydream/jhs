package org.conscrypt;

import com.xiaomi.mipush.sdk.Constants;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;
import javax.crypto.NoSuchPaddingException;
import org.conscrypt.OpenSSLCipher;

/* loaded from: classes4.dex */
public abstract class OpenSSLEvpCipherDESEDE extends OpenSSLEvpCipher {
    private static final int DES_BLOCK_SIZE = 8;

    /* renamed from: org.conscrypt.OpenSSLEvpCipherDESEDE$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$org$conscrypt$OpenSSLCipher$Padding;

        static {
            int[] iArr = new int[OpenSSLCipher.Padding.values().length];
            $SwitchMap$org$conscrypt$OpenSSLCipher$Padding = iArr;
            try {
                iArr[OpenSSLCipher.Padding.NOPADDING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$conscrypt$OpenSSLCipher$Padding[OpenSSLCipher.Padding.PKCS5PADDING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class CBC extends OpenSSLEvpCipherDESEDE {

        /* loaded from: classes4.dex */
        public static class NoPadding extends CBC {
            public NoPadding() {
                super(OpenSSLCipher.Padding.NOPADDING);
            }
        }

        /* loaded from: classes4.dex */
        public static class PKCS5Padding extends CBC {
            public PKCS5Padding() {
                super(OpenSSLCipher.Padding.PKCS5PADDING);
            }
        }

        public CBC(OpenSSLCipher.Padding padding) {
            super(OpenSSLCipher.Mode.CBC, padding);
        }
    }

    public OpenSSLEvpCipherDESEDE(OpenSSLCipher.Mode mode, OpenSSLCipher.Padding padding) {
        super(mode, padding);
    }

    @Override // org.conscrypt.OpenSSLCipher
    public void checkSupportedKeySize(int i2) throws InvalidKeyException {
        if (i2 != 16 && i2 != 24) {
            throw new InvalidKeyException("key size must be 128 or 192 bits");
        }
    }

    @Override // org.conscrypt.OpenSSLCipher
    public void checkSupportedMode(OpenSSLCipher.Mode mode) throws NoSuchAlgorithmException {
        if (mode == OpenSSLCipher.Mode.CBC) {
            return;
        }
        throw new NoSuchAlgorithmException("Unsupported mode " + mode.toString());
    }

    @Override // org.conscrypt.OpenSSLCipher
    public void checkSupportedPadding(OpenSSLCipher.Padding padding) throws NoSuchPaddingException {
        int i2 = AnonymousClass1.$SwitchMap$org$conscrypt$OpenSSLCipher$Padding[padding.ordinal()];
        if (i2 == 1 || i2 == 2) {
            return;
        }
        throw new NoSuchPaddingException("Unsupported padding " + padding.toString());
    }

    @Override // org.conscrypt.OpenSSLCipher
    public String getBaseCipherName() {
        return "DESede";
    }

    @Override // org.conscrypt.OpenSSLCipher
    public int getCipherBlockSize() {
        return 8;
    }

    @Override // org.conscrypt.OpenSSLEvpCipher
    public String getCipherName(int i2, OpenSSLCipher.Mode mode) {
        String str = i2 == 16 ? "des-ede" : "des-ede3";
        return str + Constants.ACCEPT_TIME_SEPARATOR_SERVER + mode.toString().toLowerCase(Locale.US);
    }
}
