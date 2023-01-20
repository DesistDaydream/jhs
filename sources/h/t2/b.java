package h.t2;

import h.k2.v.f0;
import h.p0;
import h.q0;
import h.s0;
import h.x1;
import java.util.Locale;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.text.CharCategory;
import kotlin.text.CharDirectionality;

@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u001a\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0001\u001a\u0018\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0000\u001a\r\u0010\u000e\u001a\u00020\u000f*\u00020\u0002H\u0087\b\u001a\r\u0010\u0010\u001a\u00020\u000f*\u00020\u0002H\u0087\b\u001a\r\u0010\u0011\u001a\u00020\u000f*\u00020\u0002H\u0087\b\u001a\r\u0010\u0012\u001a\u00020\u000f*\u00020\u0002H\u0087\b\u001a\r\u0010\u0013\u001a\u00020\u000f*\u00020\u0002H\u0087\b\u001a\r\u0010\u0014\u001a\u00020\u000f*\u00020\u0002H\u0087\b\u001a\r\u0010\u0015\u001a\u00020\u000f*\u00020\u0002H\u0087\b\u001a\r\u0010\u0016\u001a\u00020\u000f*\u00020\u0002H\u0087\b\u001a\r\u0010\u0017\u001a\u00020\u000f*\u00020\u0002H\u0087\b\u001a\r\u0010\u0018\u001a\u00020\u000f*\u00020\u0002H\u0087\b\u001a\r\u0010\u0019\u001a\u00020\u000f*\u00020\u0002H\u0087\b\u001a\r\u0010\u001a\u001a\u00020\u000f*\u00020\u0002H\u0087\b\u001a\r\u0010\u001b\u001a\u00020\u000f*\u00020\u0002H\u0087\b\u001a\n\u0010\u001c\u001a\u00020\u000f*\u00020\u0002\u001a\r\u0010\u001d\u001a\u00020\u001e*\u00020\u0002H\u0087\b\u001a\u0014\u0010\u001d\u001a\u00020\u001e*\u00020\u00022\u0006\u0010\u001f\u001a\u00020 H\u0007\u001a\r\u0010!\u001a\u00020\u0002*\u00020\u0002H\u0087\b\u001a\u0014\u0010\"\u001a\u00020\u001e*\u00020\u00022\u0006\u0010\u001f\u001a\u00020 H\u0007\u001a\r\u0010#\u001a\u00020\u0002*\u00020\u0002H\u0087\b\u001a\r\u0010$\u001a\u00020\u0002*\u00020\u0002H\u0087\b\u001a\r\u0010%\u001a\u00020\u0002*\u00020\u0002H\u0087\b\u001a\r\u0010&\u001a\u00020\u0002*\u00020\u0002H\u0087\b\u001a\r\u0010'\u001a\u00020\u001e*\u00020\u0002H\u0087\b\u001a\u0014\u0010'\u001a\u00020\u001e*\u00020\u00022\u0006\u0010\u001f\u001a\u00020 H\u0007\u001a\r\u0010(\u001a\u00020\u0002*\u00020\u0002H\u0087\b\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0015\u0010\u0005\u001a\u00020\u0006*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006)"}, d2 = {"category", "Lkotlin/text/CharCategory;", "", "getCategory", "(C)Lkotlin/text/CharCategory;", "directionality", "Lkotlin/text/CharDirectionality;", "getDirectionality", "(C)Lkotlin/text/CharDirectionality;", "checkRadix", "", "radix", "digitOf", "char", "isDefined", "", "isDigit", "isHighSurrogate", "isISOControl", "isIdentifierIgnorable", "isJavaIdentifierPart", "isJavaIdentifierStart", "isLetter", "isLetterOrDigit", "isLowSurrogate", "isLowerCase", "isTitleCase", "isUpperCase", "isWhitespace", "lowercase", "", "locale", "Ljava/util/Locale;", "lowercaseChar", "titlecase", "titlecaseChar", "toLowerCase", "toTitleCase", "toUpperCase", "uppercase", "uppercaseChar", "kotlin-stdlib"}, k = 5, mv = {1, 5, 1}, xi = 1, xs = "kotlin/text/CharsKt")
/* loaded from: classes4.dex */
public class b {
    @h.g2.f
    @x1(markerClass = {h.o.class})
    @s0(version = "1.5")
    private static final String A(char c2) {
        String valueOf = String.valueOf(c2);
        Objects.requireNonNull(valueOf, "null cannot be cast to non-null type java.lang.String");
        return valueOf.toUpperCase(Locale.ROOT);
    }

    @x1(markerClass = {h.o.class})
    @s0(version = "1.5")
    @k.e.a.d
    public static final String B(char c2, @k.e.a.d Locale locale) {
        String valueOf = String.valueOf(c2);
        Objects.requireNonNull(valueOf, "null cannot be cast to non-null type java.lang.String");
        return valueOf.toUpperCase(locale);
    }

    @h.g2.f
    @x1(markerClass = {h.o.class})
    @s0(version = "1.5")
    private static final char C(char c2) {
        return Character.toUpperCase(c2);
    }

