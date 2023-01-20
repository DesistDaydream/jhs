package e.j.a.b.c.p;

import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class k {
    /* JADX WARN: Multi-variable type inference failed */
    public static <T, E extends j<T>> ArrayList<T> a(ArrayList<E> arrayList) {
        ArrayList<T> arrayList2 = (ArrayList<T>) new ArrayList(arrayList.size());
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            arrayList2.add(arrayList.get(i2).freeze());
        }
        return arrayList2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T, E extends j<T>> ArrayList<T> b(E[] eArr) {
        ArrayList<T> arrayList = (ArrayList<T>) new ArrayList(eArr.length);
        for (E e2 : eArr) {
            arrayList.add(e2.freeze());
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T, E extends j<T>> ArrayList<T> c(Iterable<E> iterable) {
        ArrayList<T> arrayList = (ArrayList<T>) new ArrayList();
        for (E e2 : iterable) {
            arrayList.add(e2.freeze());
        }
        return arrayList;
    }
}
