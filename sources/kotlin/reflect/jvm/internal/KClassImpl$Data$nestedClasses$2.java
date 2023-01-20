package kotlin.reflect.jvm.internal;

import androidx.exifinterface.media.ExifInterface;
import h.k2.u.a;
import h.p2.b0.g.q;
import h.p2.b0.g.t.c.d;
import h.p2.b0.g.t.c.k;
import h.p2.b0.g.t.k.c;
import h.p2.b0.g.t.k.r.h;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.KClassImpl;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0000\u001a6\u0012\u0014\u0012\u0012\u0012\u000e\b\u0001\u0012\n \u0004*\u0004\u0018\u00010\u00030\u00030\u0002 \u0004*\u001a\u0012\u0014\u0012\u0012\u0012\u000e\b\u0001\u0012\n \u0004*\u0004\u0018\u00010\u00030\u00030\u0002\u0018\u00010\u00010\u0001\"\b\b\u0000\u0010\u0005*\u00020\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KClassImpl;", "", "kotlin.jvm.PlatformType", ExifInterface.GPS_DIRECTION_TRUE, "invoke"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class KClassImpl$Data$nestedClasses$2 extends Lambda implements a<List<? extends KClassImpl<? extends Object>>> {
    public final /* synthetic */ KClassImpl.Data this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KClassImpl$Data$nestedClasses$2(KClassImpl.Data data) {
        super(0);
        this.this$0 = data;
    }

    @Override // h.k2.u.a
    public final List<? extends KClassImpl<? extends Object>> invoke() {
        Collection a = h.a.a(this.this$0.o().U(), null, null, 3, null);
        ArrayList<k> arrayList = new ArrayList();
        for (Object obj : a) {
            if (!c.B((k) obj)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (k kVar : arrayList) {
            Objects.requireNonNull(kVar, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
            Class<?> o = q.o((d) kVar);
            KClassImpl kClassImpl = o != null ? new KClassImpl(o) : null;
            if (kClassImpl != null) {
                arrayList2.add(kClassImpl);
            }
        }
        return arrayList2;
    }
}
