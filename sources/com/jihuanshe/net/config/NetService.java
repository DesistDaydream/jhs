package com.jihuanshe.net.config;

import k.e.a.d;

/* loaded from: classes2.dex */
public enum NetService {
    COMMON("http://115.28.226.156:8222/", "https://api.jihuanshe.com/"),
    AUTH("http://115.28.226.156:8222/api/market/auth/", "https://api.jihuanshe.com/api/market/auth/"),
    MARKET("http://115.28.226.156:8222/api/market/", "https://api.jihuanshe.com/api/market/"),
    CARD("http://115.28.226.156:8222/api/market/cards/", "https://api.jihuanshe.com/api/market/cards/"),
    PACK("http://115.28.226.156:8222/api/market/packs/", "https://api.jihuanshe.com/api/market/packs/"),
    CARD_VERSION("http://115.28.226.156:8222/api/market/card-versions/", "https://api.jihuanshe.com/api/market/card-versions/"),
    USER("http://115.28.226.156:8222/api/market/users/", "https://api.jihuanshe.com/api/market/users/"),
    PRODUCT("http://115.28.226.156:8222/api/market/products/", "https://api.jihuanshe.com/api/market/products/"),
    CARTS("http://115.28.226.156:8222/api/market/carts/", "https://api.jihuanshe.com/api/market/carts/"),
    ORDER("http://115.28.226.156:8222/api/market/orders/", "https://api.jihuanshe.com/api/market/orders/"),
    SELLER_ORDER("http://115.28.226.156:8222/api/market/sellers/orders/", "https://api.jihuanshe.com/api/market/sellers/orders/"),
    SEARCH("http://115.28.226.156:8222/api/market/search/", "https://api.jihuanshe.com/api/market/search/"),
    ENTREPOT("http://115.28.226.156:8222/api/market/warehouse-orders/", "https://api.jihuanshe.com/api/market/warehouse-orders/"),
    INTERACT("http://115.28.226.156:8222/api/market/interactive-notifications/", "https://api.jihuanshe.com/api/market/interactive-notifications/"),
    SHARE("http://115.28.226.156:8222//api/market/share/", "https://api.jihuanshe.com//api/market/share/");
    
    @d
    private final String debugHost;
    @d
    private final String releaseHost;

    NetService(String str, String str2) {
        this.debugHost = str;
        this.releaseHost = str2;
    }

    @d
    public final String getHost() {
        return this.releaseHost;
    }
}
