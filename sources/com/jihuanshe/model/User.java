package com.jihuanshe.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.exifinterface.media.ExifInterface;
import com.jihuanshe.R;
import com.jihuanshe.utils.StringUtil;
import com.moor.imkf.IMChatManager;
import com.vector.util.Res;
import h.k2.v.f0;
import i.b.w3.v;
import i.c.c;
import java.util.ArrayList;
import java.util.List;
import k.e.a.d;
import k.e.a.e;

@c
/* loaded from: classes2.dex */
public final class User implements Parcelable {
    @d
    public static final Parcelable.Creator<User> CREATOR = new Creator();
    @e.j.e.r.c("setting_district")
    @e
    private String area;
    @e.j.e.r.c(alternate = {"following_user_avatar", "follower_user_avatar"}, value = "avatar")
    @e
    private String avatar;
    @e.j.e.r.c("balance")
    private float balance;
    @e.j.e.r.c("setting_city")
    @e
    private String city;
    @e.j.e.r.c("setting_country")
    @e
    private String country;
    @e.j.e.r.c("seller_credit_rank")
    @e
    private String creditRank;
    @e.j.e.r.c("current_month_revenue")
    private float currentMonthRevenue;
    @e.j.e.r.c("is_follow")
    @e
    private Boolean followed;
    @e.j.e.r.c(alternate = {"following_user_follower_count", "follower_user_follower_count"}, value = "follower_count")
    private final int followerNum;
    @e.j.e.r.c("free_shipping_amount")
    @e
    private String freeShippingNum;
    @e.j.e.r.c(alternate = {"following_user_id", "follower_user_id", "id"}, value = "user_id")
    private int id;
    @e.j.e.r.c("is_register")
    private int isReg;
    @e.j.e.r.c("last_login_seconds")
    private final long lastLogin;
    @e.j.e.r.c("last_month_revenue")
    private float lastMonthRevenue;
    @e.j.e.r.c(alternate = {"following_user_username", "follower_user_username"}, value = IMChatManager.CONSTANT_USERNAME)
    @e
    private String name;
    @e.j.e.r.c("ecommerce_verify")
    @e
    private final Boolean nameVerify;
    @e.j.e.r.c("etiquette_question_complete")
    @e
    private Boolean needExam;
    @e.j.e.r.c("success_order_user_count")
    private final int orderSucNum;
    @e.j.e.r.c("phone")
    @e
    private String phone;
    @e.j.e.r.c("setting_province")
    @e
    private String province;
    @e.j.e.r.c("rarities")
    @e
    private final List<List<String>> rarities;
    @e.j.e.r.c(alternate = {"following_user_seller_bio", "follower_user_seller_bio"}, value = "seller_bio")
    @e
    private String sellerBio;
    @e.j.e.r.c("shipping_price")
    @d
    private String shipping;
    @e.j.e.r.c("user_sig")
    @e
    private String sig;
    @e.j.e.r.c("tech_fee_rate")
    @e
    private String techFeeRate;
    @e.j.e.r.c("token")
    @e
    private String token;
    @e.j.e.r.c("trans_fee_rate")
    @e
    private String transFeeRate;
    @e.j.e.r.c(alternate = {"following_user_verify_status", "follower_user_verify_status"}, value = "verify_status")
    @e
    private Integer verifyStatus;
    @e.j.e.r.c("warehouse")
    @e
    private final Boolean warehouse;
    @e.j.e.r.c("wish_rarities")
    @e
    private final List<List<String>> wishRarities;

