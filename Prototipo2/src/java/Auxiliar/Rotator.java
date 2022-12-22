/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Auxiliar;

/**
 *
 * @author Kardiinal
 */
public class Rotator {
    private String images[] = {"Images/aws.png",  "Images/azure.png", "Images/google.png"};
    
    private String links[] = {
        "https://aws.amazon.com",
        "https://azure.microsoft.com",
        "https://cloud.google.com",
    };
    
    private int selectedIndex = 0;
    
    public String getImage(){
        return images[selectedIndex];
    }
    
    public String getLink(){
        return links[selectedIndex];
    }
    
    public void nextAd(){
        selectedIndex = (selectedIndex + 1) % images.length;
    }
}
