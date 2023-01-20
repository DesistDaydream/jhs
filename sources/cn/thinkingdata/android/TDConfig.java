package cn.thinkingdata.android;

import android.content.Context;
import android.content.SharedPreferences;
import cn.thinkingdata.android.ThinkingAnalyticsSDK;
import cn.thinkingdata.android.encrypt.TDSecreteKey;
import cn.thinkingdata.android.utils.TDLog;
import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.xiaomi.mipush.sdk.Constants;
import d.a.a.h;
import d.a.a.k;
import d.a.a.n.d;
import d.a.a.o.n;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.Future;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: classes.dex */
public class TDConfig {
    public static final int DEFAULT_FLUSH_BULK_SIZE = 20;
    public static final int DEFAULT_FLUSH_INTERVAL = 15000;
    private static final String PREFERENCE_NAME_PREFIX = "cn.thinkingdata.android.config";
    private static final String TAG = "ThinkingAnalytics.TDConfig";
    public static final String VERSION = "2.8.2";
    private volatile boolean mAllowedDebug;
    private final String mConfigUrl;
    public final Context mContext;
    private final k mContextConfig;
    private final String mDebugUrl;
    private TimeZone mDefaultTimeZone;
    private boolean mEnableMutiprocess;
    private final d.a.a.n.c mFlushBulkSize;
    private final d mFlushInterval;
    private SSLSocketFactory mSSLSocketFactory;
    private final String mServerUrl;
    public final String mToken;
    private volatile String name;
    private static final h sPrefsLoader = new h();
    private static final Map<Context, Map<String, TDConfig>> sInstances = new HashMap();
    private final Set<String> mDisabledEvents = new HashSet();
    private final ReadWriteLock mDisabledEventsLock = new ReentrantReadWriteLock();
    private volatile ModeEnum mMode = ModeEnum.NORMAL;
    private int mNetworkType = 255;
    private volatile boolean mTrackOldData = true;
    private TDSecreteKey secreteKey = null;
    public boolean mEnableEncrypt = false;

    /* loaded from: classes.dex */
    public enum ModeEnum {
        NORMAL,
        DEBUG,
        DEBUG_ONLY
    }

    /* loaded from: classes.dex */
    public final class NetworkType {
        public static final int TYPE_2G = 1;
        public static final int TYPE_3G = 2;
        public static final int TYPE_4G = 4;
        public static final int TYPE_5G = 16;
        public static final int TYPE_ALL = 255;
        public static final int TYPE_WIFI = 8;

