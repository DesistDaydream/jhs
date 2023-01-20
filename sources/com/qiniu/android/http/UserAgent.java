package com.qiniu.android.http;

import com.qiniu.android.common.Constants;
import com.qiniu.android.utils.Utils;
import java.nio.charset.Charset;
import java.util.Random;

/* loaded from: classes3.dex */
public final class UserAgent {
    private static UserAgent _instance = new UserAgent();
    public final String id;
    public final String ua;

    private UserAgent() {
        String genId = genId();
        this.id = genId;
        this.ua = getUserAgent(genId);
    }

    private static String genId() {
        Random random = new Random();
        return System.currentTimeMillis() + "" + random.nextInt(999);
    }

    public static String getUserAgent(String str) {
        return String.format("QiniuAndroid%s/%s (%s; %s; %s", Utils.isDebug() ? "_Debug" : "", Constants.VERSION, Utils.systemVersion(), Utils.systemName(), str);
    }

    public static UserAgent instance() {
        return _instance;
    }

    public String getUa(String str) {
        String trim = ("" + str).trim();
        if (trim.length() > 15) {
            trim = trim.substring(0, Math.min(16, trim.length()));
        }
        return new String((this.ua + "; " + trim + ")").getBytes(Charset.forName("ISO-8859-1")));
    }
}
