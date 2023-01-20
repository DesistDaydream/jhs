package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b;

import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.adapter.util.ThreadHelper;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public class k {
    private static final String b = "TTMediationSDK_" + k.class.getSimpleName();
    private Map<String, Pair<String, String>> a;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;

        public a(String str, String str2) {
            this.a = str;
            this.b = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str = k.b;
            Logger.d(str, "adn addShowFreqctlCount ritId = " + this.a + " adnSlotId = " + this.b);
            g e2 = k.this.e(this.a, this.b);
            if (e2 == null || !e2.a()) {
                return;
            }
            for (e eVar : e2.i()) {
                if (eVar.a() < eVar.c()) {
                    k.this.a(e2, eVar.d(), eVar.a() + 1);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        private static k a = new k(null);
    }

    private k() {
        this.a = new ConcurrentHashMap();
    }

    public /* synthetic */ k(a aVar) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(g gVar, String str, int i2) {
        h.a().a(gVar, str, i2);
    }

    private void a(g gVar, String str, long j2) {
        h.a().a(gVar, str, j2);
    }

    public static k b() {
        return b.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public g e(String str, String str2) {
        return h.a().b(str, str2);
    }

    public void a(String str, String str2) {
        ThreadHelper.runOnMSDKThread(new a(str, str2));
    }

    public boolean a(g gVar) {
        if (gVar != null) {
            g e2 = e(gVar.d(), gVar.c());
            if (e2 == null) {
                Logger.d(b, "adn freqctl 规则为空直接存储");
                return true;
            } else if (TextUtils.isEmpty(gVar.b())) {
                Logger.d(b, "adn freqctl version 为空 清空本地数据 ");
                c(e2.d(), e2.c());
            } else if (!TextUtils.equals(e2.b(), gVar.b())) {
                String str = b;
                Logger.d(str, "adn freqctl version不一致，缓存新规则 old version = " + e2.b() + "  new version " + gVar.b());
                return true;
            } else {
                String str2 = b;
                Logger.d(str2, "adn freqctl version 一致 version = " + e2.b() + " 无需处理");
            }
        }
        return false;
    }

    public void b(g gVar) {
        m.b().b(gVar);
    }

    public boolean b(String str, String str2) {
        StringBuilder sb;
        String str3 = b;
        Logger.d(str3, "adn checkFreqctl ritId = " + str + " adnSlotId = " + str2);
        g e2 = e(str, str2);
        if (e2 != null && e2.a()) {
            for (e eVar : e2.i()) {
                Date date = new Date();
                String str4 = b;
                Logger.d(str4, "adn checkFreqctl ritId = " + str + " adnSlotId = " + str2 + "  date = " + date.getTime() + " item.getEffectiveTime() = " + eVar.b());
                if (date.getTime() > eVar.b()) {
                    a(e2, eVar.d(), 0);
                    a(e2, eVar.d(), f.a(eVar.e()));
                    sb = new StringBuilder();
                    sb.append("adn checkFreqctl 有效期外计数需要清0，过期时间需要更新 = ");
                    sb.append(eVar.d());
                } else if (eVar.a() >= eVar.c()) {
                    Logger.d(str4, "adn checkFreqctl 到了上线不可以展示 ritId = " + str + " adnSlotId = " + str2 + " ruleId = " + eVar.d() + " count = " + eVar.a());
                    Map<String, Pair<String, String>> map = this.a;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(str);
                    sb2.append("_");
                    sb2.append(str2);
                    String sb3 = sb2.toString();
                    String d2 = eVar.d();
                    map.put(sb3, new Pair<>(d2, eVar.a() + ""));
                    return false;
                } else {
                    sb = new StringBuilder();
                    sb.append("adn checkFreqctl 未到上线可以展示 ritId = ");
                    sb.append(str);
                    sb.append(" adnSlotId = ");
                    sb.append(str2);
                    sb.append(" ruleId = ");
                    sb.append(eVar.d());
                    sb.append(" count = ");
                    sb.append(eVar.a());
                }
                Logger.d(str4, sb.toString());
            }
        }
        return true;
    }

    public void c(String str, String str2) {
        h.a().a(str, str2);
    }

    public Pair<String, String> d(String str, String str2) {
        Map<String, Pair<String, String>> map = this.a;
        return map.get(str + "_" + str2);
    }
}
