package com.google.gson;

import com.google.gson.internal.LazilyParsedNumber;
import com.google.gson.stream.MalformedJsonException;
import e.j.e.p;
import e.j.e.u.a;
import java.io.IOException;
import java.math.BigDecimal;

/* loaded from: classes2.dex */
public enum ToNumberPolicy implements p {
    DOUBLE { // from class: com.google.gson.ToNumberPolicy.1
        @Override // e.j.e.p
        public Double readNumber(a aVar) throws IOException {
            return Double.valueOf(aVar.c0());
        }
    },
    LAZILY_PARSED_NUMBER { // from class: com.google.gson.ToNumberPolicy.2
        @Override // e.j.e.p
        public Number readNumber(a aVar) throws IOException {
            return new LazilyParsedNumber(aVar.A0());
        }
    },
    LONG_OR_DOUBLE { // from class: com.google.gson.ToNumberPolicy.3
        @Override // e.j.e.p
        public Number readNumber(a aVar) throws IOException, JsonParseException {
            String A0 = aVar.A0();
            try {
                try {
                    return Long.valueOf(Long.parseLong(A0));
                } catch (NumberFormatException unused) {
                    Double valueOf = Double.valueOf(A0);
                    if ((valueOf.isInfinite() || valueOf.isNaN()) && !aVar.J()) {
                        throw new MalformedJsonException("JSON forbids NaN and infinities: " + valueOf + "; at path " + aVar.F());
                    }
                    return valueOf;
                }
            } catch (NumberFormatException e2) {
                throw new JsonParseException("Cannot parse " + A0 + "; at path " + aVar.F(), e2);
            }
        }
    },
    BIG_DECIMAL { // from class: com.google.gson.ToNumberPolicy.4
        @Override // e.j.e.p
        public BigDecimal readNumber(a aVar) throws IOException {
            String A0 = aVar.A0();
            try {
                return new BigDecimal(A0);
            } catch (NumberFormatException e2) {
                throw new JsonParseException("Cannot parse " + A0 + "; at path " + aVar.F(), e2);
            }
        }
    }
}
