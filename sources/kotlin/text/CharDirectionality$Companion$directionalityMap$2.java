package kotlin.text;

import h.a2.s0;
import h.k2.u.a;
import h.o2.q;
import java.util.LinkedHashMap;
import java.util.Map;
import k.e.a.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "", "Lkotlin/text/CharDirectionality;", "invoke"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes4.dex */
public final class CharDirectionality$Companion$directionalityMap$2 extends Lambda implements a<Map<Integer, ? extends CharDirectionality>> {
    public static final CharDirectionality$Companion$directionalityMap$2 INSTANCE = new CharDirectionality$Companion$directionalityMap$2();

    public CharDirectionality$Companion$directionalityMap$2() {
        super(0);
    }

    @Override // h.k2.u.a
    @d
    public final Map<Integer, ? extends CharDirectionality> invoke() {
        CharDirectionality[] values = CharDirectionality.values();
        LinkedHashMap linkedHashMap = new LinkedHashMap(q.n(s0.j(values.length), 16));
        for (CharDirectionality charDirectionality : values) {
            linkedHashMap.put(Integer.valueOf(charDirectionality.getValue()), charDirectionality);
        }
        return linkedHashMap;
    }
}
