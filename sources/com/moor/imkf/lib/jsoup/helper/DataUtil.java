package com.moor.imkf.lib.jsoup.helper;

import com.moor.imkf.lib.jsoup.UncheckedIOException;
import com.moor.imkf.lib.jsoup.internal.ConstrainableInputStream;
import com.moor.imkf.lib.jsoup.internal.Normalizer;
import com.moor.imkf.lib.jsoup.internal.StringUtil;
import com.moor.imkf.lib.jsoup.nodes.Comment;
import com.moor.imkf.lib.jsoup.nodes.Document;
import com.moor.imkf.lib.jsoup.nodes.Element;
import com.moor.imkf.lib.jsoup.nodes.Node;
import com.moor.imkf.lib.jsoup.nodes.XmlDeclaration;
import com.moor.imkf.lib.jsoup.parser.Parser;
import java.io.BufferedReader;
import java.io.CharArrayReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.IllegalCharsetNameException;
import java.util.Iterator;
import java.util.Locale;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.GZIPInputStream;
import k.b.a.a.c;

/* loaded from: classes2.dex */
public final class DataUtil {
    public static final int boundaryLength = 32;
    public static final int bufferSize = 32768;
    public static final String defaultCharset = "UTF-8";
    private static final int firstReadBufferSize = 5120;
    private static final Pattern charsetPattern = Pattern.compile("(?i)\\bcharset=\\s*(?:[\"'])?([^\\s,;\"']*)");
    private static final char[] mimeBoundaryChars = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    /* loaded from: classes2.dex */
    public static class BomCharset {
        private final String charset;
        private final boolean offset;

        public BomCharset(String str, boolean z) {
            this.charset = str;
            this.offset = z;
        }
    }

    private DataUtil() {
    }

