package k.b.a.a.m;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import k.b.a.a.k.o;
import k.b.a.a.k.p;

/* loaded from: classes4.dex */
public class c {
    private static final int b = 1024;
    private final MessageDigest a;

    @Deprecated
    public c() {
        this.a = null;
    }

    public static MessageDigest A() {
        return s(f.f16085j);
    }

    public static String A0(String str) {
        return o.s(x0(str));
    }

    public static MessageDigest B() {
        return s(f.f16086k);
    }

    public static String B0(byte[] bArr) {
        return o.s(y0(bArr));
    }

    public static MessageDigest C() {
        return s(f.f16087l);
    }

    public static byte[] C0(InputStream inputStream) throws IOException {
        return g(C(), inputStream);
    }

    public static MessageDigest D() {
        return s(f.f16088m);
    }

    public static byte[] D0(String str) {
        return E0(p.k(str));
    }

    public static MessageDigest E() {
        return s("SHA-512");
    }

    public static byte[] E0(byte[] bArr) {
        return C().digest(bArr);
    }

    public static MessageDigest F() {
        return s(f.f16083h);
    }

    public static String F0(InputStream inputStream) throws IOException {
        return o.s(C0(inputStream));
    }

    public static MessageDigest G() {
        return s(f.f16084i);
    }

    public static String G0(String str) {
        return o.s(D0(str));
    }

    @Deprecated
    public static MessageDigest H() {
        return x();
    }

    public static String H0(byte[] bArr) {
        return o.s(E0(bArr));
    }

    public static boolean I(String str) {
        return t(str, null) != null;
    }

    public static byte[] I0(InputStream inputStream) throws IOException {
        return g(D(), inputStream);
    }

    public static byte[] J(InputStream inputStream) throws IOException {
        return g(u(), inputStream);
    }

    public static byte[] J0(String str) {
        return K0(p.k(str));
    }

    public static byte[] K(String str) {
        return L(p.k(str));
    }

    public static byte[] K0(byte[] bArr) {
        return D().digest(bArr);
    }

    public static byte[] L(byte[] bArr) {
        return u().digest(bArr);
    }

    public static String L0(InputStream inputStream) throws IOException {
        return o.s(I0(inputStream));
    }

    public static String M(InputStream inputStream) throws IOException {
        return o.s(J(inputStream));
    }

    public static String M0(String str) {
        return o.s(J0(str));
    }

    public static String N(String str) {
        return o.s(K(str));
    }

    public static String N0(byte[] bArr) {
        return o.s(K0(bArr));
    }

    public static String O(byte[] bArr) {
        return o.s(L(bArr));
    }

    public static byte[] O0(InputStream inputStream) throws IOException {
        return g(E(), inputStream);
    }

    public static byte[] P(InputStream inputStream) throws IOException {
        return g(v(), inputStream);
    }

    public static byte[] P0(String str) {
        return Q0(p.k(str));
    }

    public static byte[] Q(String str) {
        return R(p.k(str));
    }

    public static byte[] Q0(byte[] bArr) {
        return E().digest(bArr);
    }

    public static byte[] R(byte[] bArr) {
        return v().digest(bArr);
    }

    public static String R0(InputStream inputStream) throws IOException {
        return o.s(O0(inputStream));
    }

    public static String S(InputStream inputStream) throws IOException {
        return o.s(P(inputStream));
    }

    public static String S0(String str) {
        return o.s(P0(str));
    }

    public static String T(String str) {
        return o.s(Q(str));
    }

    public static String T0(byte[] bArr) {
        return o.s(Q0(bArr));
    }

    public static String U(byte[] bArr) {
        return o.s(R(bArr));
    }

    public static byte[] U0(InputStream inputStream) throws IOException {
        return g(F(), inputStream);
    }

    @Deprecated
    public static byte[] V(InputStream inputStream) throws IOException {
        return Y(inputStream);
    }

    public static byte[] V0(String str) {
        return W0(p.k(str));
    }

    @Deprecated
    public static byte[] W(String str) {
        return Z(str);
    }

    public static byte[] W0(byte[] bArr) {
        return F().digest(bArr);
    }

    @Deprecated
    public static byte[] X(byte[] bArr) {
        return a0(bArr);
    }

