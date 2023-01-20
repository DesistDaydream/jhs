package h.t2;

import java.util.Locale;
import java.util.Objects;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\f\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"titlecaseImpl", "", "", "kotlin-stdlib"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes4.dex */
public final class a0 {
    @k.e.a.d
    public static final String a(char c2) {
        String valueOf = String.valueOf(c2);
        Objects.requireNonNull(valueOf, "null cannot be cast to non-null type java.lang.String");
        Locale locale = Locale.ROOT;
        String upperCase = valueOf.toUpperCase(locale);
        if (upperCase.length() > 1) {
            if (c2 == 329) {
                return upperCase;
            }
            char charAt = upperCase.charAt(0);
            Objects.requireNonNull(upperCase, "null cannot be cast to non-null type java.lang.String");
            String substring = upperCase.substring(1);
            Objects.requireNonNull(substring, "null cannot be cast to non-null type java.lang.String");
            String lowerCase = substring.toLowerCase(locale);
            return String.valueOf(charAt) + lowerCase;
        }
        return String.valueOf(Character.toTitleCase(c2));
    }
}
