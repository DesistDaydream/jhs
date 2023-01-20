package com.tencent.android.tpns.mqtt.persist;

import com.tencent.android.tpns.mqtt.MqttClientPersistence;
import com.tencent.android.tpns.mqtt.MqttPersistable;
import com.tencent.android.tpns.mqtt.MqttPersistenceException;
import com.tencent.android.tpns.mqtt.internal.FileLock;
import com.tencent.android.tpns.mqtt.internal.MqttPersistentData;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Vector;

/* loaded from: classes3.dex */
public class MqttDefaultFilePersistence implements MqttClientPersistence {
    private static FilenameFilter FILENAME_FILTER = null;
    private static final String LOCK_FILENAME = ".lck";
    private static final String MESSAGE_BACKUP_FILE_EXTENSION = ".bup";
    private static final String MESSAGE_FILE_EXTENSION = ".msg";
    private File clientDir;
    private File dataDir;
    private FileLock fileLock;

    public MqttDefaultFilePersistence() {
        this(System.getProperty("user.dir"));
    }

    private void checkIsOpen() throws MqttPersistenceException {
        if (this.clientDir == null) {
            throw new MqttPersistenceException();
        }
    }

    private static FilenameFilter getFilenameFilter() {
        if (FILENAME_FILTER == null) {
            FILENAME_FILTER = new PersistanceFileNameFilter(MESSAGE_FILE_EXTENSION);
        }
        return FILENAME_FILTER;
    }

    private File[] getFiles() throws MqttPersistenceException {
        checkIsOpen();
        File[] listFiles = this.clientDir.listFiles(getFilenameFilter());
        if (listFiles != null) {
            return listFiles;
        }
        throw new MqttPersistenceException();
    }

    private boolean isSafeChar(char c2) {
        return Character.isJavaIdentifierPart(c2) || c2 == '-';
    }

    private void restoreBackups(File file) throws MqttPersistenceException {
        File[] listFiles = file.listFiles(new PersistanceFileFilter(MESSAGE_BACKUP_FILE_EXTENSION));
        if (listFiles != null) {
            for (int i2 = 0; i2 < listFiles.length; i2++) {
                File file2 = new File(file, listFiles[i2].getName().substring(0, listFiles[i2].getName().length() - 4));
                if (!listFiles[i2].renameTo(file2)) {
                    file2.delete();
                    listFiles[i2].renameTo(file2);
                }
            }
            return;
        }
        throw new MqttPersistenceException();
    }

    @Override // com.tencent.android.tpns.mqtt.MqttClientPersistence
    public void clear() throws MqttPersistenceException {
        checkIsOpen();
        for (File file : getFiles()) {
            file.delete();
        }
        this.clientDir.delete();
    }

    @Override // com.tencent.android.tpns.mqtt.MqttClientPersistence
    public void close() throws MqttPersistenceException {
        synchronized (this) {
            FileLock fileLock = this.fileLock;
            if (fileLock != null) {
                fileLock.release();
            }
            if (getFiles().length == 0) {
                this.clientDir.delete();
            }
            this.clientDir = null;
        }
    }

    @Override // com.tencent.android.tpns.mqtt.MqttClientPersistence
    public boolean containsKey(String str) throws MqttPersistenceException {
        checkIsOpen();
        File file = this.clientDir;
        return new File(file, str + MESSAGE_FILE_EXTENSION).exists();
    }

