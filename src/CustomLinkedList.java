public class CustomLinkedList
{
    private Node head;

    public CustomLinkedList()
    {

    }

    public void addNode(int data)
    {
        Node newNode = new Node(data);

        // Check is head is null
        if (head == null)
        {
            head = newNode;
        }
        else
        {
            // Look for null pointer
            Node currentNode = head;
            while (currentNode.getNext() != null)
            {
                currentNode = currentNode.getNext();
            }
            // We now know that currentNode is pointing to null = end of the list
            currentNode.setNext(newNode);
            newNode.setPrevious(currentNode);
        }
    }

    public void addToHead(int data)
    {
        Node newNode = new Node(data);

        newNode.setNext(head);

        head = newNode;

        head.getNext().setPrevious(head);
    }

    public void addToPos(int pos, int data)
    {
        Node newNode = new Node(data);

        if (pos == 0)
        {
            addToHead(data);
        }
        else
        {
            // Loop through list to find pos
            Node currentNode = head;

            for (int i = 0; i < pos; i ++)
            {
                // Check to see if pos goes beyond end of list
                if (currentNode.getNext() != null)
                {
                    currentNode = currentNode.getNext();

                }
                else
                {

                    break;
                }
            }

            // Set pointers
            newNode.setNext(currentNode);
            newNode.setPrevious(currentNode.getPrevious());
            currentNode.getPrevious().setNext(newNode);
            currentNode.setPrevious(newNode);

        }
    }

    public void changeData(int data, int newData)
    {
        Node currentNode = head;

        while (currentNode.getData() != data && currentNode.getNext() != null)
        {
            currentNode = currentNode.getNext();
        }

            currentNode.setData(newData);

    }

    public String reverseOutput()
    {
        String data = "";

        Node currentNode = head;

        while (currentNode.getNext() != null)
        {
            currentNode = currentNode.getNext();
        }

        while (currentNode != head)
        {
            data = data + currentNode.getData() + ", ";
            currentNode = currentNode.getPrevious();
        }
        data = data + currentNode.getData();
        return data;
    }

    public void delete(int data)
    {
        Node currentNode = head;

        if (currentNode.getData() == data)
        {
            head = currentNode.getNext();
            currentNode.getNext().setPrevious(null);
        }
        else
        {
            while (currentNode.getData() != data && currentNode.getNext() != null)
            {
                currentNode = currentNode.getNext();
            }

            if (currentNode.getNext() == null)
            {
                currentNode.getPrevious().setNext(null);
            }
            else
            {
                currentNode.getPrevious().setNext(currentNode.getNext());
                currentNode.getNext().setPrevious(currentNode.getPrevious());
            }
        }
    }

    public String toString()
    {
        String data = "";
        // Look for null pointer
        Node currentNode = head;
        while (currentNode.getNext() != null)
        {
            data = data + currentNode.getData() + ", ";
            currentNode = currentNode.getNext();
        }
        data = data + currentNode.getData();
        return data;
    }

    private Node getHead()
    {
        return head;
    }

    private void setHead(Node head)
    {
        this.head = head;
    }

}
