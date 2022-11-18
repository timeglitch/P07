import java.util.Iterator;
import java.util.NoSuchElementException;

public class CorrectQuestionsIterator extends QuizQuestionsIterator{
    private static final boolean CORRECT = true;

    private LinkedNode<MultipleChoiceQuestion> next;

    CorrectQuestionsIterator(LinkedNode<MultipleChoiceQuestion> startNode) {
        super(startNode);
        next = startNode;
        try {
            if (startNode != null && startNode.getData().isCorrect() != CORRECT) {
                nextNode();
            }
        }
        catch (NoSuchElementException e) {
            next = null;
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
        if(!hasNext()) {
            throw new NoSuchElementException("end of the line");
        }
        try {
            boolean looking = true;
            while(looking) {
                next = super.nextNode();
                if (next.getData().isCorrect() == CORRECT) {
                    looking = false;
                }
            }
        }
        catch (NoSuchElementException e) {
            next = null;
        }
        return output;
    }
    
}
