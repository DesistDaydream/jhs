package e.b.a.p.j;

import android.content.ContentResolver;
import android.content.UriMatcher;
import android.net.Uri;
import android.provider.ContactsContract;
import androidx.annotation.NonNull;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public class n extends l<InputStream> {

    /* renamed from: e  reason: collision with root package name */
    private static final int f9467e = 1;

    /* renamed from: f  reason: collision with root package name */
    private static final int f9468f = 2;

    /* renamed from: g  reason: collision with root package name */
    private static final int f9469g = 3;

    /* renamed from: h  reason: collision with root package name */
    private static final int f9470h = 4;

    /* renamed from: i  reason: collision with root package name */
    private static final int f9471i = 5;

    /* renamed from: j  reason: collision with root package name */
    private static final UriMatcher f9472j;

    static {
        UriMatcher uriMatcher = new UriMatcher(-1);
        f9472j = uriMatcher;
        uriMatcher.addURI("com.android.contacts", "contacts/lookup/*/#", 1);
        uriMatcher.addURI("com.android.contacts", "contacts/lookup/*", 1);
        uriMatcher.addURI("com.android.contacts", "contacts/#/photo", 2);
        uriMatcher.addURI("com.android.contacts", "contacts/#", 3);
        uriMatcher.addURI("com.android.contacts", "contacts/#/display_photo", 4);
        uriMatcher.addURI("com.android.contacts", "phone_lookup/*", 5);
    }

    public n(ContentResolver contentResolver, Uri uri) {
        super(contentResolver, uri);
    }

    private InputStream g(Uri uri, ContentResolver contentResolver) throws FileNotFoundException {
        int match = f9472j.match(uri);
        if (match != 1) {
            if (match == 3) {
                return h(contentResolver, uri);
            }
            if (match != 5) {
                return contentResolver.openInputStream(uri);
            }
        }
        Uri lookupContact = ContactsContract.Contacts.lookupContact(contentResolver, uri);
        if (lookupContact != null) {
            return h(contentResolver, lookupContact);
        }
        throw new FileNotFoundException("Contact cannot be found");
    }

    private InputStream h(ContentResolver contentResolver, Uri uri) {
        return ContactsContract.Contacts.openContactPhotoInputStream(contentResolver, uri, true);
    }

    @Override // e.b.a.p.j.l
    /* renamed from: e */
    public void b(InputStream inputStream) throws IOException {
        inputStream.close();
    }

    @Override // e.b.a.p.j.l
    /* renamed from: f */
    public InputStream d(Uri uri, ContentResolver contentResolver) throws FileNotFoundException {
        InputStream g2 = g(uri, contentResolver);
        if (g2 != null) {
            return g2;
        }
        throw new FileNotFoundException("InputStream is null for " + uri);
    }

    @Override // e.b.a.p.j.d
    @NonNull
    public Class<InputStream> getDataClass() {
        return InputStream.class;
    }
}
