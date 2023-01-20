package com.bytedance.pangle.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

/* loaded from: classes.dex */
public final class h {
    public static void a(InputStream inputStream, OutputStream outputStream) {
        if (inputStream == null) {
            return;
        }
        ReadableByteChannel newChannel = Channels.newChannel(inputStream);
        WritableByteChannel newChannel2 = Channels.newChannel(outputStream);
        a(newChannel, newChannel2);
        newChannel.close();
        newChannel2.close();
    }

    public static boolean a(String str, File file, StringBuilder sb) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            FileChannel channel = fileOutputStream.getChannel();
            channel.write(ByteBuffer.wrap(str.getBytes()));
            channel.close();
            fileOutputStream.close();
            return true;
        } catch (IOException e2) {
            sb.append(e2.getMessage());
            return false;
        }
    }

    private static void a(ReadableByteChannel readableByteChannel, WritableByteChannel writableByteChannel) {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(4096);
        while (readableByteChannel.read(allocateDirect) != -1) {
            allocateDirect.flip();
            while (allocateDirect.hasRemaining()) {
                writableByteChannel.write(allocateDirect);
            }
            allocateDirect.clear();
        }
    }
}
