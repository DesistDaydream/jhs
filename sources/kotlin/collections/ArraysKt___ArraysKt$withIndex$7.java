package kotlin.collections;

import h.k2.u.a;
import h.k2.v.i;
import java.util.Iterator;
import k.e.a.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010(\n\u0002\u0010\u0006\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "", "invoke"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class ArraysKt___ArraysKt$withIndex$7 extends Lambda implements a<Iterator<? extends Double>> {
    public final /* synthetic */ double[] $this_withIndex;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArraysKt___ArraysKt$withIndex$7(double[] dArr) {
        super(0);
        this.$this_withIndex = dArr;
    }

    @Override // h.k2.u.a
    @d
    public final Iterator<? extends Double> invoke() {
        return i.d(this.$this_withIndex);
    }
}
