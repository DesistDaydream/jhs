package com.xiaomi.mipush.sdk;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.bugly.Bugly;
import com.xiaomi.mipush.sdk.PushMessageHandler;
import com.xiaomi.push.az;
import com.xiaomi.push.cf;
import com.xiaomi.push.ds;
import com.xiaomi.push.dt;
import com.xiaomi.push.ec;
import com.xiaomi.push.gq;
import com.xiaomi.push.gv;
import com.xiaomi.push.ha;
import com.xiaomi.push.hc;
import com.xiaomi.push.hd;
import com.xiaomi.push.he;
import com.xiaomi.push.hg;
import com.xiaomi.push.hi;
import com.xiaomi.push.hm;
import com.xiaomi.push.hn;
import com.xiaomi.push.ho;
import com.xiaomi.push.hp;
import com.xiaomi.push.hq;
import com.xiaomi.push.hs;
import com.xiaomi.push.hu;
import com.xiaomi.push.hw;
import com.xiaomi.push.hy;
import com.xiaomi.push.ia;
import com.xiaomi.push.ib;
import com.xiaomi.push.ic;
import com.xiaomi.push.ih;
import com.xiaomi.push.jj;
import com.xiaomi.push.jm;
import com.xiaomi.push.service.ce;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TimeZone;

/* loaded from: classes3.dex */
public class am {
    private static am a;

    /* renamed from: a */
    private static Object f21a = new Object();

    /* renamed from: a */
    private static Queue<String> f22a;

    /* renamed from: a */
    private Context f23a;

    private am(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.f23a = applicationContext;
        if (applicationContext == null) {
            this.f23a = context;
        }
    }

    public static Intent a(Context context, String str, Map<String, String> map, int i2) {
        return com.xiaomi.push.service.n.b(context, str, map, i2);
    }