    @Override // com.tencent.android.tpns.mqtt.MqttClientPersistence
    public MqttPersistable get(String str) throws MqttPersistenceException {
        checkIsOpen();
        FileInputStream fileInputStream = null;
        try {
            File file = this.clientDir;
            FileInputStream fileInputStream2 = new FileInputStream(new File(file, str + MESSAGE_FILE_EXTENSION));
            try {
                int available = fileInputStream2.available();
                byte[] bArr = new byte[available];
                for (int i2 = 0; i2 < available; i2 += fileInputStream2.read(bArr, i2, available - i2)) {
                }
                fileInputStream2.close();
                return new MqttPersistentData(str, bArr, 0, available, null, 0, 0);
            } catch (IOException e2) {
                e = e2;
                fileInputStream = fileInputStream2;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException unused) {
                    }
                }
                throw new MqttPersistenceException(e);
            }
        } catch (IOException e3) {
            e = e3;
        }
    }

    @Override // com.tencent.android.tpns.mqtt.MqttClientPersistence
    public Enumeration keys() throws MqttPersistenceException {
        String name;
        checkIsOpen();
        File[] files = getFiles();
        Vector vector = new Vector(files.length);
        for (File file : files) {
            vector.addElement(file.getName().substring(0, name.length() - 4));
        }
        return vector.elements();
    }

    @Override // com.tencent.android.tpns.mqtt.MqttClientPersistence
    public void open(String str, String str2) throws MqttPersistenceException {
        if (this.dataDir.exists() && !this.dataDir.isDirectory()) {
            throw new MqttPersistenceException();
        }
        if (!this.dataDir.exists() && !this.dataDir.mkdirs()) {
            throw new MqttPersistenceException();
        }
        if (this.dataDir.canWrite()) {
            StringBuffer stringBuffer = new StringBuffer();
            for (int i2 = 0; i2 < str.length(); i2++) {
                char charAt = str.charAt(i2);
                if (isSafeChar(charAt)) {
                    stringBuffer.append(charAt);
                }
            }
            stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            for (int i3 = 0; i3 < str2.length(); i3++) {
                char charAt2 = str2.charAt(i3);
                if (isSafeChar(charAt2)) {
                    stringBuffer.append(charAt2);
                }
            }
            synchronized (this) {
                if (this.clientDir == null) {
                    File file = new File(this.dataDir, stringBuffer.toString());
                    this.clientDir = file;
                    if (!file.exists()) {
                        this.clientDir.mkdir();
                    }
                }
                try {
                    this.fileLock = new FileLock(this.clientDir, LOCK_FILENAME);
                } catch (Throwable unused) {
                }
                restoreBackups(this.clientDir);
            }
            return;
        }
        throw new MqttPersistenceException();
    }

    @Override // com.tencent.android.tpns.mqtt.MqttClientPersistence
    public void put(String str, MqttPersistable mqttPersistable) throws MqttPersistenceException {
        checkIsOpen();
        File file = this.clientDir;
        File file2 = new File(file, str + MESSAGE_FILE_EXTENSION);
        File file3 = this.clientDir;
        File file4 = new File(file3, str + MESSAGE_FILE_EXTENSION + MESSAGE_BACKUP_FILE_EXTENSION);
        if (file2.exists() && !file2.renameTo(file4)) {
            file4.delete();
            file2.renameTo(file4);
        }
        try {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                fileOutputStream.write(mqttPersistable.getHeaderBytes(), mqttPersistable.getHeaderOffset(), mqttPersistable.getHeaderLength());
                if (mqttPersistable.getPayloadBytes() != null) {
                    fileOutputStream.write(mqttPersistable.getPayloadBytes(), mqttPersistable.getPayloadOffset(), mqttPersistable.getPayloadLength());
                }
                fileOutputStream.getFD().sync();
                fileOutputStream.close();
                if (file4.exists()) {
                    file4.delete();
                }
            } catch (IOException e2) {
                throw new MqttPersistenceException(e2);
            }
        } finally {
            if (file4.exists() && !file4.renameTo(file2)) {
                file2.delete();
                file4.renameTo(file2);
            }
        }
    }

    @Override // com.tencent.android.tpns.mqtt.MqttClientPersistence
    public void remove(String str) throws MqttPersistenceException {
        checkIsOpen();
        File file = this.clientDir;
        File file2 = new File(file, str + MESSAGE_FILE_EXTENSION);
        if (file2.exists()) {
            file2.delete();
        }
    }

    public MqttDefaultFilePersistence(String str) {
        this.clientDir = null;
        this.fileLock = null;
        this.dataDir = new File(str);
    }
}
