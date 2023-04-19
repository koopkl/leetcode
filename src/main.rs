use std::cell::RefCell;
use std::rc::Rc;
use leetcode::leetcode::greedy::t121::{Solution};
use leetcode::Post::Post;

fn main() {

    let res = Solution::max_profit(vec![7,1,2,3,4,5]);
    println!("{:?}", res);

}