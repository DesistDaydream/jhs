package com.m7.imkfsdk.utils;

import android.annotation.SuppressLint;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import com.moor.imkf.model.entity.FromToMessage;
import com.tencent.android.tpns.mqtt.MqttTopic;
import com.tencent.qcloud.tuicore.TUIConstants;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

/* loaded from: classes2.dex */
public class PickUtils {
    public static String TEMP_DIR_PATH = Environment.getExternalStorageDirectory().getPath() + "/YourAppName";
    private static String name;
    private int cut;

    public static String getDataColumn(Context context, Uri uri, String str, String[] strArr) {
        Cursor cursor = null;
        try {
            cursor = context.getContentResolver().query(uri, new String[]{"_data"}, str, strArr, null);
            if (cursor == null || !cursor.moveToFirst()) {
                if (cursor != null) {
                    cursor.close();
                    return "";
                }
                return "";
            }
            return cursor.getString(cursor.getColumnIndexOrThrow("_data"));
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    private static String getFilePathForN(Uri uri, Context context) {
        Cursor query = context.getContentResolver().query(uri, null, null, null, null);
        if (query != null) {
            try {
                if (query.moveToFirst()) {
                    name = query.getString(query.getColumnIndex("_display_name"));
                }
            } catch (Throwable th) {
                query.close();
                throw th;
            }
        }
        query.close();
        if (name == null) {
            String path = uri.getPath();
            name = path;
            int lastIndexOf = path.lastIndexOf(47);
            if (lastIndexOf != -1) {
                name = name.substring(lastIndexOf + 1);
            }
        }
        File file = new File(context.getFilesDir(), name);
        try {
            InputStream openInputStream = context.getContentResolver().openInputStream(uri);
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            byte[] bArr = new byte[Math.min(openInputStream.available(), 1048576)];
            while (true) {
                int read = openInputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                fileOutputStream.write(bArr, 0, read);
            }
            Log.e("File Size", "Size " + file.length());
            openInputStream.close();
            fileOutputStream.close();
            Log.e("File Path", "Path " + file.getPath());
            Log.e("File Size", "Size " + file.length());
        } catch (Exception e2) {
            Log.e("Exception", e2.getMessage());
        }
        return file.getPath();
    }

    @SuppressLint({"NewApi"})
    public static String getPath(Context context, Uri uri) {
        int i2 = Build.VERSION.SDK_INT;
        boolean z = i2 >= 19;
        if (i2 >= 29) {
            return FileUtils.getFilePathFromURI(context, uri);
        }
        Uri uri2 = null;
        if (z && DocumentsContract.isDocumentUri(context, uri)) {
            if (isExternalStorageDocument(uri)) {
                String[] split = DocumentsContract.getDocumentId(uri).split(Constants.COLON_SEPARATOR);
                if ("primary".equalsIgnoreCase(split[0])) {
                    return Environment.getExternalStorageDirectory() + MqttTopic.TOPIC_LEVEL_SEPARATOR + split[1];
                }
            } else if (isDownloadsDocument(uri)) {
                String documentId = DocumentsContract.getDocumentId(uri);
                if (!TextUtils.isEmpty(documentId)) {
                    if (documentId.startsWith("raw:")) {
                        return documentId.replaceFirst("raw:", "");
                    }
                    try {
                        return getDataColumn(context, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(documentId).longValue()), null, null);
                    } catch (Exception unused) {
                        ToastUtils.showShort(context, "暂不支持此类文件");
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
            if (i2 >= 24) {
                return getFilePathForN(uri, context);
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

    public static boolean isMediaDocument(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }
}
