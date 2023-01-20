package com.jihuanshe.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.jihuanshe.R;
import com.jihuanshe.utils.StringUtil;
import com.vector.util.Res;
import e.j.e.r.a;
import h.k2.v.f0;
import h.r0;
import h.t1;
import i.c.c;
import java.text.DecimalFormat;
import java.util.Objects;
import k.e.a.d;
import k.e.a.e;
import kotlin.Result;

@c
/* loaded from: classes2.dex */
public final class Product implements Parcelable {
    @d
    public static final Parcelable.Creator<Product> CREATOR = new Creator();
    @e.j.e.r.c("card_version_count")
    @e
    private Integer cardCount;
    @e.j.e.r.c(Constants.KEY_PARAM_CARD_ID)
    @e
    private Integer cardId;
    @e.j.e.r.c("created_at")
    @e
    private String createTime;
    @a
    @e
    private Game game;
    @e.j.e.r.c(Constants.KEY_PARAM_GAME_KEY)
    @e
    private String gameKey;
    @e.j.e.r.c(Constants.KEY_PARAM_GAME_SUB_KEY)
    @e
    private String gameSubKey;
    @e.j.e.r.c(alternate = {"pack_id", "card_version_id"}, value = "id")
    @e
    private Integer id;
    @e.j.e.r.c("image_url")
    @e
    private String image;
    @e.j.e.r.c("is_desire")
    private boolean inWishList;
    @e.j.e.r.c("min_price")
    @e
    private String minPrice;
    @e.j.e.r.c("name_cn")
    @e
    private String nameCN;
    @e.j.e.r.c("name_origin")
    @e
    private String nameOri;
    @e.j.e.r.c("number")
    @e
    private String num;
    @e.j.e.r.c("rarity")
    @e
    private String rarity;
    @e.j.e.r.c("released_at")
    @e
    private String releaseTime;
    @e.j.e.r.c("grade")
    @e
    private String score;
    @e.j.e.r.c("game_pack_id")
    @e
    private String tempId;
    @e.j.e.r.c("type")
    @e
    private String type;
    @e.j.e.r.c("updated_at")
    @e
    private String updateTime;
    @a
    @d
    private String showTimeStr = "";
    @a
    @d
    private String groupMonth = "";
    @a
    @d
    private String belongGroup = "";
    @a
    private int groupIndex = -1;
    @a
    private boolean showScore = true;

    /* loaded from: classes2.dex */
    public static final class Creator implements Parcelable.Creator<Product> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @d
        public final Product createFromParcel(@d Parcel parcel) {
            parcel.readInt();
            return new Product();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @d
        public final Product[] newArray(int i2) {
            return new Product[i2];
        }
    }

    public static /* synthetic */ void getBelongGroup$annotations() {
    }

    public static /* synthetic */ void getGame$annotations() {
    }

    public static /* synthetic */ void getGroupIndex$annotations() {
    }

    public static /* synthetic */ void getGroupMonth$annotations() {
    }

    public static /* synthetic */ void getShowScore$annotations() {
    }

