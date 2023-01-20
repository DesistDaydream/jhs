package e.b.a.p.k;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import com.bumptech.glide.load.engine.GlideException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class g<DataType, ResourceType, Transcode> {

    /* renamed from: f  reason: collision with root package name */
    private static final String f9529f = "DecodePath";
    private final Class<DataType> a;
    private final List<? extends e.b.a.p.g<DataType, ResourceType>> b;

    /* renamed from: c  reason: collision with root package name */
    private final e.b.a.p.m.i.e<ResourceType, Transcode> f9530c;

    /* renamed from: d  reason: collision with root package name */
    private final Pools.Pool<List<Throwable>> f9531d;

    /* renamed from: e  reason: collision with root package name */
    private final String f9532e;

    /* loaded from: classes.dex */
    public interface a<ResourceType> {
        @NonNull
        s<ResourceType> a(@NonNull s<ResourceType> sVar);
    }

    public g(Class<DataType> cls, Class<ResourceType> cls2, Class<Transcode> cls3, List<? extends e.b.a.p.g<DataType, ResourceType>> list, e.b.a.p.m.i.e<ResourceType, Transcode> eVar, Pools.Pool<List<Throwable>> pool) {
        this.a = cls;
        this.b = list;
        this.f9530c = eVar;
        this.f9531d = pool;
        this.f9532e = "Failed DecodePath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + "}";
    }

    @NonNull
    private s<ResourceType> b(e.b.a.p.j.e<DataType> eVar, int i2, int i3, @NonNull e.b.a.p.f fVar) throws GlideException {
        List<Throwable> list = (List) e.b.a.v.l.d(this.f9531d.acquire());
        try {
            return c(eVar, i2, i3, fVar, list);
        } finally {
            this.f9531d.release(list);
        }
    }

    @NonNull
    private s<ResourceType> c(e.b.a.p.j.e<DataType> eVar, int i2, int i3, @NonNull e.b.a.p.f fVar, List<Throwable> list) throws GlideException {
        int size = this.b.size();
        s<ResourceType> sVar = null;
        for (int i4 = 0; i4 < size; i4++) {
            e.b.a.p.g<DataType, ResourceType> gVar = this.b.get(i4);
            try {
                if (gVar.a(eVar.b(), fVar)) {
                    sVar = gVar.b(eVar.b(), i2, i3, fVar);
                }
            } catch (IOException | OutOfMemoryError | RuntimeException e2) {
                if (Log.isLoggable(f9529f, 2)) {
                    Log.v(f9529f, "Failed to decode data for " + gVar, e2);
                }
                list.add(e2);
            }
            if (sVar != null) {
                break;
            }
        }
        if (sVar != null) {
            return sVar;
        }
        throw new GlideException(this.f9532e, new ArrayList(list));
    }

    public s<Transcode> a(e.b.a.p.j.e<DataType> eVar, int i2, int i3, @NonNull e.b.a.p.f fVar, a<ResourceType> aVar) throws GlideException {
        return this.f9530c.a(aVar.a(b(eVar, i2, i3, fVar)), fVar);
    }

    public String toString() {
        return "DecodePath{ dataClass=" + this.a + ", decoders=" + this.b + ", transcoder=" + this.f9530c + '}';
    }
}
