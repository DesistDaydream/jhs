package com.bytedance.msdk.api;

/* loaded from: classes.dex */
public class AdError {
    public static final String AD_LOAD_AD_TIME_OUT_ERROR_MSG = "load ad timeout !!!";
    public static final String AD_LOAD_SUCCESS_MSG = "load success";
    public static final String AD_MULTI_NO_LEVEL_TAG_MSG = "价格标签为空字符，无多阶底价权限或权限异常";
    public static final String AD_MULTI_NO_MATCH_LEVEL_TAG_MSG = "无法解析价格标签，请确认并更新平台配置";
    public static final int AD_NO_FILL = 10086;
    public static final int AD_REQUEST_TIMEOUT = 10010;
    public static final String AD_THIRD_SDK_NO_CACHE_CALLBACK_MSG = "sdk no cache callback ";
    public static final String AD_UNKNOWN_ERROR_MSG = "unknown error!";
    public static final int ERROR_ADN_NO_ERROR_CODE = -99999;
    public static final int ERROR_CODE_ADAPTER_CONFIGURATION_ERROR = 30012;
    public static final int ERROR_CODE_ADAPTER_INITIALIZATION_SUCCESS = 30011;
    public static final int ERROR_CODE_ADN_EXCEED_FREQCTL = 41041;
    public static final int ERROR_CODE_ADN_EXCEED_PACING = 41042;
    public static final int ERROR_CODE_ADN_LOAD_FAIL_ERROR_CONTROL = 40044;
    public static final int ERROR_CODE_ADSLOT_CONFIG_ERROR = 40026;
    public static final int ERROR_CODE_AD_LOAD_FAIL = 20005;
    public static final int ERROR_CODE_AD_LOAD_SUCCESS = 20000;
    public static final int ERROR_CODE_BANNER_MODULE_UNABLE = 40032;
    public static final int ERROR_CODE_BIDDING_PRICE_LOW = 50100;
    public static final int ERROR_CODE_CONFIG_ERROR = 41006;
    public static final int ERROR_CODE_CONFIG_IS_ALREADY_LOADING = 81001;
    public static final int ERROR_CODE_CONTEXT_ERROR = 41005;
    public static final int ERROR_CODE_CUSTOM_BANNER_LOAD_ERROR = 49000;
    public static final int ERROR_CODE_CUSTOM_BANNER_SHOW_ERROR = 49001;
    public static final int ERROR_CODE_CUSTOM_DRAW_LOAD_ERROR = 49015;
    public static final int ERROR_CODE_CUSTOM_FULL_VIDEO_LOAD_ERROR = 49006;
    public static final int ERROR_CODE_CUSTOM_FULL_VIDEO_SHOW_ERROR = 49007;
    public static final int ERROR_CODE_CUSTOM_INIT = 49013;
    public static final int ERROR_CODE_CUSTOM_INTERSTITIAL_LOAD_ERROR = 49002;
    public static final int ERROR_CODE_CUSTOM_INTERSTITIAL_SHOW_ERROR = 49003;
    public static final int ERROR_CODE_CUSTOM_LOAD = 49014;
    public static final int ERROR_CODE_CUSTOM_NATIVE_LOAD_ERROR = 49010;
    public static final int ERROR_CODE_CUSTOM_NATIVE_VIDEO_SHOW_ERROR = 49012;
    public static final int ERROR_CODE_CUSTOM_REWARD_LOAD_ERROR = 49004;
    public static final int ERROR_CODE_CUSTOM_REWARD_SHOW_ERROR = 49005;
    public static final int ERROR_CODE_CUSTOM_SPLASH_LOAD_ERROR = 49008;
    public static final int ERROR_CODE_CUSTOM_SPLASH_SHOW_ERROR = 49009;
    public static final int ERROR_CODE_DESTROY = 41044;
    public static final int ERROR_CODE_EXCEED_FREQCTL = 40041;
    public static final int ERROR_CODE_EXCEED_PACING = 40042;
    public static final int ERROR_CODE_FEED_MODULE_UNABLE = 40035;
    public static final int ERROR_CODE_FULL_MODULE_UNABLE = 40037;
    public static final int ERROR_CODE_INPUT_PARAMS_ERROR = 81003;
    public static final int ERROR_CODE_INTERACTION_MODULE_UNABLE = 40033;
    public static final int ERROR_CODE_LOADED = 40047;
    public static final int ERROR_CODE_MSDK_NOT_INIT = 1;
    public static final int ERROR_CODE_MSDK_THREAD_HANDLER = 41043;
    public static final int ERROR_CODE_NATIVE_MODULE_UNABLE = 40038;
    public static final int ERROR_CODE_NET_TIMEOUT = 44405;
    public static final int ERROR_CODE_NO_AD = 20001;
    public static final int ERROR_CODE_NO_CONFIG = 40040;
    public static final int ERROR_CODE_NO_LEVEL_TAG = 40061;
    public static final int ERROR_CODE_NO_MATCH_LEVEL_TAG = 40062;
    public static final int ERROR_CODE_NO_NET = 44404;
    public static final int ERROR_CODE_NO_PERMISSION = 81002;
    public static final int ERROR_CODE_PANGLE_APPID_NO_SAME = 40028;
    public static final int ERROR_CODE_REQUEST_BUT_CONFIG_ERROR = 40045;
    public static final int ERROR_CODE_REQUEST_CIRCUIT_BREAKER = 40043;
    public static final int ERROR_CODE_REWARD_MODULE_UNABLE = 40036;
    public static final int ERROR_CODE_RIT = 44406;
    public static final int ERROR_CODE_RIT_ADTYPE_NO_SAME = 40031;
    public static final int ERROR_CODE_SHOWED = 40048;
    public static final int ERROR_CODE_SHOW_FAIL_NO_AD = 40052;
    public static final int ERROR_CODE_SPLASH_CARRY_BOTTOM = 40027;
    public static final int ERROR_CODE_SPLASH_MODULE_UNABLE = 40034;
    public static final int ERROR_CODE_THIRD_SDK_NO_CACHE_CALLBACK = 30010;
    public static final int ERROR_COED_ADM_ERROR = 10013;
    public static final int ERROR_COED_NOT_PRIME = 10014;
    public static final int ERROR_COED_NO_TOKEN = 10015;
    public static final String ERROR_MEDIATION_REQUEST_ID_MSG = "广告位ID不合法";
    public static final String ERROR_MEDIA_CODE_RENDER_TYPE_MISMATCH_MSG = "渲染类型错误";
    public static final String ERROR_MEDIA_NO_ERROR_MSG = "no error message";
    public static final String ERROR_MEDIA_RENDER_MSG = "渲染失败";
    public static final String ERROR_MEDIA_REQUEST_ID_MSG = "代码位ID不合法";
    public static final String ERROR_MEDIA_REQUEST_SLOT_MSG = "代码位请求参数错误";
    public static final String ERROR_MEDIA_REQUEST_SUCCESS_NO_ADS_MSG = "请求成功，但无广告可用";
    public static final int ERROR_PANGLE_CALLSTACK = 40063;
    public static final int LOAD_AD_TIME_OUT_ERROR = 10003;
    public static final int NET_ERROR = -2;
    public static final int PARSE_FAIL = -1;
    public static final int SINGLE_AD_REQUEST_TIMEOUT = 10012;
    public int code;
    public String message;
    public int thirdSdkErrorCode;
    public String thirdSdkErrorMessage;

