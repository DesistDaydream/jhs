package com.jihuanshe.ui.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.widget.TextViewCompat;
import com.jihuanshe.R;
import com.jihuanshe.model.Game;
import com.jihuanshe.ui.dialog.GameSideDialog;
import com.jihuanshe.ui.dialog.GameSideMultiDialog;
import com.jihuanshe.ui.widget.GameFilterBtn;
import com.vector.util.Res;
import e.l.h.k.b;
import e.t.o.d;
import h.k2.h;
import h.k2.u.l;
import h.k2.v.u;
import h.t1;
import java.util.ArrayList;
import java.util.List;
import k.e.a.d;
import k.e.a.e;
import kotlin.collections.CollectionsKt___CollectionsKt;

/* loaded from: classes2.dex */
public final class GameFilterBtn extends AppCompatTextView {
    @d

    /* renamed from: k */
    public static final a f4104k = new a(null);
    @d

    /* renamed from: l */
    private static final String f4105l = "GameFilterBtn";
    @d
    private List<Game> a;
    @e
    private Game b;
    @d

    /* renamed from: c */
    private List<Game> f4106c;
    @e

    /* renamed from: d */
    private l<? super Game, t1> f4107d;
    @e

    /* renamed from: e */
    private l<? super List<Game>, t1> f4108e;

    /* renamed from: f */
    private boolean f4109f;

    /* renamed from: g */
    private int f4110g;

    /* renamed from: h */
    private boolean f4111h;
    @e

    /* renamed from: i */
    private String f4112i;

    /* renamed from: j */
    private int f4113j;

    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }
    }

    @h
    public GameFilterBtn(@d Context context) {
        this(context, null, 2, null);
    }

    public /* synthetic */ GameFilterBtn(Context context, AttributeSet attributeSet, int i2, u uVar) {
        this(context, (i2 & 2) != 0 ? null : attributeSet);
    }

    public static final void e(GameFilterBtn gameFilterBtn, View view) {
        gameFilterBtn.k();
    }

    public static /* synthetic */ void h(GameFilterBtn gameFilterBtn, View view) {
        e(gameFilterBtn, view);
    }

    private final void i(AttributeSet attributeSet) {
        if (attributeSet == null) {
            return;
        }
        int i2 = 0;
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(attributeSet, R.styleable.GameFilterBtn, 0, 0);
        try {
            try {
                int indexCount = obtainStyledAttributes.getIndexCount();
                if (indexCount > 0) {
                    while (true) {
                        int i3 = i2 + 1;
                        int index = obtainStyledAttributes.getIndex(i2);
                        if (index == 0) {
                            this.f4110g = obtainStyledAttributes.getColor(index, this.f4110g);
                        } else if (index == 1) {
                            String string = obtainStyledAttributes.getString(index);
                            if (string == null) {
                                string = this.f4112i;
                            }
                            this.f4112i = string;
                        } else if (index == 2) {
                            this.f4113j = obtainStyledAttributes.getResourceId(index, this.f4113j);
                        } else if (index == 3) {
                            this.f4111h = obtainStyledAttributes.getBoolean(index, this.f4111h);
                        } else if (index == 4) {
                            this.f4109f = obtainStyledAttributes.getBoolean(index, this.f4109f);
                        }
                        if (i3 >= indexCount) {
                            break;
                        }
                        i2 = i3;
                    }
                }
            } catch (Exception e2) {
                b bVar = b.a;
                String message = e2.getMessage();
                if (message == null) {
                    message = "init game filter bar fail.";
                }
                bVar.b(f4105l, message);
            }
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    private final void k() {
        if (this.f4111h) {
            new GameSideMultiDialog(getContext(), this.a, this.f4106c, new GameFilterBtn$showDialog$1(this)).y();
        } else {
            new GameSideDialog(getContext(), this.a, this.b, this.f4109f, new GameFilterBtn$showDialog$2(this)).y();
        }
    }

    @e
    public final Game getCurrent() {
        return this.b;
    }

    @d
    public final List<Game> getCurrents() {
        return this.f4106c;
    }

    @d
    public final List<Game> getData() {
        return this.a;
    }

    @e
    public final l<Game, t1> getListener() {
        return this.f4107d;
    }

    @e
    public final l<List<Game>, t1> getMultiListener() {
        return this.f4108e;
    }

    public final void j() {
        setText(this.f4112i);
        this.b = null;
    }

    public final void setCurrent(@e Game game) {
        this.b = game;
    }

    public final void setCurrentGame(@e Game game) {
        if (game == null) {
            return;
        }
        this.b = game;
        setText(game.getName());
    }

    public final void setCurrents(@d List<Game> list) {
        this.f4106c = list;
    }

    public final void setData(@d List<Game> list) {
        this.a = list;
    }

    public final void setListener(@e l<? super Game, t1> lVar) {
        this.f4107d = lVar;
    }

    public final void setMultiListener(@e l<? super List<Game>, t1> lVar) {
        this.f4108e = lVar;
    }

    public final void setTextAndDrawableTint(int i2) {
        setTextColor(i2);
        TextViewCompat.setCompoundDrawableTintList(this, ColorStateList.valueOf(i2));
    }

    @h
    public GameFilterBtn(@d Context context, @e AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = CollectionsKt___CollectionsKt.L5(e.l.m.b.f14084c.t());
        this.f4106c = new ArrayList();
        this.f4109f = true;
        this.f4110g = Res.k(R.color.black);
        this.f4112i = Res.w(Res.a, R.string.common_all_game, null, 2, null);
        this.f4113j = R.drawable.ic_down;
        i(attributeSet);
        setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, this.f4113j, 0);
        setTextColor(this.f4110g);
        TextViewCompat.setCompoundDrawableTintList(this, ColorStateList.valueOf(this.f4110g));
        setCompoundDrawablePadding(d.a.c(e.t.o.d.a, null, 1, null).d(5));
        setText(this.f4112i);
        setGravity(8388629);
        setMaxEms(6);
        setEllipsize(TextUtils.TruncateAt.END);
        setSingleLine();
        setOnClickListener(new View.OnClickListener() { // from class: e.l.q.c.t
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GameFilterBtn.h(GameFilterBtn.this, view);
            }
        });
    }
}
