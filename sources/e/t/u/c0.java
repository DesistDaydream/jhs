package e.t.u;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes3.dex */
public class c0 {
    private static void a(Context context, Uri uri, File file) {
        try {
            InputStream openInputStream = context.getContentResolver().openInputStream(uri);
            if (openInputStream == null) {
                return;
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            b(openInputStream, fileOutputStream);
            openInputStream.close();
            fileOutputStream.close();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private static int b(InputStream inputStream, OutputStream outputStream) throws Exception {
        byte[] bArr = new byte[2048];
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, 2048);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream, 2048);
        int i2 = 0;
        while (true) {
            try {
                int read = bufferedInputStream.read(bArr, 0, 2048);
                if (read == -1) {
                    break;
                }
                bufferedOutputStream.write(bArr, 0, read);
                i2 += read;
            } finally {
                try {
                    bufferedOutputStream.close();
                } catch (IOException unused) {
                }
                try {
                    bufferedInputStream.close();
                } catch (IOException unused2) {
                }
            }
        }
        bufferedOutputStream.flush();
        try {
            bufferedInputStream.close();
        } catch (IOException unused3) {
        }
        return i2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0046, code lost:
        if (r7.name.equalsIgnoreCase(r2) == false) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0048, code lost:
        r3 = androidx.core.content.FileProvider.class.getDeclaredMethod("getPathStrategy", android.content.Context.class, java.lang.String.class);
        r3.setAccessible(true);
        r3 = r3.invoke(null, r10, r11.getAuthority());
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x006d, code lost:
        if (r3 == null) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x006f, code lost:
        r4 = java.lang.Class.forName(androidx.core.content.FileProvider.class.getName() + "$PathStrategy").getDeclaredMethod("getFileForUri", android.net.Uri.class);
        r4.setAccessible(true);
        r3 = r4.invoke(r3, r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x00a3, code lost:
        if ((r3 instanceof java.io.File) == false) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00ab, code lost:
        return ((java.io.File) r3).getAbsolutePath();
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0017, code lost:
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0017, code lost:
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0017, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String c(android.content.Context r10, android.net.Uri r11) {
        /*
            r0 = 0
            android.content.pm.PackageManager r1 = r10.getPackageManager()     // Catch: java.lang.Exception -> Lb0
            r2 = 8
            java.util.List r1 = r1.getInstalledPackages(r2)     // Catch: java.lang.Exception -> Lb0
            if (r1 == 0) goto Lb4
            java.lang.Class<androidx.core.content.FileProvider> r2 = androidx.core.content.FileProvider.class
            java.lang.String r2 = r2.getName()     // Catch: java.lang.Exception -> Lb0
            java.util.Iterator r1 = r1.iterator()     // Catch: java.lang.Exception -> Lb0
        L17:
            boolean r3 = r1.hasNext()     // Catch: java.lang.Exception -> Lb0
            if (r3 == 0) goto Lb4
            java.lang.Object r3 = r1.next()     // Catch: java.lang.Exception -> Lb0
            android.content.pm.PackageInfo r3 = (android.content.pm.PackageInfo) r3     // Catch: java.lang.Exception -> Lb0
            android.content.pm.ProviderInfo[] r3 = r3.providers     // Catch: java.lang.Exception -> Lb0
            if (r3 == 0) goto L17
            int r4 = r3.length     // Catch: java.lang.Exception -> Lb0
            r5 = 0
            r6 = 0
        L2a:
            if (r6 >= r4) goto L17
            r7 = r3[r6]     // Catch: java.lang.Exception -> Lb0
            java.lang.String r8 = r11.getAuthority()     // Catch: java.lang.Exception -> Lb0
            if (r8 == 0) goto Lac
            java.lang.String r8 = r11.getAuthority()     // Catch: java.lang.Exception -> Lb0
            java.lang.String r9 = r7.authority     // Catch: java.lang.Exception -> Lb0
            boolean r8 = r8.equals(r9)     // Catch: java.lang.Exception -> Lb0
            if (r8 == 0) goto Lac
            java.lang.String r3 = r7.name     // Catch: java.lang.Exception -> Lb0
            boolean r3 = r3.equalsIgnoreCase(r2)     // Catch: java.lang.Exception -> Lb0
            if (r3 == 0) goto L17
            java.lang.Class<androidx.core.content.FileProvider> r3 = androidx.core.content.FileProvider.class
            java.lang.String r4 = "getPathStrategy"
            r6 = 2
            java.lang.Class[] r7 = new java.lang.Class[r6]     // Catch: java.lang.Exception -> Lb0
            java.lang.Class<android.content.Context> r8 = android.content.Context.class
            r7[r5] = r8     // Catch: java.lang.Exception -> Lb0
            java.lang.Class<java.lang.String> r8 = java.lang.String.class
            r9 = 1
            r7[r9] = r8     // Catch: java.lang.Exception -> Lb0
            java.lang.reflect.Method r3 = r3.getDeclaredMethod(r4, r7)     // Catch: java.lang.Exception -> Lb0
            r3.setAccessible(r9)     // Catch: java.lang.Exception -> Lb0
            java.lang.Object[] r4 = new java.lang.Object[r6]     // Catch: java.lang.Exception -> Lb0
            r4[r5] = r10     // Catch: java.lang.Exception -> Lb0
            java.lang.String r6 = r11.getAuthority()     // Catch: java.lang.Exception -> Lb0
            r4[r9] = r6     // Catch: java.lang.Exception -> Lb0
            java.lang.Object r3 = r3.invoke(r0, r4)     // Catch: java.lang.Exception -> Lb0
            if (r3 == 0) goto L17
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Lb0
            r4.<init>()     // Catch: java.lang.Exception -> Lb0
            java.lang.Class<androidx.core.content.FileProvider> r6 = androidx.core.content.FileProvider.class
            java.lang.String r6 = r6.getName()     // Catch: java.lang.Exception -> Lb0
            r4.append(r6)     // Catch: java.lang.Exception -> Lb0
            java.lang.String r6 = "$PathStrategy"
            r4.append(r6)     // Catch: java.lang.Exception -> Lb0
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Exception -> Lb0
            java.lang.Class r4 = java.lang.Class.forName(r4)     // Catch: java.lang.Exception -> Lb0
            java.lang.String r6 = "getFileForUri"
            java.lang.Class[] r7 = new java.lang.Class[r9]     // Catch: java.lang.Exception -> Lb0
            java.lang.Class<android.net.Uri> r8 = android.net.Uri.class
            r7[r5] = r8     // Catch: java.lang.Exception -> Lb0
            java.lang.reflect.Method r4 = r4.getDeclaredMethod(r6, r7)     // Catch: java.lang.Exception -> Lb0
            r4.setAccessible(r9)     // Catch: java.lang.Exception -> Lb0
            java.lang.Object[] r6 = new java.lang.Object[r9]     // Catch: java.lang.Exception -> Lb0
            r6[r5] = r11     // Catch: java.lang.Exception -> Lb0
            java.lang.Object r3 = r4.invoke(r3, r6)     // Catch: java.lang.Exception -> Lb0
            boolean r4 = r3 instanceof java.io.File     // Catch: java.lang.Exception -> Lb0
            if (r4 == 0) goto L17
            java.io.File r3 = (java.io.File) r3     // Catch: java.lang.Exception -> Lb0
            java.lang.String r10 = r3.getAbsolutePath()     // Catch: java.lang.Exception -> Lb0
            return r10
        Lac:
            int r6 = r6 + 1
            goto L2a
        Lb0:
            r10 = move-exception
            r10.printStackTrace()
        Lb4:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: e.t.u.c0.c(android.content.Context, android.net.Uri):java.lang.String");
    }

    public static String d(Context context, Uri uri) {
        int lastIndexOf;
        String str = null;
        if ("content".equals(uri.getScheme())) {
            try {
                Cursor query = context.getApplicationContext().getContentResolver().query(uri, new String[]{"_display_name"}, null, null, null);
                if (query != null && query.moveToFirst()) {
                    str = query.getString(query.getColumnIndex("_display_name"));
                }
                if (query != null) {
                    query.close();
                }
            } catch (Exception unused) {
            }
        }
        if (str == null) {
            String path = uri.getPath();
            return (path == null || (lastIndexOf = path.lastIndexOf(47)) == -1) ? path : path.substring(lastIndexOf + 1);
        }
        return str;
    }

    public static String e(Context context, String str, Uri uri) {
        File file;
        if (str == null) {
            file = context.getCacheDir();
        } else {
            file = new File(str);
        }
        String d2 = d(context, uri);
        if (TextUtils.isEmpty(d2)) {
            return null;
        }
        File file2 = new File(file + File.separator + d2);
        a(context, uri, file2);
        return file2.getAbsolutePath();
    }
}
