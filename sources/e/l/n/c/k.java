package e.l.n.c;

import com.jihuanshe.base.model.Result;
import com.jihuanshe.model.BanUser;
import com.jihuanshe.model.BankDetail;
import com.jihuanshe.model.CardConsignmentInfo;
import com.jihuanshe.model.CityCodeSet;
import com.jihuanshe.model.CoinLog;
import com.jihuanshe.model.ConfirmState;
import com.jihuanshe.model.EtiquetteExamResult;
import com.jihuanshe.model.EtiquetteQuestion;
import com.jihuanshe.model.ExpressList;
import com.jihuanshe.model.FailProductInfo;
import com.jihuanshe.model.Game;
import com.jihuanshe.model.GameCard;
import com.jihuanshe.model.IllegalData;
import com.jihuanshe.model.OrderInfo;
import com.jihuanshe.model.OrderReturnDetail;
import com.jihuanshe.model.OrderReturnInfo;
import com.jihuanshe.model.PayParams;
import com.jihuanshe.model.Product;
import com.jihuanshe.model.RecentPhoto;
import com.jihuanshe.model.ReturnCardInfo;
import com.jihuanshe.model.ReturnOrderResult;
import com.jihuanshe.model.SellCalendar;
import com.jihuanshe.model.SellerOrderInfo;
import com.jihuanshe.model.ShopCartItem;
import com.jihuanshe.model.SoldProductInfo;
import com.jihuanshe.model.Trace;
import com.jihuanshe.model.UseBank;
import com.jihuanshe.model.User;
import com.jihuanshe.model.UserAddress;
import com.jihuanshe.model.VerifyInfo;
import com.jihuanshe.model.WantBuyList;
import com.jihuanshe.model.WantCard;
import com.jihuanshe.model.WarehouseInfo;
import com.jihuanshe.model.WarehouseProductInfo;
import com.jihuanshe.model.WithDrawResult;
import com.jihuanshe.net.ServiceApiKt;
import com.jihuanshe.net.api.FileInfo;
import com.jihuanshe.net.config.NetService;
import com.jihuanshe.ui.widget.GameBar;
import com.jihuanshe.wxapi.WXTool;
import h.t1;
import java.util.List;
import kotlinx.coroutines.flow.Flow;
import okhttp3.FormBody;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

@e.l.n.b(service = NetService.MARKET)
/* loaded from: classes2.dex */
public interface k {

    /* loaded from: classes2.dex */
    public static final class a {
        public static /* synthetic */ Flow a(k kVar, Integer num, Float f2, Integer num2, Integer num3, String str, String str2, String str3, int i2, Object obj) {
            if (obj == null) {
                return kVar.q(num, f2, num2, num3, str, str2, (i2 & 64) != 0 ? null : str3);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addProduct");
        }

        public static /* synthetic */ Flow b(k kVar, int i2, String str, String str2, int i3, Object obj) {
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
                return kVar.l(i2, str, str2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getAllAvailableReturnProducts");
        }

        public static /* synthetic */ Flow c(k kVar, String str, int i2, String str2, String str3, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    Game value = GameBar.b.a().getValue();
                    str2 = value == null ? null : value.getGameKey();
                    if (str2 == null) {
                        str2 = "";
                    }
                }
                if ((i3 & 8) != 0) {
                    Game value2 = GameBar.b.a().getValue();
                    String gameSubKey = value2 != null ? value2.getGameSubKey() : null;
                    str3 = gameSubKey != null ? gameSubKey : "";
                }
                return kVar.w(str, i2, str2, str3);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getAvailableReturnProducts");
        }

        public static /* synthetic */ Flow d(k kVar, Integer num, Integer num2, Integer num3, String str, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 1) != 0) {
                    num = null;
                }
                if ((i2 & 2) != 0) {
                    num2 = null;
                }
                if ((i2 & 4) != 0) {
                    num3 = null;
                }
                if ((i2 & 8) != 0) {
                    str = "order";
                }
                return kVar.U(num, num2, num3, str);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getExpressDetail");
        }

