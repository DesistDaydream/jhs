package com.tencent.android.tpush.message;

import android.content.Context;
import android.content.Intent;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.android.tpush.common.i;
import com.tencent.android.tpush.data.CachedMessageIntent;
import com.tencent.android.tpush.data.MessageId;
import com.tencent.android.tpush.encrypt.Rijndael;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.service.cache.CacheManager;
import com.tencent.tpns.baseapi.base.PushPreferences;
import com.tencent.tpns.baseapi.base.util.PushMd5Pref;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

@JgClassChecked(author = 1, fComment = "确认已进行安全校验", lastDate = "20150316", reviewer = 3, vComment = {EType.INTENTSCHEMECHECK, EType.INTENTCHECK, EType.RECEIVERCHECK})
/* loaded from: classes3.dex */
public class MessageManager {
    public static final int MSG_CTRL_CMD_TYPE = 3;
    public static final int MSG_CTRL_CMD_TYPE_ACTION_CLEAR_PKG = 2;
    public static final int MSG_CTRL_CMD_TYPE_ACTION_CLEAR_PUSHID = 1;
    public static final int MSG_CTRL_CMD_TYPE_ACTION_LOG_ENABLED = 3;
    public static final String SHARED_PREFERENCES_CACHE_MSG_KEY = ".tpns.msg.id.cached";
    public static final String SHARED_PREFERENCES_KEY = ".tpns.msg.id";
    private static MessageManager a = new MessageManager();
    private static final byte[] b = new byte[0];

    private MessageManager() {
    }

    private void a(Context context, String str, String str2, ArrayList<?> arrayList) {
        try {
            if (arrayList.size() > 50) {
                arrayList.subList(0, 10).clear();
            }
            String encrypt = Rijndael.encrypt(com.tencent.android.tpush.common.e.a(arrayList));
            PushPreferences.putString(context, str + str2, encrypt);
        } catch (Throwable th) {
            TLogger.e("MessageManager", "putSettings", th);
        }
    }

    public static MessageManager getInstance() {
        return a;
    }

    public static String getNotifiedMsgIds(Context context, long j2) {
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(PushMd5Pref.getString(context, "tpush_msgId_" + j2, true));
        String sb2 = sb.toString();
        if (sb2 != null && sb2.length() > 20480) {
            sb2 = sb2.substring(0, sb2.indexOf("@@", 5120));
        }
        return sb2 != null ? sb2 : "";
    }

    public static boolean setNotifiedMsgIds(Context context, long j2, String str, String str2) {
        PushMd5Pref.putString(context, "tpush_msgId_" + j2, str + str2, true);
        String string = PushMd5Pref.getString(context, "tpush_msgId_" + j2, true);
        if (string == null || !string.contains(str)) {
            TLogger.e("MessageManager", str + " flag write failed");
            return false;
        }
        return true;
    }

    public void addCachedMsgIntentByPkgName(Context context, String str, Intent intent) {
        int size;
        synchronized (b) {
            if (context != null) {
                if (!i.b(str) && intent != null) {
                    CachedMessageIntent cachedMessageIntent = new CachedMessageIntent();
                    cachedMessageIntent.pkgName = str;
                    cachedMessageIntent.msgId = intent.getLongExtra("msgId", -1L);
                    cachedMessageIntent.intent = Rijndael.encrypt(intent.toUri(1));
                    ArrayList<CachedMessageIntent> cachedMsgIntentListByPkgName = getCachedMsgIntentListByPkgName(context, str);
                    if (cachedMsgIntentListByPkgName == null) {
                        cachedMsgIntentListByPkgName = new ArrayList<>();
                    } else {
                        ArrayList arrayList = new ArrayList();
                        for (int i2 = 0; i2 < cachedMsgIntentListByPkgName.size(); i2++) {
                            CachedMessageIntent cachedMessageIntent2 = cachedMsgIntentListByPkgName.get(i2);
                            if (cachedMessageIntent2.equals(cachedMessageIntent)) {
                                arrayList.add(cachedMessageIntent2);
                            }
                        }
                        cachedMsgIntentListByPkgName.removeAll(arrayList);
                    }
                    if (cachedMsgIntentListByPkgName != null && cachedMsgIntentListByPkgName.size() > 45 && (size = cachedMsgIntentListByPkgName.size() - 45) >= 0) {
                        TLogger.w("MessageManager", "too much cache msg, try to cut " + size + " list.size: " + cachedMsgIntentListByPkgName.size());
                        cachedMsgIntentListByPkgName.subList(0, size).clear();
                    }
                    cachedMsgIntentListByPkgName.add(cachedMessageIntent);
                    updateCachedMsgIntentByPkgName(context, str, cachedMsgIntentListByPkgName);
                }
            }
        }
    }

