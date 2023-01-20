package kotlin.reflect.jvm.internal;

import androidx.exifinterface.media.ExifInterface;
import h.k2.u.a;
import h.p2.b0.g.t.b.f;
import h.p2.b0.g.t.k.c;
import h.p2.b0.g.t.n.z;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import k.e.a.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.KClassImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u0016\u0012\u0004\u0012\u00020\u0002 \u0003*\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00010\u0001\"\b\b\u0000\u0010\u0004*\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KTypeImpl;", "kotlin.jvm.PlatformType", ExifInterface.GPS_DIRECTION_TRUE, "", "invoke"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class KClassImpl$Data$supertypes$2 extends Lambda implements a<List<? extends KTypeImpl>> {
    public final /* synthetic */ KClassImpl.Data this$0;

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Ljava/lang/reflect/Type;", ExifInterface.GPS_DIRECTION_TRUE, "", "invoke"}, k = 3, mv = {1, 5, 1})
    /* renamed from: kotlin.reflect.jvm.internal.KClassImpl$Data$supertypes$2$3  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass3 extends Lambda implements a<Type> {
        public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

        public AnonymousClass3() {
            super(0);
        }

        @Override // h.k2.u.a
        @d
        public final Type invoke() {
            return Object.class;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KClassImpl$Data$supertypes$2(KClassImpl.Data data) {
        super(0);
        this.this$0 = data;
    }

    @Override // h.k2.u.a
    public final List<? extends KTypeImpl> invoke() {
        boolean z;
        Collection<z> j2 = this.this$0.o().j().j();
        ArrayList<KTypeImpl> arrayList = new ArrayList(j2.size());
        for (z zVar : j2) {
            arrayList.add(new KTypeImpl(zVar, new KClassImpl$Data$supertypes$2$$special$$inlined$mapTo$lambda$1(zVar, this)));
        }
        if (!f.r0(this.this$0.o())) {
            boolean z2 = false;
            if (!arrayList.isEmpty()) {
                for (KTypeImpl kTypeImpl : arrayList) {
                    ClassKind i2 = c.e(kTypeImpl.getType()).i();
                    if (i2 == ClassKind.INTERFACE || i2 == ClassKind.ANNOTATION_CLASS) {
                        z = true;
                        continue;
                    } else {
                        z = false;
                        continue;
                    }
                    if (!z) {
                        break;
                    }
                }
            }
            z2 = true;
            if (z2) {
                arrayList.add(new KTypeImpl(DescriptorUtilsKt.g(this.this$0.o()).i(), AnonymousClass3.INSTANCE));
            }
        }
        return h.p2.b0.g.t.p.a.c(arrayList);
    }
}
