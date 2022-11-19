import java.util.Iterator;
import java.util.NoSuchElementException;

public class QuizQuestionsIterator implements Iterator<MultipleChoiceQuestion> {

    private LinkedNode<MultipleChoiceQuestion> next;

    QuizQuestionsIterator(LinkedNode<MultipleChoiceQuestion> startNode) {
        next = startNode;
    }

    public boolean hasNext() {
        return next != null;
    }

    public MultipleChoiceQuestion next() throws NoSuchElementException {
        return nextNode().getData();
    }

    protected LinkedNode<MultipleChoiceQuestion> nextNode() throws NoSuchElementException {
        if(!hasNext()) {
            throw new NoSuchElementException("no next element");
        }
        LinkedNode<MultipleChoiceQuestion> output = next;
        next = next.getNext();
        return output;
    }

    
} 