    public void addDonotCachedMsgId(Context context, String str, ArrayList<Intent> arrayList) {
        synchronized (b) {
            if (context != null && arrayList != null) {
                a(context, str, SHARED_PREFERENCES_CACHE_MSG_KEY, arrayList);
            }
        }
    }

    public void addDonotSendCachedMsgIntentList(Context context, Intent intent) {
        if (context != null) {
            ArrayList<Intent> arrayList = new ArrayList<>();
            arrayList.add(intent);
            addDonotCachedMsgId(context, context.getPackageName(), arrayList);
        }
    }

    public void addMsgId(Context context, String str, MessageId messageId) {
        synchronized (b) {
            if (context != null) {
                if (!i.b(str) && messageId != null) {
                    ArrayList<MessageId> messageIdListByPkgName = getMessageIdListByPkgName(context, str);
                    if (messageIdListByPkgName == null) {
                        messageIdListByPkgName = new ArrayList<>();
                    } else {
                        int i2 = 0;
                        while (true) {
                            if (i2 >= messageIdListByPkgName.size()) {
                                break;
                            } else if (messageIdListByPkgName.get(i2).id == messageId.id) {
                                messageIdListByPkgName.remove(i2);
                                break;
                            } else {
                                i2++;
                            }
                        }
                    }
                    messageIdListByPkgName.add(messageId);
                    updateMsgId(context, str, messageIdListByPkgName);
                }
            }
        }
    }

    public void addNewCachedMsgIntent(Context context, Intent intent) {
        if (context != null) {
            com.tencent.android.tpush.d.a.a(context, intent);
        }
    }

    public void clearAllLocalMsg(Context context) {
        if (context != null) {
            com.tencent.android.tpush.d.a.b(context);
        }
    }

    public void clearLocalCachedMsgIntentList(Context context) {
        List<String> registerInfos;
        if (context == null || (registerInfos = CacheManager.getRegisterInfos(context)) == null || registerInfos.size() <= 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : registerInfos) {
            arrayList.clear();
            ArrayList<CachedMessageIntent> cachedMsgIntentListByPkgName = getCachedMsgIntentListByPkgName(context, str);
            if (cachedMsgIntentListByPkgName != null && cachedMsgIntentListByPkgName.size() > 0) {
                for (int i2 = 0; i2 < cachedMsgIntentListByPkgName.size(); i2++) {
                    CachedMessageIntent cachedMessageIntent = cachedMsgIntentListByPkgName.get(i2);
                    try {
                        String decrypt = Rijndael.decrypt(cachedMessageIntent.intent);
                        if (!i.b(decrypt) && Intent.parseUri(decrypt, 1).getLongExtra("msgId", 0L) != 0) {
                            arrayList.add(cachedMessageIntent);
                        }
                    } catch (Throwable th) {
                        TLogger.e("MessageManager", "clearLocalCachedMsgIntentList", th);
                    }
                }
                cachedMsgIntentListByPkgName.removeAll(arrayList);
                updateCachedMsgIntentByPkgName(context, str, cachedMsgIntentListByPkgName);
            }
        }
    }

    public void deleteAllCachedMsgIntent(Context context) {
        if (context != null) {
            com.tencent.android.tpush.d.a.a(context);
        }
    }

    public void deleteAllCachedMsgIntentByPkgName(Context context, String str) {
        synchronized (b) {
            if (context != null) {
                updateCachedMsgIntentByPkgName(context, str, new ArrayList<>());
            }
        }
    }

    public void deleteCachedMsgIntent(Context context, long j2) {
        if (context != null) {
            com.tencent.android.tpush.d.a.e(context, j2);
        }
    }

    public void deleteCachedMsgIntentByBusiId(Context context, long j2) {
        if (context != null) {
            com.tencent.android.tpush.d.a.f(context, j2);
        }
    }

    public void deleteCachedMsgIntentByPkgName(Context context, String str, long j2) {
        synchronized (b) {
            if (context != null) {
                ArrayList<CachedMessageIntent> cachedMsgIntentListByPkgName = getCachedMsgIntentListByPkgName(context, str);
                if (cachedMsgIntentListByPkgName != null && cachedMsgIntentListByPkgName.size() > 0) {
                    ArrayList arrayList = new ArrayList();
                    for (int i2 = 0; i2 < cachedMsgIntentListByPkgName.size(); i2++) {
                        CachedMessageIntent cachedMessageIntent = cachedMsgIntentListByPkgName.get(i2);
                        if (cachedMessageIntent.msgId == j2) {
                            arrayList.add(cachedMessageIntent);
                        }
                    }
                    if (arrayList.size() == 0) {
                        TLogger.e("MessageManager", "deleteCachedMsgIntentByPkgName do not have MessageId = " + j2);
                    }
                    cachedMsgIntentListByPkgName.removeAll(arrayList);
                }
                updateCachedMsgIntentByPkgName(context, str, cachedMsgIntentListByPkgName);
            }
        }
    }

