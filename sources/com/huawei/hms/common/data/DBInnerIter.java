package com.huawei.hms.common.data;

import com.huawei.hms.common.internal.Preconditions;
import java.util.Iterator;

/* loaded from: classes2.dex */
public class DBInnerIter<O> implements Iterator<O> {
    public final DataBuffer<O> dataBuffer;
    public int index = -1;

    public DBInnerIter(DataBuffer<O> dataBuffer) {
        Preconditions.checkNotNull(dataBuffer, "dataBuffer cannot be null");
        this.dataBuffer = dataBuffer;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index + 1 < this.dataBuffer.getCount();
    }

    @Override // java.util.Iterator
    public O next() {
        if (hasNext()) {
            DataBuffer<O> dataBuffer = this.dataBuffer;
            int i2 = this.index + 1;
            this.index = i2;
            return dataBuffer.get(i2);
        }
        return null;
    }
}
