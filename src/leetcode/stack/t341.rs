#[derive(Debug, PartialEq, Eq)]
pub enum NestedInteger {
  Int(i32),
  List(Vec<NestedInteger>)
}
struct NestedIterator {
    count: usize,
    nums: Vec<i32>
}


/**
  * `&self` means the method takes an immutable reference
  * If you need a mutable reference, change it to `&mut self` instead.
 */
impl NestedIterator {


    fn new(nestedList: Vec<NestedInteger>) -> Self {
        let count = 0;
        let mut nums = vec![];
        for nest in nestedList {
            match nest {
                NestedInteger::Int(e) => {
                    nums.push(e);
                },
                NestedInteger::List(list) => {
                    let mut temp_iterator = NestedIterator::new(list);
                    while temp_iterator.has_next() {
                        nums.push(temp_iterator.next());
                    }
                }
            }
        }
        Self {
            count,
            nums
        }
    }

    fn next(&mut self) -> i32 {
        self.count += 1;
        self.nums[self.count - 1]
    }

    fn has_next(&self) -> bool {
        self.count < self.nums.len()
    }
}
