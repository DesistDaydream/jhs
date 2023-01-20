package com.tencent.qcloud.tuicore.util;

import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.MimeTypeMap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.FileProvider;
import com.caverock.androidsvg.SVG;
import com.moor.imkf.model.entity.FromToMessage;
import com.tencent.android.tpns.mqtt.MqttTopic;
import com.tencent.qcloud.tuicore.R;
import com.tencent.qcloud.tuicore.TUIConfig;
import com.tencent.qcloud.tuicore.TUIConstants;
import com.tencent.qcloud.tuicore.TUILogin;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* loaded from: classes3.dex */
public class FileUtil {
    public static final String DOCUMENTS_DIR = "documents";
    public static final int SIZETYPE_B = 1;
    public static final int SIZETYPE_GB = 4;
    public static final int SIZETYPE_KB = 2;
    public static final int SIZETYPE_MB = 3;

    public static boolean deleteFile(String str) {
        File file = new File(str);
        if (file.exists()) {
            return file.delete();
        }
        return false;
    }

    public static String formatFileSize(long j2) {
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        if (j2 == 0) {
            return "0B";
        }
        if (j2 < 1024) {
            return decimalFormat.format(j2) + "B";
        } else if (j2 < SVG.H) {
            return decimalFormat.format(j2 / 1024.0d) + "KB";
        } else if (j2 < SVG.R) {
            return decimalFormat.format(j2 / 1048576.0d) + "MB";
        } else {
            return decimalFormat.format(j2 / 1.073741824E9d) + "GB";
        }
    }

