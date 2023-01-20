package com.jihuanshe.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.jihuanshe.R;
import com.vector.ext.AnyKt;
import com.vector.util.Res;
import e.j.e.r.a;
import h.k2.v.f0;
import h.k2.v.u;
import h.w;
import h.z;
import i.c.c;
import java.util.List;
import k.e.a.d;
import k.e.a.e;

@c
/* loaded from: classes2.dex */
public final class CardBaseInfo implements Parcelable {
    @d
    public static final Parcelable.Creator<CardBaseInfo> CREATOR = new Creator();
    @e.j.e.r.c("arrow")
    @e
    private final String arrow;
    @e.j.e.r.c("atk")
    @e
    private final String atk;
    @e.j.e.r.c("attribute")
    @e
    private final String attr;
    @e.j.e.r.c(Constants.KEY_PARAM_CARD_ID)
    @e
    private final Integer cardId;
    @e.j.e.r.c("cost")
    @e
    private final Integer cost;
    @e.j.e.r.c("counter")
    @e
    private final String counter;
    @e.j.e.r.c("def")
    @e
    private final String def;
    @e.j.e.r.c("desc")
    @e
    private final String desc;
    @e.j.e.r.c("energy_type")
    @e
    private final String energyType;
    @e.j.e.r.c("desc_evo_cn")
    @e
    private final String evoDesc;
    @e.j.e.r.c("feature")
    @e
    private final String feature;
    @a
    @e
    private Game game;
    @e.j.e.r.c("hp")
    @e
    private final Integer hp;
    @e.j.e.r.c("image_url")
    @e
    private final String image;
    @e.j.e.r.c("level")
    @e
    private final String lv;
    @e.j.e.r.c("desc_main_cn")
    @e
    private final String mainDesc;
    @e.j.e.r.c("monster_type")
    @e
    private final String monsterType;
    @e.j.e.r.c("name_cn")
    @e
    private final String nameCN;
    @e.j.e.r.c("name_origin")
    @e
    private final String nameOri;
    @e.j.e.r.c("number")
    @e
    private final String number;
    @e.j.e.r.c("text_cn")
    @e
    private final String onePieceDesc;
    @e.j.e.r.c("pack_name_cn")
    @e
    private final String packName;
    @e.j.e.r.c("pack_released_at")
    @e
    private final String packRelease;
    @e.j.e.r.c("pendulum_desc")
    @e
    private final String pdesc;
    @e.j.e.r.c("power")
    @e
    private final String power;
    @e.j.e.r.c("rank")
    @e
    private final String rank;
    @e.j.e.r.c("rarity")
    @e
    private final String rarity;
    @e.j.e.r.c("scale")
    @e
    private final String scale;
    @e.j.e.r.c("desc_security_cn")
    @e
    private final String securityDesc;
    @e.j.e.r.c("skill_1_cost")
    @e
    private final String skillCost1;
    @e.j.e.r.c("skill_2_cost")
    @e
    private final String skillCost2;
    @e.j.e.r.c("skill_gx_cost")
    @e
    private final String skillCostgx;
    @e.j.e.r.c("skill_1_hit_point")
    @e
    private final String skillDamage1;
    @e.j.e.r.c("skill_2_hit_point")
    @e
    private final String skillDamage2;
    @e.j.e.r.c("skill_gx_hit_point")
    @e
    private final String skillDamagegx;
    @e.j.e.r.c("skill_1_desc")
    @e
    private final String skillDesc1;
    @e.j.e.r.c("skill_2_desc")
    @e
    private final String skillDesc2;
    @e.j.e.r.c("skill_gx_desc")
    @e
    private final String skillDescgx;
    @e.j.e.r.c("skill_1_name")
    @e
    private final String skillName1;
    @e.j.e.r.c("skill_2_name")
    @e
    private final String skillName2;
    @e.j.e.r.c("skill_gx_name")
    @e
    private final String skillNamegx;
    @d
    private final w star$delegate;
    @e.j.e.r.c("type")
    @e
    private final String type;
    @e.j.e.r.c("id")
    @e
    private final Integer versionId;

