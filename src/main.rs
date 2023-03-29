use std::cell::RefCell;
use std::rc::Rc;
use leetcode::leetcode::str::T686::Solution;
use leetcode::Post::Post;
#[derive(PartialEq, Eq, Clone, Debug)]
pub struct ListNode {
    pub val: i32,
    pub next: Option<Box<ListNode>>
}

impl ListNode {
    #[inline]
    fn new(val: i32) -> Self {
        ListNode {
            next: None,
            val
        }
    }
}

fn main() {
    let mut begin_node = Box::new(ListNode::new(-1));
    let mut list2: Option<Box<ListNode>> = Some(Box::new(ListNode::new(1)));
    let mut temp = begin_node.as_mut();
    temp = temp.next.as_mut().unwrap();
    list2 = temp.next.take();
    let res = Solution::repeated_string_match("abaababa".to_string(), "abaabaa".to_string());
    println!("{:?}", res);

}