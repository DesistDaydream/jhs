package e.b.a.p.k.y;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import e.b.a.p.k.s;
import e.b.a.p.k.y.j;

/* loaded from: classes.dex */
public class i extends e.b.a.v.i<e.b.a.p.c, s<?>> implements j {

    /* renamed from: e  reason: collision with root package name */
    private j.a f9647e;

    public i(long j2) {
        super(j2);
    }

    @Override // e.b.a.p.k.y.j
    @SuppressLint({"InlinedApi"})
    public void a(int i2) {
        if (i2 >= 40) {
            b();
        } else if (i2 >= 20 || i2 == 15) {
            p(e() / 2);
        }
    }

    @Override // e.b.a.p.k.y.j
    @Nullable
    public /* bridge */ /* synthetic */ s d(@NonNull e.b.a.p.c cVar, @Nullable s sVar) {
        return (s) super.n(cVar, sVar);
    }

    @Override // e.b.a.p.k.y.j
    @Nullable
    public /* bridge */ /* synthetic */ s f(@NonNull e.b.a.p.c cVar) {
        return (s) super.o(cVar);
    }

    @Override // e.b.a.p.k.y.j
    public void g(@NonNull j.a aVar) {
        this.f9647e = aVar;
    }

    @Override // e.b.a.v.i
    /* renamed from: q */
    public int l(@Nullable s<?> sVar) {
        if (sVar == null) {
            return super.l(null);
        }
        return sVar.getSize();
    }

    @Override // e.b.a.v.i
    /* renamed from: r */
    public void m(@NonNull e.b.a.p.c cVar, @Nullable s<?> sVar) {
        j.a aVar = this.f9647e;
        if (aVar == null || sVar == null) {
            return;
        }
        aVar.a(sVar);
    }
}
