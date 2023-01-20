package com.google.gson.internal.sql;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonToken;
import e.j.e.q;
import e.j.e.t.a;
import e.j.e.u.c;
import java.io.IOException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: classes2.dex */
public final class SqlTimeTypeAdapter extends TypeAdapter<Time> {
    public static final q b = new q() { // from class: com.google.gson.internal.sql.SqlTimeTypeAdapter.1
        @Override // e.j.e.q
        public <T> TypeAdapter<T> a(Gson gson, a<T> aVar) {
            if (aVar.getRawType() == Time.class) {
                return new SqlTimeTypeAdapter();
            }
            return null;
        }
    };
    private final DateFormat a;

    @Override // com.google.gson.TypeAdapter
    /* renamed from: j */
    public Time e(e.j.e.u.a aVar) throws IOException {
        Time time;
        if (aVar.C0() == JsonToken.NULL) {
            aVar.x0();
            return null;
        }
        String A0 = aVar.A0();
        try {
            synchronized (this) {
                time = new Time(this.a.parse(A0).getTime());
            }
            return time;
        } catch (ParseException e2) {
            throw new JsonSyntaxException("Failed parsing '" + A0 + "' as SQL Time; at path " + aVar.F(), e2);
        }
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: k */
    public void i(c cVar, Time time) throws IOException {
        String format;
        if (time == null) {
            cVar.Y();
            return;
        }
        synchronized (this) {
            format = this.a.format((Date) time);
        }
        cVar.G0(format);
    }

    private SqlTimeTypeAdapter() {
        this.a = new SimpleDateFormat("hh:mm:ss a");
    }
}
