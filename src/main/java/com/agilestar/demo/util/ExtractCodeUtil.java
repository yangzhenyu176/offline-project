package com.agilestar.demo.util;
import sun.misc.BASE64Decoder;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * @author yangzhenyu
 * @date 2022年01月10日 16:48
 */
public class ExtractCodeUtil {

    private static final String CODE_DIR_NAME="code";

    public static void readTxtFile(String filePath, String targetPath, String oldPath) {
        String encoding;
        try {
            encoding = "GBK";
            File file = new File(filePath);
            if ((file.isFile()) && (file.exists())) {
                InputStreamReader read = new InputStreamReader(
                        new FileInputStream(file), encoding);
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                int num = 0;
                mkdir(targetPath + File.separator+CODE_DIR_NAME);
                while ((lineTxt = bufferedReader.readLine()) != null) {
                    String shortLineTxt = lineTxt.substring(0,
                            lineTxt.lastIndexOf("/"));
                    String shortLineFileName=lineTxt.substring(lineTxt.lastIndexOf("/")+1);
                    String newPath = targetPath +File.separator+CODE_DIR_NAME+File.separator+ shortLineFileName;
                    copyFile(oldPath + lineTxt, newPath);
                    ++num;
                }
                read.close();
                System.out.println("文件复制完成！共复制" + num + "个文件！请确认！");
            } else {
                System.out.println("找不到指定的文件");
            }
        } catch (Exception e) {
            System.out.println("读取文件内容出错");
            e.printStackTrace();
        }
    }

    public static void mkdir(String path) {
        File foder = new File(path);
        if (!(foder.exists())) {
            foder.mkdirs();
        }
    }

    public static void copyFile(String oldPath, String newPath) {
        int bytesum;
        try {
            bytesum = 0;
            int byteread = 0;
            File oldfile = new File(oldPath);
            if (oldfile.exists()) {
                InputStream inStream = new FileInputStream(oldPath);
                FileOutputStream fs = new FileOutputStream(newPath);
                byte[] buffer = new byte[1444];

                while ((byteread = inStream.read(buffer)) != -1) {
                    bytesum += byteread;
                    fs.write(buffer, 0, byteread);
                }
                System.out.println("正在复制文件：" + oldPath);
                inStream.close();
            }
        } catch (Exception e) {
            System.out.println("复制单个文件操作出错");
            e.printStackTrace();
        }
    }

    public static boolean string2Image(String imgStr, String imgFilePath) {
        // 对字节数组字符串进行Base64解码并生成图片
        if (imgStr == null)
            return false;
        try {
            // Base64解码
            byte[] b = new BASE64Decoder().decodeBuffer(imgStr);
            for (int i = 0; i < b.length; ++i) {
                if (b[i] < 0) {
                    // 调整异常数据
                    b[i] += 256;
                }
            }
            // 生成Jpeg图片
            OutputStream out = new FileOutputStream(imgFilePath);
            out.write(b);
            out.flush();
            out.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    public static void main(String[] args) {
        /*Scanner scanner = new Scanner(System.in);
        System.out.println("请输入代码列表：");
        String filePath = scanner.nextLine();
        System.out.println("请输入代码源文件地址：");
        String oldPath = scanner.nextLine();

        File directory = new File("");
        String targetPath = directory.getCanonicalPath();
        System.out.println(targetPath);
        readTxtFile(filePath, targetPath, oldPath);
        String a="G_SPECIAL_NO_PHONE";
        System.out.println(a.substring(2,a.length()));*/
        String str = "";

        //string2Image(str,"D://aa.jpg");
    }
}
