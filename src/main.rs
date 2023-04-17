use std::cell::RefCell;
use std::rc::Rc;
use leetcode::leetcode::stack::t316::{Solution};
use leetcode::Post::Post;

fn main() {

    let res = Solution::remove_duplicate_letters("babc".to_string());
    println!("{:?}", res);

}