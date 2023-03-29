use std::cell::RefCell;
use std::rc::Rc;
use leetcode::leetcode::str::T686::Solution;
use leetcode::Post::Post;
fn main() {
    let res = Solution::repeated_string_match("abaababa".to_string(), "abaabaa".to_string());
    println!("{:?}", res);

}