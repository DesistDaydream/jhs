package kotlin.sequences;

import androidx.exifinterface.media.ExifInterface;
import h.k2.u.l;
import java.util.Iterator;
import k.e.a.d;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010(\n\u0002\b\u0003\n\u0002\u0010\u001c\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "R", ExifInterface.GPS_DIRECTION_TRUE, "p1", "", "invoke"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes4.dex */
public final /* synthetic */ class SequencesKt___SequencesKt$flatMap$1 extends FunctionReferenceImpl implements l<Iterable<? extends R>, Iterator<? extends R>> {
    public static final SequencesKt___SequencesKt$flatMap$1 INSTANCE = new SequencesKt___SequencesKt$flatMap$1();

    public SequencesKt___SequencesKt$flatMap$1() {
        super(1, Iterable.class, "iterator", "iterator()Ljava/util/Iterator;", 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // h.k2.u.l
    @d
    public final Iterator<R> invoke(@d Iterable<? extends R> iterable) {
        return iterable.iterator();
    }
}
