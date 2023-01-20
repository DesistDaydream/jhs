package e.j.e;

import com.google.gson.JsonIOException;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.MalformedJsonException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

/* loaded from: classes2.dex */
public final class k {
    public static h d(e.j.e.u.a aVar) throws JsonIOException, JsonSyntaxException {
        boolean J = aVar.J();
        aVar.H0(true);
        try {
            try {
                return e.j.e.s.i.a(aVar);
            } catch (OutOfMemoryError e2) {
                throw new JsonParseException("Failed parsing JSON source: " + aVar + " to Json", e2);
            } catch (StackOverflowError e3) {
                throw new JsonParseException("Failed parsing JSON source: " + aVar + " to Json", e3);
            }
        } finally {
            aVar.H0(J);
        }
    }

    public static h e(Reader reader) throws JsonIOException, JsonSyntaxException {
        try {
            e.j.e.u.a aVar = new e.j.e.u.a(reader);
            h d2 = d(aVar);
            if (!d2.y() && aVar.C0() != JsonToken.END_DOCUMENT) {
                throw new JsonSyntaxException("Did not consume the entire document.");
            }
            return d2;
        } catch (MalformedJsonException e2) {
            throw new JsonSyntaxException(e2);
        } catch (IOException e3) {
            throw new JsonIOException(e3);
        } catch (NumberFormatException e4) {
            throw new JsonSyntaxException(e4);
        }
    }

    public static h f(String str) throws JsonSyntaxException {
        return e(new StringReader(str));
    }

    @Deprecated
    public h a(e.j.e.u.a aVar) throws JsonIOException, JsonSyntaxException {
        return d(aVar);
    }

    @Deprecated
    public h b(Reader reader) throws JsonIOException, JsonSyntaxException {
        return e(reader);
    }

    @Deprecated
    public h c(String str) throws JsonSyntaxException {
        return f(str);
    }
}
