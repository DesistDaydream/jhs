package org.conscrypt;

import java.nio.ByteBuffer;
import java.security.MessageDigestSpi;
import java.security.NoSuchAlgorithmException;
import org.conscrypt.EvpMdRef;
import org.conscrypt.NativeRef;

/* loaded from: classes4.dex */
public class OpenSSLMessageDigestJDK extends MessageDigestSpi implements Cloneable {
    private final NativeRef.EVP_MD_CTX ctx;
    private boolean digestInitializedInContext;
    private final long evp_md;
    private final byte[] singleByte;
    private final int size;

    /* loaded from: classes4.dex */
    public static final class MD5 extends OpenSSLMessageDigestJDK {
        public MD5() throws NoSuchAlgorithmException {
            super(EvpMdRef.MD5.EVP_MD, EvpMdRef.MD5.SIZE_BYTES);
        }
    }

    /* loaded from: classes4.dex */
    public static final class SHA1 extends OpenSSLMessageDigestJDK {
        public SHA1() throws NoSuchAlgorithmException {
            super(EvpMdRef.SHA1.EVP_MD, EvpMdRef.SHA1.SIZE_BYTES);
        }
    }

    /* loaded from: classes4.dex */
    public static final class SHA224 extends OpenSSLMessageDigestJDK {
        public SHA224() throws NoSuchAlgorithmException {
            super(EvpMdRef.SHA224.EVP_MD, EvpMdRef.SHA224.SIZE_BYTES);
        }
    }

    /* loaded from: classes4.dex */
    public static final class SHA256 extends OpenSSLMessageDigestJDK {
        public SHA256() throws NoSuchAlgorithmException {
            super(EvpMdRef.SHA256.EVP_MD, EvpMdRef.SHA256.SIZE_BYTES);
        }
    }

    /* loaded from: classes4.dex */
    public static final class SHA384 extends OpenSSLMessageDigestJDK {
        public SHA384() throws NoSuchAlgorithmException {
            super(EvpMdRef.SHA384.EVP_MD, EvpMdRef.SHA384.SIZE_BYTES);
        }
    }

    /* loaded from: classes4.dex */
    public static final class SHA512 extends OpenSSLMessageDigestJDK {
        public SHA512() throws NoSuchAlgorithmException {
            super(EvpMdRef.SHA512.EVP_MD, EvpMdRef.SHA512.SIZE_BYTES);
        }
    }

    private synchronized void ensureDigestInitializedInContext() {
        if (!this.digestInitializedInContext) {
            NativeCrypto.EVP_DigestInit_ex(this.ctx, this.evp_md);
            this.digestInitializedInContext = true;
        }
    }

    @Override // java.security.MessageDigestSpi
    public Object clone() {
        NativeRef.EVP_MD_CTX evp_md_ctx = new NativeRef.EVP_MD_CTX(NativeCrypto.EVP_MD_CTX_create());
        if (this.digestInitializedInContext) {
            NativeCrypto.EVP_MD_CTX_copy_ex(evp_md_ctx, this.ctx);
        }
        return new OpenSSLMessageDigestJDK(this.evp_md, this.size, evp_md_ctx, this.digestInitializedInContext);
    }

    @Override // java.security.MessageDigestSpi
    public synchronized byte[] engineDigest() {
        byte[] bArr;
        ensureDigestInitializedInContext();
        bArr = new byte[this.size];
        NativeCrypto.EVP_DigestFinal_ex(this.ctx, bArr, 0);
        this.digestInitializedInContext = false;
        return bArr;
    }

    @Override // java.security.MessageDigestSpi
    public int engineGetDigestLength() {
        return this.size;
    }

    @Override // java.security.MessageDigestSpi
    public synchronized void engineReset() {
        NativeCrypto.EVP_MD_CTX_cleanup(this.ctx);
        this.digestInitializedInContext = false;
    }

    @Override // java.security.MessageDigestSpi
    public synchronized void engineUpdate(byte b) {
        byte[] bArr = this.singleByte;
        bArr[0] = b;
        engineUpdate(bArr, 0, 1);
    }

    private OpenSSLMessageDigestJDK(long j2, int i2) throws NoSuchAlgorithmException {
        this.singleByte = new byte[1];
        this.evp_md = j2;
        this.size = i2;
        this.ctx = new NativeRef.EVP_MD_CTX(NativeCrypto.EVP_MD_CTX_create());
    }

    @Override // java.security.MessageDigestSpi
    public synchronized void engineUpdate(byte[] bArr, int i2, int i3) {
        ensureDigestInitializedInContext();
        NativeCrypto.EVP_DigestUpdate(this.ctx, bArr, i2, i3);
    }

    @Override // java.security.MessageDigestSpi
    public synchronized void engineUpdate(ByteBuffer byteBuffer) {
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
                    ensureDigestInitializedInContext();
                    NativeCrypto.EVP_DigestUpdateDirect(this.ctx, j2, remaining);
                    byteBuffer.position(position + remaining);
                    return;
                }
                throw new RuntimeException("Negative remaining amount");
            }
            throw new RuntimeException("Negative position");
        }
    }

    private OpenSSLMessageDigestJDK(long j2, int i2, NativeRef.EVP_MD_CTX evp_md_ctx, boolean z) {
        this.singleByte = new byte[1];
        this.evp_md = j2;
        this.size = i2;
        this.ctx = evp_md_ctx;
        this.digestInitializedInContext = z;
    }
}
