import java.util.*;
class MovieDetails implements Comparable<MovieDetails>{
    private String movieName;
    private String actor;
    private String actress;
    private String genre;

    public MovieDetails(String movieName, String actor, String actress, String genre) {
        this.movieName = movieName;
        this.actor = actor;
        this.actress = actress;
        this.genre = genre;
    }

    public String getMovieName() { return movieName; }
    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getActor() { return actor; }
    public void setActor(String actor) {
        this.actor = actor;
    }

    public String getActress() { return actress; }
    public void setActress(String actress) {
        this.actress = actress;
    }

    public String getGenre() { return genre; }
    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "MovieDetails{" +
                "movieName='" + movieName + '\'' +
                ", actor='" + actor + '\'' +
                ", actress='" + actress + '\'' +
                ", genre='" + genre + '\'' +
                '}';
    }

    @Override
    public int compareTo(MovieDetails o) {
        return this.movieName.compareTo(o.movieName);
    }
}
public class Assignment3Q10 {
    public static void main(String[] args) {
        Assignment3Q10 control = new Assignment3Q10();
        MovieDetails movie1 = new MovieDetails("Troy","jack","medusa","action");
        MovieDetails movie2 = new MovieDetails("Avengers","rdj","natasha","adventure");
        MovieDetails movie3 = new MovieDetails("Pan","sagar","lina","fantasy");
        Scanner scanner = new Scanner(System.in);

        control.addMovie(movie1);
        control.addMovie(movie2);
        control.addMovie(movie3);
        System.out.println("-----------------------------------------");
        ArrayList<MovieDetails> newList = new ArrayList<>();
        newList.add(movie1);
        newList.add(movie2);
        newList.add(movie3);

        // sorting by Movie Name from MovieDetails class comparator
        System.out.println("Sorted by Movie name : ");
        sort(newList,MovieDetails::compareTo);
        printSortedMovieList(newList);
        System.out.println("----------------------------------------------");
        // searching by name and removing
        System.out.println("Enter movie name to remove : ");
        String rm = scanner.next();
        control.removeMovies(newList,rm);
        System.out.println("----------------------------------------------");
        // searching by movie name and returning
        System.out.println("Enter movie name to search : ");
        String mov = scanner.next();
        System.out.println(control.find_movie_By_mov_Name(newList,mov));
        System.out.println("----------------------------------------------");
        // searching by movie genre and returning
        System.out.println("Enter movie genre to search : ");
        String movgr = scanner.next();
        System.out.println(control.find_movie_By_Genre(newList,movgr));
        System.out.println("----------------------------------------------");
        // removing all movies
        System.out.println("Type '1' to remove all movies : ");
        int tt = scanner.nextInt();
        if(tt== 1){
            System.out.println("Removing all movies : ");
            control.removeAllMovies(newList);
        }
    }

    public void addMovie(MovieDetails movie) {
        List<MovieDetails> addmovie = new ArrayList<>();
        System.out.println("Movie added : "+addmovie.add(movie));
    }
    public static void sort(ArrayList<MovieDetails> movieDetails, Comparator<MovieDetails> movieDetailsComparator){
        Collections.sort(movieDetails, movieDetailsComparator);
    }

    public static void printSortedMovieList(ArrayList<MovieDetails> movieDetails){
        for (MovieDetails i: movieDetails) {
            System.out.println(i);
        }
        return ;
    }


    public void removeMovies(List<MovieDetails> l,String movieName) {
        Iterator<MovieDetails> itr = l.iterator();
        while(itr.hasNext()){
            MovieDetails mv = itr.next();
                if (mv.getMovieName().equals(movieName)) {
                    itr.remove();

                }
        }for (MovieDetails t: l) {
            System.out.println(t);
        }
    }

    public void removeAllMovies(List<MovieDetails> movies) {
        movies.removeAll(movies);
        System.out.println("All movies removed "+movies);
        return;
    }

    public MovieDetails find_movie_By_mov_Name(List<MovieDetails> l, String movieName) {
        Iterator<MovieDetails> itr = l.iterator();
        while (itr.hasNext()) {
            MovieDetails mv = itr.next();
            if (mv.getMovieName().equals(movieName)) {
                return mv;          // returning the movie details
            }
        }
        return null;
    }

    public List<MovieDetails> find_movie_By_Genre(List<MovieDetails> l,String movieGenre) {
        Iterator<MovieDetails> itr = l.iterator();
        while(itr.hasNext()){
            MovieDetails mv = itr.next();
            if (mv.getGenre().equals(movieGenre)) {
                List<MovieDetails> lt = new ArrayList<>();      // making a new list
                lt.add(mv);                                     // adding to a new list
                return lt;             // returning out the list
            }
        }
        return null;
    }

    //public static Comparator<MovieDetails> sortAccordingly(String sortBy) {}
}