        public static /* synthetic */ Flow e(k kVar, String str, String str2, Integer num, int i2, String str3, String str4, int i3, Object obj) {
            String str5;
            String str6;
            if (obj == null) {
                if ((i3 & 16) != 0) {
                    Game value = GameBar.b.a().getValue();
                    String gameKey = value == null ? null : value.getGameKey();
                    if (gameKey == null) {
                        gameKey = "";
                    }
                    str5 = gameKey;
                } else {
                    str5 = str3;
                }
                if ((i3 & 32) != 0) {
                    Game value2 = GameBar.b.a().getValue();
                    String gameSubKey = value2 != null ? value2.getGameSubKey() : null;
                    str6 = gameSubKey != null ? gameSubKey : "";
                } else {
                    str6 = str4;
                }
                return kVar.o(str, str2, num, i2, str5, str6);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getFailProducts");
        }

        public static /* synthetic */ Flow f(k kVar, int i2, int i3, String str, String str2, int i4, Object obj) {
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
                return kVar.m0(i2, i3, str, str2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getOrderProducts");
        }

        public static /* synthetic */ Flow g(k kVar, Integer num, String str, int i2, String str2, String str3, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 8) != 0) {
                    Game value = GameBar.b.a().getValue();
                    str2 = value == null ? null : value.getGameKey();
                    if (str2 == null) {
                        str2 = "";
                    }
                }
                String str4 = str2;
                if ((i3 & 16) != 0) {
                    Game value2 = GameBar.b.a().getValue();
                    String gameSubKey = value2 != null ? value2.getGameSubKey() : null;
                    str3 = gameSubKey != null ? gameSubKey : "";
                }
                return kVar.c0(num, str, i2, str4, str3);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getSoldProducts");
        }

        public static /* synthetic */ Flow h(k kVar, Integer num, String str, int i2, int i3, String str2, String str3, int i4, Object obj) {
            String str4;
            String str5;
            if (obj == null) {
                if ((i4 & 16) != 0) {
                    Game value = GameBar.b.a().getValue();
                    str4 = value == null ? null : value.getGameKey();
                } else {
                    str4 = str2;
                }
                if ((i4 & 32) != 0) {
                    Game value2 = GameBar.b.a().getValue();
                    str5 = value2 == null ? null : value2.getGameSubKey();
                } else {
                    str5 = str3;
                }
                return kVar.d(num, str, i2, i3, str4, str5);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getWantCardList");
        }

        public static /* synthetic */ Flow i(k kVar, String str, String str2, int i2, Object obj) {
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
                return kVar.s0(str, str2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getWarehouseInfo");
        }

        public static /* synthetic */ Flow j(k kVar, String str, int i2, String str2, String str3, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    Game value = GameBar.b.a().getValue();
                    str2 = value == null ? null : value.getGameKey();
                    if (str2 == null) {
                        str2 = "";
                    }
                }
                if ((i3 & 8) != 0) {
                    Game value2 = GameBar.b.a().getValue();
                    String gameSubKey = value2 != null ? value2.getGameSubKey() : null;
                    str3 = gameSubKey != null ? gameSubKey : "";
                }
                return kVar.E(str, i2, str2, str3);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getWarehouseOrders");
        }

        public static /* synthetic */ Flow k(k kVar, String str, String str2, String str3, String str4, String str5, int i2, String str6, String str7, int i3, Object obj) {
            String str8;
            String str9;
            if (obj == null) {
                if ((i3 & 64) != 0) {
                    Game value = GameBar.b.a().getValue();
                    String gameKey = value == null ? null : value.getGameKey();
                    if (gameKey == null) {
                        gameKey = "";
                    }
                    str8 = gameKey;
                } else {
                    str8 = str6;
                }
                if ((i3 & 128) != 0) {
                    Game value2 = GameBar.b.a().getValue();
                    String gameSubKey = value2 != null ? value2.getGameSubKey() : null;
                    str9 = gameSubKey != null ? gameSubKey : "";
                } else {
                    str9 = str7;
                }
                return kVar.f0(str, str2, str3, str4, str5, i2, str8, str9);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getWarehouseProducts");
        }

        public static /* synthetic */ Flow l(k kVar, String str, int i2, String str2, String str3, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    Game value = GameBar.b.a().getValue();
                    str2 = value == null ? null : value.getGameKey();
                    if (str2 == null) {
                        str2 = "";
                    }
                }
                if ((i3 & 8) != 0) {
                    Game value2 = GameBar.b.a().getValue();
                    String gameSubKey = value2 != null ? value2.getGameSubKey() : null;
                    str3 = gameSubKey != null ? gameSubKey : "";
                }
                return kVar.g(str, i2, str2, str3);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getWarehouseReturnOrders");
        }

        public static /* synthetic */ Flow m(k kVar, Integer num, float f2, String str, String str2, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 4) != 0) {
                    Game value = GameBar.b.a().getValue();
                    str = value == null ? null : value.getGameKey();
                    if (str == null) {
                        str = "";
                    }
                }
                if ((i2 & 8) != 0) {
                    Game value2 = GameBar.b.a().getValue();
                    String gameSubKey = value2 != null ? value2.getGameSubKey() : null;
                    str2 = gameSubKey != null ? gameSubKey : "";
                }
                return kVar.t(num, f2, str, str2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: modifyPrice");
        }

