package h.t2;

import java.util.Set;
import kotlin.Metadata;
import kotlin.text.Regex;
import kotlin.text.RegexOption;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0087\b\u001a\u001b\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0087\b\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0087\b¨\u0006\u0007"}, d2 = {"toRegex", "Lkotlin/text/Regex;", "", "options", "", "Lkotlin/text/RegexOption;", "option", "kotlin-stdlib"}, k = 5, mv = {1, 5, 1}, xi = 1, xs = "kotlin/text/StringsKt")
/* loaded from: classes4.dex */
public class p extends o {
    @h.g2.f
    private static final Regex t(String str) {
        return new Regex(str);
    }

    @h.g2.f
    private static final Regex u(String str, Set<? extends RegexOption> set) {
        return new Regex(str, set);
    }

    @h.g2.f
    private static final Regex v(String str, RegexOption regexOption) {
        return new Regex(str, regexOption);
    }
}
