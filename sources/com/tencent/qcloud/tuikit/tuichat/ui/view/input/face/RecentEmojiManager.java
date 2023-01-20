package com.tencent.qcloud.tuikit.tuichat.ui.view.input.face;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;

/* loaded from: classes3.dex */
public class RecentEmojiManager {
    public static final String PREFERENCE_NAME = "recentFace";
    private SharedPreferences.Editor mEditor;
    private SharedPreferences mPreferences;

    private RecentEmojiManager(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREFERENCE_NAME, 0);
        this.mPreferences = sharedPreferences;
        this.mEditor = sharedPreferences.edit();
    }

    public static RecentEmojiManager make(Context context) {
        return new RecentEmojiManager(context);
    }

    public Collection getCollection(String str) throws IOException, ClassNotFoundException {
        String string = getString(str);
        if (TextUtils.isEmpty(string) || TextUtils.isEmpty(string.trim())) {
            return null;
        }
        ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(Base64.decode(string.getBytes(), 0)));
        Collection collection = (Collection) objectInputStream.readObject();
        objectInputStream.close();
        return collection;
    }

    public String getString(String str) {
        return this.mPreferences.getString(str, "");
    }

    public RecentEmojiManager putCollection(String str, Collection collection) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(collection);
        String str2 = new String(Base64.encode(byteArrayOutputStream.toByteArray(), 0));
        objectOutputStream.close();
        return putString(str, str2);
    }

    public RecentEmojiManager putString(String str, String str2) {
        this.mEditor.putString(str, str2).apply();
        return this;
    }
}
