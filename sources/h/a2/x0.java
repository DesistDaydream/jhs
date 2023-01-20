package h.a2;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010#\n\u0002\u0010'\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u001f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003B<\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005\u0012!\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00028\u00010\u0007¢\u0006\u0002\u0010\u000bJ\b\u0010\u001d\u001a\u00020\u001eH\u0016J\u0015\u0010\u001f\u001a\u00020 2\u0006\u0010\n\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010!J\u0015\u0010\"\u001a\u00020 2\u0006\u0010#\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010!J\u0013\u0010$\u001a\u00020 2\b\u0010%\u001a\u0004\u0018\u00010&H\u0096\u0002J\u0018\u0010'\u001a\u0004\u0018\u00018\u00012\u0006\u0010\n\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010(J\u0015\u0010)\u001a\u00028\u00012\u0006\u0010\n\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010(J\b\u0010*\u001a\u00020\u0016H\u0016J\b\u0010+\u001a\u00020 H\u0016J\u001f\u0010,\u001a\u0004\u0018\u00018\u00012\u0006\u0010\n\u001a\u00028\u00002\u0006\u0010#\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010-J\u001e\u0010.\u001a\u00020\u001e2\u0014\u0010/\u001a\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000100H\u0016J\u0017\u00101\u001a\u0004\u0018\u00018\u00012\u0006\u0010\n\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010(J\b\u00102\u001a\u000203H\u0016R)\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00028\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000e0\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0010R \u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00168VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00010\u001a8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c¨\u00064"}, d2 = {"Lkotlin/collections/MutableMapWithDefaultImpl;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlin/collections/MutableMapWithDefault;", "map", "", "default", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "key", "(Ljava/util/Map;Lkotlin/jvm/functions/Function1;)V", "entries", "", "", "getEntries", "()Ljava/util/Set;", "keys", "getKeys", "getMap", "()Ljava/util/Map;", "size", "", "getSize", "()I", "values", "", "getValues", "()Ljava/util/Collection;", "clear", "", "containsKey", "", "(Ljava/lang/Object;)Z", "containsValue", "value", "equals", "other", "", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "getOrImplicitDefault", TTDownloadField.TT_HASHCODE, "isEmpty", "put", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "putAll", "from", "", "remove", "toString", "", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class x0<K, V> implements w0<K, V> {
    @k.e.a.d
    private final Map<K, V> a;
    private final h.k2.u.l<K, V> b;

    /* JADX WARN: Multi-variable type inference failed */
    public x0(@k.e.a.d Map<K, V> map, @k.e.a.d h.k2.u.l<? super K, ? extends V> lVar) {
        this.a = map;
        this.b = lVar;
    }

    @k.e.a.d
    public Set<Map.Entry<K, V>> a() {
        return b().entrySet();
    }

    @Override // h.a2.w0, h.a2.o0
    @k.e.a.d
    public Map<K, V> b() {
        return this.a;
    }

    @Override // java.util.Map
    public void clear() {
        b().clear();
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return b().containsKey(obj);
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return b().containsValue(obj);
    }

    @k.e.a.d
    public Set<K> d() {
        return b().keySet();
    }

    @Override // h.a2.o0
    public V e(K k2) {
        Map<K, V> b = b();
        V v = b.get(k2);
        return (v != null || b.containsKey(k2)) ? v : this.b.invoke(k2);
    }

    @Override // java.util.Map
    public final /* bridge */ Set<Map.Entry<K, V>> entrySet() {
        return a();
    }

    @Override // java.util.Map
    public boolean equals(@k.e.a.e Object obj) {
        return b().equals(obj);
    }

    public int f() {
        return b().size();
    }

    @k.e.a.d
    public Collection<V> g() {
        return b().values();
    }

    @Override // java.util.Map
    @k.e.a.e
    public V get(Object obj) {
        return b().get(obj);
    }

    @Override // java.util.Map
    public int hashCode() {
        return b().hashCode();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return b().isEmpty();
    }

    @Override // java.util.Map
    public final /* bridge */ Set<K> keySet() {
        return d();
    }

    @Override // java.util.Map
    @k.e.a.e
    public V put(K k2, V v) {
        return b().put(k2, v);
    }

    @Override // java.util.Map
    public void putAll(@k.e.a.d Map<? extends K, ? extends V> map) {
        b().putAll(map);
    }

    @Override // java.util.Map
    @k.e.a.e
    public V remove(Object obj) {
        return b().remove(obj);
    }

    @Override // java.util.Map
    public final /* bridge */ int size() {
        return f();
    }

    @k.e.a.d
    public String toString() {
        return b().toString();
    }

    @Override // java.util.Map
    public final /* bridge */ Collection<V> values() {
        return g();
    }
}
