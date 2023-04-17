struct MyQueue {
    input: Vec<i32>,
    output: Vec<i32>
}


/**
 * `&self` means the method takes an immutable reference.
 * If you need a mutable reference, change it to `&mut self` instead.
 */
impl MyQueue {

    fn new() -> Self {
        Self {
            input: vec![],
            output: vec![]
        }
    }

    fn push(&mut self, x: i32) {
        self.input.push(x);
    }

    fn pop(&mut self) -> i32 {
        if self.output.len() <= 0 {
            while self.input.len() > 0 {
                self.output.push(self.input.pop().unwrap());
            }
        }
        self.output.pop().unwrap()
    }

    fn peek(&mut self) -> i32 {
        if self.output.len() <= 0 {
            while self.input.len() > 0 {
                self.output.push(self.input.pop().unwrap());
            }
        }
        self.output.last().unwrap().clone()
    }

    fn empty(&self) -> bool {
        self.input.is_empty() && self.output.is_empty()
    }
}