    public static /* synthetic */ void getShowTimeStr$annotations() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@e Object obj) {
        Integer num;
        String str;
        String str2;
        if (this == obj) {
            return true;
        }
        if (f0.g(Product.class, obj == null ? null : obj.getClass())) {
            Objects.requireNonNull(obj, "null cannot be cast to non-null type com.jihuanshe.model.Product");
            Product product = (Product) obj;
            String str3 = this.gameKey;
            if (str3 == null || f0.g(str3, product.gameKey)) {
                String str4 = this.gameSubKey;
                if (str4 == null || f0.g(str4, product.gameSubKey)) {
                    String str5 = this.tempId;
                    if (str5 == null || !f0.g(str5, product.tempId)) {
                        Integer num2 = this.id;
                        return (num2 == null || (num = product.id) == null || !f0.g(num2, num) || (str = this.type) == null || (str2 = product.type) == null || !f0.g(str, str2)) ? false : true;
                    }
                    return true;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public final int foregroundRes() {
        if (this.id == null) {
            return Res.k(R.color.black_f8f8fa);
        }
        return 0;
    }

    @d
    public final String getBelongGroup() {
        return this.belongGroup;
    }

    @e
    public final Integer getCardCount() {
        return this.cardCount;
    }

    @e
    public final Integer getCardId() {
        return this.cardId;
    }

    @e
    public final String getCountStr() {
        Integer num = this.cardCount;
        if (num == null) {
            return null;
        }
        return Res.a.v(R.string.common_card_count, String.valueOf(num));
    }

    @e
    public final String getCreateTime() {
        return this.createTime;
    }

    @e
    public final Game getGame() {
        return this.game;
    }

    @e
    public final String getGameKey() {
        return this.gameKey;
    }

    @e
    public final String getGameSubKey() {
        return this.gameSubKey;
    }

    public final int getGroupIndex() {
        return this.groupIndex;
    }

    @d
    public final String getGroupMonth() {
        return this.groupMonth;
    }

    @e
    public final Integer getId() {
        return this.id;
    }

    @e
    public final String getImage() {
        return this.image;
    }

    public final boolean getInWishList() {
        return this.inWishList;
    }

    @e
    public final String getMinPrice() {
        return this.minPrice;
    }

    @e
    public final String getNameCN() {
        return this.nameCN;
    }

    @e
    public final String getNameOri() {
        return this.nameOri;
    }

    @e
    public final String getNum() {
        return this.num;
    }

    @e
    public final String getNumberStr() {
        String str = this.num;
        if (str == null || str.length() == 0) {
            return null;
        }
        return this.num;
    }

    @d
    public final CharSequence getPrice() {
        float f2 = 0.0f;
        try {
            Result.a aVar = Result.Companion;
            String minPrice = getMinPrice();
            if (minPrice != null) {
                f2 = Float.parseFloat(minPrice);
            }
            Result.m106constructorimpl(t1.a);
        } catch (Throwable th) {
            Result.a aVar2 = Result.Companion;
            Result.m106constructorimpl(r0.a(th));
        }
        return StringUtil.c(StringUtil.a, f2, 0, false, 0, 0, true, 30, null);
    }

    @e
    public final String getRarity() {
        return this.rarity;
    }

    @e
    public final String getReleaseTime() {
        return this.releaseTime;
    }

    @e
    public final String getScore() {
        return this.score;
    }

    @e
    public final Float getScoreNum() {
        try {
            Result.a aVar = Result.Companion;
            String score = getScore();
            if (score == null) {
                return null;
            }
            return Float.valueOf(Float.parseFloat(score));
        } catch (Throwable th) {
            Result.a aVar2 = Result.Companion;
            Result.m106constructorimpl(r0.a(th));
            return null;
        }
    }

    @d
    public final String getScoreStr() {
        Float scoreNum = getScoreNum();
        if (scoreNum == null) {
            return "";
        }
        return new DecimalFormat("##.0").format(Float.valueOf(scoreNum.floatValue()));
    }

    public final boolean getShowScore() {
        return this.showScore;
    }

    @d
    public final String getShowTimeStr() {
        return this.showTimeStr;
    }

    @e
    public final String getSimpleCountStr() {
        Integer num = this.cardCount;
        if (num == null) {
            return null;
        }
        return Res.a.v(R.string.common_card_count_simple, String.valueOf(num));
    }

    @e
    public final String getTempId() {
        return this.tempId;
    }

    @e
    public final String getType() {
        return this.type;
    }

    @e
    public final String getUpdateTime() {
        return this.updateTime;
    }

    public int hashCode() {
        Integer num = this.id;
        int intValue = (num == null ? 0 : num.intValue()) * 31;
        String str = this.type;
        return intValue + (str != null ? str.hashCode() : 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0026 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0028 A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean isNoPrice() {
        /*
            r4 = this;
            r0 = 0
            kotlin.Result$a r1 = kotlin.Result.Companion     // Catch: java.lang.Throwable -> L17
            java.lang.String r1 = r4.getMinPrice()     // Catch: java.lang.Throwable -> L17
            if (r1 != 0) goto Lb
            r1 = 0
            goto Lf
        Lb:
            float r1 = java.lang.Float.parseFloat(r1)     // Catch: java.lang.Throwable -> L17
        Lf:
            h.t1 r2 = h.t1.a     // Catch: java.lang.Throwable -> L15
            kotlin.Result.m106constructorimpl(r2)     // Catch: java.lang.Throwable -> L15
            goto L22
        L15:
            r2 = move-exception
            goto L19
        L17:
            r2 = move-exception
            r1 = 0
        L19:
            kotlin.Result$a r3 = kotlin.Result.Companion
            java.lang.Object r2 = h.r0.a(r2)
            kotlin.Result.m106constructorimpl(r2)
        L22:
            int r0 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1))
            if (r0 != 0) goto L28
            r0 = 1
            goto L29
        L28:
            r0 = 0
        L29:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jihuanshe.model.Product.isNoPrice():boolean");
    }

    public final void setBelongGroup(@d String str) {
        this.belongGroup = str;
    }

    public final void setCardCount(@e Integer num) {
        this.cardCount = num;
    }

    public final void setCardId(@e Integer num) {
        this.cardId = num;
    }

    public final void setCreateTime(@e String str) {
        this.createTime = str;
    }

    public final void setGame(@e Game game) {
        this.game = game;
    }

    public final void setGameKey(@e String str) {
        this.gameKey = str;
    }

    public final void setGameSubKey(@e String str) {
        this.gameSubKey = str;
    }

    public final void setGroupIndex(int i2) {
        this.groupIndex = i2;
    }

    public final void setGroupMonth(@d String str) {
        this.groupMonth = str;
    }

    public final void setId(@e Integer num) {
        this.id = num;
    }

    public final void setImage(@e String str) {
        this.image = str;
    }

    public final void setInWishList(boolean z) {
        this.inWishList = z;
    }

    public final void setMinPrice(@e String str) {
        this.minPrice = str;
    }

    public final void setNameCN(@e String str) {
        this.nameCN = str;
    }

    public final void setNameOri(@e String str) {
        this.nameOri = str;
    }

    public final void setNum(@e String str) {
        this.num = str;
    }

    public final void setRarity(@e String str) {
        this.rarity = str;
    }

    public final void setReleaseTime(@e String str) {
        this.releaseTime = str;
    }

    public final void setScore(@e String str) {
        this.score = str;
    }

    public final void setShowScore(boolean z) {
        this.showScore = z;
    }

    public final void setShowTimeStr(@d String str) {
        this.showTimeStr = str;
    }

    public final void setTempId(@e String str) {
        this.tempId = str;
    }

    public final void setType(@e String str) {
        this.type = str;
    }

    public final void setUpdateTime(@e String str) {
        this.updateTime = str;
    }

    public final void updateData(@d Product product) {
        this.id = product.id;
        this.nameCN = product.nameCN;
        this.nameOri = product.nameOri;
        String str = product.type;
        if (str == null) {
            str = Constants.Companion.getTYPE_PACK();
        }
        this.type = str;
        String str2 = product.gameKey;
        this.gameKey = str2;
        String str3 = product.gameSubKey;
        this.gameSubKey = str3;
        this.num = product.num;
        this.rarity = product.rarity;
        this.image = product.image;
        this.cardCount = product.cardCount;
        this.score = product.score;
        this.minPrice = product.minPrice;
        this.inWishList = product.inWishList;
        this.game = e.l.l.a.b(str2, str3);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@d Parcel parcel, int i2) {
        parcel.writeInt(1);
    }
}
