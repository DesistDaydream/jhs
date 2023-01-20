package com.jihuanshe.ui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.jihuanshe.model.Game;
import com.vector.network.image.NImageView;
import e.t.r.a.f;
import h.k2.h;
import h.k2.v.f0;
import h.k2.v.u;
import java.util.Objects;
import k.e.a.d;
import k.e.a.e;

/* loaded from: classes2.dex */
public final class CardImageView extends NImageView {
    @e

    /* renamed from: c  reason: collision with root package name */
    private Game f4045c;
    @d

    /* renamed from: d  reason: collision with root package name */
    private final Path f4046d;

    @h
    public CardImageView(@d Context context) {
        this(context, null, 2, null);
    }

    public /* synthetic */ CardImageView(Context context, AttributeSet attributeSet, int i2, u uVar) {
        this(context, (i2 & 2) != 0 ? null : attributeSet);
    }

    @d
    public final Path getPath() {
        return this.f4046d;
    }

    @Override // com.vector.network.image.NImageView, e.t.r.a.f
    @d
    public f j(@d e.t.r.a.h hVar) {
        return this;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(@e Canvas canvas) {
        Game game = this.f4045c;
        if (game != null) {
            float corner = ((game.getCorner() * 1.0f) * getMeasuredWidth()) / this.f4045c.getWidth();
            this.f4046d.reset();
            this.f4046d.moveTo(corner, 0.0f);
            this.f4046d.lineTo(getWidth() - corner, 0.0f);
            this.f4046d.quadTo(getWidth(), 0.0f, getWidth(), corner);
            this.f4046d.lineTo(getWidth(), getHeight() - corner);
            this.f4046d.quadTo(getWidth(), getHeight(), getWidth() - corner, getHeight());
            this.f4046d.lineTo(corner, getHeight());
            this.f4046d.quadTo(0.0f, getHeight(), 0.0f, getHeight() - corner);
            this.f4046d.lineTo(0.0f, corner);
            this.f4046d.quadTo(0.0f, 0.0f, corner, 0.0f);
            canvas.clipPath(this.f4046d);
        }
        super.onDraw(canvas);
    }

    public final void setGame(@d Game game) {
        if (f0.g(this.f4045c, game)) {
            return;
        }
        this.f4045c = game;
        if (getLayoutParams() instanceof ConstraintLayout.LayoutParams) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            StringBuilder sb = new StringBuilder();
            sb.append(game.getWidth());
            sb.append(':');
            sb.append(game.getHeight());
            ((ConstraintLayout.LayoutParams) layoutParams).dimensionRatio = sb.toString();
        }
        requestLayout();
    }

    @Override // com.vector.network.image.NImageView
    public void z() {
        Game game;
        if ((getLayoutParams() instanceof ConstraintLayout.LayoutParams) || (game = this.f4045c) == null) {
            return;
        }
        setMeasuredDimension(getMeasuredWidth(), (int) (getMeasuredWidth() * ((game.getHeight() * 1.0f) / game.getWidth())));
    }

    @h
    public CardImageView(@d Context context, @e AttributeSet attributeSet) {
        super(context, attributeSet, 0, 4, null);
        this.f4046d = new Path();
    }
}
