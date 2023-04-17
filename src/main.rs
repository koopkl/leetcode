use std::cell::RefCell;
use std::rc::Rc;
use leetcode::leetcode::stack::t150::{Solution};
use leetcode::Post::Post;

fn main() {

    let res = Solution::eval_rpn(vec!["2".to_string(),"1".to_string(),"+".to_string(),"3".to_string(),"*".to_string()]);
    println!("{:?}", res);

}