package e.j.a.b.c.u.b;

import com.google.android.gms.common.server.response.FastParser;
import java.io.BufferedReader;
import java.io.IOException;

/* loaded from: classes2.dex */
public final class a implements FastParser.a<Integer> {
    @Override // com.google.android.gms.common.server.response.FastParser.a
    public final /* synthetic */ Integer a(FastParser fastParser, BufferedReader bufferedReader) throws FastParser.ParseException, IOException {
        int r;
        r = fastParser.r(bufferedReader);
        return Integer.valueOf(r);
    }
}
