package com.mio.wechat.gzh.util;

import java.util.Arrays;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;

public class Sha1Util {

	  public static String gen(String... arr) {
		    if (StringUtils.isAnyEmpty(arr)) {
		      throw new IllegalArgumentException("参数为空: " + Arrays.toString(arr));
		    }

		    Arrays.sort(arr);
		    StringBuilder sb = new StringBuilder();
		    for (String a : arr) {
		      sb.append(a);
		    }
		    return DigestUtils.sha1Hex(sb.toString());
		  }

		  public static String genWithAmple(String... arr) {
		    if (StringUtils.isAnyEmpty(arr)) {
		      throw new IllegalArgumentException("参数为空: " + Arrays.toString(arr));
		    }

		    Arrays.sort(arr);
		    StringBuilder sb = new StringBuilder();
		    for (int i = 0; i < arr.length; i++) {
		      String a = arr[i];
		      sb.append(a);
		      if (i != arr.length - 1) {
		        sb.append('&');
		      }
		    }
		    return DigestUtils.sha1Hex(sb.toString());
		  }
}
