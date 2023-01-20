package org.conscrypt;

import java.io.ByteArrayOutputStream;
import java.security.InvalidKeyException;
import java.security.InvalidParameterException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SignatureException;
import java.security.SignatureSpi;

/* loaded from: classes4.dex */
public class OpenSSLSignatureRawECDSA extends SignatureSpi {
    private ByteArrayOutputStream buffer = new ByteArrayOutputStream();
    private OpenSSLKey key;

    private static OpenSSLKey verifyKey(OpenSSLKey openSSLKey) throws InvalidKeyException {
        if (NativeCrypto.EVP_PKEY_type(openSSLKey.getNativeRef()) == 408) {
            return openSSLKey;
        }
        throw new InvalidKeyException("Non-EC key used to initialize EC signature.");
    }

    @Override // java.security.SignatureSpi
    public Object engineGetParameter(String str) throws InvalidParameterException {
        return null;
    }

    @Override // java.security.SignatureSpi
    public void engineInitSign(PrivateKey privateKey) throws InvalidKeyException {
        this.key = verifyKey(OpenSSLKey.fromPrivateKey(privateKey));
    }

    @Override // java.security.SignatureSpi
    public void engineInitVerify(PublicKey publicKey) throws InvalidKeyException {
        this.key = verifyKey(OpenSSLKey.fromPublicKey(publicKey));
    }

    @Override // java.security.SignatureSpi
    public void engineSetParameter(String str, Object obj) throws InvalidParameterException {
    }

    @Override // java.security.SignatureSpi
    public byte[] engineSign() throws SignatureException {
        OpenSSLKey openSSLKey = this.key;
        if (openSSLKey != null) {
            int ECDSA_size = NativeCrypto.ECDSA_size(openSSLKey.getNativeRef());
            byte[] bArr = new byte[ECDSA_size];
            try {
                try {
                    int ECDSA_sign = NativeCrypto.ECDSA_sign(this.buffer.toByteArray(), bArr, this.key.getNativeRef());
                    if (ECDSA_sign >= 0) {
                        if (ECDSA_sign != ECDSA_size) {
                            byte[] bArr2 = new byte[ECDSA_sign];
                            System.arraycopy(bArr, 0, bArr2, 0, ECDSA_sign);
                            bArr = bArr2;
                        }
                        return bArr;
                    }
                    throw new SignatureException("Could not compute signature.");
                } catch (Exception e2) {
                    throw new SignatureException(e2);
                }
            } finally {
                this.buffer.reset();
            }
        }
        throw new SignatureException("No key provided");
    }

    @Override // java.security.SignatureSpi
    public void engineUpdate(byte b) {
        this.buffer.write(b);
    }

    @Override // java.security.SignatureSpi
    public boolean engineVerify(byte[] bArr) throws SignatureException {
        if (this.key != null) {
            try {
                try {
                    int ECDSA_verify = NativeCrypto.ECDSA_verify(this.buffer.toByteArray(), bArr, this.key.getNativeRef());
                    if (ECDSA_verify != -1) {
                        return ECDSA_verify == 1;
                    }
                    throw new SignatureException("Could not verify signature.");
                } catch (Exception e2) {
                    throw new SignatureException(e2);
                }
            } finally {
                this.buffer.reset();
            }
        }
        throw new SignatureException("No key provided");
    }

    @Override // java.security.SignatureSpi
    public void engineUpdate(byte[] bArr, int i2, int i3) {
        this.buffer.write(bArr, i2, i3);
    }
}
