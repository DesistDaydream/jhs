package e.j.a.b.g;

import android.content.Context;
import android.os.AsyncTask;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import e.j.a.b.c.f;
import e.j.a.b.g.a;

/* loaded from: classes2.dex */
public final class b extends AsyncTask<Void, Void, Integer> {
    private final /* synthetic */ Context a;
    private final /* synthetic */ a.InterfaceC0348a b;

    public b(Context context, a.InterfaceC0348a interfaceC0348a) {
        this.a = context;
        this.b = interfaceC0348a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public final Integer doInBackground(Void... voidArr) {
        try {
            a.a(this.a);
            return 0;
        } catch (GooglePlayServicesNotAvailableException e2) {
            return Integer.valueOf(e2.errorCode);
        } catch (GooglePlayServicesRepairableException e3) {
            return Integer.valueOf(e3.getConnectionStatusCode());
        }
    }

    @Override // android.os.AsyncTask
    public final /* synthetic */ void onPostExecute(Integer num) {
        f fVar;
        Integer num2 = num;
        if (num2.intValue() != 0) {
            fVar = a.a;
            this.b.b(num2.intValue(), fVar.e(this.a, num2.intValue(), "pi"));
            return;
        }
        this.b.a();
    }
}