    public AdError() {
        this(ERROR_ADN_NO_ERROR_CODE, ERROR_MEDIA_NO_ERROR_MSG);
    }

    public AdError(int i2) {
        this(i2, "");
    }

    public AdError(int i2, String str) {
        this(i2, str, i2, str);
    }

    public AdError(int i2, String str, int i3, String str2) {
        this.code = i2;
        this.message = str;
        this.thirdSdkErrorCode = i3;
        this.thirdSdkErrorMessage = str2;
    }

    public AdError(String str) {
        this(ERROR_ADN_NO_ERROR_CODE, str);
    }

    public static String getMessage(int i2) {
        if (i2 != -2) {
            if (i2 != -1) {
                if (i2 != 40047) {
                    if (i2 != 40048) {
                        if (i2 != 44404) {
                            if (i2 != 44405) {
                                switch (i2) {
                                    case 1:
                                        return "MSDK还未初始化";
                                    case 10003:
                                        return AD_LOAD_AD_TIME_OUT_ERROR_MSG;
                                    case 20005:
                                        return "全部代码位请求失败";
                                    case ERROR_CODE_SHOW_FAIL_NO_AD /* 40052 */:
                                        return "广告展示失败，暂无广告可用，请重新加载";
                                    case ERROR_CODE_CONTEXT_ERROR /* 41005 */:
                                        return "Context为null，请检查传入的Context";
                                    case ERROR_CODE_CUSTOM_NATIVE_VIDEO_SHOW_ERROR /* 49012 */:
                                        return "自定义ADN 信息流 视频播放失败";
                                    case ERROR_CODE_CUSTOM_DRAW_LOAD_ERROR /* 49015 */:
                                        return "自定义ADN draw load失败";
                                    case ERROR_CODE_BIDDING_PRICE_LOW /* 50100 */:
                                        return "本次出价低于竞价底价";
                                    default:
                                        switch (i2) {
                                            case ERROR_CODE_CUSTOM_BANNER_LOAD_ERROR /* 49000 */:
                                                return "自定义ADN banner load失败";
                                            case ERROR_CODE_CUSTOM_BANNER_SHOW_ERROR /* 49001 */:
                                                return "自定义ADN banner show失败";
                                            case ERROR_CODE_CUSTOM_INTERSTITIAL_LOAD_ERROR /* 49002 */:
                                                return "自定义ADN 插屏 load失败";
                                            case ERROR_CODE_CUSTOM_INTERSTITIAL_SHOW_ERROR /* 49003 */:
                                                return "自定义ADN 插屏 show失败";
                                            case ERROR_CODE_CUSTOM_REWARD_LOAD_ERROR /* 49004 */:
                                                return "自定义ADN 激励视频 load失败";
                                            case ERROR_CODE_CUSTOM_REWARD_SHOW_ERROR /* 49005 */:
                                                return "自定义ADN 激励视频 show失败";
                                            case ERROR_CODE_CUSTOM_FULL_VIDEO_LOAD_ERROR /* 49006 */:
                                                return "自定义ADN 全屏视频 load失败";
                                            case ERROR_CODE_CUSTOM_FULL_VIDEO_SHOW_ERROR /* 49007 */:
                                                return "自定义ADN 全屏视频 show失败";
                                            case ERROR_CODE_CUSTOM_SPLASH_LOAD_ERROR /* 49008 */:
                                                return "自定义ADN 开屏视频 load失败";
                                            case ERROR_CODE_CUSTOM_SPLASH_SHOW_ERROR /* 49009 */:
                                                return "自定义ADN 开屏视频 show失败";
                                            case ERROR_CODE_CUSTOM_NATIVE_LOAD_ERROR /* 49010 */:
                                                return "自定义ADN 信息流 load失败";
                                            default:
                                                switch (i2) {
                                                    case ERROR_CODE_CONFIG_IS_ALREADY_LOADING /* 81001 */:
                                                        return "配置正在请求中，稍后重试";
                                                    case ERROR_CODE_NO_PERMISSION /* 81002 */:
                                                        return "无白名单权限";
                                                    case ERROR_CODE_INPUT_PARAMS_ERROR /* 81003 */:
                                                        return "传入的参数有误或为空，请检查参数";
                                                    default:
                                                        switch (i2) {
                                                            case 10012:
                                                                return "Adn超时后回调";
                                                            case 10013:
                                                                return "Adm数据异常";
                                                            case 10014:
                                                                return "广告位不是内容混出广告位，请查看配置";
                                                            case 10015:
                                                                return "请先获取token相关信息";
                                                            default:
                                                                switch (i2) {
                                                                    case ERROR_CODE_ADSLOT_CONFIG_ERROR /* 40026 */:
                                                                        return "adSlot 不能为 null";
                                                                    case ERROR_CODE_SPLASH_CARRY_BOTTOM /* 40027 */:
                                                                        return "开屏广告自定义兜底参数不正确，请校验";
                                                                    case ERROR_CODE_PANGLE_APPID_NO_SAME /* 40028 */:
                                                                        return "开屏广告开发者自定义兜底中pangle appId，与pangle sdk初始化的appId不一致，请检查并传入与初始化相同appId";
                                                                    default:
                                                                        switch (i2) {
                                                                            case ERROR_CODE_RIT_ADTYPE_NO_SAME /* 40031 */:
                                                                                return "聚合广告位对应的广告类型和当前广告类型不一致";
                                                                            case ERROR_CODE_BANNER_MODULE_UNABLE /* 40032 */:
                                                                                return "Banner广告暂无广告返回，请稍后重试";
                                                                            case ERROR_CODE_INTERACTION_MODULE_UNABLE /* 40033 */:
                                                                                return "插屏广告暂无广告返回，请稍后重试";
                                                                            case ERROR_CODE_SPLASH_MODULE_UNABLE /* 40034 */:
                                                                                return "开屏广告暂无广告返回，请稍后重试";
                                                                            case ERROR_CODE_FEED_MODULE_UNABLE /* 40035 */:
                                                                                return "信息流模板广告暂无广告返回，请稍后重试";
                                                                            case ERROR_CODE_REWARD_MODULE_UNABLE /* 40036 */:
                                                                                return "激励视频广告暂无广告返回，请稍后重试";
                                                                            case ERROR_CODE_FULL_MODULE_UNABLE /* 40037 */:
                                                                                return "全屏视频广告暂无广告返回，请稍后重试";
                                                                            case ERROR_CODE_NATIVE_MODULE_UNABLE /* 40038 */:
                                                                                return "信息流自渲染广告暂无广告返回，请稍后重试";
                                                                            default:
                                                                                switch (i2) {
                                                                                    case ERROR_CODE_NO_CONFIG /* 40040 */:
                                                                                    case ERROR_CODE_REQUEST_BUT_CONFIG_ERROR /* 40045 */:
                                                                                        return "暂无配置信息，请稍后重试，或者注册config回调，具体参考demo";
                                                                                    case ERROR_CODE_EXCEED_FREQCTL /* 40041 */:
                                                                                        return "waterfall层级展示次数达到上限，本次广告加载被阻止";
                                                                                    case ERROR_CODE_EXCEED_PACING /* 40042 */:
                                                                                        return "waterfall层级展示间隔未超过规定的最短时长，本次广告加载被阻止";
                                                                                    case ERROR_CODE_REQUEST_CIRCUIT_BREAKER /* 40043 */:
                                                                                        return "广告请求过于频繁，请稍后重试";
                                                                                    case ERROR_CODE_ADN_LOAD_FAIL_ERROR_CONTROL /* 40044 */:
                                                                                        return "当前ADN限制时间内不允许请求";
                                                                                    default:
                                                                                        switch (i2) {
                                                                                            case ERROR_CODE_NO_LEVEL_TAG /* 40061 */:
                                                                                                return AD_MULTI_NO_LEVEL_TAG_MSG;
                                                                                            case ERROR_CODE_NO_MATCH_LEVEL_TAG /* 40062 */:
                                                                                                return AD_MULTI_NO_MATCH_LEVEL_TAG_MSG;
                                                                                            case ERROR_PANGLE_CALLSTACK /* 40063 */:
                                                                                                return "非穿山甲给出的展示广告";
                                                                                            default:
                                                                                                switch (i2) {
                                                                                                    case ERROR_CODE_ADN_EXCEED_FREQCTL /* 41041 */:
                                                                                                        return "超过代码位层级规定的用户展示上限，实际未发起请求，请求失败";
                                                                                                    case ERROR_CODE_ADN_EXCEED_PACING /* 41042 */:
                                                                                                        return "未超过代码位层级规定的展示间隔，请求频繁，实际未发起请求";
                                                                                                    case ERROR_CODE_MSDK_THREAD_HANDLER /* 41043 */:
                                                                                                        return "msdk thread handler为null";
                                                                                                    case ERROR_CODE_DESTROY /* 41044 */:
                                                                                                        return "已经调用Destroy()方法";
                                                                                                    default:
                                                                                                        return AD_UNKNOWN_ERROR_MSG;
                                                                                                }
                                                                                        }
                                                                                }
                                                                        }
                                                                }
                                                        }
                                                }
                                        }
                                }
                            }
                            return "网络超时";
                        }
                        return "没有网络";
                    }
                    return "广告对象不可重复使用";
                }
                return "广告对象未使用过，不能重新加载";
            }
            return "解析失败";
        }
        return "网络请求失败";
    }

    public String toString() {
        return "AdError{code=" + this.code + ", message='" + this.message + "', thirdSdkErrorCode=" + this.thirdSdkErrorCode + ", thirdSdkErrorMessage='" + this.thirdSdkErrorMessage + "'}";
    }
}
