package com.jihuanshe.model;

import e.j.e.r.c;
import h.k2.v.u;
import java.util.List;
import k.e.a.d;
import k.e.a.e;

/* loaded from: classes2.dex */
public final class GlobalConfig {
    @d
    public static final String AD_TYPE_BYTEDANCE = "csj";
    @d
    public static final String AD_TYPE_POSTER = "in_house";
    @d
    public static final Companion Companion = new Companion(null);
    @c("ad_splash_supplier")
    @e
    private String adOffer;
    @c("ad_splash_android_app_id")
    @e
    private String adSdkAppId;
    @c("seller_credit_rank_intro")
    @e
    private String creditRankIntro;
    @c("ad_splash_android_gromore_slot_id")
    @e
    private Long gromoreAdId;
    @c("ad_splash_android_gromore_bottom_slot_id")
    @e
    private String gromoreBottomAdId;
    @c("ad_splash_android_gromore_bottom_ad_network")
    @e
    private String gromoreBottomType;
    @c("chat_notice")
    @e
    private String imNotice;
    @c("last_version_android")
    @e
    private String newestVersion;
    @c("official_uid_list")
    @e
    private List<String> officials;
    @c("rsa_public_key")
    @e
    private String pk;
    @c("ad_splash_in_house_click_url")
    @e
    private String posterLink;
    @c("ad_splash_in_house_image")
    @e
    private String posterUrl;
    @c("show_updated_content_android")
    @e
    private Integer showUpdateContentType;
    @c("ad_splash_android_slot_id")
    @e
    private String splashAdId;
    @c("ad_splash_android_show_interval_minutes")
    @e
    private Long splashAdShowInternal;
    @c("updated_content_android")
    @e
    private String updateContent;
    @c("update_request_content_android")
    @e
    private String updateRequestContent;
    @c("update_request_android")
    @e
    private Integer updateType;
    @c("warehouse_instruction")
    @e
    private String warehouseIntro;
    @c("warehouse_seller_notice")
    @e
    private String warehouseSellerNotice;

    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(u uVar) {
            this();
        }
    }

    public GlobalConfig() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 1048575, null);
    }

    public GlobalConfig(@e String str, @e String str2, @e List<String> list, @e String str3, @e String str4, @e String str5, @e String str6, @e String str7, @e String str8, @e String str9, @e Integer num, @e String str10, @e Integer num2, @e String str11, @e Long l2, @e Long l3, @e String str12, @e String str13, @e String str14, @e String str15) {
        this.warehouseIntro = str;
        this.pk = str2;
        this.officials = list;
        this.imNotice = str3;
        this.adSdkAppId = str4;
        this.splashAdId = str5;
        this.adOffer = str6;
        this.posterUrl = str7;
        this.posterLink = str8;
        this.newestVersion = str9;
        this.updateType = num;
        this.updateRequestContent = str10;
        this.showUpdateContentType = num2;
        this.updateContent = str11;
        this.splashAdShowInternal = l2;
        this.gromoreAdId = l3;
        this.gromoreBottomType = str12;
        this.gromoreBottomAdId = str13;
        this.warehouseSellerNotice = str14;
        this.creditRankIntro = str15;
    }

    @e
    public final String getAdOffer() {
        return this.adOffer;
    }

    @e
    public final String getAdSdkAppId() {
        return this.adSdkAppId;
    }

    @e
    public final String getCreditRankIntro() {
        return this.creditRankIntro;
    }

    @e
    public final Long getGromoreAdId() {
        return this.gromoreAdId;
    }

    @e
    public final String getGromoreBottomAdId() {
        return this.gromoreBottomAdId;
    }

    @e
    public final String getGromoreBottomType() {
        return this.gromoreBottomType;
    }

    @e
    public final String getImNotice() {
        return this.imNotice;
    }

    @e
    public final String getNewestVersion() {
        return this.newestVersion;
    }

    @e
    public final List<String> getOfficials() {
        return this.officials;
    }

    @e
    public final String getPk() {
        return this.pk;
    }

    @e
    public final String getPosterLink() {
        return this.posterLink;
    }

    @e
    public final String getPosterUrl() {
        return this.posterUrl;
    }

    @e
    public final Integer getShowUpdateContentType() {
        return this.showUpdateContentType;
    }

    @e
    public final String getSplashAdId() {
        return this.splashAdId;
    }

    @e
    public final Long getSplashAdShowInternal() {
        return this.splashAdShowInternal;
    }

    @e
    public final String getUpdateContent() {
        return this.updateContent;
    }

    @e
    public final String getUpdateRequestContent() {
        return this.updateRequestContent;
    }

    @e
    public final Integer getUpdateType() {
        return this.updateType;
    }

    @e
    public final String getWarehouseIntro() {
        return this.warehouseIntro;
    }

    @e
    public final String getWarehouseSellerNotice() {
        return this.warehouseSellerNotice;
    }

    public final void setAdOffer(@e String str) {
        this.adOffer = str;
    }

    public final void setAdSdkAppId(@e String str) {
        this.adSdkAppId = str;
    }

    public final void setCreditRankIntro(@e String str) {
        this.creditRankIntro = str;
    }

    public final void setGromoreAdId(@e Long l2) {
        this.gromoreAdId = l2;
    }

    public final void setGromoreBottomAdId(@e String str) {
        this.gromoreBottomAdId = str;
    }

    public final void setGromoreBottomType(@e String str) {
        this.gromoreBottomType = str;
    }

    public final void setImNotice(@e String str) {
        this.imNotice = str;
    }

    public final void setNewestVersion(@e String str) {
        this.newestVersion = str;
    }

    public final void setOfficials(@e List<String> list) {
        this.officials = list;
    }

    public final void setPk(@e String str) {
        this.pk = str;
    }

    public final void setPosterLink(@e String str) {
        this.posterLink = str;
    }

    public final void setPosterUrl(@e String str) {
        this.posterUrl = str;
    }

    public final void setShowUpdateContentType(@e Integer num) {
        this.showUpdateContentType = num;
    }

    public final void setSplashAdId(@e String str) {
        this.splashAdId = str;
    }

    public final void setSplashAdShowInternal(@e Long l2) {
        this.splashAdShowInternal = l2;
    }

    public final void setUpdateContent(@e String str) {
        this.updateContent = str;
    }

    public final void setUpdateRequestContent(@e String str) {
        this.updateRequestContent = str;
    }

    public final void setUpdateType(@e Integer num) {
        this.updateType = num;
    }

    public final void setWarehouseIntro(@e String str) {
        this.warehouseIntro = str;
    }

    public final void setWarehouseSellerNotice(@e String str) {
        this.warehouseSellerNotice = str;
    }

    public /* synthetic */ GlobalConfig(String str, String str2, List list, String str3, String str4, String str5, String str6, String str7, String str8, String str9, Integer num, String str10, Integer num2, String str11, Long l2, Long l3, String str12, String str13, String str14, String str15, int i2, u uVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2, (i2 & 4) != 0 ? null : list, (i2 & 8) != 0 ? null : str3, (i2 & 16) != 0 ? null : str4, (i2 & 32) != 0 ? null : str5, (i2 & 64) != 0 ? null : str6, (i2 & 128) != 0 ? null : str7, (i2 & 256) != 0 ? null : str8, (i2 & 512) != 0 ? null : str9, (i2 & 1024) != 0 ? null : num, (i2 & 2048) != 0 ? null : str10, (i2 & 4096) != 0 ? null : num2, (i2 & 8192) != 0 ? null : str11, (i2 & 16384) != 0 ? null : l2, (i2 & 32768) != 0 ? null : l3, (i2 & 65536) != 0 ? null : str12, (i2 & 131072) != 0 ? null : str13, (i2 & 262144) != 0 ? null : str14, (i2 & 524288) != 0 ? null : str15);
    }
}
