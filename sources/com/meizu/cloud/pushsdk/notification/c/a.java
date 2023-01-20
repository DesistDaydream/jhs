package com.meizu.cloud.pushsdk.notification.c;

import android.text.TextUtils;
import com.tencent.android.tpns.mqtt.MqttTopic;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/* loaded from: classes2.dex */
public class a {
    public static void a(String str, String str2) {
        String[] list;
        try {
            new File(str2).mkdirs();
            for (String str3 : new File(str).list()) {
                String str4 = File.separator;
                File file = str.endsWith(str4) ? new File(str + str3) : new File(str + str4 + str3);
                if (file.isFile()) {
                    FileInputStream fileInputStream = new FileInputStream(file);
                    FileOutputStream fileOutputStream = new FileOutputStream(str2 + MqttTopic.TOPIC_LEVEL_SEPARATOR + file.getName());
                    byte[] bArr = new byte[5120];
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    }
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    fileInputStream.close();
                } else if (file.isDirectory()) {
                    a(str + MqttTopic.TOPIC_LEVEL_SEPARATOR + str3, str2 + MqttTopic.TOPIC_LEVEL_SEPARATOR + str3);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static boolean a(String str) {
        if (!TextUtils.isEmpty(str) && !str.contains("../")) {
            File file = new File(str);
            if (file.isFile() && file.exists()) {
                return file.delete();
            }
        }
        return false;
    }

    public static boolean b(String str) {
        File[] listFiles;
        if (!TextUtils.isEmpty(str) && !str.contains("../")) {
            String str2 = File.separator;
            if (!str.endsWith(str2)) {
                str = str + str2;
            }
            File file = new File(str);
            if (file.exists() && file.isDirectory()) {
                boolean z = true;
                for (File file2 : file.listFiles()) {
                    boolean isFile = file2.isFile();
                    String absolutePath = file2.getAbsolutePath();
                    if (isFile) {
                        z = a(absolutePath);
                        if (!z) {
                            break;
                        }
                    } else {
                        z = b(absolutePath);
                        if (!z) {
                            break;
                        }
                    }
                }
                if (z) {
                    return file.delete();
                }
                return false;
            }
        }
        return false;
    }

    public static File[] b(String str, final String str2) {
        File file = new File(str);
        return file.isDirectory() ? file.listFiles(new FileFilter() { // from class: com.meizu.cloud.pushsdk.notification.c.a.1
            @Override // java.io.FileFilter
            public boolean accept(File file2) {
                try {
                    return Long.valueOf(str2).longValue() > Long.valueOf(file2.getName().split(Constants.ACCEPT_TIME_SEPARATOR_SERVER)[1]).longValue();
                } catch (Exception e2) {
                    e.p.a.a.a.f("FileUtil", "filters file error " + e2.getMessage());
                    return true;
                }
            }
        }) : new File[0];
    }
}
