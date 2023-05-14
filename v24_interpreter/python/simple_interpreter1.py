def main():
    command = "REPEAT 3 TIMES: PRINT Hello"

    # Split the command into words based on whitespace
    words = command.split(" ")

    # Handle the command
    if words[0].upper() == "REPEAT":
        repeat_count = int(words[1])
        for i in range(repeat_count):
            if words[3].upper() == "PRINT":
                print(words[4])

if __name__ == "__main__":
    main()