    /* loaded from: classes2.dex */
    public static final class Creator implements Parcelable.Creator<CardBaseInfo> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @d
        public final CardBaseInfo createFromParcel(@d Parcel parcel) {
            return new CardBaseInfo(parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @d
        public final CardBaseInfo[] newArray(int i2) {
            return new CardBaseInfo[i2];
        }
    }

    public CardBaseInfo() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1, 1023, null);
    }

    public CardBaseInfo(@e Integer num, @e String str, @e String str2, @e Integer num2, @e String str3, @e String str4, @e String str5, @e String str6, @e String str7, @e String str8, @e String str9, @e String str10, @e String str11, @e String str12, @e String str13, @e String str14, @e String str15, @e String str16, @e String str17, @e String str18, @e String str19, @e Integer num3, @e String str20, @e String str21, @e String str22, @e String str23, @e String str24, @e String str25, @e String str26, @e String str27, @e String str28, @e String str29, @e String str30, @e String str31, @e String str32, @e String str33, @e Integer num4, @e String str34, @e String str35, @e String str36, @e String str37, @e String str38) {
        this.versionId = num;
        this.nameCN = str;
        this.nameOri = str2;
        this.cardId = num2;
        this.number = str3;
        this.rarity = str4;
        this.image = str5;
        this.type = str6;
        this.monsterType = str7;
        this.attr = str8;
        this.lv = str9;
        this.rank = str10;
        this.atk = str11;
        this.def = str12;
        this.scale = str13;
        this.arrow = str14;
        this.desc = str15;
        this.pdesc = str16;
        this.mainDesc = str17;
        this.evoDesc = str18;
        this.securityDesc = str19;
        this.hp = num3;
        this.energyType = str20;
        this.skillName1 = str21;
        this.skillCost1 = str22;
        this.skillDamage1 = str23;
        this.skillDesc1 = str24;
        this.skillName2 = str25;
        this.skillCost2 = str26;
        this.skillDamage2 = str27;
        this.skillDesc2 = str28;
        this.skillNamegx = str29;
        this.skillCostgx = str30;
        this.skillDamagegx = str31;
        this.skillDescgx = str32;
        this.feature = str33;
        this.cost = num4;
        this.power = str34;
        this.counter = str35;
        this.onePieceDesc = str36;
        this.packName = str37;
        this.packRelease = str38;
        this.star$delegate = z.c(new CardBaseInfo$star$2(this));
    }

    private final CharSequence getDigimonDesc() {
        StringBuilder sb = new StringBuilder();
        String str = this.mainDesc;
        if (!(str == null || str.length() == 0)) {
            sb.append(Res.w(Res.a, R.string.common_capacity, null, 2, null));
            sb.append("\n");
            sb.append(this.mainDesc);
            sb.append("\n");
        }
        String str2 = this.evoDesc;
        if (!(str2 == null || str2.length() == 0)) {
            sb.append(Res.w(Res.a, R.string.digimon_evolution_source, null, 2, null));
            sb.append("\n");
            sb.append(this.evoDesc);
            sb.append("\n");
        }
        String str3 = this.securityDesc;
        if (!(str3 == null || str3.length() == 0)) {
            sb.append(Res.w(Res.a, R.string.digimon_def, null, 2, null));
            sb.append("\n");
            sb.append(this.securityDesc);
        }
        return sb.length() == 0 ? Res.w(Res.a, R.string.common_wu, null, 2, null) : sb.toString();
    }

    private final CharSequence getPokemonDesc() {
        StringBuilder sb = new StringBuilder();
        String str = this.energyType;
        if (!(str == null || str.length() == 0)) {
            sb.append(this.energyType);
        }
        if (AnyKt.k(this.hp)) {
            sb.append(f0.C(" -HP", this.hp));
        }
        StringBuilder sb2 = new StringBuilder();
        String str2 = this.skillCost1;
        if (!(str2 == null || str2.length() == 0)) {
            sb2.append(f0.C(this.skillCost1, ExpandableTextView.N));
        }
        String str3 = this.skillName1;
        if (!(str3 == null || str3.length() == 0)) {
            sb2.append(f0.C(this.skillName1, ExpandableTextView.N));
        }
        String str4 = this.skillDesc1;
        if (!(str4 == null || str4.length() == 0)) {
            sb2.append(String.valueOf(this.skillDesc1));
        }
        String str5 = this.skillDamage1;
        if (!(str5 == null || str5.length() == 0)) {
            sb2.append(f0.C(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR, this.skillDamage1));
        }
        if (!(sb2.length() == 0)) {
            sb.append(f0.C("\n\n", sb2));
        }
        StringBuilder sb3 = new StringBuilder();
        String str6 = this.skillCost2;
        if (!(str6 == null || str6.length() == 0)) {
            sb2.append(f0.C(this.skillCost2, ExpandableTextView.N));
        }
        String str7 = this.skillName2;
        if (!(str7 == null || str7.length() == 0)) {
            sb2.append(f0.C(this.skillName2, ExpandableTextView.N));
        }
        String str8 = this.skillDesc2;
        if (!(str8 == null || str8.length() == 0)) {
            sb2.append(String.valueOf(this.skillDesc2));
        }
        String str9 = this.skillDamage2;
        if (!(str9 == null || str9.length() == 0)) {
            sb2.append(f0.C(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR, this.skillDamage2));
        }
        if (!(sb3.length() == 0)) {
            sb.append(f0.C("\n\n", sb3));
        }
        StringBuilder sb4 = new StringBuilder();
        String str10 = this.skillCostgx;
        if (!(str10 == null || str10.length() == 0)) {
            sb2.append(f0.C(this.skillCostgx, ExpandableTextView.N));
        }
        String str11 = this.skillNamegx;
        if (!(str11 == null || str11.length() == 0)) {
            sb2.append(f0.C(this.skillNamegx, ExpandableTextView.N));
        }
        String str12 = this.skillDescgx;
        if (!(str12 == null || str12.length() == 0)) {
            sb2.append(String.valueOf(this.skillDescgx));
        }
        String str13 = this.skillDamagegx;
        if (!(str13 == null || str13.length() == 0)) {
            sb2.append(f0.C("：", this.skillDamagegx));
        }
        if (!(sb4.length() == 0)) {
            sb.append(f0.C("\n\n", sb4));
        }
        return sb.length() == 0 ? Res.w(Res.a, R.string.common_wu, null, 2, null) : sb.toString();
    }

    private final CharSequence getYgoDesc() {
        StringBuilder sb = new StringBuilder("");
        String str = this.pdesc;
        if (!(str == null || str.length() == 0)) {
            sb.append("灵摆");
            sb.append("\n");
            sb.append(this.pdesc);
            sb.append("\n");
        }
        String str2 = this.desc;
        if (!(str2 == null || str2.length() == 0)) {
            sb.append("效果");
            sb.append("\n");
            sb.append(this.desc);
        }
        String sb2 = sb.toString();
        return sb2.length() == 0 ? Res.w(Res.a, R.string.common_wu, null, 2, null) : sb2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @e
    public final String getArrow() {
        return this.arrow;
    }

    @e
    public final String getAtk() {
        return this.atk;
    }

    @e
    public final String getAttr() {
        return this.attr;
    }

    @e
    public final Integer getCardId() {
        return this.cardId;
    }

    @e
    public final Integer getCost() {
        return this.cost;
    }

    @e
    public final String getCounter() {
        return this.counter;
    }

    @e
    public final String getDef() {
        return this.def;
    }

    @e
    public final String getDesc() {
        return this.desc;
    }

    @e
    public final String getEnergyType() {
        return this.energyType;
    }

    @e
    public final String getEvoDesc() {
        return this.evoDesc;
    }

    @e
    public final String getFeature() {
        return this.feature;
    }

    @e
    public final Game getGame() {
        return this.game;
    }

    @d
    public final CharSequence getGameDesc(@e String str) {
        if (str != null) {
            int hashCode = str.hashCode();
            if (hashCode != 3553) {
                if (hashCode != 99402) {
                    if (hashCode != 111058) {
                        if (hashCode == 119585 && str.equals("ygo")) {
                            return getYgoDesc();
                        }
                    } else if (str.equals("pkm")) {
                        return getPokemonDesc();
                    }
                } else if (str.equals("dgm")) {
                    return getDigimonDesc();
                }
            } else if (str.equals("op")) {
                return getOnePieceDesc();
            }
        }
        return Res.w(Res.a, R.string.common_wu, null, 2, null);
    }

    @e
    public final Integer getHp() {
        return this.hp;
    }

    @e
    public final String getImage() {
        return this.image;
    }

    @e
    public final String getLv() {
        return this.lv;
    }

    @e
    public final String getMainDesc() {
        return this.mainDesc;
    }

    @e
    public final String getMonsterType() {
        return this.monsterType;
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
    public final String getNumber() {
        return this.number;
    }

    @d
    public final String getNumberStr() {
        String str = this.number;
        return str != null ? str : "";
    }

    @e
    /* renamed from: getOnePieceDesc  reason: collision with other method in class */
    public final String m14getOnePieceDesc() {
        return this.onePieceDesc;
    }

    @e
    public final String getPackName() {
        return this.packName;
    }

    @e
    public final String getPackRelease() {
        return this.packRelease;
    }

    @e
    public final String getPdesc() {
        return this.pdesc;
    }

    @e
    public final String getPower() {
        return this.power;
    }

    @e
    public final String getRank() {
        return this.rank;
    }

    @e
    public final String getRarity() {
        return this.rarity;
    }

    @e
    public final String getScale() {
        return this.scale;
    }

    @e
    public final String getSecurityDesc() {
        return this.securityDesc;
    }

    @e
    public final String getSkillCost1() {
        return this.skillCost1;
    }

    @e
    public final String getSkillCost2() {
        return this.skillCost2;
    }

    @e
    public final String getSkillCostgx() {
        return this.skillCostgx;
    }

    @e
    public final String getSkillDamage1() {
        return this.skillDamage1;
    }

    @e
    public final String getSkillDamage2() {
        return this.skillDamage2;
    }

    @e
    public final String getSkillDamagegx() {
        return this.skillDamagegx;
    }

    @e
    public final String getSkillDesc1() {
        return this.skillDesc1;
    }

    @e
    public final String getSkillDesc2() {
        return this.skillDesc2;
    }

    @e
    public final String getSkillDescgx() {
        return this.skillDescgx;
    }

    @e
    public final String getSkillName1() {
        return this.skillName1;
    }

    @e
    public final String getSkillName2() {
        return this.skillName2;
    }

    @e
    public final String getSkillNamegx() {
        return this.skillNamegx;
    }

    @d
    public final List<Integer> getStar() {
        return (List) this.star$delegate.getValue();
    }

    @e
    public final String getType() {
        return this.type;
    }

    @e
    public final Integer getVersionId() {
        return this.versionId;
    }

    public final void setGame(@e Game game) {
        this.game = game;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@d Parcel parcel, int i2) {
        Integer num = this.versionId;
        if (num == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num.intValue());
        }
        parcel.writeString(this.nameCN);
        parcel.writeString(this.nameOri);
        Integer num2 = this.cardId;
        if (num2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num2.intValue());
        }
        parcel.writeString(this.number);
        parcel.writeString(this.rarity);
        parcel.writeString(this.image);
        parcel.writeString(this.type);
        parcel.writeString(this.monsterType);
        parcel.writeString(this.attr);
        parcel.writeString(this.lv);
        parcel.writeString(this.rank);
        parcel.writeString(this.atk);
        parcel.writeString(this.def);
        parcel.writeString(this.scale);
        parcel.writeString(this.arrow);
        parcel.writeString(this.desc);
        parcel.writeString(this.pdesc);
        parcel.writeString(this.mainDesc);
        parcel.writeString(this.evoDesc);
        parcel.writeString(this.securityDesc);
        Integer num3 = this.hp;
        if (num3 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num3.intValue());
        }
        parcel.writeString(this.energyType);
        parcel.writeString(this.skillName1);
        parcel.writeString(this.skillCost1);
        parcel.writeString(this.skillDamage1);
        parcel.writeString(this.skillDesc1);
        parcel.writeString(this.skillName2);
        parcel.writeString(this.skillCost2);
        parcel.writeString(this.skillDamage2);
        parcel.writeString(this.skillDesc2);
        parcel.writeString(this.skillNamegx);
        parcel.writeString(this.skillCostgx);
        parcel.writeString(this.skillDamagegx);
        parcel.writeString(this.skillDescgx);
        parcel.writeString(this.feature);
        Integer num4 = this.cost;
        if (num4 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num4.intValue());
        }
        parcel.writeString(this.power);
        parcel.writeString(this.counter);
        parcel.writeString(this.onePieceDesc);
        parcel.writeString(this.packName);
        parcel.writeString(this.packRelease);
    }

    private final CharSequence getOnePieceDesc() {
        StringBuilder sb = new StringBuilder();
        String str = this.feature;
        if (!(str == null || str.length() == 0)) {
            sb.append(f0.C(this.feature, "\n\n"));
        }
        if (AnyKt.k(this.cost)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.cost);
            sb2.append((char) 36153);
            sb.append(sb2.toString());
        }
        String str2 = this.power;
        if (!(str2 == null || str2.length() == 0)) {
            sb.append(' ' + ((Object) this.power) + "\n\n");
        }
        String str3 = this.onePieceDesc;
        if (!(str3 == null || str3.length() == 0)) {
            sb.append(this.onePieceDesc);
        }
        return sb.length() == 0 ? Res.w(Res.a, R.string.common_wu, null, 2, null) : sb.toString();
    }

    public /* synthetic */ CardBaseInfo(Integer num, String str, String str2, Integer num2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, Integer num3, String str20, String str21, String str22, String str23, String str24, String str25, String str26, String str27, String str28, String str29, String str30, String str31, String str32, String str33, Integer num4, String str34, String str35, String str36, String str37, String str38, int i2, int i3, u uVar) {
        this((i2 & 1) != 0 ? null : num, (i2 & 2) != 0 ? null : str, (i2 & 4) != 0 ? null : str2, (i2 & 8) != 0 ? null : num2, (i2 & 16) != 0 ? null : str3, (i2 & 32) != 0 ? null : str4, (i2 & 64) != 0 ? null : str5, (i2 & 128) != 0 ? null : str6, (i2 & 256) != 0 ? null : str7, (i2 & 512) != 0 ? null : str8, (i2 & 1024) != 0 ? null : str9, (i2 & 2048) != 0 ? null : str10, (i2 & 4096) != 0 ? null : str11, (i2 & 8192) != 0 ? null : str12, (i2 & 16384) != 0 ? null : str13, (i2 & 32768) != 0 ? null : str14, (i2 & 65536) != 0 ? null : str15, (i2 & 131072) != 0 ? null : str16, (i2 & 262144) != 0 ? null : str17, (i2 & 524288) != 0 ? null : str18, (i2 & 1048576) != 0 ? null : str19, (i2 & 2097152) != 0 ? null : num3, (i2 & 4194304) != 0 ? null : str20, (i2 & 8388608) != 0 ? null : str21, (i2 & 16777216) != 0 ? null : str22, (i2 & 33554432) != 0 ? null : str23, (i2 & 67108864) != 0 ? null : str24, (i2 & 134217728) != 0 ? null : str25, (i2 & 268435456) != 0 ? null : str26, (i2 & 536870912) != 0 ? null : str27, (i2 & 1073741824) != 0 ? null : str28, (i2 & Integer.MIN_VALUE) != 0 ? null : str29, (i3 & 1) != 0 ? null : str30, (i3 & 2) != 0 ? null : str31, (i3 & 4) != 0 ? null : str32, (i3 & 8) != 0 ? null : str33, (i3 & 16) != 0 ? null : num4, (i3 & 32) != 0 ? null : str34, (i3 & 64) != 0 ? null : str35, (i3 & 128) != 0 ? null : str36, (i3 & 256) != 0 ? null : str37, (i3 & 512) != 0 ? null : str38);
    }
}
