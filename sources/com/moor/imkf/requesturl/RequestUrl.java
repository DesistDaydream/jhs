package com.moor.imkf.requesturl;

import android.text.TextUtils;

/* loaded from: classes2.dex */
public class RequestUrl {
    public static int ALIYUN_REQUEST = 1;
    public static String BASE_HTTP = null;
    public static String BASE_SOCKET = null;
    public static String[] FILE_DOMAINS = null;
    public static boolean IS_FILE_HTTPS = false;
    public static int MOOR_REQUEST = 3;
    public static String QINIU_HTTP = null;
    public static int TENCENT_REQUEST = 2;
    public static String VIDEO_URL = "https://kfvideo.7moor.com";

    public static void setAliUrl() {
        BASE_HTTP = "https://cc-sdk-http.7moor-fs1.com/sdkChat";
        QINIU_HTTP = "https://fs-im-resources.7moor.com/";
        FILE_DOMAINS = null;
    }

    public static void setFileUrl(String str, String[] strArr, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            QINIU_HTTP = str;
        }
        if (strArr != null && strArr.length > 0) {
            FILE_DOMAINS = strArr;
        }
        IS_FILE_HTTPS = z;
    }

    public static void setRequestBasic(int i2) {
        if (i2 == 1) {
            setAliUrl();
        } else if (i2 == 2) {
            setTxUrl();
        } else if (i2 != 3) {
            setAliUrl();
        } else {
            setYanFaUrl();
        }
    }

    public static void setRequestUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        BASE_HTTP = str;
    }

    private static void setTxUrl() {
        BASE_HTTP = "https://ykf-webchat.7moor-fs1.com/sdkChat";
        QINIU_HTTP = "https://fs-im-resources.7moor.com/";
        FILE_DOMAINS = null;
    }

    public static void setYanFaUrl() {
        BASE_HTTP = "http://58.87.118.20:3309/sdkChat";
        QINIU_HTTP = "https://fs-im-resources.7moor.com/";
        FILE_DOMAINS = null;
    }
}
