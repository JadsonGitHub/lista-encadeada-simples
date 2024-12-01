
// Classe para uma Lista Encadeada Simples de qualquer tipo (LinkedList)
public class Lista <T>
{   // Classe para um nó da lista
    private static class Node <T>
    {
        private final T data;     // Dado armazenado no nó
        private Node <T> next;    // Referência para o próximo nó
        // Construtor para inicializar um no com um dado
        public Node (T data)
        {
            this.data = data;
            this.next = null;
        }
    }
    private Node <T> head;    // Referência para o início da lista
    private int size;    // Tamanho da lista // quantidade de elementos
    // Construtor para inicializar uma lista vazia
    public Lista ()
    {
        this.head = null; // Sem nó
        this.size = 0;    // Tamanho zero
    }
    // Método para verificar se a lista está vazia
    public boolean isEmpty ()
    {
        return head == null; // Início Null, Retorna True 
    }
    // Método para obter o tamanho da lista
    public void printSize ()
    {
        System.out.println("Tamanho: " + size);    // Tamanho da lista
    }
    // Método para adicionar um elemento ao final da lista
    public void add (T element)
    {   // Cria um novo nó com o elemento fornecido
        Node <T> newNode = new Node <> (element);
        // Caso a lista esteja vazia, o novo nó se torna o início
        if (isEmpty())
        {
            head = newNode;
        }
        else
        {   // Vai ate o último nó
            Node <T> current = head;
            while (current.next != null)
            {
                current = current.next;
            }            
            current.next = newNode;  // Adiciona o novo nó ao final
        }
        size ++; // Incrementa o tamanho da lista
    }
    // Método para remover o primeiro elemento
    public boolean remove (T element)
    {   // Verifica se a lista está vazia
        if (isEmpty())
        {
            return false; // Não remove
        }
        // Elemento no primeiro nó
        if (head.data.equals(element))
        {
            head = head.next;  // Move o início para o próximo nó
            size --;           // Decrementa o tamanho da lista
            return true;       // Elemento removido com sucesso
        }
        // Percorre a lista para encontrar o elemento
        Node <T> current = head;
        while (current.next != null && !current.next.data.equals(element))
        {
            current = current.next;
        }  // Verifica se o elemento foi encontrado
        if (current.next != null)
        {
            current.next = current.next.next;  // Remove o nó e aponta para o próximo
            size --;                           // Decrementa o tamanho da lista
            return true;                       // Elemento removido com sucesso
        }
        return false; // Elemento não encontrado na lista
    }
    // Método para exibir todos os elementos da lista
    public void printList ()
    {   // Verifica se a lista está vazia
        if (isEmpty())
        {
            //throw new IllegalStateException ("Lista vazia");
            System.out.println("Lista vazia");
            return;
        }  // Imprime cada elemento
        Node <T> current = head;
        System.out.print("Lista: ");
        while (current != null)
        {
            System.out.print(current.data + " ");   // Exibe o dado do nó atual
            current = current.next;                 // Avança para o próximo nó
        }
        System.out.println();
    }   // Método para testar a Lista
    public static void main(String[] args)
    {   // Cria uma lista de inteiros
        Lista <Integer> lista = new Lista <> ();

        System.out.println();
        System.out.println("** Lista de Inteiros criada **");
        lista.printList();  // Lista atual
        lista.printSize();  // Tamanho atual

        System.out.println();
        System.out.println("** Adicionando elementos **");
        lista.add(00);
        lista.add(10);
        lista.add(20);
        lista.add(30);
        lista.add(40);
        lista.add(50);
        lista.add(60);
        lista.add(70);
        lista.add(80);
        lista.add(90);
        lista.printList();  // Lista atual
        lista.printSize();  // Tamanho atual

        System.out.println();
        System.out.println("** Removendo elemento 20 **");
        lista.remove(20);
        lista.printList();  // Lista atual
        lista.printSize();  // Tamanho atual

        System.out.println();   // Remover elemento que não está na lista
        System.out.println("** Removendo elemento 55 **");
        lista.remove(55);
        lista.printList();  // Lista atual
        lista.printSize();  // Tamanho atual
    }
}