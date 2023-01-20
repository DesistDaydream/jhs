package e.k.c.a.a.j.q;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: classes2.dex */
public class a {
    private static final String a = "BksUtil";
    private static final String b = "com.huawei.hwid";

    /* renamed from: c  reason: collision with root package name */
    private static final String f11967c = "com.huawei.hwid";

    /* renamed from: d  reason: collision with root package name */
    private static final String f11968d = "com.huawei.hms";

    /* renamed from: e  reason: collision with root package name */
    private static final String f11969e = "com.huawei.hwid.tv";

    /* renamed from: g  reason: collision with root package name */
    private static final String f11971g = "files/hmsrootcas.bks";

    /* renamed from: h  reason: collision with root package name */
    private static final String f11972h = "4.0.2.300";

    /* renamed from: i  reason: collision with root package name */
    private static final String f11973i = "aegis";

    /* renamed from: j  reason: collision with root package name */
    private static final String f11974j = "hmsrootcas.bks";

    /* renamed from: k  reason: collision with root package name */
    private static final long f11975k = 604800000;

    /* renamed from: l  reason: collision with root package name */
    private static final String f11976l = "last_update_time";

    /* renamed from: m  reason: collision with root package name */
    private static final String f11977m = "B92825C2BD5D6D6D1E7F39EECD17843B7D9016F611136B75441BC6F4D3F00F05";
    private static final String n = "3517262215D8D3008CBF888750B6418EDC4D562AC33ED6874E0D73ABA667BC3C";
    private static final String q = "";
    private static final String r = "bks_hash";

    /* renamed from: f  reason: collision with root package name */
    private static final Uri f11970f = Uri.parse("content://com.huawei.hwid");
    private static final String o = "E49D5C2C0E11B3B1B96CA56C6DE2A14EC7DAB5CCC3B5F300D03E5B4DBA44F539";
    private static final String[] p = {"B92825C2BD5D6D6D1E7F39EECD17843B7D9016F611136B75441BC6F4D3F00F05", o};

    private a() {
    }

    private static int a(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        File file = new File(str);
        if (file.exists()) {
            i.g(a, "The directory  has already exists");
            return 1;
        } else if (file.mkdirs()) {
            i.b(a, "create directory  success");
            return 0;
        } else {
            i.d(a, "create directory  failed");
            return -1;
        }
    }

    private static String b(Context context) {
        if (Build.VERSION.SDK_INT >= 24) {
            return context.createDeviceProtectedStorageContext().getFilesDir() + File.separator + f11973i;
        }
        return context.getApplicationContext().getFilesDir() + File.separator + f11973i;
    }

