package e.j.a.b.c.u.b;

import com.google.android.gms.common.server.response.FastParser;
import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigInteger;

/* loaded from: classes2.dex */
public final class g implements FastParser.a<BigInteger> {
    @Override // com.google.android.gms.common.server.response.FastParser.a
    public final /* synthetic */ BigInteger a(FastParser fastParser, BufferedReader bufferedReader) throws FastParser.ParseException, IOException {
        BigInteger v;
        v = fastParser.v(bufferedReader);
        return v;
    }
}
