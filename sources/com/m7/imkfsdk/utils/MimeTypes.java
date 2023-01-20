package com.m7.imkfsdk.utils;

import android.webkit.MimeTypeMap;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class MimeTypes {
    private Map<String, String> mMimeTypes = new HashMap();
    private Map<String, Integer> mIcons = new HashMap();

    public int getIcon(String str) {
        Integer num = this.mIcons.get(str);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public String getMimeType(String str) {
        String mimeTypeFromExtension;
        String extension = FileUtils.getExtension(str);
        if (extension.length() <= 0 || (mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(extension.substring(1))) == null) {
            String str2 = this.mMimeTypes.get(extension.toLowerCase());
            return str2 == null ? "*/*" : str2;
        }
        return mimeTypeFromExtension;
    }

    public void put(String str, String str2, int i2) {
        put(str, str2);
        this.mIcons.put(str2, Integer.valueOf(i2));
    }

    public void put(String str, String str2) {
        this.mMimeTypes.put(str, str2.toLowerCase());
    }
}
