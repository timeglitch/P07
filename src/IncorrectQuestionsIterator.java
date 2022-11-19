import java.util.Iterator;
import java.util.NoSuchElementException;

public class IncorrectQuestionsIterator extends QuizQuestionsIterator implements Iterator<MultipleChoiceQuestion>{
    private static final boolean CORRECT = false;

    private LinkedNode<MultipleChoiceQuestion> next;

    IncorrectQuestionsIterator(LinkedNode<MultipleChoiceQuestion> startNode) {
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
        while(hasNext() && next.getData().isCorrect()) {
            next = next.getNext();
        }
        return output;
    }
    
    
}
