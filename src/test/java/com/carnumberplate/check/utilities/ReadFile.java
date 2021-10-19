package com.carnumberplate.check.utilities;

import javax.annotation.processing.FilerException;
import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadFile {
    private static String firstPattern = ".[a-zA-Z]{2}[0-9]{2}[a-zA-Z]{3}";
    private static String secondPattern = "[a-zA-Z]{2}[0-9]{2}\\s[a-zA-Z]{3}";
    public static String[] carRegArr = new String[4];
    private static List<String> carReg = new ArrayList<>();
    private static List<String> output = new ArrayList<>();


    public static String[] getCarRegArray(){
        return carRegArr;
    }

    public static List getOutput(){
        return output;
    }

    public static List inputFileReader() throws IOException {
        int arrayIndex = 0;
        Pattern pattern = Pattern.compile(firstPattern);
        Pattern patternTwo = Pattern.compile(secondPattern);
        Matcher matcher;
        Matcher matcherTwo;
        FileReader file = new FileReader("src/test/resources/car_input.txt");
        BufferedReader reader = new BufferedReader(file);
        String line = "";
        while ((line = reader.readLine()) != null) {
            if (line.contains("registration")) {
                matcher = pattern.matcher(line);
                matcherTwo = patternTwo.matcher(line);
                while (matcher.find()) {
                    carRegArr[arrayIndex]=matcher.group();
                    carReg.add(matcher.group());
                    arrayIndex++;
                }
                while (matcherTwo.find()) {
                    try {
                        carReg.add(matcherTwo.group());
                        carRegArr[arrayIndex]=matcherTwo.group();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    arrayIndex++;
                }
            }
        }
        return carReg;
    }

    public static List outputFileReader() throws IOException {

        FileReader file = new FileReader("src/test/resources/car_output.txt");
        BufferedReader reader = new BufferedReader(file);
        String line = "";
        while ((line = reader.readLine()) != null) {
            output.add(line);
        }
        return output;
    }

    public static List buildVehicleIdentity(String registration, String make,String model, String colour, String year){
        String builtVehicleIdentity = registration+","+make+","+model+","+colour+","+year;
        List<String> vehicleIdentity = new ArrayList<>();
        vehicleIdentity.add(builtVehicleIdentity);
        return vehicleIdentity;
    }
}



