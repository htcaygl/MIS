package com.mis.utilities;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UsefulMethods {

    public static String getDayAndMonth() {

        LocalDate currentdate = LocalDate.now();

        LocalDateTime currentDateTime = LocalDateTime.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        String formattedDateTime = currentDateTime.format(formatter);

        //Getting the current day
        int currentDay = currentdate.getDayOfMonth();
        //Getting the current month
        int currentMonth = currentdate.getMonthValue();



      //  return currentDay+""+currentMonth;
        return formattedDateTime;
    }


}
