package atmINTERFACE;

import java.util.ArrayList;
import java.util.List;

public class TransactionHistory {
    private List<String> history;

    public TransactionHistory() {
        history = new ArrayList<>();
    }

    public void addTransaction(String transaction) {
        history.add(transaction);
    }

    public void displayHistory() {
        for (String transaction : history) {
            System.out.println(transaction);
        }
    }
}
