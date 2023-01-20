package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import h.a2.t0;
import h.k2.v.u;
import h.z0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import k.e.a.d;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt___CollectionsKt;

/* loaded from: classes3.dex */
public enum KotlinTarget {
    CLASS("class", false, 2, null),
    ANNOTATION_CLASS("annotation class", false, 2, null),
    TYPE_PARAMETER("type parameter", false),
    PROPERTY("property", false, 2, null),
    FIELD("field", false, 2, null),
    LOCAL_VARIABLE("local variable", false, 2, null),
    VALUE_PARAMETER("value parameter", false, 2, null),
    CONSTRUCTOR("constructor", false, 2, null),
    FUNCTION("function", false, 2, null),
    PROPERTY_GETTER("getter", false, 2, null),
    PROPERTY_SETTER("setter", false, 2, null),
    TYPE("type usage", false),
    EXPRESSION("expression", false),
    FILE("file", false),
    TYPEALIAS("typealias", false),
    TYPE_PROJECTION("type projection", false),
    STAR_PROJECTION("star projection", false),
    PROPERTY_PARAMETER("property constructor parameter", false),
    CLASS_ONLY("class", false),
    OBJECT("object", false),
    COMPANION_OBJECT("companion object", false),
    INTERFACE("interface", false),
    ENUM_CLASS("enum class", false),
    ENUM_ENTRY("enum entry", false),
    LOCAL_CLASS("local class", false),
    LOCAL_FUNCTION("local function", false),
    MEMBER_FUNCTION("member function", false),
    TOP_LEVEL_FUNCTION("top level function", false),
    MEMBER_PROPERTY("member property", false),
    MEMBER_PROPERTY_WITH_BACKING_FIELD("member property with backing field", false),
    MEMBER_PROPERTY_WITH_DELEGATE("member property with delegate", false),
    MEMBER_PROPERTY_WITHOUT_FIELD_OR_DELEGATE("member property without backing field or delegate", false),
    TOP_LEVEL_PROPERTY("top level property", false),
    TOP_LEVEL_PROPERTY_WITH_BACKING_FIELD("top level property with backing field", false),
    TOP_LEVEL_PROPERTY_WITH_DELEGATE("top level property with delegate", false),
    TOP_LEVEL_PROPERTY_WITHOUT_FIELD_OR_DELEGATE("top level property without backing field or delegate", false),
    INITIALIZER("initializer", false),
    DESTRUCTURING_DECLARATION("destructuring declaration", false),
    LAMBDA_EXPRESSION("lambda expression", false),
    ANONYMOUS_FUNCTION("anonymous function", false),
    OBJECT_LITERAL("object literal", false);
    
    @d
    private static final Set<KotlinTarget> ALL_TARGET_SET;
    @d
    private static final Set<KotlinTarget> DEFAULT_TARGET_SET;
    @d
    private static final Map<AnnotationUseSiteTarget, KotlinTarget> USE_SITE_MAPPING;
    @d
    private final String description;
    private final boolean isDefault;
    @d
    public static final a Companion = new a(null);
    @d
    private static final HashMap<String, KotlinTarget> map = new HashMap<>();

    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }
    }

    static {
        KotlinTarget[] values = values();
        int length = values.length;
        int i2 = 0;
        while (i2 < length) {
            KotlinTarget kotlinTarget = values[i2];
            i2++;
            map.put(kotlinTarget.name(), kotlinTarget);
        }
        KotlinTarget[] values2 = values();
        ArrayList arrayList = new ArrayList();
        for (KotlinTarget kotlinTarget2 : values2) {
            if (kotlinTarget2.isDefault()) {
                arrayList.add(kotlinTarget2);
            }
        }
        DEFAULT_TARGET_SET = CollectionsKt___CollectionsKt.N5(arrayList);
        ALL_TARGET_SET = ArraysKt___ArraysKt.Gy(values());
        AnnotationUseSiteTarget annotationUseSiteTarget = AnnotationUseSiteTarget.CONSTRUCTOR_PARAMETER;
        KotlinTarget kotlinTarget3 = VALUE_PARAMETER;
        AnnotationUseSiteTarget annotationUseSiteTarget2 = AnnotationUseSiteTarget.FIELD;
        KotlinTarget kotlinTarget4 = FIELD;
        USE_SITE_MAPPING = t0.W(z0.a(annotationUseSiteTarget, kotlinTarget3), z0.a(annotationUseSiteTarget2, kotlinTarget4), z0.a(AnnotationUseSiteTarget.PROPERTY, PROPERTY), z0.a(AnnotationUseSiteTarget.FILE, FILE), z0.a(AnnotationUseSiteTarget.PROPERTY_GETTER, PROPERTY_GETTER), z0.a(AnnotationUseSiteTarget.PROPERTY_SETTER, PROPERTY_SETTER), z0.a(AnnotationUseSiteTarget.RECEIVER, kotlinTarget3), z0.a(AnnotationUseSiteTarget.SETTER_PARAMETER, kotlinTarget3), z0.a(AnnotationUseSiteTarget.PROPERTY_DELEGATE_FIELD, kotlinTarget4));
    }

    KotlinTarget(String str, boolean z) {
        this.description = str;
        this.isDefault = z;
    }

    public final boolean isDefault() {
        return this.isDefault;
    }

    /* synthetic */ KotlinTarget(String str, boolean z, int i2, u uVar) {
        this(str, (i2 & 2) != 0 ? true : z);
    }
}
