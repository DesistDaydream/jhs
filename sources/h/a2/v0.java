package h.a2;

import androidx.exifinterface.media.ExifInterface;
import java.util.List;
import java.util.RandomAccess;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00060\u0003j\u0002`\u0004B\u0013\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0002\u0010\u0007J\u0016\u0010\u000e\u001a\u00028\u00002\u0006\u0010\u000f\u001a\u00020\tH\u0096\u0002¢\u0006\u0002\u0010\u0010J\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\tR\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u0014"}, d2 = {"Lkotlin/collections/MovingSubList;", ExifInterface.LONGITUDE_EAST, "Lkotlin/collections/AbstractList;", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "list", "", "(Ljava/util/List;)V", "_size", "", "fromIndex", "size", "getSize", "()I", "get", "index", "(I)Ljava/lang/Object;", "move", "", "toIndex", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class v0<E> extends c<E> implements RandomAccess {
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private int f14850c;

    /* renamed from: d  reason: collision with root package name */
    private final List<E> f14851d;

    /* JADX WARN: Multi-variable type inference failed */
    public v0(@k.e.a.d List<? extends E> list) {
        this.f14851d = list;
    }

    @Override // h.a2.c, kotlin.collections.AbstractCollection
    public int a() {
        return this.f14850c;
    }

    public final void d(int i2, int i3) {
        c.a.d(i2, i3, this.f14851d.size());
        this.b = i2;
        this.f14850c = i3 - i2;
    }

    @Override // h.a2.c, java.util.List
    public E get(int i2) {
        c.a.b(i2, this.f14850c);
        return this.f14851d.get(this.b + i2);
    }
}
