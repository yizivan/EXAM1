import java.util.Scanner;

public class ComplexNumberDemoEngine
{

  /**
   * Aurthor Larry Shannon This program performs complex number math using a
   * complex number class. Enter a do loop to run the menu. Ask user to enter
   * two complex numbers Store the complex numbers in Complex Number object
   * variables Ask the user to select a math operation. Print menu of math
   * options Get user choice Use "switch" on user's choice When case matches
   * user choice, call the appropriate math method from the ComplexNumber
   * Object. Receive ComplexNumber object with answer. print out the
   * ComplexNumber answer Enter Do loop Ask the user if they would like to enter
   * a new set of numbers Receive user response If proper response (yes or no)
   * exit Do loop If user responded yes then return to the top of the loop.
   * Else, Exit
   */
  private static Scanner keyboard = new Scanner(System.in);

  public static void main(String[] args)
  {

    Complex myFirstNumber = null;
    Complex mySecondNumber = null;
    Complex myAnswer = null;
    myFirstNumber = new Complex();
    mySecondNumber = new Complex();
    String yesNo = "yes";
    boolean areEqual = false;
    boolean ifMath = true;
    String userChoice = "";
    char userChar = '0';
    System.out.println("This program will perform basic math on Complex numbers");
    do
    {
      ifMath = true;
      System.out.println("Please input your first number.");
      myFirstNumber.read();
      System.out.println("Please input your second number.");
      mySecondNumber.read();
      System.out.println(
          "You input the following Complex numbers:\n" + myFirstNumber.toString() + "\n" + mySecondNumber.toString());
      System.out.println("You may perform one of the following operations:");
      System.out.println("1. Add");
      System.out.println("2. Subtract the first number from the second number");
      System.out.println("3. Subtract the second number from the first number");
      System.out.println("4. Multiplication");
      System.out.println("5. Divide the first number by the second number");
      System.out.println("6. Divide the second number by the first number");
      System.out.println("7. Check for Equality");
      do
      {
        try
        {
          System.out.println("Please select your choice from 1 to 7");
          userChoice = keyboard.nextLine().trim().substring(0, 1);
          userChar = userChoice.charAt(0);
        }
        catch (StringIndexOutOfBoundsException e)
        {
          System.out.println("Incorrect entry");
        }
        // keyboard.nextLine();
      } while (userChoice.equals("") || (userChar <= 0 && userChar >= 8));
      switch (userChoice)
      {
        case "1":
          System.out.println("Adding " + myFirstNumber.toString() + " to " + mySecondNumber.toString());
          myAnswer = myFirstNumber.add(mySecondNumber);
          break;
        case "2":
          System.out.println("Subtracting " + myFirstNumber.toString() + " from " + mySecondNumber.toString());
          myAnswer = mySecondNumber.subtract(myFirstNumber);
          break;
        case "3":
          System.out.println("Subtracting " + mySecondNumber.toString() + " from " + myFirstNumber.toString());
          myAnswer = myFirstNumber.subtract(mySecondNumber);
          break;
        case "4":
          System.out.println("Multiplying " + myFirstNumber.toString() + " by " + mySecondNumber.toString());
          myAnswer = mySecondNumber.multiply(myFirstNumber);
          break;
        case "5":
          System.out.println("Dividing " + myFirstNumber.toString() + " by " + mySecondNumber.toString());
          myAnswer = myFirstNumber.divide(mySecondNumber);
          break;
        case "6":
          System.out.println("Dividing " + mySecondNumber.toString() + " by " + myFirstNumber.toString());
          myAnswer = mySecondNumber.divide(myFirstNumber);
          break;
        case "7":
          System.out.println("Checking if " + mySecondNumber.toString() + " is equal to " + myFirstNumber.toString());
          areEqual = mySecondNumber.equals(myFirstNumber);
          ifMath = false;
          if (areEqual)
            System.out.println(mySecondNumber.toString() + " is equal to " + myFirstNumber.toString());
          else
            System.out.println(mySecondNumber.toString() + " is not equal to " + myFirstNumber.toString());
          break;
        default:
          break;
      }
      if (ifMath)
      {
        System.out.println("Produces: " + myAnswer.toString());
      }
      System.out.println("Would you like to enter new numbers?");
      do
      {
        System.out.println("Please enter yes or no");
        yesNo = keyboard.nextLine();

      } while (!yesNo.equalsIgnoreCase("yes") && !yesNo.equalsIgnoreCase("no"));
    } while (yesNo.equalsIgnoreCase("yes"));

    System.out.println("Goodbye!!");
  }




}
