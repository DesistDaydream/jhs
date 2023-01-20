package e.j.f.t.d.a;

import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.ReaderException;
import com.google.zxing.multi.qrcode.detector.MultiFinderPatternFinder;
import e.j.f.m;
import e.j.f.q.b;
import e.j.f.q.f;
import e.j.f.w.d.c;
import e.j.f.w.d.e;
import java.util.ArrayList;
import java.util.Map;

/* loaded from: classes2.dex */
public final class a extends c {

    /* renamed from: c  reason: collision with root package name */
    private static final f[] f11563c = new f[0];

    public a(b bVar) {
        super(bVar);
    }

    public f[] n(Map<DecodeHintType, ?> map) throws NotFoundException {
        e[] r = new MultiFinderPatternFinder(h(), map == null ? null : (m) map.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK)).r(map);
        if (r.length != 0) {
            ArrayList arrayList = new ArrayList();
            for (e eVar : r) {
                try {
                    arrayList.add(j(eVar));
                } catch (ReaderException unused) {
                }
            }
            if (arrayList.isEmpty()) {
                return f11563c;
            }
            return (f[]) arrayList.toArray(new f[arrayList.size()]);
        }
        throw NotFoundException.getNotFoundInstance();
    }
}
