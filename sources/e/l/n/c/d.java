package e.l.n.c;

import com.jihuanshe.base.model.Result;
import com.jihuanshe.model.ShopCarResult;
import com.jihuanshe.net.config.NetService;
import kotlinx.coroutines.flow.Flow;

@e.l.n.b(service = NetService.CARTS)
/* loaded from: classes2.dex */
public interface d {
    @l.y.e
    @l.y.o("increment")
    @k.e.a.d
    Flow<Result<ShopCarResult>> a(@l.y.c("product_id") int i2, @l.y.c("quantity") int i3);

    @l.y.e
    @l.y.o("decrement")
    @k.e.a.d
    Flow<Result<ShopCarResult>> b(@l.y.c("cart_id") int i2);
}
