package com.moor.imkf.lib.jsoup.internal;

import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.moor.imkf.lib.jsoup.helper.Validate;
import com.tencent.android.tpns.mqtt.MqttTopic;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Stack;

/* loaded from: classes2.dex */
public final class StringUtil {
    private static final int MaxCachedBuilderSize = 8192;
    private static final int MaxIdleBuilders = 8;
    public static final String[] padding = {"", ExpandableTextView.N, "  ", "   ", "    ", "     ", "      ", "       ", "        ", "         ", "          ", "           ", "            ", "             ", "              ", "               ", "                ", "                 ", "                  ", "                   ", "                    "};
    private static final Stack<StringBuilder> builders = new Stack<>();

    public static void appendNormalisedWhitespace(StringBuilder sb, String str, boolean z) {
        int length = str.length();
        int i2 = 0;
        boolean z2 = false;
        boolean z3 = false;
        while (i2 < length) {
            int codePointAt = str.codePointAt(i2);
            if (isActuallyWhitespace(codePointAt)) {
                if ((!z || z2) && !z3) {
                    sb.append(' ');
                    z3 = true;
                }
            } else if (!isInvisibleChar(codePointAt)) {
                sb.appendCodePoint(codePointAt);
                z2 = true;
                z3 = false;
            }
            i2 += Character.charCount(codePointAt);
        }
    }

    public static StringBuilder borrowBuilder() {
        StringBuilder sb;
        Stack<StringBuilder> stack = builders;
        synchronized (stack) {
            sb = stack.empty() ? new StringBuilder(8192) : stack.pop();
        }
        return sb;
    }

    public static boolean in(String str, String... strArr) {
        for (String str2 : strArr) {
            if (str2.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static boolean inSorted(String str, String[] strArr) {
        return Arrays.binarySearch(strArr, str) >= 0;
    }

    public static boolean isActuallyWhitespace(int i2) {
        return i2 == 32 || i2 == 9 || i2 == 10 || i2 == 12 || i2 == 13 || i2 == 160;
    }

    public static boolean isBlank(String str) {
        if (str != null && str.length() != 0) {
            int length = str.length();
            for (int i2 = 0; i2 < length; i2++) {
                if (!isWhitespace(str.codePointAt(i2))) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isInvisibleChar(int i2) {
        return i2 == 8203 || i2 == 173;
    }

    public static boolean isNumeric(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            if (!Character.isDigit(str.codePointAt(i2))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isWhitespace(int i2) {
        return i2 == 32 || i2 == 9 || i2 == 10 || i2 == 12 || i2 == 13;
    }

    public static String join(Collection collection, String str) {
        return join(collection.iterator(), str);
    }

    public static String normaliseWhitespace(String str) {
        StringBuilder borrowBuilder = borrowBuilder();
        appendNormalisedWhitespace(borrowBuilder, str, false);
        return releaseBuilder(borrowBuilder);
    }

    public static String padding(int i2) {
        if (i2 >= 0) {
            String[] strArr = padding;
            if (i2 < strArr.length) {
                return strArr[i2];
            }
            char[] cArr = new char[i2];
            for (int i3 = 0; i3 < i2; i3++) {
                cArr[i3] = ' ';
            }
            return String.valueOf(cArr);
        }
        throw new IllegalArgumentException("width must be > 0");
    }

    public static String releaseBuilder(StringBuilder sb) {
        Validate.notNull(sb);
        String sb2 = sb.toString();
        if (sb.length() > 8192) {
            sb = new StringBuilder(8192);
        } else {
            sb.delete(0, sb.length());
        }
        Stack<StringBuilder> stack = builders;
        synchronized (stack) {
            stack.push(sb);
            while (true) {
                Stack<StringBuilder> stack2 = builders;
                if (stack2.size() > 8) {
                    stack2.pop();
                }
            }
        }
        return sb2;
    }

    public static URL resolve(URL url, String str) throws MalformedURLException {
        if (str.startsWith("?")) {
            str = url.getPath() + str;
        }
        if (str.indexOf(46) == 0 && url.getFile().indexOf(47) != 0) {
            url = new URL(url.getProtocol(), url.getHost(), url.getPort(), MqttTopic.TOPIC_LEVEL_SEPARATOR + url.getFile());
        }
        return new URL(url, str);
    }

    public static String join(Iterator it, String str) {
        if (it.hasNext()) {
            String obj = it.next().toString();
            if (it.hasNext()) {
                StringBuilder borrowBuilder = borrowBuilder();
                borrowBuilder.append(obj);
                while (it.hasNext()) {
                    borrowBuilder.append(str);
                    borrowBuilder.append(it.next());
                }
                return releaseBuilder(borrowBuilder);
            }
            return obj;
        }
        return "";
    }

    public static String resolve(String str, String str2) {
        try {
            try {
                return resolve(new URL(str), str2).toExternalForm();
            } catch (MalformedURLException unused) {
                return new URL(str2).toExternalForm();
            }
        } catch (MalformedURLException unused2) {
            return "";
        }
    }

    public static String join(String[] strArr, String str) {
        return join(Arrays.asList(strArr), str);
    }
}
