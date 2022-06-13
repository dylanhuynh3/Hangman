
  import java.util.ArrayList;

public class Round {
  private int rightGuesses;
  private int wrongGuesses;
  private String word;
  private String[] words = {"sock","heat","brown"};
  private String showWord; 
  private String guess;
  private ArrayList <String> wrongLetters = new ArrayList<String>();
  private ArrayList <String> rightLetters = new ArrayList<String>();
  

  public Round(){
    word = Utils.randChoice(words);
    showWord = "";
    for (int i = 0; i < word.length(); i++){
      showWord += "#";
    }
  }

  public void currentGuess(){
    
    ArrayList<Integer> index = new ArrayList<Integer>();
    if(showWord.indexOf(guess) == -1){
        index.clear();
        for(int i = 0; i < word.length();i++ ){
          if (word.substring(i,i+1).equals(guess)) {
            index.add(i);
            rightLetters.add(guess);
            rightGuesses++;
          }
        }
      }

      if (index.size() != 0){
        for (int j = 0; j< index.size(); j++){
          showWord = showWord.substring(0, index.get(j)) + word.substring(index.get(j), index.get(j)+1) + showWord.substring(index.get(j)+1);
        }
        
      }
      else{
        wrongGuesses++;
        wrongLetters.add(guess);
      }
    
  }
  //arraylist . contains
  public boolean sameLetter(){
    if(wrongLetters.contains(guess) || rightLetters.contains(guess))
      return true;
    return false;
  }
    
    
  

  

  public int run(){
    System.out.println("Welcome to the Hangman Game! \nIn this game you must guess one letter at a time in order to reveal the whole word. ");
    int go = 0;
    
    guess = Utils.inputStr("\nEnter your guess:");
    while (go == 0){
      System.out.println("Start");
      while(guess.length() > 1 || this.sameLetter()){
        if(guess.length() > 1)
          guess = Utils.inputStr("Please enter only 1 letter: ");
        else if(this.sameLetter())
          guess = Utils.inputStr("You've already used this letter. Please use a different letter: ");
                    
      }
      
      this.currentGuess();
      

      switch(wrongGuesses){
      case 1:
        System.out.println("\n 6 guesses left.\nWrong Guesses: " + wrongLetters + "\nCurrent guess: " + showWord+ "\n");
        break;
      case 2:
        System.out.println("\n 5 guesses left.\nWrong Guesses: " + wrongLetters + "\nCurrent guess: " + showWord+ "\n");
        break;
      case 3:
        System.out.println("\n 4 guesses left.\nWrong Guesses: " + wrongLetters + "\nCurrent guess: " + showWord+ "\n");
        break;
      case 4:
        System.out.println("\n 3 guesses left.\nWrong Guesses: " + wrongLetters + "\nCurrent guess: " + showWord+ "\n");
        break;
      case 5:
        System.out.println("\n 2 guesses left.\nWrong Guesses: " + wrongLetters + "\nCurrent guess: " + showWord+ "\n");
        break;
      case 6:
        System.out.println("\n 1 guess left.\nWrong Guesses: " + wrongLetters + "\nCurrent guess: " + showWord+ "\n");
        break;
      case 7:
        System.out.println("\nHe is dead.\nWrong Guesses " + wrongLetters + "\nYou killed the man! The word was: " + word);
        go = 1;
        break;
      default:
        System.out.println("\nYou dodged a bullet.\nCurrent guess: " + showWord+ "\n");
     }
      if(showWord.equals(word)){
        go = 1;
        System.out.println("\nYay!! The word was "+ word+ ". You saved the Man!");
        break;
       }
     else if(wrongGuesses == 7){
       break;
     }
     guess = Utils.inputStr ("Enter your next guess: ");

    
    
    
  }
  return wrongGuesses - rightGuesses;
}
}
