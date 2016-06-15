package com.bhn.owasp.xss;

import org.owasp.encoder.Encode;

public class ExampleXssExcoding {
	public static void main(String[] args){
		String sample = "<script>inputString<script>";
		String str = Encode.forHtml(sample);
		System.out.println(str);
		str = Encode.forJavaScript(sample);
		System.out.println(str);
		str = Encode.forCssString(sample);
		System.out.println(str);
		str = Encode.forHtmlAttribute(sample);
		System.out.println(str);
		str = Encode.forUriComponent(sample);
		System.out.println(str);
	}
}
