package org.conscrypt;

import java.io.IOException;
import java.security.AlgorithmParametersSpi;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import java.security.spec.MGF1ParameterSpec;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.spec.OAEPParameterSpec;
import javax.crypto.spec.PSource;
import org.conscrypt.EvpMdRef;

/* loaded from: classes4.dex */
public class OAEPParameters extends AlgorithmParametersSpi {
    private static final String MGF1_OID = "1.2.840.113549.1.1.8";
    private static final Map<String, String> NAME_TO_OID;
    private static final Map<String, String> OID_TO_NAME;
    private static final String PSPECIFIED_OID = "1.2.840.113549.1.1.9";
    private OAEPParameterSpec spec = OAEPParameterSpec.DEFAULT;

    /* JADX WARN: Multi-variable type inference failed */
    static {
        HashMap hashMap = new HashMap();
        OID_TO_NAME = hashMap;
        NAME_TO_OID = new HashMap();
        hashMap.put(EvpMdRef.SHA1.OID, "SHA-1");
        hashMap.put(EvpMdRef.SHA224.OID, "SHA-224");
        hashMap.put(EvpMdRef.SHA256.OID, "SHA-256");
        hashMap.put(EvpMdRef.SHA384.OID, "SHA-384");
        hashMap.put(EvpMdRef.SHA512.OID, "SHA-512");
        for (Map.Entry entry : hashMap.entrySet()) {
            NAME_TO_OID.put(entry.getValue(), entry.getKey());
        }
    }

    private static String getHashName(long j2) throws IOException {
        long j3;
        try {
            j3 = NativeCrypto.asn1_read_sequence(j2);
        } catch (Throwable th) {
            th = th;
            j3 = 0;
        }
        try {
            String asn1_read_oid = NativeCrypto.asn1_read_oid(j3);
            if (!NativeCrypto.asn1_read_is_empty(j3)) {
                NativeCrypto.asn1_read_null(j3);
            }
            if (NativeCrypto.asn1_read_is_empty(j3)) {
                Map<String, String> map = OID_TO_NAME;
                if (map.containsKey(asn1_read_oid)) {
                    String str = map.get(asn1_read_oid);
                    NativeCrypto.asn1_read_free(j3);
                    return str;
                }
            }
            throw new IOException("Error reading ASN.1 encoding");
        } catch (Throwable th2) {
            th = th2;
            NativeCrypto.asn1_read_free(j3);
            throw th;
        }
    }

    public static String readHash(long j2) throws IOException {
        if (NativeCrypto.asn1_read_next_tag_is(j2, 0)) {
            long j3 = 0;
            try {
                j3 = NativeCrypto.asn1_read_tagged(j2);
                return getHashName(j3);
            } finally {
                NativeCrypto.asn1_read_free(j3);
            }
        }
        return "SHA-1";
    }

    public static String readMgfHash(long j2) throws IOException {
        long j3;
        if (NativeCrypto.asn1_read_next_tag_is(j2, 1)) {
            try {
                j3 = NativeCrypto.asn1_read_tagged(j2);
            } catch (Throwable th) {
                th = th;
                j3 = 0;
            }
            try {
                long asn1_read_sequence = NativeCrypto.asn1_read_sequence(j3);
                if (NativeCrypto.asn1_read_oid(asn1_read_sequence).equals("1.2.840.113549.1.1.8")) {
                    String hashName = getHashName(asn1_read_sequence);
                    if (NativeCrypto.asn1_read_is_empty(asn1_read_sequence)) {
                        NativeCrypto.asn1_read_free(asn1_read_sequence);
                        NativeCrypto.asn1_read_free(j3);
                        return hashName;
                    }
                    throw new IOException("Error reading ASN.1 encoding");
                }
                throw new IOException("Error reading ASN.1 encoding");
            } catch (Throwable th2) {
                th = th2;
                NativeCrypto.asn1_read_free(0L);
                NativeCrypto.asn1_read_free(j3);
                throw th;
            }
        }
        return "SHA-1";
    }

    private static long writeAlgorithmIdentifier(long j2, String str) throws IOException {
        long j3;
        try {
            j3 = NativeCrypto.asn1_write_sequence(j2);
            try {
                NativeCrypto.asn1_write_oid(j3, str);
                return j3;
            } catch (IOException e2) {
                e = e2;
                NativeCrypto.asn1_write_free(j3);
                throw e;
            }
        } catch (IOException e3) {
            e = e3;
            j3 = 0;
        }
    }

