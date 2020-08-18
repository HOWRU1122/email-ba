package com.tester.utils;

import java.io.*;
import java.util.List;

public class TsvUtil {

    public static void  writeCSV(List<List<String>> data, String filePath, String fileName, boolean hasTitle) {
        File csvFile = new File(filePath + "/" + fileName);
        BufferedWriter bufferedWriter = null;
        String line = null;
        try {
            // bufferedWriter=new BufferedWriter(new FileWriter(csvFile,true));
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(csvFile), "utf-8"));
            for (int i = 0; i < data.size(); i++) {
                line = null;
                if (hasTitle) {
                    line = getLine(data.get(i));
                }
                bufferedWriter.write(line.toString());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



        private static String getLine(List<String> items){
            StringBuilder line=new StringBuilder();
            for (int i=0;i<items.size();i++){
                line.append(items.get(i));
                if (i<(items.size()-1)){
                    line.append(",");
                }
            }
            return line.toString();
        }

}
