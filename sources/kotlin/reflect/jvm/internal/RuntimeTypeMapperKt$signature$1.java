package kotlin.reflect.jvm.internal;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import h.k2.u.l;
import k.e.a.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0016\u0010\u0002\u001a\u0012\u0012\u0002\b\u0003 \u0004*\b\u0012\u0002\b\u0003\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", AdvanceSetting.NETWORK_TYPE, "Ljava/lang/Class;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class RuntimeTypeMapperKt$signature$1 extends Lambda implements l<Class<?>, CharSequence> {
    public static final RuntimeTypeMapperKt$signature$1 INSTANCE = new RuntimeTypeMapperKt$signature$1();

    public RuntimeTypeMapperKt$signature$1() {
        super(1);
    }

    @Override // h.k2.u.l
    @d
    public final CharSequence invoke(Class<?> cls) {
        return ReflectClassUtilKt.b(cls);
    }
}
