package com.yalantis.ucrop.util;

import android.annotation.SuppressLint;
import android.content.ContentUris;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.moor.imkf.model.entity.FromToMessage;
import com.tencent.android.tpns.mqtt.MqttTopic;
import com.tencent.qcloud.tuicore.TUIConstants;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/* loaded from: classes3.dex */
public class FileUtils {
    private static final String TAG = "FileUtils";

    private FileUtils() {
    }

    public static void copyFile(@NonNull String str, @NonNull String str2) throws IOException {
        FileChannel fileChannel;
        if (str.equalsIgnoreCase(str2)) {
            return;
        }
        FileChannel fileChannel2 = null;
        try {
            FileChannel channel = new FileInputStream(new File(str)).getChannel();
            try {
                fileChannel2 = new FileOutputStream(new File(str2)).getChannel();
                channel.transferTo(0L, channel.size(), fileChannel2);
                channel.close();
                if (channel != null) {
                    channel.close();
                }
                if (fileChannel2 != null) {
                    fileChannel2.close();
                }
            } catch (Throwable th) {
                th = th;
                FileChannel fileChannel3 = fileChannel2;
                fileChannel2 = channel;
                fileChannel = fileChannel3;
                if (fileChannel2 != null) {
                    fileChannel2.close();
                }
                if (fileChannel != null) {
                    fileChannel.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            fileChannel = null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x002b, code lost:
        if (r8 != null) goto L6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x002d, code lost:
        r8.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x004e, code lost:
        if (r8 == null) goto L7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0051, code lost:
        return null;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0056  */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r7v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String getDataColumn(android.content.Context r8, android.net.Uri r9, java.lang.String r10, java.lang.String[] r11) {
        /*
            java.lang.String r0 = "_data"
            java.lang.String[] r3 = new java.lang.String[]{r0}
            r7 = 0
            android.content.ContentResolver r1 = r8.getContentResolver()     // Catch: java.lang.Throwable -> L31 java.lang.IllegalArgumentException -> L33
            r6 = 0
            r2 = r9
            r4 = r10
            r5 = r11
            android.database.Cursor r8 = r1.query(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L31 java.lang.IllegalArgumentException -> L33
            if (r8 == 0) goto L2b
            boolean r9 = r8.moveToFirst()     // Catch: java.lang.IllegalArgumentException -> L29 java.lang.Throwable -> L52
            if (r9 == 0) goto L2b
            int r9 = r8.getColumnIndexOrThrow(r0)     // Catch: java.lang.IllegalArgumentException -> L29 java.lang.Throwable -> L52
            java.lang.String r9 = r8.getString(r9)     // Catch: java.lang.IllegalArgumentException -> L29 java.lang.Throwable -> L52
            if (r8 == 0) goto L28
            r8.close()
        L28:
            return r9
        L29:
            r9 = move-exception
            goto L35
        L2b:
            if (r8 == 0) goto L51
        L2d:
            r8.close()
            goto L51
        L31:
            r9 = move-exception
            goto L54
        L33:
            r9 = move-exception
            r8 = r7
        L35:
            java.lang.String r10 = "FileUtils"
            java.util.Locale r11 = java.util.Locale.getDefault()     // Catch: java.lang.Throwable -> L52
            java.lang.String r0 = "getDataColumn: _data - [%s]"
            r1 = 1
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L52
            r2 = 0
            java.lang.String r9 = r9.getMessage()     // Catch: java.lang.Throwable -> L52
            r1[r2] = r9     // Catch: java.lang.Throwable -> L52
            java.lang.String r9 = java.lang.String.format(r11, r0, r1)     // Catch: java.lang.Throwable -> L52
            android.util.Log.i(r10, r9)     // Catch: java.lang.Throwable -> L52
            if (r8 == 0) goto L51
            goto L2d
        L51:
            return r7
        L52:
            r9 = move-exception
            r7 = r8
        L54:
            if (r7 == 0) goto L59
            r7.close()
        L59:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yalantis.ucrop.util.FileUtils.getDataColumn(android.content.Context, android.net.Uri, java.lang.String, java.lang.String[]):java.lang.String");
    }

    @SuppressLint({"NewApi"})
    public static String getPath(Context context, Uri uri) {
        Uri uri2 = null;
        if ((Build.VERSION.SDK_INT >= 19) && DocumentsContract.isDocumentUri(context, uri)) {
            if (isExternalStorageDocument(uri)) {
                String[] split = DocumentsContract.getDocumentId(uri).split(Constants.COLON_SEPARATOR);
                if ("primary".equalsIgnoreCase(split[0])) {
                    return Environment.getExternalStorageDirectory() + MqttTopic.TOPIC_LEVEL_SEPARATOR + split[1];
                }
            } else if (isDownloadsDocument(uri)) {
                String documentId = DocumentsContract.getDocumentId(uri);
                if (!TextUtils.isEmpty(documentId)) {
                    try {
                        return getDataColumn(context, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(documentId).longValue()), null, null);
                    } catch (NumberFormatException e2) {
                        Log.i(TAG, e2.getMessage());
                        return null;
                    }
                }
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
                return getDataColumn(context, uri2, "_id=?", new String[]{split2[1]});
            }
        } else if ("content".equalsIgnoreCase(uri.getScheme())) {
            if (isGooglePhotosUri(uri)) {
                return uri.getLastPathSegment();
            }
            return getDataColumn(context, uri, null, null);
        } else if ("file".equalsIgnoreCase(uri.getScheme())) {
            return uri.getPath();
        }
        return null;
    }

    public static boolean isDownloadsDocument(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    public static boolean isExternalStorageDocument(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    public static boolean isGooglePhotosUri(Uri uri) {
        return "com.google.android.apps.photos.content".equals(uri.getAuthority());
    }

    public static boolean isMediaDocument(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }
}
