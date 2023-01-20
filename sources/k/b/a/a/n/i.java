package k.b.a.a.n;

import java.util.Locale;
import org.apache.commons.codec.EncoderException;

/* loaded from: classes4.dex */
public class i implements k.b.a.a.i {
    private static final String b = "AEIOU";

    /* renamed from: c  reason: collision with root package name */
    private static final String f16174c = "EIY";

    /* renamed from: d  reason: collision with root package name */
    private static final String f16175d = "CSPTG";
    private int a = 4;

    private boolean b(int i2, int i3) {
        return i3 + 1 == i2;
    }

    private boolean d(StringBuilder sb, int i2, char c2) {
        return i2 >= 0 && i2 < sb.length() - 1 && sb.charAt(i2 + 1) == c2;
    }

    private boolean e(StringBuilder sb, int i2, char c2) {
        return i2 > 0 && i2 < sb.length() && sb.charAt(i2 - 1) == c2;
    }

    private boolean g(StringBuilder sb, int i2) {
        return b.indexOf(sb.charAt(i2)) >= 0;
    }

    private boolean i(StringBuilder sb, int i2, String str) {
        if (i2 < 0 || (str.length() + i2) - 1 >= sb.length()) {
            return false;
        }
        return sb.substring(i2, str.length() + i2).equals(str);
    }

    public int a() {
        return this.a;
    }

    public boolean c(String str, String str2) {
        return h(str).equals(h(str2));
    }

    @Override // k.b.a.a.f
    public Object encode(Object obj) throws EncoderException {
        if (obj instanceof String) {
            return h((String) obj);
        }
        throw new EncoderException("Parameter supplied to Metaphone encode is not of type java.lang.String");
    }

    @Override // k.b.a.a.i
    public String f(String str) {
        return h(str);
    }