    public static void crossStreams(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[32768];
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return;
            }
            outputStream.write(bArr, 0, read);
        }
    }

    private static BomCharset detectCharsetFromBom(ByteBuffer byteBuffer) {
        byteBuffer.mark();
        byte[] bArr = new byte[4];
        if (byteBuffer.remaining() >= 4) {
            byteBuffer.get(bArr);
            byteBuffer.rewind();
        }
        if ((bArr[0] == 0 && bArr[1] == 0 && bArr[2] == -2 && bArr[3] == -1) || (bArr[0] == -1 && bArr[1] == -2 && bArr[2] == 0 && bArr[3] == 0)) {
            return new BomCharset("UTF-32", false);
        }
        if ((bArr[0] == -2 && bArr[1] == -1) || (bArr[0] == -1 && bArr[1] == -2)) {
            return new BomCharset(c.f16034c, false);
        }
        if (bArr[0] == -17 && bArr[1] == -69 && bArr[2] == -65) {
            return new BomCharset("UTF-8", true);
        }
        return null;
    }

    public static ByteBuffer emptyByteBuffer() {
        return ByteBuffer.allocate(0);
    }

    public static String getCharsetFromContentType(String str) {
        if (str == null) {
            return null;
        }
        Matcher matcher = charsetPattern.matcher(str);
        if (matcher.find()) {
            return validateCharset(matcher.group(1).trim().replace("charset=", ""));
        }
        return null;
    }

    public static Document load(File file, String str, String str2) throws IOException {
        InputStream fileInputStream = new FileInputStream(file);
        String lowerCase = Normalizer.lowerCase(file.getName());
        if (lowerCase.endsWith(".gz") || lowerCase.endsWith(".z")) {
            boolean z = fileInputStream.read() == 31 && fileInputStream.read() == 139;
            fileInputStream.close();
            fileInputStream = z ? new GZIPInputStream(new FileInputStream(file)) : new FileInputStream(file);
        }
        return parseInputStream(fileInputStream, str, str2, Parser.htmlParser());
    }

    public static String mimeBoundary() {
        StringBuilder borrowBuilder = StringUtil.borrowBuilder();
        Random random = new Random();
        for (int i2 = 0; i2 < 32; i2++) {
            char[] cArr = mimeBoundaryChars;
            borrowBuilder.append(cArr[random.nextInt(cArr.length)]);
        }
        return StringUtil.releaseBuilder(borrowBuilder);
    }

    public static Document parseInputStream(InputStream inputStream, String str, String str2, Parser parser) throws IOException {
        Document parseInput;
        XmlDeclaration xmlDeclaration;
        if (inputStream == null) {
            return new Document(str2);
        }
        ConstrainableInputStream wrap = ConstrainableInputStream.wrap(inputStream, 32768, 0);
        wrap.mark(32768);
        ByteBuffer readToByteBuffer = readToByteBuffer(wrap, 5119);
        boolean z = wrap.read() == -1;
        wrap.reset();
        BomCharset detectCharsetFromBom = detectCharsetFromBom(readToByteBuffer);
        String str3 = detectCharsetFromBom != null ? detectCharsetFromBom.charset : str;
        Document document = null;
        if (str3 == null) {
            try {
                CharBuffer decode = Charset.forName("UTF-8").decode(readToByteBuffer);
                if (decode.hasArray()) {
                    parseInput = parser.parseInput(new CharArrayReader(decode.array()), str2);
                } else {
                    parseInput = parser.parseInput(decode.toString(), str2);
                }
                Iterator<Element> it = parseInput.select("meta[http-equiv=content-type], meta[charset]").iterator();
                String str4 = null;
                while (it.hasNext()) {
                    Element next = it.next();
                    if (next.hasAttr("http-equiv")) {
                        str4 = getCharsetFromContentType(next.attr("content"));
                    }
                    if (str4 == null && next.hasAttr("charset")) {
                        str4 = next.attr("charset");
                        continue;
                    }
                    if (str4 != null) {
                        break;
                    }
                }
                if (str4 == null && parseInput.childNodeSize() > 0) {
                    Node childNode = parseInput.childNode(0);
                    if (childNode instanceof XmlDeclaration) {
                        xmlDeclaration = (XmlDeclaration) childNode;
                    } else {
                        if (childNode instanceof Comment) {
                            Comment comment = (Comment) childNode;
                            if (comment.isXmlDeclaration()) {
                                xmlDeclaration = comment.asXmlDeclaration();
                            }
                        }
                        xmlDeclaration = null;
                    }
                    if (xmlDeclaration != null && xmlDeclaration.name().equalsIgnoreCase("xml")) {
                        str4 = xmlDeclaration.attr("encoding");
                    }
                }
                String validateCharset = validateCharset(str4);
                if (validateCharset != null && !validateCharset.equalsIgnoreCase("UTF-8")) {
                    str3 = validateCharset.trim().replaceAll("[\"']", "");
                } else if (z) {
                    document = parseInput;
                }
            } catch (UncheckedIOException e2) {
                throw e2.ioException();
            }
        } else {
            Validate.notEmpty(str3, "Must set charset arg to character set of file to parse. Set to null to attempt to detect from HTML");
        }
        if (document == null) {
            if (str3 == null) {
                str3 = "UTF-8";
            }
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(wrap, str3), 32768);
            if (detectCharsetFromBom != null && detectCharsetFromBom.offset) {
                Validate.isTrue(bufferedReader.skip(1L) == 1);
            }
            try {
                document = parser.parseInput(bufferedReader, str2);
                Charset forName = Charset.forName(str3);
                document.outputSettings().charset(forName);
                if (!forName.canEncode()) {
                    document.charset(Charset.forName("UTF-8"));
                }
            } catch (UncheckedIOException e3) {
                throw e3.ioException();
            }
        }
        wrap.close();
        return document;
    }

    public static ByteBuffer readToByteBuffer(InputStream inputStream, int i2) throws IOException {
        Validate.isTrue(i2 >= 0, "maxSize must be 0 (unlimited) or larger");
        return ConstrainableInputStream.wrap(inputStream, 32768, i2).readToByteBuffer(i2);
    }

    private static String validateCharset(String str) {
        if (str != null && str.length() != 0) {
            String replaceAll = str.trim().replaceAll("[\"']", "");
            try {
                if (Charset.isSupported(replaceAll)) {
                    return replaceAll;
                }
                String upperCase = replaceAll.toUpperCase(Locale.ENGLISH);
                if (Charset.isSupported(upperCase)) {
                    return upperCase;
                }
            } catch (IllegalCharsetNameException unused) {
            }
        }
        return null;
    }

    public static Document load(InputStream inputStream, String str, String str2) throws IOException {
        return parseInputStream(inputStream, str, str2, Parser.htmlParser());
    }

    public static Document load(InputStream inputStream, String str, String str2, Parser parser) throws IOException {
        return parseInputStream(inputStream, str, str2, parser);
    }
}
