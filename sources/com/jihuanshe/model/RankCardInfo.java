package com.jihuanshe.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.jihuanshe.R;
import com.jihuanshe.utils.StringUtil;
import com.vector.util.Res;
import e.j.e.r.a;
import h.k2.v.f0;
import h.k2.v.u;
import h.r0;
import h.t1;
import i.c.c;
import java.util.Objects;
import k.e.a.d;
import k.e.a.e;
import kotlin.Result;

@c
/* loaded from: classes2.dex */
public final class RankCardInfo implements Parcelable {
    @d
    public static final Parcelable.Creator<RankCardInfo> CREATOR = new Creator();
    @e.j.e.r.c(Constants.KEY_PARAM_CARD_ID)
    private final int cardId;
    @e.j.e.r.c("card_version_count")
    @e
    private Integer cardVersionCount;
    @e.j.e.r.c("change")
    @d
    private final String change;
    @e.j.e.r.c("created_at")
    @d
    private final String createdAt;
    @a
    @e
    private Game game;
    @e.j.e.r.c(Constants.KEY_PARAM_GAME_KEY)
    @d
    private final String gameKey;
    @e.j.e.r.c(Constants.KEY_PARAM_GAME_SUB_KEY)
    @d
    private final String gameSubKey;
    @e.j.e.r.c("grade")
    @e
    private String grade;
    @e.j.e.r.c("id")
    private final int id;
    @e.j.e.r.c("image_url")
    @d
    private String imageURL;
    @e.j.e.r.c("min_price")
    @e
    private String minPrice;
    @e.j.e.r.c("name_cn")
    @e
    private final String nameCN;
    @e.j.e.r.c("name_origin")
    @e
    private String nameOrigin;
    @e.j.e.r.c("number")
    @e
    private String number;
    @e.j.e.r.c("rank")
    @e
    private Integer rank;
    @e.j.e.r.c("rarity")
    @e
    private String rarity;
    @e.j.e.r.c("type")
    @d
    private String type;
    @e.j.e.r.c("updated_at")
    @d
    private final String updatedAt;

