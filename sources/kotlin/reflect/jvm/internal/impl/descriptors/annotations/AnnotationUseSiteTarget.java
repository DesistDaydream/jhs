package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import com.huawei.hms.push.constant.RemoteMessageConst;
import h.k2.v.u;
import h.p2.b0.g.t.o.j.a;
import k.e.a.d;

/* loaded from: classes3.dex */
public enum AnnotationUseSiteTarget {
    FIELD(null, 1, null),
    FILE(null, 1, null),
    PROPERTY(null, 1, null),
    PROPERTY_GETTER("get"),
    PROPERTY_SETTER("set"),
    RECEIVER(null, 1, null),
    CONSTRUCTOR_PARAMETER(RemoteMessageConst.MessageBody.PARAM),
    SETTER_PARAMETER("setparam"),
    PROPERTY_DELEGATE_FIELD("delegate");
    
    @d
    private final String renderName;

    AnnotationUseSiteTarget(String str) {
        this.renderName = str == null ? a.f(name()) : str;
    }

    @d
    public final String getRenderName() {
        return this.renderName;
    }

    /* synthetic */ AnnotationUseSiteTarget(String str, int i2, u uVar) {
        this((i2 & 1) != 0 ? null : str);
    }
}
