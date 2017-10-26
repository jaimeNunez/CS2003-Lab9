package pancake;
import java.util.Scanner;
import java.util.Stack;

public class DelimiterChecker {

	StackX theStack;
	int stackLength; 
	public boolean check(String testCase) {
		Scanner scan = new Scanner(testCase).useDelimiter("");
		stackLength = testCase.length();
		theStack = new StackX(stackLength);
		//input string still needs to be processed 
		while(scan.hasNext()) {
			//push if it has left delimiter
			String temp = scan.next();
			char a = temp.charAt(0);
			if(a == '{' | a == '[' | a == '(' ) {
				//char currChar = (char)nextChar;
				theStack.push(a);
			}
			if(a == '}' | a == ']' | a == ')') {
				//if stack is not empty, pop of right delimiter
				if(!theStack.isEmpty()) {
					char checkCharacter = theStack.pop();
					//if the delimiters dont match
					if(a != checkCharacter) {
						System.out.println("Error. This is a matching error");
						return false;
					}
				}else {
					System.out.println("Error. The stack is empty. Can't pop off the stack. Missing left delimiter");
					return false;
				}

			}

		}
		scan.close();
		if(!theStack.isEmpty()) {
			System.out.println("Error. The stack is non-empty. Missing right delimiter error.");
			return false;
		}else {
			System.out.println("Each delimiter is matched");
			return true;
		}

	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DelimiterChecker theChecker = new DelimiterChecker();
//		/**
//		 * @test
//		 */
//		boolean test1 = theChecker.check("{Hi said the kid (the kid was 8)}");
//		assertEquals(test1, true);
//		boolean test2 = theChecker.check("Hi said the kid (the kid was 8)}");
//		assertEquals(test2, false);
//		boolean test3 = theChecker.check("{Hi said the kid (the kid was 8)})");
//		assertEquals(test3, false);

	}

}
