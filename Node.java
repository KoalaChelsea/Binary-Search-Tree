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
public class Node {
    private Node lChild;
   private Node rChild;
   private String aString;
   
   public Node()  {
      lChild = null;
      rChild = null;
      aString = "";
   }
   
   public Node(Node lChild, Node rChild, String aString) {
      setLChild(lChild);
      setRChild(rChild);
      setAString(aString);
   }
   
   public void setLChild(Node lChild)  {
      this.lChild = lChild; 
   }
   
   public void setRChild(Node rChild)  {
      this.rChild = rChild;
   }
   
   public void setAString(String aString) {
      this.aString = aString;
   }
   
   public Node getLChild() {
      return lChild;
   }
   
   public Node getRChild() {
      return rChild;
   }
   
   public String getAString() {
      return aString;
   }
}
