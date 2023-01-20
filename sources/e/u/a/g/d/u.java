package e.u.a.g.d;

import com.tencent.android.tpns.mqtt.MqttTopic;
import kotlin.Metadata;
import kotlin.text.StringsKt___StringsKt;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0001*\u0016\u0010\u0002\"\b\u0012\u0004\u0012\u00020\u00040\u00032\b\u0012\u0004\u0012\u00020\u00040\u0003¨\u0006\u0005"}, d2 = {"getPinYinFirstCap", "", "HostVisibleListener", "Lkotlin/Function0;", "", "address-selector_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class u {
    @k.e.a.d
    public static final String a(@k.e.a.d String str) {
        return String.valueOf(StringsKt___StringsKt.L6(e.i.b.a.c.h(str, MqttTopic.TOPIC_LEVEL_SEPARATOR)));
    }
}
