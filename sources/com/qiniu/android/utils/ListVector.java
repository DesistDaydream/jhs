package com.qiniu.android.utils;

import java.util.Arrays;
import java.util.Vector;

/* loaded from: classes3.dex */
public class ListVector<E> extends Vector<E> {

    /* loaded from: classes3.dex */
    public interface EnumeratorHandler<T> {
        boolean enumerate(T t);
    }

    public ListVector() {
    }

    public synchronized void enumerateObjects(EnumeratorHandler<? super E> enumeratorHandler) {
        if (enumeratorHandler == null) {
            return;
        }
        Object[] objArr = ((Vector) this).elementData;
        int i2 = ((Vector) this).elementCount;
        for (int i3 = 0; i3 < i2; i3++) {
            if (enumeratorHandler.enumerate(objArr[i3])) {
                break;
            }
        }
    }

    public ListVector(int i2, int i3) {
        super(i2, i3);
    }

    @Override // java.util.Vector, java.util.AbstractList, java.util.List
    public synchronized ListVector<E> subList(int i2, int i3) {
        ListVector<E> listVector;
        listVector = new ListVector<>();
        if (((Vector) this).elementData.getClass() != Object[].class) {
            Object[] copyOf = Arrays.copyOf(((Vector) this).elementData, ((Vector) this).elementCount, Object[].class);
            ((Vector) listVector).elementData = copyOf;
            ((Vector) listVector).elementCount = copyOf.length;
        } else {
            ((Vector) listVector).elementData = Arrays.copyOf(((Vector) this).elementData, ((Vector) this).elementCount);
            ((Vector) listVector).elementCount = ((Vector) this).elementCount;
        }
        return listVector;
    }
}
