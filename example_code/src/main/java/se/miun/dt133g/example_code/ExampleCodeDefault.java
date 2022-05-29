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
public class ExampleCodeDefault {

  public static void createExample() {

    /*
    add observable integer first observable equals observable dot just of
    add argument one comma two comma three comma four
    add list integer mylist equals arrays dot as list of one comma two comma three comma four
    add observable integer second observable equals observable dot from iterable of mylist
    add observable integer third observable equals observable dot range of zero comma 10
     */

    Observable<Integer> firstObservable = Observable.just(1, 2, 3, 4);
    List<Integer> myList = Arrays.asList(1, 2, 3, 4);
    Observable<Integer> secondObservable = Observable.fromIterable(myList);
    Observable<Integer> thirdObservable = Observable.range(0, 10);

    /*
    add first observable dot subscribe of system dot out colon colon println
    add second observable dot subscribe of system dot out colon colon println
    add third observable dot subscribe of system dot out colon colon println
     */

    firstObservable.subscribe(System.out::println);
    secondObservable.subscribe(System.out::println);
    thirdObservable.subscribe(System.out::println);

    // Characters in code example: 395
    // Single characters: 26
    // Characters in transcript: 600
    // Words: 97
    // Commands: 8
  }

  public static void combineLatestExample() {

    /*
    add observerable string first equals observable dot just of string hello
    add observerable string second equals observable dot just of string world

    add observable string result equals observable dot combine latest of
      add argument arrays dot as list of first comma second
      add argument observables arrow observables brackets zero plus string space plus observables brackets one
    add result dot subscribe of system dot out colon colon println
     */

    Observable<String> first = Observable.just("Hello");
    Observable<String> second = Observable.just("World");
    Observable<String> result =
        Observable.combineLatest(
            Arrays.asList(first, second), observables -> observables[0] + " " + observables[1]);
    result.subscribe(System.out::println);

    // Characters in code example: 296
    // Single characters: 15
    // Characters in transcript: 442
    // Words: 67
    // Commands: 6
  }

  public static void mergeExample() {

    /*
    add observable of integer odds equals observable dot just of one comma three comma five
    add observable of integer evens equals observable dot just of two comma four comma six
    add observable of integer result equals observable dot merge of odds comma evens
    add result dot subscribe of system dot out colon colon println
     */

    Observable<Integer> odds = Observable.just(1, 3, 5);
    Observable<Integer> evens = Observable.just(2, 4, 6);
    Observable<Integer> result =
        Observable.merge(
            odds, evens); // Observable<Integer> result = Observable.merge(odds, events);
    result.subscribe(System.out::println);

    // Characters in code example: 282
    // Single characters: 15
    // Characters in transcript: 318
    // Words: 54
    // Commands: 4
  }

  public static void doExample() {

    /*
    add observable dot just of one comma two comma three comma four
      insert dot do on subscribe of d arrow system dot out dot println of string subscribed
      insert dot do on next of system dot out colon colon println
      insert dot do on complete of of arrow system dot out dot println of string completed
      insert dot blocking subscribe of
     */

    Observable.just(1, 2, 3, 4)
        .doOnSubscribe(d -> System.out.println("Subscribed"))
        .doOnNext(System.out::println)
        .doOnComplete(() -> System.out.println("Completed"))
        .blockingSubscribe();

    // Characters in code example: 203
    // Single characters: 15
    // Characters in transcript: 335
    // Words: 61
    // Commands: 5
  }

  public static void mapExample() {

    /*
    add observable dot just of string hello world
      insert dot map of capital string colon colon length
      insert dot observe on of schedulers dot computation of
      insert dot map of length arrow two times length
      insert dot subscribe of system dot out colon colon println
     */

    Observable.just("Hello World")
        .map(String::length)
        .observeOn(Schedulers.computation())
        .map(length -> 2 * length)
        .subscribe(System.out::println);

    // Characters in code example: 164
    // Single characters: 12
    // Characters in transcript: 267
    // Words: 45
    // Commands: 5
  }

  public static void flatmapExample() {

    /*
    add list string items equals arrays dot as list of
      add argument string a comma string b comma string c
    add observable dot from iterable of items
    insert dot flat map of s arrow braces
        left
        add int delay equals new random of dot next int of five
        add return observable dot just of s
          insert dot map of capital string colon colon to uppercase
        insert dot delay of delay comma time unit dot seconds
    before next semi
    insert dot subscribe of system dot out colon colon println

    add try thread dot sleep of five thousand
    end of line x
    add e dot print stack trace of
    */

    List<String> items = Arrays.asList("a", "b", "c");
    Observable.fromIterable(items)
        .flatMap(
            s -> {
              int delay = new Random().nextInt(5);
              return Observable.just(s).map(String::toUpperCase).delay(delay, TimeUnit.SECONDS);
            })
        .subscribe(System.out::println);

    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    // Characters in code example: 387
    // Single characters: 21
    // Characters in transcript: 579
    // Words: 107
    // Commands: 14
  }

  /*
  add import io dot reactivex dot observable
  add public class sum prod
  add static int sum equals 0
  add static int prod equals 1
  add public static void main of capital string brackets args
  insert curly brackets
  left enter
  add observable integer arr equals observable dot from array of
  add argument new integer brackets curly brackets
  left
  insert 0 comma 1 comma 2 comma 3 comma 4 comma 5
  add arr dot subscribe of e arrow curly brackets
  left left enter
  add sum plus equals e
  add prod times equals e
   */

  import io.reactivex.Observable;

  public class SumProd
  {
    static int sum = 0;
    static int prod = 1;
    public static void main(String[] args) {
      Observable<Integer> arr = Observable.fromArray(new Integer[] { 0, 1, 2, 3, 4, 5 });
      arr.subscribe(e -> {
        sum += e;
        prod *= e;
      });
    }

  }

  // Characters in code example: 267
  // Single characters: 16
  // Characters in transcript: 493
  // Words: 91
  // Commands: 15

  /*
  add import java dot io dot buffered reader
  add import java dot io dot file input stream
  add import java dot io dot file not found exception
  add import java dot io dot io exception
  add import java dot io dot input stream reader
  add import io dot reactivex dot observable
  add public class read file reactive
  add function public static void readFile of string filename throws file not found exception
  add buffered reader in equals new buffered reader of
  add argument new input stream reader of new file input stream of filename
  add observable dot from iterable of
  add argument of arrow in dot lines of dot iterator of
  right
  insert dot subscribe of of system dot out colon colon println
   */

  import java.io.BufferedReader;
  import java.io.FileInputStream;
  import java.io.FileNotFoundException;
  import java.io.IOException;
  import java.io.InputStreamReader;
  import io.reactivex.Observable;

  public class ReadFileReactive {

    public static void readFile(String filename) throws FileNotFoundException {
      BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
      Observable.fromIterable(() -> in.lines().iterator())
              .subscribe(System.out::println);
    }
  }

  // Characters in code example: 483
  // Single characters: 20
  // Characters in transcript: 682
  // Words: 122
  // Commands: 14

  public static void main(String[] args) {
    flatmapExample();
  }
}
