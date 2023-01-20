package e.j.a.b.c.n;

import android.os.Bundle;
import androidx.annotation.NonNull;
import e.j.a.b.c.n.p;
import e.j.a.b.c.p.a;
import java.util.Iterator;

@e.j.a.b.c.m.a
/* loaded from: classes2.dex */
public class g<T, R extends e.j.a.b.c.p.a<T> & p> extends o<R> implements e.j.a.b.c.p.b<T> {
    @e.j.a.b.c.m.a
    public g() {
    }

    @Override // e.j.a.b.c.p.b
    public void close() {
        ((e.j.a.b.c.p.a) a()).close();
    }

    @Override // e.j.a.b.c.p.b
    public T get(int i2) {
        return (T) ((e.j.a.b.c.p.a) a()).get(i2);
    }

    @Override // e.j.a.b.c.p.b
    public int getCount() {
        return ((e.j.a.b.c.p.a) a()).getCount();
    }

    @Override // e.j.a.b.c.p.b
    public Bundle getMetadata() {
        return ((e.j.a.b.c.p.a) a()).getMetadata();
    }

    @Override // e.j.a.b.c.p.b
    public boolean isClosed() {
        return ((e.j.a.b.c.p.a) a()).isClosed();
    }

    @Override // e.j.a.b.c.p.b, java.lang.Iterable
    public Iterator<T> iterator() {
        return ((e.j.a.b.c.p.a) a()).iterator();
    }

    @Override // e.j.a.b.c.p.b, e.j.a.b.c.n.m
    public void release() {
        ((e.j.a.b.c.p.a) a()).release();
    }

    @Override // e.j.a.b.c.p.b
    public Iterator<T> singleRefIterator() {
        return ((e.j.a.b.c.p.a) a()).singleRefIterator();
    }

    /* JADX WARN: Incorrect types in method signature: (TR;)V */
    /* JADX WARN: Multi-variable type inference failed */
    @e.j.a.b.c.m.a
    public g(@NonNull e.j.a.b.c.p.a aVar) {
        super(aVar);
    }
}
