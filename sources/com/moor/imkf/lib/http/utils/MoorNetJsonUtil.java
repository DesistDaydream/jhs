package com.moor.imkf.lib.http.utils;

/* loaded from: classes2.dex */
public class MoorNetJsonUtil {
    private static void addIndentBlank(StringBuilder sb, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            sb.append('\t');
        }
    }

    public static String decodeUnicode(String str) {
        int length = str.length();
        StringBuffer stringBuffer = new StringBuffer(length);
        int i2 = 0;
        while (i2 < length) {
            int i3 = i2 + 1;
            char charAt = str.charAt(i2);
            if (charAt == '\\') {
                i2 = i3 + 1;
                char charAt2 = str.charAt(i3);
                if (charAt2 == 'u') {
                    int i4 = 0;
                    int i5 = 0;
                    while (i4 < 4) {
                        int i6 = i2 + 1;
                        char charAt3 = str.charAt(i2);
                        switch (charAt3) {
                            case '0':
                            case '1':
                            case '2':
                            case '3':
                            case '4':
                            case '5':
                            case '6':
                            case '7':
                            case '8':
                            case '9':
                                i5 = ((i5 << 4) + charAt3) - 48;
                                break;
                            default:
                                switch (charAt3) {
                                    case 'A':
                                    case 'B':
                                    case 'C':
                                    case 'D':
                                    case 'E':
                                    case 'F':
                                        i5 = (((i5 << 4) + 10) + charAt3) - 65;
                                        break;
                                    default:
                                        switch (charAt3) {
                                            case 'a':
                                            case 'b':
                                            case 'c':
                                            case 'd':
                                            case 'e':
                                            case 'f':
                                                i5 = (((i5 << 4) + 10) + charAt3) - 97;
                                                break;
                                            default:
                                                throw new IllegalArgumentException("Malformed   \\uxxxx   encoding.");
                                        }
                                }
                        }
                        i4++;
                        i2 = i6;
                    }
                    stringBuffer.append((char) i5);
                } else {
                    if (charAt2 == 't') {
                        charAt2 = '\t';
                    } else if (charAt2 == 'r') {
                        charAt2 = '\r';
                    } else if (charAt2 == 'n') {
                        charAt2 = '\n';
                    } else if (charAt2 == 'f') {
                        charAt2 = '\f';
                    }
                    stringBuffer.append(charAt2);
                }
            } else {
                stringBuffer.append(charAt);
                i2 = i3;
            }
        }
        return stringBuffer.toString();
    }

    public static String formatJson(String str) {
        if (str == null || "".equals(str)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        char c2 = 0;
        int i3 = 0;
        while (i2 < str.length()) {
            char charAt = str.charAt(i2);
            if (charAt != ',') {
                if (charAt != '[') {
                    if (charAt != ']') {
                        if (charAt != '{') {
                            if (charAt != '}') {
                                sb.append(charAt);
                            }
                        }
                    }
                    i3--;
                    addIndentBlank(sb, i3);
                    sb.append(charAt);
                }
                sb.append(charAt);
                i3++;
                addIndentBlank(sb, i3);
            } else {
                sb.append(charAt);
                if (c2 != '\\') {
                    addIndentBlank(sb, i3);
                }
            }
            i2++;
            c2 = charAt;
        }
        return sb.toString();
    }
}
