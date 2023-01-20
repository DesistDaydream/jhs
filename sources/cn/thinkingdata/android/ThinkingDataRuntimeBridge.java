package cn.thinkingdata.android;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TabHost;
import android.widget.TextView;
import cn.thinkingdata.android.ThinkingAnalyticsSDK;
import cn.thinkingdata.android.utils.TDLog;
import d.a.a.o.n;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class ThinkingDataRuntimeBridge {
    private static final String TAG = "ThinkingAnalytics.ThinkingDataRuntimeBridge";

    /* loaded from: classes.dex */
    public static class a implements ThinkingAnalyticsSDK.b {
        public final /* synthetic */ Object a;

        public a(Object obj) {
            this.a = obj;
        }

        /* JADX WARN: Code restructure failed: missing block: B:27:0x0087, code lost:
            if (cn.thinkingdata.android.TDPresetProperties.disableList.contains("#title") == false) goto L26;
         */
        /* JADX WARN: Removed duplicated region for block: B:31:0x0090 A[Catch: JSONException -> 0x0117, TRY_ENTER, TryCatch #0 {JSONException -> 0x0117, blocks: (B:17:0x005a, B:20:0x006c, B:28:0x0089, B:31:0x0090, B:33:0x0098, B:35:0x009d, B:39:0x00bf, B:41:0x00c5, B:43:0x00d1, B:54:0x010d, B:44:0x00db, B:46:0x00e9, B:48:0x00f3, B:50:0x0101, B:55:0x0111, B:36:0x00b4, B:38:0x00bc, B:24:0x0077, B:26:0x0081), top: B:60:0x005a }] */
        /* JADX WARN: Removed duplicated region for block: B:36:0x00b4 A[Catch: JSONException -> 0x0117, TryCatch #0 {JSONException -> 0x0117, blocks: (B:17:0x005a, B:20:0x006c, B:28:0x0089, B:31:0x0090, B:33:0x0098, B:35:0x009d, B:39:0x00bf, B:41:0x00c5, B:43:0x00d1, B:54:0x010d, B:44:0x00db, B:46:0x00e9, B:48:0x00f3, B:50:0x0101, B:55:0x0111, B:36:0x00b4, B:38:0x00bc, B:24:0x0077, B:26:0x0081), top: B:60:0x005a }] */
        /* JADX WARN: Removed duplicated region for block: B:41:0x00c5 A[Catch: JSONException -> 0x0117, TryCatch #0 {JSONException -> 0x0117, blocks: (B:17:0x005a, B:20:0x006c, B:28:0x0089, B:31:0x0090, B:33:0x0098, B:35:0x009d, B:39:0x00bf, B:41:0x00c5, B:43:0x00d1, B:54:0x010d, B:44:0x00db, B:46:0x00e9, B:48:0x00f3, B:50:0x0101, B:55:0x0111, B:36:0x00b4, B:38:0x00bc, B:24:0x0077, B:26:0x0081), top: B:60:0x005a }] */
        /* JADX WARN: Removed duplicated region for block: B:44:0x00db A[Catch: JSONException -> 0x0117, TryCatch #0 {JSONException -> 0x0117, blocks: (B:17:0x005a, B:20:0x006c, B:28:0x0089, B:31:0x0090, B:33:0x0098, B:35:0x009d, B:39:0x00bf, B:41:0x00c5, B:43:0x00d1, B:54:0x010d, B:44:0x00db, B:46:0x00e9, B:48:0x00f3, B:50:0x0101, B:55:0x0111, B:36:0x00b4, B:38:0x00bc, B:24:0x0077, B:26:0x0081), top: B:60:0x005a }] */
        @Override // cn.thinkingdata.android.ThinkingAnalyticsSDK.b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void a(cn.thinkingdata.android.ThinkingAnalyticsSDK r9) {
            /*
                Method dump skipped, instructions count: 287
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.thinkingdata.android.ThinkingDataRuntimeBridge.a.a(cn.thinkingdata.android.ThinkingAnalyticsSDK):void");
        }
    }

    /* loaded from: classes.dex */
    public static class b implements ThinkingAnalyticsSDK.b {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ JSONObject f1348c;

        public b(String str, String str2, JSONObject jSONObject) {
            this.a = str;
            this.b = str2;
            this.f1348c = jSONObject;
        }

        @Override // cn.thinkingdata.android.ThinkingAnalyticsSDK.b
        public void a(ThinkingAnalyticsSDK thinkingAnalyticsSDK) {
            if (thinkingAnalyticsSDK.isAutoTrackEnabled()) {
                if (TextUtils.isEmpty(this.a) || thinkingAnalyticsSDK.getToken().equals(this.a)) {
                    thinkingAnalyticsSDK.track(this.b, this.f1348c);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class c implements ThinkingAnalyticsSDK.b {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ JSONObject f1349c;

        public c(String str, String str2, JSONObject jSONObject) {
            this.a = str;
            this.b = str2;
            this.f1349c = jSONObject;
        }

        @Override // cn.thinkingdata.android.ThinkingAnalyticsSDK.b
        public void a(ThinkingAnalyticsSDK thinkingAnalyticsSDK) {
            if (thinkingAnalyticsSDK.isAutoTrackEnabled()) {
                if (TextUtils.isEmpty(this.a) || thinkingAnalyticsSDK.getToken().equals(this.a)) {
                    thinkingAnalyticsSDK.track(this.b, this.f1349c);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class d implements ThinkingAnalyticsSDK.b {
        public final /* synthetic */ Object a;
        public final /* synthetic */ View b;

        public d(Object obj, View view) {
            this.a = obj;
            this.b = view;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:228:0x0415 A[Catch: Exception -> 0x0453, TryCatch #8 {Exception -> 0x0453, blocks: (B:3:0x0016, B:6:0x001d, B:9:0x0026, B:11:0x002a, B:13:0x002e, B:15:0x003a, B:18:0x0049, B:20:0x004d, B:22:0x0059, B:25:0x0068, B:27:0x006c, B:29:0x0074, B:31:0x007b, B:33:0x0087, B:35:0x008d, B:38:0x0098, B:40:0x00a0, B:42:0x00a6, B:45:0x00b1, B:53:0x00df, B:55:0x00fa, B:58:0x0105, B:61:0x010e, B:63:0x0128, B:65:0x0130, B:67:0x0135, B:69:0x013d, B:71:0x0152, B:73:0x0158, B:85:0x0174, B:88:0x0186, B:226:0x040f, B:228:0x0415, B:230:0x041d, B:231:0x0424, B:233:0x042c, B:234:0x042f, B:236:0x0444, B:237:0x044d, B:93:0x0195, B:95:0x019b, B:97:0x01a5, B:99:0x01ad, B:103:0x01c2, B:100:0x01b4, B:102:0x01bc, B:107:0x01d4, B:128:0x024f, B:129:0x0254, B:131:0x025a, B:133:0x0262, B:135:0x026b, B:137:0x0271, B:134:0x0267, B:139:0x027a, B:142:0x0280, B:152:0x02a7, B:154:0x02ab, B:156:0x02b5, B:159:0x02bb, B:161:0x02c3, B:162:0x02c8, B:164:0x02d0, B:166:0x02d4, B:168:0x02de, B:170:0x02e2, B:172:0x02ec, B:174:0x02f0, B:176:0x02fa, B:179:0x0300, B:181:0x030c, B:188:0x0327, B:182:0x0311, B:185:0x0317, B:187:0x0323, B:189:0x032d, B:191:0x0331, B:193:0x033f, B:195:0x0343, B:197:0x0351, B:209:0x0391, B:211:0x0395, B:217:0x03e0, B:213:0x03b8, B:215:0x03bc, B:218:0x03e6, B:207:0x038b, B:52:0x00dc, B:47:0x00c9, B:49:0x00d5, B:199:0x0355, B:201:0x0368, B:202:0x0376, B:204:0x037e), top: B:260:0x0016, inners: #3, #4 }] */
        /* JADX WARN: Removed duplicated region for block: B:233:0x042c A[Catch: Exception -> 0x0453, TryCatch #8 {Exception -> 0x0453, blocks: (B:3:0x0016, B:6:0x001d, B:9:0x0026, B:11:0x002a, B:13:0x002e, B:15:0x003a, B:18:0x0049, B:20:0x004d, B:22:0x0059, B:25:0x0068, B:27:0x006c, B:29:0x0074, B:31:0x007b, B:33:0x0087, B:35:0x008d, B:38:0x0098, B:40:0x00a0, B:42:0x00a6, B:45:0x00b1, B:53:0x00df, B:55:0x00fa, B:58:0x0105, B:61:0x010e, B:63:0x0128, B:65:0x0130, B:67:0x0135, B:69:0x013d, B:71:0x0152, B:73:0x0158, B:85:0x0174, B:88:0x0186, B:226:0x040f, B:228:0x0415, B:230:0x041d, B:231:0x0424, B:233:0x042c, B:234:0x042f, B:236:0x0444, B:237:0x044d, B:93:0x0195, B:95:0x019b, B:97:0x01a5, B:99:0x01ad, B:103:0x01c2, B:100:0x01b4, B:102:0x01bc, B:107:0x01d4, B:128:0x024f, B:129:0x0254, B:131:0x025a, B:133:0x0262, B:135:0x026b, B:137:0x0271, B:134:0x0267, B:139:0x027a, B:142:0x0280, B:152:0x02a7, B:154:0x02ab, B:156:0x02b5, B:159:0x02bb, B:161:0x02c3, B:162:0x02c8, B:164:0x02d0, B:166:0x02d4, B:168:0x02de, B:170:0x02e2, B:172:0x02ec, B:174:0x02f0, B:176:0x02fa, B:179:0x0300, B:181:0x030c, B:188:0x0327, B:182:0x0311, B:185:0x0317, B:187:0x0323, B:189:0x032d, B:191:0x0331, B:193:0x033f, B:195:0x0343, B:197:0x0351, B:209:0x0391, B:211:0x0395, B:217:0x03e0, B:213:0x03b8, B:215:0x03bc, B:218:0x03e6, B:207:0x038b, B:52:0x00dc, B:47:0x00c9, B:49:0x00d5, B:199:0x0355, B:201:0x0368, B:202:0x0376, B:204:0x037e), top: B:260:0x0016, inners: #3, #4 }] */
        /* JADX WARN: Removed duplicated region for block: B:236:0x0444 A[Catch: Exception -> 0x0453, TryCatch #8 {Exception -> 0x0453, blocks: (B:3:0x0016, B:6:0x001d, B:9:0x0026, B:11:0x002a, B:13:0x002e, B:15:0x003a, B:18:0x0049, B:20:0x004d, B:22:0x0059, B:25:0x0068, B:27:0x006c, B:29:0x0074, B:31:0x007b, B:33:0x0087, B:35:0x008d, B:38:0x0098, B:40:0x00a0, B:42:0x00a6, B:45:0x00b1, B:53:0x00df, B:55:0x00fa, B:58:0x0105, B:61:0x010e, B:63:0x0128, B:65:0x0130, B:67:0x0135, B:69:0x013d, B:71:0x0152, B:73:0x0158, B:85:0x0174, B:88:0x0186, B:226:0x040f, B:228:0x0415, B:230:0x041d, B:231:0x0424, B:233:0x042c, B:234:0x042f, B:236:0x0444, B:237:0x044d, B:93:0x0195, B:95:0x019b, B:97:0x01a5, B:99:0x01ad, B:103:0x01c2, B:100:0x01b4, B:102:0x01bc, B:107:0x01d4, B:128:0x024f, B:129:0x0254, B:131:0x025a, B:133:0x0262, B:135:0x026b, B:137:0x0271, B:134:0x0267, B:139:0x027a, B:142:0x0280, B:152:0x02a7, B:154:0x02ab, B:156:0x02b5, B:159:0x02bb, B:161:0x02c3, B:162:0x02c8, B:164:0x02d0, B:166:0x02d4, B:168:0x02de, B:170:0x02e2, B:172:0x02ec, B:174:0x02f0, B:176:0x02fa, B:179:0x0300, B:181:0x030c, B:188:0x0327, B:182:0x0311, B:185:0x0317, B:187:0x0323, B:189:0x032d, B:191:0x0331, B:193:0x033f, B:195:0x0343, B:197:0x0351, B:209:0x0391, B:211:0x0395, B:217:0x03e0, B:213:0x03b8, B:215:0x03bc, B:218:0x03e6, B:207:0x038b, B:52:0x00dc, B:47:0x00c9, B:49:0x00d5, B:199:0x0355, B:201:0x0368, B:202:0x0376, B:204:0x037e), top: B:260:0x0016, inners: #3, #4 }] */
        /* JADX WARN: Type inference failed for: r0v64 */
        /* JADX WARN: Type inference failed for: r0v75 */
        /* JADX WARN: Type inference failed for: r19v0, types: [cn.thinkingdata.android.ThinkingAnalyticsSDK] */
        @Override // cn.thinkingdata.android.ThinkingAnalyticsSDK.b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void a(cn.thinkingdata.android.ThinkingAnalyticsSDK r19) {
            /*
                Method dump skipped, instructions count: 1136
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.thinkingdata.android.ThinkingDataRuntimeBridge.d.a(cn.thinkingdata.android.ThinkingAnalyticsSDK):void");
        }
    }

    /* loaded from: classes.dex */
    public static class e implements ThinkingAnalyticsSDK.b {
        public final /* synthetic */ Context a;
        public final /* synthetic */ View b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ View f1350c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f1351d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f1352e;

        public e(Context context, View view, View view2, int i2, int i3) {
            this.a = context;
            this.b = view;
            this.f1350c = view2;
            this.f1351d = i2;
            this.f1352e = i3;
        }

        /* JADX WARN: Removed duplicated region for block: B:53:0x00e2 A[Catch: Exception -> 0x0188, TryCatch #1 {Exception -> 0x0188, blocks: (B:3:0x000a, B:6:0x0011, B:9:0x001a, B:11:0x0022, B:14:0x002d, B:17:0x0036, B:20:0x003f, B:23:0x0048, B:25:0x0054, B:27:0x005c, B:29:0x0071, B:31:0x0077, B:32:0x007a, B:34:0x0086, B:36:0x008e, B:37:0x0091, B:40:0x0099, B:42:0x00a1, B:44:0x00a5, B:50:0x00d7, B:51:0x00da, B:53:0x00e2, B:54:0x00e7, B:65:0x011c, B:67:0x0122, B:69:0x012a, B:70:0x012d, B:72:0x0142, B:73:0x014b, B:75:0x0155, B:77:0x0159, B:79:0x015f, B:82:0x016e, B:84:0x0174, B:80:0x0166, B:87:0x017f, B:88:0x0182, B:62:0x0110, B:64:0x0114, B:61:0x010c, B:45:0x00b4, B:47:0x00bc, B:49:0x00c1, B:56:0x00ee, B:58:0x0101), top: B:95:0x000a, inners: #0, #2 }] */
        /* JADX WARN: Removed duplicated region for block: B:62:0x0110 A[Catch: Exception -> 0x0188, TryCatch #1 {Exception -> 0x0188, blocks: (B:3:0x000a, B:6:0x0011, B:9:0x001a, B:11:0x0022, B:14:0x002d, B:17:0x0036, B:20:0x003f, B:23:0x0048, B:25:0x0054, B:27:0x005c, B:29:0x0071, B:31:0x0077, B:32:0x007a, B:34:0x0086, B:36:0x008e, B:37:0x0091, B:40:0x0099, B:42:0x00a1, B:44:0x00a5, B:50:0x00d7, B:51:0x00da, B:53:0x00e2, B:54:0x00e7, B:65:0x011c, B:67:0x0122, B:69:0x012a, B:70:0x012d, B:72:0x0142, B:73:0x014b, B:75:0x0155, B:77:0x0159, B:79:0x015f, B:82:0x016e, B:84:0x0174, B:80:0x0166, B:87:0x017f, B:88:0x0182, B:62:0x0110, B:64:0x0114, B:61:0x010c, B:45:0x00b4, B:47:0x00bc, B:49:0x00c1, B:56:0x00ee, B:58:0x0101), top: B:95:0x000a, inners: #0, #2 }] */
        /* JADX WARN: Removed duplicated region for block: B:72:0x0142 A[Catch: Exception -> 0x0188, TryCatch #1 {Exception -> 0x0188, blocks: (B:3:0x000a, B:6:0x0011, B:9:0x001a, B:11:0x0022, B:14:0x002d, B:17:0x0036, B:20:0x003f, B:23:0x0048, B:25:0x0054, B:27:0x005c, B:29:0x0071, B:31:0x0077, B:32:0x007a, B:34:0x0086, B:36:0x008e, B:37:0x0091, B:40:0x0099, B:42:0x00a1, B:44:0x00a5, B:50:0x00d7, B:51:0x00da, B:53:0x00e2, B:54:0x00e7, B:65:0x011c, B:67:0x0122, B:69:0x012a, B:70:0x012d, B:72:0x0142, B:73:0x014b, B:75:0x0155, B:77:0x0159, B:79:0x015f, B:82:0x016e, B:84:0x0174, B:80:0x0166, B:87:0x017f, B:88:0x0182, B:62:0x0110, B:64:0x0114, B:61:0x010c, B:45:0x00b4, B:47:0x00bc, B:49:0x00c1, B:56:0x00ee, B:58:0x0101), top: B:95:0x000a, inners: #0, #2 }] */
        /* JADX WARN: Removed duplicated region for block: B:79:0x015f A[Catch: JSONException -> 0x017e, Exception -> 0x0188, TryCatch #2 {JSONException -> 0x017e, blocks: (B:77:0x0159, B:79:0x015f, B:82:0x016e, B:84:0x0174, B:80:0x0166), top: B:97:0x0159, outer: #1 }] */
        /* JADX WARN: Removed duplicated region for block: B:80:0x0166 A[Catch: JSONException -> 0x017e, Exception -> 0x0188, TryCatch #2 {JSONException -> 0x017e, blocks: (B:77:0x0159, B:79:0x015f, B:82:0x016e, B:84:0x0174, B:80:0x0166), top: B:97:0x0159, outer: #1 }] */
        /* JADX WARN: Removed duplicated region for block: B:93:0x00ee A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // cn.thinkingdata.android.ThinkingAnalyticsSDK.b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void a(cn.thinkingdata.android.ThinkingAnalyticsSDK r11) {
            /*
                Method dump skipped, instructions count: 423
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.thinkingdata.android.ThinkingDataRuntimeBridge.e.a(cn.thinkingdata.android.ThinkingAnalyticsSDK):void");
        }
    }

    /* loaded from: classes.dex */
    public static class f implements ThinkingAnalyticsSDK.b {
        public final /* synthetic */ Dialog a;
        public final /* synthetic */ int b;

        public f(Dialog dialog, int i2) {
            this.a = dialog;
            this.b = i2;
        }

        /* JADX WARN: Code restructure failed: missing block: B:55:0x00e1, code lost:
            if (cn.thinkingdata.android.TDPresetProperties.disableList.contains("#element_content") == false) goto L54;
         */
        /* JADX WARN: Code restructure failed: missing block: B:64:0x0104, code lost:
            if (cn.thinkingdata.android.TDPresetProperties.disableList.contains("#element_content") == false) goto L55;
         */
        /* JADX WARN: Code restructure failed: missing block: B:79:0x014e, code lost:
            if (cn.thinkingdata.android.TDPresetProperties.disableList.contains("#element_content") == false) goto L54;
         */
        @Override // cn.thinkingdata.android.ThinkingAnalyticsSDK.b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void a(cn.thinkingdata.android.ThinkingAnalyticsSDK r10) {
            /*
                Method dump skipped, instructions count: 427
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.thinkingdata.android.ThinkingDataRuntimeBridge.f.a(cn.thinkingdata.android.ThinkingAnalyticsSDK):void");
        }
    }

    /* loaded from: classes.dex */
    public static class g implements ThinkingAnalyticsSDK.b {
        public final /* synthetic */ View a;
        public final /* synthetic */ View b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f1353c;

        public g(View view, View view2, int i2) {
            this.a = view;
            this.b = view2;
            this.f1353c = i2;
        }

        @Override // cn.thinkingdata.android.ThinkingAnalyticsSDK.b
        public void a(ThinkingAnalyticsSDK thinkingAnalyticsSDK) {
            Context context;
            try {
                if (!thinkingAnalyticsSDK.isAutoTrackEnabled() || thinkingAnalyticsSDK.isAutoTrackEventTypeIgnored(ThinkingAnalyticsSDK.AutoTrackEventType.APP_CLICK) || (context = this.a.getContext()) == null) {
                    return;
                }
                Activity f2 = n.f(context);
                if ((f2 == null || !thinkingAnalyticsSDK.isActivityAutoTrackAppClickIgnored(f2.getClass())) && !ThinkingDataRuntimeBridge.isViewIgnored(thinkingAnalyticsSDK, this.b.getClass())) {
                    JSONObject jSONObject = new JSONObject();
                    if (thinkingAnalyticsSDK.getIgnoredViewTypeList() != null) {
                        if ((this.b instanceof ListView) && !TDPresetProperties.disableList.contains("#element_type")) {
                            jSONObject.put("#element_type", "ListView");
                            if (ThinkingDataRuntimeBridge.isViewIgnored(thinkingAnalyticsSDK, ListView.class)) {
                                return;
                            }
                        } else if ((this.b instanceof GridView) && !TDPresetProperties.disableList.contains("#element_type")) {
                            jSONObject.put("#element_type", "GridView");
                            if (ThinkingDataRuntimeBridge.isViewIgnored(thinkingAnalyticsSDK, GridView.class)) {
                                return;
                            }
                        } else if ((this.b instanceof Spinner) && !TDPresetProperties.disableList.contains("#element_type")) {
                            jSONObject.put("#element_type", "Spinner");
                            if (ThinkingDataRuntimeBridge.isViewIgnored(thinkingAnalyticsSDK, Spinner.class)) {
                                return;
                            }
                        }
                    }
                    Adapter adapter = ((AdapterView) this.b).getAdapter();
                    if (adapter instanceof ThinkingAdapterViewItemTrackProperties) {
                        try {
                            JSONObject thinkingItemTrackProperties = ((ThinkingAdapterViewItemTrackProperties) adapter).getThinkingItemTrackProperties(this.f1353c);
                            if (thinkingItemTrackProperties != null && cn.thinkingdata.android.utils.g.b(thinkingItemTrackProperties)) {
                                n.v(thinkingItemTrackProperties, jSONObject, thinkingAnalyticsSDK.mConfig.getDefaultTimeZone());
                            }
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                    }
                    n.r(f2, this.a, jSONObject);
                    String k2 = n.k(this.b, thinkingAnalyticsSDK.getToken());
                    if (!TextUtils.isEmpty(k2) && !TDPresetProperties.disableList.contains("#element_id")) {
                        jSONObject.put("#element_id", k2);
                    }
                    if (f2 != null) {
                        List<String> list = TDPresetProperties.disableList;
                        if (!list.contains("#screen_name")) {
                            jSONObject.put("#screen_name", f2.getClass().getCanonicalName());
                            String i2 = n.i(f2);
                            if (!TextUtils.isEmpty(i2) && !list.contains("#title")) {
                                jSONObject.put("#title", i2);
                            }
                        }
                    }
                    if (!TDPresetProperties.disableList.contains("#element_position")) {
                        jSONObject.put("#element_position", String.valueOf(this.f1353c));
                    }
                    String str = null;
                    View view = this.a;
                    if (view instanceof ViewGroup) {
                        try {
                            str = n.o(new StringBuilder(), (ViewGroup) this.a);
                            if (!TextUtils.isEmpty(str)) {
                                str = str.substring(0, str.length() - 1);
                            }
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                    } else if (view instanceof TextView) {
                        str = ((TextView) view).getText().toString();
                    }
                    if (!TextUtils.isEmpty(str) && !TDPresetProperties.disableList.contains("#element_content")) {
                        jSONObject.put("#element_content", str);
                    }
                    n.s(this.b, jSONObject);
                    JSONObject jSONObject2 = (JSONObject) n.g(thinkingAnalyticsSDK.getToken(), this.a, R.id.thinking_analytics_tag_view_properties);
                    if (jSONObject2 != null) {
                        n.v(jSONObject2, jSONObject, thinkingAnalyticsSDK.mConfig.getDefaultTimeZone());
                    }
                    thinkingAnalyticsSDK.autoTrack("ta_app_click", jSONObject);
                }
            } catch (Exception e4) {
                e4.printStackTrace();
                TDLog.i(ThinkingDataRuntimeBridge.TAG, " AdapterView.OnItemClickListener.onItemClick AOP ERROR: " + e4.getMessage());
            }
        }
    }

    /* loaded from: classes.dex */
    public static class h implements ThinkingAnalyticsSDK.b {
        public final /* synthetic */ Object a;
        public final /* synthetic */ MenuItem b;

        public h(Object obj, MenuItem menuItem) {
            this.a = obj;
            this.b = menuItem;
        }

        @Override // cn.thinkingdata.android.ThinkingAnalyticsSDK.b
        public void a(ThinkingAnalyticsSDK thinkingAnalyticsSDK) {
            Object obj;
            try {
                if (!thinkingAnalyticsSDK.isAutoTrackEnabled() || thinkingAnalyticsSDK.isAutoTrackEventTypeIgnored(ThinkingAnalyticsSDK.AutoTrackEventType.APP_CLICK) || ThinkingDataRuntimeBridge.isViewIgnored(thinkingAnalyticsSDK, MenuItem.class) || (obj = this.a) == null) {
                    return;
                }
                String str = null;
                Context context = obj instanceof Context ? (Context) obj : null;
                if (context == null) {
                    return;
                }
                Activity f2 = n.f(context);
                if (f2 == null || !thinkingAnalyticsSDK.isActivityAutoTrackAppClickIgnored(f2.getClass())) {
                    try {
                        str = context.getResources().getResourceEntryName(this.b.getItemId());
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    JSONObject jSONObject = new JSONObject();
                    if (f2 != null) {
                        List<String> list = TDPresetProperties.disableList;
                        if (!list.contains("#screen_name")) {
                            jSONObject.put("#screen_name", f2.getClass().getCanonicalName());
                            String i2 = n.i(f2);
                            if (!TextUtils.isEmpty(i2) && !list.contains("#title")) {
                                jSONObject.put("#title", i2);
                            }
                        }
                    }
                    if (!TextUtils.isEmpty(str) && !TDPresetProperties.disableList.contains("#element_id")) {
                        jSONObject.put("#element_id", str);
                    }
                    if (!TextUtils.isEmpty(this.b.getTitle()) && !TDPresetProperties.disableList.contains("#element_content")) {
                        jSONObject.put("#element_content", this.b.getTitle());
                    }
                    if (!TDPresetProperties.disableList.contains("#element_type")) {
                        jSONObject.put("#element_type", "MenuItem");
                    }
                    thinkingAnalyticsSDK.autoTrack("ta_app_click", jSONObject);
                }
            } catch (Exception e3) {
                e3.printStackTrace();
                TDLog.i(ThinkingDataRuntimeBridge.TAG, "track MenuItem click error: " + e3.getMessage());
            }
        }
    }

    /* loaded from: classes.dex */
    public static class i implements ThinkingAnalyticsSDK.b {
        public final /* synthetic */ String a;

        public i(String str) {
            this.a = str;
        }

        @Override // cn.thinkingdata.android.ThinkingAnalyticsSDK.b
        public void a(ThinkingAnalyticsSDK thinkingAnalyticsSDK) {
            try {
                if (!thinkingAnalyticsSDK.isAutoTrackEnabled() || thinkingAnalyticsSDK.isAutoTrackEventTypeIgnored(ThinkingAnalyticsSDK.AutoTrackEventType.APP_CLICK) || ThinkingDataRuntimeBridge.isViewIgnored(thinkingAnalyticsSDK, TabHost.class)) {
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                List<String> list = TDPresetProperties.disableList;
                if (!list.contains("#element_content")) {
                    jSONObject.put("#element_content", this.a);
                }
                if (!list.contains("#element_type")) {
                    jSONObject.put("#element_type", "TabHost");
                }
                thinkingAnalyticsSDK.autoTrack("ta_app_click", jSONObject);
            } catch (Exception e2) {
                e2.printStackTrace();
                TDLog.i(ThinkingDataRuntimeBridge.TAG, " onTabChanged AOP ERROR: " + e2.getMessage());
            }
        }
    }

    private static boolean fragmentGetUserVisibleHint(Object obj) {
        try {
            return ((Boolean) obj.getClass().getMethod("getUserVisibleHint", new Class[0]).invoke(obj, new Object[0])).booleanValue();
        } catch (Exception unused) {
            return false;
        }
    }

    private static boolean fragmentIsNotHidden(Object obj) {
        try {
            return !((Boolean) obj.getClass().getMethod("isHidden", new Class[0]).invoke(obj, new Object[0])).booleanValue();
        } catch (Exception unused) {
            return true;
        }
    }

    private static boolean fragmentIsResumed(Object obj) {
        try {
            return ((Boolean) obj.getClass().getMethod("isResumed", new Class[0]).invoke(obj, new Object[0])).booleanValue();
        } catch (Exception unused) {
            return false;
        }
    }

    private static boolean isNotFragment(Object obj) {
        Class<?> cls;
        Class<?> cls2 = null;
        try {
            cls = Class.forName("androidx.fragment.app.Fragment");
        } catch (Exception unused) {
            cls = null;
        }
        try {
            cls2 = Class.forName("androidx.fragment.app.Fragment");
        } catch (Exception unused2) {
        }
        if (cls == null && cls2 == null) {
            return true;
        }
        if (cls != null) {
            try {
                if (cls.isInstance(obj)) {
                    return false;
                }
            } catch (Exception unused3) {
            }
        }
        if (cls2 != null) {
            if (cls2.isInstance(obj)) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isViewIgnored(ThinkingAnalyticsSDK thinkingAnalyticsSDK, View view) {
        if (view == null) {
            return true;
        }
        try {
            List<Class> ignoredViewTypeList = thinkingAnalyticsSDK.getIgnoredViewTypeList();
            if (ignoredViewTypeList != null) {
                for (Class cls : ignoredViewTypeList) {
                    if (cls.isAssignableFrom(view.getClass())) {
                        return true;
                    }
                }
            }
            return "1".equals(n.g(thinkingAnalyticsSDK.getToken(), view, R.id.thinking_analytics_tag_view_ignored));
        } catch (Exception e2) {
            e2.printStackTrace();
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isViewIgnored(ThinkingAnalyticsSDK thinkingAnalyticsSDK, Class cls) {
        if (cls == null) {
            return true;
        }
        try {
            List<Class> ignoredViewTypeList = thinkingAnalyticsSDK.getIgnoredViewTypeList();
            if (ignoredViewTypeList != null) {
                for (Class cls2 : ignoredViewTypeList) {
                    if (cls2.isAssignableFrom(cls)) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        } catch (Exception unused) {
            return true;
        }
    }

    public static void onAdapterViewItemClick(View view, View view2, int i2) {
        if (view == null || view2 == null || !(view instanceof AdapterView)) {
            return;
        }
        ThinkingAnalyticsSDK.allInstances(new g(view2, view, i2));
    }

    public static void onDialogClick(Object obj, int i2) {
        if (obj instanceof Dialog) {
            ThinkingAnalyticsSDK.allInstances(new f((Dialog) obj, i2));
        }
    }

    public static void onExpandableListViewOnChildClick(View view, View view2, int i2, int i3) {
        Context context;
        if (view == null || (context = view.getContext()) == null) {
            return;
        }
        ThinkingAnalyticsSDK.allInstances(new e(context, view, view2, i3, i2));
    }

    public static void onExpandableListViewOnGroupClick(View view, View view2, int i2) {
        onExpandableListViewOnChildClick(view, view2, i2, -1);
    }

    public static void onFragmentCreateView(Object obj, View view) {
        try {
            if (isNotFragment(obj)) {
                return;
            }
            String name = obj.getClass().getName();
            view.setTag(R.id.thinking_analytics_tag_view_fragment_name, name);
            if (view instanceof ViewGroup) {
                traverseView(name, (ViewGroup) view);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void onFragmentHiddenChanged(Object obj, boolean z) {
        if (isNotFragment(obj)) {
            return;
        }
        Object obj2 = null;
        try {
            obj2 = obj.getClass().getMethod("getParentFragment", new Class[0]).invoke(obj, new Object[0]);
        } catch (Exception unused) {
        }
        if (z) {
            return;
        }
        if ((obj2 == null && fragmentIsResumed(obj) && fragmentIsNotHidden(obj)) || (fragmentIsResumed(obj) && fragmentIsNotHidden(obj) && fragmentGetUserVisibleHint(obj))) {
            trackFragmentViewScreen(obj);
        }
    }

    public static void onFragmentOnResume(Object obj) {
        if (isNotFragment(obj)) {
            return;
        }
        Object obj2 = null;
        try {
            obj2 = obj.getClass().getMethod("getParentFragment", new Class[0]).invoke(obj, new Object[0]);
        } catch (Exception unused) {
        }
        if (obj2 == null) {
            if (!fragmentIsNotHidden(obj) || !fragmentGetUserVisibleHint(obj)) {
                return;
            }
        } else if (!fragmentIsNotHidden(obj) || !fragmentGetUserVisibleHint(obj) || !fragmentIsNotHidden(obj2) || !fragmentGetUserVisibleHint(obj2)) {
            return;
        }
        trackFragmentViewScreen(obj);
    }

    public static void onFragmentSetUserVisibleHint(Object obj, boolean z) {
        if (isNotFragment(obj)) {
            return;
        }
        Object obj2 = null;
        try {
            obj2 = obj.getClass().getMethod("getParentFragment", new Class[0]).invoke(obj, new Object[0]);
        } catch (Exception unused) {
        }
        if (z) {
            if ((obj2 == null && fragmentIsResumed(obj) && fragmentIsNotHidden(obj)) || (fragmentIsResumed(obj) && fragmentIsNotHidden(obj) && fragmentGetUserVisibleHint(obj))) {
                trackFragmentViewScreen(obj);
            }
        }
    }

    public static void onMenuItemSelected(Object obj, MenuItem menuItem) {
        if (menuItem == null) {
            return;
        }
        ThinkingAnalyticsSDK.allInstances(new h(obj, menuItem));
    }

    public static void onTabHostChanged(String str) {
        ThinkingAnalyticsSDK.allInstances(new i(str));
    }

    public static void onViewOnClick(View view, Object obj) {
        if (view == null) {
            return;
        }
        ThinkingAnalyticsSDK.allInstances(new d(obj, view));
    }

    public static void trackEvent(Object obj) {
        if (obj instanceof ThinkingDataTrackEvent) {
            ThinkingDataTrackEvent thinkingDataTrackEvent = (ThinkingDataTrackEvent) obj;
            String eventName = thinkingDataTrackEvent.eventName();
            String properties = thinkingDataTrackEvent.properties();
            String appId = thinkingDataTrackEvent.appId();
            if (TextUtils.isEmpty(eventName)) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            if (!TextUtils.isEmpty(properties)) {
                try {
                    n.v(new JSONObject(properties), jSONObject, null);
                } catch (JSONException e2) {
                    TDLog.e(TAG, "Exception occurred in trackEvent");
                    e2.printStackTrace();
                }
            }
            ThinkingAnalyticsSDK.allInstances(new b(appId, eventName, jSONObject));
        }
    }

    public static void trackEvent(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        if (!TextUtils.isEmpty(str2)) {
            try {
                n.v(new JSONObject(str2), jSONObject, null);
            } catch (JSONException e2) {
                TDLog.e(TAG, "Exception occurred in trackEvent");
                e2.printStackTrace();
            }
        }
        ThinkingAnalyticsSDK.allInstances(new c(str3, str, jSONObject));
    }

    private static void trackFragmentViewScreen(Object obj) {
        ThinkingAnalyticsSDK.allInstances(new a(obj));
    }

    private static void traverseView(String str, ViewGroup viewGroup) {
        try {
            if (TextUtils.isEmpty(str) || viewGroup == null) {
                return;
            }
            int childCount = viewGroup.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = viewGroup.getChildAt(i2);
                childAt.setTag(R.id.thinking_analytics_tag_view_fragment_name, str);
                if (childAt instanceof ViewGroup) {
                    traverseView(str, (ViewGroup) childAt);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
