package com.jihuanshe.model;

import e.j.e.r.c;

/* loaded from: classes2.dex */
public final class ShopCarResult {
    @c("cart_id")
    private int cartId;
    @c("quantity")
    private int num;
    @c(Constants.KEY_PARAM_PRODUCT_ID)
    private int productId;

    public final int getCartId() {
        return this.cartId;
    }

    public final int getNum() {
        return this.num;
    }

    public final int getProductId() {
        return this.productId;
    }

    public final void setCartId(int i2) {
        this.cartId = i2;
    }

    public final void setNum(int i2) {
        this.num = i2;
    }

    public final void setProductId(int i2) {
        this.productId = i2;
    }
}
