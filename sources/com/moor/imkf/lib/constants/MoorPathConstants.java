package com.moor.imkf.lib.constants;

import android.os.Environment;
import com.moor.imkf.lib.MoorBaseLibManager;
import java.io.File;

/* loaded from: classes2.dex */
public class MoorPathConstants {
    public static final String PATH_NAME_MOOR_DOWNLOAD_FILE = "Moor_Download_File";
    public static final String PATH_NAME_MOOR_LOG = "Moor_Log";
    public static final String PATH_NAME_MOOR_RECORDAUDIO_FILE = "Moor_RecordAudio_File";

    public static String getStoragePath(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(MoorBaseLibManager.getInstance().getApplication().getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS));
        String str2 = File.separator;
        sb.append(str2);
        sb.append(str);
        sb.append(str2);
        return sb.toString();
    }
}
