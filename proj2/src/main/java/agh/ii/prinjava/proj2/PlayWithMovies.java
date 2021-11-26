package agh.ii.prinjava.proj2;

import agh.ii.prinjava.proj2.dal.ImdbTop250;
import agh.ii.prinjava.proj2.model.Movie;
import agh.ii.prinjava.proj2.utils.Utils;
import java.util.*;
import java.util.stream.Collectors;

interface PlayWithMovies {

    /**
     * Returns the movies (only titles) directed (or co-directed) by a given director
     */
    static Set<String> ex01(String director) {
        final Optional<List<Movie>> movies = ImdbTop250.movies();
        return movies.orElseThrow().stream()
                .filter(m -> m.directors().contains(director))
                .map(Movie::title)
                .collect(Collectors.toSet());
    }

    /**
     * Returns the movies (only titles) in which an actor played
     */
    static Set<String> ex02(String actor) {
        final Optional<List<Movie>> movies = ImdbTop250.movies();
        return movies.orElseThrow().stream()
                .filter(m -> m.actors().contains(actor))
                .map(Movie::title)
                .collect(Collectors.toSet());
    }

    /**
     * Returns the number of movies per director (as a map)
     */
    static Map<String, Long> ex03() {
        final Optional<List<Movie>> movies = ImdbTop250.movies();

        //We create a list of lists of movies with only one director for each film
        List<List<Movie>> list1 = new ArrayList<>();
        movies.orElseThrow().forEach( movie -> list1.add(Utils.oneToManyByDirector(movie)));

        //We convert the previous list of lists into a simple list of movies (with only one director each)
        List<Movie> list2 = list1.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        //We return the correct map
        return list2.stream()
                .collect(
                        Collectors.groupingBy(
                                m -> m.directors().get(0),
                                Collectors.counting()
                        )
                );
    }

    /**
     * Returns the 10 directors with the most films on the list
     */
    static Map<String, Long> ex04() {
        Map<String, Long> numOfMoviesPerDirector = ex03();
        return numOfMoviesPerDirector.entrySet().stream()
                //We sort the directors in reverse order
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                //We take the top 10
                .limit(10)
                //We convert into a map
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    /**
     * Returns the movies (only titles) made by each of the 10 directors found in {@link PlayWithMovies#ex04 ex04}
     */
    static Map<String, Set<String>> ex05() {
        final Optional<List<Movie>> movies = ImdbTop250.movies();

        //We create a map with the top 10 of directors
        final Map<String, Long> directorsWithMostFilms = ex04();

        //We create a list of movie with only one director for each movie
        List<Movie> listWithOneDirector = new ArrayList<>();
        movies.orElseThrow().forEach( movie -> listWithOneDirector.addAll(Utils.oneToManyByDirector(movie)));

        return listWithOneDirector.stream()
                //We take only the movies with the directors from the top 10
                .filter(movie -> directorsWithMostFilms.containsKey(movie.directors().get(0)))

                //We create a map of directors and set of titles
                .collect(Collectors.groupingBy(
                        film -> film.directors().get(0),
                        Collectors.mapping(Movie::title, Collectors.toSet())));
    }

    /**
     * Returns the number of movies per actor (as a map)
     */
    static Map<String, Long> ex06() {
        final Optional<List<Movie>> movies = ImdbTop250.movies();

        //We create a list of lists of movies with only one actor for each film
        List<List<Movie>> list1 = new ArrayList<>();
        movies.orElseThrow().forEach( m -> list1.add(Utils.oneToManyByActor(m)));

        //We convert the previous list of lists into a simple list of movies (with only one director each)
        List<Movie> list2 = list1.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        //We return the correct map
        return list2.stream()
                .collect(
                        Collectors.groupingBy(
                                m -> m.actors().get(0),
                                Collectors.counting()
                        )
                );
    }

    /**
     * Returns the 9 actors with the most films on the list
     */
    static Map<String, Long> ex07() {
        Map<String, Long> numOfMoviesPerActor = ex06();
        return numOfMoviesPerActor.entrySet().stream()
                //We sort the actors in reverse order
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                //We take the top 9
                .limit(9)
                //We convert into a map
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    /**
     * Returns the movies (only titles) of each of the 9 actors from {@link PlayWithMovies#ex07 ex07}
     */
    static Map<String, Set<String>> ex08() {
        final Optional<List<Movie>> movies = ImdbTop250.movies();

        //We create a map with the top 9 of actors
        final Map<String, Long>  actorsWithMostFilms = ex07();

        //We create a list of movie with only one actor for each movie
        List<Movie> listByActors = new ArrayList<>();
        movies.orElseThrow().forEach( movie -> listByActors.addAll(Utils.oneToManyByActor(movie)));

        return listByActors.stream()
                //We take only the movies with the actors from the top 9
                .filter(movie -> actorsWithMostFilms.containsKey(movie.actors().get(0)))
                //We create a map of directors and set of titles
                .collect(Collectors.groupingBy(
                        film -> film.actors().get(0),
                        Collectors.mapping(Movie::title, Collectors.toSet())));
    }

    /**
     * Returns the 5 most frequent actor partnerships (i.e., appearing together most often)
     */
    static Map<String, Long> ex09() {
        Optional<List<Movie>> movies = ImdbTop250.movies();

        //We create a list of movies with duo of actors
        List<Movie> partnershipList = new ArrayList<>();
        movies.orElseThrow().forEach(movie -> partnershipList.addAll(Utils.oneToManyByActorDuo(movie)));

        return partnershipList.stream()
                //We create a map containing duo of actors and their number of films
                .collect(Collectors.groupingBy(
                        m -> m.actors().get(0),
                        Collectors.counting()))
                .entrySet().stream()
                //We sort in the reverse order
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                //We take the top 5
                .limit(5)
                //We convert into a map
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    /**
     * Returns the movies (only titles) of each of the 5 most frequent actor partnerships
     */
    static Map<String, Set<String>> ex10() {
        final Optional <List<Movie>> movies = ImdbTop250.movies();

        Map<String, Long> topPartnerships = ex09();

        //We create a list of movies with duo of actors
        List<Movie> partnershipList = new ArrayList<>();
        movies.orElseThrow().forEach(movie -> partnershipList.addAll(Utils.oneToManyByActorDuo(movie)));

        return partnershipList.stream()
                //We filter the list of partnerships with the top 5 partnerships
                .filter(movie -> topPartnerships.containsKey(movie.actors().get(0)))

                //We create a map containing actors and a set of their films
                .collect(Collectors.groupingBy(
                        movie -> movie.actors().get(0),
                        Collectors.mapping(Movie::title, Collectors.toSet())));
    }
}