    public static String X0(InputStream inputStream) throws IOException {
        return o.s(U0(inputStream));
    }

    public static byte[] Y(InputStream inputStream) throws IOException {
        return g(x(), inputStream);
    }

    public static String Y0(String str) {
        return o.s(V0(str));
    }

    public static byte[] Z(String str) {
        return a0(p.k(str));
    }

    public static String Z0(byte[] bArr) {
        return o.s(W0(bArr));
    }

    public static byte[] a0(byte[] bArr) {
        return x().digest(bArr);
    }

    public static byte[] a1(InputStream inputStream) throws IOException {
        return g(G(), inputStream);
    }

    public static String b0(InputStream inputStream) throws IOException {
        return o.s(Y(inputStream));
    }

    public static byte[] b1(String str) {
        return c1(p.k(str));
    }

    public static String c0(String str) {
        return o.s(Z(str));
    }

    public static byte[] c1(byte[] bArr) {
        return G().digest(bArr);
    }

    public static String d0(byte[] bArr) {
        return o.s(a0(bArr));
    }

    public static String d1(InputStream inputStream) throws IOException {
        return o.s(a1(inputStream));
    }

    public static byte[] e0(InputStream inputStream) throws IOException {
        return g(y(), inputStream);
    }

    public static String e1(String str) {
        return o.s(b1(str));
    }

    public static byte[] f(MessageDigest messageDigest, File file) throws IOException {
        return j1(messageDigest, file).digest();
    }

    public static byte[] f0(String str) {
        return g0(p.k(str));
    }

    public static String f1(byte[] bArr) {
        return o.s(c1(bArr));
    }

    public static byte[] g(MessageDigest messageDigest, InputStream inputStream) throws IOException {
        return k1(messageDigest, inputStream).digest();
    }

    public static byte[] g0(byte[] bArr) {
        return y().digest(bArr);
    }

    @Deprecated
    public static String g1(InputStream inputStream) throws IOException {
        return b0(inputStream);
    }

    public static byte[] h(MessageDigest messageDigest, RandomAccessFile randomAccessFile) throws IOException {
        return l1(messageDigest, randomAccessFile).digest();
    }

    public static String h0(InputStream inputStream) throws IOException {
        return o.s(e0(inputStream));
    }

    @Deprecated
    public static String h1(String str) {
        return c0(str);
    }

    public static byte[] i(MessageDigest messageDigest, ByteBuffer byteBuffer) {
        messageDigest.update(byteBuffer);
        return messageDigest.digest();
    }

    public static String i0(String str) {
        return o.s(f0(str));
    }

    @Deprecated
    public static String i1(byte[] bArr) {
        return d0(bArr);
    }

    public static byte[] j(MessageDigest messageDigest, Path path, OpenOption... openOptionArr) throws IOException {
        return p1(messageDigest, path, openOptionArr).digest();
    }

    public static String j0(byte[] bArr) {
        return o.s(g0(bArr));
    }

