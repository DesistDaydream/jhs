package com.xiaomi.push.service;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.tencent.android.tpush.common.MessageKey;
import com.xiaomi.push.gg;
import com.xiaomi.push.hd;
import com.xiaomi.push.jc;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes3.dex */
public class v {
    private static final boolean a = Log.isLoggable("NCHelper", 3);

    private static int a(NotificationChannel notificationChannel) {
        int i2 = 0;
        try {
            i2 = ((Integer) com.xiaomi.push.am.b((Object) notificationChannel, "getUserLockedFields", new Object[0])).intValue();
            if (a) {
                a("isUserLockedChannel:" + i2 + ExpandableTextView.N + notificationChannel);
            }
        } catch (Exception e2) {
            com.xiaomi.a.a.a.c.a("NCHelper", "is user locked error" + e2);
        }
        return i2;
    }

    @TargetApi(26)
    private static NotificationChannel a(String str, NotificationChannel notificationChannel) {
        NotificationChannel notificationChannel2 = new NotificationChannel(str, notificationChannel.getName(), notificationChannel.getImportance());
        notificationChannel2.setDescription(notificationChannel.getDescription());
        notificationChannel2.enableVibration(notificationChannel.shouldVibrate());
        notificationChannel2.enableLights(notificationChannel.shouldShowLights());
        notificationChannel2.setSound(notificationChannel.getSound(), notificationChannel.getAudioAttributes());
        notificationChannel2.setLockscreenVisibility(notificationChannel.getLockscreenVisibility());
        return notificationChannel2;
    }

    private static SharedPreferences a(Context context) {
        return context.getSharedPreferences("mipush_channel_copy_sp", 0);
    }

    @TargetApi(26)
    public static String a(z zVar, String str, CharSequence charSequence, String str2, int i2, int i3, String str3, String str4) {
        String b = zVar.b(str);
        boolean z = a;
        if (z) {
            a("createChannel: appChannelId:" + b + " serverChannelId:" + str + " serverChannelName:" + ((Object) charSequence) + " serverChannelDesc:" + str2 + " serverChannelNotifyType:" + i2 + " serverChannelName:" + ((Object) charSequence) + " serverChannelImportance:" + i3 + " channelSoundStr:" + str3 + " channelPermissions:" + str4);
        }
        NotificationChannel notificationChannel = new NotificationChannel(b, charSequence, i3);
        notificationChannel.setDescription(str2);
        notificationChannel.enableVibration((i2 & 2) != 0);
        notificationChannel.enableLights((i2 & 4) != 0);
        if ((i2 & 1) == 0) {
            notificationChannel.setSound(null, null);
        } else if (!TextUtils.isEmpty(str3)) {
            if (str3.startsWith("android.resource://" + zVar.b())) {
                notificationChannel.setSound(Uri.parse(str3), Notification.AUDIO_ATTRIBUTES_DEFAULT);
            }
        }
        if (z) {
            a("create channel:" + notificationChannel);
        }
        a(zVar, notificationChannel, str4);
        return b;
    }

    @SuppressLint({"WrongConstant"})
    @TargetApi(26)
    public static void a(Context context, z zVar, NotificationChannel notificationChannel, int i2, String str) {
        if (i2 <= 0) {
            zVar.a(notificationChannel);
            return;
        }
        int a2 = gg.a(context) >= 2 ? ca.a(context.getPackageName(), str) : 0;
        NotificationChannel a3 = a(notificationChannel.getId(), notificationChannel);
        if ((i2 & 32) != 0) {
            if (notificationChannel.getSound() != null) {
                a3.setSound(null, null);
            } else {
                a3.setSound(Settings.System.DEFAULT_NOTIFICATION_URI, Notification.AUDIO_ATTRIBUTES_DEFAULT);
            }
        }
        if ((i2 & 16) != 0) {
            if (notificationChannel.shouldVibrate()) {
                a3.enableVibration(false);
            } else {
                a3.enableVibration(true);
            }
        }
        if ((i2 & 8) != 0) {
            if (notificationChannel.shouldShowLights()) {
                a3.enableLights(false);
            } else {
                a3.enableLights(true);
            }
        }
        if ((i2 & 4) != 0) {
            int importance = notificationChannel.getImportance() - 1;
            if (importance <= 0) {
                importance = 2;
            }
            a3.setImportance(importance);
        }
        if ((i2 & 2) != 0) {
            a3.setLockscreenVisibility(notificationChannel.getLockscreenVisibility() - 1);
        }
        zVar.a(a3);
        zVar.a(notificationChannel, true);
        ca.a(zVar.b(), notificationChannel.getId(), a2, 0);
    }

    public static void a(Context context, String str) {
        if (!jc.a(context) || TextUtils.isEmpty(str)) {
            return;
        }
        d(context, str);
        ca.a(context, str);
    }

    private static void a(Context context, List<String> list) {
        if (a) {
            a("deleteCopiedChannelRecord:" + list);
        }
        if (list.isEmpty()) {
            return;
        }
        SharedPreferences.Editor edit = a(context).edit();
        for (String str : list) {
            edit.remove(str);
        }
        edit.apply();
    }

    public static void a(hd hdVar) {
        Map<String, String> map;
        if (hdVar == null || (map = hdVar.f8784j) == null || !map.containsKey("REMOVE_CHANNEL_MARK")) {
            return;
        }
        hdVar.f8780f = 0;
        hdVar.f8784j.remove(MessageKey.MSG_CHANNEL_ID);
        hdVar.f8784j.remove("channel_importance");
        hdVar.f8784j.remove("channel_name");
        hdVar.f8784j.remove("channel_description");
        hdVar.f8784j.remove("channel_perm");
        com.xiaomi.a.a.a.c.a("delete channel info by:" + hdVar.f8784j.get("REMOVE_CHANNEL_MARK"));
        hdVar.f8784j.remove("REMOVE_CHANNEL_MARK");
    }

