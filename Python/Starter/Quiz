questions = ("Hottest planet in our solar system?", 
             "'88' refers to which global leader?",
             "Which of the following is not a property of obsidian:",
             "Which of the following is the most bright star in the Milky Way?")

options = (("A. Sun ", "B. Jupiter ", "C. Venus ", "D. Uranus"),
          ("A. Putin", "B. Stalin ", "C. Hitler ", "D. Ataturk"),
          ("A. Crystal", "B. Radiation absorber ", "C. Reflective glass", "D. Mostly silica"),
          ("A. Spica", "B. Sun ", "C. Sirius ", "D. You"))

answers = ("C", "C", "A", "C")
qnum = 0
guesses = []
score = 0

for question in questions:
    print("-------------------------------------------------")
    print(question)
    for option in options[qnum]:
        print(option)
    guess = input("Enter A, B, C or D: ").upper()
    guesses.append(guess)
    print()
    if guess == answers[qnum]:
        score += 1
        print("Correct!")
    else:
        print("Incorrect.")
        print(f"The right answer was {answers[qnum]}")
    qnum += 1
print()
print(f"Your score is {score}/4")
