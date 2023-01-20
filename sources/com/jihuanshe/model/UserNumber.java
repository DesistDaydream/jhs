package com.jihuanshe.model;

import e.j.e.r.c;
import k.e.a.d;

/* loaded from: classes2.dex */
public final class UserNumber {
    @c("cart_count")
    private final int cart;
    @c("follower_count")
    private final int fans;
    @c("following_count")
    private final int following;
    @c("wish_count")
    private final int wish;

    public UserNumber(int i2, int i3, int i4, int i5) {
        this.following = i2;
        this.fans = i3;
        this.cart = i4;
        this.wish = i5;
    }

    public final int getCart() {
        return this.cart;
    }

    @d
    public final String getCartStr() {
        return String.valueOf(this.cart);
    }

    public final int getFans() {
        return this.fans;
    }

    @d
    public final String getFansStr() {
        return String.valueOf(this.fans);
    }

    public final int getFollowing() {
        return this.following;
    }

    @d
    public final String getFollowingStr() {
        return String.valueOf(this.following);
    }

    public final int getWish() {
        return this.wish;
    }

    @d
    public final String getWishStr() {
        return String.valueOf(this.wish);
    }
}
