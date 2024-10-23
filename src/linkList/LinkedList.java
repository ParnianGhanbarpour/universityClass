package linkList;

public class LinkedList {
    private Nod first=null;

    public void addLast(int data) {
        Nod n=new Nod(data);
        if(first==null) {
            first=n;
        }else {
            Nod p=first;
            while(p.next!=null) {
                p=p.next;
            }
            p.next=n;
        }
    }
    public void addFirst(int data) {
        Nod n = new Nod(data);
        if (first == null) {
            first = n;
        } else {
            n.next = first;
            first = n;
        }
    }

    public void remove(int data) {
        Nod p=first;
        Nod q=null;
        while(p!=null && p.data==data) {
            q=p;
            p=p.next;
        }
        if(p==null) return;
        if(p==first){
            first=first.next;
        }
        else{
            q.next=q.next.next;
        }


    }

    public String getAll() {
        String result = "";
        Nod p = first;
        while (p != null) {
            result += p.data;
            if (p.next != null) {
                result += " ";
            }
            p = p.next;
        }
        return result;
    }

}
