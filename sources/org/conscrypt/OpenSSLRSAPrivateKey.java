package org.conscrypt;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.RSAKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPrivateKeySpec;
import java.util.Objects;

/* loaded from: classes4.dex */
public class OpenSSLRSAPrivateKey implements RSAPrivateKey, OpenSSLKeyHolder {
    private static final long serialVersionUID = 4872170254439578735L;
    public transient boolean fetchedParams;
    public transient OpenSSLKey key;
    public BigInteger modulus;
    public BigInteger privateExponent;

    public OpenSSLRSAPrivateKey(OpenSSLKey openSSLKey) {
        this.key = openSSLKey;
    }

    public static OpenSSLRSAPrivateKey getInstance(OpenSSLKey openSSLKey) {
        byte[][] bArr = NativeCrypto.get_RSA_private_params(openSSLKey.getNativeRef());
        if (bArr[1] != null) {
            return new OpenSSLRSAPrivateCrtKey(openSSLKey, bArr);
        }
        return new OpenSSLRSAPrivateKey(openSSLKey, bArr);
    }

    private static OpenSSLKey init(RSAPrivateKeySpec rSAPrivateKeySpec) throws InvalidKeySpecException {
        BigInteger modulus = rSAPrivateKeySpec.getModulus();
        BigInteger privateExponent = rSAPrivateKeySpec.getPrivateExponent();
        if (modulus != null) {
            if (privateExponent != null) {
                try {
                    return new OpenSSLKey(NativeCrypto.EVP_PKEY_new_RSA(modulus.toByteArray(), null, privateExponent.toByteArray(), null, null, null, null, null));
                } catch (Exception e2) {
                    throw new InvalidKeySpecException(e2);
                }
            }
            throw new InvalidKeySpecException("privateExponent == null");
        }
        throw new InvalidKeySpecException("modulus == null");
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.key = new OpenSSLKey(NativeCrypto.EVP_PKEY_new_RSA(this.modulus.toByteArray(), null, this.privateExponent.toByteArray(), null, null, null, null, null));
        this.fetchedParams = true;
    }

    public static OpenSSLKey wrapJCAPrivateKeyForTLSStackOnly(PrivateKey privateKey, PublicKey publicKey) throws InvalidKeyException {
        BigInteger modulus;
        if (privateKey instanceof RSAKey) {
            modulus = ((RSAKey) privateKey).getModulus();
        } else {
            modulus = publicKey instanceof RSAKey ? ((RSAKey) publicKey).getModulus() : null;
        }
        if (modulus != null) {
            return new OpenSSLKey(NativeCrypto.getRSAPrivateKeyWrapper(privateKey, modulus.toByteArray()), true);
        }
        throw new InvalidKeyException("RSA modulus not available. Private: " + privateKey + ", public: " + publicKey);
    }

    public static OpenSSLKey wrapPlatformKey(RSAPrivateKey rSAPrivateKey) throws InvalidKeyException {
        OpenSSLKey wrapRsaKey = Platform.wrapRsaKey(rSAPrivateKey);
        return wrapRsaKey != null ? wrapRsaKey : new OpenSSLKey(NativeCrypto.getRSAPrivateKeyWrapper(rSAPrivateKey, rSAPrivateKey.getModulus().toByteArray()), true);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        ensureReadParams();
        objectOutputStream.defaultWriteObject();
    }

    public final synchronized void ensureReadParams() {
        if (this.fetchedParams) {
            return;
        }
        readParams(NativeCrypto.get_RSA_private_params(this.key.getNativeRef()));
        this.fetchedParams = true;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof OpenSSLRSAPrivateKey) {
            return this.key.equals(((OpenSSLRSAPrivateKey) obj).getOpenSSLKey());
        }
        if (obj instanceof RSAPrivateKey) {
            ensureReadParams();
            RSAPrivateKey rSAPrivateKey = (RSAPrivateKey) obj;
            return this.modulus.equals(rSAPrivateKey.getModulus()) && this.privateExponent.equals(rSAPrivateKey.getPrivateExponent());
        }
        return false;
    }

    @Override // java.security.Key
    public final String getAlgorithm() {
        return "RSA";
    }

    @Override // java.security.Key
    public final byte[] getEncoded() {
        return NativeCrypto.EVP_marshal_private_key(this.key.getNativeRef());
    }

    @Override // java.security.Key
    public final String getFormat() {
        return "PKCS#8";
    }

    @Override // java.security.interfaces.RSAKey
    public final BigInteger getModulus() {
        ensureReadParams();
        return this.modulus;
    }

    @Override // org.conscrypt.OpenSSLKeyHolder
    public OpenSSLKey getOpenSSLKey() {
        return this.key;
    }

    @Override // java.security.interfaces.RSAPrivateKey
    public final BigInteger getPrivateExponent() {
        ensureReadParams();
        return this.privateExponent;
    }

    public int hashCode() {
        ensureReadParams();
        int hashCode = 3 + this.modulus.hashCode();
        BigInteger bigInteger = this.privateExponent;
        return bigInteger != null ? (hashCode * 7) + bigInteger.hashCode() : hashCode;
    }

    public void readParams(byte[][] bArr) {
        Objects.requireNonNull(bArr[0], "modulus == null");
        Objects.requireNonNull(bArr[2], "privateExponent == null");
        this.modulus = new BigInteger(bArr[0]);
        if (bArr[2] != null) {
            this.privateExponent = new BigInteger(bArr[2]);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("OpenSSLRSAPrivateKey{");
        ensureReadParams();
        sb.append("modulus=");
        sb.append(this.modulus.toString(16));
        return sb.toString();
    }

    public OpenSSLRSAPrivateKey(OpenSSLKey openSSLKey, byte[][] bArr) {
        this(openSSLKey);
        readParams(bArr);
        this.fetchedParams = true;
    }

    public static OpenSSLKey getInstance(RSAPrivateKey rSAPrivateKey) throws InvalidKeyException {
        if (rSAPrivateKey.getFormat() == null) {
            return wrapPlatformKey(rSAPrivateKey);
        }
        BigInteger modulus = rSAPrivateKey.getModulus();
        BigInteger privateExponent = rSAPrivateKey.getPrivateExponent();
        if (modulus != null) {
            if (privateExponent != null) {
                try {
                    return new OpenSSLKey(NativeCrypto.EVP_PKEY_new_RSA(modulus.toByteArray(), null, privateExponent.toByteArray(), null, null, null, null, null));
                } catch (Exception e2) {
                    throw new InvalidKeyException(e2);
                }
            }
            throw new InvalidKeyException("privateExponent == null");
        }
        throw new InvalidKeyException("modulus == null");
    }

    public OpenSSLRSAPrivateKey(RSAPrivateKeySpec rSAPrivateKeySpec) throws InvalidKeySpecException {
        this(init(rSAPrivateKeySpec));
    }
}
