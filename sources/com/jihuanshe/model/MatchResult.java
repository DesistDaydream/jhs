package com.jihuanshe.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.SuperscriptSpan;
import androidx.exifinterface.media.ExifInterface;
import com.jihuanshe.R;
import com.jihuanshe.utils.StringUtil;
import e.j.e.r.a;
import h.k2.v.f0;
import h.k2.v.u;
import i.c.c;
import java.util.List;
import k.e.a.d;
import k.e.a.e;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.text.StringsKt__StringsKt;

@c
/* loaded from: classes2.dex */
public final class MatchResult implements Parcelable {
    @d
    public static final Parcelable.Creator<MatchResult> CREATOR = new Creator();
    @e.j.e.r.c("seller_avatar")
    @e
    private final String avatar;
    @e.j.e.r.c("cards")
    @e
    private final List<String> cards;
    @e.j.e.r.c("seller_setting_city")
    @e
    private final String city;
    @e.j.e.r.c("seller_quantity")
    @e
    private final Integer count;
    @e.j.e.r.c("card_version_image")
    @e
    private final String cover;
    @e.j.e.r.c("seller_credit_rank")
    @e
    private String creditRank;
    @a
    @e
    private Game game;
    @e.j.e.r.c("seller_username")
    @e
    private final String name;
    @e.j.e.r.c("seller_price")
    @e
    private final Float price;
    @e.j.e.r.c("seller_setting_province")
    @e
    private final String province;
    @e.j.e.r.c("seller_user_id")
    @e
    private final Integer uid;

    /* loaded from: classes2.dex */
    public static final class Creator implements Parcelable.Creator<MatchResult> {
        @Override // android.os.Parcelable.Creator
        @d
        public final MatchResult createFromParcel(@d Parcel parcel) {
            return new MatchResult(parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : Float.valueOf(parcel.readFloat()), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readString(), parcel.createStringArrayList(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        @d
        public final MatchResult[] newArray(int i2) {
            return new MatchResult[i2];
        }
    }

    public MatchResult() {
        this(null, null, null, null, null, null, null, null, null, null, 1023, null);
    }

    public MatchResult(@e Integer num, @e String str, @e String str2, @e String str3, @e String str4, @e Float f2, @e Integer num2, @e String str5, @e List<String> list, @e String str6) {
        this.uid = num;
        this.name = str;
        this.avatar = str2;
        this.province = str3;
        this.city = str4;
        this.price = f2;
        this.count = num2;
        this.cover = str5;
        this.cards = list;
        this.creditRank = str6;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @e
    public final String getAvatar() {
        return this.avatar;
    }

    @e
    public final List<String> getCards() {
        return this.cards;
    }

    @e
    public final String getCity() {
        return this.city;
    }

    @e
    public final Integer getCount() {
        return this.count;
    }

    @d
    public final CharSequence getCountStr() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.count);
        sb.append((char) 24352);
        String sb2 = sb.toString();
        int r3 = StringsKt__StringsKt.r3(sb2, "张", 0, false, 6, null);
        SpannableString spannableString = new SpannableString(sb2);
        spannableString.setSpan(new AbsoluteSizeSpan(8, true), r3, spannableString.length(), 18);
        spannableString.setSpan(new SuperscriptSpan(), r3, spannableString.length(), 17);
        return spannableString;
    }

    @e
    public final String getCover() {
        return this.cover;
    }

    @e
    public final String getCreditRank() {
        return this.creditRank;
    }

    @e
    public final Integer getCreditRankDrawable() {
        String str = this.creditRank;
        if (str != null) {
            int hashCode = str.hashCode();
            if (hashCode != 83) {
                if (hashCode != 2656) {
                    if (hashCode != 1554081906) {
                        switch (hashCode) {
                            case 65:
                                if (str.equals(ExifInterface.GPS_MEASUREMENT_IN_PROGRESS)) {
                                    return Integer.valueOf((int) R.drawable.svg_credit_rank_a);
                                }
                                break;
                            case 66:
                                if (str.equals("B")) {
                                    return Integer.valueOf((int) R.drawable.svg_credit_rank_b);
                                }
                                break;
                            case 67:
                                if (str.equals("C")) {
                                    return Integer.valueOf((int) R.drawable.svg_credit_rank_c);
                                }
                                break;
                            case 68:
                                if (str.equals("D")) {
                                    return Integer.valueOf((int) R.drawable.svg_credit_rank_d);
                                }
                                break;
                        }
                    } else if (str.equals("Beginner")) {
                        return Integer.valueOf((int) R.drawable.svg_credit_rank_beginner);
                    }
                } else if (str.equals("SS")) {
                    return Integer.valueOf((int) R.drawable.svg_credit_rank_ss);
                }
            } else if (str.equals(ExifInterface.LATITUDE_SOUTH)) {
                return Integer.valueOf((int) R.drawable.svg_credit_rank_s);
            }
        }
        return null;
    }

    @e
    public final Game getGame() {
        return this.game;
    }

    @d
    public final String getLocationStr() {
        return f0.C(this.province, this.city);
    }

    @e
    public final String getName() {
        return this.name;
    }

    @e
    public final Float getPrice() {
        return this.price;
    }

    @d
    public final CharSequence getPriceStr() {
        StringUtil stringUtil = StringUtil.a;
        Float f2 = this.price;
        return StringUtil.c(stringUtil, f2 == null ? 0.0f : f2.floatValue(), R.string.shop_price, true, 0, 0, false, 56, null);
    }

    @e
    public final String getProvince() {
        return this.province;
    }

    @d
    public final String getTitle() {
        List<String> list = this.cards;
        return list == null || list.isEmpty() ? "" : CollectionsKt___CollectionsKt.Z2(this.cards, com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP, null, null, 0, null, null, 62, null);
    }

    @e
    public final Integer getUid() {
        return this.uid;
    }

    public final void setCreditRank(@e String str) {
        this.creditRank = str;
    }

    public final void setGame(@e Game game) {
        this.game = game;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@d Parcel parcel, int i2) {
        Integer num = this.uid;
        if (num == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num.intValue());
        }
        parcel.writeString(this.name);
        parcel.writeString(this.avatar);
        parcel.writeString(this.province);
        parcel.writeString(this.city);
        Float f2 = this.price;
        if (f2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeFloat(f2.floatValue());
        }
        Integer num2 = this.count;
        if (num2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num2.intValue());
        }
        parcel.writeString(this.cover);
        parcel.writeStringList(this.cards);
        parcel.writeString(this.creditRank);
    }

    public /* synthetic */ MatchResult(Integer num, String str, String str2, String str3, String str4, Float f2, Integer num2, String str5, List list, String str6, int i2, u uVar) {
        this((i2 & 1) != 0 ? null : num, (i2 & 2) != 0 ? null : str, (i2 & 4) != 0 ? null : str2, (i2 & 8) != 0 ? null : str3, (i2 & 16) != 0 ? null : str4, (i2 & 32) != 0 ? null : f2, (i2 & 64) != 0 ? null : num2, (i2 & 128) != 0 ? null : str5, (i2 & 256) != 0 ? null : list, (i2 & 512) == 0 ? str6 : null);
    }
}
