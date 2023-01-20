package kotlin.jvm.internal;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import h.k2.u.l;
import h.p2.t;
import k.e.a.d;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", AdvanceSetting.NETWORK_TYPE, "Lkotlin/reflect/KTypeProjection;", "invoke"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class TypeReference$asString$args$1 extends Lambda implements l<t, CharSequence> {
    public final /* synthetic */ TypeReference this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TypeReference$asString$args$1(TypeReference typeReference) {
        super(1);
        this.this$0 = typeReference;
    }

    @Override // h.k2.u.l
    @d
    public final CharSequence invoke(@d t tVar) {
        String h2;
        h2 = this.this$0.h(tVar);
        return h2;
    }
}
