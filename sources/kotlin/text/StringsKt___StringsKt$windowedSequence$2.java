package kotlin.text;

import h.k2.u.l;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "R", "index", "", "invoke", "(I)Ljava/lang/Object;"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes4.dex */
public final class StringsKt___StringsKt$windowedSequence$2 extends Lambda implements l<Integer, R> {
    public final /* synthetic */ int $size;
    public final /* synthetic */ CharSequence $this_windowedSequence;
    public final /* synthetic */ l $transform;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StringsKt___StringsKt$windowedSequence$2(CharSequence charSequence, int i2, l lVar) {
        super(1);
        this.$this_windowedSequence = charSequence;
        this.$size = i2;
        this.$transform = lVar;
    }

    /* JADX WARN: Type inference failed for: r4v2, types: [R, java.lang.Object] */
    public final R invoke(int i2) {
        int i3 = this.$size + i2;
        if (i3 < 0 || i3 > this.$this_windowedSequence.length()) {
            i3 = this.$this_windowedSequence.length();
        }
        return this.$transform.invoke(this.$this_windowedSequence.subSequence(i2, i3));
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ Object invoke(Integer num) {
        return invoke(num.intValue());
    }
}
