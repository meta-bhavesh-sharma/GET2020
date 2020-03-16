Node = function(element) {
    this.data = element;
    this.next = null;
    this.previous = null;
}
DoublyLinkedList = function() {
    this.head = null;
    this.size = 0;
    this.add = function(element) {
        var current;
        var node = new Node(element);
        if (this.head == null) {
            this.head = node;
        } else {
            current = this.head;
            while (current.next) {
                current = current.next;
            }
            current.next = node;
            node.previous = current;
        }
        this.size++;
    }
    this.insert = function(index, element) {
        if (index > this.size) {
            return false;
        } else {
            var node = new Node(element);
            var previous, current, i;
            if (index == 0) {
                node.next = this.head;
                this.head.previous = node;
                this.head = node;
            } else {
                current = this.head;
                for (i = 0; i < index; i++) {
                    previous = current;
                    current = current.next;
                }
                previous.next = node;
                node.next = current;
                current.previous = node;
                node.previous = previous;
            }
            this.size++;
        }
    }
    this.remove = function(element) {
        var current, previous;
        current = this.head;
        previous = null;
        while (current != null) {
            if (current.data === element) {
                if (previous == null) {
                    this.head = current.next;
                } else {
                    previous.next = current.next;
                    current.next.previous = previous;
                }
                this.size--;
                return current.data;
            }
            previous = current;
            current = current.next;
        }
        return -1;
    }
    this.show = function() {
        var current = this.head;
        while (current != null) {
            document.write(current.data + "  ");
            current = current.next;
        }
    }
}
list = new DoublyLinkedList();
list.add(1);
list.add(3);
list.insert(1, 2);
list.show();