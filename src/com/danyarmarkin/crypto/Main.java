package com.danyarmarkin.crypto;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<User> users;
    private static Chain chain;

    public static void main(String[] args) {
        users = new ArrayList<>();
        chain = new Chain();

        users.add(new User(0));

        Mine mine = new Mine(findUserById(0), chain);

        while (true) {
            Scanner scanner = new Scanner(System.in);
            String command  = scanner.next();
            long id;
            switch (command){
                case "reg":
                    id = users.get(users.size() - 1).getId() + 1;
                    users.add(new User(id));
                    System.out.println("new user with id " + id);
                    break;
                case "transfer":
                    System.out.println("от кого перевести");
                    long id1 = scanner.nextLong();
                    System.out.println("кому перевести?");
                    id = scanner.nextLong();
                    System.out.println("how much?");
                    int c = scanner.nextInt();
                    TransferNote transferNote = new TransferNote(c, id1, id);
                    chain.getCurrentBlock().add(transferNote);
                    findUserById(id1).addCoins(-c);
                    findUserById(id).addCoins(c);
                    break;
                case "users":
                    for (int i = 0; i < users.size(); i++) {
                        System.out.println("(" + users.get(i).getId() + "): " + users.get(i).getCoins() + " coins");
                    }
                    break;
                case "mine":
                    if (mine.isStarted()) {
                        mine.stopThread();
                        break;
                    }
                    System.out.println("write id");
                    id = scanner.nextLong();
                    mine = new Mine(findUserById(id), chain);
                    mine.start();
                    break;
                case "b":
                    System.out.println(chain.getBlocks().size());
                    break;
            }
        }


//        TransferNote transferNote = new TransferNote(13, 4335358, 354646);
//        System.out.println(transferNote);
    }

    public static User findUserById(long id) {
        for(User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        User u = new User(id);
        users.add(u);
        return u;
    }
}
