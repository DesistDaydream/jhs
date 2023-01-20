package h.g2.r;

import h.o2.k;
import h.t2.h;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.random.Random;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0010\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"Lkotlin/internal/jdk8/JDK8PlatformImplementations;", "Lkotlin/internal/jdk7/JDK7PlatformImplementations;", "()V", "defaultPlatformRandom", "Lkotlin/random/Random;", "getMatchResultNamedGroup", "Lkotlin/text/MatchGroup;", "matchResult", "Ljava/util/regex/MatchResult;", "name", "", "kotlin-stdlib-jdk8"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public class a extends h.g2.q.a {
    @Override // h.g2.k
    @d
    public Random b() {
        return new h.n2.f.a();
    }

    @Override // h.g2.k
    @e
    public h c(@d MatchResult matchResult, @d String str) {
        if (!(matchResult instanceof Matcher)) {
            matchResult = null;
        }
        Matcher matcher = (Matcher) matchResult;
        if (matcher != null) {
            k kVar = new k(matcher.start(str), matcher.end(str) - 1);
            if (kVar.getStart().intValue() >= 0) {
                return new h(matcher.group(str), kVar);
            }
            return null;
        }
        throw new UnsupportedOperationException("Retrieving groups by name is not supported on this platform.");
    }
}
