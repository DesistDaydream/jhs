package e.j.f.p.a;

import androidx.core.net.MailTo;
import java.util.List;

/* loaded from: classes2.dex */
public final class f0 extends t {
    private static String q(CharSequence charSequence, String str, boolean z) {
        List<String> t = e0.t(charSequence, str, z, false);
        if (t == null || t.isEmpty()) {
            return null;
        }
        return t.get(0);
    }

    private static String[] r(CharSequence charSequence, String str, boolean z) {
        List<List<String>> u = e0.u(charSequence, str, z, false);
        if (u == null || u.isEmpty()) {
            return null;
        }
        int size = u.size();
        String[] strArr = new String[size];
        for (int i2 = 0; i2 < size; i2++) {
            strArr[i2] = u.get(i2).get(0);
        }
        return strArr;
    }

    private static String t(String str) {
        return str != null ? (str.startsWith(MailTo.MAILTO_SCHEME) || str.startsWith("MAILTO:")) ? str.substring(7) : str : str;
    }

    @Override // e.j.f.p.a.t
    /* renamed from: s */
    public g k(e.j.f.k kVar) {
        double parseDouble;
        String c2 = t.c(kVar);
        if (c2.indexOf("BEGIN:VEVENT") < 0) {
            return null;
        }
        String q = q("SUMMARY", c2, true);
        String q2 = q("DTSTART", c2, true);
        if (q2 == null) {
            return null;
        }
        String q3 = q("DTEND", c2, true);
        String q4 = q("DURATION", c2, true);
        String q5 = q(e.j.a.b.i.a.O, c2, true);
        String t = t(q("ORGANIZER", c2, true));
        String[] r = r("ATTENDEE", c2, true);
        if (r != null) {
            for (int i2 = 0; i2 < r.length; i2++) {
                r[i2] = t(r[i2]);
            }
        }
        String q6 = q("DESCRIPTION", c2, true);
        String q7 = q("GEO", c2, true);
        double d2 = Double.NaN;
        if (q7 == null) {
            parseDouble = Double.NaN;
        } else {
            int indexOf = q7.indexOf(59);
            if (indexOf < 0) {
                return null;
            }
            try {
                d2 = Double.parseDouble(q7.substring(0, indexOf));
                parseDouble = Double.parseDouble(q7.substring(indexOf + 1));
            } catch (NumberFormatException | IllegalArgumentException unused) {
                return null;
            }
        }
        return new g(q, q2, q3, q4, q5, t, r, q6, d2, parseDouble);
    }
}
