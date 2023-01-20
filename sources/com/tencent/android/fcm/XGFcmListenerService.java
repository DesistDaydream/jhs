package com.tencent.android.fcm;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.otherpush.OtherPushClient;
import com.tencent.android.tpush.otherpush.fcm.impl.OtherPushImpl;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class XGFcmListenerService extends FirebaseMessagingService {
    private static final String TAG = "XGFcmListenerService";

    private static HashMap<String, Object> strToHashMap(String str) {
        HashMap<String, Object> hashMap = new HashMap<>();
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String valueOf = String.valueOf(keys.next());
                hashMap.put(valueOf, jSONObject.get(valueOf));
            }
            return hashMap;
        } catch (JSONException unused) {
            return null;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(35:8|(3:9|10|11)|12|(33:143|144|145|(31:137|138|139|19|(28:132|133|134|(26:127|128|129|(3:122|123|124)|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|(1:45)|47|(1:49)|(1:51)(13:52|53|(1:55)|56|(1:58)|59|(1:67)|68|(1:100)(1:72)|73|(10:75|(1:77)|78|(1:80)|81|(1:83)|84|(2:86|(1:88))|89|(4:91|(1:93)|94|(1:96)))|98|99))|24|(0)|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|(0)|47|(0)|(0)(0))(1:21)|22|(0)|24|(0)|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|(0)|47|(0)|(0)(0))(1:17)|18|19|(0)(0)|22|(0)|24|(0)|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|(0)|47|(0)|(0)(0))(1:14)|15|(0)(0)|18|19|(0)(0)|22|(0)|24|(0)|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|(0)|47|(0)|(0)(0)) */
    /* JADX WARN: Can't wrap try/catch for region: R(37:8|9|10|11|12|(33:143|144|145|(31:137|138|139|19|(28:132|133|134|(26:127|128|129|(3:122|123|124)|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|(1:45)|47|(1:49)|(1:51)(13:52|53|(1:55)|56|(1:58)|59|(1:67)|68|(1:100)(1:72)|73|(10:75|(1:77)|78|(1:80)|81|(1:83)|84|(2:86|(1:88))|89|(4:91|(1:93)|94|(1:96)))|98|99))|24|(0)|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|(0)|47|(0)|(0)(0))(1:21)|22|(0)|24|(0)|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|(0)|47|(0)|(0)(0))(1:17)|18|19|(0)(0)|22|(0)|24|(0)|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|(0)|47|(0)|(0)(0))(1:14)|15|(0)(0)|18|19|(0)(0)|22|(0)|24|(0)|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|(0)|47|(0)|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x01fa, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x01fc, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x01fd, code lost:
        r26 = r14;
        r5 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0202, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0203, code lost:
        r12 = r13;
        r5 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0208, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0209, code lost:
        r29 = r4;
        r12 = r13;
        r5 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0210, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0211, code lost:
        r29 = r4;
        r23 = r11;
        r12 = r13;
        r5 = r13;
        r10 = r35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x021b, code lost:
        r3 = r37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x021d, code lost:
        r26 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0220, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0221, code lost:
        r29 = r4;
        r23 = r11;
        r12 = r13;
        r5 = r13;
        r10 = r35;
        r3 = r37;
        r26 = r14;
        r13 = r41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0231, code lost:
        com.tencent.android.tpush.logging.TLogger.e(com.tencent.android.fcm.XGFcmListenerService.TAG, "report service receive error: " + r0);
     */
    /* JADX WARN: Removed duplicated region for block: B:131:0x019e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0181 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:139:0x00f7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0193 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:145:0x02a0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01f2 A[Catch: all -> 0x01fa, TRY_LEAVE, TryCatch #11 {all -> 0x01fa, blocks: (B:53:0x01ed, B:55:0x01f2), top: B:151:0x01ed }] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x028c  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x029f A[RETURN] */
    @Override // com.google.firebase.messaging.FirebaseMessagingService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onMessageReceived(com.google.firebase.messaging.RemoteMessage r44) {
        /*
            Method dump skipped, instructions count: 1107
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.android.fcm.XGFcmListenerService.onMessageReceived(com.google.firebase.messaging.RemoteMessage):void");
    }

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public void onNewToken(String str) {
        try {
            TLogger.d(TAG, "Refreshed token: " + str);
            OtherPushImpl.setToken(getApplicationContext(), str);
            OtherPushClient.updateToken(getApplicationContext());
        } catch (Throwable th) {
            TLogger.e(TAG, "onNewToken error: " + th.toString());
        }
    }
}
