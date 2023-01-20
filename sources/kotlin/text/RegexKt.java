package kotlin.text;

import androidx.exifinterface.media.ExifInterface;
import h.a2.y;
import h.k2.v.f0;
import h.o2.q;
import h.t2.g;
import h.t2.k;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0000\u001a-\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0014\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0082\b\u001a\u001e\u0010\u0007\u001a\u0004\u0018\u00010\b*\u00020\t2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0002\u001a\u0016\u0010\r\u001a\u0004\u0018\u00010\b*\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0002\u001a\f\u0010\u000e\u001a\u00020\u000f*\u00020\u0010H\u0002\u001a\u0014\u0010\u000e\u001a\u00020\u000f*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0006H\u0002\u001a\u0012\u0010\u0012\u001a\u00020\u0006*\b\u0012\u0004\u0012\u00020\u00030\u0013H\u0002¨\u0006\u0014"}, d2 = {"fromInt", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/text/FlagEnum;", "", "value", "", "findNext", "Lkotlin/text/MatchResult;", "Ljava/util/regex/Matcher;", "from", "input", "", "matchEntire", "range", "Lkotlin/ranges/IntRange;", "Ljava/util/regex/MatchResult;", "groupIndex", "toInt", "", "kotlin-stdlib"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes4.dex */
public final class RegexKt {
    public static final k g(Matcher matcher, int i2, CharSequence charSequence) {
        if (matcher.find(i2)) {
            return new MatcherMatchResult(matcher, charSequence);
        }
        return null;
    }

    public static final /* synthetic */ <T extends Enum<T> & g> Set<T> h(int i2) {
        f0.y(4, ExifInterface.GPS_DIRECTION_TRUE);
        EnumSet allOf = EnumSet.allOf(Enum.class);
        y.P0(allOf, new RegexKt$fromInt$$inlined$apply$lambda$1(i2));
        return Collections.unmodifiableSet(allOf);
    }

    public static final k i(Matcher matcher, CharSequence charSequence) {
        if (matcher.matches()) {
            return new MatcherMatchResult(matcher, charSequence);
        }
        return null;
    }

    public static final h.o2.k j(MatchResult matchResult) {
        return q.n1(matchResult.start(), matchResult.end());
    }

    public static final h.o2.k k(MatchResult matchResult, int i2) {
        return q.n1(matchResult.start(i2), matchResult.end(i2));
    }

    public static final int l(Iterable<? extends g> iterable) {
        int i2 = 0;
        for (g gVar : iterable) {
            i2 |= gVar.getValue();
        }
        return i2;
    }
}
