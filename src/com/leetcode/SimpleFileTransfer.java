package com.java.java_base;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class SimpleFileTransfer {
	private long transferFile(File source, File des) throws IOException {
		long startTime = System.currentTimeMillis();
		if(!des.exists()) {
			des.createNewFile();
		}
		
		BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(source));
		BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(des));
		byte[] bytes = new byte[1024*1024];
		int len;
		while((len=bufferedInputStream.read(bytes)) != -1) {
			bufferedOutputStream.write(bytes, 0, len);
		}
		long endTime = System.currentTimeMillis();
		bufferedInputStream.close();
		bufferedOutputStream.close();
        return endTime - startTime;
        
	}
	
	private long transferFileWithNIO(File source, File des) throws IOException {
        long startTime = System.currentTimeMillis();

        if (!des.exists())
            des.createNewFile();

        RandomAccessFile read = new RandomAccessFile(source, "rw");
        RandomAccessFile write = new RandomAccessFile(des, "rw");

        FileChannel readChannel = read.getChannel();
        FileChannel writeChannel = write.getChannel();


        ByteBuffer byteBuffer = ByteBuffer.allocate(1024 * 1024);//1M缓冲区

        while (readChannel.read(byteBuffer) > 0) {
            byteBuffer.flip();
            writeChannel.write(byteBuffer);
            byteBuffer.clear();
        }

        writeChannel.close();
        readChannel.close();
        long endTime = System.currentTimeMillis();
        read.close();
        write.close();
        return endTime - startTime;
    }
	
	public static void main(String[] args) throws IOException {
		SimpleFileTransfer simpleFileTransferTest = new SimpleFileTransfer();
        File sourse = new File("D:\\zola_softeware\\downloads\\深入Java虚拟机（原书第2版）.pdf");
        File des = new File("newio.txt");
        File nio = new File("newnio.txt");

        long time = simpleFileTransferTest.transferFile(sourse, des);
        System.out.println(time + "：普通字节流时间");

        long timeNio = simpleFileTransferTest.transferFileWithNIO(sourse, nio);
        System.out.println(timeNio + "：NIO时间");
	}
}
