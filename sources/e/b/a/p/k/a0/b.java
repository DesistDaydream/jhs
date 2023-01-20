package e.b.a.p.k.a0;

import android.graphics.Bitmap;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.DecodeFormat;
import e.b.a.p.k.a0.d;
import e.b.a.p.k.x.e;
import e.b.a.p.k.y.j;
import e.b.a.v.n;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class b {
    private final j a;
    private final e b;

    /* renamed from: c  reason: collision with root package name */
    private final DecodeFormat f9499c;

    /* renamed from: d  reason: collision with root package name */
    private a f9500d;

    public b(j jVar, e eVar, DecodeFormat decodeFormat) {
        this.a = jVar;
        this.b = eVar;
        this.f9499c = decodeFormat;
    }

    private static int b(d dVar) {
        return n.g(dVar.d(), dVar.b(), dVar.a());
    }

    @VisibleForTesting
    public c a(d... dVarArr) {
        long e2 = (this.a.e() - this.a.getCurrentSize()) + this.b.e();
        int i2 = 0;
        for (d dVar : dVarArr) {
            i2 += dVar.c();
        }
        float f2 = ((float) e2) / i2;
        HashMap hashMap = new HashMap();
        for (d dVar2 : dVarArr) {
            hashMap.put(dVar2, Integer.valueOf(Math.round(dVar2.c() * f2) / b(dVar2)));
        }
        return new c(hashMap);
    }

    public void c(d.a... aVarArr) {
        Bitmap.Config config;
        a aVar = this.f9500d;
        if (aVar != null) {
            aVar.b();
        }
        d[] dVarArr = new d[aVarArr.length];
        for (int i2 = 0; i2 < aVarArr.length; i2++) {
            d.a aVar2 = aVarArr[i2];
            if (aVar2.b() == null) {
                if (this.f9499c == DecodeFormat.PREFER_ARGB_8888) {
                    config = Bitmap.Config.ARGB_8888;
                } else {
                    config = Bitmap.Config.RGB_565;
                }
                aVar2.c(config);
            }
            dVarArr[i2] = aVar2.a();
        }
        a aVar3 = new a(this.b, this.a, a(dVarArr));
        this.f9500d = aVar3;
        n.x(aVar3);
    }
}
