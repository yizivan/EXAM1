import java.math.BigDecimal;
import java.util.Scanner;
import java.util.regex.*;
public class Complex
{
    private static Scanner keyboard = new Scanner(System.in);
    private double A,B;
    public static Boolean isNumeric(String str)
    {
        Pattern pattern = Pattern.compile("-?[0-9]+(\\.[0-9]+)?");
        String bigStr;
        try
        {
            bigStr = new BigDecimal(str).toString();
        } catch (Exception e)
        {
            return false;
        }
        Matcher isNum = pattern.matcher(bigStr);
        if (!isNum.matches())
        {
            return false;
        }
        return true;
    }
    public Complex()
    {

    }
    public Complex(double a, double b)
    {
        A = a;
        B = b;
    }
    public void read()
    {
        String str; 
        do
        {
            System.out.println("Please enter the real part of your complex number.");
            System.out.println("This number may be positive or negative and may be an integer or a decimal number.(e.g. 5, -5, 1.5, -1.5)");
            str = keyboard.nextLine();
            if (!isNumeric(str))
            {
                System.out.println("wrong input type.");
            }
        }
        while (!isNumeric(str));
        A = Double.parseDouble(str);  
        do
        {
            System.out.println("Please enter the imaginary part of your complex number.");
            System.out.println("This number may be positive or negative and may be an integer or a decimal number.(e.g. 5, -5, 1.5, -1.5)");
            str = keyboard.nextLine();
            if (!isNumeric(str))
            {
                System.out.println("wrong input type.");
            }
        }
        while (!isNumeric(str));
        B = Double.parseDouble(str);
    }
    public String toString()
    {
        return(String.format("%.2f", A) + " + " + String.format("%.2f", B) + "i");
    }
    public Boolean equals(Complex complex)
    {
        if (A == complex.getA() && A == complex.getB())
        return true;
        return false;
    }
    public double getA()
    {
        return A;
    }
    public double getB()
    {
        return B;
    }
    public void changeA(double a)
    {
        A = a;
    }
    public void changeB(double b)
    {
        B = b;
    }
    public Complex add(Complex complex)
    {
        Complex subCom = new Complex();
        subCom.changeA(A + complex.getA());
        subCom.changeB(B + complex.getB());
        return subCom; 
    }
    public Complex subtract(Complex complex)
    {
        Complex subCom = new Complex();
        subCom.changeA(A - complex.getA());
        subCom.changeB(B - complex.getB());
        return subCom; 
    }
    public Complex multiply(Complex complex)
    {
        Complex subCom = new Complex();
        subCom.changeA(A*complex.getA() - B*complex.getB());
        subCom.changeB(A*complex.getB() + B*complex.getA());
        return subCom; 
    }
    public Complex divide(Complex complex)
    {
        Complex subCom = new Complex();
        subCom.changeA((A*complex.getA() + B*complex.getB())/(complex.getA()*complex.getA() + complex.getB()*complex.getB()));
        subCom.changeB((B*complex.getA() - A*complex.getB())/(complex.getA()*complex.getA() + complex.getB()*complex.getB()));
        return subCom;
    }
}