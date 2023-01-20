package h.a2;

import androidx.exifinterface.media.ExifInterface;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\n\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\u0010\u0005J\u001d\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u000eJ\b\u0010\u000f\u001a\u00020\u000bH\u0016J\u0016\u0010\u0010\u001a\u00028\u00002\u0006\u0010\f\u001a\u00020\u0007H\u0096\u0002¢\u0006\u0002\u0010\u0011J\u0015\u0010\u0012\u001a\u00028\u00002\u0006\u0010\f\u001a\u00020\u0007H\u0016¢\u0006\u0002\u0010\u0011J\u001e\u0010\u0013\u001a\u00028\u00002\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u0014R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u0015"}, d2 = {"Lkotlin/collections/ReversedList;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/collections/AbstractMutableList;", "delegate", "", "(Ljava/util/List;)V", "size", "", "getSize", "()I", "add", "", "index", "element", "(ILjava/lang/Object;)V", "clear", "get", "(I)Ljava/lang/Object;", "removeAt", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class y0<T> extends e<T> {
    private final List<T> a;

    public y0(@k.e.a.d List<T> list) {
        this.a = list;
    }

    @Override // h.a2.e
    public int a() {
        return this.a.size();
    }

    @Override // h.a2.e, java.util.AbstractList, java.util.List
    public void add(int i2, T t) {
        int b1;
        List<T> list = this.a;
        b1 = z.b1(this, i2);
        list.add(b1, t);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        this.a.clear();
    }

    @Override // h.a2.e
    public T d(int i2) {
        int a1;
        List<T> list = this.a;
        a1 = z.a1(this, i2);
        return list.remove(a1);
    }

    @Override // java.util.AbstractList, java.util.List
    public T get(int i2) {
        int a1;
        List<T> list = this.a;
        a1 = z.a1(this, i2);
        return list.get(a1);
    }

    @Override // h.a2.e, java.util.AbstractList, java.util.List
    public T set(int i2, T t) {
        int a1;
        List<T> list = this.a;
        a1 = z.a1(this, i2);
        return list.set(a1, t);
    }
}
