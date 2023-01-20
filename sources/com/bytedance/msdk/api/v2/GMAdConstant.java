package com.bytedance.msdk.api.v2;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes.dex */
public class GMAdConstant {
    public static final int AD_TYPE_CLIENT_BIDING = 1;
    public static final int AD_TYPE_COMMON_VIDEO = 0;
    public static final int AD_TYPE_MULTILEVEL = 3;
    public static final int AD_TYPE_NORMAL = 0;
    public static final int AD_TYPE_P = 100;
    public static final int AD_TYPE_PLAYABLE = 2;
    public static final int AD_TYPE_PLAYABLE_VIDEO = 1;
    public static final int AD_TYPE_SERVER_BIDING = 2;
    public static final int AD_TYPE_UNKNOWN = -1;
    public static final int APP_DOWNLOAD_TYPE_BYTES = 1;
    public static final int APP_DOWNLOAD_TYPE_NOTSUPPORT = -1;
    public static final int APP_DOWNLOAD_TYPE_ONCONTINUEDOWNLOAD = 12;
    public static final int APP_DOWNLOAD_TYPE_ONDOWNLOADACTIVE = 2;
    public static final int APP_DOWNLOAD_TYPE_ONDOWNLOADCLICKSTARTUP = 10;
    public static final int APP_DOWNLOAD_TYPE_ONDOWNLOADCLISKINSTALL = 9;
    public static final int APP_DOWNLOAD_TYPE_ONDOWNLOADDELETE = 7;
    public static final int APP_DOWNLOAD_TYPE_ONDOWNLOADFAILED = 4;
    public static final int APP_DOWNLOAD_TYPE_ONDOWNLOADFINISHED = 5;
    public static final int APP_DOWNLOAD_TYPE_ONDOWNLOADPAUSED = 3;
    public static final int APP_DOWNLOAD_TYPE_ONDOWNLOADREFLASH = 8;
    public static final int APP_DOWNLOAD_TYPE_ONDOWNLOADSTART = 1;
    public static final int APP_DOWNLOAD_TYPE_ONIDLE = 0;
    public static final int APP_DOWNLOAD_TYPE_ONINSTALLED = 6;
    public static final int APP_DOWNLOAD_TYPE_ONREDOWNLOAD = 11;
    public static final int APP_DOWNLOAD_TYPE_PROGRESS = 2;
    public static final String BAIDU_DISLIKE_CLICK_ITEM = "baidu_dislike_click_item";
    public static final String BAIDU_DISLIKE_INFO = "baidu_dislike_info";
    public static final String CUSTOM_DATA_KEY_ADMOB = "admob";
    public static final String CUSTOM_DATA_KEY_BAIDU = "baidu";
    public static final String CUSTOM_DATA_KEY_GDT = "gdt";
    public static final String CUSTOM_DATA_KEY_GROMORE_EXTRA = "gromoreExtra";
    public static final String CUSTOM_DATA_KEY_KLEVIN = "klevin";
    public static final String CUSTOM_DATA_KEY_KS = "ks";
    public static final String CUSTOM_DATA_KEY_MINTEGRAL = "mintegral";
    public static final String CUSTOM_DATA_KEY_PANGLE = "pangle";
    public static final String CUSTOM_DATA_KEY_SIGMOB = "sigmob";
    public static final String CUSTOM_DATA_KEY_UNITY = "unity";
    public static final int DOWNLOAD_TYPE_NO_POPUP = 0;
    public static final int DOWNLOAD_TYPE_POPUP = 1;
    public static final String EXTRA_ADID = "ad_id";
    public static final String EXTRA_CID = "c_id";
    public static final String EXTRA_DURATION = "duration";
    public static final String EXTRA_LOG_EXTRA = "log_extra";
    public static final String GM_EXTRA_KEY_PRIME_RIT_LIST = "primeRitList";
    public static final int GROMORE_SERVER_SIDE_REWARD_TYPE = 1;
    public static final int HORIZONTAL = 2;
    public static final int IMAGE_MODE_GROUP_IMG = 4;
    public static final int IMAGE_MODE_LARGE_IMG = 3;
    public static final int IMAGE_MODE_SMALL_IMG = 2;
    public static final int IMAGE_MODE_UNKNOWN = -1;
    public static final int IMAGE_MODE_VERTICAL_IMG = 16;
    public static final int IMAGE_MODE_VIDEO = 5;
    public static final int IMAGE_MODE_VIDEO_VERTICAL = 15;
    public static final int INTERACTION_TYPE_BROWSER = 2;
    public static final int INTERACTION_TYPE_DIAL = 5;
    public static final int INTERACTION_TYPE_DOWNLOAD = 4;
    public static final int INTERACTION_TYPE_LANDING_PAGE = 3;
    public static final int INTERACTION_TYPE_UNKNOWN = -1;
    public static final String MULTI_PROCESS_DATA = "multi_process_data";
    public static final String MULTI_PROCESS_MATERIALMETA = "multi_process_materialmeta";
    public static final int NETWORK_STATE_2G = 2;
    public static final int NETWORK_STATE_3G = 3;
    public static final int NETWORK_STATE_4G = 5;
    public static final int NETWORK_STATE_MOBILE = 1;
    public static final int NETWORK_STATE_WIFI = 4;
    public static final String PANGLE_CUSTOM_DIALOG = "pangle_custom_dialog";
    public static final String PANGLE_DISLIKE_INFO = "pangle_dislike_info";
    public static final String PANGLE_VID = "pangle_vid";
    public static final int PERMISSION_LOCATION = 1;
    public static final int PERMISSION_PHONE_STATE = 2;
    public static final int PERMISSION_WRITE_EXTERNAL_STORAGE = 3;
    public static final int PLUGIN_UPDATE = 2;
    public static final int PLUGIN_WIFI_UPDATE = 1;
    public static final int SPLASH_BUTTON_TYPE_DOWNLOAD_BAR = 2;
    @Deprecated
    public static final int SPLASH_BUTTON_TYPE_FULL_SCREEN = 1;
    public static final int SPLASH_TIME_OUT = 3000;
    public static final int SUB_ADTYPE_BANNER = 3;
    public static final int SUB_ADTYPE_FEED = 4;
    public static final int SUB_ADTYPE_FULL = 2;
    public static final int SUB_ADTYPE_INTERSTITIAL = 1;
    public static final String TAG = "GM_Mediation_SDK";
    public static final int TITLE_BAR_THEME_DARK = 1;
    public static final int TITLE_BAR_THEME_LIGHT = 0;
    public static final int TITLE_BAR_THEME_NO_TITLE_BAR = -1;
    public static final String TT_ADMOB_NATIVE_VIEW_ROOT_TAG = "tt_admob_native_view_root_tag";
    public static final String TT_ADMOB_NATIVE_VIEW_TAG = "tt_admob_native_view_tag";
    public static final String TT_GDT_NATIVE_LOGO_VIEW_TAG = "tt_gdt_developer_view_logo";
    public static final String TT_GDT_NATIVE_ROOT_VIEW_TAG = "tt_gdt_developer_view_root";
    public static final String TT_GDT_NATIVE_VIEW_TAG = "tt_gdt_developer_view";
    public static final int TYPE_EXPRESS_AD = 1;
    public static final int TYPE_NATIVE_AD = 2;
    public static final int VERTICAL = 1;

