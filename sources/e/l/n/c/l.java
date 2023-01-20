package e.l.n.c;

import com.jihuanshe.model.OrderConfirmResult;
import com.jihuanshe.model.OrderDetailInfo;
import com.jihuanshe.model.PayParams;
import com.jihuanshe.net.config.NetService;
import com.jihuanshe.wxapi.WXTool;
import h.t1;
import kotlinx.coroutines.flow.Flow;

@e.l.n.b(service = NetService.ORDER)
/* loaded from: classes2.dex */
public interface l {

    /* loaded from: classes2.dex */
    public static final class a {
        public static /* synthetic */ Flow a(l lVar, int i2, String str, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    str = WXTool.a.b();
                }
                return lVar.i(i2, str);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: pay");
        }
    }

    @l.y.f("{id}")
    @k.e.a.d
    Flow<OrderDetailInfo> a(@l.y.s("id") int i2);

    @l.y.e
    @l.y.o("cancel")
    @k.e.a.d
    Flow<t1> b(@l.y.c("order_id") int i2, @l.y.c("buyer_cancel_reason") @k.e.a.d String str);

    @l.y.e
    @l.y.o("returnGoods")
    @k.e.a.d
    Flow<t1> c(@l.y.c("order_id") int i2, @l.y.c("goods_status") int i3, @l.y.c("refund_reason") @k.e.a.d String str);

    @l.y.e
    @l.y.o("deferReceiveDeadline")
    @k.e.a.d
    Flow<t1> d(@l.y.c("order_id") int i2);

    @l.y.e
    @l.y.o("make")
    @k.e.a.d
    Flow<OrderConfirmResult> e(@k.e.a.e @l.y.c("order_preview_id") Integer num, @k.e.a.e @l.y.c("seller_user_id") Integer num2, @k.e.a.e @l.y.c("address_id") Integer num3, @k.e.a.e @l.y.c("remark") String str);

    @l.y.f("preview")
    @k.e.a.d
    Flow<n> f(@l.y.t("seller_user_id") int i2);

    @l.y.e
    @l.y.o("refund")
    @k.e.a.d
    Flow<t1> g(@l.y.c("order_id") int i2, @l.y.c("goods_status") int i3, @l.y.c("refund_reason") @k.e.a.d String str);

    @l.y.e
    @l.y.o("receive")
    @k.e.a.d
    Flow<t1> h(@l.y.c("order_id") int i2);

    @l.y.e
    @l.y.o("pay")
    @k.e.a.d
    Flow<PayParams> i(@l.y.c("order_id") int i2, @l.y.c("app_id") @k.e.a.d String str);
}
