struct MinStack {
    min_stack: Vec<i32>,
    nums_stack: Vec<i32>
}


/**
 * `&self` means the method takes an immutable reference.
 * If you need a mutable reference, change it to `&mut self` instead.
 */
impl MinStack {

    fn new() -> Self {
        Self {
            min_stack: vec![],
            nums_stack: vec![]
        }
    }

    fn push(&mut self, val: i32) {
        self.nums_stack.push(val);
        if self.min_stack.len() > 0 {
            if *self.min_stack.last().unwrap() > val {
                self.min_stack.push(val);
            } else {
                self.min_stack.push(self.min_stack.last().unwrap().clone());
            }
        } else {
            self.min_stack.push(val);
        }
    }

    fn pop(&mut self) {
        self.min_stack.pop();
        self.nums_stack.pop();
    }

    fn top(&self) -> i32 {
        *self.nums_stack.last().unwrap()
    }

    fn get_min(&self) -> i32 {
        *self.min_stack.last().unwrap()
    }
}