    /* loaded from: classes.dex */
    public enum ADULT_STATE {
        AGE_15,
        AGE_18,
        AGE_ADULT
    }

    /* loaded from: classes.dex */
    public enum AdIsReadyStatus {
        ADN_NO_READY_API,
        AD_IS_READY,
        AD_IS_EXPIRED,
        AD_IS_NOT_READY
    }

    /* loaded from: classes.dex */
    public enum BiddingLossReason {
        LOW_PRICE(1),
        TIME_OUT(2),
        NO_AD(3),
        AD_DATA_ERROR(4),
        OTHER(10001);
        
        public final int a;

        BiddingLossReason(int i2) {
            this.a = i2;
        }

        public int getLossReason() {
            return this.a;
        }
    }

    /* loaded from: classes.dex */
    public enum GroMoreExtraKey {
        CUSTOMIZE_RIT_SCENES("groMore_key_customize_rit_scenes"),
        RIT_SCENES("groMore_key_rit_scenes");
        
        public final String a;

        GroMoreExtraKey(String str) {
            this.a = str;
        }

        public String getExtraKey() {
            return this.a;
        }
    }

    /* loaded from: classes.dex */
    public enum GroMoreRitScenes {
        CUSTOMIZE_SCENES("customize_scenes"),
        HOME_OPEN_BONUS("home_open_bonus"),
        HOME_SVIP_BONUS("home_svip_bonus"),
        HOME_GET_PROPS("home_get_props"),
        HOME_TRY_PROPS("home_try_props"),
        HOME_GET_BONUS("home_get_bonus"),
        HOME_GIFT_BONUS("home_gift_bonus"),
        GAME_START_BONUS("game_start_bonus"),
        GAME_REDUCE_WAITING("geme_reduce_waiting"),
        GAME_MORE_KLLKRTUNITIES("game_more_kllkrtunities"),
        GAME_FINISH_REWARDS("game_finish_rewards"),
        GAME_GIFT_BONUS("game_gift_bonus");
        
        public final String a;

        GroMoreRitScenes(String str) {
            this.a = str;
        }

        public String getScenesName() {
            return this.a;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface NATIVE_AD_TYPE {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface NETWORK_STATE {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface ORIENTATION_STATE {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface TITLE_BAR_THEME {
    }
}
