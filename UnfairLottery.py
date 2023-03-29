def reverse(arr):
    i, j = 0, len(arr) - 1
    while i < j:
        arr[i], arr[j] = arr[j], arr[i]
        i += 1
        j -= 1


def get_winner_with_lowest_prize(prize_map):
    winner = None
    lowest_total = float('inf')
    for key in prize_map.keys():
        prizes = prize_map[key]
        total = sum(prizes)
        if total < lowest_total:
            winner = key
            lowest_total = total
    return winner


def main():
    values_str = input("Enter the values of this week's prizes (comma-separated): ")
    values = [int(x) for x in values_str.split(",")]
    winners = input("Enter the names of this week's winners (comma-separated): ").split(",")

    # Sort values in descending order
    values.sort(reverse=True)

    # Create dictionary to store each winner's prizes
    prize_map = {winner: [] for winner in winners}

    # Distribute prizes
    for value in values:
        winner = get_winner_with_lowest_prize(prize_map)
        prize_map[winner].append(value)

    # Print results
    for winner in prize_map:
        prizes = prize_map[winner]
        print(f"{winner}: {','.join(map(str, prizes))}")


if __name__ == '__main__':
    main()
