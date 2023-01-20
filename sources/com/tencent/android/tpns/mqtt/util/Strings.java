package com.tencent.android.tpns.mqtt.util;

/* loaded from: classes3.dex */
public final class Strings {
    private static final int INDEX_NOT_FOUND = -1;

    private Strings() {
    }

    public static boolean containsAny(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence2 == null) {
            return false;
        }
        return containsAny(charSequence, toCharArray(charSequence2));
    }

    public static int countMatches(CharSequence charSequence, CharSequence charSequence2) {
        int i2 = 0;
        if (isEmpty(charSequence) || isEmpty(charSequence2)) {
            return 0;
        }
        int i3 = 0;
        while (true) {
            int indexOf = indexOf(charSequence, charSequence2, i2);
            if (indexOf == -1) {
                return i3;
            }
            i3++;
            i2 = indexOf + charSequence2.length();
        }
    }

    public static boolean equalsAny(CharSequence charSequence, CharSequence[] charSequenceArr) {
        boolean z = charSequence == null && charSequenceArr == null;
        if (charSequenceArr != null) {
            for (CharSequence charSequence2 : charSequenceArr) {
                z = z || charSequence2.equals(charSequence);
            }
        }
        return z;
    }

    private static int indexOf(CharSequence charSequence, CharSequence charSequence2, int i2) {
        return charSequence.toString().indexOf(charSequence2.toString(), i2);
    }

    public static boolean isEmpty(CharSequence charSequence) {
        return charSequence == null || charSequence.length() == 0;
    }

    private static char[] toCharArray(CharSequence charSequence) {
        if (charSequence instanceof String) {
            return ((String) charSequence).toCharArray();
        }
        int length = charSequence.length();
        char[] cArr = new char[charSequence.length()];
        for (int i2 = 0; i2 < length; i2++) {
            cArr[i2] = charSequence.charAt(i2);
        }
        return cArr;
    }

    public static boolean containsAny(CharSequence charSequence, char[] cArr) {
        if (!isEmpty(charSequence) && !isEmpty(cArr)) {
            int length = charSequence.length();
            int length2 = cArr.length;
            int i2 = length - 1;
            int i3 = length2 - 1;
            for (int i4 = 0; i4 < length; i4++) {
                char charAt = charSequence.charAt(i4);
                for (int i5 = 0; i5 < length2; i5++) {
                    if (cArr[i5] == charAt) {
                        if (!Character.isHighSurrogate(charAt) || i5 == i3) {
                            return true;
                        }
                        if (i4 < i2 && cArr[i5 + 1] == charSequence.charAt(i4 + 1)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    private static boolean isEmpty(char[] cArr) {
        return cArr == null || cArr.length == 0;
    }
}
