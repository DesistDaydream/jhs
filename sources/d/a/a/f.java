package d.a.a;

import android.app.Activity;
import android.app.Dialog;
import android.app.Fragment;
import android.view.View;
import android.webkit.WebView;
import cn.thinkingdata.android.TDConfig;
import cn.thinkingdata.android.ThinkingAnalyticsSDK;
import d.a.a.o.n;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class f extends ThinkingAnalyticsSDK {
    private String a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private final JSONObject f9288c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f9289d;

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ThinkingAnalyticsSDK.TATrackStatus.values().length];
            a = iArr;
            try {
                iArr[ThinkingAnalyticsSDK.TATrackStatus.PAUSE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[ThinkingAnalyticsSDK.TATrackStatus.STOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[ThinkingAnalyticsSDK.TATrackStatus.SAVE_ONLY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[ThinkingAnalyticsSDK.TATrackStatus.NORMAL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public f(TDConfig tDConfig) {
        super(tDConfig, true);
        this.f9289d = true;
        this.f9288c = new JSONObject();
    }

    @Override // cn.thinkingdata.android.ThinkingAnalyticsSDK
    public void clearSuperProperties() {
        if (hasDisabled()) {
            return;
        }
        synchronized (this.f9288c) {
            Iterator<String> keys = this.f9288c.keys();
            while (keys.hasNext()) {
                keys.next();
                keys.remove();
            }
        }
    }

    @Override // cn.thinkingdata.android.ThinkingAnalyticsSDK
    public void enableAutoTrack(List<ThinkingAnalyticsSDK.AutoTrackEventType> list) {
    }

    @Override // cn.thinkingdata.android.ThinkingAnalyticsSDK
    public void enableTracking(boolean z) {
        this.f9289d = z;
    }

    @Override // cn.thinkingdata.android.ThinkingAnalyticsSDK
    public String getDistinctId() {
        String str = this.a;
        return str != null ? str : getRandomID();
    }

    @Override // cn.thinkingdata.android.ThinkingAnalyticsSDK
    public String getLoginId() {
        return this.b;
    }

    @Override // cn.thinkingdata.android.ThinkingAnalyticsSDK
    public JSONObject getSuperProperties() {
        return this.f9288c;
    }

    @Override // cn.thinkingdata.android.ThinkingAnalyticsSDK
    public boolean hasOptOut() {
        return false;
    }

    @Override // cn.thinkingdata.android.ThinkingAnalyticsSDK
    public void identify(String str) {
        this.a = str;
    }

    @Override // cn.thinkingdata.android.ThinkingAnalyticsSDK
    public void ignoreAutoTrackActivities(List<Class<?>> list) {
    }

    @Override // cn.thinkingdata.android.ThinkingAnalyticsSDK
    public void ignoreAutoTrackActivity(Class<?> cls) {
    }

    @Override // cn.thinkingdata.android.ThinkingAnalyticsSDK
    public void ignoreView(View view) {
    }

    @Override // cn.thinkingdata.android.ThinkingAnalyticsSDK
    public void ignoreViewType(Class cls) {
    }

    @Override // cn.thinkingdata.android.ThinkingAnalyticsSDK
    public boolean isEnabled() {
        return this.f9289d;
    }

    @Override // cn.thinkingdata.android.ThinkingAnalyticsSDK
    public void login(String str) {
        if (hasDisabled()) {
            return;
        }
        this.b = str;
    }

    @Override // cn.thinkingdata.android.ThinkingAnalyticsSDK
    public void logout() {
        if (hasDisabled()) {
            return;
        }
        this.b = null;
    }

    @Override // cn.thinkingdata.android.ThinkingAnalyticsSDK
    public void optInTracking() {
    }

    @Override // cn.thinkingdata.android.ThinkingAnalyticsSDK
    public void optOutTracking() {
    }

    @Override // cn.thinkingdata.android.ThinkingAnalyticsSDK
    public void optOutTrackingAndDeleteUser() {
    }

    @Override // cn.thinkingdata.android.ThinkingAnalyticsSDK
    public void setJsBridge(WebView webView) {
    }

    @Override // cn.thinkingdata.android.ThinkingAnalyticsSDK
    public void setJsBridgeForX5WebView(Object obj) {
    }

    @Override // cn.thinkingdata.android.ThinkingAnalyticsSDK
    public void setNetworkType(ThinkingAnalyticsSDK.ThinkingdataNetworkType thinkingdataNetworkType) {
    }

    @Override // cn.thinkingdata.android.ThinkingAnalyticsSDK
    public void setSuperProperties(JSONObject jSONObject) {
        if (hasDisabled() || jSONObject == null) {
            return;
        }
        try {
            if (cn.thinkingdata.android.utils.g.b(jSONObject)) {
                synchronized (this.f9288c) {
                    n.v(jSONObject, this.f9288c, this.mConfig.getDefaultTimeZone());
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // cn.thinkingdata.android.ThinkingAnalyticsSDK
    public void setTrackStatus(ThinkingAnalyticsSDK.TATrackStatus tATrackStatus) {
        int i2 = a.a[tATrackStatus.ordinal()];
        if (i2 == 1) {
            this.mMessages.f(getToken(), false);
            enableTracking(false);
        } else if (i2 == 2) {
            this.f9289d = true;
            this.mMessages.f(getToken(), false);
            optOutTracking();
        } else if (i2 == 3) {
            this.f9289d = true;
            this.mMessages.f(getToken(), true);
        } else if (i2 != 4) {
        } else {
            this.f9289d = true;
            this.mMessages.f(getToken(), false);
            flush();
        }
    }

    @Override // cn.thinkingdata.android.ThinkingAnalyticsSDK
    public void setViewID(Dialog dialog, String str) {
    }

    @Override // cn.thinkingdata.android.ThinkingAnalyticsSDK
    public void setViewID(View view, String str) {
    }

    @Override // cn.thinkingdata.android.ThinkingAnalyticsSDK
    public void setViewProperties(View view, JSONObject jSONObject) {
    }

    @Override // cn.thinkingdata.android.ThinkingAnalyticsSDK
    public void trackFragmentAppViewScreen() {
    }

    @Override // cn.thinkingdata.android.ThinkingAnalyticsSDK
    public void trackViewScreen(Activity activity) {
    }

    @Override // cn.thinkingdata.android.ThinkingAnalyticsSDK
    public void trackViewScreen(Fragment fragment) {
    }

    @Override // cn.thinkingdata.android.ThinkingAnalyticsSDK
    public void trackViewScreen(Object obj) {
    }

    @Override // cn.thinkingdata.android.ThinkingAnalyticsSDK
    public void unsetSuperProperty(String str) {
        if (hasDisabled() || str == null) {
            return;
        }
        try {
            synchronized (this.f9288c) {
                this.f9288c.remove(str);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
