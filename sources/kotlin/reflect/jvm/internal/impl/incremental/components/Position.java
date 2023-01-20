package kotlin.reflect.jvm.internal.impl.incremental.components;

import h.k2.v.u;
import java.io.Serializable;
import k.e.a.d;
import k.e.a.e;

/* loaded from: classes3.dex */
public final class Position implements Serializable {
    @d
    public static final a Companion = new a(null);
    @d
    private static final Position NO_POSITION = new Position(-1, -1);
    private final int column;
    private final int line;

    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        @d
        public final Position a() {
            return Position.NO_POSITION;
        }
    }

    public Position(int i2, int i3) {
        this.line = i2;
        this.column = i3;
    }

    public boolean equals(@e Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Position) {
            Position position = (Position) obj;
            return this.line == position.line && this.column == position.column;
        }
        return false;
    }

    public int hashCode() {
        return (this.line * 31) + this.column;
    }

    @d
    public String toString() {
        return "Position(line=" + this.line + ", column=" + this.column + ')';
    }
}
