package Lab3;

/**
 *
 * @author Yingjie(Chelsea) Wang
 */
public class BinSeaTree {
   private Node root = null;
   private int size = 0, level, lChildCount = 0, rChildCount = 0;
   private String buffer, tuffer;
   private boolean sFlag;
   
   public boolean insert(String aString)  {
      Node ptr = root;
      return insert(aString, ptr);
   }
   
   private boolean insert(String aString, Node ptr)   {
      if(size == 0)  {
         root = new Node(null, null, aString);
         size++;
         return true;
      }
      else if(ptr.getLChild() == null && aString.compareTo(ptr.getAString()) < 0)   {
          //System.out.println("****DIAGNOSTIC MESSAGE > Assigning new left child < END****");
          ptr.setLChild(new Node(null, null, aString));
          size++;
          return true;
      }
      else if(ptr.getRChild() == null && aString.compareTo(ptr.getAString()) > 0)  {
          //System.out.println("****DIAGNOSTIC MESSAGE > Assigning new right child < END****");
          ptr.setRChild(new Node(null, null, aString));
          size++;
          return true;   
      }
      if(aString.compareTo(ptr.getAString()) < 0)  {
         return insert(aString, ptr.getLChild());
      }
      else if(aString.compareTo(ptr.getAString()) > 0)  {
         return insert(aString, ptr.getRChild());
      }
      else return false;
   }
   
   public boolean delete(String aString)  {
      boolean found = false;
      if(find(aString)) {
         System.out.println("****DELETING! > " + aString + " < ****");
         found = true;
         Node ptr = root;
         Node tpr = null;
         while (ptr.getLChild() != null || ptr.getRChild() != null)  {
            if(ptr.getAString().compareTo(aString) < 0)  {
               //System.out.println("**** GOING RIGHT IN delete(String) ****");
               tpr = ptr;
               ptr = ptr.getRChild();
            }
            else if (ptr.getAString().compareTo(aString) > 0)  {
               //System.out.println("**** GOING LEFT IN delete(String) ****");
               tpr = ptr;
               ptr = ptr.getLChild(); 
            }
            else break;
         }
         
         //System.out.println("****DIAGNOSTIC MESSAGE > " + tpr.getAString() + " < ****");
         //System.out.println("****DIAGNOSTIC MESSAGE > " + ptr.getAString() + " < ****");
         
         if(tpr == null)   {
            Node temp = smallRight(ptr, ptr);
            //ptr.setAString(temp.getAString());
            //--size;
            //found = true;
            //System.out.println("****DIAGNOSTIC MESSAGE > \"tpr == null is true\" < ****");
            //System.out.println("****DIAGNOSTIC MESSAGE > " + temp.getAString() + " < ****");
            ptr.setAString(temp.getAString());
            found = true;
            --size;
            return found;
         }
         if(ptr.getLChild() == null && ptr.getRChild() == null)   {
        	/*
            if(tpr.getLChild() == null)   {
               System.out.println("****DIAGNOSTIC MESSAGE > ptr has no children deleting reference " +
                  "at the left of tpr");
               //tpr.setLChild(null);
               tpr.setRChild(null);
               --size;
               found = true;
            }
            else  {
               System.out.println("****DIAGNOSTIC MESSAGE > ptr has no children deleting reference " +
                  "at the right of tpr");
               System.out.println("");
               tpr.setLChild(null);
               --size;
               found = true;
            }
        	*/
        	 if (tpr.getLChild() == ptr)
        		 tpr.setLChild(null);
        	 else
        		 tpr.setRChild(null);
        	 
             --size;
             found = true;
        	 
         }
         else if(ptr.getLChild() != null && ptr.getRChild() != null) {
            Node temp = smallRight(ptr, tpr);
            if(temp != null) {
             //  ptr.setAString(temp.getAString());
           	 if (tpr.getLChild() == ptr)
        		 tpr.setLChild(temp);
        	 else
        		 tpr.setRChild(temp);
            	
               --size;
               found = true;
            }
         }
         else if(ptr.getLChild() != null && ptr.getRChild() == null) {
            if(ptr.getAString().equals(tpr.getLChild().getAString()))   {
               tpr.setLChild(ptr.getLChild());
               --size;
               found = true;
            }
            else  {
               tpr.setRChild(ptr.getLChild());
               --size;
               found = true;
            } 
         }
         else if(ptr.getLChild() == null && ptr.getRChild() != null) {
            Node temp = smallRight(ptr, tpr);
            if(temp != null)  {
               //ptr.setAString(temp.getAString());
            	if (tpr.getLChild() == ptr)
            		tpr.setLChild(temp);
            	else
            		tpr.setRChild(temp);
               --size;
               found = true;   
            }
         }
      }
      return found;
   }
   /** Get the address of the smallest Node in Right Subtree and Dereference */
   private Node smallRight(Node start, Node tpr)  {
      boolean wLeft = false;
      Node ptr = start;
      //if(ptr.getAString().equals(tpr.getLChild().getAString()))   {
      if(ptr == tpr.getLChild())   {
         tpr = tpr.getLChild();
      }
      else  {
         tpr = tpr.getRChild();
      }
      if(ptr.getRChild() == null) return null;
      else ptr = ptr.getRChild(); 
      while(ptr.getLChild() != null)  {
         wLeft = true;
         tpr = ptr;
         ptr = ptr.getLChild();
      }
      System.out.println("****DIAGNOSTIC MESSAGE > " + ptr.getAString() + " < smallRight****");
      if(wLeft) tpr.setLChild(null);
      else tpr.setRChild(null);
      return ptr;
   }
   
