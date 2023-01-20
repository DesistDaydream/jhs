package com.m7.imkfsdk.utils;

import android.os.Environment;
import com.moor.imkf.lib.utils.MoorSdkVersionUtil;
import java.io.File;

/* loaded from: classes2.dex */
public class MoorPathUtil {
    public static String SDK_FILE_SEPARATOR = "moor_kfSdk";

    public static String getFileDownLoadPath() {
        if (MoorSdkVersionUtil.over29()) {
            StringBuilder sb = new StringBuilder();
            sb.append(Environment.DIRECTORY_DOWNLOADS);
            String str = File.separator;
            sb.append(str);
            sb.append(SDK_FILE_SEPARATOR);
            sb.append(str);
            return sb.toString();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(Environment.getExternalStorageDirectory().getPath());
        String str2 = File.separator;
        sb2.append(str2);
        sb2.append(Environment.DIRECTORY_DOWNLOADS);
        sb2.append(str2);
        sb2.append(SDK_FILE_SEPARATOR);
        sb2.append(str2);
        String sb3 = sb2.toString();
        if (MoorFileUtils.isFileExists(sb3)) {
            return sb3;
        }
        MoorFileUtils.createOrExistsDir(new File(sb3));
        return sb3;
    }

    public static String getImageDownLoadPath() {
        if (MoorSdkVersionUtil.over29()) {
            StringBuilder sb = new StringBuilder();
            sb.append(Environment.DIRECTORY_PICTURES);
            String str = File.separator;
            sb.append(str);
            sb.append(SDK_FILE_SEPARATOR);
            sb.append(str);
            return sb.toString();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(Environment.getExternalStorageDirectory().getPath());
        String str2 = File.separator;
        sb2.append(str2);
        sb2.append(Environment.DIRECTORY_PICTURES);
        sb2.append(str2);
        sb2.append(SDK_FILE_SEPARATOR);
        sb2.append(str2);
        String sb3 = sb2.toString();
        if (MoorFileUtils.isFileExists(sb3)) {
            return sb3;
        }
        MoorFileUtils.createOrExistsDir(new File(sb3));
        return sb3;
    }
}
