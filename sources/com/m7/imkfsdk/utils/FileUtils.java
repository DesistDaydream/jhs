package com.m7.imkfsdk.utils;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

/* loaded from: classes2.dex */
public class FileUtils {
    private static String convertStreamToString(InputStream inputStream) {
        try {
            Scanner useDelimiter = new Scanner(inputStream, "UTF-8").useDelimiter("\\A");
            r0 = useDelimiter.hasNext() ? useDelimiter.next() : null;
            inputStream.close();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        return r0;
    }

    public static void copyFile(Context context, Uri uri, File file) {
        try {
            InputStream openInputStream = context.getContentResolver().openInputStream(uri);
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

    public static int copyStream(InputStream inputStream, OutputStream outputStream) throws Exception, IOException {
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

    public static String formatFileLength(long j2) {
        if ((j2 >> 30) > 0) {
            return (Math.round((((float) j2) * 10.0f) / 1.07374195E9f) / 10.0f) + " GB";
        } else if ((j2 >> 20) > 0) {
            return formatSizeMb(j2);
        } else {
            if ((j2 >> 9) > 0) {
                return (Math.round((((float) j2) * 10.0f) / 1024.0f) / 10.0f) + " KB";
            }
            return j2 + " B";
        }
    }

    public static String formatSizeMb(long j2) {
        return (Math.round((((float) j2) * 10.0f) / 1048576.0f) / 10.0f) + " MB";
    }

    public static String getExtension(String str) {
        if (str == null) {
            return null;
        }
        int lastIndexOf = str.lastIndexOf(".");
        return lastIndexOf >= 0 ? str.substring(lastIndexOf) : "";
    }

    public static String getFileName(Uri uri) {
        String path;
        int lastIndexOf;
        if (uri == null || (lastIndexOf = (path = uri.getPath()).lastIndexOf(47)) == -1) {
            return null;
        }
        return path.substring(lastIndexOf + 1);
    }

    private static String getFileNameByUri(Context context, Uri uri) {
        Cursor query = context.getContentResolver().query(uri, null, null, null, null);
        if (query == null || query.getCount() <= 0) {
            return "";
        }
        query.moveToFirst();
        String string = query.getString(query.getColumnIndexOrThrow("_display_name"));
        query.close();
        return string;
    }

    public static String getFilePathFromURI(Context context, Uri uri) {
        File externalFilesDir = context.getExternalFilesDir(null);
        String fileNameByUri = getFileNameByUri(context, uri);
        if (TextUtils.isEmpty(fileNameByUri)) {
            return null;
        }
        File file = new File(externalFilesDir + File.separator + fileNameByUri);
        copyFile(context, uri, file);
        return file.getAbsolutePath();
    }

    public static String getOriginalFundData(Context context) {
        try {
            return convertStreamToString(context.getAssets().open("kf_address.json"));
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static boolean isExists(String str) {
        try {
            return new File(str).exists();
        } catch (Exception unused) {
            return false;
        }
    }

    public static byte[] readAudioFile(Context context, String str) {
        try {
            FileInputStream fileInputStream = new FileInputStream(new File(str));
            byte[] bArr = new byte[fileInputStream.available()];
            fileInputStream.read(bArr);
            fileInputStream.close();
            return bArr;
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