    @p0
    public static final int a(int i2) {
        if (2 > i2 || 36 < i2) {
            throw new IllegalArgumentException("radix " + i2 + " was not in valid range " + new h.o2.k(2, 36));
        }
        return i2;
    }

    public static final int b(char c2, int i2) {
        return Character.digit((int) c2, i2);
    }

    @k.e.a.d
    public static final CharCategory c(char c2) {
        return CharCategory.Companion.a(Character.getType(c2));
    }

    @k.e.a.d
    public static final CharDirectionality d(char c2) {
        return CharDirectionality.Companion.b(Character.getDirectionality(c2));
    }

    @h.g2.f
    private static final boolean e(char c2) {
        return Character.isDefined(c2);
    }

    @h.g2.f
    private static final boolean f(char c2) {
        return Character.isDigit(c2);
    }

    @h.g2.f
    private static final boolean g(char c2) {
        return Character.isHighSurrogate(c2);
    }

    @h.g2.f
    private static final boolean h(char c2) {
        return Character.isISOControl(c2);
    }

    @h.g2.f
    private static final boolean i(char c2) {
        return Character.isIdentifierIgnorable(c2);
    }

    @h.g2.f
    private static final boolean j(char c2) {
        return Character.isJavaIdentifierPart(c2);
    }

    @h.g2.f
    private static final boolean k(char c2) {
        return Character.isJavaIdentifierStart(c2);
    }

    @h.g2.f
    private static final boolean l(char c2) {
        return Character.isLetter(c2);
    }

    @h.g2.f
    private static final boolean m(char c2) {
        return Character.isLetterOrDigit(c2);
    }

    @h.g2.f
    private static final boolean n(char c2) {
        return Character.isLowSurrogate(c2);
    }

    @h.g2.f
    private static final boolean o(char c2) {
        return Character.isLowerCase(c2);
    }

    @h.g2.f
    private static final boolean p(char c2) {
        return Character.isTitleCase(c2);
    }

    @h.g2.f
    private static final boolean q(char c2) {
        return Character.isUpperCase(c2);
    }

    public static final boolean r(char c2) {
        return Character.isWhitespace(c2) || Character.isSpaceChar(c2);
    }

    @h.g2.f
    @x1(markerClass = {h.o.class})
    @s0(version = "1.5")
    private static final String s(char c2) {
        String valueOf = String.valueOf(c2);
        Objects.requireNonNull(valueOf, "null cannot be cast to non-null type java.lang.String");
        return valueOf.toLowerCase(Locale.ROOT);
    }

    @x1(markerClass = {h.o.class})
    @s0(version = "1.5")
    @k.e.a.d
    public static final String t(char c2, @k.e.a.d Locale locale) {
        String valueOf = String.valueOf(c2);
        Objects.requireNonNull(valueOf, "null cannot be cast to non-null type java.lang.String");
        return valueOf.toLowerCase(locale);
    }

    @h.g2.f
    @x1(markerClass = {h.o.class})
    @s0(version = "1.5")
    private static final char u(char c2) {
        return Character.toLowerCase(c2);
    }

    @x1(markerClass = {h.o.class})
    @s0(version = "1.5")
    @k.e.a.d
    public static final String v(char c2, @k.e.a.d Locale locale) {
        String B = B(c2, locale);
        if (B.length() <= 1) {
            String valueOf = String.valueOf(c2);
            Objects.requireNonNull(valueOf, "null cannot be cast to non-null type java.lang.String");
            return f0.g(B, valueOf.toUpperCase(Locale.ROOT)) ^ true ? B : String.valueOf(Character.toTitleCase(c2));
        } else if (c2 == 329) {
            return B;
        } else {
            char charAt = B.charAt(0);
            Objects.requireNonNull(B, "null cannot be cast to non-null type java.lang.String");
            String substring = B.substring(1);
            Objects.requireNonNull(substring, "null cannot be cast to non-null type java.lang.String");
            String lowerCase = substring.toLowerCase(Locale.ROOT);
            return String.valueOf(charAt) + lowerCase;
        }
    }

    @h.g2.f
    @x1(markerClass = {h.o.class})
    @s0(version = "1.5")
    private static final char w(char c2) {
        return Character.toTitleCase(c2);
    }

    @h.g2.f
    @h.j(warningSince = "1.5")
    @h.i(message = "Use lowercaseChar() instead.", replaceWith = @q0(expression = "lowercaseChar()", imports = {}))
    private static final char x(char c2) {
        return Character.toLowerCase(c2);
    }

    @h.g2.f
    @h.j(warningSince = "1.5")
    @h.i(message = "Use titlecaseChar() instead.", replaceWith = @q0(expression = "titlecaseChar()", imports = {}))
    private static final char y(char c2) {
        return Character.toTitleCase(c2);
    }

    @h.g2.f
    @h.j(warningSince = "1.5")
    @h.i(message = "Use uppercaseChar() instead.", replaceWith = @q0(expression = "uppercaseChar()", imports = {}))
    private static final char z(char c2) {
        return Character.toUpperCase(c2);
    }
}
