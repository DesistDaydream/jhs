package com.qiniu.android.dns.local;

import com.qiniu.android.dns.Domain;
import com.qiniu.android.dns.NetworkInfo;
import com.qiniu.android.dns.Record;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes3.dex */
public final class Hosts {
    private final Map<String, LinkedList<Value>> hosts = new ConcurrentHashMap();

    private LinkedList<Value> filter(LinkedList<Value> linkedList, NetworkInfo networkInfo) {
        if (linkedList == null) {
            return null;
        }
        LinkedList<Value> linkedList2 = new LinkedList<>();
        LinkedList<Value> linkedList3 = new LinkedList<>();
        Iterator<Value> it = linkedList.iterator();
        while (it.hasNext()) {
            Value next = it.next();
            int i2 = next.provider;
            if (i2 == 0) {
                linkedList2.add(next);
            } else if (i2 == networkInfo.provider) {
                linkedList3.add(next);
            }
        }
        return linkedList3.size() != 0 ? linkedList3 : linkedList2;
    }

    private Record[] toRecords(LinkedList<Value> linkedList) {
        Record record;
        if (linkedList == null) {
            return null;
        }
        int size = linkedList.size();
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < size; i2++) {
            Value value = linkedList.get(i2);
            if (value != null && (record = value.record) != null && record.value != null) {
                arrayList.add(record);
            }
        }
        return (Record[]) arrayList.toArray(new Record[arrayList.size()]);
    }

    public synchronized Hosts put(String str, Value value) {
        LinkedList<Value> linkedList = this.hosts.get(str);
        if (linkedList == null) {
            linkedList = new LinkedList<>();
        }
        linkedList.add(value);
        this.hosts.put(str, linkedList);
        return this;
    }

    public synchronized Record[] query(Domain domain, NetworkInfo networkInfo) {
        LinkedList<Value> linkedList = this.hosts.get(domain.domain);
        if (linkedList != null && !linkedList.isEmpty()) {
            if (linkedList.size() > 1) {
                linkedList.remove(0);
                linkedList.add(linkedList.get(0));
            }
            return toRecords(filter(linkedList, networkInfo));
        }
        return null;
    }

    /* loaded from: classes3.dex */
    public static class Value {
        public final int provider;
        public final Record record;

        public Value(Record record, int i2) {
            this.record = record;
            this.provider = i2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Value) {
                Value value = (Value) obj;
                Record record = this.record;
                Record record2 = value.record;
                if (record == record2) {
                    return true;
                }
                return record != null && record2 != null && record.value.equals(record2.value) && this.provider == value.provider;
            }
            return false;
        }

        public Value(Record record) {
            this(record, 0);
        }
    }

    public Hosts put(String str, Record record) {
        put(str, new Value(record));
        return this;
    }
}
