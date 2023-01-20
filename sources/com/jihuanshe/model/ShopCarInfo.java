package com.jihuanshe.model;

import com.vector.ext.AnyKt;
import h.k2.v.f0;
import h.k2.v.s0;
import java.text.DecimalFormat;
import java.util.Arrays;
import k.e.a.d;
import k.e.a.e;

/* loaded from: classes2.dex */
public final class ShopCarInfo {
    private int count;
    @e
    private Float free;
    @e
    private Float price;
    @e
    private Float shipping;

    public ShopCarInfo() {
        this(null, null, null, 0, 15, null);
    }

    public ShopCarInfo(@e Float f2, @e Float f3, @e Float f4, int i2) {
        this.price = f2;
        this.shipping = f3;
        this.free = f4;
        this.count = i2;
    }

    public static /* synthetic */ ShopCarInfo copy$default(ShopCarInfo shopCarInfo, Float f2, Float f3, Float f4, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            f2 = shopCarInfo.price;
        }
        if ((i3 & 2) != 0) {
            f3 = shopCarInfo.shipping;
        }
        if ((i3 & 4) != 0) {
            f4 = shopCarInfo.free;
        }
        if ((i3 & 8) != 0) {
            i2 = shopCarInfo.count;
        }
        return shopCarInfo.copy(f2, f3, f4, i2);
    }

    @e
    public final Float component1() {
        return this.price;
    }

    @e
    public final Float component2() {
        return this.shipping;
    }

    @e
    public final Float component3() {
        return this.free;
    }

    public final int component4() {
        return this.count;
    }

    @d
    public final ShopCarInfo copy(@e Float f2, @e Float f3, @e Float f4, int i2) {
        return new ShopCarInfo(f2, f3, f4, i2);
    }

    public boolean equals(@e Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ShopCarInfo) {
            ShopCarInfo shopCarInfo = (ShopCarInfo) obj;
            return f0.g(this.price, shopCarInfo.price) && f0.g(this.shipping, shopCarInfo.shipping) && f0.g(this.free, shopCarInfo.free) && this.count == shopCarInfo.count;
        }
        return false;
    }

    public final int getCount() {
        return this.count;
    }

    @e
    public final Float getFree() {
        return this.free;
    }

    @e
    public final Float getPrice() {
        return this.price;
    }

    @d
    public final String getPriceStr() {
        s0 s0Var = s0.a;
        return String.format("¥%s（共%d张）", Arrays.copyOf(new Object[]{new DecimalFormat("0.##").format(this.price), Integer.valueOf(this.count)}, 2));
    }

    @e
    public final Float getShipping() {
        return this.shipping;
    }

    @e
    public final String getShippingStr() {
        if (AnyKt.l(this.shipping)) {
            return null;
        }
        if (f0.e(this.shipping, 0.0f)) {
            return "已免运费";
        }
        Float f2 = this.free;
        if (f2 != null && f2.floatValue() > 0.0f) {
            if (this.price.floatValue() >= this.free.floatValue()) {
                return "已免运费";
            }
            StringBuilder sb = new StringBuilder();
            s0 s0Var = s0.a;
            sb.append(String.format("邮费%s元", Arrays.copyOf(new Object[]{new DecimalFormat("0.##").format(this.shipping)}, 1)));
            sb.append((char) 65292);
            sb.append(String.format("满%s包邮", Arrays.copyOf(new Object[]{new DecimalFormat("0.##").format(this.free)}, 1)));
            return sb.toString();
        }
        s0 s0Var2 = s0.a;
        return String.format("邮费%s元", Arrays.copyOf(new Object[]{new DecimalFormat("0.##").format(this.shipping)}, 1));
    }

    public int hashCode() {
        Float f2 = this.price;
        int hashCode = (f2 == null ? 0 : f2.hashCode()) * 31;
        Float f3 = this.shipping;
        int hashCode2 = (hashCode + (f3 == null ? 0 : f3.hashCode())) * 31;
        Float f4 = this.free;
        return ((hashCode2 + (f4 != null ? f4.hashCode() : 0)) * 31) + this.count;
    }

    public final void setCount(int i2) {
        this.count = i2;
    }

    public final void setFree(@e Float f2) {
        this.free = f2;
    }

    public final void setPrice(@e Float f2) {
        this.price = f2;
    }

    public final void setShipping(@e Float f2) {
        this.shipping = f2;
    }

    @d
    public String toString() {
        return "ShopCarInfo(price=" + this.price + ", shipping=" + this.shipping + ", free=" + this.free + ", count=" + this.count + ')';
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ ShopCarInfo(java.lang.Float r2, java.lang.Float r3, java.lang.Float r4, int r5, int r6, h.k2.v.u r7) {
        /*
            r1 = this;
            r7 = r6 & 1
            r0 = 0
            java.lang.Float r0 = java.lang.Float.valueOf(r0)
            if (r7 == 0) goto La
            r2 = r0
        La:
            r7 = r6 & 2
            if (r7 == 0) goto Lf
            r3 = r0
        Lf:
            r7 = r6 & 4
            if (r7 == 0) goto L19
            r4 = -1082130432(0xffffffffbf800000, float:-1.0)
            java.lang.Float r4 = java.lang.Float.valueOf(r4)
        L19:
            r6 = r6 & 8
            if (r6 == 0) goto L1e
            r5 = 0
        L1e:
            r1.<init>(r2, r3, r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jihuanshe.model.ShopCarInfo.<init>(java.lang.Float, java.lang.Float, java.lang.Float, int, int, h.k2.v.u):void");
    }
}
