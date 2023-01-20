package androidx.databinding;

import androidx.collection.ArrayMap;
import androidx.databinding.ObservableMap;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes.dex */
public class ObservableArrayMap<K, V> extends ArrayMap<K, V> implements ObservableMap<K, V> {
    private transient MapChangeRegistry mListeners;

    private void notifyChange(Object obj) {
        MapChangeRegistry mapChangeRegistry = this.mListeners;
        if (mapChangeRegistry != null) {
            mapChangeRegistry.notifyCallbacks(this, 0, obj);
        }
    }

    @Override // androidx.databinding.ObservableMap
    public void addOnMapChangedCallback(ObservableMap.OnMapChangedCallback<? extends ObservableMap<K, V>, K, V> onMapChangedCallback) {
        if (this.mListeners == null) {
            this.mListeners = new MapChangeRegistry();
        }
        this.mListeners.add(onMapChangedCallback);
    }

    @Override // androidx.collection.SimpleArrayMap, java.util.Map
    public void clear() {
        if (isEmpty()) {
            return;
        }
        super.clear();
        notifyChange(null);
    }

    @Override // androidx.collection.SimpleArrayMap, java.util.Map
    public V put(K k2, V v) {
        super.put(k2, v);
        notifyChange(k2);
        return v;
    }

    @Override // androidx.collection.ArrayMap
    public boolean removeAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        boolean z = false;
        while (it.hasNext()) {
            int indexOfKey = indexOfKey(it.next());
            if (indexOfKey >= 0) {
                z = true;
                removeAt(indexOfKey);
            }
        }
        return z;
    }

    @Override // androidx.collection.SimpleArrayMap
    public V removeAt(int i2) {
        K keyAt = keyAt(i2);
        V v = (V) super.removeAt(i2);
        if (v != null) {
            notifyChange(keyAt);
        }
        return v;
    }

    @Override // androidx.databinding.ObservableMap
    public void removeOnMapChangedCallback(ObservableMap.OnMapChangedCallback<? extends ObservableMap<K, V>, K, V> onMapChangedCallback) {
        MapChangeRegistry mapChangeRegistry = this.mListeners;
        if (mapChangeRegistry != null) {
            mapChangeRegistry.remove(onMapChangedCallback);
        }
    }

    @Override // androidx.collection.ArrayMap
    public boolean retainAll(Collection<?> collection) {
        boolean z = false;
        for (int size = size() - 1; size >= 0; size--) {
            if (!collection.contains(keyAt(size))) {
                removeAt(size);
                z = true;
            }
        }
        return z;
    }

    @Override // androidx.collection.SimpleArrayMap
    public V setValueAt(int i2, V v) {
        K keyAt = keyAt(i2);
        V v2 = (V) super.setValueAt(i2, v);
        notifyChange(keyAt);
        return v2;
    }
}
