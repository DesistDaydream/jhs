package e.l.n.c;

import com.jihuanshe.model.ChangePriceResult;
import com.jihuanshe.model.OrderDetailInfo;
import com.jihuanshe.model.SellerOrderInfo;
import com.jihuanshe.net.config.NetService;
import h.t1;
import kotlinx.coroutines.flow.Flow;

@e.l.n.b(service = NetService.SELLER_ORDER)
/* loaded from: classes2.dex */
public interface t {
    @l.y.f("{order_id}")
    @k.e.a.d
    Flow<OrderDetailInfo> a(@l.y.s("order_id") int i2);

    @l.y.e
    @l.y.o("cancel")
    @k.e.a.d
    Flow<t1> b(@l.y.c("order_id") int i2, @l.y.c("seller_cancel_reason") @k.e.a.d String str);

    @l.y.e
    @l.y.o("agreeReturnGoods")
    @k.e.a.d
    Flow<t1> c(@l.y.c("order_id") int i2);

    @l.y.e
    @l.y.o("agreeRefund")
    @k.e.a.d
    Flow<t1> d(@l.y.c("order_id") int i2);

    @l.y.e
    @l.y.o("confirm")
    @k.e.a.d
    Flow<t1> e(@l.y.c("order_id") int i2);

    @l.y.e
    @l.y.o("disagreeReturnGoods")
    @k.e.a.d
    Flow<t1> f(@l.y.c("order_id") int i2);

    @l.y.e
    @l.y.o("disagreeRefund")
    @k.e.a.d
    Flow<SellerOrderInfo> g(@l.y.c("order_id") int i2);

    @l.y.e
    @l.y.o("modifyExpress")
    @k.e.a.d
    Flow<t1> h(@l.y.c("order_id") int i2, @l.y.c("express_type") int i3, @k.e.a.e @l.y.c("express_name") String str, @k.e.a.e @l.y.c("express_number") String str2);

    @l.y.e
    @l.y.o("deliver")
    @k.e.a.d
    Flow<t1> i(@l.y.c("order_id") int i2, @l.y.c("express_type") int i3, @k.e.a.e @l.y.c("express_name") String str, @k.e.a.e @l.y.c("express_number") String str2);

    @l.y.e
    @l.y.o("modifyPrice")
    @k.e.a.d
    Flow<ChangePriceResult> j(@l.y.c("order_id") int i2, @k.e.a.e @l.y.c("product_price") Float f2, @k.e.a.e @l.y.c("shipping_price") Float f3);
}
