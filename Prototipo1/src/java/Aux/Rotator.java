/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Aux;

/**
 *
 * @author ice
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
