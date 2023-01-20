package com.jihuanshe.model;

import android.os.Parcel;
import android.os.Parcelable;
import h.k2.v.f0;
import h.k2.v.u;
import i.c.c;
import k.e.a.d;
import k.e.a.e;

@c
/* loaded from: classes2.dex */
public final class Ranking implements Parcelable {
    @d
    public static final Parcelable.Creator<Ranking> CREATOR = new Creator();
    @e.j.e.r.c("all_game")
    @e
    private final Integer allGame;
    @e
    private final Integer rank;
    @e.j.e.r.c("rank_type_id")
    @e
    private final Integer rankTypeID;
    @e.j.e.r.c("rank_type_name")
    @e
    private final String rankTypeName;

    /* loaded from: classes2.dex */
    public static final class Creator implements Parcelable.Creator<Ranking> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @d
        public final Ranking createFromParcel(@d Parcel parcel) {
            return new Ranking(parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null, parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @d
        public final Ranking[] newArray(int i2) {
            return new Ranking[i2];
        }
    }

    public Ranking() {
        this(null, null, null, null, 15, null);
    }

    public Ranking(@e Integer num, @e Integer num2, @e Integer num3, @e String str) {
        this.rank = num;
        this.rankTypeID = num2;
        this.allGame = num3;
        this.rankTypeName = str;
    }

    public static /* synthetic */ Ranking copy$default(Ranking ranking, Integer num, Integer num2, Integer num3, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            num = ranking.rank;
        }
        if ((i2 & 2) != 0) {
            num2 = ranking.rankTypeID;
        }
        if ((i2 & 4) != 0) {
            num3 = ranking.allGame;
        }
        if ((i2 & 8) != 0) {
            str = ranking.rankTypeName;
        }
        return ranking.copy(num, num2, num3, str);
    }

    @e
    public final Integer component1() {
        return this.rank;
    }

    @e
    public final Integer component2() {
        return this.rankTypeID;
    }

    @e
    public final Integer component3() {
        return this.allGame;
    }

    @e
    public final String component4() {
        return this.rankTypeName;
    }

    @d
    public final Ranking copy(@e Integer num, @e Integer num2, @e Integer num3, @e String str) {
        return new Ranking(num, num2, num3, str);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@e Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Ranking) {
            Ranking ranking = (Ranking) obj;
            return f0.g(this.rank, ranking.rank) && f0.g(this.rankTypeID, ranking.rankTypeID) && f0.g(this.allGame, ranking.allGame) && f0.g(this.rankTypeName, ranking.rankTypeName);
        }
        return false;
    }

    @e
    public final Integer getAllGame() {
        return this.allGame;
    }

    @e
    public final Integer getRank() {
        return this.rank;
    }

    @d
    public final String getRankStr() {
        Integer num = this.rank;
        return num == null ? "NO." : f0.C("NO.", num);
    }

    @e
    public final Integer getRankTypeID() {
        return this.rankTypeID;
    }

    @e
    public final String getRankTypeName() {
        return this.rankTypeName;
    }

    public int hashCode() {
        Integer num = this.rank;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.rankTypeID;
        int hashCode2 = (hashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.allGame;
        int hashCode3 = (hashCode2 + (num3 == null ? 0 : num3.hashCode())) * 31;
        String str = this.rankTypeName;
        return hashCode3 + (str != null ? str.hashCode() : 0);
    }

    @d
    public String toString() {
        return "Ranking(rank=" + this.rank + ", rankTypeID=" + this.rankTypeID + ", allGame=" + this.allGame + ", rankTypeName=" + ((Object) this.rankTypeName) + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@d Parcel parcel, int i2) {
        Integer num = this.rank;
        if (num == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num.intValue());
        }
        Integer num2 = this.rankTypeID;
        if (num2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num2.intValue());
        }
        Integer num3 = this.allGame;
        if (num3 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num3.intValue());
        }
        parcel.writeString(this.rankTypeName);
    }

    public /* synthetic */ Ranking(Integer num, Integer num2, Integer num3, String str, int i2, u uVar) {
        this((i2 & 1) != 0 ? 0 : num, (i2 & 2) != 0 ? 0 : num2, (i2 & 4) != 0 ? 0 : num3, (i2 & 8) != 0 ? "" : str);
    }
}
