package e.j.f.p.a;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public final class n extends t {

    /* renamed from: f  reason: collision with root package name */
    private static final Pattern f11447f = Pattern.compile("geo:([\\-0-9.]+),([\\-0-9.]+)(?:,([\\-0-9.]+))?(?:\\?(.*))?", 2);

    @Override // e.j.f.p.a.t
    /* renamed from: q */
    public m k(e.j.f.k kVar) {
        Matcher matcher = f11447f.matcher(t.c(kVar));
        if (matcher.matches()) {
            String group = matcher.group(4);
            try {
                double parseDouble = Double.parseDouble(matcher.group(1));
                if (parseDouble <= 90.0d && parseDouble >= -90.0d) {
                    double parseDouble2 = Double.parseDouble(matcher.group(2));
                    if (parseDouble2 <= 180.0d && parseDouble2 >= -180.0d) {
                        double d2 = 0.0d;
                        if (matcher.group(3) != null) {
                            double parseDouble3 = Double.parseDouble(matcher.group(3));
                            if (parseDouble3 < 0.0d) {
                                return null;
                            }
                            d2 = parseDouble3;
                        }
                        return new m(parseDouble, parseDouble2, d2, group);
                    }
                }
            } catch (NumberFormatException unused) {
            }
            return null;
        }
        return null;
    }
}
