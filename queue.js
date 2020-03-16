queue = function() {
    this.queue = [];
    this.enqueue = function(element) {
        this.queue.push(element);
    }
    this.dequeue = function() {
        this.queue.shift();
    }
}
queElement = new queue();
queElement.enqueue(12);
queElement.enqueue(122);
queElement.enqueue(192);

queElement.queue;
queElement.dequeue();
queElement.queue;