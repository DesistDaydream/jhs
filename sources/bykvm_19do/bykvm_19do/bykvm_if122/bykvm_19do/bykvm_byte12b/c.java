package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b;

import android.text.TextUtils;
import com.bytedance.msdk.adapter.util.Logger;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public class c {
    private Map<String, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b.b> a;
    private Map<String, ConcurrentHashMap<String, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b.a>> b;

    /* loaded from: classes.dex */
    public static class b {
        private static c a = new c();
    }

    private c() {
        this.b = new ConcurrentHashMap();
    }

    public static c a() {
        return b.a;
    }

    public void a(String str, String str2, String str3) {
        boolean z;
        Logger.d("TTMediationSDK_AdnShowControl", "setAdnError adnName = " + str + " slotId = " + str2 + " error = " + str3);
        Map<String, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b.b> map = this.a;
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b.b bVar = map != null ? map.get(str) : null;
        if (bVar != null) {
            for (String str4 : bVar.b()) {
                if (TextUtils.equals(str4, str3)) {
                    Logger.d("TTMediationSDK_AdnShowControl", "setAdnError 命中errorCode = " + str4);
                    z = true;
                    break;
                }
            }
        }
        z = false;
        if (z) {
            long time = new Date().getTime() + bVar.a();
            Logger.d("TTMediationSDK_AdnShowControl", "setAdnError 更新时间 = " + f.b(time));
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b.a aVar = new bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b.a(str, str2, time);
            if (this.b != null) {
                ConcurrentHashMap<String, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b.a> concurrentHashMap = new ConcurrentHashMap<>();
                concurrentHashMap.put(str2, aVar);
                this.b.put(str, concurrentHashMap);
                Logger.d("TTMediationSDK_AdnShowControl", "setAdnError mAdnControlMap = " + this.b);
            }
        }
    }

    public void a(ConcurrentHashMap<String, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b.b> concurrentHashMap) {
        String str;
        this.a = concurrentHashMap;
        if (concurrentHashMap != null) {
            str = "mAdnControlMap = " + concurrentHashMap;
        } else {
            str = "mAdnControlMap is null ";
        }
        Logger.d("TTMediationSDK_AdnShowControl", str);
    }

    public boolean a(String str, String str2) {
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b.a aVar;
        ConcurrentHashMap<String, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b.a> concurrentHashMap;
        Logger.d("TTMediationSDK_AdnShowControl", "checkLoad adnName = " + str + " slotId = " + str2);
        Map<String, ConcurrentHashMap<String, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b.a>> map = this.b;
        if (map == null || (concurrentHashMap = map.get(str)) == null) {
            aVar = null;
        } else {
            aVar = concurrentHashMap.get(str2);
            Logger.d("TTMediationSDK_AdnShowControl", "checkLoad 取出的showBean = " + aVar);
        }
        if (aVar != null && aVar.a() != 0) {
            long time = new Date().getTime();
            if (time <= aVar.a()) {
                Logger.d("TTMediationSDK_AdnShowControl", "checkLoad 当前时间 = " + f.b(time));
                Logger.d("TTMediationSDK_AdnShowControl", "checkLoad 规则有效时间 = " + f.b(aVar.a()));
                return false;
            }
        }
        return true;
    }
}
