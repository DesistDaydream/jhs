package h.a2;

import androidx.exifinterface.media.ExifInterface;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0012\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\u0010\u0005J\u0016\u0010\n\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00020\u0007H\u0096\u0002¢\u0006\u0002\u0010\fR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lkotlin/collections/ReversedListReadOnly;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/collections/AbstractList;", "delegate", "", "(Ljava/util/List;)V", "size", "", "getSize", "()I", "get", "index", "(I)Ljava/lang/Object;", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public class z0<T> extends c<T> {
    private final List<T> b;

    /* JADX WARN: Multi-variable type inference failed */
    public z0(@k.e.a.d List<? extends T> list) {
        this.b = list;
    }

    @Override // h.a2.c, kotlin.collections.AbstractCollection
    public int a() {
        return this.b.size();
    }

    @Override // h.a2.c, java.util.List
    public T get(int i2) {
        int a1;
        List<T> list = this.b;
        a1 = z.a1(this, i2);
        return list.get(a1);
    }
}
