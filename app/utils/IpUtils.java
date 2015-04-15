package utils;

import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import play.Logger;
import play.Play;
import play.mvc.Http.Request;

public class IpUtils {

	public static String singleIp(String ip) {
		String ips[] = ip.split(",");
		return ips[0].trim();
	}
	
	public static long ipToLong(String ip) {
	    long result = 0;
	    try {
	        String[] strs = ip.split("\\.");
	        if(strs.length != 4)
	            throw new Exception();
	        int[] ips = new int[4];
	        for(int i = 0; i < 4; i ++) {
	            ips[i] = Integer.parseInt(strs[i]);
	        }
	        for(int i = 0; i < 4; i ++) {
	            result += ips[i]*Math.pow(256, 3-i);
	        }
	    }catch(Exception e) {
	    	Logger.error("ipToLong error,ip %s", ip);
	    }
	    return result;
	}
	
	public static String longToIP(long ip) {
	    String str = "";
	    str += ip % 256;
	    ip /= 256;
	    str = ip % 256 + "." + str;
	    ip /= 256;
	    str = ip % 256 + "." + str;
	    ip /= 256;
	    str = ip % 256 + "." + str;
	    return str; 
	 }
	
	public static String getIpLastStr(String ip,int last) {
		ip = String.valueOf(ipToLong(ip));
		return ip.substring(ip.length()-last, ip.length());
	}
	
	public static String getRealIp(Request request) {
		String ip = request.remoteAddress;
		if(Play.mode.isProd()) {
			ip = request.headers.get("x-real-ip").value();
		}
		return singleIp(ip);
	}
	
	public static void main(String[] args) throws IOException {
		String ip = "27.154.78.25";
		System.out.println(singleIp(ip));
		System.out.println(ipToLong(ip));
		System.out.println(longToIP(ipToLong(ip)));
		
		File input = new File("e:\\995.html");
		Document doc = Jsoup.parse(input, "UTF-8", "http://weidian.com/");
		Elements as = doc.getElementsByTag("a");
		for(Element link:as) {
			System.out.println(link.attr("href"));
		}
		
	}
}
