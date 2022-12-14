
public class QuizzerTester {
  public static void main(String[] args) {
    // System.out.print(runAllTests());
    System.out.println("testLinkedNode(): " + testLinkedNode());
    System.out.println("testAddFirst(): " + testAddFirst());
    System.out.println("testAddLast(): " + testAddLast());
    System.out.println("ALL TESTS: " + String.valueOf(runAllTests()));
  }

  /**
   * Runs all the tester methods defined in this QuizzerTester
   * 
   * @return true if all tests pass and false if any of the tests fails
   */
  public static boolean runAllTests() {
    if (!(testMultipleChoiceQuestion() || testLinkedNode() || testCorrectQuestionsIterator()
        || testInCorrectQuestionsIterator() || testQuizQuestionsIterator() || testAddLast()
        || testRemoveLast() || testRemoveFirst() || testRemove() || testAdd() || testAddFirst())) {
      return false;
    }
    return true;
    
    // PROBABLY NOT RIHRIUSBHNFIUDHU RIGHT
  }

  /**
   * This method test and make use of the MultipleChoiceQuestion constructor, an accessor (getter)
   * method, overridden method toString() and equal() method defined in the MultipleChoiceQuestion
   * class.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testMultipleChoiceQuestion() {
    return false;
  }

  public static boolean testLinkedNode() {

    // First test of LinkedNode 11/14

    LinkedNode thirdNode = new LinkedNode(3);
    LinkedNode secondNode = new LinkedNode(2, thirdNode);
    LinkedNode firstNode = new LinkedNode(1, secondNode);

    if (!(firstNode.toString().equals("1->2->3"))) {
      System.out.println(firstNode);
      System.out.println("Error with testLinkedNode()");
      return false;
    }

    // Test that the third node doesn't have a value after it - doesn't throw an error either
    if (thirdNode.getNext() != null) {
      System.out.println("Error with testLinkedNode()");
      return false;
    }

    // All tests passed successfully!
    return true;
  }

  public static boolean testCorrectQuestionsIterator() {
    return false; // Generated by default
  }

  public static boolean testInCorrectQuestionsIterator() {
    return false; // Generated by default
  }

  public static boolean testQuizQuestionsIterator() {
    return false; // Generated by default
  }

  public static boolean testAddLast() {

    String[] answers = new String[3];
    answers[0] = "Yes";
    answers[1] = "Definitely Yes";
    answers[2] = "Frick yeah!";

    MultipleChoiceQuestion question1 =
        new MultipleChoiceQuestion("Question 1", "Does Frank Get ALL The Girls???", answers, 2, 5);
    
    String[] answers2 = new String[3];
    answers[0] = "Yes";
    answers[1] = "No";
    answers[2] = "Frick yeah!";

    MultipleChoiceQuestion question2 =
        new MultipleChoiceQuestion("Question 2", "Does Pete Get ALL The Girls???", answers, 1, 5);

    ListQuizzer questionsHolder = new ListQuizzer();
    questionsHolder.addLast(question2);
    questionsHolder.addLast(question1);
    
    // Should be [Question 2, Question 1]
    
  if (questionsHolder.size() != 2) {
    System.out.println("Error with testAddLast()");
    return false;
  }
  
  if (!(questionsHolder.getFirst()==question2)) {
    return false;
  }
  
  if (!(questionsHolder.getLast()==question1)) {
    return false;
  }



    return true; // Generated by default
  }

  public static boolean testRemoveLast() {
    return false; // Generated by default
  }

  public static boolean testRemoveFirst() {
    String[] answers = new String[3];
    answers[0] = "Yes";
    answers[1] = "Definitely Yes";
    answers[2] = "Frick yeah!";

    MultipleChoiceQuestion question1 =
        new MultipleChoiceQuestion("Question 1", "Does Frank Get ALL The Girls???", answers, 2, 5);
    
    String[] answers2 = new String[3];
    answers[0] = "Yes";
    answers[1] = "No";
    answers[2] = "Frick yeah!";

    MultipleChoiceQuestion question2 =
        new MultipleChoiceQuestion("Question 2", "Does Pete Get ALL The Girls???", answers, 1, 5);

    ListQuizzer questionsHolder = new ListQuizzer();
    questionsHolder.addLast(question2);
    questionsHolder.addLast(question1);
    questionsHolder.removeFirst();
    System.out.println("TestRemoveFirst: " + String.valueOf(questionsHolder.size() == 1 && questionsHolder.getFirst() == question2));
    return (questionsHolder.size() == 1 && questionsHolder.getFirst() == question2);
  }

  public static boolean testRemove() {
    return false; // Generated by default
  }

  public static boolean testAdd() {
    return false; // Generated by default
  }

  public static boolean testAddFirst() {
    String[] answers = new String[3];
    answers[0] = "Yes";
    answers[1] = "Definitely Yes";
    answers[2] = "Frick yeah!";

    MultipleChoiceQuestion question1 =
        new MultipleChoiceQuestion("Question 1", "Does Frank Get ALL The Girls???", answers, 2, 5);
    
    String[] answers2 = new String[3];
    answers[0] = "Yes";
    answers[1] = "No";
    answers[2] = "Frick yeah!";

    MultipleChoiceQuestion question2 =
        new MultipleChoiceQuestion("Question 2", "Does Pete Get ALL The Girls???", answers, 1, 5);

    ListQuizzer questionsHolder = new ListQuizzer();
    questionsHolder.addFirst(question2);
    questionsHolder.addFirst(question1);

    
    // Should be [Question 2, Question 1]
      
    if (questionsHolder.size() != 2) {
      System.out.println("Error with testAddFirst()");
      return false;
    }
    
    if (!(questionsHolder.getFirst()==question1)) {
      System.out.println(questionsHolder.getFirst());
      return false;
    }
    
    if (!(questionsHolder.getLast()==question2)) {
      return false;
    }

    System.out.println(questionsHolder);



    return true; 
  }
}
