package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import h.p2.b0.g.t.e.b.m;
import h.p2.b0.g.t.k.p.d;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;

/* loaded from: classes3.dex */
public final class LazyJavaPackageFragment$partToFacade$2 extends Lambda implements h.k2.u.a<HashMap<d, d>> {
    public final /* synthetic */ LazyJavaPackageFragment this$0;

    /* loaded from: classes3.dex */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[KotlinClassHeader.Kind.values().length];
            iArr[KotlinClassHeader.Kind.MULTIFILE_CLASS_PART.ordinal()] = 1;
            iArr[KotlinClassHeader.Kind.FILE_FACADE.ordinal()] = 2;
            a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyJavaPackageFragment$partToFacade$2(LazyJavaPackageFragment lazyJavaPackageFragment) {
        super(0);
        this.this$0 = lazyJavaPackageFragment;
    }

    @Override // h.k2.u.a
    @k.e.a.d
    public final HashMap<d, d> invoke() {
        HashMap<d, d> hashMap = new HashMap<>();
        for (Map.Entry<String, m> entry : this.this$0.I0().entrySet()) {
            d d2 = d.d(entry.getKey());
            KotlinClassHeader c2 = entry.getValue().c();
            int i2 = a.a[c2.c().ordinal()];
            if (i2 == 1) {
                String e2 = c2.e();
                if (e2 != null) {
                    hashMap.put(d2, d.d(e2));
                }
            } else if (i2 == 2) {
                hashMap.put(d2, d2);
            }
        }
        return hashMap;
    }
}
