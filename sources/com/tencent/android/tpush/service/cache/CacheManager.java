package com.tencent.android.tpush.service.cache;

import android.content.Context;
import com.tencent.android.tpush.XGPushManager;
import com.tencent.android.tpush.common.MobileType;
import com.tencent.android.tpush.common.e;
import com.tencent.android.tpush.common.i;
import com.tencent.android.tpush.data.RegisterEntity;
import com.tencent.android.tpush.encrypt.Rijndael;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.service.b;
import com.tencent.android.tpush.service.channel.exception.NullReturnException;
import com.tencent.tpns.baseapi.base.PushPreferences;
import com.tencent.tpns.baseapi.base.device.GuidInfoManager;
import com.tencent.tpns.baseapi.base.util.TTask;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class CacheManager {
    private CacheManager() {
    }

    public static void UninstallInfoByPkgName(String str) {
        a(str, (byte) 2);
    }

    public static void UninstallInfoSuccessByPkgName(String str) {
        a(str, (byte) 4);
    }

    public static void UnregisterInfoByPkgName(String str) {
        a(str, (byte) 1);
    }

    public static void UnregisterInfoSuccessByPkgName(String str) {
        a(str, (byte) 3);
    }

    private static void a(String str) {
    }

    private static void a(String str, byte b) {
        if (i.b(str)) {
            return;
        }
        for (Map.Entry<Long, RegisterEntity> entry : getRegisterEntityMap().entrySet()) {
            RegisterEntity value = entry.getValue();
            if (value != null && !i.b(value.packageName) && str.equals(value.packageName)) {
                value.state = b;
            }
        }
    }

    public static void addRegisterInfo(RegisterEntity registerEntity) {
        if (registerEntity == null || registerEntity.accessId <= 0) {
            return;
        }
        getRegisterEntityMap().put(Long.valueOf(registerEntity.accessId), registerEntity);
    }

    public static void clearDomainServerItem(Context context) {
        ArrayList<String> arrayList;
        try {
            arrayList = getDomainKeyList(context);
        } catch (NullReturnException unused) {
            arrayList = new ArrayList<>();
        }
        arrayList.add(String.valueOf((int) MobileType.CHINAMOBILE.getType()));
        arrayList.add(String.valueOf((int) MobileType.TELCOM.getType()));
        arrayList.add(String.valueOf((int) MobileType.UNICOM.getType()));
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            try {
                PushPreferences.putString(context, it.next() + ".com.tencent.tpush.cache.server", "");
            } catch (Throwable th) {
                TLogger.e("CacheManager", "", th);
            }
        }
    }

    public static void clearTokenCache() {
        GuidInfoManager.clearTokenCache();
    }

    public static String findValidPackageByAccessid(long j2) {
        RegisterEntity registerEntity = getRegisterEntityMap().get(Long.valueOf(j2));
        if (registerEntity == null || !registerEntity.isRegistered()) {
            return null;
        }
        return registerEntity.packageName;
    }

    public static RegisterEntity findValidRegisterEntityByPkg(String str) {
        if (i.b(str)) {
            return null;
        }
        for (Map.Entry<Long, RegisterEntity> entry : getRegisterEntityMap().entrySet()) {
            RegisterEntity value = entry.getValue();
            if (value != null && str.equals(value.packageName)) {
                return value;
            }
        }
        return null;
    }

    public static Context getContext() {
        if (b.e() != null) {
            return b.e();
        }
        return XGPushManager.getContext();
    }

    public static RegisterEntity getCurrentAppRegisterEntity(Context context) {
        String string = PushPreferences.getString(context, a("cur.register", ".reg"), "");
        if (i.b(string)) {
            return null;
        }
        return RegisterEntity.decode(string);
    }

    public static String getDomain(Context context) {
        if (context != null) {
            PushPreferences.getString(context, ".com.tencent.tpush.cache.domain", "");
        }
        return "";
    }

    public static ArrayList<String> getDomainKeyList(Context context) {
        if (context != null) {
            try {
                Object a2 = e.a(Rijndael.decrypt(PushPreferences.getString(context, ".com.tencent.tpush.cache.domain.key", "")));
                if (a2 instanceof ArrayList) {
                    return (ArrayList) a2;
                }
                throw new NullReturnException("getDomainKeyList return null,because object not instance of ArrayList<?>");
            } catch (Exception e2) {
                throw new NullReturnException("getDomainKeyList return null，deseriallize err", e2);
            }
        }
        throw new NullReturnException("getDomainKeyList return null,because ctx is null");
    }

    public static long getGuid(Context context) {
        return GuidInfoManager.getGuid(context);
    }

    public static String getQua(Context context, long j2) {
        if (context != null) {
            return Rijndael.decrypt(PushPreferences.getString(context, ".com.tencent.tpush.cache.qua." + j2, ""));
        }
        return "";
    }

    public static Map<Long, RegisterEntity> getRegInfoByApps(Context context) {
        a aVar = new a(context);
        try {
            Thread thread = new Thread(aVar);
            thread.start();
            thread.join(3500L);
        } catch (Throwable th) {
            TLogger.e("CacheManager", th.toString());
        }
        return aVar.a();
    }

    public static synchronized Map<Long, RegisterEntity> getRegisterEntityMap() {
        Map<Long, RegisterEntity> regInfoByApps;
        synchronized (CacheManager.class) {
            regInfoByApps = getRegInfoByApps(getContext());
        }
        return regInfoByApps;
    }

    public static List<RegisterEntity> getRegisterInfo(Context context) {
        ArrayList arrayList = new ArrayList();
        if (context != null) {
            for (Map.Entry<Long, RegisterEntity> entry : getRegisterEntityMap().entrySet()) {
                RegisterEntity value = entry.getValue();
                if (value != null && value.isRegistered()) {
                    arrayList.add(value);
                }
            }
        }
        return arrayList;
    }

    public static RegisterEntity getRegisterInfoByPkgName(String str) {
        return findValidRegisterEntityByPkg(str);
    }

    public static List<String> getRegisterInfos(Context context) {
        ArrayList arrayList = new ArrayList();
        try {
            for (Map.Entry<Long, RegisterEntity> entry : getRegisterEntityMap().entrySet()) {
                RegisterEntity value = entry.getValue();
                if (value != null && !i.b(value.packageName) && value.isRegistered()) {
                    arrayList.add(value.packageName);
                }
            }
        } catch (Throwable th) {
            TLogger.e("CacheManager", "", th);
            arrayList = new ArrayList();
        }
        if (!arrayList.contains(context.getPackageName())) {
            arrayList.add(context.getPackageName());
        }
        return arrayList;
    }

    public static String getToken(Context context) {
        return GuidInfoManager.getToken(context);
    }

    public static void removeRegisterInfoByPkgName(String str) {
        a(str);
    }

    public static void removeRegisterInfos(String str) {
        a(str, (byte) 1);
    }

    public static void saveDomain(Context context, String str) {
        if (context == null || str == null) {
            return;
        }
        PushPreferences.putString(context, ".com.tencent.tpush.cache.domain", str);
    }

    public static void saveDomainKey(Context context, String str) {
        ArrayList<String> arrayList;
        if (context != null) {
            try {
                arrayList = getDomainKeyList(context);
            } catch (Throwable unused) {
                arrayList = new ArrayList<>();
            }
            arrayList.add(str);
            saveDomainKeyList(context, arrayList);
        }
    }

    public static void saveDomainKeyList(Context context, ArrayList<String> arrayList) {
        String a2;
        if (context != null) {
            if (arrayList != null) {
                try {
                    a2 = e.a(arrayList);
                } catch (Throwable th) {
                    TLogger.e("CacheManager", "", th);
                    return;
                }
            } else {
                a2 = "";
            }
            PushPreferences.putString(context, ".com.tencent.tpush.cache.domain.key", Rijndael.encrypt(a2));
        }
    }

    public static void setCurrentAppRegisterEntity(Context context, RegisterEntity registerEntity) {
        PushPreferences.putString(context, a("cur.register", ".reg"), RegisterEntity.encode(registerEntity));
    }

    public static void setQua(Context context, long j2, String str) {
        if (context == null || i.b(str) || j2 <= 0) {
            return;
        }
        PushPreferences.putString(context, ".com.tencent.tpush.cache.qua." + j2, str);
    }

    /* loaded from: classes3.dex */
    public static class a extends TTask {
        private Context a;
        private Map<Long, RegisterEntity> b = new HashMap();

        public a(Context context) {
            this.a = context;
        }

        @Override // com.tencent.tpns.baseapi.base.util.TTask
        public void TRun() {
            try {
                a(com.tencent.android.tpush.a.d(CacheManager.getContext()));
            } catch (Throwable unused) {
            }
        }

        public synchronized void a(Map<Long, RegisterEntity> map) {
            this.b = map;
        }

        public synchronized Map<Long, RegisterEntity> a() {
            return this.b;
        }
    }

    private static String a(String str, String str2) {
        return str + ".com.tencent.tpush.cache" + str2;
    }
}
