package kotlin.text;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import h.k2.u.l;
import h.t2.u;
import k.e.a.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", AdvanceSetting.NETWORK_TYPE, "invoke"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes4.dex */
public final class StringsKt__IndentKt$prependIndent$1 extends Lambda implements l<String, String> {
    public final /* synthetic */ String $indent;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StringsKt__IndentKt$prependIndent$1(String str) {
        super(1);
        this.$indent = str;
    }

    @Override // h.k2.u.l
    @d
    public final String invoke(@d String str) {
        if (u.U1(str)) {
            return str.length() < this.$indent.length() ? this.$indent : str;
        }
        return this.$indent + str;
    }
}
