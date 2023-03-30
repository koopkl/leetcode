use std::cell::RefCell;
use std::rc::Rc;
use leetcode::leetcode::linklist::T206::{ListNode, Solution};
use leetcode::Post::Post;

fn main() {
    let mut begin_node = Box::new(ListNode::new(1));
    begin_node.next = Some(Box::new(ListNode::new(2)));
    begin_node.next.as_mut().unwrap().next = Some(Box::new(ListNode::new(3)));
    let res = Solution::reverse_list(Some(begin_node));
    println!("{:?}", res);

}