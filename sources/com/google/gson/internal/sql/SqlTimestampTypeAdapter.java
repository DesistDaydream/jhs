package com.google.gson.internal.sql;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import e.j.e.q;
import e.j.e.t.a;
import e.j.e.u.c;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

/* loaded from: classes2.dex */
public class SqlTimestampTypeAdapter extends TypeAdapter<Timestamp> {
    public static final q b = new q() { // from class: com.google.gson.internal.sql.SqlTimestampTypeAdapter.1
        @Override // e.j.e.q
        public <T> TypeAdapter<T> a(Gson gson, a<T> aVar) {
            if (aVar.getRawType() == Timestamp.class) {
                return new SqlTimestampTypeAdapter(gson.q(Date.class));
            }
            return null;
        }
    };
    private final TypeAdapter<Date> a;

    @Override // com.google.gson.TypeAdapter
    /* renamed from: j */
    public Timestamp e(e.j.e.u.a aVar) throws IOException {
        Date e2 = this.a.e(aVar);
        if (e2 != null) {
            return new Timestamp(e2.getTime());
        }
        return null;
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: k */
    public void i(c cVar, Timestamp timestamp) throws IOException {
        this.a.i(cVar, timestamp);
    }

    private SqlTimestampTypeAdapter(TypeAdapter<Date> typeAdapter) {
        this.a = typeAdapter;
    }
}