    public void deleteCachedMsgIntentByPkgNameBusiId(Context context, String str, long j2) {
        synchronized (b) {
            if (context != null) {
                ArrayList<CachedMessageIntent> cachedMsgIntentListByPkgName = getCachedMsgIntentListByPkgName(context, str);
                if (cachedMsgIntentListByPkgName != null && cachedMsgIntentListByPkgName.size() > 0) {
                    ArrayList arrayList = new ArrayList();
                    for (int i2 = 0; i2 < cachedMsgIntentListByPkgName.size(); i2++) {
                        CachedMessageIntent cachedMessageIntent = cachedMsgIntentListByPkgName.get(i2);
                        if (j2 == Intent.parseUri(Rijndael.decrypt(cachedMessageIntent.intent), 1).getLongExtra("busiMsgId", -1L)) {
                            arrayList.add(cachedMessageIntent);
                        }
                    }
                    cachedMsgIntentListByPkgName.removeAll(arrayList);
                }
                updateCachedMsgIntentByPkgName(context, str, cachedMsgIntentListByPkgName);
            }
        }
    }

    public ArrayList<CachedMessageIntent> getCachedMsgIntentList(Context context) {
        List<String> registerInfos;
        if (context == null || (registerInfos = CacheManager.getRegisterInfos(context)) == null || registerInfos.size() <= 0) {
            return null;
        }
        ArrayList<CachedMessageIntent> arrayList = new ArrayList<>();
        for (String str : registerInfos) {
            ArrayList<CachedMessageIntent> cachedMsgIntentListByPkgName = getCachedMsgIntentListByPkgName(context, str);
            if (cachedMsgIntentListByPkgName != null && cachedMsgIntentListByPkgName.size() > 0) {
                arrayList.addAll(cachedMsgIntentListByPkgName);
            }
        }
        return arrayList;
    }

    public ArrayList<CachedMessageIntent> getCachedMsgIntentListByPkgName(Context context, String str) {
        Object a2;
        ArrayList<CachedMessageIntent> arrayList = null;
        if (context != null) {
            try {
                if (!i.b(str) && (a2 = a(context, str, SHARED_PREFERENCES_CACHE_MSG_KEY)) != null) {
                    arrayList = (ArrayList) a2;
                }
            } catch (Throwable unused) {
                return new ArrayList<>();
            }
        }
        return arrayList == null ? new ArrayList<>() : arrayList;
    }

