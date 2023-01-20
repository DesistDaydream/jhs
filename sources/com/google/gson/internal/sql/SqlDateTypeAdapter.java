package com.google.gson.internal.sql;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonToken;
import e.j.e.q;
import e.j.e.t.a;
import e.j.e.u.c;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/* loaded from: classes2.dex */
public final class SqlDateTypeAdapter extends TypeAdapter<Date> {
    public static final q b = new q() { // from class: com.google.gson.internal.sql.SqlDateTypeAdapter.1
        @Override // e.j.e.q
        public <T> TypeAdapter<T> a(Gson gson, a<T> aVar) {
            if (aVar.getRawType() == Date.class) {
                return new SqlDateTypeAdapter();
            }
            return null;
        }
    };
    private final DateFormat a;

    @Override // com.google.gson.TypeAdapter
    /* renamed from: j */
    public Date e(e.j.e.u.a aVar) throws IOException {
        java.util.Date parse;
        if (aVar.C0() == JsonToken.NULL) {
            aVar.x0();
            return null;
        }
        String A0 = aVar.A0();
        try {
            synchronized (this) {
                parse = this.a.parse(A0);
            }
            return new Date(parse.getTime());
        } catch (ParseException e2) {
            throw new JsonSyntaxException("Failed parsing '" + A0 + "' as SQL Date; at path " + aVar.F(), e2);
        }
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: k */
    public void i(c cVar, Date date) throws IOException {
        String format;
        if (date == null) {
            cVar.Y();
            return;
        }
        synchronized (this) {
            format = this.a.format((java.util.Date) date);
        }
        cVar.G0(format);
    }

    private SqlDateTypeAdapter() {
        this.a = new SimpleDateFormat("MMM d, yyyy");
    }
}
