package e.j.a.b.c.u.b;

import com.google.android.gms.common.server.response.FastParser;
import java.io.BufferedReader;
import java.io.IOException;

/* loaded from: classes2.dex */
public final class d implements FastParser.a<Double> {
    @Override // com.google.android.gms.common.server.response.FastParser.a
    public final /* synthetic */ Double a(FastParser fastParser, BufferedReader bufferedReader) throws FastParser.ParseException, IOException {
        double y;
        y = fastParser.y(bufferedReader);
        return Double.valueOf(y);
    }
}
