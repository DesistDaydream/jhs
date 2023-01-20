package kotlin.sequences;

import androidx.exifinterface.media.ExifInterface;
import h.k2.u.p;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u0002H\u0001H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", ExifInterface.GPS_DIRECTION_TRUE, "index", "", "element", "invoke", "(ILjava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes4.dex */
public final class SequencesKt___SequencesKt$onEachIndexed$1 extends Lambda implements p<Integer, T, T> {
    public final /* synthetic */ p $action;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SequencesKt___SequencesKt$onEachIndexed$1(p pVar) {
        super(2);
        this.$action = pVar;
    }

    public final T invoke(int i2, T t) {
        this.$action.invoke(Integer.valueOf(i2), t);
        return t;
    }

    @Override // h.k2.u.p
    public /* bridge */ /* synthetic */ Object invoke(Integer num, Object obj) {
        return invoke(num.intValue(), (int) obj);
    }
}
