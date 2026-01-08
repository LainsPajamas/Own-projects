import random

guesses = 0
low_n = 1
high_n = 100

while True:
    number =    random.randint(low_n, high_n)
    print(f"Guess the number {low_n}-{high_n}")
    while True:
        guess = int(input("What's your guess?  "))
        print()
        if guess < low_n:
            print(f"Invalid guess, the number is between {low_n}-{high_n}")
        elif guess > high_n:
            print(f"Invalid guess, the number is between {low_n}-{high_n}")
        elif guess == number:
            print("You got it!")
            break
        elif guess < number:
            print("Try higher")
            guesses += 1
        elif guess > number:
            print("Try lower")
            guesses += 1

    print(f"You found it in {guesses} guesses")
    print()
    round = input("Would you like to play around round? Y/N  ").upper()
    if round == "Y":
        print()
        continue
    else:
        break
