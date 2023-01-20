package kotlin.text;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import h.k2.u.l;
import h.o2.k;
import k.e.a.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", AdvanceSetting.NETWORK_TYPE, "Lkotlin/ranges/IntRange;", "invoke"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes4.dex */
public final class StringsKt__StringsKt$splitToSequence$2 extends Lambda implements l<k, String> {
    public final /* synthetic */ CharSequence $this_splitToSequence;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StringsKt__StringsKt$splitToSequence$2(CharSequence charSequence) {
        super(1);
        this.$this_splitToSequence = charSequence;
    }

    @Override // h.k2.u.l
    @d
    public final String invoke(@d k kVar) {
        return StringsKt__StringsKt.g5(this.$this_splitToSequence, kVar);
    }
}