    @TargetApi(26)
    private static void a(z zVar, NotificationChannel notificationChannel, String str) {
        int i2;
        char c2;
        int i3;
        Context a2 = zVar.a();
        String id = notificationChannel.getId();
        String a3 = z.a(id, zVar.b());
        boolean z = a;
        if (z) {
            a("appChannelId:" + id + " oldChannelId:" + a3);
        }
        if (!jc.a(a2) || TextUtils.equals(id, a3)) {
            NotificationChannel c3 = zVar.c(id);
            if (z) {
                a("elseLogic getNotificationChannel:" + c3);
            }
            if (c3 == null) {
                zVar.a(notificationChannel);
            }
            i2 = 0;
            c2 = 0;
        } else {
            NotificationManager notificationManager = (NotificationManager) a2.getSystemService(RemoteMessageConst.NOTIFICATION);
            NotificationChannel notificationChannel2 = notificationManager.getNotificationChannel(a3);
            NotificationChannel c4 = zVar.c(id);
            if (z) {
                a("xmsfChannel:" + notificationChannel2);
                a("appChannel:" + c4);
            }
            if (notificationChannel2 != null) {
                NotificationChannel a4 = a(id, notificationChannel2);
                if (z) {
                    a("copyXmsf copyXmsfChannel:" + a4);
                }
                if (c4 != null) {
                    i3 = a(c4);
                    zVar.a(a4, i3 == 0);
                    c2 = 3;
                } else {
                    i3 = a(notificationChannel2);
                    a(a2, zVar, a4, i3, notificationChannel2.getId());
                    c2 = 4;
                }
                b(a2, id);
                notificationManager.deleteNotificationChannel(a3);
            } else if (c4 == null) {
                if (z) {
                    a("appHack createNotificationChannel:" + notificationChannel);
                }
                zVar.a(notificationChannel);
                i3 = 0;
                c2 = 1;
            } else if (c(a2, id) || !a(notificationChannel, c4)) {
                i3 = 0;
                c2 = 0;
            } else {
                if (z) {
                    a("appHack updateNotificationChannel:" + notificationChannel);
                }
                i3 = a(c4);
                zVar.a(notificationChannel, i3 == 0);
                c2 = 2;
            }
            i2 = i3;
        }
        ca.a(zVar.a(), zVar.b(), id, notificationChannel.getImportance(), str, c2 == 1 || c2 == 4 || c2 == 3, i2);
    }

    private static void a(String str) {
        com.xiaomi.a.a.a.c.a("NCHelper", str);
    }

    @TargetApi(26)
    private static boolean a(NotificationChannel notificationChannel, NotificationChannel notificationChannel2) {
        boolean z;
        if (notificationChannel == null || notificationChannel2 == null) {
            return false;
        }
        boolean z2 = true;
        if (TextUtils.equals(notificationChannel.getName(), notificationChannel2.getName())) {
            z = false;
        } else {
            if (a) {
                a("appHack channelConfigLowerCompare:getName");
            }
            z = true;
        }
        if (!TextUtils.equals(notificationChannel.getDescription(), notificationChannel2.getDescription())) {
            if (a) {
                a("appHack channelConfigLowerCompare:getDescription");
            }
            z = true;
        }
        if (notificationChannel.getImportance() != notificationChannel2.getImportance()) {
            notificationChannel.setImportance(Math.min(notificationChannel.getImportance(), notificationChannel2.getImportance()));
            if (a) {
                a("appHack channelConfigLowerCompare:getImportance  " + notificationChannel.getImportance() + ExpandableTextView.N + notificationChannel2.getImportance());
            }
            z = true;
        }
        if (notificationChannel.shouldVibrate() != notificationChannel2.shouldVibrate()) {
            notificationChannel.enableVibration(false);
            if (a) {
                a("appHack channelConfigLowerCompare:enableVibration");
            }
            z = true;
        }
        if (notificationChannel.shouldShowLights() != notificationChannel2.shouldShowLights()) {
            notificationChannel.enableLights(false);
            if (a) {
                a("appHack channelConfigLowerCompare:enableLights");
            }
            z = true;
        }
        if ((notificationChannel.getSound() != null) != (notificationChannel2.getSound() != null)) {
            notificationChannel.setSound(null, null);
            if (a) {
                a("appHack channelConfigLowerCompare:setSound");
            }
        } else {
            z2 = z;
        }
        if (a) {
            a("appHack channelConfigLowerCompare:isDifferent:" + z2);
        }
        return z2;
    }

    private static void b(Context context, String str) {
        if (a) {
            a("recordCopiedChannel:" + str);
        }
        a(context).edit().putBoolean(str, true).apply();
    }

    private static boolean c(Context context, String str) {
        if (a) {
            a("checkCopeidChannel:newFullChannelId:" + str + "  " + a(context).getBoolean(str, false));
        }
        return a(context).getBoolean(str, false);
    }

    private static void d(Context context, String str) {
        try {
            z a2 = z.a(context, str);
            Set<String> keySet = a(context).getAll().keySet();
            ArrayList arrayList = new ArrayList();
            for (String str2 : keySet) {
                if (a2.a(str2)) {
                    arrayList.add(str2);
                    if (a) {
                        a("delete channel copy record:" + str2);
                    }
                }
            }
            a(context, arrayList);
        } catch (Exception unused) {
        }
    }
}
