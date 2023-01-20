package com.jihuanshe.model;

import com.bytedance.msdk.adapter.pangle.PangleAdapterUtils;
import com.jihuanshe.R;
import com.vector.util.Res;
import e.l.s.a;
import h.k2.v.u;
import java.util.List;
import k.e.a.d;
import k.e.a.e;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;

/* loaded from: classes2.dex */
public final class Constants {
    @d
    private static final List<Integer> BLUE_THEME;
    @d
    private static final List<Integer> BROWN_THEME;
    @d
    private static final List<String> ERROR_CORRECTION;
    @d
    private static final a FILTER_INFO_NEWEST;
    @d
    private static final a FILTER_INFO_PRICE_ASC;
    @d
    private static final a FILTER_INFO_PRICE_DESC;
    @d
    private static final a FILTER_MATCH;
    @d
    private static final a FILTER_MATCH_IGNORE_VERSION;
    @d
    private static final List<a> FILTER_NEWEST;
    @d
    private static final a FILTER_NUMBER;
    @d
    private static final List<a> FILTER_SELLER;
    @d
    private static final List<a> FILTER_SORTING;
    @d
    private static final List<String> FILTER_TYPE;
    @d
    private static final List<Integer> GREEN_THEME;
    @d
    public static final String KEY_PARAM_CARD_ID = "card_id";
    @d
    public static final String KEY_PARAM_CARD_VERSION_ID = "version_id";
    @d
    public static final String KEY_PARAM_GAME = "game";
    @d
    public static final String KEY_PARAM_GAME_KEY = "game_key";
    @d
    public static final String KEY_PARAM_GAME_SUB_KEY = "game_sub_key";
    @d
    public static final String KEY_PARAM_PRODUCT_ID = "product_id";
    @d
    public static final String KEY_PARAM_RESULT = "result";
    @d
    public static final String KEY_PARAM_USER_ID = "uid";
    @d
    private static final List<Pair<String, String>> PRICE_TYPE;
    public static final int PRICE_TYPE_BUY_MIN = 2;
    public static final int PRICE_TYPE_NORMAL = 0;
    public static final int PRICE_TYPE_SELL_MIN = 1;
    @d
    private static final List<String> REPORT_SELLER_REASON;
    @d
    private static final List<String> SCORE_CONTENT_CARD;
    @d
    private static final List<String> SCORE_CONTENT_PACK;
    @e
    private static final Void SEARCH_TYPE_ALL = null;
    @d
    private static final String SEARCH_TYPE_CARD;
    @d
    private static final String SEARCH_TYPE_PACK;
    @d
    private static final String SHOP_CAR_ACTIVITY;
    @d
    private static final List<Pair<String, String>> SORTING;
    @d
    private static final List<Pair<String, String>> SORTING_NEWEST;
    @d
    private static final List<Pair<String, String>> SORTING_SELLER;
    @d
    private static final List<Pair<String, String>> SORT_TYPE_REVIEW;
    @d
    public static final String STATE_PENDING = "pending";
    @d
    public static final String STATE_SENT = "sent";
    @d
    public static final String STATE_WAITING_PAY = "waiting_to_pay";
    @d
    private static final String TYPE_CARD;
    @d
    private static final String TYPE_PACK;
    @d
    public static final Companion Companion = new Companion(null);
    private static final int WAREHOUSE_SELLER_USER_ID = 1000;
    private static final int CATEGORY_ID = 99998;
    private static final int CATEGORY_DIVIDER_ID = -1;
    private static final int TYPE_CHILD = 1;
    private static final int TYPE_CP = 2;
    private static final int TYPE_NEWEST = 3;
    private static final int TYPE_SELLER = 4;
    private static final int TYPE_WAREHOUSE_SELLER = 5;
    @d
    private static final CardPackage newestProduct = new CardPackage(3, 0, null, null, null, 0, null, null, 0, null);
    @d
    private static final Category category = new Category(99998, "集换仓", 3, null);
    @d
    private static final Category categoryDivider = new Category(-1, "", 4, null);

    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(u uVar) {
            this();
        }

        @d
        public final List<Integer> getBLUE_THEME() {
            return Constants.BLUE_THEME;
        }

        @d
        public final List<Integer> getBROWN_THEME() {
            return Constants.BROWN_THEME;
        }

        public final int getCATEGORY_DIVIDER_ID() {
            return Constants.CATEGORY_DIVIDER_ID;
        }

