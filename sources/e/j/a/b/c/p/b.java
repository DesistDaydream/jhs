package e.j.a.b.c.p;

import android.os.Bundle;
import java.util.Iterator;

/* loaded from: classes2.dex */
public interface b<T> extends e.j.a.b.c.n.m, Iterable<T> {
    @Deprecated
    void close();

    T get(int i2);

    int getCount();

    @e.j.a.b.c.m.a
    Bundle getMetadata();

    @Deprecated
    boolean isClosed();

    Iterator<T> iterator();

    @Override // e.j.a.b.c.n.m
    void release();

    Iterator<T> singleRefIterator();
}
