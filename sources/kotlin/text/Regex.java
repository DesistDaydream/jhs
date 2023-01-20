package kotlin.text;

import h.a2.t;
import h.a2.y;
import h.k2.u.l;
import h.k2.v.u;
import h.o2.q;
import h.p0;
import h.q2.m;
import h.t2.k;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.sequences.SequencesKt__SequencesKt;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 ,2\u00060\u0001j\u0002`\u0002:\u0002,-B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0017\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB\u001d\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\n¢\u0006\u0002\u0010\u000bB\u000f\b\u0001\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J\u001a\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u001a\u001a\u00020\u001bJ\u001e\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00190\u001d2\u0006\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u001a\u001a\u00020\u001bJ\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0016\u001a\u00020\u0017J\u0011\u0010\u001f\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0086\u0004J\"\u0010 \u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00172\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00170\"J\u0016\u0010 \u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010#\u001a\u00020\u0004J\u0016\u0010$\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010#\u001a\u00020\u0004J\u001e\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00040&2\u0006\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010'\u001a\u00020\u001bJ\u0006\u0010(\u001a\u00020\rJ\b\u0010)\u001a\u00020\u0004H\u0016J\b\u0010*\u001a\u00020+H\u0002R\u0016\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\n8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006."}, d2 = {"Lkotlin/text/Regex;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "pattern", "", "(Ljava/lang/String;)V", "option", "Lkotlin/text/RegexOption;", "(Ljava/lang/String;Lkotlin/text/RegexOption;)V", "options", "", "(Ljava/lang/String;Ljava/util/Set;)V", "nativePattern", "Ljava/util/regex/Pattern;", "(Ljava/util/regex/Pattern;)V", "_options", "getOptions", "()Ljava/util/Set;", "getPattern", "()Ljava/lang/String;", "containsMatchIn", "", "input", "", "find", "Lkotlin/text/MatchResult;", "startIndex", "", "findAll", "Lkotlin/sequences/Sequence;", "matchEntire", "matches", "replace", "transform", "Lkotlin/Function1;", "replacement", "replaceFirst", "split", "", "limit", "toPattern", "toString", "writeReplace", "", "Companion", "Serialized", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes4.dex */
public final class Regex implements Serializable {
    @d
    public static final a Companion = new a(null);
    private Set<? extends RegexOption> _options;
    private final Pattern nativePattern;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0002\u0018\u0000 \u000e2\u00060\u0001j\u0002`\u0002:\u0001\u000eB\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\f\u001a\u00020\rH\u0002R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lkotlin/text/Regex$Serialized;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "pattern", "", "flags", "", "(Ljava/lang/String;I)V", "getFlags", "()I", "getPattern", "()Ljava/lang/String;", "readResolve", "", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes4.dex */
    public static final class Serialized implements Serializable {
        @d
        public static final a Companion = new a(null);
        private static final long serialVersionUID = 0;
        private final int flags;
        @d
        private final String pattern;

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lkotlin/text/Regex$Serialized$Companion;", "", "()V", "serialVersionUID", "", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
        /* loaded from: classes4.dex */
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(u uVar) {
                this();
            }
        }

        public Serialized(@d String str, int i2) {
            this.pattern = str;
            this.flags = i2;
        }

        private final Object readResolve() {
            return new Regex(Pattern.compile(this.pattern, this.flags));
        }

        public final int getFlags() {
            return this.flags;
        }

        @d
        public final String getPattern() {
            return this.pattern;
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\t\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0007¨\u0006\f"}, d2 = {"Lkotlin/text/Regex$Companion;", "", "()V", "ensureUnicodeCase", "", "flags", "escape", "", "literal", "escapeReplacement", "fromLiteral", "Lkotlin/text/Regex;", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes4.dex */
    public static final class a {
        private a() {
        }

        public final int b(int i2) {
            return (i2 & 2) != 0 ? i2 | 64 : i2;
        }

        @d
        public final String c(@d String str) {
            return Pattern.quote(str);
        }

        @d
        public final String d(@d String str) {
            return Matcher.quoteReplacement(str);
        }

        @d
        public final Regex e(@d String str) {
            return new Regex(str, RegexOption.LITERAL);
        }

        public /* synthetic */ a(u uVar) {
            this();
        }
    }

    @p0
    public Regex(@d Pattern pattern) {
        this.nativePattern = pattern;
    }

    public static /* synthetic */ k find$default(Regex regex, CharSequence charSequence, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        return regex.find(charSequence, i2);
    }

    public static /* synthetic */ m findAll$default(Regex regex, CharSequence charSequence, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        return regex.findAll(charSequence, i2);
    }

    public static /* synthetic */ List split$default(Regex regex, CharSequence charSequence, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        return regex.split(charSequence, i2);
    }

    private final Object writeReplace() {
        return new Serialized(this.nativePattern.pattern(), this.nativePattern.flags());
    }

    public final boolean containsMatchIn(@d CharSequence charSequence) {
        return this.nativePattern.matcher(charSequence).find();
    }

    @e
    public final k find(@d CharSequence charSequence, int i2) {
        k g2;
        g2 = RegexKt.g(this.nativePattern.matcher(charSequence), i2, charSequence);
        return g2;
    }

    @d
    public final m<k> findAll(@d CharSequence charSequence, int i2) {
        if (i2 >= 0 && i2 <= charSequence.length()) {
            return SequencesKt__SequencesKt.q(new Regex$findAll$1(this, charSequence, i2), Regex$findAll$2.INSTANCE);
        }
        throw new IndexOutOfBoundsException("Start index out of bounds: " + i2 + ", input length: " + charSequence.length());
    }

    @d
    public final Set<RegexOption> getOptions() {
        Set set = this._options;
        if (set != null) {
            return set;
        }
        int flags = this.nativePattern.flags();
        EnumSet allOf = EnumSet.allOf(RegexOption.class);
        y.P0(allOf, new Regex$fromInt$$inlined$apply$lambda$1(flags));
        Set<RegexOption> unmodifiableSet = Collections.unmodifiableSet(allOf);
        this._options = unmodifiableSet;
        return unmodifiableSet;
    }

    @d
    public final String getPattern() {
        return this.nativePattern.pattern();
    }

    @e
    public final k matchEntire(@d CharSequence charSequence) {
        k i2;
        i2 = RegexKt.i(this.nativePattern.matcher(charSequence), charSequence);
        return i2;
    }

    public final boolean matches(@d CharSequence charSequence) {
        return this.nativePattern.matcher(charSequence).matches();
    }

    @d
    public final String replace(@d CharSequence charSequence, @d String str) {
        return this.nativePattern.matcher(charSequence).replaceAll(str);
    }

    @d
    public final String replaceFirst(@d CharSequence charSequence, @d String str) {
        return this.nativePattern.matcher(charSequence).replaceFirst(str);
    }

    @d
    public final List<String> split(@d CharSequence charSequence, int i2) {
        int i3 = 0;
        if (i2 >= 0) {
            Matcher matcher = this.nativePattern.matcher(charSequence);
            if (matcher.find() && i2 != 1) {
                ArrayList arrayList = new ArrayList(i2 > 0 ? q.u(i2, 10) : 10);
                int i4 = i2 - 1;
                do {
                    arrayList.add(charSequence.subSequence(i3, matcher.start()).toString());
                    i3 = matcher.end();
                    if (i4 >= 0 && arrayList.size() == i4) {
                        break;
                    }
                } while (matcher.find());
                arrayList.add(charSequence.subSequence(i3, charSequence.length()).toString());
                return arrayList;
            }
            return t.k(charSequence.toString());
        }
        throw new IllegalArgumentException(("Limit must be non-negative, but was " + i2 + '.').toString());
    }

    @d
    public final Pattern toPattern() {
        return this.nativePattern;
    }

    @d
    public String toString() {
        return this.nativePattern.toString();
    }

    public Regex(@d String str) {
        this(Pattern.compile(str));
    }

    @d
    public final String replace(@d CharSequence charSequence, @d l<? super k, ? extends CharSequence> lVar) {
        int i2 = 0;
        k find$default = find$default(this, charSequence, 0, 2, null);
        if (find$default != null) {
            int length = charSequence.length();
            StringBuilder sb = new StringBuilder(length);
            do {
                sb.append(charSequence, i2, find$default.c().getStart().intValue());
                sb.append(lVar.invoke(find$default));
                i2 = find$default.c().getEndInclusive().intValue() + 1;
                find$default = find$default.next();
                if (i2 >= length) {
                    break;
                }
            } while (find$default != null);
            if (i2 < length) {
                sb.append(charSequence, i2, length);
            }
            return sb.toString();
        }
        return charSequence.toString();
    }

    public Regex(@d String str, @d RegexOption regexOption) {
        this(Pattern.compile(str, Companion.b(regexOption.getValue())));
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public Regex(@k.e.a.d java.lang.String r2, @k.e.a.d java.util.Set<? extends kotlin.text.RegexOption> r3) {
        /*
            r1 = this;
            kotlin.text.Regex$a r0 = kotlin.text.Regex.Companion
            int r3 = kotlin.text.RegexKt.f(r3)
            int r3 = kotlin.text.Regex.a.a(r0, r3)
            java.util.regex.Pattern r2 = java.util.regex.Pattern.compile(r2, r3)
            r1.<init>(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.Regex.<init>(java.lang.String, java.util.Set):void");
    }
}
