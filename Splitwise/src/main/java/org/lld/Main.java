package org.lld;

import org.lld.enums.SplitType;
import org.lld.models.Balance;
import org.lld.models.User;
import org.lld.service.IBalanceService;
import org.lld.service.IExpenseService;
import org.lld.service.impl.BalanceService;
import org.lld.service.impl.ExpenseService;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        User user1 = new User(1, "Vishal", "vishal.kumar@sharechat.co", "imag123");
        User user2 = new User(2, "Swapnil", "swap.kumar@phonepe.co", "imag223");
        User user3 = new User(3, "Tanuj", "tanuj.kumar@halodoc.co", "imag323");
        User user4 = new User(4, "Ankit", "ankit.kumar@razorpay.co", "imag423");
        Map<Integer, User> userMap = new HashMap<>();
        userMap.put(1, user1);
        userMap.put(2, user2);
        userMap.put(3, user3);
        userMap.put(4, user4);

        IExpenseService expenseService = new ExpenseService();
        IBalanceService balanceService = new BalanceService();


        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] tokens = line.split(" ");
            String command = tokens[0];
            switch (command) {
                case "SHOW":
                        if (tokens.length == 1) {
                            balanceService.showBalances();
                        } else {
                            balanceService.showBalance(userMap.get(tokens[1]));
                        }
                    break;
                case "EXPENSE":
                        int paidBy = Integer.parseInt(tokens[1]);
                        User paidByUser = userMap.get(paidBy);
                        Double amount = Double.parseDouble(tokens[2]);
                        int noOfUsers = Integer.parseInt(tokens[3]);
                        List<User> participants = new ArrayList<>();
                        for (int i=0;i<noOfUsers;i++){
                            int userId = Integer.parseInt(tokens[4 + i]);
                            User user = userMap.get(userId);
                            if (user == null) {
                                throw new IllegalArgumentException("user does not exist");
                            }
                            participants.add(user);
                        }
                        String splitType = tokens[4+noOfUsers];
                        Map<User, Double> shares = new HashMap<>();
                        if (!splitType.equals("EQUAL")) {
                            for (int i=0;i<noOfUsers;i++){
                                Double share = Double.parseDouble(tokens[5 + noOfUsers + i]);
                                User user = participants.get(0);
                                shares.put(user, share);
                            }
                        }
                    expenseService.addExpense(paidByUser, amount,  participants, shares,splitType);
                    break;
                default: System.out.println("unknown command");
                        break;
            }
        }
    }
}