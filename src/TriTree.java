/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Boogster
 */
public class TriTree {
    private int Count1;
    private int Count2;
    private TriNode root;
    private TriNode low;
    private TriNode middle;
    private TriNode high;

    

public void addNum(int num)
    {
        if (root == null)
        {
            root = new TriNode();
            root.setV1(num);
        }
        else
            addNumRec(root, num);
    }
    
    private void addNumRec(TriNode current, int num)
    {  
        if (!current.isNullV1() && current.isRemovedV1 && current.getV1() == num)
            current.isRemovedV1 = false;
        else if (!current.isNullV2() && current.isRemovedV2 && current.getV2() == num)
            current.isRemovedV2 = false;
        else if (current.isNullV2())
        {
            if (num >= current.getV1())
            {
                current.setV2(num);
            }
            else
            {
                if (current.low == null)
                {
                    TriNode tmp = new TriNode();
                    tmp.setV1(num);
                    tmp.parent = current;
                    current.low = tmp;     
                }
                else
                {
                    addNumRec(current.low, num);
                }
            }
        }
        else
        {
            if (num <= current.getV1())
            {
                if (current.low == null)
                {
                    TriNode tmp = new TriNode();
                    tmp.setV1(num);
                    tmp.parent = current;
                    current.low = tmp;     
                }
                else
                    addNumRec(current.low, num);
            }
            else if (num > current.getV1() && num < current.getV2())
            {
                if (current.middle == null)
                {
                    TriNode tmp = new TriNode();
                    tmp.setV1(num);
                    tmp.parent = current;
                    current.middle = tmp;     
                }
                else
                    addNumRec(current.middle, num);
            }
            else // must be greater than or equal to V2
            {
                if (current.high == null)
                {
                    TriNode tmp = new TriNode();
                    tmp.setV1(num);
                    tmp.parent = current;
                    current.high = tmp;     
                }
                else
                    addNumRec(current.high, num);
            }
        }         
    }
    
    public boolean find(int key)
    {
        return recFind(root ,key, false);
    }

    public boolean delete(int key)
    {
        return recFind(root ,key, true);
    }
    
    private boolean recFind(TriNode current, int key, boolean del)
    {
        boolean answer = false;
        if (current != null)
        {
        if (key <= current.getV1())
        {
            if (current.low != null) answer = recFind(current.low,key,del);
        }
        else if (key > current.getV1())
        {
            if (!current.isNullV2() && current.getV2() > key) 
            {
                if (current.middle != null) answer = recFind(current.middle,key,del);
            }
            if (!current.isNullV2() && current.getV2() <= key) 
            {
                if (current.high != null) answer = recFind(current.high,key,del);
            }  
            
        }
        
        if (current.getV1() == key && !current.isRemovedV1) 
        {
           current.isRemovedV1 = del; //delete if we are deleting
           answer = true; 
        }
            
        
        if (current.getV2() == key && !current.isRemovedV2) 
        {
           current.isRemovedV2 = del; //delete if we are deleting
           answer = true; 
        }      
        }         
        return answer;
    }
    
    
    
    public String printTri()
    {   
        Count1 = 0;
        Count2 = 0;
        return recPrint(root);
    }

    public String CountNode()
    {   
        Count1 = 0;
        Count2 = 0;
        return "<html><b>Tree Values:</b><br>" + recPrint(root) + recCountNode(root);
    }
     private String recPrint(TriNode current)
    {
        String answer = "";

        if (current != null)
        {
            answer += recPrint(current.low);
            if (!current.isRemovedV1 && !current.isNullV1()) answer += current.getV1() + ", ";
            answer += recPrint(current.middle);
            if (!current.isRemovedV2 && !current.isNullV2()) answer += current.getV2() + ", ";
            answer += recPrint(current.high);
        }
        
        return answer;
    }
    private String recCountNode(TriNode current)
    {
        if (current != null)
        {
            if (current.isNullV2())
                Count1++;
            else
                Count2++;
            
            recCountNode(current.low);
            recCountNode(current.middle);
            recCountNode(current.high);
        }
        
        return "\n\n\nNode Occupancy\nOne value nodes: " + Count1 + "\nTwo value nodes: " + Count2;
    }
    
}
     
        
        

    
    

