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
    
    @Override
    public boolean hasNext() {
        return next != null;
    }

    @Override
    public MultipleChoiceQuestion next() throws NoSuchElementException {
        return nextNode().getData();
    }

    @Override
    protected LinkedNode<MultipleChoiceQuestion> nextNode() throws NoSuchElementException {
        LinkedNode<MultipleChoiceQuestion> output = next;
        if(!hasNext()) {
            throw new NoSuchElementException("end of the line");   
        }
        boolean looking = true;
        next = next.getNext();
        while(hasNext() && !next.getData().isCorrect()) {
            next = next.getNext();
        }
        return output;
    }
    
}
