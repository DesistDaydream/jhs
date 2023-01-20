package h.t2;

import h.a2.l0;
import h.q0;
import h.s0;
import h.x1;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CodingErrorAction;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.text.StringsKt__StringsKt;

@Metadata(d1 = {"\u0000~\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\n\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0010\f\n\u0002\b\u0011\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\u001a\u0011\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\u0087\b\u001a\u0011\u0010\u0007\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0087\b\u001a\u0011\u0010\u0007\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\rH\u0087\b\u001a\u0019\u0010\u0007\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0087\b\u001a!\u0010\u0007\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0087\b\u001a)\u0010\u0007\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u000fH\u0087\b\u001a\u0011\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0014H\u0087\b\u001a!\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0087\b\u001a!\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0087\b\u001a\f\u0010\u0017\u001a\u00020\u0002*\u00020\u0002H\u0007\u001a\u0014\u0010\u0017\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0019H\u0007\u001a\u0015\u0010\u001a\u001a\u00020\u0011*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0011H\u0087\b\u001a\u0015\u0010\u001c\u001a\u00020\u0011*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0011H\u0087\b\u001a\u001d\u0010\u001d\u001a\u00020\u0011*\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020\u0011H\u0087\b\u001a\u001c\u0010 \u001a\u00020\u0011*\u00020\u00022\u0006\u0010!\u001a\u00020\u00022\b\b\u0002\u0010\"\u001a\u00020#\u001a\f\u0010$\u001a\u00020\u0002*\u00020\u0014H\u0007\u001a \u0010$\u001a\u00020\u0002*\u00020\u00142\b\b\u0002\u0010%\u001a\u00020\u00112\b\b\u0002\u0010\u001f\u001a\u00020\u0011H\u0007\u001a\u0019\u0010&\u001a\u00020#*\u0004\u0018\u00010'2\b\u0010!\u001a\u0004\u0018\u00010'H\u0087\u0004\u001a \u0010&\u001a\u00020#*\u0004\u0018\u00010'2\b\u0010!\u001a\u0004\u0018\u00010'2\u0006\u0010\"\u001a\u00020#H\u0007\u001a\u0015\u0010&\u001a\u00020#*\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0087\b\u001a\u0015\u0010&\u001a\u00020#*\u00020\u00022\u0006\u0010(\u001a\u00020'H\u0087\b\u001a\f\u0010)\u001a\u00020\u0002*\u00020\u0002H\u0007\u001a\u0014\u0010)\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0019H\u0007\u001a\f\u0010*\u001a\u00020\u0002*\u00020\rH\u0007\u001a*\u0010*\u001a\u00020\u0002*\u00020\r2\b\b\u0002\u0010%\u001a\u00020\u00112\b\b\u0002\u0010\u001f\u001a\u00020\u00112\b\b\u0002\u0010+\u001a\u00020#H\u0007\u001a\f\u0010,\u001a\u00020\r*\u00020\u0002H\u0007\u001a*\u0010,\u001a\u00020\r*\u00020\u00022\b\b\u0002\u0010%\u001a\u00020\u00112\b\b\u0002\u0010\u001f\u001a\u00020\u00112\b\b\u0002\u0010+\u001a\u00020#H\u0007\u001a\u001c\u0010-\u001a\u00020#*\u00020\u00022\u0006\u0010.\u001a\u00020\u00022\b\b\u0002\u0010\"\u001a\u00020#\u001a \u0010/\u001a\u00020#*\u0004\u0018\u00010\u00022\b\u0010!\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\"\u001a\u00020#\u001a2\u00100\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00192\u0016\u00101\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010302\"\u0004\u0018\u000103H\u0087\b¢\u0006\u0002\u00104\u001a6\u00100\u001a\u00020\u0002*\u00020\u00022\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0016\u00101\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010302\"\u0004\u0018\u000103H\u0087\b¢\u0006\u0004\b5\u00104\u001a*\u00100\u001a\u00020\u0002*\u00020\u00022\u0016\u00101\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010302\"\u0004\u0018\u000103H\u0087\b¢\u0006\u0002\u00106\u001a:\u00100\u001a\u00020\u0002*\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u00100\u001a\u00020\u00022\u0016\u00101\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010302\"\u0004\u0018\u000103H\u0087\b¢\u0006\u0002\u00107\u001a>\u00100\u001a\u00020\u0002*\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u00100\u001a\u00020\u00022\u0016\u00101\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010302\"\u0004\u0018\u000103H\u0087\b¢\u0006\u0004\b5\u00107\u001a2\u00100\u001a\u00020\u0002*\u00020\u00042\u0006\u00100\u001a\u00020\u00022\u0016\u00101\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010302\"\u0004\u0018\u000103H\u0087\b¢\u0006\u0002\u00108\u001a\r\u00109\u001a\u00020\u0002*\u00020\u0002H\u0087\b\u001a\n\u0010:\u001a\u00020#*\u00020'\u001a\r\u0010;\u001a\u00020\u0002*\u00020\u0002H\u0087\b\u001a\u0015\u0010;\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0019H\u0087\b\u001a\u001d\u0010<\u001a\u00020\u0011*\u00020\u00022\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020\u0011H\u0081\b\u001a\u001d\u0010<\u001a\u00020\u0011*\u00020\u00022\u0006\u0010@\u001a\u00020\u00022\u0006\u0010?\u001a\u00020\u0011H\u0081\b\u001a\u001d\u0010A\u001a\u00020\u0011*\u00020\u00022\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020\u0011H\u0081\b\u001a\u001d\u0010A\u001a\u00020\u0011*\u00020\u00022\u0006\u0010@\u001a\u00020\u00022\u0006\u0010?\u001a\u00020\u0011H\u0081\b\u001a\u001d\u0010B\u001a\u00020\u0011*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u00112\u0006\u0010C\u001a\u00020\u0011H\u0087\b\u001a4\u0010D\u001a\u00020#*\u00020'2\u0006\u0010E\u001a\u00020\u00112\u0006\u0010!\u001a\u00020'2\u0006\u0010F\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\"\u001a\u00020#\u001a4\u0010D\u001a\u00020#*\u00020\u00022\u0006\u0010E\u001a\u00020\u00112\u0006\u0010!\u001a\u00020\u00022\u0006\u0010F\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\"\u001a\u00020#\u001a\u0012\u0010G\u001a\u00020\u0002*\u00020'2\u0006\u0010H\u001a\u00020\u0011\u001a$\u0010I\u001a\u00020\u0002*\u00020\u00022\u0006\u0010J\u001a\u00020>2\u0006\u0010K\u001a\u00020>2\b\b\u0002\u0010\"\u001a\u00020#\u001a$\u0010I\u001a\u00020\u0002*\u00020\u00022\u0006\u0010L\u001a\u00020\u00022\u0006\u0010M\u001a\u00020\u00022\b\b\u0002\u0010\"\u001a\u00020#\u001a$\u0010N\u001a\u00020\u0002*\u00020\u00022\u0006\u0010J\u001a\u00020>2\u0006\u0010K\u001a\u00020>2\b\b\u0002\u0010\"\u001a\u00020#\u001a$\u0010N\u001a\u00020\u0002*\u00020\u00022\u0006\u0010L\u001a\u00020\u00022\u0006\u0010M\u001a\u00020\u00022\b\b\u0002\u0010\"\u001a\u00020#\u001a\"\u0010O\u001a\b\u0012\u0004\u0012\u00020\u00020P*\u00020'2\u0006\u0010Q\u001a\u00020R2\b\b\u0002\u0010S\u001a\u00020\u0011\u001a\u001c\u0010T\u001a\u00020#*\u00020\u00022\u0006\u0010U\u001a\u00020\u00022\b\b\u0002\u0010\"\u001a\u00020#\u001a$\u0010T\u001a\u00020#*\u00020\u00022\u0006\u0010U\u001a\u00020\u00022\u0006\u0010%\u001a\u00020\u00112\b\b\u0002\u0010\"\u001a\u00020#\u001a\u0015\u0010V\u001a\u00020\u0002*\u00020\u00022\u0006\u0010%\u001a\u00020\u0011H\u0087\b\u001a\u001d\u0010V\u001a\u00020\u0002*\u00020\u00022\u0006\u0010%\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020\u0011H\u0087\b\u001a\u0017\u0010W\u001a\u00020\r*\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0087\b\u001a\r\u0010X\u001a\u00020\u0014*\u00020\u0002H\u0087\b\u001a3\u0010X\u001a\u00020\u0014*\u00020\u00022\u0006\u0010Y\u001a\u00020\u00142\b\b\u0002\u0010Z\u001a\u00020\u00112\b\b\u0002\u0010%\u001a\u00020\u00112\b\b\u0002\u0010\u001f\u001a\u00020\u0011H\u0087\b\u001a \u0010X\u001a\u00020\u0014*\u00020\u00022\b\b\u0002\u0010%\u001a\u00020\u00112\b\b\u0002\u0010\u001f\u001a\u00020\u0011H\u0007\u001a\r\u0010[\u001a\u00020\u0002*\u00020\u0002H\u0087\b\u001a\u0015\u0010[\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0019H\u0087\b\u001a\u0017\u0010\\\u001a\u00020R*\u00020\u00022\b\b\u0002\u0010]\u001a\u00020\u0011H\u0087\b\u001a\r\u0010^\u001a\u00020\u0002*\u00020\u0002H\u0087\b\u001a\u0015\u0010^\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0019H\u0087\b\u001a\r\u0010_\u001a\u00020\u0002*\u00020\u0002H\u0087\b\u001a\u0015\u0010_\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0019H\u0087\b\"%\u0010\u0000\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003*\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006`"}, d2 = {"CASE_INSENSITIVE_ORDER", "Ljava/util/Comparator;", "", "Lkotlin/Comparator;", "Lkotlin/String$Companion;", "getCASE_INSENSITIVE_ORDER", "(Lkotlin/jvm/internal/StringCompanionObject;)Ljava/util/Comparator;", "String", "stringBuffer", "Ljava/lang/StringBuffer;", "stringBuilder", "Ljava/lang/StringBuilder;", "bytes", "", "charset", "Ljava/nio/charset/Charset;", "offset", "", "length", "chars", "", "codePoints", "", "capitalize", "locale", "Ljava/util/Locale;", "codePointAt", "index", "codePointBefore", "codePointCount", "beginIndex", "endIndex", "compareTo", "other", "ignoreCase", "", "concatToString", "startIndex", "contentEquals", "", "charSequence", "decapitalize", "decodeToString", "throwOnInvalidSequence", "encodeToByteArray", "endsWith", "suffix", "equals", "format", "args", "", "", "(Ljava/lang/String;Ljava/util/Locale;[Ljava/lang/Object;)Ljava/lang/String;", "formatNullable", "(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", "(Lkotlin/jvm/internal/StringCompanionObject;Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", "(Lkotlin/jvm/internal/StringCompanionObject;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", "intern", "isBlank", "lowercase", "nativeIndexOf", "ch", "", "fromIndex", "str", "nativeLastIndexOf", "offsetByCodePoints", "codePointOffset", "regionMatches", "thisOffset", "otherOffset", "repeat", "n", "replace", "oldChar", "newChar", "oldValue", "newValue", "replaceFirst", "split", "", "regex", "Ljava/util/regex/Pattern;", "limit", "startsWith", "prefix", "substring", "toByteArray", "toCharArray", "destination", "destinationOffset", "toLowerCase", "toPattern", "flags", "toUpperCase", "uppercase", "kotlin-stdlib"}, k = 5, mv = {1, 5, 1}, xi = 1, xs = "kotlin/text/StringsKt")
/* loaded from: classes4.dex */
public class u extends t {
    @h.j(warningSince = "1.5")
    @h.i(message = "Use replaceFirstChar instead.", replaceWith = @q0(expression = "replaceFirstChar { it.lowercase(Locale.getDefault()) }", imports = {"java.util.Locale"}))
    @k.e.a.d
    public static final String A1(@k.e.a.d String str) {
        if (!(str.length() > 0) || Character.isLowerCase(str.charAt(0))) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        String substring = str.substring(0, 1);
        Objects.requireNonNull(substring, "null cannot be cast to non-null type java.lang.String");
        sb.append(substring.toLowerCase());
        sb.append(str.substring(1));
        return sb.toString();
    }

