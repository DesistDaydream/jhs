package com.tencent.qcloud.tuikit.tuichat.util;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.tencent.android.tpns.mqtt.MqttTopic;
import com.tencent.qcloud.tuikit.tuichat.component.imagevideoscan.ImageVideoScanPresenter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* loaded from: classes3.dex */
public class FileUtil {
    private static final String TAG = ImageVideoScanPresenter.class.getSimpleName();
    public static final String rootPath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES) + "/im";

    public static void copyFile(File file, File file2) {
        if (file.getAbsolutePath().equals(file2.getAbsolutePath())) {
            return;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            byte[] bArr = new byte[1024];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read >= 0) {
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    fileInputStream.close();
                    fileOutputStream.close();
                    return;
                }
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public static void createDirIfNotExist() {
        File file = new File(rootPath);
        if (file.exists()) {
            return;
        }
        try {
            file.mkdirs();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void saveFileToAlbum(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            TUIChatLog.e(TAG, "srcString is null");
            return;
        }
        File file = new File(str);
        if (!file.exists()) {
            TUIChatLog.e(TAG, "srcFile is null");
            return;
        }
        createDirIfNotExist();
        File file2 = new File(rootPath + MqttTopic.TOPIC_LEVEL_SEPARATOR + file.getName());
        copyFile(file, file2);
        MediaScannerConnection.scanFile(context, new String[]{file2.getPath()}, null, null);
    }

    public static boolean saveImageToGallery(Context context, Bitmap bitmap) {
        if (bitmap == null) {
            TUIChatLog.e(TAG, "src is null");
            return false;
        }
        File file = new File(rootPath);
        if (!file.exists()) {
            file.mkdir();
        }
        String str = System.currentTimeMillis() + ".jpg";
        File file2 = new File(file, str);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            boolean compress = bitmap.compress(Bitmap.CompressFormat.JPEG, 60, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            MediaStore.Images.Media.insertImage(context.getContentResolver(), file2.getAbsolutePath(), str, (String) null);
            context.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(file2)));
            return compress;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }
}