   public boolean find(String aString) {
      level = 0;
      return find(aString, root);
   }
   
   private boolean find(String aString, Node ptr) {
      //System.out.println("****DIAGNOSTIC MESSAGE > " + ptr.getAString() + " " + ptr + " < ****");
      //if(aString.equals(ptr.getAString())) return true;
      if(ptr == null) return false;
      /*if(ptr.getLChild() == null && ptr.getRChild() == null && aString.equals(ptr.getAString())) {
         return true;
      }*/
      if(ptr.getAString().equals(aString)) return true;
      if(ptr.getLChild() == null && ptr.getRChild() == null) return false;
      if(ptr.getAString().compareTo(aString) < 0)   {
         level++;
         System.out.println("****GOING RIGHT****");
         return find(aString, ptr.getRChild());
      }
      else  {
         level++;
         System.out.println("****GOING LEFT****");
         return find(aString, ptr.getLChild());
      }      
   }
   
   public void display()   {
      display(root);
   }
   
   private void display(Node ptr)   {
      if(ptr == null) return;
      if(ptr.getLChild() != null)   {
         display(ptr.getLChild());
         System.out.println("****BINSEATREENODE >> " + ptr.getAString()+ " << END BINSEATREENODE****");
      }
      else  {
         System.out.println("****BINSEATREENODE >> " + ptr.getAString()+ " << END BINSEATREENODE****");
      }
      if(ptr.getRChild() != null)   {
         display(ptr.getRChild());
         }
      else  {
      }
   }
   
   public int getSize() {
      return size;
   }
   
   public int getLevel()   {
      return level;
   }
   
   public void balance()   {
      balance(root, root.getLChild(), root.getRChild());
   }
   
   private void balance(Node ptrC, Node ptrPL, Node ptrPR)   {
      if(ptrC == null || (ptrPL == null && ptrPR == null)) return;
      if(ptrC.getRChild() == null) {
         if(ptrPL.getRChild() != null) { 
            if(ptrPL.getRChild().getLChild() == null) {
               if(ptrPL.getRChild().getRChild() == null) {
                  buffer = ptrC.getAString();
                  ptrC.setAString(ptrPL.getRChild().getAString());
                  ptrC.setRChild(ptrPL.getRChild());
                  ptrC.getRChild().setAString(buffer);
                  ptrPL.setRChild(null);
                  System.out.println("****DIAGNOSTIC MESSAGE > L,LL,LLR OPTIMIZED < ****");
               }
            }
         }
      }
      if(ptrC.getLChild() == null)  {
         if(ptrC.getRChild() != null && ptrPR.getLChild() == null)   {
            if(ptrPR.getRChild() != null) {
               if(ptrPR.getRChild().getLChild() == null) { 
                  if(ptrPR.getRChild().getRChild() == null) {
                     buffer = ptrC.getAString();
                     tuffer = ptrC.getRChild().getAString();
                     ptrC.setAString(tuffer);
                     ptrPR.setAString(ptrPR.getRChild().getAString()); 
                     ptrC.setLChild(new Node(null, null, buffer));
                     ptrC.getLChild().setAString(buffer);
                     ptrPR.setRChild(null);
                     System.out.println("****DIAGNOSTIC MESSAGE > L,LR,LRR OPTIMIZED < ****");
                  }
               }
            }
         }
      }
      if(ptrPL != null) {
         balance(ptrPL, ptrPL.getLChild(), ptrPL.getRChild());
         System.out.println("****DIAGNOSTIC MESSAGE > RECURSING OVER LEFT SUBTREES < ****");
      }
      if(ptrPR != null)  {
         balance(ptrPR, ptrPR.getLChild(), ptrPR.getRChild());
         System.out.println("****DIAGNOSTIC MESSAGE > RECURSING OVER RIGHT SUBTREES < ****");
      }
   }
}