    @x1(markerClass = {h.o.class})
    @s0(version = "1.4")
    @k.e.a.d
    public static final char[] A2(@k.e.a.d String str, int i2, int i3) {
        h.a2.c.a.a(i2, i3, str.length());
        char[] cArr = new char[i3 - i2];
        str.getChars(i2, i3, cArr, 0);
        return cArr;
    }

    @h.j(warningSince = "1.5")
    @h.i(message = "Use replaceFirstChar instead.", replaceWith = @q0(expression = "replaceFirstChar { it.lowercase(locale) }", imports = {}))
    @s0(version = "1.4")
    @h.g2.g
    @x1(markerClass = {h.o.class})
    @k.e.a.d
    public static final String B1(@k.e.a.d String str, @k.e.a.d Locale locale) {
        if (!(str.length() > 0) || Character.isLowerCase(str.charAt(0))) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        String substring = str.substring(0, 1);
        Objects.requireNonNull(substring, "null cannot be cast to non-null type java.lang.String");
        sb.append(substring.toLowerCase(locale));
        sb.append(str.substring(1));
        return sb.toString();
    }

    @h.g2.f
    private static final char[] B2(String str, char[] cArr, int i2, int i3, int i4) {
        Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
        str.getChars(i3, i4, cArr, i2);
        return cArr;
    }

