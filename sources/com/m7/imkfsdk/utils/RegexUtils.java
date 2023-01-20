package com.m7.imkfsdk.utils;

import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.xiaomi.mipush.sdk.Constants;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public class RegexUtils {
    public static boolean checkBirthday(String str) {
        return Pattern.matches("[1-9]{4}([-./])\\d{1,2}\\1\\d{1,2}", str);
    }

    public static boolean checkBlankSpace(String str) {
        return Pattern.matches("\\s+", str);
    }

    public static boolean checkChinese(String str) {
        return Pattern.matches("^[一-龥]+$", str);
    }

    public static boolean checkContainsDot(String str) {
        return str.contains(".");
    }

    public static boolean checkContainsHyphen(String str) {
        return str.contains(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
    }

    public static boolean checkDecimals(String str) {
        return Pattern.matches("\\-?[1-9]\\d+(\\.\\d+)?", str);
    }

    public static boolean checkDigit(String str) {
        return Pattern.matches("\\-?[1-9]\\d+", str);
    }

    public static boolean checkEmail(String str) {
        return Pattern.matches("\\w+@\\w+\\.[a-z]+(\\.[a-z]+)?", str);
    }

    public static boolean checkIdCard(String str) {
        return Pattern.matches("[1-9]\\d{13,16}[a-zA-Z0-9]{1}", str);
    }

    public static boolean checkIpAddress(String str) {
        return Pattern.matches("[1-9](\\d{1,2})?\\.(0|([1-9](\\d{1,2})?))\\.(0|([1-9](\\d{1,2})?))\\.(0|([1-9](\\d{1,2})?))", str);
    }

    public static boolean checkMobile(String str) {
        return Pattern.matches("(\\+\\d+)?1[3458]\\d{9}$", str);
    }

    public static boolean checkPhone(String str) {
        return Pattern.matches("(\\+\\d+)?(\\d{3,4}\\-?)?\\d{7,8}$", str);
    }

    public static boolean checkPostcode(String str) {
        return Pattern.matches("[1-9]\\d{5}", str);
    }

    public static boolean checkURL(String str) {
        return str.startsWith("www") | str.startsWith("https") | str.startsWith("http") | str.startsWith("ftp");
    }

    public static boolean checkUserPasswordLength(String str) {
        return str.length() > 5 && str.length() < 21;
    }

    public static String getDomain(String str) {
        Matcher matcher = Pattern.compile("(?<=http://|\\.)[^.]*?\\.(com|cn|net|org|biz|info|cc|tv)", 2).matcher(str);
        matcher.find();
        return matcher.group();
    }

    public static String getLandlinePhoneRegexp() {
        return "(?:(\\(\\+?86\\))(0[0-9]{2,3}\\-?)+([2-9][0-9]{6,8})+(\\-[0-9]{1,4})?)|(?:(86-?)?(0[0-9]{2,3}\\-?)+([2-9][0-9]{6,8})+(\\-[0-9]{1,4})?)";
    }

    public static String getMobilePhoneRegexp() {
        return "(?:(\\(\\+?86\\))((13[0-9]{1})|(15[0-9]{1})|(170)|(18[0,5-9]{1}))+(\\-?[0-9]{4})+(\\-?[0-9]{4}))|(?:86-?((13[0-9]{1})|(15[0-9]{1})|(170)|(18[0,5-9]{1}))+(\\-?[0-9]{4})+(\\-?[0-9]{4}))|(?:((13[0-9]{1})|(15[0-9]{1})|(170)|(18[0,5-9]{1}))+(\\-?[0-9]{4})+(\\-?[0-9]{4}))";
    }

    public static String getServicePhoneRegexp() {
        return "(?:((400)+(\\-?[0-9]{3})+([0-9]{1})?+(\\-?[0-9]{3,4})))|(?:((400)+([0-9]{1})?+(\\-?[0-9]{3})+(\\-?[0-9]{3,4})))";
    }

    public static String isPhoneRegexp() {
        String mobilePhoneRegexp = getMobilePhoneRegexp();
        String landlinePhoneRegexp = getLandlinePhoneRegexp();
        String servicePhoneRegexp = getServicePhoneRegexp();
        return "(?:" + mobilePhoneRegexp + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + landlinePhoneRegexp + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + servicePhoneRegexp + "|\\d{5,})";
    }

    public static boolean isValidUserName(String str) {
        return Pattern.matches("([A-Z0-9a-z-]|[\\u4e00-\\u9fa5])+", str);
    }

    public static SpannableString matchSearchText(int i2, String str, String str2) {
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile(Pattern.compile("[\n`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。， 、？\\\\]").matcher(str2).replaceAll(""), 2).matcher(spannableString);
        while (matcher.find()) {
            spannableString.setSpan(new ForegroundColorSpan(i2), matcher.start(), matcher.end(), 33);
        }
        return spannableString;
    }

    public static String regexNumber(String str) {
        return Pattern.compile("[^0-9]").matcher(str).replaceAll("").trim();
    }
}
