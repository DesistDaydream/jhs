package com.meizu.cloud.pushsdk.c.c;

import java.nio.charset.Charset;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public class g {
    private static final Pattern a = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");
    private static final Pattern b = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");

    /* renamed from: c  reason: collision with root package name */
    private final String f4748c;

    /* renamed from: d  reason: collision with root package name */
    private final String f4749d;

    /* renamed from: e  reason: collision with root package name */
    private final String f4750e;

    /* renamed from: f  reason: collision with root package name */
    private final String f4751f;

    private g(String str, String str2, String str3, String str4) {
        this.f4748c = str;
        this.f4749d = str2;
        this.f4750e = str3;
        this.f4751f = str4;
    }

    public static g a(String str) {
        Matcher matcher = a.matcher(str);
        if (matcher.lookingAt()) {
            String group = matcher.group(1);
            Locale locale = Locale.US;
            String lowerCase = group.toLowerCase(locale);
            String lowerCase2 = matcher.group(2).toLowerCase(locale);
            Matcher matcher2 = b.matcher(str);
            String str2 = null;
            for (int end = matcher.end(); end < str.length(); end = matcher2.end()) {
                matcher2.region(end, str.length());
                if (!matcher2.lookingAt()) {
                    return null;
                }
                if ("charset".equalsIgnoreCase(matcher2.group(1))) {
                    String group2 = matcher2.group(2) != null ? matcher2.group(2) : matcher2.group(3);
                    if (str2 != null && !group2.equalsIgnoreCase(str2)) {
                        throw new IllegalArgumentException("Multiple different charsets: " + str);
                    }
                    str2 = group2;
                }
            }
            return new g(str, lowerCase, lowerCase2, str2);
        }
        return null;
    }

    public String a() {
        return this.f4749d;
    }

    public Charset b() {
        String str = this.f4751f;
        if (str != null) {
            return Charset.forName(str);
        }
        return null;
    }

    public boolean equals(Object obj) {
        return (obj instanceof g) && ((g) obj).f4748c.equals(this.f4748c);
    }

    public int hashCode() {
        return this.f4748c.hashCode();
    }

    public String toString() {
        return this.f4748c;
    }
}
