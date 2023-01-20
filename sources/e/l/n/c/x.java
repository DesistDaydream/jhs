package e.l.n.c;

import com.jihuanshe.model.ApplyForItem;
import com.jihuanshe.model.ApplyForOrder;
import com.jihuanshe.model.Game;
import com.jihuanshe.net.config.NetService;
import com.jihuanshe.ui.widget.GameBar;
import h.t1;
import kotlinx.coroutines.flow.Flow;

@e.l.n.b(service = NetService.ENTREPOT)
/* loaded from: classes2.dex */
public interface x {

    /* loaded from: classes2.dex */
    public static final class a {
        public static /* synthetic */ Flow a(x xVar, int i2, int i3, float f2, int i4, String str, String str2, String str3, int i5, Object obj) {
            String str4;
            String str5;
            if (obj == null) {
                if ((i5 & 32) != 0) {
                    Game value = GameBar.b.a().getValue();
                    String gameKey = value == null ? null : value.getGameKey();
                    if (gameKey == null) {
                        gameKey = "";
                    }
                    str4 = gameKey;
                } else {
                    str4 = str2;
                }
                if ((i5 & 64) != 0) {
                    Game value2 = GameBar.b.a().getValue();
                    String gameSubKey = value2 != null ? value2.getGameSubKey() : null;
                    str5 = gameSubKey != null ? gameSubKey : "";
                } else {
                    str5 = str3;
                }
                return xVar.a(i2, i3, f2, i4, str, str4, str5);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addStoreOrderProduct");
        }

        public static /* synthetic */ Flow b(x xVar, int i2, String str, String str2, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    Game value = GameBar.b.a().getValue();
                    str = value == null ? null : value.getGameKey();
                    if (str == null) {
                        str = "";
                    }
                }
                if ((i3 & 4) != 0) {
                    Game value2 = GameBar.b.a().getValue();
                    String gameSubKey = value2 != null ? value2.getGameSubKey() : null;
                    str2 = gameSubKey != null ? gameSubKey : "";
                }
                return xVar.c(i2, str, str2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: deleteStoreOrderProduct");
        }

        public static /* synthetic */ Flow c(x xVar, int i2, int i3, String str, String str2, int i4, Object obj) {
            if (obj == null) {
                if ((i4 & 4) != 0) {
                    Game value = GameBar.b.a().getValue();
                    str = value == null ? null : value.getGameKey();
                    if (str == null) {
                        str = "";
                    }
                }
                if ((i4 & 8) != 0) {
                    Game value2 = GameBar.b.a().getValue();
                    String gameSubKey = value2 != null ? value2.getGameSubKey() : null;
                    str2 = gameSubKey != null ? gameSubKey : "";
                }
                return xVar.b(i2, i3, str, str2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getWarehouseOrderList");
        }

        public static /* synthetic */ Flow d(x xVar, String str, String str2, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 1) != 0) {
                    Game value = GameBar.b.a().getValue();
                    str = value == null ? null : value.getGameKey();
                    if (str == null) {
                        str = "";
                    }
                }
                if ((i2 & 2) != 0) {
                    Game value2 = GameBar.b.a().getValue();
                    String gameSubKey = value2 != null ? value2.getGameSubKey() : null;
                    str2 = gameSubKey != null ? gameSubKey : "";
                }
                return xVar.f(str, str2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getWarehouseOrders");
        }

        public static /* synthetic */ Flow e(x xVar, int i2, String str, String str2, String str3, String str4, String str5, int i3, Object obj) {
            String str6;
            String str7;
            if (obj == null) {
                if ((i3 & 16) != 0) {
                    Game value = GameBar.b.a().getValue();
                    String gameKey = value == null ? null : value.getGameKey();
                    if (gameKey == null) {
                        gameKey = "";
                    }
                    str6 = gameKey;
                } else {
                    str6 = str4;
                }
                if ((i3 & 32) != 0) {
                    Game value2 = GameBar.b.a().getValue();
                    String gameSubKey = value2 != null ? value2.getGameSubKey() : null;
                    str7 = gameSubKey != null ? gameSubKey : "";
                } else {
                    str7 = str5;
                }
                return xVar.e(i2, str, str2, str3, str6, str7);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: submitOrders");
        }

        public static /* synthetic */ Flow f(x xVar, int i2, float f2, int i3, String str, String str2, int i4, Object obj) {
            if (obj == null) {
                if ((i4 & 8) != 0) {
                    Game value = GameBar.b.a().getValue();
                    str = value == null ? null : value.getGameKey();
                    if (str == null) {
                        str = "";
                    }
                }
                String str3 = str;
                if ((i4 & 16) != 0) {
                    Game value2 = GameBar.b.a().getValue();
                    String gameSubKey = value2 != null ? value2.getGameSubKey() : null;
                    str2 = gameSubKey != null ? gameSubKey : "";
                }
                return xVar.d(i2, f2, i3, str3, str2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateStoreOrderProduct");
        }
    }

    @l.y.e
    @l.y.o(e.l.j.a.p)
    @k.e.a.d
    Flow<t1> a(@l.y.c("warehouse_order_id") int i2, @l.y.c("card_version_id") int i3, @l.y.c("price") float f2, @l.y.c("quantity") int i4, @l.y.c("publish_location") @k.e.a.d String str, @k.e.a.e @l.y.c("game_key") String str2, @k.e.a.e @l.y.c("game_sub_key") String str3);

    @l.y.f("get-warehouse-order-products")
    @k.e.a.d
    Flow<e.l.h.i.e<ApplyForItem>> b(@l.y.t("warehouse_order_id") int i2, @l.y.t("page") int i3, @k.e.a.e @l.y.t("game_key") String str, @k.e.a.e @l.y.t("game_sub_key") String str2);

    @l.y.e
    @l.y.o("delete-order-product")
    @k.e.a.d
    Flow<t1> c(@l.y.c("warehouse_order_product_id") int i2, @k.e.a.e @l.y.c("game_key") String str, @k.e.a.e @l.y.c("game_sub_key") String str2);

    @l.y.e
    @l.y.o("update-order-product")
    @k.e.a.d
    Flow<t1> d(@l.y.c("warehouse_order_product_id") int i2, @l.y.c("price") float f2, @l.y.c("quantity") int i3, @k.e.a.e @l.y.c("game_key") String str, @k.e.a.e @l.y.c("game_sub_key") String str2);

    @l.y.e
    @l.y.o("commit-order")
    @k.e.a.d
    Flow<t1> e(@l.y.c("warehouse_order_id") int i2, @l.y.c("express_name") @k.e.a.d String str, @l.y.c("express_number") @k.e.a.d String str2, @l.y.c("express_image") @k.e.a.d String str3, @k.e.a.e @l.y.c("game_key") String str4, @k.e.a.e @l.y.c("game_sub_key") String str5);

    @l.y.f("get-pending-order")
    @k.e.a.d
    Flow<ApplyForOrder> f(@k.e.a.e @l.y.t("game_key") String str, @k.e.a.e @l.y.t("game_sub_key") String str2);
}
