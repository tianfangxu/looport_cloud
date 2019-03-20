package com.yollweb.looport.utils;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ImgUtil {

    /**
     * 取得base64 文件内容
     * @param base64Code 文件数据
     * @return 文件内容
     */
    public static String getFileContent(String base64Code) {
        Pattern p = Pattern.compile("data:[^;]+;base64,");
        Matcher matcher = p.matcher(base64Code);
        if (matcher.find()) {
            return base64Code.replace(matcher.group(0), "");
        } else {
            return base64Code;
        }
    }

    /***
     * 将base64转成图片
     * @throws IOException
     * return 文件路径（不包含入参path）
     */
    public static String Base64File(String base64,String path,String fileName) throws IOException {
        if(base64 == null){
            return null;
        }
        BASE64Decoder base64Decoder = new BASE64Decoder();
        try {
            base64 = getFileContent(base64);
            byte[] bs = base64Decoder.decodeBuffer(base64);
            for (int i = 0; i < bs.length; i++) {
                if(bs[i]<0){
                    bs[i]+=256;
                }
            }
            String dataUrl = DateUnit.getTime8();
            String string =path+ dataUrl;
            File file = new File(string);
            if(!file.exists()){
                file.mkdirs();
            }
            String name =string+"/"+fileName+".jpg";
            FileOutputStream outputStream = new FileOutputStream(name);
            outputStream.write(bs);
            outputStream.flush();
            outputStream.close();
            return dataUrl+"/"+fileName+".jpg";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /****
     * 将图片转成base64
     */
    public static String FileToBase64(String path){
        if(path == null){
            return null;
        }
        InputStream in = null;
        byte[] data = null;
        //读取图片字节数组
        try{
            in = new FileInputStream(path);
            data = new byte[in.available()];
            in.read(data);
            in.close();
        }
        catch (IOException e){
            e.printStackTrace();
            return "";
        }
        //对字节数组Base64编码
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(data);//返回Base64编码过的字节数组字符串
    }
}
