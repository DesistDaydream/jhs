package com.qiniu.android.storage;

import com.qiniu.android.utils.UrlSafeBase64;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Date;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class UpToken {
    public final String accessKey;
    public final String bucket;
    private long deadline = -1;
    private String returnUrl;
    public final String token;

    private UpToken(String str, String str2, String str3, String str4) {
        this.returnUrl = null;
        this.returnUrl = str;
        this.token = str2;
        this.accessKey = str3;
        this.bucket = str4;
    }

    public static UpToken getInvalidToken() {
        UpToken upToken = new UpToken("", "", "", "");
        upToken.deadline = -1L;
        return upToken;
    }

    public static boolean isInvalid(UpToken upToken) {
        return upToken == null || !upToken.isValid();
    }

    private boolean isValidBeforeTimestamp(long j2) {
        long j3 = this.deadline;
        return j3 >= 0 && j2 < j3;
    }

    public static UpToken parse(String str) {
        if (str == null) {
            return null;
        }
        try {
            String[] split = str.split(Constants.COLON_SEPARATOR);
            if (split.length != 3) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(new String(UrlSafeBase64.decode(split[2])));
            String optString = jSONObject.optString("scope");
            if (optString.equals("")) {
                return null;
            }
            String[] strArr = new String[2];
            try {
                strArr = optString.split(Constants.COLON_SEPARATOR);
            } catch (Exception unused) {
            }
            String str2 = strArr.length > 0 ? strArr[0] : "";
            long optInt = jSONObject.optInt("deadline");
            if (optInt == 0) {
                return null;
            }
            UpToken upToken = new UpToken(jSONObject.optString("returnUrl"), str, split[0], str2);
            upToken.deadline = optInt;
            return upToken;
        } catch (Exception unused2) {
            return null;
        }
    }

    public long getDeadline() {
        return this.deadline;
    }

    public boolean hasReturnUrl() {
        return !this.returnUrl.equals("");
    }

    public String index() {
        String str = "";
        if (this.accessKey != null) {
            str = "" + this.accessKey;
        }
        if (this.bucket != null) {
            return str + this.bucket;
        }
        return str;
    }

    public boolean isValid() {
        String str;
        String str2 = this.accessKey;
        return (str2 == null || str2.isEmpty() || (str = this.bucket) == null || str.isEmpty()) ? false : true;
    }

    public boolean isValidBeforeDate(Date date) {
        if (date == null) {
            return false;
        }
        return isValidBeforeTimestamp(date.getTime() / 1000);
    }

    public boolean isValidForDuration(long j2) {
        return isValidBeforeTimestamp((new Date().getTime() / 1000) + j2);
    }

    public String toString() {
        return this.token;
    }
}
