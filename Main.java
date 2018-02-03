package com.Lebomba;

import java.lang.*;
import java.util.*;


public class Main {

    public static void main(String[] args) {
	// write your code here

        // Declare Variables
        FileInput indata = new FileInput("sample.txt");
        FileInput inData2 = new FileInput("fileOut.txt");
        FileOutput outData = new FileOutput("fileOut.txt");
        String cryptLine;


        // String to hold line
        String line;
        String codedLine = "";

        // print message to screen
        System.out.println("Read from file and encrypt data.");
        // line gets the whole line of data as a single string
        while ((line = indata.fileReadLine()) != null) {
            // encrypt line

            line = encryption(line, 6);
            codedLine = codedLine + "\n" + line;



        }
        // close file stream objects
        indata.fileClose();
        outData.fileWrite(codedLine);
        outData.fileClose();


        System.out.println("read encrypted data and decrypt it. Show results on screen.");
        // Get and decrypt data
        while ((cryptLine = inData2.fileReadLine()) != null) {
            cryptLine = decryption(cryptLine, 6);
            //read decrypted data and print to screen.
            System.out.println(cryptLine);
        }
        //close file stream object
        inData2.fileClose();




            System.out.println("end of program");

    }// end of main

    //Found this code below online. I added a blank space for it to recognize the blank space
    // the follow code below had to be modified to recognize blank spaces
    // So 3 modifications were made from the original code to make this work
    public static final String ALPHABET = " abcdefghijklmnopqrstuvwxyz";


    public static String encryption(String plainText, int shiftKey)
    {
        plainText = plainText.toLowerCase();
        String cipherText = "";
        for (int i = 0; i < plainText.length(); i++)
        {
            int charPosition = ALPHABET.indexOf(plainText.charAt(i));
            int keyVal = (shiftKey + charPosition) % 27;
            char replaceVal = ALPHABET.charAt(keyVal);
            cipherText += replaceVal;
        }
        return cipherText;
    } // end of encryption


    public static String decryption(String cipherText, int shiftKey)
    {
        cipherText = cipherText.toLowerCase();
        String plainText = "";
        for (int i = 0; i < cipherText.length(); i++)
        {
            int charPosition = ALPHABET.indexOf(cipherText.charAt(i));
            int keyVal = (charPosition - shiftKey) % 27;
            if (keyVal < 0)
            {
                keyVal = ALPHABET.length() + keyVal;
            }
            char replaceVal = ALPHABET.charAt(keyVal);
            plainText += replaceVal;
        }
        return plainText;
    }





    }// end of class