    /* loaded from: classes2.dex */
    public static final class Creator implements Parcelable.Creator<RankCardInfo> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @d
        public final RankCardInfo createFromParcel(@d Parcel parcel) {
            return new RankCardInfo(parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @d
        public final RankCardInfo[] newArray(int i2) {
            return new RankCardInfo[i2];
        }
    }

    public RankCardInfo(@e Integer num, @d String str, @d String str2, @d String str3, @d String str4, @e String str5, int i2, int i3, @d String str6, @e String str7, @e String str8, @e String str9, @e String str10, @e Integer num2, @e String str11, @d String str12, @d String str13) {
        this.cardVersionCount = num;
        this.change = str;
        this.createdAt = str2;
        this.gameKey = str3;
        this.gameSubKey = str4;
        this.grade = str5;
        this.id = i2;
        this.cardId = i3;
        this.imageURL = str6;
        this.minPrice = str7;
        this.nameCN = str8;
        this.nameOrigin = str9;
        this.number = str10;
        this.rank = num2;
        this.rarity = str11;
        this.type = str12;
        this.updatedAt = str13;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@e Object obj) {
        String str;
        String str2;
        if (this == obj) {
            return true;
        }
        if (f0.g(RankCardInfo.class, obj == null ? null : obj.getClass())) {
            Objects.requireNonNull(obj, "null cannot be cast to non-null type com.jihuanshe.model.RankCardInfo");
            RankCardInfo rankCardInfo = (RankCardInfo) obj;
            return this.id == rankCardInfo.id && (str = this.type) != null && (str2 = rankCardInfo.type) != null && f0.g(str, str2);
        }
        return false;
    }

    public final int getCardId() {
        return this.cardId;
    }

    @e
    public final Integer getCardVersionCount() {
        return this.cardVersionCount;
    }

    @d
    public final String getCardVersionCountStr() {
        return "卡数: " + this.cardVersionCount + (char) 24352;
    }

    @d
    public final String getChange() {
        return this.change;
    }

    @d
    public final String getCreatedAt() {
        return this.createdAt;
    }

    @e
    public final Game getGame() {
        return this.game;
    }

    @d
    public final String getGameKey() {
        return this.gameKey;
    }

    @d
    public final String getGameName() {
        Game game = this.game;
        String name = game == null ? null : game.getName();
        return name != null ? name : "";
    }

    @d
    public final String getGameSubKey() {
        return this.gameSubKey;
    }

    @e
    public final String getGrade() {
        return this.grade;
    }

    public final int getId() {
        return this.id;
    }

    @d
    public final String getImageURL() {
        return this.imageURL;
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
    public final String getNameOrigin() {
        return this.nameOrigin;
    }

    @e
    public final String getNumber() {
        return this.number;
    }

    @d
    public final CharSequence getPriceStr() {
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
        return StringUtil.c(StringUtil.a, f2, 0, false, 0, 0, false, 62, null);
    }

    @e
    public final Integer getRank() {
        return this.rank;
    }

    @d
    public final String getRankStr() {
        return String.valueOf(this.rank);
    }

    @e
    public final String getRarity() {
        return this.rarity;
    }

    @e
    public final Float getScoreNum() {
        try {
            Result.a aVar = Result.Companion;
            String grade = getGrade();
            if (grade == null) {
                return null;
            }
            return Float.valueOf(Float.parseFloat(grade));
        } catch (Throwable th) {
            Result.a aVar2 = Result.Companion;
            Result.m106constructorimpl(r0.a(th));
            return null;
        }
    }

    public final int getSrcId() {
        String str = this.change;
        int hashCode = str.hashCode();
        if (hashCode != -892499141) {
            return hashCode != 3739 ? (hashCode == 3089570 && str.equals("down")) ? R.drawable.svg_rank_down : R.drawable.svg_rank_stable : !str.equals("up") ? R.drawable.svg_rank_stable : R.drawable.svg_rank_up;
        }
        str.equals("stable");
        return R.drawable.svg_rank_stable;
    }

    public final int getTintColor() {
        String str = this.change;
        int hashCode = str.hashCode();
        if (hashCode != -892499141) {
            if (hashCode != 3739) {
                if (hashCode == 3089570 && str.equals("down")) {
                    return Res.k(R.color.green_00b445);
                }
            } else if (str.equals("up")) {
                return Res.k(R.color.red);
            }
        } else if (str.equals("stable")) {
            return Res.k(R.color.black_b5b5b7);
        }
        return Res.k(R.color.black_b5b5b7);
    }

    @d
    public final String getType() {
        return this.type;
    }

    @d
    public final String getUpdatedAt() {
        return this.updatedAt;
    }

    public int hashCode() {
        return (this.id * 31) + this.type.hashCode();
    }

    public final void setCardVersionCount(@e Integer num) {
        this.cardVersionCount = num;
    }

    public final void setGame(@e Game game) {
        this.game = game;
    }

    public final void setGrade(@e String str) {
        this.grade = str;
    }

    public final void setImageURL(@d String str) {
        this.imageURL = str;
    }

    public final void setMinPrice(@e String str) {
        this.minPrice = str;
    }

    public final void setNameOrigin(@e String str) {
        this.nameOrigin = str;
    }

    public final void setNumber(@e String str) {
        this.number = str;
    }

    public final void setRank(@e Integer num) {
        this.rank = num;
    }

    public final void setRarity(@e String str) {
        this.rarity = str;
    }

    public final void setType(@d String str) {
        this.type = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@d Parcel parcel, int i2) {
        Integer num = this.cardVersionCount;
        if (num == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num.intValue());
        }
        parcel.writeString(this.change);
        parcel.writeString(this.createdAt);
        parcel.writeString(this.gameKey);
        parcel.writeString(this.gameSubKey);
        parcel.writeString(this.grade);
        parcel.writeInt(this.id);
        parcel.writeInt(this.cardId);
        parcel.writeString(this.imageURL);
        parcel.writeString(this.minPrice);
        parcel.writeString(this.nameCN);
        parcel.writeString(this.nameOrigin);
        parcel.writeString(this.number);
        Integer num2 = this.rank;
        if (num2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num2.intValue());
        }
        parcel.writeString(this.rarity);
        parcel.writeString(this.type);
        parcel.writeString(this.updatedAt);
    }

    public /* synthetic */ RankCardInfo(Integer num, String str, String str2, String str3, String str4, String str5, int i2, int i3, String str6, String str7, String str8, String str9, String str10, Integer num2, String str11, String str12, String str13, int i4, u uVar) {
        this((i4 & 1) != 0 ? null : num, str, str2, str3, str4, (i4 & 32) != 0 ? "" : str5, i2, i3, str6, (i4 & 512) != 0 ? null : str7, (i4 & 1024) != 0 ? null : str8, (i4 & 2048) != 0 ? null : str9, (i4 & 4096) != 0 ? "" : str10, (i4 & 8192) != 0 ? 0 : num2, (i4 & 16384) != 0 ? null : str11, str12, str13);
    }
}
