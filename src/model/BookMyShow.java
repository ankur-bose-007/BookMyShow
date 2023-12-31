package model;

import Enums.Genre;
import Enums.Language;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;

public class BookMyShow {
    private ArrayList<User> users;
    private ArrayList<Theater> theaters;
    private HashMap<String, ArrayList<Show>> movieMap;

    public BookMyShow(ArrayList<Theater> theaters){
        this.users = new ArrayList<>();
        this.theaters = theaters;
        this.movieMap = new HashMap<>();

        generateMovieMap();
    }

    private void generateMovieMap(){
        for(Theater theater: theaters) {
            for(Show show: theater.getShows()){
                // is present
                if(this.movieMap.containsKey(show.getMovie().getName())){
                    this.movieMap.get(show.getMovie().getName()).add(show);
                } else {
                    ArrayList<Show> showList = new ArrayList<>();

                    showList.add(show);

                    this.movieMap.put(show.getMovie().getName(), showList);
                }
            }
        }
    }

    public ArrayList<Show> searchShows(String movieName) throws Exception {
        if(movieMap.containsKey(movieName)) return movieMap.get(movieName);

        throw new Exception("No Shows present");
    }

    public static void main(String[] args) throws ParseException {
        // Initialize all model objects
        // Create object of BMS app
        // Use it to book tickets and search shows

        // Users
        RegisteredUser ankur = new RegisteredUser("Ankur");
        RegisteredUser ankit = new RegisteredUser("Ankit");

        GuestUser guestUser = new GuestUser("Bob");

        // Movie
        Movie ironMan = new Movie("iron man", Language.ENGLISH, Genre.ACTION);
        Movie avengers = new Movie("avengers", Language.ENGLISH, Genre.ACTION);
        Movie housefull = new Movie("housefull", Language.HINDI, Genre.COMEDY);
        Movie aWalkToRemember = new Movie("A walk to remember", Language.ENGLISH, Genre.ROMANCE);

        // Theater
        Theater pvr_gip = new Theater("PVR GIP", "Noida", 30);
        Theater big_cinema = new Theater("Big Cinema", "Gurgaon", 25);

        SimpleDateFormat formatter = new SimpleDateFormat("EEEE, MMM dd, yyyy HH:mm:ss a");

        // Shows
        Show ironManShow = new Show(formatter.parse("Friday, May 10, 2023 10:00:00 AM"), ironMan, pvr_gip);
        Show avengersShow = new Show(formatter.parse("Friday, Jun 10, 2023 10:00:00 AM"), avengers, big_cinema);
        Show housefullShow = new Show(formatter.parse("Friday, Jul 10, 2023 10:00:00 PM"), housefull, big_cinema);
        Show aWalkToRememberShow = new Show(formatter.parse("Friday, May 29, 2023 10:00:00 PM"), aWalkToRemember, pvr_gip);

        // BookMyShow
        ArrayList<Theater> theatersList = new ArrayList<>();
        theatersList.add(pvr_gip);
        theatersList.add(big_cinema);

        BookMyShow bms = new BookMyShow(theatersList);

        // Search shows
        try{
            ArrayList<Show> searchShows = bms.searchShows("iron man");
            System.out.println("Shows: " + searchShows);
        } catch (Exception e){
            System.out.println("No shows found");
        }


        // Book tickets
        try{
            Ticket ankurTicket = bms.bookTicket(ironManShow, 25, ankur, pvr_gip.getName());

            System.out.println(ankurTicket.getTicketInfo());
        } catch (Exception e){
            System.out.println("Tickets sold out");
        }

        try{
            Ticket ankitTicket = bms.bookTicket(ironManShow, 25, ankit, pvr_gip.getName());

            System.out.println(ankitTicket.getTicketInfo());
        } catch (Exception e){
            System.out.println("Tickets sold out");
        }
    }

    private Ticket bookTicket(Show show, int seats, User user, String theater) throws Exception {
        if(user instanceof RegisteredUser){
            return show.bookTickets(seats, (RegisteredUser) user, theater);
        } else {
            throw new Exception("Please register first to book tickets");
        }
    }
}
