import java.util.Iterator;
import java.util.NoSuchElementException;

public class IncorrectQuestionsIterator extends QuizQuestionsIterator implements Iterator<MultipleChoiceQuestion>{
    private static final boolean CORRECT = false;

    private LinkedNode<MultipleChoiceQuestion> next;

    IncorrectQuestionsIterator(LinkedNode<MultipleChoiceQuestion> startNode) {
        super(startNode);
        next = startNode;
        if (startNode.getData().isCorrect() != CORRECT) {
            next = nextNode();
        }
 

    }
    
    public boolean hasNext() {
        return next != null;
    }

    public MultipleChoiceQuestion next() {
        return nextNode().getData();
    }

    public LinkedNode<MultipleChoiceQuestion> nextNode() throws NoSuchElementException {
        LinkedNode<MultipleChoiceQuestion> output = next;
        boolean looking = true;
        while(looking) {
            next = super.nextNode();
            if (next.getData().isCorrect() == CORRECT) {
                looking = false;
            }
        }

        return output;

    }
    
}
