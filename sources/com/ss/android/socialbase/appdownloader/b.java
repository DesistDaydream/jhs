package com.ss.android.socialbase.appdownloader;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.provider.FontsContractCompat;
import com.huawei.hms.support.api.entity.core.CommonCode;
import com.meizu.cloud.pushsdk.notification.model.NotificationStyle;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.socialbase.appdownloader.view.JumpUnknownSourceActivity;
import com.ss.android.socialbase.downloader.a.a;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.h.h;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.tencent.android.tpush.XGPushNotificationBuilder;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class b {
    private static final String a = "b";
    private static c b;

    /* renamed from: c  reason: collision with root package name */
    private static a f5425c;

    /* loaded from: classes3.dex */
    public static class a implements a.InterfaceC0188a {
        private final e a;
        private final int b;

        /* renamed from: c  reason: collision with root package name */
        private JSONObject f5426c;

        public a(Context context, Intent intent, int i2, JSONObject jSONObject, InterfaceC0185b interfaceC0185b) {
            this.f5426c = jSONObject;
            int optInt = jSONObject.optInt("query_interval", 1000);
            this.b = optInt;
            this.a = new e(context, intent, i2, interfaceC0185b, optInt);
        }

        @Override // com.ss.android.socialbase.downloader.a.a.InterfaceC0188a
        public void b() {
            if (!this.a.f5435i) {
                Message obtain = Message.obtain();
                obtain.what = 2;
                this.a.f5432f.sendMessage(obtain);
            }
            com.ss.android.socialbase.downloader.a.a.a().b(this);
            a unused = b.f5425c = null;
        }

        @Override // com.ss.android.socialbase.downloader.a.a.InterfaceC0188a
        public void c() {
            int optInt = this.f5426c.optInt("time_out_second", 20);
            Message obtain = Message.obtain();
            obtain.what = 1;
            this.a.f5432f.sendMessage(obtain);
            if (optInt <= 0 || optInt >= 60) {
                return;
            }
            Message obtain2 = Message.obtain();
            obtain2.what = 2;
            this.a.f5432f.sendMessageDelayed(obtain2, optInt * 1000);
        }
    }

    /* renamed from: com.ss.android.socialbase.appdownloader.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0185b {
        boolean a(@NonNull Context context);
    }

    /* loaded from: classes3.dex */
    public interface c {
        void a(DownloadInfo downloadInfo, com.ss.android.socialbase.appdownloader.a aVar);
    }

    /* loaded from: classes3.dex */
    public static class d implements Callable<Boolean> {
        private final Context a;
        private final InterfaceC0185b b;

        /* renamed from: c  reason: collision with root package name */
        private final Handler f5427c;

        /* renamed from: d  reason: collision with root package name */
        private final long f5428d;

        public d(Handler handler, Context context, InterfaceC0185b interfaceC0185b, long j2) {
            this.a = context;
            this.b = interfaceC0185b;
            this.f5427c = handler;
            this.f5428d = j2;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Boolean call() throws Exception {
            Boolean bool = Boolean.FALSE;
            try {
                InterfaceC0185b interfaceC0185b = this.b;
                if (interfaceC0185b != null) {
                    long j2 = this.f5428d;
                    if (j2 > 0 && j2 <= com.heytap.mcssdk.constant.a.q) {
                        Context context = this.a;
                        boolean a = context != null ? interfaceC0185b.a(context) : false;
                        Message obtain = Message.obtain();
                        if (a) {
                            obtain.what = 2;
                            this.f5427c.sendMessage(obtain);
                        } else {
                            obtain.what = 1;
                            this.f5427c.sendMessageDelayed(obtain, this.f5428d);
                        }
                    }
                }
            } catch (Throwable unused) {
            }
            return bool;
        }
    }

    /* loaded from: classes3.dex */
    public static class e implements h.a {
        public static int a;
        private static int b;

        /* renamed from: c  reason: collision with root package name */
        private final Context f5429c;

        /* renamed from: d  reason: collision with root package name */
        private final Intent f5430d;

        /* renamed from: e  reason: collision with root package name */
        private final InterfaceC0185b f5431e;

        /* renamed from: f  reason: collision with root package name */
        private final Handler f5432f;

        /* renamed from: g  reason: collision with root package name */
        private final long f5433g;

        /* renamed from: h  reason: collision with root package name */
        private Future<Boolean> f5434h;

        /* renamed from: i  reason: collision with root package name */
        private boolean f5435i = false;

        public e(Context context, Intent intent, int i2, InterfaceC0185b interfaceC0185b, long j2) {
            this.f5429c = context;
            this.f5430d = intent;
            b = i2;
            this.f5431e = interfaceC0185b;
            this.f5432f = new com.ss.android.socialbase.downloader.h.h(Looper.getMainLooper(), this);
            this.f5433g = j2;
        }

        @Override // com.ss.android.socialbase.downloader.h.h.a
        public void a(Message message) {
            if (message != null) {
                int i2 = message.what;
                if (i2 == 1) {
                    long j2 = this.f5433g;
                    if (j2 <= 0 || j2 > com.heytap.mcssdk.constant.a.q) {
                        return;
                    }
                    a = 1;
                    this.f5434h = com.ss.android.socialbase.downloader.downloader.c.l().submit(new d(this.f5432f, this.f5429c, this.f5431e, this.f5433g));
                } else if (i2 == 2) {
                    a = 2;
                    this.f5432f.removeMessages(2);
                    this.f5432f.removeMessages(1);
                    Future<Boolean> future = this.f5434h;
                    if (future != null) {
                        future.cancel(true);
                    }
                    if (!this.f5435i && (Build.VERSION.SDK_INT < 29 || com.ss.android.socialbase.downloader.a.a.a().b())) {
                        Intent intent = this.f5430d;
                        if (intent != null) {
                            b.b(this.f5429c, intent);
                        } else {
                            DownloadInfo downloadInfo = Downloader.getInstance(this.f5429c).getDownloadInfo(b);
                            if (downloadInfo != null && downloadInfo.isDownloadOverStatus()) {
                                com.ss.android.socialbase.appdownloader.c.b(this.f5429c, b, false);
                            }
                        }
                        this.f5435i = true;
                    }
                    b.b(b, this.f5430d == null, b.a(this.f5429c));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean d(Context context) {
        if (context == null) {
            return true;
        }
        try {
            return Settings.Secure.getInt(context.getContentResolver(), "install_non_market_apps", 1) > 0;
        } catch (Throwable unused) {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @RequiresApi(api = 26)
    public static boolean e(Context context) {
        if (context == null) {
            return true;
        }
        try {
            return context.getPackageManager().canRequestPackageInstalls();
        } catch (Throwable unused) {
            return true;
        }
    }

    private static boolean b(Context context, @NonNull DownloadInfo downloadInfo, JSONObject jSONObject, @NonNull com.ss.android.socialbase.appdownloader.a aVar) {
        if (context != null && jSONObject != null) {
            String savePath = downloadInfo.getSavePath();
            if (TextUtils.isEmpty(savePath)) {
                return false;
            }
            aVar.f5419d = XGPushNotificationBuilder.CUSTOM_NOTIFICATION_BUILDER_TYPE;
            com.ss.android.socialbase.appdownloader.a.a a2 = com.ss.android.socialbase.appdownloader.a.d.a(context, XGPushNotificationBuilder.CUSTOM_NOTIFICATION_BUILDER_TYPE, jSONObject, downloadInfo);
            if (a2 != null && a2.a()) {
                Intent b2 = a2.b();
                if (b2 == null) {
                    return false;
                }
                if (a(new File(savePath), downloadInfo, jSONObject)) {
                    if (b(context, b2)) {
                        aVar.b = 0;
                        return true;
                    }
                    aVar.b = 1;
                } else {
                    aVar.b = 6;
                }
                return false;
            }
            aVar.b = 3;
        }
        return false;
    }

    public static void c(int i2, JSONObject jSONObject) {
        int i3 = 1;
        boolean z = jSONObject.optInt("show_unknown_source_on_startup") == 1;
        JSONObject jSONObject2 = new JSONObject();
        if (!z) {
            i3 = 2;
        }
        try {
            jSONObject2.put("scene", i3);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        com.ss.android.socialbase.downloader.downloader.c.P().b(i2, "guide_auth_open_setting", jSONObject2);
    }

    private static void d(int i2, JSONObject jSONObject) {
        int i3 = 1;
        boolean z = jSONObject.optInt("show_unknown_source_on_startup") == 1;
        JSONObject jSONObject2 = new JSONObject();
        if (!z) {
            i3 = 2;
        }
        try {
            jSONObject2.put("scene", i3);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        com.ss.android.socialbase.downloader.downloader.c.P().b(i2, "guide_auth_dialog_show", jSONObject2);
    }

    public static boolean a(Context context, DownloadInfo downloadInfo, Intent intent, boolean z) {
        JSONArray e2 = com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId()).e("ah_plans");
        if (e2 != null) {
            int length = e2.length();
            for (int i2 = 0; i2 < length; i2++) {
                JSONObject optJSONObject = e2.optJSONObject(i2);
                if (com.ss.android.socialbase.appdownloader.f.a.a(optJSONObject) && a(context, downloadInfo, intent, optJSONObject, z)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:100:0x0173  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean a(android.content.Context r11, com.ss.android.socialbase.downloader.model.DownloadInfo r12, android.content.Intent r13, org.json.JSONObject r14, boolean r15) {
        /*
            Method dump skipped, instructions count: 478
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.b.a(android.content.Context, com.ss.android.socialbase.downloader.model.DownloadInfo, android.content.Intent, org.json.JSONObject, boolean):boolean");
    }

    public static com.ss.android.socialbase.appdownloader.a b(JSONObject jSONObject, com.ss.android.socialbase.downloader.g.a aVar) {
        com.ss.android.socialbase.appdownloader.a aVar2 = new com.ss.android.socialbase.appdownloader.a();
        if (jSONObject == null) {
            return aVar2;
        }
        aVar2.a = jSONObject.optString("type");
        aVar2.f5420e = "vbi";
        if (com.ss.android.socialbase.appdownloader.a.d.a(com.ss.android.socialbase.downloader.downloader.c.N(), "vbi", jSONObject, aVar)) {
            aVar2.b = 0;
        } else {
            a(aVar2, 3);
        }
        return aVar2;
    }

    public static void b(int i2, JSONObject jSONObject) {
        int i3 = 1;
        boolean z = jSONObject.optInt("show_unknown_source_on_startup") == 1;
        JSONObject jSONObject2 = new JSONObject();
        if (!z) {
            i3 = 2;
        }
        try {
            jSONObject2.put("scene", i3);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        com.ss.android.socialbase.downloader.downloader.c.P().b(i2, "guide_auth_dialog_cancel", jSONObject2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(int i2, boolean z, boolean z2) {
        JSONObject jSONObject = new JSONObject();
        int i3 = 1;
        try {
            jSONObject.put("scene", z ? 1 : 2);
            if (!z2) {
                i3 = 2;
            }
            jSONObject.put(FontsContractCompat.Columns.RESULT_CODE, i3);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        com.ss.android.socialbase.downloader.downloader.c.P().b(i2, "guide_auth_result", jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(Context context, Intent intent) {
        return a(context, intent, true);
    }

    private static boolean a(Context context, @NonNull DownloadInfo downloadInfo, JSONObject jSONObject, @NonNull com.ss.android.socialbase.appdownloader.a aVar, com.ss.android.socialbase.downloader.g.a aVar2) {
        boolean z;
        String optString = jSONObject.optString("type");
        aVar.a = optString;
        Intent b2 = com.ss.android.socialbase.appdownloader.a.d.a(context, "vbi", jSONObject, downloadInfo).b();
        StringBuilder sb = new StringBuilder();
        try {
            z = b(context, b2);
        } catch (Throwable th) {
            sb.append(optString);
            sb.append(" startActivity failed : ");
            sb.append(a(th));
            a(aVar, 1);
            z = false;
        }
        if (!z) {
            aVar.f5418c = sb.toString();
        } else {
            aVar.b = 0;
        }
        return true;
    }

    private static boolean a(Context context, DownloadInfo downloadInfo, JSONObject jSONObject, com.ss.android.socialbase.appdownloader.a aVar) {
        boolean z;
        if (context != null && jSONObject != null) {
            String optString = jSONObject.optString("device_plans");
            aVar.f5420e = optString;
            if (!TextUtils.isEmpty(optString)) {
                String[] split = optString.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                String savePath = downloadInfo.getSavePath();
                if (TextUtils.isEmpty(savePath)) {
                    return false;
                }
                File file = new File(savePath);
                StringBuilder sb = new StringBuilder();
                String str = null;
                int length = split.length;
                int i2 = 0;
                while (true) {
                    z = true;
                    if (i2 >= length) {
                        z = false;
                        break;
                    }
                    String str2 = split[i2];
                    com.ss.android.socialbase.appdownloader.a.a a2 = com.ss.android.socialbase.appdownloader.a.d.a(context, str2, jSONObject, downloadInfo);
                    if (a2 != null) {
                        Intent b2 = a2.b();
                        if (b2 != null) {
                            if (a(file, downloadInfo, jSONObject)) {
                                try {
                                    a(context, b2, false);
                                    str = str2;
                                    break;
                                } catch (Throwable th) {
                                    sb.append(str2);
                                    sb.append(" startActivity failed : ");
                                    sb.append(a(th));
                                    a(aVar, 1);
                                }
                            } else {
                                a(aVar, 6);
                                sb.append(str2);
                                sb.append(" createDescFile failed! ");
                            }
                        } else {
                            a(aVar, 3);
                            sb.append(str2);
                            sb.append(" resolveActivity failed! ");
                        }
                    }
                    sb.append("  ");
                    i2++;
                }
                if (!z) {
                    aVar.f5418c = sb.toString();
                } else {
                    aVar.f5419d = str;
                    aVar.b = 0;
                }
                return z;
            }
        }
        return false;
    }

    public static int a(@NonNull com.ss.android.socialbase.downloader.g.a aVar) {
        JSONObject d2 = aVar.d("download_dir");
        if (d2 != null ? !TextUtils.isEmpty(d2.optString("dir_name")) : false) {
            if (com.ss.android.socialbase.downloader.g.a.c().a("get_download_info_by_list")) {
                JSONArray e2 = aVar.e("ah_plans");
                int i2 = -1;
                if (e2 != null) {
                    int length = e2.length();
                    for (int i3 = 0; i3 < length; i3++) {
                        JSONObject optJSONObject = e2.optJSONObject(i3);
                        if (com.ss.android.socialbase.appdownloader.f.a.a(optJSONObject)) {
                            String optString = optJSONObject.optString("type");
                            if (!"plan_a".equals(optString) && !"plan_b".equals(optString) && !"plan_e".equals(optString) && !"plan_f".equals(optString)) {
                                if ("plan_d".equalsIgnoreCase(optString) || "plan_h".equalsIgnoreCase(optString) || ("plan_g".equalsIgnoreCase(optString) && (i2 = b(optJSONObject, aVar).b) == 0)) {
                                    return 0;
                                }
                            } else {
                                i2 = a(optJSONObject, aVar).b;
                                if (i2 == 0) {
                                    return 0;
                                }
                            }
                        }
                    }
                }
                return i2;
            }
            return 4;
        }
        return 5;
    }

    @NonNull
    public static com.ss.android.socialbase.appdownloader.a a(JSONObject jSONObject, com.ss.android.socialbase.downloader.g.a aVar) {
        com.ss.android.socialbase.appdownloader.a aVar2 = new com.ss.android.socialbase.appdownloader.a();
        if (jSONObject == null) {
            return aVar2;
        }
        String optString = jSONObject.optString("type");
        aVar2.a = optString;
        if ("plan_b".equals(optString)) {
            aVar2.f5420e = XGPushNotificationBuilder.CUSTOM_NOTIFICATION_BUILDER_TYPE;
            if (com.ss.android.socialbase.appdownloader.a.d.a(com.ss.android.socialbase.downloader.downloader.c.N(), XGPushNotificationBuilder.CUSTOM_NOTIFICATION_BUILDER_TYPE, jSONObject, aVar)) {
                aVar2.b = 0;
                return aVar2;
            }
            a(aVar2, 3);
        } else {
            String optString2 = jSONObject.optString("device_plans");
            aVar2.f5420e = optString2;
            if (!TextUtils.isEmpty(optString2)) {
                for (String str : optString2.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
                    if (com.ss.android.socialbase.appdownloader.a.d.a(com.ss.android.socialbase.downloader.downloader.c.N(), str, jSONObject, aVar)) {
                        aVar2.b = 0;
                        return aVar2;
                    }
                    a(aVar2, 3);
                }
            }
        }
        return aVar2;
    }

    public static com.ss.android.socialbase.appdownloader.a a(JSONObject jSONObject, String str, Context context, com.ss.android.socialbase.downloader.g.a aVar) {
        com.ss.android.socialbase.appdownloader.a aVar2 = new com.ss.android.socialbase.appdownloader.a();
        if (jSONObject != null && com.ss.android.socialbase.appdownloader.f.d.b()) {
            aVar2.a = jSONObject.optString("type");
            if (aVar.a(NotificationStyle.BANNER_IMAGE_URL, 0) == 1) {
                aVar2.b = 0;
                return aVar2;
            } else if (a(context)) {
                aVar2.b = 2;
            } else if (com.ss.android.socialbase.appdownloader.f.a.a(str) != null) {
                aVar2.b = 0;
            } else {
                aVar2.b = 9;
            }
        }
        return aVar2;
    }

    private static void a(com.ss.android.socialbase.appdownloader.a aVar, int i2) {
        int i3 = aVar.b;
        if (i3 != -1) {
            aVar.b = (i3 * 10) + i2;
        } else {
            aVar.b = i2;
        }
    }

    private static boolean a(File file, DownloadInfo downloadInfo, @NonNull JSONObject jSONObject) {
        if (file == null) {
            return false;
        }
        String path = file.getPath();
        JSONObject d2 = com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId()).d("download_dir");
        File file2 = null;
        String optString = d2 != null ? d2.optString("ins_desc") : null;
        if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString)) {
            file2 = new File(path + File.separator + optString);
        }
        if (file2 != null) {
            try {
                if (file2.createNewFile()) {
                    file2.deleteOnExit();
                    return true;
                }
                return true;
            } catch (IOException unused) {
                return false;
            }
        }
        return true;
    }

    public static boolean a(Context context, @Nullable Intent intent, JSONObject jSONObject, int i2, @Nullable com.ss.android.socialbase.appdownloader.a aVar) {
        if (context != null && jSONObject != null) {
            long optLong = jSONObject.optLong("jump_interval", 0L);
            if (optLong <= 0) {
                return false;
            }
            SharedPreferences sharedPreferences = context.getSharedPreferences("sp_ah_config", 0);
            if ((System.currentTimeMillis() - sharedPreferences.getLong("last_jump_unknown_source_time", 0L)) / com.heytap.mcssdk.constant.a.f3314d >= optLong && !a(context)) {
                sharedPreferences.edit().putLong("last_jump_unknown_source_time", System.currentTimeMillis()).apply();
                if (jSONObject.optInt("show_unknown_source_dialog", 0) == 1) {
                    Intent intent2 = new Intent(context, JumpUnknownSourceActivity.class);
                    intent2.addFlags(268435456);
                    intent2.putExtra(CommonCode.Resolution.HAS_RESOLUTION_FROM_APK, intent);
                    intent2.putExtra("config", jSONObject.toString());
                    intent2.putExtra("id", i2);
                    try {
                        if (a(context, intent2, false)) {
                            d(i2, jSONObject);
                        }
                        return true;
                    } catch (Throwable th) {
                        if (aVar != null) {
                            aVar.b = 1;
                            aVar.f5418c = "tryShowUnknownSourceDialog" + a(th);
                        }
                        return false;
                    }
                }
                if (a(context, intent, i2, jSONObject)) {
                    c(i2, jSONObject);
                }
                return true;
            }
        }
        return false;
    }

    public static boolean a(Context context, @Nullable Intent intent, int i2, JSONObject jSONObject) {
        int i3 = Build.VERSION.SDK_INT;
        try {
            if (com.ss.android.socialbase.appdownloader.f.d.b() && i3 < 26 && !d(context)) {
                com.ss.android.socialbase.appdownloader.a.f fVar = new com.ss.android.socialbase.appdownloader.a.f(context);
                if (fVar.a()) {
                    a(context, intent, i2, jSONObject, new InterfaceC0185b() { // from class: com.ss.android.socialbase.appdownloader.b.1
                        @Override // com.ss.android.socialbase.appdownloader.b.InterfaceC0185b
                        public boolean a(@NonNull Context context2) {
                            return b.d(context2);
                        }
                    });
                    return b(context, fVar.b());
                }
            } else if (i3 >= 26 && context.getApplicationInfo().targetSdkVersion >= 26 && !e(context)) {
                com.ss.android.socialbase.appdownloader.a.b bVar = new com.ss.android.socialbase.appdownloader.a.b(context);
                if (bVar.a()) {
                    a(context, intent, i2, jSONObject, new InterfaceC0185b() { // from class: com.ss.android.socialbase.appdownloader.b.2
                        @Override // com.ss.android.socialbase.appdownloader.b.InterfaceC0185b
                        public boolean a(@NonNull Context context2) {
                            return b.e(context2);
                        }
                    });
                    return b(context, bVar.b());
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static boolean a(Context context) {
        int i2 = Build.VERSION.SDK_INT;
        if (context == null) {
            return true;
        }
        if (com.ss.android.socialbase.appdownloader.f.d.b() && i2 < 26) {
            return d(context);
        }
        if (i2 >= 26 && context.getApplicationInfo().targetSdkVersion >= 26) {
            return e(context);
        }
        return true;
    }

    public static boolean a() {
        return e.a == 1;
    }

    public static void a(int i2, JSONObject jSONObject) {
        int i3 = 1;
        boolean z = jSONObject.optInt("show_unknown_source_on_startup") == 1;
        JSONObject jSONObject2 = new JSONObject();
        if (!z) {
            i3 = 2;
        }
        try {
            jSONObject2.put("scene", i3);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        com.ss.android.socialbase.downloader.downloader.c.P().b(i2, "guide_auth_dialog_confirm", jSONObject2);
    }

    private static void a(Context context, Intent intent, int i2, JSONObject jSONObject, InterfaceC0185b interfaceC0185b) {
        if (f5425c != null) {
            com.ss.android.socialbase.downloader.a.a.a().b(f5425c);
            f5425c = null;
        }
        f5425c = new a(context, intent, i2, jSONObject, interfaceC0185b);
        com.ss.android.socialbase.downloader.a.a.a().a(f5425c);
    }

    public static boolean a(Context context, Intent intent, boolean z) {
        if (context == null || intent == null) {
            return false;
        }
        if (z) {
            try {
                intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
                context.startActivity(intent);
                return true;
            } catch (Throwable unused) {
                return false;
            }
        }
        intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
        context.startActivity(intent);
        return true;
    }

    public static String a(Throwable th) {
        String th2 = th.toString();
        return th2.length() > 800 ? th2.substring(0, 500) : th2;
    }

    public static void a(c cVar) {
        b = cVar;
    }
}
