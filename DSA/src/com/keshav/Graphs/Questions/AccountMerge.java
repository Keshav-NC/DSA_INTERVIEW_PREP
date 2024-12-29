package com.keshav.Graphs.Questions;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class AccountMerge {
    public static void main(String[] args) {
        String[][] accounts = {{"John","johnsmith@mail.com","john_newyork@mail.com"},{"John","johnsmith@mail.com","john00@mail.com"},{"Mary","mary@mail.com"},{"John","johnnybravo@mail.com"}};
        System.out.println(accountsMerge(accounts));
    }

    private static List<List<String>> accountsMerge(String[][] accounts) {
        HashMap<String, List<String>> adj = new HashMap<>();
        // create adj
        for (String[] account : accounts) {
            // account[0] == name
            String firstEmail = account[1];
            for (int i = 2; i < account.length; ++i) {
                String email = account[i];
                adj.putIfAbsent(firstEmail, new ArrayList<>());
                adj.get(firstEmail).add(email);
                adj.putIfAbsent(email, new ArrayList<>());
                adj.get(email).add(firstEmail);
            }
        }
        List<List<String>> res = new ArrayList<>();
        HashSet<String> visited = new HashSet<>();
        for (String[] account : accounts) {
            String firstEmail = account[1];
            if (!visited.contains(firstEmail)) {
                List<String> sub = new ArrayList<>();
                dfs(firstEmail, visited, adj, sub);
                Collections.sort(sub);
                sub.add(0, account[0]);
                res.add(sub);
            }
        }
        return res;
    }
    private static void dfs(String src, HashSet<String> visited, HashMap<String, List<String>> adj, List<String> sub) {
        sub.add(src);
        visited.add(src);
        if (!adj.containsKey(src)) {
            return;
        }
        for (String neighbour : adj.get(src)) {
            if (!visited.contains(neighbour)) {
                dfs(neighbour, visited, adj, sub);
            }
        }
    }
}
