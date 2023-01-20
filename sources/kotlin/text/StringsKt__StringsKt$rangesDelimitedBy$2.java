package kotlin.text;

import h.k2.u.p;
import h.z0;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\r\n\u0002\b\u0002\u0010\u0000\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0002H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "", "", "currentIndex", "invoke"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes4.dex */
public final class StringsKt__StringsKt$rangesDelimitedBy$2 extends Lambda implements p<CharSequence, Integer, Pair<? extends Integer, ? extends Integer>> {
    public final /* synthetic */ char[] $delimiters;
    public final /* synthetic */ boolean $ignoreCase;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StringsKt__StringsKt$rangesDelimitedBy$2(char[] cArr, boolean z) {
        super(2);
        this.$delimiters = cArr;
        this.$ignoreCase = z;
    }

    @Override // h.k2.u.p
    public /* bridge */ /* synthetic */ Pair<? extends Integer, ? extends Integer> invoke(CharSequence charSequence, Integer num) {
        return invoke(charSequence, num.intValue());
    }

    @e
    public final Pair<Integer, Integer> invoke(@d CharSequence charSequence, int i2) {
        int t3 = StringsKt__StringsKt.t3(charSequence, this.$delimiters, i2, this.$ignoreCase);
        if (t3 < 0) {
            return null;
        }
        return z0.a(Integer.valueOf(t3), 1);
    }
}
