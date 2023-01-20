package e.t.h.b;

import android.content.Context;
import com.vector.compat.network.NetworkConnType;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b`\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u000b"}, d2 = {"Lcom/vector/compat/network/NetworkOption;", "", "getType", "Lcom/vector/compat/network/NetworkConnType;", "context", "Landroid/content/Context;", "isAvailable", "", "isCellular", "isConnected", "isWifi", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public interface b {

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class a {
        public static boolean a(@k.e.a.d b bVar, @k.e.a.d Context context) {
            return bVar.getType(context) == NetworkConnType.CELLULAR;
        }

        public static boolean b(@k.e.a.d b bVar, @k.e.a.d Context context) {
            return bVar.getType(context) == NetworkConnType.WIFI;
        }
    }

    boolean a(@k.e.a.d Context context);

    boolean b(@k.e.a.d Context context);

    boolean c(@k.e.a.d Context context);

    boolean d(@k.e.a.d Context context);

    @k.e.a.d
    NetworkConnType getType(@k.e.a.d Context context);
}
