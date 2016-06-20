import java.util.Scanner; 

public class InvoiceClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Creates Scanner Object and variables
				Scanner keyboard = new Scanner(System.in);
				PricesDb product = new PricesDb();
				//InvoiceCalc invoice = new InvoiceCalc();
				
				String choice="go";
				String choice2=" ";
				double exit;
				double tax;
				double subtotal=0;
				
				//declare the array of a set size
				double myPrices[] = new double[100];
				//Use a counter to keep track of how many items are in your array.
				int counter = 0;
				
				//Gets and sets tax
				System.out.println("Enter tax as decimal");
				tax= keyboard.nextDouble();
				System.out.println("Current product ids are:"
						+ "\nJava1001"
						+ "\nJava1002"
						+ "\nOrcl1003"
						+ "\nPython1004"
						+ "\nZombie1005"
						+ "\nRasp1006");
				
			try{	//enters values into array
				while(choice.equals("go")||choice.equals("Yes")){
					System.out.println("Enter next product");
					choice2=keyboard.next();
					
					myPrices[counter]= PricesDb.getProduct(choice2).getPrice();
					counter+=1;
					
					System.out.println("Would you like to enter more prices? Yes or No");
					choice=keyboard.next();
				}
				//Prints the reciept
				System.out.println("Enter 0.0 to print receipt");
				exit= keyboard.nextDouble();
				if(exit==0.0){
							 for (int i=0;i <=counter; i++){
								subtotal+=myPrices[i]; 
								 System.out.printf("The price is %.02f\n",myPrices[i]);
							 }
					System.out.println("Subtotal: "+ subtotal);
					System.out.println( "tax "+tax);
					
					double grandtotal = (subtotal*tax)+ subtotal;
					System.out.print("Grand Total: " + grandtotal);
					keyboard.close();
				}
			}
			catch(ArrayIndexOutOfBoundsException e){
					System.out.println("You can no longer input prices");
		  }
			catch(Exception e){
				System.out.println("Sorry. and error has ocured that we cant fix");
				
			}
			finally{
				System.out.println("\nThanks for using our application");
			}
	}

}
