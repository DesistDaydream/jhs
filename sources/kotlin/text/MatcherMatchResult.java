package kotlin.text;

import h.a2.c;
import h.t2.i;
import h.t2.k;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\n\u0010\u001c\u001a\u0004\u0018\u00010\u0001H\u0016R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\u00020\u00168VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001d"}, d2 = {"Lkotlin/text/MatcherMatchResult;", "Lkotlin/text/MatchResult;", "matcher", "Ljava/util/regex/Matcher;", "input", "", "(Ljava/util/regex/Matcher;Ljava/lang/CharSequence;)V", "groupValues", "", "", "getGroupValues", "()Ljava/util/List;", "groupValues_", "groups", "Lkotlin/text/MatchGroupCollection;", "getGroups", "()Lkotlin/text/MatchGroupCollection;", "matchResult", "Ljava/util/regex/MatchResult;", "getMatchResult", "()Ljava/util/regex/MatchResult;", "range", "Lkotlin/ranges/IntRange;", "getRange", "()Lkotlin/ranges/IntRange;", "value", "getValue", "()Ljava/lang/String;", "next", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes4.dex */
public final class MatcherMatchResult implements k {
    @d
    private final i a = new MatcherMatchResult$groups$1(this);
    private List<String> b;

    /* renamed from: c */
    private final Matcher f16899c;

    /* renamed from: d */
    private final CharSequence f16900d;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0011\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0004H\u0096\u0002R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"kotlin/text/MatcherMatchResult$groupValues$1", "Lkotlin/collections/AbstractList;", "", "size", "", "getSize", "()I", "get", "index", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes4.dex */
    public static final class a extends c<String> {
        public a() {
            MatcherMatchResult.this = r1;
        }

        @Override // h.a2.c, kotlin.collections.AbstractCollection
        public int a() {
            return MatcherMatchResult.this.f().groupCount() + 1;
        }

        @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.util.List
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof String) {
                return d((String) obj);
            }
            return false;
        }

        public /* bridge */ boolean d(String str) {
            return super.contains(str);
        }

        @Override // h.a2.c, java.util.List
        @d
        /* renamed from: f */
        public String get(int i2) {
            String group = MatcherMatchResult.this.f().group(i2);
            return group != null ? group : "";
        }

        public /* bridge */ int g(String str) {
            return super.indexOf(str);
        }

        public /* bridge */ int h(String str) {
            return super.lastIndexOf(str);
        }

        @Override // h.a2.c, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof String) {
                return g((String) obj);
            }
            return -1;
        }

        @Override // h.a2.c, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof String) {
                return h((String) obj);
            }
            return -1;
        }
    }

    public MatcherMatchResult(@d Matcher matcher, @d CharSequence charSequence) {
        this.f16899c = matcher;
        this.f16900d = charSequence;
    }

    public final MatchResult f() {
        return this.f16899c;
    }

    @Override // h.t2.k
    @d
    public k.b a() {
        return k.a.a(this);
    }

    @Override // h.t2.k
    @d
    public List<String> b() {
        if (this.b == null) {
            this.b = new a();
        }
        return this.b;
    }

    @Override // h.t2.k
    @d
    public h.o2.k c() {
        h.o2.k j2;
        j2 = RegexKt.j(f());
        return j2;
    }

    @Override // h.t2.k
    @d
    public i d() {
        return this.a;
    }

    @Override // h.t2.k
    @d
    public String getValue() {
        return f().group();
    }

    @Override // h.t2.k
    @e
    public k next() {
        k g2;
        int end = f().end() + (f().end() == f().start() ? 1 : 0);
        if (end <= this.f16900d.length()) {
            g2 = RegexKt.g(this.f16899c.pattern().matcher(this.f16900d), end, this.f16900d);
            return g2;
        }
        return null;
    }
}
