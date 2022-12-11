/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.phanmemban.Untilies;

import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class XImage {
     public  static Image getAppicon(){
         URL url = XImage.class.getResource("/images/fpt.png");
         return new ImageIcon(url).getImage();
     }
}
