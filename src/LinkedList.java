public class LinkedList <T extends Comparable> {
    private Node<T> head;

    //constructor yazmasak da olur.
    public LinkedList(){
        this.head=null;
    }

    public void addToFront(T val){
        Node<T> newNode=new Node<>(val);
        newNode.next=head;
        head=newNode;
    }
    public void addToEnd(T val){
        Node<T> newNode=new Node<>(val);
        if(head==null)
            head=newNode;
        else {
            Node<T> iterator = head;
            while (iterator.next != null) {
                iterator = iterator.next;
            }
            iterator.next = newNode;
        }
    }

    public boolean search(T val){
        Node<T> iterator=head;
        while(iterator!=null){
            if(iterator.value.compareTo(val)==0){
                return true;
            }
            iterator=iterator.next;
        }
        return false;
    }

    public void display(){
        if(head!=null) {
            Node<T> iterator = head;
            while (iterator.next != null) {
                System.out.print(iterator + ", ");
                iterator = iterator.next;
            }
            System.out.println(iterator);
        }
    }
    public void sortedInsert(T val){
        Node<T> newNode=new Node<>(val);
        if (head==null){
            head=newNode;
        }else if(head.value.compareTo(val)==1){
            newNode.next=head;
            head=newNode;
        }else{
            Node<T> prev, iterator;
            prev=iterator=head;
            while(iterator!=null && iterator.value.compareTo(val)!=1 ){
                prev=iterator;
                iterator=iterator.next;
            }
            prev.next=newNode;
            newNode.next=iterator;

        }
    }
    public void delete(T val){
        if(!search(val)){
            return;
        }else if(head.value.compareTo(val)==0){
            head=head.next;
        }else{
            Node<T> prev, iterator;
            prev=iterator=head;
            while(iterator.value.compareTo(val)!=0){
                prev=iterator;
                iterator=iterator.next;
            }
            prev.next=iterator.next;
        }
    }
    public boolean isEmpty(){
        return this.head==null;
    }
    public T findMin() throws Exception {
        if(head==null)
            throw  new Exception("Liste boş");
        else{
            T min=head.value;
            Node<T> iterator=head;
            while(iterator!=null){
                if(iterator.value.compareTo(min)==-1)
                    min=iterator.value;
                iterator=iterator.next;
            }
            return min;
        }
    }

    public int searchWithMemoryAccess(T val){
        Node<T> iterator = head;
        int memoryAccess=0;

        while(iterator!=null){
            //her düğüme erişim bellek erişimi
            memoryAccess++;
            if(iterator.value.compareTo(val)==0){
                return memoryAccess;
            }
            iterator=iterator.next;
        }
        //while sonrası erişim sayısını döndür.
        return memoryAccess;
    }

    public int searchAndAddToFront(T val){
        Node<T> iterator = head;
        int memoryAccess=0;

        if (head == null) {
            return memoryAccess;
        }
        if (head.value.compareTo(val)==0) {
            //eğer değer başta ise yer değiştrimeye gerek yok.
            return memoryAccess;
        }

        Node<T> prev = null;
        while (iterator != null) {
            memoryAccess++;
            if (iterator.value.compareTo(val)==0) {
                if (prev != null) {
                    prev.next = iterator.next;//düğümü listeden çıkar
                    iterator.next = head; // düğümü başa ekleyelim
                    head = iterator;    //baş düğümünü güncelle
                }
                return memoryAccess; // bellek erişim sayısını döndürelim
            }
            prev = iterator;
            iterator = iterator.next;
        }
        return memoryAccess;//eğer değer yoksa döngüden çıkıp bellek erişimini döndür
    }


}
