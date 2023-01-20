package e.b.a.p.k;

import androidx.annotation.NonNull;
import java.security.MessageDigest;
import java.util.Map;

/* loaded from: classes.dex */
public class l implements e.b.a.p.c {

    /* renamed from: c  reason: collision with root package name */
    private final Object f9563c;

    /* renamed from: d  reason: collision with root package name */
    private final int f9564d;

    /* renamed from: e  reason: collision with root package name */
    private final int f9565e;

    /* renamed from: f  reason: collision with root package name */
    private final Class<?> f9566f;

    /* renamed from: g  reason: collision with root package name */
    private final Class<?> f9567g;

    /* renamed from: h  reason: collision with root package name */
    private final e.b.a.p.c f9568h;

    /* renamed from: i  reason: collision with root package name */
    private final Map<Class<?>, e.b.a.p.i<?>> f9569i;

    /* renamed from: j  reason: collision with root package name */
    private final e.b.a.p.f f9570j;

    /* renamed from: k  reason: collision with root package name */
    private int f9571k;

    public l(Object obj, e.b.a.p.c cVar, int i2, int i3, Map<Class<?>, e.b.a.p.i<?>> map, Class<?> cls, Class<?> cls2, e.b.a.p.f fVar) {
        this.f9563c = e.b.a.v.l.d(obj);
        this.f9568h = (e.b.a.p.c) e.b.a.v.l.e(cVar, "Signature must not be null");
        this.f9564d = i2;
        this.f9565e = i3;
        this.f9569i = (Map) e.b.a.v.l.d(map);
        this.f9566f = (Class) e.b.a.v.l.e(cls, "Resource class must not be null");
        this.f9567g = (Class) e.b.a.v.l.e(cls2, "Transcode class must not be null");
        this.f9570j = (e.b.a.p.f) e.b.a.v.l.d(fVar);
    }

    @Override // e.b.a.p.c
    public boolean equals(Object obj) {
        if (obj instanceof l) {
            l lVar = (l) obj;
            return this.f9563c.equals(lVar.f9563c) && this.f9568h.equals(lVar.f9568h) && this.f9565e == lVar.f9565e && this.f9564d == lVar.f9564d && this.f9569i.equals(lVar.f9569i) && this.f9566f.equals(lVar.f9566f) && this.f9567g.equals(lVar.f9567g) && this.f9570j.equals(lVar.f9570j);
        }
        return false;
    }

    @Override // e.b.a.p.c
    public int hashCode() {
        if (this.f9571k == 0) {
            int hashCode = this.f9563c.hashCode();
            this.f9571k = hashCode;
            int hashCode2 = (hashCode * 31) + this.f9568h.hashCode();
            this.f9571k = hashCode2;
            int i2 = (hashCode2 * 31) + this.f9564d;
            this.f9571k = i2;
            int i3 = (i2 * 31) + this.f9565e;
            this.f9571k = i3;
            int hashCode3 = (i3 * 31) + this.f9569i.hashCode();
            this.f9571k = hashCode3;
            int hashCode4 = (hashCode3 * 31) + this.f9566f.hashCode();
            this.f9571k = hashCode4;
            int hashCode5 = (hashCode4 * 31) + this.f9567g.hashCode();
            this.f9571k = hashCode5;
            this.f9571k = (hashCode5 * 31) + this.f9570j.hashCode();
        }
        return this.f9571k;
    }

    public String toString() {
        return "EngineKey{model=" + this.f9563c + ", width=" + this.f9564d + ", height=" + this.f9565e + ", resourceClass=" + this.f9566f + ", transcodeClass=" + this.f9567g + ", signature=" + this.f9568h + ", hashCode=" + this.f9571k + ", transformations=" + this.f9569i + ", options=" + this.f9570j + '}';
    }

    @Override // e.b.a.p.c
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        throw new UnsupportedOperationException();
    }
}
