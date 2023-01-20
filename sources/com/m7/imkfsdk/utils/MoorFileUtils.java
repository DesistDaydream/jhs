package com.m7.imkfsdk.utils;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.moor.imkf.lib.utils.MoorLogUtils;
import com.moor.imkf.lib.utils.MoorSdkVersionUtil;
import com.moor.imkf.model.entity.FromToMessage;
import com.moor.imkf.utils.MoorUtils;
import com.tencent.android.tpns.mqtt.MqttTopic;
import com.tencent.qcloud.tuicore.TUIConstants;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.FileChannel;
import java.text.DecimalFormat;

/* loaded from: classes2.dex */
public class MoorFileUtils {
    private static String name;

    private MoorFileUtils() {
    }

    private static int calculateInSampleSize(BitmapFactory.Options options, int i2, int i3) {
        int i4 = options.outHeight;
        int i5 = options.outWidth;
        int i6 = 1;
        if (i4 > i2 || i5 > i3) {
            int i7 = i4 / 2;
            int i8 = i5 / 2;
            while (i7 / i6 >= i2 && i8 / i6 >= i3) {
                i6 *= 2;
            }
        }
        return i6;
    }

    private static void copyFile(Uri uri, File file) {
        try {
            InputStream openInputStream = MoorUtils.getApp().getContentResolver().openInputStream(uri);
            if (openInputStream == null) {
                return;
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            copyStream(openInputStream, fileOutputStream);
            openInputStream.close();
            fileOutputStream.close();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private static int copyStream(InputStream inputStream, OutputStream outputStream) throws Exception {
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

    public static boolean createFileByDeleteOldFile(String str) {
        return createFileByDeleteOldFile(getFileByPath(str));
    }

    public static boolean createOrExistsDir(File file) {
        return file != null && (!file.exists() ? !file.mkdirs() : !file.isDirectory());
    }

    public static Bitmap decodeSampledBitmapFromFile(String str, int i2, int i3) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        options.inSampleSize = calculateInSampleSize(options, i3, i2);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFile(str, options);
    }

    private static String getDataColumn(Context context, Uri uri, String str, String[] strArr) {
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

    public static File getDownloadFile(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str2)) {
            str = str + str2 + File.separator;
        }
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return new File(file, str3);
    }

    public static File getFileByPath(String str) {
        if (isSpace(str)) {
            return null;
        }
        return new File(str);
    }

    public static long getFileCount(File file) {
        File[] listFiles = file.listFiles();
        long length = listFiles.length;
        for (File file2 : listFiles) {
            if (file2.isDirectory()) {
                length = (length + getFileCount(file2)) - 1;
            }
        }
        return length;
    }

    public static String getFileName(String str) {
        int lastIndexOf = str.lastIndexOf(MqttTopic.TOPIC_LEVEL_SEPARATOR);
        int length = str.length();
        if (lastIndexOf != -1) {
            return str.substring(lastIndexOf + 1, length);
        }
        return null;
    }

    private static String getFileNameByUri(Uri uri) {
        Cursor query = MoorUtils.getApp().getContentResolver().query(uri, null, null, null, null);
        if (query == null || query.getCount() <= 0) {
            return "";
        }
        query.moveToFirst();
        String string = query.getString(query.getColumnIndexOrThrow("_display_name"));
        query.close();
        return string;
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
            openInputStream.close();
            fileOutputStream.close();
        } catch (Exception e2) {
            MoorLogUtils.e("Exception", e2.getMessage());
        }
        return file.getPath();
    }

    private static String getFilePathFromUri_Q(Uri uri) {
        File externalFilesDir = MoorUtils.getApp().getExternalFilesDir(null);
        String fileNameByUri = getFileNameByUri(uri);
        if (TextUtils.isEmpty(fileNameByUri)) {
            return null;
        }
        File file = new File(externalFilesDir + File.separator + fileNameByUri);
        copyFile(uri, file);
        return file.getAbsolutePath();
    }

    public static String getFormatName(String str) {
        if (str == null) {
            return null;
        }
        String trim = str.trim();
        int lastIndexOf = trim.lastIndexOf(".");
        return lastIndexOf >= 0 ? trim.substring(lastIndexOf) : "";
    }

    public static String getRealPathFromUri(Context context, Uri uri) {
        if (uri == null) {
            return "";
        }
        if (MoorSdkVersionUtil.over29()) {
            return getFilePathFromUri_Q(uri);
        }
        Uri uri2 = null;
        if (MoorSdkVersionUtil.over19() && DocumentsContract.isDocumentUri(context, uri)) {
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
            if (MoorSdkVersionUtil.over24()) {
                return getFilePathForN(uri, context);
            }
            return getDataColumn(context, uri, null, null);
        } else if ("file".equalsIgnoreCase(uri.getScheme())) {
            return uri.getPath();
        }
        return null;
    }

    private static boolean isDownloadsDocument(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    public static boolean isDownloadsFileExists(Context context, String str, String str2) {
        if (MoorSdkVersionUtil.over29()) {
            Cursor query = context.getContentResolver().query(MediaStore.Downloads.EXTERNAL_CONTENT_URI, null, "bucket_display_name=?", new String[]{str}, null);
            if (query != null) {
                while (query.moveToNext()) {
                    if (str2.equals(query.getString(query.getColumnIndexOrThrow("_display_name")))) {
                        query.close();
                    }
                }
                return false;
            }
            return false;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(Environment.getExternalStorageDirectory().getPath());
        String str3 = File.separator;
        sb.append(str3);
        sb.append(Environment.DIRECTORY_DOWNLOADS);
        sb.append(str3);
        sb.append(str);
        sb.append(str3);
        sb.append(str2);
        if (!new File(sb.toString()).exists()) {
            return false;
        }
        return true;
    }

    private static boolean isExternalStorageDocument(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    public static boolean isFileExists(String str) {
        return isFileExists(getFileByPath(str));
    }

    private static boolean isMediaDocument(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }

    private static boolean isSpace(String str) {
        if (str == null) {
            return true;
        }
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            if (!Character.isWhitespace(str.charAt(i2))) {
                return false;
            }
        }
        return true;
    }

    public static String readFileSize(String str) {
        return readableFileSize(new File(str).length());
    }

    private static String readableFileSize(long j2) {
        double d2;
        if (j2 <= 0) {
            return "0";
        }
        int log10 = (int) (Math.log10(j2) / Math.log10(1024.0d));
        return new DecimalFormat("#,##0.#").format(d2 / Math.pow(1024.0d, log10)) + ExpandableTextView.N + new String[]{"B", "KB", "MB", "GB", "TB"}[log10];
    }

    public static boolean saveFile(Context context, File file, String str) {
        BufferedInputStream bufferedInputStream;
        if (MoorSdkVersionUtil.over29()) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("_display_name", str);
            contentValues.put("mime_type", getFormatName(str));
            contentValues.put("datetaken", Long.valueOf(System.currentTimeMillis()));
            contentValues.put("relative_path", MoorPathUtil.getFileDownLoadPath());
            ContentResolver contentResolver = context.getContentResolver();
            Uri insert = contentResolver.insert(MediaStore.Downloads.EXTERNAL_CONTENT_URI, contentValues);
            boolean z = false;
            OutputStream outputStream = null;
            try {
                try {
                    bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                    if (insert != null) {
                        try {
                            outputStream = contentResolver.openOutputStream(insert);
                        } catch (Exception unused) {
                            outputStream.close();
                            bufferedInputStream.close();
                            return z;
                        } catch (Throwable th) {
                            th = th;
                            try {
                                outputStream.close();
                                bufferedInputStream.close();
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                            throw th;
                        }
                    }
                    if (outputStream != null) {
                        byte[] bArr = new byte[4096];
                        while (true) {
                            int read = bufferedInputStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            outputStream.write(bArr, 0, read);
                        }
                        outputStream.flush();
                    }
                    z = true;
                    outputStream.close();
                    bufferedInputStream.close();
                } catch (Exception unused2) {
                    bufferedInputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    bufferedInputStream = null;
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            return z;
        }
        return saveFileToGallery(file, str);
    }

    private static boolean saveFileToGallery(File file, String str) {
        FileOutputStream fileOutputStream;
        File file2 = new File(MoorPathUtil.getFileDownLoadPath());
        if (!file2.exists()) {
            file2.mkdir();
        }
        File file3 = new File(file2, str);
        FileOutputStream fileOutputStream2 = null;
        try {
            fileOutputStream = new FileOutputStream(file3);
        } catch (Exception e2) {
            e = e2;
        }
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            byte[] bArr = new byte[4096];
            while (true) {
                int read = bufferedInputStream.read(bArr);
                if (read != -1) {
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    fileOutputStream.flush();
                    file.exists();
                    return true;
                }
            }
        } catch (Exception e3) {
            e = e3;
            fileOutputStream2 = fileOutputStream;
            e.printStackTrace();
            try {
                fileOutputStream2.flush();
                fileOutputStream2.close();
            } catch (Exception e4) {
                e4.printStackTrace();
            }
            return false;
        }
    }

    public static boolean saveImage(Context context, File file) {
        BufferedInputStream bufferedInputStream;
        if (MoorSdkVersionUtil.over29()) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("_display_name", "moor" + System.currentTimeMillis() + ".jpg");
            contentValues.put("mime_type", "image/jpg");
            contentValues.put("relative_path", MoorPathUtil.getImageDownLoadPath());
            Uri uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
            ContentResolver contentResolver = context.getContentResolver();
            Uri insert = contentResolver.insert(uri, contentValues);
            boolean z = false;
            OutputStream outputStream = null;
            try {
                try {
                    bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                    if (insert != null) {
                        try {
                            outputStream = contentResolver.openOutputStream(insert);
                        } catch (Exception unused) {
                            outputStream.close();
                            bufferedInputStream.close();
                            return z;
                        } catch (Throwable th) {
                            th = th;
                            try {
                                outputStream.close();
                                bufferedInputStream.close();
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                            throw th;
                        }
                    }
                    if (outputStream != null) {
                        byte[] bArr = new byte[4096];
                        while (true) {
                            int read = bufferedInputStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            outputStream.write(bArr, 0, read);
                        }
                        outputStream.flush();
                    }
                    file.exists();
                    z = true;
                    outputStream.close();
                    bufferedInputStream.close();
                } catch (Exception unused2) {
                    bufferedInputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    bufferedInputStream = null;
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            return z;
        }
        return saveImageToGallery(context, file);
    }

    private static boolean saveImageToGallery(Context context, File file) {
        File file2 = new File(MoorPathUtil.getImageDownLoadPath());
        if (!file2.exists()) {
            file2.mkdir();
        }
        File file3 = new File(file2, "moor" + System.currentTimeMillis() + ".jpg");
        FileOutputStream fileOutputStream = null;
        try {
            FileOutputStream fileOutputStream2 = new FileOutputStream(file3);
            try {
                BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                byte[] bArr = new byte[4096];
                while (true) {
                    int read = bufferedInputStream.read(bArr);
                    if (read != -1) {
                        fileOutputStream2.write(bArr, 0, read);
                    } else {
                        fileOutputStream2.flush();
                        file.exists();
                        context.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(file3)));
                        return true;
                    }
                }
            } catch (Exception e2) {
                e = e2;
                fileOutputStream = fileOutputStream2;
                e.printStackTrace();
                try {
                    fileOutputStream.flush();
                    fileOutputStream.close();
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
                return false;
            }
        } catch (Exception e4) {
            e = e4;
        }
    }

    public static boolean createFileByDeleteOldFile(File file) {
        if (file == null) {
            return false;
        }
        if ((!file.exists() || file.delete()) && createOrExistsDir(file.getParentFile())) {
            try {
                return file.createNewFile();
            } catch (IOException e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return false;
    }

    public static boolean isFileExists(File file) {
        return file != null && file.exists();
    }

    public static boolean copyFile(File file, String str, String str2) {
        if (file != null && !TextUtils.isEmpty(str)) {
            File file2 = new File(str);
            if (file2.exists()) {
                file2.delete();
            } else {
                try {
                    file2.mkdirs();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            File file3 = new File(str.concat(str2));
            if (file3.exists()) {
                file3.delete();
            } else {
                try {
                    file3.createNewFile();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            }
            try {
                FileChannel channel = new FileInputStream(file).getChannel();
                FileChannel channel2 = new FileOutputStream(file3).getChannel();
                channel.transferTo(0L, channel.size(), channel2);
                try {
                    channel.close();
                    channel2.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
                return true;
            } catch (FileNotFoundException e5) {
                e5.printStackTrace();
            } catch (IOException e6) {
                e6.printStackTrace();
                return false;
            }
        }
        return false;
    }
}
