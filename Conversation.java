import java.util.Random;
import java.util.Scanner;
class Conversation implements ConversationRequirements {

  // Attributes 
  

  /**
   * Constructor 
   */
  Conversation() {

  }

  /**
   * Starts and runs the conversation with the user
   */
  public void chat() {
    String[] prewrittenResponses = {"That sounds interesting.", "Tell me more.", "Mhmm.", "Great weather we're having!", "Indeed.", "Hmmm."};
    int responseNumber = prewrittenResponses.length;

    int rounds = 0;
    Random rand = new Random(); //Creates new Random object that we can use to choose random elements

    Scanner input = new Scanner(System.in);   //Creates new Scanner object for the user to choose the number of rpunds

    System.out.println("How many rounds?");   //Asks the user how many rounds the program will run
    rounds = input.nextInt();

    
    System.out.println("Hi there! What's on your mind?");    //Begins the conversation with the user

    Scanner dialogue = new Scanner(System.in);    //Creates new scanner object for conversational input    

    for (int i = 0; i < rounds; i++) {
        String userResponse = dialogue.nextLine();
        String l = prewrittenResponses[rand.nextInt(responseNumber)];
          System.out.println(l);
    }

    System.out.println("See ya!");
    
  }

  /**
   * Prints transcript of conversation
   */
  public void printTranscript() {

  }

  /**
   * Gives appropriate response (mirrored or canned) to user input
   * @param inputString the users last line of input
   * @return mirrored or canned response to user input  
   */
  public String respond(String inputString) {     //I don't understand how this is different form the chat method and if it is how we incorporate the two
    String returnString = "";     
    return returnString; 
  }

  public static void main(String[] arguments) {

    Conversation myConversation = new Conversation();
    myConversation.chat();
    myConversation.printTranscript();

  }
}
