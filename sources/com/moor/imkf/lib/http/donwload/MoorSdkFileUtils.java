package com.moor.imkf.lib.http.donwload;

import java.io.File;

/* loaded from: classes2.dex */
public class MoorSdkFileUtils {
    public static void deleteFile(File file) {
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length > 0) {
                for (File file2 : listFiles) {
                    deleteFile(file2);
                }
            }
            file.delete();
        } else if (file.exists()) {
            file.delete();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x00d4 A[Catch: IOException -> 0x00d8, TRY_LEAVE, TryCatch #3 {IOException -> 0x00d8, blocks: (B:46:0x00cb, B:48:0x00d4), top: B:59:0x00cb }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00db A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void saveFile(okhttp3.Response r9, java.lang.String r10, java.lang.String r11, final com.moor.imkf.lib.http.donwload.IMoorFileDownLoadListener r12) {
        /*
            r0 = 2048(0x800, float:2.87E-42)
            byte[] r0 = new byte[r0]
            r1 = 0
            okhttp3.ResponseBody r2 = r9.body()     // Catch: java.lang.Throwable -> L9c java.lang.Exception -> L9f
            java.io.InputStream r2 = r2.byteStream()     // Catch: java.lang.Throwable -> L9c java.lang.Exception -> L9f
            okhttp3.ResponseBody r3 = r9.body()     // Catch: java.lang.Throwable -> L94 java.lang.Exception -> L98
            long r3 = r3.contentLength()     // Catch: java.lang.Throwable -> L94 java.lang.Exception -> L98
            r5 = 0
            java.io.File r7 = new java.io.File     // Catch: java.lang.Throwable -> L94 java.lang.Exception -> L98
            r7.<init>(r10)     // Catch: java.lang.Throwable -> L94 java.lang.Exception -> L98
            boolean r10 = r7.exists()     // Catch: java.lang.Throwable -> L94 java.lang.Exception -> L98
            if (r10 != 0) goto L25
            r7.mkdirs()     // Catch: java.lang.Throwable -> L94 java.lang.Exception -> L98
        L25:
            java.io.File r10 = new java.io.File     // Catch: java.lang.Throwable -> L94 java.lang.Exception -> L98
            r10.<init>(r7, r11)     // Catch: java.lang.Throwable -> L94 java.lang.Exception -> L98
            boolean r8 = r10.exists()     // Catch: java.lang.Throwable -> L94 java.lang.Exception -> L98
            if (r8 == 0) goto L38
            r10.delete()     // Catch: java.lang.Throwable -> L94 java.lang.Exception -> L98
            java.io.File r10 = new java.io.File     // Catch: java.lang.Throwable -> L94 java.lang.Exception -> L98
            r10.<init>(r7, r11)     // Catch: java.lang.Throwable -> L94 java.lang.Exception -> L98
        L38:
            java.io.FileOutputStream r11 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L94 java.lang.Exception -> L98
            r11.<init>(r10)     // Catch: java.lang.Throwable -> L94 java.lang.Exception -> L98
        L3d:
            int r1 = r2.read(r0)     // Catch: java.lang.Throwable -> L90 java.lang.Exception -> L92
            r7 = -1
            if (r1 == r7) goto L69
            long r7 = (long) r1     // Catch: java.lang.Throwable -> L90 java.lang.Exception -> L92
            long r5 = r5 + r7
            r7 = 0
            r11.write(r0, r7, r1)     // Catch: java.lang.Throwable -> L90 java.lang.Exception -> L92
            r7 = 100
            long r7 = r7 * r5
            long r7 = r7 / r3
            int r1 = (int) r7     // Catch: java.lang.Throwable -> L90 java.lang.Exception -> L92
            int r7 = r1 % 2
            if (r7 != 0) goto L3d
            com.moor.imkf.lib.http.MoorBaseHttpUtils r7 = com.moor.imkf.lib.http.MoorBaseHttpUtils.getInstance()     // Catch: java.lang.Throwable -> L90 java.lang.Exception -> L92
            com.moor.imkf.lib.http.utils.MoorPlatform r7 = r7.getmPlatform()     // Catch: java.lang.Throwable -> L90 java.lang.Exception -> L92
            java.util.concurrent.Executor r7 = r7.defaultCallbackExecutor()     // Catch: java.lang.Throwable -> L90 java.lang.Exception -> L92
            com.moor.imkf.lib.http.donwload.MoorSdkFileUtils$1 r8 = new com.moor.imkf.lib.http.donwload.MoorSdkFileUtils$1     // Catch: java.lang.Throwable -> L90 java.lang.Exception -> L92
            r8.<init>()     // Catch: java.lang.Throwable -> L90 java.lang.Exception -> L92
            r7.execute(r8)     // Catch: java.lang.Throwable -> L90 java.lang.Exception -> L92
            goto L3d
        L69:
            r11.flush()     // Catch: java.lang.Throwable -> L90 java.lang.Exception -> L92
            com.moor.imkf.lib.http.MoorBaseHttpUtils r0 = com.moor.imkf.lib.http.MoorBaseHttpUtils.getInstance()     // Catch: java.lang.Throwable -> L90 java.lang.Exception -> L92
            com.moor.imkf.lib.http.utils.MoorPlatform r0 = r0.getmPlatform()     // Catch: java.lang.Throwable -> L90 java.lang.Exception -> L92
            java.util.concurrent.Executor r0 = r0.defaultCallbackExecutor()     // Catch: java.lang.Throwable -> L90 java.lang.Exception -> L92
            com.moor.imkf.lib.http.donwload.MoorSdkFileUtils$2 r1 = new com.moor.imkf.lib.http.donwload.MoorSdkFileUtils$2     // Catch: java.lang.Throwable -> L90 java.lang.Exception -> L92
            r1.<init>()     // Catch: java.lang.Throwable -> L90 java.lang.Exception -> L92
            r0.execute(r1)     // Catch: java.lang.Throwable -> L90 java.lang.Exception -> L92
            okhttp3.ResponseBody r9 = r9.body()     // Catch: java.io.IOException -> L8c
            r9.close()     // Catch: java.io.IOException -> L8c
            if (r2 == 0) goto L8c
            r2.close()     // Catch: java.io.IOException -> L8c
        L8c:
            r11.close()     // Catch: java.io.IOException -> Lc9
            goto Lc9
        L90:
            r10 = move-exception
            goto L96
        L92:
            r10 = move-exception
            goto L9a
        L94:
            r10 = move-exception
            r11 = r1
        L96:
            r1 = r2
            goto Lcb
        L98:
            r10 = move-exception
            r11 = r1
        L9a:
            r1 = r2
            goto La1
        L9c:
            r10 = move-exception
            r11 = r1
            goto Lcb
        L9f:
            r10 = move-exception
            r11 = r1
        La1:
            r10.printStackTrace()     // Catch: java.lang.Throwable -> Lca
            com.moor.imkf.lib.http.MoorBaseHttpUtils r10 = com.moor.imkf.lib.http.MoorBaseHttpUtils.getInstance()     // Catch: java.lang.Throwable -> Lca
            com.moor.imkf.lib.http.utils.MoorPlatform r10 = r10.getmPlatform()     // Catch: java.lang.Throwable -> Lca
            java.util.concurrent.Executor r10 = r10.defaultCallbackExecutor()     // Catch: java.lang.Throwable -> Lca
            com.moor.imkf.lib.http.donwload.MoorSdkFileUtils$3 r0 = new com.moor.imkf.lib.http.donwload.MoorSdkFileUtils$3     // Catch: java.lang.Throwable -> Lca
            r0.<init>()     // Catch: java.lang.Throwable -> Lca
            r10.execute(r0)     // Catch: java.lang.Throwable -> Lca
            okhttp3.ResponseBody r9 = r9.body()     // Catch: java.io.IOException -> Lc5
            r9.close()     // Catch: java.io.IOException -> Lc5
            if (r1 == 0) goto Lc6
            r1.close()     // Catch: java.io.IOException -> Lc5
            goto Lc6
        Lc5:
        Lc6:
            if (r11 == 0) goto Lc9
            goto L8c
        Lc9:
            return
        Lca:
            r10 = move-exception
        Lcb:
            okhttp3.ResponseBody r9 = r9.body()     // Catch: java.io.IOException -> Ld8
            r9.close()     // Catch: java.io.IOException -> Ld8
            if (r1 == 0) goto Ld9
            r1.close()     // Catch: java.io.IOException -> Ld8
            goto Ld9
        Ld8:
        Ld9:
            if (r11 == 0) goto Lde
            r11.close()     // Catch: java.io.IOException -> Lde
        Lde:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moor.imkf.lib.http.donwload.MoorSdkFileUtils.saveFile(okhttp3.Response, java.lang.String, java.lang.String, com.moor.imkf.lib.http.donwload.IMoorFileDownLoadListener):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x00ac A[Catch: IOException -> 0x00b0, TRY_LEAVE, TryCatch #9 {IOException -> 0x00b0, blocks: (B:46:0x00a3, B:48:0x00ac), top: B:65:0x00a3 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00b3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void saveFileSys(okhttp3.Response r9, java.lang.String r10, java.lang.String r11, final com.moor.imkf.lib.http.donwload.IMoorFileDownLoadListener r12) {
        /*
            r0 = 2048(0x800, float:2.87E-42)
            byte[] r0 = new byte[r0]
            r1 = 0
            okhttp3.ResponseBody r2 = r9.body()     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L77
            java.io.InputStream r2 = r2.byteStream()     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L77
            okhttp3.ResponseBody r3 = r9.body()     // Catch: java.lang.Throwable -> L6c java.lang.Exception -> L70
            long r3 = r3.contentLength()     // Catch: java.lang.Throwable -> L6c java.lang.Exception -> L70
            r5 = 0
            java.io.File r7 = new java.io.File     // Catch: java.lang.Throwable -> L6c java.lang.Exception -> L70
            r7.<init>(r10)     // Catch: java.lang.Throwable -> L6c java.lang.Exception -> L70
            boolean r10 = r7.exists()     // Catch: java.lang.Throwable -> L6c java.lang.Exception -> L70
            if (r10 != 0) goto L25
            r7.mkdirs()     // Catch: java.lang.Throwable -> L6c java.lang.Exception -> L70
        L25:
            java.io.File r10 = new java.io.File     // Catch: java.lang.Throwable -> L6c java.lang.Exception -> L70
            r10.<init>(r7, r11)     // Catch: java.lang.Throwable -> L6c java.lang.Exception -> L70
            boolean r8 = r10.exists()     // Catch: java.lang.Throwable -> L6c java.lang.Exception -> L70
            if (r8 == 0) goto L38
            r10.delete()     // Catch: java.lang.Throwable -> L6c java.lang.Exception -> L70
            java.io.File r10 = new java.io.File     // Catch: java.lang.Throwable -> L6c java.lang.Exception -> L70
            r10.<init>(r7, r11)     // Catch: java.lang.Throwable -> L6c java.lang.Exception -> L70
        L38:
            java.io.FileOutputStream r11 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L6c java.lang.Exception -> L70
            r11.<init>(r10)     // Catch: java.lang.Throwable -> L6c java.lang.Exception -> L70
        L3d:
            int r1 = r2.read(r0)     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6a
            r7 = -1
            if (r1 == r7) goto L50
            long r7 = (long) r1     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6a
            long r5 = r5 + r7
            r7 = 0
            r11.write(r0, r7, r1)     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6a
            r7 = 100
            long r7 = r7 * r5
            long r7 = r7 / r3
            goto L3d
        L50:
            r11.flush()     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6a
            if (r12 == 0) goto L58
            r12.onSuccess(r10)     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6a
        L58:
            okhttp3.ResponseBody r9 = r9.body()     // Catch: java.io.IOException -> L64
            r9.close()     // Catch: java.io.IOException -> L64
            if (r2 == 0) goto L64
            r2.close()     // Catch: java.io.IOException -> L64
        L64:
            r11.close()     // Catch: java.io.IOException -> La1
            goto La1
        L68:
            r10 = move-exception
            goto L6e
        L6a:
            r10 = move-exception
            goto L72
        L6c:
            r10 = move-exception
            r11 = r1
        L6e:
            r1 = r2
            goto La3
        L70:
            r10 = move-exception
            r11 = r1
        L72:
            r1 = r2
            goto L79
        L74:
            r10 = move-exception
            r11 = r1
            goto La3
        L77:
            r10 = move-exception
            r11 = r1
        L79:
            r10.printStackTrace()     // Catch: java.lang.Throwable -> La2
            com.moor.imkf.lib.http.MoorBaseHttpUtils r10 = com.moor.imkf.lib.http.MoorBaseHttpUtils.getInstance()     // Catch: java.lang.Throwable -> La2
            com.moor.imkf.lib.http.utils.MoorPlatform r10 = r10.getmPlatform()     // Catch: java.lang.Throwable -> La2
            java.util.concurrent.Executor r10 = r10.defaultCallbackExecutor()     // Catch: java.lang.Throwable -> La2
            com.moor.imkf.lib.http.donwload.MoorSdkFileUtils$4 r0 = new com.moor.imkf.lib.http.donwload.MoorSdkFileUtils$4     // Catch: java.lang.Throwable -> La2
            r0.<init>()     // Catch: java.lang.Throwable -> La2
            r10.execute(r0)     // Catch: java.lang.Throwable -> La2
            okhttp3.ResponseBody r9 = r9.body()     // Catch: java.io.IOException -> L9d
            r9.close()     // Catch: java.io.IOException -> L9d
            if (r1 == 0) goto L9e
            r1.close()     // Catch: java.io.IOException -> L9d
            goto L9e
        L9d:
        L9e:
            if (r11 == 0) goto La1
            goto L64
        La1:
            return
        La2:
            r10 = move-exception
        La3:
            okhttp3.ResponseBody r9 = r9.body()     // Catch: java.io.IOException -> Lb0
            r9.close()     // Catch: java.io.IOException -> Lb0
            if (r1 == 0) goto Lb1
            r1.close()     // Catch: java.io.IOException -> Lb0
            goto Lb1
        Lb0:
        Lb1:
            if (r11 == 0) goto Lb6
            r11.close()     // Catch: java.io.IOException -> Lb6
        Lb6:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moor.imkf.lib.http.donwload.MoorSdkFileUtils.saveFileSys(okhttp3.Response, java.lang.String, java.lang.String, com.moor.imkf.lib.http.donwload.IMoorFileDownLoadListener):void");
    }
}
