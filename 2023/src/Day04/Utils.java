package Day04;

public interface Utils {
    static int getCount(String elem) {
        String[] temp = elem.split(" \\| ");
        String[] winnings = temp[0].trim().split("\\s+");
        String[] numbers = temp[1].trim().split("\\s+");

        int count = 0;
        for (String number : numbers) {
            int numberInt = Integer.parseInt(number);
            for (String winning : winnings) {
                int winningInt = Integer.parseInt(winning);
                if (numberInt == winningInt) {
                    count += 1;
                    break;
                }
            }
        }
        return count;
    }
}
