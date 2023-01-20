package e.j.a.b.c.v;

import android.database.AbstractWindowedCursor;
import android.database.CrossProcessCursor;
import android.database.Cursor;
import android.database.CursorWindow;
import android.database.CursorWrapper;

@e.j.a.b.c.m.a
/* loaded from: classes2.dex */
public class a extends CursorWrapper implements CrossProcessCursor {
    private AbstractWindowedCursor a;

    @e.j.a.b.c.m.a
    public a(Cursor cursor) {
        super(cursor);
        for (int i2 = 0; i2 < 10 && (cursor instanceof CursorWrapper); i2++) {
            cursor = ((CursorWrapper) cursor).getWrappedCursor();
        }
        if (!(cursor instanceof AbstractWindowedCursor)) {
            String valueOf = String.valueOf(cursor.getClass().getName());
            throw new IllegalArgumentException(valueOf.length() != 0 ? "Unknown type: ".concat(valueOf) : new String("Unknown type: "));
        }
        this.a = (AbstractWindowedCursor) cursor;
    }

    @e.j.a.b.c.m.a
    public void a(CursorWindow cursorWindow) {
        this.a.setWindow(cursorWindow);
    }

    @Override // android.database.CrossProcessCursor
    @e.j.a.b.c.m.a
    public void fillWindow(int i2, CursorWindow cursorWindow) {
        this.a.fillWindow(i2, cursorWindow);
    }

    @Override // android.database.CrossProcessCursor
    @e.j.a.b.c.m.a
    public CursorWindow getWindow() {
        return this.a.getWindow();
    }

    @Override // android.database.CursorWrapper
    public /* synthetic */ Cursor getWrappedCursor() {
        return this.a;
    }

    @Override // android.database.CrossProcessCursor
    public boolean onMove(int i2, int i3) {
        return this.a.onMove(i2, i3);
    }
}