    @x1(markerClass = {h.o.class})
    @s0(version = "1.4")
    @k.e.a.d
    public static final String C1(@k.e.a.d byte[] bArr) {
        return new String(bArr, d.a);
    }

    public static /* synthetic */ char[] C2(String str, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = str.length();
        }
        return A2(str, i2, i3);
    }

    @x1(markerClass = {h.o.class})
    @s0(version = "1.4")
    @k.e.a.d
    public static final String D1(@k.e.a.d byte[] bArr, int i2, int i3, boolean z) {
        h.a2.c.a.a(i2, i3, bArr.length);
        if (!z) {
            return new String(bArr, i2, i3 - i2, d.a);
        }
        return d.a.newDecoder().onMalformedInput(CodingErrorAction.REPORT).onUnmappableCharacter(CodingErrorAction.REPORT).decode(ByteBuffer.wrap(bArr, i2, i3 - i2)).toString();
    }

    public static /* synthetic */ char[] D2(String str, char[] cArr, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i2 = 0;
        }
        if ((i5 & 4) != 0) {
            i3 = 0;
        }
        if ((i5 & 8) != 0) {
            i4 = str.length();
        }
        Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
        str.getChars(i3, i4, cArr, i2);
        return cArr;
    }

    public static /* synthetic */ String E1(byte[] bArr, int i2, int i3, boolean z, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = bArr.length;
        }
        if ((i4 & 4) != 0) {
            z = false;
        }
        return D1(bArr, i2, i3, z);
    }

    @h.g2.f
    @h.j(warningSince = "1.5")
    @h.i(message = "Use lowercase() instead.", replaceWith = @q0(expression = "lowercase(Locale.getDefault())", imports = {"java.util.Locale"}))
    private static final String E2(String str) {
        Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
        return str.toLowerCase();
    }

    @x1(markerClass = {h.o.class})
    @s0(version = "1.4")
    @k.e.a.d
    public static final byte[] F1(@k.e.a.d String str) {
        return str.getBytes(d.a);
    }

    @h.g2.f
    @h.j(warningSince = "1.5")
    @h.i(message = "Use lowercase() instead.", replaceWith = @q0(expression = "lowercase(locale)", imports = {}))
    private static final String F2(String str, Locale locale) {
        Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
        return str.toLowerCase(locale);
    }

    @x1(markerClass = {h.o.class})
    @s0(version = "1.4")
    @k.e.a.d
    public static final byte[] G1(@k.e.a.d String str, int i2, int i3, boolean z) {
        h.a2.c.a.a(i2, i3, str.length());
        if (!z) {
            String substring = str.substring(i2, i3);
            Charset charset = d.a;
            Objects.requireNonNull(substring, "null cannot be cast to non-null type java.lang.String");
            return substring.getBytes(charset);
        }
        ByteBuffer encode = d.a.newEncoder().onMalformedInput(CodingErrorAction.REPORT).onUnmappableCharacter(CodingErrorAction.REPORT).encode(CharBuffer.wrap(str, i2, i3));
        if (encode.hasArray() && encode.arrayOffset() == 0 && encode.remaining() == encode.array().length) {
            return encode.array();
        }
        byte[] bArr = new byte[encode.remaining()];
        encode.get(bArr);
        return bArr;
    }

    @h.g2.f
    private static final Pattern G2(String str, int i2) {
        return Pattern.compile(str, i2);
    }

    public static /* synthetic */ byte[] H1(String str, int i2, int i3, boolean z, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = str.length();
        }
        if ((i4 & 4) != 0) {
            z = false;
        }
        return G1(str, i2, i3, z);
    }

    public static /* synthetic */ Pattern H2(String str, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = 0;
        }
        return Pattern.compile(str, i2);
    }

    public static final boolean I1(@k.e.a.d String str, @k.e.a.d String str2, boolean z) {
        if (!z) {
            return str.endsWith(str2);
        }
        return d2(str, str.length() - str2.length(), str2, 0, str2.length(), true);
    }

    @h.g2.f
    @h.j(warningSince = "1.5")
    @h.i(message = "Use uppercase() instead.", replaceWith = @q0(expression = "uppercase(Locale.getDefault())", imports = {"java.util.Locale"}))
    private static final String I2(String str) {
        Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
        return str.toUpperCase();
    }

    public static /* synthetic */ boolean J1(String str, String str2, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return I1(str, str2, z);
    }

    @h.g2.f
    @h.j(warningSince = "1.5")
    @h.i(message = "Use uppercase() instead.", replaceWith = @q0(expression = "uppercase(locale)", imports = {}))
    private static final String J2(String str, Locale locale) {
        Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
        return str.toUpperCase(locale);
    }

    public static final boolean K1(@k.e.a.e String str, @k.e.a.e String str2, boolean z) {
        if (str == null) {
            return str2 == null;
        } else if (!z) {
            return str.equals(str2);
        } else {
            return str.equalsIgnoreCase(str2);
        }
    }

    @h.g2.f
    @x1(markerClass = {h.o.class})
    @s0(version = "1.5")
    private static final String K2(String str) {
        Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
        return str.toUpperCase(Locale.ROOT);
    }

    public static /* synthetic */ boolean L1(String str, String str2, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return K1(str, str2, z);
    }

    @h.g2.f
    @x1(markerClass = {h.o.class})
    @s0(version = "1.5")
    private static final String L2(String str, Locale locale) {
        Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
        return str.toUpperCase(locale);
    }

    @h.g2.f
    private static final String N1(String str, Object... objArr) {
        return String.format(str, Arrays.copyOf(objArr, objArr.length));
    }

    @h.g2.f
    private static final String O1(h.k2.v.s0 s0Var, String str, Object... objArr) {
        return String.format(str, Arrays.copyOf(objArr, objArr.length));
    }

    @h.k2.g(name = "formatNullable")
    @h.g2.f
    @s0(version = "1.4")
    private static final String Q1(String str, Locale locale, Object... objArr) {
        return String.format(locale, str, Arrays.copyOf(objArr, objArr.length));
    }

    @h.k2.g(name = "formatNullable")
    @h.g2.f
    @s0(version = "1.4")
    private static final String R1(h.k2.v.s0 s0Var, Locale locale, String str, Object... objArr) {
        return String.format(locale, str, Arrays.copyOf(objArr, objArr.length));
    }

    @k.e.a.d
    public static final Comparator<String> S1(@k.e.a.d h.k2.v.s0 s0Var) {
        return String.CASE_INSENSITIVE_ORDER;
    }

    @h.g2.f
    private static final String T1(String str) {
        Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
        return str.intern();
    }

    public static final boolean U1(@k.e.a.d CharSequence charSequence) {
        boolean z;
        if (charSequence.length() != 0) {
            h.o2.k h3 = StringsKt__StringsKt.h3(charSequence);
            if (!(h3 instanceof Collection) || !((Collection) h3).isEmpty()) {
                Iterator<Integer> it = h3.iterator();
                while (it.hasNext()) {
                    if (!b.r(charSequence.charAt(((l0) it).nextInt()))) {
                        z = false;
                        break;
                    }
                }
            }
            z = true;
            if (!z) {
                return false;
            }
        }
        return true;
    }

    @h.g2.f
    @x1(markerClass = {h.o.class})
    @s0(version = "1.5")
    private static final String V1(String str) {
        Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
        return str.toLowerCase(Locale.ROOT);
    }

    @h.g2.f
    @x1(markerClass = {h.o.class})
    @s0(version = "1.5")
    private static final String W1(String str, Locale locale) {
        Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
        return str.toLowerCase(locale);
    }

    @h.g2.f
    private static final int X1(String str, char c2, int i2) {
        Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
        return str.indexOf(c2, i2);
    }

    @h.g2.f
    private static final int Y1(String str, String str2, int i2) {
        Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
        return str.indexOf(str2, i2);
    }

    @h.g2.f
    private static final int Z1(String str, char c2, int i2) {
        Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
        return str.lastIndexOf(c2, i2);
    }

    @h.g2.f
    private static final int a2(String str, String str2, int i2) {
        Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
        return str.lastIndexOf(str2, i2);
    }

    @h.g2.f
    private static final int b2(String str, int i2, int i3) {
        Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
        return str.offsetByCodePoints(i2, i3);
    }

    public static final boolean c2(@k.e.a.d CharSequence charSequence, int i2, @k.e.a.d CharSequence charSequence2, int i3, int i4, boolean z) {
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            return d2((String) charSequence, i2, (String) charSequence2, i3, i4, z);
        }
        return StringsKt__StringsKt.a4(charSequence, i2, charSequence2, i3, i4, z);
    }

    @h.g2.f
    private static final String d1(StringBuffer stringBuffer) {
        return new String(stringBuffer);
    }

    public static final boolean d2(@k.e.a.d String str, int i2, @k.e.a.d String str2, int i3, int i4, boolean z) {
        if (!z) {
            return str.regionMatches(i2, str2, i3, i4);
        }
        return str.regionMatches(z, i2, str2, i3, i4);
    }

    @h.g2.f
    private static final String e1(StringBuilder sb) {
        return new String(sb);
    }

    @h.g2.f
    private static final String f1(byte[] bArr) {
        return new String(bArr, d.a);
    }

    @h.g2.f
    private static final String g1(byte[] bArr, int i2, int i3) {
        return new String(bArr, i2, i3, d.a);
    }

    @k.e.a.d
    public static final String g2(@k.e.a.d CharSequence charSequence, int i2) {
        int i3 = 1;
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(("Count 'n' must be non-negative, but was " + i2 + '.').toString());
        } else if (i2 != 0) {
            if (i2 != 1) {
                int length = charSequence.length();
                if (length != 0) {
                    if (length != 1) {
                        StringBuilder sb = new StringBuilder(charSequence.length() * i2);
                        if (1 <= i2) {
                            while (true) {
                                sb.append(charSequence);
                                if (i3 == i2) {
                                    break;
                                }
                                i3++;
                            }
                        }
                        return sb.toString();
                    }
                    char charAt = charSequence.charAt(0);
                    char[] cArr = new char[i2];
                    for (int i4 = 0; i4 < i2; i4++) {
                        cArr[i4] = charAt;
                    }
                    return new String(cArr);
                }
                return "";
            }
            return charSequence.toString();
        } else {
            return "";
        }
    }

    @h.g2.f
    private static final String h1(byte[] bArr, int i2, int i3, Charset charset) {
        return new String(bArr, i2, i3, charset);
    }

    @k.e.a.d
    public static final String h2(@k.e.a.d String str, char c2, char c3, boolean z) {
        if (!z) {
            return str.replace(c2, c3);
        }
        StringBuilder sb = new StringBuilder(str.length());
        for (int i2 = 0; i2 < str.length(); i2++) {
            char charAt = str.charAt(i2);
            if (c.J(charAt, c2, z)) {
                charAt = c3;
            }
            sb.append(charAt);
        }
        return sb.toString();
    }

    @h.g2.f
    private static final String i1(byte[] bArr, Charset charset) {
        return new String(bArr, charset);
    }

    @k.e.a.d
    public static final String i2(@k.e.a.d String str, @k.e.a.d String str2, @k.e.a.d String str3, boolean z) {
        int i2 = 0;
        int n3 = StringsKt__StringsKt.n3(str, str2, 0, z);
        if (n3 < 0) {
            return str;
        }
        int length = str2.length();
        int n = h.o2.q.n(length, 1);
        int length2 = (str.length() - length) + str3.length();
        if (length2 >= 0) {
            StringBuilder sb = new StringBuilder(length2);
            do {
                sb.append((CharSequence) str, i2, n3);
                sb.append(str3);
                i2 = n3 + length;
                if (n3 >= str.length()) {
                    break;
                }
                n3 = StringsKt__StringsKt.n3(str, str2, n3 + n, z);
            } while (n3 > 0);
            sb.append((CharSequence) str, i2, str.length());
            return sb.toString();
        }
        throw new OutOfMemoryError();
    }

    @h.g2.f
    private static final String j1(char[] cArr) {
        return new String(cArr);
    }

    public static /* synthetic */ String j2(String str, char c2, char c3, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        return h2(str, c2, c3, z);
    }

    @h.g2.f
    private static final String k1(char[] cArr, int i2, int i3) {
        return new String(cArr, i2, i3);
    }

    public static /* synthetic */ String k2(String str, String str2, String str3, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        return i2(str, str2, str3, z);
    }

    @h.g2.f
    private static final String l1(int[] iArr, int i2, int i3) {
        return new String(iArr, i2, i3);
    }

    @k.e.a.d
    public static final String l2(@k.e.a.d String str, char c2, char c3, boolean z) {
        int q3 = StringsKt__StringsKt.q3(str, c2, 0, z, 2, null);
        return q3 < 0 ? str : StringsKt__StringsKt.I4(str, q3, q3 + 1, String.valueOf(c3)).toString();
    }

    @h.j(warningSince = "1.5")
    @h.i(message = "Use replaceFirstChar instead.", replaceWith = @q0(expression = "replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }", imports = {"java.util.Locale"}))
    @k.e.a.d
    public static final String m1(@k.e.a.d String str) {
        return n1(str, Locale.getDefault());
    }

    @k.e.a.d
    public static final String m2(@k.e.a.d String str, @k.e.a.d String str2, @k.e.a.d String str3, boolean z) {
        int r3 = StringsKt__StringsKt.r3(str, str2, 0, z, 2, null);
        return r3 < 0 ? str : StringsKt__StringsKt.I4(str, r3, str2.length() + r3, str3).toString();
    }

    @h.j(warningSince = "1.5")
    @h.i(message = "Use replaceFirstChar instead.", replaceWith = @q0(expression = "replaceFirstChar { if (it.isLowerCase()) it.titlecase(locale) else it.toString() }", imports = {}))
    @s0(version = "1.4")
    @h.g2.g
    @x1(markerClass = {h.o.class})
    @k.e.a.d
    public static final String n1(@k.e.a.d String str, @k.e.a.d Locale locale) {
        if (str.length() > 0) {
            char charAt = str.charAt(0);
            if (Character.isLowerCase(charAt)) {
                StringBuilder sb = new StringBuilder();
                char titleCase = Character.toTitleCase(charAt);
                if (titleCase != Character.toUpperCase(charAt)) {
                    sb.append(titleCase);
                } else {
                    String substring = str.substring(0, 1);
                    Objects.requireNonNull(substring, "null cannot be cast to non-null type java.lang.String");
                    sb.append(substring.toUpperCase(locale));
                }
                sb.append(str.substring(1));
                return sb.toString();
            }
            return str;
        }
        return str;
    }

    public static /* synthetic */ String n2(String str, char c2, char c3, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        return l2(str, c2, c3, z);
    }

    @h.g2.f
    private static final int o1(String str, int i2) {
        Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
        return str.codePointAt(i2);
    }

    public static /* synthetic */ String o2(String str, String str2, String str3, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        return m2(str, str2, str3, z);
    }

    @h.g2.f
    private static final int p1(String str, int i2) {
        Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
        return str.codePointBefore(i2);
    }

    @k.e.a.d
    public static final List<String> p2(@k.e.a.d CharSequence charSequence, @k.e.a.d Pattern pattern, int i2) {
        if (i2 >= 0) {
            if (i2 == 0) {
                i2 = -1;
            }
            return h.a2.n.t(pattern.split(charSequence, i2));
        }
        throw new IllegalArgumentException(("Limit must be non-negative, but was " + i2 + '.').toString());
    }

    @h.g2.f
    private static final int q1(String str, int i2, int i3) {
        Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
        return str.codePointCount(i2, i3);
    }

    public static /* synthetic */ List q2(CharSequence charSequence, Pattern pattern, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        return p2(charSequence, pattern, i2);
    }

    public static final int r1(@k.e.a.d String str, @k.e.a.d String str2, boolean z) {
        if (z) {
            return str.compareToIgnoreCase(str2);
        }
        return str.compareTo(str2);
    }

    public static final boolean r2(@k.e.a.d String str, @k.e.a.d String str2, int i2, boolean z) {
        if (!z) {
            return str.startsWith(str2, i2);
        }
        return d2(str, i2, str2, 0, str2.length(), z);
    }

    public static /* synthetic */ int s1(String str, String str2, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return r1(str, str2, z);
    }

    public static final boolean s2(@k.e.a.d String str, @k.e.a.d String str2, boolean z) {
        if (!z) {
            return str.startsWith(str2);
        }
        return d2(str, 0, str2, 0, str2.length(), z);
    }

    @x1(markerClass = {h.o.class})
    @s0(version = "1.4")
    @k.e.a.d
    public static final String t1(@k.e.a.d char[] cArr) {
        return new String(cArr);
    }

    public static /* synthetic */ boolean t2(String str, String str2, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z = false;
        }
        return r2(str, str2, i2, z);
    }

    @x1(markerClass = {h.o.class})
    @s0(version = "1.4")
    @k.e.a.d
    public static final String u1(@k.e.a.d char[] cArr, int i2, int i3) {
        h.a2.c.a.a(i2, i3, cArr.length);
        return new String(cArr, i2, i3 - i2);
    }

    public static /* synthetic */ boolean u2(String str, String str2, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return s2(str, str2, z);
    }

    public static /* synthetic */ String v1(char[] cArr, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = cArr.length;
        }
        return u1(cArr, i2, i3);
    }

    @h.g2.f
    private static final String v2(String str, int i2) {
        Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
        return str.substring(i2);
    }

    @s0(version = "1.5")
    public static final boolean w1(@k.e.a.e CharSequence charSequence, @k.e.a.e CharSequence charSequence2) {
        if ((charSequence instanceof String) && charSequence2 != null) {
            return ((String) charSequence).contentEquals(charSequence2);
        }
        return StringsKt__StringsKt.X2(charSequence, charSequence2);
    }

    @h.g2.f
    private static final String w2(String str, int i2, int i3) {
        Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
        return str.substring(i2, i3);
    }

    @s0(version = "1.5")
    public static final boolean x1(@k.e.a.e CharSequence charSequence, @k.e.a.e CharSequence charSequence2, boolean z) {
        if (z) {
            return StringsKt__StringsKt.W2(charSequence, charSequence2);
        }
        return w1(charSequence, charSequence2);
    }

    @h.g2.f
    private static final byte[] x2(String str, Charset charset) {
        Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
        return str.getBytes(charset);
    }

    @h.g2.f
    private static final boolean y1(String str, CharSequence charSequence) {
        Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
        return str.contentEquals(charSequence);
    }

    public static /* synthetic */ byte[] y2(String str, Charset charset, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charset = d.a;
        }
        Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
        return str.getBytes(charset);
    }

    @h.g2.f
    private static final boolean z1(String str, StringBuffer stringBuffer) {
        Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
        return str.contentEquals(stringBuffer);
    }

    @h.g2.f
    private static final char[] z2(String str) {
        Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
        return str.toCharArray();
    }
}
