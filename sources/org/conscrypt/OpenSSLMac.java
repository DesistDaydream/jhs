package org.conscrypt;

import java.nio.ByteBuffer;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.MacSpi;
import javax.crypto.SecretKey;
import org.conscrypt.EvpMdRef;
import org.conscrypt.NativeRef;

/* loaded from: classes4.dex */
public abstract class OpenSSLMac extends MacSpi {
    private NativeRef.HMAC_CTX ctx;
    private final long evp_md;
    private byte[] keyBytes;
    private final byte[] singleByte;
    private final int size;

    /* loaded from: classes4.dex */
    public static final class HmacMD5 extends OpenSSLMac {
        public HmacMD5() {
            super(EvpMdRef.MD5.EVP_MD, EvpMdRef.MD5.SIZE_BYTES);
        }
    }

    /* loaded from: classes4.dex */
    public static final class HmacSHA1 extends OpenSSLMac {
        public HmacSHA1() {
            super(EvpMdRef.SHA1.EVP_MD, EvpMdRef.SHA1.SIZE_BYTES);
        }
    }

    /* loaded from: classes4.dex */
    public static final class HmacSHA224 extends OpenSSLMac {
        public HmacSHA224() throws NoSuchAlgorithmException {
            super(EvpMdRef.SHA224.EVP_MD, EvpMdRef.SHA224.SIZE_BYTES);
        }
    }

    /* loaded from: classes4.dex */
    public static final class HmacSHA256 extends OpenSSLMac {
        public HmacSHA256() throws NoSuchAlgorithmException {
            super(EvpMdRef.SHA256.EVP_MD, EvpMdRef.SHA256.SIZE_BYTES);
        }
    }

    /* loaded from: classes4.dex */
    public static final class HmacSHA384 extends OpenSSLMac {
        public HmacSHA384() throws NoSuchAlgorithmException {
            super(EvpMdRef.SHA384.EVP_MD, EvpMdRef.SHA384.SIZE_BYTES);
        }
    }

    /* loaded from: classes4.dex */
    public static final class HmacSHA512 extends OpenSSLMac {
        public HmacSHA512() {
            super(EvpMdRef.SHA512.EVP_MD, EvpMdRef.SHA512.SIZE_BYTES);
        }
    }

    private final void resetContext() {
        NativeRef.HMAC_CTX hmac_ctx = new NativeRef.HMAC_CTX(NativeCrypto.HMAC_CTX_new());
        byte[] bArr = this.keyBytes;
        if (bArr != null) {
            NativeCrypto.HMAC_Init_ex(hmac_ctx, bArr, this.evp_md);
        }
        this.ctx = hmac_ctx;
    }

    @Override // javax.crypto.MacSpi
    public byte[] engineDoFinal() {
        byte[] HMAC_Final = NativeCrypto.HMAC_Final(this.ctx);
        resetContext();
        return HMAC_Final;
    }

    @Override // javax.crypto.MacSpi
    public int engineGetMacLength() {
        return this.size;
    }

    @Override // javax.crypto.MacSpi
    public void engineInit(Key key, AlgorithmParameterSpec algorithmParameterSpec) throws InvalidKeyException, InvalidAlgorithmParameterException {
        if (!(key instanceof SecretKey)) {
            throw new InvalidKeyException("key must be a SecretKey");
        }
        if (algorithmParameterSpec == null) {
            byte[] encoded = key.getEncoded();
            this.keyBytes = encoded;
            if (encoded != null) {
                resetContext();
                return;
            }
            throw new InvalidKeyException("key cannot be encoded");
        }
        throw new InvalidAlgorithmParameterException("unknown parameter type");
    }

    @Override // javax.crypto.MacSpi
    public void engineReset() {
        resetContext();
    }

    @Override // javax.crypto.MacSpi
    public void engineUpdate(byte b) {
        byte[] bArr = this.singleByte;
        bArr[0] = b;
        engineUpdate(bArr, 0, 1);
    }

    private OpenSSLMac(long j2, int i2) {
        this.singleByte = new byte[1];
        this.evp_md = j2;
        this.size = i2;
    }

    @Override // javax.crypto.MacSpi
    public void engineUpdate(byte[] bArr, int i2, int i3) {
        NativeCrypto.HMAC_Update(this.ctx, bArr, i2, i3);
    }

    @Override // javax.crypto.MacSpi
    public void engineUpdate(ByteBuffer byteBuffer) {
        if (byteBuffer.hasRemaining()) {
            if (!byteBuffer.isDirect()) {
                super.engineUpdate(byteBuffer);
                return;
            }
            long directBufferAddress = NativeCrypto.getDirectBufferAddress(byteBuffer);
            if (directBufferAddress == 0) {
                super.engineUpdate(byteBuffer);
                return;
            }
            int position = byteBuffer.position();
            if (position >= 0) {
                long j2 = directBufferAddress + position;
                int remaining = byteBuffer.remaining();
                if (remaining >= 0) {
                    NativeCrypto.HMAC_UpdateDirect(this.ctx, j2, remaining);
                    byteBuffer.position(position + remaining);
                    return;
                }
                throw new RuntimeException("Negative remaining amount");
            }
            throw new RuntimeException("Negative position");
        }
    }
}
