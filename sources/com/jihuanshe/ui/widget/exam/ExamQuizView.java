package com.jihuanshe.ui.widget.exam;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.jihuanshe.R;
import com.jihuanshe.binding.RecyclerViewBinding;
import com.jihuanshe.model.EtiquetteQuestion;
import com.vector.ext.bind.BindViewKt;
import com.vector.util.LayoutManagers;
import e.l.h.j.b.f.b;
import e.l.q.c.s0.a;
import e.t.j.h.d;
import h.k2.h;
import h.k2.u.l;
import h.k2.v.n0;
import h.k2.v.u;
import h.m2.e;
import h.p2.n;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.PropertyReference1Impl;

/* loaded from: classes2.dex */
public final class ExamQuizView extends LinearLayout {

    /* renamed from: i  reason: collision with root package name */
    public static final /* synthetic */ n<Object>[] f4278i = {n0.r(new PropertyReference1Impl(n0.d(ExamQuizView.class), "recyclerView", "getRecyclerView()Landroidx/recyclerview/widget/RecyclerView;")), n0.r(new PropertyReference1Impl(n0.d(ExamQuizView.class), "questionTv", "getQuestionTv()Landroid/widget/TextView;"))};
    @d
    private final e a;
    @d
    private final e b;
    @k.e.a.e

    /* renamed from: c  reason: collision with root package name */
    private EtiquetteQuestion f4279c;
    @k.e.a.e

    /* renamed from: d  reason: collision with root package name */
    private l<? super Integer, t1> f4280d;
    @d

    /* renamed from: e  reason: collision with root package name */
    private final a f4281e;
    @d

    /* renamed from: f  reason: collision with root package name */
    private final LayoutManagers.a f4282f;
    @d

    /* renamed from: g  reason: collision with root package name */
    private final b f4283g;
    @d

    /* renamed from: h  reason: collision with root package name */
    private final e.t.j.h.l f4284h;

    @h
    public ExamQuizView(@d Context context) {
        this(context, null, 2, null);
    }

    public /* synthetic */ ExamQuizView(Context context, AttributeSet attributeSet, int i2, u uVar) {
        this(context, (i2 & 2) != 0 ? null : attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(int i2) {
        l<? super Integer, t1> lVar = this.f4280d;
        if (lVar != null) {
            lVar.invoke(Integer.valueOf(i2));
        }
        this.f4281e.y(i2);
        this.f4281e.notifyDataSetChanged();
    }

    private final void c() {
        TextView questionTv = getQuestionTv();
        EtiquetteQuestion etiquetteQuestion = this.f4279c;
        questionTv.setText(etiquetteQuestion == null ? null : etiquetteQuestion.getQuestion());
        this.f4281e.y(-1);
        RecyclerView recyclerView = getRecyclerView();
        a aVar = this.f4281e;
        EtiquetteQuestion etiquetteQuestion2 = this.f4279c;
        RecyclerViewBinding.b(recyclerView, aVar, etiquetteQuestion2 != null ? etiquetteQuestion2.getAnswer() : null, this.f4282f, null, null, null, this.f4283g);
    }

    private final TextView getQuestionTv() {
        return (TextView) this.b.a(this, f4278i[1]);
    }

    private final RecyclerView getRecyclerView() {
        return (RecyclerView) this.a.a(this, f4278i[0]);
    }

    @d
    public final e.t.j.h.l getOnItemClick() {
        return this.f4284h;
    }

    public final void setListener(@k.e.a.e l<? super Integer, t1> lVar) {
        this.f4280d = lVar;
    }

    public final void setQuestion(@d EtiquetteQuestion etiquetteQuestion) {
        this.f4279c = etiquetteQuestion;
        c();
    }

    @h
    public ExamQuizView(@d Context context, @k.e.a.e AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = BindViewKt.p(this, R.id.recyclerView);
        this.b = BindViewKt.p(this, R.id.questionTv);
        a aVar = new a(this);
        this.f4281e = aVar;
        LayoutManagers.a j2 = LayoutManagers.j(LayoutManagers.a, null, false, 3, null);
        this.f4282f = j2;
        b a = b.o.a(ExamQuizView$decoration$1.INSTANCE);
        this.f4283g = a;
        e.t.j.h.l a2 = d.e.a.a(new ExamQuizView$onItemClick$1(this));
        this.f4284h = a2;
        setOrientation(1);
        LayoutInflater.from(context).inflate(R.layout.view_quiz, (ViewGroup) this, true);
        RecyclerViewBinding.b(getRecyclerView(), aVar, null, j2, null, null, null, a);
        RecyclerViewBinding.f(getRecyclerView(), a2, null);
    }
}
