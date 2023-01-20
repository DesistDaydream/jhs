package com.jihuanshe.ui.page.search;

import android.app.Activity;
import android.widget.TextView;
import com.donkingliang.labels.LabelsView;
import com.jihuanshe.ui.page.search.DefaultSearchHistoryViewImpl;
import e.l.q.b.j.b;
import e.t.j.h.g;
import java.util.List;
import k.e.a.d;
import kotlin.collections.CollectionsKt___CollectionsKt;

/* loaded from: classes2.dex */
public final class DefaultSearchHistoryViewImpl implements b {
    @d
    private final Activity a;
    @d
    private final e.l.s.m.b b;
    @d

    /* renamed from: c */
    private final g f4035c = e.t.j.h.d.a.a(new DefaultSearchHistoryViewImpl$onClickClear$1(this));
    @d

    /* renamed from: d */
    private final LabelsView.c f4036d = new LabelsView.c() { // from class: e.l.q.b.j.a
        {
            DefaultSearchHistoryViewImpl.this = this;
        }

        @Override // com.donkingliang.labels.LabelsView.c
        public final void a(TextView textView, Object obj, int i2) {
            DefaultSearchHistoryViewImpl.h(DefaultSearchHistoryViewImpl.this, textView, obj, i2);
        }
    };

    public DefaultSearchHistoryViewImpl(@d Activity activity, @d e.l.s.m.b bVar) {
        this.a = activity;
        this.b = bVar;
    }

    public static final void h(DefaultSearchHistoryViewImpl defaultSearchHistoryViewImpl, TextView textView, Object obj, int i2) {
        List<String> value = defaultSearchHistoryViewImpl.b.x().getValue();
        String str = value == null ? null : (String) CollectionsKt___CollectionsKt.J2(value, i2);
        if (str == null) {
            return;
        }
        defaultSearchHistoryViewImpl.b.T(str);
        defaultSearchHistoryViewImpl.b.o(str);
    }

    @Override // e.l.q.b.j.b
    @d
    public g a() {
        return this.f4035c;
    }

    @Override // e.l.q.b.j.b
    @d
    public LabelsView.c b() {
        return this.f4036d;
    }

    @d
    public final g e() {
        return this.f4035c;
    }

    @d
    public final LabelsView.c f() {
        return this.f4036d;
    }
}