    public String h(String str) {
        int length;
        if (str == null || (length = str.length()) == 0) {
            return "";
        }
        if (length == 1) {
            return str.toUpperCase(Locale.ENGLISH);
        }
        char[] charArray = str.toUpperCase(Locale.ENGLISH).toCharArray();
        StringBuilder sb = new StringBuilder(40);
        StringBuilder sb2 = new StringBuilder(10);
        int i2 = 0;
        char c2 = charArray[0];
        if (c2 != 'A') {
            if (c2 == 'G' || c2 == 'K' || c2 == 'P') {
                if (charArray[1] == 'N') {
                    sb.append(charArray, 1, charArray.length - 1);
                } else {
                    sb.append(charArray);
                }
            } else if (c2 != 'W') {
                if (c2 != 'X') {
                    sb.append(charArray);
                } else {
                    charArray[0] = 'S';
                    sb.append(charArray);
                }
            } else if (charArray[1] == 'R') {
                sb.append(charArray, 1, charArray.length - 1);
            } else if (charArray[1] == 'H') {
                sb.append(charArray, 1, charArray.length - 1);
                sb.setCharAt(0, 'W');
            } else {
                sb.append(charArray);
            }
        } else if (charArray[1] == 'E') {
            sb.append(charArray, 1, charArray.length - 1);
        } else {
            sb.append(charArray);
        }
        int length2 = sb.length();
        while (sb2.length() < a() && i2 < length2) {
            char charAt = sb.charAt(i2);
            if (charAt == 'C' || !e(sb, i2, charAt)) {
                switch (charAt) {
                    case 'A':
                    case 'E':
                    case 'I':
                    case 'O':
                    case 'U':
                        if (i2 == 0) {
                            sb2.append(charAt);
                            break;
                        }
                        break;
                    case 'B':
                        if (!e(sb, i2, 'M') || !b(length2, i2)) {
                            sb2.append(charAt);
                            break;
                        }
                        break;
                    case 'C':
                        if (!e(sb, i2, 'S') || b(length2, i2) || f16174c.indexOf(sb.charAt(i2 + 1)) < 0) {
                            if (i(sb, i2, "CIA")) {
                                sb2.append('X');
                                break;
                            } else if (!b(length2, i2) && f16174c.indexOf(sb.charAt(i2 + 1)) >= 0) {
                                sb2.append('S');
                                break;
                            } else if (e(sb, i2, 'S') && d(sb, i2, 'H')) {
                                sb2.append('K');
                                break;
                            } else if (d(sb, i2, 'H')) {
                                if (i2 == 0 && length2 >= 3 && g(sb, 2)) {
                                    sb2.append('K');
                                    break;
                                } else {
                                    sb2.append('X');
                                    break;
                                }
                            } else {
                                sb2.append('K');
                                break;
                            }
                        }
                        break;
                    case 'D':
                        if (!b(length2, i2 + 1) && d(sb, i2, 'G')) {
                            int i3 = i2 + 2;
                            if (f16174c.indexOf(sb.charAt(i3)) >= 0) {
                                sb2.append('J');
                                i2 = i3;
                                break;
                            }
                        }
                        sb2.append('T');
                        break;
                    case 'F':
                    case 'J':
                    case 'L':
                    case 'M':
                    case 'N':
                    case 'R':
                        sb2.append(charAt);
                        break;
                    case 'G':
                        int i4 = i2 + 1;
                        if ((!b(length2, i4) || !d(sb, i2, 'H')) && ((b(length2, i4) || !d(sb, i2, 'H') || g(sb, i2 + 2)) && (i2 <= 0 || (!i(sb, i2, "GN") && !i(sb, i2, "GNED"))))) {
                            boolean e2 = e(sb, i2, 'G');
                            if (!b(length2, i2) && f16174c.indexOf(sb.charAt(i4)) >= 0 && !e2) {
                                sb2.append('J');
                                break;
                            } else {
                                sb2.append('K');
                                break;
                            }
                        }
                        break;
                    case 'H':
                        if (!b(length2, i2) && ((i2 <= 0 || f16175d.indexOf(sb.charAt(i2 - 1)) < 0) && g(sb, i2 + 1))) {
                            sb2.append('H');
                            break;
                        }
                        break;
                    case 'K':
                        if (i2 > 0) {
                            if (!e(sb, i2, 'C')) {
                                sb2.append(charAt);
                                break;
                            }
                        } else {
                            sb2.append(charAt);
                            break;
                        }
                        break;
                    case 'P':
                        if (d(sb, i2, 'H')) {
                            sb2.append('F');
                            break;
                        } else {
                            sb2.append(charAt);
                            break;
                        }
                    case 'Q':
                        sb2.append('K');
                        break;
                    case 'S':
                        if (!i(sb, i2, "SH") && !i(sb, i2, "SIO") && !i(sb, i2, "SIA")) {
                            sb2.append('S');
                            break;
                        } else {
                            sb2.append('X');
                            break;
                        }
                        break;
                    case 'T':
                        if (!i(sb, i2, "TIA") && !i(sb, i2, "TIO")) {
                            if (!i(sb, i2, "TCH")) {
                                if (i(sb, i2, "TH")) {
                                    sb2.append('0');
                                    break;
                                } else {
                                    sb2.append('T');
                                    break;
                                }
                            }
                        } else {
                            sb2.append('X');
                            break;
                        }
                        break;
                    case 'V':
                        sb2.append('F');
                        break;
                    case 'W':
                    case 'Y':
                        if (!b(length2, i2) && g(sb, i2 + 1)) {
                            sb2.append(charAt);
                            break;
                        }
                        break;
                    case 'X':
                        sb2.append('K');
                        sb2.append('S');
                        break;
                    case 'Z':
                        sb2.append('S');
                        break;
                }
                i2++;
            } else {
                i2++;
            }
            if (sb2.length() > a()) {
                sb2.setLength(a());
            }
        }
        return sb2.toString();
    }

    public void j(int i2) {
        this.a = i2;
    }
}