    private PushMessageHandler.a a(hn hnVar, boolean z, byte[] bArr, String str, int i2, Intent intent) {
        dt a2;
        String packageName;
        String a3;
        String str2;
        String str3;
        String str4;
        MiPushMessage miPushMessage;
        dt a4;
        String packageName2;
        String a5;
        int i3;
        String str5;
        ArrayList arrayList = null;
        try {
            ic a6 = ai.a(this.f23a, hnVar);
            if (a6 == null) {
                com.xiaomi.a.a.a.c.d("receiving an un-recognized message. " + hnVar.a);
                dt.a(this.f23a).b(this.f23a.getPackageName(), ds.a(i2), str, "18");
                s.c(this.f23a, hnVar, z);
                return null;
            }
            gq a7 = hnVar.a();
            com.xiaomi.a.a.a.c.a("processing a message, action=" + a7);
            switch (an.a[a7.ordinal()]) {
                case 1:
                    if (!hnVar.c()) {
                        com.xiaomi.a.a.a.c.d("receiving an un-encrypt message(SendMessage).");
                        return null;
                    } else if (b.m74a(this.f23a).m85e() && !z) {
                        com.xiaomi.a.a.a.c.a("receive a message in pause state. drop it");
                        dt.a(this.f23a).a(this.f23a.getPackageName(), ds.a(i2), str, "12");
                        return null;
                    } else {
                        hu huVar = (hu) a6;
                        hc l2 = huVar.l();
                        if (l2 == null) {
                            com.xiaomi.a.a.a.c.d("receive an empty message without push content, drop it");
                            dt.a(this.f23a).b(this.f23a.getPackageName(), ds.a(i2), str, "22");
                            s.d(this.f23a, hnVar, z);
                            return null;
                        }
                        int intExtra = intent.getIntExtra("notification_click_button", 0);
                        if (z) {
                            if (com.xiaomi.push.service.n.b(hnVar)) {
                                MiPushClient.reportIgnoreRegMessageClicked(this.f23a, l2.b(), hnVar.m(), hnVar.f8859f, l2.d());
                            } else {
                                hd hdVar = hnVar.m() != null ? new hd(hnVar.m()) : new hd();
                                if (hdVar.s() == null) {
                                    hdVar.a(new HashMap());
                                }
                                hdVar.s().put("notification_click_button", String.valueOf(intExtra));
                                MiPushClient.reportMessageClicked(this.f23a, l2.b(), hdVar, l2.d());
                            }
                        }
                        if (!z) {
                            if (!TextUtils.isEmpty(huVar.j()) && MiPushClient.aliasSetTime(this.f23a, huVar.j()) < 0) {
                                MiPushClient.addAlias(this.f23a, huVar.j());
                            } else if (!TextUtils.isEmpty(huVar.h()) && MiPushClient.topicSubscribedTime(this.f23a, huVar.h()) < 0) {
                                MiPushClient.addTopic(this.f23a, huVar.h());
                            }
                        }
                        hd hdVar2 = hnVar.f8861h;
                        if (hdVar2 == null || hdVar2.s() == null) {
                            str3 = null;
                            str4 = null;
                        } else {
                            str3 = hnVar.f8861h.f8784j.get("jobkey");
                            str4 = str3;
                        }
                        if (TextUtils.isEmpty(str3)) {
                            str3 = l2.b();
                        }
                        if (z || !m54a(this.f23a, str3)) {
                            MiPushMessage generateMessage = PushMessageHelper.generateMessage(huVar, hnVar.m(), z);
                            if (generateMessage.getPassThrough() == 0 && !z && com.xiaomi.push.service.n.a(generateMessage.getExtra())) {
                                com.xiaomi.push.service.n.a(this.f23a, hnVar, bArr);
                                return null;
                            }
                            com.xiaomi.a.a.a.c.a("receive a message, msgid=" + l2.b() + ", jobkey=" + str3 + ", btn=" + intExtra);
                            String a8 = com.xiaomi.push.service.n.a(generateMessage.getExtra(), intExtra);
                            if (z && generateMessage.getExtra() != null && !TextUtils.isEmpty(a8)) {
                                Map<String, String> extra = generateMessage.getExtra();
                                if (intExtra != 0 && hnVar.m() != null) {
                                    ao.a(this.f23a).a(hnVar.m().q(), intExtra);
                                }
                                if (com.xiaomi.push.service.n.b(hnVar)) {
                                    Intent a9 = a(this.f23a, hnVar.f8859f, extra, intExtra);
                                    a9.putExtra("eventMessageType", i2);
                                    a9.putExtra("messageId", str);
                                    a9.putExtra("jobkey", str4);
                                    if (a9 == null) {
                                        com.xiaomi.a.a.a.c.a("Getting Intent fail from ignore reg message. ");
                                        dt.a(this.f23a).b(this.f23a.getPackageName(), ds.a(i2), str, "23");
                                        return null;
                                    }
                                    String f2 = l2.f();
                                    if (!TextUtils.isEmpty(f2)) {
                                        a9.putExtra("payload", f2);
                                    }
                                    this.f23a.startActivity(a9);
                                    s.a(this.f23a, hnVar);
                                    dt.a(this.f23a).a(this.f23a.getPackageName(), ds.a(i2), str, 3006, a8);
                                    return null;
                                }
                                Context context = this.f23a;
                                Intent a10 = a(context, context.getPackageName(), extra, intExtra);
                                if (a10 != null) {
                                    if (!a8.equals(com.xiaomi.push.service.an.f9092c)) {
                                        a10.putExtra(PushMessageHelper.KEY_MESSAGE, generateMessage);
                                        a10.putExtra("eventMessageType", i2);
                                        a10.putExtra("messageId", str);
                                        a10.putExtra("jobkey", str4);
                                    }
                                    this.f23a.startActivity(a10);
                                    s.a(this.f23a, hnVar);
                                    com.xiaomi.a.a.a.c.a("start activity succ");
                                    dt.a(this.f23a).a(this.f23a.getPackageName(), ds.a(i2), str, 1006, a8);
                                    if (a8.equals(com.xiaomi.push.service.an.f9092c)) {
                                        dt.a(this.f23a).a(this.f23a.getPackageName(), ds.a(i2), str, "13");
                                        return null;
                                    }
                                    return null;
                                }
                                return null;
                            }
                            miPushMessage = generateMessage;
                        } else {
                            com.xiaomi.a.a.a.c.a("drop a duplicate message, key=" + str3);
                            dt a11 = dt.a(this.f23a);
                            String packageName3 = this.f23a.getPackageName();
                            String a12 = ds.a(i2);
                            a11.c(packageName3, a12, str, "2:" + str3);
                            miPushMessage = null;
                        }
                        if (hnVar.m() == null && !z) {
                            a(huVar, hnVar);
                        }
                        return miPushMessage;
                    }
                case 2:
                    hs hsVar = (hs) a6;
                    String str6 = b.m74a(this.f23a).f40a;
                    if (TextUtils.isEmpty(str6) || !TextUtils.equals(str6, hsVar.c())) {
                        com.xiaomi.a.a.a.c.a("bad Registration result:");
                        dt.a(this.f23a).b(this.f23a.getPackageName(), ds.a(i2), str, "21");
                        return null;
                    }
                    long m64a = ao.a(this.f23a).m64a();
                    if (m64a > 0 && SystemClock.elapsedRealtime() - m64a > com.heytap.mcssdk.constant.a.f3318h) {
                        com.xiaomi.a.a.a.c.a("The received registration result has expired.");
                        dt.a(this.f23a).b(this.f23a.getPackageName(), ds.a(i2), str, "26");
                        return null;
                    }
                    b.m74a(this.f23a).f40a = null;
                    int i4 = (hsVar.f8888e > 0L ? 1 : (hsVar.f8888e == 0L ? 0 : -1));
                    Context context2 = this.f23a;
                    if (i4 == 0) {
                        b.m74a(context2).b(hsVar.f8890g, hsVar.f8891h, hsVar.r);
                        FCMPushHelper.persistIfXmsfSupDecrypt(this.f23a);
                        a4 = dt.a(this.f23a);
                        packageName2 = this.f23a.getPackageName();
                        a5 = ds.a(i2);
                        i3 = 6006;
                        str5 = "1";
                    } else {
                        a4 = dt.a(context2);
                        packageName2 = this.f23a.getPackageName();
                        a5 = ds.a(i2);
                        i3 = 6006;
                        str5 = "2";
                    }
                    a4.a(packageName2, a5, str, i3, str5);
                    if (!TextUtils.isEmpty(hsVar.f8890g)) {
                        arrayList = new ArrayList();
                        arrayList.add(hsVar.f8890g);
                    }
                    MiPushCommandMessage generateCommandMessage = PushMessageHelper.generateCommandMessage(ec.COMMAND_REGISTER.f8488k, arrayList, hsVar.f8888e, hsVar.f8889f, null, hsVar.x());
                    ao.a(this.f23a).m72d();
                    return generateCommandMessage;
                case 3:
                    if (!hnVar.c()) {
                        com.xiaomi.a.a.a.c.d("receiving an un-encrypt message(UnRegistration).");
                        return null;
                    }
                    if (((hy) a6).f8958e == 0) {
                        b.m74a(this.f23a).m76a();
                        MiPushClient.clearExtras(this.f23a);
                    }
                    PushMessageHandler.a();
                    break;
                case 4:
                    hw hwVar = (hw) a6;
                    if (hwVar.f8936e == 0) {
                        MiPushClient.addTopic(this.f23a, hwVar.h());
                    }
                    if (!TextUtils.isEmpty(hwVar.h())) {
                        arrayList = new ArrayList();
                        arrayList.add(hwVar.h());
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append("resp-cmd:");
                    ec ecVar = ec.COMMAND_SUBSCRIBE_TOPIC;
                    sb.append(ecVar);
                    sb.append(", ");
                    sb.append(hwVar.c());
                    com.xiaomi.a.a.a.c.f(sb.toString());
                    return PushMessageHelper.generateCommandMessage(ecVar.f8488k, arrayList, hwVar.f8936e, hwVar.f8937f, hwVar.k(), null);
                case 5:
                    ia iaVar = (ia) a6;
                    if (iaVar.f8980e == 0) {
                        MiPushClient.removeTopic(this.f23a, iaVar.h());
                    }
                    if (!TextUtils.isEmpty(iaVar.h())) {
                        arrayList = new ArrayList();
                        arrayList.add(iaVar.h());
                    }
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("resp-cmd:");
                    ec ecVar2 = ec.COMMAND_UNSUBSCRIBE_TOPIC;
                    sb2.append(ecVar2);
                    sb2.append(", ");
                    sb2.append(iaVar.c());
                    com.xiaomi.a.a.a.c.f(sb2.toString());
                    return PushMessageHelper.generateCommandMessage(ecVar2.f8488k, arrayList, iaVar.f8980e, iaVar.f8981f, iaVar.k(), null);
                case 6:
                    cf.a(this.f23a.getPackageName(), this.f23a, a6, gq.Command, bArr.length);
                    hm hmVar = (hm) a6;
                    String e2 = hmVar.e();
                    List<String> j2 = hmVar.j();
                    if (hmVar.f8845e == 0) {
                        if (TextUtils.equals(e2, ec.COMMAND_SET_ACCEPT_TIME.f8488k) && j2 != null && j2.size() > 1) {
                            MiPushClient.addAcceptTime(this.f23a, j2.get(0), j2.get(1));
                            if ("00:00".equals(j2.get(0)) && "00:00".equals(j2.get(1))) {
                                b.m74a(this.f23a).a(true);
                            } else {
                                b.m74a(this.f23a).a(false);
                            }
                            j2 = a(TimeZone.getTimeZone("GMT+08"), TimeZone.getDefault(), j2);
                        } else if (TextUtils.equals(e2, ec.COMMAND_SET_ALIAS.f8488k) && j2 != null && j2.size() > 0) {
                            MiPushClient.addAlias(this.f23a, j2.get(0));
                        } else if (TextUtils.equals(e2, ec.COMMAND_UNSET_ALIAS.f8488k) && j2 != null && j2.size() > 0) {
                            MiPushClient.removeAlias(this.f23a, j2.get(0));
                        } else if (TextUtils.equals(e2, ec.COMMAND_SET_ACCOUNT.f8488k) && j2 != null && j2.size() > 0) {
                            MiPushClient.addAccount(this.f23a, j2.get(0));
                        } else if (TextUtils.equals(e2, ec.COMMAND_UNSET_ACCOUNT.f8488k) && j2 != null && j2.size() > 0) {
                            MiPushClient.removeAccount(this.f23a, j2.get(0));
                        } else if (TextUtils.equals(e2, ec.COMMAND_CHK_VDEVID.f8488k)) {
                            return null;
                        }
                    }
                    List<String> list = j2;
                    com.xiaomi.a.a.a.c.f("resp-cmd:" + e2 + ", " + hmVar.b());
                    return PushMessageHelper.generateCommandMessage(e2, list, hmVar.f8845e, hmVar.f8846f, hmVar.l(), null);
                case 7:
                    cf.a(this.f23a.getPackageName(), this.f23a, a6, gq.Notification, bArr.length);
                    if (a6 instanceof hi) {
                        hi hiVar = (hi) a6;
                        String c2 = hiVar.c();
                        com.xiaomi.a.a.a.c.f("resp-type:" + hiVar.f() + ", code:" + hiVar.f8819f + ", " + c2);
                        if (ha.DisablePushMessage.ah.equalsIgnoreCase(hiVar.f8818e)) {
                            if (hiVar.f8819f == 0) {
                                synchronized (af.class) {
                                    if (af.a(this.f23a).m53a(c2)) {
                                        af.a(this.f23a).c(c2);
                                        af a13 = af.a(this.f23a);
                                        au auVar = au.DISABLE_PUSH;
                                        if ("syncing".equals(a13.a(auVar))) {
                                            af.a(this.f23a).a(auVar, "synced");
                                            MiPushClient.clearNotification(this.f23a);
                                            MiPushClient.clearLocalNotificationType(this.f23a);
                                            PushMessageHandler.a();
                                            ao.a(this.f23a).m69b();
                                        }
                                    }
                                }
                                break;
                            } else if ("syncing".equals(af.a(this.f23a).a(au.DISABLE_PUSH))) {
                                synchronized (af.class) {
                                    if (af.a(this.f23a).m53a(c2)) {
                                        if (af.a(this.f23a).a(c2) < 10) {
                                            af.a(this.f23a).b(c2);
                                            ao.a(this.f23a).a(true, c2);
                                        } else {
                                            af.a(this.f23a).c(c2);
                                        }
                                    }
                                }
                                break;
                            }
                        } else if (ha.EnablePushMessage.ah.equalsIgnoreCase(hiVar.f8818e)) {
                            if (hiVar.f8819f == 0) {
                                synchronized (af.class) {
                                    if (af.a(this.f23a).m53a(c2)) {
                                        af.a(this.f23a).c(c2);
                                        af a14 = af.a(this.f23a);
                                        au auVar2 = au.ENABLE_PUSH;
                                        if ("syncing".equals(a14.a(auVar2))) {
                                            af.a(this.f23a).a(auVar2, "synced");
                                        }
                                    }
                                }
                                break;
                            } else if ("syncing".equals(af.a(this.f23a).a(au.ENABLE_PUSH))) {
                                synchronized (af.class) {
                                    if (af.a(this.f23a).m53a(c2)) {
                                        if (af.a(this.f23a).a(c2) < 10) {
                                            af.a(this.f23a).b(c2);
                                            ao.a(this.f23a).a(false, c2);
                                        } else {
                                            af.a(this.f23a).c(c2);
                                        }
                                    }
                                }
                                break;
                            }
                        } else if (ha.ThirdPartyRegUpdate.ah.equalsIgnoreCase(hiVar.f8818e)) {
                            b(hiVar);
                            break;
                        } else if (ha.UploadTinyData.ah.equalsIgnoreCase(hiVar.f8818e)) {
                            a(hiVar);
                            break;
                        }
                        af.a(this.f23a).c(c2);
                        break;
                    } else if (a6 instanceof hq) {
                        hq hqVar = (hq) a6;
                        if ("registration id expired".equalsIgnoreCase(hqVar.f8866e)) {
                            List<String> allAlias = MiPushClient.getAllAlias(this.f23a);
                            List<String> allTopic = MiPushClient.getAllTopic(this.f23a);
                            List<String> allUserAccount = MiPushClient.getAllUserAccount(this.f23a);
                            String acceptTime = MiPushClient.getAcceptTime(this.f23a);
                            com.xiaomi.a.a.a.c.f("resp-type:" + hqVar.f8866e + ", " + hqVar.d());
                            MiPushClient.reInitialize(this.f23a, he.RegIdExpired);
                            for (String str7 : allAlias) {
                                MiPushClient.removeAlias(this.f23a, str7);
                                MiPushClient.setAlias(this.f23a, str7, null);
                            }
                            for (String str8 : allTopic) {
                                MiPushClient.removeTopic(this.f23a, str8);
                                MiPushClient.subscribe(this.f23a, str8, null);
                            }
                            for (String str9 : allUserAccount) {
                                MiPushClient.removeAccount(this.f23a, str9);
                                MiPushClient.setUserAccount(this.f23a, str9, null);
                            }
                            String[] split = acceptTime.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                            if (split.length == 2) {
                                MiPushClient.removeAcceptTime(this.f23a);
                                MiPushClient.addAcceptTime(this.f23a, split[0], split[1]);
                                break;
                            }
                        } else if (ha.ClientInfoUpdateOk.ah.equalsIgnoreCase(hqVar.f8866e)) {
                            if (hqVar.k() != null && hqVar.k().containsKey("app_version")) {
                                b.m74a(this.f23a).m77a(hqVar.k().get("app_version"));
                                break;
                            }
                        } else if (ha.AwakeApp.ah.equalsIgnoreCase(hqVar.f8866e)) {
                            if (hnVar.c() && hqVar.k() != null && hqVar.k().containsKey("awake_info")) {
                                Context context3 = this.f23a;
                                o.a(context3, b.m74a(context3).m75a(), com.xiaomi.push.service.ad.a(this.f23a).a(gv.AwakeInfoUploadWaySwitch.a(), 0), hqVar.k().get("awake_info"));
                                break;
                            }
                        } else {
                            try {
                                if (ha.NormalClientConfigUpdate.ah.equalsIgnoreCase(hqVar.f8866e)) {
                                    hp hpVar = new hp();
                                    ib.a(hpVar, hqVar.r());
                                    com.xiaomi.push.service.ae.a(com.xiaomi.push.service.ad.a(this.f23a), hpVar);
                                } else if (ha.CustomClientConfigUpdate.ah.equalsIgnoreCase(hqVar.f8866e)) {
                                    ho hoVar = new ho();
                                    ib.a(hoVar, hqVar.r());
                                    com.xiaomi.push.service.ae.a(com.xiaomi.push.service.ad.a(this.f23a), hoVar);
                                } else if (ha.SyncInfoResult.ah.equalsIgnoreCase(hqVar.f8866e)) {
                                    av.a(this.f23a, hqVar);
                                    break;
                                } else if (ha.ForceSync.ah.equalsIgnoreCase(hqVar.f8866e)) {
                                    com.xiaomi.a.a.a.c.a("receive force sync notification");
                                    av.a(this.f23a, false);
                                    break;
                                } else if (ha.CancelPushMessage.ah.equals(hqVar.f8866e)) {
                                    com.xiaomi.a.a.a.c.f("resp-type:" + hqVar.f8866e + ", " + hqVar.d());
                                    if (hqVar.k() != null) {
                                        int i5 = -2;
                                        if (hqVar.k().containsKey(com.xiaomi.push.service.an.M)) {
                                            String str10 = hqVar.k().get(com.xiaomi.push.service.an.M);
                                            if (!TextUtils.isEmpty(str10)) {
                                                try {
                                                    i5 = Integer.parseInt(str10);
                                                } catch (NumberFormatException e3) {
                                                    e3.printStackTrace();
                                                }
                                            }
                                        }
                                        if (i5 >= -1) {
                                            MiPushClient.clearNotification(this.f23a, i5);
                                        } else {
                                            MiPushClient.clearNotification(this.f23a, hqVar.k().containsKey(com.xiaomi.push.service.an.K) ? hqVar.k().get(com.xiaomi.push.service.an.K) : "", hqVar.k().containsKey(com.xiaomi.push.service.an.L) ? hqVar.k().get(com.xiaomi.push.service.an.L) : "");
                                        }
                                    }
                                    a(hqVar);
                                    break;
                                } else {
                                    try {
                                        if (ha.HybridRegisterResult.ah.equals(hqVar.f8866e)) {
                                            hs hsVar2 = new hs();
                                            ib.a(hsVar2, hqVar.r());
                                            MiPushClient4Hybrid.onReceiveRegisterResult(this.f23a, hsVar2);
                                        } else if (ha.HybridUnregisterResult.ah.equals(hqVar.f8866e)) {
                                            hy hyVar = new hy();
                                            ib.a(hyVar, hqVar.r());
                                            MiPushClient4Hybrid.onReceiveUnregisterResult(this.f23a, hyVar);
                                        } else if (!ha.PushLogUpload.ah.equals(hqVar.f8866e)) {
                                            if (ha.DetectAppAlive.ah.equals(hqVar.f8866e)) {
                                                com.xiaomi.a.a.a.c.b("receive detect msg");
                                                b(hqVar);
                                                break;
                                            } else if (ce.a(hqVar)) {
                                                com.xiaomi.a.a.a.c.b("receive notification handle by cpra");
                                                break;
                                            }
                                        }
                                        break;
                                    } catch (ih e4) {
                                        com.xiaomi.a.a.a.c.a(e4);
                                        break;
                                    }
                                }
                                break;
                            } catch (ih unused) {
                                break;
                            }
                        }
                    }
                    break;
            }
            return null;
        } catch (u e5) {
            com.xiaomi.a.a.a.c.a(e5);
            a(hnVar);
            a2 = dt.a(this.f23a);
            packageName = this.f23a.getPackageName();
            a3 = ds.a(i2);
            str2 = "19";
            a2.b(packageName, a3, str, str2);
            s.c(this.f23a, hnVar, z);
            return null;
        } catch (ih e6) {
            com.xiaomi.a.a.a.c.a(e6);
            com.xiaomi.a.a.a.c.d("receive a message which action string is not valid. is the reg expired?");
            a2 = dt.a(this.f23a);
            packageName = this.f23a.getPackageName();
            a3 = ds.a(i2);
            str2 = "20";
            a2.b(packageName, a3, str, str2);
            s.c(this.f23a, hnVar, z);
            return null;
        }
    }

    private PushMessageHandler.a a(hn hnVar, byte[] bArr) {
        String str;
        ic a2;
        String str2 = null;
        try {
            a2 = ai.a(this.f23a, hnVar);
        } catch (u e2) {
            com.xiaomi.a.a.a.c.a(e2);
            str = "message arrived: receive a message but decrypt failed. report when click.";
        } catch (ih e3) {
            com.xiaomi.a.a.a.c.a(e3);
            str = "message arrived: receive a message which action string is not valid. is the reg expired?";
        }
        if (a2 == null) {
            com.xiaomi.a.a.a.c.d("message arrived: receiving an un-recognized message. " + hnVar.a);
            return null;
        }
        gq a3 = hnVar.a();
        com.xiaomi.a.a.a.c.a("message arrived: processing an arrived message, action=" + a3);
        if (an.a[a3.ordinal()] != 1) {
            return null;
        }
        if (hnVar.c()) {
            hu huVar = (hu) a2;
            hc l2 = huVar.l();
            if (l2 != null) {
                hd hdVar = hnVar.f8861h;
                if (hdVar != null && hdVar.s() != null) {
                    str2 = hnVar.f8861h.f8784j.get("jobkey");
                }
                MiPushMessage generateMessage = PushMessageHelper.generateMessage(huVar, hnVar.m(), false);
                generateMessage.setArrivedMessage(true);
                com.xiaomi.a.a.a.c.a("message arrived: receive a message, msgid=" + l2.b() + ", jobkey=" + str2);
                return generateMessage;
            }
            str = "message arrived: receive an empty message without push content, drop it";
        } else {
            str = "message arrived: receiving an un-encrypt message(SendMessage).";
        }
        com.xiaomi.a.a.a.c.d(str);
        return null;
    }

    public static am a(Context context) {
        if (a == null) {
            a = new am(context);
        }
        return a;
    }

    private void a() {
        SharedPreferences sharedPreferences = this.f23a.getSharedPreferences("mipush_extra", 0);
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - sharedPreferences.getLong(Constants.SP_KEY_LAST_REINITIALIZE, 0L)) > 1800000) {
            MiPushClient.reInitialize(this.f23a, he.PackageUnregistered);
            sharedPreferences.edit().putLong(Constants.SP_KEY_LAST_REINITIALIZE, currentTimeMillis).commit();
        }
    }

    public static void a(Context context, String str) {
        synchronized (f21a) {
            f22a.remove(str);
            b.m74a(context);
            SharedPreferences a2 = b.a(context);
            String a3 = com.xiaomi.push.ar.a(f22a, Constants.ACCEPT_TIME_SEPARATOR_SP);
            SharedPreferences.Editor edit = a2.edit();
            edit.putString("pref_msg_ids", a3);
            jj.a(edit);
        }
    }

    private void a(hi hiVar) {
        String c2 = hiVar.c();
        com.xiaomi.a.a.a.c.b("receive ack " + c2);
        Map<String, String> j2 = hiVar.j();
        if (j2 != null) {
            String str = j2.get("real_source");
            if (TextUtils.isEmpty(str)) {
                return;
            }
            com.xiaomi.a.a.a.c.b("receive ack : messageId = " + c2 + "  realSource = " + str);
            az.a(this.f23a).a(c2, str, Boolean.valueOf(hiVar.f8819f == 0));
        }
    }

    private void a(hn hnVar) {
        com.xiaomi.a.a.a.c.a("receive a message but decrypt failed. report now.");
        hq hqVar = new hq(hnVar.m().a, false);
        hqVar.c(ha.DecryptMessageFail.ah);
        hqVar.b(hnVar.h());
        hqVar.d(hnVar.f8859f);
        HashMap hashMap = new HashMap();
        hqVar.f8869h = hashMap;
        hashMap.put("regid", MiPushClient.getRegId(this.f23a));
        ao.a(this.f23a).a((ao) hqVar, gq.Notification, false, (hd) null);
    }

    private void a(hq hqVar) {
        hi hiVar = new hi();
        hiVar.c(ha.CancelPushMessageACK.ah);
        hiVar.a(hqVar.d());
        hiVar.a(hqVar.b());
        hiVar.b(hqVar.f());
        hiVar.e(hqVar.m());
        hiVar.a(0L);
        hiVar.d("success clear push message.");
        ao.a(this.f23a).a(hiVar, gq.Notification, false, true, null, false, this.f23a.getPackageName(), b.m74a(this.f23a).m75a(), false);
    }

    private void a(hu huVar, hn hnVar) {
        hd m2 = hnVar.m();
        if (m2 != null) {
            m2 = com.xiaomi.push.service.au.a(m2.a());
        }
        hg hgVar = new hg();
        hgVar.b(huVar.e());
        hgVar.a(huVar.c());
        hgVar.a(huVar.l().h());
        if (!TextUtils.isEmpty(huVar.h())) {
            hgVar.c(huVar.h());
        }
        if (!TextUtils.isEmpty(huVar.j())) {
            hgVar.d(huVar.j());
        }
        hgVar.a(ib.a(this.f23a, hnVar));
        ao.a(this.f23a).a((ao) hgVar, gq.AckMessage, m2);
    }

    private void a(String str, long j2, e eVar) {
        au a2 = l.a(eVar);
        if (a2 == null) {
            return;
        }
        if (j2 == 0) {
            synchronized (af.class) {
                if (af.a(this.f23a).m53a(str)) {
                    af.a(this.f23a).c(str);
                    if ("syncing".equals(af.a(this.f23a).a(a2))) {
                        af.a(this.f23a).a(a2, "synced");
                    }
                }
            }
        } else if (!"syncing".equals(af.a(this.f23a).a(a2))) {
            af.a(this.f23a).c(str);
        } else {
            synchronized (af.class) {
                if (af.a(this.f23a).m53a(str)) {
                    if (af.a(this.f23a).a(str) < 10) {
                        af.a(this.f23a).b(str);
                        ao.a(this.f23a).a(str, a2, eVar);
                    } else {
                        af.a(this.f23a).c(str);
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private static boolean m54a(Context context, String str) {
        synchronized (f21a) {
            b.m74a(context);
            SharedPreferences a2 = b.a(context);
            if (f22a == null) {
                String[] split = a2.getString("pref_msg_ids", "").split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                f22a = new LinkedList();
                for (String str2 : split) {
                    f22a.add(str2);
                }
            }
            if (f22a.contains(str)) {
                return true;
            }
            f22a.add(str);
            if (f22a.size() > 25) {
                f22a.poll();
            }
            String a3 = com.xiaomi.push.ar.a(f22a, Constants.ACCEPT_TIME_SEPARATOR_SP);
            SharedPreferences.Editor edit = a2.edit();
            edit.putString("pref_msg_ids", a3);
            jj.a(edit);
            return false;
        }
    }

    /* renamed from: a */
    private boolean m55a(hn hnVar) {
        Map<String, String> s = hnVar.m() == null ? null : hnVar.m().s();
        if (s == null) {
            return false;
        }
        String str = s.get(Constants.EXTRA_KEY_PUSH_SERVER_ACTION);
        return TextUtils.equals(str, Constants.EXTRA_VALUE_HYBRID_MESSAGE) || TextUtils.equals(str, Constants.EXTRA_VALUE_PLATFORM_MESSAGE);
    }

    private void b(hi hiVar) {
        Context context;
        e eVar;
        com.xiaomi.a.a.a.c.c("ASSEMBLE_PUSH : " + hiVar.toString());
        String c2 = hiVar.c();
        Map<String, String> j2 = hiVar.j();
        if (j2 != null) {
            String str = j2.get(Constants.ASSEMBLE_PUSH_REG_INFO);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (str.contains("brand:" + ag.FCM.name())) {
                com.xiaomi.a.a.a.c.a("ASSEMBLE_PUSH : receive fcm token sync ack");
                context = this.f23a;
                eVar = e.ASSEMBLE_PUSH_FCM;
            } else {
                if (str.contains("brand:" + ag.HUAWEI.name())) {
                    com.xiaomi.a.a.a.c.a("ASSEMBLE_PUSH : receive hw token sync ack");
                    context = this.f23a;
                    eVar = e.ASSEMBLE_PUSH_HUAWEI;
                } else {
                    if (str.contains("brand:" + ag.OPPO.name())) {
                        com.xiaomi.a.a.a.c.a("ASSEMBLE_PUSH : receive COS token sync ack");
                        context = this.f23a;
                        eVar = e.ASSEMBLE_PUSH_COS;
                    } else {
                        if (!str.contains("brand:" + ag.VIVO.name())) {
                            return;
                        }
                        com.xiaomi.a.a.a.c.a("ASSEMBLE_PUSH : receive FTOS token sync ack");
                        context = this.f23a;
                        eVar = e.ASSEMBLE_PUSH_FTOS;
                    }
                }
            }
            i.b(context, eVar, str);
            a(c2, hiVar.f8819f, eVar);
        }
    }

    private void b(hn hnVar) {
        hd m2 = hnVar.m();
        if (m2 != null) {
            m2 = com.xiaomi.push.service.au.a(m2.a());
        }
        hg hgVar = new hg();
        hgVar.b(hnVar.h());
        hgVar.a(m2.b());
        hgVar.a(m2.d());
        if (!TextUtils.isEmpty(m2.f())) {
            hgVar.c(m2.f());
        }
        hgVar.a(ib.a(this.f23a, hnVar));
        ao.a(this.f23a).a((ao) hgVar, gq.AckMessage, false, m2);
    }

    private void b(hq hqVar) {
        String str;
        Map<String, String> k2 = hqVar.k();
        if (k2 == null) {
            str = "detect failed because null";
        } else {
            String str2 = (String) com.xiaomi.push.service.aa.a(k2, "pkgList", (Object) null);
            if (!TextUtils.isEmpty(str2)) {
                try {
                    List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) this.f23a.getSystemService("activity")).getRunningAppProcesses();
                    if (jm.a(runningAppProcesses)) {
                        com.xiaomi.a.a.a.c.a("detect failed because params illegal");
                        return;
                    }
                    String[] split = str2.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    HashMap hashMap = new HashMap();
                    for (String str3 : split) {
                        String[] split2 = str3.split(Constants.WAVE_SEPARATOR);
                        if (split2.length >= 2) {
                            hashMap.put(split2[1], split2[0]);
                        }
                    }
                    jm.a aVar = new jm.a(Constants.WAVE_SEPARATOR, Constants.ACCEPT_TIME_SEPARATOR_SP);
                    for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                        if (hashMap.containsKey(runningAppProcessInfo.processName)) {
                            aVar.a((String) hashMap.get(runningAppProcessInfo.processName), String.valueOf(runningAppProcessInfo.importance));
                            hashMap.remove(runningAppProcessInfo.processName);
                        }
                    }
                    if (aVar.toString().length() <= 0) {
                        com.xiaomi.a.a.a.c.b("detect failed because no alive process");
                        return;
                    }
                    hq hqVar2 = new hq();
                    hqVar2.a(hqVar.d());
                    hqVar2.b(hqVar.f());
                    hqVar2.d(hqVar.m());
                    hqVar2.c(ha.DetectAppAliveResult.ah);
                    HashMap hashMap2 = new HashMap();
                    hqVar2.f8869h = hashMap2;
                    hashMap2.put("alive", aVar.toString());
                    if (Boolean.parseBoolean((String) com.xiaomi.push.service.aa.a(k2, "reportNotAliveApp", Bugly.SDK_IS_DEV)) && hashMap.size() > 0) {
                        jm.a aVar2 = new jm.a("", Constants.ACCEPT_TIME_SEPARATOR_SP);
                        for (String str4 : hashMap.keySet()) {
                            aVar2.a((String) hashMap.get(str4), "");
                        }
                        hqVar2.f8869h.put("notAlive", aVar2.toString());
                    }
                    ao.a(this.f23a).a((ao) hqVar2, gq.Notification, false, (hd) null);
                    return;
                } catch (Throwable th) {
                    com.xiaomi.a.a.a.c.a("detect failed " + th);
                    return;
                }
            }
            str = "detect failed because empty";
        }
        com.xiaomi.a.a.a.c.a(str);
    }

    public PushMessageHandler.a a(Intent intent) {
        String str;
        dt a2;
        String packageName;
        String str2;
        dt a3;
        String packageName2;
        String format;
        String action = intent.getAction();
        com.xiaomi.a.a.a.c.a("receive an intent from server, action=" + action);
        String stringExtra = intent.getStringExtra("mrt");
        if (stringExtra == null) {
            stringExtra = Long.toString(System.currentTimeMillis());
        }
        String stringExtra2 = intent.getStringExtra("messageId");
        int intExtra = intent.getIntExtra("eventMessageType", -1);
        if ("com.xiaomi.mipush.RECEIVE_MESSAGE".equals(action)) {
            byte[] byteArrayExtra = intent.getByteArrayExtra("mipush_payload");
            boolean booleanExtra = intent.getBooleanExtra("mipush_notified", false);
            if (byteArrayExtra == null) {
                com.xiaomi.a.a.a.c.d("receiving an empty message, drop");
                dt.a(this.f23a).a(this.f23a.getPackageName(), intent, "12");
                return null;
            }
            hn hnVar = new hn();
            try {
                ib.a(hnVar, byteArrayExtra);
                b m74a = b.m74a(this.f23a);
                hd m2 = hnVar.m();
                gq a4 = hnVar.a();
                gq gqVar = gq.SendMessage;
                if (a4 == gqVar && m2 != null && !m74a.m85e() && !booleanExtra) {
                    m2.a("mrt", stringExtra);
                    m2.a("mat", Long.toString(System.currentTimeMillis()));
                    if (m55a(hnVar)) {
                        com.xiaomi.a.a.a.c.b("this is a mina's message, ack later");
                        m2.a(Constants.EXTRA_KEY_HYBRID_MESSAGE_TS, String.valueOf(m2.d()));
                        m2.a(Constants.EXTRA_KEY_HYBRID_DEVICE_STATUS, String.valueOf((int) ib.a(this.f23a, hnVar)));
                    } else {
                        b(hnVar);
                    }
                }
                if (hnVar.a() == gqVar && !hnVar.c()) {
                    if (com.xiaomi.push.service.n.b(hnVar)) {
                        Object[] objArr = new Object[2];
                        objArr[0] = hnVar.j();
                        objArr[1] = m2 != null ? m2.b() : "";
                        com.xiaomi.a.a.a.c.a(String.format("drop an un-encrypted wake-up messages. %1$s, %2$s", objArr));
                        a3 = dt.a(this.f23a);
                        packageName2 = this.f23a.getPackageName();
                        format = String.format("13: %1$s", hnVar.j());
                    } else {
                        Object[] objArr2 = new Object[2];
                        objArr2[0] = hnVar.j();
                        objArr2[1] = m2 != null ? m2.b() : "";
                        com.xiaomi.a.a.a.c.a(String.format("drop an un-encrypted messages. %1$s, %2$s", objArr2));
                        a3 = dt.a(this.f23a);
                        packageName2 = this.f23a.getPackageName();
                        format = String.format("14: %1$s", hnVar.j());
                    }
                    a3.a(packageName2, intent, format);
                    s.a(this.f23a, hnVar, booleanExtra);
                    return null;
                }
                if (hnVar.a() == gqVar && hnVar.c() && com.xiaomi.push.service.n.b(hnVar) && (!booleanExtra || m2 == null || m2.s() == null || !m2.s().containsKey("notify_effect"))) {
                    Object[] objArr3 = new Object[2];
                    objArr3[0] = hnVar.j();
                    objArr3[1] = m2 != null ? m2.b() : "";
                    com.xiaomi.a.a.a.c.a(String.format("drop a wake-up messages which not has 'notify_effect' attr. %1$s, %2$s", objArr3));
                    dt.a(this.f23a).a(this.f23a.getPackageName(), intent, String.format("25: %1$s", hnVar.j()));
                    s.b(this.f23a, hnVar, booleanExtra);
                    return null;
                }
                if (m74a.m83c() || hnVar.a == gq.Registration) {
                    if (!m74a.m83c() || !m74a.m86f()) {
                        return a(hnVar, booleanExtra, byteArrayExtra, stringExtra2, intExtra, intent);
                    }
                    if (hnVar.a != gq.UnRegistration) {
                        s.e(this.f23a, hnVar, booleanExtra);
                        MiPushClient.unregisterPush(this.f23a);
                    } else if (hnVar.c()) {
                        m74a.m76a();
                        MiPushClient.clearExtras(this.f23a);
                        PushMessageHandler.a();
                    } else {
                        com.xiaomi.a.a.a.c.d("receiving an un-encrypt unregistration message");
                    }
                } else if (com.xiaomi.push.service.n.b(hnVar)) {
                    return a(hnVar, booleanExtra, byteArrayExtra, stringExtra2, intExtra, intent);
                } else {
                    s.e(this.f23a, hnVar, booleanExtra);
                    boolean m84d = m74a.m84d();
                    com.xiaomi.a.a.a.c.d("receive message without registration. need re-register!registered?" + m84d);
                    dt.a(this.f23a).a(this.f23a.getPackageName(), intent, "15");
                    if (m84d) {
                        a();
                    }
                }
            } catch (ih e2) {
                e = e2;
                a2 = dt.a(this.f23a);
                packageName = this.f23a.getPackageName();
                str2 = "16";
                a2.a(packageName, intent, str2);
                com.xiaomi.a.a.a.c.a(e);
                return null;
            } catch (Exception e3) {
                e = e3;
                a2 = dt.a(this.f23a);
                packageName = this.f23a.getPackageName();
                str2 = "17";
                a2.a(packageName, intent, str2);
                com.xiaomi.a.a.a.c.a(e);
                return null;
            }
        } else if ("com.xiaomi.mipush.ERROR".equals(action)) {
            MiPushCommandMessage miPushCommandMessage = new MiPushCommandMessage();
            hn hnVar2 = new hn();
            try {
                byte[] byteArrayExtra2 = intent.getByteArrayExtra("mipush_payload");
                if (byteArrayExtra2 != null) {
                    ib.a(hnVar2, byteArrayExtra2);
                }
            } catch (ih unused) {
            }
            miPushCommandMessage.setCommand(String.valueOf(hnVar2.a()));
            miPushCommandMessage.setResultCode(intent.getIntExtra("mipush_error_code", 0));
            miPushCommandMessage.setReason(intent.getStringExtra("mipush_error_msg"));
            com.xiaomi.a.a.a.c.d("receive a error message. code = " + intent.getIntExtra("mipush_error_code", 0) + ", msg= " + intent.getStringExtra("mipush_error_msg"));
            return miPushCommandMessage;
        } else if ("com.xiaomi.mipush.MESSAGE_ARRIVED".equals(action)) {
            byte[] byteArrayExtra3 = intent.getByteArrayExtra("mipush_payload");
            if (byteArrayExtra3 == null) {
                com.xiaomi.a.a.a.c.d("message arrived: receiving an empty message, drop");
                return null;
            }
            hn hnVar3 = new hn();
            try {
                ib.a(hnVar3, byteArrayExtra3);
                b m74a2 = b.m74a(this.f23a);
                if (com.xiaomi.push.service.n.b(hnVar3)) {
                    str = "message arrived: receive ignore reg message, ignore!";
                } else if (!m74a2.m83c()) {
                    str = "message arrived: receive message without registration. need unregister or re-register!";
                } else if (!m74a2.m83c() || !m74a2.m86f()) {
                    return a(hnVar3, byteArrayExtra3);
                } else {
                    str = "message arrived: app info is invalidated";
                }
                com.xiaomi.a.a.a.c.d(str);
            } catch (Exception e4) {
                com.xiaomi.a.a.a.c.d("fail to deal with arrived message. " + e4);
            }
        }
        return null;
    }

    public List<String> a(TimeZone timeZone, TimeZone timeZone2, List<String> list) {
        if (timeZone.equals(timeZone2)) {
            return list;
        }
        long rawOffset = ((timeZone.getRawOffset() - timeZone2.getRawOffset()) / 1000) / 60;
        long parseLong = ((((Long.parseLong(list.get(0).split(Constants.COLON_SEPARATOR)[0]) * 60) + Long.parseLong(list.get(0).split(Constants.COLON_SEPARATOR)[1])) - rawOffset) + 1440) % 1440;
        long parseLong2 = ((((Long.parseLong(list.get(1).split(Constants.COLON_SEPARATOR)[0]) * 60) + Long.parseLong(list.get(1).split(Constants.COLON_SEPARATOR)[1])) - rawOffset) + 1440) % 1440;
        ArrayList arrayList = new ArrayList();
        arrayList.add(String.format("%1$02d:%2$02d", Long.valueOf(parseLong / 60), Long.valueOf(parseLong % 60)));
        arrayList.add(String.format("%1$02d:%2$02d", Long.valueOf(parseLong2 / 60), Long.valueOf(parseLong2 % 60)));
        return arrayList;
    }
}
