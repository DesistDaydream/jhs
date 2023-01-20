package com.qiniu.android.http;

import com.qiniu.android.common.Constants;
import com.qiniu.android.http.request.Request;
import com.umeng.analytics.pro.d;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class ResponseInfo {
    public static final int Cancelled = -2;
    public static final int CannotConnectToHost = -1004;
    @Deprecated
    public static final int Crc32NotMatch = -406;
    public static final int InvalidArgument = -4;
    public static final int InvalidFile = -3;
    public static final int InvalidToken = -5;
    public static final int LocalIOError = -7;
    public static final int MaliciousResponseError = -8;
    public static final int NetworkConnectionLost = -1005;
    public static final int NetworkError = -1;
    public static final int NetworkProtocolError = 100;
    public static final int NetworkSSLError = -1200;
    public static final int NetworkSlow = -1009;
    @Deprecated
    public static final int NoUsableHostError = -9;
    public static final int ParseError = -1015;
    @Deprecated
    public static final int PasrseError = -1015;
    public static final int RequestSuccess = 200;
    @Deprecated
    public static final int ResquestSuccess = 200;
    public static final int SDKInteriorError = -9;
    public static final int TimedOut = -1001;
    public static final int UnexpectedSysCallError = -10;
    @Deprecated
    public static final int UnknownError = 10000;
    public static final int UnknownHost = -1003;
    public static final int ZeroSizeFile = -6;
    public final String error;
    public final String host;
    public final String id;
    public String message;
    public final String reqId;
    public final JSONObject response;
    public final Map<String, String> responseHeader;
    public final int statusCode;
    public final long timeStamp;
    public final String xlog;
    public final String xvia;

    private ResponseInfo(JSONObject jSONObject, Map<String, String> map, int i2, String str, String str2, String str3, String str4, String str5) {
        this.response = jSONObject;
        this.responseHeader = map;
        this.statusCode = i2;
        this.reqId = str == null ? "" : str;
        this.xlog = str2;
        this.xvia = str3;
        this.host = str4;
        this.id = UserAgent.instance().id;
        this.timeStamp = System.currentTimeMillis() / 1000;
        if (str5 == null && !isOK()) {
            String str6 = null;
            if (jSONObject != null) {
                try {
                    str6 = jSONObject.getString(d.O);
                } catch (JSONException unused) {
                }
            }
            this.error = str6;
            return;
        }
        this.error = str5;
    }

    public static ResponseInfo cancelled() {
        return errorInfo(-2, "cancelled by user");
    }

    public static ResponseInfo create(Request request, int i2, Map<String, String> map, JSONObject jSONObject, String str) {
        String str2;
        String str3;
        String str4;
        String str5 = null;
        String str6 = request != null ? request.host : null;
        if (map != null) {
            String str7 = map.get("x-reqid");
            String str8 = map.get("x-log");
            if (map.get("x-via") != null) {
                str5 = map.get("x-via");
            } else if (map.get("x-px") != null) {
                str5 = map.get("x-px");
            } else if (map.get("fw-via") != null) {
                str5 = map.get("fw-via");
            }
            str2 = str7;
            str4 = str5;
            str3 = str8;
        } else {
            str2 = null;
            str3 = null;
            str4 = null;
        }
        return new ResponseInfo(jSONObject, map, i2, str2, str3, str4, str6, str);
    }

    public static ResponseInfo errorInfo(int i2, String str) {
        return new ResponseInfo(null, null, i2, null, null, null, null, str);
    }

    public static ResponseInfo fileError(Exception exc) {
        return errorInfo(-3, exc != null ? exc.getMessage() : null);
    }

    public static ResponseInfo invalidArgument(String str) {
        return errorInfo(-4, str);
    }

    public static ResponseInfo invalidToken(String str) {
        return errorInfo(-5, str);
    }

    private boolean isQiniu() {
        return !isNotQiniu();
    }

    public static boolean isStatusCodeForBrokenNetwork(int i2) {
        return i2 == -1 || i2 == -1003 || i2 == -1004 || i2 == -1001 || i2 == -1005;
    }

    public static ResponseInfo localIOError(String str) {
        return errorInfo(-7, str);
    }

    public static ResponseInfo maliciousResponseError(String str) {
        return errorInfo(-8, str);
    }

    public static ResponseInfo networkError(String str) {
        return errorInfo(-1, str);
    }

    @Deprecated
    public static ResponseInfo noUsableHostError(String str) {
        return errorInfo(-9, str);
    }

    public static ResponseInfo sdkInteriorError(String str) {
        return errorInfo(-9, str);
    }

    public static ResponseInfo successResponse() {
        return new ResponseInfo(null, null, 200, "inter:reqid", "inter:xlog", "inter:xvia", null, null);
    }

    public static ResponseInfo unexpectedSysCallError(String str) {
        return errorInfo(-10, str);
    }

    public static ResponseInfo zeroSize(String str) {
        if (str == null) {
            str = "data size is 0";
        }
        return errorInfo(-6, str);
    }

    public boolean canConnectToHost() {
        return this.statusCode > 99 || isCancelled();
    }

    public ResponseInfo checkMaliciousResponse() {
        String str;
        String str2;
        return (this.statusCode == 200 && ((str = this.reqId) == null || str.length() == 0) && (str2 = this.xlog) == null) ? new ResponseInfo(null, this.responseHeader, -8, this.reqId, str2, this.xvia, this.host, "this is a malicious response") : this;
    }

    public boolean couldHostRetry() {
        int i2;
        return (isNotQiniu() || !couldRegionRetry() || (i2 = this.statusCode) == 502 || i2 == 503 || i2 == 571 || i2 == 599) ? false : true;
    }

    public boolean couldRegionRetry() {
        int i2;
        return (!couldRetry() || (i2 = this.statusCode) == 400 || i2 == 579) ? false : true;
    }

    public boolean couldRetry() {
        if (isQiniu()) {
            if (isCancelled()) {
                return false;
            }
            int i2 = this.statusCode;
            if (i2 <= 300 || i2 >= 400) {
                if ((i2 > 400 && i2 < 500 && i2 != 406) || i2 == 501 || i2 == 573 || i2 == 608 || i2 == 612 || i2 == 614 || i2 == 616 || i2 == 619 || i2 == 630 || i2 == 631 || i2 == 640 || i2 == 701) {
                    return false;
                }
                return i2 >= -1 || i2 <= -1000;
            }
            return false;
        }
        return true;
    }

    public boolean hasReqId() {
        String str = this.reqId;
        return str != null && str.length() > 0;
    }

    public boolean isCancelled() {
        return this.statusCode == -2;
    }

    public boolean isHostUnavailable() {
        int i2 = this.statusCode;
        return i2 == 502 || i2 == 503 || i2 == 504 || i2 == 599;
    }

    public boolean isNetworkBroken() {
        int i2 = this.statusCode;
        return i2 == -1 || i2 == -1009;
    }

    public boolean isNotQiniu() {
        int i2 = this.statusCode;
        return i2 == -8 || (i2 > 0 && !hasReqId() && this.xlog == null);
    }

    public boolean isOK() {
        return this.statusCode == 200 && this.error == null && (hasReqId() || this.xlog != null);
    }

    public boolean isServerError() {
        int i2 = this.statusCode;
        return (i2 >= 500 && i2 < 600 && i2 != 579) || i2 == 996;
    }

    public boolean isTlsError() {
        return this.statusCode == -1200;
    }

    public boolean needRetry() {
        int i2;
        return !isCancelled() && (needSwitchServer() || (i2 = this.statusCode) == 406 || ((i2 == 200 && this.error != null) || isNotQiniu()));
    }

    public boolean needSwitchServer() {
        return isNetworkBroken() || isServerError();
    }

    public String toString() {
        return String.format(Locale.ENGLISH, "{ver:%s,ResponseInfo:%s,status:%d, reqId:%s, xlog:%s, xvia:%s, host:%s, time:%d,error:%s}", Constants.VERSION, this.id, Integer.valueOf(this.statusCode), this.reqId, this.xlog, this.xvia, this.host, Long.valueOf(this.timeStamp), this.error);
    }
}
