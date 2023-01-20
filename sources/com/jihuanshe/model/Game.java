package com.jihuanshe.model;

import android.os.Parcel;
import android.os.Parcelable;
import h.k2.v.f0;
import h.k2.v.u;
import i.c.c;
import java.util.Objects;
import k.e.a.d;
import k.e.a.e;

@c
/* loaded from: classes2.dex */
public final class Game implements Parcelable {
    @d
    public static final Parcelable.Creator<Game> CREATOR = new Creator();
    @e.j.e.r.c("radius")
    private final int corner;
    @e.j.e.r.c(Constants.KEY_PARAM_GAME_KEY)
    @e
    private final String game_key;
    @e.j.e.r.c(Constants.KEY_PARAM_GAME_SUB_KEY)
    @e
    private final String game_subKey;
    @e.j.e.r.c("game_sub_key_id")
    @e
    private final Integer game_subKey_id;
    @e.j.e.r.c("height")
    private final int height;
    @e.j.e.r.c("max_count")
    @e
    private final Integer maxCount;
    @e.j.e.r.c("name")
    @e
    private final String name;
    @e.j.e.r.c("category_tree")
    @e
    private final String path;
    @e.j.e.r.c("short_name")
    @e
    private final String shortName;
    @e.j.e.r.c("warehouse")
    @e
    private final Integer warehouse;
    @e.j.e.r.c("width")
    private final int width;

    /* loaded from: classes2.dex */
    public static final class Creator implements Parcelable.Creator<Game> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @d
        public final Game createFromParcel(@d Parcel parcel) {
            return new Game(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @d
        public final Game[] newArray(int i2) {
            return new Game[i2];
        }
    }

    public Game(@e String str, @e String str2, @e String str3, @e String str4, @e String str5, @e Integer num, int i2, int i3, int i4, @e Integer num2, @e Integer num3) {
        this.name = str;
        this.shortName = str2;
        this.game_key = str3;
        this.game_subKey = str4;
        this.path = str5;
        this.game_subKey_id = num;
        this.width = i2;
        this.height = i3;
        this.corner = i4;
        this.maxCount = num2;
        this.warehouse = num3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@e Object obj) {
        if (this == obj) {
            return true;
        }
        if (f0.g(Game.class, obj == null ? null : obj.getClass())) {
            Objects.requireNonNull(obj, "null cannot be cast to non-null type com.jihuanshe.model.Game");
            Game game = (Game) obj;
            return f0.g(getGameKey(), game.getGameKey()) && f0.g(getGameSubKey(), game.getGameSubKey());
        }
        return false;
    }

    public final int getCorner() {
        return this.corner;
    }

    @d
    public final String getGameKey() {
        String str = this.game_key;
        return str != null ? str : "";
    }

    @d
    public final String getGameSubKey() {
        String str = this.game_subKey;
        return str != null ? str : "";
    }

    @e
    public final String getGame_key() {
        return this.game_key;
    }

    @e
    public final String getGame_subKey() {
        return this.game_subKey;
    }

    @e
    public final Integer getGame_subKey_id() {
        return this.game_subKey_id;
    }

    public final int getHeight() {
        return this.height;
    }

    @e
    public final Integer getMaxCount() {
        return this.maxCount;
    }

    @e
    public final String getName() {
        return this.name;
    }

    @e
    public final String getPath() {
        return this.path;
    }

    @e
    public final String getShortName() {
        return this.shortName;
    }

    @e
    public final Integer getWarehouse() {
        return this.warehouse;
    }

    public final int getWidth() {
        return this.width;
    }

    public int hashCode() {
        return (getGameKey().hashCode() * 31) + getGameSubKey().hashCode();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@d Parcel parcel, int i2) {
        parcel.writeString(this.name);
        parcel.writeString(this.shortName);
        parcel.writeString(this.game_key);
        parcel.writeString(this.game_subKey);
        parcel.writeString(this.path);
        Integer num = this.game_subKey_id;
        if (num == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num.intValue());
        }
        parcel.writeInt(this.width);
        parcel.writeInt(this.height);
        parcel.writeInt(this.corner);
        Integer num2 = this.maxCount;
        if (num2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num2.intValue());
        }
        Integer num3 = this.warehouse;
        if (num3 == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        parcel.writeInt(num3.intValue());
    }

    public /* synthetic */ Game(String str, String str2, String str3, String str4, String str5, Integer num, int i2, int i3, int i4, Integer num2, Integer num3, int i5, u uVar) {
        this((i5 & 1) != 0 ? null : str, (i5 & 2) != 0 ? null : str2, (i5 & 4) != 0 ? null : str3, (i5 & 8) != 0 ? null : str4, (i5 & 16) != 0 ? null : str5, (i5 & 32) != 0 ? null : num, i2, i3, i4, num2, num3);
    }
}
