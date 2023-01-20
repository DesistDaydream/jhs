package e.k.c.a.a.j.q;

import android.content.Context;
import android.os.AsyncTask;
import java.io.InputStream;

/* loaded from: classes2.dex */
public class g extends AsyncTask<Context, Integer, Boolean> {
    private static final String a = g.class.getSimpleName();

    @Override // android.os.AsyncTask
    /* renamed from: a */
    public Boolean doInBackground(Context... contextArr) {
        InputStream inputStream;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            inputStream = a.n(contextArr[0]);
        } catch (Exception e2) {
            String str = a;
            i.d(str, "doInBackground: exception : " + e2.getMessage());
            inputStream = null;
        }
        String str2 = a;
        i.b(str2, "doInBackground: get bks from hms tss cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
        if (inputStream != null) {
            h.g(inputStream);
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    @Override // android.os.AsyncTask
    /* renamed from: b */
    public void onPostExecute(Boolean bool) {
        if (bool.booleanValue()) {
            i.e(a, "onPostExecute: upate done");
        } else {
            i.d(a, "onPostExecute: upate failed");
        }
    }

    @Override // android.os.AsyncTask
    /* renamed from: c */
    public void onProgressUpdate(Integer... numArr) {
        i.e(a, "onProgressUpdate");
    }

    @Override // android.os.AsyncTask
    public void onPreExecute() {
        i.b(a, "onPreExecute");
    }
}
