package e.k.c.a.a.k;

import android.text.TextUtils;
import android.util.Log;
import com.huawei.secure.android.common.util.LogsUtil;
import com.huawei.secure.android.common.util.SecurityCommonException;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

/* loaded from: classes2.dex */
public class k {
    private static final String a = "ZipUtil";
    private static final int b = 104857600;

    /* renamed from: c  reason: collision with root package name */
    private static final int f11985c = 100;

    /* renamed from: d  reason: collision with root package name */
    private static final int f11986d = 4096;

    /* renamed from: e  reason: collision with root package name */
    private static final String f11987e = "../";

    /* renamed from: f  reason: collision with root package name */
    private static final String f11988f = "..\\";

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:79:0x012c  */
    @android.annotation.SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.util.List<java.io.File> a(java.io.File r17, java.io.File r18, long r19, boolean r21) {
        /*
            Method dump skipped, instructions count: 305
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: e.k.c.a.a.k.k.a(java.io.File, java.io.File, long, boolean):java.util.List");
    }

    private static void b(FileInputStream fileInputStream, BufferedOutputStream bufferedOutputStream, ZipInputStream zipInputStream, FileOutputStream fileOutputStream) {
        d.c(fileInputStream);
        d.d(bufferedOutputStream);
        d.c(zipInputStream);
        d.d(fileOutputStream);
    }

    private static void c(String str) {
        if (TextUtils.isEmpty(str) || !o(str)) {
            return;
        }
        Log.e(a, "IllegalArgumentException--path is not a standard path");
        throw new IllegalArgumentException("path is not a standard path");
    }

    private static boolean d(File file) {
        return file != null && (!file.exists() ? !file.mkdirs() : !file.isDirectory());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x0071 -> B:39:0x0074). Please submit an issue!!! */
    private static boolean e(String str, long j2, int i2) {
        int i3;
        boolean z = false;
        ZipFile zipFile = null;
        try {
        } catch (IOException unused) {
            LogsUtil.l(a, "close zipFile IOException ");
            zipFile = zipFile;
        }
        try {
            try {
                ZipFile zipFile2 = new ZipFile(str);
                try {
                    Enumeration<? extends ZipEntry> entries = zipFile2.entries();
                    long j3 = 0;
                    int i4 = 0;
                    while (entries.hasMoreElements()) {
                        ZipEntry nextElement = entries.nextElement();
                        j3 += nextElement.getSize();
                        int i5 = i4 + 1;
                        if (!o(nextElement.getName()) && i5 < i2 && j3 <= j2) {
                            i4 = i5;
                            if (nextElement.getSize() == -1) {
                                LogsUtil.l(a, "File name is invalid or too many files or too big");
                                i3 = i5;
                                break;
                            }
                        } else {
                            LogsUtil.l(a, "File name is invalid or too many files or too big");
                            i3 = i5;
                            break;
                        }
                    }
                    z = true;
                    i3 = i4;
                    zipFile2.close();
                    zipFile = i3;
                } catch (IOException e2) {
                    e = e2;
                    zipFile = zipFile2;
                    LogsUtil.l(a, "not a valid zip file, IOException : " + e.getMessage());
                    if (zipFile != null) {
                        zipFile.close();
                        zipFile = zipFile;
                    }
                    return z;
                } catch (Throwable th) {
                    th = th;
                    zipFile = zipFile2;
                    if (zipFile != null) {
                        try {
                            zipFile.close();
                        } catch (IOException unused2) {
                            LogsUtil.l(a, "close zipFile IOException ");
                        }
                    }
                    throw th;
                }
            } catch (IOException e3) {
                e = e3;
            }
            return z;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static boolean f(String str, String str2, long j2, int i2) throws SecurityCommonException {
        if (!TextUtils.isEmpty(str) && !o(str)) {
            if (!TextUtils.isEmpty(str2) && !o(str2)) {
                if (e(str, j2, i2)) {
                    return true;
                }
                LogsUtil.l(a, "zip file contains valid chars or too many files");
                throw new SecurityCommonException("unsecure zipfile!");
            }
            LogsUtil.l(a, "target directory is not valid");
            return false;
        }
        LogsUtil.l(a, "zip file is not valid");
        return false;
    }

    private static boolean g(List<File> list) {
        try {
            for (File file : list) {
                n(file);
            }
            return true;
        } catch (Exception e2) {
            LogsUtil.l(a, "unzip fail delete file failed" + e2.getMessage());
            return false;
        }
    }

    private static File h(String str) {
        c(str);
        return new File(str);
    }

    private static boolean i(File file) {
        if (file == null) {
            return false;
        }
        if (file.exists()) {
            return file.isFile();
        }
        if (d(file.getParentFile())) {
            try {
                return file.createNewFile();
            } catch (IOException unused) {
                Log.e(a, "createOrExistsFile IOException ");
                return false;
            }
        }
        return false;
    }

    private static File j(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return h(str);
    }

    private static void k(File file) {
        if (file == null || file.delete()) {
            return;
        }
        LogsUtil.l(a, "delete file error");
    }

    private static String l(String str) {
        int lastIndexOf;
        return (TextUtils.isEmpty(str) || (lastIndexOf = str.lastIndexOf(File.separator)) == -1) ? str : str.substring(lastIndexOf + 1);
    }

    private static void m(File file) {
        if (file == null || file.exists() || file.mkdirs()) {
            return;
        }
        LogsUtil.l(a, "mkdirs error , files exists or IOException.");
    }

    private static void n(File file) {
        if (file == null) {
            return;
        }
        if (file.isFile()) {
            k(file);
        } else if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length != 0) {
                for (File file2 : listFiles) {
                    n(file2);
                }
                k(file);
                return;
            }
            k(file);
        }
    }

    private static boolean o(String str) {
        if (!TextUtils.isEmpty(str)) {
            return str.contains(f11987e) || str.contains(f11988f) || str.contains("..") || str.contains("./") || str.contains(".\\.\\") || str.contains("%00");
        }
        Log.e(a, "isContainInvalidStr: name is null");
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x00cb, code lost:
        android.util.Log.e(e.k.c.a.a.k.k.a, "unzip  over than top size");
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00d0, code lost:
        r2 = false;
        r3 = false;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:84:0x014a  */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v13 */
    /* JADX WARN: Type inference failed for: r10v14 */
    /* JADX WARN: Type inference failed for: r10v15, types: [java.io.OutputStream, java.io.BufferedOutputStream] */
    /* JADX WARN: Type inference failed for: r10v17 */
    /* JADX WARN: Type inference failed for: r10v19 */
    /* JADX WARN: Type inference failed for: r10v2, types: [java.io.BufferedOutputStream] */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARN: Type inference failed for: r10v6 */
    /* JADX WARN: Type inference failed for: r10v7 */
    /* JADX WARN: Type inference failed for: r10v8 */
    /* JADX WARN: Type inference failed for: r10v9 */
    /* JADX WARN: Type inference failed for: r7v17 */
    /* JADX WARN: Type inference failed for: r7v2, types: [java.io.BufferedOutputStream] */
    /* JADX WARN: Type inference failed for: r7v4 */
    @java.lang.Deprecated
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean p(java.lang.String r17, java.lang.String r18, long r19, int r21, boolean r22) throws com.huawei.secure.android.common.util.SecurityCommonException {
        /*
            Method dump skipped, instructions count: 339
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: e.k.c.a.a.k.k.p(java.lang.String, java.lang.String, long, int, boolean):boolean");
    }

    @Deprecated
    public static boolean q(String str, String str2, boolean z) throws SecurityCommonException {
        return p(str, str2, 104857600L, 100, z);
    }

    public static List<File> r(String str, String str2, long j2, int i2, boolean z) throws SecurityCommonException {
        if (f(str, str2, j2, i2)) {
            String str3 = File.separator;
            if (str2.endsWith(str3) && str2.length() > str3.length()) {
                str2 = str2.substring(0, str2.length() - str3.length());
            }
            return a(j(str), j(str2), j2, z);
        }
        return null;
    }

    public static List<File> s(String str, String str2, boolean z) throws SecurityCommonException {
        return r(str, str2, 104857600L, 100, z);
    }
}
