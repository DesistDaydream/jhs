package e.l.n.c;

import com.jihuanshe.model.ShopCarResult;
import com.jihuanshe.net.config.NetService;
import h.t1;
import kotlinx.coroutines.flow.Flow;

@e.l.n.b(service = NetService.CARTS)
/* loaded from: classes2.dex */
public interface e {
    @l.y.e
    @l.y.o("clear")
    @k.e.a.d
    Flow<t1> a(@l.y.c("seller_user_id") int i2);

    @l.y.e
    @l.y.o("remove")
    @k.e.a.d
    Flow<ShopCarResult> b(@l.y.c("cart_id") int i2);
}
