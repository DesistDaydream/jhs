package k.b.a.a.n;

import androidx.exifinterface.media.ExifInterface;
import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.qq.e.comm.managers.setting.GlobalSetting;
import e.t.u.b0;
import java.util.Locale;
import org.apache.commons.codec.EncoderException;

/* loaded from: classes4.dex */
public class h implements k.b.a.a.i {
    private static final String a = " ";
    private static final String b = "";

    /* renamed from: c  reason: collision with root package name */
    private static final int f16163c = 1;

    /* renamed from: d  reason: collision with root package name */
    private static final int f16164d = 2;

    /* renamed from: e  reason: collision with root package name */
    private static final int f16165e = 3;

    /* renamed from: f  reason: collision with root package name */
    private static final int f16166f = 4;

    /* renamed from: g  reason: collision with root package name */
    private static final int f16167g = 5;

    /* renamed from: h  reason: collision with root package name */
    private static final int f16168h = 6;

    /* renamed from: i  reason: collision with root package name */
    private static final int f16169i = 7;

    /* renamed from: j  reason: collision with root package name */
    private static final int f16170j = 11;

    /* renamed from: k  reason: collision with root package name */
    private static final int f16171k = 12;

    /* renamed from: l  reason: collision with root package name */
    private static final String f16172l = "AaEeIiOoUuAaEeIiOoUuYyAaEeIiOoUuYyAaOoNnAaEeIiOoUuYyAaCcOoUu";

    /* renamed from: m  reason: collision with root package name */
    private static final String f16173m = "ÀàÈèÌìÒòÙùÁáÉéÍíÓóÚúÝýÂâÊêÎîÔôÛûŶŷÃãÕõÑñÄäËëÏïÖöÜüŸÿÅåÇçŐőŰű";
    private static final String[] n = {"BB", "CC", "DD", "FF", "GG", "HH", "JJ", "KK", "LL", b0.a.f14654e, "NN", "PP", "QQ", "RR", "SS", GlobalSetting.TT_SDK_WRAPPER, "VV", "WW", "XX", "YY", "ZZ"};

    public String a(String str) {
        String upperCase = str.toUpperCase(Locale.ENGLISH);
        String[] strArr = {"\\-", "[&]", "\\'", "\\.", "[\\,]"};
        for (int i2 = 0; i2 < 5; i2++) {
            upperCase = upperCase.replaceAll(strArr[i2], "");
        }
        return h(upperCase).replaceAll("\\s+", "");
    }

    public String b(String str) {
        int length = str.length();
        if (length > 6) {
            String substring = str.substring(0, 3);
            String substring2 = str.substring(length - 3, length);
            return substring + substring2;
        }
        return str;
    }

    public int c(int i2) {
        if (i2 <= 4) {
            return 5;
        }
        if (i2 <= 7) {
            return 4;
        }
        if (i2 <= 11) {
            return 3;
        }
        return i2 == 12 ? 2 : 1;
    }

    public boolean d(String str, String str2) {
        if (str == null || "".equalsIgnoreCase(str) || " ".equalsIgnoreCase(str) || str2 == null || "".equalsIgnoreCase(str2) || " ".equalsIgnoreCase(str2) || str.length() == 1 || str2.length() == 1) {
            return false;
        }
        if (str.equalsIgnoreCase(str2)) {
            return true;
        }
        String a2 = a(str);
        String a3 = a(str2);
        String j2 = j(a2);
        String j3 = j(a3);
        String i2 = i(j2);
        String i3 = i(j3);
        String b2 = b(i2);
        String b3 = b(i3);
        if (Math.abs(b2.length() - b3.length()) >= 3) {
            return false;
        }
        return g(b2, b3) >= c(Math.abs(b2.length() + b3.length()));
    }

    public boolean e(String str) {
        return str.equalsIgnoreCase(ExifInterface.LONGITUDE_EAST) || str.equalsIgnoreCase(ExifInterface.GPS_MEASUREMENT_IN_PROGRESS) || str.equalsIgnoreCase("O") || str.equalsIgnoreCase(ExpandableTextView.P) || str.equalsIgnoreCase("U");
    }

    @Override // k.b.a.a.f
    public final Object encode(Object obj) throws EncoderException {
        if (obj instanceof String) {
            return f((String) obj);
        }
        throw new EncoderException("Parameter supplied to Match Rating Approach encoder is not of type java.lang.String");
    }

    @Override // k.b.a.a.i
    public final String f(String str) {
        return (str == null || "".equalsIgnoreCase(str) || " ".equalsIgnoreCase(str) || str.length() == 1) ? "" : b(i(j(a(str))));
    }

    public int g(String str, String str2) {
        char[] charArray = str.toCharArray();
        char[] charArray2 = str2.toCharArray();
        int length = str.length() - 1;
        int length2 = str2.length() - 1;
        int i2 = 0;
        while (i2 < charArray.length && i2 <= length2) {
            int i3 = i2 + 1;
            String substring = str.substring(i2, i3);
            int i4 = length - i2;
            String substring2 = str.substring(i4, i4 + 1);
            String substring3 = str2.substring(i2, i3);
            int i5 = length2 - i2;
            String substring4 = str2.substring(i5, i5 + 1);
            if (substring.equals(substring3)) {
                charArray[i2] = ' ';
                charArray2[i2] = ' ';
            }
            if (substring2.equals(substring4)) {
                charArray[i4] = ' ';
                charArray2[i5] = ' ';
            }
            i2 = i3;
        }
        String replaceAll = new String(charArray).replaceAll("\\s+", "");
        String replaceAll2 = new String(charArray2).replaceAll("\\s+", "");
        if (replaceAll.length() > replaceAll2.length()) {
            return Math.abs(6 - replaceAll.length());
        }
        return Math.abs(6 - replaceAll2.length());
    }

    public String h(String str) {
        if (str == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            int indexOf = f16173m.indexOf(charAt);
            if (indexOf > -1) {
                sb.append(f16172l.charAt(indexOf));
            } else {
                sb.append(charAt);
            }
        }
        return sb.toString();
    }

    public String i(String str) {
        String[] strArr;
        String upperCase = str.toUpperCase(Locale.ENGLISH);
        for (String str2 : n) {
            if (upperCase.contains(str2)) {
                upperCase = upperCase.replace(str2, str2.substring(0, 1));
            }
        }
        return upperCase;
    }

    public String j(String str) {
        String substring = str.substring(0, 1);
        String replaceAll = str.replaceAll(ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "").replaceAll(ExifInterface.LONGITUDE_EAST, "").replaceAll(ExpandableTextView.P, "").replaceAll("O", "").replaceAll("U", "").replaceAll("\\s{2,}\\b", " ");
        if (e(substring)) {
            return substring + replaceAll;
        }
        return replaceAll;
    }
}