    /* loaded from: classes2.dex */
    public static final class Creator implements Parcelable.Creator<User> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @d
        public final User createFromParcel(@d Parcel parcel) {
            ArrayList arrayList;
            ArrayList arrayList2;
            int readInt = parcel.readInt();
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            String readString5 = parcel.readString();
            String readString6 = parcel.readString();
            String readString7 = parcel.readString();
            String readString8 = parcel.readString();
            Integer valueOf = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            long readLong = parcel.readLong();
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int readInt2 = parcel.readInt();
                arrayList = new ArrayList(readInt2);
                for (int i2 = 0; i2 != readInt2; i2++) {
                    arrayList.add(parcel.createStringArrayList());
                }
            }
            if (parcel.readInt() == 0) {
                arrayList2 = null;
            } else {
                int readInt3 = parcel.readInt();
                ArrayList arrayList3 = new ArrayList(readInt3);
                int i3 = 0;
                while (i3 != readInt3) {
                    arrayList3.add(parcel.createStringArrayList());
                    i3++;
                    readInt3 = readInt3;
                }
                arrayList2 = arrayList3;
            }
            return new User(readInt, readString, readString2, readString3, readString4, readString5, readString6, readString7, readString8, valueOf, readLong, arrayList, arrayList2, parcel.readInt() == 0 ? null : Boolean.valueOf(parcel.readInt() != 0), parcel.readInt(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : Boolean.valueOf(parcel.readInt() != 0), parcel.readInt() == 0 ? null : Boolean.valueOf(parcel.readInt() != 0), parcel.readString(), parcel.readString(), parcel.readFloat(), parcel.readString(), parcel.readString(), parcel.readFloat(), parcel.readFloat(), parcel.readInt() == 0 ? null : Boolean.valueOf(parcel.readInt() != 0), parcel.readString(), parcel.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @d
        public final User[] newArray(int i2) {
            return new User[i2];
        }
    }

    public User() {
        this(0, null, null, null, null, null, null, null, null, null, 0L, null, null, null, 0, 0, null, null, null, null, null, null, 0.0f, null, null, 0.0f, 0.0f, null, null, 0, v.f15906i, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public User(int i2, @e String str, @e String str2, @e String str3, @e String str4, @e String str5, @e String str6, @e String str7, @e String str8, @e Integer num, long j2, @e List<? extends List<String>> list, @e List<? extends List<String>> list2, @e Boolean bool, int i3, int i4, @d String str9, @e String str10, @e Boolean bool2, @e Boolean bool3, @e String str11, @e String str12, float f2, @e String str13, @e String str14, float f3, float f4, @e Boolean bool4, @e String str15, int i5) {
        this.id = i2;
        this.name = str;
        this.avatar = str2;
        this.country = str3;
        this.province = str4;
        this.city = str5;
        this.area = str6;
        this.sellerBio = str7;
        this.phone = str8;
        this.verifyStatus = num;
        this.lastLogin = j2;
        this.rarities = list;
        this.wishRarities = list2;
        this.followed = bool;
        this.followerNum = i3;
        this.orderSucNum = i4;
        this.shipping = str9;
        this.freeShippingNum = str10;
        this.nameVerify = bool2;
        this.warehouse = bool3;
        this.token = str11;
        this.sig = str12;
        this.balance = f2;
        this.techFeeRate = str13;
        this.transFeeRate = str14;
        this.lastMonthRevenue = f3;
        this.currentMonthRevenue = f4;
        this.needExam = bool4;
        this.creditRank = str15;
        this.isReg = i5;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @e
    public final String getArea() {
        return this.area;
    }

    @e
    public final String getAvatar() {
        return this.avatar;
    }

    public final float getBalance() {
        return this.balance;
    }

    @d
    public final CharSequence getBalanceStr() {
        return StringUtil.c(StringUtil.a, this.balance, R.string.shop_price, true, 16, 0, false, 48, null);
    }

    @d
    public final CharSequence getCMRStr() {
        return StringUtil.c(StringUtil.a, this.currentMonthRevenue, R.string.shop_price, true, 8, R.string.shop_price_default, false, 32, null);
    }

    @e
    public final String getCity() {
        return this.city;
    }

    @e
    public final String getCountry() {
        return this.country;
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

    public final float getCurrentMonthRevenue() {
        return this.currentMonthRevenue;
    }

    @d
    public final String getFansNumStr() {
        return String.valueOf(this.followerNum);
    }

    @d
    public final String getFansNumStr2() {
        return this.followerNum + Res.w(Res.a, R.string.common_fan, null, 2, null);
    }

    @d
    public final String getFeeRate() {
        String str;
        String str2 = this.techFeeRate;
        if (str2 == null || this.transFeeRate == null) {
            if (str2 != null || (str = this.transFeeRate) == null) {
                return (str2 == null || this.transFeeRate != null) ? "" : String.valueOf(str2);
            }
            return String.valueOf(str);
        }
        StringBuilder sb = new StringBuilder();
        sb.append((Object) this.techFeeRate);
        sb.append('+');
        sb.append((Object) this.transFeeRate);
        return sb.toString();
    }

    @e
    public final Boolean getFollowed() {
        return this.followed;
    }

    public final int getFollowerNum() {
        return this.followerNum;
    }

    @e
    public final String getFreeShippingNum() {
        return this.freeShippingNum;
    }

    @d
    public final String getFreeStr() {
        String str = this.freeShippingNum;
        return str == null ? "不包邮" : f0.C(str, "元包邮");
    }

    @d
    public final String getFreeStr2() {
        String str = this.freeShippingNum;
        return str == null ? "" : String.valueOf(str);
    }

    public final int getId() {
        return this.id;
    }

    @e
    public final String getIntro() {
        String str = this.sellerBio;
        return str == null || str.length() == 0 ? Res.w(Res.a, R.string.empty_seller_desc, null, 2, null) : this.sellerBio;
    }

    @d
    public final CharSequence getLMRStr() {
        return StringUtil.c(StringUtil.a, this.lastMonthRevenue, R.string.shop_price, true, 8, R.string.shop_price_default, false, 32, null);
    }

    public final long getLastLogin() {
        return this.lastLogin;
    }

    public final float getLastMonthRevenue() {
        return this.lastMonthRevenue;
    }

    @d
    public final String getLocation() {
        String str = this.province;
        boolean z = false;
        if (str == null || str.length() == 0) {
            String str2 = this.city;
            return (str2 == null || str2.length() == 0) ? true : true ? "" : String.valueOf(this.city);
        }
        String str3 = this.city;
        if ((str3 == null || str3.length() == 0) ? true : true) {
            return String.valueOf(this.province);
        }
        return ((Object) this.province) + ", " + ((Object) this.city);
    }

    @e
    public final String getName() {
        return this.name;
    }

    @e
    public final Boolean getNameVerify() {
        return this.nameVerify;
    }

    @e
    public final Boolean getNeedExam() {
        return this.needExam;
    }

    @d
    public final String getOrderNumStr() {
        return String.valueOf(this.orderSucNum);
    }

    public final int getOrderSucNum() {
        return this.orderSucNum;
    }

    @e
    public final String getPhone() {
        return this.phone;
    }

    @e
    public final String getProvince() {
        return this.province;
    }

    @e
    public final List<List<String>> getRarities() {
        return this.rarities;
    }

    @e
    public final String getSellerBio() {
        return this.sellerBio;
    }

    @d
    public final String getSellerLastLoginStr() {
        return StringUtil.a.f(this.lastLogin);
    }

    @d
    public final String getSellerLocation() {
        StringBuilder sb = new StringBuilder();
        String str = this.country;
        if (str == null) {
            str = "";
        }
        sb.append(str);
        String str2 = this.province;
        if (str2 == null) {
            str2 = "";
        }
        sb.append(str2);
        String str3 = this.city;
        sb.append(str3 != null ? str3 : "");
        return sb.toString();
    }

    @d
    public final String getSellerLocationCity() {
        String str = this.city;
        return str != null ? str : "";
    }

    @d
    public final String getShipping() {
        return this.shipping;
    }

    @d
    public final String getShippingStr() {
        return f0.C(this.shipping, "元");
    }

    @d
    public final String getShippingStr2() {
        return String.valueOf(this.shipping);
    }

    @e
    public final String getSig() {
        return this.sig;
    }

    @e
    public final String getTechFeeRate() {
        return this.techFeeRate;
    }

    @e
    public final String getToken() {
        return this.token;
    }

    @e
    public final String getTransFeeRate() {
        return this.transFeeRate;
    }

    @d
    public final String getUid() {
        return Res.a.v(R.string.uid, String.valueOf(this.id));
    }

    @d
    public final String getUserLocation() {
        StringBuilder sb = new StringBuilder();
        String str = this.province;
        if (str == null) {
            str = "";
        }
        sb.append(str);
        sb.append(' ');
        String str2 = this.city;
        if (str2 == null) {
            str2 = "";
        }
        sb.append(str2);
        sb.append(' ');
        String str3 = this.area;
        sb.append(str3 != null ? str3 : "");
        return sb.toString();
    }

    @e
    public final Integer getVerifyStatus() {
        return this.verifyStatus;
    }

    @e
    public final Boolean getWarehouse() {
        return this.warehouse;
    }

    @e
    public final List<List<String>> getWishRarities() {
        return this.wishRarities;
    }

    public final boolean isNewUser() {
        return this.isReg == 1;
    }

    public final int isReg() {
        return this.isReg;
    }

    public final boolean isVerifying() {
        Integer num = this.verifyStatus;
        return num != null && num.intValue() == 0;
    }

    public final void setArea(@e String str) {
        this.area = str;
    }

    public final void setAvatar(@e String str) {
        this.avatar = str;
    }

    public final void setBalance(float f2) {
        this.balance = f2;
    }

    public final void setCity(@e String str) {
        this.city = str;
    }

    public final void setCountry(@e String str) {
        this.country = str;
    }

    public final void setCreditRank(@e String str) {
        this.creditRank = str;
    }

    public final void setCurrentMonthRevenue(float f2) {
        this.currentMonthRevenue = f2;
    }

    public final void setFollowed(@e Boolean bool) {
        this.followed = bool;
    }

    public final void setFreeShippingNum(@e String str) {
        this.freeShippingNum = str;
    }

    public final void setId(int i2) {
        this.id = i2;
    }

    public final void setLastMonthRevenue(float f2) {
        this.lastMonthRevenue = f2;
    }

    public final void setName(@e String str) {
        this.name = str;
    }

    public final void setNeedExam(@e Boolean bool) {
        this.needExam = bool;
    }

    public final void setPhone(@e String str) {
        this.phone = str;
    }

    public final void setProvince(@e String str) {
        this.province = str;
    }

    public final void setReg(int i2) {
        this.isReg = i2;
    }

    public final void setSellerBio(@e String str) {
        this.sellerBio = str;
    }

    public final void setShipping(@d String str) {
        this.shipping = str;
    }

    public final void setSig(@e String str) {
        this.sig = str;
    }

    public final void setTechFeeRate(@e String str) {
        this.techFeeRate = str;
    }

    public final void setToken(@e String str) {
        this.token = str;
    }

    public final void setTransFeeRate(@e String str) {
        this.transFeeRate = str;
    }

    public final void setVerifyStatus(@e Integer num) {
        this.verifyStatus = num;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@d Parcel parcel, int i2) {
        parcel.writeInt(this.id);
        parcel.writeString(this.name);
        parcel.writeString(this.avatar);
        parcel.writeString(this.country);
        parcel.writeString(this.province);
        parcel.writeString(this.city);
        parcel.writeString(this.area);
        parcel.writeString(this.sellerBio);
        parcel.writeString(this.phone);
        Integer num = this.verifyStatus;
        if (num == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num.intValue());
        }
        parcel.writeLong(this.lastLogin);
        List<List<String>> list = this.rarities;
        if (list == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(list.size());
            for (List<String> list2 : list) {
                parcel.writeStringList(list2);
            }
        }
        List<List<String>> list3 = this.wishRarities;
        if (list3 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(list3.size());
            for (List<String> list4 : list3) {
                parcel.writeStringList(list4);
            }
        }
        Boolean bool = this.followed;
        if (bool == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(bool.booleanValue() ? 1 : 0);
        }
        parcel.writeInt(this.followerNum);
        parcel.writeInt(this.orderSucNum);
        parcel.writeString(this.shipping);
        parcel.writeString(this.freeShippingNum);
        Boolean bool2 = this.nameVerify;
        if (bool2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(bool2.booleanValue() ? 1 : 0);
        }
        Boolean bool3 = this.warehouse;
        if (bool3 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(bool3.booleanValue() ? 1 : 0);
        }
        parcel.writeString(this.token);
        parcel.writeString(this.sig);
        parcel.writeFloat(this.balance);
        parcel.writeString(this.techFeeRate);
        parcel.writeString(this.transFeeRate);
        parcel.writeFloat(this.lastMonthRevenue);
        parcel.writeFloat(this.currentMonthRevenue);
        Boolean bool4 = this.needExam;
        if (bool4 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(bool4.booleanValue() ? 1 : 0);
        }
        parcel.writeString(this.creditRank);
        parcel.writeInt(this.isReg);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ User(int r33, java.lang.String r34, java.lang.String r35, java.lang.String r36, java.lang.String r37, java.lang.String r38, java.lang.String r39, java.lang.String r40, java.lang.String r41, java.lang.Integer r42, long r43, java.util.List r45, java.util.List r46, java.lang.Boolean r47, int r48, int r49, java.lang.String r50, java.lang.String r51, java.lang.Boolean r52, java.lang.Boolean r53, java.lang.String r54, java.lang.String r55, float r56, java.lang.String r57, java.lang.String r58, float r59, float r60, java.lang.Boolean r61, java.lang.String r62, int r63, int r64, h.k2.v.u r65) {
        /*
            Method dump skipped, instructions count: 358
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jihuanshe.model.User.<init>(int, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, long, java.util.List, java.util.List, java.lang.Boolean, int, int, java.lang.String, java.lang.String, java.lang.Boolean, java.lang.Boolean, java.lang.String, java.lang.String, float, java.lang.String, java.lang.String, float, float, java.lang.Boolean, java.lang.String, int, int, h.k2.v.u):void");
    }
}
