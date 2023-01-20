package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b;

import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.adapter.util.ThreadHelper;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public class m {
    private Map<String, Long> a;
    private Map<String, Pair<String, String>> b;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public final /* synthetic */ String a;

        public a(String str) {
            m.this = r1;
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Logger.d("TTMediationSDK_IntervalShowControl", "updateShowPacingTime ritId = " + this.a);
            i i2 = m.this.i(this.a);
            if (i2 == null || !i2.a()) {
                return;
            }
            Date date = new Date();
            Logger.d("TTMediationSDK_IntervalShowControl", "updateShowPacingTime save time = " + f.b(date.getTime()));
            m.this.a(this.a, date.getTime());
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public final /* synthetic */ String a;

        public b(String str) {
            m.this = r1;
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Logger.d("TTMediationSDK_IntervalShowControl", "addShowFreqctlCount ritId = " + this.a);
            g h2 = m.this.h(this.a);
            if (h2 == null || !h2.a()) {
                return;
            }
            for (e eVar : h2.i()) {
                if (eVar.a() < eVar.c()) {
                    m.this.a(h2, eVar.d(), eVar.a() + 1);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class c {
        private static m a = new m(null);
    }

    private m() {
        a();
    }

    public /* synthetic */ m(a aVar) {
        this();
    }

    public void a(g gVar, String str, int i2) {
        h.a().a(gVar, str, i2);
    }

    private void a(g gVar, String str, long j2) {
        h.a().a(gVar, str, j2);
    }

    public static m b() {
        return c.a;
    }

    public void a() {
        this.b = new ConcurrentHashMap();
        this.a = new ConcurrentHashMap();
    }

    public void a(String str) {
        ThreadHelper.runOnMSDKThread(new b(str));
    }

    public void a(String str, long j2) {
        j.a().a(str, j2);
    }

    public boolean a(g gVar) {
        String str;
        if (gVar != null) {
            g h2 = h(gVar.d());
            if (h2 == null) {
                str = "freqctl 规则为空直接存储";
            } else if (TextUtils.isEmpty(gVar.e())) {
                Logger.d("TTMediationSDK_IntervalShowControl", "freqctl version 为空 清空本地数据 ");
                d(h2.d());
            } else if (TextUtils.equals(h2.e(), gVar.e())) {
                Logger.d("TTMediationSDK_IntervalShowControl", "freqctl version 一致 version = " + h2.e() + "无需处理");
            } else {
                str = "freqctl version不一致，缓存新规则 old version = " + h2.e() + "  new version " + gVar.e();
            }
            Logger.d("TTMediationSDK_IntervalShowControl", str);
            return true;
        }
        return false;
    }

    public boolean a(i iVar) {
        if (iVar != null) {
            i i2 = i(iVar.d());
            if (i2 == null) {
                Logger.d("TTMediationSDK_IntervalShowControl", "pacing 规则为空直接存储");
                return true;
            } else if (TextUtils.isEmpty(iVar.j())) {
                Logger.d("TTMediationSDK_IntervalShowControl", "pacing ruleId 为空 清空本地数据 ");
                e(iVar.g());
            } else if (!TextUtils.equals(i2.j(), iVar.j())) {
                Logger.d("TTMediationSDK_IntervalShowControl", "pacing ruleId不一致，缓存新规则 old ruleId = " + i2.j() + "  new ruleId = " + iVar.j());
                StringBuilder sb = new StringBuilder();
                sb.append("pacing 删除 ritId = ");
                sb.append(iVar.g());
                Logger.d("TTMediationSDK_IntervalShowControl", sb.toString());
                e(iVar.g());
                return true;
            } else {
                Logger.d("TTMediationSDK_IntervalShowControl", "pacing ruleId 一致 ruleId = " + i2.j() + " 无需处理");
            }
        }
        return false;
    }

    public void b(g gVar) {
        h.a().a(gVar);
    }

    public void b(i iVar) {
        j.a().a(iVar);
    }

    public boolean b(String str) {
        StringBuilder sb;
        g h2 = h(str);
        if (h2 != null && h2.a()) {
            for (e eVar : h2.i()) {
                Date date = new Date();
                Logger.d("TTMediationSDK_IntervalShowControl", "checkFreqctl date = " + date.getTime() + " item.getEffectiveTime() = " + eVar.b());
                if (date.getTime() > eVar.b()) {
                    a(h2, eVar.d(), 0);
                    a(h2, eVar.d(), f.a(eVar.e()));
                    sb = new StringBuilder();
                    sb.append("checkFreqctl 有效期外计数需要清0，过期时间需要更新 = ");
                    sb.append(eVar.d());
                } else if (eVar.a() >= eVar.c()) {
                    Logger.d("TTMediationSDK_IntervalShowControl", "checkFreqctl 到了上线不可以展示 ruleId = " + eVar.d() + " count = " + eVar.a());
                    Map<String, Pair<String, String>> map = this.b;
                    String d2 = eVar.d();
                    map.put(str, new Pair<>(d2, eVar.a() + ""));
                    return false;
                } else {
                    sb = new StringBuilder();
                    sb.append("checkFreqctl 未到上线可以展示 ruleId = ");
                    sb.append(eVar.d());
                    sb.append(" count = ");
                    sb.append(eVar.a());
                }
                Logger.d("TTMediationSDK_IntervalShowControl", sb.toString());
            }
        }
        return true;
    }

    public boolean c(String str) {
        i i2 = i(str);
        if (i2 != null && i2.a() && i2.l()) {
            long time = new Date().getTime();
            long k2 = i2.k();
            long k3 = i2.k() + i2.i();
            Logger.d("TTMediationSDK_IntervalShowControl", "checkPacing currentTime = " + f.b(time) + " showTime = " + f.b(k2) + " pacingBean.getPacing() = " + i2.i() + " pacingTime = " + f.b(k3));
            if (time <= k3) {
                this.a.put(str, Long.valueOf(time - k2));
                return false;
            }
        }
        return true;
    }

    public void d(String str) {
        h.a().a(str);
    }

    public void e(String str) {
        j.a().a(str);
    }

    public Pair<String, String> f(String str) {
        return this.b.get(str);
    }

    public long g(String str) {
        Long l2 = this.a.get(str);
        if (l2 == null) {
            return -2L;
        }
        return l2.longValue();
    }

    public g h(String str) {
        return h.a().b(str);
    }

    public i i(String str) {
        return j.a().b(str);
    }

    public void j(String str) {
        ThreadHelper.runOnMSDKThread(new a(str));
    }
}
