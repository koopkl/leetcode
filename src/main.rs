use std::cell::RefCell;
use std::rc::Rc;
use leetcode::leetcode::array::T303::NumArray;
use leetcode::Post::Post;
fn main() {
   let res = NumArray::new(vec![1,2,3,4]);
    println!("{:?}", res.sum_range(1, 3));
}