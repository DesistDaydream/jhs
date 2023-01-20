package e.j.a.b.c.p;

import java.util.NoSuchElementException;

@e.j.a.b.c.m.a
/* loaded from: classes2.dex */
public class l<T> extends c<T> {

    /* renamed from: c  reason: collision with root package name */
    private T f10358c;

    public l(b<T> bVar) {
        super(bVar);
    }

    @Override // e.j.a.b.c.p.c, java.util.Iterator
    public T next() {
        if (hasNext()) {
            int i2 = this.b + 1;
            this.b = i2;
            if (i2 == 0) {
                T t = this.a.get(0);
                this.f10358c = t;
                if (!(t instanceof f)) {
                    String valueOf = String.valueOf(this.f10358c.getClass());
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 44);
                    sb.append("DataBuffer reference of type ");
                    sb.append(valueOf);
                    sb.append(" is not movable");
                    throw new IllegalStateException(sb.toString());
                }
            } else {
                ((f) this.f10358c).n(i2);
            }
            return this.f10358c;
        }
        int i3 = this.b;
        StringBuilder sb2 = new StringBuilder(46);
        sb2.append("Cannot advance the iterator beyond ");
        sb2.append(i3);
        throw new NoSuchElementException(sb2.toString());
    }
}