    public static void writeHashAndMgfHash(long j2, String str, MGF1ParameterSpec mGF1ParameterSpec) throws IOException {
        long j3;
        long j4;
        long j5;
        long writeAlgorithmIdentifier;
        long j6 = 0;
        if (!str.equals("SHA-1")) {
            try {
                j5 = NativeCrypto.asn1_write_tag(j2, 0);
                try {
                    writeAlgorithmIdentifier = writeAlgorithmIdentifier(j5, NAME_TO_OID.get(str));
                } catch (Throwable th) {
                    th = th;
                }
            } catch (Throwable th2) {
                th = th2;
                j5 = 0;
            }
            try {
                NativeCrypto.asn1_write_null(writeAlgorithmIdentifier);
                NativeCrypto.asn1_write_flush(j2);
                NativeCrypto.asn1_write_free(writeAlgorithmIdentifier);
                NativeCrypto.asn1_write_free(j5);
            } catch (Throwable th3) {
                th = th3;
                j6 = writeAlgorithmIdentifier;
                NativeCrypto.asn1_write_flush(j2);
                NativeCrypto.asn1_write_free(j6);
                NativeCrypto.asn1_write_free(j5);
                throw th;
            }
        }
        if (mGF1ParameterSpec.getDigestAlgorithm().equals("SHA-1")) {
            return;
        }
        try {
            j3 = NativeCrypto.asn1_write_tag(j2, 1);
            try {
                j4 = writeAlgorithmIdentifier(j3, "1.2.840.113549.1.1.8");
                try {
                    j6 = writeAlgorithmIdentifier(j4, NAME_TO_OID.get(mGF1ParameterSpec.getDigestAlgorithm()));
                    NativeCrypto.asn1_write_null(j6);
                    NativeCrypto.asn1_write_flush(j2);
                    NativeCrypto.asn1_write_free(j6);
                    NativeCrypto.asn1_write_free(j4);
                    NativeCrypto.asn1_write_free(j3);
                } catch (Throwable th4) {
                    th = th4;
                    NativeCrypto.asn1_write_flush(j2);
                    NativeCrypto.asn1_write_free(j6);
                    NativeCrypto.asn1_write_free(j4);
                    NativeCrypto.asn1_write_free(j3);
                    throw th;
                }
            } catch (Throwable th5) {
                th = th5;
                j4 = 0;
            }
        } catch (Throwable th6) {
            th = th6;
            j3 = 0;
            j4 = 0;
        }
    }

