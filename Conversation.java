import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

class Conversation implements ConversationRequirements {

  // Attributes 
  ArrayList<String> transcript;

  /**
   * Constructor 
   */
  Conversation() {
    transcript = new ArrayList<>();
  }

  /**
   * Starts and runs the conversation with the user
   */
  public void chat() {

    int rounds = 0;
    System.out.println("How many rounds?");   //Asks the user how many rounds the program will run


    Scanner input = new Scanner(System.in);   //Creates new Scanner object for the user to choose the number of rounds
    rounds = input.nextInt();

    System.out.println("Hi there! What's on your mind?");    //Begins the conversation with the user
    this.transcript.add("Hi there! What's on your mind?");
    
    input.nextLine();


    for (int i = 0; i < rounds; i++) {
      String userResponse = input.nextLine();
        this.transcript.add(userResponse);
      String newUserResponse = respond(userResponse);
        this.transcript.add(respond(newUserResponse));
      System.out.println(newUserResponse);
        this.transcript.add(newUserResponse);
    }

    System.out.println("See ya!"); //Gives a farewell to the user
    this.transcript.add("See ya!");
  }

  /**
   * Prints transcript of conversation
   */
  public void printTranscript() {
    System.out.println();
    System.out.println("TRANSCRIPT:");
    for (int i = 0; i < this.transcript.size(); i++) {
        System.out.println(this.transcript.get(i));
    }
    System.out.print("```");
  }

  /**
   * Gives appropriate response (mirrored or canned) to user input
   * @param inputString the users last line of input
   * @return mirrored or canned response to user input  
   */
  public String respond(String inputString) {     
    String returnString = "";     

    String[] prewrittenResponses = {"That sounds interesting.", "Tell me more.", "Mhmm.", "Great weather we're having!", "Indeed.", "Hmmm."}; //Defines a list of prewritten responses.
    int responseNumber = prewrittenResponses.length; //Gives the length (a range of indexes) so that we can choose a random index later

    String[] words = inputString.split(" "); //Splits the response into individual words to taht we can iterate over each word
    Random rand = new Random(); //Creates new Random object that we can use to choose random elements

    if (inputString.contains("I" ) || inputString.contains("you" )|| inputString.contains("me" ) || inputString.contains("am" ) || inputString.contains("my" ) || inputString.contains("your" )){
      for (int i = 0; i < words.length; i++){
        if (words[i].equals("I")){
          words[i] = "you";
        }
        else if (words[i].equals("you")){
          words[i] = "I";
        }
        else if (words[i].equals("me")){
          words[i] = "you";
        }
        else if (words[i].equals("am")){
          words[i] = "are";
        }
        else if (words[i].equals("are")){
          words[i] = "am";
        }
        else if (words[i].equals("my")){
          words[i] = "your";
        }
        else if (words[i].equals("your")){
          words[i] = "my";
        }
      }
      String sew = " ";
      returnString = String.join(sew, words) + "?"; //"sews" the string back together
      
    }
    else{
      String l = prewrittenResponses[rand.nextInt(responseNumber)];
         System.out.print(l);
    }
    return returnString;

  }

  
  
  public static void main(String[] arguments) {

    Conversation myConversation = new Conversation();
    myConversation.chat();
    myConversation.printTranscript();

  }
}