    public static MessageDigest j1(MessageDigest messageDigest, File file) throws IOException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
        try {
            MessageDigest k1 = k1(messageDigest, bufferedInputStream);
            bufferedInputStream.close();
            return k1;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    bufferedInputStream.close();
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                }
                throw th2;
            }
        }
    }

    public static byte[] k(MessageDigest messageDigest, byte[] bArr) {
        return messageDigest.digest(bArr);
    }

    public static byte[] k0(InputStream inputStream) throws IOException {
        return g(z(), inputStream);
    }

    public static MessageDigest k1(MessageDigest messageDigest, InputStream inputStream) throws IOException {
        byte[] bArr = new byte[1024];
        int read = inputStream.read(bArr, 0, 1024);
        while (read > -1) {
            messageDigest.update(bArr, 0, read);
            read = inputStream.read(bArr, 0, 1024);
        }
        return messageDigest;
    }

    public static byte[] l0(String str) {
        return m0(p.k(str));
    }

    public static MessageDigest l1(MessageDigest messageDigest, RandomAccessFile randomAccessFile) throws IOException {
        return o1(messageDigest, randomAccessFile.getChannel());
    }

    public static byte[] m0(byte[] bArr) {
        return z().digest(bArr);
    }

    public static MessageDigest m1(MessageDigest messageDigest, String str) {
        messageDigest.update(p.k(str));
        return messageDigest;
    }

    public static String n0(InputStream inputStream) throws IOException {
        return o.s(k0(inputStream));
    }

    public static MessageDigest n1(MessageDigest messageDigest, ByteBuffer byteBuffer) {
        messageDigest.update(byteBuffer);
        return messageDigest;
    }

    public static String o0(String str) {
        return o.s(l0(str));
    }

    private static MessageDigest o1(MessageDigest messageDigest, FileChannel fileChannel) throws IOException {
        ByteBuffer allocate = ByteBuffer.allocate(1024);
        while (fileChannel.read(allocate) > 0) {
            allocate.flip();
            messageDigest.update(allocate);
            allocate.clear();
        }
        return messageDigest;
    }

    public static String p0(byte[] bArr) {
        return o.s(m0(bArr));
    }

    public static MessageDigest p1(MessageDigest messageDigest, Path path, OpenOption... openOptionArr) throws IOException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(Files.newInputStream(path, openOptionArr));
        try {
            MessageDigest k1 = k1(messageDigest, bufferedInputStream);
            bufferedInputStream.close();
            return k1;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    bufferedInputStream.close();
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                }
                throw th2;
            }
        }
    }

    public static byte[] q0(InputStream inputStream) throws IOException {
        return g(A(), inputStream);
    }

    public static MessageDigest q1(MessageDigest messageDigest, byte[] bArr) {
        messageDigest.update(bArr);
        return messageDigest;
    }

    public static byte[] r0(String str) {
        return s0(p.k(str));
    }

    public static MessageDigest s(String str) {
        try {
            return MessageDigest.getInstance(str);
        } catch (NoSuchAlgorithmException e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    public static byte[] s0(byte[] bArr) {
        return A().digest(bArr);
    }

    public static MessageDigest t(String str, MessageDigest messageDigest) {
        try {
            return MessageDigest.getInstance(str);
        } catch (Exception unused) {
            return messageDigest;
        }
    }

    public static String t0(InputStream inputStream) throws IOException {
        return o.s(q0(inputStream));
    }

    public static MessageDigest u() {
        return s(f.a);
    }

    public static String u0(String str) {
        return o.s(r0(str));
    }

    public static MessageDigest v() {
        return s("MD5");
    }

    public static String v0(byte[] bArr) {
        return o.s(s0(bArr));
    }

    public static byte[] w0(InputStream inputStream) throws IOException {
        return g(B(), inputStream);
    }

    public static MessageDigest x() {
        return s("SHA-1");
    }

    public static byte[] x0(String str) {
        return y0(p.k(str));
    }

    public static MessageDigest y() {
        return s("SHA-256");
    }

    public static byte[] y0(byte[] bArr) {
        return B().digest(bArr);
    }

    public static MessageDigest z() {
        return s("SHA-384");
    }

    public static String z0(InputStream inputStream) throws IOException {
        return o.s(w0(inputStream));
    }

    public byte[] a(File file) throws IOException {
        return j1(this.a, file).digest();
    }

    public byte[] b(InputStream inputStream) throws IOException {
        return k1(this.a, inputStream).digest();
    }

    public byte[] c(String str) {
        return m1(this.a, str).digest();
    }

    public byte[] d(ByteBuffer byteBuffer) {
        return n1(this.a, byteBuffer).digest();
    }

    public byte[] e(Path path, OpenOption... openOptionArr) throws IOException {
        return p1(this.a, path, openOptionArr).digest();
    }

    public byte[] l(byte[] bArr) {
        return q1(this.a, bArr).digest();
    }

    public String m(File file) throws IOException {
        return o.s(a(file));
    }

    public String n(InputStream inputStream) throws IOException {
        return o.s(b(inputStream));
    }

    public String o(String str) {
        return o.s(c(str));
    }

    public String p(ByteBuffer byteBuffer) {
        return o.s(d(byteBuffer));
    }

    public String q(Path path, OpenOption... openOptionArr) throws IOException {
        return o.s(e(path, openOptionArr));
    }

    public String r(byte[] bArr) {
        return o.s(l(bArr));
    }

    public MessageDigest w() {
        return this.a;
    }

    public c(MessageDigest messageDigest) {
        this.a = messageDigest;
    }

    public c(String str) {
        this(s(str));
    }
}
