package cn.thinkingdata.android;

import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import cn.thinkingdata.android.ThinkingAnalyticsSDK;
import cn.thinkingdata.android.utils.TDLog;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class TDWebAppInterface {
    private static final String TAG = "ThinkingAnalytics.TDWebAppInterface";
    private final ThinkingAnalyticsSDK defaultInstance;

    /* loaded from: classes.dex */
    public class a implements ThinkingAnalyticsSDK.b {
        public final /* synthetic */ String a;
        public final /* synthetic */ b b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f1347c;

        public a(TDWebAppInterface tDWebAppInterface, String str, b bVar, String str2) {
            this.a = str;
            this.b = bVar;
            this.f1347c = str2;
        }

        @Override // cn.thinkingdata.android.ThinkingAnalyticsSDK.b
        public void a(ThinkingAnalyticsSDK thinkingAnalyticsSDK) {
            if (thinkingAnalyticsSDK.getToken().equals(this.a)) {
                this.b.b();
                thinkingAnalyticsSDK.trackFromH5(this.f1347c);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b {
        private boolean a;

        private b(TDWebAppInterface tDWebAppInterface) {
        }

        public /* synthetic */ b(TDWebAppInterface tDWebAppInterface, a aVar) {
            this(tDWebAppInterface);
        }

        public boolean a() {
            return !this.a;
        }

        public void b() {
            this.a = true;
        }
    }

    public TDWebAppInterface(ThinkingAnalyticsSDK thinkingAnalyticsSDK) {
        this.defaultInstance = thinkingAnalyticsSDK;
    }

    @JavascriptInterface
    public void thinkingdata_track(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        TDLog.d(TAG, str);
        try {
            String string = new JSONObject(str).getString("#app_id");
            b bVar = new b(this, null);
            ThinkingAnalyticsSDK.allInstances(new a(this, string, bVar, str));
            if (bVar.a()) {
                this.defaultInstance.trackFromH5(str);
            }
        } catch (JSONException e2) {
            TDLog.w(TAG, "Unexpected exception occurred: " + e2.toString());
        }
    }
}
