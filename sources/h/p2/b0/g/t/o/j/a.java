package h.p2.b0.g.t.o.j;

import h.k2.v.f0;
import java.util.Iterator;
import java.util.Locale;
import java.util.Objects;
import k.e.a.d;
import kotlin.text.StringsKt__StringsKt;

/* loaded from: classes3.dex */
public final class a {
    @d
    public static final String a(@d String str) {
        boolean z = false;
        if (str.length() == 0) {
            return str;
        }
        char charAt = str.charAt(0);
        if ('a' <= charAt && charAt <= 'z') {
            z = true;
        }
        if (z) {
            char upperCase = Character.toUpperCase(charAt);
            String substring = str.substring(1);
            return String.valueOf(upperCase) + substring;
        }
        return str;
    }

    @d
    public static final String b(@d String str) {
        boolean z = false;
        if (str.length() == 0) {
            return str;
        }
        char charAt = str.charAt(0);
        if ('A' <= charAt && charAt <= 'Z') {
            z = true;
        }
        if (z) {
            char lowerCase = Character.toLowerCase(charAt);
            String substring = str.substring(1);
            return String.valueOf(lowerCase) + substring;
        }
        return str;
    }

    @d
    public static final String c(@d String str, boolean z) {
        Integer num;
        if ((str.length() == 0) || !d(str, 0, z)) {
            return str;
        }
        if (str.length() == 1 || !d(str, 1, z)) {
            if (z) {
                return b(str);
            }
            if (str.length() > 0) {
                char lowerCase = Character.toLowerCase(str.charAt(0));
                String substring = str.substring(1);
                return String.valueOf(lowerCase) + substring;
            }
            return str;
        }
        Iterator<Integer> it = StringsKt__StringsKt.h3(str).iterator();
        while (true) {
            if (!it.hasNext()) {
                num = null;
                break;
            }
            num = it.next();
            if (!d(str, num.intValue(), z)) {
                break;
            }
        }
        Integer num2 = num;
        if (num2 == null) {
            return e(str, z);
        }
        int intValue = num2.intValue() - 1;
        return f0.C(e(str.substring(0, intValue), z), str.substring(intValue));
    }

    private static final boolean d(String str, int i2, boolean z) {
        char charAt = str.charAt(i2);
        if (z) {
            return 'A' <= charAt && charAt <= 'Z';
        }
        return Character.isUpperCase(charAt);
    }

    private static final String e(String str, boolean z) {
        if (z) {
            return f(str);
        }
        Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
        return str.toLowerCase(Locale.ROOT);
    }

    @d
    public static final String f(@d String str) {
        StringBuilder sb = new StringBuilder(str.length());
        int length = str.length();
        int i2 = 0;
        while (i2 < length) {
            char charAt = str.charAt(i2);
            i2++;
            if ('A' <= charAt && charAt <= 'Z') {
                charAt = Character.toLowerCase(charAt);
            }
            sb.append(charAt);
        }
        return sb.toString();
    }
}
