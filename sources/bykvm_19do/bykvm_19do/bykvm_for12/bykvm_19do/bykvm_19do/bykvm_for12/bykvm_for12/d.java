package bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_for12;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.tencent.android.tpns.mqtt.MqttTopic;
import java.util.Map;

/* loaded from: classes.dex */
public class d {
    public boolean a = false;
    public boolean b = true;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, Integer> f235c = null;

    /* renamed from: d  reason: collision with root package name */
    public Map<String, String> f236d = null;

    /* renamed from: e  reason: collision with root package name */
    public int f237e = 10;

    /* renamed from: f  reason: collision with root package name */
    public int f238f = 1;

    /* renamed from: g  reason: collision with root package name */
    public int f239g = 1;

    /* renamed from: h  reason: collision with root package name */
    public int f240h = 10;

    /* renamed from: i  reason: collision with root package name */
    public int f241i = 1;

    /* renamed from: j  reason: collision with root package name */
    public int f242j = 1;

    /* renamed from: k  reason: collision with root package name */
    public int f243k = TypedValues.Custom.TYPE_INT;

    /* renamed from: l  reason: collision with root package name */
    public int f244l = 120;

    /* renamed from: m  reason: collision with root package name */
    public String f245m = null;

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(" localEnable: ");
        sb.append(this.a);
        sb.append(" probeEnable: ");
        sb.append(this.b);
        sb.append(" hostFilter: ");
        Map<String, Integer> map = this.f235c;
        sb.append(map != null ? map.size() : 0);
        sb.append(" hostMap: ");
        Map<String, String> map2 = this.f236d;
        sb.append(map2 != null ? map2.size() : 0);
        sb.append(" reqTo: ");
        sb.append(this.f237e);
        sb.append(MqttTopic.MULTI_LEVEL_WILDCARD);
        sb.append(this.f238f);
        sb.append(MqttTopic.MULTI_LEVEL_WILDCARD);
        sb.append(this.f239g);
        sb.append(" reqErr: ");
        sb.append(this.f240h);
        sb.append(MqttTopic.MULTI_LEVEL_WILDCARD);
        sb.append(this.f241i);
        sb.append(MqttTopic.MULTI_LEVEL_WILDCARD);
        sb.append(this.f242j);
        sb.append(" updateInterval: ");
        sb.append(this.f243k);
        sb.append(" updateRandom: ");
        sb.append(this.f244l);
        sb.append(" httpBlack: ");
        sb.append(this.f245m);
        return sb.toString();
    }
}
