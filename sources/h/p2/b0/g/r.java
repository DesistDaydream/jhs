package h.p2.b0.g;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.lang.ref.WeakReference;
import kotlin.Metadata;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0014\u001a\u00020\u0006H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0004¨\u0006\u0017"}, d2 = {"Lkotlin/reflect/jvm/internal/WeakClassLoaderBox;", "", "classLoader", "Ljava/lang/ClassLoader;", "(Ljava/lang/ClassLoader;)V", "identityHashCode", "", "getIdentityHashCode", "()I", "ref", "Ljava/lang/ref/WeakReference;", "getRef", "()Ljava/lang/ref/WeakReference;", "temporaryStrongRef", "getTemporaryStrongRef", "()Ljava/lang/ClassLoader;", "setTemporaryStrongRef", "equals", "", "other", TTDownloadField.TT_HASHCODE, "toString", "", "kotlin-reflection"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class r {
    @k.e.a.d
    private final WeakReference<ClassLoader> a;
    private final int b;
    @k.e.a.e

    /* renamed from: c  reason: collision with root package name */
    private ClassLoader f15000c;

    public r(@k.e.a.d ClassLoader classLoader) {
        this.a = new WeakReference<>(classLoader);
        this.b = System.identityHashCode(classLoader);
        this.f15000c = classLoader;
    }

    public final void a(@k.e.a.e ClassLoader classLoader) {
        this.f15000c = classLoader;
    }

    public boolean equals(@k.e.a.e Object obj) {
        return (obj instanceof r) && this.a.get() == ((r) obj).a.get();
    }

    public int hashCode() {
        return this.b;
    }

    @k.e.a.d
    public String toString() {
        String classLoader;
        ClassLoader classLoader2 = this.a.get();
        return (classLoader2 == null || (classLoader = classLoader2.toString()) == null) ? "<null>" : classLoader;
    }
}
