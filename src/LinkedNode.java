
public class LinkedNode<T> {

  private T data;
  private LinkedNode<T> next;


  public LinkedNode(T data, LinkedNode<T> next) throws NullPointerException {
    this(data);
    setNext(next);

  }

  public LinkedNode(T data) throws NullPointerException {
    if (data == null) {
      throw new NullPointerException("Error in LinkedNode Constructor (1 param)");

    }
    try {
      this.data = data;
    } catch (NullPointerException e) {
      throw new NullPointerException("Error in LinkedNode Constructor (1 param)");
    }
  }

  public LinkedNode<T> getNext() {
    return next; 
  }

  public void setNext(LinkedNode<T> next) {
    this.next = next;
  }

  public T getData() {
    return data;
  }

  @Override
  public String toString() {
    String response;
    if (next != null) {
      response = data.toString() + "->";// + next.toString();
    } else {
      response = data.toString();
    }
    return response;
  }
}