        public final int getCATEGORY_ID() {
            return Constants.CATEGORY_ID;
        }

        @d
        public final Category getCategory() {
            return Constants.category;
        }

        @d
        public final Category getCategoryDivider() {
            return Constants.categoryDivider;
        }

        @d
        public final List<String> getERROR_CORRECTION() {
            return Constants.ERROR_CORRECTION;
        }

        @d
        public final a getFILTER_INFO_NEWEST() {
            return Constants.FILTER_INFO_NEWEST;
        }

        @d
        public final a getFILTER_INFO_PRICE_ASC() {
            return Constants.FILTER_INFO_PRICE_ASC;
        }

        @d
        public final a getFILTER_INFO_PRICE_DESC() {
            return Constants.FILTER_INFO_PRICE_DESC;
        }

        @d
        public final a getFILTER_MATCH() {
            return Constants.FILTER_MATCH;
        }

        @d
        public final a getFILTER_MATCH_IGNORE_VERSION() {
            return Constants.FILTER_MATCH_IGNORE_VERSION;
        }

        @d
        public final List<a> getFILTER_NEWEST() {
            return Constants.FILTER_NEWEST;
        }

        @d
        public final a getFILTER_NUMBER() {
            return Constants.FILTER_NUMBER;
        }

        @d
        public final List<a> getFILTER_SELLER() {
            return Constants.FILTER_SELLER;
        }

        @d
        public final List<a> getFILTER_SORTING() {
            return Constants.FILTER_SORTING;
        }

        @d
        public final List<String> getFILTER_TYPE() {
            return Constants.FILTER_TYPE;
        }

        @d
        public final List<Integer> getGREEN_THEME() {
            return Constants.GREEN_THEME;
        }

        @d
        public final CardPackage getNewestProduct() {
            return Constants.newestProduct;
        }

        @d
        public final List<Pair<String, String>> getPRICE_TYPE() {
            return Constants.PRICE_TYPE;
        }

        @d
        public final List<String> getREPORT_SELLER_REASON() {
            return Constants.REPORT_SELLER_REASON;
        }

        @d
        public final List<String> getSCORE_CONTENT_CARD() {
            return Constants.SCORE_CONTENT_CARD;
        }

        @d
        public final List<String> getSCORE_CONTENT_PACK() {
            return Constants.SCORE_CONTENT_PACK;
        }

        @e
        public final Void getSEARCH_TYPE_ALL() {
            return Constants.SEARCH_TYPE_ALL;
        }

        @d
        public final String getSEARCH_TYPE_CARD() {
            return Constants.SEARCH_TYPE_CARD;
        }

        @d
        public final String getSEARCH_TYPE_PACK() {
            return Constants.SEARCH_TYPE_PACK;
        }

        @d
        public final String getSHOP_CAR_ACTIVITY() {
            return Constants.SHOP_CAR_ACTIVITY;
        }

        @d
        public final List<Pair<String, String>> getSORTING() {
            return Constants.SORTING;
        }

        @d
        public final List<Pair<String, String>> getSORTING_NEWEST() {
            return Constants.SORTING_NEWEST;
        }

        @d
        public final List<Pair<String, String>> getSORTING_SELLER() {
            return Constants.SORTING_SELLER;
        }

        @d
        public final List<Pair<String, String>> getSORT_TYPE_REVIEW() {
            return Constants.SORT_TYPE_REVIEW;
        }

        @d
        public final String getTYPE_CARD() {
            return Constants.TYPE_CARD;
        }

        public final int getTYPE_CHILD() {
            return Constants.TYPE_CHILD;
        }

        public final int getTYPE_CP() {
            return Constants.TYPE_CP;
        }

        public final int getTYPE_NEWEST() {
            return Constants.TYPE_NEWEST;
        }

        @d
        public final String getTYPE_PACK() {
            return Constants.TYPE_PACK;
        }

        public final int getTYPE_SELLER() {
            return Constants.TYPE_SELLER;
        }

        public final int getTYPE_WAREHOUSE_SELLER() {
            return Constants.TYPE_WAREHOUSE_SELLER;
        }

