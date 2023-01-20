package e.k.c.a.a.h.d;

import android.text.TextUtils;
import e.k.c.a.a.h.g.f;
import e.k.c.a.a.h.g.g;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: classes2.dex */
public abstract class a {
    private static final int a = 8192;
    private static final String b = "SHA-256";

    /* renamed from: c  reason: collision with root package name */
    private static final String f11846c = "FileSHA256";

    /* renamed from: d  reason: collision with root package name */
    private static final String f11847d = "";

    /* renamed from: e  reason: collision with root package name */
    private static final String[] f11848e = {"SHA-256", "SHA-384", "SHA-512"};

    private static boolean a(File file) {
        return file != null && file.exists() && file.length() > 0;
    }

    private static boolean b(String str) {
        for (String str2 : f11848e) {
            if (str2.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static String c(File file) {
        return d(file, "SHA-256");
    }

    public static String d(File file, String str) {
        FileInputStream fileInputStream;
        MessageDigest messageDigest;
        if (!TextUtils.isEmpty(str) && b(str)) {
            if (!a(file)) {
                g.d(f11846c, "file is not valid");
                return "";
            }
            InputStream inputStream = null;
            String str2 = null;
            try {
                try {
                    messageDigest = MessageDigest.getInstance(str);
                    fileInputStream = new FileInputStream(file);
                } catch (IOException e2) {
                    e = e2;
                    fileInputStream = null;
                } catch (NoSuchAlgorithmException e3) {
                    e = e3;
                    fileInputStream = null;
                } catch (Throwable th) {
                    th = th;
                    f.g(inputStream);
                    throw th;
                }
                try {
                    byte[] bArr = new byte[8192];
                    boolean z = false;
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read <= 0) {
                            break;
                        }
                        messageDigest.update(bArr, 0, read);
                        z = true;
                    }
                    str2 = z ? e.k.c.a.a.h.g.c.b(messageDigest.digest()) : null;
                    f.g(fileInputStream);
                } catch (IOException e4) {
                    e = e4;
                    g.d(f11846c, "IOException" + e.getMessage());
                    f.g(fileInputStream);
                    return str2;
                } catch (NoSuchAlgorithmException e5) {
                    e = e5;
                    g.d(f11846c, "NoSuchAlgorithmException" + e.getMessage());
                    f.g(fileInputStream);
                    return str2;
                }
                return str2;
            } catch (Throwable th2) {
                th = th2;
                inputStream = "";
                f.g(inputStream);
                throw th;
            }
        }
        g.d(f11846c, "algorithm is empty or not safe");
        return "";
    }

    public static String e(InputStream inputStream) {
        return inputStream == null ? "" : f(inputStream, "SHA-256");
    }

    public static String f(InputStream inputStream, String str) {
        if (inputStream == null) {
            return "";
        }
        byte[] bArr = new byte[8192];
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(str);
            while (true) {
                int read = inputStream.read(bArr);
                if (read < 0) {
                    return e.k.c.a.a.h.g.c.b(messageDigest.digest());
                }
                if (read > 0) {
                    messageDigest.update(bArr, 0, read);
                }
            }
        } catch (IOException | NoSuchAlgorithmException unused) {
            g.d(f11846c, "inputstraem exception");
            return "";
        } finally {
            f.g(inputStream);
        }
    }

    public static boolean g(File file, String str, String str2) {
        if (!TextUtils.isEmpty(str) && b(str2)) {
            return str.equals(d(file, str2));
        }
        g.d(f11846c, "hash value is null || algorithm is illegal");
        return false;
    }

    public static boolean h(File file, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.equalsIgnoreCase(c(file));
    }

    public static boolean i(InputStream inputStream, String str, String str2) {
        if (!TextUtils.isEmpty(str) && b(str2)) {
            return str.equals(f(inputStream, str2));
        }
        g.d(f11846c, "hash value is null || algorithm is illegal");
        return false;
    }

    public static boolean j(InputStream inputStream, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.equals(e(inputStream));
    }
}
