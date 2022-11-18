import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Arrays;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ListQuizzer {
  private LinkedNode<MultipleChoiceQuestion> head; // Head of this singly linked list
  private LinkedNode<MultipleChoiceQuestion> tail; // Tail of this singly linked list
  private int size; // Total number of MultipleChoiceQuestions stored in this ListQuizzer
  private ListingMode listingMode; // The listing mode of this list quizzer which defines which
                                   // questions are going to be listed while iterating through this
                                   // list

  /**
   * this constructor creates a new empty instance of ListQuizzer which contains zero elements and
   * sets its listing mode to be ListingMode.ALL by default. Represents a singly linked list
   * containing multiple choice questions for the quiz.
   */
  public ListQuizzer() {
    head = null;
    tail = null;
    size = 0;
    listingMode = ListingMode.ALL;
    //MultipleChoiceQuestion[] questionBank = new MultipleChoiceQuestion[size];
  }

  
  /** 
   * @return boolean
   */
  public boolean isEmpty() {
    return size == 0;
  }

  
  /** 
   * @return int
   */
  public int size() {
    return size;
  }

  
  /** 
   * @param listingMode
   */
  public void switchMode(ListingMode listingMode) {
    this.listingMode = listingMode;
  }

  
  /** 
   * @param index
   * @param question
   * @throws NullPointerException
   * @throws IndexOutOfBoundsException
   */
  public void add(int index, MultipleChoiceQuestion question)
      throws NullPointerException, IndexOutOfBoundsException {

    // (String title, String question, String[] answers, int correctAnswerIndex, int pointsPossible)
    // MultipleChoiceQuestion newQuestion = new
    // MultipleChoiceQuestion(question.getTitle(),question.getQuestion(),question.getAnswers(),
    // question.getCorrectAnswerIndex(), question.getPointsPossible() );
    // LinkedNode secondNode = new LinkedNode(index, question);
    // MultipleChoiceQuestion newQuestion = question.copy();
    if (index < 0 || index > size ) {
      throw new IndexOutOfBoundsException();
    }
    if(question == null) {
      throw new NullPointerException();
    }
    if(index == 0) {
      addFirst(question);
    }
    else if(index == size) {
      addLast(question);
    }
    else {
      LinkedNode<MultipleChoiceQuestion> cur = head;
      for (int i = 1; i < index; i++) {
        cur = cur.getNext();
      }
      LinkedNode<MultipleChoiceQuestion> inputNode = new LinkedNode<MultipleChoiceQuestion>(question);
      inputNode.setNext(cur.getNext());
      cur.setNext(inputNode);
      size = size + 1;
    }

  }

  
  /** 
   * @param question
   * @throws NullPointerException
   */
  public void addFirst(MultipleChoiceQuestion question) throws NullPointerException {
    if (question == null) {
      throw new NullPointerException();
    }
    if (size == 0) {
      addInitial(question);
    }
    else {
      LinkedNode<MultipleChoiceQuestion> inputNode = new LinkedNode<MultipleChoiceQuestion>(question);
      inputNode.setNext(head);
      head = inputNode;
      size++;
    }
  }

  
  /** 
   * @param question
   * @throws NullPointerException
   */
  public void addLast(MultipleChoiceQuestion question) throws NullPointerException {
    if (question == null) {
      throw new NullPointerException();
    }
    if (size == 0) {
      addInitial(question);
    }
    else {
      LinkedNode<MultipleChoiceQuestion> inputNode = new LinkedNode<MultipleChoiceQuestion>(question);
      tail.setNext(inputNode);
      tail = inputNode;
      size++;
    }
  }

  
  /** 
   * Adds item to list is list is empty
   * @param question
   */
  private void addInitial(MultipleChoiceQuestion question) {
    LinkedNode<MultipleChoiceQuestion> inputNode = new LinkedNode<MultipleChoiceQuestion>(question);
    head = inputNode;
    tail = inputNode;
    size = 1;
  }

  public void clear() {
    head = null;
    tail = null;
    size = 0;
  }

  
  /** 
   * @param someQuestion
   * @return boolean
   */
  public boolean contains(MultipleChoiceQuestion someQuestion) {
    if(isEmpty()) {
      return false;
    }

    LinkedNode<MultipleChoiceQuestion> cur = head;
    while(cur.getNext() != null) {
      if (cur.getData().equals(someQuestion)) {
        return true;
      }
      cur = cur.getNext();
    }
    return false;
  }

  
  /** 
   * @param index
   * @return MultipleChoiceQuestion
   * @throws IndexOutOfBoundsException
   */
  public MultipleChoiceQuestion get(int index) throws IndexOutOfBoundsException {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("too far out, man");
    }
    LinkedNode<MultipleChoiceQuestion> cur = head;
    for (int i = 0; i < index; i++) {
      cur = cur.getNext();

    }
    return cur.getData();
  }

  
  /** 
   * @return MultipleChoiceQuestion
   * @throws NoSuchElementException
   */
  public MultipleChoiceQuestion getFirst() throws NoSuchElementException {


    if(size == 0) {
      throw new NoSuchElementException("List is Empty");
    }
  
    return head.getData();
  }

  
  /** 
   * @return MultipleChoiceQuestion
   * @throws NoSuchElementException
   */
  public MultipleChoiceQuestion getLast() throws NoSuchElementException {

    if(size == 0) {
      throw new NoSuchElementException("List is Empty");
    }
  
    return tail.getData();
  }

  
  /** 
   * @param index
   * @return MultipleChoiceQuestion
   * @throws IndexOutOfBoundsException
   */
  public MultipleChoiceQuestion remove(int index) throws IndexOutOfBoundsException {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("too far out, man");
    }
    if (index == 0) {
      return removeFirst();
    }
    else if (index == size - 1) {
      return removeLast();
    }
    else {
      size = size - 1;
      LinkedNode<MultipleChoiceQuestion> cur = head;
      for (int i = 1; i < index; i++) {
        cur = cur.getNext();

      }
      MultipleChoiceQuestion output = cur.getNext().getData();
      cur.setNext(cur.getNext().getNext());
      return output;
    }
  }

  
  /** 
   * @return MultipleChoiceQuestion
   * @throws NoSuchElementException
   */
  public MultipleChoiceQuestion removeFirst() throws NoSuchElementException {
    if(size == 0) {
      throw new NoSuchElementException("List is Empty");
    }
    MultipleChoiceQuestion output = head.getData();
    if (size == 1) {
      clear();
    }
    else {
      head = head.getNext();
      size = size - 1;
    }
    return output;
  }

  
  /** 
   * @return MultipleChoiceQuestion
   * @throws NoSuchElementException
   */
  public MultipleChoiceQuestion removeLast() throws NoSuchElementException {
    if(size == 0) {
      throw new NoSuchElementException("List is Empty");
    }
    MultipleChoiceQuestion output = tail.getData();
    if (size == 1) {
      clear();
      return output;
    }
    else {
      LinkedNode<MultipleChoiceQuestion> cur = head;
      for (int i = 1; i < size - 1; i++) {
        cur = cur.getNext();
      }
      tail = cur;
      cur.setNext(null);
      size = size - 1;
      return output;
    }

  }

  
  /** 
   * @return Iterator<MultipleChoiceQuestion>
   */
  public Iterator<MultipleChoiceQuestion> iterator() {
    return null;

  }

  
  /** 
   * @return int
   */
  public int calculateScore() {
    return size;

  }

  
  /** 
   * @return int
   */
  public int calculateTotalPoints() {
    return size;

  }

  
  /** 
   * @return ListQuizzer
   */
  public ListQuizzer copy() {
    ListQuizzer output = new ListQuizzer();
    LinkedNode<MultipleChoiceQuestion> cur = head;
    for (int i = 0; i < size; i++) {
      output.addLast(cur.getData());
      cur = cur.getNext();
    }
    
    return output;

  }

  
      /**
   * Loads MultipleChoiceQuestions from a file
   * 
   * @author Jeff and Mouna
   * 
   * @param file file to read
   * @return the number of added MultipleChoiceQuestions to this list
   * @throws FileNotFoundException if the file is not found
   */
  public int loadQuestions(File file) throws FileNotFoundException {
    int loadedCount = 0; // count of loaded multiple choice questions
    int answerCount = 0; // count of possible answers per question
    int indexCorrectAnswer = 0; // index of the correct answer
    int points = 0; // possible points for a multiple choice question
    // try to read the file
    Scanner reader = null; // scanner to read the file line by line
    int lineNumber = 0; // number of the last read line

    try {
      reader = new Scanner(file);
      // parse the file lines - while loop to read parts of each multiple choice question
      while (reader.hasNextLine()) { // no more lines to read
        // read title
        String title = reader.nextLine();
        lineNumber++;

        // read question stem
        if (!reader.hasNextLine()) { // no more lines to read
          return loadedCount;
        }
        String question = reader.nextLine();
        lineNumber++;

        // read possible answers count
        if (!reader.hasNextLine()) { // no more lines to read
          return loadedCount;
        }
        String count = reader.nextLine();
        lineNumber++;
        // check the validity of count
        try {
          answerCount = Integer.parseInt(count.trim());
          if (answerCount <= 0 || answerCount > 10) {
            throw new NumberFormatException();
          }
        } catch (NumberFormatException e) { // count invalid - print an error message and return
          System.out
              .println("Syntax error! A positive integer less or equal to 10 is expected at line "
                  + lineNumber + (". Load questions operation interrupted!"));
          return loadedCount;
        }
        // valid count -> create the answerList array
        String[] answerList = new String[answerCount];
        int index = 0;
        while (index < answerCount && reader.hasNextLine()) {
          String answer = reader.nextLine();
          lineNumber++;
          answerList[index] = answer;
          index++;
        }

        // read index of the correct answer
        if (!reader.hasNextLine()) { // no more lines to read
          return loadedCount;
        }
        String line = reader.nextLine();
        lineNumber++;
        try { // check the validity of the index of the correct answer
          indexCorrectAnswer = Integer.parseInt(line.trim());
          if (indexCorrectAnswer < 0 || indexCorrectAnswer >= answerCount) {
            throw new NumberFormatException();
          }
        } catch (NumberFormatException e) { // indexCorrectAnswer invalid - print error and return
          System.out.println("Syntax error! A positive integer less than " + answerCount
              + " is expected at line " + lineNumber + (". Load questions operation interrupted!"));
          return loadedCount;
        }
        // valid index of the correct answer -> read possible points
        // read points
        if (!reader.hasNextLine()) { // no more lines to read
          return loadedCount;
        }
        line = reader.nextLine();

        lineNumber++;
        try { // check the validity of the index of the correct answer
          points = Integer.parseInt(line.trim());

          if (points < 0) {
            throw new NumberFormatException();
          }
        } catch (NumberFormatException e) { // invalid points - print error message and return
          System.out.println("Syntax error! A positive integer for possible points "
              + " is expected at line " + lineNumber + (". Load questions operation interrupted!"));

          return loadedCount;
        }
          // create and add quizQuestion
          MultipleChoiceQuestion quizQuestion =
              new MultipleChoiceQuestion(title, question, answerList, indexCorrectAnswer, points);

          this.addLast(quizQuestion);
          loadedCount += 1;
          System.out.println("Question " + loadedCount + " loaded!");

      }
    } finally {
      if (reader != null)
        reader.close();
    }

    return loadedCount;
  }


  /**
   * Allows a user to take this quiz. The quiz should be taken on a deep copy of this ListQuizzer.
   * This method should not make any changes to the contents of this ListQuizzer.
   * 
   * @author Jeff and Mouna
   * 
   * @return the instance of ListQuizzer taken by the user. It should include the user's responses.
   */
  public ListQuizzer takeQuiz() {

    ListQuizzer copy = this.copy();
    copy.switchMode(ListingMode.ALL);
    Scanner input = new Scanner(System.in);
    for (MultipleChoiceQuestion question : copy) {
      System.out.println(question);
      System.out.print("Enter your answer: ");
      int entry = input.nextInt();
      question.setStudentAnswerIndex(entry - 1);
      if (question.isCorrect()) {
        System.out.println("Correct!");
      } else {
        System.out.println("Incorrect!");
      }
    }
    int correctPoints = copy.calculateScore();
    int totalPoints = copy.calculateTotalPoints();
    System.out.println("Your Score: " + correctPoints);
    System.out.println("Percentage: " + correctPoints / totalPoints);
    input.close();
    return copy;
  }

  /**
   * Returns true if o is a ListQuizzer which has the exact same contents as this ListQuizzer
   * 
   * @author Mouna
   *
   * @param o an object to compare with
   * @return true if o is instanceof ListQuizzer with the exact same contents as this ListQuizzer
   */
  @Override 
  public boolean equals(Object o) {
    if(o instanceof ListQuizzer) {
      ListQuizzer other = (ListQuizzer)o;
      if(this.size()!= other.size())
        return false;
      this.switchMode(ListingMode.ALL);
      other.switchMode(ListingMode.ALL);
      Iterator<MultipleChoiceQuestion> iterator = this.iterator();
      Iterator<MultipleChoiceQuestion> otherIterator = other.iterator();
      while(iterator.hasNext()) {
        if(!iterator.next().equals(otherIterator.next()))
          return false;
      }
      return true;
    }
    return false;
  }

}