        public final int getWAREHOUSE_SELLER_USER_ID() {
            return Constants.WAREHOUSE_SELLER_USER_ID;
        }
    }

    static {
        a aVar = new a("最新发布", "published_at_desc");
        FILTER_INFO_NEWEST = aVar;
        a aVar2 = new a("编号排序", "number");
        FILTER_NUMBER = aVar2;
        a aVar3 = new a("价钱低到高", "price_asc");
        FILTER_INFO_PRICE_ASC = aVar3;
        a aVar4 = new a("价钱高到低", "price_desc");
        FILTER_INFO_PRICE_DESC = aVar4;
        a aVar5 = new a("匹配优先", "match");
        FILTER_MATCH = aVar5;
        a aVar6 = new a("匹配优先（任意版本）", "match_ignore_card_version");
        FILTER_MATCH_IGNORE_VERSION = aVar6;
        FILTER_NEWEST = CollectionsKt__CollectionsKt.P(aVar, aVar3, aVar4);
        FILTER_SORTING = CollectionsKt__CollectionsKt.P(aVar2, aVar3, aVar4);
        FILTER_SELLER = CollectionsKt__CollectionsKt.P(aVar, aVar5, aVar6, aVar3, aVar4);
        SORTING_NEWEST = CollectionsKt__CollectionsKt.P(new Pair("最新发布", "published_at_desc"), new Pair("价钱低到高", "price_asc"), new Pair("价钱高到低", "price_desc"));
        SORTING_SELLER = CollectionsKt__CollectionsKt.P(new Pair("最新发布", "published_at_desc"), new Pair("匹配优先", "match"), new Pair("匹配优先（任意版本）", "match_ignore_card_version"), new Pair("价钱低到高", "price_asc"), new Pair("价钱高到低", "price_desc"));
        SORTING = CollectionsKt__CollectionsKt.P(new Pair("编号排序", "number"), new Pair("价钱低到高", "price_asc"), new Pair("价钱高到低", "price_desc"));
        PRICE_TYPE = CollectionsKt__CollectionsKt.P(new Pair("在售", PangleAdapterUtils.MEDIA_EXTRA_PRODUCT), new Pair("求购", "wish"));
        ERROR_CORRECTION = CollectionsKt__CollectionsKt.P("卡牌信息错误", "卡图错误", "卡图缺失或不完整", "其他");
        Res res = Res.a;
        REPORT_SELLER_REASON = CollectionsKt__CollectionsKt.P(Res.w(res, R.string.report_reason_1, null, 2, null), Res.w(res, R.string.report_reason_2, null, 2, null), Res.w(res, R.string.report_reason_3, null, 2, null), Res.w(res, R.string.report_reason_4, null, 2, null), Res.w(res, R.string.report_reason_5, null, 2, null), Res.w(res, R.string.report_reason_6, null, 2, null));
        FILTER_TYPE = CollectionsKt__CollectionsKt.P(null, "all", "1_month", "3_month", "6_month", "this_year", "1_year");
        SORT_TYPE_REVIEW = CollectionsKt__CollectionsKt.P(new Pair("热门排序", "like_count"), new Pair("最新排序", "id_desc"));
        SCORE_CONTENT_CARD = CollectionsKt__CollectionsKt.P("为卡牌评分", "很讨厌", "不喜欢", "感觉还行", "挺不错", "非常棒");
        SCORE_CONTENT_PACK = CollectionsKt__CollectionsKt.P("为系列评分", "很讨厌", "不喜欢", "感觉还行", "挺不错", "非常棒");
        BROWN_THEME = CollectionsKt__CollectionsKt.P(Integer.valueOf((int) R.drawable.rank_brown_top), Integer.valueOf((int) R.color.theme_676366), Integer.valueOf((int) R.drawable.rank_brown_desc_18), Integer.valueOf((int) R.color.tv_show_detail));
        BLUE_THEME = CollectionsKt__CollectionsKt.P(Integer.valueOf((int) R.drawable.rank_blue_top), Integer.valueOf((int) R.color.theme_686B71), Integer.valueOf((int) R.drawable.rank_biue_desc_18), Integer.valueOf((int) R.color.rank_bg));
        GREEN_THEME = CollectionsKt__CollectionsKt.P(Integer.valueOf((int) R.drawable.rank_green_top), Integer.valueOf((int) R.color.rank_tab_696e6d), Integer.valueOf((int) R.drawable.rank_green_desc_18), Integer.valueOf((int) R.color.theme_4F5A4B));
        SEARCH_TYPE_CARD = "card_version";
        SEARCH_TYPE_PACK = "pack";
        TYPE_CARD = "card_version";
        TYPE_PACK = "pack";
        SHOP_CAR_ACTIVITY = "shop_car_activity";
    }
}
