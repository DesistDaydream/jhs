package kotlin.reflect;

import h.k2.u.l;
import k.e.a.d;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u0012\u0012\u0002\b\u0003 \u0002*\b\u0012\u0002\b\u0003\u0018\u00010\u00010\u00012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0001¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Ljava/lang/Class;", "kotlin.jvm.PlatformType", "p1", "invoke"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final /* synthetic */ class TypesJVMKt$typeToString$unwrap$1 extends FunctionReferenceImpl implements l<Class<? extends Object>, Class<?>> {
    public static final TypesJVMKt$typeToString$unwrap$1 INSTANCE = new TypesJVMKt$typeToString$unwrap$1();

    public TypesJVMKt$typeToString$unwrap$1() {
        super(1, Class.class, "getComponentType", "getComponentType()Ljava/lang/Class;", 0);
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final Class<?> invoke2(@d Class<?> cls) {
        return cls.getComponentType();
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ Class<?> invoke(Class<? extends Object> cls) {
        return invoke2((Class<?>) cls);
    }
}
