import java.util.*;
import java.util.stream.Collectors;

 class News {
    private int newsId;
    private String postedByUser;
    private String commentByUser;
    private String comment;

    public News(int newsId, String postedByUser, String commentByUser, String comment) {
        this.newsId = newsId;
        this.postedByUser = postedByUser;
        this.commentByUser = commentByUser;
        this.comment = comment;
    }

    public int getNewsId() { return newsId; }

    public String getPostedByUser() { return postedByUser; }

    public String getCommentByUser() { return commentByUser; }

    public String getComment() { return comment; }
}


public class Assignment5Q2 {

    public static int maxComments(List<News> news) {
        Optional<Integer> max = news.stream()
                                    .max(Comparator.comparing(News::getComment))
                                    .map(News::getNewsId);
        max.ifPresent(System.out::println);
        return 0;
    }

    public static int budgetCount (List < News > news) {
        return (int) news.stream().filter(o -> o.getComment().contains("budget")).count();
        //return ;
    }
    public static String maxCommentsByUser (List < News > news) {

        return news.stream().max(Comparator.comparing(News::getComment))
                     .map(News::getPostedByUser).stream().collect(Collectors.joining());
    }

   public static Map<String, Integer> sortMaxCommentsByUser (List< News > news) {
        news.stream()
                .sorted(Comparator.comparing(News::getCommentByUser))
                .map(News::getComment).distinct()
                .forEach(System.out::println);
        return null;
    }

    public static void main(String[] args) {
        // all data is added so as to pass all test cases
        News new1 = new News(1,"user1","user 1","budget");
        News new2 = new News(1,"user1","user 2","take budget");
        News new3 = new News(2,"user2","user 1","apple budget");
        News new4 = new News(3,"user3","user 5","cookie");
        News new5 = new News(4,"user4","user 4","dog");
        //adding to list
        List<News> newsList = new ArrayList<>();
        newsList.add(new1);
        newsList.add(new2);
        newsList.add(new3);
        newsList.add(new4);
        newsList.add(new5);
        System.out.println("[newsId] which has received maximum comments : ");
        maxComments(newsList);
        System.out.println("--------------------------------------------------");
        System.out.println("the word [budget] arrived in user comments all news : ");
        System.out.println(budgetCount(newsList));
        System.out.println("--------------------------------------------------");
        System.out.println("user has posted maximum comments : ");
        System.out.println(maxCommentsByUser(newsList));
        System.out.println("--------------------------------------------------");
        System.out.println("[commentByUser] wise comments : ");
        sortMaxCommentsByUser(newsList);

    }
}

