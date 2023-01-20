package e.j.a.b.c.u.b;

import com.google.android.gms.common.server.response.FastParser;
import java.io.BufferedReader;
import java.io.IOException;

/* loaded from: classes2.dex */
public final class b implements FastParser.a<Long> {
    @Override // com.google.android.gms.common.server.response.FastParser.a
    public final /* synthetic */ Long a(FastParser fastParser, BufferedReader bufferedReader) throws FastParser.ParseException, IOException {
        long s;
        s = fastParser.s(bufferedReader);
        return Long.valueOf(s);
    }
}
