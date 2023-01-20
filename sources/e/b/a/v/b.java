package e.b.a.v;

import androidx.collection.ArrayMap;
import androidx.collection.SimpleArrayMap;

/* loaded from: classes.dex */
public final class b<K, V> extends ArrayMap<K, V> {
    private int a;

    @Override // androidx.collection.SimpleArrayMap, java.util.Map
    public void clear() {
        this.a = 0;
        super.clear();
    }

    @Override // androidx.collection.SimpleArrayMap, java.util.Map
    public int hashCode() {
        if (this.a == 0) {
            this.a = super.hashCode();
        }
        return this.a;
    }

    @Override // androidx.collection.SimpleArrayMap, java.util.Map
    public V put(K k2, V v) {
        this.a = 0;
        return (V) super.put(k2, v);
    }

    @Override // androidx.collection.SimpleArrayMap
    public void putAll(SimpleArrayMap<? extends K, ? extends V> simpleArrayMap) {
        this.a = 0;
        super.putAll(simpleArrayMap);
    }

    @Override // androidx.collection.SimpleArrayMap
    public V removeAt(int i2) {
        this.a = 0;
        return (V) super.removeAt(i2);
    }

    @Override // androidx.collection.SimpleArrayMap
    public V setValueAt(int i2, V v) {
        this.a = 0;
        return (V) super.setValueAt(i2, v);
    }
}
