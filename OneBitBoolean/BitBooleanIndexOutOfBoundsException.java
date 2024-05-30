package OneBitBoolean;

/* BitBooleanIndexOutOfBoundsException.java 
This file is a part of OneBitBoolean Library.
 */

  

/**
 * It is an exception thrown when element 
 * out of bounds is attempted to be accessed.
 * 
 * 
 * @author Aditya Mitra (adityamitra5102@gmail.com)
 */
public class BitBooleanIndexOutOfBoundsException extends RuntimeException
{
    public BitBooleanIndexOutOfBoundsException(int pos, int max)
    {
        super("Index should be between 0 to "+max+". Found "+pos);
    }
}
