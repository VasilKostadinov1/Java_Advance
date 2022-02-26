package EXAMs;

import java.util.*;
import java.util.stream.Collectors;

public class Vloggers {

    private static class Vlogger {
        private String name;
        private Set<Vlogger> followers;
        private Set<Vlogger> following;

        public Vlogger(String name) {
            this.name = name;
            this.followers = new HashSet<>();
            this.following = new HashSet<>();
        }

        public String getName() {
            return this.name;
        }

        public void follow(Vlogger v) {
            if (v == this) {    // can't follow yourself
                return;
            }
            this.followers.add(v);
        }

        public void addFollowing(Vlogger v) {
            if (v == this) {
                return;
            }
            this.following.add(v);
        }

        public int getFollowerCount() {
            return this.followers.size();
        }

        public int getFollowingCount() {
            return this.following.size();
        }


        public String toFullString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.toBasicString()).append("\n");

            List<Vlogger> sortedFollowers = this.followers.stream()
                    .sorted((f,s)->f.getName().compareTo(s.getName())).collect(Collectors.toList());
            for (Vlogger follower : sortedFollowers) {
                sb.append("*  ").append(follower.getName()).append("\n");
            }

            return sb.toString();
        }

        public String toBasicString() {
            return String.format("%s : %d followers, %d following",
                    this.name, this.getFollowerCount(), this.getFollowingCount());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();

        Map<String, Vlogger> vloggers = new HashMap<>();
        while (!line.equals("Statistics")) {
            String[] lineParts = line.split(" ");

            if (lineParts[1].equals("joined")) {
                if (vloggers.containsKey(lineParts[0])) {
                    line = scanner.nextLine();
                    continue;
                }
                String nameV = lineParts[0];
                Vlogger vlogger = new Vlogger(nameV);
                vloggers.put(nameV, vlogger);
            } else if (lineParts[1].equals("followed")) {
                Vlogger follower = vloggers.get(lineParts[0]);
                Vlogger followed = vloggers.get(lineParts[2]);

                if (follower == null || followed == null) {
                    line = scanner.nextLine();
                    continue;
                }
                followed.follow(follower);
                follower.addFollowing(followed);

                vloggers.put(followed.getName(), followed);
                vloggers.put(follower.getName(), follower);
            }
            line = scanner.nextLine();
        }
        List<Vlogger> sortedVloggers = vloggers.values().stream().sorted((f, s) -> {
                    int diff = s.getFollowerCount() - f.getFollowerCount();
                    if (diff == 0) {
                        diff = f.getFollowingCount() - s.getFollowingCount();
                    }
                    return diff;

                })
                .collect(Collectors.toList());

        System.out.printf("The V-Logger has a total %d in the logs%n", sortedVloggers.size());
        System.out.print("1. " + sortedVloggers.get(0).toFullString());

        for (int i = 1; i < sortedVloggers.size(); i++) {
            System.out.println((i + 1) + ". " + sortedVloggers.get(1).toBasicString());
        }


    }
}
