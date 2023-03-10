package com.bytedance.pangle.g;

import android.util.ArrayMap;
import android.util.Pair;
import androidx.annotation.RequiresApi;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TipsMessageBean;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

@RequiresApi(api = 21)
/* loaded from: classes.dex */
public final class c {

    /* loaded from: classes.dex */
    public static class a extends Exception {
    }

    /* loaded from: classes.dex */
    public static class b {
        public final List<X509Certificate> a;
        public final List<Integer> b;

        public b(List<X509Certificate> list, List<Integer> list2) {
            this.a = list;
            this.b = list2;
        }
    }

    /* renamed from: com.bytedance.pangle.g.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0082c {
        public final X509Certificate[] a;
        public final b b;

        /* renamed from: c  reason: collision with root package name */
        public byte[] f2292c;

        public C0082c(X509Certificate[] x509CertificateArr, b bVar) {
            this.a = x509CertificateArr;
            this.b = bVar;
        }
    }

    public static C0082c a(RandomAccessFile randomAccessFile, m mVar) {
        ArrayMap arrayMap = new ArrayMap();
        try {
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            try {
                ByteBuffer a2 = f.a(mVar.a);
                int i2 = 0;
                C0082c c0082c = null;
                while (a2.hasRemaining()) {
                    try {
                        c0082c = a(f.a(a2), arrayMap, certificateFactory);
                        i2++;
                    } catch (a unused) {
                    } catch (IOException e2) {
                        e = e2;
                        throw new SecurityException("Failed to parse/verify signer #" + i2 + " block", e);
                    } catch (SecurityException e3) {
                        e = e3;
                        throw new SecurityException("Failed to parse/verify signer #" + i2 + " block", e);
                    } catch (BufferUnderflowException e4) {
                        e = e4;
                        throw new SecurityException("Failed to parse/verify signer #" + i2 + " block", e);
                    }
                }
                if (i2 <= 0 || c0082c == null) {
                    throw new SecurityException("No signers found");
                }
                if (i2 == 1) {
                    if (!arrayMap.isEmpty()) {
                        f.a(arrayMap, randomAccessFile, mVar);
                        if (arrayMap.containsKey(3)) {
                            c0082c.f2292c = f.a((byte[]) arrayMap.get(3), randomAccessFile.length(), mVar);
                        }
                        return c0082c;
                    }
                    throw new SecurityException("No content digests found");
                }
                throw new SecurityException("APK Signature Scheme V3 only supports one signer: multiple signers found.");
            } catch (IOException e5) {
                throw new SecurityException("Failed to read list of signers", e5);
            }
        } catch (CertificateException e6) {
            throw new RuntimeException("Failed to obtain X.509 CertificateFactory", e6);
        }
    }

    private static C0082c a(ByteBuffer byteBuffer, Map<Integer, byte[]> map, CertificateFactory certificateFactory) {
        ByteBuffer a2 = f.a(byteBuffer);
        int i2 = byteBuffer.getInt();
        int i3 = byteBuffer.getInt();
        ByteBuffer a3 = f.a(byteBuffer);
        byte[] b2 = f.b(byteBuffer);
        ArrayList arrayList = new ArrayList();
        int i4 = -1;
        int i5 = 0;
        byte[] bArr = null;
        while (true) {
            int i6 = 8;
            boolean z = true;
            if (!a3.hasRemaining()) {
                if (i4 == -1) {
                    if (i5 == 0) {
                        throw new SecurityException("No signatures found");
                    }
                    throw new SecurityException("No supported signatures found");
                }
                String c2 = f.c(i4);
                Pair<String, ? extends AlgorithmParameterSpec> d2 = f.d(i4);
                String str = (String) d2.first;
                AlgorithmParameterSpec algorithmParameterSpec = (AlgorithmParameterSpec) d2.second;
                try {
                    PublicKey generatePublic = KeyFactory.getInstance(c2).generatePublic(new X509EncodedKeySpec(b2));
                    Signature signature = Signature.getInstance(str);
                    signature.initVerify(generatePublic);
                    if (algorithmParameterSpec != null) {
                        signature.setParameter(algorithmParameterSpec);
                    }
                    signature.update(a2);
                    if (signature.verify(bArr)) {
                        a2.clear();
                        ByteBuffer a4 = f.a(a2);
                        ArrayList arrayList2 = new ArrayList();
                        byte[] bArr2 = null;
                        int i7 = 0;
                        while (a4.hasRemaining()) {
                            i7++;
                            try {
                                ByteBuffer a5 = f.a(a4);
                                if (a5.remaining() >= i6) {
                                    int i8 = a5.getInt();
                                    arrayList2.add(Integer.valueOf(i8));
                                    if (i8 == i4) {
                                        bArr2 = f.b(a5);
                                    }
                                    i6 = 8;
                                } else {
                                    throw new IOException("Record too short");
                                }
                            } catch (IOException | BufferUnderflowException e2) {
                                throw new IOException("Failed to parse digest record #".concat(String.valueOf(i7)), e2);
                            }
                        }
                        if (arrayList.equals(arrayList2)) {
                            int a6 = f.a(i4);
                            byte[] put = map.put(Integer.valueOf(a6), bArr2);
                            if (put != null && !MessageDigest.isEqual(put, bArr2)) {
                                throw new SecurityException(f.b(a6) + " contents digest does not match the digest specified by a preceding signer");
                            }
                            ByteBuffer a7 = f.a(a2);
                            ArrayList arrayList3 = new ArrayList();
                            int i9 = 0;
                            while (a7.hasRemaining()) {
                                i9++;
                                byte[] b3 = f.b(a7);
                                try {
                                    arrayList3.add(new p((X509Certificate) certificateFactory.generateCertificate(new ByteArrayInputStream(b3)), b3));
                                } catch (CertificateException e3) {
                                    throw new SecurityException("Failed to decode certificate #".concat(String.valueOf(i9)), e3);
                                }
                            }
                            if (!arrayList3.isEmpty()) {
                                if (Arrays.equals(b2, ((X509Certificate) arrayList3.get(0)).getPublicKey().getEncoded())) {
                                    if (a2.getInt() == i2) {
                                        if (a2.getInt() == i3) {
                                            return a(f.a(a2), arrayList3, certificateFactory);
                                        }
                                        throw new SecurityException("maxSdkVersion mismatch between signed and unsigned in v3 signer block.");
                                    }
                                    throw new SecurityException("minSdkVersion mismatch between signed and unsigned in v3 signer block.");
                                }
                                throw new SecurityException("Public key mismatch between certificate and signature record");
                            }
                            throw new SecurityException("No certificates listed");
                        }
                        throw new SecurityException("Signature algorithms don't match between digests and signatures records");
                    }
                    throw new SecurityException(str + " signature did not verify");
                } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | SignatureException | InvalidKeySpecException e4) {
                    throw new SecurityException("Failed to verify " + str + " signature", e4);
                }
            }
            i5++;
            try {
                ByteBuffer a8 = f.a(a3);
                if (a8.remaining() >= 8) {
                    int i10 = a8.getInt();
                    arrayList.add(Integer.valueOf(i10));
                    if (i10 != 513 && i10 != 514 && i10 != 769 && i10 != 1057 && i10 != 1059 && i10 != 1061) {
                        switch (i10) {
                            case 257:
                            case 258:
                            case 259:
                            case TipsMessageBean.MSG_TYPE_GROUP_QUITE /* 260 */:
                                break;
                            default:
                                z = false;
                                break;
                        }
                    }
                    if (z && (i4 == -1 || f.a(i10, i4) > 0)) {
                        bArr = f.b(a8);
                        i4 = i10;
                    }
                } else {
                    throw new SecurityException("Signature record too short");
                }
            } catch (IOException | BufferUnderflowException e5) {
                throw new SecurityException("Failed to parse signature record #".concat(String.valueOf(i5)), e5);
            }
        }
    }

    private static C0082c a(ByteBuffer byteBuffer, List<X509Certificate> list, CertificateFactory certificateFactory) {
        X509Certificate[] x509CertificateArr = (X509Certificate[]) list.toArray(new X509Certificate[list.size()]);
        b bVar = null;
        while (byteBuffer.hasRemaining()) {
            ByteBuffer a2 = f.a(byteBuffer);
            if (a2.remaining() >= 4) {
                if (a2.getInt() == 1000370060) {
                    if (bVar == null) {
                        bVar = a(a2, certificateFactory);
                        try {
                            if (bVar.a.size() > 0) {
                                List<X509Certificate> list2 = bVar.a;
                                if (!Arrays.equals(list2.get(list2.size() - 1).getEncoded(), x509CertificateArr[0].getEncoded())) {
                                    throw new SecurityException("Terminal certificate in Proof-of-rotation record does not match APK signing certificate");
                                }
                            } else {
                                continue;
                            }
                        } catch (CertificateEncodingException e2) {
                            throw new SecurityException("Failed to encode certificate when comparing Proof-of-rotation record and signing certificate", e2);
                        }
                    } else {
                        throw new SecurityException("Encountered multiple Proof-of-rotation records when verifying APK Signature Scheme v3 signature");
                    }
                }
            } else {
                throw new IOException("Remaining buffer too short to contain additional attribute ID. Remaining: " + a2.remaining());
            }
        }
        return new C0082c(x509CertificateArr, bVar);
    }

    private static b a(ByteBuffer byteBuffer, CertificateFactory certificateFactory) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int i2 = 0;
        try {
            byteBuffer.getInt();
            HashSet hashSet = new HashSet();
            int i3 = -1;
            p pVar = null;
            while (byteBuffer.hasRemaining()) {
                i2++;
                ByteBuffer a2 = f.a(byteBuffer);
                ByteBuffer a3 = f.a(a2);
                int i4 = a2.getInt();
                int i5 = a2.getInt();
                byte[] b2 = f.b(a2);
                if (pVar != null) {
                    Pair<String, ? extends AlgorithmParameterSpec> d2 = f.d(i3);
                    PublicKey publicKey = pVar.getPublicKey();
                    Signature signature = Signature.getInstance((String) d2.first);
                    signature.initVerify(publicKey);
                    Object obj = d2.second;
                    if (obj != null) {
                        signature.setParameter((AlgorithmParameterSpec) obj);
                    }
                    signature.update(a3);
                    if (!signature.verify(b2)) {
                        throw new SecurityException("Unable to verify signature of certificate #" + i2 + " using " + ((String) d2.first) + " when verifying Proof-of-rotation record");
                    }
                }
                a3.rewind();
                byte[] b3 = f.b(a3);
                int i6 = a3.getInt();
                if (pVar != null && i3 != i6) {
                    throw new SecurityException("Signing algorithm ID mismatch for certificate #" + i2 + " when verifying Proof-of-rotation record");
                }
                pVar = new p((X509Certificate) certificateFactory.generateCertificate(new ByteArrayInputStream(b3)), b3);
                if (!hashSet.contains(pVar)) {
                    hashSet.add(pVar);
                    arrayList.add(pVar);
                    arrayList2.add(Integer.valueOf(i4));
                    i3 = i5;
                } else {
                    throw new SecurityException("Encountered duplicate entries in Proof-of-rotation record at certificate #" + i2 + ".  All signing certificates should be unique");
                }
            }
            return new b(arrayList, arrayList2);
        } catch (IOException e2) {
            e = e2;
            throw new IOException("Failed to parse Proof-of-rotation record", e);
        } catch (BufferUnderflowException e3) {
            e = e3;
            throw new IOException("Failed to parse Proof-of-rotation record", e);
        } catch (InvalidAlgorithmParameterException e4) {
            e = e4;
            throw new SecurityException("Failed to verify signature over signed data for certificate #0 when verifying Proof-of-rotation record", e);
        } catch (InvalidKeyException e5) {
            e = e5;
            throw new SecurityException("Failed to verify signature over signed data for certificate #0 when verifying Proof-of-rotation record", e);
        } catch (NoSuchAlgorithmException e6) {
            e = e6;
            throw new SecurityException("Failed to verify signature over signed data for certificate #0 when verifying Proof-of-rotation record", e);
        } catch (SignatureException e7) {
            e = e7;
            throw new SecurityException("Failed to verify signature over signed data for certificate #0 when verifying Proof-of-rotation record", e);
        } catch (CertificateException e8) {
            throw new SecurityException("Failed to decode certificate #0 when verifying Proof-of-rotation record", e8);
        }
    }
}