        public NetworkType() {
            TDConfig.this = r1;
        }
    }

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a() {
            TDConfig.this = r1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:244:0x0263  */
        /* JADX WARN: Removed duplicated region for block: B:257:0x0259 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Type inference failed for: r8v0, types: [java.net.HttpURLConnection, java.io.InputStream] */
        /* JADX WARN: Type inference failed for: r8v1, types: [java.io.InputStream] */
        /* JADX WARN: Type inference failed for: r8v3 */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() {
            /*
                Method dump skipped, instructions count: 615
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.thinkingdata.android.TDConfig.a.run():void");
        }
    }

    /* loaded from: classes.dex */
    public static /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ThinkingAnalyticsSDK.ThinkingdataNetworkType.values().length];
            a = iArr;
            try {
                iArr[ThinkingAnalyticsSDK.ThinkingdataNetworkType.NETWORKTYPE_WIFI.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[ThinkingAnalyticsSDK.ThinkingdataNetworkType.NETWORKTYPE_DEFAULT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[ThinkingAnalyticsSDK.ThinkingdataNetworkType.NETWORKTYPE_ALL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private TDConfig(Context context, String str, String str2) {
        Context applicationContext = context.getApplicationContext();
        this.mContext = applicationContext;
        this.mContextConfig = k.b(applicationContext);
        this.mToken = str;
        this.mServerUrl = str2 + "/sync";
        this.mDebugUrl = str2 + "/data_debug";
        this.mConfigUrl = str2 + "/config?appid=" + str;
        h hVar = sPrefsLoader;
        Future<SharedPreferences> a2 = hVar.a(applicationContext, "cn.thinkingdata.android.config_" + str);
        this.mFlushInterval = new d(a2, DEFAULT_FLUSH_INTERVAL);
        this.mFlushBulkSize = new d.a.a.n.c(a2, 20);
        this.mEnableMutiprocess = false;
    }

    public static TDConfig getInstance(Context context, String str) {
        try {
            return getInstance(context, str, "");
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public static TDConfig getInstance(Context context, String str, String str2) {
        return getInstance(context, str, str2, str);
    }

    public static TDConfig getInstance(Context context, String str, String str2, String str3) {
        TDConfig tDConfig;
        String str4;
        Context applicationContext = context.getApplicationContext();
        Map<Context, Map<String, TDConfig>> map = sInstances;
        synchronized (map) {
            Map<String, TDConfig> map2 = map.get(applicationContext);
            if (map2 == null) {
                map2 = new HashMap<>();
                map.put(applicationContext, map2);
            }
            String replace = str.replace(ExpandableTextView.N, "");
            String replace2 = str3.replace(ExpandableTextView.N, "");
            tDConfig = map2.get(replace2);
            if (tDConfig == null) {
                try {
                    URL url = new URL(str2);
                    StringBuilder sb = new StringBuilder();
                    sb.append(url.getProtocol());
                    sb.append("://");
                    sb.append(url.getHost());
                    if (url.getPort() > 0) {
                        str4 = Constants.COLON_SEPARATOR + url.getPort();
                    } else {
                        str4 = "";
                    }
                    sb.append(str4);
                    TDConfig tDConfig2 = new TDConfig(applicationContext, replace, sb.toString());
                    tDConfig2.setName(replace2);
                    map2.put(replace2, tDConfig2);
                    tDConfig2.getRemoteConfig();
                    tDConfig = tDConfig2;
                } catch (MalformedURLException e2) {
                    TDLog.e(TAG, "Invalid server URL: " + str2);
                    throw new IllegalArgumentException(e2);
                }
            }
        }
        return tDConfig;
    }

    private void getRemoteConfig() {
        new Thread(new a()).start();
    }

    private void setName(String str) {
        this.name = str;
    }

    public TDConfig enableEncrypt(boolean z) {
        this.mEnableEncrypt = z;
        return this;
    }

    public String getDebugUrl() {
        return this.mDebugUrl;
    }

    public synchronized TimeZone getDefaultTimeZone() {
        TimeZone timeZone;
        timeZone = this.mDefaultTimeZone;
        if (timeZone == null) {
            timeZone = TimeZone.getDefault();
        }
        return timeZone;
    }

    public int getFlushBulkSize() {
        return this.mFlushBulkSize.e().intValue();
    }

    public int getFlushInterval() {
        return this.mFlushInterval.e().intValue();
    }

    public String getMainProcessName() {
        return this.mContextConfig.c();
    }

    public ModeEnum getMode() {
        return this.mMode;
    }

    public int getModeInt() {
        return this.mMode.ordinal();
    }

    public String getName() {
        return this.name;
    }

    public synchronized SSLSocketFactory getSSLSocketFactory() {
        return this.mSSLSocketFactory;
    }

    public TDSecreteKey getSecreteKey() {
        return this.secreteKey;
    }

    public String getServerUrl() {
        return this.mServerUrl;
    }

    public Map<String, TDConfig> getTDConfigMap() {
        return sInstances.get(this.mContext);
    }

    public boolean isDebug() {
        return ModeEnum.DEBUG.equals(this.mMode);
    }

    public boolean isDebugOnly() {
        return ModeEnum.DEBUG_ONLY.equals(this.mMode);
    }

    public boolean isDisabledEvent(String str) {
        this.mDisabledEventsLock.readLock().lock();
        try {
            return this.mDisabledEvents.contains(str);
        } finally {
            this.mDisabledEventsLock.readLock().unlock();
        }
    }

    public boolean isEnableMutiprocess() {
        return this.mEnableMutiprocess;
    }

    public boolean isNormal() {
        return ModeEnum.NORMAL.equals(this.mMode);
    }

    public synchronized boolean isShouldFlush(String str) {
        return (n.e(str) & this.mNetworkType) != 0;
    }

    public void setAllowDebug() {
        this.mAllowedDebug = true;
    }

    public synchronized TDConfig setDefaultTimeZone(TimeZone timeZone) {
        this.mDefaultTimeZone = timeZone;
        return this;
    }

    public TDConfig setMode(ModeEnum modeEnum) {
        this.mMode = modeEnum;
        return this;
    }

    public void setModeInt(int i2) {
        if (i2 < 0 || i2 > 2) {
            TDLog.d(TAG, "Invalid mode value");
        } else {
            this.mMode = ModeEnum.values()[i2];
        }
    }

    public TDConfig setMutiprocess(boolean z) {
        this.mEnableMutiprocess = z;
        return this;
    }

    public synchronized void setNetworkType(ThinkingAnalyticsSDK.ThinkingdataNetworkType thinkingdataNetworkType) {
        int i2 = b.a[thinkingdataNetworkType.ordinal()];
        if (i2 == 1) {
            this.mNetworkType = 8;
        } else if (i2 == 2 || i2 == 3) {
            this.mNetworkType = 31;
        }
    }

    public synchronized TDConfig setSSLSocketFactory(SSLSocketFactory sSLSocketFactory) {
        if (sSLSocketFactory != null) {
            this.mSSLSocketFactory = sSLSocketFactory;
            getRemoteConfig();
        }
        return this;
    }

    public TDConfig setSecretKey(TDSecreteKey tDSecreteKey) {
        if (this.secreteKey == null) {
            this.secreteKey = tDSecreteKey;
        }
        return this;
    }

    public TDConfig setTrackOldData(boolean z) {
        this.mTrackOldData = z;
        return this;
    }

    public boolean shouldThrowException() {
        return false;
    }

    public boolean trackOldData() {
        return this.mTrackOldData;
    }
}
