package e.j.a.b.c.p;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import java.util.Iterator;

/* loaded from: classes2.dex */
public abstract class a<T> implements b<T> {
    public final DataHolder a;

    @e.j.a.b.c.m.a
    public a(DataHolder dataHolder) {
        this.a = dataHolder;
    }

    @Override // e.j.a.b.c.p.b
    @Deprecated
    public final void close() {
        release();
    }

    @Override // e.j.a.b.c.p.b
    public abstract T get(int i2);

    @Override // e.j.a.b.c.p.b
    public int getCount() {
        DataHolder dataHolder = this.a;
        if (dataHolder == null) {
            return 0;
        }
        return dataHolder.getCount();
    }

    @Override // e.j.a.b.c.p.b
    public Bundle getMetadata() {
        return this.a.getMetadata();
    }

    @Override // e.j.a.b.c.p.b
    @Deprecated
    public boolean isClosed() {
        DataHolder dataHolder = this.a;
        return dataHolder == null || dataHolder.isClosed();
    }

    @Override // e.j.a.b.c.p.b, java.lang.Iterable
    public Iterator<T> iterator() {
        return new c(this);
    }

    @Override // e.j.a.b.c.p.b, e.j.a.b.c.n.m
    public void release() {
        DataHolder dataHolder = this.a;
        if (dataHolder != null) {
            dataHolder.close();
        }
    }

    @Override // e.j.a.b.c.p.b
    public Iterator<T> singleRefIterator() {
        return new l(this);
    }
}