    @Override // java.security.AlgorithmParametersSpi
    public byte[] engineGetEncoded() throws IOException {
        long j2;
        Throwable th;
        long j3;
        IOException e2;
        long asn1_write_sequence;
        long j4;
        long j5 = 0;
        try {
            try {
                j3 = NativeCrypto.asn1_write_init();
            } catch (IOException e3) {
                e2 = e3;
                j3 = 0;
            } catch (Throwable th2) {
                j2 = 0;
                th = th2;
                j3 = 0;
            }
            try {
                asn1_write_sequence = NativeCrypto.asn1_write_sequence(j3);
            } catch (IOException e4) {
                e2 = e4;
            } catch (Throwable th3) {
                th = th3;
                j2 = 0;
                NativeCrypto.asn1_write_free(j2);
                NativeCrypto.asn1_write_free(j3);
                throw th;
            }
            try {
                writeHashAndMgfHash(asn1_write_sequence, this.spec.getDigestAlgorithm(), (MGF1ParameterSpec) this.spec.getMGFParameters());
                PSource.PSpecified pSpecified = (PSource.PSpecified) this.spec.getPSource();
                if (pSpecified.getValue().length != 0) {
                    try {
                        j4 = NativeCrypto.asn1_write_tag(asn1_write_sequence, 2);
                    } catch (Throwable th4) {
                        th = th4;
                        j4 = 0;
                    }
                    try {
                        j5 = writeAlgorithmIdentifier(j4, PSPECIFIED_OID);
                        NativeCrypto.asn1_write_octetstring(j5, pSpecified.getValue());
                        NativeCrypto.asn1_write_flush(asn1_write_sequence);
                        NativeCrypto.asn1_write_free(j5);
                        NativeCrypto.asn1_write_free(j4);
                    } catch (Throwable th5) {
                        th = th5;
                        NativeCrypto.asn1_write_flush(asn1_write_sequence);
                        NativeCrypto.asn1_write_free(j5);
                        NativeCrypto.asn1_write_free(j4);
                        throw th;
                    }
                }
                byte[] asn1_write_finish = NativeCrypto.asn1_write_finish(j3);
                NativeCrypto.asn1_write_free(asn1_write_sequence);
                NativeCrypto.asn1_write_free(j3);
                return asn1_write_finish;
            } catch (IOException e5) {
                e2 = e5;
                NativeCrypto.asn1_write_cleanup(j3);
                throw e2;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    @Override // java.security.AlgorithmParametersSpi
    public <T extends AlgorithmParameterSpec> T engineGetParameterSpec(Class<T> cls) throws InvalidParameterSpecException {
        if (cls != null && cls == OAEPParameterSpec.class) {
            return this.spec;
        }
        throw new InvalidParameterSpecException("Unsupported class: " + cls);
    }

    @Override // java.security.AlgorithmParametersSpi
    public void engineInit(AlgorithmParameterSpec algorithmParameterSpec) throws InvalidParameterSpecException {
        if (algorithmParameterSpec instanceof OAEPParameterSpec) {
            this.spec = (OAEPParameterSpec) algorithmParameterSpec;
            return;
        }
        throw new InvalidParameterSpecException("Only OAEPParameterSpec is supported");
    }

    @Override // java.security.AlgorithmParametersSpi
    public String engineToString() {
        return "Conscrypt OAEP AlgorithmParameters";
    }

    @Override // java.security.AlgorithmParametersSpi
    public void engineInit(byte[] bArr) throws IOException {
        long j2;
        long asn1_read_sequence;
        long j3;
        long j4 = 0;
        try {
            j2 = NativeCrypto.asn1_read_init(bArr);
            try {
                asn1_read_sequence = NativeCrypto.asn1_read_sequence(j2);
            } catch (Throwable th) {
                th = th;
            }
        } catch (Throwable th2) {
            th = th2;
            j2 = 0;
        }
        try {
            PSource.PSpecified pSpecified = PSource.PSpecified.DEFAULT;
            String readHash = readHash(asn1_read_sequence);
            String readMgfHash = readMgfHash(asn1_read_sequence);
            if (NativeCrypto.asn1_read_next_tag_is(asn1_read_sequence, 2)) {
                try {
                    j3 = NativeCrypto.asn1_read_tagged(asn1_read_sequence);
                } catch (Throwable th3) {
                    th = th3;
                    j3 = 0;
                }
                try {
                    long asn1_read_sequence2 = NativeCrypto.asn1_read_sequence(j3);
                    if (NativeCrypto.asn1_read_oid(asn1_read_sequence2).equals(PSPECIFIED_OID)) {
                        pSpecified = new PSource.PSpecified(NativeCrypto.asn1_read_octetstring(asn1_read_sequence2));
                        if (NativeCrypto.asn1_read_is_empty(asn1_read_sequence2)) {
                            NativeCrypto.asn1_read_free(asn1_read_sequence2);
                            NativeCrypto.asn1_read_free(j3);
                        } else {
                            throw new IOException("Error reading ASN.1 encoding");
                        }
                    } else {
                        throw new IOException("Error reading ASN.1 encoding");
                    }
                } catch (Throwable th4) {
                    th = th4;
                    NativeCrypto.asn1_read_free(0L);
                    NativeCrypto.asn1_read_free(j3);
                    throw th;
                }
            }
            if (NativeCrypto.asn1_read_is_empty(asn1_read_sequence) && NativeCrypto.asn1_read_is_empty(j2)) {
                this.spec = new OAEPParameterSpec(readHash, EvpMdRef.MGF1_ALGORITHM_NAME, new MGF1ParameterSpec(readMgfHash), pSpecified);
                NativeCrypto.asn1_read_free(asn1_read_sequence);
                NativeCrypto.asn1_read_free(j2);
                return;
            }
            throw new IOException("Error reading ASN.1 encoding");
        } catch (Throwable th5) {
            th = th5;
            j4 = asn1_read_sequence;
            NativeCrypto.asn1_read_free(j4);
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
