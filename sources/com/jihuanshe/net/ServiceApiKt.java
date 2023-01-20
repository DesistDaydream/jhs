package com.jihuanshe.net;

import com.jihuanshe.net.config.NetService;
import e.l.n.b;
import h.w;
import h.z;
import k.e.a.d;
import okhttp3.FormBody;

/* loaded from: classes2.dex */
public final class ServiceApiKt {
    @d
    private static final w a = z.c(ServiceApiKt$emptyFormBody$2.INSTANCE);

    @d
    public static final FormBody a() {
        return (FormBody) a.getValue();
    }

    @d
    public static final <T> NetService b(@d Class<T> cls) {
        b bVar = (b) cls.getAnnotation(b.class);
        if (bVar != null) {
            return bVar.service();
        }
        throw new IllegalArgumentException("Missing Api @ServiceApi Annotation");
    }
}