    private static String c(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (byte b2 : bArr) {
            String hexString = Integer.toHexString(b2 & 255);
            if (hexString.length() == 1) {
                sb.append('0');
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    private static void d(InputStream inputStream, Context context) {
        if (inputStream == null || context == null) {
            return;
        }
        String b2 = b(context);
        if (!new File(b2).exists()) {
            a(b2);
        }
        File file = new File(b2, "hmsrootcas.bks");
        if (file.exists()) {
            file.delete();
        }
        FileOutputStream fileOutputStream = null;
        try {
            try {
                i.e(a, "write output stream ");
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                try {
                    byte[] bArr = new byte[2048];
                    while (true) {
                        int read = inputStream.read(bArr, 0, 2048);
                        if (read != -1) {
                            fileOutputStream2.write(bArr, 0, read);
                        } else {
                            h.h(fileOutputStream2);
                            return;
                        }
                    }
                } catch (IOException unused) {
                    fileOutputStream = fileOutputStream2;
                    i.d(a, " IOException");
                    h.h(fileOutputStream);
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    h.h(fileOutputStream);
                    throw th;
                }
            } catch (IOException unused2) {
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static boolean e(int i2) {
        return i2 >= 40002300;
    }

    private static byte[] f(Context context, String str) {
        PackageInfo packageInfo;
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager != null && (packageInfo = packageManager.getPackageInfo(str, 64)) != null) {
                    return packageInfo.signatures[0].toByteArray();
                }
            } catch (PackageManager.NameNotFoundException e2) {
                Log.e(a, "PackageManager.NameNotFoundException : " + e2.getMessage());
            } catch (Exception e3) {
                Log.e(a, "get pm exception : " + e3.getMessage());
            }
            return new byte[0];
        }
        Log.e(a, "packageName is null or context is null");
        return new byte[0];
    }

    private static String g(Context context) {
        return b(context) + File.separator + "hmsrootcas.bks";
    }

    private static String h(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(bArr);
            return c(messageDigest.digest());
        } catch (NoSuchAlgorithmException unused) {
            i.d(a, "inputstraem exception");
            return "";
        }
    }

    private static boolean i(Context context, String str) {
        return o.equalsIgnoreCase(k(f(context, str)));
    }

    private static boolean j(String str) {
        int parseInt;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        i.e(a, "hms version code is : " + str);
        String[] split = str.split("\\.");
        String[] split2 = f11972h.split("\\.");
        int length = split.length;
        int length2 = split2.length;
        int max = Math.max(length, length2);
        int i2 = 0;
        while (i2 < max) {
            if (i2 < length) {
                try {
                    parseInt = Integer.parseInt(split[i2]);
                } catch (Exception e2) {
                    i.d(a, " exception : " + e2.getMessage());
                    return i2 >= length2;
                }
            } else {
                parseInt = 0;
            }
            int parseInt2 = i2 < length2 ? Integer.parseInt(split2[i2]) : 0;
            if (parseInt < parseInt2) {
                return false;
            }
            if (parseInt > parseInt2) {
                return true;
            }
            i2++;
        }
        return true;
    }

    private static String k(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return "";
        }
        try {
            return c(MessageDigest.getInstance("SHA-256").digest(bArr));
        } catch (NoSuchAlgorithmException e2) {
            Log.e(a, "NoSuchAlgorithmException" + e2.getMessage());
            return "";
        }
    }

    private static boolean l(Context context) {
        return new File(b(context) + File.separator + "hmsrootcas.bks").exists();
    }

    private static boolean m(Context context, String str) {
        byte[] f2 = f(context, str);
        for (String str2 : p) {
            if (str2.equalsIgnoreCase(k(f2))) {
                return true;
            }
        }
        return false;
    }

    public static synchronized InputStream n(Context context) {
        InputStream inputStream;
        ByteArrayInputStream byteArrayInputStream;
        String c2;
        String h2;
        synchronized (a.class) {
            i.e(a, "get bks from tss begin");
            if (context != null) {
                e.b(context);
            }
            Context a2 = e.a();
            ByteArrayInputStream byteArrayInputStream2 = null;
            if (a2 == null) {
                i.d(a, "context is null");
                return null;
            } else if (!j(j.a("com.huawei.hwid")) && !j(j.a("com.huawei.hms"))) {
                i.d(a, "hms version code is too low : " + j.a("com.huawei.hwid"));
                return null;
            } else if (!m(a2, "com.huawei.hwid") && !i(a2, "com.huawei.hms")) {
                i.d(a, "hms sign error");
                return null;
            } else {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    inputStream = a2.getContentResolver().openInputStream(Uri.withAppendedPath(f11970f, f11971g));
                    try {
                        try {
                            byte[] bArr = new byte[1024];
                            while (true) {
                                int read = inputStream.read(bArr);
                                if (read <= -1) {
                                    break;
                                }
                                byteArrayOutputStream.write(bArr, 0, read);
                            }
                            byteArrayOutputStream.flush();
                            byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                            try {
                                c2 = k.c(r, "", a2);
                                h2 = h(byteArrayOutputStream.toByteArray());
                            } catch (Exception unused) {
                                byteArrayInputStream2 = byteArrayInputStream;
                                i.d(a, "Get bks from HMS_VERSION_CODE exception : No content provider");
                                h.g(inputStream);
                                h.h(byteArrayOutputStream);
                                h.g(byteArrayInputStream2);
                                return o(a2);
                            } catch (Throwable th) {
                                th = th;
                                byteArrayInputStream2 = byteArrayInputStream;
                                h.g(inputStream);
                                h.h(byteArrayOutputStream);
                                h.g(byteArrayInputStream2);
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    } catch (Exception unused2) {
                    }
                } catch (Exception unused3) {
                    inputStream = null;
                } catch (Throwable th3) {
                    th = th3;
                    inputStream = null;
                }
                if (l(a2) && c2.equals(h2)) {
                    i.e(a, "bks not update");
                    h.g(inputStream);
                    h.h(byteArrayOutputStream);
                    h.g(byteArrayInputStream);
                    return o(a2);
                }
                i.e(a, "update bks and sp");
                d(byteArrayInputStream, a2);
                k.i(r, h2, a2);
                h.g(inputStream);
                h.h(byteArrayOutputStream);
                h.g(byteArrayInputStream);
                return o(a2);
            }
        }
    }

    public static InputStream o(Context context) {
        if (l(context)) {
            i.e(a, "getFilesBksIS ");
            try {
                return new FileInputStream(g(context));
            } catch (FileNotFoundException unused) {
                i.d(a, "FileNotFoundExceptio: ");
                return null;
            }
        }
        return null;
    }
}