    public ArrayList<Intent> getDonotCachedMsgId(Context context, String str) {
        Object a2;
        synchronized (b) {
            ArrayList<Intent> arrayList = null;
            if (context != null) {
                try {
                    if (!i.b(str) && (a2 = a(context, str, SHARED_PREFERENCES_CACHE_MSG_KEY)) != null) {
                        arrayList = (ArrayList) a2;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return arrayList == null ? new ArrayList<>() : arrayList;
        }
    }

    public ArrayList<Intent> getDonotSendCachedMsgIntentList(Context context) {
        if (context != null) {
            return getDonotCachedMsgId(context, context.getPackageName());
        }
        return null;
    }

    public ArrayList<MessageId> getMessageIdListByPkgName(Context context, String str) {
        Object a2;
        ArrayList<MessageId> arrayList = (context == null || i.b(str) || (a2 = a(context, str, SHARED_PREFERENCES_KEY)) == null) ? null : (ArrayList) a2;
        return arrayList == null ? new ArrayList<>() : arrayList;
    }

    public MessageId getMsgId(Context context, String str, long j2) {
        ArrayList<MessageId> messageIdListByPkgName;
        if (context == null || i.b(str) || j2 <= 0 || (messageIdListByPkgName = getMessageIdListByPkgName(context, str)) == null || messageIdListByPkgName.size() <= 0) {
            return null;
        }
        for (MessageId messageId : messageIdListByPkgName) {
            if (messageId.id == j2) {
                return messageId;
            }
        }
        return null;
    }

    public ArrayList<Intent> getNewCachedMsgIntentList(Context context) {
        if (context != null) {
            return com.tencent.android.tpush.d.a.c(context);
        }
        return null;
    }

    public boolean isMsgAcked(Context context, String str, long j2) {
        ArrayList<MessageId> messageIdListByPkgName;
        if (context == null || i.b(str) || j2 <= 0 || (messageIdListByPkgName = getMessageIdListByPkgName(context, str)) == null || messageIdListByPkgName.size() <= 0) {
            return false;
        }
        for (MessageId messageId : messageIdListByPkgName) {
            if (messageId.id == j2) {
                return messageId.isMsgAcked();
            }
        }
        return false;
    }

    public boolean isMsgCached(Context context, long j2) {
        if (context != null) {
            com.tencent.android.tpush.d.a.g(context, j2);
            return false;
        }
        return false;
    }

    public void onCrtlMsgHandle(Context context, String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt("action", 2);
            if (optInt == 1) {
                for (String str2 : jSONObject.optString("pushIdList", "").split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
                    deleteCachedMsgIntentByBusiId(context, Long.valueOf(str2).longValue());
                }
            } else if (optInt == 2) {
                deleteAllCachedMsgIntent(context);
            } else if (optInt == 3) {
                int optInt2 = jSONObject.optInt("enabled", -1);
                TLogger.ii("MessageManager", "setLogToFile with cmd = " + optInt2);
                if (optInt2 != -1) {
                    TLogger.enableDebug(context, optInt2 > 0);
                }
            }
        } catch (Throwable th) {
            TLogger.e("MessageManager", "onCrtlMsgHandle", th);
        }
    }

    public void updateCachedMsgIntentByPkgName(Context context, String str, ArrayList<CachedMessageIntent> arrayList) {
        synchronized (b) {
            if (context != null && arrayList != null) {
                TLogger.v("MessageManager", "updateCachedMsgIntentByPkgName, size: " + arrayList.size());
                a(context, str, SHARED_PREFERENCES_CACHE_MSG_KEY, arrayList);
            }
        }
    }

    public void updateCachedMsgIntentToCancel(Context context, long j2) {
        if (context != null) {
            com.tencent.android.tpush.d.a.d(context, j2);
        }
    }

    public void updateCachedMsgIntentToClick(Context context, long j2) {
        if (context != null) {
            com.tencent.android.tpush.d.a.c(context, j2);
        }
    }

    public void updateCachedMsgIntentToShowed(Context context, long j2) {
        if (context != null) {
            com.tencent.android.tpush.d.a.a(context, j2);
        }
    }

    public void updateCachedMsgIntentToVerifyErr(Context context, long j2) {
        if (context != null) {
            com.tencent.android.tpush.d.a.b(context, j2);
        }
    }

    public void updateMsgId(Context context, String str, ArrayList<MessageId> arrayList) {
        synchronized (b) {
            if (context != null && arrayList != null) {
                a(context, str, SHARED_PREFERENCES_KEY, arrayList);
            }
        }
    }

    public void deleteCachedMsgIntent(Context context, List<CachedMessageIntent> list, ArrayList<CachedMessageIntent> arrayList) {
        synchronized (b) {
            if (context != null && list != null) {
                if (list.size() > 0) {
                    ArrayList arrayList2 = new ArrayList();
                    if (arrayList != null && arrayList.size() > 0) {
                        HashMap hashMap = new HashMap();
                        for (int i2 = 0; i2 < arrayList.size(); i2++) {
                            CachedMessageIntent cachedMessageIntent = arrayList.get(i2);
                            for (CachedMessageIntent cachedMessageIntent2 : list) {
                                if (cachedMessageIntent.equals(cachedMessageIntent2)) {
                                    arrayList2.add(cachedMessageIntent);
                                    ArrayList arrayList3 = (ArrayList) hashMap.get(cachedMessageIntent2.pkgName);
                                    if (arrayList3 == null) {
                                        arrayList3 = new ArrayList();
                                    }
                                    hashMap.put(cachedMessageIntent2.pkgName, arrayList3);
                                }
                            }
                        }
                        arrayList.removeAll(arrayList2);
                        Iterator<CachedMessageIntent> it = arrayList.iterator();
                        while (it.hasNext()) {
                            CachedMessageIntent next = it.next();
                            ArrayList arrayList4 = (ArrayList) hashMap.get(next.pkgName);
                            if (arrayList4 == null) {
                                arrayList4 = new ArrayList();
                            }
                            arrayList4.add(next);
                            hashMap.put(next.pkgName, arrayList4);
                        }
                        for (Map.Entry entry : hashMap.entrySet()) {
                            updateCachedMsgIntentByPkgName(context, (String) entry.getKey(), (ArrayList) entry.getValue());
                        }
                    }
                }
            }
        }
    }

    private Object a(Context context, String str, String str2) {
        try {
            return com.tencent.android.tpush.common.e.a(Rijndael.decrypt(PushPreferences.getString(context, str + str2, null)));
        } catch (Throwable th) {
            TLogger.e("MessageManager", "getSettings", th);
            return null;
        }
    }
}
