package kotlin.reflect.jvm.internal;

import androidx.exifinterface.media.ExifInterface;
import h.k2.u.a;
import h.p2.b0.g.q;
import h.p2.b0.g.t.c.d;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.KClassImpl;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a&\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u0002H\u00030\u0002 \u0004*\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u0002H\u00030\u0002\u0018\u00010\u00010\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KClassImpl;", ExifInterface.GPS_DIRECTION_TRUE, "kotlin.jvm.PlatformType", "", "invoke"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class KClassImpl$Data$sealedSubclasses$2 extends Lambda implements a<List<? extends KClassImpl<? extends T>>> {
    public final /* synthetic */ KClassImpl.Data this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KClassImpl$Data$sealedSubclasses$2(KClassImpl.Data data) {
        super(0);
        this.this$0 = data;
    }

    @Override // h.k2.u.a
    public final List<KClassImpl<? extends T>> invoke() {
        Collection<d> m2 = this.this$0.o().m();
        ArrayList arrayList = new ArrayList();
        for (d dVar : m2) {
            Objects.requireNonNull(dVar, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
            Class<?> o = q.o(dVar);
            KClassImpl kClassImpl = o != null ? new KClassImpl(o) : null;
            if (kClassImpl != null) {
                arrayList.add(kClassImpl);
            }
        }
        return arrayList;
    }
}
