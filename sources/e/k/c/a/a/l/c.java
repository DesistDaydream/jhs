package e.k.c.a.a.l;

import android.annotation.TargetApi;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.URLUtil;
import com.huawei.secure.android.common.util.LogsUtil;
import com.tencent.android.tpns.mqtt.MqttTopic;
import com.tencent.qcloud.tuikit.tuichat.ui.view.input.TIMMentionEditText;
import java.net.MalformedURLException;
import java.net.URL;

/* loaded from: classes2.dex */
public class c {
    private static final String a = "UriUtil";

    private static String a(String str) {
        if (!TextUtils.isEmpty(str)) {
            return !URLUtil.isNetworkUrl(str) ? str : b(str);
        }
        LogsUtil.r(a, "whiteListUrl is null");
        return null;
    }

    @TargetApi(9)
    public static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            LogsUtil.r(a, "url is null");
            return str;
        }
        try {
            if (!URLUtil.isNetworkUrl(str)) {
                LogsUtil.l(a, "url don't starts with http or https");
                return "";
            }
            return new URL(str.replaceAll("[\\\\#]", MqttTopic.TOPIC_LEVEL_SEPARATOR)).getHost();
        } catch (MalformedURLException e2) {
            LogsUtil.l(a, "getHostByURI error  MalformedURLException : " + e2.getMessage());
            return "";
        }
    }

    public static boolean c(String str, String[] strArr) {
        if (strArr != null && strArr.length != 0) {
            for (String str2 : strArr) {
                if (d(str, str2)) {
                    return true;
                }
            }
            return false;
        }
        LogsUtil.l(a, "whitelist is null");
        return false;
    }

    public static boolean d(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (!str.contains("..") && !str.contains(TIMMentionEditText.TIM_MENTION_TAG)) {
                if (!str2.equals(str)) {
                    if (!str.startsWith(str2 + "?")) {
                        if (!str.startsWith(str2 + MqttTopic.MULTI_LEVEL_WILDCARD)) {
                            if (str2.endsWith(MqttTopic.TOPIC_LEVEL_SEPARATOR)) {
                                if (Uri.parse(str).getPathSegments().size() - Uri.parse(str2).getPathSegments().size() != 1) {
                                    return false;
                                }
                                return str.startsWith(str2);
                            }
                            return false;
                        }
                    }
                }
                return true;
            }
            Log.e(a, "url contains unsafe char");
        }
        return false;
    }

    public static boolean e(String str, String[] strArr) {
        if (strArr != null && strArr.length != 0) {
            for (String str2 : strArr) {
                if (f(str, str2)) {
                    return true;
                }
            }
            return false;
        }
        LogsUtil.l(a, "whitelist is null");
        return false;
    }

    public static boolean f(String str, String str2) {
        String b = b(str);
        if (!TextUtils.isEmpty(b) && !TextUtils.isEmpty(str2)) {
            String a2 = a(str2);
            if (TextUtils.isEmpty(a2)) {
                Log.e(a, "whitelist host is null");
                return false;
            } else if (a2.equals(b)) {
                return true;
            } else {
                if (b.endsWith(a2)) {
                    try {
                        String substring = b.substring(0, b.length() - a2.length());
                        if (substring.endsWith(".")) {
                            return substring.matches("^[A-Za-z0-9.-]+$");
                        }
                        return false;
                    } catch (IndexOutOfBoundsException e2) {
                        LogsUtil.l(a, "IndexOutOfBoundsException" + e2.getMessage());
                    } catch (Exception e3) {
                        LogsUtil.l(a, "Exception : " + e3.getMessage());
                        return false;
                    }
                }
                return false;
            }
        }
        LogsUtil.l(a, "url or whitelist is null");
        return false;
    }

    public static boolean g(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            return TextUtils.equals(b(str), a(str2));
        }
        Log.e(a, "isUrlHostSameWhitelist: url or host is null");
        return false;
    }

    public static boolean h(String str, String[] strArr) {
        if (strArr != null && strArr.length != 0) {
            for (String str2 : strArr) {
                if (g(str, str2)) {
                    return true;
                }
            }
            return false;
        }
        LogsUtil.l(a, "whitelist is null");
        return false;
    }
}
