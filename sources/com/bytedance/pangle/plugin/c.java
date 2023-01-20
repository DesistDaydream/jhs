package com.bytedance.pangle.plugin;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.bytedance.pangle.ComponentManager;
import com.bytedance.pangle.ZeusPluginStateListener;
import com.bytedance.pangle.b.b;
import com.bytedance.pangle.g;
import com.bytedance.pangle.log.ZeusLogger;
import com.qiniu.android.collect.ReportItem;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class c {
    private static final g a = g.a();

    public final boolean a(String str) {
        Plugin plugin = PluginManager.getInstance().getPlugin(str);
        if (plugin == null) {
            ZeusLogger.w(ZeusLogger.TAG_LOAD, "PluginLoader loadPlugin, plugin == null, pkg = ".concat(String.valueOf(str)));
            return false;
        }
        synchronized (plugin) {
            if (!plugin.isInstalled()) {
                ZeusLogger.w(ZeusLogger.TAG_LOAD, "PluginLoader loadPlugin, UN_INSTALLED, ".concat(String.valueOf(str)));
                return false;
            } else if (plugin.isLoaded()) {
                return true;
            } else {
                g gVar = a;
                gVar.a(2000, 0, plugin.mPkgName, plugin.getVersion(), null);
                com.bytedance.pangle.log.b a2 = com.bytedance.pangle.log.b.a(ZeusLogger.TAG_LOAD, "PluginLoader", "loadPlugin:".concat(String.valueOf(str)));
                a(com.bytedance.pangle.b.b.f2214g, b.a.z, plugin.mPkgName, plugin.getVersion(), -1L, null);
                ZeusPluginStateListener.postStateChange(str, 8, new Object[0]);
                StringBuilder sb = new StringBuilder();
                boolean a3 = a(str, plugin, sb);
                a2.b("loadPluginInternal:".concat(String.valueOf(a3)));
                if (a3) {
                    plugin.setLifeCycle(3);
                    a(com.bytedance.pangle.b.b.f2215h, b.a.A, plugin.mPkgName, plugin.getVersion(), a2.a(), sb.toString());
                    ZeusPluginStateListener.postStateChange(str, 9, new Object[0]);
                    gVar.a(2100, 0, plugin.mPkgName, plugin.getVersion(), null);
                } else {
                    sb.append("plugin:");
                    sb.append(plugin.mPkgName);
                    sb.append(" versionCode:");
                    sb.append(plugin.getVersion());
                    sb.append("load failed;");
                    a(com.bytedance.pangle.b.b.f2215h, b.a.B, plugin.mPkgName, plugin.getVersion(), -1L, sb.toString());
                    ZeusPluginStateListener.postStateChange(str, 10, new Object[0]);
                    gVar.a(2100, -1, plugin.mPkgName, plugin.getVersion(), null);
                }
                ZeusLogger.i(ZeusLogger.TAG_LOAD, "PluginLoader loadFinished, ".concat(String.valueOf(plugin)));
                if (plugin.isLoaded()) {
                    ZeusLogger.d(ZeusLogger.TAG_LOAD, "PluginLoader postResult, LOADED " + plugin.mPkgName);
                    return true;
                }
                return false;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:241:0x0131 A[Catch: all -> 0x043d, TRY_LEAVE, TryCatch #2 {all -> 0x043d, blocks: (B:195:0x000f, B:197:0x0021, B:199:0x003b, B:201:0x0041, B:203:0x005b, B:208:0x0078, B:210:0x008d, B:212:0x00a7, B:217:0x00c2, B:222:0x00ec, B:224:0x00fd, B:225:0x0100, B:230:0x011b, B:234:0x0126, B:241:0x0131, B:247:0x0185, B:249:0x0189, B:250:0x0193, B:255:0x01b0, B:260:0x01db, B:262:0x021a, B:263:0x021e, B:265:0x0228, B:266:0x022c, B:271:0x0249, B:276:0x027b, B:279:0x028f, B:281:0x0293, B:283:0x029d, B:286:0x02a6, B:288:0x02b5, B:287:0x02b3, B:289:0x02c2, B:291:0x02c6, B:293:0x02ca, B:295:0x02d4, B:298:0x02dd, B:300:0x02eb, B:299:0x02e9, B:301:0x02f5, B:306:0x0312, B:308:0x0316, B:310:0x031a, B:312:0x0324, B:315:0x032d, B:317:0x033b, B:316:0x0339, B:318:0x0345, B:323:0x0362, B:325:0x0366, B:327:0x036a, B:329:0x0374, B:332:0x037d, B:334:0x038b, B:333:0x0389, B:335:0x0395, B:340:0x03b2, B:342:0x03b6, B:344:0x03bc, B:345:0x03c9, B:350:0x03e6, B:352:0x03f0, B:353:0x0409, B:358:0x0426, B:360:0x0438, B:357:0x041b, B:349:0x03db, B:339:0x03a7, B:322:0x0357, B:305:0x0307, B:275:0x0270, B:270:0x023e, B:259:0x01d0, B:254:0x01a5, B:246:0x0176, B:229:0x0110, B:221:0x00e1, B:216:0x00b7, B:207:0x006d, B:242:0x0142), top: B:369:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:246:0x0176 A[Catch: all -> 0x043d, TryCatch #2 {all -> 0x043d, blocks: (B:195:0x000f, B:197:0x0021, B:199:0x003b, B:201:0x0041, B:203:0x005b, B:208:0x0078, B:210:0x008d, B:212:0x00a7, B:217:0x00c2, B:222:0x00ec, B:224:0x00fd, B:225:0x0100, B:230:0x011b, B:234:0x0126, B:241:0x0131, B:247:0x0185, B:249:0x0189, B:250:0x0193, B:255:0x01b0, B:260:0x01db, B:262:0x021a, B:263:0x021e, B:265:0x0228, B:266:0x022c, B:271:0x0249, B:276:0x027b, B:279:0x028f, B:281:0x0293, B:283:0x029d, B:286:0x02a6, B:288:0x02b5, B:287:0x02b3, B:289:0x02c2, B:291:0x02c6, B:293:0x02ca, B:295:0x02d4, B:298:0x02dd, B:300:0x02eb, B:299:0x02e9, B:301:0x02f5, B:306:0x0312, B:308:0x0316, B:310:0x031a, B:312:0x0324, B:315:0x032d, B:317:0x033b, B:316:0x0339, B:318:0x0345, B:323:0x0362, B:325:0x0366, B:327:0x036a, B:329:0x0374, B:332:0x037d, B:334:0x038b, B:333:0x0389, B:335:0x0395, B:340:0x03b2, B:342:0x03b6, B:344:0x03bc, B:345:0x03c9, B:350:0x03e6, B:352:0x03f0, B:353:0x0409, B:358:0x0426, B:360:0x0438, B:357:0x041b, B:349:0x03db, B:339:0x03a7, B:322:0x0357, B:305:0x0307, B:275:0x0270, B:270:0x023e, B:259:0x01d0, B:254:0x01a5, B:246:0x0176, B:229:0x0110, B:221:0x00e1, B:216:0x00b7, B:207:0x006d, B:242:0x0142), top: B:369:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:249:0x0189 A[Catch: all -> 0x043d, TryCatch #2 {all -> 0x043d, blocks: (B:195:0x000f, B:197:0x0021, B:199:0x003b, B:201:0x0041, B:203:0x005b, B:208:0x0078, B:210:0x008d, B:212:0x00a7, B:217:0x00c2, B:222:0x00ec, B:224:0x00fd, B:225:0x0100, B:230:0x011b, B:234:0x0126, B:241:0x0131, B:247:0x0185, B:249:0x0189, B:250:0x0193, B:255:0x01b0, B:260:0x01db, B:262:0x021a, B:263:0x021e, B:265:0x0228, B:266:0x022c, B:271:0x0249, B:276:0x027b, B:279:0x028f, B:281:0x0293, B:283:0x029d, B:286:0x02a6, B:288:0x02b5, B:287:0x02b3, B:289:0x02c2, B:291:0x02c6, B:293:0x02ca, B:295:0x02d4, B:298:0x02dd, B:300:0x02eb, B:299:0x02e9, B:301:0x02f5, B:306:0x0312, B:308:0x0316, B:310:0x031a, B:312:0x0324, B:315:0x032d, B:317:0x033b, B:316:0x0339, B:318:0x0345, B:323:0x0362, B:325:0x0366, B:327:0x036a, B:329:0x0374, B:332:0x037d, B:334:0x038b, B:333:0x0389, B:335:0x0395, B:340:0x03b2, B:342:0x03b6, B:344:0x03bc, B:345:0x03c9, B:350:0x03e6, B:352:0x03f0, B:353:0x0409, B:358:0x0426, B:360:0x0438, B:357:0x041b, B:349:0x03db, B:339:0x03a7, B:322:0x0357, B:305:0x0307, B:275:0x0270, B:270:0x023e, B:259:0x01d0, B:254:0x01a5, B:246:0x0176, B:229:0x0110, B:221:0x00e1, B:216:0x00b7, B:207:0x006d, B:242:0x0142), top: B:369:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:262:0x021a A[Catch: all -> 0x043d, TryCatch #2 {all -> 0x043d, blocks: (B:195:0x000f, B:197:0x0021, B:199:0x003b, B:201:0x0041, B:203:0x005b, B:208:0x0078, B:210:0x008d, B:212:0x00a7, B:217:0x00c2, B:222:0x00ec, B:224:0x00fd, B:225:0x0100, B:230:0x011b, B:234:0x0126, B:241:0x0131, B:247:0x0185, B:249:0x0189, B:250:0x0193, B:255:0x01b0, B:260:0x01db, B:262:0x021a, B:263:0x021e, B:265:0x0228, B:266:0x022c, B:271:0x0249, B:276:0x027b, B:279:0x028f, B:281:0x0293, B:283:0x029d, B:286:0x02a6, B:288:0x02b5, B:287:0x02b3, B:289:0x02c2, B:291:0x02c6, B:293:0x02ca, B:295:0x02d4, B:298:0x02dd, B:300:0x02eb, B:299:0x02e9, B:301:0x02f5, B:306:0x0312, B:308:0x0316, B:310:0x031a, B:312:0x0324, B:315:0x032d, B:317:0x033b, B:316:0x0339, B:318:0x0345, B:323:0x0362, B:325:0x0366, B:327:0x036a, B:329:0x0374, B:332:0x037d, B:334:0x038b, B:333:0x0389, B:335:0x0395, B:340:0x03b2, B:342:0x03b6, B:344:0x03bc, B:345:0x03c9, B:350:0x03e6, B:352:0x03f0, B:353:0x0409, B:358:0x0426, B:360:0x0438, B:357:0x041b, B:349:0x03db, B:339:0x03a7, B:322:0x0357, B:305:0x0307, B:275:0x0270, B:270:0x023e, B:259:0x01d0, B:254:0x01a5, B:246:0x0176, B:229:0x0110, B:221:0x00e1, B:216:0x00b7, B:207:0x006d, B:242:0x0142), top: B:369:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:265:0x0228 A[Catch: all -> 0x043d, TryCatch #2 {all -> 0x043d, blocks: (B:195:0x000f, B:197:0x0021, B:199:0x003b, B:201:0x0041, B:203:0x005b, B:208:0x0078, B:210:0x008d, B:212:0x00a7, B:217:0x00c2, B:222:0x00ec, B:224:0x00fd, B:225:0x0100, B:230:0x011b, B:234:0x0126, B:241:0x0131, B:247:0x0185, B:249:0x0189, B:250:0x0193, B:255:0x01b0, B:260:0x01db, B:262:0x021a, B:263:0x021e, B:265:0x0228, B:266:0x022c, B:271:0x0249, B:276:0x027b, B:279:0x028f, B:281:0x0293, B:283:0x029d, B:286:0x02a6, B:288:0x02b5, B:287:0x02b3, B:289:0x02c2, B:291:0x02c6, B:293:0x02ca, B:295:0x02d4, B:298:0x02dd, B:300:0x02eb, B:299:0x02e9, B:301:0x02f5, B:306:0x0312, B:308:0x0316, B:310:0x031a, B:312:0x0324, B:315:0x032d, B:317:0x033b, B:316:0x0339, B:318:0x0345, B:323:0x0362, B:325:0x0366, B:327:0x036a, B:329:0x0374, B:332:0x037d, B:334:0x038b, B:333:0x0389, B:335:0x0395, B:340:0x03b2, B:342:0x03b6, B:344:0x03bc, B:345:0x03c9, B:350:0x03e6, B:352:0x03f0, B:353:0x0409, B:358:0x0426, B:360:0x0438, B:357:0x041b, B:349:0x03db, B:339:0x03a7, B:322:0x0357, B:305:0x0307, B:275:0x0270, B:270:0x023e, B:259:0x01d0, B:254:0x01a5, B:246:0x0176, B:229:0x0110, B:221:0x00e1, B:216:0x00b7, B:207:0x006d, B:242:0x0142), top: B:369:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:279:0x028f A[Catch: all -> 0x043d, TRY_ENTER, TryCatch #2 {all -> 0x043d, blocks: (B:195:0x000f, B:197:0x0021, B:199:0x003b, B:201:0x0041, B:203:0x005b, B:208:0x0078, B:210:0x008d, B:212:0x00a7, B:217:0x00c2, B:222:0x00ec, B:224:0x00fd, B:225:0x0100, B:230:0x011b, B:234:0x0126, B:241:0x0131, B:247:0x0185, B:249:0x0189, B:250:0x0193, B:255:0x01b0, B:260:0x01db, B:262:0x021a, B:263:0x021e, B:265:0x0228, B:266:0x022c, B:271:0x0249, B:276:0x027b, B:279:0x028f, B:281:0x0293, B:283:0x029d, B:286:0x02a6, B:288:0x02b5, B:287:0x02b3, B:289:0x02c2, B:291:0x02c6, B:293:0x02ca, B:295:0x02d4, B:298:0x02dd, B:300:0x02eb, B:299:0x02e9, B:301:0x02f5, B:306:0x0312, B:308:0x0316, B:310:0x031a, B:312:0x0324, B:315:0x032d, B:317:0x033b, B:316:0x0339, B:318:0x0345, B:323:0x0362, B:325:0x0366, B:327:0x036a, B:329:0x0374, B:332:0x037d, B:334:0x038b, B:333:0x0389, B:335:0x0395, B:340:0x03b2, B:342:0x03b6, B:344:0x03bc, B:345:0x03c9, B:350:0x03e6, B:352:0x03f0, B:353:0x0409, B:358:0x0426, B:360:0x0438, B:357:0x041b, B:349:0x03db, B:339:0x03a7, B:322:0x0357, B:305:0x0307, B:275:0x0270, B:270:0x023e, B:259:0x01d0, B:254:0x01a5, B:246:0x0176, B:229:0x0110, B:221:0x00e1, B:216:0x00b7, B:207:0x006d, B:242:0x0142), top: B:369:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:291:0x02c6 A[Catch: all -> 0x043d, TryCatch #2 {all -> 0x043d, blocks: (B:195:0x000f, B:197:0x0021, B:199:0x003b, B:201:0x0041, B:203:0x005b, B:208:0x0078, B:210:0x008d, B:212:0x00a7, B:217:0x00c2, B:222:0x00ec, B:224:0x00fd, B:225:0x0100, B:230:0x011b, B:234:0x0126, B:241:0x0131, B:247:0x0185, B:249:0x0189, B:250:0x0193, B:255:0x01b0, B:260:0x01db, B:262:0x021a, B:263:0x021e, B:265:0x0228, B:266:0x022c, B:271:0x0249, B:276:0x027b, B:279:0x028f, B:281:0x0293, B:283:0x029d, B:286:0x02a6, B:288:0x02b5, B:287:0x02b3, B:289:0x02c2, B:291:0x02c6, B:293:0x02ca, B:295:0x02d4, B:298:0x02dd, B:300:0x02eb, B:299:0x02e9, B:301:0x02f5, B:306:0x0312, B:308:0x0316, B:310:0x031a, B:312:0x0324, B:315:0x032d, B:317:0x033b, B:316:0x0339, B:318:0x0345, B:323:0x0362, B:325:0x0366, B:327:0x036a, B:329:0x0374, B:332:0x037d, B:334:0x038b, B:333:0x0389, B:335:0x0395, B:340:0x03b2, B:342:0x03b6, B:344:0x03bc, B:345:0x03c9, B:350:0x03e6, B:352:0x03f0, B:353:0x0409, B:358:0x0426, B:360:0x0438, B:357:0x041b, B:349:0x03db, B:339:0x03a7, B:322:0x0357, B:305:0x0307, B:275:0x0270, B:270:0x023e, B:259:0x01d0, B:254:0x01a5, B:246:0x0176, B:229:0x0110, B:221:0x00e1, B:216:0x00b7, B:207:0x006d, B:242:0x0142), top: B:369:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:308:0x0316 A[Catch: all -> 0x043d, TryCatch #2 {all -> 0x043d, blocks: (B:195:0x000f, B:197:0x0021, B:199:0x003b, B:201:0x0041, B:203:0x005b, B:208:0x0078, B:210:0x008d, B:212:0x00a7, B:217:0x00c2, B:222:0x00ec, B:224:0x00fd, B:225:0x0100, B:230:0x011b, B:234:0x0126, B:241:0x0131, B:247:0x0185, B:249:0x0189, B:250:0x0193, B:255:0x01b0, B:260:0x01db, B:262:0x021a, B:263:0x021e, B:265:0x0228, B:266:0x022c, B:271:0x0249, B:276:0x027b, B:279:0x028f, B:281:0x0293, B:283:0x029d, B:286:0x02a6, B:288:0x02b5, B:287:0x02b3, B:289:0x02c2, B:291:0x02c6, B:293:0x02ca, B:295:0x02d4, B:298:0x02dd, B:300:0x02eb, B:299:0x02e9, B:301:0x02f5, B:306:0x0312, B:308:0x0316, B:310:0x031a, B:312:0x0324, B:315:0x032d, B:317:0x033b, B:316:0x0339, B:318:0x0345, B:323:0x0362, B:325:0x0366, B:327:0x036a, B:329:0x0374, B:332:0x037d, B:334:0x038b, B:333:0x0389, B:335:0x0395, B:340:0x03b2, B:342:0x03b6, B:344:0x03bc, B:345:0x03c9, B:350:0x03e6, B:352:0x03f0, B:353:0x0409, B:358:0x0426, B:360:0x0438, B:357:0x041b, B:349:0x03db, B:339:0x03a7, B:322:0x0357, B:305:0x0307, B:275:0x0270, B:270:0x023e, B:259:0x01d0, B:254:0x01a5, B:246:0x0176, B:229:0x0110, B:221:0x00e1, B:216:0x00b7, B:207:0x006d, B:242:0x0142), top: B:369:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:325:0x0366 A[Catch: all -> 0x043d, TryCatch #2 {all -> 0x043d, blocks: (B:195:0x000f, B:197:0x0021, B:199:0x003b, B:201:0x0041, B:203:0x005b, B:208:0x0078, B:210:0x008d, B:212:0x00a7, B:217:0x00c2, B:222:0x00ec, B:224:0x00fd, B:225:0x0100, B:230:0x011b, B:234:0x0126, B:241:0x0131, B:247:0x0185, B:249:0x0189, B:250:0x0193, B:255:0x01b0, B:260:0x01db, B:262:0x021a, B:263:0x021e, B:265:0x0228, B:266:0x022c, B:271:0x0249, B:276:0x027b, B:279:0x028f, B:281:0x0293, B:283:0x029d, B:286:0x02a6, B:288:0x02b5, B:287:0x02b3, B:289:0x02c2, B:291:0x02c6, B:293:0x02ca, B:295:0x02d4, B:298:0x02dd, B:300:0x02eb, B:299:0x02e9, B:301:0x02f5, B:306:0x0312, B:308:0x0316, B:310:0x031a, B:312:0x0324, B:315:0x032d, B:317:0x033b, B:316:0x0339, B:318:0x0345, B:323:0x0362, B:325:0x0366, B:327:0x036a, B:329:0x0374, B:332:0x037d, B:334:0x038b, B:333:0x0389, B:335:0x0395, B:340:0x03b2, B:342:0x03b6, B:344:0x03bc, B:345:0x03c9, B:350:0x03e6, B:352:0x03f0, B:353:0x0409, B:358:0x0426, B:360:0x0438, B:357:0x041b, B:349:0x03db, B:339:0x03a7, B:322:0x0357, B:305:0x0307, B:275:0x0270, B:270:0x023e, B:259:0x01d0, B:254:0x01a5, B:246:0x0176, B:229:0x0110, B:221:0x00e1, B:216:0x00b7, B:207:0x006d, B:242:0x0142), top: B:369:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:352:0x03f0 A[Catch: all -> 0x043d, TryCatch #2 {all -> 0x043d, blocks: (B:195:0x000f, B:197:0x0021, B:199:0x003b, B:201:0x0041, B:203:0x005b, B:208:0x0078, B:210:0x008d, B:212:0x00a7, B:217:0x00c2, B:222:0x00ec, B:224:0x00fd, B:225:0x0100, B:230:0x011b, B:234:0x0126, B:241:0x0131, B:247:0x0185, B:249:0x0189, B:250:0x0193, B:255:0x01b0, B:260:0x01db, B:262:0x021a, B:263:0x021e, B:265:0x0228, B:266:0x022c, B:271:0x0249, B:276:0x027b, B:279:0x028f, B:281:0x0293, B:283:0x029d, B:286:0x02a6, B:288:0x02b5, B:287:0x02b3, B:289:0x02c2, B:291:0x02c6, B:293:0x02ca, B:295:0x02d4, B:298:0x02dd, B:300:0x02eb, B:299:0x02e9, B:301:0x02f5, B:306:0x0312, B:308:0x0316, B:310:0x031a, B:312:0x0324, B:315:0x032d, B:317:0x033b, B:316:0x0339, B:318:0x0345, B:323:0x0362, B:325:0x0366, B:327:0x036a, B:329:0x0374, B:332:0x037d, B:334:0x038b, B:333:0x0389, B:335:0x0395, B:340:0x03b2, B:342:0x03b6, B:344:0x03bc, B:345:0x03c9, B:350:0x03e6, B:352:0x03f0, B:353:0x0409, B:358:0x0426, B:360:0x0438, B:357:0x041b, B:349:0x03db, B:339:0x03a7, B:322:0x0357, B:305:0x0307, B:275:0x0270, B:270:0x023e, B:259:0x01d0, B:254:0x01a5, B:246:0x0176, B:229:0x0110, B:221:0x00e1, B:216:0x00b7, B:207:0x006d, B:242:0x0142), top: B:369:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:360:0x0438 A[Catch: ClassNotFoundException -> 0x043b, all -> 0x043d, TRY_LEAVE, TryCatch #1 {ClassNotFoundException -> 0x043b, blocks: (B:358:0x0426, B:360:0x0438), top: B:367:0x0426 }] */
    /* JADX WARN: Removed duplicated region for block: B:382:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean a(java.lang.String r23, final com.bytedance.pangle.plugin.Plugin r24, java.lang.StringBuilder r25) {
        /*
            Method dump skipped, instructions count: 1123
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.pangle.plugin.c.a(java.lang.String, com.bytedance.pangle.plugin.Plugin, java.lang.StringBuilder):boolean");
    }

    private static void a(Plugin plugin, String str) {
        JSONObject optJSONObject;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        JSONObject jSONObject = new JSONObject(str);
        JSONObject optJSONObject2 = jSONObject.optJSONObject("mapping");
        HashMap hashMap = new HashMap();
        if (optJSONObject2 != null) {
            Iterator<String> keys = optJSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                hashMap.put(next, optJSONObject2.getString(next));
            }
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("forceMappings");
        if (optJSONArray != null) {
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                int optInt = jSONObject2.optInt("minApi", 0);
                int optInt2 = jSONObject2.optInt("maxApi", Integer.MAX_VALUE);
                int apiVersionCode = plugin.getApiVersionCode();
                if (apiVersionCode <= optInt2 && apiVersionCode >= optInt && (optJSONObject = jSONObject2.optJSONObject("mapping")) != null) {
                    Iterator<String> keys2 = optJSONObject.keys();
                    while (keys2.hasNext()) {
                        String next2 = keys2.next();
                        hashMap.put(next2, optJSONObject.getString(next2));
                    }
                }
            }
        }
        for (String str2 : hashMap.keySet()) {
            String str3 = (String) hashMap.get(str2);
            String str4 = plugin.mPkgName;
            StringBuilder sb = new StringBuilder();
            sb.append((str3 == null || !str3.contains(".")) ? plugin.mPkgName + "." : "");
            sb.append((String) hashMap.get(str2));
            ComponentManager.registerActivity(str4, sb.toString(), str2);
        }
    }

    private static void a(String str, int i2, @NonNull String str2, int i3, long j2, String str3) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject.putOpt(ReportItem.RequestKeyStatusCode, com.bytedance.pangle.log.c.a(Integer.valueOf(i2)));
            jSONObject.putOpt("plugin_package_name", com.bytedance.pangle.log.c.a(str2));
            jSONObject.putOpt("version_code", com.bytedance.pangle.log.c.a(Integer.valueOf(i3)));
            jSONObject3.putOpt("duration", Integer.valueOf(com.bytedance.pangle.log.c.b(Long.valueOf(j2))));
            jSONObject2.putOpt("message", com.bytedance.pangle.log.c.a(str3));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        com.bytedance.pangle.b.b.a().a(str, jSONObject, jSONObject3, jSONObject2);
    }
}
