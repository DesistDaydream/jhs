package e.c.a.b;

import e.c.a.b.a;

/* loaded from: classes.dex */
public class b {
    private static final a a;

    static {
        new a.b().a("https://log.snssdk.com/service/2/device_register_only/").e("https://ichannel.snssdk.com/service/2/app_alert_check/").b(new String[]{"https://log.snssdk.com/service/2/app_log/", "https://applog.snssdk.com/service/2/app_log/"}).f(new String[]{"https://rtlog.snssdk.com/service/2/app_log/", "https://rtapplog.snssdk.com/service/2/app_log/"}).h("https://log.snssdk.com/service/2/log_settings/").c();
        a = new a.b().a("https://toblog.ctobsnssdk.com/service/2/device_register_only/").e("https://toblog.ctobsnssdk.com/service/2/app_alert_check/").b(new String[]{"https://toblog.ctobsnssdk.com/service/2/app_log/", "https://tobapplog.ctobsnssdk.com/service/2/app_log/"}).h("https://toblog.ctobsnssdk.com/service/2/log_settings/").j("https://toblog.ctobsnssdk.com/service/2/abtest_config/").l("https://success.ctobsnssdk.com/service/2/app_log/").c();
    }

    public static final a a(int i2) {
        return a;
    }
}
