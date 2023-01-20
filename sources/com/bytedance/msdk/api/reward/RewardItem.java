package com.bytedance.msdk.api.reward;

import java.util.Map;

/* loaded from: classes.dex */
public interface RewardItem {
    public static final String KEY_ADMOB = "admob";
    public static final String KEY_ADN_NAME = "adnName";
    public static final String KEY_BAIDU = "baidu";
    public static final String KEY_ERROR_CODE = "errorCode";
    public static final String KEY_ERROR_MSG = "errorMsg";
    public static final String KEY_EXTRA_INFO = "extraInfo";
    public static final String KEY_GDT = "gdt";
    public static final String KEY_GDT_TRANS_ID = "transId";
    public static final String KEY_GROMORE_EXTRA = "gromoreExtra";
    public static final String KEY_IS_GROMORE_SERVER_SIDE_VERIFY = "isGroMoreServerSideVerify";
    public static final String KEY_KLEVIN = "klevin";
    public static final String KEY_KS = "ks";
    public static final String KEY_MINTEGRAL = "mintegral";
    public static final String KEY_PANGLE = "pangle";
    public static final String KEY_REASON = "reason";
    public static final String KEY_REWARD_TYPE = "rewardType";
    public static final String KEY_SIGMOB = "sigmob";
    public static final String KEY_TRANS_ID = "transId";
    public static final String KEY_UNITY = "unity";

    float getAmount();

    Map<String, Object> getCustomData();

    String getRewardName();

    boolean rewardVerify();
}
