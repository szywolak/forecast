package com.weather;

import com.alibaba.fastjson.JSONObject;
import jdk.nashorn.internal.parser.JSONParser;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


/**
 * @author Crunchify.com
 *
 */

public class DUPA {

    public List getMisio() throws FileNotFoundException

    {
        BufferedReader br = new BufferedReader(new FileReader("user_reports/User01.json"));


        File ob = new File("user_reports/User01.json");


        List Misio = new ArrayList<>();


        try {
            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null) {
                Misio.add(sCurrentLine);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }


        return Misio;
    }
}



