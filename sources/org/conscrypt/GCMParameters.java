package org.conscrypt;

import java.io.IOException;
import java.security.AlgorithmParametersSpi;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;

/* loaded from: classes4.dex */
public final class GCMParameters extends AlgorithmParametersSpi {
    private static final int DEFAULT_TLEN = 96;
    private byte[] iv;
    private int tLen;

    public GCMParameters() {
    }

    @Override // java.security.AlgorithmParametersSpi
    public byte[] engineGetEncoded() throws IOException {
        long j2;
        long j3;
        int i2;
        long j4 = 0;
        try {
            j2 = NativeCrypto.asn1_write_init();
        } catch (IOException e2) {
            e = e2;
            j3 = 0;
        } catch (Throwable th) {
            th = th;
            j2 = 0;
        }
        try {
            j4 = NativeCrypto.asn1_write_sequence(j2);
            NativeCrypto.asn1_write_octetstring(j4, this.iv);
            if (this.tLen != 96) {
                NativeCrypto.asn1_write_uint64(j4, i2 / 8);
            }
            byte[] asn1_write_finish = NativeCrypto.asn1_write_finish(j2);
            NativeCrypto.asn1_write_free(j4);
            NativeCrypto.asn1_write_free(j2);
            return asn1_write_finish;
        } catch (IOException e3) {
            e = e3;
            long j5 = j4;
            j4 = j2;
            j3 = j5;
            try {
                NativeCrypto.asn1_write_cleanup(j4);
                throw e;
            } catch (Throwable th2) {
                th = th2;
                long j6 = j4;
                j4 = j3;
                j2 = j6;
                NativeCrypto.asn1_write_free(j4);
                NativeCrypto.asn1_write_free(j2);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            NativeCrypto.asn1_write_free(j4);
            NativeCrypto.asn1_write_free(j2);
            throw th;
        }
    }

    @Override // java.security.AlgorithmParametersSpi
    public <T extends AlgorithmParameterSpec> T engineGetParameterSpec(Class<T> cls) throws InvalidParameterSpecException {
        if (cls != null && cls.getName().equals("javax.crypto.spec.GCMParameterSpec")) {
            return cls.cast(Platform.toGCMParameterSpec(this.tLen, this.iv));
        }
        throw new InvalidParameterSpecException("Unsupported class: " + cls);
    }

    @Override // java.security.AlgorithmParametersSpi
    public void engineInit(AlgorithmParameterSpec algorithmParameterSpec) throws InvalidParameterSpecException {
        GCMParameters fromGCMParameterSpec = Platform.fromGCMParameterSpec(algorithmParameterSpec);
        if (fromGCMParameterSpec != null) {
            this.tLen = fromGCMParameterSpec.tLen;
            this.iv = fromGCMParameterSpec.iv;
            return;
        }
        throw new InvalidParameterSpecException("Only GCMParameterSpec is supported");
    }

    @Override // java.security.AlgorithmParametersSpi
    public String engineToString() {
        return "Conscrypt GCM AlgorithmParameters";
    }

    public byte[] getIV() {
        return this.iv;
    }

    public int getTLen() {
        return this.tLen;
    }

    public GCMParameters(int i2, byte[] bArr) {
        this.tLen = i2;
        this.iv = bArr;
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
            long asn1_read_sequence = NativeCrypto.asn1_read_sequence(j2);
            byte[] asn1_read_octetstring = NativeCrypto.asn1_read_octetstring(asn1_read_sequence);
            int asn1_read_uint64 = NativeCrypto.asn1_read_is_empty(asn1_read_sequence) ? 96 : ((int) NativeCrypto.asn1_read_uint64(asn1_read_sequence)) * 8;
            if (NativeCrypto.asn1_read_is_empty(asn1_read_sequence) && NativeCrypto.asn1_read_is_empty(j2)) {
                this.iv = asn1_read_octetstring;
                this.tLen = asn1_read_uint64;
                NativeCrypto.asn1_read_free(asn1_read_sequence);
                NativeCrypto.asn1_read_free(j2);
                return;
            }
            throw new IOException("Error reading ASN.1 encoding");
        } catch (Throwable th2) {
            th = th2;
            NativeCrypto.asn1_read_free(0L);
            NativeCrypto.asn1_read_free(j2);
            throw th;
        }
    }

    @Override // java.security.AlgorithmParametersSpi
    public byte[] engineGetEncoded(String str) throws IOException {
        if (str != null && !str.equals("ASN.1")) {
            throw new IOException("Unsupported format: " + str);
        }
        return engineGetEncoded();
    }

    @Override // java.security.AlgorithmParametersSpi
    public void engineInit(byte[] bArr, String str) throws IOException {
        if (str != null && !str.equals("ASN.1")) {
            throw new IOException("Unsupported format: " + str);
        }
        engineInit(bArr);
    }
}
