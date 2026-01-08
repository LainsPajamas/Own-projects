import time

ttime = int(input("The time in seconds you would like to count down from:  "))

for x in reversed(range(0, ttime)):
    second = int(x % 60)
    minute = int(x / 60) % 60
    hour =  int(x / 3600) % 60
    print(f"{hour:02}:{minute:02}:{second:02}")
    time.sleep(1)

print("time's up")
