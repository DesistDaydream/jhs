package kotlin.sequences;

import h.q2.m;
import java.util.Iterator;
import k.e.a.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u000f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0096\u0002¨\u0006\u0004"}, d2 = {"kotlin/sequences/SequencesKt___SequencesKt$minus$1", "Lkotlin/sequences/Sequence;", "iterator", "", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes4.dex */
public final class SequencesKt___SequencesKt$minus$1 implements m<T> {
    public final /* synthetic */ m a;
    public final /* synthetic */ Object b;

    public SequencesKt___SequencesKt$minus$1(m<? extends T> mVar, Object obj) {
        this.a = mVar;
        this.b = obj;
    }

    @Override // h.q2.m
    @d
    public Iterator<T> iterator() {
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        booleanRef.element = false;
        return SequencesKt___SequencesKt.i0(this.a, new SequencesKt___SequencesKt$minus$1$iterator$1(this, booleanRef)).iterator();
    }
}
