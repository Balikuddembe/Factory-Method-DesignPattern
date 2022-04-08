package com.factorymethod;

interface MyWrapper{
	void printType();
}
class MyInteger implements MyWrapper{
	@Override
	public void printType() {
		System.out.println("The value is of type: MyInteger");
	}
}
class MyDouble implements MyWrapper{
	@Override
	public void printType() {
		System.out.println("The value is of type: MyDouble");
	}
}
class MyBoolean implements MyWrapper{
	@Override
	public void printType() {
		System.out.println("The value is of type: MyBoolean");
	}
}
class MyCharacter implements MyWrapper{
	@Override
	public void printType() {
		System.out.println("The value is of type: MyCharacter");
	}
}
class MyWrapperFactory{  //factory class
	public MyWrapper getMyWrapperInstance(String value) {//factory method
		if(value==null || value.isEmpty()) {
			return  null;
		}else if(value.equalsIgnoreCase("true")||value.equalsIgnoreCase("false")){
			return new MyBoolean();
			
		}else if(onlyDigits(value)) {
			return new MyInteger();
		}
		else if(value.length()==1 && Character.isLetter(value.charAt(0))){
			return new MyCharacter();
			
		}
		else if(Character.isDigit(value.charAt(0))&&Character.isDigit(value.charAt(value.length()-1))&&checkDouble(value))
	        return new MyDouble();
		else
		    throw new IllegalArgumentException("Unknown data type: " +value);
	 }
		// digits, without any other types of characters
	 public boolean onlyDigits(String value){
	        //checking for all digits
	        for(int i=0;i<value.length();i++)
	          if(!Character.isDigit(value.charAt(i)))
	          return false;

	          return true;
	    }
	 //check for double
		public boolean checkDouble(String value){        
	        for(int i=0;i<value.length();i++)
	          if(!(Character.isDigit(value.charAt(i))||value.charAt(i)=='.'))
	          return false;
	          
	          return true;
	    }
	
}
public class FactoryMethodDesignPattern {

	public static void main(String[] args) {
		MyWrapperFactory factory = new MyWrapperFactory();//loose coupling
		MyWrapper myWrapperObj = factory.getMyWrapperInstance("3.14");
		myWrapperObj.printType();
	}

}
/*
 Declare an interface names MyWrapper as follows:

interface MyWrapper {
    void printType();
}

Implement the interface in the following concrete classes:

    MyInteger
    MyDouble
    MyBoolean
    MyCharacter

The concrete methods in these classes just print the name of the class with a message, e.g., "The value is of type: MyInteger".

Create a factory class called MyWrapperFactory with the method:

class MyWrapperFactory{
    public MyWrapper getMyWrapperInstance(String value) {
        // return the wrapper instance corresponding to the type of value
    }
}

The getMyWrapperInstance method returns an instance of one of the four concrete classes or null, depending on the type of the parameter value. Write custom logic and process the string to find out the type of value. If the value is of undefined/unknown type, throw IllegalArgumentException.

String processing logic to Implement in the factory method:

    If the value string contains only digits, without any other types of characters, return an instance of "MyInteger".
    If the value string contains either true or false in all lowercase, return an instance of MyBoolean.
    If the value string contains only digits, and a dot(.) in any position other than at first or last, then return an instance of MyDouble.
    If the value string contains only a single alphabet, then return an instance of MyCharacter.

Demonstrate the working in the driver class named CustomeWrapperDriver.
Sample Inputs

value = "50"
value = "false"
value = "3.142"
value = "a"

Sample Outputs

The value is of type: MyInteger
The value is of type: MyBoolean
The value is of type: MyDouble
The value is of type: MyCharacter
*/
