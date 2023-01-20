package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import com.tencent.qcloud.tuikit.tuichat.TUIChatConstants;
import h.p2.b0.g.t.e.a.y.e;
import h.p2.b0.g.t.e.a.y.h;
import h.p2.b0.g.t.e.a.y.i;
import java.util.Map;
import k.e.a.d;
import kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents;

/* loaded from: classes3.dex */
public final class PredefinedEnhancementInfoKt {
    @d
    private static final e a = new e(NullabilityQualifier.NULLABLE, null, false, false, 8, null);
    @d
    private static final e b;
    @d

    /* renamed from: c  reason: collision with root package name */
    private static final e f16555c;
    @d

    /* renamed from: d  reason: collision with root package name */
    private static final Map<String, h> f16556d;

    static {
        NullabilityQualifier nullabilityQualifier = NullabilityQualifier.NOT_NULL;
        b = new e(nullabilityQualifier, null, false, false, 8, null);
        f16555c = new e(nullabilityQualifier, null, true, false, 8, null);
        SignatureBuildingComponents signatureBuildingComponents = SignatureBuildingComponents.a;
        String h2 = signatureBuildingComponents.h("Object");
        String g2 = signatureBuildingComponents.g("Predicate");
        String g3 = signatureBuildingComponents.g("Function");
        String g4 = signatureBuildingComponents.g("Consumer");
        String g5 = signatureBuildingComponents.g("BiFunction");
        String g6 = signatureBuildingComponents.g("BiConsumer");
        String g7 = signatureBuildingComponents.g("UnaryOperator");
        String i2 = signatureBuildingComponents.i("stream/Stream");
        String i3 = signatureBuildingComponents.i("Optional");
        i iVar = new i();
        new i.a(signatureBuildingComponents.i("Iterator")).a("forEachRemaining", new PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$1$1(g4));
        new i.a(signatureBuildingComponents.h("Iterable")).a("spliterator", new PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$2$1(signatureBuildingComponents));
        i.a aVar = new i.a(signatureBuildingComponents.i("Collection"));
        aVar.a("removeIf", new PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$3$1(g2));
        aVar.a("stream", new PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$3$2(i2));
        aVar.a("parallelStream", new PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$3$3(i2));
        new i.a(signatureBuildingComponents.i("List")).a("replaceAll", new PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$4$1(g7));
        i.a aVar2 = new i.a(signatureBuildingComponents.i("Map"));
        aVar2.a("forEach", new PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$5$1(g6));
        aVar2.a("putIfAbsent", new PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$5$2(h2));
        aVar2.a("replace", new PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$5$3(h2));
        aVar2.a("replace", new PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$5$4(h2));
        aVar2.a("replaceAll", new PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$5$5(g5));
        aVar2.a("compute", new PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$5$6(h2, g5));
        aVar2.a("computeIfAbsent", new PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$5$7(h2, g3));
        aVar2.a("computeIfPresent", new PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$5$8(h2, g5));
        aVar2.a("merge", new PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$5$9(h2, g5));
        i.a aVar3 = new i.a(i3);
        aVar3.a("empty", new PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$6$1(i3));
        aVar3.a("of", new PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$6$2(h2, i3));
        aVar3.a("ofNullable", new PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$6$3(h2, i3));
        aVar3.a("get", new PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$6$4(h2));
        aVar3.a("ifPresent", new PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$6$5(g4));
        new i.a(signatureBuildingComponents.h("ref/Reference")).a("get", new PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$7$1(h2));
        new i.a(g2).a("test", new PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$8$1(h2));
        new i.a(signatureBuildingComponents.g("BiPredicate")).a("test", new PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$9$1(h2));
        new i.a(g4).a("accept", new PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$10$1(h2));
        new i.a(g6).a("accept", new PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$11$1(h2));
        new i.a(g3).a(TUIChatConstants.Group.MEMBER_APPLY, new PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$12$1(h2));
        new i.a(g5).a(TUIChatConstants.Group.MEMBER_APPLY, new PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$13$1(h2));
        new i.a(signatureBuildingComponents.g("Supplier")).a("get", new PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$14$1(h2));
        f16556d = iVar.b();
    }

    @d
    public static final Map<String, h> d() {
        return f16556d;
    }
}
