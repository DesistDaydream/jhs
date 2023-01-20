package com.jihuanshe.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import com.jihuanshe.R;
import com.jihuanshe.model.GradeDetail;
import com.vector.ext.bind.BindViewKt;
import h.k2.h;
import h.k2.v.n0;
import h.k2.v.u;
import h.m2.e;
import h.p2.n;
import java.util.List;
import k.e.a.d;
import kotlin.jvm.internal.PropertyReference1Impl;

/* loaded from: classes2.dex */
public class ScoreNumView extends FrameLayout {

    /* renamed from: f  reason: collision with root package name */
    public static final /* synthetic */ n<Object>[] f4201f = {n0.r(new PropertyReference1Impl(n0.d(ScoreNumView.class), "proBarA", "getProBarA()Landroid/widget/ProgressBar;")), n0.r(new PropertyReference1Impl(n0.d(ScoreNumView.class), "proBarB", "getProBarB()Landroid/widget/ProgressBar;")), n0.r(new PropertyReference1Impl(n0.d(ScoreNumView.class), "proBarC", "getProBarC()Landroid/widget/ProgressBar;")), n0.r(new PropertyReference1Impl(n0.d(ScoreNumView.class), "proBarD", "getProBarD()Landroid/widget/ProgressBar;")), n0.r(new PropertyReference1Impl(n0.d(ScoreNumView.class), "proBarE", "getProBarE()Landroid/widget/ProgressBar;"))};
    @d
    private final e a;
    @d
    private final e b;
    @d

    /* renamed from: c  reason: collision with root package name */
    private final e f4202c;
    @d

    /* renamed from: d  reason: collision with root package name */
    private final e f4203d;
    @d

    /* renamed from: e  reason: collision with root package name */
    private final e f4204e;

    @h
    public ScoreNumView(@d Context context) {
        this(context, null, 2, null);
    }

    public /* synthetic */ ScoreNumView(Context context, AttributeSet attributeSet, int i2, u uVar) {
        this(context, (i2 & 2) != 0 ? null : attributeSet);
    }

    private final ProgressBar getProBarA() {
        return (ProgressBar) this.a.a(this, f4201f[0]);
    }

    private final ProgressBar getProBarB() {
        return (ProgressBar) this.b.a(this, f4201f[1]);
    }

    private final ProgressBar getProBarC() {
        return (ProgressBar) this.f4202c.a(this, f4201f[2]);
    }

    private final ProgressBar getProBarD() {
        return (ProgressBar) this.f4203d.a(this, f4201f[3]);
    }

    private final ProgressBar getProBarE() {
        return (ProgressBar) this.f4204e.a(this, f4201f[4]);
    }

    public final void a(int i2, @d List<GradeDetail> list) {
        if (i2 == 0) {
            return;
        }
        double d2 = i2;
        for (GradeDetail gradeDetail : list) {
            Integer grade = gradeDetail.getGrade();
            if (grade != null && grade.intValue() == 5) {
                if (gradeDetail.getUserCount() == null) {
                    getProBarA().setProgress(0);
                } else {
                    getProBarA().setProgress((int) ((gradeDetail.getUserCount().intValue() / d2) * 100));
                }
            } else if (grade != null && grade.intValue() == 4) {
                if (gradeDetail.getUserCount() == null) {
                    getProBarB().setProgress(0);
                } else {
                    getProBarB().setProgress((int) ((gradeDetail.getUserCount().intValue() / d2) * 100));
                }
            } else if (grade != null && grade.intValue() == 3) {
                if (gradeDetail.getUserCount() == null) {
                    getProBarC().setProgress(0);
                } else {
                    getProBarC().setProgress((int) ((gradeDetail.getUserCount().intValue() / d2) * 100));
                }
            } else if (grade != null && grade.intValue() == 2) {
                if (gradeDetail.getUserCount() == null) {
                    getProBarD().setProgress(0);
                } else {
                    getProBarD().setProgress((int) ((gradeDetail.getUserCount().intValue() / d2) * 100));
                }
            } else if (grade != null && grade.intValue() == 1) {
                if (gradeDetail.getUserCount() == null) {
                    getProBarE().setProgress(0);
                } else {
                    getProBarE().setProgress((int) ((gradeDetail.getUserCount().intValue() / d2) * 100));
                }
            }
        }
    }

    @h
    public ScoreNumView(@d Context context, @k.e.a.e AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = BindViewKt.p(this, R.id.proBar_a);
        this.b = BindViewKt.p(this, R.id.proBar_b);
        this.f4202c = BindViewKt.p(this, R.id.proBar_c);
        this.f4203d = BindViewKt.p(this, R.id.proBar_d);
        this.f4204e = BindViewKt.p(this, R.id.proBar_e);
        LayoutInflater.from(context).inflate(R.layout.view_score_num, this);
    }
}
