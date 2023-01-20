package e.j.a.b.c.u.b;

import com.google.android.gms.common.server.response.FastParser;
import java.io.BufferedReader;
import java.io.IOException;

/* loaded from: classes2.dex */
public final class c implements FastParser.a<Float> {
    @Override // com.google.android.gms.common.server.response.FastParser.a
    public final /* synthetic */ Float a(FastParser fastParser, BufferedReader bufferedReader) throws FastParser.ParseException, IOException {
        float w;
        w = fastParser.w(bufferedReader);
        return Float.valueOf(w);
    }
}
