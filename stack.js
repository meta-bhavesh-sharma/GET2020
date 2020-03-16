stack = function() {
    this.stack = [];
    this.push = function(element) {
        this.stack.push(element);
    }
    this.pop = function() {
        this.stack.pop();
    }
}
stackElement = new stack();
stackElement.push(12);
stackElement.push(122);
stackElement.push(192);

stackElement.stack;
stackElement.pop();
stackElement.stack;