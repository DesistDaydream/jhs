package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b;

import android.text.TextUtils;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.adapter.util.ThreadHelper;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public class l {
    private static final String b = "TTMediationSDK_" + l.class.getSimpleName();
    private Map<String, Long> a;

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
            String str = l.b;
            Logger.d(str, "adn updateShowPacingTime ritId = " + this.a + " adnSlotId = " + this.b);
            i d2 = l.this.d(this.a, this.b);
            if (d2 == null || !d2.a()) {
                return;
            }
            Date date = new Date();
            String str2 = l.b;
            Logger.d(str2, "adn updateShowPacingTime save time = " + f.b(date.getTime()));
            l.this.a(this.a, this.b, date.getTime());
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        private static l a = new l(null);
    }

    private l() {
        this.a = new ConcurrentHashMap();
    }

    public /* synthetic */ l(a aVar) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, long j2) {
        j.a().a(str, str2, j2);
    }

    public static l b() {
        return b.a;
    }

    public boolean a(i iVar) {
        if (iVar != null) {
            i d2 = d(iVar.d(), iVar.c());
            if (d2 == null) {
                Logger.d(b, "adn pacing 规则为空直接存储");
                return true;
            } else if (TextUtils.isEmpty(iVar.j())) {
                Logger.d(b, "adn pacing ruleId 为空 清空本地数据 ");
                b(iVar.d(), iVar.c());
            } else if (!TextUtils.equals(d2.j(), iVar.j())) {
                String str = b;
                Logger.d(str, "adn pacing ruleId不一致，缓存新规则 old ruleId = " + d2.j() + "  new ruleId = " + iVar.j());
                b(iVar.d(), iVar.c());
                return true;
            } else {
                String str2 = b;
                Logger.d(str2, "adn pacing ruleId 一致 ruleId = " + d2.j() + " 无需处理");
            }
        }
        return false;
    }

    public boolean a(String str, String str2) {
        String str3 = b;
        Logger.d(str3, "adn checkPacing ritId = " + str + " adnSlotId = " + str2);
        i d2 = d(str, str2);
        if (d2 != null && d2.a() && d2.l()) {
            long time = new Date().getTime();
            long k2 = d2.k();
            long k3 = d2.k() + d2.i();
            Logger.d(str3, "adn checkPacing currentTime = " + f.b(time) + " showTime = " + f.b(k2) + " pacingBean.getPacing() = " + d2.i() + " pacingTime = " + f.b(k3));
            if (time <= k3) {
                Map<String, Long> map = this.a;
                map.put(str + "_" + str2, Long.valueOf(time - k2));
                return false;
            }
        }
        return true;
    }

    public void b(i iVar) {
        j.a().a(iVar);
    }

    public void b(String str, String str2) {
        j.a().a(str, str2);
    }

    public long c(String str, String str2) {
        Map<String, Long> map = this.a;
        Long l2 = map.get(str + "_" + str2);
        if (l2 == null) {
            return -2L;
        }
        return l2.longValue();
    }

    public i d(String str, String str2) {
        return j.a().b(str, str2);
    }

    public void e(String str, String str2) {
        ThreadHelper.runOnMSDKThread(new a(str, str2));
    }
}
