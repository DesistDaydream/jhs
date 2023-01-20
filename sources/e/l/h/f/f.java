package e.l.h.f;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.Base64;
import androidx.annotation.ColorRes;
import androidx.exifinterface.media.ExifInterface;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.vector.util.Res;
import e.t.l.t;
import h.k2.v.f0;
import h.t2.u;
import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.text.StringsKt__StringsKt;

@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\u0012\u0010\u0000\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001\u001a\n\u0010\u0003\u001a\u00020\u0001*\u00020\u0001\u001a\f\u0010\u0004\u001a\u00020\u0005*\u0004\u0018\u00010\u0006\u001a\f\u0010\u0007\u001a\u00020\b*\u0004\u0018\u00010\u0006\u001a+\u0010\t\u001a\u0002H\n\"\b\b\u0000\u0010\n*\u00020\u000b*\u0002H\n2\u0006\u0010\u0002\u001a\u00020\u00012\b\b\u0001\u0010\f\u001a\u00020\b¢\u0006\u0002\u0010\r\u001a\u001c\u0010\t\u001a\u00020\u000e*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\b\b\u0001\u0010\f\u001a\u00020\b\u001a\n\u0010\u000f\u001a\u00020\u0010*\u00020\u0001\u001a\n\u0010\u0011\u001a\u00020\u0001*\u00020\u0001¨\u0006\u0012"}, d2 = {"escapeExprSpecialWord", "", "keyword", "addComma", "calculateAccurateLength", "", "", "calculateLength", "", "highlight", ExifInterface.GPS_DIRECTION_TRUE, "Landroid/text/Spannable;", "colorId", "(Landroid/text/Spannable;Ljava/lang/String;I)Landroid/text/Spannable;", "Landroid/text/SpannableString;", "isDoubleLength", "", "toBase64", "lib-base_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public final class f {
    @k.e.a.d
    public static final String a(@k.e.a.d String str) {
        try {
            boolean z = true;
            if (!(str.length() == 0)) {
                if (Double.parseDouble(str) != 0.0d) {
                    z = false;
                }
                if (!z) {
                    str = new DecimalFormat("##,###.00").format(Double.parseDouble(str));
                    return str;
                }
            }
            return "0.00";
        } catch (Exception unused) {
            return str;
        }
    }

    public static final float b(@k.e.a.e CharSequence charSequence) {
        int length;
        float f2;
        float f3 = 0.0f;
        if (charSequence != null) {
            int i2 = 0;
            if (!(charSequence.length() == 0) && charSequence.length() - 1 >= 0) {
                while (true) {
                    int i3 = i2 + 1;
                    String obj = charSequence.subSequence(i2, i3).toString();
                    if (t.c(obj) || t.d(obj)) {
                        f2 = 1.0f;
                    } else {
                        f2 = (t.k(obj) || t.g(obj)) ? 0.5f : obj.length();
                    }
                    f3 += f2;
                    if (i3 > length) {
                        break;
                    }
                    i2 = i3;
                }
            }
        }
        return f3;
    }

    public static final int c(@k.e.a.e CharSequence charSequence) {
        float f2;
        int i2 = 0;
        if (charSequence != null) {
            if (!(charSequence.length() == 0)) {
                float f3 = 0.0f;
                int length = charSequence.length() - 1;
                if (length >= 0) {
                    while (true) {
                        int i3 = i2 + 1;
                        String obj = charSequence.subSequence(i2, i3).toString();
                        if (t.c(obj) || t.d(obj)) {
                            f2 = 1.0f;
                        } else {
                            f2 = (t.k(obj) || t.g(obj)) ? 0.5f : obj.length();
                        }
                        f3 += f2;
                        if (i3 > length) {
                            break;
                        }
                        i2 = i3;
                    }
                }
                return h.l2.d.H0(f3);
            }
        }
        return 0;
    }

    @k.e.a.e
    public static final String d(@k.e.a.e String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        String[] strArr = {"\\", "$", "(", ")", "*", "+", ".", "[", "]", "?", "^", "{", "}", HiAnalyticsConstant.REPORT_VAL_SEPARATOR};
        String str2 = str;
        int i2 = 0;
        while (i2 < 14) {
            String str3 = strArr[i2];
            int i3 = i2 + 1;
            if (StringsKt__StringsKt.V2(str, str3, false, 2, null)) {
                str2 = u.k2(str, str3, f0.C("\\", str3), false, 4, null);
            }
            i2 = i3;
        }
        return str2;
    }

    @k.e.a.d
    public static final <T extends Spannable> T e(@k.e.a.d T t, @k.e.a.d String str, @ColorRes int i2) {
        String d2 = d(str);
        String d3 = d(t.toString());
        if (d3 != null && d2 != null && StringsKt__StringsKt.S2(d3, d2, true)) {
            if (d2.length() > 0) {
                try {
                    Matcher matcher = Pattern.compile(d2, 2).matcher(t);
                    while (matcher.find()) {
                        int start = matcher.start();
                        int end = matcher.end();
                        if (start >= 0 && start <= end) {
                            t.setSpan(new ForegroundColorSpan(Res.k(i2)), start, end, 33);
                        }
                    }
                } catch (Exception e2) {
                    e.l.h.k.b.a.b("highlight", String.valueOf(e2.getMessage()));
                }
            }
        }
        return t;
    }

    @k.e.a.d
    public static final SpannableString f(@k.e.a.d String str, @k.e.a.d String str2, @ColorRes int i2) {
        return (SpannableString) e(new SpannableString(str), str2, i2);
    }

    public static final boolean g(@k.e.a.d String str) {
        return Pattern.compile("[^\\x00-\\xff]").matcher(str).find();
    }

    @k.e.a.d
    public static final String h(@k.e.a.d String str) {
        return Base64.encodeToString(str.getBytes(h.t2.d.a), 2);
    }
}
