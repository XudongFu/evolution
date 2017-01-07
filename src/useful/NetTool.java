package useful;

import java.util.*;
import java.io.*;
import java.net.*;

public class NetTool 
{

	public static String sendGet(String url, List<HTTPParam> list) throws IOException {
        StringBuffer buffer = new StringBuffer(); //����ƴ�Ӳ���
        StringBuffer result = new StringBuffer(); //�������ܷ���ֵ
        URL httpUrl = null; //HTTP URL�� �����������������
        URLConnection connection = null; //������http����
        BufferedReader bufferedReader = null; //���������ܵĲ���
        //������ڲ��������ǲ���Ҫƴ�Ӳ��� ������ localhost/index.html?a=a&b=b
        if (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                buffer.append(list.get(i).getKey()).append("=").append(URLEncoder.encode(list.get(i).getValue(), "utf-8"));
                //����������һ������������Ҫ���&
                if ((i + 1) < list.size()) {
                    buffer.append("&");
                }
            }
            url = url + "?" + buffer.toString();
        }
        //����URL
        httpUrl = new URL(url);
        //��������
        connection = httpUrl.openConnection();
       
        connection.setRequestProperty("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
        connection.setRequestProperty("connection", "keep-alive");
        connection.setRequestProperty("user-agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:34.0) Gecko/20100101 Firefox/34.0");
        connection.connect();
        //�������ӷ��ز���
        bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            result.append(line);
        }
        bufferedReader.close();
        
       return result.toString();
    }
 
    /**
     * ����Post����
     *
     * @param url  �����ַ
     * @param list �������
     *
     * @return ������
     *
     * @throws IOException
     */
    public static String sendPost(String url, List<HTTPParam> list) throws IOException {
        StringBuffer buffer = new StringBuffer(); //����ƴ�Ӳ���
        StringBuffer result = new StringBuffer(); //�������ܷ���ֵ
        URL httpUrl = null; //HTTP URL�� �����������������
        URLConnection connection = null; //������http����
        PrintWriter printWriter = null;
        BufferedReader bufferedReader; //���������ܵĲ���
        //����URL
        httpUrl = new URL(url);
        //��������
        connection = httpUrl.openConnection();
        connection.setRequestProperty("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
        connection.setRequestProperty("connection", "keep-alive");
        connection.setRequestProperty("user-agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:34.0) Gecko/20100101 Firefox/34.0");
        connection.setDoOutput(true);
        connection.setDoInput(true);
        printWriter = new PrintWriter(connection.getOutputStream());
        if (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                buffer.append(list.get(i).getKey()).append("=").append(URLEncoder.encode(list.get(i).getValue(), "utf-8"));
                //����������һ������������Ҫ���&
                if ((i + 1) < list.size()) {
                    buffer.append("&");
                }
            }
        }
        printWriter.print(buffer.toString());
        printWriter.flush();
        connection.connect();
        //�������ӷ��ز���
        bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            result.append(line);
        }
        bufferedReader.close();
        
       byte[] shuzu=result.toString().getBytes("UTF-8");
        return new String(shuzu,"US-ASCII");
        
    }

	
	public static void main(String[] args) 
	{
	
		String url="http://ip.chinaz.com/";
		HTTPParam canshu=new HTTPParam("ip","125.236.14.23");
		
		ArrayList<HTTPParam> can=new ArrayList<>();
		can.add(canshu);
		try {
			String resString=sendGet(url, can);
			System.out.println(resString);
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		
		
		
		
		
		
		
	}

}
