package kotlin.text;

import h.g2.l;
import h.o2.k;
import h.t2.h;
import h.t2.j;
import java.util.Iterator;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.collections.AbstractCollection;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.sequences.SequencesKt___SequencesKt;

@Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010(\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002J\u0013\u0010\b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\t\u001a\u00020\u0005H\u0096\u0002J\u0013\u0010\b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0096\u0002J\b\u0010\f\u001a\u00020\rH\u0016J\u0011\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u000fH\u0096\u0002R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"kotlin/text/MatcherMatchResult$groups$1", "Lkotlin/text/MatchNamedGroupCollection;", "Lkotlin/collections/AbstractCollection;", "Lkotlin/text/MatchGroup;", "size", "", "getSize", "()I", "get", "index", "name", "", "isEmpty", "", "iterator", "", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes4.dex */
public final class MatcherMatchResult$groups$1 extends AbstractCollection<h> implements j {
    public final /* synthetic */ MatcherMatchResult a;

    public MatcherMatchResult$groups$1(MatcherMatchResult matcherMatchResult) {
        this.a = matcherMatchResult;
    }

    @Override // kotlin.collections.AbstractCollection
    public int a() {
        return this.a.f().groupCount() + 1;
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean contains(Object obj) {
        if (obj != null ? obj instanceof h : true) {
            return d((h) obj);
        }
        return false;
    }

    public /* bridge */ boolean d(h hVar) {
        return super.contains(hVar);
    }

    @Override // h.t2.i
    @e
    public h get(int i2) {
        k k2;
        k2 = RegexKt.k(this.a.f(), i2);
        if (k2.getStart().intValue() >= 0) {
            return new h(this.a.f().group(i2), k2);
        }
        return null;
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        return false;
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    @d
    public Iterator<h> iterator() {
        return SequencesKt___SequencesKt.d1(CollectionsKt___CollectionsKt.n1(CollectionsKt__CollectionsKt.F(this)), new MatcherMatchResult$groups$1$iterator$1(this)).iterator();
    }

    @Override // h.t2.j
    @e
    public h get(@d String str) {
        return l.a.c(this.a.f(), str);
    }
}
