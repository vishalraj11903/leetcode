package org.example;
import java.io.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.*;

// Main class should be named 'Solution' and should not be public.
public class Solution {
    public static void main(String[] args) {
        List<List<Movie>> inputList = new ArrayList<>();
        inputList.add(Arrays.asList(new Movie("m1"), new Movie("m3"), new Movie("m3"), new Movie("m5")));
        inputList.add(Arrays.asList(new Movie("m5"), new Movie("m6"), new Movie("m7")));
        inputList.add(Arrays.asList(new Movie("m7"), new Movie("m3"), new Movie("m7")));
        System.out.println(removeDups(inputList, 3));
    }

    static class Movie {
        String movieId;
        Movie(String movieId) {
            this.movieId = movieId;
        }

        @Override
        public String toString() {
            return " " + this.movieId + " ";
        }
    }

    public static List<List<Movie>> removeDups(List<List<Movie>> movieList, int limit) {
        List<List<Movie>> result = new ArrayList<>();
        Set<String> visible = new HashSet<>();

        for (List<Movie> movies : movieList) {
            List<Movie> row = new ArrayList<>();
            List<Movie> outside = new ArrayList<>();
            for (Movie movie : movies) {
               if (row.size() < limit && visible.add(movie.movieId)) {
                   row.add(movie);
               } else if (!visible.contains(movie.movieId)){
                   outside.add(movie);
               }

            }

            if (row.size() > 0) {
                row.addAll(outside);
                result.add(row);
            }

        }

        return result;
    }
}