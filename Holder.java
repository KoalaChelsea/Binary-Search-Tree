/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab3;

/**
 *
 * @author Yingjie(Chelsea) Wang
 */
import java.util.Scanner;
public class Holder {
    public static void main(String[] args) {
      BinSeaTree myBST = new BinSeaTree();
      String buffer = "ok";
      Scanner kbd = new Scanner(System.in);
      myBST.insert("Old Spice");
      //myBST.display();
      myBST.insert("Clic");
      //myBST.display();
      myBST.insert("Turpentine");
      //myBST.display();
      myBST.insert("Apes");
      //myBST.display();
      myBST.insert("Zima");
      //myBST.display();
      myBST.insert("Quality Inn");
      //myBST.display();
      myBST.insert("Bear");
      //myBST.display();
      myBST.insert("Amen");
      myBST.insert("Anand");
      //myBST.balance();
      myBST.insert("Anarchy");
      //myBST.insert("Ocean");
      //myBST.insert("Open");
      System.out.println("There are (is) " + myBST.getSize() + " node(s)");
      
      do {
      System.out.println("#### >> Menu << (1) Find (2) Display (3) Balance (4) Size (5) Insert " +
      "(6) Delete (7) Quit << ####");
      buffer = kbd.next();
      if(buffer.charAt(0) == '1')   {
         kbd.nextLine();
         System.out.print("Enter a String to search for in the BINSEATREE: ");
         buffer = kbd.nextLine();
         if(myBST.find(buffer)) System.out.println("\n**** " + buffer + " is in the BINSEATREE at level " +
            myBST.getLevel() + " ****");
         else System.out.println("**** " + buffer + " is not in the BINSEATREE****");
      }
      if(buffer.charAt(0) == '2')   {
         kbd.nextLine();
         myBST.display();
      }
      if(buffer.charAt(0) == '3')   {
         kbd.nextLine();
         myBST.balance();
      }
      if(buffer.charAt(0) == '4')   {
         kbd.nextLine();
         System.out.println("BINSEATREE consists of " + myBST.getSize() + " node(s)");
      }
      if(buffer.charAt(0) == '5')   {
         kbd.nextLine();
         System.out.print("\n Enter a String of characters to insert into the BINSEATREE: ");
         buffer = kbd.nextLine();
         if(myBST.insert(buffer))
            System.out.print("\n" + buffer + " inserted into BINSEATREE\n");
         else
            System.out.print("\n" + buffer + " no duplicates allowed in BINSEATREE\n");
      }
      if(buffer.charAt(0) == '6')   {
         kbd.nextLine();
         System.out.print("\n Enter a String of characters to delete from the BINSEATREE: ");
         buffer = kbd.nextLine();
         if(myBST.delete(buffer))
            System.out.print("\n" + buffer + " deleted from BINSEATREE\n");
         else
            System.out.print("\n" + buffer + " not found in BINSEATREE\n");
      }
      } while(buffer.charAt(0) != '7');
   }
}
