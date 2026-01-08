import math
menu = {"Pizza": 5, "Popcorn": 3.59, "Chips": 2.99, "Coke": 1.99}
cart = []
total = 0

print("------------- Menu -------------")
for key, value in menu.items():
    print(f"{key:7}: ${value:.2f}")

while True:
    order = input("What would you like to buy? Q (to quit)  ").capitalize()
    if order == "Q":
        break
    elif menu.get(order):
        cart.append(order)
for order in cart:
    total += menu.get(order)
    print(order, end= " ")
print()
print(f"${total}")
