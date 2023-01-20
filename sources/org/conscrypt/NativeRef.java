package org.conscrypt;

/* loaded from: classes4.dex */
public abstract class NativeRef {
    public final long address;

    /* loaded from: classes4.dex */
    public static final class EC_GROUP extends NativeRef {
        public EC_GROUP(long j2) {
            super(j2);
        }

        @Override // org.conscrypt.NativeRef
        public void doFree(long j2) {
            NativeCrypto.EC_GROUP_clear_free(j2);
        }
    }

    /* loaded from: classes4.dex */
    public static final class EC_POINT extends NativeRef {
        public EC_POINT(long j2) {
            super(j2);
        }

        @Override // org.conscrypt.NativeRef
        public void doFree(long j2) {
            NativeCrypto.EC_POINT_clear_free(j2);
        }
    }

    /* loaded from: classes4.dex */
    public static final class EVP_CIPHER_CTX extends NativeRef {
        public EVP_CIPHER_CTX(long j2) {
            super(j2);
        }

        @Override // org.conscrypt.NativeRef
        public void doFree(long j2) {
            NativeCrypto.EVP_CIPHER_CTX_free(j2);
        }
    }

    /* loaded from: classes4.dex */
    public static final class EVP_MD_CTX extends NativeRef {
        public EVP_MD_CTX(long j2) {
            super(j2);
        }

        @Override // org.conscrypt.NativeRef
        public void doFree(long j2) {
            NativeCrypto.EVP_MD_CTX_destroy(j2);
        }
    }

    /* loaded from: classes4.dex */
    public static final class EVP_PKEY extends NativeRef {
        public EVP_PKEY(long j2) {
            super(j2);
        }

        @Override // org.conscrypt.NativeRef
        public void doFree(long j2) {
            NativeCrypto.EVP_PKEY_free(j2);
        }
    }

    /* loaded from: classes4.dex */
    public static final class EVP_PKEY_CTX extends NativeRef {
        public EVP_PKEY_CTX(long j2) {
            super(j2);
        }

        @Override // org.conscrypt.NativeRef
        public void doFree(long j2) {
            NativeCrypto.EVP_PKEY_CTX_free(j2);
        }
    }

    /* loaded from: classes4.dex */
    public static final class HMAC_CTX extends NativeRef {
        public HMAC_CTX(long j2) {
            super(j2);
        }

        @Override // org.conscrypt.NativeRef
        public void doFree(long j2) {
            NativeCrypto.HMAC_CTX_free(j2);
        }
    }

    /* loaded from: classes4.dex */
    public static final class SSL_SESSION extends NativeRef {
        public SSL_SESSION(long j2) {
            super(j2);
        }

        @Override // org.conscrypt.NativeRef
        public void doFree(long j2) {
            NativeCrypto.SSL_SESSION_free(j2);
        }
    }

    public NativeRef(long j2) {
        if (j2 != 0) {
            this.address = j2;
            return;
        }
        throw new NullPointerException("address == 0");
    }

    public abstract void doFree(long j2);

    public boolean equals(Object obj) {
        return (obj instanceof NativeRef) && ((NativeRef) obj).address == this.address;
    }

    public void finalize() throws Throwable {
        try {
            long j2 = this.address;
            if (j2 != 0) {
                doFree(j2);
            }
        } finally {
            super.finalize();
        }
    }

    public int hashCode() {
        long j2 = this.address;
        return (int) (j2 ^ (j2 >>> 32));
    }
}