    @Nullable
    public static File generateFileName(@Nullable String str, File file) {
        String str2;
        if (str == null) {
            return null;
        }
        File file2 = new File(file, str);
        if (file2.exists()) {
            int lastIndexOf = str.lastIndexOf(46);
            int i2 = 0;
            if (lastIndexOf > 0) {
                String substring = str.substring(0, lastIndexOf);
                str2 = str.substring(lastIndexOf);
                str = substring;
            } else {
                str2 = "";
            }
            while (file2.exists()) {
                i2++;
                file2 = new File(file, str + '(' + i2 + ')' + str2);
            }
        }
        try {
            if (file2.createNewFile()) {
                return file2;
            }
            return null;
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x002b, code lost:
        if (r8 != null) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0035, code lost:
        if (r8 == null) goto L6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0037, code lost:
        r8.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x003a, code lost:
        return null;
     */
    /* JADX WARN: Removed duplicated region for block: B:26:0x003f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String getDataColumn(android.content.Context r8, android.net.Uri r9, java.lang.String r10, java.lang.String[] r11) {
        /*
            java.lang.String r0 = "_data"
            java.lang.String[] r3 = new java.lang.String[]{r0}
            r7 = 0
            android.content.ContentResolver r1 = r8.getContentResolver()     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L30
            r6 = 0
            r2 = r9
            r4 = r10
            r5 = r11
            android.database.Cursor r8 = r1.query(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L30
            if (r8 == 0) goto L2b
            boolean r9 = r8.moveToFirst()     // Catch: java.lang.Exception -> L29 java.lang.Throwable -> L3b
            if (r9 == 0) goto L2b
            int r9 = r8.getColumnIndexOrThrow(r0)     // Catch: java.lang.Exception -> L29 java.lang.Throwable -> L3b
            java.lang.String r9 = r8.getString(r9)     // Catch: java.lang.Exception -> L29 java.lang.Throwable -> L3b
            if (r8 == 0) goto L28
            r8.close()
        L28:
            return r9
        L29:
            r9 = move-exception
            goto L32
        L2b:
            if (r8 == 0) goto L3a
            goto L37
        L2e:
            r9 = move-exception
            goto L3d
        L30:
            r9 = move-exception
            r8 = r7
        L32:
            r9.printStackTrace()     // Catch: java.lang.Throwable -> L3b
            if (r8 == 0) goto L3a
        L37:
            r8.close()
        L3a:
            return r7
        L3b:
            r9 = move-exception
            r7 = r8
        L3d:
            if (r7 == 0) goto L42
            r7.close()
        L42:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.qcloud.tuicore.util.FileUtil.getDataColumn(android.content.Context, android.net.Uri, java.lang.String, java.lang.String[]):java.lang.String");
    }

    public static File getDocumentCacheDir(@NonNull Context context) {
        File file = new File(context.getCacheDir(), DOCUMENTS_DIR);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static String getFileExtensionFromUrl(String str) {
        int lastIndexOf;
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int lastIndexOf2 = str.lastIndexOf(35);
        if (lastIndexOf2 > 0) {
            str = str.substring(0, lastIndexOf2);
        }
        int lastIndexOf3 = str.lastIndexOf(63);
        if (lastIndexOf3 > 0) {
            str = str.substring(0, lastIndexOf3);
        }
        int lastIndexOf4 = str.lastIndexOf(47);
        if (lastIndexOf4 >= 0) {
            str = str.substring(lastIndexOf4 + 1);
        }
        return (str.isEmpty() || (lastIndexOf = str.lastIndexOf(46)) < 0) ? "" : str.substring(lastIndexOf + 1).toLowerCase();
    }

    public static String getFileName(@NonNull Context context, Uri uri) {
        if (context.getContentResolver().getType(uri) == null && context != null) {
            return getName(uri.toString());
        }
        Cursor query = context.getContentResolver().query(uri, null, null, null, null);
        if (query != null) {
            int columnIndex = query.getColumnIndex("_display_name");
            query.moveToFirst();
            String string = query.getString(columnIndex);
            query.close();
            return string;
        }
        return null;
    }

    private static String getName(String str) {
        if (str == null) {
            return null;
        }
        return str.substring(str.lastIndexOf(47) + 1);
    }

    public static String getPath(Context context, Uri uri) {
        int i2 = Build.VERSION.SDK_INT;
        Uri uri2 = null;
        if ((i2 >= 19) && DocumentsContract.isDocumentUri(context, uri)) {
            if (isExternalStorageDocument(uri)) {
                String[] split = DocumentsContract.getDocumentId(uri).split(Constants.COLON_SEPARATOR);
                if ("primary".equalsIgnoreCase(split[0])) {
                    return Environment.getExternalStorageDirectory() + MqttTopic.TOPIC_LEVEL_SEPARATOR + split[1];
                }
                return getPathByCopyFile(context, uri);
            } else if (isDownloadsDocument(uri)) {
                String documentId = DocumentsContract.getDocumentId(uri);
                if (documentId.startsWith("raw:")) {
                    return documentId.replaceFirst("raw:", "");
                }
                String[] strArr = {"content://downloads/public_downloads", "content://downloads/my_downloads", "content://downloads/all_downloads"};
                for (int i3 = 0; i3 < 3; i3++) {
                    try {
                        String dataColumn = getDataColumn(context, ContentUris.withAppendedId(Uri.parse(strArr[i3]), Long.parseLong(documentId)), null, null);
                        if (dataColumn != null && i2 < 29) {
                            return dataColumn;
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
                return getPathByCopyFile(context, uri);
            } else if (isMediaDocument(uri)) {
                String[] split2 = DocumentsContract.getDocumentId(uri).split(Constants.COLON_SEPARATOR);
                String str = split2[0];
                if (FromToMessage.MSG_TYPE_IMAGE.equals(str)) {
                    uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                } else if ("video".equals(str)) {
                    uri2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                } else if (TUIConstants.TUICalling.TYPE_AUDIO.equals(str)) {
                    uri2 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                }
                String dataColumn2 = getDataColumn(context, uri2, "_id=?", new String[]{split2[1]});
                return (TextUtils.isEmpty(dataColumn2) || i2 >= 29) ? getPathByCopyFile(context, uri) : dataColumn2;
            }
        } else if ("content".equalsIgnoreCase(uri.getScheme())) {
            String dataColumn3 = getDataColumn(context, uri, null, null);
            return (TextUtils.isEmpty(dataColumn3) || i2 >= 29) ? getPathByCopyFile(context, uri) : dataColumn3;
        } else if ("file".equalsIgnoreCase(uri.getScheme())) {
            return uri.getPath();
        }
        return null;
    }

    private static String getPathByCopyFile(Context context, Uri uri) {
        File generateFileName = generateFileName(getFileName(context, uri), getDocumentCacheDir(context));
        if (generateFileName != null) {
            String absolutePath = generateFileName.getAbsolutePath();
            saveFileFromUri(context, uri, absolutePath);
            return absolutePath;
        }
        return null;
    }

    public static String getPathFromUri(Uri uri) {
        String str;
        try {
            if (Build.VERSION.SDK_INT >= 19) {
                str = getPathByCopyFile(TUILogin.getAppContext(), uri);
            } else {
                str = getRealFilePath(uri);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            str = "";
        }
        return str == null ? "" : str;
    }

    public static String getRealFilePath(Uri uri) {
        Cursor query;
        int columnIndex;
        String str = null;
        if (uri == null) {
            return null;
        }
        String scheme = uri.getScheme();
        if (scheme == null) {
            return uri.getPath();
        }
        if ("file".equals(scheme)) {
            return uri.getPath();
        }
        if (!"content".equals(scheme) || (query = TUILogin.getAppContext().getContentResolver().query(uri, new String[]{"_data"}, null, null, null)) == null) {
            return null;
        }
        if (query.moveToFirst() && (columnIndex = query.getColumnIndex("_data")) > -1) {
            str = query.getString(columnIndex);
        }
        query.close();
        return str;
    }

    public static Uri getUriFromPath(String str) {
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                Context appContext = TUIConfig.getAppContext();
                return FileProvider.getUriForFile(appContext, TUIConfig.getAppContext().getApplicationInfo().packageName + ".tuicore.fileprovider", new File(str));
            }
            return Uri.fromFile(new File(str));
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static boolean isDownloadsDocument(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    public static boolean isExternalStorageDocument(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    public static boolean isMediaDocument(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }

    public static void openFile(String str, String str2) {
        String fileExtensionFromUrl;
        Context appContext = TUIConfig.getAppContext();
        Uri uriForFile = FileProvider.getUriForFile(appContext, TUIConfig.getAppContext().getApplicationInfo().packageName + ".tuicore.fileprovider", new File(str));
        if (uriForFile == null) {
            Log.e("FileUtil", "openFile failed , uri is null");
            return;
        }
        if (TextUtils.isEmpty(str2)) {
            fileExtensionFromUrl = getFileExtensionFromUrl(str);
        } else {
            fileExtensionFromUrl = getFileExtensionFromUrl(str2);
        }
        String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileExtensionFromUrl);
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(1);
        intent.setDataAndType(uriForFile, mimeTypeFromExtension);
        try {
            Intent createChooser = Intent.createChooser(intent, TUIConfig.getAppContext().getString(R.string.open_file_tips));
            createChooser.addFlags(268435456);
            TUIConfig.getAppContext().startActivity(createChooser);
        } catch (Exception e2) {
            Log.e("FileUtil", "openFile failed , " + e2.getMessage());
        }
    }

    public static String saveBitmap(String str, Bitmap bitmap) {
        String str2 = TUIConfig.getMediaDir() + "picture_" + new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(new Date()) + ".jpg";
        try {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(str2));
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bufferedOutputStream);
            bufferedOutputStream.flush();
            bufferedOutputStream.close();
            return str2;
        } catch (IOException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x005d A[Catch: IOException -> 0x0059, TRY_LEAVE, TryCatch #0 {IOException -> 0x0059, blocks: (B:41:0x0055, B:45:0x005d), top: B:49:0x0055 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0055 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void saveFileFromUri(android.content.Context r3, android.net.Uri r4, java.lang.String r5) {
        /*
            r0 = 0
            android.content.ContentResolver r3 = r3.getContentResolver()     // Catch: java.lang.Throwable -> L38 java.io.IOException -> L3b
            java.io.InputStream r3 = r3.openInputStream(r4)     // Catch: java.lang.Throwable -> L38 java.io.IOException -> L3b
            java.io.BufferedOutputStream r4 = new java.io.BufferedOutputStream     // Catch: java.lang.Throwable -> L30 java.io.IOException -> L34
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L30 java.io.IOException -> L34
            r2 = 0
            r1.<init>(r5, r2)     // Catch: java.lang.Throwable -> L30 java.io.IOException -> L34
            r4.<init>(r1)     // Catch: java.lang.Throwable -> L30 java.io.IOException -> L34
            r5 = 1024(0x400, float:1.435E-42)
            byte[] r5 = new byte[r5]     // Catch: java.lang.Throwable -> L2c java.io.IOException -> L2e
        L18:
            int r0 = r3.read(r5)     // Catch: java.lang.Throwable -> L2c java.io.IOException -> L2e
            r1 = -1
            if (r0 == r1) goto L23
            r4.write(r5, r2, r0)     // Catch: java.lang.Throwable -> L2c java.io.IOException -> L2e
            goto L18
        L23:
            if (r3 == 0) goto L28
            r3.close()     // Catch: java.io.IOException -> L46
        L28:
            r4.close()     // Catch: java.io.IOException -> L46
            goto L51
        L2c:
            r5 = move-exception
            goto L32
        L2e:
            r5 = move-exception
            goto L36
        L30:
            r5 = move-exception
            r4 = r0
        L32:
            r0 = r3
            goto L53
        L34:
            r5 = move-exception
            r4 = r0
        L36:
            r0 = r3
            goto L3d
        L38:
            r5 = move-exception
            r4 = r0
            goto L53
        L3b:
            r5 = move-exception
            r4 = r0
        L3d:
            r5.printStackTrace()     // Catch: java.lang.Throwable -> L52
            if (r0 == 0) goto L48
            r0.close()     // Catch: java.io.IOException -> L46
            goto L48
        L46:
            r3 = move-exception
            goto L4e
        L48:
            if (r4 == 0) goto L51
            r4.close()     // Catch: java.io.IOException -> L46
            goto L51
        L4e:
            r3.printStackTrace()
        L51:
            return
        L52:
            r5 = move-exception
        L53:
            if (r0 == 0) goto L5b
            r0.close()     // Catch: java.io.IOException -> L59
            goto L5b
        L59:
            r3 = move-exception
            goto L61
        L5b:
            if (r4 == 0) goto L64
            r4.close()     // Catch: java.io.IOException -> L59
            goto L64
        L61:
            r3.printStackTrace()
        L64:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.qcloud.tuicore.util.FileUtil.saveFileFromUri(android.content.Context, android.net.Uri, java.lang.String):void");
    }
}
