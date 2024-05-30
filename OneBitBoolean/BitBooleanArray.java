package OneBitBoolean;

/* BitBooleanArray.java 
This file is a part of OneBitBoolean Library.
 */
 
import java.io.Serializable;

/**
 * It is a custom implementation that works similar to 
 * boolean but it stores a boolean in 1 bit instead of 
 * consuming a whole byte.
 * 
 * A BitBooleanArray object creates an array of
 * byte type and uses it to store an array of
 * boolean values, using 1 bit space for each.
 * 
 * @author Aditya Mitra (adityamitra5102@gmail.com)
 */
public final class BitBooleanArray implements Serializable
{
    private byte arr[];
    private int size;

    /**
     * Parameterized constructor
     * This creates an array of n booleans specified by size
     * All the elements of the created array are 'false' by default.
     * 
     * @param size is the number of elements needed
     */
    public BitBooleanArray(int size)
    {
        this.size=size;
        int r=(int)Math.ceil(size/8.0);
        arr=new byte[r];
    }

    /**
     * A copy constructor. It is used to copy the 
     * value of a BitBooleanArray object into another.
     */
    public BitBooleanArray(BitBooleanArray barr)
    {
        this.size=barr.length();
        int r=(int)Math.ceil(size/8.0);
        arr=new byte[r];
        for(int i=0;i<r;i++) arr[i]=barr.arr[i];
    }

    /**
     * It returns the size of the array
     * 
     * @return size
     */
    public int length()
    {
        return size;
    }

    /**
     * Internal function
     * It validates whether the index is correct
     * 
     * @throws BitBooleanIndexOutOfBoundsException
     */
    private void validateIndex(int pos) throws BitBooleanIndexOutOfBoundsException
    {
        if(pos<0 || pos>=size)
        {
            throw new BitBooleanIndexOutOfBoundsException(pos, size);
        }
    }

    /**
     * It sets the n-th element of the array to true.
     * 
     * @param n the position of element.
     */
    public void set(int n)
    {
        validateIndex(n);
        arr[n/8]=(byte)(arr[n/8]|((1<<n%8)));
    }

    /**
     * It sets the n-th element of the array to true.
     * 
     * @param n the position of element.
     */
    public void unset(int n)
    {
        validateIndex(n);
        arr[n/8]=(byte)(arr[n/8]&~((1<<n%8)));
    }

    /**
     * It sets the n-th element of the array to {val}.
     * 
     * @param n the position of element.
     * @param val the value to set in true or false
     */
    public void setValueAt(int n, boolean val)
    {
        if(val) set(n);
        else unset(n);
    }

    /**
     * It returns the value of the n-th element of the array
     * as the boolean primitive data type.
     * 
     * @parameter n the position of the element
     * @return the value of the n-th element
     */
    public boolean get(int n)
    {
        validateIndex(n);
        return (arr[n/8]>>(n%8))%2==1;
    }

    /**
     * It converts the array of 8 elements into
     * an array of the primitive boolean data type.
     * 
     * @return boolean array
     */
    public boolean[] toBooleanArray()
    {
        boolean arr[]=new boolean[size];
        for(int i=0;i<size;i++)arr[i]=get(i);
        return arr;
    }

    /**
     * Returns the values of the array as a String
     * 
     * @return array as a string.
     */
    @Override
    public String toString()
    {
        String str="[";
        boolean arr[]=toBooleanArray();
        for (boolean x:arr) str+=x+", ";
        str=str.substring(0,str.length()-2)+"]";
        return str;
    }
}
