package com.huawei.hms.hatool;

import android.util.Pair;
import com.tencent.android.tpns.mqtt.MqttTopic;
import com.xiaomi.mipush.sdk.Constants;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/* loaded from: classes2.dex */
public abstract class u0 {
    public static long a(String str, long j2) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, Locale.getDefault());
            return simpleDateFormat.parse(simpleDateFormat.format(Long.valueOf(j2))).getTime();
        } catch (ParseException unused) {
            y.f("hmsSdk/stringUtil", "getMillisOfDate(): Time conversion Exception !");
            return 0L;
        }
    }

    public static Pair<String, String> a(String str) {
        String str2;
        String str3;
        if ("_default_config_tag".equals(str)) {
            return new Pair<>(str, "");
        }
        String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        if (split.length > 2) {
            str3 = split[split.length - 1];
            str2 = str.substring(0, (str.length() - str3.length()) - 1);
        } else {
            str2 = split[0];
            str3 = split[1];
        }
        return new Pair<>(str2, str3);
    }

    public static String a(int i2) {
        return i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? "alltype" : "diffprivacy" : "preins" : "maint" : "oper";
    }

    public static String a(String str, String str2) {
        if ("_default_config_tag".equals(str)) {
            return str;
        }
        return str + Constants.ACCEPT_TIME_SEPARATOR_SERVER + str2;
    }

    public static String a(String str, String str2, String str3) {
        if ("_default_config_tag".equals(str)) {
            return "_default_config_tag#" + str3;
        }
        return str + Constants.ACCEPT_TIME_SEPARATOR_SERVER + str2 + MqttTopic.MULTI_LEVEL_WILDCARD + str3;
    }

    public static Set<String> a(Set<String> set) {
        if (set == null || set.size() == 0) {
            return new HashSet();
        }
        HashSet hashSet = new HashSet();
        for (String str : set) {
            if ("_default_config_tag".equals(str)) {
                hashSet.add("_default_config_tag");
            } else {
                String str2 = str + Constants.ACCEPT_TIME_SEPARATOR_SERVER + "oper";
                String str3 = str + Constants.ACCEPT_TIME_SEPARATOR_SERVER + "maint";
                hashSet.add(str2);
                hashSet.add(str3);
                hashSet.add(str + Constants.ACCEPT_TIME_SEPARATOR_SERVER + "diffprivacy");
            }
        }
        return hashSet;
    }
}
