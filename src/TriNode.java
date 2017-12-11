/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Boogster
 */
public class TriNode {
    private boolean isNullV1 = true;
    private boolean isNullV2 = true;
    public boolean isRemovedV1 = false;
    public boolean isRemovedV2 = false;
    public TriNode parent;
    public TriNode low;
    public TriNode middle;
    public TriNode high;
    private int V1;
    private int V2;
    
    public int getV1() {
        return V1;
    }

    public void setV1(int V1) {
        this.V1 = V1;
        isNullV1 = false;
        isRemovedV1 = false;
    }

    public int getV2() {
        return V2;
    }

    public void setV2(int V2) {
        this.V2 = V2;
        isNullV2 = false;
        isRemovedV2 = false;
    }

    public boolean isNullV1() {
        return isNullV1;
    }

    public boolean isNullV2() {
        return isNullV2;
    }
     public void isRemovedV1() {
        isRemovedV1 = true;
    }

    public void isRemovedV2() {
        isRemovedV2 = true;
}
}
