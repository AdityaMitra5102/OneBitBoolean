package examples;

import OneBitBoolean.*;
import java.io.*;
class Test
{
    static long getSize(Serializable ser)
    {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try (ObjectOutputStream oos = new ObjectOutputStream(baos)) {
            oos.writeObject(ser);
        }
        catch(Exception excep){}
        return baos.size()-95; //Subtracting 95 to remove the size of headers of ObjectOutputStream and other unnecessary stuff. It will give the true object
    }

    public static void main(String args[]) throws Exception
    {
        System.out.println("Creating array of 7 and setting elements at positions 1, 3 and 5 as true with function set(int).");
        BitBooleanArray x=new BitBooleanArray(7);
        x.set(1);
        x.set(3);
        x.set(5);
        System.out.println(x);
        System.out.println("Setting element as position 3 false with function unset(int)");
        x.unset(3);
        System.out.println(x);
        System.out.println("Setting element as position 4 as true and position 5 as false with function setAt(int, boolean)");
        x.setValueAt(4,true);
        x.setValueAt(5,false);
        System.out.println(x);
        System.out.println("Size of the array in bytes is: "+getSize(x));
        
        System.out.println("\nComparing array length vs size in bytes");
        for(int i=1;i<=150;i+=6)
        {
            BitBooleanArray ob=new BitBooleanArray(i); 
            System.out.println("Array Length is "+ob.length()+" and size in bytes is "+getSize(ob));
        }
        
        System.out.println("\nAttempting to access out of bounds elements");
        x.set(10);
    }
}