package k.b.a.a.l;

import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Locale;
import k.b.a.a.k.o;
import k.b.a.a.m.c;
import k.b.a.a.n.n.f;

/* loaded from: classes4.dex */
public class a {
    private final String a;
    private final String[] b;

    /* renamed from: c  reason: collision with root package name */
    private final String[] f16075c;

    private a(String[] strArr) {
        if (strArr != null) {
            if (strArr.length != 0) {
                this.b = strArr;
                this.a = strArr[0];
                if (strArr.length <= 1) {
                    this.f16075c = null;
                    return;
                }
                String[] strArr2 = new String[strArr.length - 1];
                this.f16075c = strArr2;
                System.arraycopy(strArr, 1, strArr2, 0, strArr2.length);
                return;
            }
            throw new IllegalArgumentException(String.format("Usage: java %s [algorithm] [FILE|DIRECTORY|string] ...", a.class.getName()));
        }
        throw new IllegalArgumentException("args");
    }

    public static void a(String[] strArr) throws IOException {
        new a(strArr).d();
    }

    private void b(String str, byte[] bArr) {
        c(str, bArr, null);
    }

    private void c(String str, byte[] bArr, String str2) {
        String str3;
        PrintStream printStream = System.out;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(o.s(bArr));
        if (str2 != null) {
            str3 = "  " + str2;
        } else {
            str3 = "";
        }
        sb.append(str3);
        printStream.println(sb.toString());
    }

    private void d() throws IOException {
        if (!this.a.equalsIgnoreCase(f.f16214f) && !this.a.equals("*")) {
            MessageDigest t = c.t(this.a, null);
            if (t != null) {
                f("", t);
                return;
            } else {
                f("", c.s(this.a.toUpperCase(Locale.ROOT)));
                return;
            }
        }
        h(k.b.a.a.m.f.a());
    }

    private void e(String str, String str2) throws IOException {
        f(str, c.s(str2));
    }

    private void f(String str, MessageDigest messageDigest) throws IOException {
        String[] strArr = this.f16075c;
        if (strArr == null) {
            b(str, c.g(messageDigest, System.in));
            return;
        }
        for (String str2 : strArr) {
            File file = new File(str2);
            if (file.isFile()) {
                c(str, c.f(messageDigest, file), str2);
            } else if (file.isDirectory()) {
                File[] listFiles = file.listFiles();
                if (listFiles != null) {
                    g(str, messageDigest, listFiles);
                }
            } else {
                b(str, c.k(messageDigest, str2.getBytes(Charset.defaultCharset())));
            }
        }
    }

    private void g(String str, MessageDigest messageDigest, File[] fileArr) throws IOException {
        for (File file : fileArr) {
            if (file.isFile()) {
                c(str, c.f(messageDigest, file), file.getName());
            }
        }
    }

    private void h(String[] strArr) throws IOException {
        for (String str : strArr) {
            if (c.I(str)) {
                e(str + ExpandableTextView.N, str);
            }
        }
    }

    public String toString() {
        return String.format("%s %s", super.toString(), Arrays.toString(this.b));
    }
}
