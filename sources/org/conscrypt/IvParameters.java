package org.conscrypt;

import java.io.IOException;
import java.security.AlgorithmParametersSpi;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import javax.crypto.spec.IvParameterSpec;

/* loaded from: classes4.dex */
public class IvParameters extends AlgorithmParametersSpi {
    private byte[] iv;

    /* loaded from: classes4.dex */
    public static class AES extends IvParameters {
    }

    /* loaded from: classes4.dex */
    public static class ChaCha20 extends IvParameters {
    }

    /* loaded from: classes4.dex */
    public static class DESEDE extends IvParameters {
    }

    @Override // java.security.AlgorithmParametersSpi
    public byte[] engineGetEncoded() throws IOException {
        long j2 = 0;
        try {
            try {
                j2 = NativeCrypto.asn1_write_init();
                NativeCrypto.asn1_write_octetstring(j2, this.iv);
                return NativeCrypto.asn1_write_finish(j2);
            } catch (IOException e2) {
                NativeCrypto.asn1_write_cleanup(j2);
                throw e2;
            }
        } finally {
            NativeCrypto.asn1_write_free(j2);
        }
    }

    @Override // java.security.AlgorithmParametersSpi
    public <T extends AlgorithmParameterSpec> T engineGetParameterSpec(Class<T> cls) throws InvalidParameterSpecException {
        if (cls == IvParameterSpec.class) {
            return new IvParameterSpec(this.iv);
        }
        throw new InvalidParameterSpecException("Incompatible AlgorithmParametersSpec class: " + cls);
    }

    @Override // java.security.AlgorithmParametersSpi
    public void engineInit(AlgorithmParameterSpec algorithmParameterSpec) throws InvalidParameterSpecException {
        if (algorithmParameterSpec instanceof IvParameterSpec) {
            this.iv = (byte[]) ((IvParameterSpec) algorithmParameterSpec).getIV().clone();
            return;
        }
        throw new InvalidParameterSpecException("Only IvParameterSpec is supported");
    }

    @Override // java.security.AlgorithmParametersSpi
    public String engineToString() {
        return "Conscrypt IV AlgorithmParameters";
    }

    @Override // java.security.AlgorithmParametersSpi
    public void engineInit(byte[] bArr) throws IOException {
        long j2;
        try {
            j2 = NativeCrypto.asn1_read_init(bArr);
        } catch (Throwable th) {
            th = th;
            j2 = 0;
        }
        try {
            byte[] asn1_read_octetstring = NativeCrypto.asn1_read_octetstring(j2);
            if (NativeCrypto.asn1_read_is_empty(j2)) {
                this.iv = asn1_read_octetstring;
                NativeCrypto.asn1_read_free(j2);
                return;
            }
            throw new IOException("Error reading ASN.1 encoding");
        } catch (Throwable th2) {
            th = th2;
            NativeCrypto.asn1_read_free(j2);
            throw th;
        }
    }

    @Override // java.security.AlgorithmParametersSpi
    public byte[] engineGetEncoded(String str) throws IOException {
        if (str != null && !str.equals("ASN.1")) {
            if (str.equals("RAW")) {
                return (byte[]) this.iv.clone();
            }
            throw new IOException("Unsupported format: " + str);
        }
        return engineGetEncoded();
    }

    @Override // java.security.AlgorithmParametersSpi
    public void engineInit(byte[] bArr, String str) throws IOException {
        if (str != null && !str.equals("ASN.1")) {
            if (str.equals("RAW")) {
                this.iv = (byte[]) bArr.clone();
                return;
            }
            throw new IOException("Unsupported format: " + str);
        }
        engineInit(bArr);
    }
}
