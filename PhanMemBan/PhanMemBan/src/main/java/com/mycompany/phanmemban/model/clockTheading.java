/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.phanmemban.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JLabel;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class clockTheading extends Thread {

    private JLabel lb1;

    public clockTheading(JLabel lb1) {
        this.lb1 = lb1;
    }

    public void run() {
        SimpleDateFormat formater = new SimpleDateFormat("hh:mm:ss aa");
        while (true) {
            Date now = new Date();
            String st = formater.format(now);
            lb1.setText(st);
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
            }
        }
    }
}
