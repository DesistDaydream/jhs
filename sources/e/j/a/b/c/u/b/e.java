package e.j.a.b.c.u.b;

import com.google.android.gms.common.server.response.FastParser;
import java.io.BufferedReader;
import java.io.IOException;

/* loaded from: classes2.dex */
public final class e implements FastParser.a<Boolean> {
    @Override // com.google.android.gms.common.server.response.FastParser.a
    public final /* synthetic */ Boolean a(FastParser fastParser, BufferedReader bufferedReader) throws FastParser.ParseException, IOException {
        boolean j2;
        j2 = fastParser.j(bufferedReader, false);
        return Boolean.valueOf(j2);
    }
}
