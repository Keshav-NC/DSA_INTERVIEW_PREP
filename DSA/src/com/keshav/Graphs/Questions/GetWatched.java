package com.keshav.Graphs.Questions;

import java.util.*;

public class GetWatched {
    static class Pair implements Comparable<Pair> {
        String video;
        int freq;

        public Pair(String video, int freq) {
            this.video = video;
            this.freq = freq;
        }

        @Override
        public int compareTo(Pair that) {
            if (this.freq == that.freq) {
                return this.video.compareTo(that.video);
            }
            return this.freq - that.freq;
        }
    }
    public static void main(String[] args) {
        String[][] watchedVideos = {{"A","B"},{"C"},{"B","C"},{"D","B","A"}, {"B"}};
        int[][] friends = {{1,2},{0, 4, 3},{0,3},{1,2}, {1}};
        int id = 0, level = 2;
        System.out.println(watchedVideosByFriends(watchedVideos, friends, id, level));
    }

    private static List<String> watchedVideosByFriends(String[][] watchedVideos, int[][] friends, int id, int level) {
        int n = friends.length;
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        queue.offer(id);
        visited[id] = true;
        int curLevel = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int node = queue.poll();
                for (int friend : friends[node]) {
                    if (!visited[friend]) {
                        visited[friend] = true;
                        queue.offer(friend);
                    }
                }
            }
            ++curLevel;
            if (curLevel == level) {
                break;
            }
        }
        List<String> res = new ArrayList<>();
        List<Pair> levelVideos = new ArrayList<>();
        HashMap<String, Integer> freq = new HashMap<>();
        while (!queue.isEmpty()) {
            int curId = queue.poll();
            for (String video : watchedVideos[curId]) {
                freq.put(video, freq.getOrDefault(video, 0) + 1);
            }
        }

        for (Map.Entry<String, Integer> entry : freq.entrySet()) {
            levelVideos.add(new Pair(entry.getKey(), entry.getValue()));
        }
        Collections.sort(levelVideos);
        for (Pair pair : levelVideos) {
            res.add(pair.video);
        }
        return res;
    }
}
