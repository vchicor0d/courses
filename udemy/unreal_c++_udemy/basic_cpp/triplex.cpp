#include <iostream>
#include <ctime>

bool playGameAtDifficulty(int Difficulty) {

  const int CodeA = 1 + rand() % (Difficulty + 2);
  const int CodeB = 1 + rand() % (Difficulty + 2);
  const int CodeC = 1 + rand() % (Difficulty + 2);

  const int CodeSum = CodeA + CodeB + CodeC;
  const int CodeProduct = CodeA * CodeB * CodeC;

  int MaxTries = 20 - Difficulty;

  bool bSolved = false;

  std::cout << std::endl << "+ There are 3 numbers in the code" << std::endl;
  std::cout << "+ The codes add up to: " << CodeSum << std::endl;
  std::cout << "+ The codes multiplies to: " << CodeProduct << std::endl;
  
  int GuessA, GuessB, GuessC;

  while(!bSolved && MaxTries>0) {
    std::cout << "Make your guess: " << std::endl;
					
    std::cin >> GuessA >> GuessB >> GuessC;

    int GuessSum = GuessA + GuessB + GuessC;
    int GuessProduct = GuessA * GuessB * GuessC;

    if (CodeSum == GuessSum && CodeProduct == GuessProduct) {
      std::cout << "Congratulations! You breaked the code!\nThe codes were: " << CodeA << CodeB << CodeC << "\n\n\n" << std::endl;
      bSolved = true;
    } else {
      std::cout << "Wrong guess, try again\n" << std::endl;
      --MaxTries;
      if (MaxTries == 0) {
	std::cout << "You get caught!" << std::endl;
      } else if (MaxTries <= 3) {
	std::cout << "WARNING! You have only" << MaxTries << "left!" << std::endl;
      }
    }
    std::cin.clear();
    std::cin.ignore();
  }
  return bSolved;
}

int main() {

  srand(time(NULL));
  
  int Difficulty = 1;
  int const MaxDifficulty = 10;
  bool bSolved = true;

  while (Difficulty <= MaxDifficulty && bSolved) {
    std::cout << "You're a secret agent breaking into a level " << Difficulty << " secure server room" << std::endl;
    std::cout << "You need to enter the correct codes to continue..." << std::endl;
    
    bSolved = playGameAtDifficulty(Difficulty);
    ++Difficulty;
  }

  if (bSolved) {
    std::cout << "You breaked the system, congratulations";
  } else {
    std::cout << "All of your base are belong to us" << std::endl;
  }
  return 0;
}
