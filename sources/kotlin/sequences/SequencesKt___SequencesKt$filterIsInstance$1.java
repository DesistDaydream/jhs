package kotlin.sequences;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import h.k2.u.l;
import h.k2.v.f0;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "R", AdvanceSetting.NETWORK_TYPE, "", "invoke"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes4.dex */
public final class SequencesKt___SequencesKt$filterIsInstance$1 extends Lambda implements l<Object, Boolean> {
    public static final SequencesKt___SequencesKt$filterIsInstance$1 INSTANCE = new SequencesKt___SequencesKt$filterIsInstance$1();

    public SequencesKt___SequencesKt$filterIsInstance$1() {
        super(1);
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ Boolean invoke(Object obj) {
        return Boolean.valueOf(invoke2(obj));
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [boolean, java.lang.Boolean] */
    @Override // h.k2.u.l
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final Boolean invoke2(@e Object obj) {
        f0.y(3, "R");
        return obj instanceof Object;
    }
}
