use std::cell::RefCell;
use std::rc::Rc;
use leetcode::leetcode::hash_table::T220::{Solution};
use leetcode::Post::Post;

fn main() {
    let res = Solution::contains_nearby_almost_duplicate(vec![1,5,9,1,5,9], 2, 3);
    println!("{:?}", res);

}