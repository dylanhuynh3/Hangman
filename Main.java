
class Main {
  public static void main(String[] args) {
    Game g = new Game();
    g.leaderBoard();
  }
}

/*
Game.java - hangman game

class round (public)
- string user input (instance)
- boolean is correct (instance)
- string possible letters (instance)
- string possible answers (instance)

class Game (public)
- string name (instance)
- in amount of guesses (instance)



Play method (public) - allow the user to input one letter at a time and tells them whether the letter is in the word and take away one of the guesses


leaderboard method (public) - take user name and tracks the amount of guesses to form a leaderboard

Execption handling - letter or not
switch statement - get user to start game or quit or do other things
hash maps - tie name to score and have leaderboard

Authors - Ellie Soderquist and Ainsley Chisman and Dylan Huynh

*/

