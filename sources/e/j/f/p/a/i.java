package e.j.f.p.a;

import androidx.core.net.MailTo;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Map;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public final class i extends t {

    /* renamed from: f */
    private static final Pattern f11424f = Pattern.compile(Constants.ACCEPT_TIME_SEPARATOR_SP);

    @Override // e.j.f.p.a.t
    /* renamed from: q */
    public h k(e.j.f.k kVar) {
        String[] strArr;
        String[] strArr2;
        String[] strArr3;
        String str;
        String str2;
        String str3;
        String c2 = t.c(kVar);
        if (!c2.startsWith(MailTo.MAILTO_SCHEME) && !c2.startsWith("MAILTO:")) {
            if (j.s(c2)) {
                return new h(c2);
            }
            return null;
        }
        String substring = c2.substring(7);
        int indexOf = substring.indexOf(63);
        if (indexOf >= 0) {
            substring = substring.substring(0, indexOf);
        }
        try {
            String p = t.p(substring);
            String[] split = !p.isEmpty() ? f11424f.split(p) : null;
            Map<String, String> m2 = t.m(c2);
            if (m2 != null) {
                if (split == null && (str3 = m2.get("to")) != null) {
                    split = f11424f.split(str3);
                }
                String str4 = m2.get("cc");
                String[] split2 = str4 != null ? f11424f.split(str4) : null;
                String str5 = m2.get("bcc");
                String[] split3 = str5 != null ? f11424f.split(str5) : null;
                str2 = m2.get("body");
                strArr = split;
                strArr3 = split3;
                strArr2 = split2;
                str = m2.get("subject");
            } else {
                strArr = split;
                strArr2 = null;
                strArr3 = null;
                str = null;
                str2 = null;
            }
            return new h(strArr, strArr2, strArr3, str, str2);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }
}
