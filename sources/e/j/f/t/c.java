package e.j.f.t;

import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import e.j.f.k;
import java.util.Map;

/* loaded from: classes2.dex */
public interface c {
    k[] b(e.j.f.b bVar) throws NotFoundException;

    k[] d(e.j.f.b bVar, Map<DecodeHintType, ?> map) throws NotFoundException;
}
