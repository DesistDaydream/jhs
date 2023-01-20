package kotlin.reflect.jvm.internal.impl.renderer;

import h.k2.d;
import h.k2.v.u;
import java.util.ArrayList;
import java.util.Set;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt___CollectionsKt;

/* loaded from: classes3.dex */
public enum DescriptorRendererModifier {
    VISIBILITY(true),
    MODALITY(true),
    OVERRIDE(true),
    ANNOTATIONS(false),
    INNER(true),
    MEMBER_KIND(true),
    DATA(true),
    INLINE(true),
    EXPECT(true),
    ACTUAL(true),
    CONST(true),
    LATEINIT(true),
    FUN(true),
    VALUE(true);
    
    @d
    @k.e.a.d
    public static final Set<DescriptorRendererModifier> ALL;
    @d
    @k.e.a.d
    public static final Set<DescriptorRendererModifier> ALL_EXCEPT_ANNOTATIONS;
    @k.e.a.d
    public static final a Companion = new a(null);
    private final boolean includeByDefault;

    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }
    }

    static {
        DescriptorRendererModifier[] values = values();
        ArrayList arrayList = new ArrayList();
        for (DescriptorRendererModifier descriptorRendererModifier : values) {
            if (descriptorRendererModifier.getIncludeByDefault()) {
                arrayList.add(descriptorRendererModifier);
            }
        }
        ALL_EXCEPT_ANNOTATIONS = CollectionsKt___CollectionsKt.N5(arrayList);
        ALL = ArraysKt___ArraysKt.Gy(values());
    }

    DescriptorRendererModifier(boolean z) {
        this.includeByDefault = z;
    }

    public final boolean getIncludeByDefault() {
        return this.includeByDefault;
    }
}
