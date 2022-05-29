package se.miun.dt133g.example_code;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ExampleCodeCustom {

    public static void createExample() {

        // Three ways to create observables
        Observable<Integer> firstObservable = Observable.just(1, 2, 3, 4);          // add observable integer first observable equals observable dot just of 1 comma 2 comma 3 comma 4
        List<Integer> myList = Arrays.asList(1, 2, 3, 4);                           // add integer list my list of 1 comma 2 comma 3 comma 4
        Observable<Integer> secondObservable = Observable.fromIterable(myList);     // add observable integer second observable equals observable dot from iterable of my list
        Observable<Integer> thirdObservable = Observable.range(0, 10);   // add observable integer third observable equals observable dot range of 0 comma 10

        firstObservable.subscribe(System.out::println);                             // add first observable dot subscribe of print line
        secondObservable.subscribe(System.out::println);                            // add second observable dot subscribe of print line
        thirdObservable.subscribe(System.out::println);                             // add third observable dot subscribe of print line

        // Characters in code example: 395
        // Single characters: 15
        // Characters in transcript: 521
        // Words: 80
        // Commands: 7
    }

    public static void combineLatestExample() {

        Observable<String> first = Observable.just("Hello");                        // add observable string first equals observable dot just of string hello
        Observable<String> second = Observable.just("World");                       // add observable string second equals observable dot just of string world
                                                                                    // add observable string result equals observable dot combine latest of
                                                                                    // add argument arrays dot as list of first comma second
                                                                                    // add argument observables arrow observables of 0 plus string space plus observables of 1
        Observable<String> result = Observable.combineLatest(Arrays.asList(first, second), observables -> observables[0] + " " + observables[1]);
        result.subscribe(System.out::println);                                      // add result dot subscribe of print line

        result.subscribe();

        // Characters in code example: 296
        // Single characters: 11
        // Characters in transcript: 392
        // Words: 63
        // Commands: 6
    }

    public static void mergeExample() {

        Observable<Integer> odds = Observable.just(1, 3, 5);                        // add observable integer odds equals observable dot just of 1 comma 3 comma 5
        Observable<Integer> evens = Observable.just(2, 4, 6);                       // add observable integer evens equals observable dot just of 2 comma 4 comma 6
        Observable<Integer> result = Observable.merge(odds, evens);                 // add observable integer result equals observable dot merge of odds comma evens
        result.subscribe(System.out::println);                                      // add result dot subscribe of print line

        // Characters in code example: 282
        // Single characters: 11
        // Characters in transcript: 269
        // Words: 47
        // Commands: 4
    }

    public static void doExample() {

        Observable.just(1, 2, 3, 4)                                             // add observable dot just of 1 comma 2 comma 3 comma 4
                .doOnSubscribe(d -> System.out.println("Subscribed"))           // chain do on subscribe of d with print line string subscribed
                .doOnNext(System.out::println)                                  // chain do on next of print line
                .doOnComplete(() -> System.out.println("Completed"))            // chain do on complete of empty with print line string completed
                .blockingSubscribe();                                           // chain blocking subscribe

        // Characters in code example: 203
        // Single characters: 4
        // Characters in transcript: 228
        // Words: 44
        // Commands: 5
    }

    public static void mapExample() {

        Observable.just("Hello World")                                          // add observable dot just of string hello world
                .map(String::length)                                            // chain map of string colon length
                .observeOn(Schedulers.computation())                            // chain observe on of computation
                .map(length -> 2 * length)                                      // chain map of length with two times length
                .subscribe(System.out::println);                                // chain subscribe of print line

        // Characters in code example: 164
        // Single characters: 2
        // Characters in transcript: 182
        // Words: 32
        // Commands: 5
    }

    public static void flatmapExample() {

        List<String> items = Arrays.asList("a", "b", "c");                      // add string list items of string a comma string b comma string c
        Observable.fromIterable(items)                                          // add observable dot from iterable of items
                .flatMap(s -> {                                                 // chain flat map of s with body
                    int delay = new Random().nextInt(5);                  // add int delay equals random int max five
                    return Observable.just(s).map(String::toUpperCase)          // add return observable dot just of s // chain map of string colon to upper case
                            .delay(delay, TimeUnit.SECONDS);                    // chain delay of delay comma time unit dot seconds // down
                })
                .subscribe(System.out::println);                                // chain subscribe of print line

        try {
            Thread.sleep(5000);                                           // add thread dot sleep of five thousand // go to sleep // options // down enter
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Characters in code example: 387
        // Single characters: 6
        // Characters in transcript: 392
        // Words: 76
        // Commands: 13
    }

    import io.reactivex.Observable;                                                                         // add import io dot reactivex dot observable
    public class SumProd                                                                                    // add public class sum prod
    {
        static int sum = 0;                                                                                 // add static int sum equals 0
        static int prod = 1;                                                                                // add static int prod equals 1
        public static void main(String[] args) {                                                            // add main
            Observable<Integer> arr = Observable.fromArray(new Integer[] { 0, 1, 2, 3, 4, 5 });             // add observable integer arr equals observable dot from array of // add argument integer array of 1 comma 2 comma 3 comma 4 comma 5
            arr.subscribe(e -> {                                                                            // add numbers dot subscribe of e with body
                sum += e;                                                                                   // add sum plus equals e
                prod *= e;                                                                                  // add prod times equals e
            });
        }
    }

    // Characters in code example: 267
    // Single characters: 16
    // Characters in transcript: 346
    // Words: 68
    // Commands: 10

    import java.io.BufferedReader;                                                                              // add import java dot io dot buffered reader
    import java.io.FileInputStream;                                                                             // add import java dot io dot file input stream
    import java.io.FileNotFoundException;                                                                       // add import java dot io dot file not found exception
    import java.io.IOException;                                                                                 // add import java dot io dot io exception
    import java.io.InputStreamReader;                                                                           // add import java dot io dot input stream reader
    import io.reactivex.Observable;                                                                             // add import io dot reactivex dot observable

    public class ReadFileReactive {                                                                             // add public class read file reactive

        public static void readFile(String filename) throws FileNotFoundException {                             // add function public static void readFile of string filename throws file not found exception
                                                                                                                // add buffered reader in equals new buffered reader of
                                                                                                                // add argument new input stream reader of new file input stream of filename
            BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
            Observable.fromIterable(() -> in.lines().iterator())                                                // add observable dot from iterable of empty with in dot lines of dot iterator of
                    .subscribe(System.out::println);                                                            // chain subscribe of print line
        }
    }

    // Characters in code example: 483
    // Single characters: 16
    // Characters in transcript: 633
    // Words: 113
    // Commands: 12

}