package com.jihuanshe.model;

import h.k2.v.f0;
import h.k2.v.u;
import k.e.a.d;
import k.e.a.e;

/* loaded from: classes2.dex */
public final class ReturnProduct {
    @e
    private final String id;
    private final int quantity;

    public ReturnProduct() {
        this(null, 0, 3, null);
    }

    public ReturnProduct(@e String str, int i2) {
        this.id = str;
        this.quantity = i2;
    }

    public static /* synthetic */ ReturnProduct copy$default(ReturnProduct returnProduct, String str, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = returnProduct.id;
        }
        if ((i3 & 2) != 0) {
            i2 = returnProduct.quantity;
        }
        return returnProduct.copy(str, i2);
    }

    @e
    public final String component1() {
        return this.id;
    }

    public final int component2() {
        return this.quantity;
    }

    @d
    public final ReturnProduct copy(@e String str, int i2) {
        return new ReturnProduct(str, i2);
    }

    public boolean equals(@e Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ReturnProduct) {
            ReturnProduct returnProduct = (ReturnProduct) obj;
            return f0.g(this.id, returnProduct.id) && this.quantity == returnProduct.quantity;
        }
        return false;
    }

    @e
    public final String getId() {
        return this.id;
    }

    public final int getQuantity() {
        return this.quantity;
    }

    public int hashCode() {
        String str = this.id;
        return ((str == null ? 0 : str.hashCode()) * 31) + this.quantity;
    }

    @d
    public String toString() {
        return "ReturnProduct(id=" + ((Object) this.id) + ", quantity=" + this.quantity + ')';
    }

    public /* synthetic */ ReturnProduct(String str, int i2, int i3, u uVar) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? 0 : i2);
    }
}