        public static /* synthetic */ Flow n(k kVar, int i2, String str, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    str = WXTool.a.b();
                }
                return kVar.z(i2, str);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: orderReturnPay");
        }

        public static /* synthetic */ Flow o(k kVar, String str, String str2, int i2, Object obj) {
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
                return kVar.t0(str, str2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: productsOffAllSold");
        }

        public static /* synthetic */ Flow p(k kVar, Integer num, float f2, String str, String str2, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 4) != 0) {
                    Game value = GameBar.b.a().getValue();
                    str = value == null ? null : value.getGameKey();
                    if (str == null) {
                        str = "";
                    }
                }
                if ((i2 & 8) != 0) {
                    Game value2 = GameBar.b.a().getValue();
                    String gameSubKey = value2 != null ? value2.getGameSubKey() : null;
                    str2 = gameSubKey != null ? gameSubKey : "";
                }
                return kVar.r0(num, f2, str, str2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: productsOffSold");
        }

        public static /* synthetic */ Flow q(k kVar, String str, String str2, int i2, Object obj) {
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
                return kVar.i(str, str2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: productsOnAllSold");
        }

        public static /* synthetic */ Flow r(k kVar, Integer num, float f2, String str, String str2, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 4) != 0) {
                    Game value = GameBar.b.a().getValue();
                    str = value == null ? null : value.getGameKey();
                    if (str == null) {
                        str = "";
                    }
                }
                if ((i2 & 8) != 0) {
                    Game value2 = GameBar.b.a().getValue();
                    String gameSubKey = value2 != null ? value2.getGameSubKey() : null;
                    str2 = gameSubKey != null ? gameSubKey : "";
                }
                return kVar.h(num, f2, str, str2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: productsOnSold");
        }

        public static /* synthetic */ Flow s(k kVar, int i2, Integer num, Integer num2, String str, Integer num3, String str2, String str3, int i3, Object obj) {
            String str4;
            String str5;
            if (obj == null) {
                Integer num4 = (i3 & 16) != 0 ? 1 : num3;
                if ((i3 & 32) != 0) {
                    Game value = GameBar.b.a().getValue();
                    String gameKey = value == null ? null : value.getGameKey();
                    if (gameKey == null) {
                        gameKey = "";
                    }
                    str4 = gameKey;
                } else {
                    str4 = str2;
                }
                if ((i3 & 64) != 0) {
                    Game value2 = GameBar.b.a().getValue();
                    String gameSubKey = value2 != null ? value2.getGameSubKey() : null;
                    str5 = gameSubKey != null ? gameSubKey : "";
                } else {
                    str5 = str3;
                }
                return kVar.k0(i2, num, num2, str, num4, str4, str5);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: returnOrders");
        }

        public static /* synthetic */ Flow t(k kVar, String str, String str2, int i2, String str3, String str4, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 8) != 0) {
                    Game value = GameBar.b.a().getValue();
                    str3 = value == null ? null : value.getGameKey();
                    if (str3 == null) {
                        str3 = "";
                    }
                }
                String str5 = str3;
                if ((i3 & 16) != 0) {
                    Game value2 = GameBar.b.a().getValue();
                    String gameSubKey = value2 != null ? value2.getGameSubKey() : null;
                    str4 = gameSubKey != null ? gameSubKey : "";
                }
                return kVar.q0(str, str2, i2, str5, str4);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: search");
        }

        public static /* synthetic */ Flow u(k kVar, String str, String str2, String str3, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 4) != 0) {
                    str3 = "其他银行";
                }
                return kVar.d0(str, str2, str3);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: searchBank");
        }

        public static /* synthetic */ Flow v(k kVar, FormBody formBody, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 1) != 0) {
                    formBody = ServiceApiKt.a();
                }
                return kVar.u0(formBody);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: withDraw");
        }

        public static /* synthetic */ Flow w(k kVar, FormBody formBody, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 1) != 0) {
                    formBody = ServiceApiKt.a();
                }
                return kVar.j(formBody);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: withDrawWx");
        }
    }

    @l.y.f("violations")
    @k.e.a.d
    Flow<List<IllegalData>> A();

    @l.y.f("desires")
    @k.e.a.d
    Flow<e.l.h.i.e<Product>> B(@k.e.a.e @l.y.t("type") String str, @k.e.a.e @l.y.t("game_key") String str2, @k.e.a.e @l.y.t("game_sub_key") String str3, @k.e.a.e @l.y.t("keyword") String str4, @l.y.t("page") int i2);

    @l.y.f("packs")
    @k.e.a.d
    Flow<List<SellCalendar>> C(@k.e.a.e @l.y.t("game_sub_key_id") String str);

    @l.y.f("wechat-pay-ecommerce/apply-merchant-info")
    @k.e.a.d
    Flow<VerifyInfo> D();

    @l.y.f("warehouse-orders")
    @k.e.a.d
    Flow<e.l.h.i.e<CardConsignmentInfo>> E(@k.e.a.d @l.y.t("status") String str, @l.y.t("page") int i2, @k.e.a.e @l.y.t("game_key") String str2, @k.e.a.e @l.y.t("game_sub_key") String str3);

    @l.y.e
    @l.y.o("ban-list/add")
    @k.e.a.d
    Flow<t1> F(@l.y.c("ban_user_id") @k.e.a.d String str);

    @l.y.f("wechat-pay-ecommerce/query-apply-merchant")
    @k.e.a.d
    Flow<ConfirmState> G();

    @l.y.e
    @l.y.o("sellers/products/on")
    @k.e.a.d
    Flow<t1> H(@k.e.a.e @l.y.c("product_id") Integer num, @k.e.a.e @l.y.c("price") Float f2, @k.e.a.e @l.y.c("condition") Integer num2, @k.e.a.e @l.y.c("remark") String str, @k.e.a.e @l.y.c("quantity") Integer num3);

    @l.y.e
    @l.y.o("wishes/remove-by-wish-id")
    @k.e.a.d
    Flow<t1> I(@k.e.a.e @l.y.c("wish_id") Integer num);

    @l.y.f("wechat-pay-ecommerce/get-province-city")
    @k.e.a.d
    Flow<CityCodeSet> J();

    @l.y.e
    @l.y.o("auth/bind-phone")
    @k.e.a.d
    Flow<t1> K(@l.y.c("phone") @k.e.a.d String str, @l.y.c("code") @k.e.a.d String str2, @k.e.a.e @l.y.t("token") String str3);

    @l.y.f("sellers/orders")
    @k.e.a.d
    Flow<e.l.h.i.e<SellerOrderInfo>> L(@k.e.a.d @l.y.t("status") String str, @k.e.a.e @l.y.t("keyword") String str2, @l.y.t("page") int i2);

    @l.y.f("wechat-pay-ecommerce/get-balance")
    @k.e.a.d
    Flow<User> M();

    @l.y.e
    @l.y.o("wechat-pay-ecommerce/apply-merchant")
    @k.e.a.d
    Flow<t1> N(@l.y.c("id_card_name") @k.e.a.d String str, @l.y.c("id_card_number") @k.e.a.d String str2, @l.y.c("id_card_valid_time_begin") @k.e.a.d String str3, @l.y.c("id_card_valid_time") @k.e.a.d String str4, @l.y.c("mobile_phone") @k.e.a.d String str5, @l.y.c("id_card_a_url") @k.e.a.d String str6, @l.y.c("id_card_b_url") @k.e.a.d String str7, @l.y.c("account_bank") @k.e.a.d String str8, @l.y.c("bank_address_code") @k.e.a.d String str9, @k.e.a.e @l.y.c("bank_name") String str10, @l.y.c("account_number") @k.e.a.d String str11);

    @l.y.f("wechat-pay-ecommerce/query-settlement")
    @k.e.a.d
    Flow<UseBank> O();

    @l.y.b("sellers/products/{product_id}")
    @k.e.a.d
    Flow<t1> P(@k.e.a.e @l.y.s("product_id") Integer num);

    @l.y.e
    @l.y.o("wish-list")
    @k.e.a.d
    Flow<WantBuyList> Q(@k.e.a.e @l.y.c("name") String str, @k.e.a.e @l.y.c("game_key") String str2, @k.e.a.e @l.y.c("game_sub_key") String str3);

    @l.y.f("addresses")
    @k.e.a.d
    Flow<List<UserAddress>> R(@k.e.a.e @l.y.t("is_default") Integer num);

    @l.y.e
    @k.e.a.d
    @l.y.p("wish-list/{wid}")
    Flow<t1> S(@k.e.a.e @l.y.s("wid") Integer num, @k.e.a.e @l.y.c("name") String str);

    @l.y.f("express")
    @k.e.a.d
    Flow<ExpressList> T();

    @l.y.f("express/query")
    @k.e.a.d
    Flow<Trace> U(@k.e.a.e @l.y.t("order_id") Integer num, @k.e.a.e @l.y.t("warehouse_order_id") Integer num2, @k.e.a.e @l.y.t("warehouse_return_order_id") Integer num3, @k.e.a.d @l.y.t("type") String str);

    @l.y.b("addresses/{id}")
    @k.e.a.d
    Flow<t1> V(@l.y.s("id") int i2);

    @l.y.e
    @l.y.o("desires")
    @k.e.a.d
    Flow<t1> W(@k.e.a.e @l.y.c("type") String str, @k.e.a.e @l.y.c("card_version_id") Integer num, @k.e.a.e @l.y.c("pack_id") Integer num2, @k.e.a.e @l.y.c("game_key") String str2, @k.e.a.e @l.y.c("game_sub_key") String str3);

    @l.y.e
    @k.e.a.d
    @l.y.p("wishes/{wid}")
    Flow<t1> X(@k.e.a.e @l.y.s("wid") Integer num, @k.e.a.e @l.y.c("wish_price") Float f2, @l.y.c("quantity") int i2, @k.e.a.e @l.y.c("remark") String str, @l.y.c("ignore_card_version") int i3, @k.e.a.e @l.y.c("card_version_id") Integer num2);

    @l.y.e
    @l.y.o("wishes/add")
    @k.e.a.d
    Flow<t1> Y(@k.e.a.e @l.y.c("wish_price") Float f2, @k.e.a.e @l.y.c("quantity") Integer num, @k.e.a.e @l.y.c("remark") String str, @k.e.a.e @l.y.c("ignore_card_version") Integer num2, @k.e.a.e @l.y.c("card_version_id") Integer num3, @k.e.a.e @l.y.c("game_key") String str2, @k.e.a.e @l.y.c("wish_list_id") Integer num4);

    @l.y.e
    @l.y.o("wechat-pay-ecommerce/modify-settlement")
    @k.e.a.d
    Flow<t1> Z(@l.y.c("account_bank") @k.e.a.d String str, @l.y.c("bank_address_code") @k.e.a.d String str2, @k.e.a.e @l.y.c("bank_name") String str3, @k.e.a.e @l.y.c("bank_branch_id") String str4, @l.y.c("account_number") @k.e.a.d String str5);

    @l.y.e
    @l.y.o("carts/clear")
    @k.e.a.d
    Flow<t1> a(@l.y.c("seller_user_id") int i2);

    @l.y.f("rarities/getRaritiesByGame")
    @k.e.a.d
    Flow<List<List<String>>> a0(@k.e.a.d @l.y.t("game_key") String str, @k.e.a.d @l.y.t("game_sub_key") String str2);

    @l.y.f("users")
    @k.e.a.d
    Flow<e.l.h.i.e<User>> b(@k.e.a.e @l.y.t("keyword") String str, @l.y.t("page") int i2);

    @l.y.f("orders")
    @k.e.a.d
    Flow<e.l.h.i.e<OrderInfo>> b0(@k.e.a.d @l.y.t("status") String str, @k.e.a.e @l.y.t("keyword") String str2, @l.y.t("page") int i2);

    @l.y.f("warehouse-orders/{warehouse_order_id}")
    @k.e.a.d
    Flow<CardConsignmentInfo> c(@k.e.a.e @l.y.s("warehouse_order_id") Integer num);

    @l.y.f("warehouse-products/get-sold-products")
    @k.e.a.d
    Flow<e.l.h.i.e<SoldProductInfo>> c0(@k.e.a.e @l.y.t("pay_status") Integer num, @k.e.a.e @l.y.t("keyword") String str, @l.y.t("page") int i2, @k.e.a.e @l.y.t("game_key") String str2, @k.e.a.e @l.y.t("game_sub_key") String str3);

    @l.y.f("wishes")
    @k.e.a.d
    Flow<e.l.h.i.e<WantCard>> d(@k.e.a.e @l.y.t("user_id") Integer num, @k.e.a.e @l.y.t("keyword") String str, @l.y.t("wish_list_id") int i2, @l.y.t("page") int i3, @k.e.a.e @l.y.t("game_key") String str2, @k.e.a.e @l.y.t("game_sub_key") String str3);

    @l.y.f("wechat-pay-ecommerce/get-banks")
    @k.e.a.d
    Flow<List<BankDetail>> d0(@k.e.a.d @l.y.t("keyword1") String str, @k.e.a.d @l.y.t("keyword2") String str2, @k.e.a.d @l.y.t("bank") String str3);

    @l.y.f("sellers/withdraw/withdrawLogs")
    @k.e.a.d
    Flow<e.l.h.i.e<CoinLog>> e(@l.y.t("page") int i2);

    @l.y.f("wish-list")
    @k.e.a.d
    Flow<e.l.h.i.e<WantBuyList>> e0(@k.e.a.e @l.y.t("game_key") String str, @k.e.a.e @l.y.t("game_sub_key") String str2, @l.y.t("page") int i2);

    @l.y.e
    @l.y.o("desires/remove")
    @k.e.a.d
    Flow<t1> f(@k.e.a.e @l.y.c("type") String str, @k.e.a.e @l.y.c("card_version_id") Integer num, @k.e.a.e @l.y.c("pack_id") Integer num2, @k.e.a.e @l.y.c("game_key") String str2, @k.e.a.e @l.y.c("game_sub_key") String str3);

    @l.y.f("warehouse-products")
    @k.e.a.d
    Flow<e.l.h.i.e<WarehouseProductInfo>> f0(@k.e.a.d @l.y.t("status") String str, @k.e.a.e @l.y.t("keyword") String str2, @k.e.a.e @l.y.t("rarity") String str3, @k.e.a.e @l.y.t("game_key") String str4, @k.e.a.e @l.y.t("game_sub_key") String str5, @l.y.t("page") int i2, @k.e.a.e @l.y.t("game_key") String str6, @k.e.a.e @l.y.t("game_sub_key") String str7);

    @l.y.f("warehouse-return-orders")
    @k.e.a.d
    Flow<e.l.h.i.e<CardConsignmentInfo>> g(@k.e.a.d @l.y.t("status") String str, @l.y.t("page") int i2, @k.e.a.e @l.y.t("game_key") String str2, @k.e.a.e @l.y.t("game_sub_key") String str3);

    @l.y.e
    @l.y.o("auth/commitVerifyData")
    @k.e.a.d
    Flow<t1> g0(@l.y.c("merchant_name") @k.e.a.d String str, @l.y.c("phone") @k.e.a.d String str2, @l.y.c("email") @k.e.a.d String str3, @l.y.c("business_license") @k.e.a.d String str4, @l.y.c("id_card_a") @k.e.a.d String str5, @l.y.c("id_card_b") @k.e.a.d String str6, @l.y.c("bank") @k.e.a.d String str7, @l.y.c("branch_bank") @k.e.a.d String str8, @l.y.c("bank_account") @k.e.a.d String str9);

    @l.y.e
    @l.y.o("warehouse-products/on")
    @k.e.a.d
    Flow<t1> h(@k.e.a.e @l.y.c("warehouse_product_id") Integer num, @l.y.c("price") float f2, @k.e.a.e @l.y.c("game_key") String str, @k.e.a.e @l.y.c("game_sub_key") String str2);

    @l.y.f("warehouse-return-orders/{warehouse_return_order_id}")
    @k.e.a.d
    Flow<OrderReturnDetail> h0(@l.y.s("warehouse_return_order_id") int i2);

    @l.y.e
    @l.y.o("warehouse-products/on-all")
    @k.e.a.d
    Flow<t1> i(@k.e.a.e @l.y.c("game_key") String str, @k.e.a.e @l.y.c("game_sub_key") String str2);

    @l.y.b("wish-list/{wid}")
    @k.e.a.d
    Flow<t1> i0(@k.e.a.e @l.y.s("wid") Integer num);

    @l.y.o("wechat-pay-ecommerce/withdraw")
    @k.e.a.d
    Flow<WithDrawResult> j(@l.y.a @k.e.a.d FormBody formBody);

    @l.y.f("sellers/products/images")
    @k.e.a.d
    Flow<e.l.h.i.e<RecentPhoto>> j0(@k.e.a.e @l.y.t("game_key") String str, @k.e.a.e @l.y.t("card_version_id") Integer num, @l.y.t("page") int i2);

    @l.y.e
    @l.y.o("sellers/products/off")
    @k.e.a.d
    Flow<t1> k(@k.e.a.e @l.y.c("product_id") Integer num);

    @l.y.e
    @l.y.o("warehouse-return-orders")
    @k.e.a.d
    Flow<ReturnOrderResult> k0(@l.y.c("address_id") int i2, @k.e.a.e @l.y.c("only_fail") Integer num, @k.e.a.e @l.y.c("select_return") Integer num2, @k.e.a.e @l.y.c("return_warehouse_products") String str, @k.e.a.e @l.y.c("pay_now") Integer num3, @k.e.a.e @l.y.c("game_key") String str2, @k.e.a.e @l.y.c("game_sub_key") String str3);

    @l.y.f("warehouse-return-orders/get-all-available-return-products")
    @k.e.a.d
    Flow<e.l.h.i.e<ReturnCardInfo>> l(@l.y.t("page") int i2, @k.e.a.e @l.y.t("game_key") String str, @k.e.a.e @l.y.t("game_sub_key") String str2);

    @l.y.e
    @l.y.o("wishes/remove")
    @k.e.a.d
    Flow<t1> l0(@k.e.a.e @l.y.c("card_version_id") Integer num, @k.e.a.e @l.y.c("game_key") String str, @k.e.a.e @l.y.c("game_sub_key") String str2, @k.e.a.e @l.y.c("wish_list_id") Integer num2);

    @l.y.f("ban-list")
    @k.e.a.d
    Flow<e.l.h.i.e<BanUser>> m(@l.y.t("page") int i2);

    @l.y.f("warehouse-return-orders/get-return-order-products")
    @k.e.a.d
    Flow<Result<e.l.h.i.e<OrderReturnInfo>>> m0(@l.y.t("warehouse_return_order_id") int i2, @l.y.t("page") int i3, @k.e.a.e @l.y.t("game_key") String str, @k.e.a.e @l.y.t("game_sub_key") String str2);

    @l.y.e
    @l.y.o("addresses")
    @k.e.a.d
    Flow<UserAddress> n(@l.y.c("name") @k.e.a.d String str, @l.y.c("phone") @k.e.a.d String str2, @l.y.c("province") @k.e.a.d String str3, @l.y.c("city") @k.e.a.d String str4, @l.y.c("district") @k.e.a.d String str5, @l.y.c("address") @k.e.a.d String str6, @k.e.a.e @l.y.c("postcode") String str7, @l.y.c("is_default") int i2);

    @l.y.e
    @l.y.o("packs/by-game-pack-id")
    @k.e.a.d
    Flow<List<Product>> n0(@l.y.c("game_pack_id") @k.e.a.d String str);

    @l.y.f("warehouse-products/get-fail-products")
    @k.e.a.d
    Flow<e.l.h.i.e<FailProductInfo>> o(@k.e.a.e @l.y.t("status") String str, @k.e.a.e @l.y.t("keyword") String str2, @k.e.a.e @l.y.t("warehouse_order_id") Integer num, @l.y.t("page") int i2, @k.e.a.e @l.y.t("game_key") String str3, @k.e.a.e @l.y.t("game_sub_key") String str4);

    @l.y.e
    @l.y.o("ban-list/remove")
    @k.e.a.d
    Flow<t1> o0(@l.y.c("ban_user_id") int i2);

    @l.y.o("etiquette-questions/submit")
    @k.e.a.d
    Flow<List<EtiquetteExamResult>> p(@l.y.a @k.e.a.d RequestBody requestBody);

    @l.y.e
    @k.e.a.d
    @l.y.p("addresses/{id}")
    Flow<t1> p0(@l.y.s("id") int i2, @l.y.c("name") @k.e.a.d String str, @l.y.c("phone") @k.e.a.d String str2, @l.y.c("province") @k.e.a.d String str3, @l.y.c("city") @k.e.a.d String str4, @l.y.c("district") @k.e.a.d String str5, @l.y.c("address") @k.e.a.d String str6, @k.e.a.e @l.y.c("postcode") String str7, @l.y.c("is_default") int i3);

    @l.y.e
    @l.y.o("sellers/products")
    @k.e.a.d
    Flow<t1> q(@k.e.a.e @l.y.c("card_version_id") Integer num, @k.e.a.e @l.y.c("price") Float f2, @k.e.a.e @l.y.c("quantity") Integer num2, @k.e.a.e @l.y.c("condition") Integer num3, @k.e.a.e @l.y.c("remark") String str, @k.e.a.e @l.y.c("game_key") String str2, @k.e.a.e @l.y.c("product_card_version_image") String str3);

    @l.y.f("cards")
    @k.e.a.d
    Flow<Result<e.l.h.i.b<e.l.h.i.e<Product>>>> q0(@k.e.a.d @l.y.t("keyword") String str, @k.e.a.e @l.y.t("rarity") String str2, @l.y.t("page") int i2, @k.e.a.e @l.y.t("game_key") String str3, @k.e.a.e @l.y.t("game_sub_key") String str4);

    @l.y.f("etiquette-questions")
    @k.e.a.d
    Flow<List<EtiquetteQuestion>> r();

    @l.y.e
    @l.y.o("warehouse-products/off")
    @k.e.a.d
    Flow<t1> r0(@k.e.a.e @l.y.c("warehouse_product_id") Integer num, @l.y.c("price") float f2, @k.e.a.e @l.y.c("game_key") String str, @k.e.a.e @l.y.c("game_sub_key") String str2);

    @l.y.f("carts/sellers")
    @k.e.a.d
    Flow<e.l.h.i.e<ShopCartItem>> s(@l.y.t("page") int i2);

    @l.y.f("auth/get-warehouse-user-info")
    @k.e.a.d
    Flow<WarehouseInfo> s0(@k.e.a.e @l.y.t("game_key") String str, @k.e.a.e @l.y.t("game_sub_key") String str2);

    @l.y.e
    @l.y.o("warehouse-products/modify-price")
    @k.e.a.d
    Flow<t1> t(@k.e.a.e @l.y.c("warehouse_product_id") Integer num, @l.y.c("price") float f2, @k.e.a.e @l.y.c("game_key") String str, @k.e.a.e @l.y.c("game_sub_key") String str2);

    @l.y.e
    @l.y.o("warehouse-products/off-all")
    @k.e.a.d
    Flow<t1> t0(@k.e.a.e @l.y.c("game_key") String str, @k.e.a.e @l.y.c("game_sub_key") String str2);

    @k.e.a.e
    @l.y.o("file/upload")
    @l.y.l
    Object u(@l.y.q @k.e.a.d MultipartBody.Part part, @l.y.q("type") @k.e.a.d RequestBody requestBody, @k.e.a.d h.e2.c<? super l.r<Result<FileInfo>>> cVar);

    @l.y.o("sellers/withdraw")
    @k.e.a.d
    Flow<WithDrawResult> u0(@l.y.a @k.e.a.d FormBody formBody);

    @l.y.e
    @l.y.o("wish-list/set-default")
    @k.e.a.d
    Flow<t1> v(@k.e.a.e @l.y.c("game_key") String str, @k.e.a.e @l.y.c("game_sub_key") String str2, @l.y.c("wish_list_id") int i2);

    @l.y.f("warehouse-return-orders/get-available-return-products")
    @k.e.a.d
    Flow<e.l.h.i.e<ReturnCardInfo>> w(@k.e.a.d @l.y.t("pass_or_fail") String str, @l.y.t("page") int i2, @k.e.a.e @l.y.t("game_key") String str2, @k.e.a.e @l.y.t("game_sub_key") String str3);

    @l.y.e
    @k.e.a.d
    @l.y.p("sellers/products/{id}")
    Flow<t1> x(@k.e.a.e @l.y.s("id") Integer num, @k.e.a.e @l.y.c("price") Float f2, @k.e.a.e @l.y.c("condition") Integer num2, @k.e.a.e @l.y.c("remark") String str, @k.e.a.e @l.y.c("quantity") Integer num3, @k.e.a.e @l.y.c("product_card_version_image") String str2, @k.e.a.e @l.y.c("on_sale") Integer num4, @k.e.a.e @l.y.c("default") Integer num5);

    @l.y.f("sellers/products/{id}")
    @k.e.a.d
    Flow<GameCard> y(@l.y.s("id") int i2);

    @l.y.e
    @l.y.o("warehouse-return-orders/pay")
    @k.e.a.d
    Flow<PayParams> z(@l.y.c("warehouse_return_order_id") int i2, @l.y.c("app_id") @k.e.a.d String str);
}
