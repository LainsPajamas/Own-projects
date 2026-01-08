import random

options = ("Rock", "Paper", "Scissors")

print("A round of Rock, Paper, Scissors?")

while True:
    player = None
    comp = random.choice(options)
    while player not in options:
        player = input("What's your move?  ").capitalize()
    print()
    print(f"Your move: {player}")
    print(f"Computer's move: {comp}")
    if player == comp:
        print("Tie!")
    elif player == "Rock" and comp == "Scissors":
        print("You won!")
    elif player == "Paper" and comp == "Rock":
        print("You won!")
    elif player == "Scissors" and comp == "Paper":
        print("You won!")
    else:
        print("You lost")
    print()
    round = input("Would you like to play around round? Y/N  ").capitalize()
    if round == "Y":
        continue
    else:
        break



        
