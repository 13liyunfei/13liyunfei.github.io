package com.admin.java;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.util.Enumeration;
import java.util.Vector;

public class TestDemo01 {
	// 两个包含InputStream流对象合并成一个输入流
		public static void SequenceInputStream01(InputStream inputStream01, InputStream inputStream02) throws Throwable {
			SequenceInputStream inputStream = new SequenceInputStream(inputStream01, inputStream02);
			int n;
			while ((n = inputStream.read()) != -1) {
				System.out.print((char) n);
			}
		}

		// 枚举器对象输入流合并
		public static void SequenceInputStream02(Enumeration<ByteArrayInputStream> enumeration) throws Throwable {
			SequenceInputStream inputStream = new SequenceInputStream(enumeration);
			int n=0;
			while ((n = inputStream.read()) != -1) {
				System.out.print((char) n);
			}
		}

		public static void main(String[] args) throws Throwable {
			ByteArrayInputStream arrayInputStream01 = new ByteArrayInputStream("12 ".getBytes());
			ByteArrayInputStream arrayInputStream02 = new ByteArrayInputStream("3456 ".getBytes());
			ByteArrayInputStream arrayInputStream03 = new ByteArrayInputStream("7890 ".getBytes());
			ByteArrayInputStream arrayInputStream04 = new ByteArrayInputStream("1234 ".getBytes());
			ByteArrayInputStream arrayInputStream05 = new ByteArrayInputStream("9876 ".getBytes());
			Vector<ByteArrayInputStream> vector = new Vector<ByteArrayInputStream>();
			vector.add(arrayInputStream01);
			vector.add(arrayInputStream02);
			vector.add(arrayInputStream03);
			vector.add(arrayInputStream04);
			vector.add(arrayInputStream05);
//			SequenceInputStream01(arrayInputStream01, arrayInputStream02);
//			System.out.println();
			SequenceInputStream02(vector.elements());

		}
}
